package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp
{
    public static void main(String args[])
    {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
