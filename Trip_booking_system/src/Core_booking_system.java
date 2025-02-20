import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.net.ServerSocket;

public class Core_booking_system extends Thread{
    protected Socket clientSocket;
    protected static File Passengers_File =new File ("C:\\Users\\amer\\Desktop\\Files\\Passengers_File.txt");
    protected static File  Drivers_File=new File ("C:\\Users\\amer\\Desktop\\Files\\Drivers_File.txt");
    protected static File Damascus_Trips_File=new File ("C:\\Users\\amer\\Desktop\\Files\\Damascus_Trips_File.txt");
    protected static File  Governorates_Trips_File=new File ("C:\\Users\\amer\\Desktop\\Files\\Governorates_Trips_File.txt");
    protected static File  tripFile=new File ("C:\\Users\\amer\\Desktop\\Files\\TripFile.txt");
    public static void setTripFile(File tripFile) {
        Core_booking_system.tripFile = tripFile;
    }
    public static File getTripFile() {
        return tripFile;
    }

    public void setPassengers_File(File Passengers_File) {
        this.Passengers_File = Passengers_File;
    }

    public void setDrivers_File(File Drivers_File) {
        Core_booking_system.Drivers_File = Drivers_File;
    }

    public void setDamascus_Trips_File(File Damascus_Trips_File) {
        Core_booking_system.Damascus_Trips_File = Damascus_Trips_File;
    }

    public void setGovernorates_Trips_File(File Governorates_Trips_File) {
        Core_booking_system.Governorates_Trips_File = Governorates_Trips_File;
    }

    public File getPassengers_File() {
        return Passengers_File;
    }

    public File getDrivers_File() {
        return Drivers_File;
    }

    public File Damascus_Trips_File() {
        return Damascus_Trips_File;
    }

