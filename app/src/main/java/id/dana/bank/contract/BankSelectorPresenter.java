package id.dana.bank.contract;

import android.content.Context;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.bank.contract.BankSelectorContract;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.DefaultObserver;
import id.dana.domain.bank.interactor.CheckUserBankExist;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.requestmoney.exception.NameCheckFreezeException;
import id.dana.domain.requestmoney.interactor.GetBankSelectorConfig;
import id.dana.domain.requestmoney.interactor.GetNameCheckCount;
import id.dana.domain.requestmoney.interactor.IsFreezeNameCheck;
import id.dana.domain.requestmoney.interactor.NameCheck;
import id.dana.domain.requestmoney.model.BankSelectorConfig;
import id.dana.domain.requestmoney.model.NameCheckConfig;
import id.dana.domain.sendmoney.model.NameCheckParam;
import id.dana.domain.sendmoney.model.WithdrawNameCheck;
import id.dana.domain.user.CurrencyAmount;
import id.dana.network.exception.NetworkException;
import id.dana.requestmoney.model.BankSelectorConfigModel;
import id.dana.requestmoney.model.BankSelectorConfigModelKt;
import id.dana.sendmoney.mapper.BankModelMapper;
import id.dana.sendmoney.mapper.SendMoneyBankMapper;
import id.dana.sendmoney.model.BankModel;
import id.dana.sendmoney.model.RecipientModelExtKt;
import id.dana.sendmoney.model.WithdrawNameCheckModel;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 72\u00020\u0001:\u00017BY\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020+\u0012\u0006\u0010\u0005\u001a\u00020\u0017\u0012\u0006\u0010-\u001a\u00020)\u0012\u0006\u0010.\u001a\u00020'\u0012\u0006\u0010/\u001a\u00020#\u0012\u0006\u00100\u001a\u00020\u001a\u0012\u0006\u00101\u001a\u00020\u001c\u0012\u0006\u00102\u001a\u00020\u0015\u0012\u0006\u00103\u001a\u00020\u001f\u0012\u0006\u00104\u001a\u00020\u0012¢\u0006\u0004\b5\u00106J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\fJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0013\u0010\u0010\u001a\u00020\u000b*\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0013\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\t\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\u0010\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010$\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010(R\u0014\u0010 \u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010*R\u0011\u0010\u001d\u001a\u00020+X\u0006¢\u0006\u0006\n\u0004\b\t\u0010,"}, d2 = {"Lid/dana/bank/contract/BankSelectorPresenter;", "Lid/dana/bank/contract/BankSelectorContract$Presenter;", "Lid/dana/sendmoney/model/BankModel;", "p0", "Lid/dana/requestmoney/model/BankSelectorConfigModel;", "p1", "", "PlaceComponentResult", "(Lid/dana/sendmoney/model/BankModel;Lid/dana/requestmoney/model/BankSelectorConfigModel;)V", "MyBillsEntityDataFactory", "()V", "", "(Z)V", "(Lid/dana/requestmoney/model/BankSelectorConfigModel;)V", "onDestroy", "", "getAuthRequestContext", "(Ljava/lang/Throwable;)Z", "Lid/dana/sendmoney/mapper/BankModelMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/mapper/BankModelMapper;", "Lid/dana/domain/bank/interactor/CheckUserBankExist;", "Lid/dana/domain/bank/interactor/CheckUserBankExist;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Lid/dana/domain/requestmoney/interactor/GetBankSelectorConfig;", "Lid/dana/domain/requestmoney/interactor/GetBankSelectorConfig;", "Lid/dana/domain/requestmoney/interactor/GetNameCheckCount;", "moveToNextValue", "Lid/dana/domain/requestmoney/interactor/GetNameCheckCount;", "Lid/dana/domain/recentrecipient/interactor/GetRecentRecipient;", "lookAheadTest", "Lid/dana/domain/recentrecipient/interactor/GetRecentRecipient;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/requestmoney/interactor/IsFreezeNameCheck;", "getErrorConfigVersion", "Lid/dana/domain/requestmoney/interactor/IsFreezeNameCheck;", "scheduleImpl", "Lid/dana/domain/requestmoney/interactor/NameCheck;", "Lid/dana/domain/requestmoney/interactor/NameCheck;", "Lid/dana/sendmoney/mapper/SendMoneyBankMapper;", "Lid/dana/sendmoney/mapper/SendMoneyBankMapper;", "Lid/dana/bank/contract/BankSelectorContract$View;", "Lid/dana/bank/contract/BankSelectorContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Lid/dana/bank/contract/BankSelectorContract$View;Landroid/content/Context;Lid/dana/sendmoney/mapper/SendMoneyBankMapper;Lid/dana/domain/requestmoney/interactor/NameCheck;Lid/dana/domain/requestmoney/interactor/IsFreezeNameCheck;Lid/dana/domain/requestmoney/interactor/GetBankSelectorConfig;Lid/dana/domain/requestmoney/interactor/GetNameCheckCount;Lid/dana/domain/bank/interactor/CheckUserBankExist;Lid/dana/domain/recentrecipient/interactor/GetRecentRecipient;Lid/dana/sendmoney/mapper/BankModelMapper;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankSelectorPresenter implements BankSelectorContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final BankModelMapper PlaceComponentResult;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final BankSelectorContract.View moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final NameCheck getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final CheckUserBankExist BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetBankSelectorConfig MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final IsFreezeNameCheck scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetRecentRecipient NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetNameCheckCount getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final SendMoneyBankMapper lookAheadTest;

    @Inject
    public BankSelectorPresenter(BankSelectorContract.View view, Context context, SendMoneyBankMapper sendMoneyBankMapper, NameCheck nameCheck, IsFreezeNameCheck isFreezeNameCheck, GetBankSelectorConfig getBankSelectorConfig, GetNameCheckCount getNameCheckCount, CheckUserBankExist checkUserBankExist, GetRecentRecipient getRecentRecipient, BankModelMapper bankModelMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(sendMoneyBankMapper, "");
        Intrinsics.checkNotNullParameter(nameCheck, "");
        Intrinsics.checkNotNullParameter(isFreezeNameCheck, "");
        Intrinsics.checkNotNullParameter(getBankSelectorConfig, "");
        Intrinsics.checkNotNullParameter(getNameCheckCount, "");
        Intrinsics.checkNotNullParameter(checkUserBankExist, "");
        Intrinsics.checkNotNullParameter(getRecentRecipient, "");
        Intrinsics.checkNotNullParameter(bankModelMapper, "");
        this.moveToNextValue = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.lookAheadTest = sendMoneyBankMapper;
        this.getErrorConfigVersion = nameCheck;
        this.scheduleImpl = isFreezeNameCheck;
        this.MyBillsEntityDataFactory = getBankSelectorConfig;
        this.getAuthRequestContext = getNameCheckCount;
        this.BuiltInFictitiousFunctionClassFactory = checkUserBankExist;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getRecentRecipient;
        this.PlaceComponentResult = bankModelMapper;
    }

    @Override // id.dana.bank.contract.BankSelectorContract.Presenter
    public final void MyBillsEntityDataFactory(final boolean p0) {
        this.moveToNextValue.showProgress();
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<BankSelectorConfig, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BankSelectorConfig bankSelectorConfig) {
                invoke2(bankSelectorConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BankSelectorConfig bankSelectorConfig) {
                BankModelMapper bankModelMapper;
                BankSelectorConfigModel authRequestContext;
                Intrinsics.checkNotNullParameter(bankSelectorConfig, "");
                BankSelectorPresenter.this.moveToNextValue.getAuthRequestContext();
                if (!p0) {
                    BankSelectorPresenter.this.moveToNextValue.dismissProgress();
                    BankSelectorContract.View view = BankSelectorPresenter.this.moveToNextValue;
                    bankModelMapper = BankSelectorPresenter.this.PlaceComponentResult;
                    authRequestContext = BankSelectorConfigModelKt.getAuthRequestContext(bankSelectorConfig, bankModelMapper, null);
                    view.PlaceComponentResult(authRequestContext);
                    return;
                }
                r0.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DefaultObserver<List<? extends RecentRecipient>>() { // from class: id.dana.bank.contract.BankSelectorPresenter$getDefaultBankFromRecent$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj) {
                        BankModelMapper bankModelMapper2;
                        Object obj2;
                        List list = (List) obj;
                        Intrinsics.checkNotNullParameter(list, "");
                        BankSelectorPresenter.this.moveToNextValue.dismissProgress();
                        BankSelectorContract.View view2 = BankSelectorPresenter.this.moveToNextValue;
                        BankSelectorConfig bankSelectorConfig2 = bankSelectorConfig;
                        bankModelMapper2 = BankSelectorPresenter.this.PlaceComponentResult;
                        Iterator it = list.iterator();
                        if (it.hasNext()) {
                            Object next = it.next();
                            if (it.hasNext()) {
                                long lastUpdated = ((RecentRecipient) next).getLastUpdated();
                                do {
                                    Object next2 = it.next();
                                    long lastUpdated2 = ((RecentRecipient) next2).getLastUpdated();
                                    if (lastUpdated < lastUpdated2) {
                                        next = next2;
                                        lastUpdated = lastUpdated2;
                                    }
                                } while (it.hasNext());
                            }
                            obj2 = next;
                        } else {
                            obj2 = null;
                        }
                        view2.PlaceComponentResult(BankSelectorConfigModelKt.getAuthRequestContext(bankSelectorConfig2, bankModelMapper2, (RecentRecipient) obj2));
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p02) {
                        BankModelMapper bankModelMapper2;
                        BankSelectorConfigModel authRequestContext2;
                        Intrinsics.checkNotNullParameter(p02, "");
                        BankSelectorPresenter.this.moveToNextValue.dismissProgress();
                        BankSelectorContract.View view2 = BankSelectorPresenter.this.moveToNextValue;
                        BankSelectorConfig bankSelectorConfig2 = bankSelectorConfig;
                        bankModelMapper2 = BankSelectorPresenter.this.PlaceComponentResult;
                        authRequestContext2 = BankSelectorConfigModelKt.getAuthRequestContext(bankSelectorConfig2, bankModelMapper2, null);
                        view2.PlaceComponentResult(authRequestContext2);
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, p02.getMessage(), p02);
                    }
                }, GetRecentRecipient.Params.forGetRecentRecipient(1, 1, 0));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$init$2
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
                BankSelectorPresenter.this.moveToNextValue.MyBillsEntityDataFactory();
                BankSelectorPresenter.this.moveToNextValue.dismissProgress();
                BankSelectorContract.View view = BankSelectorPresenter.this.moveToNextValue;
                String message = th.getMessage();
                view.KClassImpl$Data$declaredNonStaticMembers$2(message != null ? message : "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    public final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$getNameCheckCount$1
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
                BankSelectorPresenter.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(i);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$getNameCheckCount$2
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
                BankSelectorPresenter.this.moveToNextValue.onError(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getAuthRequestContext(Throwable th) {
        return (th instanceof NetworkException) && Intrinsics.areEqual(((NetworkException) th).getErrorCode(), "AE15112158147646");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getErrorConfigVersion.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.scheduleImpl.dispose();
    }

    @Override // id.dana.bank.contract.BankSelectorContract.Presenter
    public final void PlaceComponentResult(final BankModel p0, final BankSelectorConfigModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        NameCheckConfig nameCheckConfig = new NameCheckConfig(p1.getErrorConfigVersion, p1.PlaceComponentResult, p1.scheduleImpl);
        NameCheckParam nameCheckParam = new NameCheckParam();
        nameCheckParam.setInstId(p0.lookAheadTest);
        nameCheckParam.setCardNo(p0.getAuthRequestContext);
        nameCheckParam.setWithdrawInstLocalName(p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
        nameCheckParam.setWithdrawPayMethod(p0.NetworkUserEntityData$$ExternalSyntheticLambda2);
        nameCheckParam.setWithdrawPayOption(p0.initRecordTimeStamp);
        nameCheckParam.setSenderName(p0.newProxyInstance);
        nameCheckParam.setFundAmount(new CurrencyAmount("10000", "Rp"));
        this.getErrorConfigVersion.execute(new Pair(nameCheckConfig, nameCheckParam), new Function1<WithdrawNameCheck, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$doNameCheck$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(WithdrawNameCheck withdrawNameCheck) {
                invoke2(withdrawNameCheck);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(WithdrawNameCheck withdrawNameCheck) {
                SendMoneyBankMapper unused;
                Intrinsics.checkNotNullParameter(withdrawNameCheck, "");
                BankSelectorPresenter.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
                BankSelectorPresenter.this.MyBillsEntityDataFactory();
                unused = BankSelectorPresenter.this.lookAheadTest;
                final WithdrawNameCheckModel KClassImpl$Data$declaredNonStaticMembers$2 = SendMoneyBankMapper.KClassImpl$Data$declaredNonStaticMembers$2(withdrawNameCheck);
                BankSelectorConfigModel bankSelectorConfigModel = p1;
                final BankSelectorPresenter bankSelectorPresenter = BankSelectorPresenter.this;
                BankModel bankModel = p0;
                if (bankSelectorConfigModel.getLookAheadTest()) {
                    Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                    Intrinsics.checkNotNullParameter(bankModel, "");
                    Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
                    bankSelectorPresenter.BuiltInFictitiousFunctionClassFactory.execute(RecipientModelExtKt.getAuthRequestContext(bankModel, KClassImpl$Data$declaredNonStaticMembers$2), new Function1<Boolean, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$doSavedBankCheck$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            if (z) {
                                BankSelectorPresenter.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
                            } else {
                                BankSelectorPresenter.this.moveToNextValue.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                            }
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$doSavedBankCheck$2
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
                            BankSelectorPresenter.this.moveToNextValue.onError(th.getMessage());
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, th.getMessage(), th);
                        }
                    });
                    return;
                }
                BankSelectorContract.View view = bankSelectorPresenter.moveToNextValue;
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                view.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$doNameCheck$2
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
                boolean authRequestContext;
                Context context;
                Context context2;
                Context context3;
                Context context4;
                Intrinsics.checkNotNullParameter(th, "");
                BankSelectorPresenter.this.MyBillsEntityDataFactory();
                authRequestContext = BankSelectorPresenter.getAuthRequestContext(th);
                if (authRequestContext) {
                    BankSelectorPresenter.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2("");
                    BankSelectorContract.View view = BankSelectorPresenter.this.moveToNextValue;
                    context4 = BankSelectorPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    String string = context4.getString(R.string.request_money_bank_list_error_desc);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    view.MyBillsEntityDataFactory(th, TrackerDataKey.NetworkErrorOperationTypeProperty.WITHDRAW_NAME_CHECK, string);
                } else if (th instanceof NameCheckFreezeException) {
                    BankSelectorPresenter.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(true);
                    BankSelectorContract.View view2 = BankSelectorPresenter.this.moveToNextValue;
                    context3 = BankSelectorPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    String string2 = context3.getString(R.string.request_money_add_bank_name_check_limit_error);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    view2.MyBillsEntityDataFactory(th, TrackerDataKey.NetworkErrorOperationTypeProperty.WITHDRAW_NAME_CHECK, string2);
                } else {
                    BankSelectorContract.View view3 = BankSelectorPresenter.this.moveToNextValue;
                    SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                    UiTextModel uiTextModel = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory;
                    context = BankSelectorPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view3.onError(uiTextModel.asString(context));
                    BankSelectorContract.View view4 = BankSelectorPresenter.this.moveToNextValue;
                    SendMoneyErrorHelper sendMoneyErrorHelper2 = SendMoneyErrorHelper.INSTANCE;
                    UiTextModel uiTextModel2 = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory;
                    context2 = BankSelectorPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view4.MyBillsEntityDataFactory(th, TrackerDataKey.NetworkErrorOperationTypeProperty.WITHDRAW_NAME_CHECK, uiTextModel2.asString(context2));
                }
            }
        });
    }

    @Override // id.dana.bank.contract.BankSelectorContract.Presenter
    public final void MyBillsEntityDataFactory(BankSelectorConfigModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.scheduleImpl.execute(new NameCheckConfig(p0.getErrorConfigVersion, p0.PlaceComponentResult, p0.scheduleImpl), new Function1<Boolean, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$isFreezeNameCheck$1
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
                BankSelectorPresenter.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.bank.contract.BankSelectorPresenter$isFreezeNameCheck$2
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
                BankSelectorPresenter.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2("");
            }
        });
    }
}
