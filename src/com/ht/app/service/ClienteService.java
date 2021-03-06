/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.app.service;

import com.ht.app.bean.ChatMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquimnot
 */
public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    //cliente conectando ao servidor
    public Socket connect(){
        
        try {
            //caso queira conectar a alguma maquina em rede apenas colocar o IP da maquina
            this.socket = new Socket("localhost", 5555);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        }  catch (UnknownHostException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return socket;
    }
    //metodo para envio de mensagem após a conexão com o servidor
    public void send(ChatMessage message){
        
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
