package id.dana.contract.deeplink.generation;

import android.content.Context;
import id.dana.R;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.deeplink.interactor.GenerateTransferQrDeepLink;
import id.dana.domain.deeplink.model.DeepLink;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import id.dana.utils.DateTimeUtil;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@PerActivity
/* loaded from: classes4.dex */
public class TransferQrDeepLinkPresenter implements GenerateDeepLinkContract.TransferPresenter {
    private final ApiHitTimer KClassImpl$Data$declaredNonStaticMembers$2;
    private final GenerateDeepLinkContract.TransferView MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private final GenerateTransferQrDeepLink getAuthRequestContext;

    @Inject
    public TransferQrDeepLinkPresenter(Context context, GenerateTransferQrDeepLink generateTransferQrDeepLink, GenerateDeepLinkContract.TransferView transferView, ApiHitTimer apiHitTimer) {
        this.PlaceComponentResult = context;
        this.getAuthRequestContext = generateTransferQrDeepLink;
        this.MyBillsEntityDataFactory = transferView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = apiHitTimer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: id.dana.contract.deeplink.generation.TransferQrDeepLinkPresenter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends DefaultObserver<DeepLink> {
        AnonymousClass1() {
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            ApiHitTimer apiHitTimer = TransferQrDeepLinkPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
            Function1 function1 = new Function1() { // from class: id.dana.contract.deeplink.generation.TransferQrDeepLinkPresenter$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    TransferQrDeepLinkPresenter.this.MyBillsEntityDataFactory.getAuthRequestContext((Long) obj2);
                    return null;
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
            apiHitTimer.PlaceComponentResult = 0L;
            apiHitTimer.getAuthRequestContext = 0L;
            TransferQrDeepLinkPresenter.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(((DeepLink) obj).getLink());
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            ApiHitTimer apiHitTimer = TransferQrDeepLinkPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
            Function1 function1 = new Function1() { // from class: id.dana.contract.deeplink.generation.TransferQrDeepLinkPresenter$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    TransferQrDeepLinkPresenter.this.MyBillsEntityDataFactory.getAuthRequestContext((Long) obj);
                    return null;
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
            function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
            apiHitTimer.PlaceComponentResult = 0L;
            apiHitTimer.getAuthRequestContext = 0L;
            super.onError(th);
            TransferQrDeepLinkPresenter.this.MyBillsEntityDataFactory.onError(TransferQrDeepLinkPresenter.this.PlaceComponentResult.getString(R.string.failed_generate_url));
        }
    }

    @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.TransferPresenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        this.getAuthRequestContext.execute(new AnonymousClass1(), GenerateTransferQrDeepLink.Params.forParams(str, str2, str3));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
