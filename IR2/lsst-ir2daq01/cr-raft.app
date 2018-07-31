org.lsst.ccs.application.extends=run-crtest
org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias cr-raft --description cr --configuration ""
org.lsst.ccs.ld.library.path=Daq2
system.property.org.lsst.ccs.resource.path=/lsst/ccs/configs/raft-config/cr-raft/:../etc/:/etc/ccs/
org.lsst.ccs.rafts.partition=ts5
org.lsst.ccs.rafts.id=0
system.property.org.lsst.ccs.subsystem.teststand=ts7-2cr
system.property.org.lsst.ccs.subsystem.rebps=cr-rebps
system.option.verbose:gc
