package com.sciencom.training.customerapp.dao;

import java.util.List;

import com.sciencom.training.customerapp.model.Pemesanan;

public interface PemesananDao {
	public void create(Pemesanan pemesanan);
	public List<Pemesanan> read();
	
}
