#this script works on Ubuntu from the baby-smash/quick directory



mkdir bin
#incase its alteady there
rm bin/*.class
echo Dir contents after clean
ls
sleep 2
echo
echo now compile
javac -target 1.7 -source 1.7 -d bin -cp src src/*.java
cd bin
jar -cm ../src/mani.m    *.class >../BabySmashApp.jar
echo Done
cd ..
echo Dir contents
ls

