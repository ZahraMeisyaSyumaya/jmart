package zahraJmartRK;

public class Complaint extends Recognizable implements FileParser{
    public String date;
    public String desc;

    public Complaint(int id, String desc){
        super(id);
        this.date = "sunday";
        this.desc = desc;
    }

    @Override
    public boolean read(String content){
        return false;
    }
}