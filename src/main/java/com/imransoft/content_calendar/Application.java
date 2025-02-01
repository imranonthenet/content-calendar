package com.imransoft.content_calendar;

import com.imransoft.content_calendar.model.Content;
import com.imransoft.content_calendar.model.Status;
import com.imransoft.content_calendar.model.Type;
import com.imransoft.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		RestTemplate restTemplate = (RestTemplate)context.getBean("restTemplate");
		System.out.println(restTemplate);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(ContentRepository repository){
//		System.out.println("hello imran");
//		return args -> {
//			Content c = new Content(
//					null,
//					"Java Spring Boot",
//					"Java Development",
//					Status.IN_PROGRESS,
//					Type.VIDEO,
//					LocalDateTime.now(),
//					null,
//					""
//			);
//			repository.save(c);
//		};
//	}

}
