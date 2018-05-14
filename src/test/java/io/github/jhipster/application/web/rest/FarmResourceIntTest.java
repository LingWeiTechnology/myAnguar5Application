package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.MyAnguar5ApplicationApp;

import io.github.jhipster.application.domain.Farm;
import io.github.jhipster.application.repository.FarmRepository;
import io.github.jhipster.application.service.FarmService;
import io.github.jhipster.application.service.dto.FarmDTO;
import io.github.jhipster.application.service.mapper.FarmMapper;
import io.github.jhipster.application.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the FarmResource REST controller.
 *
 * @see FarmResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAnguar5ApplicationApp.class)
public class FarmResourceIntTest {

    private static final String DEFAULT_COMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_LOCATION = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_LEGAL_PERSON = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_LEGAL_PERSON = "BBBBBBBBBB";

    private static final String DEFAULT_REGISTERED_CAPITAL = "AAAAAAAAAA";
    private static final String UPDATED_REGISTERED_CAPITAL = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_WEB_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_WEB_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_SCOPE = "AAAAAAAAAA";
    private static final String UPDATED_SCOPE = "BBBBBBBBBB";

    private static final Float DEFAULT_LONGITUDE = 1F;
    private static final Float UPDATED_LONGITUDE = 2F;

    private static final Float DEFAULT_LATITUDE = 1F;
    private static final Float UPDATED_LATITUDE = 2F;

    private static final String DEFAULT_PROVINCE = "AAAAAAAAAA";
    private static final String UPDATED_PROVINCE = "BBBBBBBBBB";

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private FarmMapper farmMapper;

    @Autowired
    private FarmService farmService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restFarmMockMvc;

