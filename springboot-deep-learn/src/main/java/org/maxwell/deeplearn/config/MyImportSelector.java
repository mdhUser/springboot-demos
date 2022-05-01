package org.maxwell.deeplearn.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description:  导入第三方bean资源 可批量导入
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/1 18:14
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"org.maxwell.deeplearn.entity.User"};
    }


}
