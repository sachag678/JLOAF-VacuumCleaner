package PerformanceTesting;

import java.io.IOException;

import org.jLOAF.Agent;
import org.jLOAF.casebase.CaseBase;
import org.jLOAF.performance.PerformanceEvaluator;

import AgentModules.VacuumCleanerAgent;
import CaseBaseCreation.LogFile2CaseBase;



/***
 * class PerformanceTest will create an agent with one caseBase and use a testBase to measure its performance. It will output all the performance measures such as
 * accuracy, recall, precision, f-measure.
 * @author Ibrahim Ali Fawaz								
 * @since 2017 May 
 ***/
public class PerformanceTest extends PerformanceEvaluator {
	
	
	public static void main(String[] args){
		
		
		String [] filenames = {"jLOAF-VacuumCleaner/trace-m0-WallFollowerAgent.txt","jLOAF-VacuumCleaner/trace-m1-WallFollowerAgent.txt"};
		
		PerformanceTest pt = new PerformanceTest();
		try {

			pt.PerformanceEvaluatorMethod(filenames,null,"vcOutput.txt",null,null,null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public VacuumCleanerAgent createAgent() {
		VacuumCleanerAgent agent = new VacuumCleanerAgent();
	
		return agent;
	}

	@Override
	public String[] createArrayOfCasebaseNames(String[] filenames) throws IOException {
		LogFile2CaseBase lfcb = new LogFile2CaseBase();
		String[] outputs = new String[filenames.length];
		
		String outputFile ="vcb";
		int i=0;
		
		for(String s:filenames){
			outputs[i]=lfcb.parseLogFile(s,outputFile+i+".cb");
					i++;
		}
		
			return outputs;
	}

	

}
