#Projet WebService utilisant Apache Servicemix


#Commande pour autogénerer des classes enveloppe a partir d'un fichier xsd
xjc -d src file.xsd
#Transformation XSLT
Ne pas oublier de laisser namespace = "" dans la classe package-info.java;
ceci pour éviter les problèmes lors de la transformation du xml en html


#Utils
logins pour servicemix : 
user : karaf
pass : karaf

pour voir ce qui se passe sur mon service (affichage continu des logs) :    log:tail
pour installer un bundle (le mettre dans deploy)
pour désinstaller un bundle (le voir dans osgi:list) puis executer osgi:uninstall #id

dans servicemix, modifier le fichier etc/activemq.xml :
commenter la balise     <!--   <plugins>
            				<jaasAuthenticationPlugin configuration="karaf" />
        				</plugins> -->

#URLS ACCESSIBLES
le WSDL est accessible sur http://localhost:8090/ws?wsdl
la webconsole de servicemix est accessible sur http://localhost:8181/system/console/bundles  (pour voir les bundles)
la webconsole de activemq est accessible sur http://localhost:8181/activemqweb/queues.jsp ( pour voir les files de messages)

#Lancement des jars
service : java -jar FootWS-service.jar

client : java -jar FootWS-client.jar

#Pays accessibles
Spain
Germany
Argentina
Colombia
Belgium
Uruguay
Switzerland
Brazil
Chile
Ecuador
Côte D'Ivoire (Ivory Coast)
Ghana
Algeria
Nigeria
Cameroon
Italy
United States
Mexico
Costa Rica
Honduras
Iran
Japan
South Korea
Australia
United Kingdom
Bosnia & Herzegovina
Croatia
France
Greece
Netherlands
Portugal
Russia