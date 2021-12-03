package com.company;

import java.awt.Image;

import javax.swing.ImageIcon;

public class myMovieDTO {
	private String name,img,tag1,tag2,star,year;
	
	public myMovieDTO(String name, String img, String tag1, String tag2, String star, String year) {
		this.name = name;
		this.img = img;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.star = star;
		this.year = year;
		
	}
	public String getmyName() {return name;}
	public ImageIcon getImg() {
		// 이미지 크기 변경
        ImageIcon mymovieimg = new  ImageIcon(img);
        Image tempImg = mymovieimg.getImage();
        tempImg = tempImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        mymovieimg = new ImageIcon(tempImg);
		return mymovieimg;
		}
	public String getTag1() {return tag1;}
	public String getTag2() {return tag2;}
	public String getStar() {return star;}
	public String getYear() {return year;}


	 @Override
	    public String toString() {
	        return "myMovielistVO [영화이름=" + name  +", 포스터"+ img +", #태그1=" + tag1 + ", #태그2=" + tag2 +", 평점="+ star +", 출시연도="+ year +", 출시연도="+ year +"]";
	    }

}
