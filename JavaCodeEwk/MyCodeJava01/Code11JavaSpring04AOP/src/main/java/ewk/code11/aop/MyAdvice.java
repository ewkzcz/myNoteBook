package ewk.code11.aop;

import ewk.code11.data.Brand;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

@Component
@Aspect
public class MyAdvice {
    // AOP
    @Pointcut("execution(void ewk.code11.dao.BookDao.update())")
    // @Pointcut("execution(void ewk.code11.dao.BookDao.update1())")
    private void pt() {
    }

    @Pointcut("execution(int ewk.code11.dao.BookDao.show())")
    private void pt1() {
    }

    @Before("pt()")
    public void method() {
        System.out.println(System.currentTimeMillis());
    }

    @Around("pt1()")
    public int show(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        int num = (int) proceedingJoinPoint.proceed();
        System.out.println("around after");
        return num;
    }

    // 业务层接口万次执行时间
    @Pointcut("execution(* ewk.code11.service.BrandServiceInterface.selectAll())")
    private void pt2() {
    }

    @Around("pt2()")
    public List<Brand> selectAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 类信息
        Signature signature = proceedingJoinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            proceedingJoinPoint.proceed();
        }
        long end = System.currentTimeMillis();
        System.out.println("万次执行" + className + "." + methodName
                + "耗费时间:" + (end - start) + "ms");
        List<Brand> brands = (List<Brand>) proceedingJoinPoint.proceed();
        return brands;
    }

    // JoinPoint
    @Pointcut("execution(String ewk.code11.dao.BookDao.test(..))")
    private void pt3() {
    }

    /* JoinPoint获取
    @Before("pt3()")
    public void test(JoinPoint joinPoint) {
        System.out.println("before");
        Object[] objects = joinPoint.getArgs();
        System.out.println(Arrays.toString(objects));
    }
    */
    // ProceedingJoinPoint获取并修改
    @Around("pt3()")
    public void test(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around");
        Object[] objects = proceedingJoinPoint.getArgs();
        objects[0] = 666;
        proceedingJoinPoint.proceed(objects);
        System.out.println(Arrays.toString(objects));
    }

    @Pointcut("execution(String ewk.code11.dao.BookDao.testAfterReturning(..))")
    private void pt4() {
    }

    @AfterReturning(value = "pt4()",returning = "ret")
    public void testAfterReturning(Object ret){
        System.out.println("testAfterReturning "+ret);
    }
}
