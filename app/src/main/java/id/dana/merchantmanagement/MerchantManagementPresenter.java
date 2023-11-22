package id.dana.merchantmanagement;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.merchantmanagement.interactor.CheckUnbindEligibility;
import id.dana.domain.merchantmanagement.interactor.ConsultUnbind;
import id.dana.domain.merchantmanagement.interactor.GetHomeShoppingBanner;
import id.dana.domain.merchantmanagement.interactor.GetLinkedMerchants;
import id.dana.domain.merchantmanagement.model.LinkedMerchantInfo;
import id.dana.domain.merchantmanagement.model.UnbindConsultInfo;
import id.dana.domain.promotion.Space;
import id.dana.merchantmanagement.MerchantManagementContract;
import id.dana.merchantmanagement.mapper.MerchantManagementModelMapperKt;
import id.dana.merchantmanagement.model.LinkedMerchantModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001a\u0012\u0006\u0010\b\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0014\u0010\u0014\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0014\u0010\u000b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001b"}, d2 = {"Lid/dana/merchantmanagement/MerchantManagementPresenter;", "Lid/dana/merchantmanagement/MerchantManagementContract$Presenter;", "Lid/dana/merchantmanagement/model/LinkedMerchantModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/merchantmanagement/model/LinkedMerchantModel;)V", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/merchantmanagement/model/LinkedMerchantModel;Ljava/lang/String;)V", "PlaceComponentResult", "()V", "", "(I)V", "onDestroy", "Lid/dana/domain/merchantmanagement/interactor/CheckUnbindEligibility;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/merchantmanagement/interactor/CheckUnbindEligibility;", "Lid/dana/domain/merchantmanagement/interactor/ConsultUnbind;", "getAuthRequestContext", "Lid/dana/domain/merchantmanagement/interactor/ConsultUnbind;", "Lid/dana/domain/merchantmanagement/interactor/GetHomeShoppingBanner;", "Lid/dana/domain/merchantmanagement/interactor/GetHomeShoppingBanner;", "Lid/dana/domain/merchantmanagement/interactor/GetLinkedMerchants;", "Lid/dana/domain/merchantmanagement/interactor/GetLinkedMerchants;", "Lid/dana/merchantmanagement/MerchantManagementContract$View;", "Lid/dana/merchantmanagement/MerchantManagementContract$View;", "p2", "p3", "p4", "<init>", "(Lid/dana/merchantmanagement/MerchantManagementContract$View;Lid/dana/domain/merchantmanagement/interactor/GetLinkedMerchants;Lid/dana/domain/merchantmanagement/interactor/GetHomeShoppingBanner;Lid/dana/domain/merchantmanagement/interactor/ConsultUnbind;Lid/dana/domain/merchantmanagement/interactor/CheckUnbindEligibility;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantManagementPresenter implements MerchantManagementContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CheckUnbindEligibility MyBillsEntityDataFactory;
    private GetHomeShoppingBanner KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MerchantManagementContract.View PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetLinkedMerchants getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ConsultUnbind BuiltInFictitiousFunctionClassFactory;

    @Inject
    public MerchantManagementPresenter(MerchantManagementContract.View view, GetLinkedMerchants getLinkedMerchants, GetHomeShoppingBanner getHomeShoppingBanner, ConsultUnbind consultUnbind, CheckUnbindEligibility checkUnbindEligibility) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getLinkedMerchants, "");
        Intrinsics.checkNotNullParameter(getHomeShoppingBanner, "");
        Intrinsics.checkNotNullParameter(consultUnbind, "");
        Intrinsics.checkNotNullParameter(checkUnbindEligibility, "");
        this.PlaceComponentResult = view;
        this.getAuthRequestContext = getLinkedMerchants;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getHomeShoppingBanner;
        this.BuiltInFictitiousFunctionClassFactory = consultUnbind;
        this.MyBillsEntityDataFactory = checkUnbindEligibility;
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        this.PlaceComponentResult.showProgress();
        this.getAuthRequestContext.execute(new GetLinkedMerchants.Params(p0), new Function1<LinkedMerchantInfo, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$getLinkedMerchants$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(LinkedMerchantInfo linkedMerchantInfo) {
                invoke2(linkedMerchantInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LinkedMerchantInfo linkedMerchantInfo) {
                MerchantManagementContract.View view;
                MerchantManagementContract.View view2;
                MerchantManagementContract.View view3;
                Intrinsics.checkNotNullParameter(linkedMerchantInfo, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                if (linkedMerchantInfo.getMerchantList().isEmpty()) {
                    view3 = MerchantManagementPresenter.this.PlaceComponentResult;
                    view3.onLinkedMerchantEmpty();
                    return;
                }
                view2 = MerchantManagementPresenter.this.PlaceComponentResult;
                view2.onSuccessGetMerchantList(MerchantManagementModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(linkedMerchantInfo), linkedMerchantInfo.getTotalPageNumber());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$getLinkedMerchants$2
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
                MerchantManagementContract.View view;
                MerchantManagementContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                view2 = MerchantManagementPresenter.this.PlaceComponentResult;
                view2.onErrorGetMerchantList();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.GET_LINKED_MERCHANTS, DanaLogConstants.ExceptionType.MERCHANT_MANAGEMENT_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.Presenter
    public final void PlaceComponentResult(int p0) {
        this.PlaceComponentResult.showShimmerItem();
        this.getAuthRequestContext.execute(new GetLinkedMerchants.Params(p0), new Function1<LinkedMerchantInfo, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$getMoreLinkedMerchants$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(LinkedMerchantInfo linkedMerchantInfo) {
                invoke2(linkedMerchantInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LinkedMerchantInfo linkedMerchantInfo) {
                MerchantManagementContract.View view;
                MerchantManagementContract.View view2;
                Intrinsics.checkNotNullParameter(linkedMerchantInfo, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.dismissShimmerItem();
                view2 = MerchantManagementPresenter.this.PlaceComponentResult;
                view2.onSuccessGetMoreMerchantList(MerchantManagementModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(linkedMerchantInfo), linkedMerchantInfo.getTotalPageNumber());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$getMoreLinkedMerchants$2
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
                MerchantManagementContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.onErrorGetMoreMerchantList();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.GET_MORE_LINKED_MERCHANTS, DanaLogConstants.ExceptionType.MERCHANT_MANAGEMENT_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.Presenter
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<Space, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$getHomeShoppingBanner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Space space) {
                invoke2(space);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Space space) {
                MerchantManagementContract.View view;
                Intrinsics.checkNotNullParameter(space, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.onSuccessGetBannerList(MerchantManagementModelMapperKt.PlaceComponentResult(space.getCdpContents()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$getHomeShoppingBanner$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MERCHANT_MANAGEMENT, sb.toString());
            }
        });
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final LinkedMerchantModel p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(new ConsultUnbind.Params(p0.BuiltInFictitiousFunctionClassFactory, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.PlaceComponentResult), new Function1<UnbindConsultInfo, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$doUnbindConsult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UnbindConsultInfo unbindConsultInfo) {
                invoke2(unbindConsultInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UnbindConsultInfo unbindConsultInfo) {
                MerchantManagementContract.View view;
                Intrinsics.checkNotNullParameter(unbindConsultInfo, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.onSuccessUnbindConsult(MerchantManagementModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(unbindConsultInfo, p1, p0.NetworkUserEntityData$$ExternalSyntheticLambda2));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$doUnbindConsult$2
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
                MerchantManagementContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.onErrorUnbindConsult();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.CONSULT_UNBIND_MERCHANT, DanaLogConstants.ExceptionType.MERCHANT_MANAGEMENT_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.Presenter
    public final void MyBillsEntityDataFactory(final LinkedMerchantModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.execute(new CheckUnbindEligibility.Params(p0.BuiltInFictitiousFunctionClassFactory, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.PlaceComponentResult), new Function1<String, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$checkUnbindEligibility$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MerchantManagementContract.View view;
                Intrinsics.checkNotNullParameter(str, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.onSuccessCheckUnbindEligibility(p0, str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.merchantmanagement.MerchantManagementPresenter$checkUnbindEligibility$2
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
                MerchantManagementContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = MerchantManagementPresenter.this.PlaceComponentResult;
                view.onErrorCheckUnbindEligibility();
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
