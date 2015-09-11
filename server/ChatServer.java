package server;

import structure.ChatServerInt;
import structure.ChatClientInt;
import java.rmi.RemoteException;
import java.util.Vector;

public class ChatServer implements ChatServerInt{
	
	private Vector<ChatClientInt> v = new Vector<ChatClientInt>();
	
	public ChatServer() {
		super();
	}
	
	public boolean login(ChatClientInt a) throws RemoteException {
		System.out.println(a.getName() + " got connected.....");
		a.tell("You have Connected successfully.");
		publish(a.getName() + " has just connected.");
		v.add(a);
		return true;
	}
	
	public void publish(String s) throws RemoteException {
		System.out.println(s);
		for(int i = 0; i < v.size(); i++){
			try{
				ChatClientInt tmp = v.get(i);
				tmp.tell(s);
			}catch (Exception e){
				
				//problem with the client not connected.
				//better to remove it.
			}
		}
	}
	
	public Vector<ChatClientInt> getConnected() {
		return v;
	}
}






