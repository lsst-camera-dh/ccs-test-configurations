org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias aliveness-ih --description ImageHandling  --initialConfiguration "\
   General:<instrument>,\
   Guider:noGuiding,\
   DAQ:common|<instrument>,\
   build:common|<instrument>,\
   Commands:common|<instrument>,\
   FitsHandling:common|<instrument>"
org.lsst.ccs.application.description=Run the Image Handling Subsystem (for aliveness)
org.lsst.ccs.subsystem.agent.property.group=aliveness
org.lsst.ccs.subsystem.agent.property.instrument=aliveness
