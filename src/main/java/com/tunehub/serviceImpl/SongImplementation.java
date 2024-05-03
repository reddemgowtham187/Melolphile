package com.tunehub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Song;
import com.tunehub.repository.SongRepository;
import com.tunehub.service.SongService;
@Service
public class SongImplementation implements SongService {

	@Autowired
	SongRepository sr;

	@Override
	public void saveSong(Song song) {
		sr.save(song);
	}

	@Override
	public boolean songExists(String name) {
		Song song=sr.findByName(name);
		if(song != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = sr.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song song) {
		sr.save(song);		
	}


}
