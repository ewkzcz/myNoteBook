package ewk.code20.data;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
@Data
@NoArgsConstructor
// 问题4的解决: 表名与编码开发设计不同步
@TableName("sheet")
public class Brand {
    // 问题1的解决: 表字段与编码属性设计不同步
    @TableField(value = "id")
    private Integer id;
    @TableField(value = "brandName")
    private String brandName;
    @TableField(value = "enterpriseName")
    private String enterpriseName;
    @TableField(value = "introduce")
    // 问题3的解决: 采用默认查询开发了更多字段的查看权限
    // @TableField(value = "introduce",select = false)  // 不参与查询
    private String introduce;

    // 问题2的解决: 编码中添加了数据库中未定义的属性
    @TableField(exist = false)
    private Integer online;

    public Brand(Integer id, String brandName, String enterpriseName, String introduce) {
        this.id = id;
        this.brandName = brandName;
        this.enterpriseName = enterpriseName;
        this.introduce = introduce;
    }
}
