
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phillip
 */
public class TM_ {
    public static void main(String[] args) {
        String[] delta = {"q0 a q1 _ R", "q0 _ q3 _ L", "q0 b q4 b R",
            "q0 X q0 X R", "q1 a q1 a R", "q1 b q2 X L", "q1 X q1 X R", 
            "q1 _ q4 _ L", "q2 a q2 a L", "q2 X q2 X L", "q2 _ q0 _ R", "q2 b q4 b R"};
        TM_ tm = new TM_(delta, "q0", "q3", "q4");
        tm.run("aabbbb");
    }

    String[] delta;
    String q0;
    String qa;
    String qr;
    StringBuilder output = new StringBuilder("");
    HashMap<String, String> map = new HashMap<>();
    int tapeHead = 0;

    TM_(String[] delta, String q0, String qa, String qr) {
        this.delta = delta;
        this.q0 = q0;
        this.qa = qa;
        this.qr = qr;
    }

    public void run(String w) {
        for (String s: delta) {
            String[] str = stringSplit(s);
            //System.out.println(str[0] + " >> " + str[1]);
            map.put(str[0], str[1]);
        }
       
        String currentState = q0;
        output.append(w);
        output.insert(tapeHead, q0);
        System.out.println(output.toString());
        output.delete(tapeHead, tapeHead + q0.length());
        
        while (true) {
            if (currentState.equals(qa)) {
                System.out.println("ACCEPT"); break;
            }
            if (currentState.equals(qr)) {
                System.out.println("REJECT"); break;
            }
            String s = map.get(currentState + " " + output.charAt(tapeHead));
            String[] info = s.split(" ");
            String nextState = info[0];
            String ch = info[1];
            String direction = info[2];
            
            output.delete(tapeHead, tapeHead + 1);
            if (direction.equals("L")) {
                
            
            output.insert(tapeHead, ch);
            output.insert(tapeHead - 1, nextState);
            System.out.println(output.toString());
            output.delete(tapeHead - 1, tapeHead + nextState.length() - 1);
            }
            else {
                
            
            output.insert(tapeHead, nextState);
            output.insert(tapeHead, ch);
            System.out.println(output.toString());
            output.delete(tapeHead + 1, tapeHead  + 1 + nextState.length());
            }
            if (direction.equals("L")) {
                if (tapeHead != 0) {
                tapeHead -= 1;
            } 
            }
            else {
                tapeHead += 1;
            }
            currentState = nextState;
        }
    }

    public String[] stringSplit(String s) {
        int count = 0;
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
                if (count == 0 || count == 1) {
                    string1.append(s.charAt(i));
                } else {
                    string2.append(s.charAt(i));
                }
            } else {

                if (count == 0 || count == 1) {
                    string1.append(s.charAt(i));
                } else {
                    string2.append(s.charAt(i));
                }

            }
        }
               
        return new String[]{string1.toString().trim(), string2.toString().trim()};
               
    }
               

}
