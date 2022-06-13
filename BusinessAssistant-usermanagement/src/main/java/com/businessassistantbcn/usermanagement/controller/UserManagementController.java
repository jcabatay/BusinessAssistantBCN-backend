package com.businessassistantbcn.usermanagement.controller;

import com.businessassistantbcn.usermanagement.dto.UserDto;
import com.businessassistantbcn.usermanagement.dto.UserEmailDto;
import com.businessassistantbcn.usermanagement.service.UserManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/businessassistantbcn/api/v1/usermanagement")
public class UserManagementController {

    @Autowired
    UserManagementService userManagementService;

    @GetMapping(value="/test")
    public String test() {
        return "Hello from BusinessAssistant User!!!";
    }

    @PostMapping("/user")
    @Operation(summary = "add user")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "503", description = "Service Unavailable") })
    public Mono<UserDto> addUser(@RequestBody UserEmailDto userEmailDto){
        return userManagementService.addUser(Mono.just(userEmailDto));
    }
}
