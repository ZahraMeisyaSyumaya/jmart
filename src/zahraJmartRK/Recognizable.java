package zahraJmartRK;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Recognizable
{
    public final int id;

    protected Recognizable(int id)
    {
        this.id = id;
    }

    public int compareTo(Recognizable other) {
        return (this.id < other.id) ? -1 : ((this.id == other.id) ? 0 : 1);
    }

    public boolean equals(Object objek)
    {
        if (objek instanceof Recognizable)
        {
            Recognizable r = (Recognizable)objek;
            return r.id == id ? true : false;
        }
        return false;
    }

     public boolean equals (Recognizable r){
        if (r.id == this.id){
            return true;
        }
        else{
            return false;
        }
    }

    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id) {
        return 0;
    }

    public static <T extends Recognizable> int getClosingId(Class<T> clazz) {
        return 0;
    }

}
