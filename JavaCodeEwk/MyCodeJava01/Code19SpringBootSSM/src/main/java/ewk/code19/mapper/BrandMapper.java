package ewk.code19.mapper;

import ewk.code19.data.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper  // SpringBoot扫描
public interface BrandMapper {
    // 查询所有
    @Select("select * from sheet")
    List<Brand> selectAll();

    // 按id查询
    @Select("select * from sheet where id = #{id}")
    Brand selectById(int id);

    // 新增数据
    @Insert("insert into sheet values(null,#{brandName},#{enterpriseName},#{introduce})")
    int add(Brand brand);

    // 按id删除
    @Delete("DELETE from sheet WHERE id = #{id}")
    int deleteById(@Param("id") int id);

    // 按id批量删除
    int deleteByIds(@Param("ids") int[] ids);

    // 按id修改
    @Update("UPDATE sheet SET brandName=#{brand.brandName},enterpriseName=#{brand.enterpriseName},introduce=#{brand.introduce} WHERE id=#{brand.id}")
    int updateById(@Param("brand") Brand brand);

    // 分页查询
    @Select("select * from sheet limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    // 分页查询时查询记录数
    @Select("select count(*) from sheet")
    int selectTotalCount();

    // 分页多条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    // 分页多条件查询时记录查询数
    Integer selectByConditionTotalCount(@Param("brand") Brand brand);
}
