import org.lsst.ccs.description.groovy.CCSBuilder;
import org.lsst.ccs.subsystem.teststand.data.TSConfig;
import org.lsst.ccs.subsystem.teststand.TS8Bench;
import org.lsst.ccs.subsystem.teststand.KeithleyDevice;
import org.lsst.ccs.subsystem.teststand.KeithleySimDevice;
import org.lsst.ccs.subsystem.teststand.KeysightDevice;
import org.lsst.ccs.subsystem.teststand.Cornerstone260Device;
import org.lsst.ccs.subsystem.teststand.Cornerstone260SimDevice;
import org.lsst.ccs.subsystem.teststand.NewportLampDevice;
import org.lsst.ccs.subsystem.teststand.NewportLampSimDevice;
import org.lsst.ccs.subsystem.teststand.ThorlabsFWDevice;
import org.lsst.ccs.subsystem.teststand.ThorlabsSC10Device;
import org.lsst.ccs.subsystem.teststand.UniblitzShutter;
import org.lsst.ccs.bootstrap.BootstrapResourceUtils;

import org.lsst.ccs.monitor.Alarm;
import org.lsst.ccs.monitor.Line;
import org.lsst.ccs.monitor.Channel;

CCSBuilder builder = ["ts8-bench"]

Properties props = BootstrapResourceUtils.getBootstrapSystemProperties()
def runMode = props.getProperty("org.lsst.ccs.run.mode","normal");

Class keysightClass = Class.forName("org.lsst.ccs.subsystem.teststand.Keysight" + (runMode.equals("simulation") ? "Sim" : "") + "Device");
Class keithleyClass = Class.forName("org.lsst.ccs.subsystem.teststand.Keithley" + (runMode.equals("simulation") ? "Sim" : "") + "Device");
Class monochromatorClass = Class.forName("org.lsst.ccs.subsystem.teststand.Cornerstone260" + (runMode.equals("simulation") ? "Sim" : "") + "Device");
Class lamClass = Class.forName("org.lsst.ccs.subsystem.teststand.NewportLamp" + (runMode.equals("simulation") ? "Sim" : "") + "Device");
Class thorlabsFWClass = Class.forName("org.lsst.ccs.subsystem.teststand.ThorlabsFWDevice");
Class thorlabsSC10Class = Class.forName("org.lsst.ccs.subsystem.teststand.ThorlabsSC10Device");
Class uniblitzShutterClass = Class.forName("org.lsst.ccs.subsystem.teststand.UniblitzShutter");

builder.
    main (TS8Bench) {

    Lamp  (lamClass, host:"/dev/serial/by-id/usb-FTDI_FT232R_USB_UART_A104RVHX-if00-port0", port:9600) {       
        lamppower  (Channel, description:"Lamp Power", units:"W",devcName:"Lamp", hwChan:0, type:"Watts")
        lampcurrent  (Channel, description:"Lamp Current", units:"A",devcName:"Lamp", hwChan:1, type:"Amps")
    }    
    
    Monitor  (keithleyClass)
    {
/*
        mon_voltage  (Channel,
            description:"photodiode supply voltage", units:"V",
            devcName:"Monitor", hwChan:KeithleyDevice.CHAN_VOLTAGE, offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)
*/        
        mon_current  (Channel,
            description:"photodiode supply current", units:"I",
            devcName:"Monitor", hwChan:KeithleyDevice.CHAN_CURRENT, offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)
    }
 
    Monitor2  (keysightClass)
    /*
    {
        mon_voltage  (Channel,
            description:"photodiode supply voltage", units:"V",
            devcName:"Monitor2", hwChan:KeithleyDevice.CHAN_VOLTAGE, offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)
        
        mon_current  (Channel,
            description:"photodiode supply current", units:"I",
            devcName:"Monitor2", hwChan:KeithleyDevice.CHAN_CURRENT, offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)
    }
            */

    Calibration  (keithleyClass)
     /*
    {
        cal_voltage  (Channel,
            description:"photodiode supply voltage", units:"V",
            devcName:"Calibration", hwChan:KeithleyDevice.CHAN_VOLTAGE, offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)
        
        cal_current  (Channel,
            description:"Calibration supply current", units:"I",
            devcName:"Calibration", hwChan:KeithleyDevice.CHAN_CURRENT, offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)        
    }
            */

    Monochromator (monochromatorClass)

    {
     /*
 monochromatordefaultwavelength  (Channel,
            description:"Wavelength", units:"A",
            devcName:"Monochromator", hwChan:-1, type:"UNKNOWN", subtype:"A", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)
*/
        monochromatorwavelength  (Channel,
            description:"Wavelength", units:"A",
            devcName:"Monochromator", hwChan:0, type:"UNKNOWN", subtype:"A", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)

        monochromatorslit1  (Channel,
            description:"slit 1 width", units:"nm",
            devcName:"Monochromator", hwChan:3, type:"UNKNOWN", subtype:"nm", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)

        monochromatorslit2  (Channel,
            description:"slit 2 width", units:"nm",
            devcName:"Monochromator", hwChan:4, type:"UNKNOWN", subtype:"nm", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)

        monochromgrating  (Channel,
            description:"Grating Position", units:"1",
            devcName:"Monochromator", hwChan:5, type:"UNKNOWN", subtype:"1", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)

        monochromstep  (Channel,
            description:"Grating Steps", units:"1",
            devcName:"Monochromator", hwChan:7, type:"UNKNOWN", subtype:"1", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)

        monochromband  (Channel,
            description:"bandwidth", units:"1",
            devcName:"Monochromator", hwChan:6, type:"UNKNOWN", subtype:"1", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)
/*
        shutteropen  (Channel,
            description:"Shutter Open/Closed", units:"S",
            devcName:"Monochromator", hwChan:1, type:"UNKNOWN", subtype:"S", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)
*/
        filter1position  (Channel,
            description:"Filter Position", units:"F",
            devcName:"Monochromator", hwChan:2, type:"UNKNOWN", subtype:"F", offset:0.0, scale:1.0,
            checkLo:"flag", alarmLo:null,
            checkHi:"flag", alarmHi:null)

    }

    SpotProjFWheel (thorlabsFWClass)
    {
        SpotProjFWheelPos (Channel, 
                           description:"Spot projector filter wheel position",
                           devcName:"SpotProjFWheel", type:"POSITION",
                           format:"%.0f", checkLo:"none", checkHi:"none")
    }

    NeutralFWheel (thorlabsFWClass)
    {
        NeutralFWheelPos (Channel,
                           description:"Neutral density filter wheel position",
                           devcName:"NeutralFWheel", type:"POSITION",
                           format:"%.0f", checkLo:"none", checkHi:"none")
    }

    ColorFWheel (thorlabsFWClass)
    {
        ColorFWheelPos (Channel,
                           description:"Color filter wheel position",
                           devcName:"ColorFWheel", type:"POSITION",
                           format:"%.0f", checkLo:"none", checkHi:"none")
    }

    ProjectorShutter (thorlabsSC10Class)
    {
    }

    TS8Shutter (uniblitzShutterClass)
    {
    }

//    AlarmHDWPD (Alarm, eventParm:TSConfig.EVENT_ID.PD.ordinal())


}
