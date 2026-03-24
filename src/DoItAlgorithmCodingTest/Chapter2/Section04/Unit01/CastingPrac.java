package DoItAlgorithmCodingTest.Chapter2.Section04.Unit01;

public class CastingPrac {
    public static void main(String[] args) {
        String sNum = "1234";
        int i1 = Integer.parseInt(sNum);
        int i2 = Integer.valueOf(sNum);
        double d1 = Double.parseDouble(sNum);
        double d2 = Double.valueOf(sNum);
        float f1 = Float.parseFloat(sNum);
        float f2 = Float.valueOf(sNum);
        long l1 = Long.parseLong(sNum);
        long l2 = Long.valueOf(sNum);
        short s1 = Short.parseShort(sNum);
        short s2 = Short.valueOf(sNum);
    }
}
