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
@ListenerClass(method = {@ListenerMethod(defaultReturn = SummaryActivity.CHECKED, name = "onItemLongClick", parameters = {"android.widget.AdapterView<?>", "android.view.View", "int", "long"}, returnType = "boolean")}, setter = "setOnItemLongClickListener", targetType = "android.widget.AdapterView<?>", type = "android.widget.AdapterView.OnItemLongClickListener")
/* loaded from: classes3.dex */
public @interface OnItemLongClick {
    int[] value() default {-1};
}
