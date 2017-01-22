package subsriberMax;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;


public class Runner {
public static void main(String[] args) throws IOException {
	JobConf job = new JobConf(Runner.class);
	job.setJobName("SubsriberMax");
	// set outkey and value class
	job.setOutputKeyClass(Text.class);
	job.setOutputValueClass(DoubleWritable.class);
	// set mapper, combiner and reducer class
	job.setMapperClass(SubMapper.class);
	job.setReducerClass(MaxReducer.class);
	job.setCombinerClass(MaxReducer.class);
	
	// set input and output file formats
	job.setInputFormat(TextInputFormat.class);
	job.setOutputFormat(TextOutputFormat.class);
	
	// set input and output path
	FileInputFormat.setInputPaths(job,new Path(args[0]));
	FileOutputFormat.setOutputPath(job,new Path(args[1]));
	
	// start the job
	
	JobClient.runJob(job);
}
}
