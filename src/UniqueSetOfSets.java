import java.util.*;

public class TRAI_22_X6_dankurhi implements TRAI_22_X6 {

    public <E> Map<Set<E>, Set<Set<E>>> erillisetJoukot(Set<Set<E>> SS) {
        Map<Set<E>, Set<Set<E>>> tulos = new HashMap<>();

        // TODO

        Map<E, Set<Set<E>>> Apukuvaus = new HashMap<>();    //Luodaan kuvaus avuksi

        for (Set<E> alkiojoukko1 : SS) {    //Käydään alkiojoukot läpi
                for (E alkio : alkiojoukko1) {  //Käydään alkiot läpi alkiojoukoista
                    Apukuvaus.computeIfAbsent(alkio, k -> new HashSet<>()).add(alkiojoukko1); //Yhdistetään arvo avaimeen, jos avainta ei ole liitetty mihinkään hashmap-arvoon
            }
        }
        for (Set<E> alkiojoukko2 : SS) {   //Käydään alkiojoukot läpi
            Set<Set<E>> SShashset = new HashSet<>(SS);  //Tehdään joukkojen joukosta HashSet

            for (E x : alkiojoukko2) {
                SShashset.removeAll(Apukuvaus.get(x)); //Poistetaan hashsetistä arvot, jotka löytyvät Apukuvauksesta
            }
            if (SShashset.contains(alkiojoukko2)){  //Poistetaan hashsetistä alkiojoukkoja, jottei samoja joukkoja ole sekä avaimena että arvona
                SShashset.remove(alkiojoukko2);
            }
            tulos.put(alkiojoukko2, SShashset); //Lisätään tulos-kuvaukseen joukot
        }
        return tulos;   //Palautetaan tulos-kuvaus
    }
}