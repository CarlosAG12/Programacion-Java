package com.transcipcion.service;

import org.springframework.stereotype.Service;
import org.vosk.Model;
import org.vosk.Recognizer;

import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class TranscripcionService {
    public String transcribir(String audioPath){
        String rutaModelo = "modelo/vosk-model-small-es-0.42";

        try(Model model = new Model(rutaModelo)){
            InputStream audioStream = new FileInputStream(audioPath);
            Recognizer recognizer = new Recognizer(model, 16000.0f);
            
            byte[] buffer = new byte[4096];
            int bytesLeidos;
            StringBuilder resultado = new StringBuilder();

            while ((bytesLeidos = audioStream.read(buffer)) != -1) {
                if (recognizer.acceptWaveForm(buffer, bytesLeidos)) {
                    resultado.append(recognizer.getResult()).append("\n");
                }
            }
            resultado.append(recognizer.getFinalResult());
            return resultado.toString();

        }catch(Exception e){
            throw new RuntimeException("Error al transcribir el audio " + e);
        }


    }
}
