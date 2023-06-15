package com.rbc.bbp0.config;

import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.step.ExchangeRateItemWriter;
import com.rbc.bbp0.step.ExchangeRateProcessor;
import com.rbc.bbp0.step.ExchangeRateReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Slf4j
public class ExchangeRateJobConfig {
    @Value("$(rest.client.fxRateApi.url)")
    private final String fxRateApiUrl = null;
    @Value("$(rest.client.fxRateApi.username)")
    private final String apiUsername = null;
    @Value("$(rest.client.fxRateApi.password)")
    private final String apiPassword = null;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {

        return builder.build();
    }

    @Bean
    public ItemReader<ExchangeRatesRequest> itemReader(WebClient webClient) {
        return new ExchangeRateReader(fxRateApiUrl, apiUsername, apiPassword, webClient);
    }
    @Bean
    public ItemWriter<ExchangeRatesRequest> itemWriter(WebClient webClient) {
        return new ExchangeRateItemWriter(fxRateApiUrl, webClient);
    }
    @Bean
    public ItemProcessor<ExchangeRatesRequest, ExchangeRatesRequest> itemProcessor() {
        return new ExchangeRateProcessor();
    }
    public Step exampleJobStep(
            ItemReader<ExchangeRatesRequest> reader, ItemProcessor itemProcessor, ItemWriter<ExchangeRatesRequest> writer, StepBuilderFactory stepBuilderFactory
    ){
        log.info("Inside example jobstep");
        return stepBuilderFactory.get("exampleJobStep").chunk(1).reader(reader).processor(itemProcessor).writer(writer).build();
    }
    @Bean
    public Job exampleJob(
            Step exampleJobStep, JobBuilderFactory jobBuilderFactory
    ){
        log.debug("Inside example job");
        return jobBuilderFactory.get("exampleJob").incrementer(new RunIdIncrementer()).flow(exampleJobStep).end().build();
    }
}

