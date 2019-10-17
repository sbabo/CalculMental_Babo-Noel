package test;

import bo.Expression;

public class TestExpression {

    public static void main(String args[]) {
        Expression ex = new Expression();
        String rep = ex.generateCalcul(3, 10);
        System.out.println(rep);

        System.out.println(ex.resolveCalcul(rep));
    }
}
