package subDownload;

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

public class Driver {

	public static void main(String[] args) throws IOException{
		
		JobConf conf = new JobConf(Driver.class);
		conf.setJobName("SubsciberBytesDownoloaded");
		
		// Set output key and output values
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(DoubleWritable.class);
		
		// Set mapper , combiner and reducer
		conf.setMapperClass(SelectMapper.class);
		conf.setCombinerClass(AggReducer.class);
		conf.setReducerClass(AggReducer.class);
		
		// Set input and output formats
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		
		// Set input and output path arguments
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		
		// Submit to hadoop
		JobClient.runJob(conf);
		
	}
}
