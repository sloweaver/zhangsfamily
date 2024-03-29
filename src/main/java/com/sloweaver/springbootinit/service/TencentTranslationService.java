package com.sloweaver.springbootinit.service;

import com.sloweaver.springbootinit.model.dto.tencenttranslation.TencentTranslationRequest;
import com.sloweaver.springbootinit.model.entity.TencentTranslation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【tencent_translation(腾讯翻译记录表)】的数据库操作Service
* @createDate 2023-05-10 22:15:43
*/
@Component
public interface TencentTranslationService extends IService<TencentTranslation> {


    /**
     * translation sourceText
     * @param tencentTranslationRequest
     * @return
     */
    String translation(TencentTranslationRequest tencentTranslationRequest);


}
