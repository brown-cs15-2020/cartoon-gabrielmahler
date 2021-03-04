package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;


public class Player {
    public Polygon _playerBody;
    public Polygon _playerCockpit;
    public Polygon _playerMotor;
    public Polygon _playerSecondMotor;

    public Player(Pane playerPane) {
        _playerBody = new Polygon();
        _playerBody.getPoints().addAll(Constants.PLAYER_A_X, Constants.PLAYER_AB_Y,
                Constants.PLAYER_B_X, Constants.PLAYER_AB_Y,
                Constants.PLAYER_C_X, Constants.PLAYER_C_Y);
        _playerBody.setFill(Color.rgb(224,224,224));
        _playerBody.setStroke(Color.BLACK);

        _playerCockpit = new Polygon();
        _playerCockpit.getPoints().addAll(new Double[]{
                Constants.COCKPIT_PLAYER_A_X, Constants.COCKPIT_PLAYER_AB_Y,
                Constants.COCKPIT_PLAYER_B_X, Constants.COCKPIT_PLAYER_AB_Y,
                Constants.COCKPIT_PLAYER_C_X, Constants.COCKPIT_PLAYER_C_Y});
        _playerCockpit.setFill(Color.rgb(0,128,255));
        _playerCockpit.setStroke(Color.GRAY);

        _playerMotor = new Polygon();
        _playerMotor.getPoints().addAll(new Double[]{
                Constants.MOTOR_PLAYER_A_X, Constants.MOTOR_PLAYER_AB_Y,
                Constants.MOTOR_PLAYER_B_X, Constants.MOTOR_PLAYER_AB_Y,
                Constants.MOTOR_PLAYER_C_X, Constants.MOTOR_PLAYER_C_Y});
        _playerMotor.setFill(Color.RED);

        _playerSecondMotor = new Polygon();
        _playerSecondMotor.getPoints().addAll(new Double[]{
                Constants.SMOTOR_PLAYER_A_X, Constants.SMOTOR_PLAYER_AB_Y,
                Constants.SMOTOR_PLAYER_B_X, Constants.SMOTOR_PLAYER_AB_Y,
                Constants.SMOTOR_PLAYER_C_X, Constants.SMOTOR_PLAYER_C_Y});
        _playerSecondMotor.setFill(Color.ORANGE);

        playerPane.getChildren().addAll(_playerBody, _playerCockpit, _playerMotor, _playerSecondMotor);
    }

    public void moveRight() {
        double currentBodyX = _playerBody.getLayoutX();
        double currentCockpitX = _playerCockpit.getLayoutX();
        double currentMotorX = _playerMotor.getLayoutX();
        double currentSecondMotorX = _playerSecondMotor.getLayoutX();

        if (currentBodyX < 500) {
            _playerBody.setLayoutX(currentBodyX + Constants.PLAYER_MOVE);
            _playerCockpit.setLayoutX(currentCockpitX+ Constants.PLAYER_MOVE);
            _playerMotor.setLayoutX(currentMotorX + Constants.PLAYER_MOVE);
            _playerSecondMotor.setLayoutX(currentSecondMotorX + Constants.PLAYER_MOVE);
        }
    }
    public void moveLeft() {
        double currentBodyX = _playerBody.getLayoutX();
        double currentCockpitX = _playerCockpit.getLayoutX();
        double currentMotorX = _playerMotor.getLayoutX();
        double currentSecondMotorX = _playerSecondMotor.getLayoutX();
        if (currentBodyX > -500) {
            _playerBody.setLayoutX(currentBodyX - Constants.PLAYER_MOVE);
            _playerCockpit.setLayoutX(currentCockpitX - Constants.PLAYER_MOVE);
            _playerMotor.setLayoutX(currentMotorX - Constants.PLAYER_MOVE);
            _playerSecondMotor.setLayoutX(currentSecondMotorX - Constants.PLAYER_MOVE);
        }
    }
}
