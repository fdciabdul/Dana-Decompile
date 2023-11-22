package id.dana.cashier.presenter;

import android.content.Context;
import dagger.Lazy;
import id.dana.R;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckQrisCardPaymentTncFeature;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0012\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\f\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\f¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00140\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000f"}, d2 = {"Lid/dana/cashier/presenter/CashierUserRelatedPresenter;", "Lid/dana/cashier/CashierUserRelatedContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "MyBillsEntityDataFactory", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/CheckQrisCardPaymentTncFeature;", "PlaceComponentResult", "Ldagger/Lazy;", "Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;", "getAuthRequestContext", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/user/interactor/GetSingleBalance;", "Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey;", "Lid/dana/cashier/CashierUserRelatedContract$View;", "getErrorConfigVersion", "p1", "p2", "p3", "p4", "p5", "<init>", "(Landroid/content/Context;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierUserRelatedPresenter implements CashierUserRelatedContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<GetSingleBalance> getAuthRequestContext;
    private final Lazy<RecordAgreementOnlyAgreementKey> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<CheckQrisCardPaymentTncFeature> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<ConsultAgreementOnlyParamSpaceCodes> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<CashierUserRelatedContract.View> getErrorConfigVersion;

    @Inject
    public CashierUserRelatedPresenter(Context context, Lazy<CashierUserRelatedContract.View> lazy, Lazy<CheckQrisCardPaymentTncFeature> lazy2, Lazy<ConsultAgreementOnlyParamSpaceCodes> lazy3, Lazy<RecordAgreementOnlyAgreementKey> lazy4, Lazy<GetSingleBalance> lazy5) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        this.PlaceComponentResult = context;
        this.getErrorConfigVersion = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
        this.MyBillsEntityDataFactory = lazy4;
        this.getAuthRequestContext = lazy5;
    }

    @Override // id.dana.cashier.CashierUserRelatedContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getErrorConfigVersion.get().showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.cashier.presenter.CashierUserRelatedPresenter$consultAgreementTncCardPayment$1
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
                Lazy lazy;
                Lazy lazy2;
                if (!z) {
                    lazy = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                    ((CashierUserRelatedContract.View) lazy.get()).dismissProgress();
                    lazy2 = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                    ((CashierUserRelatedContract.View) lazy2.get()).PlaceComponentResult((List<AgreementInfo>) null);
                    return;
                }
                CashierUserRelatedPresenter.KClassImpl$Data$declaredNonStaticMembers$2(CashierUserRelatedPresenter.this);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierUserRelatedPresenter$consultAgreementTncCardPayment$2
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
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                ((CashierUserRelatedContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                ((CashierUserRelatedContract.View) lazy2.get()).onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.cashier.CashierUserRelatedContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getErrorConfigVersion.get().showProgress();
        this.MyBillsEntityDataFactory.get().execute(new RecordAgreementOnlyAgreementKey.Params(p0, true), new Function1<Boolean, Unit>() { // from class: id.dana.cashier.presenter.CashierUserRelatedPresenter$recordAgreementTncCardPayment$1
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
                Lazy lazy;
                Lazy lazy2;
                lazy = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                ((CashierUserRelatedContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                ((CashierUserRelatedContract.View) lazy2.get()).PlaceComponentResult(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierUserRelatedPresenter$recordAgreementTncCardPayment$2
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
                Lazy lazy2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                ((CashierUserRelatedContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                CashierUserRelatedContract.View view = (CashierUserRelatedContract.View) lazy2.get();
                context = CashierUserRelatedPresenter.this.PlaceComponentResult;
                view.onError(context.getString(R.string.tnc_card_payment_failed_toast_text));
            }
        });
    }

    @Override // id.dana.cashier.CashierUserRelatedContract.Presenter
    public final void MyBillsEntityDataFactory() {
        GetSingleBalance getSingleBalance = this.getAuthRequestContext.get();
        Intrinsics.checkNotNullExpressionValue(getSingleBalance, "");
        BaseUseCase.execute$default(getSingleBalance, new GetSingleBalance.Param(true), new Function1<CurrencyAmount, Unit>() { // from class: id.dana.cashier.presenter.CashierUserRelatedPresenter$reloadBalance$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CurrencyAmount currencyAmount) {
                Intrinsics.checkNotNullParameter(currencyAmount, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CurrencyAmount currencyAmount) {
                invoke2(currencyAmount);
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.getAuthRequestContext.get().dispose();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final CashierUserRelatedPresenter cashierUserRelatedPresenter) {
        ?? r3 = 0;
        cashierUserRelatedPresenter.BuiltInFictitiousFunctionClassFactory.get().execute(new ConsultAgreementOnlyParamSpaceCodes.Params(CollectionsKt.listOf("qris_card_payment"), r3, 2, r3), new Function1<ConsultAgreementResponse, Unit>() { // from class: id.dana.cashier.presenter.CashierUserRelatedPresenter$consultAgreement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConsultAgreementResponse consultAgreementResponse) {
                invoke2(consultAgreementResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultAgreementResponse consultAgreementResponse) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
                lazy = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                ((CashierUserRelatedContract.View) lazy.get()).dismissProgress();
                if (consultAgreementResponse.getAgreementInfos() == null || !consultAgreementResponse.getNeedUserAgreement()) {
                    lazy2 = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                    ((CashierUserRelatedContract.View) lazy2.get()).PlaceComponentResult((List<AgreementInfo>) null);
                    return;
                }
                lazy3 = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                ((CashierUserRelatedContract.View) lazy3.get()).PlaceComponentResult(consultAgreementResponse.getAgreementInfos());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierUserRelatedPresenter$consultAgreement$2
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
                Lazy lazy2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                ((CashierUserRelatedContract.View) lazy.get()).dismissProgress();
                lazy2 = CashierUserRelatedPresenter.this.getErrorConfigVersion;
                CashierUserRelatedContract.View view = (CashierUserRelatedContract.View) lazy2.get();
                context = CashierUserRelatedPresenter.this.PlaceComponentResult;
                view.onError(context.getString(R.string.tnc_card_payment_failed_toast_text));
            }
        });
    }
}
