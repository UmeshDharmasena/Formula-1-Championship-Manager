abstract class Driver {
//https://youtu.be/rxN8Iuo28oQ
    public String Name;
    public String Location;
    public String Team;

    public Driver(String Name,String Location,String Team) {
        this.Name = Name;
        this.Location = Location;
        this.Team = Team;
    }

    public abstract void RemoveName();

    public abstract void SetPoints();
}
