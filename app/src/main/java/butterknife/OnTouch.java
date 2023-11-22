package butterknife;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import id.dana.biometric.domain.model.RiskActionConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = SummaryActivity.CHECKED, name = RiskActionConstant.ON_TOUCH, parameters = {"android.view.View", "android.view.MotionEvent"}, returnType = "boolean")}, setter = "setOnTouchListener", targetType = "android.view.View", type = "android.view.View.OnTouchListener")
/* loaded from: classes3.dex */
public @interface OnTouch {
    int[] value() default {-1};
}
