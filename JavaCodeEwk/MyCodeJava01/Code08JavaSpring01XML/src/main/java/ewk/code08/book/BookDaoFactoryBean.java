package ewk.code08.book;

import org.springframework.beans.factory.FactoryBean;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {
    @Override
    public BookDao getObject() throws Exception {
        System.out.println("BookDaoFactoryBean");
        return new BookDaoClass();
    }

    @Override
    public Class<?> getObjectType() {
        return BookDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;  // 单例
    }
}
