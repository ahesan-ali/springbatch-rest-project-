import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableBatchProcessing
@Slf4j
public class SpringBatchApplication implements CommandLineRunner {
	@Autowired
	private Job job;
	@Autowired
	private JobLauncher jobLauncher;

	public static void main(String[] args) {

		System.exit(SpringApplication.exit(SpringApplication.run(SpringBatchApplication.class,args)));
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Spring batch job started>>>> ");
		jobLauncher.run(job, newExecution());
	}

	public JobParameters newExecution() {
		Map<String,JobParameter> parameters= new HashMap<>();
		JobParameter parameter = new JobParameter (new Date());
		parameters.put("currentTime",parameter);
		return new JobParameters();
	}
}
