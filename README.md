# jeir
The Equipment Identity Register (EIR) is a database that contains a record of the all the mobile stations (MS)that are allowed in a network as well as an database of all equipment that is banned, e.g. because it is lost or stolen.

The identity of the mobile station is given by the International Mobile Equipment Identity (IMEI). Each time a call is made, the MSC requests the IMEI of the mobile station, which is then send to the EIR for authorisation.

jEIR is built on [RestComm jSS7](https://github.com/RestComm/jSS7).

jEIR is lead by [TeleStax](http://www.telestax.com/), Inc. and developed collaboratively by a community of individual and enterprise contributors.


Install on Ubuntu 14.04 from Source
========
You can run these instructions as a normal user (root shouldn't be required).

Where relevant you may have to replace "user" with your username, and "/home/user" with your own home directory.

Install Oracle Java 7
```
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java7-installer
sudo apt-get install oracle-java7-set-default
java -version
```

Install Maven
```
apt-get install git software-properties-common screen
add-apt-repository "deb http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main"
apt-get update
apt-get install maven3
ln -s /usr/share/maven3/bin/mvn /usr/bin/mvn
```

Install RestComm JAIN SLEE
```
apt-get install unzip ant
su user
cd ~
mkdir RestComm
cd RestComm
# Download from https://mobicents.ci.cloudbees.com/job/Mobicents-JAIN-SLEE-Release/
unzip ~/mobicents-slee-2.8.10.32.zip	
```

Setup JBOSS
```
vi ~/.profile
#
JBOSS_HOME=/home/user/mobicents-slee-2.8.10.32/jboss-5.1.0.GA
export JBOSS_HOME
#

vi $JBOSS_HOME/server/default/conf/bootstrap/profile.xml
conf/bootstrap/profile.xml
# Find AttachmentStore
<constructor><parameter class="java.io.File">
#

Test run the server
cd $JBOSS_HOME/bin
# run the server open on all network interfaces
./run.sh -b 0.0.0.0
```

You can keep the server running and watch jSS7 get deployed

```
cd
git clone https://github.com/RestComm/jain-slee.ss7.git
cd jain-slee.ss7/resources/map
mvn clean install
```

Deploy the jEIR
```
cd ~
git clone https://github.com/RestComm/jeir.git
cd jeir
mvn clean install
```

You can view the various included web consoles here:

1. http://yourserver:8080/admin-console/
  * user: admin
  * password: admin
2. http://yourserver:8080/slee-management-console
3. http://yourserver:8080/jmx-console/

Want to Contribute ? 
========
[See our Contributors Guide](https://github.com/RestComm/Restcomm-Core/wiki/Contribute-to-RestComm)

Issue Tracking and Roadmap
========
[Issue Tracker](https://github.com/RestComm/jeir/issues)

Questions ?
========
Please ask your question on [StackOverflow](http://stackoverflow.com/questions/tagged/restcomm) or the Google [public forum](http://groups.google.com/group/restcomm)

License
========

RestComm jEIR is licensed under dual license policy. The default license is the Free Open Source GNU Affero GPL v3.0. Alternatively a commercial license can be obtained from Telestax ([contact form](http://www.telestax.com/contactus/#InquiryForm))

Acknowledgements
========
[See who has been contributing to RestComm](http://www.telestax.com/opensource/acknowledgments/)
