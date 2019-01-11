import org.lsst.ccs.description.groovy.CCSBuilder;
import org.lsst.ccs.subsystem.focalplane.*;
import org.lsst.ccs.utilities.ccd.*;
import org.lsst.ccs.utilities.image.*;
import org.lsst.ccs.bootstrap.BootstrapResourceUtils;
import org.lsst.ccs.imagenaming.service.ImageNameService
import org.lsst.ccs.subsystem.rafts.*;
import org.lsst.ccs.subsystem.ts8.sim.*;
import org.lsst.ccs.drivers.reb.*;
import org.lsst.ccs.drivers.reb.sim.*;
import org.lsst.ccs.monitor.*;
import org.lsst.ccs.subsystem.rafts.alerts.RaftAlert;
import org.lsst.ccs.daq.utilities.FitsService


CCSBuilder builder = ["focal-plane"]

CCDType type = new ITLCCDType();

FocalPlane focalPlane = new FocalPlane();
focalPlane.addChildGeometry( Raft.createRaft(type), 2, 2);
focalPlane.addChildGeometry( Raft.createRaft(type), 1, 0);

Properties props = BootstrapResourceUtils.getBootstrapSystemProperties()
def runMode = props.getProperty("org.lsst.ccs.run.mode","normal");
System.out.println("Building FocalPlane subsystem in run mode: "+runMode);

taskConfig = ["monitor-update/taskPeriodMillis":1000,"monitor-publish/taskPeriodMillis":10000,
              "agentStatusAggregatorService/patternConfigList":[
              "[pattern:.*,predicate:[agentName:focal-plane]]",
              "[pattern:.*,predicate:[agentName:bot-motorplatform]]",
              "[pattern:.*,predicate:[agentName:ccob-subsystem]]",
              "[pattern:.*,predicate:[agentName:fp-rebps]]"]
             ]

def partition = props.getProperty("org.lsst.ccs.raft.partition","2raft")

