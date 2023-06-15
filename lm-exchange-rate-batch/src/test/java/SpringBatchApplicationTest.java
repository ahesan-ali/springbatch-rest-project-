import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SpringBatchApplicationTest {
    /**
     * Method under test: {@link SpringBatchApplication#run(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRun() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.batch.core.launch.JobLauncher.run(org.springframework.batch.core.Job, org.springframework.batch.core.JobParameters)" because "this.jobLauncher" is null
        //       at SpringBatchApplication.run(SpringBatchApplication.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        (new SpringBatchApplication()).run("Strings");
    }

    /**
     * Method under test: {@link SpringBatchApplication#newExecution()}
     */
    @Test
    void testNewExecution() {
        assertTrue((new SpringBatchApplication()).newExecution().isEmpty());
    }
}

