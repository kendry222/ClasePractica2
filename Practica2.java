public class Practica2 {

    // 1. Eliminar elementos repetidos de la lista
    public static <E> void eliminarRepetidos(IList<E> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).equals(lista.get(j))) {
                    lista.remove(j);
                    j--;
                }
            }
        }
    }

    // 2. Rotar una posición a la derecha: A-B-C-D -> D-A-B-C
    public static <E> void rotarDerecha(IList<E> lista) {
        if (lista.size() > 1) {
            E ultimo = lista.remove(lista.size() - 1);
            lista.add(ultimo, 0);
        }
    }

    // 3. Concatenar dos listas
    public static <E> IList<E> concatenar(IList<E> lista1, IList<E> lista2) {
        IList<E> resultado = new ArrayList<>();
        for (int i = 0; i < lista1.size(); i++) {
            resultado.add(lista1.get(i));
        }
        for (int i = 0; i < lista2.size(); i++) {
            resultado.add(lista2.get(i));
        }
        return resultado;
    }

    // Método auxiliar para imprimir
    public static <E> void imprimirLista(String titulo, IList<E> lista) {
        System.out.print(titulo + ": ");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
            if (i < lista.size() - 1) System.out.print(" - ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Prueba 1: Eliminar repetidos
        System.out.println("=== 1. Eliminar elementos repetidos ===");
        IList<String> listaRepetidos = new ArrayList<>();
        listaRepetidos.add("A");
        listaRepetidos.add("B");
        listaRepetidos.add("A");
        listaRepetidos.add("C");
        listaRepetidos.add("B");
        listaRepetidos.add("D");
        listaRepetidos.add("A");
        imprimirLista("Lista original", listaRepetidos);
        eliminarRepetidos(listaRepetidos);
        imprimirLista("Sin repetidos", listaRepetidos);

        // Prueba 2: Rotar a la derecha
        System.out.println("\n=== 2. Rotar una posición a la derecha ===");
        IList<String> listaRotar = new ArrayList<>();
        listaRotar.add("A");
        listaRotar.add("B");
        listaRotar.add("C");
        listaRotar.add("D");
        imprimirLista("Lista original", listaRotar);
        rotarDerecha(listaRotar);
        imprimirLista("Rotada", listaRotar);

        // Prueba 3: Concatenar
        System.out.println("\n=== 3. Concatenar dos listas ===");
        IList<String> lista1 = new ArrayList<>();
        lista1.add("A");
        lista1.add("B");
        lista1.add("C");
        lista1.add("D");

        IList<String> lista2 = new ArrayList<>();
        lista2.add("E");
        lista2.add("F");
        lista2.add("G");
        lista2.add("H");

        imprimirLista("Lista 1", lista1);
        imprimirLista("Lista 2", lista2);
        IList<String> concatenada = concatenar(lista1, lista2);
        imprimirLista("Concatenada", concatenada);
    }
}