package ewk.code10.mapper;

import ewk.code10.data.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    @Select("select * from sheet")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into sheet values(null,#{brandName},#{enterpriseName},#{introduce})")
    void add(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);

    // 分页查询
    @Select("select * from sheet limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    // 查询记录数
    @Select("select count(*) from sheet")
    int selectTotalCount();

    // 分页多条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    // 多条件查询记录数
    int selectByConditionTotalCount(Brand brand);
}
