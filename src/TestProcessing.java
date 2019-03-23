import processing.core.PApplet;
import processing.opengl.*;

public class TestProcessing extends PApplet{

    public static void main(String[] args) {
        PApplet.main("TestProcessing");
    }

    public void settings(){
    	//size(500,500,P3D);
    	fullScreen(P3D);
    }

    public void setup(){
    }

    public void draw(){
    	background(0);
    	fill(255);
    	translate(width/2,height/2,mouseX);
    	sphere(100);
    }
}
