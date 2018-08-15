# Specification file for ts7-2cret_cond header. Taken from LCA 10140 v1
#
EXTNAME     String  "TEST_COND"                 Name of the extension
TEMP_SET    Float   ${StatusAggregator.ts7-2cr/ccdtempsetpoint}       Temperature set point
SENSTEMP    Float   ${MeasuredTemperature}             Measured sensor temperature
ROOMTEMP    Float   ${StatusAggregator.ts7-2cr/roomtemperature}       Room Temperature
DWRPRESS    Float   ${StatusAggregator.ts7-2cr/vqmpressure}           Dewar internal pressure level
SRCTYPE     String  ${StatusAggregator.ts7-2cr/TSState/srctype}       Type of light source used
SRCMODL     String  ${StatusAggregator.ts7-2cr/TSState/srctype}       Manufacturer’s Model number
SRCPWR      Float   ${StatusAggregator.ts8-bench/lamppower}             Light source power
ND_FILT     Integer ${StatusAggregator.ts7-2cr/TSState/fltpos}        ND Filter after lamp (if any)
FILTER      String  ${StatusAggregator.ts7-2cr/TSState/filter}        Optical Filter used
FILTRPOS    Integer ${StatusAggregator.ts8-bench/filter1position}        Filter position
MONOMODL    String  ${StatusAggregator.ts8-bench/TSState/monotype}      Monochromator model number
MONOPOS     Integer ${StatusAggregator.ts8-bench/monochromgrating}      Monochromator grating turret position
MONOGRAT    Integer ${StatusAggregator.ts8-bench/monochromgrating}      Monochromator grating in use
MONOWL      Float   ${MonochromatorWavelength}                                                              Monochromator WL setting
MONOSTEP    Integer ${StatusAggregator.ts8-bench/monochromstep}        Monochromator step
MONOSLT1    Float  ${StatusAggregator.ts8-bench/monochromatorslit1}      Monochromator slit width 1
MONOSLT2    Float  ${StatusAggregator.ts8-bench/monochromatorslit2}      Monochromator slit width 2
MONOWAVE    Float  ${StatusAggregator.ts8-bench/monochromatorwavelength} Monochromator wavelength
PD_MODEL    String  ${StatusAggregator.ts7-2cr/TSState/pdtype}        Monitor Photodiode model number
PD_SER      String  ${PhotodiodeSignal}                                                                     Monitor Photodiode serial number
LAMPCURR    Float   ${StatusAggregator.ts8-bench/lampcurrent}          Lamp current (A)
LAMPPWR     Float   ${StatusAggregator.ts8-bench/lamppower}             Lamp power (W)
# TS7-2CR Parameters
COLDTEMP    Float   ${StatusAggregator.ts7-2cr/ColdPlate}             Cold Plate Temperature (deg C)
CRYOTEMP    Float   ${StatusAggregator.ts7-2cr/CryoPlate}             Cryo Plate Temperature (deg C)
CRYOHTR1    Float   ${StatusAggregator.ts7-2cr/htrread1}              Cryocon Loop 1 power (%)
CRYOHTR2    Float   ${StatusAggregator.ts7-2cr/htrread2}              Cryocon Loop 2 power (%)
TEMPCHNG    Float   ${StatusAggregator.ts7-2cr/tmpChng}               Temperature change rate (deg C/min)
TEMPSET1    Float   ${StatusAggregator.ts7-2cr/SetPnt1}               CryoCon Loop 1 set point (deg C)
TEMPSET2    Float   ${StatusAggregator.ts7-2cr/SetPnt2}               CryoCon Loop 2 set point (deg C)
VQMPRESS    Float   ${StatusAggregator.ts7-2cr/vqmpressure}           Dewar pressure (Torr)
PDU15I      Float   ${StatusAggregator.ts7-2cr/PDU15Current}          PDU15 current (A)
PDU15W      Float   ${StatusAggregator.ts7-2cr/PDU15Power}            PDU15 power (W)
VQMSTAT     Integer ${StatusAggregator.ts7-2cr/VQMState}              VQM on/off status
CRYOSTAT    Integer ${StatusAggregator.ts7-2cr/CryoConState}          CryoCon 24C on/off status
RPSSTAT     Integer ${StatusAggregator.ts7-2cr/REBPsState}            REB Power Supply on/off status
OTMPSTAT    Integer ${StatusAggregator.ts7-2cr/OTMPsState}            OTM power supply on/off status
RPMPSTAT    Integer ${StatusAggregator.ts7-2cr/RoughPumpState}        Roughing Pump on/off status
TURBSTAT    Integer ${StatusAggregator.ts7-2cr/TurboPumpState}        Turbo pump on/off status
SWCHSTAT    Integer ${StatusAggregator.ts7-2cr/NetSwitchStat}         Network switch on/off status
VATVSTAT    Integer ${StatusAggregator.ts7-2cr/VATvalveState}         Vacuum valve on/off status
PDU20I      Float   ${StatusAggregator.ts7-2cr/PDU20Current}          PDU20 current (A)
PDU20W      Float   ${StatusAggregator.ts7-2cr/PDU20Power}            PDU20 power (W)
NF51STAT    Integer ${StatusAggregator.ts7-2cr/NF_55_1State}          NF-55 PCC #1 on/off status
NF52STAT    Integer ${StatusAggregator.ts7-2cr/NF_55_2State}          NF-55 PCC #2 on/off status
PT30STAT    Integer ${StatusAggregator.ts7-2cr/PT_30State}            PT-30 PCC on/off status
XEDPSTAT    Integer ${StatusAggregator.ts7-2cr/XEDPowerState}         XED Power on/off status
XEDCSTAT    Integer ${StatusAggregator.ts7-2cr/XEDCntrlState}         XED Controller  on/off status
TPMP_I      Float   ${StatusAggregator.ts7-2cr/TurboCurrent}          Turbo pump current (mA)
TPMP_V      Float   ${StatusAggregator.ts7-2cr/TurboVoltage}          Turbo pump voltage (V dc)
TPMP_W      Float   ${StatusAggregator.ts7-2cr/TurboPower}            Turbo pump power (W)
TPMP_FRQ    Float   ${StatusAggregator.ts7-2cr/TurboDriveFreq}        Turbo pump drive frequency (Hz)
TPMP_TMP    Float   ${StatusAggregator.ts7-2cr/TurboPumpTemp}         Turbo pump temperature (deg C)
TPMP_RPM    Integer ${StatusAggregator.ts7-2cr/TurboRPM}              Turbo pump RPM (Hz)
TPMP_STS    Integer ${StatusAggregator.ts7-2cr/TurboStatus}           Turbo pump status
UPS_STS     Integer ${StatusAggregator.ts7-2cr/UPS_Status}            UPS status
UPS_CUR     Float   ${StatusAggregator.ts7-2cr/UPS_Current}           UPS current (A)
UPS_CHG     Float   ${StatusAggregator.ts7-2cr/UPS_Charge}            UPS charge (%)
UPS_TIM     Integer ${StatusAggregator.ts7-2cr/UPS_RemTime}           UPS time remaining (seconds)