    public File getGovernorates_Trips_File() {
        return Governorates_Trips_File;
    }
    public static void addPassenger(String fullName, String password, double balance) {

        try {
            try (FileWriter writer = new FileWriter(Passengers_File, true)) {
                writer.write(fullName + "," + password + "," + balance + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removePassenger(String fullName) {
        try {
            File inputFile =Passengers_File;
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (!parts[0].equals(fullName)) {
                    writer.write(currentLine + "\n");
                }
            }

            writer.close();
            reader.close();

            Files.move(tempFile.toPath(),Passengers_File.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updatePassengerBalance(String fullName, double newBalance) {
        try {
            File tempFile = new File("C:\\Users\\amer\\Desktop\\Files\\temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(Passengers_File));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (parts[0].equals(fullName)) {
                    writer.write(parts[0] + "," + parts[1] + "," + newBalance + "\n");
                } else {
                    writer.write(currentLine + "\n");
                }
            }
            writer.close();
            reader.close();

            Files.move(tempFile.toPath(),Passengers_File.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void addDriver(String fullName, String triptype, int phoneenumber) {
        try {
            FileWriter writer = new FileWriter(Drivers_File, true);
            writer.write(fullName + "," + triptype + "," + phoneenumber + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removeDriver(String fullName) {
        try {
            File inputFile = Drivers_File;
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (!parts[0].equals(fullName)) {
                    writer.write(currentLine + "\n");
                }
            }

            writer.close();
            reader.close();

            Files.move(tempFile.toPath(),Drivers_File.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }}
    public void updateDrivertrip(String fullName, String newtrip) {
        try {
            File inputFile = Drivers_File;
            File tempFile = new File("C:\\Users\\amer\\Desktop\\Files\\temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (parts[0].equals(fullName)) {
                    writer.write(parts[0] + "," + newtrip+ "," +parts[2] + "\n");
                } else {
                    writer.write(currentLine + "\n");
                }
            }
            writer.close();
            reader.close();

            Files.move(tempFile.toPath(),Drivers_File.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void add_gov_trip(String dst,int req_pass,int available_pass, double approximate, double cost) {

        try {
            try (FileWriter writer = new FileWriter(Governorates_Trips_File, true)) {
                writer.write(dst+ "," + req_pass + "," + available_pass + ","+approximate+ ","+cost+ "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void remove_gov_trip(String dst) {
        try {
            File inputFile = Governorates_Trips_File;
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (!parts[0].equals(dst)) {
                    writer.write(currentLine + "\n");
                }
            }

            writer.close();
            reader.close();

            Files.move(tempFile.toPath(),Governorates_Trips_File.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }}
    public void updategovpassnum(String dst) {
        try {
            File tempFile = new File("C:\\Users\\amer\\Desktop\\Files\\temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(Governorates_Trips_File));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (parts[0].equals(dst)) {
                    writer.write(parts[0] + "," + parts[1] + "," + (Integer.parseInt( parts[2])+1)+"," +parts[3] + "," + parts[4] + "\n");
                } else {
                    writer.write(currentLine + "\n");
                }
            }
            writer.close();
            reader.close();

            Files.move(tempFile.toPath(),Governorates_Trips_File.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void add_damascus_trip(String location, double cost, double approximate) {

        try {
            try (FileWriter writer = new FileWriter(Damascus_Trips_File, true)) {
                writer.write(location+ "," + cost + "," + approximate + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void remove_dam_trip(String location) {
        try {
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(Damascus_Trips_File));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (!parts[0].equals(location)) {
                    writer.write(currentLine + "\n");
                }
            }

            writer.close();
            reader.close();

            Files.move(tempFile.toPath(),Damascus_Trips_File.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }}
    public void update_dam_trip_location(String oldlocation,String newlocation) {
        try {
            File tempFile = new File("C:\\Users\\amer\\Desktop\\Files\\temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(Damascus_Trips_File));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (parts[0].equals(oldlocation)) {
                    writer.write( newlocation+ "," + parts[1] + "," + (Integer.parseInt( parts[2])-1)+"," +parts[3] + "," + parts[4] + "\n");
                } else {
                    writer.write(currentLine + "\n");
                }
            }
            writer.close();
            reader.close();

            Files.move(tempFile.toPath(),Damascus_Trips_File.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void addTrip(String Trip_type, int passengers, double approximate,double cost) {

        try {
            try (FileWriter writer = new FileWriter(tripFile, true)) {
                writer.write(Trip_type+ "," + passengers + "," + approximate + ","+  cost+ "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9320);
            System.out.println ("Connection Socket Created on Core_booking_system Socket on port 9320");
            try {
                while (true)
                {
                    System.out.println ("Waiting for Connection");
                    new Core_booking_system(serverSocket.accept());
                }
            }
            catch (IOException e)
            {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        }
        catch (IOException e)
        {
            System.err.println("Could not listen on port: 9320.");
            System.exit(1);
        }
        finally
        {
            try {
                serverSocket.close();
            }
            catch (IOException e)
            {
                System.err.println("Could not close port: 9320.");
                System.exit(1);
            }
        }
    }

    protected Core_booking_system(Socket clientSoc)
    {
        this.clientSocket = clientSoc;
        start();
    }

    public void run()
    {
        System.out.println ("New Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( clientSocket.getInputStream()));
            String in_dam="In_Damascus";
            String to_gov="To_Governorates";
            String full_name= in.readLine();
            String currentLine;
            String bal=null;
            String password=in.readLine();
            boolean is_exist = false;
            try {

                BufferedReader reader = new BufferedReader(new FileReader(Passengers_File));
                while ((currentLine = reader.readLine()) != null) {
                    String[] parts = currentLine.split(",");
                    if (parts[0].equals(full_name) && parts[1].equals(password)) {
                        is_exist = true;
                    }
                }
                reader.close();
                String choice ="0";
                if (is_exist){
                    while (Integer.parseInt(choice) != 3){
                        out.println("press 1 to  book a trip"+
                                "or 2 for checking trip statement (last 3 trips in damascus) or 3 to exit ");

                        choice = in.readLine();
                        if(Integer.parseInt(choice)==1) {
                            // full_name= in.readLine();

                            //while ((inputLine = in.readLine()) != null)
                            // {
                            //    System.out.println ("Server: " + inputLine);
                            BufferedReader reader_pass = new BufferedReader(new FileReader(Passengers_File));
                            while ((currentLine = reader_pass.readLine()) != null) {
                                String[] parts = currentLine.split(",");
                                if (parts[0].equals(full_name)) {
                                    bal = parts[2];
                                }
                            }

                            reader_pass.close();

                            System.out.println("Your balance is :    " + bal);
                            BufferedReader reader_driver = new BufferedReader(new FileReader(Drivers_File));
                            try {
                                while ((currentLine = reader_driver.readLine()) != null) {
                                    String[] parts = new String[3];
                                    parts = currentLine.split(",");
                                    System.out.println("Driver's full Name is : " + parts[0]
                                            + "Trip type is : " + parts[1] +
                                            "Driver's phone number is : " + parts[2]);
                                }
                            } catch (ArrayIndexOutOfBoundsException i) {
                                System.out.println("thats all!");
                            }
                            reader_driver.close();
                            out.println("please enter which driver you want ");
                            String driver_name = in.readLine();
                            String trip_type = null;
                            BufferedReader reader_driver2 = new BufferedReader(new FileReader(Drivers_File));
                            while ((currentLine = reader_driver2.readLine()) != null) {
                                String[] parts = currentLine.split(",");
                                if (parts[0].equals(driver_name)) {
                                    trip_type = parts[1];
                                }
                            }
                            reader_driver2.close();
                            double trip_cost_dam = 0;
                            double trip_approx_dam = 0;
                            if (trip_type.equals(in_dam)) {
                                out.println(in_dam);
                                BufferedReader reader_dam = new BufferedReader(new FileReader(Damascus_Trips_File));
                                while ((currentLine = reader_dam.readLine()) != null) {
                                    String[] parts = currentLine.split(",");
                                    try {

                                        System.out.println("the trip location is "+parts[0]+"the trip cost is" + parts[1] + "the trip approximate time in minutes is : " + parts[2]);
                                    } catch (ArrayIndexOutOfBoundsException i) {
                                        System.out.println("thats all the trips");
                                    }

                                }
                                reader_dam.close();
                                out.println("please choose a location");
                                String loc=in.readLine();
                                BufferedReader reader_dam2 = new BufferedReader(new FileReader(Damascus_Trips_File));
                                while ((currentLine = reader_dam2.readLine()) != null) {
                                    String[] parts = currentLine.split(",");
                                    try {
                                        if (parts[0].equals(loc)) {
                                            trip_cost_dam = Double.parseDouble(parts[1]);
                                            trip_approx_dam = Double.parseDouble(parts[2]);
                                        }

                                    } catch (ArrayIndexOutOfBoundsException i) {
                                        System.out.println("");
                                    }

                                }
                                reader_dam2.close();


                                out.println("Do you want to confirm? Press press Yes or No");
                                String confirm = in.readLine();
                                String new_bal = null;
                                if (confirm.equals("Yes")) {
                                    reader_pass = new BufferedReader(new FileReader(Passengers_File));
                                    while ((currentLine = reader_pass.readLine()) != null) {
                                        String[] parts = currentLine.split(",");
                                        if (parts[0].equals(full_name)) {
                                            new_bal = String.valueOf(Double.parseDouble(parts[2]) - trip_cost_dam);
                                            parts[2] = new_bal;
                                        }
                                    }
                                    reader_pass.close();
                                    // if(Double.parseDouble(bal)>Double.parseDouble(trip_cost_dam)){
                                    //if you have time continue here to check the postivity of balance
                                    // }
                                    updatePassengerBalance(full_name, Double.parseDouble(new_bal));
                                    System.out.println(new_bal);
                                    addTrip(in_dam, 1, trip_approx_dam, trip_cost_dam);

                                }
                            } else {
                                out.println(to_gov);
                                String trip_dst =trip_type;
                                double trip_cost_gov = 0;
                                double trip_approx_gov = 0;
                                int trip_available_pass = 0;
                                int trip_req_pass = 0;
                                BufferedReader reader_gov = new BufferedReader(new FileReader(Governorates_Trips_File));
                                while ((currentLine = reader_gov.readLine()) != null) {
                                    String[] parts = currentLine.split(",");
                                    try {
                                        if(trip_dst.equals(parts[0])) {
                                            trip_cost_gov = Double.parseDouble(parts[4]);
                                            trip_approx_gov = Double.parseDouble(parts[3]);
                                            trip_req_pass = Integer.parseInt(parts[1]);
                                            trip_available_pass = Integer.parseInt(parts[2]);
                                            System.out.println("The trip destination is " + parts[0] + " the trip cost is" + parts[4] +
                                                    "the trip approximate time in minutes is : " + parts[3] +
                                                    "the Available number of passengers is : " + parts[2]);
                                        }} catch (ArrayIndexOutOfBoundsException i) {
                                        System.out.println("that's all the trips");
                                    }
                                }
                                reader_gov.close();
                                if (trip_req_pass > trip_available_pass) {
                                    out.println("Do you want to confirm? Press press Yes or No");
                                    String confirm = in.readLine();
                                    if (confirm.equals("Yes")) {
                                        updategovpassnum(trip_dst);

                                        if (trip_req_pass == trip_available_pass + 1) {
                                            addTrip(to_gov, trip_req_pass, trip_approx_gov, trip_cost_gov);
                                            updatePassengerBalance(full_name, Double.parseDouble(bal) - trip_cost_gov);
                                        }
                                    }
                                    out.println("if the available seats meet the required the trip wil be added to your file and your balance will be updated");
                                } else {
                                    out.println("sorry this trip is filled press 1 to  book a tripor 2 for checking trip statement (last 3 trips in damascus) or 3 to exit ");

                                }
                            }
                        }
                        else if (Integer.parseInt(choice)==2){
                            String strLine=null;
                            int counter=0;
                            BufferedReader rea = new BufferedReader(new FileReader(Damascus_Trips_File));
                            int lines = 0;
                            while (rea.readLine() != null) lines++;
                            rea.close();
                            int count=lines-3;

                            LineNumberReader reader_dam = new LineNumberReader(new InputStreamReader(new FileInputStream(Damascus_Trips_File), "UTF-8"));

                            while (((strLine = reader_dam.readLine()) != null)){
                                counter=reader_dam.getLineNumber();
                                if(counter<count+1){
                                    continue;
                                }
                                System.out.println(strLine);}

                            reader_dam.close();


                        }
                        else if (Integer.parseInt(choice)==3){
                            out.println("thanks for using our service");
                            continue;
                        }
                        else {
                            out.println("Please enter a valid choice statement");
                        }

                    }}else {
                    System.out.println("Sorry wrong password or username");
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            out.close();
            in.close();
            clientSocket.close();
        }
        catch (IOException e)
        {
            System.err.println("Problem with Communication Server Or the client has disconnected");
        }

    }}


