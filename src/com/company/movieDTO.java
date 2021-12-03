package com.company;

import javax.swing.ImageIcon;
import java.awt.*;

public class movieDTO {
    private String name, image , tag1 ,tag2;
    private float star;
    private int year;

    public movieDTO(String name, String image ,String tag1 , String tag2, float star , int year ) {
        this.name = name;
        this.image = image;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.star = star;
        this.year = year;

    }

    public String getName() {
        return name;
    }
    public ImageIcon getimage() {

        // 이미지 크기 변경
        ImageIcon movieImg = new  ImageIcon(image);
        Image tempImg = movieImg.getImage();
        tempImg = tempImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        movieImg = new ImageIcon(tempImg);
        return movieImg;
    }
    public String gettag1() {
        return tag1;
    }
    public String gettag2() {
        return tag2;
    }
    public float getstar() {
        return star;
    }
    public int  getyear() {
        return year;
    }


    @Override
    public String toString() {
        return "NamecardVO [name=" + name + ", image=" +image + ", tag1=" + tag1 + ", tag2=" + tag2 + ", star="+ star+",year="+year+"]";
    }
}
