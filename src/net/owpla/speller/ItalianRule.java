package net.owpla.speller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

class ItalianRule {

    public boolean isSeparate(String a, String b) {
        BiPredicate<String, String> biPredicate =
                vowelRule()
                .or(geminateRule())
                .or(consonantRule());
        return biPredicate.test(a, b);
    }

    public Predicate<Character> isVowel() {
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

    public Predicate<String> isTriphthong() {
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

    public Predicate<String> isDiphthong() {
        Predicate<String> predicate = s -> {
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
            return list.contains(s);
        };
        return predicate;
    }

    public Predicate<String> hasProparoxytoneSuffix() {
        Predicate<String> predicate = s -> {
            List<String> list = new ArrayList<String>() {{
                this.add("agine");
                this.add("aggine");
                this.add("igine");
                this.add("iggine");
                this.add("edine");
                this.add("udine");
                this.add("abile");
                this.add("evole");
                this.add("ibile");
                this.add("ico");
                this.add("aceo");
                this.add("ognolo");
                this.add("oide");
                this.add("cefalo");
                this.add("crate");
                this.add("dromo");
                this.add("fago");
                this.add("filo");
                this.add("fobo");
                this.add("fono");
                this.add("gamo");
                this.add("geno");
                this.add("gono");
                this.add("grafo");
                this.add("logo");
                this.add("mane");
                this.add("metro");
                this.add("nomo");
                this.add("stato");
                this.add("tesi");
                this.add("ttero");
                this.add("fero");
                this.add("fugo");
                this.add("voro");
            }};
            for (String suffix : list) {
                if (s.endsWith(suffix)) {
                    return true;
                }
            }
            return false;
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
            if (d.length() > 3) {
                triphthong += d.substring(0, 3);
            }
            if (isTriphthong().test(triphthong)) {
                return true;
            }
            if (d.length() > 2) {
                triphthong += d.substring(0, 2);
            }

            String D = d.length() > 1 ? d.substring(0, 2) : "";
            String E = d.length() > 2 ? d.substring(0, 3) : "";
            String diphthong = Character.toString(endOfC) + Character.toString(startOfD);

            if (isVowel().test(endOfC) && (isDiacritic().test(D) || isDiacritic().test(E))) {
                return true;
            } else if (d.length() > 1  && isVowel().test(endOfC) && isConsonant().test(startOfD)
                    && isComplexConsonant().negate().test(startOfD, d.charAt(1))) {
                return true;
            } else if (isVowel().test(endOfC) && startOfD == 's' && d.length() > 1 && d.charAt(1) != 's') {
                return true;
            } else if(isTriphthong().test(triphthong) || isDiphthong().test(diphthong)) {
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
            char secondOfD = d.length() > 1 ? d.charAt(1) : d.charAt(0);

            boolean retVal = false;
            if (isConsonant().test(endOfC) && startOfD == 'h') {
                return false;
            } else if (diacriticsRule().test(c, d)) {
                return false;
            }else if (endOfC == 'c' && startOfD == 'q') {
                return true;
            } else {
                if ((endOfC == 'l' || endOfC == 'm' || endOfC == 'n' || endOfC == 'r') && isConsonant().test(startOfD)) {
                    retVal = true;
                    if (d.length() > 1 && secondOfD=='s') {
                        retVal = false;
                    }
                }
                if (isConsonantGroup().test(endOfC, startOfD)) {
                    retVal = false;
                } else if (isConsonant().test(endOfC) && startOfD == 's') {
                    retVal = true;
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

    private BiPredicate<String, String> geminateRule() {
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

    private Predicate<String> isDiacritic() {
        Predicate<String> predicate = s-> {
            List<String> diatrics = Arrays.asList(new String[] {
                    "gli", "gna", "gne", "gni", "gno", "gnu",
                    "sce", "sci", "che", "chi", "ghe", "ghi",
                    "cia", "cio", "ciu", "gia", "gio", "giu",
                    "glia", "glie", "glii", "glio", "gliu",
                    "scia", "scie", "scii", "scio", "sciu",
            });
            return diatrics.contains(s);
        };
        return predicate;
    }

    private BiPredicate<String, String> diacriticsRule() {
        BiPredicate<String , String> predicate = (c, d)->{
            String A = (d.length() > 1) ? Character.toString(c.charAt(c.length() - 1)) + d.substring(0, 2) : Character.toString(c.charAt(c.length() - 1)) + d.substring(0, 1);
            String B = (c.length() > 1) ? Character.toString(c.charAt(c.length() - 2)) + d.substring(0, 1) : Character.toString(c.charAt(c.length() - 1)) + d.substring(0, 1);
            if ( isDiacritic().test(A) || isDiacritic().test(B) ){
                return false;
            }
            return false;
        };
        return predicate;
    }
}
