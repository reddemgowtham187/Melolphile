package com.tunehub.entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Song {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
   private int id;
   private String name;
   private String artist;
   private String genre;
   private String link;
   @ManyToAny
   private List<PlayList> playLists;
public Song() {
	super();
	// TODO Auto-generated constructor stub
}
public Song(int id, String name, String artist, String genre, String link, List<PlayList> playLists) {
	super();
	this.id = id;
	this.name = name;
	this.artist = artist;
	this.genre = genre;
	this.link = link;
	this.playLists = playLists;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getArtist() {
	return artist;
}
public void setArtist(String artist) {
	this.artist = artist;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public List<PlayList> getPlayLists() {
	return playLists;
}
public void setPlayLists(List<PlayList> playLists) {
	this.playLists = playLists;
}
@Override
public String toString() {
	return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
			+ ", playLists=" + playLists + "]";
}

   
}
