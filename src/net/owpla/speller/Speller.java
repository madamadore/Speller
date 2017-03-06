package net.owpla.speller;

import java.util.Collection;
import java.util.function.Function;

@FunctionalInterface
public interface Speller extends Function<String, Collection<String>> {
    Collection<String> apply(String word);
}

/*

 Dato M che è un modello della "realtà" (una canzone o poesia), occorre
 sviluppare una funzione f(M) tale che mappi il modello in una
 matrice di double da dare "in pasto" alla rete di Kohonen.

    M -> x, y = f(M) -> double matrix = new double[x][y];
    f(M) = ??

 Per riconoscere un ritornello da una strofa la funzione f(M) potrebbe contare,
 con opportuni "pesi":
  - Il numero di insiemi di parole (S)

  - la ripetizione (o meno) di ogni S
  - il numero di versi (V) in ogni S

  - la ripetizione (o meno) di versi (V) all'interno di S
  - il numero di sillabe in ogni V

  Una Strofa (S) è caratterizzata da:
    - numero di versi
    - ripetizione dei versi
    - rime (numero e tipo, schema: ABA, ABBA, BBAB, ...)
    - numero di sillabe per ogni verso

*/
