import org.lsst.ccs.description.groovy.CCSBuilder;
import org.lsst.ccs.subsystem.common.devices.power.distribution.*;
import org.lsst.ccs.bootstrap.BootstrapResourceUtils;
import org.lsst.ccs.subsystem.apcpdu.ApcPdu

import org.lsst.ccs.monitor.Alarm;
import org.lsst.ccs.monitor.Channel;

CCSBuilder builder = ["pap-pdu"]

Properties props = BootstrapResourceUtils.getBootstrapSystemProperties()
def runMode = props.getProperty("org.lsst.ccs.run.mode","normal");

String type = runMode.equals("simulation") ? "APC7900Sim" : "APC7900"

builder.main (ApcPdu) {

    PDU120 (APC7900Device, type: type, node:"192.168.1.2", outlets:["THERMOCOUPLEDISPLAY","flatlamp","Outlet-3","lowern2valve","ALWAYSON","Outlet-6","n2heater","nitrogenvalve"]) {
        Power    (Channel, description:"PDU power", units:"Watts",
                       hwChan:APC7900Device.CHAN_POWER, type:"POWER",
                       limitHi:1320.0)

    }

    PDU230 (APC7900Device, type: type, node:"192.168.1.3", outlets:["Outlet-21","Outlet-22","Outlet-23","Outlet-24","Outlet-25","vacuumscrollpump","upperbandhtr","lwrbandhtr"]) {
        Power    (Channel, description:"PDU power", units:"Watts",
                       hwChan:APC7900Device.CHAN_POWER, type:"POWER",
                       limitHi:1320.0)

    }
}

