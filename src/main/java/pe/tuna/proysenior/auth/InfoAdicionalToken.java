package pe.tuna.proysenior.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import pe.tuna.proysenior.entity.Usuario;
import pe.tuna.proysenior.service.UsuarioLocalService;

import java.util.HashMap;
import java.util.Map;

// Esta clase nos sirve para agregar mas info a nuestro token
@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private UsuarioLocalService usuarioLocalService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        Usuario usuario = usuarioLocalService.findByUsername(oAuth2Authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional", "Hola ".concat(oAuth2Authentication.getName()));
        info.put("usuario_nombre", usuario.getId() + ": " + usuario.getUsername());
        info.put("nombre", usuario.getNombre());
        info.put("apellido", usuario.getApellido());
        info.put("email", usuario.getEmail());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        return oAuth2AccessToken;
    }
}
