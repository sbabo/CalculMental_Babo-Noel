package bo;

public class Expression {

    private String binaire[] = {"+ ","- ","* ","/ "};
    private String unaire[] = {"inv ","rac "};

    public String generateCalcul(int difficulte, int fourchette){
        StringBuilder resultat = new StringBuilder();
        int base = 0;

        base += rand(fourchette);
        resultat.append(base + " ");
        for (int i=0; i < difficulte; i++) {
                int operande = 0;
                operande += rand(fourchette);
                resultat.append(operande + " ");
                resultat.append(binaire[rand(3)]);
        }
        int operandeUnaire = 0;
        operandeUnaire += rand(fourchette);
        resultat.append(operandeUnaire + " ");
        resultat.append(unaire[rand(1)]);

        return resultat.toString();
    }

    public Integer resolveCalcul(){

        return 0;
    }

    public Integer rand(int max){
        Double rand = (Math.random() * (max + 1));

        return rand.intValue();
    }
}
