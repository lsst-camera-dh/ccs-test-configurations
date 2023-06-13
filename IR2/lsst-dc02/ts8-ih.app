org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias ts8-ih --description ImageHandling --initialConfiguration "\
   General:<instrument>(13),\
   Guider:noGuiding,\
   DAQ:common|<instrument>,\
   build:common|<instrument>,\
   Commands:common|<instrument>(6),\
   FitsHandling:common|<instrument>(7)"
org.lsst.ccs.application.description=Run the Image Handling Subsystem (for ts8)
org.lsst.ccs.subsystem.agent.property.group=ts8-raft
org.lsst.ccs.subsystem.agent.property.instrument=ts8
system.option.-add-opens\=java.base/java.util\=ALL-UNNAMED
