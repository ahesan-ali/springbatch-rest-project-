package com.rbc.bbp0.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rbc.bbp0.dto.request.ExchangeRatesRequest;
import com.rbc.bbp0.step.ExchangeRateItemWriter;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.JobFlowBuilder;
import org.springframework.batch.core.job.flow.FlowJob;
import org.springframework.batch.core.job.flow.FlowStep;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.jsr.step.builder.JsrBatchletStepBuilder;
import org.springframework.batch.core.jsr.step.builder.JsrFaultTolerantStepBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.dao.JdbcExecutionContextDao;
import org.springframework.batch.core.repository.dao.JdbcJobExecutionDao;
import org.springframework.batch.core.repository.dao.JdbcJobInstanceDao;
import org.springframework.batch.core.repository.dao.JdbcStepExecutionDao;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.core.step.builder.FaultTolerantStepBuilder;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.item.ChunkOrientedTasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

@ContextConfiguration(classes = {ExchangeRateJobConfig.class})
@ExtendWith(SpringExtension.class)
class ExchangeRateJobConfigTest {
    @Autowired
    private ExchangeRateJobConfig exchangeRateJobConfig;

    /**
     * Method under test: {@link ExchangeRateJobConfig#webClient(WebClient.Builder)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWebClient() {
        // TODO: Complete this test.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        exchangeRateJobConfig.webClient(null);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#itemReader(WebClient)}
     */
    @Test
    void testItemReader() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        assertNull((new ExchangeRateJobConfig()).itemReader(null).read());
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#itemReader(WebClient)}
     */
    @Test
    void testItemReader2() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        WebClient webClient = mock(WebClient.class);
        Mockito.<WebClient.RequestHeadersUriSpec<?>>when(webClient.get()).thenReturn(null);
        ExchangeRatesRequest actualReadResult = exchangeRateJobConfig.itemReader(webClient).read();
        verify(webClient).get();
        assertNull(actualReadResult);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#itemWriter(WebClient)}
     */
    @Test
    void testItemWriter() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ItemWriter<ExchangeRatesRequest> actualItemWriterResult = (new ExchangeRateJobConfig()).itemWriter(null);
        actualItemWriterResult.write(new ArrayList<>());
        assertTrue(actualItemWriterResult instanceof ExchangeRateItemWriter);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#itemWriter(WebClient)}
     */
    @Test
    void testItemWriter2() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ItemWriter<ExchangeRatesRequest> actualItemWriterResult = (new ExchangeRateJobConfig())
                .itemWriter(mock(WebClient.class));
        actualItemWriterResult.write(new ArrayList<>());
        assertTrue(actualItemWriterResult instanceof ExchangeRateItemWriter);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#itemProcessor()}
     */
    @Test
    void testItemProcessor() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ItemProcessor<ExchangeRatesRequest, ExchangeRatesRequest> actualItemProcessorResult = (new ExchangeRateJobConfig())
                .itemProcessor();
        ExchangeRatesRequest exchangeRatesRequest = new ExchangeRatesRequest();
        assertSame(exchangeRatesRequest, actualItemProcessorResult.process(exchangeRatesRequest));
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#itemProcessor()}
     */
    @Test
    void testItemProcessor2() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ExchangeRatesRequest exchangeRatesRequest = mock(ExchangeRatesRequest.class);
        assertSame(exchangeRatesRequest, (new ExchangeRateJobConfig()).itemProcessor().process(exchangeRatesRequest));
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    void testExampleJobStep() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        ItemReader<ExchangeRatesRequest> reader = mock(ItemReader.class);
        ItemProcessor itemProcessor = mock(ItemProcessor.class);
        ItemWriter<ExchangeRatesRequest> writer = mock(ItemWriter.class);
        JdbcJobInstanceDao jobInstanceDao = new JdbcJobInstanceDao();
        JdbcJobExecutionDao jobExecutionDao = new JdbcJobExecutionDao();
        JdbcStepExecutionDao stepExecutionDao = new JdbcStepExecutionDao();
        SimpleJobRepository jobRepository = new SimpleJobRepository(jobInstanceDao, jobExecutionDao, stepExecutionDao,
                new JdbcExecutionContextDao());

