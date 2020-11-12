package lecture_practice.lec_05;

public class Rectangle extends Shape{
    public double width;
    public double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public String getCurType(){
        return "Rectangle";
    }
}
