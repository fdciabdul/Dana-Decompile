package id.dana.cashier.presenter;

import dagger.Lazy;
import id.dana.cashier.CashierBannerContract;
import id.dana.cashier.domain.interactor.FetchCashierBanner;
import id.dana.cashier.domain.interactor.FetchNpsSurvey;
import id.dana.cashier.domain.interactor.SubmitNpsSurvey;
import id.dana.cashier.domain.model.FetchBannerInfo;
import id.dana.cashier.domain.model.NpsSurveyConsultInfo;
import id.dana.cashier.mapper.FetchBannerModelMapperKt;
import id.dana.cashier.mapper.FetchNpsSurveyModelMapperKt;
import id.dana.cashier.mapper.SubmitNpsSurveyModelRequestMapperKt;
import id.dana.cashier.model.FetchBannerRequestModel;
import id.dana.cashier.model.npssurvey.NpsSurveyRequestModel;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitRequestModel;
import id.dana.cashier.utils.CashierLogExtKt;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BA\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012"}, d2 = {"Lid/dana/cashier/presenter/CashierBannerPresenter;", "Lid/dana/cashier/CashierBannerContract$Presenter;", "Lid/dana/cashier/model/FetchBannerRequestModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/cashier/model/FetchBannerRequestModel;)V", "Lid/dana/cashier/model/npssurvey/NpsSurveyRequestModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/npssurvey/NpsSurveyRequestModel;)V", "onDestroy", "()V", "Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;)V", "Ldagger/Lazy;", "Lid/dana/cashier/domain/interactor/FetchCashierBanner;", "MyBillsEntityDataFactory", "Ldagger/Lazy;", "getAuthRequestContext", "Lid/dana/cashier/domain/interactor/FetchNpsSurvey;", "Lid/dana/cashier/domain/interactor/SubmitNpsSurvey;", "Lid/dana/cashier/CashierBannerContract$View;", "p1", "p2", "p3", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierBannerPresenter implements CashierBannerContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<SubmitNpsSurvey> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<FetchCashierBanner> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<FetchNpsSurvey> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<CashierBannerContract.View> KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public CashierBannerPresenter(Lazy<CashierBannerContract.View> lazy, Lazy<FetchCashierBanner> lazy2, Lazy<FetchNpsSurvey> lazy3, Lazy<SubmitNpsSurvey> lazy4) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.getAuthRequestContext = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.PlaceComponentResult = lazy4;
    }

    @Override // id.dana.cashier.CashierBannerContract.Presenter
    public final void PlaceComponentResult(FetchBannerRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        FetchCashierBanner fetchCashierBanner = this.getAuthRequestContext.get();
        FetchBannerRequestModel.Companion companion = FetchBannerRequestModel.INSTANCE;
        fetchCashierBanner.execute(new FetchCashierBanner.Params(FetchBannerRequestModel.Companion.BuiltInFictitiousFunctionClassFactory(p0)), new Function1<FetchBannerInfo, Unit>() { // from class: id.dana.cashier.presenter.CashierBannerPresenter$fetchBanner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FetchBannerInfo fetchBannerInfo) {
                invoke2(fetchBannerInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FetchBannerInfo fetchBannerInfo) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(fetchBannerInfo, "");
                lazy = CashierBannerPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((CashierBannerContract.View) lazy.get()).getAuthRequestContext(FetchBannerModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(fetchBannerInfo));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierBannerPresenter$fetchBanner$2
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
                lazy = CashierBannerPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((CashierBannerContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2();
                CashierLogExtKt.MyBillsEntityDataFactory(th, DanaLogConstants.Prefix.FETCH_BANNER);
            }
        });
    }

    @Override // id.dana.cashier.CashierBannerContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NpsSurveyRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.get().execute(FetchNpsSurvey.Params.INSTANCE.createFetchNpsSurveyRequest(p0.getAuthRequestContext, p0.MyBillsEntityDataFactory, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.getBuiltInFictitiousFunctionClassFactory()), new Function1<NpsSurveyConsultInfo, Unit>() { // from class: id.dana.cashier.presenter.CashierBannerPresenter$fetchNpsSurvey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(NpsSurveyConsultInfo npsSurveyConsultInfo) {
                invoke2(npsSurveyConsultInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(NpsSurveyConsultInfo npsSurveyConsultInfo) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(npsSurveyConsultInfo, "");
                lazy = CashierBannerPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((CashierBannerContract.View) lazy.get()).PlaceComponentResult(FetchNpsSurveyModelMapperKt.BuiltInFictitiousFunctionClassFactory(npsSurveyConsultInfo));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierBannerPresenter$fetchNpsSurvey$2
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
                lazy = CashierBannerPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((CashierBannerContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory();
                CashierLogExtKt.MyBillsEntityDataFactory(th, DanaLogConstants.Prefix.FETCH_NPS_SURVEY);
            }
        });
    }

    @Override // id.dana.cashier.CashierBannerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(NpsSurveySubmitRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SubmitNpsSurvey submitNpsSurvey = this.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(submitNpsSurvey, "");
        CompletableUseCase.execute$default(submitNpsSurvey, SubmitNpsSurvey.Params.INSTANCE.createNpsSurveySubmitRequest(SubmitNpsSurveyModelRequestMapperKt.PlaceComponentResult(p0)), null, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierBannerPresenter$submitNpsSurvey$1
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
                lazy = CashierBannerPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((CashierBannerContract.View) lazy.get()).onError(th.getMessage());
                CashierLogExtKt.MyBillsEntityDataFactory(th, DanaLogConstants.Prefix.SUBMIT_NPS_SURVEY);
            }
        }, 2, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.PlaceComponentResult.get().dispose();
    }
}
