package com.fredericboisguerin.insa.network.core.service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessageReceiverService implements MessageReceiverService {

    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {

        byte[] receiveData = new byte[500];
        DatagramSocket serverSocket = new DatagramSocket(port);
        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
        serverSocket.receive(receivePacket);

        String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());
        incomingMessageListener.onNewIncomingMessage(sentence);
    }
}
