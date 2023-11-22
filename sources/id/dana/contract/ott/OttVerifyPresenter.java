package id.dana.contract.ott;

import android.content.Context;
import com.google.firebase.perf.metrics.Trace;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.ott.OttVerifyContract;
import id.dana.data.util.NumberUtils;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.ott.OttVerifyResult;
import id.dana.domain.ott.interactor.GetOttVerify;
import id.dana.mapper.OttModelMapperKt;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\t\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0018\u0010\u000b\u001a\u0006*\u00020\u00050\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0012\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015"}, d2 = {"Lid/dana/contract/ott/OttVerifyPresenter;", "Lid/dana/contract/ott/OttVerifyContract$Presenter;", "", "onDestroy", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "getAuthRequestContext", "Lid/dana/domain/ott/interactor/GetOttVerify;", "Lid/dana/domain/ott/interactor/GetOttVerify;", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "PlaceComponentResult", "Ljava/lang/String;", "Lid/dana/contract/ott/OttVerifyContract$View;", "Lid/dana/contract/ott/OttVerifyContract$View;", "p1", "p2", "p3", "<init>", "(Landroid/content/Context;Lid/dana/contract/ott/OttVerifyContract$View;Lid/dana/domain/ott/interactor/GetOttVerify;Lid/dana/domain/account/interactor/GetPhoneNumber;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class OttVerifyPresenter implements OttVerifyContract.Presenter {
    private final GetPhoneNumber BuiltInFictitiousFunctionClassFactory;
    private final GetOttVerify KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final OttVerifyContract.View PlaceComponentResult;

    @Inject
    public OttVerifyPresenter(Context context, OttVerifyContract.View view, GetOttVerify getOttVerify, GetPhoneNumber getPhoneNumber) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getOttVerify, "");
        Intrinsics.checkNotNullParameter(getPhoneNumber, "");
        this.getAuthRequestContext = context;
        this.PlaceComponentResult = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getOttVerify;
        this.BuiltInFictitiousFunctionClassFactory = getPhoneNumber;
        this.MyBillsEntityDataFactory = "OttVerifyPresenter";
    }

    @Override // id.dana.contract.ott.OttVerifyContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<OttVerifyResult>() { // from class: id.dana.contract.ott.OttVerifyPresenter$verifyOttContent$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                OttVerifyContract.View view;
                OttVerifyContract.View view2;
                OttVerifyResult ottVerifyResult = (OttVerifyResult) obj;
                Intrinsics.checkNotNullParameter(ottVerifyResult, "");
                view = OttVerifyPresenter.this.PlaceComponentResult;
                view.KClassImpl$Data$declaredNonStaticMembers$2(OttModelMapperKt.getAuthRequestContext(ottVerifyResult));
                view2 = OttVerifyPresenter.this.PlaceComponentResult;
                view2.dismissProgress();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                OttVerifyContract.View view;
                Context context;
                OttVerifyContract.View view2;
                String str;
                Intrinsics.checkNotNullParameter(p02, "");
                super.onError(p02);
                FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullParameter("deeplink_payment_with_ott", "");
                Trace trace = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get("deeplink_payment_with_ott");
                if (trace != null) {
                    trace.stop();
                }
                view = OttVerifyPresenter.this.PlaceComponentResult;
                context = OttVerifyPresenter.this.getAuthRequestContext;
                view.onError(ErrorUtil.PlaceComponentResult(p02, context));
                view2 = OttVerifyPresenter.this.PlaceComponentResult;
                view2.dismissProgress();
                str = OttVerifyPresenter.this.MyBillsEntityDataFactory;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, p02.getMessage());
            }
        }, p0);
    }

    @Override // id.dana.contract.ott.OttVerifyContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<String>() { // from class: id.dana.contract.ott.OttVerifyPresenter$verifyPhoneNumber$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                OttVerifyContract.View view;
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                String str2 = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().lookAheadTest;
                boolean areEqual = Intrinsics.areEqual(NumberUtils.getClearPhoneNumber(str), NumberUtils.getClearPhoneNumber(str2 != null ? str2 : ""));
                view = OttVerifyPresenter.this.PlaceComponentResult;
                view.MyBillsEntityDataFactory(areEqual);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                str = OttVerifyPresenter.this.MyBillsEntityDataFactory;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, p0.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
