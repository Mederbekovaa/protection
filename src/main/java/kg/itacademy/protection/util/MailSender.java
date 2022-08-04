//package kg.itacademy.protection.util;
//
//import org.springframework.core.env.Environment;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import javax.mail.internet.MimeMessage;
//import java.util.Objects;
//
//@Component
//public class MailSender {
//    final JavaMailSender javaMailSender;
//    final Environment environment;
//
//    public MailSender(JavaMailSender javaMailSender, Environment environment) {
//        this.javaMailSender = javaMailSender;
//        this.environment = environment;
//    }
//
//    public boolean sendMail(String email, String text) {
//        try {
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//            mimeMessage.setSubject("Код на подтверждение родителя", "UTF-8");
//
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//            mimeMessageHelper.setFrom(Objects.requireNonNull(environment.getProperty("spring.mail.username")));
//            mimeMessageHelper.setTo(email);
//            mimeMessageHelper.setText(text, true);
//            javaMailSender.send(mimeMessage);
//
//            return true;
//        } catch (Exception ignored) {
//            return false;
//        }
//    }
//}
