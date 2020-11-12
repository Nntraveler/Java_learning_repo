package lecture_practice.lec_05;

public class Ellipse extends Shape{
    double semiMajorAxis;
    double semiMinorAxis;

    public Ellipse(double semiMajorAxis, double semiMinorAxis) {
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    @Override
    public double getArea() {
        return 3.14*semiMajorAxis*semiMinorAxis;
    }

    @Override
    public String getCurType(){
        return "Ellipse";
    }
}
