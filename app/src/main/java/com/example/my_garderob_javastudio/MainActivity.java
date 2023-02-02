package com.example.my_garderob_javastudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // задание полей
    float Polto = 70; // пальто
    byte PoltoDiscount = 77; // скидка (в процентах)
    float ram = 23; // Шляпа
    byte ramDiscount =37;
    float room = 53; // Деловой костюм
    byte roomDiscount = 44;
    float cooler = 19; // Сорочка
    float tufla = 41; // Туфли
    byte tuflaDiscount = 32;
    float account = 312; // счёт пользователя

    // метод подсчёта стоимости делового гардероба
    private float sum() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (Polto * (100 -PoltoDiscount) + ram * (100 - ramDiscount)
                + room * (100 - roomDiscount)+ tufla * (100 - tuflaDiscount)) / 100+cooler;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки серверного комплекта
    private boolean possibility() {
        if (sum() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить серверный комплект
            return account - sum(); // то возвращается остаток от покупки
        } else { // иначе
            return sum()-account; // возвращается маркер недостатка денежных средств
        }
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut;
    private TextView balanceOut;

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);


        if (possibility()) {
            possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки делового гардероба");
            balanceOut.setText( "Для покупки не хватает:   " + balance() );
        }
    }
}