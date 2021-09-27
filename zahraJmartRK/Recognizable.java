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
}
