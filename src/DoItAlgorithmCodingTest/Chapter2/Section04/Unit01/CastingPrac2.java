package DoItAlgorithmCodingTest.Chapter2.Section04.Unit01;

public class CastingPrac2 {
    public static void main(String[] args) {
        int i = 1234;
        String i1 = String.valueOf(i);
        String i2 = Integer.toString(i);
        double d = 1.23;
        String d1 = String.valueOf(d);
        String d2 = Double.toString(d);
        float f = (float) 1.23;
        String f1 = String.valueOf(f);
        String f2 = Float.toString(f);
        long l = 1234;
        String l1 = String.valueOf(l);
        String l2 = Long.toString(l);
        short s = 1234;
        String s1 = String.valueOf(s);
        String s2 = Short.toString(s);
    }
}
