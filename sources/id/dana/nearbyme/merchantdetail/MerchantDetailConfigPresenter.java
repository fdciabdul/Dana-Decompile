package id.dana.nearbyme.merchantdetail;

import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailActionConfig;
import id.dana.domain.nearbyme.interactor.GetMerchantDetailPromoConfig;
import id.dana.domain.nearbyme.model.MerchantDetailConfig;
import id.dana.domain.nearbyme.model.MerchantDetailPromoConfig;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDetailPromoConfigModelMapperKt;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailPromoConfigModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0005\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015"}, d2 = {"Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigPresenter;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "", "p0", "", "PlaceComponentResult", "(Z)V", "BuiltInFictitiousFunctionClassFactory", "()V", "onDestroy", "Lid/dana/domain/nearbyme/interactor/GetMerchantDetailActionConfig;", "getAuthRequestContext", "Lid/dana/domain/nearbyme/interactor/GetMerchantDetailActionConfig;", "Lid/dana/domain/nearbyme/interactor/GetMerchantDetailPromoConfig;", "MyBillsEntityDataFactory", "Lid/dana/domain/nearbyme/interactor/GetMerchantDetailPromoConfig;", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "()Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;", "p1", "p2", "<init>", "(Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;Lid/dana/domain/nearbyme/interactor/GetMerchantDetailActionConfig;Lid/dana/domain/nearbyme/interactor/GetMerchantDetailPromoConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class MerchantDetailConfigPresenter implements MerchantDetailConfigContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    MerchantDetailPromoConfigModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MerchantDetailConfigContract.View getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetMerchantDetailPromoConfig BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetMerchantDetailActionConfig PlaceComponentResult;

    @Inject
    public MerchantDetailConfigPresenter(MerchantDetailConfigContract.View view, GetMerchantDetailActionConfig getMerchantDetailActionConfig, GetMerchantDetailPromoConfig getMerchantDetailPromoConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMerchantDetailActionConfig, "");
        Intrinsics.checkNotNullParameter(getMerchantDetailPromoConfig, "");
        this.getAuthRequestContext = view;
        this.PlaceComponentResult = getMerchantDetailActionConfig;
        this.BuiltInFictitiousFunctionClassFactory = getMerchantDetailPromoConfig;
    }

    @Override // id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract.Presenter
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final MerchantDetailPromoConfigModel getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract.Presenter
    public final void PlaceComponentResult(boolean p0) {
        this.PlaceComponentResult.execute(new GetMerchantDetailActionConfig.Params(p0), new Function1<MerchantDetailConfig, Unit>() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter$getActionConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantDetailConfig merchantDetailConfig) {
                invoke2(merchantDetailConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantDetailConfig merchantDetailConfig) {
                MerchantDetailConfigContract.View view;
                Intrinsics.checkNotNullParameter(merchantDetailConfig, "");
                view = MerchantDetailConfigPresenter.this.getAuthRequestContext;
                view.onGetActionConfig(merchantDetailConfig);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter$getActionConfig$2
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
                MerchantDetailConfigContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                view = MerchantDetailConfigPresenter.this.getAuthRequestContext;
                view.onGetActionConfig(new MerchantDetailConfig(false, false, false, false, false, false, false, 127, null));
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.NEARBY_ME_MERCHANT_DETAIL, MerchantDetailConfigPresenter.this.getClass().getName(), exc);
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<MerchantDetailPromoConfig, Unit>() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter$getMerchantDetailPromoConfigModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantDetailPromoConfig merchantDetailPromoConfig) {
                invoke2(merchantDetailPromoConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantDetailPromoConfig merchantDetailPromoConfig) {
                MerchantDetailConfigContract.View view;
                Intrinsics.checkNotNullParameter(merchantDetailPromoConfig, "");
                MerchantDetailPromoConfigModel KClassImpl$Data$declaredNonStaticMembers$2 = MerchantDetailPromoConfigModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(merchantDetailPromoConfig);
                MerchantDetailConfigPresenter merchantDetailConfigPresenter = MerchantDetailConfigPresenter.this;
                merchantDetailConfigPresenter.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
                view = merchantDetailConfigPresenter.getAuthRequestContext;
                view.onGetMerchantDetailPromoConfig(KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailConfigPresenter$getMerchantDetailPromoConfigModel$2
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
                MerchantDetailConfigContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                MerchantDetailConfigPresenter merchantDetailConfigPresenter = MerchantDetailConfigPresenter.this;
                MerchantDetailPromoConfigModel.Companion companion = MerchantDetailPromoConfigModel.INSTANCE;
                merchantDetailConfigPresenter.KClassImpl$Data$declaredNonStaticMembers$2 = MerchantDetailPromoConfigModel.Companion.PlaceComponentResult();
                view = MerchantDetailConfigPresenter.this.getAuthRequestContext;
                MerchantDetailPromoConfigModel.Companion companion2 = MerchantDetailPromoConfigModel.INSTANCE;
                view.onGetMerchantDetailPromoConfig(MerchantDetailPromoConfigModel.Companion.PlaceComponentResult());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
