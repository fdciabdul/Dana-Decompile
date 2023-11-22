package id.dana.network.util;

import android.text.TextUtils;
import com.alipay.mobile.framework.service.annotation.OperationType;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/network/util/ReflectHelper;", "", "Ljava/lang/Class;", "clz", "", "getOperationType", "(Ljava/lang/Class;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReflectHelper {
    public static final ReflectHelper INSTANCE = new ReflectHelper();

    private ReflectHelper() {
    }

    public final String getOperationType(Class<?> clz) {
        OperationType operationType;
        if (clz == null) {
            return "unknown";
        }
        Method[] methods = clz.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "");
        for (Method method : methods) {
            if (method != null && (operationType = (OperationType) method.getAnnotation(OperationType.class)) != null) {
                String value = operationType.value();
                if (!TextUtils.isEmpty(value)) {
                    return value;
                }
            }
        }
        return "unknown";
    }
}
