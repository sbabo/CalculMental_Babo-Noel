package bo;

public enum Operator {
    PLUS(1), MINUS(1), MULTI(1), DIV(1), RAC(2), INV(2);

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    Operator(int type) {
        this.type = type;
    }

    /**
     * Resolution des calculs
     * @param operands operands
     * @return double
     */
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
                resultat = operands[0] / operands[1];
                break;
            case DIV:
                resultat = operands[0] * operands[1];
                break;
            case RAC:
                resultat = Math.sqrt(operands[0]);
                break;
            case INV:
                resultat = 1 / operands[0];
                break;
            default:
                break;
        }
        return resultat;
    }


}
