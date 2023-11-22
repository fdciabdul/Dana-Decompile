package id.dana.ipg.constant;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/ipg/constant/IpgConstant;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IpgConstant {
    public static final IpgConstant INSTANCE = new IpgConstant();
    private static final String getAuthRequestContext = "ipgPayload";
    private static final String BuiltInFictitiousFunctionClassFactory = "sync_config_%s";

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "config_%s_jkt_consent";

    private IpgConstant() {
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static String BuiltInFictitiousFunctionClassFactory() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "PlaceComponentResult")
    public static String PlaceComponentResult() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
