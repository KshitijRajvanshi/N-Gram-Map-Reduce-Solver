import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordLengthMapper
	extends Mapper<LongWritable,Text,Text,LongWritable>{

@Override
public void map(LongWritable key,Text value, Context context)
throws IOException,InterruptedException{
	
	String str=value.toString();
	String[] strArr=str.split("\t");
	long len=strArr[0].length();
	long freq=Integer.parseInt(strArr[2]);
	long numerator =(len*freq);
	String year=strArr[1];
	String yearD=strArr[1]+"D";
	context.write(new Text (year), new LongWritable(numerator));
	context.write(new Text (yearD), new LongWritable(freq));
	
	}

}

