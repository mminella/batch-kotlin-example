package io.spring.configuration

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Michael Minella
 */
@Configuration
@EnableBatchProcessing
class BatchConfiguration {

    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory

    @Bean
    fun step1() = stepBuilderFactory.get("step1")
            .tasklet { stepContribution, chunkContext ->
                println("This is a batch job in Kotlin")
                RepeatStatus.FINISHED
            }
            .build()

    @Bean
    fun job() = jobBuilderFactory.get("job1")
            .start(step1())
            .build()
}