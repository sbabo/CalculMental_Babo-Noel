package bo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Expression {

    /**
     * Génération d'un calcul avec un niveau de difficulté et une amplitude de valeur
     * @param difficulte difficulté de la partie
     * @param fourchette fourchette des valeurs possibles
     * @return Une Question
     */
    public String generateCalcul(int difficulte, int fourchette){
        List<String> tabOp = new ArrayList<>();
        // Récupération des opérateurs possibles
        for (Operator op : Operator.values()) {
            tabOp.add(op.toString());
        }
        StringBuilder resultat = new StringBuilder();
        int base = 0;
        // Generation du calcul
        base += rand(fourchette) + 1;
        resultat.append(base + " ");
        for (int i=0; i < difficulte -1 ; i++) {
                int operande = 0;
                operande += rand(fourchette) + 1;
                resultat.append(operande + " ");
                resultat.append(tabOp.get(rand(4)) + " ");
        }
        int operandeUnaire = 0;
        operandeUnaire += rand(fourchette);
        resultat.append(operandeUnaire + " ");

        resultat.append(tabOp.get(rand(4)) + " ");
        resultat.append(tabOp.get(randUnaire(2)) + " ");

        return resultat.toString();
    }

    /**
     * résolution du calcul générer par generateCalcul
     * @param calcul calcul de generateCalcul
     * @return résolution du calcul
     */
    public String resolveCalcul(String calcul){
        //Découpage de la String
        Double resultat = 0d;
        Stack<Double> stack = new Stack();
        StringTokenizer st = new StringTokenizer(calcul, " ");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            try {
                Operator op = Operator.valueOf(token);
                // Si l'opérateur est +, -, *, /
                if ( op.getType() == 1 ) {
                    Double op1 = 0d;
                    Double op2 = 0d;
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op.eval(op1, op2));
                } else { // Si l'opérateur est une racine carrée ou Inverse
                    Double op1 = 0d;
                    op1 = stack.pop();
                    stack.push(op.eval(op1));
                }
            } catch (Exception e ) { // Si le String n'est pas un opérateur, c'est un nombre et on le stack
                stack.push(Double.parseDouble(token));
            }
        }
        resultat = stack.pop();
        // Formattage de la réponse pour éviter plus de 2 chiffres après la virgule
        DecimalFormat df = new DecimalFormat("0.00");
        String resultFormat = df.format(resultat);
        return resultFormat;
    }

    /**
     * Génération d'une question compréhensible par le joueur
     * @param valeur question de generateCalcul
     * @return une Question compréhensible par le joueur
     */
    public String generateCalcVisuel (String valeur) {
        //Decoupage de la question
        StringBuilder resultat = new StringBuilder();
        Stack<String> stack = new Stack();
        StringTokenizer st = new StringTokenizer(valeur, " ");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            try {
                Operator op = Operator.valueOf(token);
                // Si l'opérateur est +, -, *, /
                if ( op.getType() == 1 ) {
                    String op1 = "";
                    String op2 = "";
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push("(" + op1 +  " " + op + " " + op2 +")");
                } else { // Si l'opérateur est une racine carrée ou Inverse
                    String op1 = "";
                    op1 = stack.pop();
                    stack.push(op1 + " " + op + ")");
                }
            } catch (Exception e ) { // Si le String n'est pas un opérateur, c'est un nombre et on le stack
                stack.push(token);
            }
        }
        resultat.append(stack.pop());
        return resultat.toString();
    }

    /**
     * Génération d'un chiffre aléatoire
     * @param max range max de la génération
     * @return Int
     */
    public Integer rand(int max){
        Double rand = (Math.random() * max);

        return rand.intValue();
    }

    /**
     * Générateur pour choix RAC ou INV
     * @param max range max pour la génération
     * @return Int
     */
    public Integer randUnaire(int max) {
        Double rand = (Math.random() * max) + 4;

        return rand.intValue();
    }
}
