package Calculator;

import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {

    Converter converter = new Converter();
    String[] actions = {"+", "-", "/", "*"};
    String[] regexActions = {"\\+", "-", "/", "\\*"};



    int actionIndex= -1;
    for (int i = 0; i < actions.length; i++) {
        if (calc().contains(actions[i])) {
            actionIndex = i;
            break;
        }

    }
    if(actionIndex == -1) {
        System.out.println("Cтрока не является математической операцией");
        return;
    }
        String[] data = calc().split(regexActions[actionIndex]);
   if(data.length == 3){
       System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
       return;
   }
    if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
        int a,b;
        boolean isRoman = converter.isRoman(data[0]);
        if(isRoman){
            a = converter.romanToInt(data[0]);
            b = converter.romanToInt(data[1]);

        }else{
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
        }
        int result = switch (actions[actionIndex]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
        if(isRoman){if (result < 0) {
            System.out.println("В римской системе нет отрицательных чисел");
            return;
        }else if (result == 0) {
            System.out.println("в римской системе нет 0");
            return;
        }
            System.out.println(converter.intToRoman(result));
        }else{
            System.out.println(result);
        }
    } else{
        System.out.println("Используются одновременно разные системы счисления");
    }
}public static String calc(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        return scn.nextLine();
    }
}


