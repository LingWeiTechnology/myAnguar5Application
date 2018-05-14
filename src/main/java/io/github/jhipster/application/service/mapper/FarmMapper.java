package io.github.jhipster.application.service.mapper;

import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.service.dto.FarmDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Farm and its DTO FarmDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FarmMapper extends EntityMapper<FarmDTO, Farm> {



    default Farm fromId(Long id) {
        if (id == null) {
            return null;
        }
        Farm farm = new Farm();
        farm.setId(id);
        return farm;
    }
}
