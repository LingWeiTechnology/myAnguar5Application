package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.MyAnguar5ApplicationApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the FarmDataController REST controller.
 *
 * @see FarmDataControllerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAnguar5ApplicationApp.class)
public class FarmDataControllerResourceIntTest {

    private MockMvc restMockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        FarmDataControllerResource farmDataControllerResource = new FarmDataControllerResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(farmDataControllerResource)
            .build();
    }

    /**
    * Test create
    */
    @Test
    public void testCreate() throws Exception {
        restMockMvc.perform(post("/api/farm-data-controller/create"))
            .andExpect(status().isOk());
    }
    /**
    * Test get
    */
    @Test
    public void testGet() throws Exception {
        restMockMvc.perform(get("/api/farm-data-controller/get"))
            .andExpect(status().isOk());
    }
    /**
    * Test update
    */
    @Test
    public void testUpdate() throws Exception {
        restMockMvc.perform(post("/api/farm-data-controller/update"))
            .andExpect(status().isOk());
    }

}
