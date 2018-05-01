import org.lsst.ccs.description.groovy.CCSBuilder;
import org.lsst.ccs.subsystem.teststand.data.*;
import org.lsst.ccs.subsystem.teststand.*;
import org.lsst.ccs.subsystem.teststand.alerts.TS7Alerts;
import org.lsst.ccs.bootstrap.BootstrapResourceUtils;

import org.lsst.ccs.monitor.Alarm;
import org.lsst.ccs.monitor.Line;
import org.lsst.ccs.monitor.Channel;

CCSBuilder builder = ["ts7-2"]

Properties props = BootstrapResourceUtils.getBootstrapSystemProperties()
def runMode = props.getProperty("org.lsst.ccs.run.mode","normal");

Class cryoClass = Class.forName("org.lsst.ccs.subsystem.teststand.CryoCon24c" + (runMode.equals("simulation") ? "Sim" : "") + "Device");
Class pduClass = Class.forName("org.lsst.ccs.subsystem.teststand.APC7900" + (runMode.equals("simulation") ? "Sim" : "") + "Device");
Class upsClass = Class.forName("org.lsst.ccs.subsystem.teststand.AP9630UPS" + (runMode.equals("simulation") ? "Sim" : "") + "Device");
Class turboClass = Class.forName("org.lsst.ccs.subsystem.teststand.TwisTorr84" + "Device");

