package ro.tafacprogramator.m4.contactapppregatire;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactTest {
    
    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldHaveContacts() throws Exception {
        this.mockMvc
        .perform(get("/contacts"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()", Matchers.greaterThan(2)));
    }

    // TODO do the same test with rest-assured

}
