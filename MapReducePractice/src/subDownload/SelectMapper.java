package subDownload;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class SelectMapper extends  MapReduceBase implements Mapper<LongWritable,Text, Text, DoubleWritable>{

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, DoubleWritable> output, Reporter arg3)
			throws IOException {
		
		String cdr = value.toString();
		if(null != cdr && cdr.length() > 97 ){
			String subId = cdr.substring(0,15);
			Double bytes = Double.parseDouble(cdr.substring(87,97));		 
			output.collect(new Text(subId), new DoubleWritable(bytes));
		}else{
			output.collect(new Text("Dummy"), new DoubleWritable(1.0));
		}
	
	}	
}
