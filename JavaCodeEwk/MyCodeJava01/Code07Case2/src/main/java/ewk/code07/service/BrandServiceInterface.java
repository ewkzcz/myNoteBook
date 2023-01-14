package ewk.code07.service;

import ewk.code07.data.Brand;
import ewk.code07.data.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandServiceInterface {
    List<Brand> selectAll();

    void add(Brand brand);

    void deleteByIds(int[] ids);

    Page<Brand> selectByPage(int currentPage,int pageSize);

    Page<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);
}
