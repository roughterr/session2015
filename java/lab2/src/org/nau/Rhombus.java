package org.nau;

import java.util.*;

/**
 * Ромб: координати вершин, конструктор, методи обчислення площини, периметру, виведення об'єкта.
 */
public class Rhombus {
    /**
     * Вершина A.
     */
    private Vertex a;
    /**
     * Вершина B.
     */
    private Vertex b;
    /**
     * Вершина C.
     */
    private Vertex c;
    /**
     * Вершина D.
     */
    private Vertex d;

    /**
     * Конструктор.
     * @param aX координата x вершини A
     * @param aY координата y вершини A
     * @param bX координата x вершини B
     * @param bY координата y вершини B
     * @param cX координата x вершини C
     * @param cY координата y вершини C
     * @param dX координата x вершини D
     * @param dY координата y вершини D
     */
    public Rhombus(int aX, int aY, int bX, int bY, int cX, int cY, int dX, int dY) {
        a = new Vertex(aX, aY);
        b = new Vertex(bX, bY);
        c = new Vertex(cX, cY);
        d = new Vertex(dX, dY);
    }

    /**
     * Конструктор.
     * @param vertex1 першиа вершина ромба
     * @param vertex2 друга вершина ромба
     * @param vertex3 третя вершина ромба
     * @param vertex4 четверта вершина ромба
     */
    public Rhombus(Vertex vertex1, Vertex vertex2, Vertex vertex3, Vertex vertex4) {
        this.a = vertex1;
        this.b = vertex2;
        this.c = vertex3;
        this.d = vertex4;
    }

    /**
     * Вираховує периметр ромбу.
     * @return
     */
    public double calculatePerimeter() {
        final double perimeter = distanceBetweenAandB() * 4;
        System.out.println("perimeter='" + perimeter + "'.");
        return distanceBetweenAandB() * 4;
    }

    /**
     * Метод розраховує відстань між точками А і Б.
     * @return
     */
    public double distanceBetweenAandB() {
        return calculateDistanceBetweenTwoPoints(a.getX(), a.getY(), b.getX(), b.getY());
    }

    /**
     * Розраховує площу ромба.
     * @return
     */
    public double calcuateArea() {
        final double diagonalAC = calculateDistanceBetweenTwoPoints(a.getX(), a.getY(), c.getX(), c.getY());
        final double diagonalBD = calculateDistanceBetweenTwoPoints(b.getX(), b.getY(), d.getX(), d.getY());
        return (diagonalAC * diagonalBD) / 2.0;
    }

    /**
     * Розраховує відстань між двома точками, які задані координатами.
     * @param aX
     * @param aY
     * @param bX
     * @param bY
     * @return
     */
    public static double calculateDistanceBetweenTwoPoints(int aX, int aY, int bX, int bY) {
        final int var1 = bX - aX;
        final int var2 = bY - aY;
        final double var3 = (var1 * var1) + (var2 * var2);
        return Math.sqrt(var3);
    }

    /**
     * Генерує новий ромб.
     * @return
     */
    public static Rhombus generateNewRhombus() {
        //Згенерувати дві точки
        final Random random = new Random();
        final int ax = (int) (random.nextDouble() * 10);
        final int ay = (int) (random.nextDouble() * 10);
        final int bx = ax + ((int) (random.nextDouble() * 5));
        final int by = ay + ((int) (random.nextDouble() * 5));
        final Vertex a = new Vertex(ax, ay);
        final Vertex b = new Vertex(bx, by);
        final Vertex c = new Vertex(ax + Math.abs((ax - bx)) * 2, ay);
        final Vertex d = new Vertex(bx, by - Math.abs((ay - by) * 2));
        return new Rhombus(a, b, c, d);
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("vertex1: %1$2s,\n vertex2: %2$2s,\n vertex3: %3$2s,\n vertex4: %4$2s", a, b, c, d);
        return formatter.toString();
    }

    public Vertex getVertexA() {
        return a;
    }

    public Vertex getVertexB() {
        return b;
    }

    public Vertex getVertexC() {
        return c;
    }

    public Vertex getVertexD() {
        return d;
    }

    /**
     * Метод, який генерує хеш-код об’єкту Ромб. Використовує множення для створення хеш-коду.
     * Як інший можливий варіант - метод міг би визначати хеш-код за допомогою наступних параметрів:
     * <ul>
     * <li>площа ромба</li>
     * <li>значення найменшого ікса</li>
     * <li>значення найбільшого ікса</li>
     * <li>значення найменшого ігрика</li>
     * <li>значення найбільшого ігрика</li>
     * </ul>
     * @return
     */
    @Override
    public int hashCode() {
        //List<Integer> allX = Arrays.asList(new Integer[]{a.getX(), b.getX(), c.getX(), d.getX()});
        //List<Integer> allY = Arrays.asList(new Integer[]{a.getY(), b.getY(), c.getY(), d.getY()});
        //int smallestX = Collections.min(allX);
        //int smallestY = Collections.min(allY);
        //int biggestX = Collections.max(allX);
        //int biggestY = Collections.max(allY);
        //return Arrays.hashCode(new Integer[]{smallestX, smallestY, biggestX, biggestY, (int) calcuateArea()});
        return a.getX() * a.getY() * b.getX() * b.getY() * c.getX() * c.getY() * d.getX() * d.getY();
    }
}