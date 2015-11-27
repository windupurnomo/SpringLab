package com.sciencom.training.customerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sciencom.training.customerapp.model.Pemesanan;
import com.sciencom.training.customerapp.service.PemesananService;
import com.sciencom.training.customerapp.viewmodel.PemesananVM;

@RestController
@RequestMapping("/pemesanan")
public class PemesananController {
	
	@Autowired
	private PemesananService pemesananService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Pemesanan create(@RequestBody PemesananVM pemesanan){
		pemesananService.create(pemesanan);
		return null;
	}
}
