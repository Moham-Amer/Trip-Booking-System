
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class The_Passenger {
    public static void main(String[] args) throws IOException {
        Socket server_Socket = new Socket("127.0.0.1", 9320);
        Core_booking_system server_object = new Core_booking_system(server_Socket);
        Scanner read = new Scanner(System.in);
        String full_name = JOptionPane.showInputDialog(null,"Input your name");
        String password =JOptionPane.showInputDialog(null,"Input your Password");
        String Choice = null;
        String serverHostname = "127.0.0.1";
        String location = null;

        System.out.println("Attempting to connect to host " +
                serverHostname + " on port 9320.");

        server_Socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String In_dam="In_Damascus";

        try {
            server_Socket = new Socket(serverHostname, 9320);
            out = new PrintWriter(server_Socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    server_Socket.getInputStream()));
        } catch (Exception e) {
            System.out.println("sorry no connection was made");
        }
        out.println(full_name);
        out.println(password);
        Choice = "0";
        while (Integer.parseInt(Choice) != 3) {
            System.out.println(in.readLine()); //print choice
            Choice = read.next();
            out.println(Choice);
            if(Integer.parseInt(Choice)==1){
                System.out.println(in.readLine());//choose driver
                String driver = read.next();
                out.println(driver);
                if(in.readLine().equals(In_dam)){
                    System.out.println(in.readLine());//choosing location
                    location=read.next();
                    out.println(location);
                    System.out.println(in.readLine());//confirm
                    String confirm = read.next();
                    out.println(confirm);}
                else{
                    System.out.println(in.readLine());//confirm
                    String confirm = read.next();
                    out.println(confirm);
                    System.out.println(in.readLine());
                }}
            else if(Integer.parseInt(Choice)==2){
                System.out.println("Sent Request for trip statement");
            }
            else if(Integer.parseInt(Choice)==3){
                System.out.println(in.readLine());
                break;
            }
            else{
                System.out.println(in.readLine());
            }
        }
        out.close();
        in.close();
        server_Socket.close();
        System.exit(1);
    }
}


