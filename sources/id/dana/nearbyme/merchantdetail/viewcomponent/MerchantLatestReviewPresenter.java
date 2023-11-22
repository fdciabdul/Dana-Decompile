package id.dana.nearbyme.merchantdetail.viewcomponent;

import id.dana.domain.nearbyme.interactor.GetMerchantReviews;
import id.dana.domain.nearbyme.model.MerchantReviews;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\u0006\u0010\u0004\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000f"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewPresenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewContract$Presenter;", "", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "()V", "Lid/dana/domain/nearbyme/interactor/GetMerchantReviews;", "MyBillsEntityDataFactory", "Lid/dana/domain/nearbyme/interactor/GetMerchantReviews;", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewContract$View;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewContract$View;", "<init>", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewContract$View;Lid/dana/domain/nearbyme/interactor/GetMerchantReviews;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantLatestReviewPresenter implements MerchantLatestReviewContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetMerchantReviews getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MerchantLatestReviewContract.View MyBillsEntityDataFactory;

    @Inject
    public MerchantLatestReviewPresenter(MerchantLatestReviewContract.View view, GetMerchantReviews getMerchantReviews) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMerchantReviews, "");
        this.MyBillsEntityDataFactory = view;
        this.getAuthRequestContext = getMerchantReviews;
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.showProgress();
        this.getAuthRequestContext.execute(new GetMerchantReviews.Param(p0, p1, 1, 10, null, 16, null), new Function1<MerchantReviews, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewPresenter$getReview$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantReviews merchantReviews) {
                invoke2(merchantReviews);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantReviews merchantReviews) {
                MerchantLatestReviewContract.View view;
                Intrinsics.checkNotNullParameter(merchantReviews, "");
                view = MerchantLatestReviewPresenter.this.MyBillsEntityDataFactory;
                view.BuiltInFictitiousFunctionClassFactory(NearbyExtensionKt.MyBillsEntityDataFactory(merchantReviews.getReviews()));
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewPresenter$getReview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                MerchantLatestReviewContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
                view = MerchantLatestReviewPresenter.this.MyBillsEntityDataFactory;
                view.onError(exc.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
