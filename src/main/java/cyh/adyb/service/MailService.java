package cyh.adyb.service;

import cyh.adyb.domain.Mail;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService{
    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "jkijki1249@gmail.com";

    public void mailSend(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(MailService.FROM_ADDRESS);
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(mail.getTitle());

        message.setText(mail.getMessage() + "  작성자 번호 = " + mail.getPhoneNumber() + "  회신받을 이메일 = " + mail.getAddress());

        mailSender.send(message);
    }

};