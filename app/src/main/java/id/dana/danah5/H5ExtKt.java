package id.dana.danah5;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003"}, d2 = {"Lcom/alibaba/ariver/app/api/Page;", "", "getAppId", "(Lcom/alibaba/ariver/app/api/Page;)Ljava/lang/String;", "appId", "getServiceKey", DanaH5.SERVICE_KEY}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class H5ExtKt {
    @JvmName(name = "getAppId")
    public static final String getAppId(Page page) {
        Intrinsics.checkNotNullParameter(page, "");
        String string = page.getStartParams().getString("appId");
        if (string == null || !TextUtils.isDigitsOnly(string)) {
            return null;
        }
        return string;
    }

    @JvmName(name = "getServiceKey")
    public static final String getServiceKey(Page page) {
        Intrinsics.checkNotNullParameter(page, "");
        return page.getStartParams().getString(DanaH5.SERVICE_KEY);
    }
}
