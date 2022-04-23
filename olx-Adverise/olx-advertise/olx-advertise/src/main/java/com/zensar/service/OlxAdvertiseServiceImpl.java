package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.entity.AdvertiseDetails;
@Service
public class OlxAdvertiseServiceImpl implements OlxAdvertiseService {
     
	static List<Advertise> advertises = new ArrayList<Advertise>();
	static List<AdvertiseDetails> advertiseDetails=new ArrayList<AdvertiseDetails>();

	static {
		advertises.add(new Advertise(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"7/21/22", "7/21/22", "OPEN"));
	}
	
	static {
		advertiseDetails.add(new AdvertiseDetails(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"7/21/22", "7/21/22", "OPEN","Anand Kulkarni"));
	}
	
	@Override
	public Advertise addAdvertise(Advertise advertise, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			advertises.add(advertise);
			advertise.setCategory("Electronic goods");
			advertise.setUserName("anand");
			advertise.setCreatedDate("7/21/22");
			advertise.setModifiedDate("7/21/22");
			advertise.setStatus("OPEN");
			return advertise;
		}

		return null;
	}

	@Override
	public Advertise getAdvertise(long postId, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			
			for(Advertise advertise:advertises) {
				if(advertise.getId()==postId) {
					return advertise;
				}
				
			}
		}
			return null;
	}

	@Override
	public Advertise updateAdvertise(long id, Advertise advertises, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			Advertise advertise = getAdvertise(id, "anand", "anand123");
			advertise.setTitle(advertises.getTitle());
			advertise.setPrice(advertises.getPrice());
			advertise.setDescription(advertises.getDescription());
			
			return advertise;
		}

		return null;
	}

	@Override
	public List<Advertise> getAllAdvertise(String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			return advertises;
			}
			
			return null;
	}

	@Override
	public boolean deleteAdvertise(long id, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for(Advertise advertise:advertises) {
				if(advertise.getId()==id) {
					advertises.remove(advertise);
					
					return true;
				}
			}
				
			}
			return false;
	}

	@Override
	public Advertise searchAdvertisementsByCriteria(String category, String toDate, Long filtercriteria,
			String fromDate) {
		for(Advertise advertise:advertises) {
			if(advertise.getId()==filtercriteria||advertise.getCategory().equals(category)||advertise.getCreatedDate().equals(fromDate)||advertise.getModifiedDate().equals(toDate)) {
				return advertise;
			}

			
		}
		return null;
	}

	@Override
	public List<Advertise> searchAdvertise() {
		return advertises;
	}

	@Override
	public List<AdvertiseDetails> advertiseDetails(long id, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for(AdvertiseDetails advertise:advertiseDetails) {
				if(advertise.getId()==id) {
			
					return advertiseDetails;
				}
			}
		}
		return null;
	}

}
