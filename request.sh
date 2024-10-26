#!/bin/sh

URL=localhost:8080

case $1 in
  "get-cities")
    http GET $URL/cities;;
  "get-city")
    http GET $URL/city/1;;
  *)
    echo route not found in $URL;;
esac