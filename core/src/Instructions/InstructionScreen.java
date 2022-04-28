package Instructions;

import Menu.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MainGame;

public class InstructionScreen implements Screen {
    MainGame game;
    Texture Instructions;

    Music MenuBack;

    public InstructionScreen(MainGame game){
        this.game=game;
    }
    @Override
    public void show() {
        Instructions = new Texture("Instructions.png");
        MenuBack = Gdx.audio.newMusic(Gdx.files.internal("Menu_Back.mp3"));
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(Instructions,0f,0f);

        if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            this.dispose();
            MenuBack.play();
            game.setScreen(new MenuScreen(game));
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
        MenuBack.dispose();
    }
}