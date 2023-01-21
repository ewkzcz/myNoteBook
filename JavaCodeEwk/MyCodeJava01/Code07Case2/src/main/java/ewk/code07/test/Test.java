package ewk.code07.test;

import ewk.code07.data.Brand;
import ewk.code07.mapper.BrandMapper;
import ewk.code07.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        for (Brand brand : brands) {
            System.out.print(brand);
        }
    }
}
