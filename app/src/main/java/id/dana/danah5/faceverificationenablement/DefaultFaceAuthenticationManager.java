package id.dana.danah5.faceverificationenablement;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.challenge.ChallengeControl;
import id.dana.constants.ErrorCode;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.bioutility.BioUtilityResultFactory;
import id.dana.danah5.bioutility.BioUtilitySuccessResult;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.auth.face.result.FaceAuthenticationResult;
import id.dana.domain.auth.face.result.SecurityContext;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.transferaccount.interactor.DeletionChangeNumber;
import id.dana.domain.transferaccount.interactor.SaveTransferAccountToken;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthenticationCallback;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.network.exception.NetworkException;
import id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iBA\b\u0007\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010$\u001a\u00020b\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010\u001b\u001a\u00020[¢\u0006\u0004\bg\u0010hJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ3\u0010\u001e\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u000bJ+\u0010!\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u000bJ\u000f\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u000bJ\u0017\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J+\u00100\u001a\u00020\u00072\u001a\u0010/\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070-H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b6\u0010\u000bJ\u0018\u00108\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u000207H\u0096\u0001¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\fH\u0002¢\u0006\u0004\b;\u0010<J+\u0010=\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\fH\u0016¢\u0006\u0004\b@\u0010<J\u0010\u0010A\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\bA\u0010\u000bJ \u0010C\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\bE\u0010\u000bJ\u0010\u0010F\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\bF\u0010\u000bJ\u001a\u0010G\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0001¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\bI\u0010\u000bJ\u0010\u0010J\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\bJ\u0010\u000bJ\u0010\u0010K\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\bK\u0010\u000bJ \u0010L\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\bL\u0010DJ\u0010\u0010M\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\bM\u0010\u000bJ\u0010\u0010N\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\bN\u0010\u000bR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b*\u0010OR\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b3\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\u001b\u001a\u00020[8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b^\u0010_R*\u0010`\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070-8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010$\u001a\u00020b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010WR\u0014\u0010e\u001a\u00020d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b?\u0010W"}, d2 = {"Lid/dana/danah5/faceverificationenablement/DefaultFaceAuthenticationManager;", "Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker;", "", "faceAuthNew", "Lid/dana/domain/auth/face/result/FaceAuthenticationResult;", "faceAuthenticationResult", "", "decideAction", "(ZLid/dana/domain/auth/face/result/FaceAuthenticationResult;)V", "doEnroll", "()V", "", BioUtilityBridge.SECURITY_ID, "continueSwitchFaceAuth", "doFaceAuth", "(ZLjava/lang/String;Z)V", "", "Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "verificationMethods", RecordError.KEY_PUB_KEY, "doRiskChallenge", "(ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "", "errorCode", "errorCodeBioUtility", "(I)Ljava/lang/String;", "finishForceDanaVizEnroll", IpcMessageConstants.EXTRA_EVENT, "source", "launchFaceAuth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "navigateToTransferAccount", "onFaceSwitchRiskChallenge", "(Ljava/lang/String;Ljava/lang/String;Z)V", "runDeletionChangeNumber", "saveTransferAccountToken", "", "throwable", "sendErrorResponseChangeNumber", "(Ljava/lang/Throwable;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "setActivity", "(Landroid/app/Activity;)V", "Lkotlin/Function2;", "Landroid/content/Intent;", "activityResult", "setActivityResult", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "setBridgeCallback", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "setNumberOfAttempts", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "setSource", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)V", "userId", "startEnrollFaceAuth", "(Ljava/lang/String;)V", "switchFaceAuth", "(ZLjava/lang/String;Ljava/lang/String;)V", "token", "tokenTransferAccount", "trackEnrollCanceled", "message", "trackEnrollFailed", "(ILjava/lang/String;)V", "trackEnrollStarted", "trackEnrollSucceed", "trackToggleOffFailed", "(Ljava/lang/Integer;)V", "trackToggleOffStarted", "trackToggleOffSucceed", "trackVerifyCanceled", "trackVerifyFailed", "trackVerifyStarted", "trackVerifySucceed", "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "danaVizTrackerImpl", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/domain/transferaccount/interactor/DeletionChangeNumber;", "deletionChangeNumber", "Lid/dana/domain/transferaccount/interactor/DeletionChangeNumber;", "Ljava/lang/String;", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", BioUtilityBridge.FACE_AUTHENTICATION, "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;", "Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;", "Lid/dana/domain/account/interactor/GetUserId;", "getUserId", "Lid/dana/domain/account/interactor/GetUserId;", "onRiskChallenged", "Lkotlin/jvm/functions/Function2;", "Lid/dana/domain/transferaccount/interactor/SaveTransferAccountToken;", "Lid/dana/domain/transferaccount/interactor/SaveTransferAccountToken;", "Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;", "switchFaceAuthentication", "Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;", "<init>", "(Lid/dana/domain/auth/face/interactor/SwitchFaceAuthentication;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/lib/bio/faceauth/FaceAuthentication;Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;Lid/dana/domain/transferaccount/interactor/SaveTransferAccountToken;Lid/dana/domain/transferaccount/interactor/DeletionChangeNumber;Lid/dana/domain/resetpin/interactor/FinishForceDanaVizEnroll;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultFaceAuthenticationManager implements FaceAuthenticationManager, DanaVizTracker {
    public static final String SOURCE_CASH_OUT = "SOURCE_CASH_OUT";
    public static final String SOURCE_DANA_PROTECTION = "DANA_PROTECTION";
    public static final String SOURCE_REGISTRATION = "REGISTRATION";
    public static final String SOURCE_TRANSFER_ACCOUNT = "TRANSFER_ACCOUNT";
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private final DanaVizTrackerImpl danaVizTrackerImpl;
    private final DeletionChangeNumber deletionChangeNumber;
    private String eventName;
    private final FaceAuthentication faceAuthentication;
    private final FinishForceDanaVizEnroll finishForceDanaVizEnroll;
    private final GetUserId getUserId;
    private Function2<? super Intent, ? super Integer, Unit> onRiskChallenged;
    private final SaveTransferAccountToken saveTransferAccountToken;
    private String source;
    private final SwitchFaceAuthentication switchFaceAuthentication;
    private String token;

    /* JADX INFO: Access modifiers changed from: private */
    public final String errorCodeBioUtility(int errorCode) {
        return errorCode != 1001 ? errorCode != 1003 ? errorCode != 1005 ? errorCode != 1006 ? "001" : "005" : "004" : "003" : "002";
    }

    @Override // id.dana.analytics.tracker.danaviz.DanaVizTracker
    public final void setSource(DanaVizTracker.Source source) {
        Intrinsics.checkNotNullParameter(source, "");
        this.danaVizTrackerImpl.setSource(source);
    }

    public final void trackEnrollCanceled() {
        this.danaVizTrackerImpl.PlaceComponentResult();
    }

    public final void trackEnrollFailed(int errorCode, String message) {
        Intrinsics.checkNotNullParameter(message, "");
        this.danaVizTrackerImpl.getAuthRequestContext(errorCode, message);
    }

    public final void trackEnrollStarted() {
        this.danaVizTrackerImpl.MyBillsEntityDataFactory();
    }

    public final void trackEnrollSucceed() {
        this.danaVizTrackerImpl.BuiltInFictitiousFunctionClassFactory();
    }

    public final void trackToggleOffFailed(Integer errorCode) {
        this.danaVizTrackerImpl.MyBillsEntityDataFactory(errorCode);
    }

    public final void trackToggleOffStarted() {
        this.danaVizTrackerImpl.getAuthRequestContext();
    }

    public final void trackToggleOffSucceed() {
        this.danaVizTrackerImpl.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void trackVerifyCanceled() {
        this.danaVizTrackerImpl.lookAheadTest();
    }

    public final void trackVerifyFailed(int errorCode, String message) {
        Intrinsics.checkNotNullParameter(message, "");
        this.danaVizTrackerImpl.KClassImpl$Data$declaredNonStaticMembers$2(errorCode, message);
    }

    public final void trackVerifyStarted() {
        this.danaVizTrackerImpl.getErrorConfigVersion();
    }

    public final void trackVerifySucceed() {
        this.danaVizTrackerImpl.scheduleImpl();
    }

    @Inject
    public DefaultFaceAuthenticationManager(SwitchFaceAuthentication switchFaceAuthentication, GetUserId getUserId, FaceAuthentication faceAuthentication, DanaVizTrackerImpl danaVizTrackerImpl, SaveTransferAccountToken saveTransferAccountToken, DeletionChangeNumber deletionChangeNumber, FinishForceDanaVizEnroll finishForceDanaVizEnroll) {
        Intrinsics.checkNotNullParameter(switchFaceAuthentication, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(faceAuthentication, "");
        Intrinsics.checkNotNullParameter(danaVizTrackerImpl, "");
        Intrinsics.checkNotNullParameter(saveTransferAccountToken, "");
        Intrinsics.checkNotNullParameter(deletionChangeNumber, "");
        Intrinsics.checkNotNullParameter(finishForceDanaVizEnroll, "");
        this.switchFaceAuthentication = switchFaceAuthentication;
        this.getUserId = getUserId;
        this.faceAuthentication = faceAuthentication;
        this.danaVizTrackerImpl = danaVizTrackerImpl;
        this.saveTransferAccountToken = saveTransferAccountToken;
        this.deletionChangeNumber = deletionChangeNumber;
        this.finishForceDanaVizEnroll = finishForceDanaVizEnroll;
    }

    @Override // id.dana.danah5.faceverificationenablement.FaceAuthenticationManager
    public final void setBridgeCallback(BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        this.bridgeCallback = bridgeCallback;
    }

    @Override // id.dana.danah5.faceverificationenablement.FaceAuthenticationManager
    public final void setActivityResult(Function2<? super Intent, ? super Integer, Unit> activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "");
        this.onRiskChallenged = activityResult;
    }

    @Override // id.dana.danah5.faceverificationenablement.FaceAuthenticationManager
    public final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.activity = activity;
    }

    @Override // id.dana.danah5.faceverificationenablement.FaceAuthenticationManager
    public final void tokenTransferAccount(String token) {
        Intrinsics.checkNotNullParameter(token, "");
        this.token = token;
    }

    @Override // id.dana.danah5.faceverificationenablement.FaceAuthenticationManager
    public final void launchFaceAuth(String eventName, String source, String securityId, boolean faceAuthNew) {
        Intrinsics.checkNotNullParameter(securityId, "");
        this.eventName = eventName;
        this.source = source;
        if (source != null) {
            switch (source.hashCode()) {
                case -2093922362:
                    if (source.equals(SOURCE_CASH_OUT)) {
                        doFaceAuth(faceAuthNew, securityId, false);
                        return;
                    }
                    break;
                case -848803399:
                    if (source.equals(SOURCE_TRANSFER_ACCOUNT)) {
                        if (this.token == null) {
                            sendErrorResponseChangeNumber(new IllegalStateException("Token is required"));
                            return;
                        }
                        setSource(DanaVizTracker.Source.TRANSFER_ACCOUNT);
                        doFaceAuth(faceAuthNew, securityId, false);
                        return;
                    }
                    break;
                case -788873336:
                    if (source.equals("DANA_PROTECTION")) {
                        setSource(DanaVizTracker.Source.DANA_PROTECTION);
                        switchFaceAuth(faceAuthNew, "", source);
                        return;
                    }
                    break;
                case 966971577:
                    if (source.equals(SOURCE_REGISTRATION)) {
                        setSource(DanaVizTracker.Source.REGISTRATION);
                        switchFaceAuth(faceAuthNew, "", source);
                        return;
                    }
                    break;
            }
        }
        switchFaceAuth$default(this, true, "", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void switchFaceAuth$default(DefaultFaceAuthenticationManager defaultFaceAuthenticationManager, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        defaultFaceAuthenticationManager.switchFaceAuth(z, str, str2);
    }

    private final void switchFaceAuth(final boolean faceAuthNew, String securityId, String source) {
        this.switchFaceAuthentication.execute(new SwitchFaceAuthentication.Params(faceAuthNew, securityId, source), new Function1<FaceAuthenticationResult, Unit>() { // from class: id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager$switchFaceAuth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FaceAuthenticationResult faceAuthenticationResult) {
                invoke2(faceAuthenticationResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FaceAuthenticationResult faceAuthenticationResult) {
                Intrinsics.checkNotNullParameter(faceAuthenticationResult, "");
                DefaultFaceAuthenticationManager.this.decideAction(faceAuthNew, faceAuthenticationResult);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager$switchFaceAuth$2
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
                String str;
                BridgeCallback bridgeCallback;
                BridgeCallback bridgeCallback2;
                BridgeCallback bridgeCallback3;
                BridgeCallback bridgeCallback4;
                Intrinsics.checkNotNullParameter(th, "");
                BridgeCallback bridgeCallback5 = null;
                if (!(th instanceof NetworkException)) {
                    str = DefaultFaceAuthenticationManager.this.eventName;
                    if (Intrinsics.areEqual(str, FaceAuthenticationBridge.EVENT_NAME_ENABLE_FACE_AUTH_SWITCH)) {
                        bridgeCallback2 = DefaultFaceAuthenticationManager.this.bridgeCallback;
                        if (bridgeCallback2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bridgeCallback5 = bridgeCallback2;
                        }
                        bridgeCallback5.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getSWITCH_FAILED());
                        return;
                    }
                    bridgeCallback = DefaultFaceAuthenticationManager.this.bridgeCallback;
                    if (bridgeCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback5 = bridgeCallback;
                    }
                    bridgeCallback5.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getENROLLMENT_FAILED());
                } else if (Intrinsics.areEqual(((NetworkException) th).getErrorCode(), "AE15101858018086")) {
                    bridgeCallback4 = DefaultFaceAuthenticationManager.this.bridgeCallback;
                    if (bridgeCallback4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback5 = bridgeCallback4;
                    }
                    bridgeCallback5.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getRISK_REJECT());
                } else {
                    bridgeCallback3 = DefaultFaceAuthenticationManager.this.bridgeCallback;
                    if (bridgeCallback3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback5 = bridgeCallback3;
                    }
                    bridgeCallback5.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getENROLLMENT_FAILED());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decideAction(boolean faceAuthNew, FaceAuthenticationResult faceAuthenticationResult) {
        String action = faceAuthenticationResult.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -795785494) {
                if (action.equals(Companion.ActionConstant.TO_ENROLL)) {
                    doEnroll();
                    return;
                }
                return;
            }
            BridgeCallback bridgeCallback = null;
            if (hashCode == -407149037) {
                if (action.equals(Companion.ActionConstant.TO_RISK)) {
                    List<VerificationMethodInfo> verificationMethods = faceAuthenticationResult.getVerificationMethods();
                    String securityId = faceAuthenticationResult.getSecurityId();
                    SecurityContext securityContext = faceAuthenticationResult.getSecurityContext();
                    doRiskChallenge(faceAuthNew, verificationMethods, securityId, securityContext != null ? securityContext.getPubKey() : null);
                }
            } else if (hashCode == 458732895 && action.equals(Companion.ActionConstant.SUCCESS_ENABLE)) {
                BridgeCallback bridgeCallback2 = this.bridgeCallback;
                if (bridgeCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback2;
                }
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }
    }

    private final void doRiskChallenge(boolean faceAuthNew, List<VerificationMethodInfo> verificationMethods, String securityId, String pubKey) {
        if (verificationMethods != null) {
            Iterator<VerificationMethodInfo> it = verificationMethods.iterator();
            while (it.hasNext()) {
                String verificationMethod = it.next().getVerificationMethod();
                if (Intrinsics.areEqual(verificationMethod, "PASSWORD")) {
                    onFaceSwitchRiskChallenge(securityId, pubKey, faceAuthNew);
                } else if (Intrinsics.areEqual(verificationMethod, "MIC_FACE")) {
                    doFaceAuth$default(this, faceAuthNew, securityId, false, 4, null);
                }
            }
        }
    }

    private final void onFaceSwitchRiskChallenge(String securityId, String pubKey, boolean faceAuthNew) {
        Activity activity = this.activity;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        Function2<? super Intent, ? super Integer, Unit> function2 = this.onRiskChallenged;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            function2 = null;
        }
        ChallengeControl.Builder builder = new ChallengeControl.Builder(activity, function2);
        builder.scheduleImpl = "face_activation";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = ChallengeControl.Key.FACE_ACTIVATION_REGISTRATION;
        new ChallengeControl(builder.MyBillsEntityDataFactory(false, securityId, pubKey, faceAuthNew), defaultConstructorMarker).getAuthRequestContext();
    }

    static /* synthetic */ void doFaceAuth$default(DefaultFaceAuthenticationManager defaultFaceAuthenticationManager, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        defaultFaceAuthenticationManager.doFaceAuth(z, str, z2);
    }

    private final void doFaceAuth(final boolean faceAuthNew, String securityId, final boolean continueSwitchFaceAuth) {
        trackVerifyStarted();
        FaceAuthentication faceAuthentication = this.faceAuthentication;
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        Activity activity2 = activity;
        if (securityId == null) {
            securityId = "";
        }
        faceAuthentication.PlaceComponentResult(activity2, securityId, new FaceAuthenticationCallback() { // from class: id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager$doFaceAuth$1
            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onCancel() {
                String str;
                BridgeCallback bridgeCallback;
                BridgeCallback bridgeCallback2;
                str = DefaultFaceAuthenticationManager.this.source;
                BridgeCallback bridgeCallback3 = null;
                if (!Intrinsics.areEqual(str, DefaultFaceAuthenticationManager.SOURCE_CASH_OUT)) {
                    bridgeCallback = DefaultFaceAuthenticationManager.this.bridgeCallback;
                    if (bridgeCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback3 = bridgeCallback;
                    }
                    bridgeCallback3.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getUSER_CANCEL());
                } else {
                    JSONObject error = BioUtilityResultFactory.getError("003");
                    bridgeCallback2 = DefaultFaceAuthenticationManager.this.bridgeCallback;
                    if (bridgeCallback2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback3 = bridgeCallback2;
                    }
                    bridgeCallback3.sendJSONResponse(error);
                }
                DefaultFaceAuthenticationManager.this.trackVerifyCanceled();
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onFailed(DanaBioException.FaceAuthenticationException exception) {
                String str;
                BridgeCallback bridgeCallback;
                String errorCodeBioUtility;
                BridgeCallback bridgeCallback2;
                Intrinsics.checkNotNullParameter(exception, "");
                str = DefaultFaceAuthenticationManager.this.source;
                BridgeCallback bridgeCallback3 = null;
                if (Intrinsics.areEqual(str, DefaultFaceAuthenticationManager.SOURCE_CASH_OUT)) {
                    errorCodeBioUtility = DefaultFaceAuthenticationManager.this.errorCodeBioUtility(exception.getErrorCode());
                    JSONObject error = BioUtilityResultFactory.getError(errorCodeBioUtility);
                    bridgeCallback2 = DefaultFaceAuthenticationManager.this.bridgeCallback;
                    if (bridgeCallback2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback3 = bridgeCallback2;
                    }
                    bridgeCallback3.sendJSONResponse(error);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.UAP_FACE_AUTHENTICATION_PREFIX);
                    sb.append(getClass().getName());
                    sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.UAP_FACE_AUTHENTICATION, sb.toString(), exception);
                    bridgeCallback = DefaultFaceAuthenticationManager.this.bridgeCallback;
                    if (bridgeCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback3 = bridgeCallback;
                    }
                    bridgeCallback3.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getSWITCH_FAILED());
                }
                DefaultFaceAuthenticationManager.this.trackVerifyFailed(exception.getErrorCode(), exception.getMessage());
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onSuccess(String verifyId) {
                String str;
                DanaVizTrackerImpl danaVizTrackerImpl;
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(verifyId, "");
                if (!continueSwitchFaceAuth) {
                    str = DefaultFaceAuthenticationManager.this.source;
                    if (Intrinsics.areEqual(str, DefaultFaceAuthenticationManager.SOURCE_CASH_OUT)) {
                        JSONObject result = BioUtilityResultFactory.getResult(new BioUtilitySuccessResult(verifyId));
                        bridgeCallback = DefaultFaceAuthenticationManager.this.bridgeCallback;
                        if (bridgeCallback == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            bridgeCallback = null;
                        }
                        bridgeCallback.sendJSONResponse(result);
                    } else if (Intrinsics.areEqual(str, DefaultFaceAuthenticationManager.SOURCE_TRANSFER_ACCOUNT)) {
                        danaVizTrackerImpl = DefaultFaceAuthenticationManager.this.danaVizTrackerImpl;
                        danaVizTrackerImpl.scheduleImpl();
                        DefaultFaceAuthenticationManager.this.saveTransferAccountToken();
                    }
                } else {
                    DefaultFaceAuthenticationManager.switchFaceAuth$default(DefaultFaceAuthenticationManager.this, faceAuthNew, verifyId, null, 4, null);
                }
                DefaultFaceAuthenticationManager.this.trackVerifySucceed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveTransferAccountToken() {
        SaveTransferAccountToken saveTransferAccountToken = this.saveTransferAccountToken;
        String str = this.token;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        saveTransferAccountToken.execute(str, new Function1<Boolean, Unit>() { // from class: id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager$saveTransferAccountToken$1
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
                DefaultFaceAuthenticationManager.this.runDeletionChangeNumber();
            }
        }, new DefaultFaceAuthenticationManager$saveTransferAccountToken$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runDeletionChangeNumber() {
        this.deletionChangeNumber.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager$runDeletionChangeNumber$1
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
                DefaultFaceAuthenticationManager.this.navigateToTransferAccount();
            }
        }, new DefaultFaceAuthenticationManager$runDeletionChangeNumber$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendErrorResponseChangeNumber(Throwable throwable) {
        DanaLog.BuiltInFictitiousFunctionClassFactory("FaceAuthManager", throwable.getMessage(), throwable);
        BridgeCallback bridgeCallback = null;
        if (throwable instanceof NetworkException) {
            String errorCode = ((NetworkException) throwable).getErrorCode();
            if (Intrinsics.areEqual(errorCode, ErrorCode.USER_IS_FREEZED)) {
                BridgeCallback bridgeCallback2 = this.bridgeCallback;
                if (bridgeCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback2;
                }
                bridgeCallback.sendJSONResponse(BioUtilityResultFactory.getError(17));
                return;
            } else if (Intrinsics.areEqual(errorCode, ErrorCode.BALANCE_LIMIT_EXCEED)) {
                BridgeCallback bridgeCallback3 = this.bridgeCallback;
                if (bridgeCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback3;
                }
                bridgeCallback.sendJSONResponse(BioUtilityResultFactory.getError(18));
                return;
            } else {
                BridgeCallback bridgeCallback4 = this.bridgeCallback;
                if (bridgeCallback4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback4;
                }
                bridgeCallback.sendJSONResponse(BioUtilityResultFactory.getError(16));
                return;
            }
        }
        BridgeCallback bridgeCallback5 = this.bridgeCallback;
        if (bridgeCallback5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bridgeCallback = bridgeCallback5;
        }
        bridgeCallback.sendJSONResponse(BioUtilityResultFactory.getError(16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToTransferAccount() {
        Activity activity = this.activity;
        Activity activity2 = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        Intent intent = new Intent(activity, TransferAccountStatusActivity.class);
        Activity activity3 = this.activity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            activity2 = activity3;
        }
        activity2.startActivity(intent);
    }

    private final void doEnroll() {
        this.getUserId.execute(new DefaultObserver<String>() { // from class: id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager$doEnroll$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onNext(String userId) {
                Intrinsics.checkNotNullParameter(userId, "");
                DefaultFaceAuthenticationManager.this.startEnrollFaceAuth(userId);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable e) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(e, "");
                bridgeCallback = DefaultFaceAuthenticationManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getENROLLMENT_FAILED());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startEnrollFaceAuth(String userId) {
        trackEnrollStarted();
        FaceAuthentication faceAuthentication = this.faceAuthentication;
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        faceAuthentication.MyBillsEntityDataFactory(activity, userId, MapsKt.mapOf(TuplesKt.to("sceneId", "dana_app_securitysetting"), TuplesKt.to("productCode", "FACE_ENROLL")), new FaceAuthenticationCallback() { // from class: id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager$startEnrollFaceAuth$1
            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onCancel() {
                BridgeCallback bridgeCallback;
                bridgeCallback = DefaultFaceAuthenticationManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getUSER_CANCEL());
                DefaultFaceAuthenticationManager.this.trackEnrollCanceled();
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onFailed(DanaBioException.FaceAuthenticationException exception) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(exception, "");
                bridgeCallback = DefaultFaceAuthenticationManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendJSONResponse(FaceAuthenticationResponse.INSTANCE.getENROLLMENT_FAILED());
                DefaultFaceAuthenticationManager.this.trackEnrollFailed(exception.getErrorCode(), exception.getMessage());
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onSuccess(String verifyId) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(verifyId, "");
                bridgeCallback = DefaultFaceAuthenticationManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                DefaultFaceAuthenticationManager.this.trackEnrollSucceed();
                DefaultFaceAuthenticationManager.this.finishForceDanaVizEnroll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishForceDanaVizEnroll() {
        CompletableUseCase.execute$default(this.finishForceDanaVizEnroll, NoParams.INSTANCE, null, null, 6, null);
    }

    public final void setNumberOfAttempts() {
        this.danaVizTrackerImpl.getAuthRequestContext++;
    }
}
