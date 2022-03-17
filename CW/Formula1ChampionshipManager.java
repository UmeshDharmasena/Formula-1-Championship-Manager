import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.*;


public class Formula1ChampionshipManager implements ChampionshipManager{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Formula1Driver> DriverList = new ArrayList(); //https://www.w3schools.com/java/java_arraylist.asp
    static Table Table = new Table();
    static ArrayList<Race> RaceList = new ArrayList();

    public static void main(String[] args) {
        Formula1Driver Driver = new Formula1Driver(null, null, null, null, 0, 0);
        Race Event = new Race(null, 0, null);
        Table.ShowTable();
        while (true) {
            String Selection;
            do {
                System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
                System.out.println("1 : Add new driver \n2 : Delete a driver \n3 : Change a driver \n4 : Display driver details \n5 : Display driver table \n6 : Add a race \n7 : Save in a file \n8 : Read from a file \n9 : Exit ");
                System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
                System.out.println("Type in your selection :");
                Selection = sc.nextLine();
                System.out.println("                                                                                ");
            } while (!Selection.equalsIgnoreCase("1") && !Selection.equalsIgnoreCase("2")
                    && !Selection.equalsIgnoreCase("3") && !Selection.equalsIgnoreCase("4")
                    && !Selection.equalsIgnoreCase("5") && !Selection.equalsIgnoreCase("6")
                    && !Selection.equalsIgnoreCase("7") && !Selection.equalsIgnoreCase("8")
                    && !Selection.equalsIgnoreCase("9"));
            switch (Selection) {
                case "1":
                    AddDriver();
                    Table.setValues(DriverList);
                    break;
                case "2":
                    DeleteDriver();
                    Table.setValues(DriverList);
                    break;
                case "3":
                    ChangeDriver();
                    Table.setValues(DriverList);
                    break;
                case "4":
                    DisplayDriver();
                    break;
                case "5":
                    DisplayTable();
                    break;
                case "6":
                    AddRace();
                    Table.setValues(DriverList);
                    break;
                case "7":
                    SaveFile();
                    break;
                case "8":
                    try {
                        ReadFile();
                        Table.setValues(DriverList);
                    }catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "9":
                    System.exit(0);
            }
        }
    }
    private static void ReadFile() throws NoSuchElementException{
        try {
            File file = new File("DriverTextfile.txt");
            Scanner reader = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = reader.nextLine();

                String[] parts = data.split(":");
                String part1 = parts[0];
                String part2 = parts[1];
                String[] one = part1.split("#");
                String one1 = one[0];
                String one2 = one[1];
                String one3 = one[2];
                String one4 = one[3];
                int ione4 = Integer.parseInt(one4);
                String one5 = one[4];
                int ione5 = Integer.parseInt(one5);
                String[] temp = part2.split("#");
                int [] ipart2 = new int[10];
                for (int i = 0; i < temp.length; i++){
                    ipart2[i] = Integer.parseInt(temp[i]);
                }
                Formula1Driver Driver1 = new Formula1Driver(one1, one2, one3, ipart2, ione4, ione5);
                DriverList.add(Driver1);
            }
            reader.close();
            //Table.setDriverValues(DriverList);
            System.out.println("Successfully updated Array.");
        } catch (IOException except) {
            System.out.println("Error");
            except.printStackTrace();
        }
        try{
            File file2 = new File("RaceTextfile.txt");
            Scanner reader2 = new Scanner(file2);
            while (sc.hasNextLine()){
                String data = reader2.nextLine();
                String[] pa = data.split(":");
                String p1 = pa[0];
                String p2 = pa[1];
                int ip2 = Integer.parseInt(p2);
                String p3 = pa[2];
                Race Event1 = new Race(p1, ip2, p3);
                RaceList.add(Event1);
            }
            reader2.close();

            System.out.println("Successfully updated Array.");
        } catch (IOException except) {
            System.out.println("Error");
            except.printStackTrace();
        }
        throw new NoSuchElementException("ERROR");
    }
    private static void SaveFile() {
        String SaveChoice;
        do{
        System.out.println("1 : Save Driver File \n2 : Save Race File");
        SaveChoice = sc.nextLine();
        }while (!SaveChoice.equalsIgnoreCase("1") && !SaveChoice.equalsIgnoreCase("2"));
        switch (SaveChoice) {
            case "1":
                try {
                    String str = "";
                    FileWriter writer = new FileWriter("DriverTextfile.txt");
                    for (int i = 0; i < DriverList.size(); i++) {
                        Formula1Driver Read = DriverList.get(i);
                        int[] temp = Read.GetPosition();
                        int First = temp[0];
                        int Second = temp[1];
                        int Third = temp[2];
                        int Fourth = temp[3];
                        int Fifth = temp[4];
                        int Sixth = temp[5];
                        int Seventh = temp[6];
                        int Eighth = temp[7];
                        int Ninth = temp[8];
                        int Tenth = temp[9];
                        str = Read.GetName() + "#" + Read.GetLocation() + "#" + Read.GetTeam() + "#"
                                + Read.GetPoints() + "#" + Read.GetRacesParticipated() + ':' + First + '#' + Second + '#' + Third + '#' + Fourth + '#' + Fifth + '#' + Sixth + '#' + Seventh + '#' + Eighth + '#' + Ninth + '#' + Tenth;
                        writer.write(str + "\n");
                    }
                    writer.close();
                    System.out.println("Successfully updated file.");
                } catch (IOException except) {
                    System.out.println("Error");
                    except.printStackTrace();
                }
                break;
            case "2":
                try {
                    String str = "";
                    FileWriter writer = new FileWriter("RaceTextfile.txt");
                    for (int i = 0; i < RaceList.size(); i++) {
                        Race Read = RaceList.get(i);
                        str = Read.GetDriverName() + "#" + Read.GetRacePosition() + "#" + Read.GetDate();
                        writer.write(str + "\n");
                    }
                    writer.close();
                    System.out.println("Successfully updated file.");
                } catch (IOException except) {
                    System.out.println("Error");
                    except.printStackTrace();
                }
                break;
        }
    }
    private static void AddRace() {
        for (int count = 0; count < DriverList.size(); count++) {
            System.out.println("Enter Driver Name :");
            String DriverName = sc.nextLine();

            int RacePosition;
            do{
                System.out.println("Enter Driver Position :");
                RacePosition = sc.nextInt();
            }while(RacePosition != 1 && RacePosition != 2
            && RacePosition != 3 && RacePosition != 4
            && RacePosition != 5 && RacePosition != 6
            && RacePosition != 7 && RacePosition != 8
            && RacePosition != 9 && RacePosition != 10 );
            sc.nextLine();

            System.out.println("Enter Race Date(DD/MM/YYYY) :");
            String Date = sc.nextLine();

            Race Event1 = new Race(DriverName, RacePosition, Date);
            RaceList.add(Event1);

            System.out.println(Event1.GetDriverName());
            System.out.println(Event1.GetRacePosition());
            System.out.println(Event1.GetDate());

            for (int i = 0; i < DriverList.size(); i++) {
                Formula1Driver Read = DriverList.get(i);
                String TempName = Read.GetName();
                if (TempName.equalsIgnoreCase(DriverName)){
                    int Races = Read.GetRacesParticipated();
                    Races = Races + 1;
                    Read.SetRacesParticipated(Races);
                    int[] PositionArray = Read.GetPosition();
                    int Position = PositionArray[RacePosition-1];
                    PositionArray[RacePosition-1] = Position + 1;
                    Read.SetPosition(PositionArray);
                    Read.SetPoints();
                    DriverList.remove(i);
                    DriverList.add(Read);
                }
            }
        }
    }
    private static void DisplayTable() {
        SortDec();
        for (int i = 0; i < DriverList.size(); i++) {
            Formula1Driver Read = DriverList.get(i);
            System.out.println("[Name :" + Read.GetName() + ", Team :" + Read.GetTeam() + ", Points :" + Read.GetPoints() + "]");
        }
    }
    private static void DisplayDriver() {
        System.out.println("Enter Driver Name :");
        String Name = sc.nextLine();
        for (int i = 0; i < DriverList.size(); i++) {
            Formula1Driver Read = DriverList.get(i);
            String TempName = Read.GetName();
            if (TempName.equalsIgnoreCase(Name)){
                System.out.println("Total Number of Points: " + Read.GetPoints());
                System.out.println("Total Number of Races Participated: " + Read.GetRacesParticipated());
                int[] Temp = Read.GetPosition();
                int Count = 1;
                for (int j = 0; j < 3; j++) {
                    System.out.println("Number of "+ (Count + j) + " Positions: " + Temp[j]);
                }
            }
        }
    }
    private static void ChangeDriver() {
        System.out.println("Enter Driver Team :");
        String Team = sc.nextLine();

        
        for (int i = 0; i < DriverList.size(); i++) {
            Formula1Driver Test = DriverList.get(i);
            String TempTeam = Test.GetTeam();
            if (TempTeam.equalsIgnoreCase(Team)){
                DriverList.remove(i);

                System.out.println("Enter Driver Name :");
                String Name = sc.nextLine();

                System.out.println("Enter Driver Location :");
                String Location = sc.nextLine();

                System.out.println("Enter Number of Races Participated in:");
                int RacesParticipated = sc.nextInt();         
                int Flag = 0;
                int First = 0;
                int Second = 0;
                int Third = 0;
                int Fourth = 0;
                int Fifth = 0;
                int Sixth = 0;
                int Seventh = 0;
                int Eighth = 0;
                int Ninth = 0;
                int Tenth = 0;
                do{
                    System.out.println("Enter Race Positions:");
                    Flag = 0;
                    System.out.println("Enter how many times 1st positon was scored:");
                    First = sc.nextInt();
                    Flag = Flag + First;
                    System.out.println("Enter how many times 2nd positon was scored:");
                    Second = sc.nextInt();
                    Flag = Flag + Second;
                    System.out.println("Enter how many times 3rd positon was scored:");
                    Third = sc.nextInt();
                    Flag = Flag + Third;
                    System.out.println("Enter how many times 4th positon was scored:");
                    Fourth = sc.nextInt();
                    Flag = Flag + Fourth;
                    System.out.println("Enter how many times 5th positon was scored:");
                    Fifth = sc.nextInt();
                    Flag = Flag + Fifth;
                    System.out.println("Enter how many times 6th positon was scored:");
                    Sixth = sc.nextInt();
                    Flag = Flag + Sixth;
                    System.out.println("Enter how many times 7th positon was scored:");
                    Seventh = sc.nextInt();
                    Flag = Flag + Seventh;
                    System.out.println("Enter how many times 8th positon was scored:");
                    Eighth = sc.nextInt();
                    Flag = Flag + Eighth;
                    System.out.println("Enter how many times 9th positon was scored:");
                    Ninth = sc.nextInt();
                    Flag = Flag + Ninth;
                    System.out.println("Enter how many times 10th positon was scored:");
                    Tenth = sc.nextInt();
                    Flag = Flag + Tenth;
                }while(Flag != RacesParticipated);

                int[] PositionArray={First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth, Tenth};
                Formula1Driver Driver1 = new Formula1Driver(Name,Location,Team,PositionArray,0,RacesParticipated);
                DriverList.add(Driver1);
                Driver1.SetPoints();
            }
        }
    }
    private static void DeleteDriver() {
        System.out.println("Enter Driver Name: ");
        String Name = sc.nextLine();
        for (int i = 0; i < DriverList.size(); i++) {
            Formula1Driver Read = DriverList.get(i);
            String TempName = Read.GetName();
            if (TempName.equalsIgnoreCase(Name)){
                DriverList.remove(i);
                Read.RemoveName();
            }
        }
    }
    public static void AddDriver () {
        System.out.println("Enter Driver Name :");
        String Name = sc.nextLine();

        System.out.println("Enter Driver Location :");
        String Location = sc.nextLine();
        
        System.out.println("Enter Driver Team :");
        String Team = sc.nextLine();
        boolean UTeam = false;
        do{
            UTeam = true;
            for (int i = 0; i < DriverList.size(); i++) {
                String TempTeam = DriverList.get(i).GetTeam();
                if (TempTeam.equalsIgnoreCase(Team)){
                    Formula1ChampionshipManager ex = new Formula1ChampionshipManager();
                    ex.TeamVerify();
                    UTeam = false;
                    System.out.println("Enter Driver Team :");
                    Team = sc.nextLine();
                
                }
            }
        }while(UTeam == false);
        

        System.out.println("Enter Number of Races Participated in:");
        int RacesParticipated = sc.nextInt();         
        int Flag = 0;
        int First = 0;
        int Second = 0;
        int Third = 0;
        int Fourth = 0;
        int Fifth = 0;
        int Sixth = 0;
        int Seventh = 0;
        int Eighth = 0;
        int Ninth = 0;
        int Tenth = 0;
        do{
            System.out.println("Enter Race Positions:");
            Flag = 0;
            System.out.println("Enter how many times 1st positon was scored:");
            First = sc.nextInt();
            Flag = Flag + First;
            System.out.println("Enter how many times 2nd positon was scored:");
            Second = sc.nextInt();
            Flag = Flag + Second;
            System.out.println("Enter how many times 3rd positon was scored:");
            Third = sc.nextInt();
            Flag = Flag + Third;
            System.out.println("Enter how many times 4th positon was scored:");
            Fourth = sc.nextInt();
            Flag = Flag + Fourth;
            System.out.println("Enter how many times 5th positon was scored:");
            Fifth = sc.nextInt();
            Flag = Flag + Fifth;
            System.out.println("Enter how many times 6th positon was scored:");
            Sixth = sc.nextInt();
            Flag = Flag + Sixth;
            System.out.println("Enter how many times 7th positon was scored:");
            Seventh = sc.nextInt();
            Flag = Flag + Seventh;
            System.out.println("Enter how many times 8th positon was scored:");
            Eighth = sc.nextInt();
            Flag = Flag + Eighth;
            System.out.println("Enter how many times 9th positon was scored:");
            Ninth = sc.nextInt();
            Flag = Flag + Ninth;
            System.out.println("Enter how many times 10th positon was scored:");
            Tenth = sc.nextInt();
            Flag = Flag + Tenth;
        }while(Flag != RacesParticipated);

        int[] PositionArray={First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth, Tenth};

        
        

        Formula1Driver Driver1 = new Formula1Driver(Name,Location,Team,PositionArray,0,RacesParticipated);
        Driver1.SetPoints();
        DriverList.add(Driver1);
    }

    public void TeamVerify() {
        System.out.println("Team already taken");
    }

    public static void SortDec(){ //https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
        Collections.sort(DriverList,Formula1Driver.Sort);
        for(int i = 0; i < (DriverList.size()-1); i++) {
            int j = i + 1;
            if(DriverList.get(i).GetPoints() == DriverList.get(j).GetPoints()){
                int[] Drive1 = DriverList.get(i).GetPosition();
                int[] Drive2 = DriverList.get(i).GetPosition();
                if (Drive1[0] < Drive2[0]){
                    Collections.swap(DriverList,i,j);
                }
            }
        }
    }

    public ArrayList<Formula1Driver> GetDriverList(){
        return DriverList;
    }
}