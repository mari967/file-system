package fs;

import java.util.function.Consumer;

public class HighLevelFileSystem {
    LowLevelFileSystem fileSystem;
    byte[] bufferBytes;

    public int abrirArchivo(String directorio) {
        int fd_archivo = fileSystem.openFile(directorio);
        if ( fd_archivo < 0)
            throw new NoSePudoAbrirArchivoException("El archivo no puedo ser abierto");
        return fd_archivo;
    }

    public void cerrarArchivo(int fd_archivo) {
        fileSystem.closeFile(fd_archivo);
    }

    public int leerArchivoSinc(int fd_archivo, BloqueArchivo bloque) {
        int cant_leida = fileSystem.syncReadFile(fd_archivo, bufferBytes, bloque.comienzo, bloque.fin);

        if(cant_leida <= 0)
            throw new NoSePudoLeerArchivoException("No fue posible realizar la lectura");

        return cant_leida;
    }

    public void escribirArchivoSinc(int fd_archivo, BloqueArchivo bloque) {
        fileSystem.syncWriteFile(fd_archivo, bufferBytes, bloque.comienzo, bloque.fin);
    }


    public void leerArchivoAsinc(int fd_archivo, BloqueArchivo bloque, Consumer<Integer> callback) {
        fileSystem.asyncReadFile(fd_archivo, bufferBytes, bloque.comienzo, bloque.fin, callback);
    }

}

