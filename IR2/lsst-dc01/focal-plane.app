system.property.org.lsst.ccs.resource.path=/home/ccs/projects/sequencer-files/run5/|../etc/|~/ccs/etc/|/etc/ccs/
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description FocalPlane --alias focal-plane --initialConfiguration "\
   DAQ:common|<instrument>|<instrument>-<site>,\
   Devices:<instrument>,\
   General:common|<instrument>|<instrument>-<site>,\
   HardwareId:<instrument>,\
   Instrument:<instrument>|<instrument>-<site>,\
   Limits:<instrument>,\
   RaftsLimits:<instrument>,\
   RaftTempControl:<instrument>,\
   RaftTempControlStatus:<instrument>|<instrument>-on,\
   Rafts:<instrument>|<instrument>-emu,\
   RaftsPower:<instrument>,\
   Sequencer:common|v26,\
   build:<instrument>,\
   Visualization:<site>,\
   timers:<instrument>" 
org.lsst.ccs.application.description=Run the FocalPlane Subsystem
org.lsst.ccs.ld.library.path=Daq4
org.lsst.ccs.raft.partition=camera
org.lsst.ccs.subsystem.agent.property.group=camera
org.lsst.ccs.dbUrl=jdbc:mysql://lsst-ir2db01.slac.stanford.edu:3306/ir2dbprod?user=ccs&password=ccs23&autoReconnect=true
org.lsst.ccs.transport=jgroups:udp_ccs:org.lsst.ccs.messaging.util.MultiQueueDispatcher
org.lsst.ccs.use.influxdb.service=true
org.lsst.ccs.config.remote=true
