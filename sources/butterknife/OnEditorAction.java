package butterknife;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = SummaryActivity.CHECKED, name = "onEditorAction", parameters = {"android.widget.TextView", "int", "android.view.KeyEvent"}, returnType = "boolean")}, setter = "setOnEditorActionListener", targetType = "android.widget.TextView", type = "android.widget.TextView.OnEditorActionListener")
/* loaded from: classes2.dex */
public @interface OnEditorAction {
    int[] value() default {-1};
}
