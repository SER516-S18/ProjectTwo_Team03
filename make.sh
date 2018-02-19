#/usr/bin/env bash

./clean.sh
mkdir -p bin/utility
mkdir -p bin/server
mkdir -p bin/client
javac -cp $CLASSPATH:src src/utility/*.java -d bin/
javac -cp $CLASSPATH:src src/server/*.java -d bin/
javac -cp $CLASSPATH:src src/client/*.java -d bin/