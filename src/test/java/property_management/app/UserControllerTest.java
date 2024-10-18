package property_management.app;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import property_management.app.controller.UserController;

@WebMvcTest(UserController.class) // UserController is the class we are testing
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testOpenLoginPage() throws Exception {
        
        mockMvc.perform(get("/openLoginPage"))
                .andExpect(status().isOk()) 
                .andExpect(view().name("user_login")); 
    }
}
