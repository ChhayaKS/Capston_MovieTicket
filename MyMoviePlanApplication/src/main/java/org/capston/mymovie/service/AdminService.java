package org.capston.mymovie.service;

import java.util.List;

import org.capston.mymovie.entity.Admin;
import org.capston.mymovie.repository.AdminRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepositoty adminRepositoty;
	
	public Admin addAdmin(Admin admin)
	{
		Admin admin1=new Admin();
		admin1.setEmail(admin.getEmail());
		admin1.setPassword(admin.getPassword());
		return adminRepositoty.save(admin1);	
	}
	
	public List<Admin> getAllAdmin()
	{
		return adminRepositoty.findAll();
	}
	
	

}
