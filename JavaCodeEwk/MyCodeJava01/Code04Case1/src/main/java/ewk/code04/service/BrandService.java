package ewk.code04.service;

import ewk.code04.data.Brand;
import ewk.code04.mapper.BrandMapper;
import ewk.code04.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    // 查询所有
    public List<Brand> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    // 添加数据
    public void add(Brand brand){
        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 执行方法
        brandMapper.add(brand);
        // 释放资源
        sqlSession.close();
    }

    // 根据id查询
    public Brand selectById(int id){
        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 执行方法
        Brand brand = brandMapper.selectById(id);
        // 释放资源
        sqlSession.close();
        // 返回数据
        return brand;
    }

    // 修改数据
    public void update(Brand brand){
        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 执行方法
        brandMapper.update(brand);
        // 释放资源
        sqlSession.close();
    }
}
