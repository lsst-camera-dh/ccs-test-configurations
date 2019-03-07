# Specification file for primary header. Taken from LCA 10140 v1
#
MONDIODE    Float   0                           Current in the monitoring diode (nA)
CCDBSS      Float   ${MeasuredCCDBSS}           CCD bias voltage
FILTER      String  ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/filter}        Name of the filter
FILTPOS     Integer ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts8-bench)]/Monochromator/filterId}      Filter position
CCDGAIN     Float   1.00                        Rough guess at overall system gain (e-/DNB)
CCDNOISE    Float   10.0                        Rough guess at system noise (e- rms)
PIXRATE     Float   ${PixelReadRate}            Rate for pixel reads
HIERARCH.MONOCH-WAVELENG Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/monochromatorwavelength} monochromator wavelength
HIERARCH.MONOCH-SLIT_A   Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/monochromatorslit1}     Width of the A slit in um
HIERARCH.MONOCH-SLIT_B   Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/monochromatorslit2}     Width of the B slit in um
HIERARCH.MONOCH-SLIT_C   Float   0                            Width of the C slit in um
HIERARCH.MONOCH-BANDPASS Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/monochromband}          Automatic slit width in nm
HIERARCH.MONOCH-FILT_1   Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/filter1position}        filter position
HIERARCH.MONOCH-MSTEPS   Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/monochromstep}          Current grating position in terms of motor step
HIERARCH.MONOCH-GRATING  Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.ts8-bench,ts)]/monochromgrating}       Grating position
HIERARCH.AMP0-IDN        String  ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/pdtype}         Monitor Photodiode model number
HIERARCH.AMP0-AZERO      String  F                            SYSTEM:AZERO value
HIERARCH.AMP0-COUNT      Integer ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/pdcnt}          number of measuremen[System(org.lsst.ccs.subsystem.teststand,ts)] (buffer length)
HIERARCH.AMP0-MEAS_NPLC  Integer ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/pdnplc}         Time of each measurment. In Hz multiples (1 = 1
HIERARCH.AMP2-IDN        String  ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/biastype}       identification string
#HIERARCH.AMP2-ON         Integer ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/biasstate}      If voltage source is switched on
HIERARCH.AMP2-VOLTAGE    Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/ccdbiasvoltage}         [V] voltage level
HIERARCH.AMP2-CURRENT    Float   ${StatusAggregator.[System(org.lsst.ccs.subsystem.teststand,ts)]/TSState/picocurrent}    [pA] measured current (in picoAmps)
HIERARCH.AMP2-ZERO_CHECK String  off                          Zero check on/off
