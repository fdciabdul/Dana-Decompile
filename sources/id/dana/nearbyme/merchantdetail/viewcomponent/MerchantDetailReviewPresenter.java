package id.dana.nearbyme.merchantdetail.viewcomponent;

import id.dana.domain.nearbyme.interactor.GetMerchantReviews;
import id.dana.domain.nearbyme.model.MerchantReviews;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewResultModel;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0015\u0012\u0006\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0014\u0010\b\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\f\u001a\u00020\u000e8\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u0011R\u001a\u0010\u000f\u001a\u00020\u00128\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\b\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewPresenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "p1", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "Lid/dana/domain/nearbyme/interactor/GetMerchantReviews;", "getAuthRequestContext", "Lid/dana/domain/nearbyme/interactor/GetMerchantReviews;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "", "I", "()I", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$View;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$View;Lid/dana/domain/nearbyme/interactor/GetMerchantReviews;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailReviewPresenter implements MerchantDetailReviewContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MerchantDetailReviewContract.View MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    boolean getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetMerchantReviews PlaceComponentResult;

    @Inject
    public MerchantDetailReviewPresenter(MerchantDetailReviewContract.View view, GetMerchantReviews getMerchantReviews) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMerchantReviews, "");
        this.MyBillsEntityDataFactory = view;
        this.PlaceComponentResult = getMerchantReviews;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract.Presenter
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract.Presenter
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract.Presenter
    public final void PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.PlaceComponentResult.execute(new GetMerchantReviews.Param(p0, p1, this.KClassImpl$Data$declaredNonStaticMembers$2, 10, null, 16, null), new Function1<MerchantReviews, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewPresenter$getReview$1
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
                Intrinsics.checkNotNullParameter(merchantReviews, "");
                MerchantDetailReviewPresenter.this.getAuthRequestContext = merchantReviews.getHasMore();
                MerchantDetailReviewPresenter.MyBillsEntityDataFactory(MerchantDetailReviewPresenter.this, NearbyExtensionKt.MyBillsEntityDataFactory(merchantReviews));
                MerchantDetailReviewPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewPresenter$getReview$2
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
                MerchantDetailReviewContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
                view = MerchantDetailReviewPresenter.this.MyBillsEntityDataFactory;
                view.onError(exc.getMessage());
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MerchantDetailReviewPresenter merchantDetailReviewPresenter, MerchantReviewResultModel merchantReviewResultModel) {
        if (merchantDetailReviewPresenter.KClassImpl$Data$declaredNonStaticMembers$2 > 1) {
            merchantDetailReviewPresenter.MyBillsEntityDataFactory.onSuccessLoadMoreReview(merchantReviewResultModel);
        } else {
            merchantDetailReviewPresenter.MyBillsEntityDataFactory.onSuccessGetReviewList(merchantReviewResultModel);
        }
    }
}