        Step actualExampleJobStepResult = exchangeRateJobConfig.exampleJobStep(reader, itemProcessor, writer,
                new StepBuilderFactory(jobRepository, new ResourcelessTransactionManager()));
        assertEquals("exampleJobStep", actualExampleJobStepResult.getName());
        assertFalse(actualExampleJobStepResult.isAllowStartIfComplete());
        assertTrue(((TaskletStep) actualExampleJobStepResult).getTasklet() instanceof ChunkOrientedTasklet);
        assertEquals(Integer.MAX_VALUE, actualExampleJobStepResult.getStartLimit());
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJobStep2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: ItemReader must be provided
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        ItemProcessor itemProcessor = mock(ItemProcessor.class);
        ItemWriter<ExchangeRatesRequest> writer = mock(ItemWriter.class);
        JdbcJobInstanceDao jobInstanceDao = new JdbcJobInstanceDao();
        JdbcJobExecutionDao jobExecutionDao = new JdbcJobExecutionDao();
        JdbcStepExecutionDao stepExecutionDao = new JdbcStepExecutionDao();
        SimpleJobRepository jobRepository = new SimpleJobRepository(jobInstanceDao, jobExecutionDao, stepExecutionDao,
                new JdbcExecutionContextDao());

        exchangeRateJobConfig.exampleJobStep(null, itemProcessor, writer,
                new StepBuilderFactory(jobRepository, new ResourcelessTransactionManager()));
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJobStep3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.configuration.annotation.StepBuilderFactory.get(String)" because "stepBuilderFactory" is null
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ExchangeRateJobConfig()).exampleJobStep(mock(ItemReader.class), mock(ItemProcessor.class),
                mock(ItemWriter.class), null);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJobStep4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.batch.core.step.builder.StepBuilderException: java.lang.IllegalStateException: JobRepository is mandatory
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   java.lang.IllegalStateException: JobRepository is mandatory
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        ItemReader<ExchangeRatesRequest> reader = mock(ItemReader.class);
        ItemProcessor itemProcessor = mock(ItemProcessor.class);
        ItemWriter<ExchangeRatesRequest> writer = mock(ItemWriter.class);
        StepBuilderFactory stepBuilderFactory = mock(StepBuilderFactory.class);
        when(stepBuilderFactory.get(Mockito.<String>any())).thenReturn(new StepBuilder("Name"));
        exchangeRateJobConfig.exampleJobStep(reader, itemProcessor, writer, stepBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJobStep5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.step.builder.StepBuilder.chunk(int)" because the return value of "org.springframework.batch.core.configuration.annotation.StepBuilderFactory.get(String)" is null
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        ItemReader<ExchangeRatesRequest> reader = mock(ItemReader.class);
        ItemProcessor itemProcessor = mock(ItemProcessor.class);
        ItemWriter<ExchangeRatesRequest> writer = mock(ItemWriter.class);
        StepBuilderFactory stepBuilderFactory = mock(StepBuilderFactory.class);
        when(stepBuilderFactory.get(Mockito.<String>any())).thenReturn(null);
        exchangeRateJobConfig.exampleJobStep(reader, itemProcessor, writer, stepBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJobStep6() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.batch.core.step.builder.StepBuilderException: java.lang.IllegalStateException: JobRepository is mandatory
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   java.lang.IllegalStateException: JobRepository is mandatory
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        ItemReader<ExchangeRatesRequest> reader = mock(ItemReader.class);
        ItemProcessor itemProcessor = mock(ItemProcessor.class);
        ItemWriter<ExchangeRatesRequest> writer = mock(ItemWriter.class);
        StepBuilder stepBuilder = mock(StepBuilder.class);
        when(stepBuilder.chunk(anyInt())).thenReturn(new SimpleStepBuilder<>(
                new JsrBatchletStepBuilder(new JsrFaultTolerantStepBuilder<>(new StepBuilder("Name")))));
        StepBuilderFactory stepBuilderFactory = mock(StepBuilderFactory.class);
        when(stepBuilderFactory.get(Mockito.<String>any())).thenReturn(stepBuilder);
        exchangeRateJobConfig.exampleJobStep(reader, itemProcessor, writer, stepBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJobStep7() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.step.builder.SimpleStepBuilder.reader(org.springframework.batch.item.ItemReader)" because the return value of "org.springframework.batch.core.step.builder.StepBuilder.chunk(int)" is null
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        ItemReader<ExchangeRatesRequest> reader = mock(ItemReader.class);
        ItemProcessor itemProcessor = mock(ItemProcessor.class);
        ItemWriter<ExchangeRatesRequest> writer = mock(ItemWriter.class);
        StepBuilder stepBuilder = mock(StepBuilder.class);
        when(stepBuilder.chunk(anyInt())).thenReturn(null);
        StepBuilderFactory stepBuilderFactory = mock(StepBuilderFactory.class);
        when(stepBuilderFactory.get(Mockito.<String>any())).thenReturn(stepBuilder);
        exchangeRateJobConfig.exampleJobStep(reader, itemProcessor, writer, stepBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJobStep8() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.step.builder.SimpleStepBuilder.processor(org.springframework.batch.item.ItemProcessor)" because the return value of "org.springframework.batch.core.step.builder.SimpleStepBuilder.reader(org.springframework.batch.item.ItemReader)" is null
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        ItemReader<ExchangeRatesRequest> reader = mock(ItemReader.class);
        ItemProcessor itemProcessor = mock(ItemProcessor.class);
        ItemWriter<ExchangeRatesRequest> writer = mock(ItemWriter.class);
        FaultTolerantStepBuilder<Object, Object> faultTolerantStepBuilder = mock(FaultTolerantStepBuilder.class);
        when(faultTolerantStepBuilder.reader(Mockito.<ItemReader<Object>>any())).thenReturn(null);
        StepBuilder stepBuilder = mock(StepBuilder.class);
        when(stepBuilder.chunk(anyInt())).thenReturn(faultTolerantStepBuilder);
        StepBuilderFactory stepBuilderFactory = mock(StepBuilderFactory.class);
        when(stepBuilderFactory.get(Mockito.<String>any())).thenReturn(stepBuilder);
        exchangeRateJobConfig.exampleJobStep(reader, itemProcessor, writer, stepBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJobStep(ItemReader, ItemProcessor, ItemWriter, StepBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJobStep9() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.step.builder.SimpleStepBuilder.writer(org.springframework.batch.item.ItemWriter)" because the return value of "org.springframework.batch.core.step.builder.SimpleStepBuilder.processor(org.springframework.batch.item.ItemProcessor)" is null
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJobStep(ExchangeRateJobConfig.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        ItemReader<ExchangeRatesRequest> reader = mock(ItemReader.class);
        ItemProcessor itemProcessor = mock(ItemProcessor.class);
        ItemWriter<ExchangeRatesRequest> writer = mock(ItemWriter.class);
        FaultTolerantStepBuilder<Object, Object> faultTolerantStepBuilder = mock(FaultTolerantStepBuilder.class);
        when(faultTolerantStepBuilder.processor(Mockito.<ItemProcessor<Object, Object>>any())).thenReturn(null);
        FaultTolerantStepBuilder<Object, Object> faultTolerantStepBuilder2 = mock(FaultTolerantStepBuilder.class);
        when(faultTolerantStepBuilder2.reader(Mockito.<ItemReader<Object>>any())).thenReturn(faultTolerantStepBuilder);
        StepBuilder stepBuilder = mock(StepBuilder.class);
        when(stepBuilder.chunk(anyInt())).thenReturn(faultTolerantStepBuilder2);
        StepBuilderFactory stepBuilderFactory = mock(StepBuilderFactory.class);
        when(stepBuilderFactory.get(Mockito.<String>any())).thenReturn(stepBuilder);
        exchangeRateJobConfig.exampleJobStep(reader, itemProcessor, writer, stepBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    void testExampleJob() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        FlowStep exampleJobStep = new FlowStep();
        JdbcJobInstanceDao jobInstanceDao = new JdbcJobInstanceDao();
        JdbcJobExecutionDao jobExecutionDao = new JdbcJobExecutionDao();
        JdbcStepExecutionDao stepExecutionDao = new JdbcStepExecutionDao();
        Job actualExampleJobResult = exchangeRateJobConfig.exampleJob(exampleJobStep, new JobBuilderFactory(
                new SimpleJobRepository(jobInstanceDao, jobExecutionDao, stepExecutionDao, new JdbcExecutionContextDao())));
        assertTrue(actualExampleJobResult.getJobParametersIncrementer() instanceof RunIdIncrementer);
        assertTrue(actualExampleJobResult.isRestartable());
        assertEquals("exampleJob", actualExampleJobResult.getName());
        assertTrue(actualExampleJobResult.getJobParametersValidator() instanceof DefaultJobParametersValidator);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    void testExampleJob2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        FlowStep exampleJobStep = new FlowStep(new SimpleFlow("Inside example job"));
        JdbcJobInstanceDao jobInstanceDao = new JdbcJobInstanceDao();
        JdbcJobExecutionDao jobExecutionDao = new JdbcJobExecutionDao();
        JdbcStepExecutionDao stepExecutionDao = new JdbcStepExecutionDao();
        Job actualExampleJobResult = exchangeRateJobConfig.exampleJob(exampleJobStep, new JobBuilderFactory(
                new SimpleJobRepository(jobInstanceDao, jobExecutionDao, stepExecutionDao, new JdbcExecutionContextDao())));
        assertTrue(actualExampleJobResult.getJobParametersIncrementer() instanceof RunIdIncrementer);
        assertTrue(actualExampleJobResult.isRestartable());
        assertEquals(1, ((FlowJob) actualExampleJobResult).getStepNames().size());
        assertEquals("exampleJob", actualExampleJobResult.getName());
        assertTrue(actualExampleJobResult.getJobParametersValidator() instanceof DefaultJobParametersValidator);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    void testExampleJob3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        Step exampleJobStep = mock(Step.class);
        JdbcJobInstanceDao jobInstanceDao = new JdbcJobInstanceDao();
        JdbcJobExecutionDao jobExecutionDao = new JdbcJobExecutionDao();
        JdbcStepExecutionDao stepExecutionDao = new JdbcStepExecutionDao();
        Job actualExampleJobResult = exchangeRateJobConfig.exampleJob(exampleJobStep, new JobBuilderFactory(
                new SimpleJobRepository(jobInstanceDao, jobExecutionDao, stepExecutionDao, new JdbcExecutionContextDao())));
        assertTrue(actualExampleJobResult.getJobParametersIncrementer() instanceof RunIdIncrementer);
        assertTrue(actualExampleJobResult.isRestartable());
        assertEquals("exampleJob", actualExampleJobResult.getName());
        assertTrue(actualExampleJobResult.getJobParametersValidator() instanceof DefaultJobParametersValidator);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJob4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.batch.core.step.builder.StepBuilderException: java.lang.IllegalArgumentException: JobRepository must be set
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   java.lang.IllegalArgumentException: JobRepository must be set
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        FlowStep exampleJobStep = new FlowStep();
        exchangeRateJobConfig.exampleJob(exampleJobStep, new JobBuilderFactory(null));
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJob5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.configuration.annotation.JobBuilderFactory.get(String)" because "jobBuilderFactory" is null
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        exchangeRateJobConfig.exampleJob(new FlowStep(), null);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJob6() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.batch.core.step.builder.StepBuilderException: java.lang.IllegalArgumentException: JobRepository must be set
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   java.lang.IllegalArgumentException: JobRepository must be set
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        FlowStep exampleJobStep = new FlowStep();
        JobBuilderFactory jobBuilderFactory = mock(JobBuilderFactory.class);
        when(jobBuilderFactory.get(Mockito.<String>any())).thenReturn(new JobBuilder("Name"));
        exchangeRateJobConfig.exampleJob(exampleJobStep, jobBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJob7() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.job.builder.JobBuilder.incrementer(org.springframework.batch.core.JobParametersIncrementer)" because the return value of "org.springframework.batch.core.configuration.annotation.JobBuilderFactory.get(String)" is null
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        FlowStep exampleJobStep = new FlowStep();
        JobBuilderFactory jobBuilderFactory = mock(JobBuilderFactory.class);
        when(jobBuilderFactory.get(Mockito.<String>any())).thenReturn(null);
        exchangeRateJobConfig.exampleJob(exampleJobStep, jobBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJob8() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.batch.core.job.builder.FlowBuilderException: No state can be created for: null
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        JobBuilder jobBuilder = mock(JobBuilder.class);
        when(jobBuilder.incrementer(Mockito.<JobParametersIncrementer>any())).thenReturn(new JobBuilder("Name"));
        JobBuilderFactory jobBuilderFactory = mock(JobBuilderFactory.class);
        when(jobBuilderFactory.get(Mockito.<String>any())).thenReturn(jobBuilder);
        exchangeRateJobConfig.exampleJob(null, jobBuilderFactory);
    }

    /**
     * Method under test: {@link ExchangeRateJobConfig#exampleJob(Step, JobBuilderFactory)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExampleJob9() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.web.reactive.function.client.WebClient$Builder
        //   See https://diff.blue/R027 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.batch.core.job.builder.FlowBuilderException: java.lang.IllegalArgumentException: No start state was found. You must specify at least one step in a job.
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   java.lang.IllegalArgumentException: No start state was found. You must specify at least one step in a job.
        //       at com.rbc.bbp0.config.ExchangeRateJobConfig.exampleJob(ExchangeRateJobConfig.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        ExchangeRateJobConfig exchangeRateJobConfig = new ExchangeRateJobConfig();
        FlowStep exampleJobStep = new FlowStep();
        JobBuilder jobBuilder = mock(JobBuilder.class);
        when(jobBuilder.flow(Mockito.<Step>any()))
                .thenReturn(new JobFlowBuilder(new FlowJobBuilder(new JobBuilder("Name"))));
        JobBuilder jobBuilder2 = mock(JobBuilder.class);
        when(jobBuilder2.incrementer(Mockito.<JobParametersIncrementer>any())).thenReturn(jobBuilder);
        JobBuilderFactory jobBuilderFactory = mock(JobBuilderFactory.class);
        when(jobBuilderFactory.get(Mockito.<String>any())).thenReturn(jobBuilder2);
        exchangeRateJobConfig.exampleJob(exampleJobStep, jobBuilderFactory);
    }
}

