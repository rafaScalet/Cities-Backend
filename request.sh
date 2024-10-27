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
  "post-city-null-error")
    http POST $URL/city \
      name="" \
      state="" \
      country="" \
      age:=null \
      area:=null \
      population:=null
    ;;
  "post-city-size-error")
    http POST $URL/city \
      name="a" \
      state="a" \
      country="a" \
      age:=1 \
      area:=1 \
      population:=1
    ;;
  "put-city")
    http PUT $URL/city/2 \
      name="cidade 2 editado" \
      state="estado 2 editado" \
      country="país 2 editado" \
      age:=200 \
      area:=2000.0 \
      population:=20000
    ;;
  *)
    echo route not found in $URL;;
esac