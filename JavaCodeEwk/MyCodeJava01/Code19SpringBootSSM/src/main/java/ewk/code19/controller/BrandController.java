package ewk.code19.controller;

import ewk.code19.data.Brand;
import ewk.code19.data.Code;
import ewk.code19.data.Page;
import ewk.code19.data.Result;
import ewk.code19.service.BrandServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // 声明为控制器类
@RequestMapping("/brands")  // 模块名
public class BrandController {
    @Autowired
    private BrandServiceInterface brandServiceInterface;

    // 新增
    @PostMapping // 这里要保证Brand类有无参构造函数,不知道为什么,但是必须有(使用了RequestBody的都是)
    public Result add(@RequestBody Brand brand) {
        boolean flag = brandServiceInterface.add(brand);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag + "");
    }

    // 根据id删除
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        boolean flag = brandServiceInterface.deleteById(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag + "");
    }

    // 根据id数组批量删除
    @RequestMapping("/deleteByIds")
    public Result deleteByIds(@RequestBody int[] ids) {
        System.out.println(ids);
        boolean flag = brandServiceInterface.deleteByIds(ids);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag + "");
    }

    // 查询所有
    @GetMapping
    public Result selectAll() {
        List<Brand> brands = brandServiceInterface.selectAll();
        Integer code = (brands == null) ? Code.GET_ERR : Code.GET_OK;
        String msg = (brands == null) ? "数据查询失败,请重试" : "";
        return new Result(code, brands, msg);
    }

    // 按id查询
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Brand brand = brandServiceInterface.selectById(id);
        Integer code = (brand == null) ? Code.GET_ERR : Code.GET_OK;
        String msg = (brand == null) ? "数据查询失败,请重试" : "";
        return new Result(code, brand, msg);
    }

    // 根据id修改
    @PutMapping
    public Result updateById(@RequestBody Brand brand) {
        boolean flag = brandServiceInterface.updateById(brand);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag + "");
    }

    // 分页查询
    @PostMapping("/{currentPage}/{pageSize}")
    public Result selectByPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        Page<Brand> page = brandServiceInterface.selectByPage(currentPage, pageSize);
        Integer code = (page == null) ? Code.GET_ERR : Code.GET_OK;
        String msg = (page == null) ? "数据查询失败,请重试" : "";
        return new Result(code, page, msg);
    }

    // 分页条件查询
    @RequestMapping("/selectByPageAndCondition/{currentPage}/{pageSize}")
    public Result selectByPageAndCondition(@PathVariable int currentPage,
                                           @PathVariable int pageSize,
                                           @RequestBody Brand brand) {
        Page<Brand> page = brandServiceInterface.selectByPageAndCondition(currentPage, pageSize, brand);
        Integer code = (page == null) ? Code.GET_ERR : Code.GET_OK;
        String msg = (page == null) ? "数据查询失败,请重试" : "";
        return new Result(code, page, msg);
    }
}
