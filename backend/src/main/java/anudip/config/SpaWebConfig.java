package anudip.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaWebConfig {

    // Forwards any non-API, non-static browser route (e.g. /register, /login,
    // /dashboard) back to index.html so React Router can handle it client-side.
    // Excludes anything with a file extension (e.g. index.html, main.js, style.css)
    // to avoid re-matching the forwarded index.html and causing an infinite loop.
    @RequestMapping(value = {
            "/{path:^(?!api)(?!.*\\.).*$}",
            "/{path:^(?!api)(?!.*\\.).*$}/**"
    })
    public String forward() {
        return "forward:/index.html";
    }
}