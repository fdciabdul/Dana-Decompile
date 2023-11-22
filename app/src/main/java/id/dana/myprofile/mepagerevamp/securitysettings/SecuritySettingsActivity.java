package id.dana.myprofile.mepagerevamp.securitysettings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.challenge.ChallengeControl;
import id.dana.common.ProfileDividerItemDecoration;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.util.DANAToast;
import id.dana.danah5.DanaH5;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.databinding.ActivitySecuritySettingsBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.SettingModelMapper;
import id.dana.model.UserInfo;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.ProfileUserServiceType;
import id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.MePageRevampModule;
import id.dana.myprofile.mepagerevamp.securitysettings.DaggerSecuritySettingsComponent;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;
import id.dana.myprofile.mepagerevamp.securitysettings.adapter.SecuritySettingsAdapter;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView;
import id.dana.myprofile.mepagerevamp.securitysettings.viewholder.NewProfileMenuFaceAuthViewHolder;
import id.dana.myprofile.mepagerevamp.securitysettings.viewholder.ProfileMenuLocationPermissionViewHolder;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.productpage.ProductPageManagerExtKt;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCredential;
import id.dana.riskChallenges.ui.createpin.CreatePinLauncher;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher;
import id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyLauncher;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.riskChallenges.ui.verifypin.VerifyPinLauncher;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.ErrorUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.UrlUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import id.dana.wallet_v3.constant.WalletConstant;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0095\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u0095\u0001\u0096\u0001B\b¢\u0006\u0005\b\u0094\u0001\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\r\u001a\u00020\u000b2\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\b\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\r\u0010\u0013J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0007\u0010\u0015J\u0017\u0010\r\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\u0019J\u0019\u0010$\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000bH\u0014¢\u0006\u0004\b&\u0010\u0019J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010\u0019J\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010)J\u000f\u00104\u001a\u00020\u000bH\u0014¢\u0006\u0004\b4\u0010\u0019J!\u00107\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u00108J'\u0010<\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u000bH\u0016¢\u0006\u0004\b>\u0010\u0019J\u000f\u0010?\u001a\u00020\u000bH\u0016¢\u0006\u0004\b?\u0010\u0019J\u000f\u0010@\u001a\u00020\u000bH\u0016¢\u0006\u0004\b@\u0010\u0019J\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010BR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010DR\u0013\u0010I\u001a\u00020FX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010LR\u0013\u0010\u0007\u001a\u00020NX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\bO\u0010HR$\u0010W\u001a\u0004\u0018\u00010P8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0018\u0010E\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010[\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bZ\u0010YR\u0018\u0010C\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\\\u0010YR\u0016\u0010_\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010^R\u0018\u0010X\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\be\u0010DR\u001a\u0010k\u001a\u00020f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\"\u0010m\u001a\u00020l8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0016\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bs\u0010^R\u001a\u0010v\u001a\u00020f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bt\u0010h\u001a\u0004\bu\u0010jR\"\u0010x\u001a\u00020w8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b~\u0010^R\u0016\u0010G\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010^R\u0017\u0010a\u001a\u00030\u0080\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\\\u001a\u00020\u000f8\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0015\u0010]\u001a\u00030\u008c\u0001X\u0083\u0080\u0002¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010HR\u0015\u0010Z\u001a\u00030\u008e\u0001X\u0083\u0080\u0002¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010HR\u0015\u0010d\u001a\u00030\u0090\u0001X\u0083\u0080\u0002¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010HR\u0015\u0010t\u001a\u00030\u0092\u0001X\u0083\u0080\u0002¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010H"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivitySecuritySettingsBinding;", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$View;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "Lid/dana/domain/profilemenu/model/SettingModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/domain/profilemenu/model/SettingModel;", "Landroid/content/Intent;", "(Landroid/content/Intent;)Ljava/lang/String;", "Lid/dana/myprofile/mepagerevamp/securitysettings/viewholder/NewProfileMenuFaceAuthViewHolder;", "()Lid/dana/myprofile/mepagerevamp/securitysettings/viewholder/NewProfileMenuFaceAuthViewHolder;", "", "(Ljava/lang/String;)I", IAPSyncCommand.COMMAND_INIT, "()V", "initViewBinding", "()Lid/dana/databinding/ActivitySecuritySettingsBinding;", RequestPermission.REQUEST_CODE, "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "enable", "onGetChangePinNativeEntryConfig", "(Z)V", "onGetUserInfoFailed", "Lid/dana/model/UserInfo;", "userInfo", "onGetUserInfoSuccess", "(Lid/dana/model/UserInfo;)V", "enrollmentState", "onPasskeyEnrollmentStatusFetched", "(Ljava/lang/String;)V", "enabled", "onPasskeyFeatureEnabled", "onResume", WalletConstant.KYC_LEVEL, "kycCertified", "onUserKycInfo", "(Ljava/lang/String;Z)V", "isFaceLoginEnabled", "hasEnrolled", "isFaceLoginReady", "setFaceLoginState", "(ZZZ)V", "showErrorToast", "showSecurityQuestionStateOff", "showSecurityQuestionStateOn", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "lookAheadTest", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/ui/createpin/CreatePinLauncher;", "initRecordTimeStamp", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "GetContactSyncConfig", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "getAuthRequestContext", "Lid/dana/riskChallenges/ui/passkey/launcher/enrollment/EnrollPasskeyLauncher;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsActivity$Listener;", "DatabaseTableConfigUtil", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsActivity$Listener;", "getFaceAuthListener", "()Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsActivity$Listener;", "setFaceAuthListener", "(Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsActivity$Listener;)V", "faceAuthListener", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/Boolean;", "PrepareContext", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "Z", "scheduleImpl", "Ljava/util/concurrent/atomic/AtomicBoolean;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getErrorConfigVersion", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "getLocationPermission", "()Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "locationPermission", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "mePageRevampPresenter", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "getMePageRevampPresenter", "()Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "setMePageRevampPresenter", "(Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;)V", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda5", "getPhonePermission", "phonePermission", "Lid/dana/lib/bio/productpage/ProductPageManager;", "productPageManager", "Lid/dana/lib/bio/productpage/ProductPageManager;", "getProductPageManager", "()Lid/dana/lib/bio/productpage/ProductPageManager;", "setProductPageManager", "(Lid/dana/lib/bio/productpage/ProductPageManager;)V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "getSupportButtonTintMode", "Lid/dana/myprofile/mepagerevamp/securitysettings/adapter/SecuritySettingsAdapter;", "SubSequence", "Lid/dana/myprofile/mepagerevamp/securitysettings/adapter/SecuritySettingsAdapter;", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$Presenter;", "securitySettingsPresenter", "Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$Presenter;", "getSecuritySettingsPresenter", "()Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$Presenter;", "setSecuritySettingsPresenter", "(Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsContract$Presenter;)V", "whenAvailable", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "readMicros", "Lid/dana/core/ui/dialog/DanaAlertDialog;", "getCallingPid", "Lid/dana/riskChallenges/ui/passkey/launcher/unlink/UnlinkPasskeyLauncher;", "C", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinLauncher;", "BottomSheetCardBindingView$watcherCardNumberView$1", "<init>", "Companion", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SecuritySettingsActivity extends ViewBindingActivity<ActivitySecuritySettingsBinding> implements SecuritySettingsContract.View {
    private static int A = 0;
    private static int B = 0;
    private static byte[] D = null;
    public static final String NETWORK_EXCEPTION = "NETWORK_EXCEPTION";
    public static final String SECURITY_SETTINGS_COLLECTION = "setting_collection_security_settings";
    private static int VerifyPinStateManager$executeRiskChallenge$2$1;
    private static short[] getOnBoardingScenario;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: C  reason: from kotlin metadata */
    private final Lazy newProxyInstance;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private Listener faceAuthListener;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private DanaLogoLoadingDialog getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private Boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final ActivityPermissionRequest locationPermission;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final ActivityPermissionRequest phonePermission;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private Boolean lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private AtomicBoolean getErrorConfigVersion;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private Boolean moveToNextValue;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final Lazy PrepareContext;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String PlaceComponentResult;
    @Inject
    public MePageRevampContract.Presenter mePageRevampPresenter;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;
    @Inject
    public ProductPageManager productPageManager;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final Lazy isLayoutRequested;
    @Inject
    public SecuritySettingsContract.Presenter securitySettingsPresenter;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private SettingModel NetworkUserEntityData$$ExternalSyntheticLambda7;
    public static final byte[] $$a = {59, -54, -26, -72, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 118;
    public static final byte[] PlaceComponentResult = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 88;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private final SecuritySettingsAdapter NetworkUserEntityData$$ExternalSyntheticLambda8 = new SecuritySettingsAdapter();

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            byte[] r0 = id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.PlaceComponentResult
            int r7 = 23 - r7
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L2f
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L2f:
            int r6 = r6 + 1
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.a(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r7 = 46 - r7
            byte[] r0 = id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.$$a
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r7 = r7 + 1
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.c(byte, short, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        B = 1257195769;
        A = 1291369327;
        D = new byte[]{-97, -111, -99, 107, 98, -67, -67, 36, -101, -34, 85, 100, 101, 98, -111, 105, -110, 100, -117, 67, -109, -100, 99, 108, -107, -117, 68, -102, -108, 108, -110, 106, -114, -67, -116, 33, -97, -112, -84, 85, 100, 101, 98, -111, 105, -110, 96, -103, 106, -116, 97, 101, 98, 99, -97, -80, 82, -103, -106, 108, -97, 98, -115, -80, -100, 78, -77, -99, 81, -80, -104, 103, 96, 76, -78, -104, 99, 98, 75, -101, 98, -83, 81, -77, -102, 80, -79, 76, -97, 96, -100, -76, -102, -97, 100, -102, 96, 82, 96, -100, 97, -79, 96, 96, 74, -85, 103, -99, 76, -77, 80, -77, -104, 80, 96, -83, -98, 96, -98, 102, 97, -97, -99, -101, -97, 99, -103, 101, 75, -83, 83, -86, 100, -99, -100, 82, -97, -76, -101, 79, -98, -82, -97, 81, -77, 76, -77, 72, -77, -100, 98, -102, 82, -84, 84, -85, -97, 97, -100, -97, 82, -80, 99, 73, 96, -77, -105, 104, 76, -99, -79, -98, 75, -101, -97, 80, -81, 98, -101, 97, -99, 80, -86, 96, 82, -99, -75, 76, -101, -98, -82, 103, -101, -100, 84, -79, -97, -99, 96, 74, -75, -103, 81, -78, 75, -77, 78, -97, -79, 96, 76, -80, -101, 77, 96, -81, 81, -81, 80, -101, -75, -104, 98, -99, -97, 102, -97, -97, -101, -99, 100, 97, 72, 98, -85, 96, 96, -103, -106, 112, -114, -87, 98, 35, -40, 36, -98, -111, 97, 102, -102, -91, 89, 102, -112, -83, 93, 97, -109, -86, 86, 108, -114, 115, -101, 97, -112, 109, -114, 115, -111, -90, 37, -98, -115, 97, 112, -116, 99, 108, -107, 107, -39, 82, 108, -110, 98, -86, -97, 106, 88, -100, 99, -97, -109, 96, -101, 101, -103, 106, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        VerifyPinStateManager$executeRiskChallenge$2$1 = -2030726631;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:331:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0930  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0935  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0b04 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:588:0x02bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r31) {
        /*
            Method dump skipped, instructions count: 2821
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Class<?> cls;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((-102232975) - TextUtils.indexOf("", "", 0), super.getResources().getString(R.string.toast_create_saving_goal_success).substring(0, 5).codePointAt(2) - 197, (byte) (super.getResources().getString(R.string.invalid_number_dialog_description).substring(47, 49).codePointAt(1) + SecLiteException.ERROR_API_KEY_OR_SIGN), (short) (getPackageName().length() - 7), 870655357 + super.getResources().getString(R.string.retry_limit_read_card_title).substring(0, 18).length(), objArr);
            Class<?> cls2 = Class.forName((String) objArr[0]);
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                cls = Class.forName((String) objArr2[0]);
                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr3 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 102233006, super.getResources().getString(R.string.social_feeds_activate_feed).substring(8, 13).codePointAt(1) - 154, (byte) (super.getResources().getString(R.string.passkey_enrollment_main_title).substring(5, 6).length() - 1), (short) (getPackageName().codePointAt(5) - 110), 870655400 - TextUtils.getCapsMode("", 0, 0), objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), View.MeasureSpec.getMode(0) + 18, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
        super.onPause();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    public SecuritySettingsActivity() {
        Boolean bool = Boolean.FALSE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = bool;
        this.lookAheadTest = bool;
        this.moveToNextValue = bool;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        this.PrepareContext = LazyKt.lazy(new Function0<DanaAlertDialog>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$unlinkConfirmDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaAlertDialog invoke() {
                DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(SecuritySettingsActivity.this);
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_warning_24;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.passkey_unlink_dialog_title);
                builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.passkey_unlink_dialog_description);
                builder.PrepareContext = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.passkey_unlink_dialog_delete);
                final SecuritySettingsActivity securitySettingsActivity = SecuritySettingsActivity.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$unlinkConfirmDialog$2.1
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
                        DanaLogoLoadingDialog danaLogoLoadingDialog;
                        danaLogoLoadingDialog = SecuritySettingsActivity.this.getAuthRequestContext;
                        if (danaLogoLoadingDialog == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            danaLogoLoadingDialog = null;
                        }
                        if (!danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
                            danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
                            danaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
                        }
                        SecuritySettingsActivity.access$getUnlinkPasskeyLauncher(SecuritySettingsActivity.this).BuiltInFictitiousFunctionClassFactory();
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder.newProxyInstance = function0;
                builder.initRecordTimeStamp = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.passkey_unlink_dialog_cancel);
                builder.lookAheadTest = Boolean.FALSE;
                return builder.BuiltInFictitiousFunctionClassFactory();
            }
        });
        this.isLayoutRequested = LazyKt.lazy(new Function0<UiComponent>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$uiComponentChangePIN$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UiComponent invoke() {
                return new UiComponent(UIComponentType.Full, R.color.f27072131100488, R.string.change_pin);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = LazyKt.lazy(new Function0<VerifyPinLauncher>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$verifyPinLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VerifyPinLauncher invoke() {
                VerifyPinLauncher.Builder builder = new VerifyPinLauncher.Builder(SecuritySettingsActivity.this);
                UseCaseStrategy useCaseStrategy = new UseCaseStrategy("MODIFY_PASSWORD", null, null, 6, null);
                Intrinsics.checkNotNullParameter(useCaseStrategy, "");
                builder.PlaceComponentResult = useCaseStrategy;
                Intrinsics.checkNotNullParameter("RESET_PASSWORD", "");
                builder.getAuthRequestContext = "RESET_PASSWORD";
                Intrinsics.checkNotNullParameter("Change PIN", "");
                builder.BuiltInFictitiousFunctionClassFactory = "Change PIN";
                UiComponent access$getUiComponentChangePIN = SecuritySettingsActivity.access$getUiComponentChangePIN(SecuritySettingsActivity.this);
                Intrinsics.checkNotNullParameter(access$getUiComponentChangePIN, "");
                builder.scheduleImpl = access$getUiComponentChangePIN;
                final SecuritySettingsActivity securitySettingsActivity = SecuritySettingsActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$verifyPinLauncher$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Parcelable parcelable;
                        SecurityInfoModel placeComponentResult;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        String str = null;
                        if (Build.VERSION.SDK_INT >= 33) {
                            parcelable = (Parcelable) bundle.getParcelable("KEY_DATA_RISK_CONSULT", BasicRiskChallengesModel.class);
                        } else {
                            Parcelable parcelable2 = bundle.getParcelable("KEY_DATA_RISK_CONSULT");
                            if (!(parcelable2 instanceof BasicRiskChallengesModel)) {
                                parcelable2 = null;
                            }
                            parcelable = (BasicRiskChallengesModel) parcelable2;
                        }
                        BasicRiskChallengesModel basicRiskChallengesModel = (BasicRiskChallengesModel) parcelable;
                        String string = bundle.getString("KEY_PHONE_NUMBER");
                        CreatePinLauncher access$getCreatePinLauncher = SecuritySettingsActivity.access$getCreatePinLauncher(SecuritySettingsActivity.this);
                        if (string == null) {
                            string = "";
                        }
                        Intrinsics.checkNotNullParameter(string, "");
                        access$getCreatePinLauncher.PlaceComponentResult = string;
                        String kClassImpl$Data$declaredNonStaticMembers$2 = basicRiskChallengesModel != null ? basicRiskChallengesModel.getKClassImpl$Data$declaredNonStaticMembers$2() : null;
                        if (kClassImpl$Data$declaredNonStaticMembers$2 == null) {
                            kClassImpl$Data$declaredNonStaticMembers$2 = "";
                        }
                        Intrinsics.checkNotNullParameter(kClassImpl$Data$declaredNonStaticMembers$2, "");
                        access$getCreatePinLauncher.KClassImpl$Data$declaredNonStaticMembers$2 = kClassImpl$Data$declaredNonStaticMembers$2;
                        if (basicRiskChallengesModel != null && (placeComponentResult = basicRiskChallengesModel.getPlaceComponentResult()) != null) {
                            str = placeComponentResult.MyBillsEntityDataFactory;
                        }
                        if (str == null) {
                            str = "";
                        }
                        Intrinsics.checkNotNullParameter(str, "");
                        access$getCreatePinLauncher.BuiltInFictitiousFunctionClassFactory = str;
                        access$getCreatePinLauncher.BuiltInFictitiousFunctionClassFactory();
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder.getErrorConfigVersion = function1;
                final SecuritySettingsActivity securitySettingsActivity2 = SecuritySettingsActivity.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$verifyPinLauncher$2.2
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
                        SecuritySettingsActivity.this.scheduleImpl = false;
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
                final SecuritySettingsActivity securitySettingsActivity3 = SecuritySettingsActivity.this;
                Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$verifyPinLauncher$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Intrinsics.checkNotNullParameter(bundle, "");
                        SecuritySettingsActivity.this.scheduleImpl = false;
                    }
                };
                Intrinsics.checkNotNullParameter(function12, "");
                builder.PlaceComponentResult = function12;
                return builder.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<CreatePinLauncher>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$createPinLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreatePinLauncher invoke() {
                CreatePinLauncher.Builder builder = new CreatePinLauncher.Builder(SecuritySettingsActivity.this);
                Intrinsics.checkNotNullParameter("Change PIN", "");
                builder.BuiltInFictitiousFunctionClassFactory = "Change PIN";
                UseCaseStrategy useCaseStrategy = new UseCaseStrategy("MODIFY_PASSWORD", null, null, 6, null);
                Intrinsics.checkNotNullParameter(useCaseStrategy, "");
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = useCaseStrategy;
                UiComponent access$getUiComponentChangePIN = SecuritySettingsActivity.access$getUiComponentChangePIN(SecuritySettingsActivity.this);
                Intrinsics.checkNotNullParameter(access$getUiComponentChangePIN, "");
                builder.scheduleImpl = access$getUiComponentChangePIN;
                final SecuritySettingsActivity securitySettingsActivity = SecuritySettingsActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$createPinLauncher$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Intrinsics.checkNotNullParameter(bundle, "");
                        SecuritySettingsActivity.this.PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$trackPinCreateComplete$1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder2) {
                                invoke2(builder2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(EventTrackerModel.Builder builder2) {
                                Intrinsics.checkNotNullParameter(builder2, "");
                                builder2.MyBillsEntityDataFactory = TrackerKey.Event.PIN_CREATE_COMPLETE;
                                builder2.MyBillsEntityDataFactory("Source", "Change PIN");
                            }
                        });
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder.getErrorConfigVersion = function1;
                final SecuritySettingsActivity securitySettingsActivity2 = SecuritySettingsActivity.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$createPinLauncher$2.2
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
                        SecuritySettingsActivity.this.scheduleImpl = false;
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder.MyBillsEntityDataFactory = function0;
                return builder.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<EnrollPasskeyLauncher>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$enrollPasskeyLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EnrollPasskeyLauncher invoke() {
                EnrollPasskeyLauncher.Builder builder = new EnrollPasskeyLauncher.Builder(SecuritySettingsActivity.this);
                Intrinsics.checkNotNullParameter("Security Setting", "");
                builder.moveToNextValue = "Security Setting";
                Intrinsics.checkNotNullParameter("Enroll", "");
                builder.PlaceComponentResult = "Enroll";
                Intrinsics.checkNotNullParameter("PROFILE", "");
                builder.MyBillsEntityDataFactory = "PROFILE";
                final SecuritySettingsActivity securitySettingsActivity = SecuritySettingsActivity.this;
                EnrollPasskeyLauncher.Builder BuiltInFictitiousFunctionClassFactory = EnrollPasskeyLauncher.Builder.BuiltInFictitiousFunctionClassFactory(builder, false, false, new Function1<List<? extends PasskeyCredential>, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$enrollPasskeyLauncher$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends PasskeyCredential> list) {
                        invoke2((List<PasskeyCredential>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<PasskeyCredential> list) {
                        AtomicBoolean atomicBoolean;
                        Intrinsics.checkNotNullParameter(list, "");
                        StringBuilder sb = new StringBuilder();
                        sb.append("SIZE: ");
                        sb.append(list.size());
                        DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
                        atomicBoolean = SecuritySettingsActivity.this.getErrorConfigVersion;
                        atomicBoolean.set(!list.isEmpty());
                        SecuritySettingsActivity.this.onPasskeyEnrollmentStatusFetched(list.isEmpty() ? NewSwitchFaceAuthenticationView.NOT_ENROLLED : NewSwitchFaceAuthenticationView.ENROLLED);
                    }
                }, null, 11);
                final SecuritySettingsActivity securitySettingsActivity2 = SecuritySettingsActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$enrollPasskeyLauncher$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        AtomicBoolean atomicBoolean;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        atomicBoolean = SecuritySettingsActivity.this.getErrorConfigVersion;
                        atomicBoolean.set(true);
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = function1;
                final SecuritySettingsActivity securitySettingsActivity3 = SecuritySettingsActivity.this;
                Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$enrollPasskeyLauncher$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        AtomicBoolean atomicBoolean;
                        Intrinsics.checkNotNullParameter(bundle, "");
                        atomicBoolean = SecuritySettingsActivity.this.getErrorConfigVersion;
                        atomicBoolean.set(false);
                    }
                };
                Intrinsics.checkNotNullParameter(function12, "");
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = function12;
                return BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.getErrorConfigVersion = new AtomicBoolean(false);
        SecuritySettingsActivity securitySettingsActivity = this;
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) securitySettingsActivity);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$phonePermission$1
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
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(SecuritySettingsActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.phonePermission = builder.PlaceComponentResult();
        ActivityPermissionRequest.Builder builder2 = new ActivityPermissionRequest.Builder((ComponentActivity) securitySettingsActivity);
        String[] strArr2 = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.PlaceComponentResult = ArraysKt.toSet(strArr2);
        PermissionCallback permissionCallback2 = new PermissionCallback() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$locationPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                SecuritySettingsAdapter securitySettingsAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                securitySettingsAdapter = SecuritySettingsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                ViewGroup viewGroup = securitySettingsAdapter.KClassImpl$Data$declaredNonStaticMembers$2;
                ProfileMenuLocationPermissionViewHolder profileMenuLocationPermissionViewHolder = viewGroup != null ? new ProfileMenuLocationPermissionViewHolder(viewGroup) : null;
                if (profileMenuLocationPermissionViewHolder != null) {
                    profileMenuLocationPermissionViewHolder.MyBillsEntityDataFactory.setLocationPermissionEnabled(false);
                    Iterator<PermissionReport> it = p0.BuiltInFictitiousFunctionClassFactory.iterator();
                    while (it.hasNext()) {
                        if (it.next().getBuiltInFictitiousFunctionClassFactory()) {
                            profileMenuLocationPermissionViewHolder.MyBillsEntityDataFactory.setLocationPermissionEnabled(true);
                            return;
                        }
                    }
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PermissionHelper.MyBillsEntityDataFactory(SecuritySettingsActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback2, "");
        builder2.getAuthRequestContext = permissionCallback2;
        this.locationPermission = builder2.PlaceComponentResult();
        this.newProxyInstance = LazyKt.lazy(new Function0<UnlinkPasskeyLauncher>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$unlinkPasskeyLauncher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnlinkPasskeyLauncher invoke() {
                UnlinkPasskeyLauncher.Builder builder3 = new UnlinkPasskeyLauncher.Builder(SecuritySettingsActivity.this);
                Intrinsics.checkNotNullParameter("Security Setting", "");
                builder3.BuiltInFictitiousFunctionClassFactory = "Security Setting";
                Intrinsics.checkNotNullParameter("Unlink", "");
                builder3.MyBillsEntityDataFactory = "Unlink";
                final SecuritySettingsActivity securitySettingsActivity2 = SecuritySettingsActivity.this;
                Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$unlinkPasskeyLauncher$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Intrinsics.checkNotNullParameter(bundle, "");
                        DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                        SecuritySettingsActivity securitySettingsActivity3 = SecuritySettingsActivity.this;
                        SecuritySettingsActivity securitySettingsActivity4 = securitySettingsActivity3;
                        String string = securitySettingsActivity3.getString(R.string.passkey_delete_success);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        DANAToast.PlaceComponentResult(securitySettingsActivity4, string, "");
                        SecuritySettingsActivity.access$getEnrollPasskeyLauncher(SecuritySettingsActivity.this).getAuthRequestContext();
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                builder3.getErrorConfigVersion = function1;
                final SecuritySettingsActivity securitySettingsActivity3 = SecuritySettingsActivity.this;
                Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$unlinkPasskeyLauncher$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                        invoke2(bundle);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Bundle bundle) {
                        Intrinsics.checkNotNullParameter(bundle, "");
                        DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                        SecuritySettingsActivity securitySettingsActivity4 = SecuritySettingsActivity.this;
                        SecuritySettingsActivity securitySettingsActivity5 = securitySettingsActivity4;
                        String string = securitySettingsActivity4.getString(R.string.passkey_delete_failed);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        DANAToast.MyBillsEntityDataFactory(securitySettingsActivity5, string, "");
                        SecuritySettingsActivity.access$getEnrollPasskeyLauncher(SecuritySettingsActivity.this).getAuthRequestContext();
                    }
                };
                Intrinsics.checkNotNullParameter(function12, "");
                builder3.PlaceComponentResult = function12;
                final SecuritySettingsActivity securitySettingsActivity4 = SecuritySettingsActivity.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$unlinkPasskeyLauncher$2.3
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
                        DanaLogoLoadingDialog danaLogoLoadingDialog;
                        danaLogoLoadingDialog = SecuritySettingsActivity.this.getAuthRequestContext;
                        if (danaLogoLoadingDialog == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            danaLogoLoadingDialog = null;
                        }
                        danaLogoLoadingDialog.PlaceComponentResult();
                    }
                };
                Intrinsics.checkNotNullParameter(function0, "");
                builder3.MyBillsEntityDataFactory = function0;
                return builder3.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @JvmName(name = "getMePageRevampPresenter")
    public final MePageRevampContract.Presenter getMePageRevampPresenter() {
        MePageRevampContract.Presenter presenter = this.mePageRevampPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMePageRevampPresenter")
    public final void setMePageRevampPresenter(MePageRevampContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.mePageRevampPresenter = presenter;
    }

    @JvmName(name = "getSecuritySettingsPresenter")
    public final SecuritySettingsContract.Presenter getSecuritySettingsPresenter() {
        SecuritySettingsContract.Presenter presenter = this.securitySettingsPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSecuritySettingsPresenter")
    public final void setSecuritySettingsPresenter(SecuritySettingsContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.securitySettingsPresenter = presenter;
    }

    @JvmName(name = "getProductPageManager")
    public final ProductPageManager getProductPageManager() {
        ProductPageManager productPageManager = this.productPageManager;
        if (productPageManager != null) {
            return productPageManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setProductPageManager")
    public final void setProductPageManager(ProductPageManager productPageManager) {
        Intrinsics.checkNotNullParameter(productPageManager, "");
        this.productPageManager = productPageManager;
    }

    @JvmName(name = "getFaceAuthListener")
    public final Listener getFaceAuthListener() {
        return this.faceAuthListener;
    }

    @JvmName(name = "setFaceAuthListener")
    public final void setFaceAuthListener(Listener listener) {
        this.faceAuthListener = listener;
    }

    @JvmName(name = "getPhonePermission")
    public final ActivityPermissionRequest getPhonePermission() {
        return this.phonePermission;
    }

    @JvmName(name = "getLocationPermission")
    public final ActivityPermissionRequest getLocationPermission() {
        return this.locationPermission;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        try {
            byte b = PlaceComponentResult[25];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), objArr3);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 102233008;
            try {
                byte b3 = PlaceComponentResult[25];
                byte b4 = b3;
                Object[] objArr4 = new Object[1];
                a(b3, b4, b4, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
                Object[] objArr5 = new Object[1];
                b(i, ((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 117, (byte) (super.getResources().getString(R.string.investment_home_balance_description_empty).substring(7, 8).codePointAt(0) - 117), (short) (super.getResources().getString(R.string.desc_error_failed_beneficiary_list).substring(1, 2).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN), super.getResources().getString(R.string.member_services_information).substring(41, 43).length() + 870655352, objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                int codePointAt = super.getResources().getString(R.string.FamilyDashboardPresenter_Factory).substring(0, 9).codePointAt(2) - 102233079;
                int i2 = (-96) - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1));
                try {
                    byte b5 = PlaceComponentResult[25];
                    byte b6 = b5;
                    Object[] objArr6 = new Object[1];
                    a(b5, b6, b6, objArr6);
                    Class<?> cls4 = Class.forName((String) objArr6[0]);
                    a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
                    Object[] objArr7 = new Object[1];
                    b(codePointAt, i2, (byte) (((ApplicationInfo) cls4.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), super.getResources().getString(R.string.mybills_detail_label_kk_va_number).substring(5, 6).length() + 870655370, objArr7);
                    int intValue = ((Integer) cls3.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            Object[] objArr8 = new Object[1];
                            b(super.getResources().getString(R.string.my_bills_label_dana_balance_insufficient).substring(22, 23).length() - 102232976, (-76) - KeyEvent.keyCodeFromString(""), (byte) View.resolveSize(0, 0), (short) (getPackageName().codePointAt(3) - 100), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 870655375, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            int scrollBarFadeDuration = (-102232973) - (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                            int length = super.getResources().getString(R.string.ask_the_recipient_to_tap_on).substring(42, 44).length() - 86;
                            try {
                                byte b7 = PlaceComponentResult[25];
                                byte b8 = b7;
                                Object[] objArr9 = new Object[1];
                                a(b7, b8, b8, objArr9);
                                Class<?> cls6 = Class.forName((String) objArr9[0]);
                                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
                                Object[] objArr10 = new Object[1];
                                b(scrollBarFadeDuration, length, (byte) (((ApplicationInfo) cls6.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), (short) View.resolveSize(0, 0), getPackageName().codePointAt(1) + 870655300, objArr10);
                                baseContext = (Context) cls5.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        if (baseContext != null) {
                            baseContext = baseContext.getApplicationContext();
                        }
                        if (baseContext != null) {
                            try {
                                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj == null) {
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                Object[] objArr11 = new Object[1];
                                b((-102233017) - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), super.getResources().getString(R.string.nps_survey_hint_suggestion).substring(0, 1).codePointAt(0) - 119, (byte) (super.getResources().getString(R.string.auto_routing_success_deactivation).substring(23, 25).codePointAt(1) - 100), (short) (super.getResources().getString(R.string.SchedulerPoolFactory).substring(2, 7).codePointAt(2) + SecLiteException.ERROR_API_KEY_OR_SIGN), getPackageName().length() + 870655410, objArr11);
                                String str = (String) objArr11[0];
                                int length2 = getPackageName().length() - 102232982;
                                try {
                                    byte b9 = PlaceComponentResult[25];
                                    byte b10 = b9;
                                    Object[] objArr12 = new Object[1];
                                    a(b9, b10, b10, objArr12);
                                    Class<?> cls7 = Class.forName((String) objArr12[0]);
                                    a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
                                    Object[] objArr13 = new Object[1];
                                    b(length2, ((ApplicationInfo) cls7.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 71, (byte) (super.getResources().getString(R.string.tooltip_smartpay_available_title).substring(0, 9).codePointAt(1) - 109), (short) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), super.getResources().getString(R.string.global_search_bottomsheet_general_error_desc).substring(62, 64).length() + 870655462, objArr13);
                                    String str2 = (String) objArr13[0];
                                    int resolveSize = View.resolveSize(0, 0) - 102233022;
                                    int red = (-38) - Color.red(0);
                                    try {
                                        byte b11 = PlaceComponentResult[25];
                                        byte b12 = b11;
                                        Object[] objArr14 = new Object[1];
                                        a(b11, b12, b12, objArr14);
                                        Class<?> cls8 = Class.forName((String) objArr14[0]);
                                        a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
                                        Object[] objArr15 = new Object[1];
                                        b(resolveSize, red, (byte) (((ApplicationInfo) cls8.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (super.getResources().getString(R.string.title_card_expired).substring(11, 12).length() - 1), super.getResources().getString(R.string.res_0x7f130e6f_networkuserentitydata_externalsyntheticlambda7).substring(0, 2).length() + 870655525, objArr15);
                                        String str3 = (String) objArr15[0];
                                        int indexOf = TextUtils.indexOf("", "", 0, 0) - 102232968;
                                        int resolveSize2 = View.resolveSize(0, 0) - 42;
                                        byte scrollBarFadeDuration2 = (byte) (ViewConfiguration.getScrollBarFadeDuration() >> 16);
                                        try {
                                            byte b13 = PlaceComponentResult[25];
                                            byte b14 = b13;
                                            Object[] objArr16 = new Object[1];
                                            a(b13, b14, b14, objArr16);
                                            Class<?> cls9 = Class.forName((String) objArr16[0]);
                                            a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
                                            short s = (short) (((ApplicationInfo) cls9.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33);
                                            try {
                                                byte b15 = PlaceComponentResult[25];
                                                byte b16 = b15;
                                                Object[] objArr17 = new Object[1];
                                                a(b15, b16, b16, objArr17);
                                                Class<?> cls10 = Class.forName((String) objArr17[0]);
                                                Object[] objArr18 = new Object[1];
                                                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), objArr18);
                                                int i3 = ((ApplicationInfo) cls10.getMethod((String) objArr18[0], null).invoke(this, null)).targetSdkVersion + 870655557;
                                                Object[] objArr19 = new Object[1];
                                                b(indexOf, resolveSize2, scrollBarFadeDuration2, s, i3, objArr19);
                                                String str4 = (String) objArr19[0];
                                                Object[] objArr20 = new Object[1];
                                                b(super.getResources().getString(R.string.twilio_bottomsheet_left_attempt).substring(20, 21).codePointAt(0) - 102233120, Gravity.getAbsoluteGravity(0, 0) - 96, (byte) (ViewConfiguration.getScrollDefaultDelay() >> 16), (short) (super.getResources().getString(R.string.parking_description).substring(10, 11).length() - 1), super.getResources().getString(R.string.success_unbind_notification_message).substring(10, 11).length() + 870655648, objArr20);
                                                try {
                                                    Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                    if (obj2 == null) {
                                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), (Process.myPid() >> 22) + 18, (char) (MotionEvent.axisFromString("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                    }
                                                    ((Method) obj2).invoke(invoke, objArr21);
                                                } catch (Throwable th2) {
                                                    Throwable cause2 = th2.getCause();
                                                    if (cause2 == null) {
                                                        throw th2;
                                                    }
                                                    throw cause2;
                                                }
                                            } catch (Throwable th3) {
                                                Throwable cause3 = th3.getCause();
                                                if (cause3 == null) {
                                                    throw th3;
                                                }
                                                throw cause3;
                                            }
                                        } catch (Throwable th4) {
                                            Throwable cause4 = th4.getCause();
                                            if (cause4 == null) {
                                                throw th4;
                                            }
                                            throw cause4;
                                        }
                                    } catch (Throwable th5) {
                                        Throwable cause5 = th5.getCause();
                                        if (cause5 == null) {
                                            throw th5;
                                        }
                                        throw cause5;
                                    }
                                } catch (Throwable th6) {
                                    Throwable cause6 = th6.getCause();
                                    if (cause6 == null) {
                                        throw th6;
                                    }
                                    throw cause6;
                                }
                            } catch (Throwable th7) {
                                Throwable cause7 = th7.getCause();
                                if (cause7 == null) {
                                    throw th7;
                                }
                                throw cause7;
                            }
                        }
                    }
                    try {
                        Object[] objArr22 = new Object[1];
                        a((byte) 37, (byte) (-PlaceComponentResult[30]), PlaceComponentResult[32], objArr22);
                        Class<?> cls11 = Class.forName((String) objArr22[0]);
                        byte b17 = PlaceComponentResult[35];
                        byte b18 = (byte) (-PlaceComponentResult[30]);
                        Object[] objArr23 = new Object[1];
                        a(b17, b18, (byte) (b18 + 1), objArr23);
                        try {
                            Object[] objArr24 = {Integer.valueOf(((Integer) cls11.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls12 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 494, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 3, (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
                                Object[] objArr25 = new Object[1];
                                c($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr25);
                                obj3 = cls12.getMethod((String) objArr25[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr26 = (Object[]) ((Method) obj3).invoke(null, objArr24);
                            int i4 = ((int[]) objArr26[1])[0];
                            if (((int[]) objArr26[0])[0] != i4) {
                                long j = ((r2 ^ i4) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), View.getDefaultSize(0, 0) + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr27 = {-898442767, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr27);
                                    } catch (Throwable th8) {
                                        Throwable cause8 = th8.getCause();
                                        if (cause8 == null) {
                                            throw th8;
                                        }
                                        throw cause8;
                                    }
                                } catch (Throwable th9) {
                                    Throwable cause9 = th9.getCause();
                                    if (cause9 == null) {
                                        throw th9;
                                    }
                                    throw cause9;
                                }
                            }
                            super.onCreate(savedInstanceState);
                            this.getAuthRequestContext = new DanaLogoLoadingDialog(this);
                            getLifecycle().BuiltInFictitiousFunctionClassFactory((VerifyPinLauncher) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue());
                            getLifecycle().BuiltInFictitiousFunctionClassFactory((CreatePinLauncher) this.MyBillsEntityDataFactory.getValue());
                            getLifecycle().BuiltInFictitiousFunctionClassFactory((EnrollPasskeyLauncher) this.BuiltInFictitiousFunctionClassFactory.getValue());
                            getLifecycle().BuiltInFictitiousFunctionClassFactory((UnlinkPasskeyLauncher) this.newProxyInstance.getValue());
                        } catch (Throwable th10) {
                            Throwable cause10 = th10.getCause();
                            if (cause10 == null) {
                                throw th10;
                            }
                            throw cause10;
                        }
                    } catch (Throwable th11) {
                        Throwable cause11 = th11.getCause();
                        if (cause11 == null) {
                            throw th11;
                        }
                        throw cause11;
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        } catch (Throwable th14) {
            Throwable cause14 = th14.getCause();
            if (cause14 == null) {
                throw th14;
            }
            throw cause14;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivitySecuritySettingsBinding initViewBinding() {
        ActivitySecuritySettingsBinding BuiltInFictitiousFunctionClassFactory = ActivitySecuritySettingsBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        final String str;
        Context baseContext = getBaseContext();
        SettingModel settingModel = null;
        if (baseContext == null) {
            int length = getPackageName().length() - 102232982;
            int length2 = super.getResources().getString(R.string.payment_success).substring(0, 1).length() - 77;
            byte codePointAt = (byte) (super.getResources().getString(R.string.your_account_is_on_hold).substring(2, 3).codePointAt(0) - 117);
            try {
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
                Object[] objArr2 = new Object[1];
                b(length, length2, codePointAt, (short) (((ApplicationInfo) cls.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().codePointAt(4) + 870655278, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length3 = getPackageName().length() - 102232980;
                try {
                    byte b3 = PlaceComponentResult[25];
                    byte b4 = b3;
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[27], (byte) (-PlaceComponentResult[5]), new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(length3, ((ApplicationInfo) cls3.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 117, (byte) (super.getResources().getString(R.string.search_nearby_hint).substring(0, 1).length() - 1), (short) (super.getResources().getString(R.string.my_bills_label_dana_balance_sufficient).substring(0, 5).length() - 5), 870655400 - KeyEvent.getDeadChar(0, 0), objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), KeyEvent.getDeadChar(0, 0) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, TextUtils.getOffsetBefore("", 0) + 18, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 == null) {
                    throw th4;
                }
                throw cause4;
            }
        }
        super.onResume();
        SettingModel settingModel2 = (SettingModel) getIntent().getParcelableExtra(MyProfileBundleKey.SETTING_MODEL);
        if (settingModel2 != null) {
            Intrinsics.checkNotNullExpressionValue(settingModel2, "");
            String collection = settingModel2.getCollection();
            if (collection == null || collection.length() == 0) {
                settingModel2.setCollection(SECURITY_SETTINGS_COLLECTION);
            }
            String title = settingModel2.getTitle();
            if (title == null || StringsKt.isBlank(title)) {
                settingModel2.setTitle(getString(R.string.security_settings_toolbar_title));
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = settingModel2;
            setTitle(settingModel2.getTitle());
            setMenuLeftButton(R.drawable.btn_arrow_left);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null && this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            MePageRevampContract.Presenter mePageRevampPresenter = getMePageRevampPresenter();
            SettingModel settingModel3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (settingModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                settingModel = settingModel3;
            }
            String collection2 = settingModel.getCollection();
            Intrinsics.checkNotNullExpressionValue(collection2, "");
            mePageRevampPresenter.MyBillsEntityDataFactory(collection2);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        getSecuritySettingsPresenter().PlaceComponentResult();
        getSecuritySettingsPresenter().MyBillsEntityDataFactory();
        if (this.initRecordTimeStamp) {
            getSecuritySettingsPresenter().getAuthRequestContext();
            this.initRecordTimeStamp = false;
        }
        if (this.scheduleImpl) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null || (str = extras.getString(MyProfileBundleKey.MIXPANEL_SOURCE)) == null) {
            str = TrackerKey.SourceType.ME;
        }
        final boolean z = BuiltInFictitiousFunctionClassFactory("android.permission.ACCESS_FINE_LOCATION") && BuiltInFictitiousFunctionClassFactory(ManifestPermission.ACCESS_COARSE_LOCATION);
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$trackSecuritySettingOpenPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Boolean bool;
                boolean z2;
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SECURITY_SETTINGS_PAGE_OPEN;
                bool = SecuritySettingsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.DANA_VIZ_ACTIVE, Intrinsics.areEqual(bool, Boolean.TRUE));
                z2 = SecuritySettingsActivity.this.DatabaseTableConfigUtil;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.SECURITY_QUESTION_ACTIVE, z2);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.LOCATION_PERMISSION_ACTIVE, z);
                builder.MyBillsEntityDataFactory("Source", str);
            }
        });
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((VerifyPinLauncher) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue());
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((CreatePinLauncher) this.MyBillsEntityDataFactory.getValue());
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((EnrollPasskeyLauncher) this.BuiltInFictitiousFunctionClassFactory.getValue());
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((UnlinkPasskeyLauncher) this.newProxyInstance.getValue());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r2, int resultCode, Intent data) {
        super.onActivityResult(r2, resultCode, data);
        if (r2 == 1002) {
            if (resultCode == -1) {
                getSecuritySettingsPresenter().MyBillsEntityDataFactory();
                Listener listener = this.faceAuthListener;
                if (listener != null) {
                    listener.MyBillsEntityDataFactory();
                    Unit unit = Unit.INSTANCE;
                }
            } else if (resultCode == 0) {
                if (data != null && data.hasExtra(ChallengeControl.Key.CANCEL_REASON) && Intrinsics.areEqual(data.getStringExtra(ChallengeControl.Key.CANCEL_REASON), "NETWORK_EXCEPTION")) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                    Listener listener2 = this.faceAuthListener;
                    if (listener2 != null) {
                        listener2.KClassImpl$Data$declaredNonStaticMembers$2();
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                    Listener listener3 = this.faceAuthListener;
                    if (listener3 != null) {
                        listener3.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(data));
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            } else {
                Listener listener4 = this.faceAuthListener;
                if (listener4 != null) {
                    listener4.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(data));
                    Unit unit4 = Unit.INSTANCE;
                }
            }
            getSecuritySettingsPresenter().MyBillsEntityDataFactory();
        }
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        return ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, p0) == 0;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (isTaskRoot()) {
            Intent addFlags = new Intent(this, HomeTabActivity.class).addFlags(335544320);
            Intrinsics.checkNotNullExpressionValue(addFlags, "");
            startActivity(addFlags);
            finish();
            return;
        }
        super.onBackPressed();
    }

    public final void showErrorToast() {
        showToast(getString(R.string.SchedulerPoolFactory));
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.View
    public final void onGetChangePinNativeEntryConfig(boolean enable) {
        if (enable) {
            this.scheduleImpl = true;
            ((VerifyPinLauncher) this.NetworkUserEntityData$$ExternalSyntheticLambda5.getValue()).BuiltInFictitiousFunctionClassFactory();
            PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$trackPinChangeOpen$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(EventTrackerModel.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "");
                    builder.MyBillsEntityDataFactory = TrackerDataKey.Event.PIN_CHANGE;
                    builder.MyBillsEntityDataFactory("Source", "Me Page");
                }
            });
            return;
        }
        String str = this.PlaceComponentResult;
        if (str == null) {
            return;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(str);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext, new SecuritySettingsActivity$openH5Container$$inlined$withDanaH5Callback$1(this));
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.View
    public final void onPasskeyFeatureEnabled(boolean enabled) {
        if (!enabled || !this.getErrorConfigVersion.get()) {
            if (!enabled || this.getErrorConfigVersion.get()) {
                return;
            }
            EnrollPasskeyLauncher.Companion companion = EnrollPasskeyLauncher.INSTANCE;
            if (EnrollPasskeyLauncher.Companion.PlaceComponentResult()) {
                ((EnrollPasskeyLauncher) this.BuiltInFictitiousFunctionClassFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
                return;
            }
            return;
        }
        DanaAlertDialog danaAlertDialog = (DanaAlertDialog) this.PrepareContext.getValue();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        Intrinsics.checkNotNullParameter(supportFragmentManager, "");
        danaAlertDialog.show(supportFragmentManager, "DanaAlertDialog");
    }

    public final void onPasskeyEnrollmentStatusFetched(String enrollmentState) {
        Intrinsics.checkNotNullParameter(enrollmentState, "");
        SettingModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.SETTING_PASSKEY_ENROLLMENT);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.setEnrolmentState(enrollmentState);
            SecuritySettingsAdapter securitySettingsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String parent = KClassImpl$Data$declaredNonStaticMembers$2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "");
            Intrinsics.checkNotNullParameter(parent, "");
            int BuiltInFictitiousFunctionClassFactory = securitySettingsAdapter.BuiltInFictitiousFunctionClassFactory(parent);
            if (BuiltInFictitiousFunctionClassFactory != -1) {
                securitySettingsAdapter.notifyItemChanged(BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.View
    public final void showSecurityQuestionStateOn() {
        this.DatabaseTableConfigUtil = true;
        String string = getString(R.string.security_setting_question_state_on);
        Intrinsics.checkNotNullExpressionValue(string, "");
        KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.SETTING_SECURITY_QUESTIONS, string);
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.View
    public final void showSecurityQuestionStateOff() {
        this.DatabaseTableConfigUtil = false;
        String string = getString(R.string.setting_field_unset_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.SETTING_SECURITY_QUESTIONS, string);
    }

    public final void onUserKycInfo(String r1, boolean kycCertified) {
        this.GetContactSyncConfig = kycCertified;
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.View
    public final void onGetUserInfoSuccess(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "");
        MixPanelTracker.MyBillsEntityDataFactory(userInfo.getGetAuthRequestContext());
        MixPanelTracker.getAuthRequestContext(userInfo.getPlaceComponentResult());
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.View
    public final void onGetUserInfoFailed() {
        SettingModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.SETTING_FACE_VERIFICATION);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.setEnrolmentState(NewSwitchFaceAuthenticationView.ERROR_FETCH);
            SecuritySettingsAdapter securitySettingsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String parent = KClassImpl$Data$declaredNonStaticMembers$2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "");
            Intrinsics.checkNotNullParameter(parent, "");
            int BuiltInFictitiousFunctionClassFactory = securitySettingsAdapter.BuiltInFictitiousFunctionClassFactory(parent);
            if (BuiltInFictitiousFunctionClassFactory != -1) {
                securitySettingsAdapter.notifyItemChanged(BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    private static String PlaceComponentResult(Intent p0) {
        Bundle extras;
        String string = (p0 == null || (extras = p0.getExtras()) == null) ? null : extras.getString(ChallengeControl.Key.CANCEL_REASON);
        return string == null ? "" : string;
    }

    private final NewProfileMenuFaceAuthViewHolder BuiltInFictitiousFunctionClassFactory() {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.findViewHolderForLayoutPosition(PlaceComponentResult(MyProfileMenuAction.SETTING_FACE_VERIFICATION));
        if (findViewHolderForLayoutPosition instanceof NewProfileMenuFaceAuthViewHolder) {
            return (NewProfileMenuFaceAuthViewHolder) findViewHolderForLayoutPosition;
        }
        return null;
    }

    private final int PlaceComponentResult(String p0) {
        SettingModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0);
        String parent = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.getParent() : null;
        if (parent == null) {
            parent = "";
        }
        return new SecuritySettingsAdapter().BuiltInFictitiousFunctionClassFactory(parent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SettingModel KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        SettingModel settingModel;
        Iterator<SettingModel> it = this.NetworkUserEntityData$$ExternalSyntheticLambda8.getItems().iterator();
        do {
            settingModel = null;
            if (!it.hasNext()) {
                break;
            }
            List<SettingModel> settingChilds = it.next().getSettingChilds();
            Intrinsics.checkNotNullExpressionValue(settingChilds, "");
            Iterator<T> it2 = settingChilds.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((SettingModel) next).getName(), p0)) {
                    settingModel = next;
                    break;
                }
            }
            settingModel = settingModel;
        } while (settingModel == null);
        return settingModel;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        SettingModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.setSubtitle(p1);
            SecuritySettingsAdapter securitySettingsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String parent = KClassImpl$Data$declaredNonStaticMembers$2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "");
            Intrinsics.checkNotNullParameter(parent, "");
            int BuiltInFictitiousFunctionClassFactory = securitySettingsAdapter.BuiltInFictitiousFunctionClassFactory(parent);
            if (BuiltInFictitiousFunctionClassFactory != -1) {
                securitySettingsAdapter.notifyItemChanged(BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    public final void PlaceComponentResult(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult2 = EventTrackerModel.Builder.PlaceComponentResult(this);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        p0.invoke(PlaceComponentResult2);
        PlaceComponentResult2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult2, (byte) 0));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0014\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsActivity$Listener;", "", "onCancelled", "", ZdocRecordService.REASON, "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "onSuccess", "data", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        /* renamed from: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$Listener$-CC */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }
    }

    /* renamed from: $r8$lambda$JoS17a6A-znhUH_PFu5aWyb3YPw */
    public static /* synthetic */ void m2695$r8$lambda$JoS17a6AznhUH_PFu5aWyb3YPw(SecuritySettingsActivity securitySettingsActivity, boolean z) {
        Intrinsics.checkNotNullParameter(securitySettingsActivity, "");
        securitySettingsActivity.getSecuritySettingsPresenter().MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$YORYH2Aq8WDMTnCNREF5CRqgEu4(SecuritySettingsActivity securitySettingsActivity) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(securitySettingsActivity, "");
        if (securitySettingsActivity.BuiltInFictitiousFunctionClassFactory() == null || (bool = securitySettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda0) == null || securitySettingsActivity.lookAheadTest == null || securitySettingsActivity.moveToNextValue == null) {
            return;
        }
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = securitySettingsActivity.lookAheadTest;
        boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Boolean bool3 = securitySettingsActivity.moveToNextValue;
        securitySettingsActivity.setFaceLoginState(booleanValue, booleanValue2, bool3 != null ? bool3.booleanValue() : false);
    }

    public static /* synthetic */ void $r8$lambda$xDN57GyjKGxbFd2V53YGbIWRDLo(SecuritySettingsActivity securitySettingsActivity) {
        Intrinsics.checkNotNullParameter(securitySettingsActivity, "");
        NewProfileMenuFaceAuthViewHolder BuiltInFictitiousFunctionClassFactory = securitySettingsActivity.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory != null) {
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setFaceAuthSwitchOn();
        }
    }

    public static final /* synthetic */ CreatePinLauncher access$getCreatePinLauncher(SecuritySettingsActivity securitySettingsActivity) {
        return (CreatePinLauncher) securitySettingsActivity.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ EnrollPasskeyLauncher access$getEnrollPasskeyLauncher(SecuritySettingsActivity securitySettingsActivity) {
        return (EnrollPasskeyLauncher) securitySettingsActivity.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ UiComponent access$getUiComponentChangePIN(SecuritySettingsActivity securitySettingsActivity) {
        return (UiComponent) securitySettingsActivity.isLayoutRequested.getValue();
    }

    public static final /* synthetic */ UnlinkPasskeyLauncher access$getUnlinkPasskeyLauncher(SecuritySettingsActivity securitySettingsActivity) {
        return (UnlinkPasskeyLauncher) securitySettingsActivity.newProxyInstance.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0035 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.util.List access$mapWithPasskeysSetting(id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity r4, java.util.List r5) {
        /*
            if (r5 == 0) goto L7b
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r5 = r5.iterator()
        Lf:
            boolean r1 = r5.hasNext()
            java.lang.String r2 = "setting_passkey_enrollment"
            if (r1 == 0) goto L39
            java.lang.Object r1 = r5.next()
            r3 = r1
            id.dana.domain.profilemenu.model.SettingModel r3 = (id.dana.domain.profilemenu.model.SettingModel) r3
            java.lang.String r3 = r3.getAction()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
            if (r2 == 0) goto L32
            id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher$Companion r2 = id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher.INSTANCE
            boolean r2 = id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyLauncher.Companion.PlaceComponentResult()
            if (r2 != 0) goto L32
            r2 = 1
            goto L33
        L32:
            r2 = 0
        L33:
            if (r2 != 0) goto Lf
            r0.add(r1)
            goto Lf
        L39:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r5 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r1)
            r5.<init>(r1)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r0 = r0.iterator()
        L4e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L78
            java.lang.Object r1 = r0.next()
            id.dana.domain.profilemenu.model.SettingModel r1 = (id.dana.domain.profilemenu.model.SettingModel) r1
            java.lang.String r3 = r1.getAction()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
            if (r3 == 0) goto L74
            java.util.concurrent.atomic.AtomicBoolean r3 = r4.getErrorConfigVersion
            boolean r3 = r3.get()
            if (r3 == 0) goto L6f
            java.lang.String r3 = "ENROLLED"
            goto L71
        L6f:
            java.lang.String r3 = "NOT_ENROLLED"
        L71:
            r1.setEnrolmentState(r3)
        L74:
            r5.add(r1)
            goto L4e
        L78:
            java.util.List r5 = (java.util.List) r5
            goto L7c
        L7b:
            r5 = 0
        L7c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.access$mapWithPasskeysSetting(id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity, java.util.List):java.util.List");
    }

    public static final /* synthetic */ void access$routeSecuritySettingScreenByItem(SecuritySettingsActivity securitySettingsActivity, SettingModel settingModel) {
        String name = settingModel.getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        securitySettingsActivity.KClassImpl$Data$declaredNonStaticMembers$2 = name;
        if (Intrinsics.areEqual(settingModel.getName(), ProfileUserServiceType.CHANGE_PIN)) {
            securitySettingsActivity.getSecuritySettingsPresenter().BuiltInFictitiousFunctionClassFactory();
            securitySettingsActivity.PlaceComponentResult = settingModel.getRedirectUrl();
            return;
        }
        String action = settingModel.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1808490108:
                    if (action.equals(MyProfileMenuAction.SETTING_PASSKEY_ENROLLMENT)) {
                        securitySettingsActivity.getSecuritySettingsPresenter().getAuthRequestContext(settingModel);
                        return;
                    }
                    break;
                case -1295229910:
                    if (action.equals(MyProfileMenuAction.SETTING_LOCATION_PERMISSION)) {
                        return;
                    }
                    break;
                case -719054499:
                    if (action.equals(MyProfileMenuAction.SETTING_SECURITY_QUESTIONS)) {
                        securitySettingsActivity.initRecordTimeStamp = true;
                        ProductPageManagerExtKt.BuiltInFictitiousFunctionClassFactory(securitySettingsActivity.getProductPageManager(), securitySettingsActivity);
                        return;
                    }
                    break;
                case 1741450382:
                    if (action.equals(MyProfileMenuAction.SETTING_FACE_VERIFICATION)) {
                        return;
                    }
                    break;
            }
        }
        String redirectUrl = settingModel.getRedirectUrl();
        if (redirectUrl != null) {
            String authRequestContext = UrlUtil.getAuthRequestContext(redirectUrl);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            DanaH5.startContainerFullUrl(authRequestContext, new SecuritySettingsActivity$openH5Container$$inlined$withDanaH5Callback$1(securitySettingsActivity));
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        DaggerSecuritySettingsComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerSecuritySettingsComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (MePageRevampModule) Preconditions.getAuthRequestContext(new MePageRevampModule(new MePageRevampContract.View() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$getMePageRevampModule$1
            @Override // id.dana.myprofile.mepagerevamp.MePageRevampContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.myprofile.mepagerevamp.MePageRevampContract.View
            public final void getAuthRequestContext(final List<? extends SettingModel> p0) {
                EnrollPasskeyLauncher access$getEnrollPasskeyLauncher = SecuritySettingsActivity.access$getEnrollPasskeyLauncher(SecuritySettingsActivity.this);
                final SecuritySettingsActivity securitySettingsActivity = SecuritySettingsActivity.this;
                EnrollPasskeyLauncher.KClassImpl$Data$declaredNonStaticMembers$2(access$getEnrollPasskeyLauncher, false, false, null, new Function1<Boolean, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$getMePageRevampModule$1$onGetSettingCollectionSuccess$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        ArrayList arrayList;
                        SecuritySettingsAdapter securitySettingsAdapter;
                        String str;
                        boolean z2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("isPasskeyEnrollmentEnabled: ");
                        sb.append(z);
                        DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
                        if (z) {
                            arrayList = SecuritySettingsActivity.access$mapWithPasskeysSetting(SecuritySettingsActivity.this, p0);
                        } else {
                            List<SettingModel> list = p0;
                            if (list != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (Object obj : list) {
                                    if (!Intrinsics.areEqual(((SettingModel) obj).getAction(), MyProfileMenuAction.SETTING_PASSKEY_ENROLLMENT)) {
                                        arrayList2.add(obj);
                                    }
                                }
                                arrayList = arrayList2;
                            } else {
                                arrayList = null;
                            }
                        }
                        if (arrayList != null) {
                            arrayList = SettingModelMapper.PlaceComponentResult(arrayList, true);
                        }
                        securitySettingsAdapter = SecuritySettingsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        securitySettingsAdapter.setItems(arrayList);
                        SecuritySettingsActivity securitySettingsActivity2 = SecuritySettingsActivity.this;
                        str = securitySettingsActivity2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        z2 = SecuritySettingsActivity.this.GetContactSyncConfig;
                        securitySettingsActivity2.onUserKycInfo(str, z2);
                        SecuritySettingsActivity.this.getSecuritySettingsPresenter().PlaceComponentResult();
                    }
                }, 4);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                SecuritySettingsActivity securitySettingsActivity = SecuritySettingsActivity.this;
                Toast.makeText(securitySettingsActivity, ErrorUtil.BuiltInFictitiousFunctionClassFactory(securitySettingsActivity), 0).show();
            }
        }));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (SecuritySettingsModule) Preconditions.getAuthRequestContext(new SecuritySettingsModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, SecuritySettingsModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, MePageRevampModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerSecuritySettingsComponent.SecuritySettingsComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getMePageRevampPresenter(), getSecuritySettingsPresenter());
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.setOnItemClickListener(new GroupedSettingItemClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$initSettingsAdapter$1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int p0) {
                SecuritySettingsAdapter securitySettingsAdapter;
                securitySettingsAdapter = SecuritySettingsActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                SettingModel item = securitySettingsAdapter.getItem(p0);
                if (item != null) {
                    SecuritySettingsActivity.access$routeSecuritySettingScreenByItem(SecuritySettingsActivity.this, item);
                }
            }

            @Override // id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener
            public final void getAuthRequestContext(SettingModel p0) {
                if (p0 != null) {
                    SecuritySettingsActivity.access$routeSecuritySettingScreenByItem(SecuritySettingsActivity.this, p0);
                }
            }
        });
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        recyclerView.setNestedScrollingEnabled(false);
        ProfileDividerItemDecoration profileDividerItemDecoration = new ProfileDividerItemDecoration(recyclerView.getContext());
        Drawable PlaceComponentResult2 = ContextCompat.PlaceComponentResult(recyclerView.getContext(), (int) R.drawable.divider_drawable);
        if (PlaceComponentResult2 != null) {
            if (PlaceComponentResult2 == null) {
                throw new IllegalArgumentException("Drawable cannot be null.");
            }
            profileDividerItemDecoration.MyBillsEntityDataFactory = PlaceComponentResult2;
            recyclerView.addItemDecoration(profileDividerItemDecoration);
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    SecuritySettingsActivity.$r8$lambda$YORYH2Aq8WDMTnCNREF5CRqgEu4(SecuritySettingsActivity.this);
                }
            });
        }
        if (getIntent().getBooleanExtra(MyProfileBundleKey.SWITCH_FACE_AUTH_ON, false)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SecuritySettingsActivity.$r8$lambda$xDN57GyjKGxbFd2V53YGbIWRDLo(SecuritySettingsActivity.this);
                }
            }, 1000L);
        }
        DanaApplication danaApplication = getDanaApplication();
        if (danaApplication != null) {
            danaApplication.chckTmprdApp();
        }
    }

    @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract.View
    public final void setFaceLoginState(boolean isFaceLoginEnabled, boolean hasEnrolled, boolean isFaceLoginReady) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Boolean.valueOf(isFaceLoginEnabled);
        this.lookAheadTest = Boolean.valueOf(hasEnrolled);
        this.moveToNextValue = Boolean.valueOf(isFaceLoginReady);
        SettingModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.SETTING_FACE_VERIFICATION);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.setEnrolmentState((hasEnrolled && isFaceLoginEnabled) ? NewSwitchFaceAuthenticationView.ENROLLED : (!hasEnrolled || isFaceLoginEnabled) ? NewSwitchFaceAuthenticationView.NOT_ENROLLED : NewSwitchFaceAuthenticationView.DISABLED);
            KClassImpl$Data$declaredNonStaticMembers$2.setFaceLoginEnabled(isFaceLoginEnabled);
            SecuritySettingsAdapter securitySettingsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String parent = KClassImpl$Data$declaredNonStaticMembers$2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "");
            Intrinsics.checkNotNullParameter(parent, "");
            int BuiltInFictitiousFunctionClassFactory = securitySettingsAdapter.BuiltInFictitiousFunctionClassFactory(parent);
            if (BuiltInFictitiousFunctionClassFactory != -1) {
                securitySettingsAdapter.notifyItemChanged(BuiltInFictitiousFunctionClassFactory);
            }
        }
        ViewGroup viewGroup = this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2;
        NewProfileMenuFaceAuthViewHolder newProfileMenuFaceAuthViewHolder = viewGroup != null ? new NewProfileMenuFaceAuthViewHolder(viewGroup) : null;
        if (newProfileMenuFaceAuthViewHolder != null) {
            newProfileMenuFaceAuthViewHolder.MyBillsEntityDataFactory.setFaceLoginEnabled(isFaceLoginEnabled);
            NewProfileMenuFaceAuthViewHolder.CheckedListener checkedListener = new NewProfileMenuFaceAuthViewHolder.CheckedListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity$$ExternalSyntheticLambda2
                @Override // id.dana.myprofile.mepagerevamp.securitysettings.viewholder.NewProfileMenuFaceAuthViewHolder.CheckedListener
                public final void MyBillsEntityDataFactory(boolean z) {
                    SecuritySettingsActivity.m2695$r8$lambda$JoS17a6AznhUH_PFu5aWyb3YPw(SecuritySettingsActivity.this, true);
                }
            };
            Intrinsics.checkNotNullParameter(checkedListener, "");
            newProfileMenuFaceAuthViewHolder.KClassImpl$Data$declaredNonStaticMembers$2 = checkedListener;
        }
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (B ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = D;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (D[i3 + ((int) (VerifyPinStateManager$executeRiskChallenge$2$1 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (B ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (getOnBoardingScenario[i3 + ((int) (VerifyPinStateManager$executeRiskChallenge$2$1 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (B ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (VerifyPinStateManager$executeRiskChallenge$2$1 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (A ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = D;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = D;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = getOnBoardingScenario;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
