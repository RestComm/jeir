To be able to test EIR Server we should create a MSC simulator.

This file guides you to create the configuration of Sigtran to connect EIR to MSC.

So the process is:
1. Deploy EIR Server to one Mobicents JAIN SLEE node
2. Start EIR Server
3. Start MSC Simulator

EIR Server will try to connect MSC Simulator. When this connection is active, MSC Simulator will send checkIMEI requests to EIR.

---------------------------------------------------------------------------------------------------------------------------
----------------------------------- Sigran configuration for Mobicents EIR Server -----------------------------------------
---------------------------------------------------------------------------------------------------------------------------
*** Summary for EIR Server ***
PC: 1
GT: 553496629939
SSN: 9
IP: 127.0.0.1
Port: 3000
---------------------------------------------------------------------------------------------------------------------------
Configure SS7 on jEIR:
1) Run the ss7-cli.sh (Mobicents SS7 Management Shell) and connect to TelScale CLI

# cd mobicents-slee-2.8.12.36/extra/mobicents-ss7/mobicents-jss7-3.0.1322/ss7/shell/bin
# ss7-cli.bat
telscale>connect 127.0.0.1 3435
Connected to TelScale CLI 3.0.1322 TeleStax Authenticating against configured security realm
Username:admin
Password:*****		(use 'admin')


2) Execute below ss7-cli commands

sctp association create EirSCTPAssoc1 CLIENT 127.0.0.1 3001 127.0.0.1 3000

m3ua as create EirAS1 IPSP mode SE ipspType client rc 100

m3ua asp create EirASP1 EirSCTPAssoc1

m3ua as add EirAS1 EirASP1

m3ua route add EirAS1 2 -1 -1

//Rule for incoming SCCP message
sccp address create 1 19 1 9 0 1 4 553496629939
sccp rule create 1 K 18 0 9 0 1 4 553496629939 solitary 1 

//Rule for all out going
sccp address create 2 19 2 0 0 1 4 -
sccp rule create 2 K 18 0 0 0 1 4 * solitary 2

sccp rsp create 1 2 0 0

sccp rss create 1 2 8 0

sccp sap create 1 1 1 3

sccp dest create 1 1 2 2 0 255 255

m3ua asp start EirASP1

---------------------------------------------------------------------------------------------------------------------------
-------------------------------------- Sigtran configuration for MSC Simulator --------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
*** Summary for MSC Simulator ***
PC: 2
GT: 553496629938
SSN: 8
IP: 127.0.0.1
Port: 3001
---------------------------------------------------------------------------------------------------------------------------

Just use the config files at test/bootsrap/src/main/config/data/