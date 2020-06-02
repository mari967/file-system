package tests;

import fs.BloqueArchivo;
import fs.HighLevelFileSystem;
import org.junit.Before;
import org.testng.annotations.Test;

public class EjemplosDeUso {
    private HighLevelFileSystem unFileSystem;
    private BloqueArchivo c0;
    private BloqueArchivo c1;
    private BloqueArchivo c2;

    @Before
    public void init() {
        unFileSystem = new HighLevelFileSystem();
        c0 = new BloqueArchivo(0,3);
        c1 = new BloqueArchivo(4,4);
        c2 = new BloqueArchivo(5,10);
    }


    @Test
    public void lecturaArchivoTresCampos() {
        int archivo = unFileSystem.abrirArchivo("/archivoDeTresCampos");
        unFileSystem.leerArchivoSinc(archivo, c0);
        unFileSystem.leerArchivoSinc(archivo, c1);
        unFileSystem.leerArchivoSinc(archivo, c2);
    }

    public void escrituraArchivoTresCampos() {
        int archivoEscritura = unFileSystem.abrirArchivo("/otro/archivo");
        unFileSystem.leerArchivoSinc(archivoEscritura, c0);
        unFileSystem.leerArchivoSinc(archivoEscritura, c1);
        unFileSystem.leerArchivoSinc(archivoEscritura, c2);
    }


    public void leerArchivoCompleto
}
