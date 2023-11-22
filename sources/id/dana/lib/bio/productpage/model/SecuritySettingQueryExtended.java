package id.dana.lib.bio.productpage.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0011\u0010\u0005\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0011\u0010\u000b\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\t"}, d2 = {"Lid/dana/lib/bio/productpage/model/SecuritySettingQueryExtended;", "", "", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SecuritySettingQueryExtended {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String MyBillsEntityDataFactory;
    final String getAuthRequestContext;

    public SecuritySettingQueryExtended(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = str2;
        this.MyBillsEntityDataFactory = str3;
        this.PlaceComponentResult = true;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/lib/bio/productpage/model/SecuritySettingQueryExtended$Companion;", "", "Lid/dana/lib/bio/productpage/model/SecuritySettingQueryExtended;", "p0", "Lorg/json/JSONObject;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/lib/bio/productpage/model/SecuritySettingQueryExtended;)Lorg/json/JSONObject;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static JSONObject BuiltInFictitiousFunctionClassFactory(SecuritySettingQueryExtended p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", p0.getAuthRequestContext);
            jSONObject.put("isDirect", p0.getPlaceComponentResult());
            jSONObject.put("productCode", p0.MyBillsEntityDataFactory);
            return jSONObject;
        }
    }
}
