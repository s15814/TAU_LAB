package tv.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TvShowControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void ReturnListOfTvShows() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tvshows")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Lost"))
                .andExpect(jsonPath("$[0].numberOfSeasons").value(6))
                .andExpect(jsonPath("$[0].directorsName").value("Director's Name"))
                .andExpect(jsonPath("$[0].platform").value("TV"));
    }

    @Test
    public void ReturnCorrectTvShowIfExists() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tvshows/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Lost"))
                .andExpect(jsonPath("$.numberOfSeasons").value(6))
                .andExpect(jsonPath("$.directorsName").value("Director's Name"))
                .andExpect(jsonPath("$.platform").value("TV"));
    }

    @Test
    public void ErrorWhenTvShowDoesntExist() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/tvshows/4")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
