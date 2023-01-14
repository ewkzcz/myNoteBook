package ewk.code12.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface AccountService {
    @Transactional(rollbackFor = {IOException.class})
    public void transfer(String out, String in, Double money) throws IOException;
}
