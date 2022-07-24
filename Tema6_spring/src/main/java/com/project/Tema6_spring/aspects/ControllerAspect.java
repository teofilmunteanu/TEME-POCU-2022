package com.project.Tema6_spring.aspects;

import com.project.Tema6_spring.model.User;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Pointcut("within(com.project.Tema6_spring.controller.UserController)")
    private void userControllerMethod(){

    }


    @Pointcut("within(com.project.Tema6_spring.controller.CarInsuranceControllerDev)")
    private void carControllerMethod(){

    }


    @Pointcut("execution(* com.project.Tema6_spring.controller.HouseInsuranceController.getHouseInsurancePrice(..))")
    private void houseControllerMethod(){

    }



    @Before("userControllerMethod() && execution(* create*(..)) && args(user,..)")
    private void logCreateUser(User user){
        log.info("Received request to create user: " + user.toString());
    }

    @Before("userControllerMethod() && execution(* getUser(..)) && args(id,..)")
    private void logGetUser(int id){
        log.info("Received request to retrieve user with id: " + id);
    }

    @Before("userControllerMethod() && execution(* getUsers(..)) && args()")
    private void logGetUsers(){
        log.info("Received request to retrieve all users");
    }

    @Before("userControllerMethod() && execution(* delete*(..)) && args(id,..)")
    private void logDeleteUser(int id){
        log.info("Received request to delete user with id: " + id);
    }


    @Before("execution(* getCarInsurancePrice(..)) && args(id)")
    private void getCarInsurancePrice(int id){
        log.info("Received request to calculate insurance price for car with id: " + id);
    }


    /* Logging every method from user */
    @Around("userControllerMethod()")
    private Object logControllerMethod(ProceedingJoinPoint joinPoint){
        log.info("Controller method invoked: " + joinPoint.getSignature().getName());

        try{
            return joinPoint.proceed();
        }
        catch(Throwable e){
            throw new RuntimeException(e);
        }
        finally{
            log.info("User method executed");
        }
    }


    /* Logging every method from car + get price if getCarInsurancePrice method was called(if the result is just the price)*/
    @Around("carControllerMethod()")
    private Object logCarInsuranceControllerMethod(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        log.info("CarInsuranceController method invoked: " + joinPoint.getSignature().getName());

        try{
            Object res = joinPoint.proceed();

            if(res instanceof Double){
                log.info("Price of car insurance: " + res);
            }

            return res;
        }
        catch(Throwable e){
            throw new RuntimeException(e);
        }
        finally{
            log.info("CarInsurance method executed");
        }
    }

    /* Logging only the insurance price method from house */
    @Around("houseControllerMethod()")
    private Object logHouseInsuranceControllerMethod(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();

        log.info("HouseInsuranceController method invoked: " + joinPoint.getSignature().getName());

        try{
            Object res = joinPoint.proceed();
            log.info("Received request to calculate insurance price for house with id: " + args[0]);
            log.info("Price of house insurance: " + res);

            return res;
        }
        catch(Throwable e){
            throw new RuntimeException(e);
        }
        finally{
            log.info("HouseInsurance method executed");
        }
    }
}
