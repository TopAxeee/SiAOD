import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Ex9 {
    public static <ex> void main (String[] arg) throws ScriptException {
        String string = "";
        //создаеи ридер файла
        System.out.println("Text:");
        try (FileReader reader = new FileReader("#9.txt");
             BufferedReader br = new BufferedReader(reader)) {
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                string+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(Calc (Result(string)));//вызываем метод
        new Ex9(string);
    }


    public Ex9 (String Str) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        StringBuilder str1 = new StringBuilder();
        Stack stk= new Stack();
        Stack stk2 = new Stack();
        for (int i = 0; i < Str.length(); i++) {
            stk.add(Str.charAt(i));
        }
        for (int i = 0; i < Str.length(); i++) {
            stk2.add(stk.pop());
        }
        for (int i = 0; i < Str.length(); i++) {
            if (Compare(stk2.peek().toString(), "T"))
                str1.append("true ");
            if (Compare(stk2.peek().toString(), "F"))
                str1.append("false ");
            if (Compare(stk2.peek().toString(), "N"))
                str1.append("! ");
            if (Compare(stk2.peek().toString(), "A"))
                str1.append("&& ");
            if (Compare(stk2.peek().toString(), "X"))
                str1.append("!= ");
            if (Compare(stk2.peek().toString(), "O"))
                str1.append("|| ");
            if (Compare(stk2.peek().toString(), "("))
                str1.append("( ");
            if (Compare(stk2.peek().toString(), ")"))
                str1.append(")");
            stk2.pop();
        }

        Object o;
        o = engine.eval(str1.toString());
        System.out.println(o);
    }
    public static boolean Compare (String str1,String str2){//сравниваем строки
        if(str1.charAt(0)==str2.charAt(0))
            return true;
        return false;
    }
    public static boolean Calc(String input) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (boolean)engine.eval(input);
    }
}
