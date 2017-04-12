package gameutil2d.framework;
/*
 *  [GameRunnable.java] - Classe intermediária, responsável pela execução da instância
 *  da classe GameMain (que é a classe onde escrevemos o código do nosso jogo)
 *  Ela processa todos os eventos como  Update, Draw, Touch e etc.
 *
 *
 *  Desenvolvida por : Luciano Alves da Silva
 *  e-mail : lucianopascal@yahoo.com.br
 *  site : http://www.gameutil2d.org
 *
 * ***************************************************************
 *  Pacote de renderização de imagens :  SpriteBatcher
 *  Criada por : Tim Wicksteed (Twice Circled)
 *  site : http://www.twicecircled.com
 *  **************************************************************
 */
import gameutil2d.project.*;
import android.content.Context;
import android.opengl.GLSurfaceView;

import android.view.MotionEvent;

import com.twicecircled.spritebatcher.Drawer;
import com.twicecircled.spritebatcher.SpriteBatcher;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class GameRunnable extends GLSurfaceView implements Drawer {

    private GameState gameState;

    GameMain gameMain;

    Context context;

    private   int viewWidth;
    private  int viewHeight;



    public GameRunnable(Context context) {
        super(context);

        gameMain = new GameMain(context);
        this.context = context;

        gameState = GameState.PLAY_RESUME;


        try {


            ArrayList<Integer> arrayIdImages = new ArrayList<Integer>();

            Class<?> drawableClass = R.drawable.class;
            Field[] attrsDrawable = drawableClass.getFields();

            for(Field f : attrsDrawable)
            {
                arrayIdImages.add(f.getInt(f.getType()));
            }

            ArrayList<Integer> arrayFonts = new ArrayList<Integer>();

            Class<?> fontClass = R.string.class;
            Field[] attrsFont = fontClass.getFields();

            for(Field f : attrsFont)
            {
                if((f.getInt(f.getType())==R.string.pcsenior) ||
                        (f.getInt(f.getType())==R.string.chlorinap) ||
                        (f.getInt(f.getType())==R.string.impact) ||
                        (f.getInt(f.getType())==R.string.metal_gear) ||
                        (f.getInt(f.getType())==R.string.techno_overload) )
                   arrayFonts.add(f.getInt(f.getType()));
            }

            int[] idResources = new int[arrayIdImages.size() + arrayFonts.size()];

            int indexId = 0;

            for(Integer id : arrayIdImages)
            {
                idResources[indexId] = id;
                indexId++;
            }

            for(Integer id : arrayFonts)
            {
                idResources[indexId] = id;
                indexId++;
            }

            this.setRenderer(new SpriteBatcher(context,idResources,this));
        }
        catch (Exception e)
        {

        }


        setFocusable(true);
    }

    public void Update()
    {
        gameMain.Update();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        if(w > h)
            gameMain.onScreenLoading(800,480,OrientationMode.LANDSCAPE);
        else
            gameMain.onScreenLoading(480,800,OrientationMode.PORTRAIT);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if(gameState == GameState.PLAY_RESUME) {

            event.setLocation((event.getX() * Display.WIDTH) / viewWidth, (event.getY() * Display.HEIGHT) / viewHeight);

            gameMain.onTouch(event);
        }

        return true;
    }

    public void onExitGame()
    {
        gameMain.onExitGame();
    }


    public void resumeGame()
    {
        gameState = GameState.PLAY_RESUME;
        gameMain.onResumeGame();
    }

    public void pauseGame()
    {
        gameState = GameState.PAUSE;
        gameMain.onPauseGame();
    }

    public GameState GetGameState()
    {
        return gameState;
    }

    public void SetGameState(GameState state)
    {
        gameState = state;
    }

    @Override
    public void onDrawFrame(GL10 gl, SpriteBatcher spriteBatcher) {

        if(gameState == GameState.PLAY_RESUME)
            gameMain.Update();

        //Obtém a largura da tela do dispositivo
         viewWidth = spriteBatcher.getViewWidth();

        //Obtém a altura da tela do dispostiivo
         viewHeight = spriteBatcher.getViewHeight();

        //Calcula a escala X referente a largura da tela de exibição do jogo
        float scaleX = ((float) viewWidth * 1.0f) / (float) Display.WIDTH;

        //Calcula a escala Y referente a altura da tela de exibição do jogo
        float scaleY = ((float) viewHeight * 1.0f) / (float) Display.HEIGHT;


        gameMain.Draw(spriteBatcher);

        //Redimensiona a tela de exibição de acordo com o tamanho da tela do dispositivo
        //baseado no cálculo das escalas X e Y
        gl.glScalef(scaleX,scaleY,1.0f);



    }

    public void backButtonPressed()
    {
        gameMain.onBackButtonPressed();
    }





}
