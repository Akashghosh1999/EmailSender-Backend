package emailsenderapp.test.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

public interface EmailService {
    //  send email to single person
    void sendEmail(String to, String subject, String message);

    //send email multiple person

    void sendEmail(String []to, String subject, String message);

    //send email with html

    void sendEmailWithHtml(String to, String subject, String htmlContent);

    //send email with file

    void sendEmailWithFile(String to, String subject, String message, File file);


    void sendEmailWithFile(String to, String subject, String message, InputStream is);

}
