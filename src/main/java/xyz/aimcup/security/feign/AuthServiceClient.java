package xyz.aimcup.security.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import xyz.aimcup.security.domain.User;

@FeignClient(name = "auth-service", path = "/api/auth-service")
@Headers("Authorization: Bearer {token}")
public interface AuthServiceClient {

    @GetMapping("/issue-jwt")
    Boolean issueJwt(@RequestHeader("Authorization") String token);

    @GetMapping("/principal")
    ResponseEntity<User> user(@RequestHeader("Authorization") String token);
}
