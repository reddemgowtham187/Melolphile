package com.tunehub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.PlayList;
import com.tunehub.repository.PlaylistRepository;
import com.tunehub.service.PlaylistService;
@Service
public class PlaylistServiceImplementation implements PlaylistService{
  @Autowired
  PlaylistRepository pr;

@Override
public void addplayList(PlayList plist) {
//	PlayList exisplist=pr.findByName(plist.getName());
//	if(exisplist==null) {
//		pr.save(plist);
//	}
//	System.out.println("Duplicate record");
  pr.save(plist);	
}



@Override
public boolean getPlayListName(PlayList plist) {
	PlayList plName=pr.findByName(plist.getName());
	if(plName==null) {
		return true;	
	}
	return false;
}



@Override
public List<PlayList> fetchAllPlaylist() {
	List<PlayList> plist = pr.findAll();
	return plist;
	
}








}
