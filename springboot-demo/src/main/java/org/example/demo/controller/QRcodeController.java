package org.example.demo.controller;

import org.example.demo.util.QRcodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@RestController
public class QRcodeController {

    @GetMapping("/qrcode")
    public void qrcode(String url, HttpServletResponse response) throws Exception {
        QRcodeUtil.encode(url,response);
    }



}
