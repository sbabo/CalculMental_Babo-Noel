package bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Expression {

    public String generateCalcul(int difficulte, int fourchette){
        List<String> tabOp = new ArrayList<>();
        for (Operator op : Operator.values()) {
            tabOp.add(op.toString());
        }
        StringBuilder resultat = new StringBuilder();
        int base = 0;

        base += rand(fourchette);
        resultat.append(base + " ");
        for (int i=0; i < difficulte -1 ; i++) {
                int operande = 0;
                operande += rand(fourchette);
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

    public Integer resolveCalcul(String calcul){

        int base = 0;
        int operande = 0;
        Stack stack = new Stack();
        StringTokenizer st = new StringTokenizer(calcul, " ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        return 0;
    }

    public Integer rand(int max){
        Double rand = (Math.random() * max);

        return rand.intValue();
    }

    public Integer randUnaire(int max) {
        Double rand = (Math.random() * max) + 4;

        return rand.intValue();
    }
}
