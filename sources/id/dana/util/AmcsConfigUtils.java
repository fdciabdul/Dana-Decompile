package id.dana.util;

import com.alibaba.fastjson.JSONObject;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.foundation.utils.JsonUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/util/AmcsConfigUtils;", "", "", "p0", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/Number;)Ljava/lang/Number;", "Lcom/alibaba/fastjson/JSONObject;", "getAuthRequestContext", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)Lcom/alibaba/fastjson/JSONObject;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class AmcsConfigUtils {
    public static final AmcsConfigUtils INSTANCE = new AmcsConfigUtils();

    private AmcsConfigUtils() {
    }

    @JvmStatic
    public static final Number KClassImpl$Data$declaredNonStaticMembers$2(String p0, Number p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Number numberConfig = ConfigCenter.getInstance().getNumberConfig(p0, p1);
        Intrinsics.checkNotNullExpressionValue(numberConfig, "");
        return numberConfig;
    }

    @JvmStatic
    public static final JSONObject getAuthRequestContext(String p0, JSONObject p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return JsonUtil.MyBillsEntityDataFactory(ConfigCenter.getInstance().getJSONConfig(p0, JsonUtil.getAuthRequestContext(p1)));
    }
}
