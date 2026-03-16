package com.transcipcion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class AudioController {

    @PostMapping("/transcribir")
    public ResponseEntity<String> transcribirAudio(@RequestParam("audio") MultipartFile audio) {
        
        if (audio == null || audio.isEmpty()) {
            return ResponseEntity.badRequest().body("No se recibió ningún archivo");
        }

        String respuesta = "Transcripción del audio: [Aquí iría la transcripción real del audio]" + audio;

        return ResponseEntity.ok(respuesta);
    }
}
