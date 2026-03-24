package com.transcipcion.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranscripcionController {
    private final TranscripcionService transcripcionService;

    public TranscripcionController(TranscripcionService transcripcionService) {
        this.transcripcionService = transcripcionService;
    }

    @GetMapping("/transcribir")
    public String transcribirAudio(@RequestParam String audioPath) {
        return transcripcionService.transcribir(audioPath);
    }
}
