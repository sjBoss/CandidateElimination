import java.io.*;
import java.util.ArrayList;

/**
 * remove the first redundant column in the dataSet file
 * Copy contents of the file into a 2D array
 * @author SUBHADIP JANA
 *
 */
public class PreprocessData
{
	String classListFile;
	String rawDataSetFile;
	String processedDataFile;
	String line;
	String[] lineSplit;
	BufferedReader bfr;
	
	/**
	 * 
	 * @param classListFile
	 * @param rawDataSetFile
	 * @param outputDataSetFile
	 */
	public PreprocessData(String classListFile, String rawDataSetFile,String outputDataSetFile)
	{
		this.classListFile = classListFile;
		this.rawDataSetFile = rawDataSetFile;
		this.processedDataFile = outputDataSetFile;
		try
		{
			bfr = new BufferedReader(new FileReader(classListFile));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}		
	

	/**
	 * 
	 * @throws IOException
	 */
	public void modifyDataSet() throws IOException
	{
		/**
		 * open the file in read mode using buffered reader
		 */
		bfr = new BufferedReader(new FileReader(rawDataSetFile));
		new FileWriter(processedDataFile);
		FileWriter fw = new FileWriter(processedDataFile);	
		/**
		 * iterate over the file line by line,
		 * remove the first word,
		 * write the rest over line to the new file.
		 */
		while((line=bfr.readLine())!=null)
		{
			lineSplit = line.split(",");
			lineSplit[0] = "";
			fw.write(line.substring(line.indexOf(',')+1) + "\n");			
		}
		fw.close();
	}
	
	/**
	 * Store the modified dataFile into a 2D array
	 * @return String[][]
	 * @throws IOException
	 */
	public String[][] createDataPointsList() throws IOException
	{
		modifyDataSet();
		ArrayList<String[]> dataPoints_ArrayList = new ArrayList<String[]>();
		bfr = new BufferedReader(new FileReader(processedDataFile));
		
		/**
		 * line.split to convert a string to a string array based on a delimiter
		 */
		while((line=bfr.readLine())!=null)
		{
			dataPoints_ArrayList.add(line.split(","));
		}
		
		return dataPoints_ArrayList.toArray(new String[0][0]);
	}

}
