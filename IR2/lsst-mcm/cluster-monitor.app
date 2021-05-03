org.lsst.ccs.application.extends=cluster-monitor
org.lsst.ccs.application.args=--description ClusterMonitor --initialConfiguration InfluxDb:<cluster>
#system.property.com.sun.management.jmxremote.port=5555 
# This seems to cause problems sometimes, I am not sure why
#system.property.com.sun.management.jmxremote.rmi.port=5555 
org.lsst.ccs.use.influxdb.service=true
#org.lsst.ccs.subsystem.cluster.monitor.level=INFO