package net.owpla.speller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ItalianSpeller implements Speller {

    private char[] wordCharArray;

    @Override
    public List<String> apply(String word) {
        wordCharArray = word.toCharArray();

        List<String> syllabes = null;
        if (wordCharArray.length > 0) {
            syllabes = spell();
            String sillabaLunga = syllabes.stream().max(Comparator.comparing(String::length)).get();
            int indexOfSillabaLunga = syllabes.indexOf(sillabaLunga);
            System.out.println(syllabes + " (" + sillabaLunga + ") " + indexOfSillabaLunga);
        }

        return syllabes;
    }

    private double versoInNumero(String verso) {
        String str = verso.toUpperCase();
        double ris = 0;
        for ( int i = 0; i < str.length(); i++ ) {
            ris += ( (str.charAt(i) / 100.0) * Math.pow(str.length(),(i * -1) ) );
        }
        return ris;
    }

    private List<String> spell() {
        List<String> spell = new ArrayList<>();
        StringBuffer syllabe = new StringBuffer(wordCharArray.length);
        syllabe.append(wordCharArray[0]);

        for (int i=0; i<wordCharArray.length-1; i++) {
            String restOfString = new String(wordCharArray).substring(i+1);

            ItalianRule ruler = new ItalianRule();
            if (ruler.isSeparate(syllabe.toString(), restOfString)) {
                String slb = syllabe.toString();
                spell.add(slb);
                syllabe = new StringBuffer(wordCharArray.length);
            }
            syllabe.append(restOfString.charAt(0));
        }

        String slb = syllabe.toString();
        spell.add(slb);
        return spell;
    }

}