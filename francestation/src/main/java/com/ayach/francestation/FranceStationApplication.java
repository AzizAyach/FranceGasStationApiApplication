package com.ayach.francestation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ayach.francestation.service.SourceFileProcess;

@SpringBootApplication(scanBasePackages = { "com.ayach.francestation.service", "com.ayach.francestation.repositories",
		"com.ayach.francestation.configuration" })
@EnableAsync
public class FranceStationApplication implements CommandLineRunner {

	@Autowired
	SourceFileProcess sourceFileProcess;

	public static void main(String[] args) {
		SpringApplication.run(FranceStationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sourceFileProcess.getProcessFileAndPreInsert();

	}

	@Bean("threadPoolTaskExecutor")
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(20);
		executor.setMaxPoolSize(1000);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("Async_Process_FranceStation");
		return executor;
	}

}
