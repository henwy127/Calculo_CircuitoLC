# Cálculo de Circuito LC

Este repositório contém a resolução de um exercício de Física/Eletricidade sobre um circuito **LC oscilante**, implementado em **Java**.

## Enunciado do exercício

Em um circuito LC oscilante:
- L = 3,00 mH
- C = 2,70 µF

No instante t = 0, a carga do capacitor é zero e a corrente é i(0) = 2,00 A.

Pede-se:
1. Qual é a carga máxima do capacitor?
2. Em que instante t > 0 a taxa com que a energia é armazenada no capacitor é máxima pela primeira vez?
3. Qual é o valor dessa taxa máxima?

---

## Modelo físico utilizado

Para um circuito LC ideal (sem resistência), a energia total se conserva:

U = q²/(2C) + Li²/2

A frequência angular natural é:

ω = 1/√(LC)

Com as condições iniciais q(0)=0 e i(0)=I0:

q(t) = Qmáx·sen(ωt)  
i(t) = I0·cos(ωt)

e:

Qmáx = I0/ω = I0·√(LC)

Energia no capacitor:

Uc(t) = q²(t)/(2C)

Taxa de armazenamento de energia no capacitor:

dUc/dt = (q/C)·(dq/dt) = (q·i)/C

Substituindo as expressões:

dUc/dt = (Qmáx·I0/C)·sen(ωt)·cos(ωt)  
dUc/dt = (Qmáx·I0/(2C))·sen(2ωt)

---

## Cálculos principais

### Dados em SI
- L = 3,00 × 10⁻³ H
- C = 2,70 × 10⁻⁶ F
- I0 = 2,00 A

### 1) Carga máxima no capacitor

Qmáx = I0·√(LC)

Qmáx = 2,00·√[(3,00×10⁻³)(2,70×10⁻⁶)]  
Qmáx ≈ 1,80×10⁻⁴ C

**Resultado:**  
Qmáx ≈ 1,80×10⁻⁴ C = 180 µC

### 2) Primeiro instante t > 0 de taxa máxima de armazenamento

A taxa é máxima quando sen(2ωt)=1, então:

2ωt = π/2  =>  t = π/(4ω)

Como:

ω = 1/√(LC) ≈ 1,11×10⁴ rad/s

t ≈ π / [4·(1,11×10⁴)]  
t ≈ 7,07×10⁻⁵ s

**Resultado:**  
t ≈ 7,07×10⁻⁵ s = 70,7 µs

### 3) Valor da taxa máxima

(dUc/dt)máx = (Qmáx·I0)/(2C)

(dUc/dt)máx ≈ [(1,80×10⁻⁴)·2,00] / [2·(2,70×10⁻⁶)]  
(dUc/dt)máx ≈ 66,7 W

**Resultado:**  
Taxa máxima ≈ 66,7 W

---

## Implementação em Java

O programa em Java:
- Define os valores de L, C e I0
- Converte unidades para SI
- Calcula ω, Qmáx, t do primeiro máximo e (dUc/dt)máx
- Exibe os resultados formatados no terminal

---

## Bibliotecas utilizadas

A solução usa apenas bibliotecas padrão da JDK:

- `java.lang.Math`
  - `Math.sqrt(...)`
  - `Math.PI`
  - (opcional) `Math.sin(...)` e `Math.cos(...)` para validação
- `System.out.printf(...)` para saída formatada

**Não há dependências externas** (Maven/Gradle) para os cálculos principais.

---

## Como executar

Compile e rode com Java (JDK 8+):

```bash
javac Main.java
java Main
```

> Se o nome do arquivo principal for diferente, substitua `Main.java` pelo nome correto do seu arquivo.

---

## Resumo dos resultados

- Carga máxima: 1,80×10⁻⁴ C (180 µC)
- Primeiro instante de taxa máxima: 7,07×10⁻⁵ s (70,7 µs)
- Taxa máxima de armazenamento de energia: 66,7 W
