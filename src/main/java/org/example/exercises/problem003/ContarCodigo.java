package org.example.exercises.problem003;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContarCodigo {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());

            String rutaArchivo = selectedFile.getAbsolutePath();

            try {
                File archivo = new File(rutaArchivo);
                FileReader lectorArchivo = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(lectorArchivo);

                String linea;
                int lineasDeCodigo = 0;
                int lineasEnBlanco = 0;
                int lineasDeComentarios = 0;
                int clases = 0;
                int funciones = 0;
                int objetos = 0;
                int lineasInservibles = 0;

                boolean dentroComentario = false;

                while ((linea = bufferedReader.readLine()) != null) {
                    linea = linea.trim();

                    if (linea.isEmpty()) {
                        lineasEnBlanco++;
                    } else if (linea.startsWith("//")) {
                        lineasDeComentarios++;
                    } else if (linea.startsWith("/*")) {
                        dentroComentario = true;
                        lineasDeComentarios++;
                    } else if (linea.endsWith("*/")) {
                        dentroComentario = false;
                        lineasDeComentarios++;
                    } else if (!dentroComentario) {
                        if (!linea.equals("{") && !linea.equals("}") && !linea.startsWith("import") && !linea.startsWith("package")) {
                            lineasDeCodigo++;

                            if (linea.matches(".*\\bclass\\b.*\\{.*")) {
                                clases++;
                            }

                            if (linea.matches(".*\\b\\w+\\s+\\w+\\(.*\\)\\s*\\{.*")) {
                                funciones++;
                            }

                            if (linea.matches(".*\\bnew\\s+\\w+.*")) {
                                objetos++;
                            }
                        } else {
                            lineasInservibles++;
                        }
                    }
                }

                System.out.println("Líneas de código: " + lineasDeCodigo);
                System.out.println("Líneas en blanco: " + lineasEnBlanco);
                System.out.println("Líneas de comentarios: " + lineasDeComentarios);
                System.out.println("Clases: " + clases);
                System.out.println("Funciones: " + funciones);
                System.out.println("Objetos: " + objetos);
                System.out.println("Líneas inservibles: " + lineasInservibles);

                bufferedReader.close();
                lectorArchivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
