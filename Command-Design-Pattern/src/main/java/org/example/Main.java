package org.example;

// command design pattern...
// user -> invoker -> command -> receiver

public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        ICommand turnOnAc = new TurnOnAc(airConditioner);

        RemoteInvoker remoteInvoker = new RemoteInvoker();
        remoteInvoker.setCommand(turnOnAc);
        remoteInvoker.pressButton();
        remoteInvoker.pressBackButton();
    }
}