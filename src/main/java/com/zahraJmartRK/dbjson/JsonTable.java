package com.zahraJmartRK;

import java.io.*;
import java.util.Vector;
import java.util.Collections;
import java.lang.reflect.Array;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable <T> extends Vector<T> {

    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
        try {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] baca = readJson(arrayType, filepath);
            if(baca != null) {
                Collections.addAll(this, baca);
            }
        } catch (FileNotFoundException e) {
            File x = new File(filepath);
            File cek = x.getParentFile();
            if(cek != null) {
                cek.mkdir();
            }
            cek.createNewFile();
        }
    }
    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException{
        Reader reader = new FileReader(filepath);
        return gson.fromJson(reader, clazz);
    }

    public void writeJson () throws IOException {
        writeJson(this, this.filepath);
    }


    public static void writeJson(Object objek, String filepath) throws IOException {
        File x = new File(filepath);
        if (!x.exists()){
            File parent = x.getParentFile();
            if (parent != null)
                parent.mkdirs();
            x.createNewFile();
        }
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(objek));
        writer.close();
    }

}

