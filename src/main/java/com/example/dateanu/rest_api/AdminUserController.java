package com.example.dateanu.rest_api;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserController {
    private final UserDaoService service; // 싱글톤 객체를 생성자주입을 하기 위해 꼭 final이 붙어야한다.

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        List<User> user = service.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }

    // Version 1
    // GET /users/1
    // @GetMapping(value = "users/{id}/",params = "version=1")
    @GetMapping(value = "users/{id}/",headers = "X-API-VERSION=1")
    public MappingJacksonValue retrieveUserVersion1(@PathVariable int id) {
        User user =  service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }

    // Version 2
    // GET /users/1
    // @GetMapping(value = "users/{id}/",params = "version=2")
    @GetMapping(value = "users/{id}/",headers = "X-API-VERSION=2")
    public MappingJacksonValue retrieveUserVersion2(@PathVariable int id) {
        User user =  service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }

        UserVersionTwo userV2 = UserVersionTwo.builder().address("seoul").build();
        BeanUtils.copyProperties(user, userV2);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "ssn","address");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo2",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);

        return mapping;
    }
}
