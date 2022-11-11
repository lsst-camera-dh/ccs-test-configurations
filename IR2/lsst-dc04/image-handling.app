org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias image-handling-<host> --description ImageHandling  --initialConfiguration "\
    build:<host>,\
    General:defaultInitial|<host>,Commands:common|<instrument>,\
    DAQ:common|<instrument>|<host>,\
    FitsHandling:common|bot|<host>" 
org.lsst.ccs.application.description=Run the Image Handling Subsystem (<host>)
org.lsst.ccs.subsystem.agent.property.group=camera
org.lsst.ccs.config.remote=true
system.property.org.lsst.ccs.subsystem.imagehandling.FitsTimeoutSeconds=60
system.option.-add-opens\=java.base/java.util\=ALL-UNNAMED