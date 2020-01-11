import com.zl.dao.IRoleDao;
import com.zl.domain.Role;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleTest {
    InputStream in;
    SqlSessionFactory factory;
    SqlSession sqlSession;
    IRoleDao roleDao;

    @Before
    public void init() throws IOException {
    in= Resources.getResourceAsStream("SqlMapConfig.xml");
    factory= new SqlSessionFactoryBuilder().build(in);
    sqlSession=factory.openSession();
    roleDao=sqlSession.getMapper(IRoleDao.class);
    }
    @After
    public void destroy() throws IOException {
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Role> roles=roleDao.findAll();
        for(Role role:roles){
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
