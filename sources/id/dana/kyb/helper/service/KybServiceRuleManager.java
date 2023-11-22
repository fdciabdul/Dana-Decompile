package id.dana.kyb.helper.service;

import id.dana.extension.lang.StringExtKt;
import id.dana.kyb.constant.KybServiceRules;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.KybServiceRedirectValueModel;
import id.dana.kyb.model.KybServiceRuleModel;
import id.dana.kyb.model.KybServiceValidationResult;
import id.dana.utils.extension.JSONExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\t\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u000e"}, d2 = {"Lid/dana/kyb/helper/service/KybServiceRuleManager;", "", "Lid/dana/kyb/model/KybServiceModel;", "p0", "", "p1", "", "p2", "Lid/dana/kyb/model/KybServiceValidationResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/kyb/model/KybServiceModel;Ljava/lang/String;I)Lid/dana/kyb/model/KybServiceValidationResult;", "", "PlaceComponentResult", "(Ljava/lang/Object;I)Z", "(Ljava/lang/Object;Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybServiceRuleManager {
    public static final KybServiceRuleManager INSTANCE = new KybServiceRuleManager();

    private KybServiceRuleManager() {
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Object p0, String p1) {
        List<String> emptyList;
        String obj;
        if (p0 == null || (obj = p0.toString()) == null || (emptyList = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(obj)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return (p1.length() > 0) && (emptyList.isEmpty() ^ true) && !StringExtKt.KClassImpl$Data$declaredNonStaticMembers$2(emptyList, p1);
    }

    private static boolean PlaceComponentResult(Object p0, int p1) {
        String obj;
        Integer intOrNull;
        return p1 < ((p0 == null || (obj = p0.toString()) == null || (intOrNull = StringsKt.toIntOrNull(obj)) == null) ? 0 : intOrNull.intValue());
    }

    @JvmStatic
    public static final KybServiceValidationResult KClassImpl$Data$declaredNonStaticMembers$2(KybServiceModel p0, String p1, int p2) {
        Pair pair;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        KybServiceRedirectValueModel kybServiceRedirectValueModel = p0.MyBillsEntityDataFactory;
        if (kybServiceRedirectValueModel != null) {
            for (KybServiceRuleModel kybServiceRuleModel : kybServiceRedirectValueModel.scheduleImpl) {
                String str = kybServiceRuleModel.BuiltInFictitiousFunctionClassFactory;
                if (Intrinsics.areEqual(str, KybServiceRules.TIERS)) {
                    if (KClassImpl$Data$declaredNonStaticMembers$2(kybServiceRuleModel.PlaceComponentResult, p1)) {
                        pair = TuplesKt.to(Boolean.FALSE, kybServiceRuleModel);
                        break;
                    }
                } else if (Intrinsics.areEqual(str, KybServiceRules.MINIMUM_TRANSACTION) && PlaceComponentResult(kybServiceRuleModel.PlaceComponentResult, p2)) {
                    pair = TuplesKt.to(Boolean.FALSE, kybServiceRuleModel);
                    break;
                }
            }
        }
        pair = TuplesKt.to(Boolean.TRUE, null);
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        KybServiceRuleModel kybServiceRuleModel2 = (KybServiceRuleModel) pair.component2();
        if (booleanValue) {
            KybServiceValidationResult.Companion companion = KybServiceValidationResult.INSTANCE;
            return KybServiceValidationResult.Companion.BuiltInFictitiousFunctionClassFactory();
        }
        String str2 = kybServiceRuleModel2 != null ? kybServiceRuleModel2.BuiltInFictitiousFunctionClassFactory : null;
        return new KybServiceValidationResult(str2 != null ? str2 : "", false, kybServiceRuleModel2 != null ? kybServiceRuleModel2.getAuthRequestContext : null);
    }
}
