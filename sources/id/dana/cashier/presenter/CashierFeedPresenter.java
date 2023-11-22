package id.dana.cashier.presenter;

import dagger.Lazy;
import id.dana.cashier.CashierFeedContract;
import id.dana.cashier.utils.CashierLogExtKt;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.feeds.domain.share.interactor.GetPreviewActivity;
import id.dana.feeds.domain.share.interactor.SetLastShareFeedRequest;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r"}, d2 = {"Lid/dana/cashier/presenter/CashierFeedPresenter;", "Lid/dana/cashier/CashierFeedContract$Presenter;", "", "onDestroy", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "Ldagger/Lazy;", "Lid/dana/feeds/domain/share/interactor/GetPreviewActivity;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "PlaceComponentResult", "Lid/dana/feeds/domain/share/interactor/SetLastShareFeedRequest;", "Lid/dana/cashier/CashierFeedContract$View;", "p1", "p2", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierFeedPresenter implements CashierFeedContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<GetPreviewActivity> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<CashierFeedContract.View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<SetLastShareFeedRequest> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public CashierFeedPresenter(Lazy<CashierFeedContract.View> lazy, Lazy<GetPreviewActivity> lazy2, Lazy<SetLastShareFeedRequest> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.PlaceComponentResult = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
    }

    @Override // id.dana.cashier.CashierFeedContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.get().execute(new GetPreviewActivity.Params(p0, null, null, null, null, 30, null), new Function1<PreviewActivityData, Unit>() { // from class: id.dana.cashier.presenter.CashierFeedPresenter$previewActivity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PreviewActivityData previewActivityData) {
                invoke2(previewActivityData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PreviewActivityData previewActivityData) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(previewActivityData, "");
                lazy = CashierFeedPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((CashierFeedContract.View) lazy.get()).getAuthRequestContext(previewActivityData);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierFeedPresenter$previewActivity$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierFeedPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((CashierFeedContract.View) lazy.get()).MyBillsEntityDataFactory();
                CashierLogExtKt.MyBillsEntityDataFactory(th, DanaLogConstants.Prefix.PREVIEW_ACTIVITY_PREFIX);
            }
        });
    }

    @Override // id.dana.cashier.CashierFeedContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SetLastShareFeedRequest setLastShareFeedRequest = this.BuiltInFictitiousFunctionClassFactory.get();
        Intrinsics.checkNotNullExpressionValue(setLastShareFeedRequest, "");
        CompletableUseCase.execute$default(setLastShareFeedRequest, p0, null, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierFeedPresenter$setLastShareFeedRequest$1
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierFeedPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((CashierFeedContract.View) lazy.get()).onError(th.getMessage());
                CashierLogExtKt.MyBillsEntityDataFactory(th, DanaLogConstants.Prefix.SHARE_FEED_ACTIVITY_PREFIX);
            }
        }, 2, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}
