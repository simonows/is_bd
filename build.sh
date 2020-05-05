#!/bin/bash

MVN_PATH="/opt/tomcat9/webapps/ROOT/apache-maven-3.6.3/bin/"
MVN_CMD="mvn"
INSTALL_DIR="/opt/tomcat9/webapps"
APP_NAME="aviakassa-1.0"
SERVER_NAME="tomcat9"
SERVER_GROUP="tomcat"

$MVN_PATH$MVN_CMD clean package

if ! [ $? -eq 0 ]; then
	echo "build.sh: Error build"
	exit 1;
fi

rm -rf $INSTALL_DIR/$APP_NAME
rm -rf $INSTALL_DIR/$APP_NAME.war

cp target/$APP_NAME.war $INSTALL_DIR
chown $SERVER_NAME:$SERVER_GROUP $INSTALL_DIR/$APP_NAME.war
systemctl restart $SERVER_NAME

