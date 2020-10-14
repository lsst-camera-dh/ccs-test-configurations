EXTNAME        String  "REB_COND"                 Name of the extension
# REB board temperatures and sensor temperature
TEMP1          Float   ${focal-plane/${RAFT}/${REB}/Temp1} REB Board temperature 1
TEMP2          Float   ${focal-plane/${RAFT}/${REB}/Temp2} REB Board temperature 2
TEMP3          Float   ${focal-plane/${RAFT}/${REB}/Temp3} REB Board temperature 3
TEMP4          Float   ${focal-plane/${RAFT}/${REB}/Temp4} REB Board temperature 4
TEMP5          Float   ${focal-plane/${RAFT}/${REB}/Temp5} REB Board temperature 5
TEMP6          Float   ${focal-plane/${RAFT}/${REB}/Temp6} REB Board temperature 6
TEMP7          Float   ${focal-plane/${RAFT}/${REB}/Temp7} REB Board temperature 7
TEMP8          Float   ${focal-plane/${RAFT}/${REB}/Temp8} REB Board temperature 8
TEMP9          Float   ${focal-plane/${RAFT}/${REB}/Temp9} REB Board temperature 9
TEMP10         Float   ${focal-plane/${RAFT}/${REB}/Temp10} REB Board temperature 10
ATEMPU         Float   ${focal-plane/${RAFT}/${REB}/AspicU/Temp0} ASPIC 0 upper temperature
ATEMPL         Float   ${focal-plane/${RAFT}/${REB}/AspicL/Temp0} ASPIC 0 lower temperature
CCDTEMP        Float   ${focal-plane/${RAFT}/${REB}/${CCD_TRENDING}/Temp} CCD temperature
RTDTEMP        Float   ${focal-plane/${RAFT}/${REB}/RTDTemp} RTD temperature
# Incoming voltages and curent from the REB PS as measured by the REB
DIGPS_V        Float   ${focal-plane/${RAFT}/${REB}/DigV} REB Digital PS voltage 
DIGPS_I        Float   ${focal-plane/${RAFT}/${REB}/DigI} REB Digital PS current 
ANAPS_V        Float   ${focal-plane/${RAFT}/${REB}/AnaV} REB Analog PS voltage 
ANAPS_I        Float   ${focal-plane/${RAFT}/${REB}/AnaI} REB Analog PS current 
CLKHPS_V       Float   ${focal-plane/${RAFT}/${REB}/ClkHV} REB CLK_H PS voltage 
CLKHPS_I       Float   ${focal-plane/${RAFT}/${REB}/ClkHI} REB CLK_H PS current 
CLKLPS_V       Float   ${focal-plane/${RAFT}/${REB}/ClkLV} REB CLK_L PS voltage 
CLKLPS_I       Float   ${focal-plane/${RAFT}/${REB}/ClkLI} REB CLK_L PS current 
ODPS_V         Float   ${focal-plane/${RAFT}/${REB}/ODV}  REB OD PS voltage 
ODPS_I         Float   ${focal-plane/${RAFT}/${REB}/ODI}  REB OD PS current 
HTRPS_V        Float   ${focal-plane/${RAFT}/${REB}/HtrV} REB Heater PS voltage 
HTRPS_W        Float   ${focal-plane/${RAFT}/${REB}/HtrW} REB Heater PS power 
# measurements of serial, parallel and RG clock rails
PCKU_V         Float   ${focal-plane/${RAFT}/${REB}/PClkU}  REB clock rails PCK_U Voltage
PCKL_V         Float   ${focal-plane/${RAFT}/${REB}/PClkL}  REB clock rails PCK_L Voltage
SCKU_V         Float   ${focal-plane/${RAFT}/${REB}/SClkU}  REB clock rails SCK_U Voltage
SCKL_V         Float   ${focal-plane/${RAFT}/${REB}/SClkL}  REB clock rails SCK_L Voltage
RGU_V          Float   ${focal-plane/${RAFT}/${REB}/RGU}   REB clock rails RG_U Voltage
RGL_V          Float   ${focal-plane/${RAFT}/${REB}/RGL}   REB clock rails RG_L Voltage
# measurements of the front biases
# voltages
ODV           Float   ${focal-plane/${RAFT}/${REB}/${CCD_TRENDING}/ODV}    REB bias OD voltage
OGV           Float   ${focal-plane/${RAFT}/${REB}/${CCD_TRENDING}/OGV}    REB bias OG voltage
RDV           Float   ${focal-plane/${RAFT}/${REB}/${CCD_TRENDING}/RDV}    REB bias RD voltage
GDV           Float   ${focal-plane/${RAFT}/${REB}/${CCD_TRENDING}/GDV}    REB bias GD voltage
# current
ODI           Float   ${focal-plane/${RAFT}/${REB}/${CCD_TRENDING}/ODI}    REB bias OD current
# configuration values for front biases
GDP            Float   ${focal-plane/${RAFT}/${REB}/Bias0/gdP}    REB config bias GD (requested)  
RDP            Float   ${focal-plane/${RAFT}/${REB}/Bias0/rdP}    REB config bias RD (requested)  
OGP            Float   ${focal-plane/${RAFT}/${REB}/Bias0/ogP}    REB config bias OG (requested)  
ODP            Float   ${focal-plane/${RAFT}/${REB}/Bias0/odP}    REB config bias OD (requested)  
CSGATEP        Float   ${focal-plane/${RAFT}/${REB}/Bias0/csGateP} REB config bias CS gate (requested)  
# configuration values for clock rails
SCK_LOWP       Float   ${focal-plane/${RAFT}/${REB}/DAC/sclkLowP}   REB DAC SCLK Low (requested)
SCK_HIP        Float   ${focal-plane/${RAFT}/${REB}/DAC/sclkHighP}  REB DAC SCLK High (requested)
PCK_LOWP       Float   ${focal-plane/${RAFT}/${REB}/DAC/pclkLowP}   REB DAC PCLK Low (requested)
PCK_HIP        Float   ${focal-plane/${RAFT}/${REB}/DAC/pclkHighP}  REB DAC PCLK High (requested)
RG_LOWP        Float   ${focal-plane/${RAFT}/${REB}/DAC/rgLowP}     REB DAC RG Low (requested)
RG_HIP         Float   ${focal-plane/${RAFT}/${REB}/DAC/rgHighP}    REB DAC RG High (requested)
# ASPIC settings
AP0_RC         Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC0/rc}    CCD ASPIC 0 RC
AP1_RC         Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC1/rc}    CCD ASPIC 1 RC 
AP0_GAIN       Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC0/gain}  CCD ASPIC 0 gain
AP1_GAIN       Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC1/gain}  CCD ASPIC 1 gain
AP0_CLMP       Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC0/clamp} CCD ASPIC 0 clamp
AP1_CLMP       Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC1/clamp} CCD ASPIC 1 clamp
AP0_AF1        Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC0/af1}    CCD ASPIC 0 af1
AP1_AF1        Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC1/af1}    CCD ASPIC 1 af1
AP0_TM         Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC0/tm}    CCD ASPIC 0 Transparent Mode
AP1_TM         Integer ${focal-plane/${RAFT}/${REB}/${CCD}/ASPIC1/tm}    CCD ASPIC 1 Transparent Mode
# OFF/ON state of HV bias switch (ON :: closed)
HVBIAS         String  ${focal-plane/${RAFT}/${REB}/HVBiasState}    REB HVBias Switch state
# Idle_flush state
IDLEFLSH       Integer ${focal-plane/sequencerConfig/idleFlushTimeout} IDLE FLUSH setting


