public class Main {

    static void Create(int[][] a, int min, int max, int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) (Math.random() * (max - min) + min);
            }
        }
    }

    static void Print(int[][] a, int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d\t|  ", a[i][j]);
            }
            System.out.println();
        }
    }

    static void Sort(int[][] a, int m, int n){
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - i - 1; j++) {
               if ((a[j][0] < a[j + 1][0]) ||
                  (a[j][0] == a[j + 1][0] && a[j][1] < a[j + 1][1]) ||
                  (a[j][0] == a[j + 1][0] && a[j][1] == a[j + 1][1] && a[j][2] > a[j + 1][2]))
               {
                   Change(a, j, j+1, n);
               }
            }
        }
    }

    static void Change(int[][] a, int n1, int n2, int n){
        int temp;
        for (int i = 0; i < n; i++) {
            temp = a[n1][i];
            a[n1][i] = a[n2][i];
            a[n2][i] = temp;
        }
    }

    static void Calc(int[][] a, int m, int n){
        int sum = 0; int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] > 0 || (i % 2 != 0 && j % 2 != 0)){
                    sum += a[i][j];
                    count++;
                    a[i][j] = 0;
                }
            }
        }
        System.out.println("Сума / кількість = " + sum + " / " + count);
    }

    public static void main(String[] args) {
        int min = -8; int max = 42;
        int m = 8; int n = 7;

        int[][] a = new int[m][n];

        Create(a, min, max, m, n);
        Print(a, m, n);
        Sort(a, m, n);
        System.out.println();
        Print(a, m, n);
        System.out.println();
        Calc(a, m, n);
        Print(a, m, n);
    }
}