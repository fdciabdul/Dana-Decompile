package id.dana.challenge.otp;

import android.content.Context;
import android.text.TextUtils;
import dagger.Lazy;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.login.LoginTracker;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.LoginFailureException;
import id.dana.challenge.LoginFailureExceptionKt;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.challenge.otp.OtpState;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckResendWhatsAppEnable;
import id.dana.domain.featureconfig.interactor.GetQueryUserDataConfig;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.foundation.logger.LoginScenarioConstant;
import id.dana.domain.login.interactor.OtpLogin;
import id.dana.domain.model.rpc.UserInfo;
import id.dana.domain.model.rpc.response.LoginResponse;
import id.dana.domain.otp.interactor.ReceiveOtp;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.interactor.VerifyOtpRisk;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.domain.otp.model.VerifyOtpRiskResponse;
import id.dana.domain.registration.interactor.GetNumberOfRequestOtp;
import id.dana.domain.registration.interactor.RemoveNumberOfRequestOtp;
import id.dana.domain.registration.interactor.SaveIsFreezeVerifyOtp;
import id.dana.domain.registration.interactor.SaveNumberOfRequestOtp;
import id.dana.myprofile.UserInfoMapper;
import id.dana.network.exception.BotProtectionException;
import id.dana.network.exception.NetworkException;
import id.dana.oauth.OauthLoginManager;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigFactory;
import id.dana.tracker.EventConfigProperty;
import id.dana.tracker.EventTracker;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.model.TrackOtpModel;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B©\u0001\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020X\u0012\u0006\u0010\u000e\u001a\u000206\u0012\u0006\u0010\u000f\u001a\u00020I\u0012\u0006\u0010\u0010\u001a\u00020<\u0012\u0006\u0010\u0012\u001a\u00020$\u0012\u0006\u0010\u0015\u001a\u00020&\u0012\u0006\u0010[\u001a\u00020N\u0012\u0006\u0010\\\u001a\u00020(\u0012\u0006\u0010]\u001a\u00020D\u0012\f\u0010^\u001a\b\u0012\u0004\u0012\u00020C0-\u0012\u0006\u0010_\u001a\u00020*\u0012\u0006\u0010`\u001a\u00020F\u0012\u0006\u0010a\u001a\u00020?\u0012\u0006\u0010b\u001a\u00020!\u0012\f\u0010c\u001a\b\u0012\u0004\u0012\u00020.0-\u0012\f\u0010d\u001a\b\u0012\u0004\u0012\u0002030-\u0012\f\u0010e\u001a\b\u0012\u0004\u0012\u00020U0-¢\u0006\u0004\bf\u0010gJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0007\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0007\u0010\rJ;\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014JG\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u0016J9\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0013\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J'\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u001cJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ7\u0010\u0019\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001cJ\u0019\u0010\u0013\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010\u0004R\u0014\u0010\u0013\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0007\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010%R\u0014\u0010\u0003\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010'R\u0014\u0010\n\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0014\u0010\u0019\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u0002030-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00100R\u0016\u00105\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u00104R\u0012\u0010\u001e\u001a\u00020\u0005X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u00104R\u0012\u0010+\u001a\u00020\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u00102R\u0014\u0010\"\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010/\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00104R\u0014\u00101\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020C0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00100R\u0014\u0010=\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010ER\u0014\u0010@\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010;\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010J\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u00104R\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u00104R\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010OR\u0014\u0010M\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010RR\u0012\u0010L\u001a\u00020SX\u0086\"¢\u0006\u0006\n\u0004\b5\u0010TR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020U0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u00100R\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010Z"}, d2 = {"Lid/dana/challenge/otp/OtpLoginPresenter;", "Lid/dana/challenge/otp/AbstractOtpContract$Presenter;", "", "getAuthRequestContext", "()V", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "", "PlaceComponentResult", "()I", "Lid/dana/challenge/otp/OtpState;", "()Lid/dana/challenge/otp/OtpState;", "p1", "p2", "p3", "", "p4", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "p5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/model/rpc/response/LoginResponse;", "MyBillsEntityDataFactory", "(Lid/dana/domain/model/rpc/response/LoginResponse;)Z", "onDestroy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "moveToNextValue", "scheduleImpl", "Lid/dana/domain/featureconfig/interactor/CheckResendWhatsAppEnable;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/featureconfig/interactor/CheckResendWhatsAppEnable;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/sync_engine/domain/interactor/GetIsSyncPermission;", "Lid/dana/sync_engine/domain/interactor/GetIsSyncPermission;", "Lid/dana/domain/registration/interactor/GetNumberOfRequestOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/registration/interactor/GetNumberOfRequestOtp;", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/GetQueryUserDataConfig;", "GetContactSyncConfig", "Ldagger/Lazy;", "initRecordTimeStamp", "Z", "Lid/dana/analytics/tracker/login/LoginTracker;", "Ljava/lang/String;", "getErrorConfigVersion", "Lid/dana/domain/login/interactor/OtpLogin;", "DatabaseTableConfigUtil", "Lid/dana/domain/login/interactor/OtpLogin;", "isLayoutRequested", "I", "newProxyInstance", "Lid/dana/domain/otp/interactor/ReceiveOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/domain/otp/interactor/ReceiveOtp;", "Lid/dana/domain/registration/interactor/RemoveNumberOfRequestOtp;", "PrepareContext", "Lid/dana/domain/registration/interactor/RemoveNumberOfRequestOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/domain/registration/interactor/SaveIsFreezeVerifyOtp;", "Lid/dana/sync_engine/domain/interactor/SaveIsSyncPermission;", "Lid/dana/sync_engine/domain/interactor/SaveIsSyncPermission;", "Lid/dana/domain/registration/interactor/SaveNumberOfRequestOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lid/dana/domain/registration/interactor/SaveNumberOfRequestOtp;", "Lid/dana/domain/otp/interactor/SendOtp;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/domain/otp/interactor/SendOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/tracker/model/TrackOtpModel;", "Lid/dana/tracker/model/TrackOtpModel;", "Lid/dana/myprofile/UserInfoMapper;", "Lid/dana/myprofile/UserInfoMapper;", "Lid/dana/domain/otp/interactor/VerifyOtpRisk;", "whenAvailable", "getSupportButtonTintMode", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "getCallingPid", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "<init>", "(Lid/dana/challenge/otp/AbstractOtpContract$View;Lid/dana/domain/login/interactor/OtpLogin;Lid/dana/domain/otp/interactor/SendOtp;Lid/dana/domain/otp/interactor/ReceiveOtp;Landroid/content/Context;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/data/toggle/SplitFacade;Lid/dana/sync_engine/domain/interactor/GetIsSyncPermission;Lid/dana/sync_engine/domain/interactor/SaveIsSyncPermission;Ldagger/Lazy;Lid/dana/domain/registration/interactor/GetNumberOfRequestOtp;Lid/dana/domain/registration/interactor/SaveNumberOfRequestOtp;Lid/dana/domain/registration/interactor/RemoveNumberOfRequestOtp;Lid/dana/domain/featureconfig/interactor/CheckResendWhatsAppEnable;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OtpLoginPresenter implements AbstractOtpContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final GetIsSyncPermission PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final OtpLogin NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final SendOtp newProxyInstance;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy<GetQueryUserDataConfig> moveToNextValue;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final DeviceInformationProvider getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final GetNumberOfRequestOtp MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final CheckResendWhatsAppEnable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final TrackOtpModel NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final SaveNumberOfRequestOtp PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final ReceiveOtp initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy<SaveIsFreezeVerifyOtp> isLayoutRequested;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final RemoveNumberOfRequestOtp NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Lazy<LoginTracker> scheduleImpl;
    private final AbstractOtpContract.View getCallingPid;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public UserInfoMapper NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private int DatabaseTableConfigUtil;
    String lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final SplitFacade NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private String GetContactSyncConfig;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final SaveIsSyncPermission NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy<VerifyOtpRisk> getSupportButtonTintMode;

    @Inject
    public OtpLoginPresenter(AbstractOtpContract.View view, OtpLogin otpLogin, SendOtp sendOtp, ReceiveOtp receiveOtp, Context context, DeviceInformationProvider deviceInformationProvider, SplitFacade splitFacade, GetIsSyncPermission getIsSyncPermission, SaveIsSyncPermission saveIsSyncPermission, Lazy<SaveIsFreezeVerifyOtp> lazy, GetNumberOfRequestOtp getNumberOfRequestOtp, SaveNumberOfRequestOtp saveNumberOfRequestOtp, RemoveNumberOfRequestOtp removeNumberOfRequestOtp, CheckResendWhatsAppEnable checkResendWhatsAppEnable, Lazy<GetQueryUserDataConfig> lazy2, Lazy<LoginTracker> lazy3, Lazy<VerifyOtpRisk> lazy4) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(otpLogin, "");
        Intrinsics.checkNotNullParameter(sendOtp, "");
        Intrinsics.checkNotNullParameter(receiveOtp, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(getIsSyncPermission, "");
        Intrinsics.checkNotNullParameter(saveIsSyncPermission, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(getNumberOfRequestOtp, "");
        Intrinsics.checkNotNullParameter(saveNumberOfRequestOtp, "");
        Intrinsics.checkNotNullParameter(removeNumberOfRequestOtp, "");
        Intrinsics.checkNotNullParameter(checkResendWhatsAppEnable, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        this.getCallingPid = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = otpLogin;
        this.newProxyInstance = sendOtp;
        this.initRecordTimeStamp = receiveOtp;
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = deviceInformationProvider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = splitFacade;
        this.PlaceComponentResult = getIsSyncPermission;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = saveIsSyncPermission;
        this.isLayoutRequested = lazy;
        this.MyBillsEntityDataFactory = getNumberOfRequestOtp;
        this.PrepareContext = saveNumberOfRequestOtp;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = removeNumberOfRequestOtp;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkResendWhatsAppEnable;
        this.moveToNextValue = lazy2;
        this.scheduleImpl = lazy3;
        this.getSupportButtonTintMode = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new TrackOtpModel(context, "Login");
        this.DatabaseTableConfigUtil = -1;
        this.getErrorConfigVersion = "";
        this.lookAheadTest = "";
        this.FragmentBottomSheetPaymentSettingBinding = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = "";
        this.GetContactSyncConfig = "";
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, boolean p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.GetContactSyncConfig = p0;
        this.lookAheadTest = p1;
        if (p2 == null) {
            p2 = "";
        }
        this.FragmentBottomSheetPaymentSettingBinding = p2;
        if (p3 == null) {
            p3 = "";
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = p3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.MyBillsEntityDataFactory = Intrinsics.areEqual(p1, OtpChannel.WHATSAPP) ? ChallengeEvent.Channel.WHATSAPP : ChallengeEvent.Channel.SMS;
        BaseUseCase.execute$default(this.MyBillsEntityDataFactory, p0, new OtpLoginPresenter$getNumberOfRequestOtp$1(this, false), null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        lookAheadTest();
        EventTracker.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult(p0));
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, final String p1, String p2, String p3, final String p4, String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p5, "");
        this.getCallingPid.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(OtpLogin.Params.INSTANCE.forOtpLogin(p0, p1, p5), new Function1<LoginResponse, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$input$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(LoginResponse loginResponse) {
                invoke2(loginResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LoginResponse loginResponse) {
                AbstractOtpContract.View view;
                TrackOtpModel trackOtpModel;
                int i;
                AbstractOtpContract.View view2;
                String str;
                Intrinsics.checkNotNullParameter(loginResponse, "");
                view = OtpLoginPresenter.this.getCallingPid;
                view.dismissProgress();
                OtpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0(OtpLoginPresenter.this);
                if (loginResponse.isSuccess()) {
                    view2 = OtpLoginPresenter.this.getCallingPid;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2();
                    OtpLoginPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OtpLoginPresenter.this, loginResponse);
                    String str2 = p1;
                    if (str2 != null) {
                        OtpLoginPresenter.this.getErrorConfigVersion = str2;
                    }
                    OtpLoginPresenter otpLoginPresenter = OtpLoginPresenter.this;
                    str = otpLoginPresenter.GetContactSyncConfig;
                    CompletableUseCase.execute$default(otpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8, str, null, null, 6, null);
                } else {
                    String errorMessage = loginResponse.getErrorMessage();
                    Intrinsics.checkNotNullExpressionValue(errorMessage, "");
                    LoginFailureExceptionKt.BuiltInFictitiousFunctionClassFactory(new LoginFailureException(errorMessage));
                    StringBuilder sb = new StringBuilder();
                    sb.append("[OtpLogin] login error: errorCode = ");
                    sb.append(loginResponse.getErrorCode());
                    sb.append(", errorMessage = ");
                    sb.append(loginResponse.getErrorMessage());
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory("DanaLogin", sb.toString());
                }
                trackOtpModel = OtpLoginPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                boolean isSuccess = loginResponse.isSuccess();
                int failedCount = loginResponse.getFailedCount();
                i = OtpLoginPresenter.this.DatabaseTableConfigUtil;
                EventTracker.PlaceComponentResult(trackOtpModel.BuiltInFictitiousFunctionClassFactory(isSuccess, failedCount, i, p4));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$input$2
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
                AbstractOtpContract.View view;
                AbstractOtpContract.View view2;
                AbstractOtpContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = OtpLoginPresenter.this.getCallingPid;
                view.dismissProgress();
                OtpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0(OtpLoginPresenter.this);
                if (th instanceof NetworkException) {
                    view3 = OtpLoginPresenter.this.getCallingPid;
                    NetworkException networkException = (NetworkException) th;
                    String errorCode = networkException.getErrorCode();
                    String message = th.getMessage();
                    Intrinsics.checkNotNullExpressionValue(networkException.getLeftTimes(), "");
                    view3.BuiltInFictitiousFunctionClassFactory(errorCode, message, "alipayplus.mobilewallet.user.login", networkException.getTraceId());
                } else {
                    view2 = OtpLoginPresenter.this.getCallingPid;
                    view2.onError(th.getMessage());
                }
                OtpLoginPresenter.BuiltInFictitiousFunctionClassFactory(OtpLoginPresenter.this, th);
            }
        });
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, final String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p4, "");
        this.getCallingPid.showProgress();
        this.getSupportButtonTintMode.get().execute(new VerifyOtpRisk.Params(p0, p1, p2, p4, "AP_LOGIN", null, 32, null), new Function1<VerifyOtpRiskResponse, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$inputOtpRisk$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(VerifyOtpRiskResponse verifyOtpRiskResponse) {
                invoke2(verifyOtpRiskResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyOtpRiskResponse verifyOtpRiskResponse) {
                AbstractOtpContract.View view;
                TrackOtpModel trackOtpModel;
                int i;
                AbstractOtpContract.View view2;
                String str;
                Intrinsics.checkNotNullParameter(verifyOtpRiskResponse, "");
                view = OtpLoginPresenter.this.getCallingPid;
                view.dismissProgress();
                OtpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0(OtpLoginPresenter.this);
                if (verifyOtpRiskResponse.getSuccess()) {
                    view2 = OtpLoginPresenter.this.getCallingPid;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2();
                    OtpLoginPresenter.this.scheduleImpl();
                    OtpLoginPresenter.this.getErrorConfigVersion = "Trust Risk Login V2";
                    OtpLoginPresenter otpLoginPresenter = OtpLoginPresenter.this;
                    str = otpLoginPresenter.GetContactSyncConfig;
                    CompletableUseCase.execute$default(otpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8, str, null, null, 6, null);
                } else {
                    String errorMessage = verifyOtpRiskResponse.getErrorMessage();
                    LoginFailureExceptionKt.BuiltInFictitiousFunctionClassFactory(new LoginFailureException(errorMessage != null ? errorMessage : ""));
                    StringBuilder sb = new StringBuilder();
                    sb.append("[OtpLogin] login error: errorCode = ");
                    sb.append(verifyOtpRiskResponse.getErrorCode());
                    sb.append(", errorMessage = ");
                    sb.append(verifyOtpRiskResponse.getErrorMessage());
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory("DanaLogin", sb.toString());
                }
                trackOtpModel = OtpLoginPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                boolean success = verifyOtpRiskResponse.getSuccess();
                int identFailedCount = verifyOtpRiskResponse.getIdentFailedCount();
                i = OtpLoginPresenter.this.DatabaseTableConfigUtil;
                EventTracker.PlaceComponentResult(trackOtpModel.BuiltInFictitiousFunctionClassFactory(success, identFailedCount, i, p3));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$inputOtpRisk$2
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
                AbstractOtpContract.View view;
                AbstractOtpContract.View view2;
                AbstractOtpContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = OtpLoginPresenter.this.getCallingPid;
                view.dismissProgress();
                OtpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0(OtpLoginPresenter.this);
                if (th instanceof NetworkException) {
                    view3 = OtpLoginPresenter.this.getCallingPid;
                    NetworkException networkException = (NetworkException) th;
                    String errorCode = networkException.getErrorCode();
                    String message = th.getMessage();
                    Intrinsics.checkNotNullExpressionValue(networkException.getLeftTimes(), "");
                    view3.BuiltInFictitiousFunctionClassFactory(errorCode, message, "alipayplus.mobilewallet.user.login", networkException.getTraceId());
                } else {
                    view2 = OtpLoginPresenter.this.getCallingPid;
                    view2.onError(th.getMessage());
                }
                OtpLoginPresenter.BuiltInFictitiousFunctionClassFactory(OtpLoginPresenter.this, th);
            }
        });
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void MyBillsEntityDataFactory(String str, String str2, String str3) {
        this.getCallingPid.showProgress();
        EventTracker.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda4.BuiltInFictitiousFunctionClassFactory(ChallengeEvent.Channel.SMS, str3));
        if (str == null) {
            str = "";
        }
        this.FragmentBottomSheetPaymentSettingBinding = str;
        if (str2 == null) {
            str2 = "";
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str2;
        BaseUseCase.execute$default(this.MyBillsEntityDataFactory, this.GetContactSyncConfig, new OtpLoginPresenter$getNumberOfRequestOtp$1(this, false), null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        this.getCallingPid.showProgress();
        EventTracker.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda4.BuiltInFictitiousFunctionClassFactory(ChallengeEvent.Channel.WHATSAPP, p0));
        this.lookAheadTest = OtpChannel.WHATSAPP;
        BaseUseCase.execute$default(this.MyBillsEntityDataFactory, this.GetContactSyncConfig, new OtpLoginPresenter$getNumberOfRequestOtp$1(this, false), null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final OtpState BuiltInFictitiousFunctionClassFactory() {
        OtpState.SMS1 sms1;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return OtpState.WA1.INSTANCE;
        }
        if (Intrinsics.areEqual(OtpChannel.WHATSAPP, this.lookAheadTest)) {
            int i = this.DatabaseTableConfigUtil;
            if (i == 1) {
                sms1 = OtpState.WA1.INSTANCE;
            } else if (i == 2) {
                sms1 = OtpState.WA2.INSTANCE;
            } else if (i == 3) {
                sms1 = OtpState.WA3.INSTANCE;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getOtpState ");
            sb.append(this.DatabaseTableConfigUtil);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(sms1);
            DanaLog.BuiltInFictitiousFunctionClassFactory("OTP", sb.toString());
            return sms1;
        }
        sms1 = OtpState.SMS1.INSTANCE;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getOtpState ");
        sb2.append(this.DatabaseTableConfigUtil);
        sb2.append(InputCardNumberView.DIVIDER);
        sb2.append(sms1);
        DanaLog.BuiltInFictitiousFunctionClassFactory("OTP", sb2.toString());
        return sms1;
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void getAuthRequestContext() {
        BaseUseCase.execute$default(this.KClassImpl$Data$declaredNonStaticMembers$2, null, new Function1<Boolean, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$checkIsWhatsAppFeatureEnable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                AbstractOtpContract.View view;
                view = OtpLoginPresenter.this.getCallingPid;
                view.PlaceComponentResult();
            }
        }, null, 4, null);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final int getDatabaseTableConfigUtil() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.isLayoutRequested.get().execute(new SaveIsFreezeVerifyOtp.Params(p0, true), new Function0<Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$saveIsFreezeVerifyOtp$1
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
                AbstractOtpContract.View view;
                view = OtpLoginPresenter.this.getCallingPid;
                view.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$saveIsFreezeVerifyOtp$2
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
                AbstractOtpContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = OtpLoginPresenter.this.getCallingPid;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void PlaceComponentResult(final String p0, String p1, String p2) {
        SendOtp.Params forSendOtp;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        SendOtp sendOtp = this.newProxyInstance;
        DefaultObserver<SendOtpResponse> defaultObserver = new DefaultObserver<SendOtpResponse>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$requestOtp$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AbstractOtpContract.View view;
                AbstractOtpContract.View view2;
                int i;
                String str;
                int i2;
                SendOtpResponse sendOtpResponse = (SendOtpResponse) obj;
                Intrinsics.checkNotNullParameter(sendOtpResponse, "");
                view = OtpLoginPresenter.this.getCallingPid;
                view.dismissProgress();
                if (sendOtpResponse.isSuccess()) {
                    OtpLoginPresenter.MyBillsEntityDataFactory(OtpLoginPresenter.this, p0);
                    OtpLoginPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                    view2 = OtpLoginPresenter.this.getCallingPid;
                    sendOtpResponse.getExpirySeconds();
                    view2.MyBillsEntityDataFactory(sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getOtpCodeLength());
                    OtpLoginPresenter otpLoginPresenter = OtpLoginPresenter.this;
                    i = otpLoginPresenter.DatabaseTableConfigUtil;
                    otpLoginPresenter.DatabaseTableConfigUtil = i + 1;
                    OtpLoginPresenter otpLoginPresenter2 = OtpLoginPresenter.this;
                    str = otpLoginPresenter2.GetContactSyncConfig;
                    i2 = OtpLoginPresenter.this.DatabaseTableConfigUtil;
                    OtpLoginPresenter.MyBillsEntityDataFactory(otpLoginPresenter2, str, i2);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpLogin]  send OTP error: errorCode = ");
                sb.append(sendOtpResponse.getErrorCode());
                sb.append(", errorMessage = ");
                sb.append(sendOtpResponse.getErrorMessage());
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory("DanaLogin", sb.toString());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                AbstractOtpContract.View view;
                Intrinsics.checkNotNullParameter(p02, "");
                view = OtpLoginPresenter.this.getCallingPid;
                view.dismissProgress();
                OtpLoginPresenter.KClassImpl$Data$declaredNonStaticMembers$2(OtpLoginPresenter.this, p02);
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpLogin]  send OTP  error: ");
                sb.append(p02);
                CrashlyticsLogUtil.PlaceComponentResult("DanaLogin", sb.toString(), p02);
            }
        };
        forSendOtp = SendOtp.Params.INSTANCE.forSendOtp(p1, p2, (i & 4) != 0 ? null : null, (i & 8) != 0 ? false : false, (i & 16) != 0 ? null : null, (i & 32) != 0 ? null : null, (i & 64) != 0 ? null : p0);
        sendOtp.execute(defaultObserver, forSendOtp);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BaseUseCase.execute$default(this.initRecordTimeStamp, NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$receiveOtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                AbstractOtpContract.View view;
                Intrinsics.checkNotNullParameter(str, "");
                view = OtpLoginPresenter.this.getCallingPid;
                view.PlaceComponentResult(str);
            }
        }, null, 4, null);
    }

    public final void scheduleImpl() {
        if (Intrinsics.areEqual(this.lookAheadTest, OtpChannel.WHATSAPP)) {
            this.scheduleImpl.get().MyBillsEntityDataFactory("WHATSAPP_OTP");
        } else {
            this.scheduleImpl.get().MyBillsEntityDataFactory("OTP_SMS");
        }
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(LoginResponse p0) {
        if (p0.getUserInfo() != null) {
            UserInfo userInfo = p0.getUserInfo();
            Intrinsics.checkNotNull(userInfo);
            if (!TextUtils.isEmpty(userInfo.getUserId())) {
                UserInfo userInfo2 = p0.getUserInfo();
                Intrinsics.checkNotNull(userInfo2);
                if (!TextUtils.isEmpty(userInfo2.getNickname())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean MyBillsEntityDataFactory(LoginResponse p0) {
        String kycLevel = p0 != null ? p0.getKycLevel() : null;
        return !(kycLevel == null || kycLevel.length() == 0);
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        LoginTracker loginTracker = this.scheduleImpl.get();
        Intrinsics.checkNotNullExpressionValue(loginTracker, "");
        loginTracker.KClassImpl$Data$declaredNonStaticMembers$2(System.currentTimeMillis());
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void MyBillsEntityDataFactory() {
        LoginTracker loginTracker = this.scheduleImpl.get();
        Intrinsics.checkNotNullExpressionValue(loginTracker, "");
        loginTracker.BuiltInFictitiousFunctionClassFactory(System.currentTimeMillis());
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void moveToNextValue() {
        this.scheduleImpl.get().scheduleImpl();
    }

    @Override // id.dana.challenge.otp.AbstractOtpContract.Presenter
    public final void lookAheadTest() {
        String str = this.lookAheadTest;
        if (Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
            this.scheduleImpl.get().NetworkUserEntityData$$ExternalSyntheticLambda0();
        } else if (Intrinsics.areEqual(str, OtpChannel.SMS)) {
            this.scheduleImpl.get().lookAheadTest();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
        this.newProxyInstance.dispose();
        this.initRecordTimeStamp.dispose();
        this.PlaceComponentResult.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.dispose();
        this.isLayoutRequested.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.PrepareContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.dispose();
        this.moveToNextValue.get().dispose();
        this.getSupportButtonTintMode.get().dispose();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final OtpLoginPresenter otpLoginPresenter, final LoginResponse loginResponse) {
        GetQueryUserDataConfig getQueryUserDataConfig = otpLoginPresenter.moveToNextValue.get();
        Intrinsics.checkNotNullExpressionValue(getQueryUserDataConfig, "");
        BaseUseCase.execute$default(getQueryUserDataConfig, NoParams.INSTANCE, new Function1<QueryUserDataConfig, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$getQueryUserDataConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryUserDataConfig queryUserDataConfig) {
                invoke2(queryUserDataConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryUserDataConfig queryUserDataConfig) {
                String str;
                Intrinsics.checkNotNullParameter(queryUserDataConfig, "");
                OtpLoginPresenter otpLoginPresenter2 = OtpLoginPresenter.this;
                LoginResponse loginResponse2 = loginResponse;
                Intrinsics.checkNotNullParameter(loginResponse2, "");
                EventConfigProperty.Builder builder = new EventConfigProperty.Builder();
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = otpLoginPresenter2.BuiltInFictitiousFunctionClassFactory;
                builder.getAuthRequestContext = MixPanelTracker.getAuthRequestContext();
                builder.lookAheadTest = otpLoginPresenter2.getAuthRequestContext.getCurrentTrackerId();
                if (OtpLoginPresenter.KClassImpl$Data$declaredNonStaticMembers$2(loginResponse2)) {
                    UserInfo userInfo = loginResponse2.getUserInfo();
                    builder.getErrorConfigVersion = userInfo != null ? userInfo.getUserId() : null;
                }
                if (OtpLoginPresenter.MyBillsEntityDataFactory(loginResponse2)) {
                    UserInfo userInfo2 = loginResponse2.getUserInfo();
                    String kycLevel = userInfo2 != null ? userInfo2.getKycLevel() : null;
                    if (kycLevel == null) {
                        kycLevel = "";
                    }
                    builder.MyBillsEntityDataFactory = kycLevel;
                }
                List<EventConfig> authRequestContext = EventConfigFactory.getAuthRequestContext(new EventConfigProperty(builder, (byte) 0), otpLoginPresenter2.getAuthRequestContext, TrackerType.MIXPANEL, TrackerType.FULLSTORY);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                Iterator<T> it = authRequestContext.iterator();
                while (it.hasNext()) {
                    ((EventConfig) it.next()).BuiltInFictitiousFunctionClassFactory();
                }
                final OtpLoginPresenter otpLoginPresenter3 = OtpLoginPresenter.this;
                LoginResponse loginResponse3 = loginResponse;
                Intrinsics.checkNotNullParameter(loginResponse3, "");
                otpLoginPresenter3.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$checkSyncPermissionStatus$1
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
                        AbstractOtpContract.View view;
                        if (z) {
                            return;
                        }
                        view = OtpLoginPresenter.this.getCallingPid;
                        view.getAuthRequestContext();
                        OtpLoginPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7.execute(Boolean.TRUE, new Function1<Boolean, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$setIsSyncPermission$1
                            public final void invoke(boolean z2) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }
                        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$setIsSyncPermission$2
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                Intrinsics.checkNotNullParameter(th, "");
                                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_IS_SYNC_PERMISSION, th.getMessage());
                            }
                        });
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.otp.OtpLoginPresenter$checkSyncPermissionStatus$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_IS_SYNC_PERMISSION, th.getMessage());
                    }
                });
                otpLoginPresenter3.scheduleImpl();
                otpLoginPresenter3.scheduleImpl.get().getAuthRequestContext();
                LoginTracker loginTracker = otpLoginPresenter3.scheduleImpl.get();
                Intrinsics.checkNotNullExpressionValue(loginTracker, "");
                loginTracker.PlaceComponentResult();
                if (!OtpLoginPresenter.MyBillsEntityDataFactory(loginResponse3) || (str = loginResponse3.getKycLevel()) == null) {
                    str = "";
                }
                OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
                String scheduleImpl = OauthLoginManager.scheduleImpl();
                if ((scheduleImpl.length() == 0 ? (byte) 1 : (byte) 0) != 0) {
                    scheduleImpl = otpLoginPresenter3.BuiltInFictitiousFunctionClassFactory.getString(R.string.dana_string);
                    Intrinsics.checkNotNullExpressionValue(scheduleImpl, "");
                }
                String str2 = scheduleImpl;
                LoginTracker loginTracker2 = otpLoginPresenter3.scheduleImpl.get();
                String userId = loginResponse3.getUserId();
                if (userId == null) {
                    userId = "";
                }
                String str3 = otpLoginPresenter3.getErrorConfigVersion;
                Intrinsics.checkNotNullParameter(str3, "");
                loginTracker2.BuiltInFictitiousFunctionClassFactory(userId, Intrinsics.areEqual(LoginScenarioConstant.TRUSTRISKLOGIN, str3) ? TrackerKey.LoginType.TRUST_RISK_LOGIN : "Normal", str, str2);
                SplitFacade splitFacade = otpLoginPresenter3.NetworkUserEntityData$$ExternalSyntheticLambda3;
                SplitFacade.PlaceComponentResult("login_challenge_type", "OTP SMS");
            }
        }, null, 4, null);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(OtpLoginPresenter otpLoginPresenter, Throwable th) {
        Context context = otpLoginPresenter.BuiltInFictitiousFunctionClassFactory;
        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(context, "alipayplus.mobilewallet.user.security.sendOtp", ErrorUtil.getAuthRequestContext(context), "Login", th);
        if (th instanceof BotProtectionException) {
            otpLoginPresenter.getCallingPid.getAuthRequestContext(((BotProtectionException) th).getChallengeContext(), otpLoginPresenter.lookAheadTest, otpLoginPresenter.FragmentBottomSheetPaymentSettingBinding, otpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda6);
        } else if (th instanceof NetworkException) {
            AbstractOtpContract.View view = otpLoginPresenter.getCallingPid;
            NetworkException networkException = (NetworkException) th;
            String errorCode = networkException.getErrorCode();
            String message = th.getMessage();
            Intrinsics.checkNotNullExpressionValue(networkException.getLeftTimes(), "");
            view.BuiltInFictitiousFunctionClassFactory(errorCode, message, "alipayplus.mobilewallet.user.security.sendOtp", "");
        } else {
            otpLoginPresenter.getCallingPid.onError(th.getMessage());
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OtpLoginPresenter otpLoginPresenter, int i) {
        if (i == -1) {
            otpLoginPresenter.DatabaseTableConfigUtil = 0;
        } else {
            otpLoginPresenter.DatabaseTableConfigUtil = i;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OtpLoginPresenter otpLoginPresenter, String str, int i) {
        if (otpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        CompletableUseCase.execute$default(otpLoginPresenter.PrepareContext, new SaveNumberOfRequestOtp.Params(str, i), null, null, 6, null);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(OtpLoginPresenter otpLoginPresenter, String str) {
        if (Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
            LoginTracker loginTracker = otpLoginPresenter.scheduleImpl.get();
            Intrinsics.checkNotNullExpressionValue(loginTracker, "");
            loginTracker.KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (Intrinsics.areEqual(str, OtpChannel.SMS)) {
            LoginTracker loginTracker2 = otpLoginPresenter.scheduleImpl.get();
            Intrinsics.checkNotNullExpressionValue(loginTracker2, "");
            loginTracker2.MyBillsEntityDataFactory();
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(OtpLoginPresenter otpLoginPresenter) {
        String str = otpLoginPresenter.lookAheadTest;
        if (!Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
            if (Intrinsics.areEqual(str, OtpChannel.SMS)) {
                otpLoginPresenter.scheduleImpl.get().getErrorConfigVersion();
                return;
            }
            return;
        }
        otpLoginPresenter.scheduleImpl.get().scheduleImpl();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(OtpLoginPresenter otpLoginPresenter, Throwable th) {
        LoginFailureExceptionKt.BuiltInFictitiousFunctionClassFactory(new LoginFailureException(th));
        StringBuilder sb = new StringBuilder();
        sb.append("[OtpLogin] login error: ");
        sb.append(th);
        CrashlyticsLogUtil.PlaceComponentResult("DanaLogin", sb.toString(), th);
        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(otpLoginPresenter.BuiltInFictitiousFunctionClassFactory, "alipayplus.mobilewallet.user.login", th.getMessage(), "Login", th);
    }
}
