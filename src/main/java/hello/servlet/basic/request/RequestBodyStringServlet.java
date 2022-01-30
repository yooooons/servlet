package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet",urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();//메세지 바디내용을 바이트코드로 바로 획득가능
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//스프링 제공 바이트->스트링, 바이트를 문자로 변환할때는 항상 어떤 인코딩인지 알려 줘야한다
        System.out.println("messageBody = " + messageBody);

        resp.getWriter().write("OK");

    }
}
