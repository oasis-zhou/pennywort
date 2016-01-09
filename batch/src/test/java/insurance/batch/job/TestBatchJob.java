package insurance.batch.job;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


public class TestBatchJob implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution paramStepContribution,
			ChunkContext paramChunkContext) throws Exception {
//		Map jobParameter = new HashMap();
//		if(paramChunkContext != null)
//		{
//			jobParameter=paramChunkContext.getStepContext().getJobParameters();
//			//this is to fix the issue that spring boot will run all defined job while starting up.
//			//need to check if there is any setting that could be used to turn off the feature of spring boot.
//			if(!jobParameter.containsKey("RunningDate"))
//			{
//				return RepeatStatus.FINISHED;
//			}
//		}
//		String jobParameterString = (String)jobParameter.get("parameter");
//		Date dueDate = (Date)jobParameter.get("dueDate");	
//		Map parameterMap = new HashMap();
	
		System.out.print("##########TestBatchJob Execute!#######################");

		return RepeatStatus.FINISHED;
	}

	

}
