package ewk.code02.mapper;

import ewk.code02.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface StudentSheet1Mapper {
    // 查询所有数据
    // 注解开发方式
    // @Select("select stu_id as id,stu_name as name,stu_age as age,stu_bir as bir from sheet1;")
    List<Data> selectAll();

    // 查看详情
    List<Data> selectById(int id);

    // 多条件查询1
    List<Data> selectByCondition(@Param("id")int id,@Param("name")String name,
                                 @Param("age")int age,@Param("bir")String bir);
    // 多条件查询2
    List<Data> selectByCondition(Data data);

    // 多条件查询3
    List<Data> selectByCondition(Map map);

    // 单条件查询
    List<Data> selectByConditionSingle(Data data);

    // 插入数据1
    void add(Data data);

    // 插入数据2
    int addReturnId(Data data);

    // 删除单个数据
    void deleteById(int id);

    // 批量删除数据
    void deleteByIds(@Param("ids")int[] ids);

    // 更新数据
    int update(Data data);
}
