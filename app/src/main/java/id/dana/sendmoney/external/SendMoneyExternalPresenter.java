package id.dana.sendmoney.external;

import android.content.Context;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.interactor.GetWithdrawChannelInfoData;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.InitWithdraw;
import id.dana.domain.sendmoney.interactor.IsNeedToShowExternalOnboardingDialog;
import id.dana.domain.sendmoney.interactor.SaveExternalOnboardingDialog;
import id.dana.domain.sendmoney.model.QrisTcicoEntryPointInfo;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.TransferInitParam;
import id.dana.domain.sendmoney.model.WithdrawChannelInfoData;
import id.dana.domain.sendmoney.model.WithdrawInit;
import id.dana.domain.sendmoney.model.WithdrawInitBase;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.sendmoney.TransferType;
import id.dana.sendmoney.external.SendMoneyExternalContract;
import id.dana.sendmoney.mapper.TransferMethod;
import id.dana.sendmoney.mapper.TransferMethodMapper;
import id.dana.sendmoney.mapper.WithdrawInitMethodOptionModelMapper;
import id.dana.sendmoney.model.ExternalWithdrawChannelModel;
import id.dana.sendmoney.model.WithdrawChannelModel;
import id.dana.sendmoney.model.WithdrawChannelModelKt;
import id.dana.sendmoney.model.WithdrawInitChannelOptionModel;
import id.dana.sendmoney.model.WithdrawInitChannelOptionModelKt;
import id.dana.sendmoney.model.WithdrawInitMethodOptionModel;
import id.dana.sendmoney.model.WithdrawMethodOptionModel;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 @2\u00020\u0001:\u0001@BY\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0012\u0012\u0006\u00105\u001a\u00020\u0019\u0012\u0006\u00106\u001a\u00020\u001c\u0012\u0006\u00107\u001a\u00020)\u0012\u0006\u00108\u001a\u00020 \u0012\u0006\u00109\u001a\u00020&\u0012\u0006\u0010:\u001a\u00020\u0014\u0012\u0006\u0010;\u001a\u000202\u0012\u0006\u0010<\u001a\u00020\u0016\u0012\u0006\u0010=\u001a\u00020.¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0005\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\r8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\n\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0010\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001a\u001a\u00020 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R&\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0#j\b\u0012\u0004\u0012\u00020\b`$8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010%R\u0014\u0010!\u001a\u00020&8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\u001d\u001a\u00020)8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0012\u0010*\u001a\u00020,X\u0087\"¢\u0006\u0006\n\u0004\b\u0010\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00101\u001a\u00020\r8\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0014\u0010'\u001a\u0002028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b3\u00104"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyExternalPresenter;", "Lid/dana/sendmoney/external/SendMoneyExternalContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "p0", "getAuthRequestContext", "(Ljava/util/List;)V", "onDestroy", "", "(Z)V", "Z", "MyBillsEntityDataFactory", "()Z", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/sendmoney/interactor/GetWithdrawChannelInfoData;", "moveToNextValue", "Lid/dana/domain/sendmoney/interactor/GetWithdrawChannelInfoData;", "Lid/dana/domain/sendmoney/interactor/InitTransferMoney;", "getErrorConfigVersion", "Lid/dana/domain/sendmoney/interactor/InitTransferMoney;", "Lid/dana/domain/sendmoney/interactor/InitWithdraw;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/sendmoney/interactor/InitWithdraw;", "lookAheadTest", "Lid/dana/domain/sendmoney/interactor/IsNeedToShowExternalOnboardingDialog;", "scheduleImpl", "Lid/dana/domain/sendmoney/interactor/IsNeedToShowExternalOnboardingDialog;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "Lid/dana/domain/sendmoney/interactor/SaveExternalOnboardingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/sendmoney/interactor/SaveExternalOnboardingDialog;", "Lid/dana/sendmoney/mapper/TransferMethodMapper;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/mapper/TransferMethodMapper;", "Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/sendmoney/external/SendMoneyExternalContract$View;", "GetContactSyncConfig", "Lid/dana/sendmoney/external/SendMoneyExternalContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/sendmoney/mapper/WithdrawInitMethodOptionModelMapper;", "initRecordTimeStamp", "Lid/dana/sendmoney/mapper/WithdrawInitMethodOptionModelMapper;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Landroid/content/Context;Lid/dana/domain/sendmoney/interactor/InitTransferMoney;Lid/dana/domain/sendmoney/interactor/InitWithdraw;Lid/dana/sendmoney/mapper/TransferMethodMapper;Lid/dana/domain/sendmoney/interactor/IsNeedToShowExternalOnboardingDialog;Lid/dana/domain/sendmoney/interactor/SaveExternalOnboardingDialog;Lid/dana/domain/user/interactor/GetUserInfoWithKyc;Lid/dana/sendmoney/mapper/WithdrawInitMethodOptionModelMapper;Lid/dana/domain/sendmoney/interactor/GetWithdrawChannelInfoData;Lid/dana/sendmoney/external/SendMoneyExternalContract$View;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyExternalPresenter implements SendMoneyExternalContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final TransferMethodMapper NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final SendMoneyExternalContract.View GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetUserInfoWithKyc MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public UserInfoResponse DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final InitWithdraw lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final SaveExternalOnboardingDialog scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final InitTransferMoney PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final WithdrawInitMethodOptionModelMapper NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private ArrayList<ExternalWithdrawChannelModel> moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetWithdrawChannelInfoData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final IsNeedToShowExternalOnboardingDialog getErrorConfigVersion;

    @Inject
    public SendMoneyExternalPresenter(Context context, InitTransferMoney initTransferMoney, InitWithdraw initWithdraw, TransferMethodMapper transferMethodMapper, IsNeedToShowExternalOnboardingDialog isNeedToShowExternalOnboardingDialog, SaveExternalOnboardingDialog saveExternalOnboardingDialog, GetUserInfoWithKyc getUserInfoWithKyc, WithdrawInitMethodOptionModelMapper withdrawInitMethodOptionModelMapper, GetWithdrawChannelInfoData getWithdrawChannelInfoData, SendMoneyExternalContract.View view) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(initTransferMoney, "");
        Intrinsics.checkNotNullParameter(initWithdraw, "");
        Intrinsics.checkNotNullParameter(transferMethodMapper, "");
        Intrinsics.checkNotNullParameter(isNeedToShowExternalOnboardingDialog, "");
        Intrinsics.checkNotNullParameter(saveExternalOnboardingDialog, "");
        Intrinsics.checkNotNullParameter(getUserInfoWithKyc, "");
        Intrinsics.checkNotNullParameter(withdrawInitMethodOptionModelMapper, "");
        Intrinsics.checkNotNullParameter(getWithdrawChannelInfoData, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = context;
        this.PlaceComponentResult = initTransferMoney;
        this.lookAheadTest = initWithdraw;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = transferMethodMapper;
        this.getErrorConfigVersion = isNeedToShowExternalOnboardingDialog;
        this.scheduleImpl = saveExternalOnboardingDialog;
        this.MyBillsEntityDataFactory = getUserInfoWithKyc;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = withdrawInitMethodOptionModelMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getWithdrawChannelInfoData;
        this.GetContactSyncConfig = view;
        this.moveToNextValue = new ArrayList<>();
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "getErrorConfigVersion")
    /* renamed from: getErrorConfigVersion  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        InitTransferMoney initTransferMoney = this.PlaceComponentResult;
        DefaultObserver<TransferInit> defaultObserver = new DefaultObserver<TransferInit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$getAtmWithdrawOption$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                SendMoneyExternalContract.View view;
                TransferInit transferInit = (TransferInit) obj;
                Intrinsics.checkNotNullParameter(transferInit, "");
                SendMoneyExternalPresenter.this.BuiltInFictitiousFunctionClassFactory = true;
                view = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                view.BuiltInFictitiousFunctionClassFactory();
                SendMoneyExternalPresenter.MyBillsEntityDataFactory(SendMoneyExternalPresenter.this, transferInit);
                SendMoneyExternalPresenter.BuiltInFictitiousFunctionClassFactory(SendMoneyExternalPresenter.this, transferInit);
                SendMoneyExternalPresenter.getAuthRequestContext(SendMoneyExternalPresenter.this, transferInit);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Context context;
                SendMoneyExternalContract.View view;
                SendMoneyExternalContract.View view2;
                Intrinsics.checkNotNullParameter(p0, "");
                SendMoneyExternalPresenter.this.BuiltInFictitiousFunctionClassFactory = true;
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, p0.getMessage(), p0);
                SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(p0).BuiltInFictitiousFunctionClassFactory;
                context = SendMoneyExternalPresenter.this.getAuthRequestContext;
                String asString = uiTextModel.asString(context);
                view = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                view.onError(asString);
                view2 = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                view2.PlaceComponentResult(TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_INIT, asString, TrackerDataKey.Source.SEND_AND_WITHDRAW_CASH, p0);
            }
        };
        TransferInitParam transferInitParam = new TransferInitParam();
        transferInitParam.setNeedPayMethod(true);
        transferInitParam.setNeedTransferMethod(true);
        transferInitParam.setNeedWithdrawMethod(true);
        initTransferMoney.execute(defaultObserver, InitTransferMoney.Params.forSendMoneyInit(transferInitParam));
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.Presenter
    public final void getAuthRequestContext() {
        this.getErrorConfigVersion.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$isNeedToShowOnboardingDialog$1
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
                SendMoneyExternalContract.View view;
                view = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                view.BuiltInFictitiousFunctionClassFactory(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$isNeedToShowOnboardingDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.Presenter
    public final void PlaceComponentResult(boolean p0) {
        this.scheduleImpl.execute(new SaveExternalOnboardingDialog.Param(p0), new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$saveStateShowOnboardingDialog$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$saveStateShowOnboardingDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.Presenter
    public final void PlaceComponentResult() {
        this.lookAheadTest.execute(new InitWithdraw.Param(false, "OTC"), new Function1<WithdrawInit, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$getOutletWithdrawOption$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(WithdrawInit withdrawInit) {
                invoke2(withdrawInit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(WithdrawInit withdrawInit) {
                SendMoneyExternalContract.View view;
                WithdrawInitMethodOptionModelMapper withdrawInitMethodOptionModelMapper;
                Object obj;
                SendMoneyExternalContract.View view2;
                List<WithdrawInitChannelOptionModel> list;
                Intrinsics.checkNotNullParameter(withdrawInit, "");
                SendMoneyExternalPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                view = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
                List<WithdrawInitBase> withdrawMethodViewList = withdrawInit.getWithdrawMethodViewList();
                if (withdrawMethodViewList != null) {
                    SendMoneyExternalPresenter sendMoneyExternalPresenter = SendMoneyExternalPresenter.this;
                    for (WithdrawInitBase withdrawInitBase : withdrawMethodViewList) {
                        withdrawInitMethodOptionModelMapper = sendMoneyExternalPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        List<? extends WithdrawInitMethodOptionModel> apply = withdrawInitMethodOptionModelMapper.apply(withdrawInitBase.getWithdrawMethodViews());
                        Intrinsics.checkNotNullExpressionValue(apply, "");
                        Iterator<T> it = apply.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (Intrinsics.areEqual(((WithdrawInitMethodOptionModel) obj).PlaceComponentResult, "WITHDRAW_OTC")) {
                                break;
                            }
                        }
                        WithdrawInitMethodOptionModel withdrawInitMethodOptionModel = (WithdrawInitMethodOptionModel) obj;
                        if (withdrawInitMethodOptionModel != null && (list = withdrawInitMethodOptionModel.BuiltInFictitiousFunctionClassFactory) != null) {
                            sendMoneyExternalPresenter.getAuthRequestContext(SendMoneyExternalPresenter.BuiltInFictitiousFunctionClassFactory(sendMoneyExternalPresenter, WithdrawInitChannelOptionModelKt.MyBillsEntityDataFactory(list)));
                        }
                        view2 = sendMoneyExternalPresenter.GetContactSyncConfig;
                        view2.dismissProgress();
                    }
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$getOutletWithdrawOption$2
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
                Context context;
                SendMoneyExternalContract.View view;
                SendMoneyExternalContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                SendMoneyExternalPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, th.getMessage(), th);
                SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory;
                context = SendMoneyExternalPresenter.this.getAuthRequestContext;
                String asString = uiTextModel.asString(context);
                view = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                view.onError(asString);
                view2 = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                view2.PlaceComponentResult(TrackerDataKey.NetworkErrorOperationTypeProperty.WITHDRAW_INIT, asString, TrackerDataKey.Source.SEND_AND_WITHDRAW_CASH, th);
            }
        });
    }

    @Override // id.dana.sendmoney.external.SendMoneyExternalContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.GetContactSyncConfig.showProgress();
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$getUserKycStatus$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                SendMoneyExternalPresenter sendMoneyExternalPresenter = SendMoneyExternalPresenter.this;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                sendMoneyExternalPresenter.DatabaseTableConfigUtil = userInfoResponse;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onComplete() {
                SendMoneyExternalContract.View view;
                view = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                UserInfoResponse userInfoResponse = SendMoneyExternalPresenter.this.DatabaseTableConfigUtil;
                if (userInfoResponse == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    userInfoResponse = null;
                }
                view.MyBillsEntityDataFactory(userInfoResponse.isKycCertified());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                SendMoneyExternalContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, p0.getMessage(), p0);
                view = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                context = SendMoneyExternalPresenter.this.getAuthRequestContext;
                view.onError(ErrorUtil.BuiltInFictitiousFunctionClassFactory(context));
            }
        }, GetUserInfoWithKyc.Params.forParams(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(final List<ExternalWithdrawChannelModel> p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<List<? extends WithdrawChannelInfoData>, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$getWithdrawChannelInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends WithdrawChannelInfoData> list) {
                invoke2((List<WithdrawChannelInfoData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<WithdrawChannelInfoData> list) {
                SendMoneyExternalContract.View view;
                Object obj;
                SendMoneyExternalContract.View view2;
                SendMoneyExternalContract.View view3;
                SendMoneyExternalContract.View view4;
                Intrinsics.checkNotNullParameter(list, "");
                if (SendMoneyExternalPresenter.this.getBuiltInFictitiousFunctionClassFactory() && SendMoneyExternalPresenter.this.getNetworkUserEntityData$$ExternalSyntheticLambda2()) {
                    SendMoneyExternalPresenter.this.BuiltInFictitiousFunctionClassFactory = false;
                    SendMoneyExternalPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
                    view4 = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                    view4.PlaceComponentResult();
                }
                if (Intrinsics.areEqual(p0.get(0).lookAheadTest, "WITHDRAW_OTC")) {
                    view3 = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                    view3.MyBillsEntityDataFactory(SendMoneyExternalPresenter.BuiltInFictitiousFunctionClassFactory(p0, list));
                } else {
                    view = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                    view.getAuthRequestContext(SendMoneyExternalPresenter.BuiltInFictitiousFunctionClassFactory(p0, list));
                }
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((WithdrawChannelInfoData) obj).getInstId(), "QRIS")) {
                        break;
                    }
                }
                WithdrawChannelInfoData withdrawChannelInfoData = (WithdrawChannelInfoData) obj;
                if (withdrawChannelInfoData != null) {
                    view2 = SendMoneyExternalPresenter.this.GetContactSyncConfig;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2(withdrawChannelInfoData);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalPresenter$getWithdrawChannelInfo$2
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
                SendMoneyExternalContract.View view;
                SendMoneyExternalContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                if (Intrinsics.areEqual(p0.get(0).lookAheadTest, "WITHDRAW_OTC")) {
                    view2 = this.GetContactSyncConfig;
                    view2.MyBillsEntityDataFactory(p0);
                } else {
                    view = this.GetContactSyncConfig;
                    view.getAuthRequestContext(p0);
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.getErrorConfigVersion.dispose();
        this.scheduleImpl.dispose();
        this.lookAheadTest.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(SendMoneyExternalPresenter sendMoneyExternalPresenter, TransferInit transferInit) {
        Object obj;
        Object obj2;
        List<WithdrawMethodOptionModel> list;
        List<WithdrawChannelModel> list2;
        List<TransferMethod> apply = sendMoneyExternalPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.apply(transferInit);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        Iterator<T> it = apply.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual(((TransferMethod) obj2).MyBillsEntityDataFactory, TransferType.ATM_TRANSFER)) {
                break;
            }
        }
        TransferMethod transferMethod = (TransferMethod) obj2;
        if (transferMethod == null || (list = transferMethod.scheduleImpl) == null) {
            return;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.areEqual(((WithdrawMethodOptionModel) next).MyBillsEntityDataFactory, "WITHDRAW_ATM")) {
                obj = next;
                break;
            }
        }
        WithdrawMethodOptionModel withdrawMethodOptionModel = (WithdrawMethodOptionModel) obj;
        if (withdrawMethodOptionModel == null || (list2 = withdrawMethodOptionModel.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        sendMoneyExternalPresenter.getAuthRequestContext(WithdrawChannelModelKt.BuiltInFictitiousFunctionClassFactory(list2));
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SendMoneyExternalPresenter sendMoneyExternalPresenter, TransferInit transferInit) {
        Object obj;
        Object obj2;
        List<WithdrawMethodOptionModel> list;
        List<WithdrawChannelModel> list2;
        List<TransferMethod> apply = sendMoneyExternalPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.apply(transferInit);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        Iterator<T> it = apply.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.areEqual(((TransferMethod) obj2).MyBillsEntityDataFactory, "OTC")) {
                break;
            }
        }
        TransferMethod transferMethod = (TransferMethod) obj2;
        if (transferMethod == null || (list = transferMethod.scheduleImpl) == null) {
            return;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.areEqual(((WithdrawMethodOptionModel) next).MyBillsEntityDataFactory, "WITHDRAW_REMITTANCE")) {
                obj = next;
                break;
            }
        }
        WithdrawMethodOptionModel withdrawMethodOptionModel = (WithdrawMethodOptionModel) obj;
        if (withdrawMethodOptionModel == null || (list2 = withdrawMethodOptionModel.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        List<ExternalWithdrawChannelModel> BuiltInFictitiousFunctionClassFactory = WithdrawChannelModelKt.BuiltInFictitiousFunctionClassFactory(list2);
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        sendMoneyExternalPresenter.moveToNextValue.addAll(BuiltInFictitiousFunctionClassFactory);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(SendMoneyExternalPresenter sendMoneyExternalPresenter, TransferInit transferInit) {
        QrisTcicoEntryPointInfo qrisTcicoEntryPointInfo = transferInit.getQrisTcicoEntryPointInfo();
        if (qrisTcicoEntryPointInfo != null) {
            if (!qrisTcicoEntryPointInfo.getVisibleStatus()) {
                sendMoneyExternalPresenter.GetContactSyncConfig.getAuthRequestContext();
            } else if (qrisTcicoEntryPointInfo.getEnableStatus()) {
                sendMoneyExternalPresenter.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(transferInit);
            } else {
                sendMoneyExternalPresenter.GetContactSyncConfig.getAuthRequestContext(transferInit);
            }
        }
    }

    public static final /* synthetic */ List BuiltInFictitiousFunctionClassFactory(SendMoneyExternalPresenter sendMoneyExternalPresenter, List list) {
        Object obj;
        if ((!sendMoneyExternalPresenter.moveToNextValue.isEmpty()) != false) {
            for (ExternalWithdrawChannelModel externalWithdrawChannelModel : sendMoneyExternalPresenter.moveToNextValue) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda0, ((ExternalWithdrawChannelModel) obj).NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                        break;
                    }
                }
                ExternalWithdrawChannelModel externalWithdrawChannelModel2 = (ExternalWithdrawChannelModel) obj;
                if (externalWithdrawChannelModel2 != null) {
                    externalWithdrawChannelModel2.MyBillsEntityDataFactory = externalWithdrawChannelModel.MyBillsEntityDataFactory;
                }
            }
        }
        return list;
    }

    public static final /* synthetic */ List BuiltInFictitiousFunctionClassFactory(List list, List list2) {
        Object obj;
        if ((!list2.isEmpty()) != false) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                WithdrawChannelInfoData withdrawChannelInfoData = (WithdrawChannelInfoData) it.next();
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (Intrinsics.areEqual(withdrawChannelInfoData.getInstId(), ((ExternalWithdrawChannelModel) obj).NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                        break;
                    }
                }
                ExternalWithdrawChannelModel externalWithdrawChannelModel = (ExternalWithdrawChannelModel) obj;
                if (externalWithdrawChannelModel != null) {
                    externalWithdrawChannelModel.getErrorConfigVersion = withdrawChannelInfoData.getLabel();
                }
            }
        }
        return list;
    }
}
