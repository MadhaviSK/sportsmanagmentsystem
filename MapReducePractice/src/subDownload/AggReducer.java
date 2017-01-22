package subDownload;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class AggReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable>{

	@Override
	public void reduce(Text key, Iterator<DoubleWritable> value,
			OutputCollector<Text, DoubleWritable> output, Reporter arg3)
			throws IOException {
		// TODO Auto-generated method stub
		Double sum = 0.0;
		while(value.hasNext()){
			sum += value.next().get();
		}
	output.collect(key, new DoubleWritable(sum));	
	}
}
