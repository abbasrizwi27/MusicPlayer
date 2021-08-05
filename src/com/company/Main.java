package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {


        Album album = new Album("Album1","Ac/dc");

        album.addSong("tnt",4.5);
        album.addSong("highway",5.9);
        album.addSong("road",5.5);
        album.addSong("right",4.9);
        albums.add(album);


        album = new Album("Album2","Enimum");

        album.addSong("rapgod",4.6);
        album.addSong("not afraid",5.5);
        album.addSong("lose yourself",6.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        Album a = albums.get(0);
        a.addToPlayList("tnt",playList_1);
        albums.get(0).addToPlayList("highway",playList_1);
        albums.get(1).addToPlayList("rapgod",playList_1);
        albums.get(1).addToPlayList("lose yourself",playList_1);

        play(playList_1);
    }
    private static void play(LinkedList<Song> playList){

        Scanner sc =new Scanner(System.in);
        boolean quit = false;
        boolean forward= true;
        ListIterator<Song> listIterator = playList.listIterator();


        if(playList.size() == 0){
            System.out.println("This playlist is empty");
        }else {
            System.out.println("Now Playing" +listIterator.next().toString());
            printmenu();
        }

        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit =true;
                    break;

                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward= true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now Playing" +listIterator.next().toString());
                    }else {
                        System.out.println("No song available reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;

                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing"+ listIterator.previous().toString());
                    }else {
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing" +listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now Playing"+ listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We have reached at the last of the list");

                        }
                    }break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printmenu();
                    break;
                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("now playing"+ listIterator.next().toString());

                        }else {
                            if (listIterator.hasPrevious())
                                System.out.println("now playing"+ listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printmenu(){
        System.out.println("Available option\n press");
        System.out.println("o - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available option\n"+
                "6 - delete curent song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("____________________");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            }
        System.out.println("_____________________");

    }
}
