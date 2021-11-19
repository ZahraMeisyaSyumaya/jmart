package com.zahraJmartRK;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable<T> extends Vector<T>{
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
        File f = new File(filepath);
        f.getParentFile().mkdirs();
        f.createNewFile();
        Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
        T[] loaded = readJson(arrayType, filepath);
    }
    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException{
        T reader;
        FileReader fileReader = new FileReader(filepath);
        reader  = gson.fromJson(fileReader, clazz);
        return reader;
    }


    public void writeJson() throws IOException{
        writeJson(this, this.filepath);
    }
    public static void writeJson(Object object, String filepath) throws IOException{
        FileWriter writer = new FileWriter(filepath);
        String json = gson.toJson(object);
        writer.write(json);
        writer.close();
    }
}

