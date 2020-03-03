org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlaneSubsystem --configuration "HardwareId:pl60dp96,Rafts:pl60dp96,Limits:pl60dp96,RaftsLimits:pl60dp96,RaftsPower:pl60dp96,timers:pl60dp96,DAQ:pl60dp96,RaftTempControlStatus:pl60dp96,FitsHandling:pl60dp96,RaftTempControl:pl60dp96,Sequencer:pl60dp96"
org.lsst.ccs.application.description=Run the FocalPlane Subsystem
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.raft.partition=camera
org.lsst.ccs.subsystem.agent.property.group=camera
org.lsst.ccs.dbUrl=jdbc:mysql://lsst-ir2db01.slac.stanford.edu:3306/ir2dbprod?user=ccs&password=ccs23&autoReconnect=true

