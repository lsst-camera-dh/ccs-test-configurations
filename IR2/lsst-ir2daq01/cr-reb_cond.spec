# Specification file for reb_cond header.
#
EXTNAME     String  "REB_COND"                 Name of the extension
######################################################
R0POWER     Float   ${StatusAggregator.cr-rebps/WREB.Power} Total REB0 power
R0DIGVB     Float   ${StatusAggregator.cr-rebps/WREB.digital.VbefLDO}   REB0 Digi Voltage before LDO         
R0DIGIB     Float   ${StatusAggregator.cr-rebps/WREB.digital.IbefLDO}	REB0 Digi Current before LDO         
R0DIGVA     Float   ${StatusAggregator.cr-rebps/WREB.digital.VaftLDO}	REB0 Digi Voltage after LDO          
R0DIGIA     Float   ${StatusAggregator.cr-rebps/WREB.digital.IaftLDO}	REB0 Digi Current after LDO        
R0DIGVS     Float   ${StatusAggregator.cr-rebps/WREB.digital.VaftSwch}	REB0 Digi Voltage after Switch      
R0ANAVB     Float   ${StatusAggregator.cr-rebps/WREB.analog.VbefLDO}	REB0 Ana Voltage before LDO          
R0ANAIB     Float   ${StatusAggregator.cr-rebps/WREB.analog.IbefLDO}	REB0 Ana Current before LDO          
R0ANAVA     Float   ${StatusAggregator.cr-rebps/WREB.analog.VaftLDO}	REB0 Ana Voltage after LDO           
R0ANAIA     Float   ${StatusAggregator.cr-rebps/WREB.analog.IaftLDO}	REB0 Ana  Current after LDO         
R0ANAIS     Float   ${StatusAggregator.cr-rebps/WREB.analog.VaftSwch}	REB0 Ana Voltage after Switch       
R0ODVB      Float   ${StatusAggregator.cr-rebps/WREB.OD.VbefLDO}	REB0 OD Voltage before LDO           
R0ODIB      Float   ${StatusAggregator.cr-rebps/WREB.OD.IbefLDO}	REB0 OD Current before LDO           
R0ODVA      Float   ${StatusAggregator.cr-rebps/WREB.OD.VaftLDO}	REB0 OD Voltage after LDO            
R0ODVA2     Float   ${StatusAggregator.cr-rebps/WREB.OD.VaftLDO2}	REB0 OD Voltage after LDO2           
R0ODIA      Float   ${StatusAggregator.cr-rebps/WREB.OD.IaftLDO}	REB0 OD Current after LDO            
R0ODVS      Float   ${StatusAggregator.cr-rebps/WREB.OD.VaftSwch}	REB0 OD Voltage after Switch         
R0CKHVB     Float   ${StatusAggregator.cr-rebps/WREB.clockhi.VbefLDO}	REB0 Clk HI Voltage before LDO       
R0CKHIB     Float   ${StatusAggregator.cr-rebps/WREB.clockhi.IbefLDO}	REB0 Clk HI Current before LDO       
R0CKHVA     Float   ${StatusAggregator.cr-rebps/WREB.clockhi.VaftLDO}	REB0 Clk HI Voltage after LDO        
R0CKHIA     Float   ${StatusAggregator.cr-rebps/WREB.clockhi.IaftLDO}	REB0 Clk HI Current after LDO       
R0CKHVS     Float   ${StatusAggregator.cr-rebps/WREB.clockhi.VaftSwch}	REB0 Clk HI Voltage after Switch     
R0CKLVB     Float   ${StatusAggregator.cr-rebps/WREB.clocklo.VbefLDO}	REB0 Clk LO Voltage before LDO       
R0CKLIB     Float   ${StatusAggregator.cr-rebps/WREB.clocklo.IbefLDO}	REB0 Clk LO Current before LDO       
R0CKLVA     Float   ${StatusAggregator.cr-rebps/WREB.clocklo.VaftLDO}	REB0 Clk LO Voltage after LDO        
R0CKLV2     Float   ${StatusAggregator.cr-rebps/WREB.clocklo.VaftLDO2}	REB0 Clk LO Voltage after LDO2       
R0CKLIA     Float   ${StatusAggregator.cr-rebps/WREB.clocklo.IaftLDO}	REB0 Clk LO Current after LDO        
R0CKLVA     Float   ${StatusAggregator.cr-rebps/WREB.clocklo.VaftSwch}	REB0 Clk LO Voltage after Switch     
R0DPHIVB    Float   ${StatusAggregator.cr-rebps/WREB.dphi.VbefLDO}	REB0 DPHI Voltage before LDO       
R0DPHIIB    Float   ${StatusAggregator.cr-rebps/WREB.dphi.IbefLDO}	REB0 DPHI Current before LDO       
R0DPHIVA    Float   ${StatusAggregator.cr-rebps/WREB.dphi.VaftLDO}	REB0 DPHI Voltage after LDO        
R0DPHIIA    Float   ${StatusAggregator.cr-rebps/WREB.dphi.IaftLDO}	REB0 DPHI Current after LDO       
R0DPHIVS    Float   ${StatusAggregator.cr-rebps/WREB.dphi.VaftSwch}	REB0 DPHI Voltage after Switch     
R0HTRVB     Float   ${StatusAggregator.cr-rebps/WREB.heater.VbefLDO}	REB0 Clk Heater Voltage before LDO   
R0HTRIB     Float   ${StatusAggregator.cr-rebps/WREB.heater.IbefLDO}	REB0 Clk Heater Current before LDO   
R0HTRVA     Float   ${StatusAggregator.cr-rebps/WREB.heater.VaftLDO}	REB0 Clk Heater Voltage after LDO    
R0HTRIA     Float   ${StatusAggregator.cr-rebps/WREB.heater.IaftLDO}	REB0 Clk Heater Current after LDO   
R0HTRVAS    Float   ${StatusAggregator.cr-rebps/WREB.heater.VaftSwch}	REB0 Clk Heater Voltage after Switch
R0BSSVBS    Float   ${StatusAggregator.cr-rebps/WREB.hvbias.VbefSwch}	REB0 HV Bias Voltage before Switch   
R0BSSIBS    Float   ${StatusAggregator.cr-rebps/WREB.hvbias.IbefSwch}	REB0 HV Bias Current before Switch   
######################################################
R1POWER     Float   ${StatusAggregator.cr-rebps/GREB.Power} Total REB1 power
R1DIGVB     Float   ${StatusAggregator.cr-rebps/GREB.digital.VbefLDO}   REB1 Digi Voltage before LDO         
R1DIGIB     Float   ${StatusAggregator.cr-rebps/GREB.digital.IbefLDO}	REB1 Digi Current before LDO         
R1DIGVA     Float   ${StatusAggregator.cr-rebps/GREB.digital.VaftLDO}	REB1 Digi Voltage after LDO          
R1DIGIA     Float   ${StatusAggregator.cr-rebps/GREB.digital.IaftLDO}	REB1 Digi Current after LDO        
R1DIGVS     Float   ${StatusAggregator.cr-rebps/GREB.digital.VaftSwch}	REB1 Digi Voltage after Switch      
R1ANAVB     Float   ${StatusAggregator.cr-rebps/GREB.analog.VbefLDO}	REB1 Ana Voltage before LDO          
R1ANAIB     Float   ${StatusAggregator.cr-rebps/GREB.analog.IbefLDO}	REB1 Ana Current before LDO          
R1ANAVA     Float   ${StatusAggregator.cr-rebps/GREB.analog.VaftLDO}	REB1 Ana Voltage after LDO           
R1ANAIA     Float   ${StatusAggregator.cr-rebps/GREB.analog.IaftLDO}	REB1 Ana  Current after LDO         
R1ANAIS     Float   ${StatusAggregator.cr-rebps/GREB.analog.VaftSwch}	REB1 Ana Voltage after Switch       
R1ODVB      Float   ${StatusAggregator.cr-rebps/GREB.OD.VbefLDO}	REB1 OD Voltage before LDO           
R1ODIB      Float   ${StatusAggregator.cr-rebps/GREB.OD.IbefLDO}	REB1 OD Current before LDO           
R1ODVA      Float   ${StatusAggregator.cr-rebps/GREB.OD.VaftLDO}	REB1 OD Voltage after LDO            
R1ODVA2     Float   ${StatusAggregator.cr-rebps/GREB.OD.VaftLDO2}	REB1 OD Voltage after LDO2           
R1ODIA      Float   ${StatusAggregator.cr-rebps/GREB.OD.IaftLDO}	REB1 OD Current after LDO            
R1ODVS      Float   ${StatusAggregator.cr-rebps/GREB.OD.VaftSwch}	REB1 OD Voltage after Switch         
R1CKHVB     Float   ${StatusAggregator.cr-rebps/GREB.clockhi.VbefLDO}	REB1 Clk HI Voltage before LDO       
R1CKHIB     Float   ${StatusAggregator.cr-rebps/GREB.clockhi.IbefLDO}	REB1 Clk HI Current before LDO       
R1CKHVA     Float   ${StatusAggregator.cr-rebps/GREB.clockhi.VaftLDO}	REB1 Clk HI Voltage after LDO        
R1CKHIA     Float   ${StatusAggregator.cr-rebps/GREB.clockhi.IaftLDO}	REB1 Clk HI Current before LDO       
R1CKHVS     Float   ${StatusAggregator.cr-rebps/GREB.clockhi.VaftSwch}	REB1 Clk HI Voltage after Switch     
R1CKLVB     Float   ${StatusAggregator.cr-rebps/GREB.clocklo.VbefLDO}	REB1 Clk LO Voltage before LDO       
R1CKLIB     Float   ${StatusAggregator.cr-rebps/GREB.clocklo.IbefLDO}	REB1 Clk LO Current before LDO       
R1CKLVA     Float   ${StatusAggregator.cr-rebps/GREB.clocklo.VaftLDO}	REB1 Clk LO Voltage after LDO        
R1CKLV2     Float   ${StatusAggregator.cr-rebps/GREB.clocklo.VaftLDO2}	REB1 Clk LO Voltage after LDO2       
R1CKLIA     Float   ${StatusAggregator.cr-rebps/GREB.clocklo.IaftLDO}	REB1 Clk LO Current after LDO        
R1CKLVA     Float   ${StatusAggregator.cr-rebps/GREB.clocklo.VaftSwch}	REB1 Clk LO Voltage after Switch     
R1DPHIVB    Float   ${StatusAggregator.cr-rebps/GREB.dphi.VbefLDO}	REB1 DPHI Voltage before LDO       
R1DPHIIB    Float   ${StatusAggregator.cr-rebps/GREB.dphi.IbefLDO}	REB1 DPHI Current before LDO       
R1DPHIVA    Float   ${StatusAggregator.cr-rebps/GREB.dphi.VaftLDO}	REB1 DPHI Voltage after LDO        
R1DPHIIA    Float   ${StatusAggregator.cr-rebps/GREB.dphi.IaftLDO}	REB1 DPHI Current after LDO       
R1DPHIVS    Float   ${StatusAggregator.cr-rebps/GREB.dphi.VaftSwch}	REB1 DPHI Voltage after Switch     
R1HTRVB     Float   ${StatusAggregator.cr-rebps/GREB.heater.VbefLDO}	REB1 Clk Heater Voltage before LDO   
R1HTRIB     Float   ${StatusAggregator.cr-rebps/GREB.heater.IbefLDO}	REB1 Clk Heater Current before LDO   
R1HTRVA     Float   ${StatusAggregator.cr-rebps/GREB.heater.VaftLDO}	REB1 Clk Heater Voltage after LDO    
R1HTRIA     Float   ${StatusAggregator.cr-rebps/GREB.heater.IaftLDO}	REB1 Clk Heater Current after LDO   
R1HTRVAS    Float   ${StatusAggregator.cr-rebps/GREB.heater.VaftSwch}	REB1 Clk Heater Voltage after Switch
R1BSSVBS    Float   ${StatusAggregator.cr-rebps/GREB.hvbias.VbefSwch}	REB1 HV Bias Voltage before Switch   
R1BSSIBS    Float   ${StatusAggregator.cr-rebps/GREB.hvbias.IbefSwch}	REB1 HV Bias Current before Switch   
#
#          Reb                         0      WREB
R0TEMP1    Float    ${StatusAggregator.cr-raft/WREB.Temp1}   Board temperature 1 
R0TEMP2    Float    ${StatusAggregator.cr-raft/WREB.Temp2}   Board temperature 2 
R0TEMP3    Float    ${StatusAggregator.cr-raft/WREB.Temp3}   Board temperature 3 
R0TEMP4    Float    ${StatusAggregator.cr-raft/WREB.Temp4}   Board temperature 4 
R0TEMP5    Float    ${StatusAggregator.cr-raft/WREB.Temp5}   Board temperature 5 
R0TEMP6    Float    ${StatusAggregator.cr-raft/WREB.Temp6}   Board temperature 6 
R0ATMP0U   Float    ${StatusAggregator.cr-raft/WREB.Atemp0U}   ASPIC 0 upper temp
R0ATMP0L   Float    ${StatusAggregator.cr-raft/WREB.Atemp0L}   ASPIC 0 lower temp
R0CCDT0    Float    ${StatusAggregator.cr-raft/WREB.CCDTemp0}   CCD 0 temperature 
R0RTDT     Float    ${StatusAggregator.cr-raft/WREB.RTDTemp}   RTD temperature  
R0HTRV     Float    ${StatusAggregator.cr-raft/WREB.HtrV}   Heater voltage  
R0HTRI     Float    ${StatusAggregator.cr-raft/WREB.HtrI}   Heater current
R0HTRW     Float    ${StatusAggregator.cr-raft/WREB.HtrW}   Heater power
R0DIGV     Float    ${StatusAggregator.cr-raft/WREB.DigV}   Digital PS voltage 
R0DIGI     Float    ${StatusAggregator.cr-raft/WREB.DigI}   Digital PS current 
R0ANAV     Float    ${StatusAggregator.cr-raft/WREB.AnaV}   Analog PS voltage 
R0ANAI     Float    ${StatusAggregator.cr-raft/WREB.AnaI}   Analog PS current 
R0CLKV     Float    ${StatusAggregator.cr-raft/WREB.ClkV}   Clock PS voltage 
R0CLKI     Float    ${StatusAggregator.cr-raft/WREB.ClkI}   Clock PS current 
R0CLKHV    Float    ${StatusAggregator.cr-raft/WREB.ClkHV}   Clock High PS voltage 
R0CLKHI    Float    ${StatusAggregator.cr-raft/WREB.ClkHI}   Clock High PS current 
R0CLKLV    Float    ${StatusAggregator.cr-raft/WREB.ClkLV}   Clock Low PS voltage 
R0CLKLI    Float    ${StatusAggregator.cr-raft/WREB.ClkLI}   Clock Low PS current 
R0ODV      Float    ${StatusAggregator.cr-raft/WREB.ODV}   OD PS voltage 
R0ODI      Float    ${StatusAggregator.cr-raft/WREB.ODI}   OD PS current 
R0PCLKU    Float    ${StatusAggregator.cr-raft/WREB.PClkU}   Parallel upper  
R0PCLKL    Float    ${StatusAggregator.cr-raft/WREB.PClkL}   Parallel lower  
R0SCLKU    Float    ${StatusAggregator.cr-raft/WREB.SClkU}   Serial upper  
R0SCLKL    Float    ${StatusAggregator.cr-raft/WREB.SClkL}   Serial lower  
R0RGU      Float    ${StatusAggregator.cr-raft/WREB.RGU}   Reset gate upper 
R0RGL      Float    ${StatusAggregator.cr-raft/WREB.RGL}   Reset gate lower  
R0OD0V     Float    ${StatusAggregator.cr-raft/WREB.OD0V}   OD 0 voltage 
R0OG0V     Float    ${StatusAggregator.cr-raft/WREB.OG0V}   OG 0 voltage 
R0RD0V     Float    ${StatusAggregator.cr-raft/WREB.RD0V}   RD 0 voltage 
R0GD0V     Float    ${StatusAggregator.cr-raft/WREB.GD0V}   GD 0 voltage 
R0OD0I     Float    ${StatusAggregator.cr-raft/WREB.OD0I}   CCD OD current
#          Reb                         1      GREB
R1TEMP1    Float    ${StatusAggregator.cr-raft/GREB.Temp1}   Board temperature 1 
R1TEMP2    Float    ${StatusAggregator.cr-raft/GREB.Temp2}   Board temperature 2 
R1TEMP3    Float    ${StatusAggregator.cr-raft/GREB.Temp3}   Board temperature 3 
R1TEMP4    Float    ${StatusAggregator.cr-raft/GREB.Temp4}   Board temperature 4 
R1TEMP5    Float    ${StatusAggregator.cr-raft/GREB.Temp5}   Board temperature 5 
R1TEMP6    Float    ${StatusAggregator.cr-raft/GREB.Temp6}   Board temperature 6 
R1TEMP7    Float    ${StatusAggregator.cr-raft/GREB.Temp7}   Board temperature 7 
R1TEMP8    Float    ${StatusAggregator.cr-raft/GREB.Temp8}   Board temperature 8 
R1TEMP9    Float    ${StatusAggregator.cr-raft/GREB.Temp9}   Board temperature 9 
R1TEMP10   Float    ${StatusAggregator.cr-raft/GREB.Temp10}   Board temperature 10 
R1ATMP0U   Float    ${StatusAggregator.cr-raft/GREB.Atemp0U}   ASPIC 0 upper temp
R1ATMP0L   Float    ${StatusAggregator.cr-raft/GREB.Atemp0L}   ASPIC 0 lower temp
R1ATMP1U   Float    ${StatusAggregator.cr-raft/GREB.Atemp1U}   ASPIC 1 upper temp
R1ATMP1L   Float    ${StatusAggregator.cr-raft/GREB.Atemp1L}   ASPIC 1 lower temp
R1CCDT0    Float    ${StatusAggregator.cr-raft/GREB.CCDTemp0}   CCD 0 temperature 
R1CCDT1    Float    ${StatusAggregator.cr-raft/GREB.CCDTemp1}   CCD 1 temperature 
R1RTDT     Float    ${StatusAggregator.cr-raft/GREB.RTDTemp}   RTD temperature  
R1HTRV     Float    ${StatusAggregator.cr-raft/GREB.HtrV}   Heater voltage  
R1HTRI     Float    ${StatusAggregator.cr-raft/GREB.HtrI}   Heater current
R1HTRW     Float    ${StatusAggregator.cr-raft/GREB.HtrW}   Heater power  
R1DIGV     Float    ${StatusAggregator.cr-raft/GREB.DigV}   Digital PS voltage 
R1DIGI     Float    ${StatusAggregator.cr-raft/GREB.DigI}   Digital PS current 
R1ANAV     Float    ${StatusAggregator.cr-raft/GREB.AnaV}   Analog PS voltage 
R1ANAI     Float    ${StatusAggregator.cr-raft/GREB.AnaI}   Analog PS current 
R1CLKHV    Float    ${StatusAggregator.cr-raft/GREB.ClkHV}   Clock High PS voltage 
R1CLKHI    Float    ${StatusAggregator.cr-raft/GREB.ClkHI}   Clock High PS current 
R1CLKLV    Float    ${StatusAggregator.cr-raft/GREB.ClkLV}   Clock Low PS voltage 
R1CLKLI    Float    ${StatusAggregator.cr-raft/GREB.ClkLI}   Clock Low PS current 
R1ODV      Float    ${StatusAggregator.cr-raft/GREB.ODV}   OD PS voltage 
R1ODI      Float    ${StatusAggregator.cr-raft/GREB.ODI}   OD PS current 
R1PCLKU    Float    ${StatusAggregator.cr-raft/GREB.PClkU}   Parallel upper  
R1PCLKL    Float    ${StatusAggregator.cr-raft/GREB.PClkL}   Parallel lower  
R1SCLKU    Float    ${StatusAggregator.cr-raft/GREB.SClkU}   Serial upper  
R1SCLKL    Float    ${StatusAggregator.cr-raft/GREB.SClkL}   Serial lower  
R1RGU      Float    ${StatusAggregator.cr-raft/GREB.RGU}   Reset gate upper 
R1RGL      Float    ${StatusAggregator.cr-raft/GREB.RGL}   Reset gate lower 
R1OD0V     Float    ${StatusAggregator.cr-raft/GREB.OD0V}   OD 0 voltage 
R1OG0V     Float    ${StatusAggregator.cr-raft/GREB.OG0V}   OG 0 voltage 
R1RD0V     Float    ${StatusAggregator.cr-raft/GREB.RD0V}   RD 0 voltage 
R1GD0V     Float    ${StatusAggregator.cr-raft/GREB.GD0V}   GD 0 voltage 
R1OD0I     Float    ${StatusAggregator.cr-raft/GREB.OD0I}   CCD 0 OD current
R1OD1V     Float    ${StatusAggregator.cr-raft/GREB.OD1V}   OD 1 voltage 
R1OG1V     Float    ${StatusAggregator.cr-raft/GREB.OG1V}   OG 1 voltage 
R1RD1V     Float    ${StatusAggregator.cr-raft/GREB.RD1V}   RD 1 voltage 
R1GD1V     Float    ${StatusAggregator.cr-raft/GREB.GD1V}   GD 1 voltage 
R1OD1I     Float    ${StatusAggregator.cr-raft/GREB.OD1I}   CCD 1 OD current