    private Farm farm;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final FarmResource farmResource = new FarmResource(farmService);
        this.restFarmMockMvc = MockMvcBuilders.standaloneSetup(farmResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Farm createEntity(EntityManager em) {
        Farm farm = new Farm()
            .companyName(DEFAULT_COMPANY_NAME)
            .companyLocation(DEFAULT_COMPANY_LOCATION)
            .companyLegalPerson(DEFAULT_COMPANY_LEGAL_PERSON)
            .registeredCapital(DEFAULT_REGISTERED_CAPITAL)
            .email(DEFAULT_EMAIL)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .createDate(DEFAULT_CREATE_DATE)
            .address(DEFAULT_ADDRESS)
            .webAddress(DEFAULT_WEB_ADDRESS)
            .scope(DEFAULT_SCOPE)
            .longitude(DEFAULT_LONGITUDE)
            .latitude(DEFAULT_LATITUDE)
            .province(DEFAULT_PROVINCE);
        return farm;
    }

    @Before
    public void initTest() {
        farm = createEntity(em);
    }

    @Test
    @Transactional
    public void createFarm() throws Exception {
        int databaseSizeBeforeCreate = farmRepository.findAll().size();

        // Create the Farm
        FarmDTO farmDTO = farmMapper.toDto(farm);
        restFarmMockMvc.perform(post("/api/farms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(farmDTO)))
            .andExpect(status().isCreated());

        // Validate the Farm in the database
        List<Farm> farmList = farmRepository.findAll();
        assertThat(farmList).hasSize(databaseSizeBeforeCreate + 1);
        Farm testFarm = farmList.get(farmList.size() - 1);
        assertThat(testFarm.getCompanyName()).isEqualTo(DEFAULT_COMPANY_NAME);
        assertThat(testFarm.getCompanyLocation()).isEqualTo(DEFAULT_COMPANY_LOCATION);
        assertThat(testFarm.getCompanyLegalPerson()).isEqualTo(DEFAULT_COMPANY_LEGAL_PERSON);
        assertThat(testFarm.getRegisteredCapital()).isEqualTo(DEFAULT_REGISTERED_CAPITAL);
        assertThat(testFarm.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testFarm.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
        assertThat(testFarm.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testFarm.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testFarm.getWebAddress()).isEqualTo(DEFAULT_WEB_ADDRESS);
        assertThat(testFarm.getScope()).isEqualTo(DEFAULT_SCOPE);
        assertThat(testFarm.getLongitude()).isEqualTo(DEFAULT_LONGITUDE);
        assertThat(testFarm.getLatitude()).isEqualTo(DEFAULT_LATITUDE);
        assertThat(testFarm.getProvince()).isEqualTo(DEFAULT_PROVINCE);
    }

    @Test
    @Transactional
    public void createFarmWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = farmRepository.findAll().size();

        // Create the Farm with an existing ID
        farm.setId(1L);
        FarmDTO farmDTO = farmMapper.toDto(farm);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFarmMockMvc.perform(post("/api/farms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(farmDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Farm in the database
        List<Farm> farmList = farmRepository.findAll();
        assertThat(farmList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllFarms() throws Exception {
        // Initialize the database
        farmRepository.saveAndFlush(farm);

        // Get all the farmList
        restFarmMockMvc.perform(get("/api/farms?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(farm.getId().intValue())))
            .andExpect(jsonPath("$.[*].companyName").value(hasItem(DEFAULT_COMPANY_NAME.toString())))
            .andExpect(jsonPath("$.[*].companyLocation").value(hasItem(DEFAULT_COMPANY_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].companyLegalPerson").value(hasItem(DEFAULT_COMPANY_LEGAL_PERSON.toString())))
            .andExpect(jsonPath("$.[*].registeredCapital").value(hasItem(DEFAULT_REGISTERED_CAPITAL.toString())))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL.toString())))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS.toString())))
            .andExpect(jsonPath("$.[*].webAddress").value(hasItem(DEFAULT_WEB_ADDRESS.toString())))
            .andExpect(jsonPath("$.[*].scope").value(hasItem(DEFAULT_SCOPE.toString())))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(DEFAULT_LONGITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(DEFAULT_LATITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].province").value(hasItem(DEFAULT_PROVINCE.toString())));
    }

    @Test
    @Transactional
    public void getFarm() throws Exception {
        // Initialize the database
        farmRepository.saveAndFlush(farm);

        // Get the farm
        restFarmMockMvc.perform(get("/api/farms/{id}", farm.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(farm.getId().intValue()))
            .andExpect(jsonPath("$.companyName").value(DEFAULT_COMPANY_NAME.toString()))
            .andExpect(jsonPath("$.companyLocation").value(DEFAULT_COMPANY_LOCATION.toString()))
            .andExpect(jsonPath("$.companyLegalPerson").value(DEFAULT_COMPANY_LEGAL_PERSON.toString()))
            .andExpect(jsonPath("$.registeredCapital").value(DEFAULT_REGISTERED_CAPITAL.toString()))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL.toString()))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER.toString()))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS.toString()))
            .andExpect(jsonPath("$.webAddress").value(DEFAULT_WEB_ADDRESS.toString()))
            .andExpect(jsonPath("$.scope").value(DEFAULT_SCOPE.toString()))
            .andExpect(jsonPath("$.longitude").value(DEFAULT_LONGITUDE.doubleValue()))
            .andExpect(jsonPath("$.latitude").value(DEFAULT_LATITUDE.doubleValue()))
            .andExpect(jsonPath("$.province").value(DEFAULT_PROVINCE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingFarm() throws Exception {
        // Get the farm
        restFarmMockMvc.perform(get("/api/farms/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFarm() throws Exception {
        // Initialize the database
        farmRepository.saveAndFlush(farm);
        int databaseSizeBeforeUpdate = farmRepository.findAll().size();

        // Update the farm
        Farm updatedFarm = farmRepository.findOne(farm.getId());
        // Disconnect from session so that the updates on updatedFarm are not directly saved in db
        em.detach(updatedFarm);
        updatedFarm
            .companyName(UPDATED_COMPANY_NAME)
            .companyLocation(UPDATED_COMPANY_LOCATION)
            .companyLegalPerson(UPDATED_COMPANY_LEGAL_PERSON)
            .registeredCapital(UPDATED_REGISTERED_CAPITAL)
            .email(UPDATED_EMAIL)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .createDate(UPDATED_CREATE_DATE)
            .address(UPDATED_ADDRESS)
            .webAddress(UPDATED_WEB_ADDRESS)
            .scope(UPDATED_SCOPE)
            .longitude(UPDATED_LONGITUDE)
            .latitude(UPDATED_LATITUDE)
            .province(UPDATED_PROVINCE);
        FarmDTO farmDTO = farmMapper.toDto(updatedFarm);

        restFarmMockMvc.perform(put("/api/farms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(farmDTO)))
            .andExpect(status().isOk());

        // Validate the Farm in the database
        List<Farm> farmList = farmRepository.findAll();
        assertThat(farmList).hasSize(databaseSizeBeforeUpdate);
        Farm testFarm = farmList.get(farmList.size() - 1);
        assertThat(testFarm.getCompanyName()).isEqualTo(UPDATED_COMPANY_NAME);
        assertThat(testFarm.getCompanyLocation()).isEqualTo(UPDATED_COMPANY_LOCATION);
        assertThat(testFarm.getCompanyLegalPerson()).isEqualTo(UPDATED_COMPANY_LEGAL_PERSON);
        assertThat(testFarm.getRegisteredCapital()).isEqualTo(UPDATED_REGISTERED_CAPITAL);
        assertThat(testFarm.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testFarm.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testFarm.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testFarm.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testFarm.getWebAddress()).isEqualTo(UPDATED_WEB_ADDRESS);
        assertThat(testFarm.getScope()).isEqualTo(UPDATED_SCOPE);
        assertThat(testFarm.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testFarm.getLatitude()).isEqualTo(UPDATED_LATITUDE);
        assertThat(testFarm.getProvince()).isEqualTo(UPDATED_PROVINCE);
    }

    @Test
    @Transactional
    public void updateNonExistingFarm() throws Exception {
        int databaseSizeBeforeUpdate = farmRepository.findAll().size();

        // Create the Farm
        FarmDTO farmDTO = farmMapper.toDto(farm);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restFarmMockMvc.perform(put("/api/farms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(farmDTO)))
            .andExpect(status().isCreated());

        // Validate the Farm in the database
        List<Farm> farmList = farmRepository.findAll();
        assertThat(farmList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteFarm() throws Exception {
        // Initialize the database
        farmRepository.saveAndFlush(farm);
        int databaseSizeBeforeDelete = farmRepository.findAll().size();

        // Get the farm
        restFarmMockMvc.perform(delete("/api/farms/{id}", farm.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Farm> farmList = farmRepository.findAll();
        assertThat(farmList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Farm.class);
        Farm farm1 = new Farm();
        farm1.setId(1L);
        Farm farm2 = new Farm();
        farm2.setId(farm1.getId());
        assertThat(farm1).isEqualTo(farm2);
        farm2.setId(2L);
        assertThat(farm1).isNotEqualTo(farm2);
        farm1.setId(null);
        assertThat(farm1).isNotEqualTo(farm2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FarmDTO.class);
        FarmDTO farmDTO1 = new FarmDTO();
        farmDTO1.setId(1L);
        FarmDTO farmDTO2 = new FarmDTO();
        assertThat(farmDTO1).isNotEqualTo(farmDTO2);
        farmDTO2.setId(farmDTO1.getId());
        assertThat(farmDTO1).isEqualTo(farmDTO2);
        farmDTO2.setId(2L);
        assertThat(farmDTO1).isNotEqualTo(farmDTO2);
        farmDTO1.setId(null);
        assertThat(farmDTO1).isNotEqualTo(farmDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(farmMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(farmMapper.fromId(null)).isNull();
    }
}
