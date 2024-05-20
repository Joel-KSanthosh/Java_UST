package module3.c1.linkedlist;
// Song class to represent a song
class Song {
    private String title;
    private String artist;
    private Song prev;
    private Song next;
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.prev = null;
        this.next = null;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public Song getPrev() {
        return prev;
    }
    public void setPrev(Song prev) {
        this.prev = prev;
    }
    public Song getNext() {
        return next;
    }
    public void setNext(Song next) {
        this.next = next;
    }
}
// Playlist class to manage the playlist
class Playlist {
    private Song head;
    private Song tail;
    private Song current;
    public Playlist() {
        head = null;
        tail = null;
        current = null;
    }
    // Method to add a song to the playlist
    public void addSong(String title, String artist) {
        Song newSong = new Song(title, artist);
        if (head == null) {
            head = newSong;
            tail = newSong;
        } else {
            tail.setNext(newSong);
            newSong.setPrev(tail);
            tail = newSong;
        }
        System.out.println("Added song: " + title + " by " + artist);
    }
    // Method to remove the current song from the playlist
    public void removeCurrentSong() {
        if (current != null) {
            if (current == head && current == tail) {
                head = null;
                tail = null;
            } else if (current == head) {
                head = head.getNext();
                head.setPrev(null);
            } else if (current == tail) {
                tail = tail.getPrev();
                tail.setNext(null);
            } else {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            }
            System.out.println("Removed song: " + current.getTitle() + " by " + current.getArtist());
            current = current.getNext();
        } else {
            System.out.println("No current song to remove.");
        }
    }
    // Method to play the current song
    public void playCurrentSong() {
        if (current != null) {
            System.out.println("Now playing: " + current.getTitle() + " by " + current.getArtist());
        } else {
            System.out.println("No current song to play.");
        }
    }

    // Method to move to the next song in the playlist
    public void nextSong() {
        if (current != null && current.getNext() != null) {
            current = current.getNext();
            System.out.println("Switched to next song: " + current.getTitle() + " by " + current.getArtist());
        } else {
            System.out.println("No next song available.");
        }
    }
    // Method to move to the previous song in the playlist
    public void previousSong() {
        if (current != null && current.getPrev() != null) {
            current = current.getPrev();
            System.out.println("Switched to previous song: " + current.getTitle() + " by " + current.getArtist());
        } else {
            System.out.println("No previous song available.");
        }
    }
}
public class SongMain {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        // Adding songs to the playlist
        playlist.addSong("Song A", "Artist A");
        playlist.addSong("Song B", "Artist B");
        playlist.addSong("Song C", "Artist C");
        // Playing songs
        playlist.playCurrentSong();
        // Moving to the next song
        playlist.nextSong();
        // Removing the current song
        playlist.removeCurrentSong();
        // Moving to the previous song
        playlist.previousSong();
    }
}
