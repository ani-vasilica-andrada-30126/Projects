#include <DHT.h>
#include <Wire.h>
#include <DHT_U.h>
#include <SimpleDHT.h>
#include <LiquidCrystal_I2C.h>

#define DHTPIN 2
#define DHTTYPE DHT11
#define moistureSensorPin A1

DHT dht(DHTPIN, DHTTYPE);
SimpleDHT11 simpleDHT11(DHTPIN);

LiquidCrystal_I2C lcd(0x27, 16, 2);

// Timer
unsigned long timer = 0;
const unsigned long interval = 6000; // Interval de 6 secunde pentru irigare

// Ultrasonic Sensor
int Trig = 8;
int Echo = 9;
int Duration;
float Distance;

// LED
int buzzerPin = 5;
int led = 6;

// Moisture sensor
int water_count = 0;

// Relay
int relay = 13;
bool pumpOn = false;


enum State {
  STATE_INITIAL,
  STATE_DISPLAY_DATA,
  STATE_DISPLAY_ULTRASONIC,
  STATE_ALERT_LOW_WATER_LEVEL,
  STATE_IRRIGATION,
  STATE_CHECK_MOISTURE,
  STATE_FINAL
};

State currentState = STATE_INITIAL;

void setup() {
  Serial.begin(9600);
  dht.begin();
  lcd.init();
  lcd.clear();
  lcd.backlight();
  lcd.setCursor(0, 0);
  lcd.print("Wait a minute...");
  pinMode(Trig, OUTPUT);
  pinMode(Echo, INPUT);
  pinMode(buzzerPin, OUTPUT);
  pinMode(led, OUTPUT);
  pinMode(relay, OUTPUT);
  digitalWrite(relay, HIGH);
}

void loop() {
  switch (currentState) {
    case STATE_INITIAL:
      checkDHT11();
      currentState = STATE_DISPLAY_DATA;
      Serial.print("Current State: ");
      Serial.println(currentState);
      break;

    case STATE_DISPLAY_DATA:
      checkWater();
      currentState = STATE_DISPLAY_ULTRASONIC;
       Serial.print("Current State: ");
      Serial.println(currentState);
      break;

    case STATE_DISPLAY_ULTRASONIC:
      checkWater();
      currentState = STATE_CHECK_MOISTURE;
       Serial.print("Current State: ");
      Serial.println(currentState);
      break;

    case STATE_ALERT_LOW_WATER_LEVEL:
      digitalWrite(led, HIGH);
      currentState = STATE_FINAL;
       Serial.print("Current State: ");
      Serial.println(currentState);
      break;

    case STATE_IRRIGATION:
      watering();
      currentState = STATE_CHECK_MOISTURE;
       Serial.print("Current State: ");
      Serial.println(currentState);
      break;

    case STATE_CHECK_MOISTURE:
      checkMoisture();
      currentState = STATE_FINAL;
       Serial.print("Current State: ");
      Serial.println(currentState);
      break;

    case STATE_FINAL:
      completeWatering();
      currentState = STATE_INITIAL;
       Serial.print("Current State: ");
      Serial.println(currentState);
      break;
  }
}

void checkDHT11() {
  Serial.println("=========================");
  Serial.println("Sample DHT11...");

  byte temperature = 0;
  byte humidity = 0;
  byte data[40] = { 0 };
  int err = SimpleDHTErrSuccess;

  if ((err = simpleDHT11.read(&temperature, &humidity, NULL)) != SimpleDHTErrSuccess) {
    Serial.print("Read DHT11 failed err=");
    Serial.println(err);
    lcd.setCursor(0, 0);
    lcd.print("Error reading sensor");
    lcd.setCursor(0, 1);
    lcd.print("Try again");
    delay(1000);
    return;
  }

  lcd.setCursor(0, 0);
  lcd.print("Temp: ");
  lcd.print((int)temperature);
  lcd.print(" C");
  lcd.setCursor(0, 1);
   lcd.print("Humidity: ");
  lcd.print((int)humidity);
  lcd.print(" %");
  delay(1000);
}

void checkMoisture() {
  int moisture = analogRead(moistureSensorPin);
  Serial.print("Moisture: ");
  Serial.println(moisture);
  lcd.setCursor(0, 1);
  lcd.print("Moisture: " + String(moisture) + "   ");

  if (moisture >= 500) {
    water_count++;
    watering();

    if (water_count == 5) {
      water_count = 0;
    }
  } else {
    stopPump();
  }
}

void checkWater() {
  digitalWrite(Trig, LOW);
  delayMicroseconds(1);
  digitalWrite(Trig, HIGH);
  delayMicroseconds(11);
  digitalWrite(Trig, LOW);
  Duration = pulseIn(Echo, HIGH);

  if (Duration > 0) {
    Distance = Duration / 2;
    Distance = Distance * 340 * 100 / 1000000;
    delay(2000);
    lcd.setCursor(0, 0);
    lcd.print("Distance: " + String(Distance) + "cm   ");
    Serial.println(Distance);

    int moisture = analogRead(moistureSensorPin);
    Serial.print("Moisture: ");
    Serial.println(moisture);
    lcd.setCursor(0, 1);
    lcd.print("Moisture: " + String(moisture) + "   ");

    if (Distance > 9) {
      digitalWrite(led, HIGH);
      currentState = STATE_ALERT_LOW_WATER_LEVEL;
        tone(buzzerPin, 500);; // Activez buzzer
        delay(1500);
        digitalWrite(buzzerPin, LOW); // Dezactivez buzzerul
    } else {
      digitalWrite(led, LOW);
      noTone(buzzerPin);
      delay(1500);

      if (currentState != STATE_IRRIGATION) {
        currentState = STATE_CHECK_MOISTURE;
      }
    }
  }
}

void watering() {
  startPump();
  delay(3000);
  stopPump();
  delay(10000);
}

void completeWatering() {
  lcd.setCursor(0, 0);
  lcd.print("   Thank you!   ");
  lcd.setCursor(0, 1);
  lcd.print("   Done!    ");
  delay(5000);
  lcd.setCursor(0, 0);
  lcd.print("                ");
  lcd.setCursor(0, 1);
  lcd.print("                ");
  checkDHT11();
  int moisture = analogRead(A1);
  lcd.setCursor(0, 1);
  lcd.print("Moisture: " + String(moisture) + "   ");
}

void startPump() {
  if (!pumpOn) {
    digitalWrite(relay, LOW);
    pumpOn = true;
  }
}

void stopPump() {
  if (pumpOn) {
    digitalWrite(relay, HIGH);
    pumpOn = false;
  }
}
