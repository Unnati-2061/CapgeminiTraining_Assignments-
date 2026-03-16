package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserVerifier {
    @Autowired
    OtpGenerator otpGenerator ;
    @Autowired
    OtpGenerator FourDigitOtpGenerator;
    @Autowired
    OtpGenerator SixDigitOtpGenerator;
//    @Autowired


    @Autowired
    public UserVerifier(OtpGenerator otpGenerator){
        super();
        System.out.println("constructor setting the otpgenerator " + otpGenerator);
        this.otpGenerator = otpGenerator;
    }
//    @Autowired
//    public void setOtpGenerator(OtpGenerator otpGenerator){
//        System.out.println("settig the topgenerator" + otpGenerator);
//        this.otpGenerator = otpGenerator;
//    }
    public void verfiyUser(){
        String otp = otpGenerator.getOtp();
        if(otp!=null){
            System.out.println("user verifies");
        }else{
            System.out.println("user verification fails");
        }
        System.out.println(otpGenerator);
        System.out.println(FourDigitOtpGenerator);
        System.out.println(SixDigitOtpGenerator);
    }
}
