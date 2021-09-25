package zahraJmartRK;


/**
 * Write a description of class FileParser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

    public interface FileParser
{
    boolean read (String content);
    default Object write() {
        return null;
    }
    
    static Object newInstance (String content){
        return null;
    }
    
}
