#!/usr/bin/env bash

java -cp $CLASSPATH:bin server.ServerUi &
java -cp $CLASSPATH:bin client.ClientUi &