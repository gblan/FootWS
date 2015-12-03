#Projet WebService utilisant Apache Servicemix


#Transformation XSLT
Ne pas oublier de laisser namespace = "" dans la classe package-info.java;
ceci pour éviter les problèmes lors de la transformation du xml en html


#Utils
pour acceder a la webconsole de service mix, utiliser l'url suivante après avoir démarré le service mix : 
http://localhost:8181/system/console/bundles
user : karaf
pass : karaf


#Lancement des jars
service : java -jar FootWS-service.jar

ensuite le WSDL est accessible sur http://localhost:8090/ws?wsdl, et on peut lancer le client

client : java -jar FootWS-client.jar