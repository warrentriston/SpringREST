package edu.primefocus.jobguru.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class LoginAspect {

    @AfterThrowing(value = "execution(* edu.primefocus.jobguru.serviceimpl.LoginServiceImpl.create(..))", throwing = "ex")
    public void logForException(Exception ex){
        log.debug("Error when creating login");
    }
}
