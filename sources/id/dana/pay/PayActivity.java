package id.dana.pay;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.view.ComponentActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.base.ViewPagerBaseFragment;
import id.dana.cashier.CashierAddOnModule;
import id.dana.cashier.CashierAddOnViewListener;
import id.dana.cashier.CashierCardBindingModule;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierEventListener;
import id.dana.cashier.CashierExitConfirmationDialog;
import id.dana.cashier.CashierHighlightModule;
import id.dana.cashier.CashierHighlightViewListener;
import id.dana.cashier.CashierPayLaterModule;
import id.dana.cashier.CashierPayLaterViewListener;
import id.dana.cashier.CashierRisk3dsActivity;
import id.dana.cashier.CashierUserRelatedModule;
import id.dana.cashier.CashierUserRelatedViewListener;
import id.dana.cashier.CashierViewListener;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.fragment.CashierGeneralProcessingFragment;
import id.dana.cashier.fragment.InputAmountFragment;
import id.dana.cashier.fragment.PayConfirmationFragment;
import id.dana.cashier.fragment.PaymentResultFragment;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierInitParamHelper;
import id.dana.cashier.helper.CashierListRiskMethod;
import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierMerchantModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayChannelModelKt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.OneKlikPhonesModel;
import id.dana.cashier.model.PayMethodInitModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.RiskVerificationMethodModel;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.cashier.model.constants.PaymentResultBackToHomeStatus;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.utils.CashierTimerType;
import id.dana.cashier.view.ExpandablePaymentMethod;
import id.dana.challenge.ChallengeControl;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.data.constant.UrlParam;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCashierComponent;
import id.dana.di.modules.CashierAnalyticModule;
import id.dana.di.modules.CashierModule;
import id.dana.di.modules.CashierRiskChallengeModule;
import id.dana.di.modules.TopUpAndPayModule;
import id.dana.familyaccount.view.summary.OrganizerSummaryActivity;
import id.dana.lib.gcontainer.GContainer;
import id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.pay.PayActivity$countDownTimer$2;
import id.dana.pay.model.PayActivityListenerModel;
import id.dana.pay.model.PayResultEmoneyBannerListenerModel;
import id.dana.promoquest.handler.nativepage.NativePageType;
import id.dana.richview.CustomDecoratedBarcodeView;
import id.dana.richview.DanaProtectionView;
import id.dana.scanner.CameraReadyTimeHelper;
import id.dana.scanner.tracker.PayQrOpenTracker;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.OnSwipeListener;
import id.dana.utils.PhoneCall;
import id.dana.utils.danah5.DanaH5Listener;
import io.reactivex.subjects.BehaviorSubject;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u009c\u00022\u00020\u00012\u00020\u0002:\u0006\u009d\u0002\u009e\u0002\u009c\u0002B\b¢\u0006\u0005\b\u009b\u0002\u0010\u000eJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u000eJ\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u000eJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u000eJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J;\u0010.\u001a\u00020\b2\u0006\u0010'\u001a\u00020$2\u0006\u0010)\u001a\u00020(2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010\u000eJ!\u00104\u001a\u00020\b2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\b01¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0005¢\u0006\u0004\b7\u0010\u0019J)\u0010<\u001a\u00020\b2\u0006\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!2\b\u0010;\u001a\u0004\u0018\u00010:H\u0014¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\bH\u0016¢\u0006\u0004\b>\u0010\u000eJ\u000f\u0010?\u001a\u00020\bH\u0002¢\u0006\u0004\b?\u0010\u000eJ\u0019\u0010A\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\bA\u0010\u0012J\u000f\u0010B\u001a\u00020\bH\u0014¢\u0006\u0004\bB\u0010\u000eJ\u001f\u0010E\u001a\u00020\b2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020\u000fH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\bH\u0014¢\u0006\u0004\bG\u0010\u000eJ\u000f\u0010H\u001a\u00020\bH\u0014¢\u0006\u0004\bH\u0010\u000eJ\u0017\u0010J\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u0005H\u0002¢\u0006\u0004\bJ\u0010\u0019JO\u0010R\u001a\u00020\b2\u0006\u0010K\u001a\u00020$2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010M\u001a\u00020\u00052\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SJO\u0010Z\u001a\u00020\b2\"\u0010V\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0Tj\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$`U2\b\u0010W\u001a\u0004\u0018\u00010$2\b\u0010X\u001a\u0004\u0018\u00010$2\b\u0010Y\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bZ\u0010[J\u001f\u0010_\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u001c2\b\u0010^\u001a\u0004\u0018\u00010]¢\u0006\u0004\b_\u0010`J\u0015\u0010c\u001a\u00020\b2\u0006\u0010b\u001a\u00020a¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020\b2\b\b\u0001\u00109\u001a\u00020$¢\u0006\u0004\be\u0010fJ\r\u0010g\u001a\u00020\b¢\u0006\u0004\bg\u0010\u000eJ\u0015\u0010i\u001a\u00020\b2\u0006\u0010h\u001a\u00020$¢\u0006\u0004\bi\u0010fJ\u001f\u0010m\u001a\u00020\b2\u0006\u0010k\u001a\u00020j2\b\b\u0002\u0010l\u001a\u00020$¢\u0006\u0004\bm\u0010nJQ\u0010r\u001a\u00020\b2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010P2\b\b\u0002\u0010p\u001a\u00020\u00052\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010M\u001a\u00020\u00052\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\br\u0010sJ!\u0010v\u001a\u00020\b2\u0006\u0010t\u001a\u00020$2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010$¢\u0006\u0004\bv\u0010wJ\r\u0010x\u001a\u00020\b¢\u0006\u0004\bx\u0010\u000eR%\u0010\u0080\u0001\u001a\u0004\u0018\u00010y8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR*\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0016\u0010?\u001a\u00030\u0088\u0001X\u0083\u0080\u0002¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R1\u0010\u0093\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u00018\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R1\u0010\u009c\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010\u008b\u00018\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u008e\u0001\u001a\u0006\b\u009a\u0001\u0010\u0090\u0001\"\u0006\b\u009b\u0001\u0010\u0092\u0001R1\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010\u009d\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010\r\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R,\u0010®\u0001\u001a\u0005\u0018\u00010§\u00018\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001RA\u0010³\u0001\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\b012\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\b018\u0007@BX\u0087\u000e¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R\u0017\u0010¶\u0001\u001a\u00030´\u0001X\u0083\u0080\u0002¢\u0006\b\n\u0006\bµ\u0001\u0010\u008a\u0001R\u001b\u0010J\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R,\u0010Á\u0001\u001a\u0005\u0018\u00010º\u00018\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R\u0019\u0010Ä\u0001\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R(\u0010Æ\u0001\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bÅ\u0001\u0010Ã\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0005\bÈ\u0001\u0010\u0019R(\u0010Ê\u0001\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bÉ\u0001\u0010Ã\u0001\u001a\u0006\bÊ\u0001\u0010Ç\u0001\"\u0005\bË\u0001\u0010\u0019R\u0019\u0010Í\u0001\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Ã\u0001R \u0010Ï\u0001\u001a\u00020\u00058GX\u0087\u0084\u0002¢\u0006\u0010\n\u0006\bÎ\u0001\u0010\u008a\u0001\u001a\u0006\bÏ\u0001\u0010Ç\u0001R(\u0010Ñ\u0001\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bÐ\u0001\u0010Ã\u0001\u001a\u0006\bÑ\u0001\u0010Ç\u0001\"\u0005\bÒ\u0001\u0010\u0019R(\u0010Ô\u0001\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bÓ\u0001\u0010Ã\u0001\u001a\u0006\bÔ\u0001\u0010Ç\u0001\"\u0005\bÕ\u0001\u0010\u0019R(\u0010×\u0001\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bÖ\u0001\u0010Ã\u0001\u001a\u0006\b×\u0001\u0010Ç\u0001\"\u0005\bØ\u0001\u0010\u0019R(\u0010Ú\u0001\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bÙ\u0001\u0010Ã\u0001\u001a\u0006\bÚ\u0001\u0010Ç\u0001\"\u0005\bÛ\u0001\u0010\u0019R\u0019\u0010Ý\u0001\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ã\u0001R(\u0010ß\u0001\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bÞ\u0001\u0010Ã\u0001\u001a\u0006\bß\u0001\u0010Ç\u0001\"\u0005\bà\u0001\u0010\u0019R*\u0010è\u0001\u001a\u00030á\u00018\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\bâ\u0001\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001RE\u0010ï\u0001\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0Tj\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$`U8\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R(\u0010ó\u0001\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\bð\u0001\u0010Ã\u0001\u001a\u0006\bñ\u0001\u0010Ç\u0001\"\u0005\bò\u0001\u0010\u0019R\u0018\u0010z\u001a\u00020$8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R\u0019\u0010÷\u0001\u001a\u00020$8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bö\u0001\u0010õ\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001f\u0010ü\u0001\u001a\u00020$8GX\u0087\u0084\u0002¢\u0006\u000f\n\u0006\bú\u0001\u0010\u008a\u0001\u001a\u0005\bû\u0001\u0010&R\u0017\u0010\u0089\u0001\u001a\u00030ý\u0001X\u0083\u0080\u0002¢\u0006\b\n\u0006\bþ\u0001\u0010\u008a\u0001R*\u0010\u0080\u0002\u001a\u00030ÿ\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R \u0010\u008b\u0002\u001a\u00030\u0086\u00028\u0007X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R-\u00109\u001a\u00020$8\u0007@\u0007X\u0087\u000e¢\u0006\u001d\n\u0006\b\u008c\u0002\u0010õ\u0001\u0012\u0005\b\u008f\u0002\u0010\u000e\u001a\u0005\b\u008d\u0002\u0010&\"\u0005\b\u008e\u0002\u0010fR\u0019\u0010\u008d\u0001\u001a\u00020!8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002R \u0010\u0095\u0002\u001a\u0002028GX\u0087\u0084\u0002¢\u0006\u0010\n\u0006\b\u0092\u0002\u0010\u008a\u0001\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002R\u001f\u0010\u0098\u0002\u001a\u00020$8GX\u0087\u0084\u0002¢\u0006\u000f\n\u0006\b\u0096\u0002\u0010\u008a\u0001\u001a\u0005\b\u0097\u0002\u0010&R\u001f\u0010\u009a\u0002\u001a\u00020$8GX\u0087\u0084\u0002¢\u0006\u000f\n\u0006\b\u0091\u0002\u0010\u008a\u0001\u001a\u0005\b\u0099\u0002\u0010&"}, d2 = {"Lid/dana/pay/PayActivity;", "Lid/dana/base/BaseActivity;", "Landroidx/fragment/app/FragmentResultListener;", "Landroidx/fragment/app/Fragment;", "fragment", "", "isEnableToRemove", "isFromPayResultPage", "", "addAndRemoveStackedFragment", "(Landroidx/fragment/app/Fragment;ZZ)V", "addFragment", "(Landroidx/fragment/app/Fragment;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroid/os/Bundle;", HummerConstants.BUNDLE, "backToHomePage", "(Landroid/os/Bundle;)V", "Lid/dana/cashier/fragment/PaymentResultFragment$CashierResultBannerListener;", "createCashierResultBannerListener", "()Lid/dana/cashier/fragment/PaymentResultFragment$CashierResultBannerListener;", "disposePresenter", "isEnable", "enableDisableActivityTouchEvent", "(Z)V", "expandBottomSheet", "finishCountDownEarly", "Lid/dana/cashier/model/CashierCheckoutRequestModel;", "requestModel", SummaryActivity.FIRST_STATE_SHARE_FEED, "getCashierMain", "(Lid/dana/cashier/model/CashierCheckoutRequestModel;Z)V", "", "getLayout", "()I", "", "getOneKlikBizOrderId", "()Ljava/lang/String;", "riskType", "Lid/dana/cashier/RiskParamsFactory;", "riskParamsFactory", "", "Lid/dana/cashier/model/OneKlikPhonesModel;", "phoneNumberList", "cashierFragment", "handleCashierRiskPhase", "(Ljava/lang/String;Lid/dana/cashier/RiskParamsFactory;Ljava/util/List;Landroidx/fragment/app/Fragment;)V", IAPSyncCommand.COMMAND_INIT, "Lkotlin/Function1;", "", "action", "listenCountDown", "(Lkotlin/jvm/functions/Function1;)V", "needToBackHome", "needToBackHomeOnDestroy", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "KClassImpl$Data$declaredNonStaticMembers$2", "savedInstanceState", "onCreate", "onDestroy", "requestKey", "result", "onFragmentResult", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onPause", "onStart", "p0", "getAuthRequestContext", "url", "source", "isFromCpm", "Lid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;", CashierKeyParams.EXCHANGE_RATE, "Lid/dana/cashier/model/CashierMerchantModel;", "preloadMerchantModel", "processCashierUrl", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;ZLid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;Lid/dana/cashier/model/CashierMerchantModel;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nativelyDecodedQr", UrlParam.REQUEST_ID, "qrCode", "precreateOrder", "processNativelyDecodedQr", "(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "checkoutRequestModel", "Lid/dana/cashier/model/CashierPayMethodModel;", "selectedPayMethod", "retryPaymentFromResultPage", "(Lid/dana/cashier/model/CashierCheckoutRequestModel;Lid/dana/cashier/model/CashierPayMethodModel;)V", "Lid/dana/pay/PayActivity$CashierRiskListener;", "cashierRiskListener", "setCashierRiskListener", "(Lid/dana/pay/PayActivity$CashierRiskListener;)V", "setCurrentPaymentStatus", "(Ljava/lang/String;)V", "setHalfScreenBottomSheet", "oneKlikBankPhoneNumber", "setOneKlikPhoneNumer", "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "oneKlikTopUpVerifyRequestModel", "oneKlikBizOrderId", "setTopUpPayInputFragmentParameter", "(Lid/dana/cashier/model/TopUpVerifyRequestModel;Ljava/lang/String;)V", "merchantModel", "isPreloadMerchantModel", "kybOrderId", "showCashier", "(Lid/dana/cashier/model/CashierMerchantModel;ZLid/dana/cashier/model/CashierCheckoutRequestModel;Ljava/lang/String;ZLid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;)V", "tradeNo", "merchantId", "startCashierProcessing", "(Ljava/lang/String;Ljava/lang/String;)V", "startCountDown", "Lid/dana/cashier/model/AddOnTrackingModel;", "lookAheadTest", "Lid/dana/cashier/model/AddOnTrackingModel;", "getAddOnTrackingModel", "()Lid/dana/cashier/model/AddOnTrackingModel;", "setAddOnTrackingModel", "(Lid/dana/cashier/model/AddOnTrackingModel;)V", "addOnTrackingModel", "Lid/dana/richview/CustomDecoratedBarcodeView;", "barcodeView", "Lid/dana/richview/CustomDecoratedBarcodeView;", "getBarcodeView", "()Lid/dana/richview/CustomDecoratedBarcodeView;", "setBarcodeView", "(Lid/dana/richview/CustomDecoratedBarcodeView;)V", "Landroidx/transition/AutoTransition;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/cashier/model/CashierCheckoutModel;", "DatabaseTableConfigUtil", "Lio/reactivex/subjects/BehaviorSubject;", "getCashierCheckoutModel", "()Lio/reactivex/subjects/BehaviorSubject;", "setCashierCheckoutModel", "(Lio/reactivex/subjects/BehaviorSubject;)V", "cashierCheckoutModel", "Lid/dana/di/modules/CashierModule;", "GetContactSyncConfig", "Lid/dana/di/modules/CashierModule;", "PlaceComponentResult", "Lid/dana/cashier/model/PayMethodInitModel;", "initRecordTimeStamp", "getCashierPayMethod", "setCashierPayMethod", CashierKeyParams.CASHIER_PAY_METHOD, "Ldagger/Lazy;", "Lid/dana/cashier/CashierContract$Presenter;", "cashierPresenter", "Ldagger/Lazy;", "getCashierPresenter", "()Ldagger/Lazy;", "setCashierPresenter", "(Ldagger/Lazy;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/pay/PayActivity$CashierRiskListener;", "Lid/dana/pay/PayActivity$CashierSmartPayListener;", "PrepareContext", "Lid/dana/pay/PayActivity$CashierSmartPayListener;", "getCashierSmartPayListener", "()Lid/dana/pay/PayActivity$CashierSmartPayListener;", "setCashierSmartPayListener", "(Lid/dana/pay/PayActivity$CashierSmartPayListener;)V", "cashierSmartPayListener", "newProxyInstance", "Lkotlin/jvm/functions/Function1;", "getCountDownListener", "()Lkotlin/jvm/functions/Function1;", "countDownListener", "Landroid/os/CountDownTimer;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "MyBillsEntityDataFactory", "Lid/dana/pay/model/PayResultEmoneyBannerListenerModel;", "isLayoutRequested", "Lid/dana/pay/model/PayResultEmoneyBannerListenerModel;", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "getFeatureTimeModel", "()Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "setFeatureTimeModel", "(Lid/dana/cashier/model/featureTime/FeatureTimeModel;)V", "featureTimeModel", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda5", "isCustomKeyboardEnable", "()Z", "setCustomKeyboardEnable", "FragmentBottomSheetPaymentSettingBinding", "isDismissAllowed", "setDismissAllowed", "NetworkUserEntityData$$ExternalSyntheticLambda6", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda3", "isFromDanaKagetRevamp", "SubSequence", "isInPaymentResult", "setInPaymentResult", "getSupportButtonTintMode", "isNeedBackConfirmation", "setNeedBackConfirmation", "getCallingPid", "isNeedExpandPayMethodOnBack", "setNeedExpandPayMethodOnBack", "whenAvailable", "isQrisCrossBorder", "setQrisCrossBorder", "readMicros", "getErrorConfigVersion", "C", "isReturnHome", "setReturnHome", "Lid/dana/cashier/helper/CashierListRiskMethod;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/cashier/helper/CashierListRiskMethod;", "getListRiskMethod", "()Lid/dana/cashier/helper/CashierListRiskMethod;", "setListRiskMethod", "(Lid/dana/cashier/helper/CashierListRiskMethod;)V", "listRiskMethod", "A", "Ljava/util/HashMap;", "getNativelyDecodedQrResult", "()Ljava/util/HashMap;", "setNativelyDecodedQrResult", "(Ljava/util/HashMap;)V", "nativelyDecodedQrResult", DiskFormatter.B, "getNeedBackHomeOnDestroy", "setNeedBackHomeOnDestroy", "needBackHomeOnDestroy", "BottomSheetCardBindingView$watcherCardNumberView$1", "Ljava/lang/String;", "getOnBoardingScenario", "moveToNextValue", SummaryActivity.DAYS, "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "E", "getOrderTitleFromSummary", "orderTitleFromSummary", "Lid/dana/pay/PayFragment;", "getValueOfTouchPositionAbsolute", "Lid/dana/pay/PayScannerFragment;", "payScannerFragment", "Lid/dana/pay/PayScannerFragment;", "getPayScannerFragment", "()Lid/dana/pay/PayScannerFragment;", "setPayScannerFragment", "(Lid/dana/pay/PayScannerFragment;)V", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "VerifyPinStateManager$executeRiskChallenge$2$2", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "getPhonePermission", "()Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "phonePermission", DiskFormatter.GB, "getResultCode", "setResultCode", "getResultCode$annotations", "AppCompatEmojiTextHelper", "I", SummaryActivity.HOURS, "getTimerDuration", "()J", "timerDuration", LogConstants.RESULT_FALSE, "getTimerType", "timerType", "getTransferType", CashierKeyParams.TRANSFER_TYPE, "<init>", "Companion", "CashierRiskListener", "CashierSmartPayListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PayActivity extends BaseActivity implements FragmentResultListener {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int[] M = null;
    public static final String MP_POSITION = "mp_position";
    private static DanaH5Listener NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    public static final String PAYMENT_RESULT = "PAYMENT RESULT";
    public static final int SMART_PAY_BOTTOM_SHEET_REQUEST_CODE = 3001;
    private static CashierEventListener getErrorConfigVersion;
    private static boolean scheduleImpl;

    /* renamed from: A  reason: from kotlin metadata */
    private HashMap<String, String> nativelyDecodedQrResult;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    private int DatabaseTableConfigUtil;

    /* renamed from: B */
    private boolean needBackHomeOnDestroy;

    /* renamed from: D */
    private TopUpVerifyRequestModel GetContactSyncConfig;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private BehaviorSubject<CashierCheckoutModel> cashierCheckoutModel;

    /* renamed from: F */
    private final Lazy timerType;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final CashierModule PlaceComponentResult;

    /* renamed from: H */
    private final Lazy timerDuration;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private CashierRiskListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy isFromDanaKagetRevamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private boolean isCustomKeyboardEnable;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private FeatureTimeModel featureTimeModel;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private CashierSmartPayListener cashierSmartPayListener;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private boolean isInPaymentResult;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private CashierListRiskMethod listRiskMethod;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private final ActivityPermissionRequest phonePermission;
    public CustomDecoratedBarcodeView barcodeView;
    @Inject
    public dagger.Lazy<CashierContract.Presenter> cashierPresenter;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean isNeedExpandPayMethodOnBack;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean isNeedBackConfirmation;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private BehaviorSubject<PayMethodInitModel> id.dana.cashier.utils.CashierKeyParams.CASHIER_PAY_METHOD java.lang.String;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private PayResultEmoneyBannerListenerModel getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private AddOnTrackingModel addOnTrackingModel;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private Function1<? super Long, Unit> countDownListener;
    public PayScannerFragment payScannerFragment;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private boolean isQrisCrossBorder;
    public static final byte[] $$a = {63, Ascii.SUB, 111, -17, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 253;
    public static final byte[] getAuthRequestContext = {62, -79, -77, -78, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 22;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean isDismissAllowed = true;

    /* renamed from: C  reason: from kotlin metadata */
    private boolean isReturnHome = true;

    /* renamed from: G */
    private String resultCode = PaymentResultBackToHomeStatus.CANCELLED;

    /* renamed from: I  reason: from kotlin metadata */
    private final Lazy id.dana.cashier.utils.CashierKeyParams.TRANSFER_TYPE java.lang.String = LazyKt.lazy(new Function0<String>() { // from class: id.dana.pay.PayActivity$transferType$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle bundleExtra = PayActivity.this.getIntent().getBundleExtra("data");
            String string = bundleExtra != null ? bundleExtra.getString(CashierKeyParams.TRANSFER_TYPE) : null;
            return string == null ? "" : string;
        }
    });

    /* renamed from: E  reason: from kotlin metadata */
    private final Lazy orderTitleFromSummary = LazyKt.lazy(new Function0<String>() { // from class: id.dana.pay.PayActivity$orderTitleFromSummary$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle bundleExtra = PayActivity.this.getIntent().getBundleExtra("data");
            String string = bundleExtra != null ? bundleExtra.getString(CashierKeyParams.GET_ORDER_TITLE) : null;
            return string == null ? "" : string;
        }
    });

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private String moveToNextValue = "";

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private String lookAheadTest = "";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/pay/PayActivity$CashierRiskListener;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface CashierRiskListener {
        void MyBillsEntityDataFactory(String p0);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/pay/PayActivity$CashierSmartPayListener;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface CashierSmartPayListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void getAuthRequestContext();
    }

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        M = new int[]{2114241654, -1079791848, 199854693, 1701971224, 1475512259, 338170609, 955411345, 1534001849, -1014133862, -1378224542, -1259515490, -502802974, 1475168577, 527068677, 557976387, 1868885189, -643151057, -1703109966};
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0023 -> B:47:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.pay.PayActivity.getAuthRequestContext
            int r8 = 106 - r8
            int r7 = r7 + 4
            int r9 = r9 + 16
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2d
        L13:
            r3 = 0
        L14:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            int r7 = r7 + 1
            r3 = r0[r7]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2d:
            int r8 = r8 + r9
            int r8 = r8 + (-4)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pay.PayActivity.b(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x002e -> B:47:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r0 = id.dana.pay.PayActivity.$$a
            int r7 = r7 + 4
            int r9 = r9 * 2
            int r9 = r9 + 75
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            r8 = r7
            goto L36
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L1d:
            int r4 = r3 + 1
            int r8 = r8 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pay.PayActivity.c(byte, byte, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3, String str4, Boolean bool, boolean z3, PayActivityListenerModel payActivityListenerModel, @CashierTimerType String str5, long j, FeatureTimeModel featureTimeModel) {
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, str3, str4, bool, z3, payActivityListenerModel, str5, j, featureTimeModel);
    }

    @JvmStatic
    public static final Intent createPayActivityFromFamilyAccountApprovalIntent(Context context, String str, AttributeCashierPayModel attributeCashierPayModel) {
        return Companion.MyBillsEntityDataFactory(context, str, attributeCashierPayModel);
    }

    @JvmStatic
    public static final Intent createPayActivityIntent(Context context, String str) {
        return Companion.getAuthRequestContext(context, str);
    }

    @JvmStatic
    public static final Intent createPayActivityforSendMoney(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, @CashierTimerType String str8, long j, FeatureTimeModel featureTimeModel) {
        return Companion.PlaceComponentResult(context, str, str2, str3, str4, str5, str6, str7, str8, j, featureTimeModel);
    }

    @PaymentResultBackToHomeStatus
    public static /* synthetic */ void getResultCode$annotations() {
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, new int[]{1384397432, 1929233769, -1449865899, 563921989, 571934413, 180809772, -917011587, -1663160426, -836904044, -681428578}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(6 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new int[]{-1430053055, -277631478, -1295306304, -834682981}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(View.MeasureSpec.makeMeasureSpec(0, 0) + 48, new int[]{-320385722, 1408045507, -310156257, 1834350668, -1448200398, -2109567372, -664072410, -1361412252, -254025865, -1904289983, -2113600577, -363570250, 937835341, 741253306, 877227987, -1244628052, 355449086, -1237615470, 758222218, 1829746237, -1514669751, 681380258, -1117666679, 712953403}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(KeyEvent.keyCodeFromString("") + 64, new int[]{805159877, -1325016080, 2005790485, 643197703, 1502295988, 555931409, 766146151, -789156770, -1959721661, 927034926, 2021181550, 1266311680, 1517999753, 1250645184, -1334235512, 749512370, -1873611332, 1262491698, 1576435621, -1906673110, 1242026966, -1079494665, -1333347477, 927790107, 388536518, 1986222963, -246846792, -734443925, -1605937743, 2091712486, -1100455890, 633412661}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(Color.alpha(0) + 64, new int[]{498862187, 882111968, -1973757960, 183229335, 1219592039, -1191809522, -974307538, -1320059981, 1783561056, -487754456, 281817461, -1765711027, -801950423, 523347910, 1363357774, -1389928077, 1483556703, -382002711, 33555351, -1195910142, 612173346, 333321729, 226853686, 1773542312, 432921956, -2142990206, 60667924, 98900650, 1120820429, 1624587073, -589859734, -1659013615}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - TextUtils.getOffsetBefore("", 0), new int[]{-332710936, 689928187, -1334219689, -1254839483, -457907000, 1168626195, -216269935, -376415913, 896251783, 406131282, -904042546, 1378403018, 462565694, 883718943, -1961802542, 560452152, -838791088, 1602239359, -1506465721, -222563068, 1205397, 2043636504, -1783239417, -412878467, 1239390228, 1202631517, 1054974897, -378589274, -603916995, -1777533058}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(5 - TextUtils.indexOf((CharSequence) "", '0'), new int[]{-1835517791, -401825619, 162843848, 1457404375}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                b((short) 36, b, b, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (PlaceComponentResult - 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), '3' - AndroidCharacter.getMirror('0'), (char) Color.alpha(0));
                        byte b2 = $$a[47];
                        byte b3 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b2, b3, b3, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 800, 15 - Color.alpha(0), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - KeyEvent.keyCodeFromString(""), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - KeyEvent.normalizeMetaState(0), 30 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (View.resolveSize(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 800, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 15, (char) Gravity.getAbsoluteGravity(0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, Drawable.resolveOpacity(0, 0) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {823537413, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = {this};
                byte b4 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                b((short) 36, b4, b4, objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                b((byte) (PlaceComponentResult - 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getJumpTapTimeout() >> 16), '^' - AndroidCharacter.getMirror('0'), (char) (ImageFormat.getBitsPerPixel(0) + 1));
                        Object[] objArr23 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {823537413, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr26 = {this};
                byte b5 = getAuthRequestContext[25];
                Object[] objArr27 = new Object[1];
                b((short) 36, b5, b5, objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                b((byte) (PlaceComponentResult - 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 118, (ViewConfiguration.getWindowTouchSlop() >> 8) + 3, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 38968));
                        Object[] objArr30 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, Drawable.resolveOpacity(0, 0) + 35, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {823537413, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr33 = {this};
                byte b6 = getAuthRequestContext[25];
                Object[] objArr34 = new Object[1];
                b((short) 36, b6, b6, objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                b((byte) (PlaceComponentResult - 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 3 - (Process.myTid() >> 22), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
                        Object[] objArr37 = new Object[1];
                        c((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {823537413, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, 18 - View.resolveSize(0, 0), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_pay;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().length() + 19, new int[]{1384397432, 1929233769, -1449865899, 563921989, 1111947423, 146902217, -1572588377, -223441367, 2127774351, -59463624, -199630093, 1081996740, -914734400, 737516493}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(getAuthRequestContext[9], getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[59], getAuthRequestContext[13], getAuthRequestContext[56], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{605943996, 1261236936, 431376495, -1014160714, -1559058947, 885274408, 1456344373, 81864686, -283421763, 238489884}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        }
        super.onResume();
    }

    public PayActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.pay.PayActivity$phonePermission$1
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
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(PayActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.phonePermission = builder.PlaceComponentResult();
        this.listRiskMethod = new CashierListRiskMethod();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = LazyKt.lazy(new Function0<PayFragment>() { // from class: id.dana.pay.PayActivity$payFragment$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PayFragment invoke() {
                return new PayFragment();
            }
        });
        this.nativelyDecodedQrResult = new HashMap<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<AutoTransition>() { // from class: id.dana.pay.PayActivity$bottomsheetTransition$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AutoTransition invoke() {
                AutoTransition autoTransition = new AutoTransition();
                autoTransition.setDuration(100L);
                return autoTransition;
            }
        });
        BehaviorSubject<CashierCheckoutModel> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        this.cashierCheckoutModel = BuiltInFictitiousFunctionClassFactory;
        BehaviorSubject<PayMethodInitModel> BuiltInFictitiousFunctionClassFactory2 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        this.id.dana.cashier.utils.CashierKeyParams.CASHIER_PAY_METHOD java.lang.String = BuiltInFictitiousFunctionClassFactory2;
        this.PlaceComponentResult = new CashierModule(new CashierViewListener() { // from class: id.dana.pay.PayActivity$cashierModule$1
            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void MyBillsEntityDataFactory(CashierCheckoutModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PayActivity.this.getCashierCheckoutModel().onNext(p0);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void getAuthRequestContext(List<? extends CashierPayMethodModel> p0, boolean p1, boolean p2) {
                Boolean bool = null;
                Boolean bool2 = null;
                PayActivity.this.getCashierPayMethod().onNext(new PayMethodInitModel(p0, Boolean.valueOf(p1), Boolean.valueOf(p2), bool, bool2, Boolean.valueOf(PayActivity.this.getCashierPresenter().get().getNetworkUserEntityData$$ExternalSyntheticLambda6()), Boolean.valueOf(PayActivity.this.getCashierPresenter().get().getNetworkUserEntityData$$ExternalSyntheticLambda5()), null, null, 408, null));
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void PlaceComponentResult(boolean p0) {
                PayActivity.this.getCashierPayMethod().onNext(new PayMethodInitModel(null, null, null, Boolean.valueOf(p0), null, null, null, null, null, 503, null));
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
                PayActivity.this.getCashierPayMethod().onNext(new PayMethodInitModel(null, null, null, null, Boolean.TRUE, null, null, null, null, 495, null));
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
            public final void DatabaseTableConfigUtil() {
                PayActivity.this.getCashierPayMethod().onNext(new PayMethodInitModel(null, null, null, null, null, null, null, Boolean.TRUE, null, 383, null));
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                PayActivity.this.getCashierPayMethod().onNext(new PayMethodInitModel(null, null, null, null, null, null, null, null, Boolean.TRUE, 255, null));
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                BehaviorSubject<PayMethodInitModel> cashierPayMethod = PayActivity.this.getCashierPayMethod();
                Boolean bool = Boolean.FALSE;
                cashierPayMethod.onNext(new PayMethodInitModel(null, null, null, null, null, null, null, bool, bool, 127, null));
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
            public final void MyBillsEntityDataFactory(String p0, String p1, Throwable p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(PayActivity.this, p0, p1, TrackerDataKey.Source.CASHIER_NATIVE, p2);
            }

            @Override // id.dana.cashier.CashierViewListener, id.dana.cashier.CashierContract.View
            public final void PlaceComponentResult(CashierErrorState p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PayActivity.this.getCashierCheckoutModel().onError(new Throwable(p0.getAuthRequestContext.asString(PayActivity.this)));
            }
        });
        this.timerType = LazyKt.lazy(new Function0<String>() { // from class: id.dana.pay.PayActivity$timerType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle extras;
                Bundle bundle;
                String string;
                Intent intent = PayActivity.this.getIntent();
                return (intent == null || (extras = intent.getExtras()) == null || (bundle = extras.getBundle("data")) == null || (string = bundle.getString("timer_type")) == null) ? "" : string;
            }
        });
        this.isFromDanaKagetRevamp = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.pay.PayActivity$isFromDanaKagetRevamp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(Intrinsics.areEqual(PayActivity.this.getTimerType(), CashierTimerType.DANA_KAGET_SHARE_PAGE_TIMER));
            }
        });
        this.timerDuration = LazyKt.lazy(new Function0<Long>() { // from class: id.dana.pay.PayActivity$timerDuration$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Bundle extras;
                Bundle bundle;
                Intent intent = PayActivity.this.getIntent();
                long j = 0;
                if (intent != null && (extras = intent.getExtras()) != null && (bundle = extras.getBundle("data")) != null) {
                    j = bundle.getLong("timer_duration", 0L);
                }
                return Long.valueOf(j);
            }
        });
        this.countDownListener = new Function1<Long, Unit>() { // from class: id.dana.pay.PayActivity$countDownListener$1
            public final void invoke(long j) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }
        };
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<PayActivity$countDownTimer$2.AnonymousClass1>() { // from class: id.dana.pay.PayActivity$countDownTimer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [id.dana.pay.PayActivity$countDownTimer$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                long timerDuration = PayActivity.this.getTimerDuration();
                final PayActivity payActivity = PayActivity.this;
                return new CountDownTimer(timerDuration) { // from class: id.dana.pay.PayActivity$countDownTimer$2.1
                    @Override // android.os.CountDownTimer
                    public final void onTick(long p0) {
                        PayActivity.this.getCountDownListener().invoke(Long.valueOf(TimeUnit.SECONDS.convert(p0, TimeUnit.MILLISECONDS)));
                    }

                    @Override // android.os.CountDownTimer
                    public final void onFinish() {
                        PayActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                        PayActivity.this.getAuthRequestContext(true);
                    }
                };
            }
        });
    }

    @JvmName(name = "getCashierPresenter")
    public final dagger.Lazy<CashierContract.Presenter> getCashierPresenter() {
        dagger.Lazy<CashierContract.Presenter> lazy = this.cashierPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCashierPresenter")
    public final void setCashierPresenter(dagger.Lazy<CashierContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.cashierPresenter = lazy;
    }

    @JvmName(name = "getCashierSmartPayListener")
    public final CashierSmartPayListener getCashierSmartPayListener() {
        return this.cashierSmartPayListener;
    }

    @JvmName(name = "setCashierSmartPayListener")
    public final void setCashierSmartPayListener(CashierSmartPayListener cashierSmartPayListener) {
        this.cashierSmartPayListener = cashierSmartPayListener;
    }

    @JvmName(name = "isDismissAllowed")
    /* renamed from: isDismissAllowed  reason: from getter */
    public final boolean getIsDismissAllowed() {
        return this.isDismissAllowed;
    }

    @JvmName(name = "setDismissAllowed")
    public final void setDismissAllowed(boolean z) {
        this.isDismissAllowed = z;
    }

    @JvmName(name = "isCustomKeyboardEnable")
    /* renamed from: isCustomKeyboardEnable  reason: from getter */
    public final boolean getIsCustomKeyboardEnable() {
        return this.isCustomKeyboardEnable;
    }

    @JvmName(name = "setCustomKeyboardEnable")
    public final void setCustomKeyboardEnable(boolean z) {
        this.isCustomKeyboardEnable = z;
    }

    @JvmName(name = "isInPaymentResult")
    /* renamed from: isInPaymentResult  reason: from getter */
    public final boolean getIsInPaymentResult() {
        return this.isInPaymentResult;
    }

    @JvmName(name = "setInPaymentResult")
    public final void setInPaymentResult(boolean z) {
        this.isInPaymentResult = z;
    }

    @JvmName(name = "isReturnHome")
    /* renamed from: isReturnHome  reason: from getter */
    public final boolean getIsReturnHome() {
        return this.isReturnHome;
    }

    @JvmName(name = "setReturnHome")
    public final void setReturnHome(boolean z) {
        this.isReturnHome = z;
    }

    @JvmName(name = "isQrisCrossBorder")
    /* renamed from: isQrisCrossBorder  reason: from getter */
    public final boolean getIsQrisCrossBorder() {
        return this.isQrisCrossBorder;
    }

    @JvmName(name = "setQrisCrossBorder")
    public final void setQrisCrossBorder(boolean z) {
        this.isQrisCrossBorder = z;
    }

    @JvmName(name = "getResultCode")
    public final String getResultCode() {
        return this.resultCode;
    }

    @JvmName(name = "setResultCode")
    public final void setResultCode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.resultCode = str;
    }

    @JvmName(name = "getNeedBackHomeOnDestroy")
    public final boolean getNeedBackHomeOnDestroy() {
        return this.needBackHomeOnDestroy;
    }

    @JvmName(name = "setNeedBackHomeOnDestroy")
    public final void setNeedBackHomeOnDestroy(boolean z) {
        this.needBackHomeOnDestroy = z;
    }

    @JvmName(name = "isNeedBackConfirmation")
    /* renamed from: isNeedBackConfirmation  reason: from getter */
    public final boolean getIsNeedBackConfirmation() {
        return this.isNeedBackConfirmation;
    }

    @JvmName(name = "setNeedBackConfirmation")
    public final void setNeedBackConfirmation(boolean z) {
        this.isNeedBackConfirmation = z;
    }

    @JvmName(name = "isNeedExpandPayMethodOnBack")
    /* renamed from: isNeedExpandPayMethodOnBack  reason: from getter */
    public final boolean getIsNeedExpandPayMethodOnBack() {
        return this.isNeedExpandPayMethodOnBack;
    }

    @JvmName(name = "setNeedExpandPayMethodOnBack")
    public final void setNeedExpandPayMethodOnBack(boolean z) {
        this.isNeedExpandPayMethodOnBack = z;
    }

    @JvmName(name = "getTransferType")
    public final String getTransferType() {
        return (String) this.id.dana.cashier.utils.CashierKeyParams.TRANSFER_TYPE java.lang.String.getValue();
    }

    @JvmName(name = "getOrderTitleFromSummary")
    public final String getOrderTitleFromSummary() {
        return (String) this.orderTitleFromSummary.getValue();
    }

    @JvmName(name = "getAddOnTrackingModel")
    public final AddOnTrackingModel getAddOnTrackingModel() {
        return this.addOnTrackingModel;
    }

    @JvmName(name = "setAddOnTrackingModel")
    public final void setAddOnTrackingModel(AddOnTrackingModel addOnTrackingModel) {
        this.addOnTrackingModel = addOnTrackingModel;
    }

    @JvmName(name = "getPhonePermission")
    public final ActivityPermissionRequest getPhonePermission() {
        return this.phonePermission;
    }

    @JvmName(name = "getListRiskMethod")
    public final CashierListRiskMethod getListRiskMethod() {
        return this.listRiskMethod;
    }

    @JvmName(name = "setListRiskMethod")
    public final void setListRiskMethod(CashierListRiskMethod cashierListRiskMethod) {
        Intrinsics.checkNotNullParameter(cashierListRiskMethod, "");
        this.listRiskMethod = cashierListRiskMethod;
    }

    @JvmName(name = "getPayScannerFragment")
    public final PayScannerFragment getPayScannerFragment() {
        PayScannerFragment payScannerFragment = this.payScannerFragment;
        if (payScannerFragment != null) {
            return payScannerFragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPayScannerFragment")
    public final void setPayScannerFragment(PayScannerFragment payScannerFragment) {
        Intrinsics.checkNotNullParameter(payScannerFragment, "");
        this.payScannerFragment = payScannerFragment;
    }

    @JvmName(name = "getBarcodeView")
    public final CustomDecoratedBarcodeView getBarcodeView() {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.barcodeView;
        if (customDecoratedBarcodeView != null) {
            return customDecoratedBarcodeView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBarcodeView")
    public final void setBarcodeView(CustomDecoratedBarcodeView customDecoratedBarcodeView) {
        Intrinsics.checkNotNullParameter(customDecoratedBarcodeView, "");
        this.barcodeView = customDecoratedBarcodeView;
    }

    @JvmName(name = "getNativelyDecodedQrResult")
    public final HashMap<String, String> getNativelyDecodedQrResult() {
        return this.nativelyDecodedQrResult;
    }

    @JvmName(name = "setNativelyDecodedQrResult")
    public final void setNativelyDecodedQrResult(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "");
        this.nativelyDecodedQrResult = hashMap;
    }

    @JvmName(name = "getCashierCheckoutModel")
    public final BehaviorSubject<CashierCheckoutModel> getCashierCheckoutModel() {
        return this.cashierCheckoutModel;
    }

    @JvmName(name = "setCashierCheckoutModel")
    public final void setCashierCheckoutModel(BehaviorSubject<CashierCheckoutModel> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "");
        this.cashierCheckoutModel = behaviorSubject;
    }

    @JvmName(name = "getCashierPayMethod")
    public final BehaviorSubject<PayMethodInitModel> getCashierPayMethod() {
        return this.id.dana.cashier.utils.CashierKeyParams.CASHIER_PAY_METHOD java.lang.String;
    }

    @JvmName(name = "setCashierPayMethod")
    public final void setCashierPayMethod(BehaviorSubject<PayMethodInitModel> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "");
        this.id.dana.cashier.utils.CashierKeyParams.CASHIER_PAY_METHOD java.lang.String = behaviorSubject;
    }

    @JvmName(name = "getFeatureTimeModel")
    public final FeatureTimeModel getFeatureTimeModel() {
        return this.featureTimeModel;
    }

    @JvmName(name = "setFeatureTimeModel")
    public final void setFeatureTimeModel(FeatureTimeModel featureTimeModel) {
        this.featureTimeModel = featureTimeModel;
    }

    @JvmName(name = "getTimerType")
    public final String getTimerType() {
        return (String) this.timerType.getValue();
    }

    @JvmName(name = "isFromDanaKagetRevamp")
    public final boolean isFromDanaKagetRevamp() {
        return ((Boolean) this.isFromDanaKagetRevamp.getValue()).booleanValue();
    }

    @JvmName(name = "getTimerDuration")
    public final long getTimerDuration() {
        return ((Number) this.timerDuration.getValue()).longValue();
    }

    @JvmName(name = "getCountDownListener")
    public final Function1<Long, Unit> getCountDownListener() {
        return this.countDownListener;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        finishCountDownEarly();
        CashierEventListener cashierEventListener = getErrorConfigVersion;
        if (cashierEventListener != null) {
            cashierEventListener.PlaceComponentResult(this.resultCode, this.getAuthRequestContext);
        }
        if (this.needBackHomeOnDestroy) {
            GContainer.closeAllContainers();
            startActivity(new Intent(this, HomeTabActivity.class));
        }
        super.onDestroy();
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.BaseActivity
    public final void disposePresenter() {
        super.disposePresenter();
        getCashierPresenter().get().onDestroy();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Bundle extras;
        Bundle bundle;
        Object[] objArr = new Object[1];
        a(getPackageName().codePointAt(4) - 79, new int[]{1384397432, 1929233769, -1449865899, 563921989, 571934413, 180809772, -917011587, -1663160426, -836904044, -681428578}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(getPackageName().codePointAt(5) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS, new int[]{-1430053055, -277631478, -1295306304, -834682981}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr3 = new Object[1];
                    b(getAuthRequestContext[9], getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    b(getAuthRequestContext[59], getAuthRequestContext[13], getAuthRequestContext[56], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{1384397432, 1929233769, -1449865899, 563921989, 1111947423, 146902217, -1572588377, -223441367, 2127774351, -59463624, -199630093, 1081996740, -914734400, 737516493}, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a(TextUtils.getOffsetBefore("", 0) + 18, new int[]{605943996, 1261236936, 431376495, -1014160714, -1559058947, 885274408, 1456344373, 81864686, -283421763, 238489884}, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 35 - TextUtils.getOffsetAfter("", 0), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(getPackageName().codePointAt(1) - 52, new int[]{-320385722, 1408045507, -310156257, 1834350668, -1448200398, -2109567372, -664072410, -1361412252, -254025865, -1904289983, -2113600577, -363570250, 937835341, 741253306, 877227987, -1244628052, 355449086, -1237615470, 758222218, 1829746237, -1514669751, 681380258, -1117666679, 712953403}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(R.string.gn_subtitle_jp).substring(0, 86).length() - 22, new int[]{805159877, -1325016080, 2005790485, 643197703, 1502295988, 555931409, 766146151, -789156770, -1959721661, 927034926, 2021181550, 1266311680, 1517999753, 1250645184, -1334235512, 749512370, -1873611332, 1262491698, 1576435621, -1906673110, 1242026966, -1079494665, -1333347477, 927790107, 388536518, 1986222963, -246846792, -734443925, -1605937743, 2091712486, -1100455890, 633412661}, objArr7);
                    String str2 = (String) objArr7[0];
                    try {
                        Object[] objArr8 = new Object[1];
                        b(getAuthRequestContext[9], getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(getAuthRequestContext[59], getAuthRequestContext[13], getAuthRequestContext[56], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 31, new int[]{498862187, 882111968, -1973757960, 183229335, 1219592039, -1191809522, -974307538, -1320059981, 1783561056, -487754456, 281817461, -1765711027, -801950423, 523347910, 1363357774, -1389928077, 1483556703, -382002711, 33555351, -1195910142, 612173346, 333321729, 226853686, 1773542312, 432921956, -2142990206, 60667924, 98900650, 1120820429, 1624587073, -589859734, -1659013615}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.ep_general_error_desc).substring(2, 3).length() + 59, new int[]{-332710936, 689928187, -1334219689, -1254839483, -457907000, 1168626195, -216269935, -376415913, 896251783, 406131282, -904042546, 1378403018, 462565694, 883718943, -1961802542, 560452152, -838791088, 1602239359, -1506465721, -222563068, 1205397, 2043636504, -1783239417, -412878467, 1239390228, 1202631517, 1054974897, -378589274, -603916995, -1777533058}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(5 - Process.getGidForName(""), new int[]{-1835517791, -401825619, 162843848, 1457404375}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            }
        }
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr14 = new Object[1];
            b((short) 36, b, b, objArr14);
            Class<?> cls5 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b((byte) (PlaceComponentResult - 1), getAuthRequestContext[7], getAuthRequestContext[25], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 4 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                    Object[] objArr17 = new Object[1];
                    c((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr17);
                    obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 35 - Color.blue(0), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr19 = {-454067470, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                }
                this.getErrorConfigVersion = savedInstanceState != null;
                this.skipInit = true;
                super.onCreate(savedInstanceState);
                setContentView(getLayout());
                Intent intent = getIntent();
                if ((intent == null || (extras = intent.getExtras()) == null || (bundle = extras.getBundle("data")) == null || bundle.getBoolean("open_cashier")) ? false : true) {
                    setBarcodeView(new CustomDecoratedBarcodeView(this));
                    setPayScannerFragment(new PayScannerFragment());
                }
                getApplicationComponent().MyBillsEntityDataFactory(this);
                init();
            } catch (Throwable th7) {
                Throwable cause7 = th7.getCause();
                if (cause7 == null) {
                    throw th7;
                }
                throw cause7;
            }
        } catch (Throwable th8) {
            Throwable cause8 = th8.getCause();
            if (cause8 == null) {
                throw th8;
            }
            throw cause8;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.request_money_bank_list_title).substring(1, 2).codePointAt(0) - 71, new int[]{1384397432, 1929233769, -1449865899, 563921989, 1111947423, 146902217, -1572588377, -223441367, 2127774351, -59463624, -199630093, 1081996740, -914734400, 737516493}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(TextUtils.indexOf((CharSequence) "", '0') + 19, new int[]{605943996, 1261236936, 431376495, -1014160714, -1559058947, 885274408, 1456344373, 81864686, -283421763, 238489884}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), KeyEvent.normalizeMetaState(0) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onPause();
        dispose();
        if (isFinishing()) {
            overridePendingTransition(R.anim.f5032130772052, R.anim.f5082130772059);
        }
    }

    public static /* synthetic */ void processCashierUrl$default(PayActivity payActivity, String str, Bundle bundle, String str2, boolean z, CurrencyRateModel currencyRateModel, CashierMerchantModel cashierMerchantModel, int i, Object obj) {
        payActivity.processCashierUrl(str, (i & 2) != 0 ? null : bundle, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : currencyRateModel, (i & 32) == 0 ? cashierMerchantModel : null);
    }

    public static /* synthetic */ void getCashierMain$default(PayActivity payActivity, CashierCheckoutRequestModel cashierCheckoutRequestModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        payActivity.getCashierMain(cashierCheckoutRequestModel, z);
    }

    public final void getCashierMain(CashierCheckoutRequestModel requestModel, boolean r3) {
        Intrinsics.checkNotNullParameter(requestModel, "");
        getCashierPresenter().get().PlaceComponentResult(requestModel, r3);
    }

    public final void retryPaymentFromResultPage(CashierCheckoutRequestModel checkoutRequestModel, CashierPayMethodModel selectedPayMethod) {
        Intrinsics.checkNotNullParameter(checkoutRequestModel, "");
        getCashierMain(checkoutRequestModel, true);
        PayConfirmationFragment.Companion companion = PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        addAndRemoveStackedFragment(PayConfirmationFragment.Companion.PlaceComponentResult(checkoutRequestModel, null, selectedPayMethod, false, null, 58), true, true);
    }

    public final void processNativelyDecodedQr(HashMap<String, String> nativelyDecodedQr, String r12, String qrCode, Boolean precreateOrder) {
        Intrinsics.checkNotNullParameter(nativelyDecodedQr, "");
        this.nativelyDecodedQrResult = nativelyDecodedQr;
        CashierInitParamHelper cashierInitParamHelper = CashierInitParamHelper.INSTANCE;
        showCashier$default(this, CashierInitParamHelper.PlaceComponentResult(nativelyDecodedQr, r12, qrCode, precreateOrder), false, null, null, false, null, 62, null);
    }

    public static /* synthetic */ void showCashier$default(PayActivity payActivity, CashierMerchantModel cashierMerchantModel, boolean z, CashierCheckoutRequestModel cashierCheckoutRequestModel, String str, boolean z2, CurrencyRateModel currencyRateModel, int i, Object obj) {
        if ((i & 1) != 0) {
            cashierMerchantModel = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            cashierCheckoutRequestModel = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        if ((i & 32) != 0) {
            currencyRateModel = null;
        }
        payActivity.showCashier(cashierMerchantModel, z, cashierCheckoutRequestModel, str, z2, currencyRateModel);
    }

    public final void showCashier(CashierMerchantModel merchantModel, boolean isPreloadMerchantModel, CashierCheckoutRequestModel checkoutRequestModel, String kybOrderId, boolean isFromCpm, CurrencyRateModel r14) {
        if (!isPreloadMerchantModel && merchantModel != null) {
            InputAmountFragment.Companion companion = InputAmountFragment.INSTANCE;
            addFragment(InputAmountFragment.Companion.PlaceComponentResult(merchantModel, null, 2));
        }
        if (checkoutRequestModel != null) {
            PayConfirmationFragment.Companion companion2 = PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            addFragment(PayConfirmationFragment.Companion.PlaceComponentResult(checkoutRequestModel, !isPreloadMerchantModel ? null : merchantModel, null, isFromCpm, r14, 12));
        }
        if (kybOrderId != null) {
            InputAmountFragment.Companion companion3 = InputAmountFragment.INSTANCE;
            addFragment(InputAmountFragment.Companion.PlaceComponentResult(null, kybOrderId, 1));
        }
        BuiltInFictitiousFunctionClassFactory();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.addOnBackStackChangedListener(new PayActivity$$ExternalSyntheticLambda4(supportFragmentManager, this));
        scheduleImpl = true;
        DanaH5Listener danaH5Listener = NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (danaH5Listener != null) {
            danaH5Listener.onContainerCreated(null);
        }
    }

    public static /* synthetic */ void startCashierProcessing$default(PayActivity payActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        payActivity.startCashierProcessing(str, str2);
    }

    /* JADX WARN: Type inference failed for: r17v0, types: [java.util.List, id.dana.cashier.model.CashierPayMethodModel] */
    public final void startCashierProcessing(String tradeNo, String merchantId) {
        Intrinsics.checkNotNullParameter(tradeNo, "");
        BuiltInFictitiousFunctionClassFactory();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.addOnBackStackChangedListener(new PayActivity$$ExternalSyntheticLambda4(supportFragmentManager, this));
        ?? r17 = 0;
        RiskParamsFactory riskParamsFactory = new RiskParamsFactory(null, null, null, false, null, null, null, null, null, null, null, null, r17, merchantId, r17, 24575, null);
        CashierGeneralProcessingFragment.Companion companion = CashierGeneralProcessingFragment.INSTANCE;
        addFragment(CashierGeneralProcessingFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(tradeNo, riskParamsFactory));
        scheduleImpl = true;
        DanaH5Listener danaH5Listener = NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (danaH5Listener != null) {
            danaH5Listener.onContainerCreated(null);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.NavigationMenuPresenter$HeaderViewHolder);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
            constraintLayout.setOnTouchListener(new OnSwipeListener() { // from class: id.dana.pay.PayActivity$setSwipeListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(PayActivity.this);
                }

                @Override // id.dana.utils.OnSwipeListener
                public final void getAuthRequestContext() {
                    PayActivity.this.setHalfScreenBottomSheet();
                }

                @Override // id.dana.utils.OnSwipeListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    PayActivity.this.expandBottomSheet();
                }
            });
        }
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.LoaderManagerImpl$LoaderViewModel$1);
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(new OnSwipeListener() { // from class: id.dana.pay.PayActivity$setSwipeListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(PayActivity.this);
                }

                @Override // id.dana.utils.OnSwipeListener
                public final void getAuthRequestContext() {
                    PayActivity.this.setHalfScreenBottomSheet();
                }

                @Override // id.dana.utils.OnSwipeListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    PayActivity.this.expandBottomSheet();
                }
            });
        }
    }

    public final void expandBottomSheet() {
        if (this.scheduleImpl) {
            return;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.UserBankRepository));
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(_$_findCachedViewById(R.id.res_0x7f0a0ce8_abstractmap_values_1).getId()).BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = "";
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2((ConstraintLayout) _$_findCachedViewById(R.id.UserBankRepository));
        TransitionManager.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.UserBankRepository), (AutoTransition) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
        this.scheduleImpl = true;
    }

    public final void setOneKlikPhoneNumer(String oneKlikBankPhoneNumber) {
        Intrinsics.checkNotNullParameter(oneKlikBankPhoneNumber, "");
        this.lookAheadTest = oneKlikBankPhoneNumber;
    }

    public static /* synthetic */ void setTopUpPayInputFragmentParameter$default(PayActivity payActivity, TopUpVerifyRequestModel topUpVerifyRequestModel, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        payActivity.setTopUpPayInputFragmentParameter(topUpVerifyRequestModel, str);
    }

    public final void setTopUpPayInputFragmentParameter(TopUpVerifyRequestModel oneKlikTopUpVerifyRequestModel, String oneKlikBizOrderId) {
        Intrinsics.checkNotNullParameter(oneKlikTopUpVerifyRequestModel, "");
        Intrinsics.checkNotNullParameter(oneKlikBizOrderId, "");
        this.GetContactSyncConfig = oneKlikTopUpVerifyRequestModel;
        this.moveToNextValue = oneKlikBizOrderId;
    }

    /* renamed from: getOneKlikBizOrderId  reason: from getter */
    public final String getMoveToNextValue() {
        return this.moveToNextValue;
    }

    public final void setHalfScreenBottomSheet() {
        if (this.scheduleImpl) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.UserBankRepository));
            int i = getBaseContext().getResources().getDisplayMetrics().heightPixels;
            if (i <= 480) {
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(_$_findCachedViewById(R.id.res_0x7f0a0ce8_abstractmap_values_1).getId()).BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = "";
            } else if (i >= 900) {
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(_$_findCachedViewById(R.id.res_0x7f0a0ce8_abstractmap_values_1).getId()).BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = getString(R.string.card_pay_view_constraint_ratio);
            } else {
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(_$_findCachedViewById(R.id.res_0x7f0a0ce8_abstractmap_values_1).getId()).BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = "H,1:1.50";
            }
            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2((ConstraintLayout) _$_findCachedViewById(R.id.UserBankRepository));
            TransitionManager.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.UserBankRepository), (AutoTransition) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
            this.scheduleImpl = false;
        } else if (this.isDismissAllowed) {
            finish();
        }
    }

    public final void addFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = R.anim.MyBillsEntityDataFactory_res_0x7f010057;
        beginTransaction.GetContactSyncConfig = R.anim.f4712130772012;
        beginTransaction.newProxyInstance = R.anim.f4702130772011;
        beginTransaction.PrepareContext = R.anim.lookAheadTest;
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(((FragmentContainerView) _$_findCachedViewById(R.id.res_0x7f0a0796_access_getargumentsdepth)).getId(), fragment, null, 1);
        if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        beginTransaction.scheduleImpl = true;
        beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        this.isInPaymentResult = fragment instanceof PaymentResultFragment;
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void addAndRemoveStackedFragment$default(PayActivity payActivity, Fragment fragment, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        payActivity.addAndRemoveStackedFragment(fragment, z, z2);
    }

    public final void addAndRemoveStackedFragment(Fragment fragment, boolean isEnableToRemove, boolean isFromPayResultPage) {
        Intrinsics.checkNotNullParameter(fragment, "");
        int i = this.DatabaseTableConfigUtil + 1;
        this.DatabaseTableConfigUtil = i;
        if (isEnableToRemove) {
            if (i > 0) {
                int i2 = 1;
                while (true) {
                    getSupportFragmentManager().popBackStack();
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            this.DatabaseTableConfigUtil = 0;
        }
        if (getSupportFragmentManager().getBackStackEntryCount() > 1 && isEnableToRemove && isFromPayResultPage) {
            getSupportFragmentManager().popBackStack();
        }
        addFragment(fragment);
    }

    public final void enableDisableActivityTouchEvent(boolean isEnable) {
        if (isEnable) {
            getWindow().clearFlags(16);
        } else {
            getWindow().setFlags(16, 16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleCashierRiskPhase$default(PayActivity payActivity, String str, RiskParamsFactory riskParamsFactory, List list, Fragment fragment, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            fragment = null;
        }
        payActivity.handleCashierRiskPhase(str, riskParamsFactory, list, fragment);
    }

    /* JADX WARN: Code restructure failed: missing block: B:348:0x0035, code lost:
    
        if (r1.equals(id.dana.cashier.VerificationMethod.SEND_OTP) == false) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0132, code lost:
    
        if (r1.equals("OTP_SMS") == false) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0164, code lost:
    
        if (r1.equals(id.dana.cashier.VerificationMethod.BANK_OTP) != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x016a, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, id.dana.cashier.VerificationMethod.SEND_OTP) == false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x016c, code lost:
    
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0170, code lost:
    
        if (r3 == null) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0176, code lost:
    
        if (r3.isEmpty() == false) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x0179, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x017b, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x017c, code lost:
    
        if (r5 != false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x017e, code lost:
    
        r5 = id.dana.cashier.fragment.CashierOneKlikChallengeFragment.INSTANCE;
        r5 = r19.getAuthRequestContext(r1);
        r5.putParcelableArrayList("PHONE_NUMBER_LIST", new java.util.ArrayList<>(r3));
        r5.putString("BANK_PHONE_NUMBER", r17.lookAheadTest);
        r3 = r17.GetContactSyncConfig;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0197, code lost:
    
        if (r3 == null) goto L411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0199, code lost:
    
        r5.putParcelable(id.dana.cashier.utils.CashierKeyParams.TOP_UP_VERIFY_REQUEST_MODEL, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x019e, code lost:
    
        r3 = id.dana.cashier.fragment.CashierOneKlikChallengeFragment.Companion.PlaceComponentResult(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x01a5, code lost:
    
        r3 = id.dana.cashier.fragment.CashierOtpChallengeFragment.INSTANCE;
        r3 = id.dana.cashier.fragment.CashierOtpChallengeFragment.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r19.getAuthRequestContext(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x01b1, code lost:
    
        addFragment(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleCashierRiskPhase(java.lang.String r18, id.dana.cashier.RiskParamsFactory r19, java.util.List<id.dana.cashier.model.OneKlikPhonesModel> r20, androidx.fragment.app.Fragment r21) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pay.PayActivity.handleCashierRiskPhase(java.lang.String, id.dana.cashier.RiskParamsFactory, java.util.List, androidx.fragment.app.Fragment):void");
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String requestKey, Bundle result) {
        Intrinsics.checkNotNullParameter(requestKey, "");
        Intrinsics.checkNotNullParameter(result, "");
        if (Intrinsics.areEqual(requestKey, "3ds_request_key")) {
            int i = result.getInt("3ds_result_key");
            if (i != -1) {
                if (i == 0) {
                    finish();
                    return;
                }
                return;
            }
            String string = result.getString(CashierRisk3dsActivity.URL_PARAMS);
            CashierRiskListener cashierRiskListener = this.BuiltInFictitiousFunctionClassFactory;
            if (cashierRiskListener != null) {
                cashierRiskListener.MyBillsEntityDataFactory(string);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r2, int resultCode, Intent data) {
        Bundle extras;
        super.onActivityResult(r2, resultCode, data);
        if (r2 == 1006) {
            if (resultCode == -1) {
                CashierSmartPayListener cashierSmartPayListener = this.cashierSmartPayListener;
                if (cashierSmartPayListener != null) {
                    cashierSmartPayListener.getAuthRequestContext();
                    return;
                }
                return;
            }
            CashierSmartPayListener cashierSmartPayListener2 = this.cashierSmartPayListener;
            if (cashierSmartPayListener2 != null) {
                String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString(ChallengeControl.Key.CANCEL_REASON);
                if (string == null) {
                    string = "";
                }
                cashierSmartPayListener2.KClassImpl$Data$declaredNonStaticMembers$2(string);
            }
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        ExpandablePaymentMethod expandablePaymentMethod;
        if (this.isNeedBackConfirmation) {
            CashierExitConfirmationDialog.KClassImpl$Data$declaredNonStaticMembers$2(this, new Function1<View, Unit>() { // from class: id.dana.pay.PayActivity$onBackPressed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    PayActivity.this.setNeedBackConfirmation(false);
                    PayActivity.this.onBackPressed();
                }
            });
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 1 && !this.isInPaymentResult) {
            if (this.isNeedExpandPayMethodOnBack) {
                PayConfirmationFragment.Companion companion = PayConfirmationFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                PayConfirmationFragment authRequestContext = PayConfirmationFragment.Companion.getAuthRequestContext();
                if (authRequestContext != null && (expandablePaymentMethod = (ExpandablePaymentMethod) authRequestContext.BuiltInFictitiousFunctionClassFactory(R.id.DefaultBehaviorComponent)) != null) {
                    expandablePaymentMethod.expandView(true);
                }
                this.isNeedExpandPayMethodOnBack = false;
            }
            supportFragmentManager.popBackStackImmediate();
            return;
        }
        finish();
    }

    public final void setCashierRiskListener(CashierRiskListener cashierRiskListener) {
        Intrinsics.checkNotNullParameter(cashierRiskListener, "");
        this.BuiltInFictitiousFunctionClassFactory = cashierRiskListener;
    }

    public final void backToHomePage(Bundle r2) {
        this.needBackHomeOnDestroy = false;
        backToHomepage(r2);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        scheduleImpl = false;
        DanaH5Listener danaH5Listener = NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (danaH5Listener != null) {
            danaH5Listener.onContainerDestroyed(null);
        }
        String str = this.resultCode;
        if (Intrinsics.areEqual(getSource(), TrackerKey.SourceType.MY_BILLS)) {
            EventBus.getDefault().post(new MyBillsDashboardFragment.PaymentResultStatusEvent(str));
        }
    }

    public final void listenCountDown(Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "");
        this.countDownListener = action;
    }

    public final void startCountDown() {
        if (Intrinsics.areEqual(getTimerType(), "")) {
            return;
        }
        ((CountDownTimer) this.MyBillsEntityDataFactory.getValue()).cancel();
        ((CountDownTimer) this.MyBillsEntityDataFactory.getValue()).start();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    }

    public final void finishCountDownEarly() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            ((CountDownTimer) this.MyBillsEntityDataFactory.getValue()).cancel();
            getAuthRequestContext(false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        }
    }

    public final void getAuthRequestContext(boolean p0) {
        CashierEventListener cashierEventListener = getErrorConfigVersion;
        if (cashierEventListener != null) {
            cashierEventListener.PlaceComponentResult(getTimerType(), getTimerDuration(), p0);
        }
        if (isFromDanaKagetRevamp()) {
            finish();
        }
    }

    public final void setCurrentPaymentStatus(@PaymentResultBackToHomeStatus String resultCode) {
        Intrinsics.checkNotNullParameter(resultCode, "");
        this.resultCode = resultCode;
        if (Intrinsics.areEqual(resultCode, PaymentResultBackToHomeStatus.CANCELLED) || Intrinsics.areEqual(resultCode, "")) {
            setResult(0);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(PAYMENT_RESULT, resultCode);
        setResult(-1, intent);
    }

    public final void needToBackHomeOnDestroy(boolean needToBackHome) {
        this.needBackHomeOnDestroy = needToBackHome;
    }

    public final PaymentResultFragment.CashierResultBannerListener createCashierResultBannerListener() {
        return new PaymentResultFragment.CashierResultBannerListener() { // from class: id.dana.pay.PayActivity$createCashierResultBannerListener$1
            @Override // id.dana.cashier.fragment.PaymentResultFragment.CashierResultBannerListener
            public final void getAuthRequestContext(boolean p0) {
                PayActivity.this.getAuthRequestContext = new PayResultEmoneyBannerListenerModel(true, p0);
            }
        };
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÅ\u0001\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010#\u001a\u00020\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u001a2(\b\u0002\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010'j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010,\u001a\u00020\u001a2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0003\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0002\u00104J&\u00105\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u00106\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u000108H\u0007J\u001c\u00109\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007Jz\u0010:\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u00106\u001a\u0004\u0018\u00010\u00042\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010\u00042\b\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006A"}, d2 = {"Lid/dana/pay/PayActivity$Companion;", "", "()V", "CASHIER_CUSTOM_KEYBOARD", "", "DEVICE_COMPACT_HEIGHT", "", "DEVICE_MEDIUM_HEIGHT", "FEATURE_TIME_MODEL_ARG", "IS_RETURN_HOME", "MP_POSITION", "NATIVELY_DECODED_QR", "OPEN_CASHIER", OrganizerSummaryActivity.PAYMENT_RESULT, "PRECREATE_ORDER", "QR_CODE", "REDIRECT_URL", "REQUEST_ID", "SMART_PAY_BOTTOM_SHEET_REQUEST_CODE", "TIMER_DURATION", "TIMER_TYPE", "cashierEventListener", "Lid/dana/cashier/CashierEventListener;", "h5CashierListener", "Lid/dana/utils/danah5/DanaH5Listener;", "isShowingCashier", "", "()Z", "setShowingCashier", "(Z)V", "createCashierIntent", "Landroid/content/Intent;", HummerConstants.CONTEXT, "Landroid/content/Context;", "source", "isCashier", "redirectUrl", "isCustomKeyboardEnable", "nativelyDecodedQr", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", UrlParam.REQUEST_ID, "qrCode", "precreateOrder", "isReturnHome", "payActivityListenerModel", "Lid/dana/pay/model/PayActivityListenerModel;", "timerType", "timerDuration", "", "featureTimeModel", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;ZLjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLid/dana/pay/model/PayActivityListenerModel;Ljava/lang/String;JLid/dana/cashier/model/featureTime/FeatureTimeModel;)Landroid/content/Intent;", "createPayActivityFromFamilyAccountApprovalIntent", CashierKeyParams.CASHIER_ORDER_ID, "attributeModel", "Lid/dana/cashier/model/AttributeCashierPayModel;", "createPayActivityIntent", "createPayActivityforSendMoney", "fundOrderId", "groupOrderId", "orderId", CashierKeyParams.TRANSFER_TYPE, "reloadRequest", "orderTitle", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "isShowingCashier")
        public static boolean MyBillsEntityDataFactory() {
            return PayActivity.scheduleImpl;
        }

        @JvmName(name = "setShowingCashier")
        public static void PlaceComponentResult() {
            PayActivity.scheduleImpl = false;
        }

        public static /* synthetic */ Intent PlaceComponentResult(Context context, String str, boolean z, String str2, boolean z2, HashMap hashMap, String str3, String str4, Boolean bool, boolean z3, PayActivityListenerModel payActivityListenerModel, String str5, long j, FeatureTimeModel featureTimeModel, int i) {
            return PlaceComponentResult(context, str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : hashMap, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? true : z3, (i & 1024) != 0 ? null : payActivityListenerModel, (i & 2048) != 0 ? "" : str5, (i & 4096) != 0 ? 0L : j, (i & 8192) != 0 ? null : featureTimeModel);
        }

        @JvmStatic
        public static Intent PlaceComponentResult(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3, String str4, Boolean bool, boolean z3, PayActivityListenerModel payActivityListenerModel, @CashierTimerType String str5, long j, FeatureTimeModel featureTimeModel) {
            Intrinsics.checkNotNullParameter(str5, "");
            Intent intent = new Intent(context, PayActivity.class);
            intent.putExtra("source", str);
            Bundle bundle = new Bundle();
            bundle.putBoolean("open_cashier", z);
            bundle.putString("redirect_url", str2);
            bundle.putBoolean("is_return_home", z3);
            bundle.putBoolean("cashier_custom_keyboard", z2);
            bundle.putSerializable("natively_decoded_qr", hashMap);
            bundle.putString("qrCode", str4);
            bundle.putBoolean("precreateOrder", bool != null ? bool.booleanValue() : false);
            bundle.putString(UrlParam.REQUEST_ID, str3);
            bundle.putString("timer_type", str5);
            bundle.putLong("timer_duration", j);
            bundle.putParcelable("feature_time_model_arg", featureTimeModel);
            intent.putExtra("data", bundle);
            if (payActivityListenerModel != null) {
                PayActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = payActivityListenerModel.PlaceComponentResult;
                PayActivity.getErrorConfigVersion = payActivityListenerModel.BuiltInFictitiousFunctionClassFactory;
            }
            return intent;
        }

        @JvmStatic
        public static Intent getAuthRequestContext(Context context, String str) {
            CameraReadyTimeHelper.BuiltInFictitiousFunctionClassFactory();
            PayQrOpenTracker payQrOpenTracker = PayQrOpenTracker.INSTANCE;
            PayQrOpenTracker.MyBillsEntityDataFactory();
            Intent intent = new Intent(context, PayActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("open_cashier", false);
            intent.putExtra("source", str);
            intent.putExtra("data", bundle);
            return intent;
        }

        @JvmStatic
        public static Intent PlaceComponentResult(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, @CashierTimerType String str8, long j, FeatureTimeModel featureTimeModel) {
            Intrinsics.checkNotNullParameter(str8, "");
            Bundle bundle = new Bundle();
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, str);
            bundle.putString("bizNo", str2);
            bundle.putString("groupOrderId", str3);
            bundle.putString("orderId", str4);
            bundle.putString(CashierKeyParams.TRANSFER_TYPE, str5);
            if (str6 != null) {
                bundle.putString("reloadRequest", str6);
            }
            if (str7 != null) {
                bundle.putString(CashierKeyParams.GET_ORDER_TITLE, str7);
            }
            bundle.putBoolean("open_cashier", true);
            bundle.putString("timer_type", str8);
            bundle.putLong("timer_duration", j);
            if (featureTimeModel != null) {
                bundle.putParcelable("feature_time_model_arg", featureTimeModel);
            }
            Intent intent = new Intent(context, PayActivity.class);
            intent.putExtra("source", "Send Money");
            intent.putExtra("data", bundle);
            return intent;
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context context, String str, AttributeCashierPayModel attributeCashierPayModel) {
            Bundle bundle = new Bundle();
            bundle.putString(CashierKeyParams.CASHIER_ORDER_ID, str);
            bundle.putParcelable(CashierKeyParams.ATTRIBUTE_CASHIER_PAY, attributeCashierPayModel);
            bundle.putBoolean("open_cashier", true);
            Intent intent = new Intent(context, PayActivity.class);
            intent.putExtra("source", "Family Account");
            intent.putExtra("data", bundle);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$3X0aC7phJMcOQANlUaywIoshrgk(PayActivity payActivity, View view) {
        Intrinsics.checkNotNullParameter(payActivity, "");
        DanaH5.startContainerFullUrl(DanaUrl.DANA_PAY);
    }

    public static /* synthetic */ void $r8$lambda$3t1Cg6m3_dGku85wIsiiMuVCUjc(FragmentManager fragmentManager, PayActivity payActivity) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(payActivity, "");
        if (fragmentManager.findFragmentById(((FragmentContainerView) payActivity._$_findCachedViewById(R.id.res_0x7f0a0796_access_getargumentsdepth)).getId()) instanceof PayFragment) {
            scheduleImpl = false;
            DanaH5Listener danaH5Listener = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (danaH5Listener != null) {
                danaH5Listener.onContainerDestroyed(null);
            }
            String str = payActivity.resultCode;
            if (Intrinsics.areEqual(payActivity.getSource(), TrackerKey.SourceType.MY_BILLS)) {
                EventBus.getDefault().post(new MyBillsDashboardFragment.PaymentResultStatusEvent(str));
            }
            payActivity.setHalfScreenBottomSheet();
            if (payActivity.cashierCheckoutModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                BehaviorSubject<CashierCheckoutModel> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                payActivity.cashierCheckoutModel = BuiltInFictitiousFunctionClassFactory;
            }
            if (payActivity.id.dana.cashier.utils.CashierKeyParams.CASHIER_PAY_METHOD java.lang.String.KClassImpl$Data$declaredNonStaticMembers$2()) {
                BehaviorSubject<PayMethodInitModel> BuiltInFictitiousFunctionClassFactory2 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
                payActivity.id.dana.cashier.utils.CashierKeyParams.CASHIER_PAY_METHOD java.lang.String = BuiltInFictitiousFunctionClassFactory2;
            }
            BaseFragment KClassImpl$Data$declaredNonStaticMembers$2 = ViewPagerBaseFragment.KClassImpl$Data$declaredNonStaticMembers$2((PayFragment) payActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue());
            PayScannerFragment payScannerFragment = KClassImpl$Data$declaredNonStaticMembers$2 instanceof PayScannerFragment ? KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (payScannerFragment != null) {
                PayScannerFragment payScannerFragment2 = payScannerFragment;
                payScannerFragment2.onSelected();
                if (payScannerFragment2.scheduleImpl) {
                    payScannerFragment2.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                    payScannerFragment2.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory();
                }
                payScannerFragment2.moveToNextValue();
                payScannerFragment2.lookAheadTest();
                payScannerFragment2.scanQrPresenter.get().PlaceComponentResult();
                payScannerFragment2.BuiltInFictitiousFunctionClassFactory(false);
                payScannerFragment2.scheduleImpl();
            }
        }
    }

    /* renamed from: $r8$lambda$6i4FgWfcLH9cKCy-rSV1cuzwwHc */
    public static /* synthetic */ void m2772$r8$lambda$6i4FgWfcLH9cKCyrSV1cuzwwHc(PayActivity payActivity, View view) {
        Intrinsics.checkNotNullParameter(payActivity, "");
        if (payActivity.isDismissAllowed) {
            payActivity.finish();
        }
    }

    /* renamed from: $r8$lambda$XdCq0-SVM3Ic65ii-bVQT2SQ71s */
    public static /* synthetic */ void m2773$r8$lambda$XdCq0SVM3Ic65iibVQT2SQ71s(PayActivity payActivity, View view) {
        Intrinsics.checkNotNullParameter(payActivity, "");
        payActivity.finish();
    }

    /* renamed from: $r8$lambda$jgIxDu5pl2-7F8-8N58gofCxFMI */
    public static /* synthetic */ void m2774$r8$lambda$jgIxDu5pl27F88N58gofCxFMI(PayActivity payActivity, View view) {
        Intrinsics.checkNotNullParameter(payActivity, "");
        DanaH5.startContainerFullUrl(DanaUrl.ONE_HUNDRED_PERCENT_GUARANTEE);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str) {
        return Companion.PlaceComponentResult(context, str, false, null, false, null, null, null, null, false, null, null, 0L, null, 16380);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z) {
        return Companion.PlaceComponentResult(context, str, z, null, false, null, null, null, null, false, null, null, 0L, null, 16376);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2) {
        return Companion.PlaceComponentResult(context, str, z, str2, false, null, null, null, null, false, null, null, 0L, null, 16368);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2) {
        return Companion.PlaceComponentResult(context, str, z, str2, z2, null, null, null, null, false, null, null, 0L, null, 16352);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap) {
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, null, null, null, false, null, null, 0L, null, 16320);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3) {
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, str3, null, null, false, null, null, 0L, null, 16256);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3, String str4) {
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, str3, str4, null, false, null, null, 0L, null, 16128);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3, String str4, Boolean bool) {
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, str3, str4, bool, false, null, null, 0L, null, 15872);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3, String str4, Boolean bool, boolean z3) {
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, str3, str4, bool, z3, null, null, 0L, null, 15360);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3, String str4, Boolean bool, boolean z3, PayActivityListenerModel payActivityListenerModel) {
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, str3, str4, bool, z3, payActivityListenerModel, null, 0L, null, 14336);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3, String str4, Boolean bool, boolean z3, PayActivityListenerModel payActivityListenerModel, @CashierTimerType String str5) {
        Intrinsics.checkNotNullParameter(str5, "");
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, str3, str4, bool, z3, payActivityListenerModel, str5, 0L, null, 12288);
    }

    @JvmStatic
    public static final Intent createCashierIntent(Context context, String str, boolean z, String str2, boolean z2, HashMap<String, String> hashMap, String str3, String str4, Boolean bool, boolean z3, PayActivityListenerModel payActivityListenerModel, @CashierTimerType String str5, long j) {
        Intrinsics.checkNotNullParameter(str5, "");
        return Companion.PlaceComponentResult(context, str, z, str2, z2, hashMap, str3, str4, bool, z3, payActivityListenerModel, str5, j, null, 8192);
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        Bundle extras;
        Bundle bundle;
        Parcelable parcelable;
        DaggerCashierComponent.Builder MyBillsEntityDataFactory = DaggerCashierComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.scheduleImpl = (CashierModule) Preconditions.getAuthRequestContext(this.PlaceComponentResult);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CashierRiskChallengeModule) Preconditions.getAuthRequestContext(new CashierRiskChallengeModule(new CashierViewListener() { // from class: id.dana.pay.PayActivity$cashierRiskChallengeModule$1
        }));
        MyBillsEntityDataFactory.getErrorConfigVersion = (TopUpAndPayModule) Preconditions.getAuthRequestContext(new TopUpAndPayModule(new CashierViewListener() { // from class: id.dana.pay.PayActivity$topUpAndPayModule$1
        }));
        MyBillsEntityDataFactory.PlaceComponentResult = (CashierCardBindingModule) Preconditions.getAuthRequestContext(new CashierCardBindingModule(new CashierViewListener() { // from class: id.dana.pay.PayActivity$cashierCardBindingModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (CashierAnalyticModule) Preconditions.getAuthRequestContext(new CashierAnalyticModule());
        MyBillsEntityDataFactory.moveToNextValue = (CashierPayLaterModule) Preconditions.getAuthRequestContext(new CashierPayLaterModule(new CashierPayLaterViewListener() { // from class: id.dana.pay.PayActivity$cashierPayLaterModule$1
        }));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (CashierAddOnModule) Preconditions.getAuthRequestContext(new CashierAddOnModule(new CashierAddOnViewListener() { // from class: id.dana.pay.PayActivity$cashierAddOnModule$1
        }));
        MyBillsEntityDataFactory.lookAheadTest = (CashierUserRelatedModule) Preconditions.getAuthRequestContext(new CashierUserRelatedModule(new CashierUserRelatedViewListener() { // from class: id.dana.pay.PayActivity$cashierUserRelatedModule$1
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (CashierHighlightModule) Preconditions.getAuthRequestContext(new CashierHighlightModule(new CashierHighlightViewListener() { // from class: id.dana.pay.PayActivity$cashierHighlightModule$1
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory().MyBillsEntityDataFactory(this);
        if (this.getErrorConfigVersion) {
            this.needBackHomeOnDestroy = true;
            finish();
        } else {
            Intent intent = getIntent();
            if (intent != null && (extras = intent.getExtras()) != null && (bundle = extras.getBundle("data")) != null) {
                if (bundle.getBoolean("open_cashier")) {
                    this.isCustomKeyboardEnable = bundle.getBoolean("cashier_custom_keyboard");
                    String string = bundle.getString("redirect_url");
                    String str = string == null ? "" : string;
                    String string2 = extras.getString("source");
                    processCashierUrl$default(this, str, bundle, string2 == null ? "" : string2, false, (CurrencyRateModel) bundle.getParcelable(CashierKeyParams.EXCHANGE_RATE), null, 40, null);
                    Intrinsics.checkNotNullExpressionValue(bundle, "");
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelable = (Parcelable) bundle.getParcelable("feature_time_model_arg", FeatureTimeModel.class);
                    } else {
                        Parcelable parcelable2 = bundle.getParcelable("feature_time_model_arg");
                        parcelable = (FeatureTimeModel) (parcelable2 instanceof FeatureTimeModel ? parcelable2 : null);
                    }
                    this.featureTimeModel = (FeatureTimeModel) parcelable;
                } else {
                    addAndRemoveStackedFragment$default(this, (PayFragment) this.NetworkUserEntityData$$ExternalSyntheticLambda2.getValue(), true, false, 4, null);
                    ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.NavigationMenuPresenter$HeaderViewHolder);
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(8);
                    }
                    RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.LoaderManagerImpl$LoaderViewModel$1);
                    if (relativeLayout != null) {
                        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pay.PayActivity$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PayActivity.m2773$r8$lambda$XdCq0SVM3Ic65iibVQT2SQ71s(PayActivity.this, view);
                            }
                        });
                        relativeLayout.setOnTouchListener(null);
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2();
                }
                this.isReturnHome = bundle.getBoolean("is_return_home");
            }
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.UserBankRepository);
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pay.PayActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayActivity.m2772$r8$lambda$6i4FgWfcLH9cKCyrSV1cuzwwHc(PayActivity.this, view);
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.Locator);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pay.PayActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayActivity.$r8$lambda$3X0aC7phJMcOQANlUaywIoshrgk(PayActivity.this, view);
                }
            });
        }
        DanaProtectionView danaProtectionView = (DanaProtectionView) _$_findCachedViewById(R.id.res_0x7f0a1b1f_lambda_getnearbyshops_0_id_dana_data_nearbyme_repository_nearbymeentityrepository);
        if (danaProtectionView != null) {
            danaProtectionView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pay.PayActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayActivity.m2774$r8$lambda$jgIxDu5pl27F88N58gofCxFMI(PayActivity.this, view);
                }
            });
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            for (int i = 0; i < backStackEntryCount; i++) {
                supportFragmentManager.popBackStack(supportFragmentManager.getBackStackEntryAt(i).PlaceComponentResult(), 1);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.List, java.lang.String] */
    public final void processCashierUrl(String url, Bundle data, String source, boolean isFromCpm, CurrencyRateModel r74, CashierMerchantModel preloadMerchantModel) {
        String str;
        CashierCheckoutRequestModel cashierCheckoutRequestModel;
        CashierCheckoutRequestModel cashierCheckoutRequestModel2;
        CashierMerchantModel cashierMerchantModel;
        String str2;
        String str3;
        String str4;
        List<OneKlikPhonesModel> list;
        MoneyViewModel moneyViewModel;
        List<CashierPayChannelModel> list2;
        Intrinsics.checkNotNullParameter(url, "");
        if (Intrinsics.areEqual(source, "Send Money") || Intrinsics.areEqual(source, "Group Send") || Intrinsics.areEqual(source, TrackerKey.SourceType.TRANSFER_OVERSEAS)) {
            if (data != null) {
                CashierInitParamHelper cashierInitParamHelper = CashierInitParamHelper.INSTANCE;
                Intrinsics.checkNotNullParameter(data, "");
                String string = data.getString("groupOrderId");
                String string2 = data.getString(CashierKeyParams.CASHIER_ORDER_ID);
                String string3 = data.getString("reloadRequest");
                Boolean valueOf = string3 != null ? Boolean.valueOf(Boolean.parseBoolean(string3)) : null;
                String string4 = data.getString("orderId");
                String string5 = data.getString("bizNo");
                String str5 = string;
                if (str5 == null || str5.length() == 0) {
                    String str6 = string4;
                    str = !(str6 == null || str6.length() == 0) ? string4 : string5;
                } else {
                    str = string;
                }
                String str7 = null;
                ?? r16 = 0;
                String str8 = null;
                ?? r19 = 0;
                cashierCheckoutRequestModel = new CashierCheckoutRequestModel(string2, valueOf, new CheckoutExternalInfo(str7, str, r16, str8, Boolean.valueOf(!(str5 == null || str5.length() == 0)), r19, 45, null), str7, null, r16, str8, null, r19, null, NativePageType.SEND_MONEY, false, null, 7160, null);
                cashierCheckoutRequestModel2 = cashierCheckoutRequestModel;
            }
            cashierCheckoutRequestModel2 = null;
        } else {
            CashierInitParamHelper cashierInitParamHelper2 = CashierInitParamHelper.INSTANCE;
            if (CashierInitParamHelper.NetworkUserEntityData$$ExternalSyntheticLambda2(url)) {
                CashierInitParamHelper cashierInitParamHelper3 = CashierInitParamHelper.INSTANCE;
                cashierCheckoutRequestModel = CashierInitParamHelper.BuiltInFictitiousFunctionClassFactory(url);
                cashierCheckoutRequestModel2 = cashierCheckoutRequestModel;
            } else {
                if (Intrinsics.areEqual(source, "Family Account")) {
                    BuiltInFictitiousFunctionClassFactory();
                    if (data != null) {
                        AttributeCashierPayModel attributeCashierPayModel = (AttributeCashierPayModel) data.getParcelable(CashierKeyParams.ATTRIBUTE_CASHIER_PAY);
                        String string6 = data.getString(CashierKeyParams.CASHIER_ORDER_ID);
                        String str9 = string6 == null ? "" : string6;
                        if (attributeCashierPayModel != null) {
                            List<RiskVerificationMethodModel> list3 = attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1;
                            if (!(list3 == null || list3.isEmpty())) {
                                RiskVerificationMethodModel riskVerificationMethodModel = (RiskVerificationMethodModel) CollectionsKt.first((List) attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1);
                                str3 = riskVerificationMethodModel.MyBillsEntityDataFactory;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                str4 = riskVerificationMethodModel.scheduleImpl;
                            } else {
                                RiskVerificationMethodModel riskVerificationMethodModel2 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String;
                                str4 = riskVerificationMethodModel2 != null ? riskVerificationMethodModel2.scheduleImpl : null;
                                str3 = "";
                            }
                        } else {
                            str3 = "";
                            str4 = null;
                        }
                        CashierPayMethodModel.BalanceFamilyPayMethod BuiltInFictitiousFunctionClassFactory = (attributeCashierPayModel == null || (list2 = attributeCashierPayModel.I) == null) ? null : CashierPayChannelModelKt.BuiltInFictitiousFunctionClassFactory(list2);
                        CashierPayMethodModel.BalanceFamilyPayMethod balanceFamilyPayMethod = BuiltInFictitiousFunctionClassFactory;
                        PayResultModel payResultModel = new PayResultModel(null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, -1, 524287, null);
                        payResultModel.AppCompatEmojiTextHelper = (BuiltInFictitiousFunctionClassFactory == null || (moneyViewModel = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext) == null) ? null : moneyViewModel.getAuthRequestContext();
                        Unit unit = Unit.INSTANCE;
                        RiskParamsFactory riskParamsFactory = new RiskParamsFactory(attributeCashierPayModel, str9, balanceFamilyPayMethod, false, null, payResultModel, null, null, null, null, null, null, null, null, null, 32728, null);
                        String str10 = str4;
                        if ((str10 == null || str10.length() == 0) || Intrinsics.areEqual(str4, "MIC_FACE")) {
                            CashierGeneralProcessingFragment.Companion companion = CashierGeneralProcessingFragment.INSTANCE;
                            addFragment(CashierGeneralProcessingFragment.Companion.BuiltInFictitiousFunctionClassFactory(str3, str4 != null ? str4 : "", riskParamsFactory));
                        } else {
                            RiskVerificationMethodModel riskVerificationMethodModel3 = attributeCashierPayModel.com.alibaba.griver.image.photo.utils.DiskFormatter.KB java.lang.String;
                            if (riskVerificationMethodModel3 == null || (list = riskVerificationMethodModel3.getAuthRequestContext) == null) {
                                RiskVerificationMethodModel riskVerificationMethodModel4 = attributeCashierPayModel.P;
                                list = riskVerificationMethodModel4 != null ? riskVerificationMethodModel4.getAuthRequestContext : null;
                            }
                            handleCashierRiskPhase(str4, riskParamsFactory, list, null);
                        }
                    }
                }
                cashierCheckoutRequestModel2 = null;
            }
        }
        if (cashierCheckoutRequestModel2 != null) {
            getCashierMain(cashierCheckoutRequestModel2, true);
            showCashier$default(this, preloadMerchantModel, true, cashierCheckoutRequestModel2, null, isFromCpm, r74, 8, null);
            return;
        }
        Serializable serializable = data != null ? data.getSerializable("natively_decoded_qr") : null;
        if (serializable != null) {
            String string7 = data.getString(UrlParam.REQUEST_ID);
            String string8 = data.getString("qrCode");
            boolean z = data.getBoolean("precreateOrder");
            CashierInitParamHelper cashierInitParamHelper4 = CashierInitParamHelper.INSTANCE;
            cashierMerchantModel = CashierInitParamHelper.PlaceComponentResult((HashMap) serializable, string7, string8, Boolean.valueOf(z));
        } else {
            CashierInitParamHelper cashierInitParamHelper5 = CashierInitParamHelper.INSTANCE;
            if (CashierInitParamHelper.scheduleImpl(url)) {
                CashierInitParamHelper cashierInitParamHelper6 = CashierInitParamHelper.INSTANCE;
                cashierMerchantModel = CashierInitParamHelper.MyBillsEntityDataFactory(url);
            } else {
                cashierMerchantModel = null;
            }
        }
        if (cashierMerchantModel != null) {
            this.isQrisCrossBorder = cashierMerchantModel.getBuiltInFictitiousFunctionClassFactory();
            showCashier$default(this, cashierMerchantModel, false, null, null, false, null, 62, null);
            return;
        }
        CashierInitParamHelper cashierInitParamHelper7 = CashierInitParamHelper.INSTANCE;
        if (CashierInitParamHelper.getErrorConfigVersion(url)) {
            CashierInitParamHelper cashierInitParamHelper8 = CashierInitParamHelper.INSTANCE;
            str2 = CashierInitParamHelper.getAuthRequestContext(url);
        } else {
            str2 = null;
        }
        if (str2 != null) {
            showCashier$default(this, null, false, null, str2, false, null, 55, null);
            return;
        }
        if (url.length() > 0) {
            DanaH5.startContainerFullUrl(url, NetworkUserEntityData$$ExternalSyntheticLambda0);
            finish();
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = M;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = M;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
