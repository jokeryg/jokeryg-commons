package util;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 参数处理工具类
 * JokerYG
 * Date: 2019-02-20
 * Time: 14:28
 */
public class ParamUtil {
    private ParamUtil(){}

    /**
     * 每页显示数量上限
     */
    @Getter
    @Setter
    private int pageSizeLimit = 15;

    @Getter
    private int pageNo = 1;
    @Getter
    private int pageSize = pageSizeLimit;
    @Getter
    private String startTime = null;
    @Getter
    private String endTime = null;
    @Getter
    private List<String> trimStringList = null;


    /**
     * 常见参数处理
     * @param no 页码，如果参数无效则默认为第一页
     * @param size 每页显示数量，如果参数无效默认为系统设置
     * @param startTime 开始时间，如果不为空则在后边增加 00:00:00
     * @param endTime 结束时间，如果不为空则在后边增加 23:59:59
     * @param trimStrings 需要trim的字符串吧列表，返回的实体中的list按照跟传入顺序一致
     * @return 处理后的实体
     */
    public static ParamUtil handle(String no,String size,String startTime,String endTime,String...trimStrings){
        ParamUtil paramUtil = new ParamUtil();
        //判断页码与显示数量是否正确
        if (StringUtil.isPositiveInteger(no)) {
            paramUtil.pageNo = Integer.parseInt(no);
            if (paramUtil.pageNo < 1) {
                paramUtil.pageNo = 1;
            }
        }
        if (StringUtil.isPositiveInteger(size)) {
            paramUtil.pageSize = Integer.parseInt(size);
            if (paramUtil.pageSize < paramUtil.pageSizeLimit) {
                paramUtil.pageSize = paramUtil.pageSizeLimit;
            }
        }
        //开始时间处理
        if(StringUtil.isEmpty(startTime) == false){
            paramUtil.startTime = startTime + " 00:00:00";
        }
        //结束时间处理
        if(StringUtil.isEmpty(endTime) == false){
            paramUtil.endTime = endTime + " 23:59:59";
        }

        //trim字符串处理
        if(trimStrings != null && trimStrings.length>0){
            paramUtil.trimStringList = new ArrayList<>();
            for (String trimString : trimStrings) {
                paramUtil.trimStringList.add(trimString != null ? trimString.trim() : null);

            }
        }
        return paramUtil;
    }


    /**
     * 常见参数处理
     * @param no 页码，如果参数无效则默认为第一页
     * @param size 每页显示数量，如果参数无效默认为系统设置
     * @return 处理后的实体
     */
    public static ParamUtil handle(String no,String size) {
        return handle(no,size,null,null,null);
    }

    /**
     * 常见参数处理
     * @param no 页码，如果参数无效则默认为第一页
     * @param size 每页显示数量，如果参数无效默认为系统设置
     * @param startTime 开始时间，如果不为空则在后边增加 00:00:00
     * @param endTime 结束时间，如果不为空则在后边增加 23:59:59
     * @return 处理后的实体
     */
    public static ParamUtil handle(String no,String size,String startTime,String endTime) {
        return handle(no,size,startTime,endTime,null);
    }

    /**
     * 常见参数处理
     * @param no 页码，如果参数无效则默认为第一页
     * @param size 每页显示数量，如果参数无效默认为系统设置
     * @param trimStrings 需要trim的字符串吧列表，返回的实体中的list按照跟传入顺序一致
     * @return 处理后的实体
     */
    public static ParamUtil handle(String no,String size,String...trimStrings) {
        return handle(no,size,null,null,trimStrings);
    }
}
