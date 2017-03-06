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

        syllables = (ArrayList<String>) is.apply("udine");
        assertEquals("udine", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("u"); this.add("di"); this.add("ne"); }});

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
        assertEquals("pianura", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("pia"); this.add("nu"); this.add("ra"); }});

        syllables = (ArrayList<String>) is.apply("aiuola");
        assertEquals("aiuola", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("a"); this.add("iuo"); this.add("la"); }});

        syllables = (ArrayList<String>) is.apply("dito");
        assertEquals("dito", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("di"); this.add("to"); }});

        syllables = (ArrayList<String>) is.apply("texano");
        assertEquals("texano", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("te"); this.add("xa"); this.add("no"); }});

        syllables = (ArrayList<String>) is.apply("nessun'amica");
        assertEquals("nessun'amica", 5, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("nes"); this.add("su"); this.add("n'a"); this.add("mi"); this.add("ca"); }});

        syllables = (ArrayList<String>) is.apply("sull'albero");
        assertEquals("sull'albero", 4, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("sul"); this.add("l'al"); this.add("be"); this.add("ro"); }});

        syllables = (ArrayList<String>) is.apply("chiaro");
        assertEquals("chiaro", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("chia"); this.add("ro"); }});

        syllables = (ArrayList<String>) is.apply("luglio");
        assertEquals("chiaro", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("lu"); this.add("glio"); }});

        syllables = (ArrayList<String>) is.apply("schiavo");
        assertEquals("schiavo", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("schia"); this.add("vo"); }});

        syllables = (ArrayList<String>) is.apply("bruma");
        assertEquals("bruma", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("bru"); this.add("ma"); }});

        syllables = (ArrayList<String>) is.apply("cloro");
        assertEquals("cloro", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("clo"); this.add("ro"); }});

        syllables = (ArrayList<String>) is.apply("prugna");
        assertEquals("prugna", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("pru"); this.add("gna"); }});

        syllables = (ArrayList<String>) is.apply("storico");
        assertEquals("storico", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("sto"); this.add("ri"); this.add("co"); }});

        syllables = (ArrayList<String>) is.apply("strada");
        assertEquals("strada", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("stra"); this.add("da"); }});

        syllables = (ArrayList<String>) is.apply("mostruoso");
        assertEquals("mostruoso", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("mo"); this.add("struo"); this.add("so"); }});

        syllables = (ArrayList<String>) is.apply("collo");
        assertEquals("collo", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("col"); this.add("lo"); }});

        syllables = (ArrayList<String>) is.apply("blocco");
        assertEquals("blocco", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("bloc"); this.add("co"); }});

        syllables = (ArrayList<String>) is.apply("acquatico");
        assertEquals("acquatico", 4, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("ac"); this.add("qua"); this.add("ti"); this.add("co"); }});

        syllables = (ArrayList<String>) is.apply("stanco");
        assertEquals("stanco", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("stan"); this.add("co"); }});

        syllables = (ArrayList<String>) is.apply("erba");
        assertEquals("erba", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("er"); this.add("ba"); }});

        syllables = (ArrayList<String>) is.apply("alto");
        assertEquals("alto", 2, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("al"); this.add("to"); }});

        syllables = (ArrayList<String>) is.apply("sorpresa");
        assertEquals("sorpresa", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("sor"); this.add("pre"); this.add("sa"); }});

        syllables = (ArrayList<String>) is.apply("oltranzista");
        assertEquals("oltranzista", 4, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("ol"); this.add("tran"); this.add("zi"); this.add("sta"); }});

        syllables = (ArrayList<String>) is.apply("soppressata");
        assertEquals("soppressata", 4, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("sop"); this.add("pres"); this.add("sa"); this.add("ta"); }});

        syllables = (ArrayList<String>) is.apply("feldspato");
        assertEquals("feldspato", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("feld"); this.add("spa"); this.add("to"); }});

        syllables = (ArrayList<String>) is.apply("tungsteno");
        assertEquals("tungsteno", 3, syllables.size());
        assertEquals(syllables, new ArrayList<String>(){{ this.add("tung"); this.add("ste"); this.add("no"); }});
    }
}
