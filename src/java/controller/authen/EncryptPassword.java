/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vudm
 */
public class EncryptPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        byte[] salt;
        try {
            System.out.println("Input password:");
            String password = scanner.nextLine().trim();
            salt = getSalt();
            String ePass;
            ePass = encryptPassword(password,salt);
            System.out.println("Pass1:"+ePass);
            System.out.println("Salt:" +Base64.getEncoder().encodeToString(salt));
            
            String salttostring = Base64.getEncoder().encodeToString(salt);
            System.out.println("Pass2:"+encryptPassword(password, Base64.getDecoder().decode(salttostring)));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptPassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EncryptPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    public static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }

    //Encrypt password with Java SHA1 Hashing by password and salt
    public static String encryptPassword(String password, byte[] salt) {
        String encryptedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes 
            byte[] bytes = md.digest(password.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            encryptedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }
}
