package com.fredericboisguerin.insa.network.core.service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

public class UDPMessageSenderService implements MessageSenderService {

    @Override
    public void sendMessageOn(String ipAddress, int port, String message) throws Exception {

        byte[] buffer= message.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,Inet4Address.getByName(ipAddress),port);
        DatagramSocket datagramSocket = new DatagramSocket();

        datagramSocket.send(datagramPacket);
    }
}
