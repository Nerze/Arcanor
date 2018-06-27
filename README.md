# Arcanor

Pour créer un fichier .jar depuis les fichier sources il faut se placer dens le fichier ws de et éxecuter la commande suivante :

javac -d ../class ../src/*.java
puis
javadoc -charset UTF8 -private -d ../javaDoc ../src/*.java
puis
jar cvf arcanor.jar manifest.txt ../class
puis
chmod 700 arcanor.jar
puis
java -jar arcanor.jar
