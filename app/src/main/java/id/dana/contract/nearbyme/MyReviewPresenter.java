package id.dana.contract.nearbyme;

import dagger.Lazy;
import id.dana.contract.nearbyme.MyReviewContract;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewedMerchantsList;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.nearbyme.model.QueryUserReviews;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewViewHolderModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBA\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00180\n\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00028\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0005\u0010\u0012R\u001a\u0010\u0010\u001a\u00020\u00028\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00130\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0012\u0010\u0017\u001a\u00020\u0015X\u0081\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\r"}, d2 = {"Lid/dana/contract/nearbyme/MyReviewPresenter;", "Lid/dana/contract/nearbyme/MyReviewContract$Presenter;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "MyBillsEntityDataFactory", "onDestroy", "()V", "Ldagger/Lazy;", "Lid/dana/domain/nearbyme/interactor/merchantreview/ConsultMerchantReview;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "PlaceComponentResult", "Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewedMerchantsList;", "getAuthRequestContext", "Z", "()Z", "Lid/dana/nearbyme/mapper/NearbyShopsModelMapper;", "scheduleImpl", "", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/contract/nearbyme/MyReviewContract$View;", "lookAheadTest", "p1", "p2", "p3", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MyReviewPresenter implements MyReviewContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<ConsultMerchantReview> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    boolean getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<GetReviewedMerchantsList> MyBillsEntityDataFactory;
    private final Lazy<MyReviewContract.View> lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<NearbyShopsModelMapper> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public MyReviewPresenter(Lazy<MyReviewContract.View> lazy, Lazy<ConsultMerchantReview> lazy2, Lazy<GetReviewedMerchantsList> lazy3, Lazy<NearbyShopsModelMapper> lazy4) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        this.lookAheadTest = lazy;
        this.PlaceComponentResult = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.BuiltInFictitiousFunctionClassFactory = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    }

    @Override // id.dana.contract.nearbyme.MyReviewContract.Presenter
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // id.dana.contract.nearbyme.MyReviewContract.Presenter
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.contract.nearbyme.MyReviewContract.Presenter
    public final void MyBillsEntityDataFactory(final boolean p0) {
        if (p0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0++;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
        }
        this.PlaceComponentResult.get().execute(new ConsultMerchantReview.Param(null, 0, this.NetworkUserEntityData$$ExternalSyntheticLambda0, 3, null), new Function1<MerchantConsult, Unit>() { // from class: id.dana.contract.nearbyme.MyReviewPresenter$fetchUnreviewedMerchants$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantConsult merchantConsult) {
                invoke2(merchantConsult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantConsult merchantConsult) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(merchantConsult, "");
                MyReviewPresenter.this.getAuthRequestContext = merchantConsult.getHasMore();
                lazy = MyReviewPresenter.this.lookAheadTest;
                MyReviewContract.View view = (MyReviewContract.View) lazy.get();
                MerchantReviewTagModel.Companion companion = MerchantReviewTagModel.INSTANCE;
                List<MerchantReviewTagModel> authRequestContext = MerchantReviewTagModel.Companion.getAuthRequestContext(merchantConsult.getPositiveTags());
                MerchantReviewTagModel.Companion companion2 = MerchantReviewTagModel.INSTANCE;
                view.MyBillsEntityDataFactory(new Pair<>(authRequestContext, MerchantReviewTagModel.Companion.getAuthRequestContext(merchantConsult.getNegativeSentiments())));
                lazy2 = MyReviewPresenter.this.lookAheadTest;
                MyReviewContract.View view2 = (MyReviewContract.View) lazy2.get();
                MerchantConsultReviewViewHolderModel.Companion companion3 = MerchantConsultReviewViewHolderModel.INSTANCE;
                view2.MyBillsEntityDataFactory(MerchantConsultReviewViewHolderModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(MyReviewPresenter.PlaceComponentResult(MyReviewPresenter.this, merchantConsult)));
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.contract.nearbyme.MyReviewPresenter$fetchUnreviewedMerchants$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(exc, "");
                if (p0) {
                    MyReviewPresenter myReviewPresenter = this;
                    myReviewPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0--;
                }
                lazy = this.lookAheadTest;
                ((MyReviewContract.View) lazy.get()).MyBillsEntityDataFactory(CollectionsKt.emptyList());
                DanaLog.BuiltInFictitiousFunctionClassFactory("MyReviewPresenter", String.valueOf(exc.getMessage()), exc);
            }
        });
    }

    @Override // id.dana.contract.nearbyme.MyReviewContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0) {
        int i = 1;
        if (p0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0++;
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
        }
        this.MyBillsEntityDataFactory.get().execute(new GetReviewedMerchantsList.Param(0, this.NetworkUserEntityData$$ExternalSyntheticLambda0, i, null), new Function1<QueryUserReviews, Unit>() { // from class: id.dana.contract.nearbyme.MyReviewPresenter$fetchReviewedMerchantsList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryUserReviews queryUserReviews) {
                invoke2(queryUserReviews);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryUserReviews queryUserReviews) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(queryUserReviews, "");
                MyReviewPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = queryUserReviews.getHasMore();
                lazy = MyReviewPresenter.this.lookAheadTest;
                MyReviewContract.View view = (MyReviewContract.View) lazy.get();
                MerchantReviewModel.Companion companion = MerchantReviewModel.INSTANCE;
                view.KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewModel.Companion.getAuthRequestContext(NearbyExtensionKt.MyBillsEntityDataFactory(queryUserReviews.getReviews())));
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.contract.nearbyme.MyReviewPresenter$fetchReviewedMerchantsList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(exc, "");
                if (p0) {
                    MyReviewPresenter myReviewPresenter = this;
                    myReviewPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0--;
                }
                lazy = this.lookAheadTest;
                ((MyReviewContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(CollectionsKt.emptyList());
                lazy2 = this.lookAheadTest;
                Exception exc2 = exc;
                ((MyReviewContract.View) lazy2.get()).KClassImpl$Data$declaredNonStaticMembers$2(exc2, GetReviewedMerchantsList.GET_REVIEWED_MERCHANT_LIST);
                DanaLog.BuiltInFictitiousFunctionClassFactory("MyReviewPresenter", String.valueOf(exc.getMessage()), exc2);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
    }

    public static final /* synthetic */ List PlaceComponentResult(MyReviewPresenter myReviewPresenter, MerchantConsult merchantConsult) {
        ArrayList arrayList = new ArrayList();
        for (Shop shop : merchantConsult.getShopInfos()) {
            ShopModel PlaceComponentResult = myReviewPresenter.BuiltInFictitiousFunctionClassFactory.get().PlaceComponentResult(shop);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            MerchantReviewTagModel.Companion companion = MerchantReviewTagModel.INSTANCE;
            List<MerchantReviewTagModel> authRequestContext = MerchantReviewTagModel.Companion.getAuthRequestContext(merchantConsult.getPositiveTags());
            MerchantReviewTagModel.Companion companion2 = MerchantReviewTagModel.INSTANCE;
            List<MerchantReviewTagModel> authRequestContext2 = MerchantReviewTagModel.Companion.getAuthRequestContext(merchantConsult.getNegativeSentiments());
            String merchantId = shop.getMerchantId();
            arrayList.add(new MerchantConsultReviewModel(PlaceComponentResult, authRequestContext, authRequestContext2, "Nearby Review List Open", merchantId == null ? "" : merchantId, 0, 32, null));
        }
        return arrayList;
    }
}
