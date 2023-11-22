package id.dana.lib.bio.productpage.common;

import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.lib.bio.productpage.model.SecuritySettingQueryExtended;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a'\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lid/dana/lib/bio/productpage/model/SecuritySettingQueryExtended;", "p0", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/Map;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConstantsKt {
    public static /* synthetic */ Map PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter("dana_app_securitysetting", "");
        Intrinsics.checkNotNullParameter(SecurityConstants.KEY_SQ, "");
        Intrinsics.checkNotNullParameter("sq_20001", "");
        return MapsKt.mapOf(TuplesKt.to("sceneId", "dana_app_securitysetting"), TuplesKt.to("userId", str), TuplesKt.to("productCode", SecurityConstants.KEY_SQ), TuplesKt.to("productId", "sq_20001"));
    }

    public static /* synthetic */ Map MyBillsEntityDataFactory() {
        Intrinsics.checkNotNullParameter("dana_app_securitysetting", "");
        Intrinsics.checkNotNullParameter("APP_SETTING_NATIVE", "");
        return MapsKt.mapOf(TuplesKt.to("verifyType", "4"), TuplesKt.to("productCode", "APP_SETTING_NATIVE"), TuplesKt.to("sceneId", "dana_app_securitysetting"));
    }

    public static final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2(List<SecuritySettingQueryExtended> list) {
        Intrinsics.checkNotNullParameter(list, "");
        JSONObject jSONObject = new JSONObject();
        for (SecuritySettingQueryExtended securitySettingQueryExtended : list) {
            String str = securitySettingQueryExtended.KClassImpl$Data$declaredNonStaticMembers$2;
            SecuritySettingQueryExtended.Companion companion = SecuritySettingQueryExtended.INSTANCE;
            jSONObject.put((JSONObject) str, (String) SecuritySettingQueryExtended.Companion.BuiltInFictitiousFunctionClassFactory(securitySettingQueryExtended));
        }
        return MapsKt.mapOf(TuplesKt.to(RequestConstants.SecVIKeySecuritySettingsConfig, jSONObject.toJSONString()));
    }
}
