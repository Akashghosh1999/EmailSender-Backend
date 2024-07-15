package emailsenderapp.test.controller;

import emailsenderapp.test.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    //send email
    @PostMapping("/send")
    public ResponseEntity<?>sendEmail(@RequestBody EmailRequest request){
        emailService.sendEmailWithHtml(request.getTo(), request.getSubject(), request.getMessage());
        return ResponseEntity.ok(CustomResponse.builder().message("Email send Successfully !!").httpStatus(HttpStatus.OK).success(true).build());

    }

    //send email with file
    @PostMapping(value = "/send-with-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?>sendWithFile(@RequestPart("request") EmailRequest request, @RequestPart("file") MultipartFile file) throws MessagingException, IOException {
        emailService.sendEmailWithFile(request.getTo(), request.getSubject(), request.getMessage(), file.getInputStream());
        return ResponseEntity.ok(CustomResponse.builder().message("Email send Successfully !!").httpStatus(HttpStatus.OK).success(true).build());
    }


}
