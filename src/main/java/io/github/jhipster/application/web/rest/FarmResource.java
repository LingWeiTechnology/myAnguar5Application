package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.service.FarmService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.application.service.dto.FarmDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Farm.
 */
@RestController
@RequestMapping("/api")
public class FarmResource {

    private final Logger log = LoggerFactory.getLogger(FarmResource.class);

    private static final String ENTITY_NAME = "farm";

    private final FarmService farmService;

    public FarmResource(FarmService farmService) {
        this.farmService = farmService;
    }

    /**
     * POST  /farms : Create a new farm.
     *
     * @param farmDTO the farmDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new farmDTO, or with status 400 (Bad Request) if the farm has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/farms")
    @Timed
    public ResponseEntity<FarmDTO> createFarm(@RequestBody FarmDTO farmDTO) throws URISyntaxException {
        log.debug("REST request to save Farm : {}", farmDTO);
        if (farmDTO.getId() != null) {
            throw new BadRequestAlertException("A new farm cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FarmDTO result = farmService.save(farmDTO);
        return ResponseEntity.created(new URI("/api/farms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /farms : Updates an existing farm.
     *
     * @param farmDTO the farmDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated farmDTO,
     * or with status 400 (Bad Request) if the farmDTO is not valid,
     * or with status 500 (Internal Server Error) if the farmDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/farms")
    @Timed
    public ResponseEntity<FarmDTO> updateFarm(@RequestBody FarmDTO farmDTO) throws URISyntaxException {
        log.debug("REST request to update Farm : {}", farmDTO);
        if (farmDTO.getId() == null) {
            return createFarm(farmDTO);
        }
        FarmDTO result = farmService.save(farmDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, farmDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /farms : get all the farms.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of farms in body
     */
    @GetMapping("/farms")
    @Timed
    public List<FarmDTO> getAllFarms() {
        log.debug("REST request to get all Farms");
        return farmService.findAll();
        }

    /**
     * GET  /farms/:id : get the "id" farm.
     *
     * @param id the id of the farmDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the farmDTO, or with status 404 (Not Found)
     */
    @GetMapping("/farms/{id}")
    @Timed
    public ResponseEntity<FarmDTO> getFarm(@PathVariable Long id) {
        log.debug("REST request to get Farm : {}", id);
        FarmDTO farmDTO = farmService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(farmDTO));
    }

    /**
     * DELETE  /farms/:id : delete the "id" farm.
     *
     * @param id the id of the farmDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/farms/{id}")
    @Timed
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
        log.debug("REST request to delete Farm : {}", id);
        farmService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
