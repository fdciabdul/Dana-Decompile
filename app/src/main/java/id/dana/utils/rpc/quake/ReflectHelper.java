package id.dana.utils.rpc.quake;

import android.text.TextUtils;
import com.alipay.mobile.framework.service.annotation.OperationType;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class ReflectHelper {
    private ReflectHelper() {
    }

    public static String PlaceComponentResult(Class cls) {
        OperationType operationType;
        if (cls == null) {
            return "unknown";
        }
        for (Method method : cls.getMethods()) {
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
