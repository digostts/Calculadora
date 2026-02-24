diff --git a/README.md b/README.md
index 0267e6d718931cc5a823c5c8f72234acd86f1a84..9d89e0367367d00588ff5a664801e22066307ffd 100644
--- a/README.md
+++ b/README.md
@@ -1,5 +1,32 @@
-# Calculadora
+# Calculadora (Java)
 
-Codigo de calculadora desenvolvido em linguagem Java
+Calculadora de linha de comando em Java, com interface simples e validação de entrada.
 
-Versão 1.0
+## Funcionalidades
+
+- Soma
+- Subtração
+- Multiplicação
+- Divisão (com tratamento para divisão por zero)
+- Potência
+
+## Como executar
+
+### Opção rápida (executável)
+
+```bash
+./calculadora
+```
+
+> O script compila automaticamente os arquivos Java e inicia o programa.
+
+### Opção manual
+
+```bash
+javac -d bin Calc.java Numero.java
+java -cp bin Calc
+```
+
+## Requisitos
+
+- Java 8+
