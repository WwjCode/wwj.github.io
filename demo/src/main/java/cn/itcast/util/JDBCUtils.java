package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//JDBC�����࣬ʹ��Durid���ӳ�
public class JDBCUtils {

    private static DataSource ds;

    static {

        try {
//        ���������ļ�
            Properties pro = new Properties();
//        ʹ��ClassLoader���������ļ�����ȡ�ֽ�������
            InputStream is = JdbcUtils.class.getResourceAsStream("/druid.properties");
//            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

//            ��ʼ�����ӳض���
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ӳض���
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * ��ȡ����Connection����
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
