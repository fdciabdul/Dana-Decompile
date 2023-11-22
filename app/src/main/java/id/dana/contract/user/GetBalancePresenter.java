package id.dana.contract.user;

import dagger.Lazy;
import id.dana.contract.user.GetBalanceContract;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.di.PerActivity;
import id.dana.domain.account.interactor.GetAllBalanceVisibility;
import id.dana.domain.account.interactor.GetBalanceVisibility;
import id.dana.domain.account.interactor.SetBalanceVisibility;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.investment.AccountInvestmentStatus;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import id.dana.domain.investment.model.UserInvestmentInfo;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.domain.user.interactor.GetBalance;
import id.dana.domain.user.interactor.GetDanaHomeBalanceConfig;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.notification.RxNotificationBus;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.utils.BalanceUtil;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes4.dex */
public class GetBalancePresenter implements GetBalanceContract.Presenter {
    final Lazy<GetUserInvestmentSummary> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<SetBalanceVisibility> DatabaseTableConfigUtil;
    private final Lazy<GetBalanceVisibility> GetContactSyncConfig;
    final Lazy<CurrencyAmountModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    final Lazy<GetBalanceContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy<GetSingleBalance> NetworkUserEntityData$$ExternalSyntheticLambda2;
    boolean PlaceComponentResult;
    boolean getAuthRequestContext;
    boolean getErrorConfigVersion;
    private final Lazy<GetDanaHomeBalanceConfig> initRecordTimeStamp;
    private final CompositeDisposable lookAheadTest;
    private final Lazy<GetBalance> moveToNextValue;
    private final Lazy<GetAllBalanceVisibility> scheduleImpl;

