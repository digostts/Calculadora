diff --git a/Numero.java b/Numero.java
index 2b170e34bcb593206e8ccfb37f13284f185be8c3..b68f30a8499ca2ce517fb410cd92fc33b2c52fd1 100644
--- a/Numero.java
+++ b/Numero.java
@@ -1,12 +1,19 @@
 public class Numero {
-    private int valor;
-    public Numero(){
-        this.valor = 0;
+    private double valor;
+
+    public Numero() {
+        this(0.0);
     }
-    public void setValor(int valor){
+
+    public Numero(double valor) {
         this.valor = valor;
     }
-    public int getValor(){
+
+    public void setValor(double valor) {
+        this.valor = valor;
+    }
+
+    public double getValor() {
         return this.valor;
     }
 }
