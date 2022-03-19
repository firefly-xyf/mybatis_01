package com.j2103.test;
import com.j2103.mapper.IUserMapper;
import com.j2103.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName UserMapperTest
 * @Author BlackPearl
 * @Date 2021/8/27
 * @Version V1.0
 * @Description: TODO
 **/
public class UserMapperTest {
    //@BeforeClass    //当测试类被调用时执行,静态方法

    SqlSession session = null;
    IUserMapper userMapper = null;

    @Before //当方法每次被调用时执行
    public void testBefore() throws IOException {
        //读取核心配置文件
        String resuorce = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resuorce);

        //创建SqlSessionFactory--用来创建SqlSession对象的，而SqlSession用来操作数据库的。
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建Session对象
        session = sqlSessionFactory.openSession(true);//加参数true，设置事务的自动提交
        //获取mapper对象
        userMapper = session.getMapper(IUserMapper.class);
    }

    /*测试添加方法*/
    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("admin3");
        user.setPassword("admin333");

        boolean flag = userMapper.insert(user);
        System.out.println("testInsert-->" + flag);
    }

    /*测试查询所有方法*/
    @Test
    public void testSelectAll(){
        List<User> userList = userMapper.findAll();
        System.out.println("testSelectAll--->"+userList);
    }

    /*测试根据id查询方法，参数为int类型*/
    @Test
    public void testFindUserById(){
       User user = userMapper.findById(3);
        System.out.println("testFindUserById--->"+user);
    }
    /*测试根据id查询方法，参数为user对象类型*/
    @Test
    public void testFindUserByUid(){
        User user = new User();
        user.setUid(3);
        user = userMapper.findByUid(user);
        System.out.println("testFindUserById--->"+user);
    }


    /*测试根据id修改一个用户的信息*/
    @Test
    public void updateUserById(){
        User user = new User();
        user.setUid(3);
        user.setUsername("hello");
        user.setPassword("hello222");

        boolean flag1 = userMapper.updateById(user);
        System.out.println("updateUserById--->"+flag1);

    }
    /*测试根据id删除一个用户的信息*/
    @Test
    public void deleteUserById(){
        boolean flag3 = userMapper.deleteById(3);
        System.out.println("deleteUserById-->"+flag3);
    }

    @After  //每次方法被调用后运行
    public void testAfter(){
        //手动提交事务
        //session.commit();
        session.close();
    }
}
