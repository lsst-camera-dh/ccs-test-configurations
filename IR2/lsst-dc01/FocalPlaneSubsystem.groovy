import org.lsst.ccs.description.groovy.CCSBuilder;
import org.lsst.ccs.subsystem.focalplane.*;
import org.lsst.ccs.utilities.ccd.*;
import org.lsst.ccs.utilities.image.*;
import org.lsst.ccs.bootstrap.BootstrapResourceUtils;
import org.lsst.ccs.imagenaming.service.ImageNameService
import org.lsst.ccs.subsystem.rafts.*;
import org.lsst.ccs.drivers.reb.*;
import org.lsst.ccs.monitor.*;
import org.lsst.ccs.subsystem.focalplane.alerts.FocalPlaneAlertType;
import org.lsst.ccs.subsystem.focalplane.RebTotalPower;

CCSBuilder builder = ["focal-plane"]

Properties buildProperties = buildProperties();

FocalPlane focalPlane = new FocalPlane(buildProperties.getProperty("org.lsst.ccs.subsystem.focal.plane.rafts","[R10:[ccdType:itl],R22:[ccdType:itl]]"));

Properties props = BootstrapResourceUtils.getBootstrapSystemProperties()
def focalPlaneName = props.getProperty("org.lsst.ccs.application.name","focal-plane");

def partition = props.getProperty("org.lsst.ccs.raft.partition","2raft")

