package cartoon;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;


public class FallingObject {
    Polygon _object;

    public FallingObject(Pane meteoritePane) {
//        Integer randomXLocation = (int)(Math.random()*1000);
//        Color meteoriteColor = Color.rgb(104, 104, 104);
//        Color ellipseColor = Color.rgb(168,168,168);
//        _object = new Circle(Constants.CIRCLE_DIAMETER, meteoriteColor);
//        _object.setCenterX(randomXLocation);
//        _object.setCenterY(Constants.FALL_Y_LOCATION);
//        _ellipseOne = new Ellipse(Constants.FALL_ELLIPSE_ONE_X, Constants.FALL_ELLIPSE_ONE_Y);
//        _ellipseTwo = new Ellipse(Constants.FALL_ELLIPSE_TWO_X, Constants.FALL_ELLIPSE_TWO_Y);
//
//        _ellipseOne.setCenterX(randomXLocation + 10);
//        _ellipseOne.setCenterY(Constants.FALL_Y_LOCATION - 5);
//
//        _ellipseTwo.setCenterX(randomXLocation - 11);
//        _ellipseTwo.setCenterY(Constants.FALL_Y_LOCATION + 12);
//
//        _ellipseOne.setFill(ellipseColor);
//        _ellipseTwo.setFill(ellipseColor);
//
//        meteoritePane.getChildren().addAll(_object,_ellipseOne,_ellipseTwo);

        _object = new Polygon();
        int numberOfPoints = (int)(Math.random()*(10-5)+5);
        double centralXLocation = (int)(Math.random()*1000);
        double xPointDifference;
        double yPointDifference;
        for (int i = 0; i < numberOfPoints; i++) {
            xPointDifference = (int)(Math.random()*(Constants.FALL_UPPER_X-Constants.FALL_LOWER_X)+Constants.FALL_LOWER_X);
            yPointDifference = (int)(Math.random()*(Constants.FALL_UPPER_Y-Constants.FALL_LOWER_Y)+Constants.FALL_LOWER_Y);
            _object.getPoints().addAll(centralXLocation + xPointDifference, Constants.FALL_Y_LOCATION+yPointDifference);
        }
        _object.setStroke(Color.rgb(148,148,148));
        int grayRandom = (int)(Math.random()*(91)+82);
        _object.setFill(Color.rgb(grayRandom, grayRandom, grayRandom));
        meteoritePane.getChildren().addAll(_object);

    }

    public void moveFallObject(Integer time){
        double moveBy = Math.floor(time*0.01);
        double currentYLocation = _object.getLayoutY();
        _object.setLayoutY(currentYLocation+moveBy);


//        double yFallingObject = _object.getCenterY();
//        double yFallingEllipseOne = _ellipseOne.getCenterY();
//        double yFallingEllipseTwo = _ellipseTwo.getCenterY();
//        _object.setCenterY(yFallingObject + moveBy);
//        _ellipseOne.setCenterY(yFallingEllipseOne + moveBy);
//        _ellipseTwo.setCenterY(yFallingEllipseTwo + moveBy);
    }

    public boolean checkFallingOnPlane() {
        double yFallingObject = _object.getLayoutY();
        boolean fallIsOn;
        if (yFallingObject < 1220){
            fallIsOn = true;
        }
        else {
            fallIsOn = false;
        }
        return fallIsOn;
    }
}