## Information coming from the rebpower subsystem
POWER     Float   ${rebpower/${RAFT}/${REB}/Power}            Total REB PS power
DIGVB     Float   ${rebpower/${RAFT}/${REB}/digital/VbefLDO}  REB PS Digi Voltage before LDO         
DIGIB     Float   ${rebpower/${RAFT}/${REB}/digital/IbefLDO}	 REB PS Digi Current before LDO         
DIGVA     Float   ${rebpower/${RAFT}/${REB}/digital/VaftLDO}	 REB PS Digi Voltage after LDO          
DIGIA     Float   ${rebpower/${RAFT}/${REB}/digital/IaftLDO}	 REB PS Digi Current after LDO        
DIGVS     Float   ${rebpower/${RAFT}/${REB}/digital/VaftSwch} REB PS Digi Voltage after Switch      
ANAVB     Float   ${rebpower/${RAFT}/${REB}/analog/VbefLDO}	 REB PS Ana Voltage before LDO          
ANAIB     Float   ${rebpower/${RAFT}/${REB}/analog/IbefLDO}	 REB PS Ana Current before LDO          
ANAVA     Float   ${rebpower/${RAFT}/${REB}/analog/VaftLDO}	 REB PS Ana Voltage after LDO           
ANAIA     Float   ${rebpower/${RAFT}/${REB}/analog/IaftLDO}	 REB PS Ana  Current after LDO         
ANAIS     Float   ${rebpower/${RAFT}/${REB}/analog/VaftSwch}	 REB PS Ana Voltage after Switch       
ODVB      Float   ${rebpower/${RAFT}/${REB}/OD/VbefLDO}	 REB PS OD Voltage before LDO           
ODIB      Float   ${rebpower/${RAFT}/${REB}/OD/IbefLDO}	 REB PS OD Current before LDO           
ODVA      Float   ${rebpower/${RAFT}/${REB}/OD/VaftLDO}	 REB PS OD Voltage after LDO            
ODVA2     Float   ${rebpower/${RAFT}/${REB}/OD/VaftLDO2}	 REB PS OD Voltage after LDO2           
ODIA      Float   ${rebpower/${RAFT}/${REB}/OD/IaftLDO}	 REB PS OD Current after LDO            
ODVS      Float   ${rebpower/${RAFT}/${REB}/OD/VaftSwch}	 REB PS OD Voltage after Switch         
CKHVB     Float   ${rebpower/${RAFT}/${REB}/clockhi/VbefLDO}	 REB PS Clk HI Voltage before LDO       
CKHIB     Float   ${rebpower/${RAFT}/${REB}/clockhi/IbefLDO}	 REB PS Clk HI Current before LDO       
CKHVA     Float   ${rebpower/${RAFT}/${REB}/clockhi/VaftLDO}	 REB PS Clk HI Voltage after LDO        
CKHIA     Float   ${rebpower/${RAFT}/${REB}/clockhi/IaftLDO}	 REB PS Clk HI Current after LDO       
CKHVS     Float   ${rebpower/${RAFT}/${REB}/clockhi/VaftSwch} REB PS Clk HI Voltage after Switch     
CKLVB     Float   ${rebpower/${RAFT}/${REB}/clocklo/VbefLDO}	 REB PS Clk LO Voltage before LDO       
CKLIB     Float   ${rebpower/${RAFT}/${REB}/clocklo/IbefLDO}	 REB PS Clk LO Current before LDO       
CKLVA     Float   ${rebpower/${RAFT}/${REB}/clocklo/VaftLDO}	 REB PS Clk LO Voltage after LDO        
CKLV2     Float   ${rebpower/${RAFT}/${REB}/clocklo/VaftLDO2} REB PS Clk LO Voltage after LDO2       
CKLIA     Float   ${rebpower/${RAFT}/${REB}/clocklo/IaftLDO}	 REB PS Clk LO Current after LDO        
CKLVS     Float   ${rebpower/${RAFT}/${REB}/clocklo/VaftSwch} REB PS Clk LO Voltage after Switch     
HTRVB     Float   ${rebpower/${RAFT}/${REB}/heater/VbefLDO}	 REB PS Clk Heater Voltage before LDO   
HTRIB     Float   ${rebpower/${RAFT}/${REB}/heater/IbefLDO}	 REB PS Clk Heater Current before LDO   
HTRVA     Float   ${rebpower/${RAFT}/${REB}/heater/VaftLDO}	 REB PS Clk Heater Voltage after LDO    
HTRIA     Float   ${rebpower/${RAFT}/${REB}/heater/IaftLDO}	 REB PS Clk Heater Current after LDO   
HTRVAS    Float   ${rebpower/${RAFT}/${REB}/heater/VaftSwch}	 REB PS Clk Heater Voltage after Switch
BSSVBS    Float   ${rebpower/${RAFT}/${REB}/hvbias/VbefSwch}	 REB PS HV Bias Voltage before Switch   
BSSIBS    Float   ${rebpower/${RAFT}/${REB}/hvbias/IbefSwch}	 REB PS HV Bias Current before Switch   