builder.
    "main" (FocalPlaneSubsystem, geometry:focalPlane) {

        sequencerConfig (SequencerConfig)
        webHooksConfig(WebHooksConfig)
        instrumentConfig(InstrumentConfig)
        imageCoordinatorService(ImageCoordinatorService)
    
        imageNameService (ImageNameService, 
            dbURL: props.getProperty("org.lsst.ccs.dbUrl", "jdbc:h2:mem:test;MODE=MYSQL"), 
            source: "MainCamera",
            controller: "CCS", 
            timeZoneId: "America/Los_Angeles",
            offset: java.time.Duration.ZERO
        )
        
        imageDatabaseService ( ImageDatabaseService, 
            dbURL: props.getProperty("org.lsst.ccs.dbUrl", "jdbc:h2:mem:test;MODE=MYSQL") 
        )

    for (Raft raftGeometry : focalPlane.getChildrenList() ) {
        System.out.println("Looping on Raft "+raftGeometry.getName());
        
        def boolean isCornerRaft = raftGeometry instanceof CornerRaft;

        def tempControl = raftGeometry.getName()+"/TempControl";        
        rebs = isCornerRaft ? ["RebW"] : ["Reb0","Reb2"]
        tempChans = isCornerRaft ? ["RebW/SW/Temp"] : ["Reb0/S01/Temp", "Reb1/S11/Temp"];
        "$tempControl" (TempControl, raftPath:raftGeometry.getName()+"/", rebs:rebs, tempChans:tempChans)

        int rebPosition = 0;    
        for (Reb rebGeometry : raftGeometry.getRebs() ) {
            def rebCount = ((10*raftGeometry.getParallelPosition())+raftGeometry.getSerialPosition())*4+rebPosition;
            rebPosition++;
            def reb = raftGeometry.getName()+"/"+rebGeometry.getName();
            def boolean isRebW = isCornerRaft ? reb.endsWith("RebW") : false;

            System.out.println("Using Reb Id "+rebCount+" "+reb+" "+rebGeometry.getUniqueId() );
            
            "$reb" (REBDevice, id:rebCount, ifcName:partition, processImages: false) {

                //"DAC" (DacControl, raw: true, version: 2)   // Science raft REBs, raw DAC values
                "DAC" (DacControl) // All REBs, physical values

                def int nBias = isCornerRaft ? (isRebW ? 1 : 2) : 3;
                for (int j = 0; j < nBias; j++) {
                    "Bias$j" (BiasControl, hwChan: j)   // All REBs, physical values
                }


                RebAspicTemperatureLowLimit   (FocalPlaneRebAlarm, alertType:FocalPlaneAlertType.ASPICS_TEMPERATURE_TOO_LOW)
                RebAspicTemperatureHighLimit  (FocalPlaneRebAlarm, alertType:FocalPlaneAlertType.ASPICS_TEMPERATURE_TOO_HIGH)
                RebBoardTemperatureLowLimit   (FocalPlaneRebAlarm, alertType:FocalPlaneAlertType.REB_BOARD_TEMPERATURE_TOO_LOW)
                RebBoardTemperatureHighLimit  (FocalPlaneRebAlarm, alertType:FocalPlaneAlertType.REB_BOARD_TEMPERATURE_TOO_HIGH)

                def int nTemps = isRebW ? 6 : 10;
                String title = "${reb} temperatures\\"
                for (int j = 1; j <= nTemps; j++) {
                    // Per Stuart Marshall. for 2 ETU testing will will set limits on Temps 1 and 2
                    if ( j == 1 || j == 2 ) {                
                        "Temp$j" (Channel, description: "${title}Board temperature $j", units: "\u00b0C",
                                hwChan: j - 1, type: "TEMP", 
                                checkLo:"alarm", limitLo:10.0, dbandLo:5.0, alarmLo:"$reb/RebBoardTemperatureLowLimit",
                                checkHi:"alarm", limitHi:45, dbandHi:5.0, alarmHi:"$reb/RebBoardTemperatureHighLimit")
                    } else {
                        "Temp$j" (Channel, description: "${title}Board temperature $j", units: "\u00b0C",
                                hwChan: j - 1, type: "TEMP", 
                                checkLo:"flag", limitLo:10.0, dbandLo:5.0,
                                checkHi:"flag", limitHi:45, dbandHi:5.0)                
                    }
                    title = ""
                }

                if ( ! isCornerRaft ) {
                    "AspicU/Temp0" (Channel, description: "ASPIC 0 upper temp", units: "\u00b0C",
                            hwChan: 0, type: "ATEMP", 
                            checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"$reb/RebAspicTemperatureLowLimit"*/,
                            checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"$reb/RebAspicTemperatureHighLimit"*/)

                    "AspicL/Temp0" (Channel, description: "ASPIC 0 lower temp", units: "\u00b0C",
                            hwChan: 1, type: "ATEMP", 
                            checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"$reb/RebAspicTemperatureLowLimit"*/,
                            checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"$reb/RebAspicTemperatureHighLimit"*/)

                    "AspicU/Temp1" (Channel, description: "ASPIC 1 upper temp", units: "\u00b0C",
                                hwChan: 2, type: "ATEMP", 
                                checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"$reb/RebAspicTemperatureLowLimit"*/,
                                checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"$reb/RebAspicTemperatureHighLimit"*/)

                    "AspicL/Temp1" (Channel, description: "ASPIC 1 lower temp", units: "\u00b0C",
                                hwChan: 3, type: "ATEMP", 
                                checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"$reb/RebAspicTemperatureLowLimit"*/,
                                checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"$reb/RebAspicTemperatureHighLimit"*/)


                    "AspicU/Temp2" (Channel, description: "ASPIC 2 upper temp", units: "\u00b0C",
                                    hwChan: 4, type: "ATEMP", 
                                    checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"$reb/RebAspicTemperatureLowLimit"*/,
                                    checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"$reb/RebAspicTemperatureHighLimit"*/)

                    "AspicL/Temp2" (Channel, description: "ASPIC 2 lower temp", units: "\u00b0C",
                                    hwChan: 5, type: "ATEMP", 
                                    checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"$reb/RebAspicTemperatureLowLimit"*/,
                                    checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"$reb/RebAspicTemperatureHighLimit"*/)
                }


                "HVBiasSwitch"  (Channel, description: "HV bias switch", format: ".0f",
                            hwChan: 0, type: "HVSWCH")


                if ( isRebW ) {
                    "SW/Temp" (Channel, description: "SW temperature", units: "\u00b0C",
                                hwChan: 0, type: "RTD")
                } else {
                    for (CCD ccdGeometry : rebGeometry.getCCDs() ) {
                        int js = ccdGeometry.getSerialPosition();
                        def current_name = ccdGeometry.getName()+"/Temp";
                        current_name = current_name.replace("Sen","S");
                        "${current_name}" (Channel, description: "${current_name} temperature", units: "\u00b0C",
                                    hwChan: js, type: "RTD")
                    }
                }
       

                "RTDTemp" (Channel, description: "RTD temperature", units: "\u00b0C",
                            hwChan: 3, type: "RTD")

                "HtrV"    (Channel, description: "$reb heater\\Heater voltage", units: "Volts",
                            hwChan: REBDevice.CHAN_HTR_VOLTS, type: "HEATER")

                "HtrW"    (Channel, description: "Heater power", units: "Watts",
                            hwChan: REBDevice.CHAN_HTR_POWER, type: "HEATER")

                "DigV"    (Channel, description: "${reb} board power\\Digital PS voltage", units: "Volts",
                            hwChan: PowerAdcs.ADC_DIG_VOLTAGE, type: "POWER")

                "DigI"    (Channel, description: "Digital PS current", format: ".1f", units: "mA",
                            hwChan: PowerAdcs.ADC_DIG_CURRENT, type: "POWER", scale: 1000)

                "AnaV"    (Channel, description: "Analog PS voltage", units: "Volts",
                            hwChan: PowerAdcs.ADC_ANA_VOLTAGE, type: "POWER")

                "AnaI"    (Channel, description: "Analog PS current", format: ".1f", units: "mA",
                            hwChan: PowerAdcs.ADC_ANA_CURRENT, type: "POWER", scale: 1000)

                "ClkHV"   (Channel, description: "Clock High PS voltage", units: "Volts",
                            hwChan: PowerAdcs.ADC_CLKH_VOLTAGE, type: "POWER")

                "ClkHI"   (Channel, description: "Clock High PS current", format: ".1f", units: "mA",
                            hwChan: PowerAdcs.ADC_CLKH_CURRENT, type: "POWER", scale: 1000)

                if ( isCornerRaft ) {
                    "ClkLV"   (Channel, description: "Clock Low PS voltage", units: "Volts",
                                hwChan: SlowAdcs.CHAN_V_CLKL, type: "CRVOLT")

                } else {
                    "ClkLV"   (Channel, description: "Clock Low PS voltage", units: "Volts",
                                hwChan: PowerAdcs.ADC_CLKL_VOLTAGE, type: "POWER")

                    "ClkLI"   (Channel, description: "Clock Low PS current", format: ".1f", units: "mA",
                                hwChan: PowerAdcs.ADC_CLKL_CURRENT, type: "POWER", scale: 1000)
                }

                "ODV"     (Channel, description: "OD PS voltage", units: "Volts",
                            hwChan: PowerAdcs.ADC_OD_VOLTAGE, type: "POWER")

                "ODI"     (Channel, description: "OD PS current", format: ".1f", units: "mA",
                            hwChan: PowerAdcs.ADC_OD_CURRENT, type: "POWER", scale: 1000)

                if ( isCornerRaft ) {
                    "HtrPV"   (Channel, description: "$reb heater\\Heater PS voltage", units: "Volts",
                               hwChan: PowerAdcs.ADC_HTR_VOLTAGE, type: "POWER")

                    "HtrPI"   (Channel, description: "$reb heater\\Heater PS current", format: ".1f", units: "mA",
                               hwChan: PowerAdcs.ADC_HTR_CURRENT, type: "POWER", scale: 1000)
                }

                "Power"   (Channel, description: "Total power", format: ".2f", units: "Watts",
                            hwChan: REBDevice.CHAN_TOTAL_POWER, type: "POWER")

                def String chanType = isCornerRaft ? "CRVOLT" : "BIAS";

                "PClkU"   (Channel, description: "${reb} clock rails\\Parallel upper", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_CKP_U, type: "$chanType")

                "PClkL"   (Channel, description: "${reb} clock rails\\Parallel lower", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_CKP_L, type: "$chanType")

                "SClkU"   (Channel, description: "Serial upper", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_SCK_U, type: "$chanType")

                "SClkL"   (Channel, description: "Serial lower", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_SCK_L, type: "$chanType")

                "RGU"     (Channel, description: "Reset gate upper", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_RG_U, type: "$chanType")

                "RGL"     (Channel, description: "Reset gate lower", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_RG_L, type: "$chanType")

                if ( isCornerRaft ) {
                    "PClk0"  (Channel, description: "Clock states\\Parallel 0", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_CKP_0, type: "CRVOLT")

                    "SClk0"  (Channel, description: "Serial 0", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_CKS_0, type: "CRVOLT")

                    "RG0"    (Channel, description: "RG 0", format: ".2f", units: "Volts",
                            hwChan: SlowAdcs.CHAN_RG_0, type: "CRVOLT")

                    if ( ! isRebW ) {
                        "PClk1"   (Channel, description: "Parallel 1", format: ".2f", units: "Volts",
                                hwChan: SlowAdcs.CHAN_CKP_1, type: "CRVOLT")
                                
                        "SClk1"   (Channel, description: "Serial 1", format: ".2f", units: "Volts",
                                hwChan: SlowAdcs.CHAN_CKS_1, type: "CRVOLT")

                        "RG1"     (Channel, description: "RG 1", format: ".2f", units: "Volts",
                                hwChan: SlowAdcs.CHAN_RG_1, type: "CRVOLT")
                    }
                }

                if ( ! isCornerRaft ) {
                    "RefP12"  (Channel, description: "Positive 12 ref", units: "Volts",
                                hwChan: SlowAdcs.CHAN_VP12, type: "BIAS")

                    "RefN12"  (Channel, description: "Negative 12 ref", units: "Volts",
                                hwChan: SlowAdcs.CHAN_VN12, type: "BIAS")
                }

                for (CCD ccdGeometry : rebGeometry.getCCDs() ) {
                    def js = ccdGeometry.getSerialPosition();
                    def current_name = ccdGeometry.getName().replace("Sen","S");
                    if ( isRebW ) {
                        current_name = "SW";
                    }

                    if (current_name == "SG0") {
                        js = 0;
                    }
                    if (current_name == "SG1") {
                        js = 1;
                    }

                    if ( js == 0  ) {                
                        "${current_name}/ODV"    (Channel, description: "${reb} bias voltages\\OD 0 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OD_0, type: "$chanType")

                        "${current_name}/OGV"    (Channel, description: "OG 0 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OG_0, type: "$chanType")

                        "${current_name}/RDV"    (Channel, description: "RD 0 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_RD_0, type: "$chanType")

                        "${current_name}/GDV"    (Channel, description: "GD 0 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_GD_0, type: "$chanType")

                        if ( isCornerRaft ) {
                         "${current_name}/ODI"    (Channel, description: "OD 0 current", format: ".2f", units: "mA",
                                        hwChan: SlowAdcs.CHAN_ODI_0, type: "$chanType", scale: 1000)
                        }
                    } else if ( js == 1 ) {
                        "${current_name}/ODV"    (Channel, description: "OD 1 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OD_1, type: "$chanType")

                        "${current_name}/OGV"    (Channel, description: "OG 1 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OG_1, type: "$chanType")

                        "${current_name}/RDV"    (Channel, description: "RD 1 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_RD_1, type: "$chanType")

                        "${current_name}/GDV"    (Channel, description: "GD 1 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_GD_1, type: "$chanType")

                        if ( isCornerRaft ) {
                            "${current_name}/ODI"    (Channel, description: "OD 1 current", format: ".2f", units: "mA",
                                        hwChan: SlowAdcs.CHAN_ODI_1, type: "$chanType", scale: 1000)
                        }
                    } else if ( js == 2 ) {
                        "${current_name}/ODV"    (Channel, description: "OD 2 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OD_2, type: "$chanType")

                        "${current_name}/OGV"    (Channel, description: "OG 2 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OG_2, type: "$chanType")

                        "${current_name}/RDV"    (Channel, description: "RD 2 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_RD_2, type: "BIAS")

                        "${current_name}/GDV"    (Channel, description: "GD 2 voltage", format: ".2f", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_GD_2, type: "$chanType")
                    }
                    if ( isRebW ) {
                        break;
                    }

                }

                def int nAspic = isCornerRaft ? (isRebW ? 1 : 2) : 2;
                for (CCD ccdGeometry : rebGeometry.getCCDs() ) {
                    def js = ccdGeometry.getSerialPosition();

                    for (int j = 0; j < nAspic; j++) {
                        def apc = ccdGeometry.getName()+"/ASPIC$j"
                        def int channel = nAspic*js + j;
                        "${apc}" (AspicControl, hwChan: channel)
                    }
                }

                if ( ! isCornerRaft ) {
                    "Ref05V"  (Channel, description: "5V ref 0 voltage", units: "Volts",
                                hwChan: SlowAdcs.CHAN_VREF5_0, type: "BIAS")

                    "Ref15V"  (Channel, description: "5V ref 1 voltage", units: "Volts",
                                hwChan: SlowAdcs.CHAN_VREF5_1, type: "BIAS")

                    "Ref25V"  (Channel, description: "5V ref 2 voltage", units: "Volts",
                                hwChan: SlowAdcs.CHAN_VREF5_2, type: "BIAS")

                    "Ref125V" (Channel, description: "2.5V ref 1 voltage", units: "Volts",
                                hwChan: SlowAdcs.CHAN_VREF25_1, type: "BIAS")


                    title = "${reb} CCD currents\\"
                    for (CCD ccdGeometry : rebGeometry.getCCDs() ) {
                        def js = ccdGeometry.getSerialPosition();
                        for (int jd = 0; jd < 2; jd++) {
                            String tb = jd == 0 ? "upper" : "lower"
                            int jb = 1 - jd // Fix for LSSTCCSRAFTS-389
                            for (int jc = 0; jc < 8; jc++) {
                                int ch = jc + 8 * jd + 16 * js
                                def current_name = ccdGeometry.getName()+"/Seg${jb}${jc}/I";
                                current_name = current_name.replace("Sen","S");
                                "${current_name}" (Channel, description: "${title}"+ccdGeometry.getName().replace("Sen","S")+" ${tb} current ${jc}", format: ".3f", units: "mA",
                                    hwChan: ch, type: "CURR", scale: 1000)
                                title = ""
                            }
                        }
                    }
                }
            }
        }             
    }

    "RebTotalPower" (RebTotalPower, description:"Reb Total Power", units:"Watts")
}
