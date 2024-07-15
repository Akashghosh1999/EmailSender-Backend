package emailsenderapp.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import emailsenderapp.test.services.EmailService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailService emailService;

    @Test
    void emailSendTest(){
        System.out.println("sending email");
        emailService.sendEmail("akash.ghosh2605@gmail.com", "Email from Spring Boot", "This email is send using spring boot while creating email service.");
    }

    @Test
    void sendHtmlInEmail(){
        String html=""+"<h1 style='color:red; border:1px solid red;'>Hello World</h1>"+"";
        emailService.sendEmailWithHtml("akash.ghosh2605@gmail.com","Email from Spring Boot",html);
    }

    @Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile(
                "akash.ghosh2605@gmail.com",
                "Email with file",
                "this email contains file",
                new File("C:\\Users\\akash\\Downloads\\test\\test\\src\\main\\resources\\static\\self_photo_graph.png"));
    }

    @Test
    void sendEmailWithFileWithStream(){
        File file=new File("C:\\Users\\akash\\Downloads\\test\\test\\src\\main\\resources\\static\\self_photo_graph.png");
        try {
            InputStream inputStream=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        emailService.sendEmailWithFile(
                "akash.ghosh2605@gmail.com",
                "Email with file",
                "this email contains file", InputStream.nullInputStream()
                );
    }
}
