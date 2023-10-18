import org.lsst.ccs.description.groovy.CCSBuilder;
import org.lsst.ccs.subsystem.common.devices.power.distribution.*;
import org.lsst.ccs.bootstrap.BootstrapResourceUtils;
import org.lsst.ccs.subsystem.apcpdu.ApcPdu

import org.lsst.ccs.monitor.Alarm;
import org.lsst.ccs.monitor.Channel;

CCSBuilder builder = ["pap-pdu"]

builder.main (ApcPdu) {

    PDU120 (APC7900Device) {
        Power    (Channel, description:"PDU power", units:"Watts",
                       hwChan:APC7900Device.CHAN_POWER, type:"POWER")

    }

}