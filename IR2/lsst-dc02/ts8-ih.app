org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias ts8-ih --description ImageHandling --initialConfiguration "\
   General:<instrument>|<instrument>-<site>,\
   DAQ:common|<instrument>|<instrument>-<site>,\
   build:common|<instrument>|<instrument>-<site>,\
   Commands:common|<instrument>|<instrument>-<site>,\
   FitsHandling:common|<instrument>|<instrument>-<site>"
org.lsst.ccs.application.description=Run the Image Handling Subsystem (for ts8)
org.lsst.ccs.subsystem.agent.property.group=ts8-raft
org.lsst.ccs.subsystem.agent.property.instrument=ts8
system.option.-add-opens\=java.base/java.util\=ALL-UNNAMED