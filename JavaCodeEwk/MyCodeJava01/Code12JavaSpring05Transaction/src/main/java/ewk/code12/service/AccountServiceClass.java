package ewk.code12.service;

import ewk.code12.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AccountServiceClass implements AccountService{
    @Autowired(required=false)
    private AccountDao accountDao;
    @Autowired(required=false)
    private LogService logService;

    public void transfer(String out,String in,Double money) throws IOException {
        /*
        accountDao.outMoney(out,money);
        // int num = 1/0;  // 异常导致,上一句出帐成功,下一句入账失败(默认可以回滚的异常)
        // if(true) throw new IOException();  // 默认不会回滚的异常
        accountDao.inMoney(in,money);
         */
        try{
            accountDao.outMoney(out,money);
            // int num = 1/0;
            accountDao.inMoney(in,money);
        } finally {
            logService.log(out,in,money);
        }
    }
}
