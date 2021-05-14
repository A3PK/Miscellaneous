/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
    public static void listen() {

    }

    public static void main(String[] args) {
        try {

            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "";
            BSTImplement Bst = new BSTImplement();

            while (!str.equals("stop")) {
                str = din.readUTF();
                // if (str.equals("over")) {
                System.out.println("client says: " + str);
                // else {
                dout.writeUTF(str2);
                dout.flush();
                // }
            }

            din.close();
            s.close();
            ss.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
