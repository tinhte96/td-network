package com.fredericboisguerin.insa.network.core.service;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPMessageSenderService implements MessageSenderService {

    @Override
    public void sendMessageOn(String ipAddress, int port, String message) throws Exception {
        Socket clientSocket = new Socket(ipAddress,port);
        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        oos.write(message.getBytes());
        oos.flush();
    }
}
