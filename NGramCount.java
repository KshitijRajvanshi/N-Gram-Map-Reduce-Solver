//For each year available, plot the total number of words used.  Year on the x-axis, total words on y-axis.

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class NGramCount {
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: NGramCount <input path> <output path>");
      System.exit(-1);
    }
        Job job = new Job();
    job.setJarByClass(YearCount.class);
    job.setJobName("NGramCount");
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    job.setMapperClass(NGramCountMapper.class);
    job.setReducerClass(NGramCountReducer.class);
    job.setNumReduceTasks(5);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
