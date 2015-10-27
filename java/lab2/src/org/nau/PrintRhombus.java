package org.nau;

/**
 * Малює ромб.
 */
public class PrintRhombus {
    /**
     * Видає ромб у форматі матриці символів.
     * @return
     */
    public static boolean[][] makeRhombusMatrix(Rhombus rhombus) {
        //10 на 10
        boolean[][] matrix = new boolean[32][];
        for (int i = 0; i < 32; i++) {
            matrix[i] = new boolean[32];
            //Заповнити значенням false
            for (int j = 0; j < 32; j++) {
                matrix[i][j] = false;
            }
        }
        matrix[rhombus.getVertexA().getX() + 16][rhombus.getVertexA().getY() + 16] = true;
        matrix[rhombus.getVertexB().getX() + 16][rhombus.getVertexB().getY() + 16] = true;
        matrix[rhombus.getVertexC().getX() + 16][rhombus.getVertexC().getY() + 16] = true;
        matrix[rhombus.getVertexD().getX() + 16][rhombus.getVertexD().getY() + 16] = true;
        return matrix;
    }

    /**
     * Створює рядок, на якому зображається двохвимірний двохвимірний масив символів.
     * @param matrix boolean[][]
     * @return рядок, який можна, наприклад, виводити на екран
     */
    public static String convertTwoDimentionMatrixCharToStr(boolean[][] matrix) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < matrix.length; i++) {
            boolean[] subMatrix = matrix[i];
            for (int j = 0; j < subMatrix.length; j++) {
                sb.append(subMatrix[j] ? " * " : "   ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Генерує рядок, на якому зображений ромб.
     * @param rhombus представлення ромба
     * @return рядок, який можна виводити на екран.
     */
    public static String makeStringWithRhombusPicture(Rhombus rhombus) {
        final boolean[][] matrix = makeRhombusMatrix(rhombus);
        return convertTwoDimentionMatrixCharToStr(matrix);
    }
}
