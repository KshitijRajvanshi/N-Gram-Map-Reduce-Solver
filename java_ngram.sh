#!/bin/bash
rm -rf out_ngram
rm -rf ngramClasses
rm -rf ngram.jar
rm -rf out_ngram
mkdir ngramClasses
mkdir out_ngram
javac -target 1.7 -source 1.7 -classpath /root/hadoop-1.2.1/hadoop-core-1.2.1.jar -d ngramClasses/ *.java
jar -cvf ngram.jar -C ngramClasses/ .
hadoop fs -rmr /user/naah/output_ngram
hadoop jar ngram.jar YearCount /data/1gram/ output_ngram
output_ngram
hadoop fs -get /user/naah/output_ngram/part* out_ngram
cd out_ngram
cat part* >> final.txt
cd ..
python final_ngram.py ./out_ngram/final.txt 

