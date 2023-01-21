package ewk.code20;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ewk.code20.data.Brand;
import ewk.code20.data.BrandQuery;
import ewk.code20.mapper.BrandMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Code20MybatisPlusApplicationTests {
    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void testSave() {
        Brand brand = new Brand(1009, "华强北", "华强北公司", "仿造第一");
        brandMapper.insert(brand);
    }

    @Test
    public void testDelete() {
        brandMapper.deleteById(1659441154);
    }

    @Test
    public void testUpdate() {
        Brand brand = new Brand(1008, "蒙牛", "蒙牛公司", "喝牛奶吗?");
        brandMapper.updateById(brand);
    }

    @Test
    void testSelectAll() {
        List<Brand> brands = brandMapper.selectList(null);
        brands.forEach(System.out::println);
    }

    @Test
    void testSelectById() {
        Brand brand = brandMapper.selectById(1001);
        System.out.println(brand);
    }

    // 分页查询
    @Test
    void testSelectByPage() {
        IPage page = new Page(1, 5);
        brandMapper.selectPage(page, null);
        System.out.println("当前页码值:" + page.getCurrent());
        System.out.println("每页显示数:" + page.getSize());
        System.out.println("一共多少页:" + page.getCurrent());
        System.out.println("一共多少条数据:" + page.getTotal());
        System.out.println("数据:" + page.getRecords());
    }

    // 条件查询
    @Test
    void testSelectByCondition() {
        // 方法1
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.lt("id",1005);
//        List<Brand> brandList = brandMapper.selectList(queryWrapper);
//        System.out.println(brandList);

        // 方法2
//        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
//        queryWrapper.lambda().lt(Brand::getId,1005);
//        List<Brand> brandList = brandMapper.selectList(queryWrapper);
//        System.out.println(brandList);

        // 方法3:
        // 链式编程,and逻辑
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper.lt(Brand::getId, 1005).gt(Brand::getId, 1003);
        List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
        System.out.println(brandList);
        // 链式编程,or逻辑
        LambdaQueryWrapper<Brand> lambdaQueryWrapper1 = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper1.lt(Brand::getId, 1005).or().gt(Brand::getId, 1003);
        List<Brand> brandList1 = brandMapper.selectList(lambdaQueryWrapper1);
        System.out.println(brandList1);
        // lt小于,le小于等于,gt大于,ge大于等于,eq等于
        LambdaQueryWrapper<Brand> lambdaQueryWrapper2 = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper2.eq(Brand::getId, 1005);
        List<Brand> brandList2 = brandMapper.selectList(lambdaQueryWrapper2);
        System.out.println(brandList2);
    }

    // 多条件查询处理null值
    @Test
    void testSelectByConditionWithNull() {
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setIdMin(1001);
        brandQuery.setIdMax(1005);
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper.gt(brandQuery.getIdMin() != null, Brand::getId, brandQuery.getIdMin());
        lambdaQueryWrapper.lt(brandQuery.getIdMax() != null, Brand::getId, brandQuery.getIdMax());
        List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
        System.out.println(brandList);
    }

    // 查询投影
    @Test
    void test1() {
        // 写法1
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Brand::getId, Brand::getBrandName, Brand::getEnterpriseName);
        List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
        System.out.println(brandList);
        // 写法2
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        queryWrapper.select("id", "brandName", "enterpriseName");
        List<Brand> brandList1 = brandMapper.selectList(queryWrapper);
        System.out.println(brandList1);
    }

    // 查询投影用于count统计,groupBy分组
    @Test
    void test2() {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        queryWrapper.select("count(*) as count,id");
        queryWrapper.groupBy("id");
        List<Map<String, Object>> list = brandMapper.selectMaps(queryWrapper);
        System.out.println(list);
    }

    // 单查询
    @Test
    void testSelectOne() {
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper.eq(Brand::getId, 1005);
        Brand brand = brandMapper.selectOne(lambdaQueryWrapper);
        System.out.println(brand);
    }

    // 范围查询
    @Test
    void testSelectBetween() {
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper.between(Brand::getId, 1001, 1005);
        List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
        System.out.println(brandList);
    }

    // 模糊匹配: likeLeft左边加%,likeRight右边加%,like左右加空格
    @Test
    void testSelectLike() {
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper.like(Brand::getEnterpriseName, "公司");
        List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
        System.out.println(brandList);
    }

    // 自增策略
    @Test
    public void testIdAdd() {
        Brand brand = new Brand();
        brand.setBrandName("华强北");
        brand.setEnterpriseName("华强北公司");
        brand.setIntroduce("仿造第一");
        brandMapper.insert(brand);
    }

    // 根据主键进行多数据操作
    @Test
    public void testByIds(){
        // 删除多条数据
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        brandMapper.deleteBatchIds(list);
        // 查询多条数据
        List<Integer> list1 = new ArrayList<>();
        list1.add(1003);
        list1.add(1004);
        brandMapper.selectBatchIds(list1);
    }
}