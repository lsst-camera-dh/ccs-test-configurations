TEMP1          Float   ${focal-plane/RAFT/REB/Temp1} REB Board temperature 1
TEMP2          Float   ${focal-plane/RAFT/REB/Temp2} REB Board temperature 2
TEMP3          Float   ${focal-plane/RAFT/REB/Temp3} REB Board temperature 3
TEMP4          Float   ${focal-plane/RAFT/REB/Temp4} REB Board temperature 4
TEMP5          Float   ${focal-plane/RAFT/REB/Temp5} REB Board temperature 5
TEMP6          Float   ${focal-plane/RAFT/REB/Temp6} REB Board temperature 6
ATEMPU         Float   ${focal-plane/RAFT/REB/Atemp0U} ASPIC - upper temperature
ATEMPL         Float   ${focal-plane/RAFT/REB/Atemp0L} ASPIC - lower temperature
CCDTEMP        Float   ${focal-plane/RAFT/REB/CCDtemp0} CCD temperature
#
DIGPS_V        Float   ${focal-plane/RAFT/REB/DigPS_V} REB Digital PS voltage 
DIGPS_I        Float   ${focal-plane/RAFT/REB/DigPS_I} REB Digital PS current 
ANAPS_V        Float   ${focal-plane/RAFT/REB/AnaPS_V} REB Analog PS voltage 
ANAPS_I        Float   ${focal-plane/RAFT/REB/AnaPS_I} REB Analog PS current 
CLKHPS_V       Float   ${focal-plane/RAFT/REB/ClkHPS_V} REB CLK_H PS voltage 
CLKHPS_I       Float   ${focal-plane/RAFT/REB/ClkHPS_I} REB CLK_H PS current 
ODPS_V         Float   ${focal-plane/RAFT/REB/ODPS_V}  REB OD PS voltage 
ODPS_I         Float   ${focal-plane/RAFT/REB/ODPS_I}  REB OD PS current 
HTRPS_V        Float   ${focal-plane/RAFT/REB/HtrPS_V} REB Heater PS voltage 
HTRPS_I        Float   ${focal-plane/RAFT/REB/HtrPS_I} REB Heater PS current 
#
CKPSH_V        Float   ${focal-plane/RAFT/REB/CKPSH_V} REB clock rails CKP_SH Voltage
CKS_V          Float   ${focal-plane/RAFT/REB/CKS_V}   REB clock rails CKS Voltage
SCKU_V         Float   ${focal-plane/RAFT/REB/SCKU_V}  REB clock rails SCK_U Voltage
CSKL_V         Float   ${focal-plane/RAFT/REB/SCKL_V}  REB clock rails SCK_L Voltage
RG_V           Float   ${focal-plane/RAFT/REB/RG_V}    REB clock rails RG Voltage
RGU_V          Float   ${focal-plane/RAFT/REB/RGU_V}   REB clock rails RG_U Voltage
RGL_V          Float   ${focal-plane/RAFT/REB/RGL_V}   REB clock rails RG_L Voltage
CKP0_V         Float   ${focal-plane/RAFT/REB/CKP0V}   REB clock rails CKP 0 Voltage
CKS0_V         Float   ${focal-plane/RAFT/REB/CKS0V}   REB clock rails CKS 0 Voltage
RG0_V          Float   ${focal-plane/RAFT/REB/RG0V}    REB clock rails RG 0 Voltage
#
ODOV           Float   ${focal-plane/RAFT/REB/OD0V}    REB bias OD voltage
OGOV           Float   ${focal-plane/RAFT/REB/OG0V}    REB bias OG voltage
RD0V           Float   ${focal-plane/RAFT/REB/RD0V}    REB bias RD voltage
RG0V           Float   ${focal-plane/RAFT/REB/GD0V}    REB bias GD voltae
ODOI           Float   ${focal-plane/RAFT/REB/OD0I}    REB bias OD current
#
GDP            Float   ${focal-plane/RAFT/REB/Bias0/gdP}    REB config bias GD (requested)  
GD             Integer ${focal-plane/RAFT/REB/Bias0/gd}     REB config bias GD (applied)
RDP            Float   ${focal-plane/RAFT/REB/Bias0/rdP}    REB config bias RD (requested)  
RD             Integer ${focal-plane/RAFT/REB/Bias0/rd}     REB config bias RD (applied)
OGP            Float   ${focal-plane/RAFT/REB/Bias0/ogP}    REB config bias OG (requested)  
OG             Integer ${focal-plane/RAFT/REB/Bias0/og}     REB config bias OG (applied)
ODP            Float   ${focal-plane/RAFT/REB/Bias0/odP}    REB config bias OD (requested)  
OD             Integer ${focal-plane/RAFT/REB/Bias0/od}     REB config bias OD (applied)
CSGATEP        Float   ${focal-plane/RAFT/REB/Bias0/csGateP} REB config bias CS gate (requested)  
CSGATE         Integer ${focal-plane/RAFT/REB/Bias0/csGate}  REB config bias CS gate (applied)
#
AP0_RC         Integer ${focal-plane/RAFT/REB/ASPIC0/rc}    REB ASPIC 0 RC
AP1_RC         Integer ${focal-plane/RAFT/REB/ASPIC1/rc}    REB ASPIC 1 RC 
AP0_GAIN       Integer ${focal-plane/RAFT/REB/ASPIC0/gain}  REB ASPIC 0 gain
AP1_GAIN       Integer ${focal-plane/RAFT/REB/ASPIC1/gain}  REB ASPIC 1 gain
AP0_CLMP       Integer ${focal-plane/RAFT/REB/ASPIC0/clamp} REB ASPIC 0 clamp
AP1_CLMP       Integer ${focal-plane/RAFT/REB/ASPIC1/clamp} REB ASPIC 1 clamp
AP0_AF1        Integer ${focal-plane/RAFT/REB/ASPIC0/af1}    REB ASPIC 0 af1
AP1_AF1        Integer ${focal-plane/RAFT/REB/ASPIC1/af1}    REB ASPIC 1 af1
#
SCK_LOWP       Float   ${focal-plane/RAFT/REB/DAC/sclkLowP}   REB DAC SCLK Low (requested)
SCK_LOW        Integer ${focal-plane/RAFT/REB/DAC/sclkLow}    REB DAC SCLK Low (applied)
SCK_HIP        Float   ${focal-plane/RAFT/REB/DAC/sclkHighP}  REB DAC SCLK High (requested)
SCK_HI         Integer ${focal-plane/RAFT/REB/DAC/sclkHigh}   REB DAC SCLK High (applied)
PCK_LOWP       Float   ${focal-plane/RAFT/REB/DAC/pclkLowP}   REB DAC PCLK Low (requested)
PCK_LOW        Integer ${focal-plane/RAFT/REB/DAC/pclkLow}    REB DAC PCLK Low (applied)
PCK_HIP        Float   ${focal-plane/RAFT/REB/DAC/pclkHighP}  REB DAC PCLK High (requested)
PCK_HI         Integer ${focal-plane/RAFT/REB/DAC/pclkHigh}   REB DAC PCLK High (applied)
RG_LOWP        Float   ${focal-plane/RAFT/REB/DAC/rgLowP}     REB DAC RG Low (requested)
RG_LOW         Integer ${focal-plane/RAFT/REB/DAC/rgLow}      REB DAC RG Low (applied)
RG_HIP         Float   ${focal-plane/RAFT/REB/DAC/rgHighP}    REB DAC RG High (requested)
RG_HI          Integer ${focal-plane/RAFT/REB/DAC/rgHigh}     REB DAC RG High (applied)
