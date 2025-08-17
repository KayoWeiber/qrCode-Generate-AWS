package com.kayoweiber.qrcode.generator.controller;

import com.kayoweiber.qrcode.generator.dto.qrcode.QrCodeGenerateRequest;
import com.kayoweiber.qrcode.generator.dto.qrcode.QrGenerateResponse;
import com.kayoweiber.qrcode.generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {
    private  final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeService){
        this.qrCodeGeneratorService = qrCodeService;
    }
    @PostMapping
    public ResponseEntity<QrGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request){
        try{
            QrGenerateResponse response = qrCodeGeneratorService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
