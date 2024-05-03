package com.tunehub.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.Song;
import com.tunehub.service.SongService;


@Controller
public class SongController {

	@Autowired
	SongService ss;

	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		String name=song.getName();
		boolean songExists=ss.songExists(name);
		if(songExists==false) {
			ss.saveSong(song);
			System.out.println("Song added successfully");
		}
		else {
			System.out.println("Duplicate Song");
		}
		return "AdminHome";
//			ss.saveSong(song);
//			return "song";
	}
	
	@GetMapping("/playsongs")
	public String playSongs(Model model) {
	  boolean premium=true;
	  if(premium) {
	
   		List<Song> songslist=ss.fetchAllSongs();
   		model.addAttribute("songs",songslist);
   		System.out.println(songslist);
		return "viewSongs";
	}
	  else {
		  return "pay";
	  }	
	}

	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
	  
	
   		List<Song> songslist=ss.fetchAllSongs();
   		model.addAttribute("songs",songslist);
   		System.out.println(songslist);
		return "viewSongs";
	}
	 
	}
	

