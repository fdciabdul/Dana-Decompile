package id.dana.electronicmoney.bank.mandiri;

import android.content.Intent;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import id.dana.data.base.ErrorDetails;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.electronicmoney.interactor.ConfirmUpdateBalanceEmoney;
import id.dana.domain.electronicmoney.interactor.GenerateEmoneyTransId;
import id.dana.domain.electronicmoney.interactor.GetEmoneyReversal;
import id.dana.domain.electronicmoney.interactor.GetTopUpCommandEmoney;
import id.dana.domain.electronicmoney.interactor.InquireBalanceEmoney;
import id.dana.domain.electronicmoney.model.response.EmoneyCardInfo;
import id.dana.domain.electronicmoney.model.response.EmoneyGenerateTransId;
import id.dana.domain.electronicmoney.model.response.EmoneyReversal;
import id.dana.electronicmoney.BaseElectronicMoneyManager;
import id.dana.electronicmoney.ElectronicMoneyCallback;
import id.dana.electronicmoney.activity.ElectronicMoneyActivity;
import id.dana.electronicmoney.bank.mandiri.constants.EmoneyMandiriErrorCode;
import id.dana.electronicmoney.bank.mandiri.constants.MandiriApdu;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;
import id.dana.electronicmoney.util.ElectronicMoneyUtils;
import id.dana.network.exception.NetworkException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020)\u0012\u0006\u0010\b\u001a\u00020&\u0012\u0006\u0010\u0013\u001a\u00020#\u0012\u0006\u00105\u001a\u00020/\u0012\u0006\u00106\u001a\u00020\u001e¢\u0006\u0004\b7\u00108J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\nJ\u001f\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\t\u0010\u0010J\u000f\u0010\t\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\t\u0010\u0011J\u001f\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0005\u0010\u0010J/\u0010\t\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0012\u0010!\u001a\u00020 X\u0087\"¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010*R\u0012\u0010.\u001a\u00020,X\u0087\u0002¢\u0006\u0006\n\u0004\b%\u0010-R\u0012\u0010\u0016\u001a\u00020,X\u0087\u0002¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010\u0018\u001a\u00020/8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u00100R\u0012\u0010\u001c\u001a\u00020\u0007X\u0087\u0002¢\u0006\u0006\n\u0004\b+\u0010\u0017R\u0018\u00104\u001a\u000202*\u0002018CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u00103\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "Lid/dana/electronicmoney/BaseElectronicMoneyManager;", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "p0", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p1", "PlaceComponentResult", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthRequestContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Intent;", "Lid/dana/electronicmoney/ElectronicMoneyCallback;", "", "(Landroid/content/Intent;Lid/dana/electronicmoney/ElectronicMoneyCallback;)V", "()V", "Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "p2", "Lid/dana/electronicmoney/BalanceResult;", "(Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleImpl", "Ljava/lang/String;", "GetContactSyncConfig", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "KClassImpl$Data$declaredNonStaticMembers$2", "initRecordTimeStamp", "MyBillsEntityDataFactory", "Lid/dana/domain/electronicmoney/interactor/ConfirmUpdateBalanceEmoney;", "Lid/dana/domain/electronicmoney/interactor/ConfirmUpdateBalanceEmoney;", "Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;", "electronicMoneyMixpanelTracker", "Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;", "Lid/dana/domain/electronicmoney/interactor/GetEmoneyReversal;", "Lid/dana/domain/electronicmoney/interactor/GetEmoneyReversal;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/electronicmoney/interactor/GenerateEmoneyTransId;", "Lid/dana/domain/electronicmoney/interactor/GenerateEmoneyTransId;", "moveToNextValue", "Lid/dana/domain/electronicmoney/interactor/InquireBalanceEmoney;", "Lid/dana/domain/electronicmoney/interactor/InquireBalanceEmoney;", "lookAheadTest", "", "I", "getErrorConfigVersion", "Lid/dana/domain/electronicmoney/interactor/GetTopUpCommandEmoney;", "Lid/dana/domain/electronicmoney/interactor/GetTopUpCommandEmoney;", "Landroid/nfc/tech/IsoDep;", "", "(Landroid/nfc/tech/IsoDep;)Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p3", "p4", "<init>", "(Lid/dana/domain/electronicmoney/interactor/InquireBalanceEmoney;Lid/dana/domain/electronicmoney/interactor/GenerateEmoneyTransId;Lid/dana/domain/electronicmoney/interactor/GetEmoneyReversal;Lid/dana/domain/electronicmoney/interactor/GetTopUpCommandEmoney;Lid/dana/domain/electronicmoney/interactor/ConfirmUpdateBalanceEmoney;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MandiriEmoneyManager implements BaseElectronicMoneyManager {
    public final ConfirmUpdateBalanceEmoney BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final InquireBalanceEmoney lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GetEmoneyReversal NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public int getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final GenerateEmoneyTransId moveToNextValue;
    @Inject
    public ElectronicMoneyAnalyticTracker electronicMoneyMixpanelTracker;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public BridgeCallback KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public int scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String initRecordTimeStamp;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final GetTopUpCommandEmoney GetContactSyncConfig;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String PlaceComponentResult;

    @Override // id.dana.electronicmoney.BaseElectronicMoneyManager
    public final void PlaceComponentResult(Intent p0, ElectronicMoneyCallback p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
    }

    @Inject
    public MandiriEmoneyManager(InquireBalanceEmoney inquireBalanceEmoney, GenerateEmoneyTransId generateEmoneyTransId, GetEmoneyReversal getEmoneyReversal, GetTopUpCommandEmoney getTopUpCommandEmoney, ConfirmUpdateBalanceEmoney confirmUpdateBalanceEmoney) {
        Intrinsics.checkNotNullParameter(inquireBalanceEmoney, "");
        Intrinsics.checkNotNullParameter(generateEmoneyTransId, "");
        Intrinsics.checkNotNullParameter(getEmoneyReversal, "");
        Intrinsics.checkNotNullParameter(getTopUpCommandEmoney, "");
        Intrinsics.checkNotNullParameter(confirmUpdateBalanceEmoney, "");
        this.lookAheadTest = inquireBalanceEmoney;
        this.moveToNextValue = generateEmoneyTransId;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getEmoneyReversal;
        this.GetContactSyncConfig = getTopUpCommandEmoney;
        this.BuiltInFictitiousFunctionClassFactory = confirmUpdateBalanceEmoney;
        this.initRecordTimeStamp = "";
        this.getAuthRequestContext = "";
        this.PlaceComponentResult = "";
        this.MyBillsEntityDataFactory = "";
    }

    @Override // id.dana.electronicmoney.BaseElectronicMoneyManager
    public final void BuiltInFictitiousFunctionClassFactory(Intent p0, ElectronicMoneyCallback p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Tag tag = (Tag) p0.getParcelableExtra("android.nfc.extra.TAG");
        if (tag == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(p1.getAuthRequestContext, Dispatchers.getIO(), null, new MandiriEmoneyManager$updateAndReadBalance$$inlined$executeInBackground$1(null, tag, this, p0.getStringExtra(ElectronicMoneyActivity.EXTRA_SOURCE_CLICK), p1), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119 A[Catch: Exception -> 0x013c, TryCatch #2 {Exception -> 0x013c, blocks: (B:14:0x0037, B:53:0x0138, B:43:0x0111, B:45:0x0119, B:49:0x0124, B:48:0x011e, B:50:0x0127), top: B:65:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0137 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v15, types: [id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object PlaceComponentResult(id.dana.electronicmoney.bank.mandiri.MandiriApduCommand r24, id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute r25, java.lang.String r26, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.BalanceResult> r27) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager.PlaceComponentResult(id.dana.electronicmoney.bank.mandiri.MandiriApduCommand, id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object BuiltInFictitiousFunctionClassFactory(EmoneyCardAttribute emoneyCardAttribute, final String str, Continuation<? super EmoneyApiResult> continuation) {
        int i = this.scheduleImpl + 1;
        this.scheduleImpl = i;
        if (i > 3) {
            this.scheduleImpl = 0;
            String str2 = this.MyBillsEntityDataFactory;
            return new EmoneyApiResult(false, EmoneyMandiriErrorCode.THREE_TIMES_LIMIT, str, this.getAuthRequestContext, str2, null, null, null, false, false, 992, null);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        this.MyBillsEntityDataFactory = "";
        this.getAuthRequestContext = "";
        this.lookAheadTest.execute(new InquireBalanceEmoney.Params(emoneyCardAttribute.getAuthRequestContext(str, this.getAuthRequestContext, this.PlaceComponentResult)), new Function1<EmoneyCardInfo, Unit>() { // from class: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$inquiryBalance$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EmoneyCardInfo emoneyCardInfo) {
                invoke2(emoneyCardInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EmoneyCardInfo emoneyCardInfo) {
                String str3;
                String str4;
                Intrinsics.checkNotNullParameter(emoneyCardInfo, "");
                MandiriEmoneyManager mandiriEmoneyManager = MandiriEmoneyManager.this;
                String apiVersion = emoneyCardInfo.getApiVersion();
                if (apiVersion == null) {
                    apiVersion = "";
                }
                mandiriEmoneyManager.MyBillsEntityDataFactory = apiVersion;
                MandiriEmoneyManager mandiriEmoneyManager2 = MandiriEmoneyManager.this;
                String approvalCode = emoneyCardInfo.getApprovalCode();
                if (approvalCode == null) {
                    approvalCode = "";
                }
                mandiriEmoneyManager2.getAuthRequestContext = approvalCode;
                MandiriEmoneyManager mandiriEmoneyManager3 = MandiriEmoneyManager.this;
                String pendingTopup = emoneyCardInfo.getPendingTopup();
                if (pendingTopup == null) {
                    pendingTopup = "";
                }
                mandiriEmoneyManager3.PlaceComponentResult = pendingTopup;
                CancellableContinuation<EmoneyApiResult> cancellableContinuation = cancellableContinuationImpl2;
                boolean success = emoneyCardInfo.getSuccess();
                String errorCode = emoneyCardInfo.getErrorCode();
                String str5 = errorCode == null ? "" : errorCode;
                String apiVersion2 = emoneyCardInfo.getApiVersion();
                String str6 = apiVersion2 == null ? "" : apiVersion2;
                str3 = MandiriEmoneyManager.this.getAuthRequestContext;
                str4 = MandiriEmoneyManager.this.PlaceComponentResult;
                EmoneyApiResult emoneyApiResult = new EmoneyApiResult(success, str5, str, str3, str6, str4, emoneyCardInfo.getSession(), emoneyCardInfo.getData(), false, false, 768, null);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(emoneyApiResult));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$inquiryBalance$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                String str3;
                String str4;
                Intrinsics.checkNotNullParameter(th, "");
                if (!(th instanceof NetworkException)) {
                    MandiriEmoneyManager.this.getAuthRequestContext = "";
                    MandiriEmoneyManager.this.MyBillsEntityDataFactory = "";
                    MandiriEmoneyManager.this.PlaceComponentResult = "";
                } else {
                    Map<String, String> extendInfo = ((NetworkException) th).getExtendInfo();
                    if (extendInfo != null) {
                        MandiriEmoneyManager mandiriEmoneyManager = MandiriEmoneyManager.this;
                        String str5 = extendInfo.get("approvalCode");
                        if (str5 == null) {
                            str5 = "";
                        }
                        mandiriEmoneyManager.getAuthRequestContext = str5;
                        String str6 = extendInfo.get("cardType");
                        if (str6 == null) {
                            str6 = "";
                        }
                        mandiriEmoneyManager.MyBillsEntityDataFactory = str6;
                        String str7 = extendInfo.get("amount");
                        if (str7 == null) {
                            str7 = "";
                        }
                        mandiriEmoneyManager.PlaceComponentResult = str7;
                    }
                }
                ErrorDetails errorDetails = ErrorDetails.INSTANCE.get(th);
                CancellableContinuation<EmoneyApiResult> cancellableContinuation = cancellableContinuationImpl2;
                String code = errorDetails.getCode();
                String str8 = code == null ? "" : code;
                str3 = MandiriEmoneyManager.this.MyBillsEntityDataFactory;
                str4 = MandiriEmoneyManager.this.getAuthRequestContext;
                LinkedHashMap extendInfo2 = errorDetails.getExtendInfo();
                if (extendInfo2 == null) {
                    extendInfo2 = new LinkedHashMap();
                }
                EmoneyApiResult emoneyApiResult = new EmoneyApiResult(false, str8, str, str4, str3, null, null, extendInfo2, false, false, 864, null);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(emoneyApiResult));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011a A[PHI: r1
      0x011a: PHI (r1v17 java.lang.Object) = (r1v15 java.lang.Object), (r1v1 java.lang.Object) binds: [B:39:0x0117, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute r24, kotlin.coroutines.Continuation<? super id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult> r25) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager.BuiltInFictitiousFunctionClassFactory(id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getAuthRequestContext")
    public static boolean getAuthRequestContext(IsoDep isoDep) {
        ElectronicMoneyUtils electronicMoneyUtils = ElectronicMoneyUtils.INSTANCE;
        ElectronicMoneyUtils electronicMoneyUtils2 = ElectronicMoneyUtils.INSTANCE;
        byte[] transceive = isoDep.transceive(ElectronicMoneyUtils.BuiltInFictitiousFunctionClassFactory(MandiriApdu.EMONEY_AVAILABILITY));
        Intrinsics.checkNotNullExpressionValue(transceive, "");
        return Intrinsics.areEqual(ElectronicMoneyUtils.PlaceComponentResult(transceive), "9000");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        BridgeCallback bridgeCallback = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bridgeCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    public final Object getAuthRequestContext(Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        this.moveToNextValue.execute(NoParams.INSTANCE, new Function1<EmoneyGenerateTransId, Unit>() { // from class: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$getTransactionId$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EmoneyGenerateTransId emoneyGenerateTransId) {
                invoke2(emoneyGenerateTransId);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EmoneyGenerateTransId emoneyGenerateTransId) {
                Intrinsics.checkNotNullParameter(emoneyGenerateTransId, "");
                MandiriEmoneyManager mandiriEmoneyManager = MandiriEmoneyManager.this;
                String bizId = emoneyGenerateTransId.getBizId();
                Intrinsics.checkNotNullParameter(bizId, "");
                mandiriEmoneyManager.initRecordTimeStamp = bizId;
                CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(emoneyGenerateTransId.getBizId()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$getTransactionId$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(th)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object getAuthRequestContext(final EmoneyCardAttribute emoneyCardAttribute, Continuation<? super EmoneyApiResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        String str = emoneyCardAttribute.PlaceComponentResult;
        if (str == null) {
            str = "";
        }
        String str2 = emoneyCardAttribute.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Map<String, String> map = emoneyCardAttribute.lookAheadTest;
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        this.GetContactSyncConfig.execute(new GetTopUpCommandEmoney.Params(str, "MANDIRI", str2, map), new Function1<EmoneyCardInfo, Unit>() { // from class: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$getTopUpCommand$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EmoneyCardInfo emoneyCardInfo) {
                invoke2(emoneyCardInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EmoneyCardInfo emoneyCardInfo) {
                String str3;
                String str4;
                Intrinsics.checkNotNullParameter(emoneyCardInfo, "");
                CancellableContinuation<EmoneyApiResult> cancellableContinuation = cancellableContinuationImpl2;
                boolean success = emoneyCardInfo.getSuccess();
                String errorCode = emoneyCardInfo.getErrorCode();
                str3 = this.MyBillsEntityDataFactory;
                String str5 = emoneyCardInfo.getData().get("approvalCode");
                if (str5 == null) {
                    str5 = emoneyCardInfo.getApprovalCode();
                }
                String str6 = str5;
                String str7 = this.initRecordTimeStamp;
                Map<String, String> data = emoneyCardInfo.getData();
                MandiriEmoneyManager mandiriEmoneyManager = this;
                EmoneyCardAttribute emoneyCardAttribute2 = emoneyCardAttribute;
                String str8 = emoneyCardInfo.getData().get("message");
                data.put("message", str8 != null ? str8 : "");
                str4 = mandiriEmoneyManager.PlaceComponentResult;
                data.put("amount", str4);
                data.put("lastBalance", emoneyCardAttribute2.moveToNextValue);
                EmoneyApiResult emoneyApiResult = new EmoneyApiResult(success, errorCode, str7, str6, str3, null, null, data, false, false, 864, null);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(emoneyApiResult));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$getTopUpCommand$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                String str3;
                String str4;
                Intrinsics.checkNotNullParameter(th, "");
                ErrorDetails errorDetails = ErrorDetails.INSTANCE.get(th);
                CancellableContinuation<EmoneyApiResult> cancellableContinuation = cancellableContinuationImpl2;
                String code = errorDetails.getCode();
                String str5 = code == null ? "" : code;
                str3 = this.MyBillsEntityDataFactory;
                String str6 = this.initRecordTimeStamp;
                str4 = this.getAuthRequestContext;
                LinkedHashMap extendInfo = errorDetails.getExtendInfo();
                if (extendInfo == null) {
                    extendInfo = new LinkedHashMap();
                }
                EmoneyApiResult emoneyApiResult = new EmoneyApiResult(true, str5, str6, str4, str3, null, null, extendInfo, false, false, 864, null);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(emoneyApiResult));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object PlaceComponentResult(EmoneyCardAttribute emoneyCardAttribute, final String str, Continuation<? super EmoneyApiResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        String str2 = emoneyCardAttribute.PlaceComponentResult;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = emoneyCardAttribute.MyBillsEntityDataFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new GetEmoneyReversal.Params(str2, str3 != null ? str3 : "", emoneyCardAttribute.getAuthRequestContext(str, this.getAuthRequestContext, this.PlaceComponentResult)), new Function1<EmoneyReversal, Unit>() { // from class: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$doReversal$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EmoneyReversal emoneyReversal) {
                invoke2(emoneyReversal);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EmoneyReversal emoneyReversal) {
                String str4;
                String str5;
                Intrinsics.checkNotNullParameter(emoneyReversal, "");
                CancellableContinuation<EmoneyApiResult> cancellableContinuation = cancellableContinuationImpl2;
                boolean success = emoneyReversal.getSuccess();
                String errorCode = emoneyReversal.getErrorCode();
                str4 = this.MyBillsEntityDataFactory;
                str5 = this.getAuthRequestContext;
                Map<String, String> data = emoneyReversal.getData();
                String str6 = emoneyReversal.getData().get("message");
                data.put("message", str6 != null ? str6 : "");
                EmoneyApiResult emoneyApiResult = new EmoneyApiResult(success, errorCode, str, str5, str4, null, null, data, false, false, 864, null);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(emoneyApiResult));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager$doReversal$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                String str4;
                String str5;
                Intrinsics.checkNotNullParameter(th, "");
                ErrorDetails errorDetails = ErrorDetails.INSTANCE.get(th);
                CancellableContinuation<EmoneyApiResult> cancellableContinuation = cancellableContinuationImpl2;
                String code = errorDetails.getCode();
                String str6 = code == null ? "" : code;
                str4 = this.MyBillsEntityDataFactory;
                str5 = this.getAuthRequestContext;
                LinkedHashMap extendInfo = errorDetails.getExtendInfo();
                if (extendInfo == null) {
                    extendInfo = new LinkedHashMap();
                }
                EmoneyApiResult emoneyApiResult = new EmoneyApiResult(false, str6, str, str5, str4, null, null, extendInfo, false, false, 864, null);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(emoneyApiResult));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
