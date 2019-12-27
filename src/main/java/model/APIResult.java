package model;

import com.google.gson.Gson;
import enums.APICode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by 杨光 on 2018/4/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResult<T> {
    private static final Gson gson = new Gson();

    private int responseCode = APICode.成功.getCode();//返回码,默认成功
    private String errorMsg;//错误时错误信息描述
    private String token;//新的token
    private T result;//返回对象

    public void setResponseCode(APICode apiCode) {
        this.responseCode = apiCode.getCode();
    }

    /**
     * 业务参数错误
     * @param errorMsg 错误信息描述
     */
    public void paramError(String errorMsg){
        error(APICode.业务参数错误,errorMsg);
    }

    /**
     * 返回错误
     * @param apiCode 返回码
     * @param errorMsg 错误信息描述
     */
    public void error(APICode apiCode,String errorMsg){
        setAll(apiCode,errorMsg,null,null);
    }

    /**
     * 设置所有字段
     * @param apiCode 返回码
     * @param errorMsg 错误时错误信息描述
     * @param token
     * @param result 返回对象
     */
    public void setAll(APICode apiCode,String errorMsg,String token,T result){
        this.responseCode = apiCode.getCode();
        this.errorMsg = errorMsg;
        this.result = result;
        this.token = token;
    }

    /**
     * 将当前实体转为Json
     * @return
     */
    public String toJson(){
        return gson.toJson(this);
    }


    /**
     * 从json转为APIResult
     * @param json json字符串
     * @param resultClazz APIResult实体中result属性想要转换的实体类型
     */
    public static APIResult fromJson(String json, Class resultClazz){
        return gson.fromJson(json, type(APIResult.class,resultClazz));
    }

    private static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}