builder.main (TS7, rebPsSubsystem:"cr-rebps",
                    coldPlate1:ref("ColdPlate-a"), coldPlate2:ref("ColdPlate-b"),
                    cryoPlate:ref("CryoPlate"), pressureDevice:ref("vqmpressure") ) {

    Cryo   (cryoClass, host:"192.168.2.5", maxSetPoints:[35, 35, 35, 35] as double[],
            channelTypes:["A":"PTC100", "B":"PTC100", "C":"NONE", "D":"PTC100"],
            channelUnits:["A":"C", "B":"C", "C":"C", "D":"C"], 
            p_gainLoop1:12.0, i_gainLoop1:440.0, d_gainLoop1:63.0, 
            p_gainLoop2:2.5, i_gainLoop2:220.0, d_gainLoop2:31.0)
    
    TS7AlertHandler (TS7AlertHandler)

    Turbo  (turboClass, devcId:"", lowSpeedMode:false, waterCooling:false,
            ventValveByCmnd:true, interlockType:true, softStartMode:true,
            activeStopMode:true)

    VQMonitor (GPVacMon835Device, serialdev:"/dev/serial/by-id/usb-Brooks_Automation_Inc._Granville-Phillips_VQM_835_835A0515-if00")

    PDU15 (pduClass, node:"192.168.2.2")

    PDU20 (pduClass, node:"192.168.2.3")

    UPS (upsClass, node:"192.168.0.2")

    AlarmCryoHighTempLimit  (Alarm, description:"Cryo Plate high temperature alarm", eventParm:TS7Alerts.CRYO_PLATE_TEMPERATURE_TOO_HIGH.ordinal())

    AlarmCryoLowTempLimit   (Alarm, description:"Cryo Plate low temperature alarm", eventParm:TS7Alerts.CRYO_PLATE_TEMPERATURE_TOO_LOW.ordinal())
    
    AlarmColdHighTempLimit  (Alarm, description:"Cold Plate high temperature alarm", eventParm:TS7Alerts.COLD_PLATE_TEMPERATURE_TOO_HIGH.ordinal())

    AlarmColdLowTempLimit   (Alarm, description:"Cold Plate low temperature alarm", eventParm:TS7Alerts.COLD_PLATE_TEMPERATURE_TOO_LOW.ordinal())

    AlarmPressureHighLimit  (Alarm, description:"Pressure too high alarm", eventParm:TS7Alerts.PRESSURE_TOO_HIGH.ordinal())

    AlarmPressureLowLimit   (Alarm, description:"Pressure too low alarm", eventParm:TS7Alerts.PRESSURE_TOO_LOW.ordinal())

    AlarmTurboStatusFail    (Alarm, description:"Turbo Pump Status = Fail", eventParm:TS7Alerts.TURBO_PUMP_FAIL.ordinal())

    AlarmTurboTempHighLimit (Alarm, description:"Turbo Pump Temp too high", eventParm:TS7Alerts.TURBO_PUMP_OVERTEMP.ordinal())

    AlarmGeneric  (Alarm, description:"Generic alarm", eventParm:TS7Alerts.GENERIC.ordinal())

     /*
         Its name, used to identify it in databases, plots, etc.
    Its longer, more descriptive, name.
    The units the value is expressed in, e.g. "Volts".
    The device used for obtaining its value.
    The hardware channel number on the device.
    The channel type, e.g. temperature, pressure, etc, which is needed by some devices.
    The subtype, which supplies hardware configuration information.
    The offset and scale values needed for converting a raw hardware value to a physical one.
    Parameters used for checking the value against a limit.  There is one set for the low limit and one for the high one:
        The checking option: NONE, FLAG or ALARM
        The limit value.
        The alarm to be activated upon status transitions when ALARM is specified.
        The deadband value which delays a potential alarm action during a transition back to good status.
    Its id, which is its index in the list of all channels.

The limit values are maintained by the configuration system and can be changed while running.  Any such change causes a status messa\
ge to be broadcast, which can be used to update the trending database or to update any console displays.
*/
    "ColdPlate-a"  (Channel, description:"Cryogenics temperature A", units:"\u00b0C",
             devcName:"Cryo", hwChan:CryoCon24cDevice.CHAN_TEMP_A,
             checkLo:"alarm", limitLo:-135, dbandLo:35.0, alarmLo:"AlarmColdLowTempLimit",
             checkHi:"alarm", limitHi:30, dbandHi:35.0, alarmHi:"AlarmColdHighTempLimit")

    "ColdPlate-b"  (Channel, description:"Cryogenics temperature B", units:"\u00b0C",
             devcName:"Cryo", hwChan:CryoCon24cDevice.CHAN_TEMP_B,
             limitLo:-135.0, dbandLo:35.0, checkLo:"alarm", alarmLo:"AlarmColdLowTempLimit",
             checkHi:"alarm", limitHi:30.0, dbandHi:35.0, alarmHi:"AlarmColdHighTempLimit")
             

    CryoPlate  (Channel, description:"Cryogenics temperature D", units:"\u00b0C",
             devcName:"Cryo", hwChan:CryoCon24cDevice.CHAN_TEMP_D,
             limitLo:-135.0, dbandLo:35.0, checkLo:"alarm", alarmLo:"AlarmCryoLowTempLimit",
             checkHi:"alarm", limitHi:30.0, dbandHi:35.0, alarmHi:"AlarmCryoHighTempLimit")

    htrread1  (Channel, description:"Cryogenics heater loop 1 % power", units:"%",
               devcName:"Cryo", hwChan:CryoCon24cDevice.CHAN_HTR_1, limitLo:0.0, limitHi:100.0)

    htrread2  (Channel, description:"Cryogenics heater loop 2 % power", units:"%",
               devcName:"Cryo", hwChan:CryoCon24cDevice.CHAN_HTR_2, limitLo:0.0, limitHi:100.0)

    tempChng  (Channel, description:"Temperature change rate", units:"\u00b0C/min",
               devcName:"Cryo", hwChan:CryoCon24cDevice.CHAN_TEMP_CHNG,
               checkLo:"alarm", limitLo:-10.0, alarmLo:"AlarmGeneric",
               checkHi:"alarm", limitHi:10.0, alarmHi:"AlarmGeneric")

    SetPnt1  (Channel, description:"setPoint Loop 1", units:"",
              devcName:"Cryo", hwChan:CryoCon24cDevice.CHAN_SETPOINT_1,
              limitLo:-135.0, checkHi:"alarm", limitHi:27.0, alarmHi:"AlarmGeneric")

    SetPnt2  (Channel, description:"setPoint Loop 2", units:"",
              devcName:"Cryo", hwChan:CryoCon24cDevice.CHAN_SETPOINT_2,
              limitLo:-135.0, checkHi:"alarm", limitHi:27.0, alarmHi:"AlarmGeneric")

    vqmpressure  (Channel, description:"VQM Pressure Reading", units:"Torr", format:".3G",
                  devcName:"VQMonitor", hwChan:0,
                limitLo:750.0, dbandLo:5.0, checkLo:"alarm", alarmLo:"AlarmPressureLowLimit",
                checkHi:"alarm", limitHi:810.0, dbandHi:20.0, alarmHi:"AlarmPressureHighLimit")

    PDU15Current  (Channel, description:"PDU15 current", units:"Amps",
                   devcName:"PDU15", hwChan:APC7900Device.CHAN_CURRENT, type:"POWER",
                   limitHi:12.0)

    PDU15Power    (Channel, description:"PDU15 power", units:"Watts",
                   devcName:"PDU15", hwChan:APC7900Device.CHAN_POWER, type:"POWER",
                   limitHi:1320.0)

    VQMState      (Channel, description:"VQM controller state", format:".0f",
                   devcName:"PDU15", hwChan:0, type:"OUTLET", subtype:TS7Outlets.VQMCONTROLLER.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    CryoConState  (Channel, description:"CryoCon 24C state", format:".0f",
                   devcName:"PDU15", hwChan:0, type:"OUTLET", subtype:TS7Outlets.CRYOCON.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    REBPsState    (Channel, description:"REB power supply state", format:".0f",
                   devcName:"PDU15", hwChan:0, type:"OUTLET", subtype:TS7Outlets.REB48VOLTPOWERSUPPLY.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    OTMPsState    (Channel, description:"OTM power supply state", format:".0f",
                   devcName:"PDU15", hwChan:0, type:"OUTLET", subtype:TS7Outlets.OTMPOWERSUPPLY.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    RoughPumpState (Channel, description:"ROUGH-PUMP state", format:".0f",
                   devcName:"PDU15", hwChan:0, type:"OUTLET", subtype:TS7Outlets.ROUGHINGPUMP.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    TurboPumpState (Channel, description:"TURBO-PUMP state", format:".0f",
                   devcName:"PDU15", hwChan:0, type:"OUTLET", subtype:TS7Outlets.TURBOPUMP.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    NetSwitchState (Channel, description:"Network switch state", format:".0f",
                   devcName:"PDU15", hwChan:0, type:"OUTLET", subtype:"NET-SWITCH (ON)",
                   limitLo:0.9, limitHi:1.1)

    PDU15_8State  (Channel, description:"VATValve state", format:".0f",
                   devcName:"PDU15", hwChan:0, type:"OUTLET", subtype:TS7Outlets.VACUUMVALVE.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    PDU20Current  (Channel, description:"PDU20 current", units:"Amps",
                   devcName:"PDU20", hwChan:APC7900Device.CHAN_CURRENT, type:"POWER",
                   limitHi:16.0)

    PDU20Power    (Channel, description:"PDU20 power", units:"Watts",
                   devcName:"PDU20", hwChan:APC7900Device.CHAN_POWER, type:"POWER",
                   limitHi:1760.0)

    NF_55_1State  (Channel, description:"NF-55-1 state", format:".0f",
                   devcName:"PDU20", hwChan:0, type:"OUTLET", subtype:TS7Outlets.COLDPLATEREFRIGERATOR_1.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    NF_55_2State  (Channel, description:"NF-55-2 state", format:".0f",
                   devcName:"PDU20", hwChan:0, type:"OUTLET", subtype:TS7Outlets.COLDPLATEREFRIGERATOR_2.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    PT_30State    (Channel, description:"PT-30 state", format:".0f",
                   devcName:"PDU20", hwChan:0, type:"OUTLET", subtype:TS7Outlets.CRYOPLATEREFRIGERATOR.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    VATvalveState  (Channel, description:"XED-Power state", format:".0f",
                   devcName:"PDU20", hwChan:0, type:"OUTLET", subtype:TS7Outlets.XEDPOWER.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    PDU20_5State  (Channel, description:"XED-Control state", format:".0f",
                   devcName:"PDU20", hwChan:0, type:"OUTLET", subtype:TS7Outlets.XEDCONTROL.getOutletName(),
                   limitLo:0.9, limitHi:1.1)

    PDU20_6State  (Channel, description:"Outlet 6 state", format:".0f",
                   devcName:"PDU20", hwChan:0, type:"OUTLET", subtype:"ALWAYS-6 ON",
                   limitLo:0.9, limitHi:1.1)

    PDU20_7State  (Channel, description:"Outlet 7 state", format:".0f",
                   devcName:"PDU20", hwChan:0, type:"OUTLET", subtype:"ALWAYS-7 ON",
                   limitLo:0.9, limitHi:1.1)

    PDU20_8State  (Channel, description:"ESD-Control state", format:".0f",
                   devcName:"PDU20", hwChan:0, type:"OUTLET", subtype:"ESD-ON",
                   limitLo:0.9, limitHi:1.1)

    TurboCurrent      (Channel, description:"TurboPump current", units:"mA dc",
                       devcName:"Turbo", type:"Numeric", subtype:"CURRENT",
                       checkLo:"none", checkHi:"none", format:"%.0f")

    TurboVoltage      (Channel, description:"TurboPump voltage", units:"V dc",
                       devcName:"Turbo", type:"Numeric", subtype:"VOLTAGE",
                       checkLo:"none", checkHi:"none", format:"%.0f")

    TurboPower        (Channel, description:"TurboPump power", units:"W",
                       devcName:"Turbo", type:"Numeric", subtype:"POWER",
                       checkLo:"none", checkHi:"none", format:"%.0f")

    TurboDriveFreq    (Channel, description:"TurboPump drive freq.", units:"Hz",
                       devcName:"Turbo", type:"Numeric", subtype:"DRIVEFREQ",
                       checkLo:"none", checkHi:"none", format:"%.0f")

    TurboPumpTemp     (Channel, description:"TurboPump pump temperature", 
                       units:"deg C", devcName:"Turbo", 
                       type:"Numeric", subtype:"PUMP_TEMP", format:"%.0f",
                       limitLo:0.0, checkLo:"flag", dbandLo:5.0, 
                       limitHi:50.0, checkHi:"alarm", dbandHi:10.0, 
                       alarmHi:"AlarmTurboTempHighLimit")

    TurboContTempSink (Channel, description:"TurboPump controller sink temp.", 
                       units:"deg C", devcName:"Turbo", 
                       type:"Numeric", subtype:"CONT_TEMP_SINK",
                       checkLo:"none", checkHi:"none", format:"%.0f")

    TurboContTempAir  (Channel, description:"TurboPump controller air temp.", 
                       units:"deg C", devcName:"Turbo", 
                       type:"Numeric", subtype:"CONT_TEMP_AIR",
                       checkLo:"none", checkHi:"none", format:"%.0f")

    TurboRPM          (Channel, description:"TurboPump speed", units:"RPM",
                       devcName:"Turbo", type:"Numeric", subtype:"RPM",
                       checkLo:"none", checkHi:"none", format:"%.0f")

    TurboStatus       (Channel, description:"TurboPump status: 5=normal, 6=fail", 
                       devcName:"Turbo", type:"Numeric", subtype:"STATUS", 
                       format:"%.0f",
                       limitLo:-0.5, checkLo:"flag", dbandLo:5.0, limitHi:5.5,
                       checkHi:"alarm", alarmHi:"AlarmTurboStatusFail")

    UPS_Status    (Channel, description:"UPS status", format:".0f",
                   devcName:"UPS", hwChan:AP9630UPSDevice.CHAN_STATUS)
               
    UPS_Current   (Channel, description:"UPS output current", units:"Amps", format:".2f",
                   devcName:"UPS", hwChan:AP9630UPSDevice.CHAN_OUT_CURRENT)
               
    UPS_Charge    (Channel, description:"UPS battery charge", units:"%", format:".2f",
                   devcName:"UPS", hwChan:AP9630UPSDevice.CHAN_BATT_CHARGE)
               
    UPS_RemTime   (Channel, description:"UPS remaining time", units:"secs", format:".0f",
                   devcName:"UPS", hwChan:AP9630UPSDevice.CHAN_REM_TIME)
               
    ThermalConfiguration(ThermalConfiguration, coldSetPoint: Double.NaN, cryoSetPoint: Double.NaN, 
        coldMonitoringLimitAlgorithm: 'NONE', cryoMonitoringLimitAlgorithm: 'NONE',
        coldMonitoringLimitAlgorithmParameters: [],   cryoMonitoringLimitAlgorithmParameters: [])
    
    VacuumConfiguration(VacuumConfiguration, pressureSetPoint: Double.NaN, 
        pressureMonitoringLimitAlgorithm: 'NONE', pressureMonitoringLimitAlgorithmParameters: [], 
        pressureMonitoringTransitionAlgorithm: 'NONE', pressureMonitoringTransitionAlgorithmParameters: [])  

}

