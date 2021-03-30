system.property.org.lsst.ccs.resource.path=/home/ccs/projects/sequencer-files/25raft/:../etc/:~/ccs/etc/:/etc/ccs/
system.pre-execute=daqv4-setup
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlaneSubsystem --alias ts8-fp --initialConfiguration 
org.lsst.ccs.application.description=Run the FocalPlane Subsystem
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.raft.partition=ts8
org.lsst.ccs.subsystem.agent.property.group=ts8-raft
org.lsst.ccs.dbUrl=jdbc:mysql://lsst-ir2db01.slac.stanford.edu:3306/ir2dbprod?user=ccs&password=ccs23&autoReconnect=true
system.option.agentpath=:/home/ccs/jprofiler11.1.4/bin/linux-x64/libjprofilerti.so=port=8849,nowait,id=121,config=/home/ccs/jprofiler_config.xml 
