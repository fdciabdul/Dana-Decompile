package id.dana.contract.sendmoney;

import id.dana.contract.sendmoney.RecipientContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig;
import id.dana.domain.referralconfig.model.ReferralConfig;
import id.dana.domain.sendmoney.interactor.CheckBelowKitkatDialogX2BFeature;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes4.dex */
public class RecipientPresenter implements RecipientContract.Presenter {
    final RecipientContract.View BuiltInFictitiousFunctionClassFactory;
    private final SaveRecentBank KClassImpl$Data$declaredNonStaticMembers$2;
    private final CheckBelowKitkatDialogX2BFeature MyBillsEntityDataFactory;
    private final GetReferralSendMoneyConfig PlaceComponentResult;
    private final GetSmartFrictionConfig getAuthRequestContext;
    private final SaveRecentGroup getErrorConfigVersion;
    private final SaveRecentContact moveToNextValue;

    @Inject
    public RecipientPresenter(RecipientContract.View view, CheckBelowKitkatDialogX2BFeature checkBelowKitkatDialogX2BFeature, GetReferralSendMoneyConfig getReferralSendMoneyConfig, SaveRecentBank saveRecentBank, SaveRecentContact saveRecentContact, GetSmartFrictionConfig getSmartFrictionConfig, SaveRecentGroup saveRecentGroup) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = checkBelowKitkatDialogX2BFeature;
        this.PlaceComponentResult = getReferralSendMoneyConfig;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = saveRecentBank;
        this.moveToNextValue = saveRecentContact;
        this.getAuthRequestContext = getSmartFrictionConfig;
        this.getErrorConfigVersion = saveRecentGroup;
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.Presenter
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.sendmoney.RecipientPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                RecipientPresenter.this.BuiltInFictitiousFunctionClassFactory.onGetFeatureBelowKitkatConfigSuccess(((Boolean) obj).booleanValue());
            }
        });
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.Presenter
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.execute(new DefaultObserver<ReferralConfig>() { // from class: id.dana.contract.sendmoney.RecipientPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ReferralConfig referralConfig = (ReferralConfig) obj;
                RecipientPresenter.this.BuiltInFictitiousFunctionClassFactory.onFinishCheckReferralSendMoney(referralConfig.isEnabled(), referralConfig.getHowToUrl());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REFERRAL_TAG, sb.toString());
            }
        });
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.sendmoney.RecipientPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                RecipientPresenter.this.BuiltInFictitiousFunctionClassFactory.onGetSmartFrictionConfig((SmartFrictionConfig) obj);
                return null;
            }
        }, new Function1() { // from class: id.dana.contract.sendmoney.RecipientPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecipientPresenter.MyBillsEntityDataFactory((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit MyBillsEntityDataFactory(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("onError: ");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory("Split", sb.toString());
        return null;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
        this.moveToNextValue.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getErrorConfigVersion.dispose();
    }

    @Override // id.dana.contract.sendmoney.RecipientContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, final RecentRecipientModel recentRecipientModel, final boolean z2) {
        if (recentRecipientModel.isLayoutRequested == 4) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.sendmoney.RecipientPresenter.3
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    Boolean bool = (Boolean) obj;
                    if (z2) {
                        RecipientPresenter.this.BuiltInFictitiousFunctionClassFactory.onSuccessRemoveOldFavoriteState(bool.booleanValue());
                    } else {
                        RecipientPresenter.this.BuiltInFictitiousFunctionClassFactory.onSuccessUpdateFavoriteState(bool.booleanValue(), recentRecipientModel);
                    }
                }
            }, SaveRecentBank.Params.forUpdateRecentBank(recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0(), recentRecipientModel.BuiltInFictitiousFunctionClassFactory, recentRecipientModel.getErrorConfigVersion, recentRecipientModel.BuiltInFictitiousFunctionClassFactory(), recentRecipientModel.getAuthRequestContext, recentRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2(), recentRecipientModel.BuiltInFictitiousFunctionClassFactory, recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2, recentRecipientModel.DatabaseTableConfigUtil, recentRecipientModel.initRecordTimeStamp, recentRecipientModel.getAuthRequestContext(), recentRecipientModel.getErrorConfigVersion, recentRecipientModel.MyBillsEntityDataFactory(), recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1, Long.valueOf(recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda0), z));
        } else if (recentRecipientModel.isLayoutRequested == 2) {
            this.moveToNextValue.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.sendmoney.RecipientPresenter.4
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    Boolean bool = (Boolean) obj;
                    if (z2) {
                        RecipientPresenter.this.BuiltInFictitiousFunctionClassFactory.onSuccessRemoveOldFavoriteState(bool.booleanValue());
                    } else {
                        RecipientPresenter.this.BuiltInFictitiousFunctionClassFactory.onSuccessUpdateFavoriteState(bool.booleanValue(), recentRecipientModel);
                    }
                }
            }, SaveRecentContact.Params.forUpdateRecentContact(recentRecipientModel.PlaceComponentResult(), recentRecipientModel.getErrorConfigVersion, recentRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2(), recentRecipientModel.BuiltInFictitiousFunctionClassFactory(), recentRecipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1, z));
        } else if (recentRecipientModel.isLayoutRequested == 7) {
            this.getErrorConfigVersion.execute(SaveRecentGroup.Params.INSTANCE.forUpdateRecentGroup(recentRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2(), recentRecipientModel.PlaceComponentResult(), recentRecipientModel.BuiltInFictitiousFunctionClassFactory(), recentRecipientModel.moveToNextValue != null ? recentRecipientModel.moveToNextValue.intValue() : 0, GroupSendRecipientType.CONTACT, z), new Function1() { // from class: id.dana.contract.sendmoney.RecipientPresenter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    RecipientPresenter recipientPresenter = RecipientPresenter.this;
                    boolean z3 = z2;
                    RecentRecipientModel recentRecipientModel2 = recentRecipientModel;
                    Boolean bool = (Boolean) obj;
                    if (z3) {
                        recipientPresenter.BuiltInFictitiousFunctionClassFactory.onSuccessRemoveOldFavoriteState(bool.booleanValue());
                    } else {
                        recipientPresenter.BuiltInFictitiousFunctionClassFactory.onSuccessUpdateFavoriteState(bool.booleanValue(), recentRecipientModel2);
                    }
                    return Unit.INSTANCE;
                }
            }, new Function1() { // from class: id.dana.contract.sendmoney.RecipientPresenter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Throwable th = (Throwable) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            });
        }
    }
}
