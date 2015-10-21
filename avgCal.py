import sys
import math


name=sys.argv[1]
f=open (name,'r')
data=list(f)
f.close()

outputDic={}
numerator={}
denominator={}

for i in range(len(data)):
	st=data[i].split("\t")
	if len(st[0]) == 4:
		if st[0] in numerator:
			num=numerator[st[0]]
			numerator[st[0]]=num+ st[1]
		else:
			numerator[st[0]]=st[1]
	elif len(st[0]) == 5:
		if st[0] in denominator:
			numD=denominator[st[0]]
			denominator[st[0]]=numD+ st[1]
		else:
			denominator[st[0]]=st[1]
	else:
		print "We are in a problem"
		break


for i in numerator.keys():
	num=float(numerator[i] )
	deKey=i+'D'
	Dnum=float(denominator[deKey])
	output=(num)/Dnum
	outputDic[i]=(output)
	print str(i) + "    " + str(outputDic[i] )


