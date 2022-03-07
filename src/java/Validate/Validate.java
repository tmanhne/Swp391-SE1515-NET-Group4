package Validate;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Chu Tuan Thong
 */
public class Validate {

    private static String regexname = "^[\\w\\d\\@\\{3,15}\\.\\p{L}]+$";
    private static String regexpass = "^[\\w\\d\\@]+$";
    private static String regexInt = "^\\d+$";
    private static String regexDouble = "^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$";
    private static String regexEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\]";

    //ThongCT - Validate Name function   
    public static boolean checkName(String name) {
        return Pattern.matches(regexname, name.trim());
    }

    //ThongCT - Validate Number function 
    public static boolean checkInt(String number) {
        number = number.trim();
        // can't null string
        if (number.isEmpty()) {
            return false;
        }
        // number must contain only digit
        if (!number.trim().matches(regexInt)) {
            return false;
        }
        try {
            // try catch parseInt
            int x = Integer.parseInt(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //ThongCT - Validate Number function 
    public static boolean checkUnitInStock(String number) {
        number = number.trim();
        // can't null string
        if (number.isEmpty()) {
            return false;
        }
        // number must contain only digit
        if (!number.trim().matches(regexInt)) {
            return false;
        }
        try {
            // try catch parseInt
            int x = Integer.parseInt(number);
            // unit in stock must positive
            if (x < 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // ThongCT Validate Double function 
    public static boolean checkDouble(String number) {
        number = number.trim();
        // number must contain - and digit and , 
        if (!number.trim().matches(regexDouble)) {
            return false;
        }
        try {
            // check for parse Double 
            Double x = Double.parseDouble(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // ThongCT Validate Double function 
    public static boolean checkPrice(String number) {
        number = number.trim();
        // can't null string
        if (number.isEmpty()) {
            return false;
        }
        // number must contain - and digit and , 
        if (!number.matches(regexDouble)) {
            return false;
        }
        try {
            // check for parse Double 
            Double x = Double.parseDouble(number);
            // price is positive
            if (x < 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // ThongCT Validate Date function 
    public static boolean checkDate(String input) throws Exception {
        if (input.isEmpty()) {
            return false;
        }
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        f.setLenient(false);
        try {
            f.parse(input);
        } catch (ParseException ex) {
            throw new Exception("Please enter date by format dd/MM/yyyy");
        }
        return true;
    }

    public static boolean checkEmail(String input) {
        return input.trim().matches(regexEmail);
    }

    /*
        ThongCt
        Validate Password 
        password can not empty 
        password at least 4 digit
        password at least 1 lower character 1 upper character 1 digit
    
     */
    public static boolean checkPass(String pass) {
        if (Pattern.matches(regexpass, pass) && !pass.isEmpty()) {
            if (pass.length() <= 4) {
                return false;
            }
            int lowerCharacter = 0;
            int upperCharacter = 0;
            int digit = 0;

            // count number of digit , character
            for (Character c : pass.toCharArray()) {
                if (c.compareTo('a') >= 0 && c.compareTo('z') <= 0) {
                    ++lowerCharacter;
                } else if (c.compareTo('A') >= 0 && c.compareTo('Z') <= 0) {
                    ++upperCharacter;
                } else if (c.compareTo('0') >= 0 && c.compareTo('9') <= 0) {
                    ++digit;
                }

            }

            //number of each type must greater than 1             
            if (lowerCharacter < 1 || upperCharacter < 1 || digit < 1) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkLinkImage(String url) {
        try {
            new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }

        return true;
    }

    /**
     * Check email
     *
     * @param email
     * @return email is valid
     */
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    public static boolean checkPhoneNumber(String s) {
        Pattern p = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})\\b");
        Matcher m = p.matcher(s);
        return (m.matches());
    }
}
