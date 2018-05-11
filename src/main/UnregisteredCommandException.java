package main;

/**
 * Created by vlan0416 on 11.05.2018.
 */
public class UnregisteredCommandException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Command is not found";
    }
}
