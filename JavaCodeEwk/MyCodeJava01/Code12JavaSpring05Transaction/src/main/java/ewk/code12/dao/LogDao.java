package ewk.code12.dao;

import org.apache.ibatis.annotations.Insert;

public interface LogDao {
    @Insert("insert into accountLog (info,date)" +
            "values(#{info},now())")
    void log(String info);
}
