package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {

    public static SqlSession getSqlSeeion() throws IOException {
        //获取配置的资源文件
        Reader reader= Resources.getResourceAsReader("databaseConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
        //sqlsession就能执行SQL文件中的sql语句了
        SqlSession sqlSession=factory.openSession();
        return sqlSession;

    }
}
