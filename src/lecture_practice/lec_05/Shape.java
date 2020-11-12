package lecture_practice.lec_05;

public abstract class Shape implements Relatable{
    public int compare(Relatable other){
        Shape otherShape = (Shape)other;
        return Double.compare(this.getArea(), otherShape.getArea());
    }
    public abstract String getCurType();
    public abstract double getArea();
    public void print(){
        System.out.println("Type=" + getCurType());
        System.out.println("Area=" + getArea());
    }
}
