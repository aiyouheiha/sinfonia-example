# Sending Email via Spring Boot

- [Back to Home Page](https://aiyouheiha.github.io/)

----------------------------------------

## 参考

- [163免费邮客户端设置的POP3、SMTP、IMAP地址](http://help.163.com/09/1223/14/5R7P3QI100753VB8.html)
- [35. Sending email](http://docs.spring.io/spring-boot/docs/1.5.6.RELEASE/reference/htmlsingle/#boot-features-email)

----------------------------------------

## 1. 网易邮件收发服务

网易邮箱支持POP3/SMTP/IMAP服务，方便您可以通过电脑客户端软件更好地收发邮件！

网易163免费邮箱相关服务器信息：

| 服务器名称 | 服务器地址   | SSL协议端口号 | 非SSL协议端口号 |
| :--------- | :----------- | :------------ | :-------------- |
| IMAP       | imap.163.com | 993           | 143             |
| SMTP       | smtp.163.com | 465/994       | 25              |
| POP3       | pop.163.com  | 995           | 110             |

- **PS** 需要登录邮箱，找到 `设置 -> 客户端授权密码` ，设置授权码后，方可在程序中发送邮件
    - `3. settings` 中的 `spring.mail.password` 配置项为授权密码，而非邮箱登录密码

## 2. pom

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

## 3. settings

> application.properties

```
spring.mail.host=smtp.163.com
spring.mail.port=25
spring.mail.username=username@163.com
spring.mail.password=password
```

## 4. example

### util to send email

```
@Component
public class MailUtil {
    private static MailSender mailSender;

    @Autowired
    public MailUtil(MailSender mailSender) {
        MailUtil.mailSender = mailSender;
    }

    public static void send(String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("username@163.com");
        message.setTo("to_username@xxx.com");
        message.setSubject("This is one test email");
        message.setText(text);
        mailSender.send(message);
    }
}
```

### api call util to send email

```
@RestController
@RequestMapping("/v1/example")
public class ExampleController {
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public void info() {
        MailUtil.send("example info has been called");
    }
}
```

> Run application and call localhost:8080/v1/example/info, the mail will be sent.