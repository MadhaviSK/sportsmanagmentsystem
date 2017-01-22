package subscriberSort;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;


public class sortreducer extends MapReduceBase 
implements Reducer<DoubleWritable,Text,Text,DoubleWritable> {

	public void reduce(DoubleWritable key, Iterator<Text> value,OutputCollector<Text,DoubleWritable> output, Reporter reporter) throws IOException {
		Double key1 = -key.get();
	while(value.hasNext())
		output.collect(value.next(),new DoubleWritable(key1));
	}

}

