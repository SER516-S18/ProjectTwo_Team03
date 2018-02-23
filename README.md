# ProjectTwo_Team03

## Build
### Unix
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