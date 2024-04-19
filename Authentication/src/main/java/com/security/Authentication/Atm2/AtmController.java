package com.security.Authentication.Atm2;

import co.ke.emtechhouse.Atm2.dto.ResponseDto;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(value = "/atm")
@RequestMapping("/atms")
public class AtmController {

    private final AtmService atmService;

    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @PostMapping("/addAtms")
    public ResponseEntity<?> createAtm(@RequestBody Atm atm) {
        try {
            return ResponseEntity.ok().body(atmService.addAtm(atm));
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    @GetMapping("/getAtms")
    public ResponseEntity<?> getAtms() {
        try {
            return ResponseEntity.ok().body(atmService.getAtms());
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    @GetMapping("all")
    public ResponseEntity<EntityResponse<List<ResponseDto>>> getAllAtms() {
        try {
            return ResponseEntity.ok().body(atmService.listAllAtms());
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    @DeleteMapping("/permanent/delete")
    public ResponseEntity<EntityResponse<?>> permanentDelete(@RequestParam String terminalId) {
        try {
            return ResponseEntity.ok().body(atmService.permanentDelete(terminalId));
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

    @DeleteMapping("/delete/{terminalId}")
    public ResponseEntity<EntityResponse<?>> delete(@PathVariable("terminalId") String terminalId) {
        try {
            return ResponseEntity.ok().body(atmService.delete(terminalId));
        } catch (Exception e) {
            log.info("Catched Error {} " + e);
            return null;
        }
    }

}
