#!/bin/sh

URL=localhost:8080

case $1 in
  "get-cities")
    http GET $URL/cities;;
  "get-city")
    http GET $URL/city/1;;
  "delete-city")
    http DELETE $URL/city/1;;
  "post-city")
    http POST $URL/city \
      name="cidade 4" \
      state="estado 4" \
      country="país 4" \
      age:=40 \
      area:=400.0 \
      population:=4000
    ;;
  *)
    echo route not found in $URL;;
esac