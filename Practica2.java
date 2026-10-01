public class Practica2 {

    
    public static <E> void quitarRepetidos(IList<E> l) {
        int i = 0;
        while (i < l.size()) {
            int j = i + 1;
            while (j < l.size()) {
                if (l.get(i).equals(l.get(j))) {
                    l.remove(j);
                } else {
                    j++;
                }
            }
            i++;
        }
    }

    
    public static <E> void rotar(IList<E> l) {
        if (l.size() <= 1) {
            return;
        }
        E aux = l.get(l.size() - 1);
        l.remove(l.size() - 1);
        l.add(aux, 0);
    }

    
    public static <E> IList<E> juntar(IList<E> a, IList<E> b) {
        IList<E> res = new ArrayList<>();
        int i = 0;
        while (i < a.size()) {
            res.add(a.get(i));
            i++;
        }
        i = 0;
        while (i < b.size()) {
            res.add(b.get(i));
            i++;
        }
        return res;
    }

    
    public static <E> void mostrar(IList<E> l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i));
            if (i != l.size() - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

       
        System.out.println("--- repetidos ---");
        IList<String> lista1 = new ArrayList<>();
        lista1.add("A");
        lista1.add("B");
        lista1.add("A");
        lista1.add("C");
        lista1.add("B");
        lista1.add("D");
        lista1.add("A");
        System.out.print("antes: ");
        mostrar(lista1);
        quitarRepetidos(lista1);
        System.out.print("despues: ");
        mostrar(lista1);

        
        System.out.println();
        System.out.println("--- rotar ---");
        IList<String> lista2 = new ArrayList<>();
        lista2.add("A");
        lista2.add("B");
        lista2.add("C");
        lista2.add("D");
        System.out.print("antes: ");
        mostrar(lista2);
        rotar(lista2);
        System.out.print("despues: ");
        mostrar(lista2);

        
        System.out.println();
        System.out.println("--- juntar ---");
        IList<String> l1 = new LinkedList<>();
        l1.add("A");
        l1.add("B");
        l1.add("C");
        l1.add("D");

        IList<String> l2 = new LinkedList<>();
        l2.add("E");
        l2.add("F");
        l2.add("G");
        l2.add("H");

        System.out.print("lista 1: ");
        mostrar(l1);
        System.out.print("lista 2: ");
        mostrar(l2);
        IList<String> unida = juntar(l1, l2);
        System.out.print("unidas: ");
        mostrar(unida);
    }
}
    

