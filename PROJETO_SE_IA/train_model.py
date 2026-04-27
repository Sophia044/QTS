import numpy as np
import pandas as pd
from sklearn.tree import DecisionTreeClassifier, export_text

# Dataset simulado
data = {
    "temperatura": [20, 22, 23, 24, 26, 28, 30, 32, 35, 37, 40, 42],
    "umidade":     [40, 45, 50, 55, 58, 62, 65, 68, 72, 78, 85, 90],
    "classe":      [ 0,  0,  0,  0,  1,  1,  1,  1,  2,  2,  2,  2]
}

df = pd.DataFrame(data)

X = df[["temperatura", "umidade"]]
y = df["classe"]

# Treinamento da Decision Tree
modelo = DecisionTreeClassifier(max_depth=3)
modelo.fit(X, y)

# Exibe a árvore em formato texto
print("=== Árvore de Decisão Treinada ===")
print(export_text(modelo, feature_names=["temperatura", "umidade"]))

# Testes de predição
labels = {0: "NORMAL", 1: "ALERTA", 2: "CRÍTICO"}
testes = [[22, 45], [30, 65], [38, 80]]

print("=== Testes de Predição ===")
for t in testes:
    pred = modelo.predict([t])[0]
    print(f"Temp: {t[0]}°C | Umidade: {t[1]}% → {labels[pred]}")
