package aop.demo;

/**
 * @author leexuehan on 2019/8/30.
 */
public  class Foo {
    public String doSomething(String arg){
        System.out.println("do something in Foo!");
        return arg;
    }
}
