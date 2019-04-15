package model;

import enums.ValidateMode;
import exception.WarnException;

/**
 * JokerYG
 * Date: 2019-04-12
 * Time: 15:21
 */
public abstract  class ValidateEntity {
    /**
     * 数据校验
     * @param mode 校验的模式
     * @return
     */
    public abstract String validate(ValidateMode mode);

    public static void Validate(ValidateEntity entity, ValidateMode mode)throws WarnException{
        String msg = entity.validate(mode);
        if(msg != null){
            throw new WarnException(msg);
        }
    }

}
