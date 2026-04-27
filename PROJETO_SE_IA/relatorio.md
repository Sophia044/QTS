# Sistema de Monitoramento Ambiental com ESP32 e IA

**Disciplina:** Sistemas Embarcados  
**Data:** Abril/2026

---

## 1. Descrição do Problema

Ambientes críticos como estufas, laboratórios e data centers exigem monitoramento
contínuo de temperatura e umidade. Sistemas tradicionais baseados em thresholds
fixos apenas reagem quando o problema já ocorreu, sem qualquer capacidade preditiva
ou de classificação de risco. Isso pode resultar em danos a equipamentos, perda de
cultivos ou falhas em servidores antes que qualquer ação corretiva seja tomada.

---

## 2. Solução Proposta

Desenvolvimento de um sistema embarcado com ESP32 que integra um modelo de
Inteligência Artificial (Decision Tree) diretamente no firmware, permitindo classificar
o estado do ambiente em tempo real em três categorias:

- **NORMAL** → LED Verde aceso
- **ALERTA** → LED Amarelo aceso
- **CRÍTICO** → LED Vermelho aceso + Buzzer acionado

---

## 3. Componentes e Plataforma

| Componente | Função |
|---|---|
| ESP32 DevKit | Microcontrolador principal |
| Sensor DHT22 | Leitura de temperatura e umidade |
| LED Verde | Indicador visual — estado NORMAL |
| LED Amarelo | Indicador visual — estado ALERTA |
| LED Vermelho | Indicador visual — estado CRÍTICO |
| Buzzer | Alerta sonoro no estado CRÍTICO |
| Resistores 220Ω | Proteção dos LEDs |
| Protoboard + Jumpers | Montagem do circuito |

**Plataforma:** Arduino IDE com suporte a ESP32  
**Bibliotecas:** DHT sensor library, scikit-learn (treinamento em Python)

---

## 4. Como a IA Foi Aplicada

Foi utilizado o algoritmo **Decision Tree (Árvore de Decisão)**, um modelo de
aprendizado de máquina supervisionado. O processo ocorreu em duas etapas:

**Etapa 1 — Treinamento (Python/scikit-learn):**  
Um dataset simulado com 12 amostras rotuladas de temperatura e umidade foi
utilizado para treinar o modelo com `max_depth=3`. Após o treinamento, as regras
da árvore foram extraídas com `export_text()`.

**Etapa 2 — Embarcamento manual (C++/ESP32):**  
As regras extraídas foram implementadas diretamente como estrutura `if/else` no
firmware, eliminando a necessidade de qualquer biblioteca de ML no microcontrolador.
Essa abordagem é ideal para sistemas com recursos limitados de memória e
processamento como o ESP32.

---

## 5. Resultados Obtidos

| Temperatura | Umidade | Classificação | Atuador |
|---|---|---|---|
| 22°C | 45% | NORMAL | LED Verde |
| 30°C | 65% | ALERTA | LED Amarelo |
| 38°C | 80% | CRÍTICO | LED Vermelho + Buzzer |

O modelo atingiu acurácia de 100% no dataset de treinamento com `max_depth=3`,
sendo suficiente para o problema proposto. A resposta do sistema em tempo real
ocorre em menos de 2 segundos por ciclo de leitura.

---

## 6. Conclusão

O projeto demonstrou que é viável integrar técnicas de IA em sistemas embarcados
com recursos limitados, utilizando a estratégia de treinar o modelo externamente e
embarcar apenas suas regras no firmware. Como melhorias futuras, propõe-se:

- Envio dos dados via MQTT para monitoramento em nuvem
- Retreinamento periódico do modelo com dados reais coletados
- Expansão para outros sensores (CO₂, luminosidade, pressão)
