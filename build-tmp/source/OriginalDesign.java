import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalDesign extends PApplet {

int x = 5;
int changeX=1;
float blueAmount=0;
float greenAmount=600;
int y=-60;
public void setup()
{
  size(500, 500, P3D);
  noFill();
  frameRate(25);
}
public void gradient()
{
	blueAmount=0;
	greenAmount=600;
	y=-60;
  while (y<560)
  {
    stroke(0, greenAmount, blueAmount);
    line(y, -60, -100, y, 560, -100);
    y=y+1;
    greenAmount= greenAmount -1;
    blueAmount = blueAmount + 0.9f;
  }
}

public void draw()
{
  gradient();
  // float randomX = random(0, 255);
  // float randomY = random(0, 255);
  // float randomZ = random(0, 255);
  // float r= random(110, 255);
  // float g= random(0, 156);
  // float b= random(40, 180);
  // float r2= random(0, 126);
  // float g2= random(30, 190);
  // float b2= random(110, 255);

  float randomX = (float)(Math.random()*255);
  float randomY = (float)(Math.random()*255);
  float randomZ = (float)(Math.random()*255);
  float r = (float)(Math.random()*145) + 110;
  float g = (float)(Math.random()*156);
  float b = (float)(Math.random()*140)+40;
  float r2 = (float)(Math.random()*126);
  float g2 = (float)(Math.random()*160)+30;
  float b2 = (float)(Math.random()*145)+110;

  if (mousePressed && (mouseButton == LEFT)) 
  {
    fill(r2, g2, b2);
  } else if (mousePressed && (mouseButton == RIGHT)) 
  {
    fill(r, g, b);
  } else 
  {
    fill(126);
  }
  strokeWeight(1);
  stroke(randomX, randomY, randomZ);
  translate(pmouseX, pmouseY);
  ambientLight(102, 102, 102);
  lightSpecular(204, 204, 204);
  directionalLight(102, 102, 102, 0, 0, -1);
  specular(255, 255, 255);

  rotateX(radians(mouseX));
  rotateY(radians(mouseX));
  rotateZ(radians(mouseX));
  sphereDetail(x-130);
  sphere(x);
  sphere(-x);
  x = x + changeX;
  if (x>170)
  {
    changeX=-changeX;
  }
  if (x<0)
  {
    changeX=-changeX;
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalDesign" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
