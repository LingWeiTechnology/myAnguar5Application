package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.FarmService;
import io.github.jhipster.application.domain.Farm;
import io.github.jhipster.application.repository.FarmRepository;
import io.github.jhipster.application.service.dto.FarmDTO;
import io.github.jhipster.application.service.mapper.FarmMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Farm.
 */
@Service
@Transactional
public class FarmServiceImpl implements FarmService {

    private final Logger log = LoggerFactory.getLogger(FarmServiceImpl.class);

    private final FarmRepository farmRepository;

    private final FarmMapper farmMapper;

    public FarmServiceImpl(FarmRepository farmRepository, FarmMapper farmMapper) {
        this.farmRepository = farmRepository;
        this.farmMapper = farmMapper;
    }

    /**
     * Save a farm.
     *
     * @param farmDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FarmDTO save(FarmDTO farmDTO) {
        log.debug("Request to save Farm : {}", farmDTO);
        Farm farm = farmMapper.toEntity(farmDTO);
        farm = farmRepository.save(farm);
        return farmMapper.toDto(farm);
    }

    /**
     * Get all the farms.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<FarmDTO> findAll() {
        log.debug("Request to get all Farms");
        return farmRepository.findAll().stream()
            .map(farmMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one farm by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public FarmDTO findOne(Long id) {
        log.debug("Request to get Farm : {}", id);
        Farm farm = farmRepository.findOne(id);
        return farmMapper.toDto(farm);
    }

    /**
     * Delete the farm by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Farm : {}", id);
        farmRepository.delete(id);
    }
}
