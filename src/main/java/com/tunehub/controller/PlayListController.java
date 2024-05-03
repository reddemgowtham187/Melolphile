package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entity.PlayList;
import com.tunehub.entity.Song;
import com.tunehub.service.PlaylistService;
import com.tunehub.service.SongService;

@org.springframework.stereotype.Controller
public class PlayListController {

	@Autowired
	PlaylistService ps;
	@Autowired
	SongService ss;


	@GetMapping("/createplaylists")
	public String createPlayList(Model model) {
		System.out.println("Create Playlist");
		List<Song> songList = ss.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";

	}

	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList plist) {
		boolean plName=ps.getPlayListName(plist);
		//		    Checking Duplicates
		if(plName) {
			ps.addplayList(plist);		
			System.out.println("Playlist Added Successfully");

			//Updating the song_playlists table
			List<Song> songs = plist.getSongs();

			for(Song song:songs) {
				song.getPlayLists().add(plist);
				ss.updateSong(song);
			}
		}
		else {
			System.out.println("Duplicate Record");
		}
		return "AdminHome";

	}	

	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model) {
		

			List<PlayList> playlist=ps.fetchAllPlaylist();
			model.addAttribute("playlists",playlist);
			System.out.println(playlist);
			return "viewplaylist";
		
		}
	}



