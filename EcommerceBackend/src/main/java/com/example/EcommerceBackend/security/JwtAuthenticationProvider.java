package com.example.EcommerceBackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.EcommerceBackend.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.HashMap;
import java.util.Date;

/**
 * Clase encargada de la creacion y validacion de jwt para el inicio de sesion de un Usuario
 */
@Component
public class JwtAuthenticationProvider {

    /**
     * Llave para cifrar el jwt
     */
    @Value("${jwt.secret.key}")
    private String secretKey;

    /**
     * Lista blanca con los jwt creados
     */
    private HashMap<String, UserDTO> listToken = new HashMap<>();

    /**
     * Crea un nuevo jwt en base al usuario recibido por parametro y lo agrega a la lista blanca
     *
     * @param UserJwt Usuario a utilizar en la creacion del jwt
     * @return Jwt creado
     */
    public String createToken(UserDTO UserJwt) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hora en milisegundos

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String tokenCreated = JWT.create()
                .withClaim("Id", UserJwt.getId())
                .withClaim("correo", UserJwt.getCorreo())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);

        listToken.put(tokenCreated, UserJwt);
        return tokenCreated;
    }


    /**
     * Valida si el token es valido y retorna una sesión del usuario
     *
     * @param token Token a validar
     * @return Sesion del usuario
     * @throws BadCredentialsException     Si el token no existe en la lista blanca
     */
    public Authentication validateToken(String token) throws AuthenticationException {

        //verifica el token como su firma y expiración, lanza una excepcion si algo falla
        JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);


        UserDTO exists = listToken.get(token);
        if (exists == null) {
            throw new BadCredentialsException("Usuario no registrado.");
        }

        return new UsernamePasswordAuthenticationToken(exists, token);
    }
    public String deleteToken(String jwt) {

        if (!listToken.containsKey(jwt)) {
            return "No existe token";
        }

        listToken.remove(jwt);
        return "Sesión cerrada exitosamente";
    }
}
