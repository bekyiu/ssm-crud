package bekyiu.query;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

// 封装了查询的结果集和分页信息, 前端方便处理
@Getter
@ToString
public class PageResult
{
    // 前端传递
    private Integer currentPage;
    private Integer pageSize;

    // 数据库查询
    private List<?> list;
    private Integer totalCount;

    // 算
    private Integer prevPage;
    private Integer nextPage;
    private Integer totalPage;

    // 下拉菜单的值, 每页多少条数据
    private List<Integer> pageSizeItems = Arrays.asList(2, 3, 4);

    public PageResult(List<?> list, Integer totalCount, Integer currentPage, Integer pageSize)
    {
        this.list = list;
        this.totalCount = totalCount;

        this.currentPage = currentPage;
        this.pageSize = pageSize;

        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : currentPage;
        this.nextPage = currentPage + 1 <= this.totalPage ? currentPage + 1 : this.totalPage;

        this.currentPage = currentPage > totalPage ? totalPage : currentPage;
    }
}
