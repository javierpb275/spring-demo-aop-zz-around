package com.javi.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//Spring Pure Java Configuration
@EnableAspectJAutoProxy//Spring AOP Proxy Support
@ComponentScan("com.javi.aopdemo")//Component scan for components and aspects (Recurse packages)
public class DemoConfig {

}
