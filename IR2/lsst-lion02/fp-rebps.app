org.lsst.ccs.application.description=Control the REB power supply
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--description Rebps --initialConfiguration  --alias fp-rebps
org.lsst.ccs.subsystem.agent.property.group=camera

#To use a REB power supply with prototype firmware
#org.lsst.ccs.ps.version=proto

#To use the Lambda CPFE1000 as the main power supply
org.lsst.ccs.main.ps.type=none

#To run in simulation mode
#org.lsst.ccs.run.mode=simulation
