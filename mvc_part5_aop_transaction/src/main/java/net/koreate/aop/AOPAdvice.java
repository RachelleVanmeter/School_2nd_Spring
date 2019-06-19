package net.koreate.aop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.koreate.vo.MessageVo;

@Slf4j
@Component
@Aspect
public class AOPAdvice {
	
	@Before("execution(* net.koreate.service.MessageService*.*(..))")
	public void startLog(JoinPoint join) {
		log.info("------------------------------------------------");
		log.info("------------    START LOG BEFORE    ------------");
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		String date = format.format(new Date());
		log.info("startTime : " + date);
		log.info("target : " + join.getTarget());
		log.info("type : " + join.getKind());
		log.info("parameters : " + Arrays.toString(join.getArgs()));
		log.info("------------     END LOG BEFORE     ------------");
		log.info("------------------------------------------------");
	}
	
	@After("execution(* net.koreate.service.MessageService*.*(..))")
	public void endLog(JoinPoint join) {
		log.info("------------------------------------------------");
		log.info("------------     END LOG BEFORE     ------------");
		log.info("target : " + join.getTarget());
		log.info("type : " + join.getKind());
		log.info("parameters : " + Arrays.toString(join.getArgs()));
		log.info("name : " + join.getSignature().getName());
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		String date = format.format(new Date());
		log.info("endTime : " + date);
		log.info("------------       END LOG END      ------------");
		log.info("------------------------------------------------");
	}
	
	@Around("execution(* net.koreate.service.MessageServiceImpl.readMessage(..))")
	public Object timeLlog(ProceedingJoinPoint pjp) throws Throwable {
		log.info("------------------------------------------------");
		log.info("------      START Around LOG BEFORE       ------");
		long startTime = System.currentTimeMillis();
		
		Object o = pjp.proceed();
		MessageVo message = (MessageVo) o;
		message.setMessage("수정");
		log.info("Obj : " + o.toString());
		
		long endTime = System.currentTimeMillis();
		log.info(pjp.getSignature().getName() + " 걸린시간 : " + (endTime - startTime));
		log.info("------       END Around LOG BEFORE        ------");
		log.info("------------------------------------------------");
		return o;
	}
	
}
