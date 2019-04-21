TEMP1          Float   ${ts6-fp/RAFT/REB/Temp1} REB Board temperature 1
TEMP2          Float   ${ts6-fp/RAFT/REB/Temp2} REB Board temperature 2
TEMP3          Float   ${ts6-fp/RAFT/REB/Temp3} REB Board temperature 3
TEMP4          Float   ${ts6-fp/RAFT/REB/Temp4} REB Board temperature 4
TEMP5          Float   ${ts6-fp/RAFT/REB/Temp5} REB Board temperature 5
TEMP6          Float   ${ts6-fp/RAFT/REB/Temp6} REB Board temperature 6
TEMP7          Float   ${ts6-fp/RAFT/REB/Temp7} REB Board temperature 7
TEMP8          Float   ${ts6-fp/RAFT/REB/Temp8} REB Board temperature 8
TEMP9          Float   ${ts6-fp/RAFT/REB/Temp9} REB Board temperature 9
TEMP10         Float   ${ts6-fp/RAFT/REB/Temp10} REB Board temperature 10
ATEMPU         Float   ${ts6-fp/RAFT/REB/Atemp0U} ASPIC - upper temperature
ATEMPL         Float   ${ts6-fp/RAFT/REB/Atemp0L} ASPIC - lower temperature
CCDTEMP        Float   ${ts6-fp/RAFT/REB/CCDtemp0} CCD temperature
#
DIGPS_V        Float   ${ts6-fp/RAFT/REB/DigPS_V} REB Digital PS voltage 
DIGPS_I        Float   ${ts6-fp/RAFT/REB/DigPS_I} REB Digital PS current 
ANAPS_V        Float   ${ts6-fp/RAFT/REB/AnaPS_V} REB Analog PS voltage 
ANAPS_I        Float   ${ts6-fp/RAFT/REB/AnaPS_I} REB Analog PS current 
CLKHPS_V       Float   ${ts6-fp/RAFT/REB/ClkHPS_V} REB CLK_H PS voltage 
CLKHPS_I       Float   ${ts6-fp/RAFT/REB/ClkHPS_I} REB CLK_H PS current 
ODPS_V         Float   ${ts6-fp/RAFT/REB/ODPS_V}  REB OD PS voltage 
ODPS_I         Float   ${ts6-fp/RAFT/REB/ODPS_I}  REB OD PS current 
HTRPS_V        Float   ${ts6-fp/RAFT/REB/HtrPS_V} REB Heater PS voltage 
HTRPS_I        Float   ${ts6-fp/RAFT/REB/HtrPS_I} REB Heater PS current 
#
CKPSH_V        Float   ${ts6-fp/RAFT/REB/CKPSH_V} REB clock rails CKP_SH Voltage
CKS_V          Float   ${ts6-fp/RAFT/REB/CKS_V}   REB clock rails CKS Voltage
SCKU_V         Float   ${ts6-fp/RAFT/REB/SCKU_V}  REB clock rails SCK_U Voltage
CSKL_V         Float   ${ts6-fp/RAFT/REB/SCKL_V}  REB clock rails SCK_L Voltage
RG_V           Float   ${ts6-fp/RAFT/REB/RG_V}    REB clock rails RG Voltage
RGU_V          Float   ${ts6-fp/RAFT/REB/RGU_V}   REB clock rails RG_U Voltage
RGL_V          Float   ${ts6-fp/RAFT/REB/RGL_V}   REB clock rails RG_L Voltage
CKP0_V         Float   ${ts6-fp/RAFT/REB/CKP0V}   REB clock rails CKP 0 Voltage
CKS0_V         Float   ${ts6-fp/RAFT/REB/CKS0V}   REB clock rails CKS 0 Voltage
RG0_V          Float   ${ts6-fp/RAFT/REB/RG0V}    REB clock rails RG 0 Voltage
#
ODOV           Float   ${ts6-fp/RAFT/REB/OD0V}    REB bias OD voltage
OGOV           Float   ${ts6-fp/RAFT/REB/OG0V}    REB bias OG voltage
RD0V           Float   ${ts6-fp/RAFT/REB/RD0V}    REB bias RD voltage
RG0V           Float   ${ts6-fp/RAFT/REB/GD0V}    REB bias GD voltae
ODOI           Float   ${ts6-fp/RAFT/REB/OD0I}    REB bias OD current
#
GDP            Float   ${ts6-fp/RAFT/REB/Bias0/gdP}    REB config bias GD (requested)  
GD             Integer ${ts6-fp/RAFT/REB/Bias0/gd}     REB config bias GD (applied)
RDP            Float   ${ts6-fp/RAFT/REB/Bias0/rdP}    REB config bias RD (requested)  
RD             Integer ${ts6-fp/RAFT/REB/Bias0/rd}     REB config bias RD (applied)
OGP            Float   ${ts6-fp/RAFT/REB/Bias0/ogP}    REB config bias OG (requested)  
OG             Integer ${ts6-fp/RAFT/REB/Bias0/og}     REB config bias OG (applied)
ODP            Float   ${ts6-fp/RAFT/REB/Bias0/odP}    REB config bias OD (requested)  
OD             Integer ${ts6-fp/RAFT/REB/Bias0/od}     REB config bias OD (applied)
CSGATEP        Float   ${ts6-fp/RAFT/REB/Bias0/csGateP} REB config bias CS gate (requested)  
CSGATE         Integer ${ts6-fp/RAFT/REB/Bias0/csGate}  REB config bias CS gate (applied)
#
AP0_RC         Integer ${ts6-fp/RAFT/REB/ASPIC0/rc}    REB ASPIC 0 RC
AP1_RC         Integer ${ts6-fp/RAFT/REB/ASPIC1/rc}    REB ASPIC 1 RC 
AP0_GAIN       Integer ${ts6-fp/RAFT/REB/ASPIC0/gain}  REB ASPIC 0 gain
AP1_GAIN       Integer ${ts6-fp/RAFT/REB/ASPIC1/gain}  REB ASPIC 1 gain
AP0_CLMP       Integer ${ts6-fp/RAFT/REB/ASPIC0/clamp} REB ASPIC 0 clamp
AP1_CLMP       Integer ${ts6-fp/RAFT/REB/ASPIC1/clamp} REB ASPIC 1 clamp
AP0_AF1        Integer ${ts6-fp/RAFT/REB/ASPIC0/af1}    REB ASPIC 0 af1
AP1_AF1        Integer ${ts6-fp/RAFT/REB/ASPIC1/af1}    REB ASPIC 1 af1
#
SCK_LOWP       Float   ${ts6-fp/RAFT/REB/DAC/sclkLowP}   REB DAC SCLK Low (requested)
SCK_LOW        Integer ${ts6-fp/RAFT/REB/DAC/sclkLow}    REB DAC SCLK Low (applied)
SCK_HIP        Float   ${ts6-fp/RAFT/REB/DAC/sclkHighP}  REB DAC SCLK High (requested)
SCK_HI         Integer ${ts6-fp/RAFT/REB/DAC/sclkHigh}   REB DAC SCLK High (applied)
PCK_LOWP       Float   ${ts6-fp/RAFT/REB/DAC/pclkLowP}   REB DAC PCLK Low (requested)
PCK_LOW        Integer ${ts6-fp/RAFT/REB/DAC/pclkLow}    REB DAC PCLK Low (applied)
PCK_HIP        Float   ${ts6-fp/RAFT/REB/DAC/pclkHighP}  REB DAC PCLK High (requested)
PCK_HI         Integer ${ts6-fp/RAFT/REB/DAC/pclkHigh}   REB DAC PCLK High (applied)
RG_LOWP        Float   ${ts6-fp/RAFT/REB/DAC/rgLowP}     REB DAC RG Low (requested)
RG_LOW         Integer ${ts6-fp/RAFT/REB/DAC/rgLow}      REB DAC RG Low (applied)
RG_HIP         Float   ${ts6-fp/RAFT/REB/DAC/rgHighP}    REB DAC RG High (requested)
RG_HI          Integer ${ts6-fp/RAFT/REB/DAC/rgHigh}     REB DAC RG High (applied)
