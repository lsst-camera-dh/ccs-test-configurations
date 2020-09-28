org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.description=Run the Daq-monitoring subsystem
org.lsst.ccs.application.args=--description daq-monitor --initialConfiguration --alias ts8-daq-monitor
system.pre-execute=daqv4-setup
