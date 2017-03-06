package net.owpla.speller.test;

import net.owpla.speller.ItalianSpeller;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by emme on 06/03/2017.
 */
public class UnitTest {

    @Test
    public void testWord() {
        ArrayList<String> syllables = null;
        ItalianSpeller is = new ItalianSpeller();
        syllables = (ArrayList<String>) is.apply("amido");
        assertEquals("amido", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("a"); this.add("mi"); this.add("do"); }});

        syllables = (ArrayList<String>) is.apply("transatlantico");
        assertEquals("transatlantico", 5, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("tran"); this.add("sa"); this.add("tlan"); this.add("ti"); this.add("co"); }});

        syllables = (ArrayList<String>) is.apply("acqua");
        assertEquals("acqua", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("acq"); this.add("ua"); }});

        syllables = (ArrayList<String>) is.apply("qua");
        assertEquals("qua", 1, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("qua"); }});

        syllables = (ArrayList<String>) is.apply("matto");
        assertEquals("matto", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("mat"); this.add("to"); }});

        syllables = (ArrayList<String>) is.apply("stoico");
        assertEquals("stoico", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("stoi"); this.add("co"); }});

        syllables = (ArrayList<String>) is.apply("ghetto");
        assertEquals("ghetto", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("ghet"); this.add("to"); }});

        syllables = (ArrayList<String>) is.apply("mia");
        assertEquals("mia", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("mi"); this.add("a"); }});

        syllables = (ArrayList<String>) is.apply("leone");
        assertEquals("leone", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("le"); this.add("o"); this.add("ne"); }});

        syllables = (ArrayList<String>) is.apply("pianura");
        assertEquals(3, syllables.size());

        syllables = (ArrayList<String>) is.apply("aiuola");
        assertEquals(3, syllables.size());

        syllables = (ArrayList<String>) is.apply("dito");
        assertEquals(2, syllables.size());

        syllables = (ArrayList<String>) is.apply("texano");
        assertEquals(3, syllables.size());

        syllables = (ArrayList<String>) is.apply("nessun'amica");
        assertEquals(5, syllables.size());

        syllables = (ArrayList<String>) is.apply("sull'albero");
        assertEquals(4, syllables.size());

        syllables = (ArrayList<String>) is.apply("chiaro");
        syllables = (ArrayList<String>) is.apply("luglio");
        syllables = (ArrayList<String>) is.apply("schiavo");

        syllables = (ArrayList<String>) is.apply("bruma");
        syllables = (ArrayList<String>) is.apply("cloro");
        syllables = (ArrayList<String>) is.apply("prugna");

        syllables = (ArrayList<String>) is.apply("storico");
        syllables = (ArrayList<String>) is.apply("strada");
        syllables = (ArrayList<String>) is.apply("mostruoso");
    }
}
