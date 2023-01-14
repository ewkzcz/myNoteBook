package ewk.code07.service.serviceclass;

import ewk.code07.data.Brand;
import ewk.code07.data.Page;
import ewk.code07.mapper.BrandMapper;
import ewk.code07.service.BrandServiceInterface;
import ewk.code07.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceClass implements BrandServiceInterface {
    // 创建
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(ids);
        sqlSession.close();
    }

    @Override
    public Page<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Brand> rows = brandMapper.selectByPage(begin, size);  // 分页查询
        int totalCount = brandMapper.selectTotalCount();  // 查询条目数
        Page<Brand> page = new Page<>();
        page.setRows(rows);
        page.setTotalCount(totalCount);
        sqlSession.close();
        return page;
    }

    @Override
    public Page<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        // 处理条件,模糊表达式
        String brandName = brand.getBrandName();
        if(brandName != null&&brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String enterpriseName = brand.getEnterpriseName();
        if(enterpriseName != null&&enterpriseName.length()>0){
            brand.setEnterpriseName("%"+enterpriseName+"%");
        }
        // 多条件查询
        List<Brand> rows = brandMapper.selectByPageAndCondition(begin, size, brand);  // 分页多条件查询
        int totalCount = brandMapper.selectByConditionTotalCount(brand);  // 多条件查询查询条目数

        Page<Brand> page = new Page<>();
        page.setRows(rows);
        page.setTotalCount(totalCount);
        sqlSession.close();
        return page;
    }
}
