package com.dd.soapuui.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dd.soapuui.client.SoapServiceClient;

@Controller
public class SoapUIClientController {

	@Autowired
	private SoapServiceClient soapServiceClient;

	@RequestMapping("/")
	public String index() {
		return "test";
	}

	@PostMapping("/callService")
	public String callService(@RequestParam("input") String name, Model model) {
		model.addAttribute("inputReq", name);
		String res = "";
		try {
			res = soapServiceClient.callService(name);
			System.out.println(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("result", res);
		return "test";
	}

	@PostMapping("/processwsdl")
	public String processwsdl(@RequestParam("wsdlName") String wsdlName, Model model) {
		model.addAttribute("inputReq", wsdlName);
		String res = "";
		try {
			res = soapServiceClient.processwsdl(wsdlName);
			System.out.println(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("inputReq", res);
		return "test";
	}
}