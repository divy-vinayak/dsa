public class OOPs {
    public static void main(String[] args) {
        Pen p1 = new Pen("Red", 1);
        p1.setColor("Pink");
        p1.setTip(4);
        System.out.println(p1.getColor() );

        Pen p2 = new Pen(p1);
        System.out.println(p2.getColor());
        System.out.println(p2.getTip());
    }
}

class Pen {
    private String color;
    private int tip;

    // constructor
    Pen(){
        this.color = "Red";
        this.tip = 1;
    }
    Pen(String color, int tip){
        this.color = color;
        this.tip = tip;
    }

    // copy constructor
    Pen(Pen p){
        this.color = p.color;
        this.tip = p.tip;
    }

    // getters
    String getColor(){
        return this.color;
    }
    int getTip(){
        return this.tip;
    }

    // setters
    void setColor(String newColor){
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
}

class Student {
    String name;
    int age;
    float percentage;

    void calculatePercentage(int phy, int chem, int math){
        percentage = (float)(phy + chem + math) * 100 / 3;
    }
}