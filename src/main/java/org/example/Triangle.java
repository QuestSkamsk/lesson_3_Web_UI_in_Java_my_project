package org.example;

public class Triangle {

        private int a;
        private int b;
        private int c;
        private double p;

        public Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public void setA(int a) {this.a = a;}
        public void setB(int b) {this.b = b;}
        public void setC(int c) {this.c = c;}
        public Triangle() {}

        public double triangleArea() {
            if (a == 0 || b == 0 || c == 0) {
                throw new ArithmeticException("Одна из сторон равна нулю!");
            } else if (a < 0 || b < 0 || c < 0) {
                throw new ArithmeticException("Одна из сторон имеет отрицательное значение!");
            }
            p = 0.5 * (a + b + c);
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        public void info() {
            System.out.println("Площадь треугольника = " + triangleArea());
        }

        public static void main(String[] args) {
            Triangle triangle = new Triangle();
            System.out.println(triangle.triangleArea());

        }
    }