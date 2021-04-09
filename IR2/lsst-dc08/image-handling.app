org.lsst.ccs.application.mainClass=org.lsst.ccs.startup.SubsystemBoot
org.lsst.ccs.application.args=--alias image-handling-<host> --description ImageHandlingSubsystem  --initialConfiguration "build:<host>,General:defaultInitial|<host>,DAQ:defaultInitial|<host>,FitsHandling:defaultInitial|bot|<host>" 
org.lsst.ccs.application.description=Run the Image Handling Subsystem (<host>)
org.lsst.ccs.subsystem.agent.property.group=camera