    @Inject
    public GetBalancePresenter(Lazy<GetBalanceContract.View> lazy, Lazy<GetBalance> lazy2, Lazy<GetSingleBalance> lazy3, Lazy<CurrencyAmountModelMapper> lazy4, Lazy<GetBalanceVisibility> lazy5, Lazy<SetBalanceVisibility> lazy6, Lazy<GetAllBalanceVisibility> lazy7, Lazy<GetDanaHomeBalanceConfig> lazy8, Lazy<GetUserInvestmentSummary> lazy9) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.lookAheadTest = compositeDisposable;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy;
        this.moveToNextValue = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy4;
        this.GetContactSyncConfig = lazy5;
        this.DatabaseTableConfigUtil = lazy6;
        this.scheduleImpl = lazy7;
        this.initRecordTimeStamp = lazy8;
        this.BuiltInFictitiousFunctionClassFactory = lazy9;
        compositeDisposable.getAuthRequestContext(RxNotificationBus.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.subscribe(new Consumer() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetBalancePresenter getBalancePresenter = GetBalancePresenter.this;
                if (((Boolean) obj).booleanValue()) {
                    getBalancePresenter.PlaceComponentResult(Boolean.TRUE);
                }
            }
        }));
    }

    @Override // id.dana.contract.user.GetBalanceContract.Presenter
    public final void PlaceComponentResult(Boolean bool) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().execute(new GetSingleBalance.Param(bool.booleanValue()), new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetBalancePresenter getBalancePresenter = GetBalancePresenter.this;
                getBalancePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dismissProgress();
                getBalancePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalance(getBalancePresenter.KClassImpl$Data$declaredNonStaticMembers$2.get().apply((CurrencyAmount) obj));
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                GetBalancePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalanceError();
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.contract.user.GetBalanceContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.GetContactSyncConfig.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetBalancePresenter getBalancePresenter = GetBalancePresenter.this;
                Boolean bool = (Boolean) obj;
                getBalancePresenter.getAuthRequestContext = bool.booleanValue();
                getBalancePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalanceState(bool);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    @Override // id.dana.contract.user.GetBalanceContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.scheduleImpl.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetBalancePresenter getBalancePresenter = GetBalancePresenter.this;
                List<Boolean> list = (List) obj;
                getBalancePresenter.getAuthRequestContext = list.get(0).booleanValue();
                getBalancePresenter.PlaceComponentResult = list.get(1).booleanValue();
                getBalancePresenter.getErrorConfigVersion = list.get(2).booleanValue();
                getBalancePresenter.MyBillsEntityDataFactory = list.get(3).booleanValue();
                getBalancePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetAllBalanceState(list);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    @Override // id.dana.contract.user.GetBalanceContract.Presenter
    public final void MyBillsEntityDataFactory(String str) {
        char c;
        boolean z;
        boolean z2;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == 3116762) {
            if (str.equals(AccountEntityRepository.BalanceType.EMAS)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 98526144) {
            if (hashCode == 1928999635 && str.equals(AccountEntityRepository.BalanceType.INVESTMENT)) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("goals")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            z = this.MyBillsEntityDataFactory;
        } else if (c == 1) {
            z = this.PlaceComponentResult;
        } else if (c == 2) {
            z = this.getErrorConfigVersion;
        } else {
            z2 = !this.getAuthRequestContext;
            this.getAuthRequestContext = z2;
            this.DatabaseTableConfigUtil.get().execute(new SetBalanceVisibility.Params(z2, str), new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Boolean bool = (Boolean) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    GetBalancePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onError(((Throwable) obj).getMessage());
                    return Unit.INSTANCE;
                }
            });
        }
        z2 = !z;
        this.DatabaseTableConfigUtil.get().execute(new SetBalanceVisibility.Params(z2, str), new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Boolean bool = (Boolean) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetBalancePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onError(((Throwable) obj).getMessage());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.moveToNextValue.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.lookAheadTest.dispose();
        this.GetContactSyncConfig.get().dispose();
        this.DatabaseTableConfigUtil.get().dispose();
        this.scheduleImpl.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.initRecordTimeStamp.get().dispose();
    }

    @Override // id.dana.contract.user.GetBalanceContract.Presenter
    public final void PlaceComponentResult() {
        this.initRecordTimeStamp.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final GetBalancePresenter getBalancePresenter = GetBalancePresenter.this;
                final DanaHomeBalanceConfigModel danaHomeBalanceConfigModel = (DanaHomeBalanceConfigModel) obj;
                if (!danaHomeBalanceConfigModel.getEnable()) {
                    getBalancePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalanceDanaPlusError();
                } else {
                    getBalancePresenter.BuiltInFictitiousFunctionClassFactory.get().execute(GetUserInvestmentSummary.Params.forDanaPlus(), new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            String str;
                            String str2;
                            GetBalancePresenter getBalancePresenter2 = GetBalancePresenter.this;
                            DanaHomeBalanceConfigModel danaHomeBalanceConfigModel2 = danaHomeBalanceConfigModel;
                            UserInvestmentInfo userInvestmentInfo = (UserInvestmentInfo) obj2;
                            if (userInvestmentInfo.getAccountStatus().equals(AccountInvestmentStatus.INACTIVE)) {
                                getBalancePresenter2.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalanceDanaPlusUnActive(danaHomeBalanceConfigModel2);
                            } else if ((userInvestmentInfo.getAccountStatus().equals(AccountInvestmentStatus.ACTIVE) || userInvestmentInfo.getAccountStatus().equals(AccountInvestmentStatus.PRE_ACTIVE)) && userInvestmentInfo.getAvailableBalance() != null && userInvestmentInfo.getAvailableBalance().getAmount() != null) {
                                Long amount = userInvestmentInfo.getAvailableBalance().getAmount();
                                if (amount.longValue() == 0) {
                                    getBalancePresenter2.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalanceDanaPlusUnActive(danaHomeBalanceConfigModel2);
                                } else {
                                    GetBalanceContract.View view = getBalancePresenter2.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
                                    String KClassImpl$Data$declaredNonStaticMembers$2 = BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(amount.toString());
                                    MultiCurrencyMoneyView totalGainLossAmount = userInvestmentInfo.getTotalGainLossAmount();
                                    if (totalGainLossAmount == null || totalGainLossAmount.getAmount() == null) {
                                        str = "";
                                    } else {
                                        Long amount2 = totalGainLossAmount.getAmount();
                                        if (amount2.longValue() < 0) {
                                            amount2 = Long.valueOf(Math.abs(amount2.longValue()));
                                            str2 = "-";
                                        } else {
                                            str2 = "+";
                                        }
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(str2);
                                        sb.append(BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(amount2.toString()));
                                        str = sb.toString();
                                    }
                                    view.onGetBalanceDanaPlusActive(KClassImpl$Data$declaredNonStaticMembers$2, str, danaHomeBalanceConfigModel2);
                                    getBalancePresenter2.MyBillsEntityDataFactory();
                                }
                            } else {
                                getBalancePresenter2.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalanceDanaPlusError();
                            }
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Throwable th = (Throwable) obj2;
                            GetBalancePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalanceDanaPlusError();
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.user.GetBalancePresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                GetBalancePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().onGetBalanceDanaPlusError();
                return Unit.INSTANCE;
            }
        });
    }
}
