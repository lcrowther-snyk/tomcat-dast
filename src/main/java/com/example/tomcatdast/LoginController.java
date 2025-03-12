package com.example.tomcatdast;

    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    import javax.servlet.http.HttpSession;
    import java.util.HashMap;
    import java.util.Map;

    @RestController
    public class LoginController {
        private Map<String, String> inMemoryDb = new HashMap<>();

        public LoginController() {
            // Pre-populate the in-memory database with a user
            inMemoryDb.put("user", "password");
        }

        @PostMapping("/login")
        public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
            if (inMemoryDb.containsKey(username) && inMemoryDb.get(username).equals(password)) {
                session.setAttribute("user", username);
                return "Login successful! <a href='/admin'>Go to Admin Page</a>";
            } else {
                return "Invalid username or password.";
            }
        }
    }