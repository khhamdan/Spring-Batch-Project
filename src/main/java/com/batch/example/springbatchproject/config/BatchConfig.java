package com.batch.example.springbatchproject.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig
{
    @Bean
     public Job jobBean(JobRepository jobRepository)
     {
        return new JobBuilder("job",jobRepository)
                .listener(listener)
                .start(steps)
                .build()
     }

     @Bean
    public Step step(JobRepository jobRepository)
    {
        return new StepBuilder("jobStep",jobRepository)
                .chunk(5,);
                
    }

}
