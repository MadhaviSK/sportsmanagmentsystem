package subsriberMax;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class SubMapper extends MapReduceBase 
implements Mapper<LongWritable, Text, Text, DoubleWritable>{

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, DoubleWritable> output, 
			Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		String line = value.toString();
		if(line==null || line.length()<97){
			output.collect(new Text("dummy"), new DoubleWritable(1.0));
		}
		else{
			String subId = line.substring(15, 26);
			Double bytes = Double.parseDouble(line.substring(87,97));
			output.collect(new Text(subId), new DoubleWritable(bytes));
		}
		
		
	}

}
