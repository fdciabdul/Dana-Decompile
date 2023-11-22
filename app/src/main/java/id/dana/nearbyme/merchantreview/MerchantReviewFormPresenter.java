package id.dana.nearbyme.merchantreview;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.nearbyme.interactor.merchantreview.GetUGCBannerConfig;
import id.dana.domain.nearbyme.interactor.merchantreview.SaveDismissedMerchantReviewForm;
import id.dana.domain.nearbyme.interactor.merchantreview.SaveLastTimeMerchantReviewFormShown;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.nearbyme.merchantreview.MerchantReviewFormContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001#B9\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\u0010¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u0004R\u0014\u0010\r\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\n\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewFormPresenter;", "Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext", "onDestroy", "MyBillsEntityDataFactory", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "", "PlaceComponentResult", "Lid/dana/feeds/domain/activation/interactor/GetFeedStatus;", "Lid/dana/feeds/domain/activation/interactor/GetFeedStatus;", "Lid/dana/domain/nearbyme/interactor/merchantreview/GetUGCBannerConfig;", "Lid/dana/domain/nearbyme/interactor/merchantreview/GetUGCBannerConfig;", "Lid/dana/domain/nearbyme/interactor/merchantreview/SaveDismissedMerchantReviewForm;", "Lid/dana/domain/nearbyme/interactor/merchantreview/SaveDismissedMerchantReviewForm;", "Lid/dana/domain/nearbyme/interactor/merchantreview/SaveLastTimeMerchantReviewFormShown;", "Lid/dana/domain/nearbyme/interactor/merchantreview/SaveLastTimeMerchantReviewFormShown;", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$View;", "lookAheadTest", "Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$View;", "moveToNextValue", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$View;Lid/dana/domain/nearbyme/interactor/merchantreview/SaveLastTimeMerchantReviewFormShown;Lid/dana/domain/nearbyme/interactor/merchantreview/SaveDismissedMerchantReviewForm;Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;Lid/dana/feeds/domain/activation/interactor/GetFeedStatus;Lid/dana/domain/nearbyme/interactor/merchantreview/GetUGCBannerConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewFormPresenter implements MerchantReviewFormContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetFeedStatus PlaceComponentResult;
    private final SaveLastTimeMerchantReviewFormShown KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SaveDismissedMerchantReviewForm BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetUGCBannerConfig MyBillsEntityDataFactory;
    private final SaveShareFeedConsent getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final MerchantReviewFormContract.View moveToNextValue;

    @Inject
    public MerchantReviewFormPresenter(MerchantReviewFormContract.View view, SaveLastTimeMerchantReviewFormShown saveLastTimeMerchantReviewFormShown, SaveDismissedMerchantReviewForm saveDismissedMerchantReviewForm, SaveShareFeedConsent saveShareFeedConsent, GetFeedStatus getFeedStatus, GetUGCBannerConfig getUGCBannerConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(saveLastTimeMerchantReviewFormShown, "");
        Intrinsics.checkNotNullParameter(saveDismissedMerchantReviewForm, "");
        Intrinsics.checkNotNullParameter(saveShareFeedConsent, "");
        Intrinsics.checkNotNullParameter(getFeedStatus, "");
        Intrinsics.checkNotNullParameter(getUGCBannerConfig, "");
        this.moveToNextValue = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = saveLastTimeMerchantReviewFormShown;
        this.BuiltInFictitiousFunctionClassFactory = saveDismissedMerchantReviewForm;
        this.getAuthRequestContext = saveShareFeedConsent;
        this.PlaceComponentResult = getFeedStatus;
        this.MyBillsEntityDataFactory = getUGCBannerConfig;
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewFormContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(Long.valueOf(System.currentTimeMillis()), new Function1<Boolean, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$saveLastTimeMerchantReviewShown$1
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                DanaLog.MyBillsEntityDataFactory("Nearby", "Success save last time merchant review");
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$saveLastTimeMerchantReviewShown$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                String message = exc.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", message != null ? message : "", exc);
            }
        });
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewFormContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(p0, new Function1<Boolean, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$saveMerchantDismissed$1
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                DanaLog.MyBillsEntityDataFactory("Nearby", "Success save dismissed merchant");
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$saveMerchantDismissed$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                String message = exc.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", message != null ? message : "", exc);
            }
        });
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewFormContract.Presenter
    public final void PlaceComponentResult() {
        this.getAuthRequestContext.execute(Boolean.TRUE, new Function1<Unit, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$setShareToFeedConfig$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$setShareToFeedConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SHARE_TO_FEEDS_TAG, exc.getMessage(), exc);
            }
        });
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewFormContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$getFeedStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                MerchantReviewFormContract.View view;
                view = MerchantReviewFormPresenter.this.moveToNextValue;
                view.getAuthRequestContext(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$getFeedStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MerchantReviewFormContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = MerchantReviewFormPresenter.this.moveToNextValue;
                view.getAuthRequestContext(false);
            }
        });
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewFormContract.Presenter
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$getUGCBannerConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                MerchantReviewFormContract.View view;
                Intrinsics.checkNotNullParameter(str, "");
                view = MerchantReviewFormPresenter.this.moveToNextValue;
                view.KClassImpl$Data$declaredNonStaticMembers$2(str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter$getUGCBannerConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                String message = th.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", message != null ? message : "", th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.PlaceComponentResult.dispose();
    }
}
