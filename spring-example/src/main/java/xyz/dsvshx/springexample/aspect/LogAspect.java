package xyz.dsvshx.springexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component //让spring能够扫描到
@Aspect //定义这是一个切面类
public class LogAspect {

    /**
     * modifier-pattern：用于匹配public、private等访问修饰符
     * ret-type-pattern：用于匹配返回值类型，不可省略
     * declaring-type-pattern：用于匹配包类型
     * modifier-pattern（param-pattern）：用于匹配类中的方法，不可省略
     * throws-pattern：用于匹配抛出异常的方法
     * <p>
     * <p>
     * 多个表达式之间使用连接符匹配多个条件， 如使用||表示“或”，使用 &&表示“且”
     */
    @Pointcut("@annotation(xyz.dsvshx.springexample.annotation.LogAop) &&" +
            "execution(public * xyz.dsvshx.springexample.service.impl.AopTestServiceImpl.get*(..))")
    public void log() {

    }

    /**
     * 匹配com.example.demo.service.impl包下所有类下的方法名以update结尾、参数类型不限的public方法
     */
    @Pointcut("execution(public * xyz.dsvshx.springexample.service.impl.*.*update(..))")
    public void say() {

    }

    @Order(2)
    @Before("log()")
    public void beforeLog2() {
        System.out.println("后执行，增加log()方法...");
    }

    @Order(1) // Order 代表优先级，数字越小优先级越高
    @Before("log()||say()") //多个的话用 @Before("log()||say()")
    public void beforeLog1() {
        System.out.println("先执行，增加log()方法...");
    }

    /**
     * Advice注解一共有五种，分别是：
     * 1.@Before前置通知
     * 前置通知在切入点运行前执行，不会影响切入点的逻辑
     * 2.@After后置通知
     * 后置通知在切入点正常运行结束后执行，如果切入点抛出异常，则在抛出异常前执行
     * 3.@AfterThrowing异常通知
     * 异常通知在切入点抛出异常前执行，如果切入点正常运行（未抛出异常），则不执行
     * 4.@AfterReturning返回通知
     * 返回通知在切入点正常运行结束后执行，如果切入点抛出异常，则不执行
     * 5.@Around环绕通知
     * 环绕通知是功能最强大的通知，可以在切入点执行前后自定义一些操作。环绕通知需要负责决定是继续处理join point(调用ProceedingJoinPoint的proceed方法)还是中断执行
     */
    @Before("say()")
    public void beforeSay() {
        System.out.println("增加say()方法...");
    }
}
