package test;

import bo.Expression;

public class TestExpression {

    //Class de test de génération d'expression
    public static void main(String args[]) {
        Expression ex = new Expression();
        String rep = ex.generateCalcul(3, 10);
        String repUser = ex.generateCalcVisuel(rep);
        System.out.println(rep);
        System.out.println(repUser);

        System.out.println(ex.resolveCalcul(rep));
    }
}
