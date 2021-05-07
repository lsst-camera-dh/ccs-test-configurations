system.property.org.lsst.ccs.resource.path=/home/ccs/projects/sequencer-files/25raft/:../etc/:~/ccs/etc/:/etc/ccs/
system.pre-execute=daqv4-setup
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlaneSubsystem --alias aliveness-fp --initialConfiguration "build:<instrument>,DAQ:<instrument>,Devices:<instrument>,General:<instrument>,HardwareId:<instrument>,Instrument:<instrument>,Limits:<instrument>,RaftsLimits:<instrument>,RaftsPower:<instrument>,Rafts:<instrument>,RaftTempControl:<instrument>,RaftTempControlStatus:<instrument>,Sequencer:<instrument>,Services:<instrument>,timers:<instrument>,Visualization:<instrument>"
org.lsst.ccs.application.description=Run the FocalPlane Subsystem
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.raft.partition=aliveness
org.lsst.ccs.subsystem.agent.property.group=aliveness
org.lsst.ccs.subsystem.agent.property.instrument=aliveness
org.lsst.ccs.dbUrl=jdbc:mysql://lsst-ir2db01.slac.stanford.edu:3306/ir2dbprod?user=ccs&password=ccs23&autoReconnect=true
org.lsst.ccs.transport=jgroups:udp_ccs:org.lsst.ccs.messaging.util.MultiQueueDispatcher

