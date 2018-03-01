# Specification file for [System(org.lsst.ccs.subsystem.teststand,ts)]et_cond header. Taken from LCA 10140 v1
#
EXTNAME     String  "TEST_COND"                 Name of the extension
TEMP_SET    Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/ccdtempsetpoint}       Temperature set point
SENSTEMP    Float   ${MeasuredTemperature}             Measured sensor temperature
ROOMTEMP    Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/roomtemperature}       Room Temperature
CRYOTEMP    Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/CryoPlate}                Cryo Plate Temperature
COLDTMPA    Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/ColdPlate-a}                Cold Plate Temperature
COLDTMPB    Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/ColdPlate-b}                Cold Plate Temperature
DWRPRESS    Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/dewarpressure}         Dewar internal pressure level
SRCTYPE     String  ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/srctype}       Type of light source used
SRCMODL     String  ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/srctype}       Manufacturer’s Model number
SRCPWR      Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/lamppower}             Light source power
ND_FILT     Integer ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/fltpos}        ND Filter after lamp (if any)
FILTER      String  ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/filter}        Optical Filter used
MONOMODL    String  ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/TSState/monotype}      Monochromator model number
MONOPOS     Integer ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/monochromgrating}      Monochromator grating turret position
MONOGRAT    Integer ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/monochromgrating}      Monochromator grating in use
MONOWL      Float   ${MonochromatorWavelength}  Monochromator WL setting
PD_MODEL    String  ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/pdtype}        Monitor Photodiode model number
PD_SER      String  ${PhotodiodeSignal}         Monitor Photodiode serial number
