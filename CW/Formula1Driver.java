import java.util.Comparator; //https://youtu.be/TIPnQe2-iPE
public class Formula1Driver extends Driver {

    int[] Position = {0,0,0,0,0,0,0,0,0,0};
    int Points;
    int RacesParticipated;
    

    public Formula1Driver(String Name, String Location, String Team,int[] Position, int Points, int RacesParticipated) {
        super(Name,Location,Team);
        this.Position = Position;
        this.Points = Points;
        this.RacesParticipated = RacesParticipated;
    }

    

    public void SetName(String Name) {
        this.Name = Name;
    }

    public void SetLocation(String Location) {
        this.Location = Location;
    }

    public void SetPosition(int[] Position) {
        this.Position = Position;
    }


    public void SetRacesParticipated(int RacesParticipated){
        this.RacesParticipated = RacesParticipated;
    }

    public String GetName() {
        return Name;
    }

    public String GetLocation() {
        return Location;
    }

    public String GetTeam() {
        return Team;
    }

    public int[] GetPosition(){
        return Position;
    }

    public int GetPoints(){
        return Points;
    }

    public int GetRacesParticipated(){
        return RacesParticipated;
    }

    public void RemoveName() {
        System.out.println("Driver Removed");
    }

    public void SetPoints(){
        int Points = 0;
        int TempPoints = 0;
        for (int i = 0; i <10; i++){
            int Temp = Position[i];
            switch (i){
                case 0:
                TempPoints = Temp * 25;
                Points = Points + TempPoints;
                break;
                case 1:
                TempPoints = Temp * 18;
                Points = Points + TempPoints;
                break;
                case 2:
                TempPoints = Temp * 15;
                Points = Points + TempPoints;
                break;
                case 3:
                TempPoints = Temp * 12;
                Points = Points + TempPoints;
                break;
                case 4:
                TempPoints = Temp * 10;
                Points = Points + TempPoints;
                break;
                case 5:
                TempPoints = Temp * 8;
                Points = Points + TempPoints;
                break;
                case 6:
                TempPoints = Temp * 6;
                Points = Points + TempPoints;
                break;
                case 7:
                TempPoints = Temp * 4;
                Points = Points + TempPoints;
                break;
                case 8:
                TempPoints = Temp * 2;
                Points = Points + TempPoints;
                break;
                case 9:
                TempPoints = Temp * 1;
                Points = Points + TempPoints;
                break;
            }
        }
        this.Points = Points;
    }

    public static Comparator<Formula1Driver> Sort = new Comparator<Formula1Driver>(){

        @Override
        public int compare(Formula1Driver D1, Formula1Driver D2){
            int Points1 = D1.GetPoints();
            int Points2 = D2.GetPoints();
            return Points2 - Points1;
        }
    };

    @Override    
    public String toString() {
        return "[Name :" + Name + ", Team :" + Team + ", Points :" +Points + "]";
    }

}

//    public static void main(String[] args) {
//    Driver obj = new Formula1Driver();
//    obj.name();
//    obj.location();
//   obj.team();
//    obj.statistics();
//    }