package id.dana.kycrenewal;

import dagger.Lazy;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.kycrenewal.interactor.GetKycRenewal;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalButtonClicked;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckDismiss;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckQuery;
import id.dana.domain.kycrenewal.interactor.GetKycRenewalCheckShow;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalButtonClick;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckDismiss;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckQuery;
import id.dana.domain.kycrenewal.interactor.SaveKycRenewalCheckShow;
import id.dana.domain.kycrenewal.model.QueryKYCRenewalStatus;
import id.dana.kycrenewal.KycRenewalContract;
import id.dana.kycrenewal.mapper.KYCRenewalStatusToKYCRenewalStatusModelMapperKt;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 /2\u00020\u0001:\u0001/B\u0095\u0001\b\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020$0\u0014\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u0014\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u0014\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0012¢\u0006\u0004\b\u0005\u0010\u0013R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00180\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020$0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017"}, d2 = {"Lid/dana/kycrenewal/KycRenewalPresenter;", "Lid/dana/kycrenewal/KycRenewalContract$Presenter;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "PlaceComponentResult", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(J)Z", "onDestroy", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalButtonClick$Param;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalButtonClick$Param;", "p1", "(ZJ)V", "", "(I)V", "Ldagger/Lazy;", "Lid/dana/domain/kycrenewal/interactor/GetKycRenewal;", "scheduleImpl", "Ldagger/Lazy;", "Lid/dana/domain/kycrenewal/interactor/GetKycRenewalButtonClicked;", "Lid/dana/domain/kycrenewal/interactor/GetKycRenewalCheckDismiss;", "Lid/dana/domain/kycrenewal/interactor/GetKycRenewalCheckQuery;", "Lid/dana/domain/kycrenewal/interactor/GetKycRenewalCheckShow;", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalButtonClick;", "getErrorConfigVersion", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckDismiss;", "moveToNextValue", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckQuery;", "lookAheadTest", "Lid/dana/domain/kycrenewal/interactor/SaveKycRenewalCheckShow;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/kycrenewal/KycRenewalContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycRenewalPresenter implements KycRenewalContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy<GetKycRenewalCheckShow> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Lazy<GetKycRenewalCheckQuery> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Lazy<GetKycRenewalCheckDismiss> getAuthRequestContext;
    private final Lazy<SaveKycRenewalCheckShow> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Lazy<GetKycRenewalButtonClicked> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Lazy<SaveKycRenewalButtonClick> getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<KycRenewalContract.View> lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final Lazy<SaveKycRenewalCheckQuery> scheduleImpl;
    private final Lazy<SaveKycRenewalCheckDismiss> moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<GetKycRenewal> MyBillsEntityDataFactory;

    @Inject
    public KycRenewalPresenter(Lazy<KycRenewalContract.View> lazy, Lazy<GetKycRenewal> lazy2, Lazy<GetKycRenewalCheckQuery> lazy3, Lazy<SaveKycRenewalCheckQuery> lazy4, Lazy<GetKycRenewalCheckShow> lazy5, Lazy<SaveKycRenewalCheckShow> lazy6, Lazy<GetKycRenewalCheckDismiss> lazy7, Lazy<SaveKycRenewalCheckDismiss> lazy8, Lazy<GetKycRenewalButtonClicked> lazy9, Lazy<SaveKycRenewalButtonClick> lazy10) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        this.lookAheadTest = lazy;
        this.MyBillsEntityDataFactory = lazy2;
        this.BuiltInFictitiousFunctionClassFactory = lazy3;
        this.scheduleImpl = lazy4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy6;
        this.getAuthRequestContext = lazy7;
        this.moveToNextValue = lazy8;
        this.PlaceComponentResult = lazy9;
        this.getErrorConfigVersion = lazy10;
    }

    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1<QueryKYCRenewalStatus, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$checkKycRenewalRequired$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryKYCRenewalStatus queryKYCRenewalStatus) {
                invoke2(queryKYCRenewalStatus);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryKYCRenewalStatus queryKYCRenewalStatus) {
                Lazy lazy;
                long BuiltInFictitiousFunctionClassFactory;
                Lazy lazy2;
                long BuiltInFictitiousFunctionClassFactory2;
                Intrinsics.checkNotNullParameter(queryKYCRenewalStatus, "");
                lazy = KycRenewalPresenter.this.lookAheadTest;
                KycRenewalContract.View view = (KycRenewalContract.View) lazy.get();
                DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                view.getAuthRequestContext(KYCRenewalStatusToKYCRenewalStatusModelMapperKt.getAuthRequestContext(queryKYCRenewalStatus));
                KycRenewalPresenter kycRenewalPresenter = KycRenewalPresenter.this;
                BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                kycRenewalPresenter.scheduleImpl.get().execute(new SaveKycRenewalCheckQuery.Param(BuiltInFictitiousFunctionClassFactory), new Function1<Boolean, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$saveQueryKYCRenewalDialog$1
                    public final void invoke(boolean z) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$saveQueryKYCRenewalDialog$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
                    }
                });
                if (!queryKYCRenewalStatus.getRenewKYC()) {
                    KycRenewalPresenter.this.MyBillsEntityDataFactory(-1);
                    lazy2 = KycRenewalPresenter.this.lookAheadTest;
                    ((KycRenewalContract.View) lazy2.get()).onError("");
                    return;
                }
                KycRenewalPresenter.this.getErrorConfigVersion.get().execute(new SaveKycRenewalButtonClick.Param(false), KycRenewalPresenter$saveKYCRenewalButtonClick$1.INSTANCE, KycRenewalPresenter$saveKYCRenewalButtonClick$2.INSTANCE);
                KycRenewalPresenter.this.PlaceComponentResult();
                KycRenewalPresenter kycRenewalPresenter2 = KycRenewalPresenter.this;
                boolean renewKYC = queryKYCRenewalStatus.getRenewKYC();
                BuiltInFictitiousFunctionClassFactory2 = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                kycRenewalPresenter2.KClassImpl$Data$declaredNonStaticMembers$2(renewKYC, BuiltInFictitiousFunctionClassFactory2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$checkKycRenewalRequired$2
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
                lazy = KycRenewalPresenter.this.lookAheadTest;
                ((KycRenewalContract.View) lazy.get()).onError("");
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, long p1) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new SaveKycRenewalCheckShow.Param(p0, p1), new Function1<Boolean, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$saveShowKYCRenewalDialog$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$saveShowKYCRenewalDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
            }
        });
    }

    public final void PlaceComponentResult() {
        this.getAuthRequestContext.get().execute(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$getKYCRenewalDismissCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Lazy lazy;
                Lazy lazy2;
                if (i <= 0) {
                    lazy2 = KycRenewalPresenter.this.lookAheadTest;
                    ((KycRenewalContract.View) lazy2.get()).KClassImpl$Data$declaredNonStaticMembers$2();
                    return;
                }
                lazy = KycRenewalPresenter.this.lookAheadTest;
                ((KycRenewalContract.View) lazy.get()).PlaceComponentResult();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$getKYCRenewalDismissCount$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
            }
        });
    }

    public final void MyBillsEntityDataFactory(int p0) {
        this.moveToNextValue.get().execute(new SaveKycRenewalCheckDismiss.Param(p0), new Function1<Boolean, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$setKYCRenewalDismissCount$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$setKYCRenewalDismissCount$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
            }
        });
    }

    public final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext.get().execute(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$constructKycRenewalUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Lazy lazy;
                lazy = KycRenewalPresenter.this.lookAheadTest;
                ((KycRenewalContract.View) lazy.get()).PlaceComponentResult(i);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.kycrenewal.KycRenewalPresenter$constructKycRenewalUrl$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.KYC_RENEWAL_TAG, th.getMessage(), th);
            }
        });
    }

    public static SaveKycRenewalButtonClick.Param KClassImpl$Data$declaredNonStaticMembers$2() {
        return new SaveKycRenewalButtonClick.Param(true);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.scheduleImpl.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.moveToNextValue.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.getErrorConfigVersion.get().dispose();
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(long p0) {
        return DateTimeUtil.PlaceComponentResult(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(), p0) == 1;
    }

    public static boolean MyBillsEntityDataFactory(long p0) {
        return DateTimeUtil.PlaceComponentResult(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(), p0) == 0;
    }
}
