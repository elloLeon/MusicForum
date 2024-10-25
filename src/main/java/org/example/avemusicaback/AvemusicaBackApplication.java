package org.example.avemusicaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class AvemusicaBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvemusicaBackApplication.class, args);
    }

}
