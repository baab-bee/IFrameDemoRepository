package com.baabbee.iframex.spring.config.patch.json;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PatchRequestBody {
}