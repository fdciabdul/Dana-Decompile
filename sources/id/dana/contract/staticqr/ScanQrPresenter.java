package id.dana.contract.staticqr;

import android.content.Context;
import android.os.Bundle;
import dagger.Lazy;
import id.dana.R;
import id.dana.analytics.firebase.FirebaseAnalyticsEvent;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.cashier.helper.CashierInitParamHelper;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.featureconfig.model.CashierNativeConfig;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.domain.qrbarcode.DecodedScan;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrBarcode;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrisTopUp;
import id.dana.domain.qrbarcode.interactor.GetMerchantQrWhitelist;
import id.dana.domain.qrbarcode.interactor.GetNativelyDecodedQr;
import id.dana.domain.qrbarcode.interactor.GetQrisCpmSendmoneyConfig;
import id.dana.domain.qrbarcode.interactor.IsNativeDecodeEnabled;
import id.dana.domain.qrbarcode.interactor.ValidateNativelyDecodedQr;
import id.dana.domain.qrbarcode.model.CpmToSendMoneyConfig;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserStatusInfo;
import id.dana.domain.usereducation.interactor.SaveShowDialog;
import id.dana.mapper.ScanResultMapper;
import id.dana.model.ScanModel;
import id.dana.scanner.handler.nativepages.ScannerSceneType;
import id.dana.tracker.EventTracker;
import id.dana.tracker.appsflyer.AppsflyerEvent;
import id.dana.tracker.branch.BranchEventStrategy;
import id.dana.utils.ContextUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001Bñ\u0001\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u001e\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020I0\"\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020(0\"\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020*0\"\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020A0\"\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u0002060\"\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020%0\"\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020.0\"\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020?0\"\u0012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020F0\"\u0012\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020,0\"\u0012\f\u0010R\u001a\b\u0012\u0004\u0012\u00020/0\"\u0012\f\u0010S\u001a\b\u0012\u0004\u0012\u0002090\"\u0012\f\u0010T\u001a\b\u0012\u0004\u0012\u0002050\"\u0012\f\u0010U\u001a\b\u0012\u0004\u0012\u0002020\"\u0012\f\u0010V\u001a\b\u0012\u0004\u0012\u00020@0\"¢\u0006\u0004\bW\u0010XJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\bJ9\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0003\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002¢\u0006\u0004\b\u0003\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0014J\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0014J\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\bJ'\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u001aR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u0014\u0010\u0010\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0012\u0010\u0012\u001a\u00020 X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020(0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010$R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010$R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020.0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010$R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020/0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010$R\u001a\u00104\u001a\b\u0012\u0004\u0012\u0002020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010$R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002050\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010$R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002060\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010$R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00108R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u0002090\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010$R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00108R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00108R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020?0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010$R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020@0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010$R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010$R\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020F0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010$R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010$"}, d2 = {"Lid/dana/contract/staticqr/ScanQrPresenter;", "Lid/dana/contract/staticqr/ScanQrContract$Presenter;", "", "MyBillsEntityDataFactory", "()Z", "Lid/dana/model/ScanModel;", "p0", "", "(Lid/dana/model/ScanModel;)V", "", "p1", "p2", "p3", "p4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "Lkotlin/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/jvm/functions/Function0;)V", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "()V", "(Ljava/lang/String;)Z", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "PlaceComponentResult", "Lid/dana/domain/qrbarcode/DecodedScan;", "(Lid/dana/domain/qrbarcode/DecodedScan;Ljava/lang/String;Ljava/lang/String;)Lid/dana/model/ScanModel;", "Lid/dana/domain/featureconfig/model/CashierNativeConfig;", "Lid/dana/domain/featureconfig/model/CashierNativeConfig;", "Ljava/lang/String;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/qrbarcode/model/CpmToSendMoneyConfig;", "Lid/dana/domain/qrbarcode/model/CpmToSendMoneyConfig;", "Ldagger/Lazy;", "Lid/dana/data/config/DeviceInformationProvider;", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/GetCashierNativeConfig;", "getErrorConfigVersion", "moveToNextValue", "Lid/dana/domain/qrbarcode/interactor/GetDecodedQrBarcode;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/qrbarcode/interactor/GetDecodedQrisTopUp;", "scheduleImpl", "Lid/dana/domain/qrbarcode/interactor/GetMerchantQrWhitelist;", "lookAheadTest", "Lid/dana/domain/qrbarcode/interactor/GetNativelyDecodedQr;", "Lid/dana/domain/oauth/interactor/GetQrBindingConfig;", "initRecordTimeStamp", "DatabaseTableConfigUtil", "Lid/dana/domain/qrbarcode/interactor/GetQrisCpmSendmoneyConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "Lid/dana/domain/paylater/interactor/GetUserLoanInfo;", "Lid/dana/domain/user/interactor/GetUserStatusInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "Lid/dana/domain/featureconfig/interactor/IsFeaturePaylaterCicilScannerEnabled;", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/domain/qrbarcode/interactor/IsNativeDecodeEnabled;", "Lid/dana/domain/usereducation/interactor/SaveShowDialog;", "Lid/dana/mapper/ScanResultMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/domain/user/UserInfoResponse;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/domain/qrbarcode/interactor/ValidateNativelyDecodedQr;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/contract/staticqr/ScanQrContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "<init>", "(Landroid/content/Context;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class ScanQrPresenter implements ScanQrContract.Presenter {
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy<GetUserLoanInfo> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    CpmToSendMoneyConfig getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<GetDecodedQrBarcode> getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy<GetQrisCpmSendmoneyConfig> GetContactSyncConfig;
    private final Lazy<GetUserStatusInfo> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Lazy<ScanResultMapper> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private UserInfoResponse NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Lazy<ScanQrContract.View> NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy<ValidateNativelyDecodedQr> FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy<SaveShowDialog> PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy<IsNativeDecodeEnabled> isLayoutRequested;
    private CashierNativeConfig PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<DeviceInformationProvider> MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<GetCashierNativeConfig> moveToNextValue;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<GetQrBindingConfig> DatabaseTableConfigUtil;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<GetNativelyDecodedQr> scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy<GetMerchantQrWhitelist> lookAheadTest;
    private final Lazy<IsFeaturePaylaterCicilScannerEnabled> newProxyInstance;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<GetDecodedQrisTopUp> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    @Inject
    public ScanQrPresenter(Context context, Lazy<ScanQrContract.View> lazy, Lazy<GetDecodedQrBarcode> lazy2, Lazy<GetDecodedQrisTopUp> lazy3, Lazy<ScanResultMapper> lazy4, Lazy<DeviceInformationProvider> lazy5, Lazy<GetUserStatusInfo> lazy6, Lazy<GetCashierNativeConfig> lazy7, Lazy<GetNativelyDecodedQr> lazy8, Lazy<IsNativeDecodeEnabled> lazy9, Lazy<ValidateNativelyDecodedQr> lazy10, Lazy<GetMerchantQrWhitelist> lazy11, Lazy<GetQrBindingConfig> lazy12, Lazy<IsFeaturePaylaterCicilScannerEnabled> lazy13, Lazy<GetUserLoanInfo> lazy14, Lazy<GetQrisCpmSendmoneyConfig> lazy15, Lazy<SaveShowDialog> lazy16) {
        Intrinsics.checkNotNullParameter(context, "");
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
        Intrinsics.checkNotNullParameter(lazy11, "");
        Intrinsics.checkNotNullParameter(lazy12, "");
        Intrinsics.checkNotNullParameter(lazy13, "");
        Intrinsics.checkNotNullParameter(lazy14, "");
        Intrinsics.checkNotNullParameter(lazy15, "");
        Intrinsics.checkNotNullParameter(lazy16, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = lazy;
        this.getErrorConfigVersion = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = lazy4;
        this.MyBillsEntityDataFactory = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy6;
        this.moveToNextValue = lazy7;
        this.scheduleImpl = lazy8;
        this.isLayoutRequested = lazy9;
        this.FragmentBottomSheetPaymentSettingBinding = lazy10;
        this.lookAheadTest = lazy11;
        this.DatabaseTableConfigUtil = lazy12;
        this.newProxyInstance = lazy13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy14;
        this.GetContactSyncConfig = lazy15;
        this.PrepareContext = lazy16;
        ?? r1 = 0;
        this.getAuthRequestContext = new CpmToSendMoneyConfig(false, r1, 3, r1);
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.Presenter
    public final void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$initDecodeConfig$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        IsNativeDecodeEnabled isNativeDecodeEnabled = this.isLayoutRequested.get();
        Intrinsics.checkNotNullExpressionValue(isNativeDecodeEnabled, "");
        BaseUseCase.execute$default(isNativeDecodeEnabled, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$checkIsNativeDecodeEnabled$1
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
                ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = z;
            }
        }, null, 4, null);
        GetMerchantQrWhitelist getMerchantQrWhitelist = this.lookAheadTest.get();
        Intrinsics.checkNotNullExpressionValue(getMerchantQrWhitelist, "");
        BaseUseCase.execute$default(getMerchantQrWhitelist, NoParams.INSTANCE, new Function1<List<? extends String>, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$getMerchantQrDomainWhitelist$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(list, "");
                lazy = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(list);
            }
        }, null, 4, null);
        GetQrBindingConfig getQrBindingConfig = this.DatabaseTableConfigUtil.get();
        Intrinsics.checkNotNullExpressionValue(getQrBindingConfig, "");
        BaseUseCase.execute$default(getQrBindingConfig, NoParams.INSTANCE, new Function1<QrBindingConfig, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$getQrBindingConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QrBindingConfig qrBindingConfig) {
                invoke2(qrBindingConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QrBindingConfig qrBindingConfig) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(qrBindingConfig, "");
                lazy = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy.get()).getAuthRequestContext(qrBindingConfig);
            }
        }, null, 4, null);
        GetQrisCpmSendmoneyConfig getQrisCpmSendmoneyConfig = this.GetContactSyncConfig.get();
        Intrinsics.checkNotNullExpressionValue(getQrisCpmSendmoneyConfig, "");
        BaseUseCase.execute$default(getQrisCpmSendmoneyConfig, NoParams.INSTANCE, new Function1<CpmToSendMoneyConfig, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$getQrisCpmPrefix$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CpmToSendMoneyConfig cpmToSendMoneyConfig) {
                invoke2(cpmToSendMoneyConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CpmToSendMoneyConfig cpmToSendMoneyConfig) {
                Intrinsics.checkNotNullParameter(cpmToSendMoneyConfig, "");
                ScanQrPresenter scanQrPresenter = ScanQrPresenter.this;
                Intrinsics.checkNotNullParameter(cpmToSendMoneyConfig, "");
                scanQrPresenter.getAuthRequestContext = cpmToSendMoneyConfig;
            }
        }, null, 4, null);
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.Presenter
    public final void MyBillsEntityDataFactory(final String p0, final String p1, final String p2, final boolean p3, boolean p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (MyBillsEntityDataFactory()) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().showProgress();
        if (Intrinsics.areEqual(p2, ScannerSceneType.SCENE_QRIS_TOP_UP_KYB)) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new DefaultObserver<DecodedScan>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$decodeQrTopUp$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    Lazy lazy;
                    Lazy lazy2;
                    Lazy lazy3;
                    ScanModel PlaceComponentResult;
                    Lazy lazy4;
                    Lazy lazy5;
                    DecodedScan decodedScan = (DecodedScan) obj;
                    Intrinsics.checkNotNullParameter(decodedScan, "");
                    lazy = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    ((ScanQrContract.View) lazy.get()).dismissProgress();
                    lazy2 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    ((ScanQrContract.View) lazy2.get()).moveToNextValue();
                    if (decodedScan.isSuccess()) {
                        if (p3) {
                            lazy5 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                            ((ScanQrContract.View) lazy5.get()).BuiltInFictitiousFunctionClassFactory(true, "");
                        }
                        PlaceComponentResult = ScanQrPresenter.this.PlaceComponentResult(decodedScan, p0, p1);
                        ScanQrPresenter scanQrPresenter = ScanQrPresenter.this;
                        scanQrPresenter.PlaceComponentResult(PlaceComponentResult);
                        lazy4 = scanQrPresenter.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        ((ScanQrContract.View) lazy4.get()).BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
                    } else if (p3) {
                        lazy3 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        ((ScanQrContract.View) lazy3.get()).BuiltInFictitiousFunctionClassFactory(false, p0);
                    }
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p02) {
                    Lazy lazy;
                    Lazy lazy2;
                    Lazy lazy3;
                    Intrinsics.checkNotNullParameter(p02, "");
                    lazy = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    ((ScanQrContract.View) lazy.get()).moveToNextValue();
                    if (p3) {
                        lazy3 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                        ((ScanQrContract.View) lazy3.get()).BuiltInFictitiousFunctionClassFactory(false, p0);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.SCAN_QRCODE_PREFIX);
                    sb.append(getClass().getName());
                    sb.append("getDecodedQrisTopUp:onError");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), p02);
                    lazy2 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    ((ScanQrContract.View) lazy2.get()).dismissProgress();
                    ScanQrPresenter.MyBillsEntityDataFactory(ScanQrPresenter.this, p02, p1);
                }
            }, new GetDecodedQrisTopUp.Params(p0, p2, true));
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 && this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            this.scheduleImpl.get().execute(p0, new Function1<HashMap<String, String>, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$nativeDecode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap) {
                    invoke2(hashMap);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(HashMap<String, String> hashMap) {
                    Intrinsics.checkNotNullParameter(hashMap, "");
                    r1.FragmentBottomSheetPaymentSettingBinding.get().execute(hashMap, new Function1<Boolean, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$doValidateNativelyDecodedQr$1
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
                            Lazy lazy;
                            Lazy lazy2;
                            if (z) {
                                lazy = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                                ((ScanQrContract.View) lazy.get()).moveToNextValue();
                                final ScanModel scanModel = new ScanModel();
                                scanModel.setSource(r2);
                                scanModel.setNativelyDecodedQr(hashMap);
                                scanModel.setRequestId(ScanQrPresenter.getAuthRequestContext(ScanQrPresenter.this));
                                scanModel.setQrCode(r4);
                                scanModel.setPrecreateOrder(true);
                                lazy2 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                                ((ScanQrContract.View) lazy2.get()).PlaceComponentResult(true);
                                ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
                                ScanQrPresenter scanQrPresenter = ScanQrPresenter.this;
                                final ScanQrPresenter scanQrPresenter2 = ScanQrPresenter.this;
                                scanQrPresenter.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$doValidateNativelyDecodedQr$1.1
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
                                        Lazy lazy3;
                                        CashierNativeConfig cashierNativeConfig;
                                        lazy3 = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                                        ScanQrContract.View view = (ScanQrContract.View) lazy3.get();
                                        ScanModel scanModel2 = scanModel;
                                        cashierNativeConfig = ScanQrPresenter.this.PlaceComponentResult;
                                        view.getAuthRequestContext(scanModel2, cashierNativeConfig != null && cashierNativeConfig.isCustomKeyboardEnable());
                                    }
                                });
                                return;
                            }
                            r5.MyBillsEntityDataFactory(new ScanQrPresenter$onlineDecode$1(ScanQrPresenter.this, r4, r5, true, r6, r2));
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$doValidateNativelyDecodedQr$2
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
                            Intrinsics.checkNotNullParameter(th, "");
                            r5.MyBillsEntityDataFactory(new ScanQrPresenter$onlineDecode$1(ScanQrPresenter.this, r2, r4, true, r5, r3));
                        }
                    });
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$nativeDecode$2
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
                    Intrinsics.checkNotNullParameter(th, "");
                    r5.MyBillsEntityDataFactory(new ScanQrPresenter$onlineDecode$1(ScanQrPresenter.this, p0, p2, true, p3, p1));
                }
            });
        } else {
            MyBillsEntityDataFactory(new ScanQrPresenter$onlineDecode$1(this, p0, p2, p4, p3, p1));
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.Presenter
    public final void getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        CashierInitParamHelper cashierInitParamHelper = CashierInitParamHelper.INSTANCE;
        ScanModel PlaceComponentResult = PlaceComponentResult(CashierInitParamHelper.KClassImpl$Data$declaredNonStaticMembers$2(p0), p0, p1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().moveToNextValue();
        PlaceComponentResult(PlaceComponentResult);
        MyBillsEntityDataFactory(PlaceComponentResult);
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.Presenter
    public final boolean getAuthRequestContext(String p0) {
        if (this.getAuthRequestContext.getIsNeedToshowDialog()) {
            String str = p0;
            if (str == null || StringsKt.isBlank(str)) {
                return false;
            }
            return this.getAuthRequestContext.containAnyPrefix(p0);
        }
        return false;
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getAuthRequestContext.setNeedToshowDialog(false);
        SaveShowDialog saveShowDialog = this.PrepareContext.get();
        Intrinsics.checkNotNullExpressionValue(saveShowDialog, "");
        BaseUseCase.execute$default(saveShowDialog, SaveShowDialog.Params.INSTANCE.forShowDialog(false, "cpm_to_sendmoney"), new Function1<Boolean, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$saveShowQrisCpmToSendMoneyDialog$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    public final ScanModel PlaceComponentResult(DecodedScan p0, String p1, String p2) {
        ScanModel authRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().getAuthRequestContext(p0);
        authRequestContext.getBizInfo().NetworkUserEntityData$$ExternalSyntheticLambda6 = p1;
        authRequestContext.setSource(p2);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0078, code lost:
    
        if (id.dana.cashier.helper.CashierInitParamHelper.initRecordTimeStamp(r1 != null ? r1 : "") == false) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(final id.dana.model.ScanModel r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r1 = r5.getRedirectUrl()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L2b
            java.lang.String r1 = r5.getRedirectUrl()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L21
            r1 = 1
            goto L22
        L21:
            r1 = 0
        L22:
            if (r1 == 0) goto L2b
            java.lang.String r1 = r5.getRedirectUrl()
            r4.BuiltInFictitiousFunctionClassFactory = r1
            goto L51
        L2b:
            id.dana.model.BizInfoModel r1 = r5.getBizInfo()
            java.lang.String r1 = r1.isLayoutRequested
            if (r1 == 0) goto L51
            id.dana.model.BizInfoModel r1 = r5.getBizInfo()
            java.lang.String r1 = r1.isLayoutRequested
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L46
            r1 = 1
            goto L47
        L46:
            r1 = 0
        L47:
            if (r1 == 0) goto L51
            id.dana.model.BizInfoModel r1 = r5.getBizInfo()
            java.lang.String r1 = r1.isLayoutRequested
            r4.BuiltInFictitiousFunctionClassFactory = r1
        L51:
            java.lang.String r1 = r4.BuiltInFictitiousFunctionClassFactory
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L5f
            int r1 = r1.length()
            if (r1 == 0) goto L5f
            r1 = 0
            goto L60
        L5f:
            r1 = 1
        L60:
            if (r1 != 0) goto L7a
            id.dana.cashier.helper.CashierInitParamHelper r1 = id.dana.cashier.helper.CashierInitParamHelper.INSTANCE
            java.lang.String r1 = r4.BuiltInFictitiousFunctionClassFactory
            boolean r1 = id.dana.cashier.helper.CashierInitParamHelper.lookAheadTest(r1)
            if (r1 != 0) goto L7a
            id.dana.cashier.helper.CashierInitParamHelper r1 = id.dana.cashier.helper.CashierInitParamHelper.INSTANCE
            java.lang.String r1 = r4.BuiltInFictitiousFunctionClassFactory
            if (r1 != 0) goto L73
            goto L74
        L73:
            r0 = r1
        L74:
            boolean r0 = id.dana.cashier.helper.CashierInitParamHelper.initRecordTimeStamp(r0)
            if (r0 != 0) goto L7c
        L7a:
            r4.NetworkUserEntityData$$ExternalSyntheticLambda7 = r3
        L7c:
            id.dana.cashier.helper.CashierInitParamHelper r0 = id.dana.cashier.helper.CashierInitParamHelper.INSTANCE
            java.lang.String r0 = r4.BuiltInFictitiousFunctionClassFactory
            boolean r0 = id.dana.cashier.helper.CashierInitParamHelper.moveToNextValue(r0)
            if (r0 == 0) goto L8c
            boolean r0 = r4.initRecordTimeStamp
            if (r0 == 0) goto L8c
            r4.NetworkUserEntityData$$ExternalSyntheticLambda7 = r2
        L8c:
            boolean r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            if (r0 == 0) goto La5
            id.dana.cashier.helper.CashierInitParamHelper r0 = id.dana.cashier.helper.CashierInitParamHelper.INSTANCE
            java.lang.String r0 = r4.BuiltInFictitiousFunctionClassFactory
            boolean r0 = id.dana.cashier.helper.CashierInitParamHelper.moveToNextValue(r0)
            if (r0 != 0) goto La5
            id.dana.contract.staticqr.ScanQrPresenter$checkCashierMerchantWhitelistConfig$1 r0 = new id.dana.contract.staticqr.ScanQrPresenter$checkCashierMerchantWhitelistConfig$1
            r0.<init>()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r4.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            return
        La5:
            id.dana.domain.user.UserInfoResponse r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4
            if (r0 != 0) goto Lb4
            id.dana.contract.staticqr.ScanQrPresenter$checkUserInfo$1 r0 = new id.dana.contract.staticqr.ScanQrPresenter$checkUserInfo$1
            r0.<init>(r4, r5)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r4.MyBillsEntityDataFactory(r0)
            return
        Lb4:
            r4.BuiltInFictitiousFunctionClassFactory(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.staticqr.ScanQrPresenter.MyBillsEntityDataFactory(id.dana.model.ScanModel):void");
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.newProxyInstance.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$isFeaturePaylaterCicilScannerEnabled$1
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
                UserLoanInfo execute;
                Lazy lazy;
                execute = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(new GetUserLoanInfo.Params(LoanInfo.LOAN_PERSONAL));
                boolean z2 = Intrinsics.areEqual(execute.getIsWhitelisted(), Boolean.TRUE) && z;
                lazy = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy.get()).MyBillsEntityDataFactory(z2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$isFeaturePaylaterCicilScannerEnabled$2
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
                lazy = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy.get()).MyBillsEntityDataFactory(false);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SCAN_QRCODE_PREFIX);
                sb.append(ScanQrPresenter.this.getClass().getName());
                sb.append("isFeaturePaylaterCicilScannerEnabled:onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), th);
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final Function0<Unit> p0) {
        if (this.PlaceComponentResult != null) {
            p0.invoke();
        } else {
            this.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1<CashierNativeConfig, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$getCashierNativeConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(CashierNativeConfig cashierNativeConfig) {
                    invoke2(cashierNativeConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(CashierNativeConfig cashierNativeConfig) {
                    Intrinsics.checkNotNullParameter(cashierNativeConfig, "");
                    ScanQrPresenter.this.PlaceComponentResult = cashierNativeConfig;
                    ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = cashierNativeConfig.isCashierNativeEnable();
                    ScanQrPresenter scanQrPresenter = ScanQrPresenter.this;
                    List<String> cashierNativeEntryPoints = cashierNativeConfig.getCashierNativeEntryPoints();
                    String lowerCase = "qris_cb".toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                    scanQrPresenter.initRecordTimeStamp = cashierNativeEntryPoints.contains(lowerCase);
                    p0.invoke();
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$getCashierNativeConfig$2
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
                    Intrinsics.checkNotNullParameter(th, "");
                    ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
                    p0.invoke();
                }
            });
        }
    }

    public final void MyBillsEntityDataFactory(final Function0<Unit> p0) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().execute(new GetUserStatusInfo.Param(true), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$getUserStatusInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda4 = userInfoResponse;
                p0.invoke();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$getUserStatusInfo$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
                QrErrorHelper qrErrorHelper = QrErrorHelper.INSTANCE;
                context = ScanQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String PlaceComponentResult = QrErrorHelper.PlaceComponentResult(th, context);
                lazy = ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                ((ScanQrContract.View) lazy.get()).onError(PlaceComponentResult);
                ScanQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().PlaceComponentResult(TrackerDataKey.Source.CAMERA_CARD_DECODE_ONLINE, "alipayplus.mobilewallet.wallet.user.info", PlaceComponentResult, th);
            }
        });
    }

    public final void BuiltInFictitiousFunctionClassFactory(ScanModel p0) {
        UserInfoResponse userInfoResponse = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        boolean z = false;
        if (userInfoResponse != null && userInfoResponse.isUserAndAccountStatusEnable()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().dismissProgress();
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().PlaceComponentResult(p0);
                return;
            }
            ScanQrContract.View view = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get();
            CashierNativeConfig cashierNativeConfig = this.PlaceComponentResult;
            if (cashierNativeConfig != null && cashierNativeConfig.isCustomKeyboardEnable()) {
                z = true;
            }
            view.getAuthRequestContext(p0, z);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().dismissProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().onError(this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.error_init_transfer));
    }

    private final boolean MyBillsEntityDataFactory() {
        if (ContextUtil.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            return false;
        }
        onDestroy();
        return true;
    }

    public final void PlaceComponentResult(ScanModel p0) {
        Bundle bundle = new Bundle();
        bundle.putString("bizType", p0.getBizType());
        bundle.putString("UTDID", this.MyBillsEntityDataFactory.get().getDeviceUtdId());
        HashMap hashMap = new HashMap();
        hashMap.put("bizType", p0.getBizType());
        hashMap.put("UTDID", this.MyBillsEntityDataFactory.get().getDeviceUtdId());
        EventTracker.BuiltInFictitiousFunctionClassFactory(new AppsflyerEvent(this.KClassImpl$Data$declaredNonStaticMembers$2, "scan_qr", hashMap), new BranchEventStrategy(this.KClassImpl$Data$declaredNonStaticMembers$2, "scan_qr", hashMap), new FirebaseAnalyticsEvent(this.KClassImpl$Data$declaredNonStaticMembers$2, "scan_qr", bundle));
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.Presenter
    public final void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.contract.staticqr.ScanQrPresenter$onResume$1
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
                CashierNativeConfig cashierNativeConfig;
                ScanQrPresenter scanQrPresenter = ScanQrPresenter.this;
                cashierNativeConfig = scanQrPresenter.PlaceComponentResult;
                scanQrPresenter.NetworkUserEntityData$$ExternalSyntheticLambda7 = cashierNativeConfig != null && cashierNativeConfig.isCashierNativeEnable();
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getErrorConfigVersion.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.moveToNextValue.get().dispose();
        this.scheduleImpl.get().dispose();
        this.isLayoutRequested.get().dispose();
        this.FragmentBottomSheetPaymentSettingBinding.get().dispose();
        this.newProxyInstance.get().dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(ScanQrPresenter scanQrPresenter, ScanModel scanModel) {
        if (scanQrPresenter.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
            scanQrPresenter.MyBillsEntityDataFactory(new ScanQrPresenter$checkUserInfo$1(scanQrPresenter, scanModel));
        } else {
            scanQrPresenter.BuiltInFictitiousFunctionClassFactory(scanModel);
        }
    }

    public static final /* synthetic */ String getAuthRequestContext(ScanQrPresenter scanQrPresenter) {
        String deviceUUID = scanQrPresenter.MyBillsEntityDataFactory.get().getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        return deviceUUID;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void MyBillsEntityDataFactory(id.dana.contract.staticqr.ScanQrPresenter r8, java.lang.Throwable r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.staticqr.ScanQrPresenter.MyBillsEntityDataFactory(id.dana.contract.staticqr.ScanQrPresenter, java.lang.Throwable, java.lang.String):void");
    }
}
