package kg.itacademy.protection.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Objects;

@Component
@AllArgsConstructor
@Slf4j
public class MailSenderComponent {
    private final JavaMailSender javaMailSender;
    private final Environment environment;

    public boolean sendMail(String email, String text) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setSubject("Код на подтверждение родителя", "UTF-8");

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setFrom(Objects.requireNonNull(environment.getProperty("spring.mail.username")));
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setText(text, true);
            javaMailSender.send(mimeMessage);

            return true;
        } catch (Exception ignored) {
            log.error(ignored.getMessage(), ignored);
            return false;
        }
    }
}
