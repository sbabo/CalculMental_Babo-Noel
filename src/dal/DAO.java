package dal;

public abstract class DAO<E> implements IDAO<E> {
    protected String dbUrl = "";
    protected String dbLogin = "";
    protected String dbPwd = "";

    public DAO( String dbUrl, String dbLogin, String dbPwd ) {
        this.dbUrl = dbUrl;
        this.dbLogin = dbLogin;
        this.dbPwd = dbPwd;
    }
}
