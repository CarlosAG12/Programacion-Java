package com.transcipcion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class AudioController {

    @PostMapping("/transcribir")
    public ResponseEntity<String> transcribirAudio(@RequestParam("audio") MultipartFile audio) {

        if (audio.isEmpty()) {
            return ResponseEntity.badRequest().body("No se recibió ningún archivo");
        }

        String nombreArchivo = audio.getOriginalFilename();
        long tamano = audio.getSize();

        String respuesta = "Archivo recibido: " + nombreArchivo + " | Tamaño: " + tamano + " bytes";

        return ResponseEntity.ok(respuesta);
    }
}
