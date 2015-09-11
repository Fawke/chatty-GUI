package server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import structure.ChatServerInt;

public class StartServer {
	
	public static void main(String[] args){
		
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}
		
		try{
			String name = "Messenger";
			ChatServerInt csi = new ChatServer();
			ChatServerInt stub = 
					(ChatServerInt) UnicastRemoteObject.exportObject(csi,0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("[System] Chat server is ready.");
		} catch (Exception e){
			System.err.println("Chat server failed: ");
			e.printStackTrace();
		}
	}
}
