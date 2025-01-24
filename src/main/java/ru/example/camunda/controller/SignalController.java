package ru.example.camunda.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.example.camunda.model.TriggerSignalCommand;

@RestController
@RequestMapping("/signal")
@RequiredArgsConstructor
public class SignalController {

    private final RuntimeService runtimeService;

    @PostMapping
    public ResponseEntity<?> triggerSignal(@RequestBody TriggerSignalCommand command) {
        runtimeService.createSignalEvent(command.getName()).send();
        return ResponseEntity.ok("Signal send");
    }
}
