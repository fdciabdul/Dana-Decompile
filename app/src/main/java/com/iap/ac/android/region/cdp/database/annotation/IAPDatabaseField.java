package com.iap.ac.android.region.cdp.database.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface IAPDatabaseField {
    public static final String DEFAULT_VALUE = "__DEFAULT_VALUE__";

    boolean canBeNull() default true;

    String defaultValue() default "__DEFAULT_VALUE__";

    boolean generatedId() default false;

    boolean id() default false;

    boolean unique() default false;

    boolean uniqueCombo() default false;
}
