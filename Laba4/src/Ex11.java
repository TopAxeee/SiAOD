import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Ex11 {
    public static <ex> void main (String[] arg) throws ScriptException {
        String string = "";
        //создаеи ридер файла
        System.out.println("Text:");
        try (FileReader reader = new FileReader("#11.txt");
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
        new Ex11(string);//вызываем метод
    }


    public Ex11(String Str) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        //Object o =engine.eval(code);
        StringBuilder str1 = new StringBuilder();
        Stack stk = new Stack();
        Stack stk2 = new Stack();
        for (int i = 0; i < Str.length(); i++) {
            stk.add(Str.charAt(i));
        }
        for (int i = 0; i < Str.length(); i++) {
            stk2.add(stk.pop());
        }
        for (int i = 0; i < Str.length(); i++) {
            if (Compare(stk2.peek().toString(), "x"))
                str1.append("1");
            if (Compare(stk2.peek().toString(), "y"))
                str1.append("2");
            if (Compare(stk2.peek().toString(), "z"))
                str1.append("3");
            if (Compare(stk2.peek().toString(), "("))
                str1.append("( ");
            if (Compare(stk2.peek().toString(), ")"))
                str1.append(")");
            if (Compare(stk2.peek().toString(), "+"))
                str1.append("+");
            if (Compare(stk2.peek().toString(), "-"))
                str1.append("-");
            stk2.pop();
        }
        try {
            Object o = engine.eval(str1.toString());
            System.out.println("true" );
        } catch (Throwable e) {
            System.out.println("false" );
        }

    }
    public static boolean Compare (String str1,String str2){//сравниваем строки
        if(str1.charAt(0)==str2.charAt(0))
            return true;
        return false;
    }
}
