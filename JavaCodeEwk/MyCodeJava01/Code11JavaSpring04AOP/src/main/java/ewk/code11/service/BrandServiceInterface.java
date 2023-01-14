package ewk.code11.service;

import ewk.code11.data.Brand;
import ewk.code11.data.Page;

import java.util.List;

public interface BrandServiceInterface {
    List<Brand> selectAll();

    void add(Brand brand);

    void deleteByIds(int[] ids);

    Page<Brand> selectByPage(int currentPage, int pageSize);

    Page<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}
