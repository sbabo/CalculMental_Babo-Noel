package bo;

public enum Operator {
    PLUS, MINUS, MULTI, DIV, RAC, INV;


    public double eval(double... operands){
        double resultat = 0;
        switch (this) {
            case PLUS:
                resultat = operands[0] + operands[1];
                break;
            case MINUS:
                resultat = operands[0] - operands[1];
                break;
            case MULTI:
                resultat = operands[0] * operands[1];
                break;
            case DIV:
                resultat = operands[0] / operands[1];
                break;
            case RAC:

                break;
            case INV:

                break;
            default:
                break;
        }
        return resultat;
    }


}
