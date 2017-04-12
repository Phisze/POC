package gameutil2d.framework;

/*
 *  [GameActivity.java] - Classe (Activity) principal, que irá executar todo o motor de jogo
 *  da GameUtil2D
 *
 *  Desenvolvida por : Luciano Alves da Silva
 *  e-mail : lucianopascal@yahoo.com.br
 *  site : http://www.gameutil2d.org
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;



public class GameActivity extends Activity {

    private GameRunnable gameRunnable;

    private GameState gameState;

    private boolean displayMessageOnExit;

    private boolean canCloseGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        displayMessageOnExit = true;
        canCloseGame = true;

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gameRunnable = new GameRunnable(this);

        gameState = GameState.PLAY_RESUME;

        setContentView(gameRunnable);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_pause_resume_game: {

                if(gameState == GameState.PAUSE) {
                    gameRunnable.resumeGame();
                    gameState = GameState.PLAY_RESUME;
                    item.setTitle("Pausar Jogo");
                }
                else {

                    gameRunnable.pauseGame();
                    gameState = GameState.PAUSE;

                    item.setTitle("Continuar Jogo");

                }

            } break;


            case R.id.menu_exit_game : {

               ShowExitMessage();

            } break;

        }
        return super.onOptionsItemSelected(item);
    }


    private void ShowExitMessage()
    {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Aviso");
        dialogo.setMessage("Deseja sair do Jogo ?");
        dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                GameActivity.this.finish();
            }
        } );
        dialogo.setNegativeButton("Não", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                gameRunnable.SetGameState(GameState.PLAY_RESUME);
            }
        });

        gameRunnable.SetGameState(GameState.PAUSE);
        dialogo.show();
    }

    @Override
    protected void onDestroy() {
        gameRunnable.onExitGame();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        if(gameState == GameState.PAUSE)
          gameRunnable.onResume();
        super.onResume();
    }

    @Override
    public void onBackPressed() {

        if(canCloseGame)
        {
            if(displayMessageOnExit)
                ShowExitMessage();
            else
                super.onBackPressed();
        }
        else
            gameRunnable.backButtonPressed();
    }


    @Override
    protected void onUserLeaveHint() {
        gameRunnable.onPause();
        super.onUserLeaveHint();
    }

    public void SetDisplayMessageOnExit(boolean canDisplayMessage)
    {
        displayMessageOnExit = canDisplayMessage;
    }

    public void SetCanCloseGame(boolean close_game)
    {
        canCloseGame = close_game;
    }

    public void ForceCloseGame()
    {
        this.finish();
    }


}
