package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

 class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public  Album(){

    }
    public Song findSong(String title){

        for (Song checkedSong : songs){
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }
    public boolean addSong(String title, double duration){
        if (findSong(title) == null){
            songs.add(new Song(title,duration));
//            System.out.println(title +"successfully added to the list ");
            return true;
        }
        else {
//            System.out.println("song with this name already exist");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> Playlist){
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songs.size()){
            Playlist.add(this.songs.get(index));
            return true;
        }
//        System.out.println("this album does not have song with track nmbr"+trackNumber);
        return false;

    }
    public boolean addToPlayList(String title, LinkedList<Song> Playlist){
        for(Song checkedSongs : songs){
            if (checkedSongs.getTitle().equals(title)){
                Playlist.add(checkedSongs);
                return true;
            }
        }
//        System.out.println("There is no such song in album");
        return false;

    }
}
