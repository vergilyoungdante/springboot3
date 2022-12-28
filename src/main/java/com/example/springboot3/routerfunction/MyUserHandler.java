package com.example.springboot3.routerfunction;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.routerfunction
 * @Author: vergil young
 * @CreateTime: 2022-12-27  17:43
 * @Description: TODO
 */
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class MyUserHandler {

    public ServerResponse getUser(ServerRequest request) {
        return ServerResponse.ok().body("getUser");
    }

    public ServerResponse getUserCustomers(ServerRequest request) {
        return ServerResponse.ok().body("getUserCustomers");
    }

    public ServerResponse deleteUser(ServerRequest request) {
        return ServerResponse.ok().body("deleteUser");
    }

}

