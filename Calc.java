diff --git a/Calc.java b/Calc.java
index 75bab2a31eade0775fed1ea72ce660b4404d202d..fa3fed9bf0d8362d114492bbfffed4d955256401 100644
--- a/Calc.java
+++ b/Calc.java
@@ -1,39 +1,107 @@
+import java.util.Locale;
 import java.util.Scanner;
+
 public class Calc {
-    static public void  main(String[] args) {
-     
-    Scanner scan=new Scanner(System.in);
+    public static void main(String[] args) {
+        Locale.setDefault(Locale.US);
+
+        Scanner scanner = new Scanner(System.in);
+        System.out.println("=== Calculadora Java Moderna ===");
 
-    Numero n1 = new Numero();
-    Numero n2 = new Numero();
-    Numero res = new Numero();
-    String opc = "S";
+        boolean continuar = true;
+        while (continuar) {
+            exibirMenu();
+            String operacao = scanner.nextLine().trim();
 
-    while(opc.equals("s") || opc.equals("S")){
-    
+            if (operacao.equals("0")) {
+                continuar = false;
+                continue;
+            }
 
+            if (!operacaoValida(operacao)) {
+                System.out.println("Operação inválida. Tente novamente.\n");
+                continue;
+            }
 
-        System.out.printf("%nDigite o valor 1: ");
-        n1.setValor(scan.nextInt());
-    
-        System.out.printf("%nDigite o valor 2: ");
-        n2.setValor(scan.nextInt());
-    
-        res.setValor(n1.getValor() + n2.getValor());
-        System.out.printf("%nA soma de %d com %d e igual a %d", n1.getValor(), n2.getValor(), res.getValor());
+            Numero n1 = new Numero(lerNumero(scanner, "Digite o valor 1: "));
+            Numero n2 = new Numero(lerNumero(scanner, "Digite o valor 2: "));
 
-        System.out.printf("%n%nDeseja somar outro valor?");
-        opc = scan.next();
-        System.out.printf("%n%n%n");
+            try {
+                double resultado = calcular(n1.getValor(), n2.getValor(), operacao);
+                System.out.printf(Locale.US, "Resultado: %.2f %s %.2f = %.2f%n%n",
+                        n1.getValor(), simbolo(operacao), n2.getValor(), resultado);
+            } catch (ArithmeticException ex) {
+                System.out.println("Erro: " + ex.getMessage() + "\n");
+            }
+        }
 
+        System.out.println("Calculadora encerrada. Até mais!");
+        scanner.close();
+    }
 
-    
+    private static void exibirMenu() {
+        System.out.println("Escolha a operação:");
+        System.out.println("1) Soma (+)");
+        System.out.println("2) Subtração (-)");
+        System.out.println("3) Multiplicação (*)");
+        System.out.println("4) Divisão (/)");
+        System.out.println("5) Potência (^)");
+        System.out.println("0) Sair");
+        System.out.print("Opção: ");
     }
 
-    
+    private static boolean operacaoValida(String operacao) {
+        return operacao.equals("1") || operacao.equals("2") || operacao.equals("3")
+                || operacao.equals("4") || operacao.equals("5");
+    }
 
+    private static String simbolo(String operacao) {
+        switch (operacao) {
+            case "1":
+                return "+";
+            case "2":
+                return "-";
+            case "3":
+                return "*";
+            case "4":
+                return "/";
+            case "5":
+                return "^";
+            default:
+                return "?";
+        }
     }
 
-    
+    private static double lerNumero(Scanner scanner, String mensagem) {
+        while (true) {
+            System.out.print(mensagem);
+            String entrada = scanner.nextLine().trim().replace(',', '.');
 
+            try {
+                return Double.parseDouble(entrada);
+            } catch (NumberFormatException e) {
+                System.out.println("Valor inválido. Digite um número válido.");
+            }
+        }
+    }
+
+    private static double calcular(double a, double b, String operacao) {
+        switch (operacao) {
+            case "1":
+                return a + b;
+            case "2":
+                return a - b;
+            case "3":
+                return a * b;
+            case "4":
+                if (b == 0.0) {
+                    throw new ArithmeticException("Divisão por zero não é permitida.");
+                }
+                return a / b;
+            case "5":
+                return Math.pow(a, b);
+            default:
+                throw new IllegalArgumentException("Operação não suportada.");
+        }
+    }
 }
