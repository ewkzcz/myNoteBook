package ewk.code19.data;

import java.util.List;

public class Page<T> {
    // 总记录数
    private Integer totalCount;
    // 当前页数据
    private List<T> rows;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                '}' + '\n';
    }
}
