package module3.c1.linkedlist;
import java.time.LocalDateTime;
// Post class to represent a social media post
class Post {
    private String content;
    private LocalDateTime timestamp;
    private Post prev;
    private Post next;
    public Post(String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now(); // Set timestamp to current time
        this.prev = null;
        this.next = null;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public Post getPrev() {
        return prev;
    }
    public void setPrev(Post prev) {
        this.prev = prev;
    }
    public Post getNext() {
        return next;
    }
    public void setNext(Post next) {
        this.next = next;
    }
}
// SocialMediaFeed class to manage the feed
class SocialMediaFeed {
    Post head;
    private Post tail;
    public SocialMediaFeed() {
        head = null;
        tail = null;
    }
    // Method to add a new post to the feed
    public void addPost(String content) {
        Post newPost = new Post(content);
        if (head == null) {
            head = newPost;
            tail = newPost;
        } else {
            newPost.setNext(head);
            head.setPrev(newPost);
            head = newPost;
        }
        System.out.println("New post added: " + content);
    }
    // Method to remove a post from the feed
    public void removePost(Post post) {
        if (post == head && post == tail) {
            head = null;
            tail = null;
        } else if (post == head) {
            head = head.getNext();
            head.setPrev(null);
        } else if (post == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            post.getPrev().setNext(post.getNext());
            post.getNext().setPrev(post.getPrev());
        }
        System.out.println("Post removed: " + post.getContent());
    }
    // Method to display the feed in chronological order
    public void displayFeed() {
        System.out.println("Social Media Feed:");
        Post current = head;
        while (current != null) {
            System.out.println("- " + current.getContent() + " (posted at " + current.getTimestamp() + ")");
            current = current.getNext();
        }
    }
}
public class SocialMediaMain {
    public static void main(String[] args) {
        SocialMediaFeed feed = new SocialMediaFeed();
        // Adding posts to the feed
        feed.addPost("First post");
        feed.addPost("Second post");
        feed.addPost("Third post");
        // Displaying the feed
        feed.displayFeed();
        // Removing a post
        Post postToRemove = feed.head.getNext();
        feed.removePost(postToRemove);
        // Displaying the updated feed
        feed.displayFeed();
    }
}
