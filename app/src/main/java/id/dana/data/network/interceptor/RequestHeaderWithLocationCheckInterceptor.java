package id.dana.data.network.interceptor;

import android.content.Context;
import android.util.Base64;
import com.alipay.iap.android.lbs.LBSLocation;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.globalnetwork.source.local.UserLocation;
import id.dana.utils.foundation.facede.LbsFacade;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\t\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\r\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/network/interceptor/RequestHeaderWithLocationCheckInterceptor;", "Lid/dana/data/network/interceptor/RequestHeaderInterceptor;", "Lcom/alipay/iap/android/lbs/LBSLocation;", "p0", "", "MyBillsEntityDataFactory", "(Lcom/alipay/iap/android/lbs/LBSLocation;)Z", "Lokhttp3/Request;", "Lokhttp3/Request$Builder;", "p1", "", "(Lokhttp3/Request;Lokhttp3/Request$Builder;)V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/globalnetwork/source/local/UserLocation;", "PlaceComponentResult", "Lid/dana/data/globalnetwork/source/local/UserLocation;", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "p3", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "p4", "<init>", "(Lid/dana/data/foundation/facade/SecurityGuardFacade;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;Lid/dana/data/globalnetwork/source/local/UserLocation;Lid/dana/data/account/repository/source/AccountEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestHeaderWithLocationCheckInterceptor extends RequestHeaderInterceptor {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final UserLocation BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public RequestHeaderWithLocationCheckInterceptor(SecurityGuardFacade securityGuardFacade, ApSecurityFacade apSecurityFacade, Context context, UserLocation userLocation, AccountEntityDataFactory accountEntityDataFactory) {
        super(securityGuardFacade, apSecurityFacade, context, userLocation, accountEntityDataFactory);
        Intrinsics.checkNotNullParameter(securityGuardFacade, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(userLocation, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = userLocation;
    }

    @Override // id.dana.data.network.interceptor.RequestHeaderInterceptor
    protected final void MyBillsEntityDataFactory(Request p0, Request.Builder p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        try {
            LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            if (MyBillsEntityDataFactory(authRequestContext)) {
                JSONObject jSONObject = new JSONObject();
                BuiltInFictitiousFunctionClassFactory(p0.headers(), "X-Location", jSONObject);
                jSONObject.put("latitude", authRequestContext.getLatitude());
                jSONObject.put("longitude", authRequestContext.getLongitude());
                jSONObject.put("updateTime", authRequestContext.getTime());
                jSONObject.put("type", authRequestContext.getType());
                jSONObject.put("status", authRequestContext.getErrorCode());
                jSONObject.put("userCountryCurrent", this.BuiltInFictitiousFunctionClassFactory.getCurrentCountryCode());
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "");
                byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "");
                p1.addHeader("X-Location", Base64.encodeToString(bytes, 2));
            }
        } catch (JSONException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SIGN_CHECK, e.toString());
        }
    }

    private static boolean MyBillsEntityDataFactory(LBSLocation p0) {
        return Math.abs(p0.getLatitude()) <= 90.0d && Math.abs(p0.getLongitude()) <= 180.0d;
    }
}
