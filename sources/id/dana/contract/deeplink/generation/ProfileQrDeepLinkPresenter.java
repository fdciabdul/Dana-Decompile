package id.dana.contract.deeplink.generation;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.R;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.deeplink.interactor.GenerateProfileQrDeepLink;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@PerActivity
/* loaded from: classes4.dex */
public class ProfileQrDeepLinkPresenter implements GenerateDeepLinkContract.ProfilePresenter {
    private final GenerateDeepLinkContract.ProfileView BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final GenerateProfileQrDeepLink MyBillsEntityDataFactory;
    private final ApiHitTimer getAuthRequestContext;

    @Inject
    public ProfileQrDeepLinkPresenter(Context context, GenerateProfileQrDeepLink generateProfileQrDeepLink, GenerateDeepLinkContract.ProfileView profileView, ApiHitTimer apiHitTimer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = generateProfileQrDeepLink;
        this.BuiltInFictitiousFunctionClassFactory = profileView;
        this.getAuthRequestContext = apiHitTimer;
    }

    @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfilePresenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, boolean z) {
        this.getAuthRequestContext.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        if (TextUtils.isEmpty(str)) {
            this.BuiltInFictitiousFunctionClassFactory.showProgress();
        }
        GenerateProfileQrDeepLink.Params forParams = GenerateProfileQrDeepLink.Params.forParams(str, str2, str3, z);
        StringBuilder sb = new StringBuilder();
        sb.append(DanaLogConstants.Prefix.DEEPLINK_PROFILE_QR);
        sb.append(getClass().getName());
        sb.append("generateProfileQrDeepLink Params ");
        sb.append(forParams.toString());
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
        this.MyBillsEntityDataFactory.execute(new AnonymousClass1(), forParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends DefaultObserver<DeepLink> {
        AnonymousClass1() {
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            DeepLink deepLink = (DeepLink) obj;
            ApiHitTimer apiHitTimer = ProfileQrDeepLinkPresenter.this.getAuthRequestContext;
            Function1 function1 = new Function1() { // from class: id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    ProfileQrDeepLinkPresenter.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory((Long) obj2);
                    return null;
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
            apiHitTimer.PlaceComponentResult = 0L;
            apiHitTimer.getAuthRequestContext = 0L;
            if (!TextUtils.isEmpty(deepLink.getLink())) {
                ProfileQrDeepLinkPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.DEEPLINK_PROFILE_QR);
                sb.append(getClass().getName());
                sb.append("onNext");
                sb.append(deepLink.getLink());
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
                ProfileQrDeepLinkPresenter.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(deepLink.getLink());
                return;
            }
            ProfileQrDeepLinkPresenter.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DanaLogConstants.Prefix.DEEPLINK_PROFILE_QR);
            sb2.append(getClass().getName());
            sb2.append("Retry Deeplink");
            DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb2.toString());
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            ApiHitTimer apiHitTimer = ProfileQrDeepLinkPresenter.this.getAuthRequestContext;
            Function1 function1 = new Function1() { // from class: id.dana.contract.deeplink.generation.ProfileQrDeepLinkPresenter$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    ProfileQrDeepLinkPresenter.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory((Long) obj);
                    return null;
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
            apiHitTimer.PlaceComponentResult = 0L;
            apiHitTimer.getAuthRequestContext = 0L;
            super.onError(th);
            ProfileQrDeepLinkPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
            StringBuilder sb = new StringBuilder();
            sb.append(DanaLogConstants.Prefix.STATIC_QRCODE_PREFIX);
            sb.append(getClass().getName());
            sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), th);
            ProfileQrDeepLinkPresenter.this.BuiltInFictitiousFunctionClassFactory.onError(ProfileQrDeepLinkPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.failed_generate_url));
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
