package id.dana.data.miniprogram.provider;

import android.app.Application;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.member.MemberInfo;
import com.alipay.iap.android.wallet.acl.member.MemberInfoResult;
import com.alipay.iap.android.wallet.acl.member.MemberInfoScope;
import com.alipay.iap.android.wallet.acl.member.MemberService;
import id.dana.data.account.AccountEntity;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.miniprogram.MiniProgramMapperKt;
import id.dana.data.miniprogram.source.local.MiniProgramPreference;
import id.dana.data.user.UserEntityRepository;
import id.dana.domain.user.MiniProgramUserInfoResponse;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/miniprogram/provider/MemberServiceProvider;", "Lcom/alipay/iap/android/wallet/acl/member/MemberService;", "Lcom/alipay/iap/android/wallet/acl/member/MemberService$MemberInfoFetchStrategy;", "p0", "Lcom/alipay/iap/android/wallet/acl/member/MemberInfoScope;", "p1", "Lcom/alipay/iap/android/wallet/acl/base/APIContext;", "p2", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lcom/alipay/iap/android/wallet/acl/member/MemberInfoResult;", "p3", "", "getMemberInfo", "(Lcom/alipay/iap/android/wallet/acl/member/MemberService$MemberInfoFetchStrategy;Lcom/alipay/iap/android/wallet/acl/member/MemberInfoScope;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "Lid/dana/data/miniprogram/source/local/MiniProgramPreference;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "Lid/dana/data/user/UserEntityRepository;", "PlaceComponentResult", "Lid/dana/data/user/UserEntityRepository;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemberServiceProvider implements MemberService {
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<MiniProgramPreference>() { // from class: id.dana.data.miniprogram.provider.MemberServiceProvider$miniProgramPreference$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MiniProgramPreference invoke() {
            Application applicationContext = GriverEnv.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "");
            return new MiniProgramPreference(applicationContext);
        }
    });

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public UserEntityRepository getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[MemberService.MemberInfoFetchStrategy.values().length];
            iArr[MemberService.MemberInfoFetchStrategy.LOCAL_USER_ID_ONLY.ordinal()] = 1;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(Callback callback, MiniProgramUserInfoResponse miniProgramUserInfoResponse) {
        Intrinsics.checkNotNullParameter(callback, "");
        Intrinsics.checkNotNullExpressionValue(miniProgramUserInfoResponse, "");
        callback.result(new MemberInfoResult(MiniProgramMapperKt.PlaceComponentResult(miniProgramUserInfoResponse)));
    }

    @Override // com.alipay.iap.android.wallet.acl.member.MemberService
    public final void getMemberInfo(MemberService.MemberInfoFetchStrategy p0, MemberInfoScope p1, APIContext p2, final Callback<MemberInfoResult> p3) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        MiniProgramPreference miniProgramPreference = (MiniProgramPreference) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        if (WhenMappings.BuiltInFictitiousFunctionClassFactory[p0.ordinal()] == 1) {
            MemberInfo memberInfo = new MemberInfo();
            AccountEntity account = miniProgramPreference.BuiltInFictitiousFunctionClassFactory.getAccount();
            memberInfo.userId = account != null ? account.getUserId() : null;
            p3.result(new MemberInfoResult(memberInfo));
            return;
        }
        try {
            obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(String.valueOf(((MiniProgramPreference) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext().get(p1 != null ? p1.getAppId() : null)), null), (Class<Object>) GnAuthResult.class);
        } catch (Exception unused) {
            obj = null;
        }
        GnAuthResult gnAuthResult = (GnAuthResult) obj;
        if (gnAuthResult == null) {
            return;
        }
        String clientId = gnAuthResult.getClientId();
        AccountEntity account2 = miniProgramPreference.BuiltInFictitiousFunctionClassFactory.getAccount();
        UserEntityRepository userEntityRepository = this.getAuthRequestContext;
        if (userEntityRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userEntityRepository = null;
        }
        userEntityRepository.getMiniProgramUserInfo(clientId, account2 != null ? account2.getUserId() : null).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.data.miniprogram.provider.MemberServiceProvider$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                MemberServiceProvider.PlaceComponentResult(Callback.this, (MiniProgramUserInfoResponse) obj2);
            }
        }, new Consumer() { // from class: id.dana.data.miniprogram.provider.MemberServiceProvider$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MP_USER_INFO, r1.getMessage(), (Throwable) obj2);
            }
        });
    }
}
