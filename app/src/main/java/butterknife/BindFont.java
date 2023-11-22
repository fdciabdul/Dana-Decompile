package butterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface BindFont {

    /* loaded from: classes3.dex */
    public @interface TypefaceStyle {
    }

    int style() default 0;

    int value();
}
