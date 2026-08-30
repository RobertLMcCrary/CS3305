// Name: Robert McCrary
// Class: CS3305 - Data Structures
// Term: Fall 2026
// Instrctor:  
// Assignment: 1
// IDE Name: Neovim

public class Rectangle {
    private double width;
    private double height;

    Rectangle() {
        this.width = 1.00;
        this.height = 1.00;
    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width * 2) + (this.height * 2);
    }

    public String printRectangle(String objectName) {
        // formatting the string vs concatenation for readability
        return String.format("Rectangle %s is %f units wide and 20.0 units high.", objectName, this.width, this.height);
    }
}
