package module3.c1.linkedlist;
// Image class to represent an image
class Image {
    private String name;
    private String filePath;
    private Image prev;
    private Image next;
    public Image(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
        this.prev = null;
        this.next = null;
    }
    public String getName() {
        return name;
    }
    public String getFilePath() {
        return filePath;
    }
    public Image getPrev() {
        return prev;
    }
    public void setPrev(Image prev) {
        this.prev = prev;
    }
    public Image getNext() {
        return next;
    }
    public void setNext(Image next) {
        this.next = next;
    }
}
// ImageViewer class to manage the image viewer
class ImageViewer {
    private Image current;
    public ImageViewer() {
        current = null;
    }
    // Method to display the current image
    public void displayCurrentImage() {
        if (current != null) {
            System.out.println("Displaying image: " + current.getName() + " (" + current.getFilePath() + ")");
        } else {
            System.out.println("No image to display.");
        }
    }
    // Method to move to the next image
    public void nextImage() {
        if (current != null && current.getNext() != null) {
            current = current.getNext();
            System.out.println("Switched to next image: " + current.getName());
        } else {
            System.out.println("No next image available.");
        }
    }
    // Method to move to the previous image
    public void previousImage() {
        if (current != null && current.getPrev() != null) {
            current = current.getPrev();
            System.out.println("Switched to previous image: " + current.getName());
        } else {
            System.out.println("No previous image available.");
        }
    }
    // Method to add an image to the image viewer
    public void addImage(Image image) {
        if (current == null) {
            current = image;
        } else {
            Image temp = current;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(image);
            image.setPrev(temp);
        }
        System.out.println("Added image: " + image.getName());
    }
}
public class ImageViewerMain {
    public static void main(String[] args) {
        ImageViewer imageViewer = new ImageViewer();
        // Adding images to the image viewer
        imageViewer.addImage(new Image("Image1", "/path/to/image1.jpg"));
        imageViewer.addImage(new Image("Image2", "/path/to/image2.jpg"));
        imageViewer.addImage(new Image("Image3", "/path/to/image3.jpg"));
        // Displaying and navigating images
        imageViewer.displayCurrentImage();
        imageViewer.nextImage();
        imageViewer.previousImage();
    }
}

