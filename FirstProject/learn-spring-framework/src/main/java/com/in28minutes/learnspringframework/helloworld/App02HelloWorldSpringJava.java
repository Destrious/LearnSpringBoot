package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpringJava {
    public static void main(String[] args) {

        // Launch a Spring Context
        try(var context =
                    new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // Configure the things that we want Spring to manage - @Configuration
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person5Qualifier"));

            // System.out.println - (use streams to print out all beans)
//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);


        }






    }

}