builder.
    "main" (FocalPlaneSubsystem, geometry:focalPlane, nodeTags:taskConfig) {

        clientFactory (runMode.equals("simulation") ? ClientFactorySimulation : ClientFactory)

        globalProc (GlobalProc)
        focalPlaneConfig (FocalPlaneConfig)

        imageNameService (ImageNameService, 
            dbURL: props.getProperty("org.lsst.ccs.dbUrl", "jdbc:h2:mem:test;MODE=MYSQL"), 
            source: "MainCamera",
            controller: "CCS", 
            timeZoneId: "America/Los_Angeles",
            offset: java.time.Duration.ZERO
        )

        RebAspicTemperatureLowLimit  (Alarm, description:"Alarm for Aspic low temperature limit", eventParm:RaftAlert.ASPICS_TEMPERATURE_TOO_LOW.ordinal())
        RebAspicTemperatureHighLimit  (Alarm, description:"Alarm for Aspic high temperature limit", eventParm:RaftAlert.ASPICS_TEMPERATURE_TOO_HIGH.ordinal())
        RebBoardTemperatureLowLimit  (Alarm, description:"Alarm for Reb board low temperature limit", eventParm:RaftAlert.REB_BOARD_TEMPERATURE_TOO_LOW.ordinal())
        RebBoardTemperatureHighLimit  (Alarm, description:"Alarm for Reb board high temperature limit", eventParm:RaftAlert.REB_BOARD_TEMPERATURE_TOO_HIGH.ordinal())

    for (Raft raftGeometry : focalPlane.getChildrenList() ) {
        System.out.println("Looping on Raft "+raftGeometry.getName());
            
        for (Reb rebGeometry : raftGeometry.getChildrenList() ) {
            def rebCount = ((10*raftGeometry.getParallelPosition())+raftGeometry.getSerialPosition())*4+rebGeometry.getParallelPosition();
            def reb = raftGeometry.getName()+"/"+rebGeometry.getName();
            System.out.println("Using Reb Id "+rebCount+" "+reb);
            
            
            "$reb" (REBDevice, hdwType:"daq2", id:rebCount, ifcName:partition, ccdMask:7, ccdType:"ITL") {

                //"DAC" (DacControl, raw: true, version: 2)   // Science raft REBs, raw DAC values
                "DAC" (DacControl) // All REBs, physical values

                fitsService (FitsService, 
                   headerFilesList:["fp-primary:primary", "extended", "fp-reb_cond", "fp-test_cond"],
                   replacements:["$reb".toString()+":REB"]
                )

                for (int j = 0; j < 6; j++) {
                    def apc = "ASPIC$j"
                    //"${apc}" (AspicControl, description: "", hwChan: j, gain: 0, rc: 0, clamp: 0, af1: 0, tm: 0)
                    "${apc}" (AspicControl, hwChan: j)
                }

                for (int j = 0; j < 3; j++) {
                    //"Bias$j" (BiasControl, hwChan: j, raw: true)   // All REBs. raw DAC values
                    "Bias$j" (BiasControl, hwChan: j)   // All REBs, physical values
                }

                String title = "${reb} temperatures\\"
                for (int j = 1; j <= 10; j++) {
                    if ( j == 3 || j == 6 ) {                
                        "Temp$j" (Channel, description: "${title}Board temperature $j", units: "\u00b0C",
                                hwChan: j - 1, type: "TEMP", 
                                checkLo:"alarm", limitLo:10.0, dbandLo:5.0, alarmLo:"RebBoardTemperatureLowLimit",
                                checkHi:"alarm", limitHi:45, dbandHi:5.0, alarmHi:"RebBoardTemperatureHighLimit")
                    } else {
                        "Temp$j" (Channel, description: "${title}Board temperature $j", units: "\u00b0C",
                                hwChan: j - 1, type: "TEMP", 
                                checkLo:"flag", limitLo:10.0, dbandLo:5.0,
                                checkHi:"flag", limitHi:45, dbandHi:5.0)                
                    }
                    title = ""
                }

                "AspicU/Temp0" (Channel, description: "ASPIC 0 upper temp", units: "\u00b0C",
                            hwChan: 0, type: "ATEMP", 
                            checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"RebAspicTemperatureLowLimit"*/,
                            checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"RebAspicTemperatureHighLimit"*/)

                "AspicL/Temp0" (Channel, description: "ASPIC 0 lower temp", units: "\u00b0C",
                            hwChan: 1, type: "ATEMP", 
                            checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"RebAspicTemperatureLowLimit"*/,
                            checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"RebAspicTemperatureHighLimit"*/)

                "AspicU/Temp1" (Channel, description: "ASPIC 1 upper temp", units: "\u00b0C",
                            hwChan: 2, type: "ATEMP", 
                            checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"RebAspicTemperatureLowLimit"*/,
                            checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"RebAspicTemperatureHighLimit"*/)

                "AspicL/Temp1" (Channel, description: "ASPIC 1 lower temp", units: "\u00b0C",
                            hwChan: 3, type: "ATEMP", 
                            checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"RebAspicTemperatureLowLimit"*/,
                            checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"RebAspicTemperatureHighLimit"*/)

                "AspicU/Temp2" (Channel, description: "ASPIC 2 upper temp", units: "\u00b0C",
                            hwChan: 4, type: "ATEMP", 
                            checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"RebAspicTemperatureLowLimit"*/,
                            checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"RebAspicTemperatureHighLimit"*/)

                "AspicL/Temp2" (Channel, description: "ASPIC 2 lower temp", units: "\u00b0C",
                            hwChan: 5, type: "ATEMP", 
                            checkLo:"flag", limitLo:10.0, dbandLo:5.0/*, alarmLo:"RebAspicTemperatureLowLimit"*/,
                            checkHi:"flag", limitHi:45, dbandHi:5.0/*, alarmHi:"RebAspicTemperatureHighLimit"*/)


                for (CCD ccdGeometry : rebGeometry.getChildrenList() ) {
                    int js = ccdGeometry.getSerialPosition();
                    def current_name = ccdGeometry.getName()+"/Temp";
                    current_name = current_name.replace("Sen","S");
                    "${current_name}" (Channel, description: "${current_name} temperature", units: "\u00b0C",
                                hwChan: js, type: "RTD")
                }
       

                "RTDTemp" (Channel, description: "RTD temperature", units: "\u00b0C",
                            hwChan: 3, type: "RTD")

                "HtrV"    (Channel, description: "$reb heater\\Heater voltage", units: "Volts",
                            hwChan: REBDevice.CHAN_HTR_VOLTS, type: "HEATER")

                "HtrW"    (Channel, description: "Heater power", units: "Watts",
                            hwChan: REBDevice.CHAN_HTR_POWER, type: "HEATER")

                "DigV"    (Channel, description: "${reb} board power\\Digital PS voltage", units: "Volts",
                            hwChan: 0, type: "POWER")

                "DigI"    (Channel, description: "Digital PS current", format: ".1f", units: "mA",
                            hwChan: 1, type: "POWER", scale: 1000)

                "AnaV"    (Channel, description: "Analog PS voltage", units: "Volts",
                            hwChan: 2, type: "POWER")

                "AnaI"    (Channel, description: "Analog PS current", format: ".1f", units: "mA",
                            hwChan: 3, type: "POWER", scale: 1000)

                "ClkHV"   (Channel, description: "Clock High PS voltage", units: "Volts",
                            hwChan: 4, type: "POWER")

                "ClkHI"   (Channel, description: "Clock High PS current", format: ".1f", units: "mA",
                            hwChan: 5, type: "POWER", scale: 1000)

                "ClkLV"   (Channel, description: "Clock Low PS voltage", units: "Volts",
                            hwChan: 8, type: "POWER")

                "ClkLI"   (Channel, description: "Clock Low PS current", format: ".1f", units: "mA",
                            hwChan: 9, type: "POWER", scale: 1000)

                "ODV"     (Channel, description: "OD PS voltage", units: "Volts",
                            hwChan: 6, type: "POWER")

                "ODI"     (Channel, description: "OD PS current", format: ".1f", units: "mA",
                            hwChan: 7, type: "POWER", scale: 1000)

                "Power"   (Channel, description: "Total power", format: ".2f", units: "Watts",
                            hwChan: REBDevice.CHAN_TOTAL_POWER, type: "POWER")

                "PClkU"   (Channel, description: "${reb} clock rails\\Parallel upper", units: "Volts",
                            hwChan: SlowAdcs.CHAN_CKP_U, type: "BIAS")

                "PClkL"   (Channel, description: "Parallel lower", units: "Volts",
                            hwChan: SlowAdcs.CHAN_CKP_L, type: "BIAS")

                "SClkU"   (Channel, description: "Serial upper", units: "Volts",
                            hwChan: SlowAdcs.CHAN_SCK_U, type: "BIAS")

                "SClkL"   (Channel, description: "Serial lower", units: "Volts",
                            hwChan: SlowAdcs.CHAN_SCK_L, type: "BIAS")

                "RGU"     (Channel, description: "Reset gate upper", units: "Volts",
                            hwChan: SlowAdcs.CHAN_RG_U, type: "BIAS")

                "RGL"     (Channel, description: "Reset gate lower", units: "Volts",
                            hwChan: SlowAdcs.CHAN_RG_L, type: "BIAS")

                "RefP12"  (Channel, description: "Positive 12 ref", units: "Volts",
                            hwChan: SlowAdcs.CHAN_VP12, type: "BIAS")

                "RefN12"  (Channel, description: "Negative 12 ref", units: "Volts",
                            hwChan: SlowAdcs.CHAN_VN12, type: "BIAS")

                for (CCD ccdGeometry : rebGeometry.getChildrenList() ) {
                    def js = ccdGeometry.getSerialPosition();
                    def current_name = ccdGeometry.getName().replace("Sen","S");
                    
                    if ( js == 0  ) {                
                        "${current_name}/ODV"    (Channel, description: "${reb} bias voltages\\OD 0 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OD_0, type: "BIAS")

                        "${current_name}/OGV"    (Channel, description: "OG 0 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OG_0, type: "BIAS")

                        "${current_name}/RDV"    (Channel, description: "RD 0 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_RD_0, type: "BIAS")

                        "${current_name}/GDV"    (Channel, description: "GD 0 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_GD_0, type: "BIAS")

                    } else if ( js == 1 ) {
                        "${current_name}/ODV"    (Channel, description: "OD 1 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OD_1, type: "BIAS")

                        "${current_name}/OGV"    (Channel, description: "OG 1 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OG_1, type: "BIAS")

                        "${current_name}/RDV"    (Channel, description: "RD 1 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_RD_1, type: "BIAS")

                        "${current_name}/GDV"    (Channel, description: "GD 1 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_GD_1, type: "BIAS")
                    } else if ( js == 2 ) {
                        "${current_name}/ODV"    (Channel, description: "OD 2 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OD_2, type: "BIAS")

                        "${current_name}/OGV"    (Channel, description: "OG 2 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_OG_2, type: "BIAS")

                        "${current_name}/RDV"    (Channel, description: "RD 2 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_RD_2, type: "BIAS")

                        "${current_name}/GDV"    (Channel, description: "GD 2 voltage", units: "Volts",
                                    hwChan: SlowAdcs.CHAN_GD_2, type: "BIAS")
                    }
                }


                "Ref05V"  (Channel, description: "5V ref 0 voltage", units: "Volts",
                            hwChan: SlowAdcs.CHAN_VREF5_0, type: "BIAS")

                "Ref15V"  (Channel, description: "5V ref 1 voltage", units: "Volts",
                            hwChan: SlowAdcs.CHAN_VREF5_1, type: "BIAS")

                "Ref25V"  (Channel, description: "5V ref 2 voltage", units: "Volts",
                            hwChan: SlowAdcs.CHAN_VREF5_2, type: "BIAS")

                "Ref125V" (Channel, description: "2.5V ref 1 voltage", units: "Volts",
                            hwChan: SlowAdcs.CHAN_VREF25_1, type: "BIAS")


                title = "${reb} CCD currents\\"
                for (CCD ccdGeometry : rebGeometry.getChildrenList() ) {

                    def js = ccdGeometry.getSerialPosition();
                    for (int jd = 0; jd < 2; jd++) {
                        String tb = jd == 0 ? "upper" : "lower"
                        for (int jc = 0; jc < 8; jc++) {
                            int ch = jc + 8 * jd + 16 * js
                            def current_name = ccdGeometry.getName()+"/I${jd}${jc}";
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
