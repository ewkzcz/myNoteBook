package ewk.code17.code17ssm.service;

import ewk.code17.code17pojo.data.Brand;
import ewk.code17.code17pojo.data.Page;
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
