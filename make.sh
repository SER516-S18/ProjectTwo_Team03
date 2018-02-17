#/usr/bin/env bash

./clean.sh
javac src/server/*.java -d bin/server
javac src/client/*.java -d bin/client