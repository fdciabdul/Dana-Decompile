package id.dana.service;

import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.model.ThirdPartyService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/service/ServiceMaintenanceUtil;", "", "Lid/dana/model/ThirdPartyService;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/model/ThirdPartyService;)V", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceMaintenanceUtil {
    public static final ServiceMaintenanceUtil INSTANCE = new ServiceMaintenanceUtil();

    private ServiceMaintenanceUtil() {
    }

    @JvmStatic
    public static final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(DanaUrl.MAINTENANCE_PAGE, Arrays.copyOf(new Object[]{p0}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        sb.append(format);
        DanaH5.startContainerFullUrl(sb.toString());
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyService p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.D != 0) {
            return;
        }
        if (Intrinsics.areEqual(p0.NetworkUserEntityData$$ExternalSyntheticLambda8, "service_danapoly")) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(p0.NetworkUserEntityData$$ExternalSyntheticLambda6);
            DanaH5.startContainerFullUrl(sb.toString());
            return;
        }
        String str = p0.FragmentBottomSheetPaymentSettingBinding;
        getAuthRequestContext(str != null ? str : "");
    }
}
