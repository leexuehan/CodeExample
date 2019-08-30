package aop.demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * @author leexuehan on 2019/8/30.
 */
public class MainApp {
    public static void main(String[] args) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("Beans.xml");
//        Student student = (Student) context.getBean("student");
//        student.getName();
//        student.getAge();
//        student.printThrowException();
//        Foo foo = (Foo) context.getBean("foo");
//        foo.doSomething("params");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Foo.class);
        enhancer.setCallback(new FooCallback());

        Foo fooProxy = (Foo) enhancer.create();
        fooProxy.doSomething("hahaha");
    }

    static class FooCallback implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            if (method.getName().equals("doSomething")) {
                System.out.println("before method:doSomething");

                System.out.println("after method:doSomething");
                return methodProxy.invokeSuper(o, objects);

            }
            return null;
        }
    }
}
