package gameutil2d.classes.basic;

/*
 *  [GameElement.java]  - Classe genérica, utilizada como classe base para a construção
 *  da maioria das classes presentes dentro dessa framework
 * 
 *  Desenvolvida por : Luciano Alves da Silva
 *  e-mail : lucianopascal@yahoo.com.br
 *  site : http://www.gameutil2d.org
 *  
 */

import android.graphics.Canvas;

import com.twicecircled.spritebatcher.SpriteBatcher;

import gameutil2d.framework.Display;


public abstract class GameElement {
	
    protected int x;
	
    protected int y;
	
    protected int width;
	
    protected int height;
    
    
    protected String tag;
    
    	
	
	public void SetX(int x) {
    	this.x = x;
    	
    }
    
    public void SetY(int y) {
    	this.y = y;
    
    }
    
    public void SetWidth(int width) {
    	this.width = width;
    	
    }
    
    public void SetHeight(int height) {
    	this.height = height;
    	
    }
	
	public void MoveByX(int x) {
		
		this.x += x;
		
	}
	
    public void MoveByY(int y) {
		
		this.y += y;
		
	}
    
    
    public void SetBounds(int x, int y, int width, int height) {
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	
    }
    
    public void SetTag(String tag_name) {
    	tag = tag_name;
    }
    
    public String GetTag() {
    	return tag;
    }
    
    public int GetX() { return x; }
    
    public int GetY() { return y; }
    
    public int GetWidth() { return width; }
    
    public int GetHeight() { return height; }
    
    public abstract void Draw(SpriteBatcher spriteBatcher);
    

    
   public boolean IsTouch(float posx, float posy) {


    	if( (posx >= x) && (posx <= x + width)
    	&& (posy >= y) && (posy <= y + height))
    		return true;
    	else    		 	
    	    return false;
   }
    
    

}
