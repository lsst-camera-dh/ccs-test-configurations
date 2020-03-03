org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlaneSubsystem --alias fp-3rebs --configuration "HardwareId:3rebs,Rafts:3rebs,Limits:3rebs,RaftsLimits:3rebs,RaftsPower:3rebs"
org.lsst.ccs.application.description=Run the FocalPlane Subsystem
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.raft.partition=camera
org.lsst.ccs.subsystem.agent.property.group=camera
org.lsst.ccs.dbUrl=jdbc:mysql://lsst-ir2db01.slac.stanford.edu:3306/ir2dbprod?user=ccs&password=ccs23&autoReconnect=true

