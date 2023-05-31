import org.lsst.ccs.description.groovy.CCSBuilder;
import org.lsst.ccs.subsystem.ccob.CCOBMainModule;
import org.lsst.ccs.subsystem.ccob.CCOBDevice;
import org.lsst.ccs.drivers.ccob.CCOBCommands;
import org.lsst.ccs.monitor.Channel;
import org.lsst.ccs.subsystem.teststand.KeysightDevice;

CCSBuilder builder = ["ccob"]

Class keysightClass = Class.forName("org.lsst.ccs.subsystem.teststand.KeysightDevice");


builder.main (CCOBMainModule) {  
    
    PhotoDiode  (keysightClass)
    {
    }


    // Low level access to driver
    ccobDriver(CCOBCommands)

    // ------ Monitoring 
    ccobDvc(CCOBDevice) {
        
        // Channels read as a group with getADCValues
        ledVoltage(Channel, description:"LED voltage", hwChan:CCOBDevice.CHAN_LED_VOLTAGE, units:"V", format:".5f",
                   checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)

        ledCurrent(Channel, description:"LED current", hwChan:CCOBDevice.CHAN_LED_CURRENT, units:"A", format:".6f",
                   checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)

        vrefLed(Channel, description:"LED reference voltage", hwChan:CCOBDevice.CHAN_LED_VREF, units:"V", format:".5f",
                checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)

        tempLed1(Channel, description:"LED temperature 1", hwChan:CCOBDevice.CHAN_LED_TEMP1, units:"\u00b0C", format:".1f",
                 checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)

        tempLed2(Channel, description:"LED temperature 2", hwChan:CCOBDevice.CHAN_LED_TEMP2, units:"\u00b0C", format:".1f",
                 checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)

        photodiodeCurrent(Channel, description:"Photodiode current", hwChan:CCOBDevice.CHAN_PD_CURRENT, units:"A", format:".6f",
                          checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)

        tempSphere(Channel, description:"Sphere temperature", hwChan:CCOBDevice.CHAN_SPHERE_TEMP, units:"\u00b0C", format:".1f",
                   checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)

        tempBrd(Channel, description:"Board temperature", hwChan:CCOBDevice.CHAN_BOARD_TEMP, units:"\u00b0C", format:".1f",
                checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)
        
        // Channels read separately
        photodiodeAdc(Channel, description:"Photodiode ADC", hwChan:CCOBDevice.CHAN_PD_ADC, units:"V", format:".5f",
                      checkLo:"flag", alarmLo:null, checkHi:"flag", alarmHi:null)
    }

}

