#this script works on Ubuntu from the baby-smash/quick directory



#mkdir bin
#incase its alteady there
#rm bin/*.class
echo "Removing exising target directory"
rm -rf target
#echo "Dir contents after clean"
#ls
#sleep 2
#echo
#echo now compile
echo "Running maven package..."
mvn -version
mvn -X package > mvn.log
echo "maven complete..."
echo "tail mvn.log"
tail mvn.log
#javac -target 1.7 -source 1.7 -d bin -cp vlcj/target/classes:src src/*.java
#cd bin
#cd target
#jar -cvm ../src/mani.m    *.class  -C ../vlcj/target/classes/ .>../BabySmashApp.jar
echo Done
echo "Execute java -jar target/
cd ..
echo Dir contents
ls

