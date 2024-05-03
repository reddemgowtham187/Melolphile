package com.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tunehub.entity.Song;
import com.tunehub.entity.User;
@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{

	Song findByName(String name);



}
