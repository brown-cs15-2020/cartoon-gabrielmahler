package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;


public class Meteorite {
    Circle _objectMeteorite;
    Ellipse _ellipseOne;
    Ellipse _ellipseTwo;

    public Meteorite(Pane meteoritePane) {
        int randomXLocation = (int) (Math.random() * 1000);
        Color meteoriteColor = Color.rgb(104, 104, 104);
        Color ellipseColor = Color.rgb(168, 168, 168);
        _objectMeteorite = new Circle(Constants.CIRCLE_DIAMETER, meteoriteColor);
        _objectMeteorite.setCenterX(randomXLocation);
        _objectMeteorite.setCenterY(Constants.FALL_Y_LOCATION);
        _ellipseOne = new Ellipse(Constants.FALL_ELLIPSE_ONE_X, Constants.FALL_ELLIPSE_ONE_Y);
        _ellipseTwo = new Ellipse(Constants.FALL_ELLIPSE_TWO_X, Constants.FALL_ELLIPSE_TWO_Y);

        _ellipseOne.setCenterX(randomXLocation + 10);
        _ellipseOne.setCenterY(Constants.FALL_Y_LOCATION - 5);

        _ellipseTwo.setCenterX(randomXLocation - 11);
        _ellipseTwo.setCenterY(Constants.FALL_Y_LOCATION + 12);

        _ellipseOne.setFill(ellipseColor);
        _ellipseTwo.setFill(ellipseColor);

        meteoritePane.getChildren().addAll(_objectMeteorite, _ellipseOne, _ellipseTwo);
    }

    public void moveMeteorite(Integer time){
        double moveBy = Math.floor(time*0.01);
        double yFallingObject = _objectMeteorite.getCenterY();
        double yFallingEllipseOne = _ellipseOne.getCenterY();
        double yFallingEllipseTwo = _ellipseTwo.getCenterY();
        _objectMeteorite.setCenterY(yFallingObject + moveBy);
        _ellipseOne.setCenterY(yFallingEllipseOne + moveBy);
        _ellipseTwo.setCenterY(yFallingEllipseTwo + moveBy);
    }

    public boolean checkMeteoriteOnPlane() {
        double yFallingObject = _objectMeteorite.getCenterY();
        boolean meteoIsOn;
        if (yFallingObject < 200){
            meteoIsOn = true;
        }
        else {
            meteoIsOn = false;
        }
        return meteoIsOn;
    }
}
