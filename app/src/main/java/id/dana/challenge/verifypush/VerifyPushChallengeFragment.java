package id.dana.challenge.verifypush;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.firebase.perf.FirebasePerformance;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengePinWithFaceActivity;
import id.dana.challenge.ChallengeScenarioListener;
import id.dana.challenge.verifypush.VerifyPushChallengeFragment$countDownDialogCS$2;
import id.dana.challenge.verifypush.VerifyPushContract;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager;
import id.dana.data.login.source.network.model.VerifyMethod;
import id.dana.databinding.FragmentVerifyPushChallengeBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerVerifyPushChallengeComponent;
import id.dana.di.modules.VerifyPushChallengeModule;
import id.dana.dialog.DialogWithImage;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.model.TwilioTimeoutConfig;
import id.dana.onboarding.verify.VerifyNumberFragment;
import id.dana.performancetracker.VerifyMethodAnalyticTracker;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import id.dana.twilio.tracker.TwilioMixpanelTracker$trackTwilioCreateChallenge$1;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import id.dana.utils.permission.ManifestPermission;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\bN\u0010\u000fJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u000fJ\u001d\u0010\u0005\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019H\u0002¢\u0006\u0004\b\u0005\u0010\u001aR\u0016\u0010\f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u00020\u001fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010$R\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\u0013\u001a\u00020\t8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000bR\u0016\u0010#\u001a\u00020+8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010\u001bR\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u0010.\u001a\f\u0012\b\u0012\u0006*\u00020\u00100\u0010028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u0010(\u001a\u0002058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010,\u001a\u0002088\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u00109\u001a\u0002058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b;\u00107R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010'R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010=8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010;\u001a\u00020@8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bA\u0010BR\u001e\u00103\u001a\f\u0012\b\u0012\u0006*\u00020\u00100\u0010028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bC\u00104R\u0012\u0010E\u001a\u00020DX\u0087\"¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010C\u001a\u00020G8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010'R\u0012\u0010L\u001a\u00020KX\u0087\"¢\u0006\u0006\n\u0004\bL\u0010M"}, d2 = {"Lid/dana/challenge/verifypush/VerifyPushChallengeFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentVerifyPushChallengeBinding;", "Ljava/util/HashMap;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/HashMap;", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "", "getLayout", "()I", "BuiltInFictitiousFunctionClassFactory", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "getAuthRequestContext", "()Z", "moveToNextValue", "Landroid/content/Context;", "p0", "onAttach", "(Landroid/content/Context;)V", "onDestroyView", "", "(Ljava/util/List;)Z", "Z", "Lio/reactivex/disposables/CompositeDisposable;", "lookAheadTest", "Lio/reactivex/disposables/CompositeDisposable;", "Lid/dana/challenge/verifypush/VerifyPushChallengeFragment$countDownDialogCS$2$1;", "getErrorConfigVersion", "Lkotlin/Lazy;", "Landroid/os/CountDownTimer;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/os/CountDownTimer;", "PlaceComponentResult", "scheduleImpl", "I", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "Ljava/lang/String;", "Landroid/location/Geocoder;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroid/location/Geocoder;", "DatabaseTableConfigUtil", "Landroid/location/Location;", "GetContactSyncConfig", "Landroid/location/Location;", "Lio/reactivex/subjects/PublishSubject;", "isLayoutRequested", "Lio/reactivex/subjects/PublishSubject;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "PrepareContext", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "newProxyInstance", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", "", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Ljava/util/List;", "Lid/dana/challenge/ChallengeScenarioListener;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/challenge/ChallengeScenarioListener;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "twilioMixpanelTracker", "Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "Ljava/util/Date;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Ljava/util/Date;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/challenge/verifypush/VerifyPushLoginPresenter;", "verifyPushLoginPresenter", "Lid/dana/challenge/verifypush/VerifyPushLoginPresenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPushChallengeFragment extends ViewBindingFragment<FragmentVerifyPushChallengeBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = Reflection.getOrCreateKotlinClass(VerifyPushChallengeFragment.class).getSimpleName();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;
    private int FragmentBottomSheetPaymentSettingBinding;
    private Location GetContactSyncConfig;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private CountDownTimer KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Geocoder NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private int lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final PublishSubject<Boolean> isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private ChallengeScenarioListener NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private Date NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private List<String> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private int PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final FragmentPermissionRequest newProxyInstance;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final PublishSubject<Boolean> DatabaseTableConfigUtil;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private CompositeDisposable MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private CountDownTimer PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private int getErrorConfigVersion;
    @Inject
    public TwilioMixpanelTracker twilioMixpanelTracker;
    @Inject
    public VerifyPushLoginPresenter verifyPushLoginPresenter;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen NetworkUserEntityData$$ExternalSyntheticLambda1 = new MeasureLoadAndRenderingScreen();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<VerifyPushChallengeFragment$countDownDialogCS$2.AnonymousClass1>() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$countDownDialogCS$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v3, types: [id.dana.challenge.verifypush.VerifyPushChallengeFragment$countDownDialogCS$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            int i;
            VerifyPushChallengeFragment.FragmentBottomSheetPaymentSettingBinding(VerifyPushChallengeFragment.this);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            i = VerifyPushChallengeFragment.this.lookAheadTest;
            long millis = timeUnit.toMillis(i);
            long millis2 = TimeUnit.SECONDS.toMillis(1L);
            final VerifyPushChallengeFragment verifyPushChallengeFragment = VerifyPushChallengeFragment.this;
            return new CountDownTimer(millis, millis2) { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$countDownDialogCS$2.1
                @Override // android.os.CountDownTimer
                public final void onTick(long p0) {
                    int i2;
                    VerifyPushChallengeFragment verifyPushChallengeFragment2 = VerifyPushChallengeFragment.this;
                    i2 = verifyPushChallengeFragment2.lookAheadTest;
                    verifyPushChallengeFragment2.lookAheadTest = i2 - 1;
                    VerifyPushChallengeFragment verifyPushChallengeFragment3 = VerifyPushChallengeFragment.this;
                    String string = verifyPushChallengeFragment3.getResources().getString(R.string.face_login_failed_cs);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    MixPanelTracker.BuiltInFictitiousFunctionClassFactory(verifyPushChallengeFragment3.getContext(), "alipayplus.mobilewallet.user.login", "", string, "Login", "");
                }

                @Override // android.os.CountDownTimer
                public final void onFinish() {
                    ((AnonymousClass1) VerifyPushChallengeFragment.this.getAuthRequestContext.getValue()).cancel();
                    VerifyNumberFragment.Companion companion = VerifyNumberFragment.INSTANCE;
                    VerifyNumberFragment.Companion.BuiltInFictitiousFunctionClassFactory();
                }
            };
        }
    });

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_verify_push_challenge;
    }

    public VerifyPushChallengeFragment() {
        VerifyPushChallengeFragment verifyPushChallengeFragment = this;
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(verifyPushChallengeFragment);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$locationPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    VerifyPushChallengeFragment.this.initRecordTimeStamp = true;
                    VerifyPushChallengeFragment.initRecordTimeStamp(VerifyPushChallengeFragment.this);
                    if (LocationUtil.getAuthRequestContext(VerifyPushChallengeFragment.this.getBaseActivity())) {
                        VerifyPushChallengeFragment.moveToNextValue(VerifyPushChallengeFragment.this);
                        return;
                    }
                    return;
                }
                VerifyPushChallengeFragment.initRecordTimeStamp(VerifyPushChallengeFragment.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder2 = new FragmentPermissionRequest.Builder(verifyPushChallengeFragment);
        String[] strArr2 = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.getAuthRequestContext = ArraysKt.toSet(strArr2);
        VerifyPushChallengeFragment$phonePermission$1 verifyPushChallengeFragment$phonePermission$1 = new VerifyPushChallengeFragment$phonePermission$1(this);
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment$phonePermission$1, "");
        builder2.BuiltInFictitiousFunctionClassFactory = verifyPushChallengeFragment$phonePermission$1;
        this.newProxyInstance = builder2.PlaceComponentResult();
        this.getErrorConfigVersion = 20;
        this.FragmentBottomSheetPaymentSettingBinding = 10;
        this.lookAheadTest = 3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ArrayList();
        this.scheduleImpl = "unknown";
        Date time = Calendar.getInstance().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = time;
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.DatabaseTableConfigUtil = PlaceComponentResult;
        PublishSubject<Boolean> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.isLayoutRequested = PlaceComponentResult2;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ FragmentVerifyPushChallengeBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentVerifyPushChallengeBinding MyBillsEntityDataFactory = FragmentVerifyPushChallengeBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullParameter("twilio_verification_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("twilio_verification_screen_render");
        try {
            BaseActivity baseActivity = getBaseActivity();
            if (baseActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.challenge.ChallengeScenarioListener");
            }
            ChallengeScenarioListener challengeScenarioListener = (ChallengeScenarioListener) baseActivity;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = challengeScenarioListener;
            if (challengeScenarioListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                challengeScenarioListener = null;
            }
            challengeScenarioListener.hideClose();
        } catch (ClassCastException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(p0);
            sb.append("must implement ChallengeScenarioListener");
            throw new ClassCastException(sb.toString());
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(List<String> p0) {
        return p0.size() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean moveToNextValue() {
        return !Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, CollectionsKt.emptyList());
    }

    private final HashMap<String, String> KClassImpl$Data$declaredNonStaticMembers$2() {
        return MapsKt.hashMapOf(TuplesKt.to("device", MyBillsEntityDataFactory()), TuplesKt.to("location", this.scheduleImpl), TuplesKt.to("time", BuiltInFictitiousFunctionClassFactory()), TuplesKt.to(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, String.valueOf(PlaceComponentResult())), TuplesKt.to(TwilioIdentityVerificationActivity.CHALLENGE_INFO_VERIFICATION_TYPE, "login"), TuplesKt.to(TwilioIdentityVerificationActivity.CHALLENGE_TIMEMILLIS, DateTimeUtil.scheduleImpl()));
    }

    @JvmName(name = "PlaceComponentResult")
    private final int PlaceComponentResult() {
        return this.PrepareContext > 0 ? (this.getErrorConfigVersion * 2) + this.FragmentBottomSheetPaymentSettingBinding + 15 : this.getErrorConfigVersion + this.FragmentBottomSheetPaymentSettingBinding;
    }

    private static String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(Build.MODEL);
        return sb.toString();
    }

    private static String BuiltInFictitiousFunctionClassFactory() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TwilioVerifySecurityProductManager.DATE_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getAuthRequestContext() {
        return LocationUtil.getAuthRequestContext(getContext()) && this.initRecordTimeStamp;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/challenge/verifypush/VerifyPushChallengeFragment$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/challenge/verifypush/VerifyPushChallengeFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)Lid/dana/challenge/verifypush/VerifyPushChallengeFragment;", "", "Ljava/lang/String;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static VerifyPushChallengeFragment KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
            VerifyPushChallengeFragment verifyPushChallengeFragment = new VerifyPushChallengeFragment();
            verifyPushChallengeFragment.setArguments(p0);
            return verifyPushChallengeFragment;
        }
    }

    public static /* synthetic */ Boolean PlaceComponentResult(VerifyPushChallengeFragment verifyPushChallengeFragment, Location location, Boolean bool) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment, "");
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(bool, "");
        Geocoder geocoder = new Geocoder(verifyPushChallengeFragment.getBaseActivity().getApplicationContext(), Locale.getDefault());
        verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = geocoder;
        try {
            List<Address> fromLocation = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            Address address = fromLocation != null ? fromLocation.get(0) : null;
            if (address != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(address.getLocality());
                sb.append(", ");
                sb.append(address.getSubAdminArea());
                sb.append(", ");
                sb.append(address.getAdminArea());
                verifyPushChallengeFragment.scheduleImpl = sb.toString();
            }
        } catch (IOException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, e.getMessage());
        }
        return bool;
    }

    public static /* synthetic */ void PlaceComponentResult(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment, "");
        VerifyPushLoginPresenter verifyPushLoginPresenter = verifyPushChallengeFragment.verifyPushLoginPresenter;
        if (verifyPushLoginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            verifyPushLoginPresenter = null;
        }
        verifyPushLoginPresenter.getAuthRequestContext("LOGIN_FROM_NEW_DEVICE", verifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    public static /* synthetic */ void getAuthRequestContext(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment, "");
        verifyPushChallengeFragment.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment verifyPushChallengeFragment, Location location) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment, "");
        verifyPushChallengeFragment.GetContactSyncConfig = location;
        verifyPushChallengeFragment.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
        CompositeDisposable compositeDisposable = verifyPushChallengeFragment.MyBillsEntityDataFactory;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            compositeDisposable = null;
        }
        compositeDisposable.dispose();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment verifyPushChallengeFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (-1 == i) {
            verifyPushChallengeFragment.newProxyInstance.check();
            dialogInterface.dismiss();
        }
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(final VerifyPushChallengeFragment verifyPushChallengeFragment, final Boolean bool) {
        Observable fromCallable;
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment, "");
        Intrinsics.checkNotNullParameter(bool, "");
        final Location location = verifyPushChallengeFragment.GetContactSyncConfig;
        if (location != null && (fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return VerifyPushChallengeFragment.PlaceComponentResult(VerifyPushChallengeFragment.this, location, bool);
            }
        })) != null) {
            return fromCallable;
        }
        return Observable.just(bool);
    }

    public static /* synthetic */ Boolean BuiltInFictitiousFunctionClassFactory(Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment, "");
        CountDownTimer countDownTimer = verifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = verifyPushChallengeFragment.PlaceComponentResult;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        VerifyPushLoginPresenter verifyPushLoginPresenter = verifyPushChallengeFragment.verifyPushLoginPresenter;
        if (verifyPushLoginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            verifyPushLoginPresenter = null;
        }
        verifyPushLoginPresenter.getAuthRequestContext("LOGIN_FROM_NEW_DEVICE", verifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2());
        verifyPushChallengeFragment.PrepareContext++;
    }

    public static final /* synthetic */ VerifyPushChallengeFragment$countDownDialogCS$2.AnonymousClass1 BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        return (VerifyPushChallengeFragment$countDownDialogCS$2.AnonymousClass1) verifyPushChallengeFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ void moveToNextValue(final VerifyPushChallengeFragment verifyPushChallengeFragment) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        verifyPushChallengeFragment.MyBillsEntityDataFactory = compositeDisposable;
        compositeDisposable.getAuthRequestContext(new LocationUtil.LocationRequestBuilder((Application) verifyPushChallengeFragment.getBaseActivity().getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VerifyPushChallengeFragment.BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment.this, (Location) obj);
            }
        }, new Consumer() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                VerifyPushChallengeFragment.getAuthRequestContext(VerifyPushChallengeFragment.this);
            }
        }));
    }

    public static final /* synthetic */ void initRecordTimeStamp(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        final VerifyPushLoginPresenter verifyPushLoginPresenter = verifyPushChallengeFragment.verifyPushLoginPresenter;
        if (verifyPushLoginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            verifyPushLoginPresenter = null;
        }
        verifyPushLoginPresenter.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<TwilioTimeoutConfig, Unit>() { // from class: id.dana.challenge.verifypush.VerifyPushLoginPresenter$getTwilioTimeoutConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TwilioTimeoutConfig twilioTimeoutConfig) {
                invoke2(twilioTimeoutConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TwilioTimeoutConfig twilioTimeoutConfig) {
                VerifyPushContract.View view;
                Intrinsics.checkNotNullParameter(twilioTimeoutConfig, "");
                VerifyPushLoginPresenter.this.MyBillsEntityDataFactory = twilioTimeoutConfig.getCounter();
                view = VerifyPushLoginPresenter.this.scheduleImpl;
                view.MyBillsEntityDataFactory(twilioTimeoutConfig.getTimeout(), twilioTimeoutConfig.getCounter());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.verifypush.VerifyPushLoginPresenter$getTwilioTimeoutConfig$2
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
                VerifyPushContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = VerifyPushLoginPresenter.this.scheduleImpl;
                view.MyBillsEntityDataFactory(10, 20);
            }
        });
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VerifyPushChallengeFragment verifyPushChallengeFragment, String str) {
        TwilioMixpanelTracker twilioMixpanelTracker;
        TwilioMixpanelTracker twilioMixpanelTracker2 = verifyPushChallengeFragment.twilioMixpanelTracker;
        ChallengeScenarioListener challengeScenarioListener = null;
        if (twilioMixpanelTracker2 != null) {
            twilioMixpanelTracker = twilioMixpanelTracker2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twilioMixpanelTracker = null;
        }
        twilioMixpanelTracker.MyBillsEntityDataFactory("Login", verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3, (String) null, str, "Client Session Expired");
        if (!verifyPushChallengeFragment.moveToNextValue() || verifyPushChallengeFragment.PrepareContext != 0) {
            if (verifyPushChallengeFragment.moveToNextValue() && verifyPushChallengeFragment.PrepareContext > 0) {
                Context context = verifyPushChallengeFragment.getContext();
                if (context != null) {
                    VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(context, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_TIME, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_FAILED, null, "Client Session Expired");
                }
                ChallengeScenarioListener challengeScenarioListener2 = verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (challengeScenarioListener2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    challengeScenarioListener = challengeScenarioListener2;
                }
                challengeScenarioListener.onNext(verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda7, ChallengeEvent.OTPPurpose.PV_FAILOVER);
                return;
            } else if (verifyPushChallengeFragment.PrepareContext > 0) {
                ((VerifyPushChallengeFragment$countDownDialogCS$2.AnonymousClass1) verifyPushChallengeFragment.getAuthRequestContext.getValue()).start();
                return;
            } else {
                return;
            }
        }
        FragmentVerifyPushChallengeBinding binding = verifyPushChallengeFragment.getBinding();
        if (binding != null) {
            binding.MyBillsEntityDataFactory.setVisibility(8);
            binding.PlaceComponentResult.setVisibility(8);
            binding.scheduleImpl.setVisibility(8);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(VerifyPushChallengeFragment verifyPushChallengeFragment, String str) {
        TwilioMixpanelTracker twilioMixpanelTracker;
        TwilioMixpanelTracker twilioMixpanelTracker2 = verifyPushChallengeFragment.twilioMixpanelTracker;
        ChallengeScenarioListener challengeScenarioListener = null;
        if (twilioMixpanelTracker2 != null) {
            twilioMixpanelTracker = twilioMixpanelTracker2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twilioMixpanelTracker = null;
        }
        twilioMixpanelTracker.MyBillsEntityDataFactory("Login", verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3, (String) null, str, "Client Session Expired");
        if (verifyPushChallengeFragment.moveToNextValue()) {
            Context context = verifyPushChallengeFragment.getContext();
            if (context != null) {
                VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(context, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_TIME, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_FAILED, null, "Client Session Expired");
            }
            ChallengeScenarioListener challengeScenarioListener2 = verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (challengeScenarioListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                challengeScenarioListener = challengeScenarioListener2;
            }
            challengeScenarioListener.onNext(verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda7, ChallengeEvent.OTPPurpose.PV_FAILOVER);
            return;
        }
        ((VerifyPushChallengeFragment$countDownDialogCS$2.AnonymousClass1) verifyPushChallengeFragment.getAuthRequestContext.getValue()).start();
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda7(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        FragmentVerifyPushChallengeBinding binding = verifyPushChallengeFragment.getBinding();
        if (binding != null) {
            binding.MyBillsEntityDataFactory.setVisibility(8);
            binding.PlaceComponentResult.setVisibility(0);
            binding.scheduleImpl.setText(verifyPushChallengeFragment.getString(R.string.twilio_bottomsheet_left_attempt));
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(VerifyPushChallengeFragment verifyPushChallengeFragment, int i) {
        FragmentVerifyPushChallengeBinding binding = verifyPushChallengeFragment.getBinding();
        AppCompatTextView appCompatTextView = binding != null ? binding.MyBillsEntityDataFactory : null;
        if (appCompatTextView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = verifyPushChallengeFragment.getString(R.string.twilio_bottomsheet_countdown_timer);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            appCompatTextView.setText(format);
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda6(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        FragmentVerifyPushChallengeBinding binding = verifyPushChallengeFragment.getBinding();
        if (binding != null) {
            binding.PlaceComponentResult.setVisibility(4);
            binding.MyBillsEntityDataFactory.setVisibility(0);
        }
    }

    public static final /* synthetic */ void FragmentBottomSheetPaymentSettingBinding(final VerifyPushChallengeFragment verifyPushChallengeFragment) {
        DialogWithImage.Builder builder = new DialogWithImage.Builder();
        builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnClickListener() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VerifyPushChallengeFragment.BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment.this, dialogInterface, i);
            }
        };
        builder.MyBillsEntityDataFactory = R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3;
        builder.moveToNextValue = verifyPushChallengeFragment.getResources().getString(R.string.risk_reject_dialog_title);
        builder.PlaceComponentResult = verifyPushChallengeFragment.getResources().getString(R.string.face_login_failed_cs);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = verifyPushChallengeFragment.getResources().getString(R.string.risk_reject_positive_button_msg);
        DialogWithImage.Builder MyBillsEntityDataFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).MyBillsEntityDataFactory(false);
        new DialogWithImage(verifyPushChallengeFragment.getBaseActivity(), MyBillsEntityDataFactory.lookAheadTest, MyBillsEntityDataFactory, (byte) 0).MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final VerifyPushChallengeFragment verifyPushChallengeFragment, final String str) {
        if (verifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = verifyPushChallengeFragment.getErrorConfigVersion;
            final long millis = TimeUnit.SECONDS.toMillis(intRef.element);
            final long millis2 = TimeUnit.SECONDS.toMillis(1L);
            verifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2 = new CountDownTimer(millis, millis2) { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$startMainTimer$1
                @Override // android.os.CountDownTimer
                public final void onTick(long p0) {
                    Ref.IntRef.this.element--;
                    VerifyPushChallengeFragment.MyBillsEntityDataFactory(verifyPushChallengeFragment, Ref.IntRef.this.element);
                }

                @Override // android.os.CountDownTimer
                public final void onFinish() {
                    int i;
                    int i2;
                    i = verifyPushChallengeFragment.PrepareContext;
                    if (i <= 0) {
                        VerifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(verifyPushChallengeFragment);
                        VerifyPushChallengeFragment.MyBillsEntityDataFactory(verifyPushChallengeFragment, str);
                    } else {
                        VerifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(verifyPushChallengeFragment, str);
                    }
                    Ref.IntRef intRef2 = Ref.IntRef.this;
                    i2 = verifyPushChallengeFragment.getErrorConfigVersion;
                    intRef2.element = i2;
                }
            };
        }
        CountDownTimer countDownTimer = verifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final VerifyPushChallengeFragment verifyPushChallengeFragment, final String str) {
        if (verifyPushChallengeFragment.PlaceComponentResult == null) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = verifyPushChallengeFragment.FragmentBottomSheetPaymentSettingBinding;
            final long millis = TimeUnit.SECONDS.toMillis(intRef.element);
            final long millis2 = TimeUnit.SECONDS.toMillis(1L);
            verifyPushChallengeFragment.PlaceComponentResult = new CountDownTimer(millis, millis2) { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$startUserInactiveTimer$1
                @Override // android.os.CountDownTimer
                public final void onTick(long p0) {
                    Ref.IntRef.this.element--;
                }

                @Override // android.os.CountDownTimer
                public final void onFinish() {
                    int i;
                    VerifyPushChallengeFragment.PlaceComponentResult(verifyPushChallengeFragment, str);
                    Ref.IntRef intRef2 = Ref.IntRef.this;
                    i = verifyPushChallengeFragment.FragmentBottomSheetPaymentSettingBinding;
                    intRef2.element = i;
                }
            };
        }
        CountDownTimer countDownTimer = verifyPushChallengeFragment.PlaceComponentResult;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda5(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        CountDownTimer countDownTimer = verifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = verifyPushChallengeFragment.PlaceComponentResult;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DanaButtonPrimaryView danaButtonPrimaryView;
        DaggerVerifyPushChallengeComponent.Builder PlaceComponentResult = DaggerVerifyPushChallengeComponent.PlaceComponentResult();
        PlaceComponentResult.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult.PlaceComponentResult = (VerifyPushChallengeModule) Preconditions.getAuthRequestContext(new VerifyPushChallengeModule(new VerifyPushContract.View() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$getVerifyPushChallengeModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.challenge.verifypush.VerifyPushContract.View
            public final void MyBillsEntityDataFactory(int p0, int p1) {
                PublishSubject publishSubject;
                boolean authRequestContext;
                PublishSubject publishSubject2;
                VerifyPushChallengeFragment.this.getErrorConfigVersion = p1;
                VerifyPushChallengeFragment.this.FragmentBottomSheetPaymentSettingBinding = p0;
                TwilioMixpanelTracker twilioMixpanelTracker = VerifyPushChallengeFragment.this.twilioMixpanelTracker;
                if (twilioMixpanelTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    twilioMixpanelTracker = null;
                }
                Intrinsics.checkNotNullParameter("Login", "");
                TwilioMixpanelTracker$trackTwilioCreateChallenge$1 twilioMixpanelTracker$trackTwilioCreateChallenge$1 = new TwilioMixpanelTracker$trackTwilioCreateChallenge$1("Login", twilioMixpanelTracker);
                EventTrackerModel.Builder PlaceComponentResult2 = EventTrackerModel.Builder.PlaceComponentResult(twilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
                twilioMixpanelTracker$trackTwilioCreateChallenge$1.invoke((TwilioMixpanelTracker$trackTwilioCreateChallenge$1) PlaceComponentResult2);
                PlaceComponentResult2.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult2, (byte) 0));
                publishSubject = VerifyPushChallengeFragment.this.isLayoutRequested;
                Boolean bool = Boolean.TRUE;
                publishSubject.onNext(bool);
                authRequestContext = VerifyPushChallengeFragment.this.getAuthRequestContext();
                if (!authRequestContext) {
                    publishSubject2 = VerifyPushChallengeFragment.this.DatabaseTableConfigUtil;
                    publishSubject2.onNext(bool);
                }
                VerifyPushChallengeFragment verifyPushChallengeFragment = VerifyPushChallengeFragment.this;
                Date time = Calendar.getInstance().getTime();
                Intrinsics.checkNotNullExpressionValue(time, "");
                verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 = time;
            }

            @Override // id.dana.challenge.verifypush.VerifyPushContract.View
            public final void getAuthRequestContext(String str, boolean z) {
                Date date;
                Intrinsics.checkNotNullParameter(str, "");
                TwilioMixpanelTracker twilioMixpanelTracker = VerifyPushChallengeFragment.this.twilioMixpanelTracker;
                if (twilioMixpanelTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    twilioMixpanelTracker = null;
                }
                date = VerifyPushChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                twilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2("Login", date, null, str, z);
                VerifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda6(VerifyPushChallengeFragment.this);
                VerifyPushChallengeFragment.BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment.this, str);
                VerifyPushChallengeFragment verifyPushChallengeFragment = VerifyPushChallengeFragment.this;
                Date time = Calendar.getInstance().getTime();
                Intrinsics.checkNotNullExpressionValue(time, "");
                verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda3 = time;
            }

            @Override // id.dana.challenge.verifypush.VerifyPushContract.View
            public final void getAuthRequestContext(String p0) {
                Date date;
                ChallengeScenarioListener challengeScenarioListener;
                Intrinsics.checkNotNullParameter(p0, "");
                TwilioMixpanelTracker twilioMixpanelTracker = VerifyPushChallengeFragment.this.twilioMixpanelTracker;
                if (twilioMixpanelTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    twilioMixpanelTracker = null;
                }
                date = VerifyPushChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                twilioMixpanelTracker.MyBillsEntityDataFactory("Login", date, (String) null, p0);
                Context context = VerifyPushChallengeFragment.this.getContext();
                if (context != null) {
                    VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(context, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_TIME, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_SUCCESS, null, null);
                }
                challengeScenarioListener = VerifyPushChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (challengeScenarioListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    challengeScenarioListener = null;
                }
                challengeScenarioListener.onNext(null, null);
            }

            @Override // id.dana.challenge.verifypush.VerifyPushContract.View
            public final void PlaceComponentResult(String p0, String p1, String p2) {
                TwilioMixpanelTracker twilioMixpanelTracker;
                Date date;
                ChallengeScenarioListener challengeScenarioListener;
                Intrinsics.checkNotNullParameter(p0, "");
                TwilioMixpanelTracker twilioMixpanelTracker2 = VerifyPushChallengeFragment.this.twilioMixpanelTracker;
                if (twilioMixpanelTracker2 != null) {
                    twilioMixpanelTracker = twilioMixpanelTracker2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    twilioMixpanelTracker = null;
                }
                date = VerifyPushChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                twilioMixpanelTracker.MyBillsEntityDataFactory("Login", date, (String) null, p0, "User Reject");
                VerifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(VerifyPushChallengeFragment.this);
                Context context = VerifyPushChallengeFragment.this.getContext();
                if (context != null) {
                    VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(context, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_TIME, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_FAILED, p1, p2);
                }
                challengeScenarioListener = VerifyPushChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (challengeScenarioListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    challengeScenarioListener = null;
                }
                challengeScenarioListener.onNext(CollectionsKt.arrayListOf(VerifyMethod.DISMISS_PUSH_VERIFY), null);
                VerifyPushChallengeFragment.this.BuiltInFictitiousFunctionClassFactory = true;
                VerifyPushChallengeFragment.BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment.this).start();
            }

            @Override // id.dana.challenge.verifypush.VerifyPushContract.View
            public final void getAuthRequestContext(String p0, String p1, String p2) {
                TwilioMixpanelTracker twilioMixpanelTracker;
                Date date;
                boolean moveToNextValue;
                int i;
                int i2;
                ChallengeScenarioListener challengeScenarioListener;
                List<String> list;
                Intrinsics.checkNotNullParameter(p1, "");
                TwilioMixpanelTracker twilioMixpanelTracker2 = VerifyPushChallengeFragment.this.twilioMixpanelTracker;
                ChallengeScenarioListener challengeScenarioListener2 = null;
                if (twilioMixpanelTracker2 != null) {
                    twilioMixpanelTracker = twilioMixpanelTracker2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    twilioMixpanelTracker = null;
                }
                date = VerifyPushChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                twilioMixpanelTracker.MyBillsEntityDataFactory("Login", date, (String) null, p1, p0 == null ? "" : p0);
                moveToNextValue = VerifyPushChallengeFragment.this.moveToNextValue();
                if (moveToNextValue) {
                    i2 = VerifyPushChallengeFragment.this.PrepareContext;
                    if (i2 > 1) {
                        Context context = VerifyPushChallengeFragment.this.getContext();
                        if (context != null) {
                            VerifyMethodAnalyticTracker.BuiltInFictitiousFunctionClassFactory(context, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_TIME, TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_FAILED, p2, p0);
                        }
                        challengeScenarioListener = VerifyPushChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        if (challengeScenarioListener == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            challengeScenarioListener2 = challengeScenarioListener;
                        }
                        list = VerifyPushChallengeFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        challengeScenarioListener2.onNext(list, ChallengeEvent.OTPPurpose.PV_FAILOVER);
                        return;
                    }
                }
                i = VerifyPushChallengeFragment.this.PrepareContext;
                if (i > 1) {
                    VerifyPushChallengeFragment.BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment.this).start();
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, VerifyPushChallengeModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerVerifyPushChallengeComponent.VerifyPushChallengeComponentImpl(PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.MyBillsEntityDataFactory, (byte) 0).getAuthRequestContext(this);
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        VerifyPushLoginPresenter verifyPushLoginPresenter = this.verifyPushLoginPresenter;
        if (verifyPushLoginPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            verifyPushLoginPresenter = null;
        }
        abstractPresenterArr[0] = verifyPushLoginPresenter;
        registerPresenter(abstractPresenterArr);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<String> stringArrayList = arguments.getStringArrayList(ChallengePinWithFaceActivity.CHALLENGE_METHOD_LIST);
            if (stringArrayList == null) {
                stringArrayList = CollectionsKt.emptyList();
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2(stringArrayList)) {
                List<String> mutableList = CollectionsKt.toMutableList((Collection) stringArrayList);
                mutableList.remove(0);
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = mutableList;
            }
        }
        addDisposable(Observable.zip(this.DatabaseTableConfigUtil, this.isLayoutRequested, new BiFunction() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return VerifyPushChallengeFragment.BuiltInFictitiousFunctionClassFactory((Boolean) obj, (Boolean) obj2);
            }
        }).flatMap(new Function() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VerifyPushChallengeFragment.BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment.this, (Boolean) obj);
            }
        }).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Boolean bool = (Boolean) obj;
                VerifyPushChallengeFragment.PlaceComponentResult(VerifyPushChallengeFragment.this);
            }
        }));
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.check();
        FragmentVerifyPushChallengeBinding binding = getBinding();
        if (binding != null && (danaButtonPrimaryView = binding.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyPushChallengeFragment.KClassImpl$Data$declaredNonStaticMembers$2(VerifyPushChallengeFragment.this);
                }
            });
        }
        VerifyMethodAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.LOGIN_VERIFICATION_METHOD_TWILIO_TIME);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "");
        Intrinsics.checkNotNullParameter(requireView, "");
        FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
        FirstDrawListener.Companion.MyBillsEntityDataFactory(requireView, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        CountDownTimer countDownTimer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (countDownTimer != null && countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.PlaceComponentResult;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
