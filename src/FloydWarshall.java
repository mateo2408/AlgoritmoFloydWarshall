import java.util.Scanner;

public class FloydWarshall {
    // Representa infinito para las distancias no alcanzables.
    final static int INF = 99999;

    // Método que implementa el algoritmo de Floyd-Warshall
    public static void floydWarshall(int[][] graph) {
        int vertices = graph.length; // Número de vértices en el grafo
        int[][] dist = new int[vertices][vertices]; // Matriz de distancias

        // Inicializar la matriz de distancias con los valores del grafo original.
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Aplicar el algoritmo Floyd-Warshall
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    // Si el camino a través del vértice k es más corto, actualizar la distancia
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist);
    }

    // Método para imprimir la matriz de distancias
    public static void printSolution(int[][] dist) {
        int vertices = dist.length; // Número de vértices en el grafo
        System.out.println("Matriz de distancias más cortas entre todos los pares de vértices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                // Imprimir "INF" si la distancia es infinita
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    // Imprimir la distancia
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Ingrese el número de vértices:");
        int vertices = scanner.nextInt(); // Leer el número de vértices

        int[][] graph = new int[vertices][vertices]; // Crear la matriz de adyacencia
        System.out.println("Ingrese la matriz de adyacencia (use " + INF + " para infinito):");

        // Leer la matriz de adyacencia desde la entrada del usuario
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // Llamar al método floydWarshall para calcular las distancias más cortas
        floydWarshall(graph);
    }
}