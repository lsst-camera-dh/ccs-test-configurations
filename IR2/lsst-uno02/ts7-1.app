org.lsst.ccs.application.extends=ts7-slac
org.lsst.ccs.application.args=\
 --description TS7Bench \
 --alias ts7-1 \
 --initialConfiguration Cryocon:defaultInitial,\
                        Limits:defaultInitial|ts7-1|ts7-1-ops,\
                        General:defaultInitial|<alias>,\
                        timers:defaultInitial|<alias>,\
                        Devices:defaultInitial,\
			InfluxDb:<cluster>

org.lsst.ccs.use.influxdb.service=true


