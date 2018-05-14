package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.FarmDTO;
import java.util.List;

/**
 * Service Interface for managing Farm.
 */
public interface FarmService {

    /**
     * Save a farm.
     *
     * @param farmDTO the entity to save
     * @return the persisted entity
     */
    FarmDTO save(FarmDTO farmDTO);

    /**
     * Get all the farms.
     *
     * @return the list of entities
     */
    List<FarmDTO> findAll();

    /**
     * Get the "id" farm.
     *
     * @param id the id of the entity
     * @return the entity
     */
    FarmDTO findOne(Long id);

    /**
     * Delete the "id" farm.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
