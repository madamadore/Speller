package net.owpla.speller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

class ItalianRule {

    public boolean isSeparate(String a, String b) {
        BiPredicate<String, String> biPredicate = vowelRule()
                /*.or(cqRule())*/
                .or(isGeminateRule())
                .or(consonantRule());
        return biPredicate.test(a, b);
    }

    private Predicate<Character> isVowel() {
        Predicate<Character> predicate = c-> {
            List<Character> list = new ArrayList<Character>() {{
                this.add('a');
                this.add('e');
                this.add('i');
                this.add('o');
                this.add('u');
            }};
            return list.contains(c);
        };
        return predicate;
    }

    private Predicate<String> isTriphthong() {
        Predicate<String> predicate = (s) -> {
            List<String> list = new ArrayList<String>() {{
                this.add("iai");
                this.add("iei");
                this.add("uai");
                this.add("uoi");
                this.add("iuo");
            }};
            return list.contains(s);
        };
        return predicate;
    }

    private BiPredicate<Character, Character> isDiphthong() {
        BiPredicate<Character, Character> predicate = (c, d) -> {
            List<String> list = new ArrayList<String>() {{
                this.add("ia");
                this.add("ie");
                this.add("io");
                this.add("iu");
                this.add("ua");
                this.add("ue");
                this.add("ui");
                this.add("uo");
                this.add("ai");
                this.add("ei");
                this.add("oi");
                this.add("ui");
                this.add("au");
                this.add("eu");
            }};
            String diphthong = Character.toString(c) + Character.toString(d);
            return list.contains(diphthong);
        };
        return predicate;
    }

    private BiPredicate<Character, Character> isComplexConsonant() {
        BiPredicate<Character, Character> predicate = (c, d) -> {
            if (isConsonant().test(c) && isConsonant().test(d) && isConsonantGroup().negate().test(c, d)) {
                return true;
            }
            return false;
        };
        return predicate;
    }

    private BiPredicate<String, String> vowelRule() {
        BiPredicate<String, String> predicate = (c, d)-> {
            char endOfC = c.charAt(c.length() - 1);
            char startOfD = d.charAt(0);

            if (d.length()>3) {
                String triphthong = d.substring(0, 3);
                if (isTriphthong().test(triphthong)) {
                    return true;
                }
            }

            String triphthong = Character.toString(endOfC);
            if (d.length()>2) {
                triphthong += d.substring(0, 2);
            }

            if (d.length() > 1  && isVowel().test(endOfC) && isConsonant().test(startOfD)
                    && isComplexConsonant().negate().test(startOfD, d.charAt(1))) {
                return true;
            } else if(isTriphthong().test(triphthong) || isDiphthong().test(endOfC, startOfD)) {
                return false;
            } else if (apostropheRule().test(endOfC, startOfD)) {
                return false;
            } else if (isVowel().test(endOfC) && isVowel().test(startOfD)){
                return true;
            }
            return false;
        };
        return predicate;
    }

    private Predicate<Character> isConsonant() {
        Predicate<Character> notAnApostrophe = c->{ return c != '\'' ? true : false; };
        return isVowel().negate().and( notAnApostrophe );
    }

    private BiPredicate<Character, Character> isConsonantGroup() {
        BiPredicate<Character, Character> predicate = (c, d) -> {
            if ((c == 'b' || c == 'c' || c == 'd' || c == 'f' ||
                    c == 'g' || c == 'p' || c == 't' || c == 'v')  &&
                    (d == 'l' || d == 'r')) {
                return true;
            }
            return false;
        };
        return predicate;
    }

    private BiPredicate<String, String> consonantRule() {
        BiPredicate<String, String> predicate = (c, d)-> {
            char endOfC = c.charAt(c.length() - 1);
            char startOfD = d.charAt(0);

            boolean retVal = false;
            if (endOfC == 'c' && startOfD == 'q') {
                return true;
            }else {
                if ((endOfC == 'l' || endOfC == 'm' || endOfC == 'n' || endOfC == 'r') && isConsonant().test(startOfD)) {
                    retVal = true;
                }
                if (isConsonantGroup().test(endOfC, startOfD)) {
                    retVal = false;
                } else if (endOfC == 's' && isConsonant().test(startOfD)) {
                    retVal = false;
                } else if (apostropheRule().test(endOfC, startOfD)) {
                    retVal = false;
                }
            }
            return retVal;
        };
        return predicate;
    }

    private BiPredicate<String, String> isGeminateRule() {
        BiPredicate<String, String> predicate = (c, d)-> {
            char endOfC = c.charAt(c.length() - 1);
            char startOfD = d.charAt(0);
            if (isConsonant().test(endOfC) && endOfC == startOfD) {
                return true;
            }
            return false;
        };
        return predicate;
    }

    private BiPredicate<Character, Character> apostropheRule(){
        BiPredicate<Character, Character> predicate = (c, d)->{
            if(c =='\'' || d  =='\'' ){
                return false;
            }
            return false;
        };
        return predicate;
    }

    private Predicate<String> isDiacritic(){

    }

    private BiPredicate<String, String> diacriticsRule(){
        BiPredicate<String , String> predicate = (c, d)->{
            char endOfC = c.charAt(c.length() - 1);
            char startOfD = d.charAt(0);
            if(){
                return true;
            }
            return false;
        };
        return predicate;
    }
}
