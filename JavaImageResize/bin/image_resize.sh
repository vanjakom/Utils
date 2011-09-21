#!/bin/sh

DESTINATION_FOLDER = /Users/vanja/Desktop/resized/
GREATER_DIMENSION = 800;
java -cp target/JavaImageResize-*-jar-with-dependencies.jar com.busywait.javaimageresize.TerminalResizer $@ DESTINATION_FOLDER GREATER_DIMENSION
