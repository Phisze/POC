package gameutil2d.classes.text;

/*
 *  [TextDrawable.java]  - Classe utilizada  para  exibirmos frases , textos
 *  ou informações na tela. Ideal para a construção de HUD (Head-Up Display).
 *  
 *  Desenvolvida por : Luciano Alves da Silva
 *  e-mail : lucianopascal@yahoo.com.br
 *  site : http://www.gameutil2d.org
 *  
 */

import android.content.Context;


import com.twicecircled.spritebatcher.SpriteBatcher;

import gameutil2d.framework.R;

public class TextDrawable {
	
	int x;
	
	int y;

    FontName font_name;

    float scale;

	public TextDrawable(Context context, FontName font_name)
	{

        this.font_name = font_name;

		x = y = 0;
        scale = 1;

	}
	
	public void SetX(int value)
	{
		x = value;
	}
	
	public void SetY(int value)
	{
		y = value;
	}
	
	public void SetXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void MoveByX(int value)
	{
		x+=value;
	}
	
	public void MoveByY(int value)
	{
		y+=value;
	}
	
	public void SetSize(int scale)
	{
		this.scale = scale;
	}
	
	public void DrawString(SpriteBatcher spriteBatcher, String text){

        int font_name_id = 0;


        switch (font_name)
        {
            case PC_SENIOR: font_name_id = R.string.pcsenior;break;
            case CHLORINAP: font_name_id = R.string.chlorinap;break;
            case IMPACT: font_name_id = R.string.impact;break;
            case METAL_GEAR:  font_name_id = R.string.metal_gear;break;
            case TECHNO_OVERLOAD: font_name_id = R.string.techno_overload;break;
        }

        spriteBatcher.drawText(font_name_id,text,x,y,scale);

		
	}

}
