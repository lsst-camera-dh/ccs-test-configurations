import org.lsst.ccs.description.groovy.CCSBuilder
import org.lsst.ccs.subsystem.power.PowerControl
import org.lsst.ccs.subsystem.power.BK1696Device
import org.lsst.ccs.subsystem.power.RebPower
import org.lsst.ccs.subsystem.power.RebPsDevice
import org.lsst.ccs.monitor.Channel
import org.lsst.ccs.monitor.Page

taskConfig = ["monitor-update/taskPeriodMillis":5000,"monitor-publish/taskPeriodMillis":10000]

CCSBuilder builder = ["rebpscr"]

def ps0 = "PS0"

builder.main (RebPower, nodeTags:taskConfig) {

    "$ps0" (RebPsDevice, ipAddr: "192.168.1.39")

    // MainPS (BK1696Device, connType: "serial", devcId: "/dev/serial/by-id/usb-FTDI_FT232R_USB_UART_AH03ILEF-if00-port0", baudRate: 0) {
    // MainPS (BK1696Device) {
    //
    //     MainCtrl (PowerControl, desc: "Main PS control", hwChan: 0, voltage: 48.0,
    //               current: 2.0, onDelay: 0.0, offDelay: 0.0)
    // }

    Page4 (Page, id: 4, label: "Common")

    BoardTemp   (Channel, description: "Common\\Board temperature", units: "\u00b0C",
                 devcName: "$ps0", hwChan: 0, type: "TEMP", pageId: 4)

    //MainVoltage (Channel, description: "Main PS Voltage", units: "Volts",
    //             devcName: "MainPS", hwChan: 0, type: "VOLTAGE", pageId: 4)

    //MainCurrent (Channel, description: "Main PS Current", format: ".1f", units: "mA",
    //             devcName: "MainPS", hwChan: 0, type: "CURRENT", scale: 1000, pageId: 4)

    for (int i = 0; i < 2; i++) {
        def reb = (i == 0) ? "WREB" : "GREB"

        "Page$i" (Page, id: i, label: reb)

        def psn = "digital"

        "${reb}.${psn}.VbefLDO" (Channel, description: "${reb} $psn PS\\Voltage before LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 0, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IbefLDO" (Channel, description: "Current before LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 1, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftLDO" (Channel, description: "Voltage after LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 2, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IaftLDO" (Channel, description: "Current after LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 3, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftSwch" (Channel, description: "Voltage after switch", units: "Volts",
                                  devcName: "$ps0", hwChan: 4, type: "$i:$psn", pageId: i)

        psn = "analog"

        "${reb}.${psn}.VbefLDO" (Channel, description: "${reb} ${psn} PS\\Voltage before LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 0, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IbefLDO" (Channel, description: "Current before LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 1, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftLDO" (Channel, description: "Voltage after LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 2, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IaftLDO" (Channel, description: "Current after LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 3, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftSwch" (Channel, description: "Voltage after switch", units: "Volts",
                                  devcName: "$ps0", hwChan: 4, type: "$i:$psn", pageId: i)

        psn = "OD"

        "${reb}.${psn}.VbefLDO" (Channel, description: "${reb} ${psn} PS\\Voltage before LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 0, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IbefLDO" (Channel, description: "Current before LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 1, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftLDO" (Channel, description: "Voltage after LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 2, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.VaftLDO2" (Channel, description: "Voltage after LDO2", units: "Volts",
                                  devcName: "$ps0", hwChan: 5, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IaftLDO" (Channel, description: "Current after LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 3, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftSwch" (Channel, description: "Voltage after switch", units: "Volts",
                                  devcName: "$ps0", hwChan: 4, type: "$i:$psn", pageId: i)

        psn = "clockhi"

        "${reb}.${psn}.VbefLDO" (Channel, description: "${reb} ${psn} PS\\Voltage before LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 0, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IbefLDO" (Channel, description: "Current before LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 1, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftLDO" (Channel, description: "Voltage after LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 2, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IaftLDO" (Channel, description: "Current after LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 3, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftSwch" (Channel, description: "Voltage after switch", units: "Volts",
                                  devcName: "$ps0", hwChan: 4, type: "$i:$psn", pageId: i)

        psn = "clocklo"

        "${reb}.${psn}.VbefLDO" (Channel, description: "${reb} ${psn} PS\\Voltage before LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 0, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IbefLDO" (Channel, description: "Current before LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 1, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftLDO" (Channel, description: "Voltage after LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 2, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.VaftLDO2" (Channel, description: "Voltage after LDO2", units: "Volts",
                                  devcName: "$ps0", hwChan: 5, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IaftLDO" (Channel, description: "Current after LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 3, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftSwch" (Channel, description: "Voltage after switch", units: "Volts",
                                  devcName: "$ps0", hwChan: 4, type: "$i:$psn", pageId: i)

        psn = "dphi"

        "${reb}.${psn}.VbefLDO" (Channel, description: "${reb} ${psn} PS\\Voltage before LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 0, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IbefLDO" (Channel, description: "Current before LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 1, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftLDO" (Channel, description: "Voltage after LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 2, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IaftLDO" (Channel, description: "Current after LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 3, type: "$i:$psn", scale: 1000, pageId: i)

        "${reb}.${psn}.VaftSwch" (Channel, description: "Voltage after switch", units: "Volts",
                                  devcName: "$ps0", hwChan: 4, type: "$i:$psn", pageId: i)

        def psnn = "heater"
        psn = (i == 0) ? "digital" : "analog"

        "${reb}.${psnn}.VbefLDO" (Channel, description: "${reb} $psnn PS\\Voltage before LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 0, type: "2:$psn", pageId: i)

        "${reb}.${psnn}.IbefLDO" (Channel, description: "Current before LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 1, type: "2:$psn", scale: 1000, pageId: i)

        "${reb}.${psnn}.VaftLDO" (Channel, description: "Voltage after LDO", units: "Volts",
                                 devcName: "$ps0", hwChan: 2, type: "2:$psn", pageId: i)

        "${reb}.${psnn}.IaftLDO" (Channel, description: "Current after LDO", format: ".1f", units: "mA",
                                 devcName: "$ps0", hwChan: 3, type: "2:$psn", scale: 1000, pageId: i)

        "${reb}.${psnn}.VaftSwch" (Channel, description: "Voltage after switch", units: "Volts",
                                  devcName: "$ps0", hwChan: 4, type: "2:$psn", pageId: i)

        psn = "hvbias"

        "${reb}.${psn}.VbefSwch" (Channel, description: "${reb} ${psn} PS\\Voltage before switch", units: "Volts",
                                  devcName: "$ps0", hwChan: 0, type: "$i:$psn", pageId: i)

        "${reb}.${psn}.IbefSwch" (Channel, description: "Current before switch", format: ".3f", units: "mA",
                                  devcName: "$ps0", hwChan: 1, type: "$i:$psn", scale: 1000, pageId: i)

    }

}
