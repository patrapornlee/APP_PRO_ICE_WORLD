import iceworld.given.IcetizenLook;
import iceworld.given.MyIcetizen;

/**
 * Created with IntelliJ IDEA.
 * User: AVALON
 * Date: 10/4/2556
 * Time: 17:52 น.
 * To change this template use File | Settings | File Templates.
 */
public class Icetizen implements MyIcetizen{

        String username;
        IcetizenLook look;
        int IDPort, ListenPort;

        @Override
        public String getUsername() {
            return this.username;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setUsername(String s) {
            this.username = s;//To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public int getIcePortID() {
            return IDPort;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setIcePortID(int i) {
            this.IDPort = i;
        }

        @Override
        public IcetizenLook getIcetizenLook() {
            return look;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setIcetizenLook(IcetizenLook icetizenLook) {
            this.look = icetizenLook;
        }

        @Override
        public int getListeningPort() {
            return ListenPort;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setListeningPort(int i) {
            this.ListenPort = i;//To change body of implemented methods use File | Settings | File Templates.
        }

}
