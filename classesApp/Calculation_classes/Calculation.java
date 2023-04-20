// Name: Omar Waleed Zenhom               ID: 20206130
// Name: Muhammed Aladdin Muhammed        ID: 20206068
// Mohamed Ahmed Galal                    ID: 20206060

package Calculation_classes;

import javax.persistence.*;

@Entity
@Table(name = "calculation")
public class Calculation {

    private int number1;
    private int number2;
    private String operation;

    public Calculation() {}

    public Calculation(int number1, int number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    // toString method
    @Override
    public String toString() {
        return "Calculation{" +
                ", number1=" + number1 +
                ", number2=" + number2 +
                ", operation='" + operation + '\'' +
                '}';
    }
}