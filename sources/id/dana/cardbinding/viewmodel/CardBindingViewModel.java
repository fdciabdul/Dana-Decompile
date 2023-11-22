package id.dana.cardbinding.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import id.dana.cardbinding.domain.exception.OCRUnsupportedCardException;
import id.dana.cardbinding.domain.interactor.BindingCardAdd;
import id.dana.cardbinding.domain.interactor.GetCardInfoFromImage;
import id.dana.cardbinding.domain.interactor.GetSupportedCardsConfig;
import id.dana.cardbinding.domain.model.BankCardInfo;
import id.dana.cardbinding.domain.model.BindingCardAddInfo;
import id.dana.cardbinding.domain.model.SupportedCardsConfig;
import id.dana.cardbinding.model.BankCardInfoModelKt;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cardbinding.model.CashierPayParamRequestExtKt;
import id.dana.cardbinding.model.SupportedCardsConfigModelKt;
import id.dana.cardbinding.viewmodel.CardBindingUiState;
import id.dana.cashier.OneklikAnnotations;
import id.dana.cashier.VerificationMethod;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfoFlow;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrl;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrlFlow;
import id.dana.cashier.domain.interactor.GetQueryCardPolicy;
import id.dana.cashier.domain.interactor.GetQueryCardPolicyFlow;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayCashierFlow;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.PayQueryCashierFlow;
import id.dana.cashier.domain.model.Attribute;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.domain.model.QueryCardPolicyInfo;
import id.dana.cashier.mapper.CashierCheckoutModelMapper;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.QueryCardPolicyInfoModelMapperKt;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.contract.payasset.SceneType;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.payasset.model.QueryPayMethodResponse;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.network.exception.NetworkException;
import id.dana.utils.TextUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0081\u0001\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001d\u0012\u0006\u0010\u0013\u001a\u00020)\u0012\u0006\u0010\u0016\u001a\u000207\u0012\u0006\u0010H\u001a\u00020C\u0012\u0006\u0010I\u001a\u00020\u001f\u0012\u0006\u0010J\u001a\u000201\u0012\u0006\u0010K\u001a\u00020,\u0012\u0006\u0010L\u001a\u00020!\u0012\u0006\u0010M\u001a\u00020#\u0012\u0006\u0010N\u001a\u000204\u0012\u0006\u0010O\u001a\u00020;\u0012\u0006\u0010P\u001a\u00020>\u0012\u0006\u0010Q\u001a\u00020&\u0012\u0006\u0010R\u001a\u00020/\u0012\u0006\u0010S\u001a\u00020@¢\u0006\u0004\bT\u0010UJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\u000bJ\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\u0003\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e¢\u0006\u0004\b\u0005\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J)\u0010\u0005\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\b\u0010\rJ\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010\u0011\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0019\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010 R\u0014\u0010\u0003\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\"R\u0014\u0010\u0005\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0015\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010$\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010*\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00100R\u0014\u0010'\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u00102\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010<\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010?R\u0014\u00108\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010A\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001b0FX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010G"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierCheckoutRequestModel;", "p0", "getAuthRequestContext", "(Lid/dana/cashier/model/CashierCheckoutRequestModel;)V", "Lid/dana/cardbinding/model/CashierPayParamModel;", "(Lid/dana/cardbinding/model/CashierPayParamModel;)V", "", "(Ljava/lang/String;)V", "Landroid/content/Context;", "(Landroid/content/Context;)V", "Lid/dana/domain/payasset/interactor/QueryPayMethod$Params;", "PlaceComponentResult", "()Lid/dana/domain/payasset/interactor/QueryPayMethod$Params;", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "onCleared", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/app/Application;", "Landroid/app/Application;", "Lid/dana/cardbinding/domain/interactor/BindingCardAdd;", "Lid/dana/cardbinding/domain/interactor/BindingCardAdd;", "Lid/dana/cashier/mapper/CashierCheckoutModelMapper;", "Lid/dana/cashier/mapper/CashierCheckoutModelMapper;", "Lid/dana/cashier/mapper/CashierPayModelMapper;", "getErrorConfigVersion", "Lid/dana/cashier/mapper/CashierPayModelMapper;", "Lid/dana/data/config/DeviceInformationProvider;", "scheduleImpl", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage;", "lookAheadTest", "Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage;", "Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfoFlow;", "moveToNextValue", "Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfoFlow;", "Lid/dana/cashier/domain/interactor/GetOneklikRedirectUrlFlow;", "Lid/dana/cashier/domain/interactor/GetOneklikRedirectUrlFlow;", "Lid/dana/cashier/domain/interactor/GetQueryCardPolicyFlow;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/cashier/domain/interactor/GetQueryCardPolicyFlow;", "Lid/dana/cardbinding/domain/interactor/GetSupportedCardsConfig;", "initRecordTimeStamp", "Lid/dana/cardbinding/domain/interactor/GetSupportedCardsConfig;", "Lid/dana/domain/usereducation/interactor/IsNeedToShowToolTip;", "DatabaseTableConfigUtil", "Lid/dana/domain/usereducation/interactor/IsNeedToShowToolTip;", "GetContactSyncConfig", "Lid/dana/cashier/domain/interactor/PayCashierFlow;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/domain/interactor/PayCashierFlow;", "Lid/dana/cashier/domain/interactor/PayQueryCashierFlow;", "Lid/dana/cashier/domain/interactor/PayQueryCashierFlow;", "Lid/dana/domain/payasset/interactor/QueryPayMethod;", "PrepareContext", "Lid/dana/domain/payasset/interactor/QueryPayMethod;", "Lid/dana/domain/usereducation/interactor/SaveShowToolTip;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/domain/usereducation/interactor/SaveShowToolTip;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "<init>", "(Landroid/app/Application;Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage;Lid/dana/domain/usereducation/interactor/IsNeedToShowToolTip;Lid/dana/domain/usereducation/interactor/SaveShowToolTip;Lid/dana/cardbinding/domain/interactor/BindingCardAdd;Lid/dana/cashier/domain/interactor/GetQueryCardPolicyFlow;Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfoFlow;Lid/dana/cashier/mapper/CashierCheckoutModelMapper;Lid/dana/cashier/mapper/CashierPayModelMapper;Lid/dana/cardbinding/domain/interactor/GetSupportedCardsConfig;Lid/dana/cashier/domain/interactor/PayCashierFlow;Lid/dana/cashier/domain/interactor/PayQueryCashierFlow;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/cashier/domain/interactor/GetOneklikRedirectUrlFlow;Lid/dana/domain/payasset/interactor/QueryPayMethod;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CardBindingViewModel extends ViewModel {
    private final BindingCardAdd BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final IsNeedToShowToolTip GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final PayQueryCashierFlow NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MutableStateFlow<CardBindingUiState> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Application PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetOneklikRedirectUrlFlow lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final PayCashierFlow NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final GetQueryCardPolicyFlow scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final SaveShowToolTip PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final StateFlow<CardBindingUiState> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final QueryPayMethod DatabaseTableConfigUtil;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final CashierCheckoutModelMapper MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final CashierPayModelMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetSupportedCardsConfig initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetCardInfoFromImage getErrorConfigVersion;
    private final GetCashierCheckoutInfoFlow moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final DeviceInformationProvider NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public CardBindingViewModel(Application application, GetCardInfoFromImage getCardInfoFromImage, IsNeedToShowToolTip isNeedToShowToolTip, SaveShowToolTip saveShowToolTip, BindingCardAdd bindingCardAdd, GetQueryCardPolicyFlow getQueryCardPolicyFlow, GetCashierCheckoutInfoFlow getCashierCheckoutInfoFlow, CashierCheckoutModelMapper cashierCheckoutModelMapper, CashierPayModelMapper cashierPayModelMapper, GetSupportedCardsConfig getSupportedCardsConfig, PayCashierFlow payCashierFlow, PayQueryCashierFlow payQueryCashierFlow, DeviceInformationProvider deviceInformationProvider, GetOneklikRedirectUrlFlow getOneklikRedirectUrlFlow, QueryPayMethod queryPayMethod) {
        Intrinsics.checkNotNullParameter(application, "");
        Intrinsics.checkNotNullParameter(getCardInfoFromImage, "");
        Intrinsics.checkNotNullParameter(isNeedToShowToolTip, "");
        Intrinsics.checkNotNullParameter(saveShowToolTip, "");
        Intrinsics.checkNotNullParameter(bindingCardAdd, "");
        Intrinsics.checkNotNullParameter(getQueryCardPolicyFlow, "");
        Intrinsics.checkNotNullParameter(getCashierCheckoutInfoFlow, "");
        Intrinsics.checkNotNullParameter(cashierCheckoutModelMapper, "");
        Intrinsics.checkNotNullParameter(cashierPayModelMapper, "");
        Intrinsics.checkNotNullParameter(getSupportedCardsConfig, "");
        Intrinsics.checkNotNullParameter(payCashierFlow, "");
        Intrinsics.checkNotNullParameter(payQueryCashierFlow, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(getOneklikRedirectUrlFlow, "");
        Intrinsics.checkNotNullParameter(queryPayMethod, "");
        this.PlaceComponentResult = application;
        this.getErrorConfigVersion = getCardInfoFromImage;
        this.GetContactSyncConfig = isNeedToShowToolTip;
        this.PrepareContext = saveShowToolTip;
        this.BuiltInFictitiousFunctionClassFactory = bindingCardAdd;
        this.scheduleImpl = getQueryCardPolicyFlow;
        this.moveToNextValue = getCashierCheckoutInfoFlow;
        this.MyBillsEntityDataFactory = cashierCheckoutModelMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cashierPayModelMapper;
        this.initRecordTimeStamp = getSupportedCardsConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = payCashierFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = payQueryCashierFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = deviceInformationProvider;
        this.lookAheadTest = getOneklikRedirectUrlFlow;
        this.DatabaseTableConfigUtil = queryPayMethod;
        MutableStateFlow<CardBindingUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(CardBindingUiState.None.INSTANCE);
        this.getAuthRequestContext = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        GetCardInfoFromImage getCardInfoFromImage = this.getErrorConfigVersion;
        GetCardInfoFromImage.Params.Companion companion = GetCardInfoFromImage.Params.INSTANCE;
        BaseFlowUseCase.execute$default(getCardInfoFromImage, GetCardInfoFromImage.Params.Companion.PlaceComponentResult(), null, new Function1<BankCardInfo, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCardInfoFromImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BankCardInfo bankCardInfo) {
                invoke2(bankCardInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BankCardInfo bankCardInfo) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(bankCardInfo, "");
                if (bankCardInfo.getBuiltInFictitiousFunctionClassFactory()) {
                    mutableStateFlow2 = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        CardBindingUiState cardBindingUiState = (CardBindingUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, new CardBindingUiState.OnGetCardInfoSuccess(BankCardInfoModelKt.MyBillsEntityDataFactory(bankCardInfo))));
                    return;
                }
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState2 = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.OnErrorCardNotSupported.INSTANCE));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCardInfoFromImage$2
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
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(th, "");
                if (th instanceof OCRUnsupportedCardException) {
                    mutableStateFlow2 = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        CardBindingUiState cardBindingUiState = (CardBindingUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, CardBindingUiState.OnErrorCardNotSupported.INSTANCE));
                    return;
                }
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState2 = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.OnErrorScanCard.INSTANCE));
            }
        }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCardInfoFromImage$3
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.None.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(this), 2, null);
    }

    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.execute(new DefaultObserver<Boolean>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getIsFirstTimeOpenCardBinding$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                MutableStateFlow mutableStateFlow;
                Object value;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                String str = p0;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnIsFirstTimeOpenCardBinding(booleanValue, str)));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(p02, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                String str = p0;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnIsFirstTimeOpenCardBinding(false, str)));
            }
        }, IsNeedToShowToolTip.Params.forShowTooltip(p0));
    }

    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PrepareContext.execute(new DefaultObserver<Boolean>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$setAlreadyFinishedCardBindingFirstTimer$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.CARD_BINDING_TUTORIAL_FIRST_TIMER);
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CARD_BINDING_TAG, sb.toString(), p02.getMessage());
            }
        }, SaveShowToolTip.Params.forSaveShowToolTip(true, p0));
    }

    public final void MyBillsEntityDataFactory() {
        BaseFlowUseCase.execute$default(this.BuiltInFictitiousFunctionClassFactory, NoParams.INSTANCE, null, new Function1<BindingCardAddInfo, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$bindingCardAdd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BindingCardAddInfo bindingCardAddInfo) {
                invoke2(bindingCardAddInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BindingCardAddInfo bindingCardAddInfo) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(bindingCardAddInfo, "");
                String str = bindingCardAddInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                if (str != null) {
                    mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnSuccessBindingCardAdd(str)));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$bindingCardAdd$2
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.OnErrorBindingCardAdd.INSTANCE));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void getAuthRequestContext() {
        BaseFlowUseCase.execute$default(this.initRecordTimeStamp, NoParams.INSTANCE, null, new Function1<SupportedCardsConfig, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getSupportedCardsConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SupportedCardsConfig supportedCardsConfig) {
                invoke2(supportedCardsConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SupportedCardsConfig supportedCardsConfig) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(supportedCardsConfig, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnSuccessGetSupportedCardsConfig(SupportedCardsConfigModelKt.BuiltInFictitiousFunctionClassFactory(supportedCardsConfig))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getSupportedCardsConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CARD_BINDING_TAG, DanaLogConstants.Prefix.CARD_BINDING_SUPPORTED_CARDS, th.getMessage());
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void MyBillsEntityDataFactory(CashierPayParamModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(PayCashier.Params.Companion.createPayCashierRequest$default(PayCashier.Params.INSTANCE, CashierPayParamRequestExtKt.BuiltInFictitiousFunctionClassFactory(p0.BuiltInFictitiousFunctionClassFactory, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.lookAheadTest, p0.scheduleImpl), false, null, 4, null), new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCashierPay$1
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.ShowProgress.INSTANCE));
            }
        }, new Function1<CashierPay, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCashierPay$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                MutableStateFlow mutableStateFlow;
                Object value;
                CashierPayModelMapper cashierPayModelMapper;
                CashierPayModel apply;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                CardBindingViewModel cardBindingViewModel = CardBindingViewModel.this;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                    cashierPayModelMapper = cardBindingViewModel.KClassImpl$Data$declaredNonStaticMembers$2;
                    apply = cashierPayModelMapper.apply(cashierPay);
                    Intrinsics.checkNotNullExpressionValue(apply, "");
                } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnSuccessCashierPay(apply)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCashierPay$3
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
                sb.append("[CashierPay]: card_binding_exception");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CARD_BINDING_TAG, sb.toString(), th);
                CardBindingViewModel.BuiltInFictitiousFunctionClassFactory(CardBindingViewModel.this, th);
            }
        }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCashierPay$4
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.DismissProgress.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final CashierPayParamModel p0) {
        PayQueryCashier.Params createPayQueryRequest;
        Intrinsics.checkNotNullParameter(p0, "");
        PayQueryCashierFlow payQueryCashierFlow = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        PayQueryCashier.Params.Companion companion = PayQueryCashier.Params.INSTANCE;
        String str = p0.BuiltInFictitiousFunctionClassFactory;
        String str2 = p0.scheduleImpl;
        String str3 = p0.lookAheadTest;
        String str4 = p0.getAuthRequestContext;
        createPayQueryRequest = companion.createPayQueryRequest(str, (r27 & 2) != 0 ? null : KClassImpl$Data$declaredNonStaticMembers$2(str2, str3, str4 != null ? str4 : ""), (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? null : null, (r27 & 16) != 0 ? null : p0.NetworkUserEntityData$$ExternalSyntheticLambda0, true, (r27 & 64) != 0 ? null : p0.getMyBillsEntityDataFactory() ? this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndroidId(this.PlaceComponentResult.getApplicationContext()) : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? false : p0.getPlaceComponentResult(), (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null);
        payQueryCashierFlow.execute(createPayQueryRequest, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getPayQuery$1
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.ShowProgress.INSTANCE));
            }
        }, new Function1<CashierPay, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getPayQuery$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Unit unit;
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                CashierPayModelMapper cashierPayModelMapper;
                CashierPayModel apply;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                Attribute attributes = cashierPay.getAttributes();
                int i = 1;
                ?? r3 = 0;
                if (attributes != null) {
                    CardBindingViewModel cardBindingViewModel = CardBindingViewModel.this;
                    CashierPayParamModel cashierPayParamModel = p0;
                    if (Intrinsics.areEqual(attributes.getQueryAgain(), Boolean.TRUE)) {
                        cashierPayParamModel.PlaceComponentResult = true;
                        cardBindingViewModel.KClassImpl$Data$declaredNonStaticMembers$2(cashierPayParamModel);
                    } else {
                        cashierPayParamModel.PlaceComponentResult = false;
                        mutableStateFlow2 = cardBindingViewModel.getAuthRequestContext;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            CardBindingUiState cardBindingUiState = (CardBindingUiState) value2;
                            cashierPayModelMapper = cardBindingViewModel.KClassImpl$Data$declaredNonStaticMembers$2;
                            apply = cashierPayModelMapper.apply(cashierPay);
                            Intrinsics.checkNotNullExpressionValue(apply, "");
                        } while (!mutableStateFlow2.compareAndSet(value2, new CardBindingUiState.OnSuccessPayQuery(apply)));
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        CardBindingUiState cardBindingUiState2 = (CardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnError(r3, i, r3)));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getPayQuery$3
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
                sb.append("[PayQuery]: card_binding_exception");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CARD_BINDING_TAG, sb.toString(), th);
                CardBindingViewModel.BuiltInFictitiousFunctionClassFactory(CardBindingViewModel.this, th);
            }
        }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getPayQuery$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MutableStateFlow mutableStateFlow;
                Object value;
                if (CashierPayParamModel.this.getPlaceComponentResult()) {
                    return;
                }
                mutableStateFlow = this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.DismissProgress.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }

    public final void PlaceComponentResult(final String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        BaseFlowUseCase.execute$default(this.scheduleImpl, GetQueryCardPolicy.Params.Companion.createQueryCardPolicy$default(GetQueryCardPolicy.Params.INSTANCE, null, p1, p0, 1, null), null, new Function1<QueryCardPolicyInfo, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getQueryCardPolicy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryCardPolicyInfo queryCardPolicyInfo) {
                invoke2(queryCardPolicyInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryCardPolicyInfo queryCardPolicyInfo) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(queryCardPolicyInfo, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                String str = p0;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnSuccessQueryCardPolicy(QueryCardPolicyInfoModelMapperKt.PlaceComponentResult(queryCardPolicyInfo), str)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getQueryCardPolicy$2
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnErrorQueryCardPolicy(th.getMessage())));
            }
        }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getQueryCardPolicy$3
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.None.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(this), 2, null);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String androidId = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndroidId(p0);
        String str = androidId;
        if (!(str == null || str.length() == 0)) {
            GetOneklikRedirectUrlFlow getOneklikRedirectUrlFlow = this.lookAheadTest;
            GetOneklikRedirectUrl.Params.Companion companion = GetOneklikRedirectUrl.Params.INSTANCE;
            String authRequestContext = TextUtil.getAuthRequestContext(androidId, UserAgentFactory.getUserAgent(), OneklikAnnotations.ONEKLIK_STATIC_IP);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            getOneklikRedirectUrlFlow.execute(companion.createPayCashierRequest(OneklikAnnotations.ONEKLIK_SCENARIO, authRequestContext), new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getOneklikRedirectUrl$1
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
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.ShowProgress.INSTANCE));
                }
            }, new Function1<String, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getOneklikRedirectUrl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str2) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    MutableStateFlow mutableStateFlow2;
                    Object value2;
                    Intrinsics.checkNotNullParameter(str2, "");
                    mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.DismissProgress.INSTANCE));
                    mutableStateFlow2 = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        CardBindingUiState cardBindingUiState2 = (CardBindingUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, new CardBindingUiState.OnGetOneklikRedirectUrlSuccess(str2)));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getOneklikRedirectUrl$3
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
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    Intrinsics.checkNotNullParameter(th, "");
                    mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnGetOneklikRedirectUrlError(th)));
                }
            }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getOneklikRedirectUrl$4
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
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.DismissProgress.INSTANCE));
                }
            }, ViewModelKt.PlaceComponentResult(this));
            return;
        }
        MutableStateFlow<CardBindingUiState> mutableStateFlow = this.getAuthRequestContext;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), CardBindingUiState.DismissProgress.INSTANCE));
        MutableStateFlow<CardBindingUiState> mutableStateFlow2 = this.getAuthRequestContext;
        do {
        } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), new CardBindingUiState.OnGetOneklikRedirectUrlError(new Throwable())));
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        this.DatabaseTableConfigUtil.execute(NetworkUserEntityData$$ExternalSyntheticLambda0(), new Function1<QueryPayMethodResponse, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$updateQueryPayMethod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryPayMethodResponse queryPayMethodResponse) {
                invoke2(queryPayMethodResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryPayMethodResponse queryPayMethodResponse) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(queryPayMethodResponse, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.None.INSTANCE));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$updateQueryPayMethod$2
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.None.INSTANCE));
            }
        });
        this.DatabaseTableConfigUtil.execute(PlaceComponentResult(), new Function1<QueryPayMethodResponse, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$updateQueryPayMethod$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryPayMethodResponse queryPayMethodResponse) {
                invoke2(queryPayMethodResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryPayMethodResponse queryPayMethodResponse) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(queryPayMethodResponse, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.None.INSTANCE));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$updateQueryPayMethod$4
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.None.INSTANCE));
            }
        });
    }

    private final QueryPayMethod.Params NetworkUserEntityData$$ExternalSyntheticLambda0() {
        QueryPayMethod.Params.Companion companion = QueryPayMethod.Params.INSTANCE;
        String generateDeviceId = this.NetworkUserEntityData$$ExternalSyntheticLambda0.generateDeviceId(this.PlaceComponentResult.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(generateDeviceId, "");
        return companion.forF2FPayUtdid(generateDeviceId, true);
    }

    private final QueryPayMethod.Params PlaceComponentResult() {
        QueryPayMethod.Params.Companion companion = QueryPayMethod.Params.INSTANCE;
        String generateDeviceId = this.NetworkUserEntityData$$ExternalSyntheticLambda0.generateDeviceId(this.PlaceComponentResult.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(generateDeviceId, "");
        return companion.forQueryAsset(generateDeviceId, SceneType.ASSETS, true);
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        if (p0 != null) {
            int hashCode = p0.hashCode();
            if (hashCode != -1075191160) {
                if (hashCode != -420010491) {
                    if (hashCode == 1999612571 && p0.equals("PASSWORD")) {
                        String encrypt = RSAHelper.encrypt(String.valueOf(p1), p2);
                        Intrinsics.checkNotNullExpressionValue(encrypt, "");
                        return encrypt;
                    }
                    return "";
                } else if (!p0.equals("OTP_SMS")) {
                    return "";
                }
            } else if (!p0.equals(VerificationMethod.BANK_OTP)) {
                return "";
            }
            return String.valueOf(p1);
        }
        return "";
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        this.GetContactSyncConfig.dispose();
        this.PrepareContext.dispose();
        this.DatabaseTableConfigUtil.dispose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CardBindingViewModel cardBindingViewModel, Throwable th) {
        CardBindingUiState value;
        String errorCode;
        Throwable cause = th.getCause();
        NetworkException networkException = cause instanceof NetworkException ? (NetworkException) cause : null;
        if (networkException != null) {
            MutableStateFlow<CardBindingUiState> mutableStateFlow = cardBindingViewModel.getAuthRequestContext;
            do {
                value = mutableStateFlow.getValue();
                errorCode = networkException.getErrorCode();
                if (errorCode == null) {
                    errorCode = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(errorCode, "");
                }
            } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnErrorCashierPay(errorCode, networkException.getMessage())));
            return;
        }
        MutableStateFlow<CardBindingUiState> mutableStateFlow2 = cardBindingViewModel.getAuthRequestContext;
        do {
        } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), new CardBindingUiState.OnErrorCashierPay("", th.getMessage())));
    }

    public final void getAuthRequestContext(CashierCheckoutRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = "cashierMain";
        String str2 = null;
        String str3 = null;
        BaseFlowUseCase.execute$default(this.moveToNextValue, GetCashierCheckoutInfo.Params.INSTANCE.createCashierMainRequest(new CashierPayRequest(str, str2, str3, p0.KClassImpl$Data$declaredNonStaticMembers$2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, p0.getErrorConfigVersion, null, null, -14, 895, null), false), null, new Function1<CashierPay, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCashierMain$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                MutableStateFlow mutableStateFlow;
                Object value;
                CashierCheckoutModelMapper cashierCheckoutModelMapper;
                CashierCheckoutModel apply;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                CardBindingViewModel cardBindingViewModel = CardBindingViewModel.this;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                    cashierCheckoutModelMapper = cardBindingViewModel.MyBillsEntityDataFactory;
                    apply = cashierCheckoutModelMapper.apply(cashierPay);
                    Intrinsics.checkNotNullExpressionValue(apply, "");
                } while (!mutableStateFlow.compareAndSet(value, new CardBindingUiState.OnSuccessGetCashierMain(apply)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.CardBindingViewModel$getCashierMain$2
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = CardBindingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    CardBindingUiState cardBindingUiState = (CardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, CardBindingUiState.OnErrorGetCashierMain.INSTANCE));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }
}
