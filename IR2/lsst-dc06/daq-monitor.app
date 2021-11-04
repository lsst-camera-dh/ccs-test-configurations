org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.description=Run the Daq-monitoring subsystem
org.lsst.ccs.application.args=--description DaqMonitor --initialConfiguration "Store:common|camera" --alias daq-monitor
system.pre-execute=daqv5-setup
org.lsst.ccs.subsystem.agent.property.group=camera
org.lsst.ccs.config.remote=true

