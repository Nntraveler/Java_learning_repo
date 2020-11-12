package lecture_practice.lec_05;

public class Square extends Shape{
    public double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return edge*edge;
    }

    @Override
    public String getCurType(){
        return "Square";
    }
}
