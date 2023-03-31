org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description MCM  --alias ts8-mcm --initialConfiguration General:common|<instrument>|<instrument>-<site>
org.lsst.ccs.application.description=Start the MCM subsystem for TS8   
org.lsst.ccs.logging.StackTraceFormats.depth=-1
org.lsst.ccs.mcm.camera: TestStand
org.lsst.ccs.subsystem.agent.property.group=ts8-raft
org.lsst.ccs.subsystem.agent.property.instrument=ts8
org.lsst.ccs.subsystem.agent.property.site=slac
org.lsst.ccs.dbUrl=jdbc:mysql://lsst-ir2db01.slac.stanford.edu:3306/ir2dbprod?user=ccs&password=ccs23&autoReconnect=true
