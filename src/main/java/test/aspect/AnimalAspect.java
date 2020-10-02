package test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnimalAspect {

    @Pointcut("execution(* test.Animal.voice(..))")
    public void voicePoint(){
    }

    @Pointcut("execution(* test.Animal.eat(..))")
    public void eatPoint() {
    }

    @Pointcut("within(test.Fish)")
    public void fishPoint() {
    }

    @After(value = "voicePoint()")
    public void afterVoice(JoinPoint joinPoint) {
        System.out.println("Try to add food to the hungry " + joinPoint.getTarget().getClass().getSimpleName());
    }

    @Before(value = "eatPoint()")
    public void beforeEat(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getSimpleName() + " started to eat");
    }

    @After(value = "eatPoint()")
    public void afterEat(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getSimpleName() + " finished to eat");
    }

    @AfterThrowing(value = "eatPoint()", throwing = "ex")
    public void eatFailed(Throwable ex) {
        System.out.println("eat failed: " + ex.getMessage());
    }

    @AfterReturning(value = "eatPoint()")
    public void eatSuccess(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().getClass().getSimpleName() + "eat success");
    }

//    @Around(value = "eatPoint() && args(food) && !fishPoint()")
//    public Object eatAround(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
//        String target = proceedingJoinPoint.getTarget().getClass().toString();
//        if (LocalDateTime.now().isAfter(food.getExpirationDate())){
//            return false;
//        }
//        System.out.println(target + " start eat");
//        try {
//            Object result = proceedingJoinPoint.proceed();
//            System.out.println(target + " eat success");
//            System.out.println(target + " end eat");
//            return result;
//        } catch (Throwable e) {
//            System.out.println(target + " eat failed: " + e.getMessage());
//            throw e;
//        }
//    }

//    @Around(value = "eatPoint() && args(food) && fishPoint()")
//    public Object validateEatForFish(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
//        if (Objects.equals(food.getFoodName(), "fish")) {
//            return false;
//        } else {
//            return eatAround(proceedingJoinPoint, food);
//        }
//    }
}
