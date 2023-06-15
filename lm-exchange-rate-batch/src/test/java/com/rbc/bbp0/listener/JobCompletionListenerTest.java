package com.rbc.bbp0.listener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;

class JobCompletionListenerTest {
    @Test
    void testAfterJob() {
        JobCompletionListener jobCompletionListener = new JobCompletionListener();
        JobExecution jobExecution = new JobExecution(1L);
        jobCompletionListener.afterJob(jobExecution);
        assertFalse(jobExecution.isRunning());
        assertTrue(jobExecution.getStepExecutions().isEmpty());
        assertEquals(BatchStatus.STARTING, jobExecution.getStatus());
        assertTrue(jobExecution.getFailureExceptions().isEmpty());
        assertEquals(1L, jobExecution.getId().longValue());
    }

    @Test
    void testAfterJob2() {
        JobCompletionListener jobCompletionListener = new JobCompletionListener();

        JobExecution jobExecution = new JobExecution(1L);
        jobExecution.setStatus(BatchStatus.COMPLETED);
        jobCompletionListener.afterJob(jobExecution);
        assertFalse(jobExecution.isRunning());
        assertTrue(jobExecution.getStepExecutions().isEmpty());
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        assertTrue(jobExecution.getFailureExceptions().isEmpty());
        assertEquals(1L, jobExecution.getId().longValue());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testAfterJob3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.JobExecution.getStatus()" because "jobExecution" is null
        //       at com.rbc.bbp0.listener.JobCompletionListener.afterJob(JobCompletionListener.java:11)
        //   See https://diff.blue/R013 to resolve this issue.

        (new JobCompletionListener()).afterJob(null);
    }

    @Test
    void testAfterJob4() {
        JobCompletionListener jobCompletionListener = new JobCompletionListener();

        JobExecution jobExecution = new JobExecution(1L);
        jobExecution.setEndTime(mock(Date.class));
        jobCompletionListener.afterJob(jobExecution);
        assertFalse(jobExecution.isRunning());
        assertTrue(jobExecution.getStepExecutions().isEmpty());
        assertEquals(BatchStatus.STARTING, jobExecution.getStatus());
        assertTrue(jobExecution.getFailureExceptions().isEmpty());
        assertEquals(1L, jobExecution.getId().longValue());
    }
}

