import iceworld.given.IcetizenLook;
import iceworld.given.MyIcetizen;


public class Icetizen implements MyIcetizen{

	private String username;
	private int portID,listeningPort;
	private IcetizenLook icetizenLook;

	public int getIcePortID() {
		return portID;
	}

	public IcetizenLook getIcetizenLook() {
		return icetizenLook;
	}

	public int getListeningPort() {
		return listeningPort;
	}

	public String getUsername() {
		return username;
	}

	public void setIcePortID(int portID) {
		this.portID = portID;
	}

	public void setIcetizenLook(IcetizenLook icetizenLook) {
		this.icetizenLook=icetizenLook;
	}

	public void setListeningPort(int listeningPort) {
		this.listeningPort=listeningPort ;
	}

	public void setUsername(String username) {
		this.username = username;	
	}

}
