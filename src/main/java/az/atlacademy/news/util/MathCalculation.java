package az.atlacademy.news.util;

public class MathCalculation {
    public int calc(int a, int b, char  opr) {
        if (opr=='+') {
            return a + b;
        } else if(opr=='-') {
            return a - b;
        }else if(opr=='*'){
            return a*b;
        }else{
            try {
                return a / b;
            }catch(ArithmeticException e){
                return 0;
            }
        }

    }

    public double minus(double a, double c) {
        return a - c;
    }

    public String convert(double number) {
        return String.valueOf(number);
    }
}
