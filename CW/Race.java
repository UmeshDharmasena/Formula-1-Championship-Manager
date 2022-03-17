public class Race extends Formula1ChampionshipManager {
    String DriverName;
    int RacePosition;
    String Date;

    public Race(String DriverName,int RacePosition,String Date) {
        this.DriverName = DriverName;
        this.RacePosition = RacePosition;
        this.Date = Date;
    }

    public String GetDriverName() {
        return DriverName;
    }

    public int GetRacePosition() {
        return RacePosition;
    }

    public String GetDate() {
        return Date;
    }

}