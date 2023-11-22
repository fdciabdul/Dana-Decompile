package id.dana.danah5.twilioverifysecurityproduct;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.google.common.net.HttpHeaders;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.verifypush.mapper.ChallengeModelMapperKt;
import id.dana.challenge.verifypush.model.request.TwilioChallengeModel;
import id.dana.constants.ErrorCode;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.constant.BridgeName;
import id.dana.domain.DefaultObserver;
import id.dana.domain.twilio.interactor.CheckTwilioEnrollmentStatus;
import id.dana.domain.twilio.interactor.TwilioRequestChallenge;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge;
import id.dana.domain.twilio.model.RequestChallengeInfo;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.network.exception.NetworkException;
import id.dana.notification.TwilioChallengeDirector;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import id.dana.twilio.onboarding.mapper.TwilioModelMapperKt;
import id.dana.twilio.onboarding.model.request.TwilioVerifySecurityProductModel;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import id.dana.twilio.tracker.TwilioMixpanelTracker$trackTwilioCreateChallenge$1;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.TimerUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.rpc.errorcode.VerificationErrorCode;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 `2\u00020\u0001:\u0001`B1\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010S\u001a\u00020R¢\u0006\u0004\b^\u0010_J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J=\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b(\u0010%J\u001f\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006*\u00020\u00020\u00020)H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0007¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u0010\u0016J\u000f\u00109\u001a\u00020\u0005H\u0002¢\u0006\u0004\b9\u0010\u0016J\u000f\u0010:\u001a\u00020\u0005H\u0002¢\u0006\u0004\b:\u0010\u0016J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b;\u0010'R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010<R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010=R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010=R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010=R\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010JR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010=R\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010="}, d2 = {"Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductManager;", "", "", TwilioIdentityVerificationActivity.FACTOR_SID, TwilioIdentityVerificationActivity.CHALLENGE_SID, "", "approveTwilioChallenge", "(Ljava/lang/String;Ljava/lang/String;)V", "", "isEnrolled", "Lid/dana/domain/twilio/interactor/TwilioRequestChallenge$Params;", "createRequestChallengeParam", "(Z)Lid/dana/domain/twilio/interactor/TwilioRequestChallenge$Params;", "Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge$Param;", "createUpdateTwilioChallengeParam", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge$Param;", BioUtilityBridge.SECURITY_ID, CashierKeyParams.VERIFICATION_METHOD, "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct$Param;", "createVerifySecurityParam", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct$Param;", "disposeAllObservable", "()V", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, "Lcom/alibaba/ariver/app/api/Page;", "page", "doVerify", "(Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Ljava/lang/String;Ljava/lang/String;ILcom/alibaba/ariver/app/api/Page;)V", "Landroid/location/Location;", "location", "getAddress", "(Landroid/location/Location;Ljava/lang/String;)V", "getDeviceModel", "()Ljava/lang/String;", "getEnrollmentStatus", "(Ljava/lang/String;)V", "getLocalDateTime", "", "getRequestChallengeInfo", "()Ljava/util/Map;", "getRequestChallengeScene", "(Z)Ljava/lang/String;", "isHaveLocationPermission", "()Z", "onLocationUpdate", "(Landroid/location/Location;)V", "Lid/dana/danah5/twilioverifysecurityproduct/TwilioPushVerifyEvent;", "event", "onNotificationReceived", "(Lid/dana/danah5/twilioverifysecurityproduct/TwilioPushVerifyEvent;)V", "requestChallenge", "(ZLjava/lang/String;)V", "startTimer", "unregisterEventBus", "updateLocation", "verifySecurityProduct", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Ljava/lang/String;", "Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;", "checkTwilioEnrollmentStatus", "Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "currentAddress", "Landroid/location/Geocoder;", "geocoder", "Landroid/location/Geocoder;", "isTimeout", "Z", "Lcom/alibaba/ariver/app/api/Page;", "Ljava/util/Date;", "startTime", "Ljava/util/Date;", "I", "Lid/dana/utils/TimerUtil;", "timerUtil", "Lid/dana/utils/TimerUtil;", "Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "twilioMixpanelTracker", "Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "Lid/dana/domain/twilio/interactor/TwilioRequestChallenge;", "twilioRequestChallenge", "Lid/dana/domain/twilio/interactor/TwilioRequestChallenge;", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", BridgeName.TWILIO_VERIFY_SECURITY_PRODUCT, "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;", "updateTwilioChallenge", "Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;", "<init>", "(Lid/dana/domain/twilio/interactor/CheckTwilioEnrollmentStatus;Lid/dana/domain/twilio/interactor/TwilioRequestChallenge;Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;Lid/dana/twilio/tracker/TwilioMixpanelTracker;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioVerifySecurityProductManager {
    public static final String DATE_FORMAT = "d MMM yyyy HH:mm:ss";
    private static final String ERROR_CODE_INVALID = "AE15112168005028";
    private static final String SCENE_RESET_PIN = "RESET_PIN";
    private static final String SCENE_RESET_PIN_FROM_NEW_DEVICE = "RESET_PIN_FROM_NEW_DEVICE";
    private static final String STATUS_APPROVED = "approved";
    private static final String VERIFICATION_STATUS = "verificationStatus";
    private static final String VERIFICATION_STATUS_INVALID = "INVALID";
    public static final String VERIFY_SECURITY_PRODUCT_POST_LOGIN = "verifySecurityProductPost";
    private BridgeCallback bridgeCallback;
    private String challengeSid;
    private final CheckTwilioEnrollmentStatus checkTwilioEnrollmentStatus;
    private CompositeDisposable compositeDisposable;
    private String currentAddress;
    private String eventName;
    private String factorSid;
    private Geocoder geocoder;
    private boolean isTimeout;
    private Page page;
    private String securityId;
    private Date startTime;
    private int timeout;
    private TimerUtil timerUtil;
    private final TwilioMixpanelTracker twilioMixpanelTracker;
    private final TwilioRequestChallenge twilioRequestChallenge;
    private final TwilioVerifySecurityProduct twilioVerifySecurityProduct;
    private final UpdateTwilioChallenge updateTwilioChallenge;
    private String verificationMethod;

    private final String getRequestChallengeScene(boolean isEnrolled) {
        return isEnrolled ? "RESET_PIN" : SCENE_RESET_PIN_FROM_NEW_DEVICE;
    }

    @Inject
    public TwilioVerifySecurityProductManager(CheckTwilioEnrollmentStatus checkTwilioEnrollmentStatus, TwilioRequestChallenge twilioRequestChallenge, TwilioVerifySecurityProduct twilioVerifySecurityProduct, UpdateTwilioChallenge updateTwilioChallenge, TwilioMixpanelTracker twilioMixpanelTracker) {
        Intrinsics.checkNotNullParameter(checkTwilioEnrollmentStatus, "");
        Intrinsics.checkNotNullParameter(twilioRequestChallenge, "");
        Intrinsics.checkNotNullParameter(twilioVerifySecurityProduct, "");
        Intrinsics.checkNotNullParameter(updateTwilioChallenge, "");
        Intrinsics.checkNotNullParameter(twilioMixpanelTracker, "");
        this.checkTwilioEnrollmentStatus = checkTwilioEnrollmentStatus;
        this.twilioRequestChallenge = twilioRequestChallenge;
        this.twilioVerifySecurityProduct = twilioVerifySecurityProduct;
        this.updateTwilioChallenge = updateTwilioChallenge;
        this.twilioMixpanelTracker = twilioMixpanelTracker;
        this.challengeSid = "";
        this.factorSid = "";
        this.currentAddress = "unknown";
        Date time = Calendar.getInstance().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "");
        this.startTime = time;
    }

    public final void doVerify(String eventName, BridgeCallback bridgeCallback, String securityId, String verificationMethod, int timeout, Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(verificationMethod, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.eventName = eventName;
        this.bridgeCallback = bridgeCallback;
        this.securityId = securityId;
        this.verificationMethod = verificationMethod;
        this.page = page;
        this.timeout = timeout;
        startTimer();
        if (Intrinsics.areEqual(eventName, VERIFY_SECURITY_PRODUCT_POST_LOGIN)) {
            EventBus.getDefault().register(this);
            TwilioChallengeDirector.Companion companion = TwilioChallengeDirector.INSTANCE;
            TwilioChallengeDirector.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        updateLocation();
        Date time = Calendar.getInstance().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "");
        this.startTime = time;
    }

    private final void updateLocation() {
        if (isHaveLocationPermission()) {
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.compositeDisposable = compositeDisposable;
            Page page = this.page;
            if (page == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                page = null;
            }
            Context context = BridgeExtensionExtKt.getContext(page);
            compositeDisposable.getAuthRequestContext(new LocationUtil.LocationRequestBuilder(context != null ? context.getApplicationContext() : null).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    TwilioVerifySecurityProductManager.this.onLocationUpdate((Location) obj);
                }
            }));
            return;
        }
        String str = this.factorSid;
        getEnrollmentStatus(str != null ? str : "");
    }

    private final boolean isHaveLocationPermission() {
        if (OSUtil.GetContactSyncConfig()) {
            Page page = this.page;
            if (page == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                page = null;
            }
            if (LocationUtil.BuiltInFictitiousFunctionClassFactory(BridgeExtensionExtKt.getContext(page))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLocationUpdate(Location location) {
        if (location != null) {
            String str = this.factorSid;
            if (str == null) {
                str = "";
            }
            getAddress(location, str);
            CompositeDisposable compositeDisposable = this.compositeDisposable;
            if (compositeDisposable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                compositeDisposable = null;
            }
            compositeDisposable.dispose();
        }
    }

    private final void getAddress(Location location, String factorSid) {
        Page page = this.page;
        if (page == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            page = null;
        }
        Context context = BridgeExtensionExtKt.getContext(page);
        List<Address> fromLocation = context != null ? new Geocoder(context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1) : null;
        Address address = fromLocation != null ? fromLocation.get(0) : null;
        if (address != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(address.getLocality());
            sb.append(", ");
            sb.append(address.getSubAdminArea());
            sb.append(", ");
            sb.append(address.getAdminArea());
            this.currentAddress = sb.toString();
        }
        getEnrollmentStatus(factorSid);
    }

    private final void getEnrollmentStatus(final String factorSid) {
        this.checkTwilioEnrollmentStatus.execute(new DefaultObserver<Boolean>() { // from class: id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager$getEnrollmentStatus$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                onNext(((Boolean) obj).booleanValue());
            }

            public final void onNext(boolean isEnrolled) {
                TwilioMixpanelTracker twilioMixpanelTracker;
                twilioMixpanelTracker = TwilioVerifySecurityProductManager.this.twilioMixpanelTracker;
                Intrinsics.checkNotNullParameter(TrackerKey.SourceType.FORGOT_PIN, "");
                TwilioMixpanelTracker$trackTwilioCreateChallenge$1 twilioMixpanelTracker$trackTwilioCreateChallenge$1 = new TwilioMixpanelTracker$trackTwilioCreateChallenge$1(TrackerKey.SourceType.FORGOT_PIN, twilioMixpanelTracker);
                EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(twilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                twilioMixpanelTracker$trackTwilioCreateChallenge$1.invoke((TwilioMixpanelTracker$trackTwilioCreateChallenge$1) PlaceComponentResult);
                PlaceComponentResult.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
                TwilioVerifySecurityProductManager.this.requestChallenge(isEnrolled, factorSid);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable error) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(error, "");
                bridgeCallback = TwilioVerifySecurityProductManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendBridgeResponse(new BridgeResponse(TwilioVerifySecurityProductResultFactory.INSTANCE.getFailedResult(String.valueOf(error.getMessage()))));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestChallenge(boolean isEnrolled, final String factorSid) {
        this.twilioMixpanelTracker.MyBillsEntityDataFactory(TrackerKey.SourceType.FORGOT_PIN, this.challengeSid, HttpHeaders.ACCEPT, (String) null);
        this.twilioRequestChallenge.execute(createRequestChallengeParam(isEnrolled), new Function1<RequestChallengeInfo, Unit>() { // from class: id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager$requestChallenge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RequestChallengeInfo requestChallengeInfo) {
                invoke2(requestChallengeInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RequestChallengeInfo requestChallengeInfo) {
                TwilioMixpanelTracker twilioMixpanelTracker;
                Date date;
                String str;
                Intrinsics.checkNotNullParameter(requestChallengeInfo, "");
                TwilioVerifySecurityProductManager.this.challengeSid = requestChallengeInfo.getChallengeSid();
                twilioMixpanelTracker = TwilioVerifySecurityProductManager.this.twilioMixpanelTracker;
                date = TwilioVerifySecurityProductManager.this.startTime;
                String str2 = factorSid;
                str = TwilioVerifySecurityProductManager.this.challengeSid;
                twilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.SourceType.FORGOT_PIN, date, str2, str, true);
                TwilioVerifySecurityProductManager.this.verifySecurityProduct(factorSid);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager$requestChallenge$2
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
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(th, "");
                TwilioVerifySecurityProductManager.this.unregisterEventBus();
                bridgeCallback = TwilioVerifySecurityProductManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendBridgeResponse(new BridgeResponse(TwilioVerifySecurityProductResultFactory.INSTANCE.getFailedResult(String.valueOf(th.getMessage()))));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifySecurityProduct(final String factorSid) {
        this.twilioVerifySecurityProduct.dispose();
        TwilioVerifySecurityProduct twilioVerifySecurityProduct = this.twilioVerifySecurityProduct;
        DefaultObserver<VerifySecurityInfo> defaultObserver = new DefaultObserver<VerifySecurityInfo>() { // from class: id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager$verifySecurityProduct$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onNext(VerifySecurityInfo verifySecurityInfo) {
                TimerUtil timerUtil;
                TwilioMixpanelTracker twilioMixpanelTracker;
                Date date;
                String str;
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(verifySecurityInfo, "");
                timerUtil = TwilioVerifySecurityProductManager.this.timerUtil;
                BridgeCallback bridgeCallback2 = null;
                if (timerUtil == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    timerUtil = null;
                }
                Disposable disposable = timerUtil.BuiltInFictitiousFunctionClassFactory;
                if (disposable != null && !disposable.isDisposed()) {
                    timerUtil.BuiltInFictitiousFunctionClassFactory.dispose();
                }
                twilioMixpanelTracker = TwilioVerifySecurityProductManager.this.twilioMixpanelTracker;
                date = TwilioVerifySecurityProductManager.this.startTime;
                String str2 = factorSid;
                str = TwilioVerifySecurityProductManager.this.challengeSid;
                twilioMixpanelTracker.MyBillsEntityDataFactory(TrackerKey.SourceType.FORGOT_PIN, date, str2, str);
                bridgeCallback = TwilioVerifySecurityProductManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback2 = bridgeCallback;
                }
                bridgeCallback2.sendBridgeResponse(new BridgeResponse(TwilioVerifySecurityProductResultFactory.INSTANCE.getSuccessResult(new VerifySecurityProductResult(String.valueOf(verifySecurityInfo.getExtendInfo().get("verificationStatus"))))));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable error) {
                TimerUtil timerUtil;
                TwilioMixpanelTracker twilioMixpanelTracker;
                Date date;
                String str;
                BridgeCallback bridgeCallback;
                TimerUtil timerUtil2;
                TwilioMixpanelTracker twilioMixpanelTracker2;
                Date date2;
                String str2;
                BridgeCallback bridgeCallback2;
                boolean z;
                Intrinsics.checkNotNullParameter(error, "");
                if (error instanceof NetworkException) {
                    String errorCode = ((NetworkException) error).getErrorCode();
                    TwilioVerifySecurityProductManager twilioVerifySecurityProductManager = TwilioVerifySecurityProductManager.this;
                    String str3 = factorSid;
                    if (Intrinsics.areEqual(errorCode, VerificationErrorCode.RETRY_VERIFY)) {
                        z = twilioVerifySecurityProductManager.isTimeout;
                        if (z) {
                            return;
                        }
                        twilioVerifySecurityProductManager.verifySecurityProduct(str3);
                        return;
                    }
                    BridgeCallback bridgeCallback3 = null;
                    if (Intrinsics.areEqual(errorCode, ErrorCode.VERIFY_PUSH_REJECT)) {
                        timerUtil2 = twilioVerifySecurityProductManager.timerUtil;
                        if (timerUtil2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            timerUtil2 = null;
                        }
                        Disposable disposable = timerUtil2.BuiltInFictitiousFunctionClassFactory;
                        if (disposable != null && !disposable.isDisposed()) {
                            timerUtil2.BuiltInFictitiousFunctionClassFactory.dispose();
                        }
                        twilioMixpanelTracker2 = twilioVerifySecurityProductManager.twilioMixpanelTracker;
                        date2 = twilioVerifySecurityProductManager.startTime;
                        str2 = twilioVerifySecurityProductManager.challengeSid;
                        twilioMixpanelTracker2.MyBillsEntityDataFactory(TrackerKey.SourceType.FORGOT_PIN, date2, str3, str2, String.valueOf(error.getMessage()));
                        twilioVerifySecurityProductManager.unregisterEventBus();
                        bridgeCallback2 = twilioVerifySecurityProductManager.bridgeCallback;
                        if (bridgeCallback2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bridgeCallback3 = bridgeCallback2;
                        }
                        bridgeCallback3.sendBridgeResponse(new BridgeResponse(TwilioVerifySecurityProductResultFactory.INSTANCE.getSuccessResult(new VerifySecurityProductResult("INVALID"))));
                        return;
                    }
                    timerUtil = twilioVerifySecurityProductManager.timerUtil;
                    if (timerUtil == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        timerUtil = null;
                    }
                    Disposable disposable2 = timerUtil.BuiltInFictitiousFunctionClassFactory;
                    if (disposable2 != null && !disposable2.isDisposed()) {
                        timerUtil.BuiltInFictitiousFunctionClassFactory.dispose();
                    }
                    twilioMixpanelTracker = twilioVerifySecurityProductManager.twilioMixpanelTracker;
                    date = twilioVerifySecurityProductManager.startTime;
                    str = twilioVerifySecurityProductManager.challengeSid;
                    twilioMixpanelTracker.MyBillsEntityDataFactory(TrackerKey.SourceType.FORGOT_PIN, date, str3, str, String.valueOf(error.getMessage()));
                    twilioVerifySecurityProductManager.unregisterEventBus();
                    bridgeCallback = twilioVerifySecurityProductManager.bridgeCallback;
                    if (bridgeCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        bridgeCallback3 = bridgeCallback;
                    }
                    bridgeCallback3.sendBridgeResponse(new BridgeResponse(TwilioVerifySecurityProductResultFactory.INSTANCE.getFailedResult(String.valueOf(error.getMessage()))));
                }
            }
        };
        String str = this.securityId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        String str3 = this.verificationMethod;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str2 = str3;
        }
        twilioVerifySecurityProduct.execute(defaultObserver, createVerifySecurityParam(str, str2, this.challengeSid));
    }

    private final void startTimer() {
        this.isTimeout = false;
        TimerUtil timerUtil = new TimerUtil();
        timerUtil.PlaceComponentResult(this.timeout, new TimerUtil.OnTimerCallback() { // from class: id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager$$ExternalSyntheticLambda1
            @Override // id.dana.utils.TimerUtil.OnTimerCallback
            public final void onFinish() {
                TwilioVerifySecurityProductManager.m725startTimer$lambda2$lambda1(TwilioVerifySecurityProductManager.this);
            }
        });
        this.timerUtil = timerUtil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startTimer$lambda-2$lambda-1  reason: not valid java name */
    public static final void m725startTimer$lambda2$lambda1(TwilioVerifySecurityProductManager twilioVerifySecurityProductManager) {
        Intrinsics.checkNotNullParameter(twilioVerifySecurityProductManager, "");
        twilioVerifySecurityProductManager.twilioMixpanelTracker.MyBillsEntityDataFactory(TrackerKey.SourceType.FORGOT_PIN, twilioVerifySecurityProductManager.challengeSid, "Expired", "Client Session Expired", (String) null);
        TwilioMixpanelTracker twilioMixpanelTracker = twilioVerifySecurityProductManager.twilioMixpanelTracker;
        Date date = twilioVerifySecurityProductManager.startTime;
        String str = twilioVerifySecurityProductManager.factorSid;
        twilioMixpanelTracker.MyBillsEntityDataFactory(TrackerKey.SourceType.FORGOT_PIN, date, str == null ? "" : str, twilioVerifySecurityProductManager.challengeSid, "Client Session Expired");
        twilioVerifySecurityProductManager.isTimeout = true;
        twilioVerifySecurityProductManager.unregisterEventBus();
        TimerUtil timerUtil = twilioVerifySecurityProductManager.timerUtil;
        if (timerUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            timerUtil = null;
        }
        Disposable disposable = timerUtil.BuiltInFictitiousFunctionClassFactory;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        timerUtil.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onNotificationReceived(TwilioPushVerifyEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        String str = this.eventName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        if (Intrinsics.areEqual(str, VERIFY_SECURITY_PRODUCT_POST_LOGIN)) {
            this.challengeSid = event.getChallengeSid();
            this.factorSid = event.getFactorSid();
            approveTwilioChallenge(event.getFactorSid(), event.getChallengeSid());
        }
    }

    private final void approveTwilioChallenge(final String factorSid, String challengeSid) {
        this.updateTwilioChallenge.execute(createUpdateTwilioChallengeParam(factorSid, challengeSid), new Function1<Boolean, Unit>() { // from class: id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager$approveTwilioChallenge$1
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
                Page page;
                Resources resources;
                BridgeCallback bridgeCallback;
                if (z) {
                    TwilioVerifySecurityProductManager.this.verifySecurityProduct(factorSid);
                    return;
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_UPDATE_CHALLENGE, String.valueOf(z));
                page = TwilioVerifySecurityProductManager.this.page;
                BridgeCallback bridgeCallback2 = null;
                if (page == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    page = null;
                }
                Activity activity = BridgeExtensionExtKt.getActivity(page);
                if (activity == null || (resources = activity.getResources()) == null) {
                    return;
                }
                bridgeCallback = TwilioVerifySecurityProductManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback2 = bridgeCallback;
                }
                TwilioVerifySecurityProductResultFactory twilioVerifySecurityProductResultFactory = TwilioVerifySecurityProductResultFactory.INSTANCE;
                String string = resources.getString(R.string.general_error_msg);
                Intrinsics.checkNotNullExpressionValue(string, "");
                bridgeCallback2.sendBridgeResponse(new BridgeResponse(twilioVerifySecurityProductResultFactory.getFailedResult(string)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager$approveTwilioChallenge$2
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
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(th, "");
                TwilioVerifySecurityProductManager.this.unregisterEventBus();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_UPDATE_CHALLENGE, th.getMessage(), th);
                bridgeCallback = TwilioVerifySecurityProductManager.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendBridgeResponse(new BridgeResponse(TwilioVerifySecurityProductResultFactory.INSTANCE.getFailedResult(String.valueOf(th.getMessage()))));
            }
        });
    }

    private final TwilioRequestChallenge.Params createRequestChallengeParam(boolean isEnrolled) {
        return new TwilioRequestChallenge.Params(ChallengeModelMapperKt.MyBillsEntityDataFactory(new TwilioChallengeModel(getRequestChallengeScene(isEnrolled), getRequestChallengeInfo(), null, 4, null)));
    }

    private final Map<String, String> getRequestChallengeInfo() {
        return MapsKt.mapOf(TuplesKt.to("device", getDeviceModel()), TuplesKt.to("location", this.currentAddress), TuplesKt.to("time", getLocalDateTime()), TuplesKt.to(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, String.valueOf(this.timeout)), TuplesKt.to(TwilioIdentityVerificationActivity.CHALLENGE_INFO_VERIFICATION_TYPE, TwilioIdentityVerificationActivity.VERIFICATION_TYPE_CHANGE_PIN), TuplesKt.to(TwilioIdentityVerificationActivity.CHALLENGE_TIMEMILLIS, DateTimeUtil.scheduleImpl()));
    }

    private final String getLocalDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    private final String getDeviceModel() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(Build.MODEL);
        return sb.toString();
    }

    private final TwilioVerifySecurityProduct.Param createVerifySecurityParam(String securityId, String verificationMethod, String challengeSid) {
        return new TwilioVerifySecurityProduct.Param(TwilioModelMapperKt.getAuthRequestContext(new TwilioVerifySecurityProductModel(securityId, verificationMethod, challengeSid, null, 8, null)));
    }

    private final UpdateTwilioChallenge.Param createUpdateTwilioChallengeParam(String factorSid, String challengeSid) {
        return new UpdateTwilioChallenge.Param(factorSid, challengeSid, STATUS_APPROVED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterEventBus() {
        EventBus.getDefault().unregister(this);
        TwilioChallengeDirector.Companion companion = TwilioChallengeDirector.INSTANCE;
        TwilioChallengeDirector.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }

    public final void disposeAllObservable() {
        this.checkTwilioEnrollmentStatus.dispose();
        this.twilioRequestChallenge.dispose();
        this.twilioVerifySecurityProduct.dispose();
        this.updateTwilioChallenge.dispose();
    }
}
