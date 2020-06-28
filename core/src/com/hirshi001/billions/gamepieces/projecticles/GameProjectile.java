package com.hirshi001.billions.gamepieces.projecticles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.hirshi001.billions.gamepieces.BoxEntity;
import com.hirshi001.billions.gamepieces.entities.BoxGameEntity;
import com.hirshi001.billions.gamepieces.structures.Structure;

import java.util.List;

public abstract class GameProjectile extends BoxEntity {

    public GameProjectile(Vector2 position) {
        super(position);
    }

    @Override
    public void draw(Vector2 bottomLeft, Vector2 topRight, SpriteBatch b) {
        if(shouldDraw(bottomLeft, topRight)){
            drawProjectile(b);
        }
    }

    public abstract void drawProjectile(SpriteBatch batch);

    public boolean shouldDraw(Vector2 bottomLeft, Vector2 topRight){
        return !(getPosition().x+getWidth()<bottomLeft.x || getPosition().x>topRight.x || getPosition().y+getHeight()<bottomLeft.y || getPosition().y>topRight.y);
    }


    public void touchingMob(List<BoxGameEntity> mobs){
        for(BoxGameEntity m:mobs){
            if(touchingBox(m.getPosition(),m.getWidth(), m.getHeight())){
                onTouchingMob(m);
            }
        }
    }

    public void touchingStructure(List<Structure> structures){

    }

    public abstract void onTouchingMob(BoxGameEntity m);
}