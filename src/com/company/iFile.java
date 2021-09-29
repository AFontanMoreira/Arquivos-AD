package com.company;

public interface iFile {
    public void eDirectorio(String path);
    public void eFicheiro(String path);
    public void crearDirectorio(String path);
    public void crearFicheiro(String path, String fileName);
    public void modoAcceso(String path, String fileName);
    public void calculaLonxitude(String path, String fileName);
    public void mLectura(String path, String fileName);
    public void mEscritura(String path, String fileName);
    public void borraFicheiro(String path, String fileName);
    public void borraDirectorio(String path);
    public void mContido(String path);
    public void recur(String path);
}
