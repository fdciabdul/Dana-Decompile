package id.dana.riskChallenges.data.forgetpassword.source.network;

import android.content.Context;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseSecureRestNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.ResultResponse;
import id.dana.riskChallenges.data.forgetpassword.source.ResetPasswordEntityData;
import id.dana.riskChallenges.data.forgetpassword.source.network.request.ResetPasswordRequest;
import id.dana.riskChallenges.data.forgetpassword.source.network.request.RiskChallengesRequest;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.ResetPasswordResult;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.RiskChallengesResult;
import id.dana.riskChallenges.di.RiskChallengesScope;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@RiskChallengesScope
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B#\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0016\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ=\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/riskChallenges/data/forgetpassword/source/network/NetworkResetPasswordEntityData;", "Lid/dana/network/base/BaseSecureRestNetwork;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/ResetPasswordApi;", "Lid/dana/riskChallenges/data/forgetpassword/source/ResetPasswordEntityData;", "", "p0", "p1", "", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/RiskChallengesResult;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lio/reactivex/Observable;", "p4", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/ResetPasswordResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getAuthRequestContext", "Lid/dana/riskChallenges/data/forgetpassword/source/network/ResetPasswordApi;", "PlaceComponentResult", "Landroid/content/Context;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "<init>", "(Landroid/content/Context;Lid/dana/data/foundation/facade/ApSecurityFacade;Lid/dana/riskChallenges/data/forgetpassword/source/network/ResetPasswordApi;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkResetPasswordEntityData extends BaseSecureRestNetwork<ResetPasswordApi> implements ResetPasswordEntityData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ResetPasswordApi PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkResetPasswordEntityData(Context context, ApSecurityFacade apSecurityFacade, @Named("RESET_PASSWORD_API") ResetPasswordApi resetPasswordApi) {
        super(context, apSecurityFacade);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(resetPasswordApi, "");
        this.PlaceComponentResult = resetPasswordApi;
    }

    public final Observable<RiskChallengesResult> MyBillsEntityDataFactory(final String p0, final String p1, final boolean p2, final boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<RiskChallengesResult> onErrorResumeNext = wrapper(this.PlaceComponentResult, new Function1<ResetPasswordApi, Observable<ResultResponse<RiskChallengesResult>>>() { // from class: id.dana.riskChallenges.data.forgetpassword.source.network.NetworkResetPasswordEntityData$forgetPasswordConsult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<RiskChallengesResult>> invoke(ResetPasswordApi resetPasswordApi) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(resetPasswordApi, "");
                RiskChallengesRequest riskChallengesRequest = new RiskChallengesRequest(p0);
                NetworkResetPasswordEntityData networkResetPasswordEntityData = this;
                boolean z = p2;
                String str = p1;
                boolean z2 = p3;
                generateMobileEnvInfo = networkResetPasswordEntityData.generateMobileEnvInfo();
                Map<String, String> map = generateMobileEnvInfo.extendInfo;
                Intrinsics.checkNotNullExpressionValue(map, "");
                map.put("operationOrigin", "Native");
                Map<String, String> map2 = generateMobileEnvInfo.extendInfo;
                Intrinsics.checkNotNullExpressionValue(map2, "");
                map2.put("isSupportWAOtp", String.valueOf(z));
                if (str != null) {
                    Map<String, String> map3 = generateMobileEnvInfo.extendInfo;
                    Intrinsics.checkNotNullExpressionValue(map3, "");
                    map3.put(NetworkFaceAuthenticationEntityData.PAGE_SOURCE, str);
                }
                Map<String, String> map4 = riskChallengesRequest.extParams;
                Intrinsics.checkNotNullExpressionValue(map4, "");
                map4.put("isPasskeysSupported", String.valueOf(z2));
                riskChallengesRequest.envInfo = generateMobileEnvInfo;
                return resetPasswordApi.KClassImpl$Data$declaredNonStaticMembers$2(riskChallengesRequest);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.riskChallenges.data.forgetpassword.source.network.NetworkResetPasswordEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkResetPasswordEntityData.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    public final Observable<ResetPasswordResult> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1, final String p2, final String p3, final String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Observable<ResetPasswordResult> onErrorResumeNext = wrapper(this.PlaceComponentResult, new Function1<ResetPasswordApi, Observable<ResultResponse<ResetPasswordResult>>>() { // from class: id.dana.riskChallenges.data.forgetpassword.source.network.NetworkResetPasswordEntityData$resetPassword$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<ResetPasswordResult>> invoke(ResetPasswordApi resetPasswordApi) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(resetPasswordApi, "");
                String encrypt = RSAHelper.encrypt(p1, p0);
                Intrinsics.checkNotNullExpressionValue(encrypt, "");
                ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest(encrypt, p2, p3, p4);
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                resetPasswordRequest.envInfo = generateMobileEnvInfo;
                return resetPasswordApi.getAuthRequestContext(resetPasswordRequest);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.riskChallenges.data.forgetpassword.source.network.NetworkResetPasswordEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkResetPasswordEntityData.PlaceComponentResult((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }
}
