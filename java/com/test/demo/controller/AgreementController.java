package com.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgreementController {

        @GetMapping("userAgreement")
        public String agreement() {
            return "userAgreement";
        }
    }
