package io.github.jhipster.application.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FarmDataController controller
 */
@RestController
@RequestMapping("/api/farm-data-controller")
public class FarmDataControllerResource {

    private final Logger log = LoggerFactory.getLogger(FarmDataControllerResource.class);

    /**
    * POST create
    */
    @PostMapping("/create")
    public String create() {
        return "create";
    }

    /**
    * GET get
    */
    @GetMapping("/get")
    public String get() {
        return "get";
    }

    /**
    * POST update
    */
    @PostMapping("/update")
    public String update() {
        return "update";
    }

}
