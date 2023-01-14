package ewk.code12.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {
    @Update("update sheet set money = money + #{money}" +
            "where name = #{name}")
    void inMoney(@Param("name")String name, @Param("money")Double money);

    @Update("update sheet set money = money - #{money}" +
            "where name = #{name}")
    void outMoney(@Param("name")String name, @Param("money")Double money);
}
