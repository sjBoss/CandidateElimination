import java.util.*;
import java.io.*;

public class candidateEliminationDriver
{
	static String[][] dataSet;
	public static void main(String[] args) {
		
		try
		{
			dataSet = new PreprocessData("C://Users//SUBHADIP JANA//Desktop//classList.txt","C://Users//SUBHADIP JANA//Desktop//candidateDataSet.txt","C://Users//SUBHADIP JANA//Desktop//newData.txt").createDataPointsList();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		for(int classNum = 1;classNum<=7;classNum++)
		{
			new CandidateEliminationBackend("" + classNum, dataSet,"C://Users//SUBHADIP JANA//Desktop//" + "Results" + ".txt");
		}
	}
}
