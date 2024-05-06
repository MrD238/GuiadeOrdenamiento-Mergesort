public class App {
    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            //busca el punto medio del arreglo
            int mid = (left + right) / 2;
    
            //ordena recursivamente la mitad izquierda
            mergeSort(arr, left, mid);

            //ordena recursivamente pero ahora del lado derecho
            mergeSort(arr, mid + 1, right);
    
            //ahora combina as 2 mitades ordenadas
            merge(arr, left, mid, right);
        }
    
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        //tamaños de los subarreglos a unir 
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;
    
        //arreglos temporales para almacenar los subarreglos anteriores
        int[] temLeft = new int[sizeLeft];
        int[] temRight = new int[sizeRight];
    
        //copia datos a los arreglos temporales
        for (int i = 0; i < sizeLeft; i++) {
            temLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            temRight[j] = arr[mid + 1 + j];
        }
    
        //fusiona los subarreglos temporales en el original
        int i = 0, j = 0;
        int k = left; //indice inicial

        while (i < sizeLeft && j < sizeRight) {
            if (temLeft[i] <= temRight[j]) {
                arr[k] = temLeft[i];
                i++;
            } else {
                arr[k] = temRight[j];
                j++;
            }
            k++;
        }
    
        //copia los elementos restantes de temLeft[] si es que hay
        while (i < sizeLeft) {
            arr[k] = temLeft[i];
            i++;
            k++;
        }
    
        //lo mismo que en lo anterior solamente que con el temRight[]
        while (j < sizeRight) {
            arr[k] = temRight[j];
            j++;
            k++;
    
        }
    }
    public static void main(String[] args) throws Exception {

        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int n = arr.length;
        System.out.println("Arreglo desordenado:");
        for (int num : arr) {
            System.out.println(num +  "");
        }

        mergeSort(arr,  0, n - 1); // //llamada al metodo del ordenamiento MergeSort

        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.println(num +  "");
        }
    }
}