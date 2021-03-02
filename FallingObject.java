package cartoon;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import sun.font.TrueTypeFont;

public class FallingObject {
    Circle _object;

    public FallingObject() {
        _object = new Circle(Constants.CIRCLE_DIAMETER, Color.WHITE);
        _object.setCenterX((int)(Math.random()*1000));
        _object.setCenterY(Constants.FALL_Y_LOCATION);
    }

    public void moveFallObject(){
        double yFallingObject = _object.getCenterY();
        double xFallingObject = _object.getCenterX();
        _object.setCenterY(yFallingObject + Constants.FALL_UNITS_PER_SECOND);
    }

    public boolean checkOnPlane() {
        double yFallingObject = _object.getCenterY();
        if (yFallingObject < 610){
            return true;
        }
        else {
            return false;
        }
    }

    public Node getFallingObjectNode() {
        return _object;
    }
}
