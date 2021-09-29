package com.company;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main{

    public static void main(String[] args) {

        /*
        Ejercicio 1:
        crearDirectorio("/home/dam2a/NetBeansProjects/arquivos/arquivosdir");
        eDirectorio("/home/dam2a/NetBeansProjects/arquivos/arquivosdir");
         */
        /*
        Ejercicio 2:
        crearFicheiro("/home/dam2a/NetBeansProjects/arquivos/arquivosdir","Products1.txt");
        if (eFicheiro("/home/dam2a/NetBeansProjects/arquivos/arquivosdir/Products1.txt")){
            System.out.println("es un fichero");
        }
         */

        /*
        Ejercicio 3:
        crearDirectorio("/home/dam2a/NetBeansProjects/arquivos/arquivosdir/subdir");
        crearFicheiro("/home/dam2a/NetBeansProjects/arquivos/arquivosdir/subdir","Products2.txt");
         */
        /*
        Ejercicio 4:
        mContido("/home/dam2a/NetBeansProjects/arquivos/arquivosdir");
         */
        /*
        Ejercicio 5:
        modoAcceso("/home/dam2a/NetBeansProjects/arquivos/arquivosdir","Products1.txt");
        calculaLonxitude("/home/dam2a/NetBeansProjects/arquivos/arquivosdir","Products1.txt");
         */
        /*
        Ejercicio 6:
        mLectura("/home/dam2a/NetBeansProjects/arquivos/arquivosdir","Products1.txt");
         */
        /*
        Ejercicio 7:
        mEscritura("/home/dam2a/NetBeansProjects/arquivos/arquivosdir","Products1.txt");
         */
        /*
        Ejercicio 8:
        borraFicheiro("/home/dam2a/NetBeansProjects/arquivos/arquivosdir","Products1.txt");
         */
        /*
        Ejercicio 9:
        borraFicheiro("/home/dam2a/NetBeansProjects/arquivos/arquivosdir/subdir","Products2.txt");
        borraDirectorio("/home/dam2a/NetBeansProjects/arquivos/arquivosdir/subdir");
        borraFicheiro("/home/dam2a/NetBeansProjects/arquivos/arquivosdir","Products1.txt");
        borraDirectorio("/home/dam2a/NetBeansProjects/arquivos/arquivosdir");
        borraDirectorio("/home/dam2a/NetBeansProjects/arquivos");
         */
        /*
        Ejercicio 10:
        recur("/home/dam2a/NetBeansProjects/arquivos");
         */


    }

    public static boolean eDirectorio(String path) {
        boolean result = false;
        try{
            File file = new File(path);
            result=file.isDirectory();
        }catch (Exception e){
        }
        return result;
    }

    public static boolean eFicheiro(String path) {
        boolean result = false;
        try{
            File file = new File(path);
            result=file.isFile();

        }catch (Exception e){
        }
        return result;
    }

    public static void crearDirectorio(String path) {

        try{
            if(!new File(path).isDirectory()){
                new File(path).mkdirs();
                System.out.println("directorio creado");
            }else{
                System.out.println("El directorio ya existe.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void crearFicheiro(String path, String fileName) {

        try{
            Path filePath = Paths.get(path, fileName);
            if(new File(path).isDirectory()){
                new File(filePath.toString()).createNewFile();
            } else {
                new File(path).mkdir();
                new File(filePath.toString()).createNewFile();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void modoAcceso(String path, String fileName) {

        try {

            Path filePath = Paths.get(path,fileName);
            File file = new File(filePath.toString());
            final String LECTURA = file.canRead() ? "Lectura si" : "Lectura no";
            final String ESCRITURA = file.canWrite() ? "Escritura si" : "Escritura no";
            System.out.println(LECTURA);
            System.out.println(ESCRITURA);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void calculaLonxitude(String path, String fileName) {
        try {
            Path filePath = Paths.get(path, fileName);
            File file = new File(filePath.toString());
            System.out.println(file.length() + " bytes");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void mLectura(String path, String fileName) {
        try {
            Path filePath = Paths.get(path, fileName);
            File file = new File(filePath.toString());
            file.setReadOnly();
            System.out.println(file.getName() + " ahora es de solo lectura");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mEscritura(String path, String fileName) {
        try {
            Path filePath = Paths.get(path, fileName);
            File file = new File(filePath.toString());
            file.setWritable(true);
            System.out.println(file.getName() + " ahora se puede escribir");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void borraFicheiro(String path, String fileName) {
        try {
            Path filePath = Paths.get(path, fileName);
            File file = new File(filePath.toString());

            if (file.exists()) {
                file.delete();
                System.out.println("El archivo se ha eliminado");
            } else {
                System.out.println("El archivo no existe");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void borraDirectorio(String path) {
        try {
            File file = new File(path);

            if (file.exists() && file.isDirectory()) {
                file.delete();
                System.out.println("El directorio se ha eliminado");
            } else {
                System.out.println("El directorio no existe");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mContido(String path) {
        try {
            File file = new File(path);
            for (File subFile : file.listFiles()) {
                System.out.println(subFile.getName());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void recur(String path) {

        File file = new File(path);
        File[] list = file.listFiles();

        if (list == null)return;

        for (File f : list){
            if (f.isDirectory()){
                recur(f.getAbsolutePath());
                System.out.println("Path directorio: "+ f.getAbsoluteFile());
                System.out.println("");
            }else {
                System.out.println("Path archivo: " + f.getAbsoluteFile());
                System.out.println("");
            }
        }


    }

}
