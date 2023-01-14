package ewk.code12.service;

import ewk.code12.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceClass implements LogService {
    @Autowired(required=false)
    private LogDao logDao;

    @Override
    public void log(String out, String in, Double money) {
        logDao.log("转账操作由" + out + "到" + in + ",金额:" + money);
    }
}
