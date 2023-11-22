package org.checkerframework.checker.mustcall.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE_USE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface MustCallAlias {
}
