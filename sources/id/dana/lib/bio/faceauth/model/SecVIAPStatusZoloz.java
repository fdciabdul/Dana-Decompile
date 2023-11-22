package id.dana.lib.bio.faceauth.model;

import com.alipay.mobile.verifyidentity.base.message.ProductConstants;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/lib/bio/faceauth/model/SecVIAPStatusZoloz;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p0", "p1", "p2", "<init>", "(ZZLjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SecVIAPStatusZoloz {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final boolean MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final boolean getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    public SecVIAPStatusZoloz(boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory = z;
        this.getAuthRequestContext = z2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/lib/bio/faceauth/model/SecVIAPStatusZoloz$Companion;", "", "", "p0", "Lid/dana/lib/bio/faceauth/model/SecVIAPStatusZoloz;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/lib/bio/faceauth/model/SecVIAPStatusZoloz;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static SecVIAPStatusZoloz KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            String str = p0;
            if ((str == null || str.length() == 0) || StringsKt.isBlank(str)) {
                throw new DanaBioException.FaceAuthenticationException("Face enroll state is empty or blank", 100002);
            }
            try {
                JSONObject jSONObject = new JSONObject(p0).getJSONObject(ProductConstants.KEY_PRODUCT_ENV_ZOLOZ).getJSONObject(ProductConstants.KEY_PRODUCT_STATE_ZOLOZ);
                boolean z = jSONObject.getBoolean(MaintenanceBroadcastResult.KEY_VISIBLE);
                boolean z2 = jSONObject.getBoolean("enable");
                String string = jSONObject.getString("verifyId");
                Intrinsics.checkNotNullExpressionValue(string, "");
                return new SecVIAPStatusZoloz(z, z2, string);
            } catch (JSONException unused) {
                throw new DanaBioException.FaceAuthenticationException("Face enroll state failed to parse", 100003);
            }
        }
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        if (!this.MyBillsEntityDataFactory || this.getAuthRequestContext) {
            return false;
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.length() > 0;
    }
}
