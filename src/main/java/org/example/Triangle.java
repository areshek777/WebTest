package org.example;

public class Triangle {

    public int square (int a, int b, int c) throws SquareException {
        if(a <= 0 || b <= 0 || c <= 0 || a+b < c || a+c < b || c+b < a) throw new SquareException("Это не треугольник");
        int p = (a+b+c)/2;
        int S = (int) Math.sqrt(p*(p-a)*(p-b)*(p-c));
       return S;
    }
}
