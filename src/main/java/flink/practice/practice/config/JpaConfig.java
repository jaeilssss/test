package flink.practice.practice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // config파일이다 라는것을 의미 (설정파일)
@EnableJpaAuditing //활성화 시키겠다는 의미
public class JpaConfig {
}
