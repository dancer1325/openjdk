package share.classes.java.lang.Character;

public class Main {
    public static void main(String[] args) {
        Character character = Character.valueOf('A');
        System.out.println("character " + character);
        System.out.println("character.charValue() " + character.charValue());

        char charFirst = 'Ω';
        boolean isGreekUnicode = Character.UnicodeBlock.of(charFirst) == Character.UnicodeBlock.GREEK;
        System.out.println("isGreekUnicode " + isGreekUnicode);
    }
}
