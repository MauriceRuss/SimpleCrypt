package rocks.zipcodewilmington;

import java.io.*;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    ROT13(Character cs, Character cf) {
    }

    ROT13() {
        this('a', 'm');
    }


    public String crypt(String text) throws UnsupportedOperationException {
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
        }

        return text;
    }

    public String encrypt(String text) {
        String encrypt = crypt(text);
        return encrypt;
    }

    public String decrypt(String text) {
        String decrypt = crypt(text);
        return decrypt;
    }

    public static String rotate(String s, Character c) {
        Integer index = s.indexOf(c);
        return s.substring(index) + s.substring(0, index);
    }

    public static void encyptTextFile() throws Exception{
        ROT13 rot13 = new ROT13();
        File file = new File("/Users/mruss/Documents/Projects/SimpleCrypt/sonnet18.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();

        String line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            String fileString = stringBuilder.toString();
            String fileEncrypted = rot13.encrypt(fileString);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/mruss/Documents/Projects/SimpleCrypt/sonnet18.encrpted"));
            bufferedWriter.write(fileEncrypted);
            bufferedWriter.close();
            System.out.println(fileEncrypted);

    }

}
