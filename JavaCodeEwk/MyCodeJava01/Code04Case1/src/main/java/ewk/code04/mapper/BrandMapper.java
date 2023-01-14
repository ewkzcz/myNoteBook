package ewk.code04.mapper;

import ewk.code04.data.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    // 查询所有数据
    List<Brand> selectAll();

    // 查看详情
    Brand selectById(int id);

    // 多条件查询
    List<Brand> selectByCondition(@Param("id") int id, @Param("name") String name,
                                  @Param("age") int age, @Param("bir") String bir);
    // 多条件查询
    List<Brand> selectByCondition(Brand brand);

    // 多条件查询
    List<Brand> selectByCondition(Map map);

    // 单条件查询
    List<Brand> selectByConditionSingle(Brand brand);

    // 插入数据
    void add(Brand brand);

    // 插入数据
    int addReturnId(Brand brand);

    // 删除单个数据
    void deleteById(int id);

    // 批量删除数据
    void deleteByIds(@Param("ids") int[] ids);

    // 更新数据
    int update(Brand brand);
}
