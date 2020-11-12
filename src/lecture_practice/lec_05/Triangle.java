package lecture_practice.lec_05;

public class Triangle extends Shape{
    public double base;
    public double altitude;

    public Triangle(double base, double altitude) {
        this.base = base;
        this.altitude = altitude;
    }

    @Override
    public double getArea() {
        return 0.5*base*altitude;
    }

    @Override
    public String getCurType(){
        return "Triangle";
    }
}
