#system.property.org.lsst.ccs.resource.path=/home/ccs/projects/sequencer-files/commissioning/|../etc/|~/ccs/etc/|/etc/ccs/
system.property.org.lsst.ccs.resource.path=ccs://lsst-camera-dev.slac.stanford.edu/RestFileServer/misc/sequencer-files[seq]|../etc/|~/ccs/etc/|/etc/ccs/
system.pre-execute=daqv5-setup
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlane --alias aliveness-fp --initialConfiguration "build:<instrument>,DAQ:common|<instrument>,Devices:<instrument>,General:<instrument>,HardwareId:<instrument>,Instrument:<instrument>,Limits:<instrument>,RaftsLimits:<instrument>,RaftsPower:<instrument>,Rafts:<instrument>,RaftTempControl:<instrument>,RaftTempControlStatus:<instrument>,Sequencer:common|3s-v1,timers:<instrument>,Visualization:<instrument>,Guider:no-guiding"
org.lsst.ccs.application.description=Run the FocalPlane Subsystem
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.raft.partition=aliveness
org.lsst.ccs.subsystem.agent.property.group=aliveness
org.lsst.ccs.subsystem.agent.property.instrument=aliveness
org.lsst.ccs.dbUrl=jdbc:mysql://lsst-ir2db01.slac.stanford.edu:3306/ir2dbprod?user=ccs&password=ccs23&autoReconnect=true
org.lsst.ccs.transport=jgroups:udp_ccs:org.lsst.ccs.messaging.util.MultiQueueDispatcher
