/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;

public class ServerSocketTest {
    public static void listen() {

    }

    public static void main(String[] args) {
        try {

            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            String str = "";
            BSTImplement bst = new BSTImplement(new BSTImplement.Node(0));

            while (!str.equals("stop")) {
                str = din.readUTF();
                if (str.startsWith("add")) {
                    bst.insert(Integer.parseInt(str.substring(3)));
                }
                else if (str.startsWith("delete")) {
                    bst.delete(Integer.parseInt(str.substring(6)));
                }
                else if (str.startsWith("printall")) {
                    Queue<Integer> q = bst.printInorder();
                }
                // dout.writeUTF(str2);
                dout.flush();
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
