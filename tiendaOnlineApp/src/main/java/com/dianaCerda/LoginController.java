package com.dianaCerda;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dianaCerda.model.ResetToken;
import com.dianaCerda.model.Usuario;
import com.dianaCerda.service.ILoginService;
import com.dianaCerda.service.IResetTokenService;
import com.dianaCerda.util.EmailUtil;
import com.dianaCerda.util.Mail;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private ILoginService service;
	
	@Autowired
	private IResetTokenService tokenService;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@PostMapping(value = "/enviarCorreo", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Integer> enviarCorreo(@RequestBody String correo) {
		int respuesta = 0;
		try {
			Usuario us = service.verificarNombreUsuario(correo);
			if (us != null && us.getIdUsuario() > 0) {
				
				ResetToken token = new ResetToken();
				token.setToken(UUID.randomUUID().toString());
				token.setUser(us);
				token.setExpiracion(25);
				tokenService.guardar(token);
				
				Mail mail = new Mail();
				mail.setFrom("email.prueba.demo@gmail.com");
				mail.setTo(us.getUsername());
				mail.setSubject("RESTABLECER CONTRASEÑA - MEDIAPP");
				
				Map<String, Object> model = new HashMap<>();
				String url = "http://localhost:4200/recuperar/" + token.getToken();
				model.put("user", token.getUser().getUsername());
				model.put("resetUrl", url);
				mail.setModel(model);
				emailUtil.enviarMail(mail);
				respuesta = 1;
			}
		} catch(Exception e) {
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);
	}
	
}
