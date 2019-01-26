# Specification file for primary header. Taken from LCA 10140 v1.
# Modified for use with focal-plane
#
HEADVER     Integer 2                           Version number of header
ORIGIN      String  ${Origin}                   Which site acquired the data
DATE        Date    ${FileCreationTime}         Creation Date and Time of File
DATE-OBS    Date    ${ObservationDate}          Date of the observation (image acquisition), UTC
MJD         MJD     ${FileCreationTime}         Modified Julian Date that the file was written
MJD-OBS     MJD     ${ObservationDate}          Modified Julian Date of image acquisition
INSTRUME    String  LSST_CAMERA                 Instrument
TELESCOP    String  LSST                        Telescope
IMAGETAG    String  ${Tag}                      DAQ Image id
CONTNUM     String  ${CCDControllerSerial}      CCD Controller (REB) Serial Number
SEQFILE     String  ${SequencerFileName}        Sequencer file name
SEQCKSUM    String  ${SequencerChecksum}        Checksum of Sequencer
CCD_MANU    String  ${CCDManufacturer}          CCD Manufacturer
CCD_TYPE    String  ${CCDModel}                 CCD Model Number
CCD_SERN    String  ${CCDControllerSerial}      Manufacturers' CCD Serial Number
LSST_NUM    String  ${CCDSerialLSST}            LSST Assigned CCD Number
CCDSLOT     String  ${CCDSlot}                  The CCD Slot
REBNAME     String  ${RebName}                  Name of the REB
IMGTYPE     String  ${ImageType}                BIAS, DARK, \u2026
TESTTYPE    String  ${TestType}                 DARK:FLAT:OBS:PPUMP:QE:SFLAT
DETSIZE     String  ${DETSIZE}                  IRAF detector size 
TEMP_SET    Float   ${TemperatureSetPoint}      CCD Temperature set point (deg C)
CCDTEMP     Float   ${MeasuredTemperature}      Measured temperature (deg C)
EXPTIME     Float   ${ExposureTime}             Exposure Time in Seconds
DARKTIME    Float   ${DarkTime}                 Dark Time in Seconds (see TSEIA-91)
FILENAME    String  ${OriginalFileName}         Original name of the file
RUNNUM      Integer ${RunNumber}                The Run Number (when running under eTraveler)
# Elements from the image name, see also TSEIA-79
OBSID       String  ${ImageName}                The image name or obs-id
TELCODE     String  ${ImageSource}              The "code" for MainCamera
CONTRLLR    String  ${ImageController}          The controller (e.g. O for OCS, C for CCS)
DAYOBS      String  ${ImageDate}                The observation day as defined in the image name 
SEQNUM      Integer ${ImageNumber}              The sequence number from the image name
# CCOB items (do they belong in primary header -- probably not)
TEMPLED1    Float   ${StatusAggregator.ccob-subsystem/tempLed1}                 CCOB daughter board temperature, front
TEMPLED2    Float   ${StatusAggregator.ccob-subsystem/tempLed2}                 CCOB daughter board temperature, back
TEMPSPH     Float   ${StatusAggregator.ccob-subsystem/tempSphere}               CCOB sphere temperature
TEMPBRD     Float   ${StatusAggregator.ccob-subsystem/tempBrd}                  CCOB board temperature
# BOT items
BOTXCAM     Float ${StatusAggregator.bot-motorplatform/LampStatus/xcam}   
BOTYCAM     Float ${StatusAggregator.bot-motorplatform/LampStatus/ycam}
BOTX        Float ${StatusAggregator.bot-motorplatform/LampStatus/xbot}
BOTY        Float ${StatusAggregator.bot-motorplatform/LampStatus/ybot}
