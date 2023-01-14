package ewk.code11.service;

import ewk.code11.data.Brand;
import ewk.code11.data.Page;
import ewk.code11.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceClass implements BrandServiceInterface {
    @Autowired(required = false)
    // 使用@Autowired注解的时候,默认required=true,表示注入的时候bean必须存在,否则注入失败
    // 解决方案: 在自动转配的注解后面添加(required=false)
    private BrandMapper brandMapper;

    @Override
    public List<Brand> selectAll() {
        List<Brand> brands = brandMapper.selectAll();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        brandMapper.add(brand);
    }

    @Override
    public void deleteByIds(int[] ids) {
        brandMapper.deleteByIds(ids);
    }

    @Override
    public Page<Brand> selectByPage(int currentPage, int pageSize) {
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Brand> rows = brandMapper.selectByPage(begin, size);  // 分页查询
        int totalCount = brandMapper.selectTotalCount();  // 查询条目数
        Page<Brand> page = new Page<>();
        page.setRows(rows);
        page.setTotalCount(totalCount);
        return page;
    }

    @Override
    public Page<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        // 处理条件,模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }
        String enterpriseName = brand.getEnterpriseName();
        if (enterpriseName != null && enterpriseName.length() > 0) {
            brand.setEnterpriseName("%" + enterpriseName + "%");
        }
        // 多条件查询
        List<Brand> rows = brandMapper.selectByPageAndCondition(begin, size, brand);  // 分页多条件查询
        int totalCount = brandMapper.selectByConditionTotalCount(brand);  // 多条件查询查询条目数

        Page<Brand> page = new Page<>();
        page.setRows(rows);
        page.setTotalCount(totalCount);
        return page;
    }
}
