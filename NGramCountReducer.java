//For each year available, plot the total number of words used.  Year on the x-axis, total words on y-axis.

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class NGramCountReducer extends Reducer<Text,IntWritable,Text,IntWritable>{


public void reduce(Text key,Iterable<IntWritable> values ,Context context)
throws IOException,InterruptedException{
	int sum=0;
	for(IntWritable value: values) {
	sum=sum+ value.get();
	}	
	context.write(key,new IntWritable(sum));
	}

}

