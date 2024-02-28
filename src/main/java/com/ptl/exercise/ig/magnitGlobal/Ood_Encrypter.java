package com.ptl.exercise.ig.magnitGlobal;

//this is the class you need to create at line 6
class Encrypter{
    public static String geEncryptedName(String name) throws IllegalArgumentException{
            Validator validator = new Validator();
            boolean isValid = validator.validate(name);
            if(isValid){
                  StringBuilder sb = new StringBuilder();
                  for(int i = name.length() - 1; i>= 0; i--){
                        sb.append(name.charAt(i));
                  }
                  
                  return sb.toString().toLowerCase();
            }else{
                  throw new IllegalArgumentException("Try again with valid name");
            } 
    }
}

//all below are given
class Validator{
    public boolean validate(String name){
        //given code
        return true;
    }
}
public class Ood_Encrypter {
    
}
