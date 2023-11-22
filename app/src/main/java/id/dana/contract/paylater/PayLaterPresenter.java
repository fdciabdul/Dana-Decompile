package id.dana.contract.paylater;

import dagger.Lazy;
import id.dana.contract.paylater.PayLaterContract;
import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist;
import id.dana.domain.paylater.interactor.GetPayLaterCacheLoanWhitelist;
import id.dana.domain.paylater.interactor.GetPayLaterLoanStatusWhitelist;
import id.dana.domain.paylater.interactor.GetPaylaterRotationDelayTime;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.interactor.SavePaylaterRotationDelayTime;
import id.dana.domain.paylater.interactor.SetPayLaterLoanCache;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.PayLaterLoanWhitelist;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.domain.paylater.util.PayLaterUtil;
import id.dana.model.ThirdPartyService;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0087\u0001\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\"0\u0012\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020!0\u0012\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u000eJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\r\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00190\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010\u0014R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014"}, d2 = {"Lid/dana/contract/paylater/PayLaterPresenter;", "Lid/dana/contract/paylater/PayLaterContract$Presenter;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "", "Lid/dana/model/ThirdPartyService;", "(Ljava/util/List;)V", "Lid/dana/domain/paylater/model/UserLoanInfo;", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/domain/paylater/model/UserLoanInfo;", "getAuthRequestContext", "()V", "onDestroy", "", "(I)V", "Ldagger/Lazy;", "Lid/dana/domain/paylater/interactor/ClearCachePayLaterLoanWhitelist;", "Ldagger/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/paylater/interactor/GetPayLaterCacheLoanWhitelist;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/paylater/interactor/GetPayLaterLoanStatusWhitelist;", "Lid/dana/domain/paylater/interactor/GetPaylaterRotationDelayTime;", "Lid/dana/domain/paylater/interactor/GetUserLoanInfo;", "Lid/dana/domain/paylater/interactor/SavePaylaterRotationDelayTime;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/paylater/interactor/SetPayLaterLoanCache;", "getErrorConfigVersion", "scheduleImpl", "Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache;", "Lid/dana/contract/paylater/PayLaterContract$View;", "moveToNextValue", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class PayLaterPresenter implements PayLaterContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<GetPaylaterRotationDelayTime> getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<GetPayLaterLoanStatusWhitelist> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<GetPayLaterCacheLoanWhitelist> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<PayLaterContract.View> moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<GetUserLoanInfo> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<ClearCachePayLaterLoanWhitelist> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<SetPayLaterLoanCache> scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<SavePaylaterRotationDelayTime> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<UpdatePayLaterLoanCache> getErrorConfigVersion;

    @Inject
    public PayLaterPresenter(Lazy<PayLaterContract.View> lazy, Lazy<ClearCachePayLaterLoanWhitelist> lazy2, Lazy<GetPayLaterCacheLoanWhitelist> lazy3, Lazy<GetUserLoanInfo> lazy4, Lazy<SavePaylaterRotationDelayTime> lazy5, Lazy<GetPaylaterRotationDelayTime> lazy6, Lazy<GetPayLaterLoanStatusWhitelist> lazy7, Lazy<UpdatePayLaterLoanCache> lazy8, Lazy<SetPayLaterLoanCache> lazy9) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        this.moveToNextValue = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy3;
        this.MyBillsEntityDataFactory = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy5;
        this.getAuthRequestContext = lazy6;
        this.PlaceComponentResult = lazy7;
        this.getErrorConfigVersion = lazy8;
        this.scheduleImpl = lazy9;
    }

    @Override // id.dana.contract.paylater.PayLaterContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1<PayLaterLoanWhitelist, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$loadPayLaterLoanCache$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PayLaterLoanWhitelist payLaterLoanWhitelist) {
                invoke2(payLaterLoanWhitelist);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PayLaterLoanWhitelist payLaterLoanWhitelist) {
                Intrinsics.checkNotNullParameter(payLaterLoanWhitelist, "");
                PayLaterPresenter.PlaceComponentResult(PayLaterPresenter.this, payLaterLoanWhitelist);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$loadPayLaterLoanCache$2
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
                lazy = PayLaterPresenter.this.moveToNextValue;
                ((PayLaterContract.View) lazy.get()).MyBillsEntityDataFactory();
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.LOAN_WHITELIST);
                sb.append(Reflection.getOrCreateKotlinClass(PayLaterPresenter.class).getSimpleName());
                sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYLATER_LOAN_CACHE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.contract.paylater.PayLaterContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.getErrorConfigVersion.get().dispose();
        this.getErrorConfigVersion.get().execute(UpdatePayLaterLoanCache.Params.INSTANCE.withBill(), new Function1<PayLaterLoanWhitelist, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$refreshPayLaterLoan$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PayLaterLoanWhitelist payLaterLoanWhitelist) {
                invoke2(payLaterLoanWhitelist);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PayLaterLoanWhitelist payLaterLoanWhitelist) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(payLaterLoanWhitelist, "");
                lazy = PayLaterPresenter.this.moveToNextValue;
                ((PayLaterContract.View) lazy.get()).MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$refreshPayLaterLoan$2
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
                lazy = PayLaterPresenter.this.moveToNextValue;
                ((PayLaterContract.View) lazy.get()).MyBillsEntityDataFactory();
                PayLaterPresenter.this.moveToNextValue.get().getAuthRequestContext();
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.LOAN_WHITELIST);
                sb.append(Reflection.getOrCreateKotlinClass(PayLaterPresenter.class).getSimpleName());
                sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYLATER_LOAN_CACHE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.contract.paylater.PayLaterContract.Presenter
    public final void MyBillsEntityDataFactory(final List<ThirdPartyService> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if ((!p0.isEmpty()) != false && StringsKt.contains((CharSequence) p0.get(0).NetworkUserEntityData$$ExternalSyntheticLambda8, (CharSequence) LoanInfo.SERVICE_PAYLATER, true)) {
            this.PlaceComponentResult.get().dispose();
            this.PlaceComponentResult.get().execute(NoParams.INSTANCE, new Function1<List<? extends LoanStatusWhitelist>, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$composePromotedService$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends LoanStatusWhitelist> list) {
                    invoke2((List<LoanStatusWhitelist>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<LoanStatusWhitelist> list) {
                    Unit unit;
                    Object obj;
                    Lazy lazy;
                    Lazy lazy2;
                    Intrinsics.checkNotNullParameter(list, "");
                    List<ThirdPartyService> list2 = p0;
                    Iterator<T> it = list.iterator();
                    while (true) {
                        unit = null;
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (StringsKt.contains((CharSequence) list2.get(0).NetworkUserEntityData$$ExternalSyntheticLambda8, (CharSequence) ((LoanStatusWhitelist) obj).getType(), true)) {
                            break;
                        }
                    }
                    LoanStatusWhitelist loanStatusWhitelist = (LoanStatusWhitelist) obj;
                    if (loanStatusWhitelist != null) {
                        List<ThirdPartyService> list3 = p0;
                        PayLaterPresenter payLaterPresenter = this;
                        ThirdPartyService thirdPartyService = list3.get(0);
                        Integer dueDays = loanStatusWhitelist.getDueDays();
                        thirdPartyService.readMicros = dueDays != null ? dueDays.intValue() : -1;
                        thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda5 = loanStatusWhitelist.getStatus();
                        thirdPartyService.KClassImpl$Data$declaredNonStaticMembers$2 = Intrinsics.areEqual(loanStatusWhitelist.getAlwaysConsult(), Boolean.TRUE);
                        payLaterPresenter.moveToNextValue.get().getAuthRequestContext();
                        lazy2 = payLaterPresenter.moveToNextValue;
                        ((PayLaterContract.View) lazy2.get()).BuiltInFictitiousFunctionClassFactory(list3);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        PayLaterPresenter payLaterPresenter2 = this;
                        List<ThirdPartyService> list4 = p0;
                        payLaterPresenter2.moveToNextValue.get().getAuthRequestContext();
                        lazy = payLaterPresenter2.moveToNextValue;
                        ((PayLaterContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(list4);
                    }
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$composePromotedService$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    PayLaterPresenter.this.moveToNextValue.get().getAuthRequestContext();
                    lazy = PayLaterPresenter.this.moveToNextValue;
                    ((PayLaterContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(p0);
                }
            });
            return;
        }
        this.moveToNextValue.get().BuiltInFictitiousFunctionClassFactory(p0);
    }

    @Override // id.dana.contract.paylater.PayLaterContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0;
        if (StringsKt.contains((CharSequence) str, (CharSequence) LoanInfo.SERVICE_PAYLATER, true) || StringsKt.contains((CharSequence) str, (CharSequence) LoanInfo.SETTING_PAYLATER, true)) {
            this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$clearCachePayLaterLoanWhitelist$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Lazy lazy;
                    lazy = PayLaterPresenter.this.moveToNextValue;
                    PayLaterContract.View view = (PayLaterContract.View) lazy.get();
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$clearCachePayLaterLoanWhitelist$2
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
                    Intrinsics.checkNotNullParameter(th, "");
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.LOAN_WHITELIST);
                    sb.append(PayLaterPresenter.this.getClass().getName());
                    sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.HOME_TAG, sb.toString(), th);
                }
            });
        }
    }

    @Override // id.dana.contract.paylater.PayLaterContract.Presenter
    public final UserLoanInfo PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.MyBillsEntityDataFactory.get().execute(new GetUserLoanInfo.Params(p0));
    }

    @Override // id.dana.contract.paylater.PayLaterContract.Presenter
    public final void getAuthRequestContext(int p0) {
        if (PayLaterUtil.isCacheExpire$default(PayLaterUtil.INSTANCE, null, null, this.getAuthRequestContext.get().execute(NoParams.INSTANCE).longValue(), p0, 3, null)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
            SavePaylaterRotationDelayTime savePaylaterRotationDelayTime = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
            Intrinsics.checkNotNullExpressionValue(savePaylaterRotationDelayTime, "");
            BaseUseCase.execute$default(savePaylaterRotationDelayTime, 0L, new Function1<Boolean, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$savePaylaterRotationDelayTime$1
                public final void invoke(boolean z) {
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }, null, 4, null);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.scheduleImpl.get().dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(final PayLaterPresenter payLaterPresenter, PayLaterLoanWhitelist payLaterLoanWhitelist) {
        if (payLaterLoanWhitelist.getStatusWhitelist().isEmpty() || payLaterLoanWhitelist.getLoanWhitelist().getLoanInfo().isEmpty()) {
            payLaterPresenter.MyBillsEntityDataFactory();
            return;
        }
        boolean isLoanStatusWhitelistAlwaysConsult = payLaterLoanWhitelist.isLoanStatusWhitelistAlwaysConsult();
        boolean isLoanWhitelisted = payLaterLoanWhitelist.getLoanWhitelist().isLoanWhitelisted();
        boolean z = isLoanWhitelisted && PayLaterUtil.isCacheExpire$default(PayLaterUtil.INSTANCE, payLaterLoanWhitelist.getLoanWhitelist(), payLaterLoanWhitelist.getPaylaterCicilConfig(), 0L, 0, 12, null);
        boolean z2 = isLoanStatusWhitelistAlwaysConsult || (isLoanWhitelisted && z);
        if (!isLoanStatusWhitelistAlwaysConsult && (isLoanWhitelisted && !z)) {
            payLaterPresenter.scheduleImpl.get().dispose();
            payLaterPresenter.scheduleImpl.get().execute(new SetPayLaterLoanCache.Params(payLaterLoanWhitelist), new Function1<PayLaterLoanWhitelist, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$handleSetPayLaterLoanCache$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(PayLaterLoanWhitelist payLaterLoanWhitelist2) {
                    invoke2(payLaterLoanWhitelist2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(PayLaterLoanWhitelist payLaterLoanWhitelist2) {
                    Lazy lazy;
                    Intrinsics.checkNotNullParameter(payLaterLoanWhitelist2, "");
                    lazy = PayLaterPresenter.this.moveToNextValue;
                    ((PayLaterContract.View) lazy.get()).MyBillsEntityDataFactory();
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.paylater.PayLaterPresenter$handleSetPayLaterLoanCache$2
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
                    lazy = PayLaterPresenter.this.moveToNextValue;
                    ((PayLaterContract.View) lazy.get()).MyBillsEntityDataFactory();
                    PayLaterPresenter.this.moveToNextValue.get().getAuthRequestContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.LOAN_WHITELIST);
                    sb.append(Reflection.getOrCreateKotlinClass(PayLaterPresenter.class).getSimpleName());
                    sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYLATER_LOAN_CACHE, sb.toString(), th);
                }
            });
        } else if (z2) {
            payLaterPresenter.MyBillsEntityDataFactory();
        } else {
            payLaterPresenter.moveToNextValue.get().MyBillsEntityDataFactory();
        }
    }
}
