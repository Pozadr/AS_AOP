package pl.pozadr.aop.aspect.email;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pl.pozadr.aop.service.email.EmailService;
import pl.pozadr.aop.service.email.EmailServiceImpl;

@Aspect
@Component
public class EmailAspect {
    private final EmailService emailService;

    public EmailAspect(EmailServiceImpl emailServiceImpl) {
        emailService = emailServiceImpl;
    }

    @After("@annotation(pl.pozadr.aop.aspect.email.SendEmail)")
    public void sendEmailAfter() {
        emailService.sendEmail();
    }
}
