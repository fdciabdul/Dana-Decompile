package id.dana.data.util;

import com.iap.ac.config.lite.ConfigCenter;
import id.dana.animation.HomeTabActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/util/ConfigCenterHelper;", "", "", HomeTabActivity.WALLET_SECTION, "Lorg/json/JSONObject;", "getSection", "(Ljava/lang/String;)Lorg/json/JSONObject;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfigCenterHelper {
    public static final ConfigCenterHelper INSTANCE = new ConfigCenterHelper();

    private ConfigCenterHelper() {
    }

    @JvmStatic
    public static final JSONObject getSection(String section) {
        Intrinsics.checkNotNullParameter(section, "");
        return ConfigCenter.getInstance().getSectionConfig(section);
    }
}
