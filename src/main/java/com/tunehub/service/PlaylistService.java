package com.tunehub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tunehub.entity.PlayList;

@Service
public interface PlaylistService {

	void addplayList(PlayList plist);


	boolean getPlayListName(PlayList plist);


	List<PlayList> fetchAllPlaylist();


	




}
