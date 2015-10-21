//For each year available, plot the total number of words used.  Year on the x-axis, total words on y-axis.

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NGramCountMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    

	  String line = value.toString();
	  String [] lines = line.split("\t");
	  String year  = lines[1];
	  String strTF = lines[2];
	  int tf = Integer.parseInt(strTF);
	  context.write(new Text(year), new IntWritable(1));
	  //context.write(new Text(attrib), new IntWritable(1));
  }
}
