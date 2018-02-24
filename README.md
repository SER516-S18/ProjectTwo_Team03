# ProjectTwo_Team03

## To Run the Project
Run in the following sequence, first start the Server and then start the Client.
### For Server
`java -jar ServerUi.jar`

### For Client
`java -jar ClientUi.jar`

## To Compile and Run 
### On Unix
`./make.sh && ./run.sh` are convenience scripts for the following:
```bash
# clean
rm -rf bin/utility
rm -rf bin/client
rm -rf bin/server
# build
mkdir -p bin/utility
mkdir -p bin/server
mkdir -p bin/client
javac -cp $CLASSPATH:src src/utility/*.java -d bin/
javac -cp $CLASSPATH:src src/server/*.java -d bin/
javac -cp $CLASSPATH:src src/client/*.java -d bin/
# run
java -cp $CLASSPATH:bin server.ServerUi &
java -cp $CLASSPATH:bin client.ClientUi &
```
### On Windows
Use an IDE to run the ServerUi and ClientUi
Follow these steps:
```bash
Copy all files inside src to the IDE Project src folder.
Compile and Run ServerUi.java
Compile and Run ClientUi.java
