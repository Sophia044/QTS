#include <Arduino.h>
#include <DHT.h>

// Definição dos pinos
#define DHTPIN 4
#define DHTTYPE DHT22
#define LED_VERDE 16
#define LED_AMARELO 17
#define LED_VERMELHO 18
#define BUZZER 19

DHT dht(DHTPIN, DHTTYPE);

// Decision Tree embarcada manualmente
int classifyEnvironment(float temperature, float humidity) {
  if (temperature < 25.0) {
    if (humidity < 60.0) return 0; // NORMAL
    else return 1;                 // ALERTA
  } else if (temperature < 35.0) {
    if (humidity < 70.0) return 1; // ALERTA
    else return 2;                 // CRÍTICO
  } else {
    return 2;                      // CRÍTICO
  }
}

void setup() {
  Serial.begin(115200);
  pinMode(LED_VERDE, OUTPUT);
  pinMode(LED_AMARELO, OUTPUT);
  pinMode(LED_VERMELHO, OUTPUT);
  pinMode(BUZZER, OUTPUT);
  dht.begin();
  Serial.println("Sistema de Monitoramento Iniciado");
}

void loop() {
  float temperatura = dht.readTemperature();
  float umidade = dht.readHumidity();

  if (isnan(temperatura) || isnan(umidade)) {
    Serial.println("Erro ao ler sensor DHT22!");
    delay(2000);
    return;
  }

  Serial.print("Temperatura: "); Serial.print(temperatura); Serial.println(" °C");
  Serial.print("Umidade: "); Serial.print(umidade); Serial.println(" %");

  int resultado = classifyEnvironment(temperatura, umidade);

  // Apaga todos os LEDs antes de acender o correto
  digitalWrite(LED_VERDE, LOW);
  digitalWrite(LED_AMARELO, LOW);
  digitalWrite(LED_VERMELHO, LOW);
  noTone(BUZZER);

  if (resultado == 0) {
    digitalWrite(LED_VERDE, HIGH);
    Serial.println("Status: NORMAL");
  } else if (resultado == 1) {
    digitalWrite(LED_AMARELO, HIGH);
    Serial.println("Status: ALERTA");
  } else {
    digitalWrite(LED_VERMELHO, HIGH);
    tone(BUZZER, 1000);
    delay(500);
    noTone(BUZZER);
    Serial.println("Status: CRÍTICO");
  }

  delay(2000);
}
