package org.example;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // which packages to scan for Annotations(like @Component)
        context.scan("org.example");

        context.refresh();

        PasswordHasher bean = context.getBean(PasswordHasher.class);
        System.out.println(bean);
        System.out.println(bean.hash("Hello"));
        StringBuilder bean3 = context.getBean(StringBuilder.class);
        StringBuilder bean3a = context.getBean(StringBuilder.class);
        StringBuilder bean3b = context.getBean(StringBuilder.class);
//        context.getBean()
        System.out.println(bean3);
        System.out.println(bean3a);
        System.out.println(bean3b);
//        create an object of data source and injext into the spring conext
        Calc bean4 = context.getBean(Calc.class);
        int sum = bean4.add(4,5);
        System.out.println(sum);
        String []beanss = context.getBeanDefinitionNames();
        for(String beanName: beanss){
            System.out.println(beanName);
        }
        Object bean5 = context.getBean("getMyCalc");
//        Object bean6 = context.getBean("getCalc");
        Object bean6 = context.getBean("getDataSource");
        System.out.println(bean6);

//        xml file content
        /*ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("beans.xml");
        xmlContext.refresh();
        StringBuilder bean9 = xmlContext.getBean(StringBuilder.class);
        System.out.println(bean9);*/
        UserVerifier bean10 = context.getBean(UserVerifier.class);
        bean10.verfiyUser();

        context.close();
    }
}
