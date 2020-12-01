package cn.elook.user.util;

import cn.elook.common.entity.PageRequest;
import cn.elook.common.entity.PageResult;
import com.github.pagehelper.PageInfo;

//分页查询相关工具类
public class PageUtils {
    /**
     * 分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setCurrentPage(pageInfo.getPageNum());
        pageResult.setPageSiez(pageInfo.getPageSize());
        pageResult.setTotalNum(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
