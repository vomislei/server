package br.edu.utfpr.pb.tcc2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc2.enumeration.Role;

@RestController
@RequestMapping("roles")
public class RoleController {
	
	@GetMapping
	public Role[] getRoles(){
		return Role.values();
	}
	

}
