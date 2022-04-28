package Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import Credit.CreditsScreen;
import Play.InsideStart;
import Instructions.InstructionScreen;
import com.mygdx.game.MainGame;

public class MenuScreen implements Screen {

    MainGame game;

    Texture mainMenuImg;
    Texture circleImg;

    private static final int circleWidth=22;
    private static final int circleHight=13;


    int count=0;

    final int[] circleX = new int[]{1160,1144,1068,1132};
    final int[] circleY = new int[]{272,224,176,128};

    int circleIndx=0;

    Music Background;
    Music MenuMoving;
    Music MenuSelection;


    public MenuScreen(MainGame game){
        this.game=game;
    }
    @Override
    public void show() {

        Background = Gdx.audio.newMusic(Gdx.files.internal("Background.mp3"));
        MenuMoving = Gdx.audio.newMusic(Gdx.files.internal("Menu_Moving.mp3"));
        MenuSelection = Gdx.audio.newMusic(Gdx.files.internal("Menu_Selection.mp3"));

        Background.setLooping(true);
        Background.setVolume(0.2f);
        Background.play();

        mainMenuImg=new Texture("Menu.png");
        circleImg = new Texture("Circle.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        game.batch.begin();
        game.batch.draw(mainMenuImg,0,0);
        game.batch.draw(circleImg,circleX[circleIndx],circleY[circleIndx],circleWidth,circleHight);

        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            MenuMoving.stop();
            MenuMoving.play();
            circleIndx++;
            if(circleIndx>=4) circleIndx=0;
        }

        else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            MenuMoving.stop();
            MenuMoving.play();
            circleIndx--;
            if(circleIndx<0) circleIndx=3;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==0){
            this.dispose();
            MenuSelection.play();
            game.setScreen(new InsideStart(game));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==2){
            this.dispose();
            MenuSelection.play();
            game.setScreen(new InstructionScreen(game));
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && circleIndx==3){
            this.dispose();
            MenuSelection.play();
            game.setScreen(new CreditsScreen(game));
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Background.dispose();
        MenuMoving.dispose();
        MenuSelection.dispose();
    }
}