#!/bin/bash

# Run build.sh first if you haven't already

if [ ! -f app.jar ]; then
	echo "[simple-web-app]: Unable to find app.jar. Did you run build.sh?"
else 
	java -jar app.jar
fi
