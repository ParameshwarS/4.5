import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AssgnReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
	IntWritable c = new IntWritable();
	
	public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		int s = 0;
		for (IntWritable value : values) {
			s+=value.get();
		}
		c.set(s);
		context.write(key,c);
}
}