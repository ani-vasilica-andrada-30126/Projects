#include <Wire.h>

#include <LiquidCrystal_I2C.h> 


LiquidCrystal_I2C lcd(0x27, 16, 2); 
#define t1  20

const int trig = 2;

const int echo = 3; 
int buzzer =13;

int duration = 0;

int distance = 0;


int i;

void setup()

{
  

  //ultrasonic sensor

  pinMode(trig , OUTPUT); // sets the digital pin TRIG as OUTPUT
  

  pinMode(echo , INPUT); // sets the digital pin ECHO as INPUT

  //LEDS

  for (i = 4; i <= 12; i++) {

    pinMode(i, OUTPUT);  // setam LED urile ca si IESIRI

  }
  //lcd: o variabilă de tip LiquidCrystal

  //LCD display

  lcd.begin(); 

  lcd.backlight(); 

  Serial.begin(9600);  
}

void loop()

{
 

 
  
  digitalWrite(trig , HIGH); // sets the digital pin trig ON(high)

  delayMicroseconds(1000);

  digitalWrite(trig , LOW); // sets the digital pin trig OFF(low)

  duration = pulseIn(echo , HIGH);  

  distance = (duration / 2) / 29.1 ;
  

  Serial.println(distance); 
  lcd.clear(); //clear lcd screen

  lcd.setCursor(0,0); 

  lcd.print("Distance: "); 

  lcd.print(distance);

  lcd.print("CM"); 

  delay(500);

  if (distance >= 24) {
    lcd.setCursor(0,1);
    lcd.print("Distance is >=24");
    delay(100);
     tone(buzzer,900);
  effect_1();

  }
  else{
    //clear_led();
    lcd.setCursor(0,1);
    lcd.print("Distance is < 24");
    //clear_led();
    delay(100);
  }

   if (distance <=3) {     

    lcd.setCursor(0,1);
    lcd.print("Distance is < 3");
    tone(buzzer,400);

  }else{
    noTone(buzzer);
  }

  if (distance >= 7) {     

    digitalWrite(12, HIGH);
    digitalWrite(4, LOW);
    digitalWrite(5, LOW);
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
    digitalWrite(8, LOW);
    digitalWrite(9, LOW);
    digitalWrite(10, LOW);
    digitalWrite(11, LOW);

  }else{

  digitalWrite(12, LOW);

  }

  if (distance >= 10) {

    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
    digitalWrite(4, LOW);
    digitalWrite(5, LOW);
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
    digitalWrite(8, LOW);
    digitalWrite(9, LOW);
    digitalWrite(10, LOW);
    

  }else{

  digitalWrite(11, LOW);

  }

  if (distance >= 12) {

    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
     digitalWrite(4, LOW);
    digitalWrite(5, LOW);
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
    digitalWrite(8, LOW);
    digitalWrite(9, LOW);

  }else{

  digitalWrite(10, LOW);

  }

  if (distance >= 14) {

    digitalWrite(9, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
     digitalWrite(4, LOW);
     digitalWrite(5, LOW);
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
    digitalWrite(8, LOW);


  }else{

  digitalWrite(9, LOW);

  }

  if (distance >= 16) {

    digitalWrite(8, HIGH);
    digitalWrite(9, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
     digitalWrite(4, LOW);
    digitalWrite(5, LOW);
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);

  }else{

  digitalWrite(8, LOW);

  }

  if (distance >= 18) {

    digitalWrite(7, HIGH);
    digitalWrite(8, HIGH);
    digitalWrite(9, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
     digitalWrite(4, LOW);
    digitalWrite(5, LOW);
    digitalWrite(6, LOW);

  }else{

  digitalWrite(7, LOW);

  }

  if (distance >= 20) {

    digitalWrite(6, HIGH);
     digitalWrite(7, HIGH);
    digitalWrite(8, HIGH);
    digitalWrite(9, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
     digitalWrite(4, LOW);
    digitalWrite(5, LOW);


  }else{

  digitalWrite(6, LOW);

  }

  if (distance >= 22) {

    digitalWrite(5, HIGH);
    digitalWrite(6, HIGH);
     digitalWrite(7, HIGH);
    digitalWrite(8, HIGH);
    digitalWrite(9, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);
     digitalWrite(4, LOW);

  }else{

  digitalWrite(5, LOW);

  }

  if (distance >= 24) {

    digitalWrite(4, HIGH);
    digitalWrite(5, HIGH);
    digitalWrite(6, HIGH);
     digitalWrite(7, HIGH);
    digitalWrite(8, HIGH);
    digitalWrite(9, HIGH);
    digitalWrite(10, HIGH);
    digitalWrite(11, HIGH);
    digitalWrite(12, HIGH);

  }else{

  digitalWrite(4, LOW);

  }

}

void effect_1()
{
  for (int i = 4; i <= 12; i++) {
    digitalWrite(i, HIGH);
    delay(t1);
    digitalWrite(i + 1, HIGH);
    delay(t1);
    digitalWrite(i + 2, HIGH);
    delay(t1);
    digitalWrite(i, LOW);
    delay(t1);
    digitalWrite(i + 1, LOW);
    delay(t1);
  }
  for (int i = 12; i >= 4; i--) {
    digitalWrite(i, HIGH);
    delay(t1);
    digitalWrite(i - 1, HIGH);
    delay(t1);
    digitalWrite(i - 2, HIGH);
    delay(t1);
    digitalWrite(i, LOW);
    delay(t1);
    digitalWrite(i - 1, LOW);
    delay(t1);
  }
}
// function to switch all LEDs off
/*void clear_led()
{
  for (int i = 4; i <= 12; i++) {
    digitalWrite(i, LOW);
  }
}*/
