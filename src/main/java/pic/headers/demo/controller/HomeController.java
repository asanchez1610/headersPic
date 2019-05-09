package pic.headers.demo.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pic.headers.demo.dto.UserHeader;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	
	@RequestMapping
	public ModelAndView home(@RequestHeader HttpHeaders headers, HttpSession session) {
		UserHeader usuario = this.getParamsHeaders(headers);
		session.setAttribute("userHeaders", usuario);
		session.setAttribute("grantingTicket", this.generateTicket(usuario));
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping(value = "/generateTicket")
	public @ResponseBody Map<String, ? extends Object> generarTicket(UserHeader usuario) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			data.put("success", Boolean.TRUE);
			data.put("ticket", this.generateTicket(usuario));
		} catch (Exception e) {
			data.put("success", Boolean.FALSE);
			data.put("message", "Error al generar el ticket.");
		}
		return data;
	}

	private String generateTicket(UserHeader usuario) {
		String stringToEncrypt = "";
		stringToEncrypt.concat(usuario.getIvUser()).concat(usuario.getIvTicket());
	    MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    md.update(stringToEncrypt.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}

	private UserHeader getParamsHeaders(HttpHeaders headers) {

		String ivTicket = null, ivUser = null, nombre = null, registro = null;

		if (headers != null && headers.get("iv_ticketService") != null && headers.get("iv_ticketService").size() > 0) {
			ivTicket = headers.get("iv_ticketService").get(0);
		}

		if (headers != null && headers.get("iv-user") != null && headers.get("iv-user").size() > 0) {
			ivUser = headers.get("iv-user").get(0);
		}

		if (headers != null && headers.get("nombre") != null && headers.get("nombre").size() > 0) {
			nombre = headers.get("nombre").get(0);
		}

		if (headers != null && headers.get("registro") != null && headers.get("registro").size() > 0) {
			registro = headers.get("registro").get(0);
		}

		return new UserHeader(ivUser, ivTicket, nombre, registro);

	}

}
