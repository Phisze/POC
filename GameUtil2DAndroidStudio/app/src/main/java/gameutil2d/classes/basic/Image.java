package gameutil2d.classes.basic;

/*
 *  [Image.java]  - Classe destinada para exibição de imagens na tela do jogo
 * 
 *  Desenvolvida por : Luciano Alves da Silva
 *  e-mail : lucianopascal@yahoo.com.br
 *  site : http://www.gameutil2d.org
 *
 * ***************************************************************
 *  Pacote de renderização de imagens :  SpriteBatcher
 *  Criada por : Tim Wicksteed (Twice Circled)
 *  site : http://www.twicecircled.com
 * ***************************************************************
*/


import android.content.Context;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.twicecircled.spritebatcher.SpriteBatcher;


public class Image extends GameElement {

	Context context;
	
    int id_image;
    

    int original_width;

    int original_height;


	public Image(Context context, int id_image, int x, int y, int width,
			int height)  {
		
		this.context = context;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
        this.id_image = id_image;

        BitmapFactory.Options dimension = new BitmapFactory.Options();
        dimension.inJustDecodeBounds = true;
        Bitmap mBitmap = BitmapFactory.decodeResource(context.getResources(), id_image, dimension);
        original_width = dimension.outWidth;
        original_height =  dimension.outHeight;
		

	}

	
	public Image(Context context, int id_image, int x, int y, int width,
			int height, String tag) {

		this(context,id_image,x,y,width, height);
		
		this.tag = tag;
		
	}

	public void Draw(SpriteBatcher spriteBatcher) {

        Draw(spriteBatcher,FlipEffect.NONE);

	}

	public void Draw(SpriteBatcher spriteBatcher, FlipEffect effect) {

		if (effect == FlipEffect.NONE) {

            spriteBatcher.draw(id_image, new Rect(0,0, original_width  ,original_height),x,y, new Rect(0,0,width,height),0,1.0f);
			
		} else {

            //Usa os mesmos parâmetros acima, mudando somente o valor para NEGATIVO em original_width
            spriteBatcher.draw(id_image, new Rect(0,0, -original_width ,original_height),x,y, new Rect(0,0,width,height),0,1.0f);
		}
	}



   
}
