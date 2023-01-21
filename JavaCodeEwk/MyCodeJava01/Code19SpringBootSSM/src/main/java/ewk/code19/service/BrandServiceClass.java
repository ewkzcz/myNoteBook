package ewk.code19.service;

import ewk.code19.data.Brand;
import ewk.code19.data.Page;
import ewk.code19.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceClass implements BrandServiceInterface {
    @Autowired(required = false)
    private BrandMapper brandMapper;

    public boolean add(Brand brand) {
        return brandMapper.add(brand) > 0;
    }

    public boolean deleteById(int id) {
        return brandMapper.deleteById(id) > 0;
    }

    public boolean deleteByIds(int[] ids) {
        return brandMapper.deleteByIds(ids) > 0;
    }

    public boolean updateById(Brand brand) {
        return brandMapper.updateById(brand) > 0;
    }

    public List<Brand> selectAll() {
        List<Brand> brands = brandMapper.selectAll();
        return brands;
    }

    public Brand selectById(int id) {
        return brandMapper.selectById(id);
    }

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

    public Page<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        // 处理查询参数
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        // 处理查询条件: 模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }
        String enterpriseName = brand.getEnterpriseName();
        if (enterpriseName != null && enterpriseName.length() > 0) {
            brand.setEnterpriseName("%" + enterpriseName + "%");
        }

        // 多条件查询
        // 多条件查询查询条目数
        Integer totalCount = brandMapper.selectByConditionTotalCount(brand);
        // 分页多条件查询结果
        List<Brand> rows = brandMapper.selectByPageAndCondition(begin, size, brand);
        // 包装为Page类型
        Page<Brand> page = new Page<>();
        page.setRows(rows);
        page.setTotalCount(totalCount);
        // 返回结果
        return page;
    }
}
