org.lsst.ccs.application.description=Control the REB power supply
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=\
 --description RebPowerSupply --alias ts7-rebpower \
 --initialConfiguration build:<alias>,\
                        Limits:<alias>,\
                        Power:<alias>,\
			HVRegulation:<alias>,\
                        General:<alias>,\
                        timers:<alias>,\
                        Devices:<alias>

org.lsst.ccs.subsystem.agent.property.group=ts8-raft

#To use a REB power supply with prototype firmware
#org.lsst.ccs.ps.version=proto

#To use the Lambda CPFE1000 as the main power supply
org.lsst.ccs.main.ps.type=cpfe

#To run in simulation mode
#org.lsst.ccs.run.mode=simulation
