package tables;

import db.IDBConnect;
import db.MySQLConnect;

import java.sql.ResultSet;
import java.util.List;

public abstract class AbsTable implements ITable{
    protected IDBConnect dbConnector = null;
    private String tableName = "";

    public AbsTable (String tableName){
        dbConnector = new MySQLConnect();
        this.tableName = tableName;
    }
    @Override
    public void create(List<String> columns){
        delete();
        dbConnector.execute(String.format("CREATE TABLE %s (%s)",tableName,String.join(",",columns)));
    }
    @Override
    public void delete () {
        dbConnector.execute(String.format("DROP TABLE if exists %s ;", this.tableName));

    }
    public ResultSet selectAll(){
        return dbConnector.executeQuery(String.format("SELECT * FROM %s ;",this.tableName));

    }

}
