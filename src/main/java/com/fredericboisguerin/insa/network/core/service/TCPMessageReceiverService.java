package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Collectors;

public class TCPMessageReceiverService implements MessageReceiverService {

    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket connectionSocket = serverSocket.accept();

        BufferedReader inFromClient = new BufferedReader
                (new InputStreamReader(connectionSocket.getInputStream()));
        String sentence = inFromClient.lines().collect(Collectors.joining());
        incomingMessageListener.onNewIncomingMessage(sentence);
    }
}
