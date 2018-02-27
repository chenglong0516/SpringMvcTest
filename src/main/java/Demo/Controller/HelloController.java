package Demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/say")
    public @ResponseBody String say() {
        return "hello, world! This com from springMvc!";
    }
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
