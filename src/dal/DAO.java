package dal;

public class DAO {
    protected String dbUrl = "";
    protected String dbLogin = "";
    protected String dbPwd = "";

    public DAO( String dbUrl, String dbLogin, String dbPwd ) {
        this.dbUrl = dbUrl;
        this.dbLogin = dbLogin;
        this.dbPwd = dbPwd;
    }
}
