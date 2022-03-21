import java.util.ArrayList;
import java.util.List;

/**
 * Распечатать строку. Символы в фигурных скобках напечатать столько раз, сколько указано перед открывающейся скобкой.
 * Пример: "2{b}3{fg}" - bbfgfg
 *
 * @author <Artyom Baranov>
 * @since 21 март 2022 г.
 */
public class BraceSolution {

    public static void main(String[] args) {
        System.out.println(getResult("2{b}3{fg}"));
        System.out.println(getResult("ее4{b3{a}zz}vv2{oo}yy"));
        System.out.println(getResult("abcd"));
    }

    public static String getResult(String formula) {
        List<String> stringList = splitString(formula);
        String result = "";
        for (String subString : stringList) {
            if (Character.isDigit(subString.charAt(0))) {
                String textBetweenBrace   = getTextBetweenBrace(subString);
                String text = "";
                if(textBetweenBrace.contains("{")) {
                    text = getResult(textBetweenBrace);
                }
                text = getResult(textBetweenBrace);
                for (int i = 0; i < getCountType(subString); i++) {
                    result = result.concat(text);
                }
            } else {
                result = result.concat(subString);
            }
        }
        return result;
    }

    public static String getTextBetweenBrace(String textInBrace) {
        return textInBrace.substring(textInBrace.indexOf("{") + 1, textInBrace.lastIndexOf("}"));
    }

    public static Integer getCountType(String textInBrace) {
        return Integer.parseInt(textInBrace.split("\\{")[0]);
    }

    public static List<String> splitString(String target) {
        List<String> result = new ArrayList<>();
        if(!target.matches(".*\\d.*") && !target.isEmpty()) {
            result.add(target);
            return result;
        }
        char[] chars = target.toCharArray();
        int countBrace = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i]) && i != 0 && countBrace == 0) {
                result.add(target.substring(0, i));
                result.addAll(splitString(target.substring(i, target.length())));
                break;
            } else if (chars[i] == '{') {
                countBrace++;
            } else if (chars[i] == '}') {
                countBrace--;
                if (countBrace == 0) {
                    result.add(target.substring(0, i + 1));
                    result.addAll(splitString(target.substring(i + 1, target.length())));
                    break;
                }
            }
        }
        return result;
    }
}
