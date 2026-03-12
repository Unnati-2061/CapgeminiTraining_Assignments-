package org.example;
import org.example.OtpGenerator;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class SixDigitOtpGenerator implements OtpGenerator {
    @Override
    public String getOtp(){
        return " " +  new Random().nextInt(1000000);
    }
}
