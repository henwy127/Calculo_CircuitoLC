# Cálculo de Circuito LC

Este repositório contém a resolução de um exercício de Física/Eletricidade sobre um circuito **LC oscilante**, implementado em **Java**.

## 📘 Enunciado do exercício

Em um circuito LC oscilante,  
- \( L = 3{,}00 \text{ mH} \)  
- \( C = 2{,}70 \text{ µF} \)

No instante \( t = 0 \), a carga do capacitor é zero e a corrente é \( i(0) = 2{,}00 \text{ A} \).

Pede-se:

1. Qual é a carga máxima do capacitor?
2. Em que instante \( t > 0 \) a taxa com que a energia é armazenada no capacitor é máxima pela primeira vez?
3. Qual é o valor dessa taxa máxima?

---

## ⚙️ Modelo físico utilizado

Para um circuito LC ideal (sem resistência), a energia total se conserva:

\[
U = \frac{q^2}{2C} + \frac{Li^2}{2}
\]

A frequência angular natural é:

\[
\omega = \frac{1}{\sqrt{LC}}
\]

Com a condição inicial \( q(0)=0 \) e \( i(0)=I_0 \), temos:

\[
q(t)=Q_{\max}\sin(\omega t), \quad i(t)=I_0\cos(\omega t)
\]

e

\[
Q_{\max}=\frac{I_0}{\omega}=I_0\sqrt{LC}
\]

A energia no capacitor:

\[
U_C(t)=\frac{q^2(t)}{2C}
\]

A taxa de armazenamento de energia no capacitor é:

\[
\frac{dU_C}{dt} = \frac{q}{C}\frac{dq}{dt} = \frac{q\,i}{C}
\]

Substituindo as expressões senoidal/cossenoidal:

\[
\frac{dU_C}{dt} = \frac{Q_{\max}I_0}{C}\sin(\omega t)\cos(\omega t)
= \frac{Q_{\max}I_0}{2C}\sin(2\omega t)
\]

---

## 🧮 Cálculos principais

### Dados em SI
- \( L = 3{,}00 \times 10^{-3}\ \text{H} \)
- \( C = 2{,}70 \times 10^{-6}\ \text{F} \)
- \( I_0 = 2{,}00\ \text{A} \)

### 1) Carga máxima no capacitor
\[
Q_{\max} = I_0\sqrt{LC}
\]
\[
Q_{\max} = 2{,}00\sqrt{(3{,}00\times10^{-3})(2{,}70\times10^{-6})}
\approx 1{,}80\times10^{-4}\ \text{C}
\]

✅ **Resultado:**  
\[
Q_{\max} \approx 1{,}80\times10^{-4}\ \text{C} = 180\ \mu\text{C}
\]

### 2) Primeiro instante \( t>0 \) de taxa máxima de armazenamento
A taxa é máxima quando \(\sin(2\omega t)=1\), ou seja:
\[
2\omega t = \frac{\pi}{2}
\Rightarrow t=\frac{\pi}{4\omega}
\]

Como
\[
\omega=\frac{1}{\sqrt{LC}} \approx 1{,}11\times10^4\ \text{rad/s}
\]

\[
t \approx \frac{\pi}{4(1{,}11\times10^4)} \approx 7{,}07\times10^{-5}\ \text{s}
\]

✅ **Resultado:**  
\[
t \approx 7{,}07\times10^{-5}\ \text{s} = 70{,}7\ \mu\text{s}
\]

### 3) Valor da taxa máxima
\[
\left(\frac{dU_C}{dt}\right)_{\max}=\frac{Q_{\max}I_0}{2C}
\]

\[
\left(\frac{dU_C}{dt}\right)_{\max}
\approx \frac{(1{,}80\times10^{-4})(2{,}00)}{2(2{,}70\times10^{-6})}
\approx 66{,}7\ \text{W}
\]

✅ **Resultado:**  
\[
\left(\frac{dU_C}{dt}\right)_{\max} \approx 66{,}7\ \text{W}
\]

---

## 💻 Implementação em Java

O programa em Java:
- Define os valores de \(L\), \(C\) e \(I_0\)
- Converte unidades para SI
- Calcula \(\omega\), \(Q_{\max}\), \(t\) do primeiro máximo e \(\left(dU_C/dt\right)_{\max}\)
- Exibe os resultados formatados no terminal

---

## 📚 Bibliotecas utilizadas

Como o projeto está 100% em Java, a solução usa apenas bibliotecas padrão da JDK:

- `java.lang.Math`
  - `Math.sqrt(...)`
  - `Math.PI`
  - (opcionalmente `Math.sin(...)`/`Math.cos(...)` para validação)
- `System.out.printf(...)` para saída formatada

✅ **Não há dependências externas** (Maven/Gradle) para os cálculos principais.

---

## ▶️ Como executar

Compile e rode com Java (JDK 8+):

```bash
javac Main.java
java Main
```

> Ajuste o nome do arquivo/classe principal conforme a estrutura do repositório.

---

## ✅ Resumo dos resultados

- **Carga máxima:** \(Q_{\max} \approx 1{,}80\times10^{-4}\ \text{C}\) (**180 µC**)
- **Primeiro instante de taxa máxima:** \(t \approx 7{,}07\times10^{-5}\ \text{s}\) (**70,7 µs**)
- **Taxa máxima de armazenamento de energia:** \(\approx 66{,}7\ \text{W}\)

---
