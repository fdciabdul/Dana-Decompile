package id.dana.data.userconsent.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.userconsent.repository.source.UserConsentData;
import id.dana.data.userconsent.repository.source.model.ConsultAgreementResult;
import id.dana.data.userconsent.repository.source.model.FetchScopesResult;
import id.dana.nearbyme.NearbyMePromoType;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/userconsent/repository/source/network/NetworkUserConsentEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/userconsent/repository/source/network/UserConsentFacade;", "Lid/dana/data/userconsent/repository/source/UserConsentData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Landroid/content/Context;", "p0", "Lid/dana/network/rpc/RpcConnector;", "p1", "Lid/dana/utils/concurrent/ThreadExecutor;", "p2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkUserConsentEntityData extends SecureBaseNetwork<UserConsentFacade> implements UserConsentData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<UserConsentFacade> getFacadeClass() {
        return UserConsentFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkUserConsentEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    public static /* synthetic */ ConsultAgreementResult BuiltInFictitiousFunctionClassFactory(List list, Boolean bool, UserConsentFacade userConsentFacade) {
        Intrinsics.checkNotNullParameter(list, "");
        return userConsentFacade.consultAgreement(new ConsultAgreementRequest(list, null, bool));
    }

    public static /* synthetic */ ConsultAgreementResult BuiltInFictitiousFunctionClassFactory(List list, String str, boolean z, String str2, UserConsentFacade userConsentFacade) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        ConsultAgreementRequest consultAgreementRequest = new ConsultAgreementRequest(list, str, null, 4, null);
        Map<String, String> map = consultAgreementRequest.extParams;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("isMiniProgram", String.valueOf(z));
        map.put("SCOPES", str2);
        return userConsentFacade.consultAgreement(consultAgreementRequest);
    }

    public static /* synthetic */ BaseRpcResult PlaceComponentResult(String str, boolean z, UserConsentFacade userConsentFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        return userConsentFacade.recordAgreement(new RecordAgreementRequest(str, z, null));
    }

    public static /* synthetic */ BaseRpcResult getAuthRequestContext(String str, boolean z, String str2, String str3, String str4, String str5, String str6, UserConsentFacade userConsentFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        RecordAgreementRequest recordAgreementRequest = new RecordAgreementRequest(str, z, str2);
        Map<String, String> map = recordAgreementRequest.extParams;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("SCOPES", str3);
        map.put("APP_ID", str4);
        map.put("CLIENT_ID", str5);
        map.put(NearbyMePromoType.LimitType.MERCHANT_ID, str6);
        return userConsentFacade.recordAgreement(recordAgreementRequest);
    }

    public static /* synthetic */ FetchScopesResult KClassImpl$Data$declaredNonStaticMembers$2(String str, UserConsentFacade userConsentFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        return userConsentFacade.fetchScopes(new FetchScopesRequest(str));
    }
}
