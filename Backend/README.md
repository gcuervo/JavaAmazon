#Backend

##Installation

###Requirements

* [Apache tomcat](http://tomcat.apache.org/download-80.cgi)
* [Apache Maven](https://maven.apache.org/download.cgi)
* [MySql](http://dev.mysql.com/downloads/mysql/) - [HowTo](http://websystique.com/misc/how-to-setup-mysql-on-local-pc/)

###Guide

	Build the war via maven command line( mvn clean install).Deploy the war to a Servlet 3.0 container. Since here i am using Tomcat, i will simply put this war file into tomcat webapps folder and click on start.bat inside tomcat/bin directory.