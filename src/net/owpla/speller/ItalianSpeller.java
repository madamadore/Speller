package net.owpla.speller;

import java.util.ArrayList;
import java.util.List;

public class ItalianSpeller implements Speller {

    private char[] wordCharArray;
    private List<String> spell;

    @Override
    public List<String> apply(String word) {
        wordCharArray = word.toCharArray();
        spell = new ArrayList<>();

        if (wordCharArray.length > 0) {
            spell();
        }

        return spell;
    }

    private void spell() {
        spell.clear();
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
    }

}