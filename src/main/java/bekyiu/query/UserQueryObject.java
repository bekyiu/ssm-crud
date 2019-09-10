package bekyiu.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 封装了高级查询的参数和分页的参数
@Getter
@Setter
@ToString
public class UserQueryObject
{
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Integer currentPage = 1;
    private Integer pageSize = 3;

    public Integer getStart()
    {
        return (currentPage - 1) * pageSize;
    }
}
