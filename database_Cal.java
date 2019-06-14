package Calendar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class database_Cal {

    public static void main(String[] args) throws Exception {

    	// 準備。servicesとかは入ってないみたいなので、1.6でもforNameする。
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:GrassField.db");
        Statement stmt = conn.createStatement();

        // テーブルを作る。
        // 実行するとgetConnection時に指定したGrassFieldという名前のファイルが出来る。
        //stmt.execute( "create table GrassField( id integer primary key, address string,  num_word integer, tag string, date_record  )" );

        /*// とりあえず、１行INSERT。
        String addre = "ad";
        int num1= 4;
        String tag = "tag1";
        String datas = "2019-05-22";
        String insert= "insert into Grass(address, num_word, tag, date_record) values  ('" + addre + "' , "+ num1 +",'" + tag +"','"+ datas +"');";
        //確認用
        //System.out.println(insert);
        int num3 = stmt.executeUpdate(insert);
        */
        //SELECTして値を見てみる。

        /*ResultSet rs = stmt.executeQuery( "select * from Grass where date_record='" + datas + "'" );
        while( rs.next() ) {
            System.out.println( rs.getString( 2 ) );
            System.out.println( rs.getInt( 3 ) );
        }*/
        data_insert();
        ResultSet rr = data_select("2019-05-22");

        // 閉じる
        conn.close();
    }

    public static void data_insert () throws Exception {
    	Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:GrassField.db");
        Statement stmt = conn.createStatement();

    	String addre = "ad";
        int num1= 4;
        String tag = "tag1";
        String dates = "2019-05-22";
        String insert= "insert into Grass(address, num_word, tag, date_record) values  ('" + addre + "' , "+ num1 +",'" + tag +"','"+ dates +"');";
        //確認用
        System.out.println(insert);
        int num3 = stmt.executeUpdate(insert);
        conn.close();
    }

    public static ResultSet data_select (String dates) throws Exception{
    	Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:GrassField.db");
        Statement stmt = conn.createStatement();

        //dates = "2019-05-22";
        ResultSet rs = stmt.executeQuery( "select * from Grass where date_record='" + dates + "'" );
        while( rs.next() ) {
            System.out.println( rs.getString( 2 ) );
            System.out.println( rs.getInt( 3 ) );
            System.out.println( rs.getInt( 4 ) );
        }
        conn.close();
        return rs;
    }

    public static void data_update(String string) throws Exception{
    	Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:GrassField.db");
        Statement stmt = conn.createStatement();

        //dates = "2019-05-22";
        String update="update Grass set address='bbbb' where date_record='" + string +"'";
        int num3 = stmt.executeUpdate(update);
        conn.close();

    }


}