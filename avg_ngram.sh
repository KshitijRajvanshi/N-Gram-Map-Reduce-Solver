#!/bin/bash
rm -rf avgClasses
rm -rf avg.jar
rm -rf output_avg
mkdir avgClasses
mkdir output_avg
javac -target 1.7 -source 1.7 -classpath /root/hadoop-1.2.1/hadoop-core-1.2.1.jar -d avgClasses/ *.java
jar -cvf avg.jar -C avgClasses/ .
hadoop fs -rmr /user/naah/output_avg
hadoop jar GramAvgWordLen.jar GramAvgWordLen /data/1gram/ output_avg 
#hadoop jar avg.jar avg googleebooks-eng-all-1gram-20120701-z output_avg
hadoop fs -get /user/naah/output_avg/part* output_avg
cd output_avg
cat part* >> final_avg.txt
cd ..
python avgCal.py ./output_avg/final_avg.txt

