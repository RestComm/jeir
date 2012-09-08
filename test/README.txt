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
sctp association create SCTPAssoc1 CLIENT 127.0.0.1 3001 127.0.0.1 3000
 
m3ua as create AS1 IPSP mode SE ipspType client rc 100

m3ua asp create ASP1 SCTPAssoc1

m3ua as add AS1 ASP1

m3ua route add AS1 2 -1 -1

//Rule for incoming SCCP message
sccp primary_add create 1 19 1 9 0 1 4 553496629939 
sccp rule create 1 K 18 0 9 0 1 4 553496629939 solitary 1 

//Rule for all out going
sccp primary_add create 2 19 2 0 0 1 4 -
sccp rule create 2 K 18 0 0 0 1 4 * solitary 2 

sccp rsp create 1 2 0 0

sccp rss create 1 2 8 0

sccp sap create 1 1 1 3

sccp dest create 1 1 2 2 0 255 0 255 255

m3ua asp start ASP1

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