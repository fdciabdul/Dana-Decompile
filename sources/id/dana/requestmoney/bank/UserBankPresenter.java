package id.dana.requestmoney.bank;

import id.dana.data.bank.UserBankExistException;
import id.dana.domain.bank.interactor.AddUserBank;
import id.dana.domain.bank.interactor.DeleteUserBank;
import id.dana.domain.bank.interactor.GetUserBanks;
import id.dana.domain.bank.interactor.InitRequestMoney;
import id.dana.domain.bank.interactor.SaveUserBanks;
import id.dana.domain.bank.model.RequestMoneyInit;
import id.dana.domain.bank.model.UserBank;
import id.dana.domain.core.usecase.NoParams;
import id.dana.requestmoney.bank.UserBankContract;
import id.dana.requestmoney.model.RequestMoneyInitModelKt;
import id.dana.requestmoney.model.UserBankModel;
import id.dana.requestmoney.model.UserBankModelKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\t\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/requestmoney/bank/UserBankPresenter;", "Lid/dana/requestmoney/bank/UserBankContract$Presenter;", "Lid/dana/requestmoney/model/UserBankModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/requestmoney/model/UserBankModel;)V", "getAuthRequestContext", "()V", "PlaceComponentResult", "onDestroy", "Lid/dana/domain/bank/interactor/AddUserBank;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/bank/interactor/AddUserBank;", "Lid/dana/domain/bank/interactor/DeleteUserBank;", "MyBillsEntityDataFactory", "Lid/dana/domain/bank/interactor/DeleteUserBank;", "Lid/dana/domain/bank/interactor/GetUserBanks;", "Lid/dana/domain/bank/interactor/GetUserBanks;", "Lid/dana/domain/bank/interactor/InitRequestMoney;", "Lid/dana/domain/bank/interactor/InitRequestMoney;", "Lid/dana/domain/bank/interactor/SaveUserBanks;", "Lid/dana/domain/bank/interactor/SaveUserBanks;", "Lid/dana/requestmoney/bank/UserBankContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/requestmoney/bank/UserBankContract$View;", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/requestmoney/bank/UserBankContract$View;Lid/dana/domain/bank/interactor/GetUserBanks;Lid/dana/domain/bank/interactor/SaveUserBanks;Lid/dana/domain/bank/interactor/AddUserBank;Lid/dana/domain/bank/interactor/DeleteUserBank;Lid/dana/domain/bank/interactor/InitRequestMoney;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserBankPresenter implements UserBankContract.Presenter {
    private final InitRequestMoney BuiltInFictitiousFunctionClassFactory;
    private final AddUserBank KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final DeleteUserBank getAuthRequestContext;
    private final UserBankContract.View NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetUserBanks MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SaveUserBanks PlaceComponentResult;

    @Inject
    public UserBankPresenter(UserBankContract.View view, GetUserBanks getUserBanks, SaveUserBanks saveUserBanks, AddUserBank addUserBank, DeleteUserBank deleteUserBank, InitRequestMoney initRequestMoney) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserBanks, "");
        Intrinsics.checkNotNullParameter(saveUserBanks, "");
        Intrinsics.checkNotNullParameter(addUserBank, "");
        Intrinsics.checkNotNullParameter(deleteUserBank, "");
        Intrinsics.checkNotNullParameter(initRequestMoney, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.MyBillsEntityDataFactory = getUserBanks;
        this.PlaceComponentResult = saveUserBanks;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = addUserBank;
        this.getAuthRequestContext = deleteUserBank;
        this.BuiltInFictitiousFunctionClassFactory = initRequestMoney;
    }

    @Override // id.dana.requestmoney.bank.UserBankContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<RequestMoneyInit, Unit>() { // from class: id.dana.requestmoney.bank.UserBankPresenter$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RequestMoneyInit requestMoneyInit) {
                invoke2(requestMoneyInit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RequestMoneyInit requestMoneyInit) {
                UserBankContract.View view;
                Intrinsics.checkNotNullParameter(requestMoneyInit, "");
                view = UserBankPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.getAuthRequestContext(RequestMoneyInitModelKt.MyBillsEntityDataFactory(requestMoneyInit));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.requestmoney.bank.UserBankPresenter$init$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.requestmoney.bank.UserBankContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<List<? extends UserBank>, Unit>() { // from class: id.dana.requestmoney.bank.UserBankPresenter$getSavedUserBanks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserBank> list) {
                invoke2((List<UserBank>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserBank> list) {
                UserBankContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = UserBankPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.getAuthRequestContext(UserBankModelKt.PlaceComponentResult(list));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.requestmoney.bank.UserBankPresenter$getSavedUserBanks$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.requestmoney.bank.UserBankContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(UserBankModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(UserBankModelKt.getAuthRequestContext(p0), new Function1<Boolean, Unit>() { // from class: id.dana.requestmoney.bank.UserBankPresenter$addUserBank$1
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
                UserBankContract.View view;
                view = UserBankPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.requestmoney.bank.UserBankPresenter$addUserBank$2
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
                UserBankContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, th.getMessage(), th);
                if (th instanceof UserBankExistException) {
                    view = UserBankPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view.PlaceComponentResult();
                }
            }
        });
    }

    @Override // id.dana.requestmoney.bank.UserBankContract.Presenter
    public final void getAuthRequestContext(final UserBankModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.execute(UserBankModelKt.getAuthRequestContext(p0), new Function1<Boolean, Unit>() { // from class: id.dana.requestmoney.bank.UserBankPresenter$deleteUserBank$1
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
                UserBankContract.View view;
                view = UserBankPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.BuiltInFictitiousFunctionClassFactory(z, p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.requestmoney.bank.UserBankPresenter$deleteUserBank$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getAuthRequestContext.dispose();
    }
}
