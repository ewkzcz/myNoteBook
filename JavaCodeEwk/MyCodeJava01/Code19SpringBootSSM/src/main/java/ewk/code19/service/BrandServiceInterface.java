package ewk.code19.service;

import ewk.code19.data.Brand;
import ewk.code19.data.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional  // 打开事务管理器
public interface BrandServiceInterface {
    boolean add(Brand brand);

    boolean deleteById(int id);

    boolean deleteByIds(int[] ids);

    boolean updateById(Brand brand);

    List<Brand> selectAll();

    Brand selectById(int id);

    Page<Brand> selectByPage(int currentPage, int pageSize);

    Page<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}
