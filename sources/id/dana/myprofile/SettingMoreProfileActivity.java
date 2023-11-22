package id.dana.myprofile;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ExpandableListView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.GriverParams;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.pin.LogoutContract;
import id.dana.common.ProfileDividerItemDecoration;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationModule;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSubMenuComponent;
import id.dana.di.component.SubMenuComponent;
import id.dana.di.modules.ChangePhoneNumberH5EventModule;
import id.dana.di.modules.LogoutModule;
import id.dana.di.modules.SubMenuModule;
import id.dana.dialog.LoadingDialog;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.h5event.ChangePhoneNumberH5EventContract;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.merchantmanagement.view.MerchantManagementActivity;
import id.dana.myprofile.SettingMoreContract;
import id.dana.myprofile.adapter.MyProfileAdapter;
import id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuFaceAuthViewHolder;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.productpage.ProductPageManagerExtKt;
import id.dana.richview.BlueSwitchView;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.SectionShowcaseBuilder;
import id.dana.showcase.Showcase;
import id.dana.social.RestrictedContactActivity;
import id.dana.social.view.activity.ChangeUsernameActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.twilio.onboarding.TwilioIntroductionActivity;
import id.dana.twilio.trusteddevice.TrustedDeviceActivity;
import id.dana.utils.BorderedToastUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.RandomInteger;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.deeplink.DeepLinkParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.handpick.HandPicked;
import id.dana.utils.handpick.HandPickedResultHandler;
import id.dana.utils.permission.PermissionHelper;
import id.dana.wallet_v3.constant.WalletConstant;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.D;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Ç\u00012\u00020\u00012\u00020\u0002:\u0004Ç\u0001È\u0001B\b¢\u0006\u0005\bÆ\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u000b\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0004\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0004\u0010\u0015J\u000f\u0010#\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\u0003H\u0016¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010\u0005J)\u0010/\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0003H\u0016¢\u0006\u0004\b1\u0010\u0005J\u000f\u00102\u001a\u00020\u0003H\u0016¢\u0006\u0004\b2\u0010\u0005J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u00103J!\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u000b\u00105J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u0019\u00108\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u000b\u00103J\u000f\u0010:\u001a\u00020\u0003H\u0014¢\u0006\u0004\b:\u0010\u0005J\u0019\u0010<\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b<\u0010=J)\u0010A\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\bA\u0010BJ\u001f\u0010F\u001a\u00020\u00032\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010CH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0003H\u0016¢\u0006\u0004\bH\u0010\u0005J\u000f\u0010I\u001a\u00020\u0003H\u0014¢\u0006\u0004\bI\u0010\u0005J\u000f\u0010J\u001a\u00020\u0003H\u0016¢\u0006\u0004\bJ\u0010\u0005J!\u0010M\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010\u00132\u0006\u0010L\u001a\u00020\tH\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0003H\u0002¢\u0006\u0004\bO\u0010\u0005J\u000f\u0010P\u001a\u00020\u0003H\u0002¢\u0006\u0004\bP\u0010\u0005J\u000f\u0010Q\u001a\u00020\u0003H\u0002¢\u0006\u0004\bQ\u0010\u0005J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010=J\u000f\u0010R\u001a\u00020\u0003H\u0002¢\u0006\u0004\bR\u0010\u0005J\u000f\u0010S\u001a\u00020\u0003H\u0002¢\u0006\u0004\bS\u0010\u0005J\u000f\u0010T\u001a\u00020\u0003H\u0002¢\u0006\u0004\bT\u0010\u0005J\u000f\u0010U\u001a\u00020\u0003H\u0002¢\u0006\u0004\bU\u0010\u0005J\u000f\u0010V\u001a\u00020\u0003H\u0002¢\u0006\u0004\bV\u0010\u0005J'\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010W\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010XJ'\u0010\\\u001a\u00020\u00032\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0016¢\u0006\u0004\b\\\u0010XJ\u000f\u0010]\u001a\u00020\u0003H\u0002¢\u0006\u0004\b]\u0010\u0005J!\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0004\u0010^J\u0019\u0010`\u001a\u00020\u00032\b\u0010_\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b`\u0010=J\u0017\u0010b\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u0013H\u0016¢\u0006\u0004\bb\u0010=J\u000f\u0010c\u001a\u00020\u0003H\u0016¢\u0006\u0004\bc\u0010\u0005J\u000f\u0010d\u001a\u00020\u0003H\u0016¢\u0006\u0004\bd\u0010\u0005J\u0017\u0010f\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u0013H\u0016¢\u0006\u0004\bf\u0010=J\u0017\u0010h\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u0013H\u0016¢\u0006\u0004\bh\u0010=J\u000f\u0010i\u001a\u00020\u0003H\u0016¢\u0006\u0004\bi\u0010\u0005J\u000f\u0010j\u001a\u00020\u0003H\u0016¢\u0006\u0004\bj\u0010\u0005J\u000f\u0010k\u001a\u00020\u0003H\u0016¢\u0006\u0004\bk\u0010\u0005J\u0017\u0010l\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0013H\u0002¢\u0006\u0004\bl\u0010=J\u000f\u0010m\u001a\u00020\u0003H\u0016¢\u0006\u0004\bm\u0010\u0005J\u000f\u0010n\u001a\u00020\u0003H\u0016¢\u0006\u0004\bn\u0010\u0005J\u0017\u0010p\u001a\u00020\u00032\u0006\u0010o\u001a\u00020\u0013H\u0016¢\u0006\u0004\bp\u0010=J\u0017\u0010r\u001a\u00020\u00032\u0006\u0010q\u001a\u00020DH\u0016¢\u0006\u0004\br\u0010sJ\u0017\u0010t\u001a\u00020\u00032\u0006\u0010q\u001a\u00020DH\u0016¢\u0006\u0004\bt\u0010sJ\u0017\u0010\u0006\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0006\u0010=J\u001f\u0010l\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0013H\u0002¢\u0006\u0004\bl\u0010uR\u0014\u0010l\u001a\u00020\t8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010$R\u0016\u0010\u000b\u001a\u00020w8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\b\u0010xR$\u0010\u007f\u001a\u0004\u0018\u00010y8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R*\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R$\u0010\u0004\u001a\b*\u00030\u0087\u00010\u0087\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b\r\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R*\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R'\u0010\u0094\u0001\u001a\u0004\u0018\u00010y8\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bv\u0010z\u001a\u0005\b\u0092\u0001\u0010|\"\u0005\b\u0093\u0001\u0010~R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0017\u0010\u0095\u0001R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0095\u0001R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010\u0096\u0001R*\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001b\u0010\b\u001a\b*\u00030\u009e\u00010\u009e\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u001f\u0010\u009f\u0001R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b+\u0010\u0095\u0001R\u0018\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0017\u0010\u0007\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b'\u0010¡\u0001R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b#\u0010¢\u0001R\u001f\u0010\u0017\u001a\u00030£\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b)\u0010\u0088\u0001\u001a\u0006\b \u0001\u0010¤\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u0016\u0010v\u001a\u00030¬\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\bQ\u0010\u00ad\u0001R\u0018\u0010\u0089\u0001\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bP\u0010¡\u0001R'\u0010°\u0001\u001a\u0004\u0018\u00010y8\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bO\u0010z\u001a\u0005\b®\u0001\u0010|\"\u0005\b¯\u0001\u0010~R\u0015\u0010\u001c\u001a\u00020(8\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\bR\u0010±\u0001R\u001d\u0010³\u0001\u001a\u00020(8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bS\u0010±\u0001\u001a\u0005\b²\u0001\u0010*R*\u0010µ\u0001\u001a\u00030´\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R*\u0010¼\u0001\u001a\u00030»\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R\u0018\u0010)\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010¡\u0001R\u0017\u0010#\u001a\u00020D8\u0002@\u0002X\u0083.¢\u0006\u0007\n\u0005\bU\u0010Ã\u0001R\u0017\u0010+\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bT\u0010¡\u0001R\u001a\u0010'\u001a\u0005\u0018\u00010Ä\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b]\u0010Å\u0001"}, d2 = {"Lid/dana/myprofile/SettingMoreProfileActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/myprofile/SettingMoreContract$View;", "", "PlaceComponentResult", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "scheduleImpl", "", "p0", "getAuthRequestContext", "(Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "Landroid/view/View;", "getErrorConfigVersion", "()Landroid/view/View;", "dismissProgress", "", "", "(Ljava/lang/String;)I", "Lid/dana/myprofile/viewholder/ProfileMenuAutoSwitchViewHolder;", "initRecordTimeStamp", "()Lid/dana/myprofile/viewholder/ProfileMenuAutoSwitchViewHolder;", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Intent;)Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()Ljava/lang/String;", "Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder;", "DatabaseTableConfigUtil", "()Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder;", "getLayout", "()I", "isLayoutRequested", "()Z", "hideNickname", IAPSyncCommand.COMMAND_INIT, "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "()Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "newProxyInstance", RequestPermission.REQUEST_CODE, "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onAlreadyEnrolled", "onBackPressed", "(I)V", "p1", "(ILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "isVisible", "isSwitchActive", "authenticationType", "onGetAutoSwitchInitialState", "(ZZLjava/lang/String;)V", "", "Lid/dana/domain/profilemenu/model/SettingModel;", "settings", "onGetSettingCollectionSuccess", "(Ljava/util/List;)V", "onGetUserInfoFailed", "onResume", "onUnenrolled", WalletConstant.KYC_LEVEL, "kycCertified", "onUserKycInfo", "(Ljava/lang/String;Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda4", "getSupportButtonTintMode", "SubSequence", "readMicros", "p2", "(ZZZ)V", "isFaceLoginEnabled", "hasEnrolled", "isFaceLoginReady", "setFaceLoginState", "whenAvailable", "(ILandroid/view/View;)V", GriverParams.ShareParams.IMAGE_URL, "showAvatar", "emailAddress", "showEmailAddress", "showEmailAddressUnset", "showErrorToast", "name", "showNickname", "phoneNumber", "showPhoneNumber", "showProgress", "showSecurityQuestionStateOff", "showSecurityQuestionStateOn", "BuiltInFictitiousFunctionClassFactory", "showTrustedDevice", "showTrustedDeviceUnset", "username", "showUsername", MyProfileBundleKey.SETTING_MODEL, "toggleShareFeedConsentFailed", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "toggleShareFeedConsentSuccess", "(Ljava/lang/String;Ljava/lang/String;)V", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lid/dana/myprofile/SettingMoreProfileActivity$Listener;", "Lid/dana/myprofile/SettingMoreProfileActivity$Listener;", "getAutoRouteListener", "()Lid/dana/myprofile/SettingMoreProfileActivity$Listener;", "setAutoRouteListener", "(Lid/dana/myprofile/SettingMoreProfileActivity$Listener;)V", "autoRouteListener", "Lid/dana/h5event/ChangePhoneNumberH5EventContract$Presenter;", "changePhoneNumberH5EventPresenter", "Lid/dana/h5event/ChangePhoneNumberH5EventContract$Presenter;", "getChangePhoneNumberH5EventPresenter", "()Lid/dana/h5event/ChangePhoneNumberH5EventContract$Presenter;", "setChangePhoneNumberH5EventPresenter", "(Lid/dana/h5event/ChangePhoneNumberH5EventContract$Presenter;)V", "Lid/dana/di/component/SubMenuComponent;", "Lkotlin/Lazy;", "GetContactSyncConfig", "()Lid/dana/di/component/SubMenuComponent;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "getFaceAuthListener", "setFaceAuthListener", "faceAuthListener", "Ljava/lang/Boolean;", "Lid/dana/myprofile/viewholder/ProfileMenuFaceAuthViewHolder;", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "Lid/dana/utils/handpick/HandPicked;", "Lid/dana/utils/handpick/HandPicked;", "PrepareContext", "Z", "Ljava/lang/String;", "Lid/dana/dialog/LoadingDialog;", "()Lid/dana/dialog/LoadingDialog;", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "logoutPresenter", "Lid/dana/challenge/pin/LogoutContract$Presenter;", "getLogoutPresenter", "()Lid/dana/challenge/pin/LogoutContract$Presenter;", "setLogoutPresenter", "(Lid/dana/challenge/pin/LogoutContract$Presenter;)V", "Lid/dana/myprofile/adapter/MyProfileAdapter;", "Lid/dana/myprofile/adapter/MyProfileAdapter;", "getPaymentAuthListener", "setPaymentAuthListener", "paymentAuthListener", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "getPhonePermission", "phonePermission", "Lid/dana/myprofile/SettingMoreContract$Presenter;", "presenter", "Lid/dana/myprofile/SettingMoreContract$Presenter;", "getPresenter", "()Lid/dana/myprofile/SettingMoreContract$Presenter;", "setPresenter", "(Lid/dana/myprofile/SettingMoreContract$Presenter;)V", "Lid/dana/lib/bio/productpage/ProductPageManager;", "productPageManager", "Lid/dana/lib/bio/productpage/ProductPageManager;", "getProductPageManager", "()Lid/dana/lib/bio/productpage/ProductPageManager;", "setProductPageManager", "(Lid/dana/lib/bio/productpage/ProductPageManager;)V", "getCallingPid", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/showcase/Showcase;", "Lid/dana/showcase/Showcase;", "<init>", "Companion", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SettingMoreProfileActivity extends BaseActivity implements SettingMoreContract.View {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final int AUTO_ROUTE_BOTTOM_SHEET_REQUEST_CODE = 2001;
    private static long B = 0;
    private static int BottomSheetCardBindingView$watcherCardNumberView$1 = 0;
    private static int C = 0;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String PARAM_USERNAME_SUCCESS = "USERNAME_SUCCESS";
    public static final byte[] PlaceComponentResult;
    public static final long TOAST_DURATION = 4000;
    public static final int TOAST_MAX_TEXT_LINES = 3;
    private static char VerifyPinStateManager$executeRiskChallenge$2$1;
    public static final int getAuthRequestContext;
    private static final int getErrorConfigVersion;
    private static long readMicros;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final HandPicked scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private ProfileMenuFaceAuthViewHolder getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private Listener faceAuthListener;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final ActivityPermissionRequest phonePermission;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private Listener paymentAuthListener;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private SettingModel isLayoutRequested;
    @Inject
    public ChangePhoneNumberH5EventContract.Presenter changePhoneNumberH5EventPresenter;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean newProxyInstance;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String DatabaseTableConfigUtil;
    @Inject
    public LogoutContract.Presenter logoutPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Listener autoRouteListener;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private Boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public SettingMoreContract.Presenter presenter;
    @Inject
    public ProductPageManager productPageManager;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MaterialDialog getAuthRequestContext;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private Showcase NetworkUserEntityData$$ExternalSyntheticLambda7;
    public static final byte[] $$a = {38, -105, 32, Ascii.RS, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 73;
    private static int A = 0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final MyProfileAdapter NetworkUserEntityData$$ExternalSyntheticLambda2 = new MyProfileAdapter();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy initRecordTimeStamp = LazyKt.lazy(new Function0<LoadingDialog>() { // from class: id.dana.myprofile.SettingMoreProfileActivity$loadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LoadingDialog invoke() {
            return new LoadingDialog(SettingMoreProfileActivity.this);
        }
    });

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean GetContactSyncConfig = true;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<SubMenuComponent>() { // from class: id.dana.myprofile.SettingMoreProfileActivity$component$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SubMenuComponent invoke() {
            DaggerSubMenuComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerSubMenuComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(SettingMoreProfileActivity.this.getApplicationComponent());
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (SubMenuModule) Preconditions.getAuthRequestContext(new SubMenuModule(SettingMoreProfileActivity.this));
            final SettingMoreProfileActivity settingMoreProfileActivity = SettingMoreProfileActivity.this;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (ChangePhoneNumberH5EventModule) Preconditions.getAuthRequestContext(new ChangePhoneNumberH5EventModule(new ChangePhoneNumberH5EventContract.View() { // from class: id.dana.myprofile.SettingMoreProfileActivity$component$2$$ExternalSyntheticLambda0
                @Override // id.dana.h5event.ChangePhoneNumberH5EventContract.View
                public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
                    SettingMoreProfileActivity.access$onChangePhoneNumberSuccess(SettingMoreProfileActivity.this, z);
                }
            }));
            final SettingMoreProfileActivity settingMoreProfileActivity2 = SettingMoreProfileActivity.this;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (LogoutModule) Preconditions.getAuthRequestContext(new LogoutModule(new LogoutContract.View() { // from class: id.dana.myprofile.SettingMoreProfileActivity$component$2.2
                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void MyBillsEntityDataFactory() {
                    SettingMoreProfileActivity.this.dismissProgress();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                    SettingMoreProfileActivity.this.dismissProgress();
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    SettingMoreProfileActivity.this.showProgress();
                }

                @Override // id.dana.challenge.pin.LogoutContract.View
                public final void PlaceComponentResult() {
                    SettingMoreProfileActivity.access$trackLogoutEvent(SettingMoreProfileActivity.this, "Normal");
                    Intent intent = new Intent(SettingMoreProfileActivity.this, OnboardingActivity.class);
                    DeepLinkParser.getAuthRequestContext();
                    intent.setFlags(268468224);
                    SettingMoreProfileActivity.this.startActivity(intent);
                    SettingMoreProfileActivity.this.finish();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    dismissProgress();
                    SettingMoreProfileActivity.this.showErrorToast();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    SettingMoreProfileActivity.this.showProgress();
                }
            }));
            Preconditions.getAuthRequestContext(new FaceAuthPopUpConsultationModule(new FaceAuthPopUpConsultationContract.View() { // from class: id.dana.myprofile.SettingMoreProfileActivity$component$2.3
                @Override // id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory() {
                    FaceAuthPopUpConsultationContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
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
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, SubMenuModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, ChangePhoneNumberH5EventModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, LogoutModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            return new DaggerSubMenuComponent.SubMenuComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda1 = NetworkUserEntityData$$ExternalSyntheticLambda8();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/SettingMoreProfileActivity$Listener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory(String p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: $r8$lambda$2jjPnG_TmmCNSqGd-QDqKyvmOFE */
    public static /* synthetic */ void m2691$r8$lambda$2jjPnG_TmmCNSqGdQDqKyvmOFE(SettingMoreProfileActivity settingMoreProfileActivity, int i) {
        int i2 = A + 59;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        char c = i2 % 2 == 0 ? '#' : ',';
        Object[] objArr = null;
        MyBillsEntityDataFactory(settingMoreProfileActivity, i);
        if (c == '#') {
            objArr.hashCode();
        }
        int i3 = A + 67;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 21 : (char) 20) != 21) {
            return;
        }
        int length = objArr.length;
    }

    public static /* synthetic */ void $r8$lambda$6focC4705Tiy7ajQfhERitZUqjc(SettingMoreProfileActivity settingMoreProfileActivity) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 123;
            try {
                A = i % 128;
                if ((i % 2 != 0 ? 'W' : '5') != 'W') {
                    PlaceComponentResult(settingMoreProfileActivity);
                } else {
                    PlaceComponentResult(settingMoreProfileActivity);
                    int i2 = 51 / 0;
                }
                int i3 = A + 51;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$Y0tXzMRrgG3pCYENyiRc8E82qFo(SettingMoreProfileActivity settingMoreProfileActivity, View view, int i) {
        int i2 = A + 19;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
        try {
            PlaceComponentResult(settingMoreProfileActivity, view, i);
            int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 5;
            A = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        B = -8467282231789074370L;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x004e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x003d -> B:45:0x003f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r9, short r10, short r11, java.lang.Object[] r12) {
        /*
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L56
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r1     // Catch: java.lang.Exception -> L56
            int r0 = r0 % 2
            int r10 = r10 + 16
            byte[] r0 = id.dana.myprofile.SettingMoreProfileActivity.PlaceComponentResult
            int r9 = 56 - r9
            int r11 = r11 + 97
            byte[] r1 = new byte[r10]
            r2 = -1
            int r10 = r10 + r2
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L1c
            r5 = 1
            goto L1d
        L1c:
            r5 = 0
        L1d:
            if (r5 == r4) goto L28
            r7 = r10
            r10 = r9
            r9 = r11
            r11 = r7
            r8 = r0
            r0 = r12
            r12 = r1
            r1 = r8
            goto L3f
        L28:
            r2 = r1
            r5 = -1
            r1 = r0
            r0 = r12
            r12 = r11
            r11 = r10
            r10 = r9
        L2f:
            int r9 = r9 + r12
            int r9 = r9 + (-4)
            int r10 = r10 + r4
            int r12 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L54
            int r12 = r12 + 75
            int r6 = r12 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r6     // Catch: java.lang.Exception -> L56
            int r12 = r12 % 2
            r12 = r2
            r2 = r5
        L3f:
            int r5 = r2 + 1
            byte r2 = (byte) r9
            r12[r5] = r2
            if (r5 != r11) goto L4e
            java.lang.String r9 = new java.lang.String
            r9.<init>(r12, r3)
            r0[r3] = r9
            return
        L4e:
            r2 = r1[r10]
            r7 = r2
            r2 = r12
            r12 = r7
            goto L2f
        L54:
            r9 = move-exception
            throw r9
        L56:
            r9 = move-exception
            goto L59
        L58:
            throw r9
        L59:
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.c(short, short, short, java.lang.Object[]):void");
    }

    private static void g(byte b, byte b2, int i, Object[] objArr) {
        byte[] bArr = $$a;
        int i2 = 42 - (i * 3);
        int i3 = 47 - b2;
        int i4 = (b * 2) + 75;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i4 = (i4 + (-i3)) - 7;
            i3++;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i6;
            int i9 = i3;
            i4 = (i4 + (-bArr[i3])) - 7;
            i3 = i9 + 1;
            i6 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    static void getAuthRequestContext() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 1;
        A = i % 128;
        int i2 = i % 2;
        VerifyPinStateManager$executeRiskChallenge$2$1 = (char) 60677;
        readMicros = 4360990799332652212L;
        C = -956812108;
        int i3 = A + 105;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void _$_clearFindViewByIdCache() {
        int i = A + 103;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? 'C' : '(') != 'C') {
            this._$_findViewCache.clear();
            return;
        }
        try {
            this._$_findViewCache.clear();
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map;
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 117;
        A = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 29 : 'W') != 29) {
            try {
                map = this._$_findViewCache;
                View view = map.get(Integer.valueOf(i));
                if (view != null) {
                    return view;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            map = this._$_findViewCache;
            View view2 = map.get(Integer.valueOf(i));
            int i3 = 34 / 0;
            if (view2 != null) {
                return view2;
            }
        }
        try {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 99;
                A = i4 % 128;
                boolean z = i4 % 2 == 0;
                map.put(Integer.valueOf(i), findViewById);
                if (z) {
                    return findViewById;
                }
                int i5 = 37 / 0;
                return findViewById;
            }
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:332:0x00a3, code lost:
    
        if ((r2 > 99999 ? 17 : '6') != 17) goto L333;
     */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0775  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x0957  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0959  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x095c  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x095f  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0965  */
    /* JADX WARN: Removed duplicated region for block: B:589:0x0b29 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:604:0x02a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r28) {
        /*
            Method dump skipped, instructions count: 3286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 61;
        A = i % 128;
        int i2 = i % 2;
        Context applicationContext = super.getApplicationContext();
        int i3 = A + 81;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
        return applicationContext;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 9;
        A = i % 128;
        if (i % 2 != 0) {
            Context baseContext = super.getBaseContext();
            Object[] objArr = null;
            int length = objArr.length;
            return baseContext;
        }
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        int i = A + 109;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        String authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
        try {
            int i3 = A + 31;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            if ((i3 % 2 == 0 ? 'L' : 'Z') != 'L') {
                return authRequestContext;
            }
            Object obj = null;
            obj.hashCode();
            return authRequestContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 41;
        A = i % 128;
        if ((i % 2 != 0 ? ']' : '\f') == ']') {
            int i2 = 54 / 0;
        }
        int i3 = A + 9;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 60 / 0;
            return R.layout.activity_sub_menu;
        }
        return R.layout.activity_sub_menu;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 87;
        A = i % 128;
        if (i % 2 != 0) {
            Resources resources = super.getResources();
            Object obj = null;
            obj.hashCode();
            return resources;
        }
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        char[] cArr;
        char[] cArr2;
        int i;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int i2 = A + 39;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 15 : 'I') != 15) {
                cArr = new char[]{0, 0, 0, 0};
                cArr2 = new char[]{13037, 3019, 56888, 49979};
                i = -33;
            } else {
                cArr = new char[]{0, 0, 0, 0};
                cArr2 = new char[]{13037, 3019, 56888, 49979};
                i = 80;
            }
            char[] cArr3 = cArr;
            char[] cArr4 = cArr2;
            try {
                Object[] objArr = new Object[1];
                c((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                c(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), objArr2);
                Object[] objArr3 = new Object[1];
                b(cArr3, cArr4, i + ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion, (char) (getPackageName().codePointAt(3) + 15226), new char[]{24945, 16491, 54604, 2910, 28507, 46413, 51949, 58096, 13200, 31238, 57842, 26517, 11105, 52953, 19317, 27917, 46076, 49709, 19947, 59254, 43911, 22494, 13800, 61989, 61709, 55112}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(new char[]{0, 0, 0, 0}, new char[]{43120, 31466, 7384, 62998}, super.getResources().getString(R.string.exceed_month_limit_smart_friction_description).substring(16, 17).length() - 1, (char) (super.getResources().getString(R.string.withdraw).substring(1, 2).length() + 5659), new char[]{62507, 28480, 4740, 'm', 6760, 37198, 39434, 21900, 15700, 7397, 9209, 46854, 65108, 51752, 11180, 425, 33596, 28129}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
            int i3 = A + 69;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
        }
        if (baseContext != null) {
            int i5 = A + 31;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
            int i6 = i5 % 2;
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 911, 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onPause();
    }

    public SettingMoreProfileActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.myprofile.SettingMoreProfileActivity$phonePermission$1
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
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(SettingMoreProfileActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.phonePermission = builder.PlaceComponentResult();
        HandPicked.Builder builder2 = new HandPicked.Builder(this);
        builder2.KClassImpl$Data$declaredNonStaticMembers$2 = GriverEnv.getApplicationContext().getString(R.string.pick_profile_photo_title);
        builder2.PlaceComponentResult = new HandPickedResultHandler() { // from class: id.dana.myprofile.SettingMoreProfileActivity$handPicked$1
            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void MyBillsEntityDataFactory(Uri p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                SettingMoreProfileActivity.this.getPresenter().BuiltInFictitiousFunctionClassFactory(FileUtil.MyBillsEntityDataFactory(SettingMoreProfileActivity.this.getApplicationContext(), p0.toString()));
            }

            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Exception p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.MyBillsEntityDataFactory("uploadAvatar", p0);
            }
        };
        Application applicationContext = GriverEnv.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        builder2.getAuthRequestContext = PermissionHelper.MyBillsEntityDataFactory(applicationContext, "android.permission.CAMERA");
        Application applicationContext2 = GriverEnv.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "");
        builder2.NetworkUserEntityData$$ExternalSyntheticLambda0 = PermissionHelper.getAuthRequestContext(applicationContext2);
        this.scheduleImpl = new HandPicked(builder2, (byte) 0);
    }

    public static final /* synthetic */ View access$createTooltipView(SettingMoreProfileActivity settingMoreProfileActivity) {
        int i = A + 115;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? (char) 7 : '3') != '3') {
            int i2 = 45 / 0;
            return settingMoreProfileActivity.getErrorConfigVersion();
        }
        return settingMoreProfileActivity.getErrorConfigVersion();
    }

    public static final /* synthetic */ MaterialDialog access$getAlwaysAskPinSuccessDialog$p(SettingMoreProfileActivity settingMoreProfileActivity) {
        int i = A + 97;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        MaterialDialog materialDialog = settingMoreProfileActivity.getAuthRequestContext;
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 37;
        A = i3 % 128;
        if (i3 % 2 == 0) {
            return materialDialog;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return materialDialog;
    }

    public static final /* synthetic */ HandPicked access$getHandPicked$p(SettingMoreProfileActivity settingMoreProfileActivity) {
        int i = A + 91;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        boolean z = i % 2 != 0;
        HandPicked handPicked = settingMoreProfileActivity.scheduleImpl;
        if (!z) {
            int i2 = 38 / 0;
        }
        int i3 = A + 81;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
        return handPicked;
    }

    public static final /* synthetic */ int access$getREQUEST_CODE_PRIVACY_SETTING$cp() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 97;
        A = i % 128;
        if (!(i % 2 == 0)) {
            int i2 = getErrorConfigVersion;
            Object obj = null;
            obj.hashCode();
            return i2;
        }
        return getErrorConfigVersion;
    }

    public static final /* synthetic */ void access$onChangePhoneNumberSuccess(SettingMoreProfileActivity settingMoreProfileActivity, boolean z) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 111;
        A = i % 128;
        boolean z2 = i % 2 == 0;
        settingMoreProfileActivity.MyBillsEntityDataFactory(z);
        if (!z2) {
            int i2 = 24 / 0;
        }
        int i3 = A + 47;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 34 / 0;
        }
    }

    public static final /* synthetic */ void access$setShowcase$p(SettingMoreProfileActivity settingMoreProfileActivity, Showcase showcase) {
        try {
            int i = A + 69;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            settingMoreProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = showcase;
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 93;
            A = i3 % 128;
            if ((i3 % 2 != 0 ? '0' : (char) 17) != '0') {
                return;
            }
            int i4 = 68 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$setShowcaseShowing$p(SettingMoreProfileActivity settingMoreProfileActivity, boolean z) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 55;
        A = i % 128;
        char c = i % 2 != 0 ? '-' : 'Y';
        settingMoreProfileActivity.moveToNextValue = z;
        if (c != '-') {
            return;
        }
        int i2 = 14 / 0;
    }

    public static final /* synthetic */ void access$showAutoSwitchTooltip(SettingMoreProfileActivity settingMoreProfileActivity, int i, View view) {
        int i2 = A + 23;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
        settingMoreProfileActivity.PlaceComponentResult(i, view);
        int i4 = A + 73;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i4 % 128;
        if (!(i4 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static final /* synthetic */ void access$trackLogoutEvent(SettingMoreProfileActivity settingMoreProfileActivity, String str) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 3;
            A = i % 128;
            int i2 = i % 2;
            settingMoreProfileActivity.KClassImpl$Data$declaredNonStaticMembers$2(str);
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
            A = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getPresenter")
    public final SettingMoreContract.Presenter getPresenter() {
        int i = A + 19;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        SettingMoreContract.Presenter presenter = this.presenter;
        if (!(presenter != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        try {
            int i3 = A + 101;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = A + 125;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
                int i6 = i5 % 2;
                return presenter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(SettingMoreContract.Presenter presenter) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 73;
            A = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(presenter, "");
            this.presenter = presenter;
            int i3 = A + 29;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            if (i3 % 2 != 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x001c, code lost:
    
        if ((r0 != null ? id.dana.cashier.view.InputCardNumberView.DIVIDER : 24) != 24) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0027, code lost:
    
        if ((r0 == null) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0029, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x002e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x002f, code lost:
    
        r2 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 + 59;
        id.dana.myprofile.SettingMoreProfileActivity.A = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0039, code lost:
    
        if ((r2 % 2) == 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003b, code lost:
    
        r1 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x003c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003f, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getFriendshipAnalyticTracker")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.feeds.ui.tracker.FriendshipAnalyticTracker getFriendshipAnalyticTracker() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r0 = r0 + 19
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L21
            id.dana.feeds.ui.tracker.FriendshipAnalyticTracker r0 = r4.friendshipAnalyticTracker
            r3 = 45
            int r3 = r3 / r2
            r2 = 24
            if (r0 == 0) goto L1a
            r3 = 32
            goto L1c
        L1a:
            r3 = 24
        L1c:
            if (r3 == r2) goto L29
            goto L2f
        L1f:
            r0 = move-exception
            throw r0
        L21:
            id.dana.feeds.ui.tracker.FriendshipAnalyticTracker r0 = r4.friendshipAnalyticTracker
            if (r0 == 0) goto L26
            goto L27
        L26:
            r2 = 1
        L27:
            if (r2 == 0) goto L2f
        L29:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r1
        L2f:
            int r2 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r2 = r2 + 59
            int r3 = r2 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L3f
            int r1 = r1.length     // Catch: java.lang.Throwable -> L3d
            return r0
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.getFriendshipAnalyticTracker():id.dana.feeds.ui.tracker.FriendshipAnalyticTracker");
    }

    @JvmName(name = "setFriendshipAnalyticTracker")
    public final void setFriendshipAnalyticTracker(FriendshipAnalyticTracker friendshipAnalyticTracker) {
        int i = A + 7;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? (char) 17 : '#') != '#') {
            Intrinsics.checkNotNullParameter(friendshipAnalyticTracker, "");
            this.friendshipAnalyticTracker = friendshipAnalyticTracker;
            int i2 = 83 / 0;
        } else {
            Intrinsics.checkNotNullParameter(friendshipAnalyticTracker, "");
            this.friendshipAnalyticTracker = friendshipAnalyticTracker;
        }
        int i3 = A + 101;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmName(name = "getProductPageManager")
    public final ProductPageManager getProductPageManager() {
        ProductPageManager productPageManager = this.productPageManager;
        Object[] objArr = null;
        if ((productPageManager != null ? '\n' : '%') != '\n') {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 9;
        A = i % 128;
        if (!(i % 2 == 0)) {
            int length = objArr.length;
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 93;
        A = i2 % 128;
        int i3 = i2 % 2;
        return productPageManager;
    }

    @JvmName(name = "setProductPageManager")
    public final void setProductPageManager(ProductPageManager productPageManager) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
        A = i % 128;
        if ((i % 2 != 0 ? (char) 0 : '\b') != 0) {
            Intrinsics.checkNotNullParameter(productPageManager, "");
            this.productPageManager = productPageManager;
            return;
        }
        Intrinsics.checkNotNullParameter(productPageManager, "");
        this.productPageManager = productPageManager;
        int i2 = 5 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x001b, code lost:
    
        if ((r0 != null ? ')' : 20) != ')') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0027, code lost:
    
        if ((r0 == null) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0029, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x002e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x002f, code lost:
    
        r1 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
        id.dana.myprofile.SettingMoreProfileActivity.A = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0039, code lost:
    
        r1 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
        id.dana.myprofile.SettingMoreProfileActivity.A = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0043, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0044, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0045, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "getDynamicUrlWrapper")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.data.dynamicurl.DynamicUrlWrapper getDynamicUrlWrapper() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 63
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L20
            id.dana.data.dynamicurl.DynamicUrlWrapper r0 = r4.dynamicUrlWrapper
            r1.hashCode()     // Catch: java.lang.Throwable -> L1e
            r2 = 41
            if (r0 == 0) goto L19
            r3 = 41
            goto L1b
        L19:
            r3 = 20
        L1b:
            if (r3 == r2) goto L2f
            goto L29
        L1e:
            r0 = move-exception
            throw r0
        L20:
            id.dana.data.dynamicurl.DynamicUrlWrapper r0 = r4.dynamicUrlWrapper
            if (r0 == 0) goto L26
            r2 = 0
            goto L27
        L26:
            r2 = 1
        L27:
            if (r2 == 0) goto L2f
        L29:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r1
        L2f:
            int r1 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r1 = r1 + 15
            int r2 = r1 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r2
            int r1 = r1 % 2
            int r1 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L44
            int r1 = r1 + 107
            int r2 = r1 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r2     // Catch: java.lang.Exception -> L44
            int r1 = r1 % 2
            return r0
        L44:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.getDynamicUrlWrapper():id.dana.data.dynamicurl.DynamicUrlWrapper");
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        int i = A + 13;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
            this.dynamicUrlWrapper = dynamicUrlWrapper;
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
            this.dynamicUrlWrapper = dynamicUrlWrapper;
            int i2 = 46 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getLogoutPresenter")
    public final LogoutContract.Presenter getLogoutPresenter() {
        LogoutContract.Presenter presenter = this.logoutPresenter;
        try {
            if (!(presenter == null)) {
                int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 99;
                A = i % 128;
                if ((i % 2 != 0 ? 'E' : 'V') != 'V') {
                    int i2 = 33 / 0;
                    return presenter;
                }
                return presenter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i3 = A + 121;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            boolean z = i3 % 2 != 0;
            Object[] objArr = null;
            if (z) {
                return null;
            }
            int length = objArr.length;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setLogoutPresenter")
    public final void setLogoutPresenter(LogoutContract.Presenter presenter) {
        int i = A + 13;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.logoutPresenter = presenter;
            int i2 = 48 / 0;
        } else {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.logoutPresenter = presenter;
        }
        int i3 = A + 115;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0020, code lost:
    
        if ((r0 != null ? '@' : '`') != '`') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0027, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0029, code lost:
    
        r2 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 + 11;
        id.dana.myprofile.SettingMoreProfileActivity.A = r2 % 128;
        r2 = r2 % 2;
        r2 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 + 119;
        id.dana.myprofile.SettingMoreProfileActivity.A = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003f, code lost:
    
        if ((r2 % 2) == 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0041, code lost:
    
        r2 = '8';
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0044, code lost:
    
        r2 = 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0046, code lost:
    
        if (r2 == 19) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0048, code lost:
    
        r1 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0049, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004d, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0052, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getChangePhoneNumberH5EventPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.h5event.ChangePhoneNumberH5EventContract.Presenter getChangePhoneNumberH5EventPresenter() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r0 = r0 + 81
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            r1 = 0
            if (r0 == 0) goto L25
            id.dana.h5event.ChangePhoneNumberH5EventContract$Presenter r0 = r4.changePhoneNumberH5EventPresenter
            r1.hashCode()     // Catch: java.lang.Throwable -> L23
            r2 = 96
            if (r0 == 0) goto L1e
            r3 = 64
            goto L20
        L1e:
            r3 = 96
        L20:
            if (r3 == r2) goto L4d
            goto L29
        L23:
            r0 = move-exception
            throw r0
        L25:
            id.dana.h5event.ChangePhoneNumberH5EventContract$Presenter r0 = r4.changePhoneNumberH5EventPresenter
            if (r0 == 0) goto L4d
        L29:
            int r2 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r2 = r2 + 11
            int r3 = r2 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r3
            int r2 = r2 % 2
            int r2 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r2 = r2 + 119
            int r3 = r2 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r3
            int r2 = r2 % 2
            r3 = 19
            if (r2 == 0) goto L44
            r2 = 56
            goto L46
        L44:
            r2 = 19
        L46:
            if (r2 == r3) goto L4c
            int r1 = r1.length     // Catch: java.lang.Throwable -> L4a
            return r0
        L4a:
            r0 = move-exception
            throw r0
        L4c:
            return r0
        L4d:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.getChangePhoneNumberH5EventPresenter():id.dana.h5event.ChangePhoneNumberH5EventContract$Presenter");
    }

    @JvmName(name = "setChangePhoneNumberH5EventPresenter")
    public final void setChangePhoneNumberH5EventPresenter(ChangePhoneNumberH5EventContract.Presenter presenter) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 49;
        A = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.changePhoneNumberH5EventPresenter = presenter;
        try {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 5;
            A = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getPaymentAuthListener")
    public final Listener getPaymentAuthListener() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 87;
        A = i % 128;
        int i2 = i % 2;
        Listener listener = this.paymentAuthListener;
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 47;
        A = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return listener;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return listener;
    }

    @JvmName(name = "setPaymentAuthListener")
    public final void setPaymentAuthListener(Listener listener) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 69;
            try {
                A = i % 128;
                int i2 = i % 2;
                this.paymentAuthListener = listener;
                int i3 = A + 11;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getFaceAuthListener")
    public final Listener getFaceAuthListener() {
        Listener listener;
        int i = A + 75;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? '6' : (char) 17) != 17) {
            try {
                listener = this.faceAuthListener;
                int i2 = 67 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            listener = this.faceAuthListener;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 45;
        A = i3 % 128;
        int i4 = i3 % 2;
        return listener;
    }

    @JvmName(name = "setFaceAuthListener")
    public final void setFaceAuthListener(Listener listener) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 19;
        A = i % 128;
        int i2 = i % 2;
        try {
            this.faceAuthListener = listener;
            int i3 = A + 93;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getAutoRouteListener")
    public final Listener getAutoRouteListener() {
        int i = A + 109;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        Listener listener = this.autoRouteListener;
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 33;
        A = i3 % 128;
        int i4 = i3 % 2;
        return listener;
    }

    @JvmName(name = "setAutoRouteListener")
    public final void setAutoRouteListener(Listener listener) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 43;
            try {
                A = i % 128;
                int i2 = i % 2;
                this.autoRouteListener = listener;
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 85;
                A = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "PrepareContext")
    private final LoadingDialog PrepareContext() {
        LoadingDialog loadingDialog;
        int i = A + 77;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? 'C' : '[') != 'C') {
            loadingDialog = (LoadingDialog) this.initRecordTimeStamp.getValue();
        } else {
            loadingDialog = (LoadingDialog) this.initRecordTimeStamp.getValue();
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = A + 27;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
        return loadingDialog;
    }

    @JvmName(name = "GetContactSyncConfig")
    private final SubMenuComponent GetContactSyncConfig() {
        int i = A + 13;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        SubMenuComponent subMenuComponent = (SubMenuComponent) this.PlaceComponentResult.getValue();
        try {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 67;
            A = i3 % 128;
            if ((i3 % 2 != 0 ? ')' : (char) 4) != ')') {
                return subMenuComponent;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return subMenuComponent;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getPhonePermission")
    public final ActivityPermissionRequest getPhonePermission() {
        ActivityPermissionRequest activityPermissionRequest;
        int i = A + 9;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? 'U' : '0') != '0') {
            try {
                activityPermissionRequest = this.phonePermission;
                int i2 = 94 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            activityPermissionRequest = this.phonePermission;
        }
        int i3 = A + 17;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
        return activityPermissionRequest;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        int i = A + 7;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda7();
        newProxyInstance();
        PlaceComponentResult();
        lookAheadTest();
        try {
            int i3 = A + 25;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        char[] cArr;
        char[] cArr2;
        int i;
        Object[] objArr;
        int i2 = A + 77;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        if (i2 % 2 == 0) {
            cArr = new char[]{0, 0, 0, 0};
            cArr2 = new char[]{42683, 28058, 35891, 38934};
            i = 93;
        } else {
            cArr = new char[]{0, 0, 0, 0};
            cArr2 = new char[]{42683, 28058, 35891, 38934};
            i = -33;
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 43;
        A = i3 % 128;
        int i4 = i3 % 2;
        try {
            Object[] objArr2 = new Object[1];
            c((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            c(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), objArr3);
            Object[] objArr4 = new Object[1];
            b(cArr, cArr2, i + ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion, (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 5772), new char[]{46315, 49998, 26068, 20089, 31537, 34282, 28539, 34073, 41437, 10061, 37779, 32614, 44186, 13143, 4617, 11775, 41146, 38484}, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            char[] cArr3 = {0, 0, 0, 0};
            char[] cArr4 = {1874, 62528, 41777, 59373};
            int gidForName = 838090758 - Process.getGidForName("");
            int i5 = BottomSheetCardBindingView$watcherCardNumberView$1 + 93;
            A = i5 % 128;
            int i6 = i5 % 2;
            try {
                Object[] objArr5 = new Object[1];
                c((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                Object[] objArr6 = new Object[1];
                c(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), objArr6);
                Object[] objArr7 = new Object[1];
                b(cArr3, cArr4, gidForName, (char) (((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 60802), new char[]{35740, 57586, 48854, 19289, 39266}, objArr7);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if ((intValue >= 99000 ? '6' : '!') != '6' || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        char[] cArr5 = {0, 0, 0, 0};
                        char[] cArr6 = {13037, 3019, 56888, 49979};
                        try {
                            Object[] objArr8 = new Object[1];
                            c((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr8);
                            Class<?> cls4 = Class.forName((String) objArr8[0]);
                            c(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), new Object[1]);
                            Object[] objArr9 = new Object[1];
                            b(cArr5, cArr6, ((ApplicationInfo) cls4.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.error_select_own_number).substring(10, 11).codePointAt(0) + 15294), new char[]{24945, 16491, 54604, 2910, 28507, 46413, 51949, 58096, 13200, 31238, 57842, 26517, 11105, 52953, 19317, 27917, 46076, 49709, 19947, 59254, 43911, 22494, 13800, 61989, 61709, 55112}, objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            b(new char[]{0, 0, 0, 0}, new char[]{43120, 31466, 7384, 62998}, super.getResources().getString(R.string.feed_sharing_activation_dialog_title).substring(1, 2).length() - 1, (char) (5660 - View.MeasureSpec.makeMeasureSpec(0, 0)), new char[]{62507, 28480, 4740, 'm', 6760, 37198, 39434, 21900, 15700, 7397, 9209, 46854, 65108, 51752, 11180, 425, 33596, 28129}, objArr10);
                            baseContext = (Context) cls5.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    if ((baseContext != null ? 'H' : '5') == 'H') {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr11 = new Object[1];
                            b(new char[]{0, 0, 0, 0}, new char[]{678, 16416, 54640, 49695}, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1, (char) Color.blue(0), new char[]{42336, 9086, 25991, 8440, 11162, 15843, 6163, 54524, 33389, 20629, 36383, 50033, 9567, 27181, 50408, 3908, 38534, 6130, 35665, 7973, 22992, 64209, 46937, 12749, 51180, 34422, 65399, 1777, 16308, 23847, 54166, 54908, 25353, 45027, 58083, 44163, 64180, 15240, 49389, 7289, 24260, 61720, 61631, 15560, 10005, 37706, 58603, 2254}, objArr11);
                            String str = (String) objArr11[0];
                            char[] cArr7 = {0, 0, 0, 0};
                            char[] cArr8 = {10450, 24441, 24335, 42287};
                            int i7 = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
                            A = i7 % 128;
                            int i8 = i7 % 2;
                            try {
                                Object[] objArr12 = new Object[1];
                                c((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr12);
                                Class<?> cls6 = Class.forName((String) objArr12[0]);
                                c(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), new Object[1]);
                                Object[] objArr13 = new Object[1];
                                b(cArr7, cArr8, ((ApplicationInfo) cls6.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), new char[]{49805, 34299, 60271, 48380, 5379, 60491, 50989, 42957, 38039, 44584, 26896, 51066, 54734, 55436, 58434, 22890, 549, 52607, 19426, 32657, 59509, 29132, 46999, 26886, 4498, 2379, 60373, 57193, 56093, 65290, 17172, 16389, 9956, 17709, 47717, 11651, 11072, 63060, 51137, 37872, 37088, 17973, 27508, 1973, 39535, 17174, 464, 6546, 21115, 38829, 61601, 693, 6199, 2376, 39699, 50295, 54518, 22770, 50469, 57188, 57041, 13670, 44526, 64969}, objArr13);
                                String str2 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                b(new char[]{0, 0, 0, 0}, new char[]{24916, 26239, 50885, 19157}, ViewConfiguration.getLongPressTimeout() >> 16, (char) ((-16777216) - Color.rgb(0, 0, 0)), new char[]{63404, 2617, 39053, 7384, 11077, 11725, 5743, 29768, 31782, 40292, 34616, 2007, 23396, 23273, 32234, 14736, 23654, 12124, 13482, 44703, 7648, 15407, 46078, 9373, 6817, 966, 55466, 8536, 2621, 61580, 2498, 57211, 9361, 64939, 37749, 11868, 11581, 9788, 32735, 4286, 53403, 35315, 52963, 19338, 15591, 10076, 45103, 30568, 22825, 43567, 60449, 39521, 41945, 34911, 31719, 44020, 5272, 14633, 53673, 32260, 40532, 36224, 21938, 27044}, objArr14);
                                String str3 = (String) objArr14[0];
                                char[] cArr9 = {0, 0, 0, 0};
                                char[] cArr10 = {5200, 4178, 34284, 13840};
                                try {
                                    Object[] objArr15 = new Object[1];
                                    c((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr15);
                                    Class<?> cls7 = Class.forName((String) objArr15[0]);
                                    c(PlaceComponentResult[25], PlaceComponentResult[56], (byte) (-PlaceComponentResult[5]), new Object[1]);
                                    Object[] objArr16 = new Object[1];
                                    b(cArr9, cArr10, ((ApplicationInfo) cls7.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(2) - 46), new char[]{52061, 10971, 64813, 43610, 39330, 16337, 18255, 17998, 30454, 13130, 22006, 10291, 11083, 25763, 63061, 34831, Typography.plusMinus, 40560, 21577, 22361, 38536, 54297, 51715, 13961, 49305, 36107, 4650, 31952, 18576, 16998, 26314, 5925, 58309, 36401, 5342, 32218, 48190, 44726, 12716, 26809, 57984, 39116, 41896, 9625, 40377, 43267, 15672, 23941, 29425, 1076, 64267, 3595, 3657, 64572, 28005, 36428, 64822, 8833, 31901, 57785}, objArr16);
                                    String str4 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    b(new char[]{0, 0, 0, 0}, new char[]{37417, 21757, 30084, 12230}, super.getResources().getString(R.string.risk_reject_suspicious_message).substring(24, 25).length() - 1, (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 50805), new char[]{27053, 61762, 43141, 17083, 2660, 42970}, objArr17);
                                    try {
                                        Object[] objArr18 = {baseContext, str, str2, str3, str4, true, (String) objArr17[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr18);
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
                    }
                }
                int i9 = A + 63;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i9 % 128;
                int i10 = i9 % 2;
                try {
                    Object[] objArr19 = new Object[1];
                    c(PlaceComponentResult[31], PlaceComponentResult[25], PlaceComponentResult[32], objArr19);
                    Class<?> cls8 = Class.forName((String) objArr19[0]);
                    byte b = (byte) (PlaceComponentResult[34] + 1);
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr20 = new Object[1];
                    c(b, b2, (byte) (b2 | 8), objArr20);
                    try {
                        Object[] objArr21 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - Process.getGidForName(""), (-16777212) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                            byte b3 = (byte) ($$a[47] - 1);
                            byte b4 = b3;
                            Object[] objArr22 = new Object[1];
                            g(b3, b4, b4, objArr22);
                            obj3 = cls9.getMethod((String) objArr22[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr23 = (Object[]) ((Method) obj3).invoke(null, objArr21);
                        int i11 = ((int[]) objArr23[1])[0];
                        if (((int[]) objArr23[0])[0] != i11) {
                            long j = ((r0 ^ i11) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr24 = {-1231363781, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr24);
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
                        super.onCreate(savedInstanceState);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        ProfileMenuFaceAuthViewHolder profileMenuFaceAuthViewHolder = this.getErrorConfigVersion;
        if ((profileMenuFaceAuthViewHolder != null ? (char) 24 : 'X') != 'X') {
            try {
                int i = A + 71;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                profileMenuFaceAuthViewHolder.dispose();
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 51;
                A = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        super.onDestroy();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        int i = A + 43;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        Context baseContext = getBaseContext();
        SettingModel settingModel = null;
        if (!(baseContext != null)) {
            Object[] objArr = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{13037, 3019, 56888, 49979}, super.getResources().getString(R.string.google_play).substring(1, 2).length() - 1, (char) (15326 - ExpandableListView.getPackedPositionGroup(0L)), new char[]{24945, 16491, 54604, 2910, 28507, 46413, 51949, 58096, 13200, 31238, 57842, 26517, 11105, 52953, 19317, 27917, 46076, 49709, 19947, 59254, 43911, 22494, 13800, 61989, 61709, 55112}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{43120, 31466, 7384, 62998}, getPackageName().codePointAt(6) - 97, (char) (View.resolveSizeAndState(0, 0, 0) + 5660), new char[]{62507, 28480, 4740, 'm', 6760, 37198, 39434, 21900, 15700, 7397, 9209, 46854, 65108, 51752, 11180, 425, 33596, 28129}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (!(baseContext == null)) {
            baseContext = baseContext.getApplicationContext();
        }
        if ((baseContext != null ? (char) 20 : '*') != '*') {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
        KClassImpl$Data$declaredNonStaticMembers$2();
        if (this.isLayoutRequested != null) {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 27;
            A = i3 % 128;
            int i4 = i3 % 2;
            if (!(!this.GetContactSyncConfig)) {
                SettingMoreContract.Presenter presenter = getPresenter();
                SettingModel settingModel2 = this.isLayoutRequested;
                if (settingModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    settingModel = settingModel2;
                }
                String collection = settingModel.getCollection();
                Intrinsics.checkNotNullExpressionValue(collection, "");
                presenter.KClassImpl$Data$declaredNonStaticMembers$2(collection);
            }
        }
        this.GetContactSyncConfig = true;
        getPresenter().PlaceComponentResult();
        getChangePhoneNumberH5EventPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            getPresenter().getAuthRequestContext();
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x004b, code lost:
    
        if (r1 != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0059, code lost:
    
        if ((r1.length() != 0) != false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r6 = this;
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            android.content.Intent r0 = r6.getIntent()
            java.lang.String r1 = "settingModel"
            android.os.Parcelable r0 = r0.getParcelableExtra(r1)
            id.dana.domain.profilemenu.model.SettingModel r0 = (id.dana.domain.profilemenu.model.SettingModel) r0
            r1 = 30
            if (r0 == 0) goto L1d
            r2 = 8
            goto L1f
        L1d:
            r2 = 30
        L1f:
            if (r2 == r1) goto L7d
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = r0.getCollection()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 58
            if (r1 == 0) goto L33
            r3 = 61
            goto L35
        L33:
            r3 = 58
        L35:
            r4 = 0
            r5 = 1
            if (r3 == r2) goto L5c
            int r2 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r2 = r2 + 75
            int r3 = r2 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L50
            int r1 = r1.length()
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L5c
            goto L5d
        L4e:
            r0 = move-exception
            throw r0
        L50:
            int r1 = r1.length()
            if (r1 == 0) goto L58
            r1 = 1
            goto L59
        L58:
            r1 = 0
        L59:
            if (r1 == 0) goto L5c
            goto L5d
        L5c:
            r4 = 1
        L5d:
            r1 = 78
            if (r4 == 0) goto L64
            r2 = 78
            goto L66
        L64:
            r2 = 93
        L66:
            if (r2 == r1) goto L69
            goto L6e
        L69:
            java.lang.String r1 = "setting_collection_settings"
            r0.setCollection(r1)
        L6e:
            r6.isLayoutRequested = r0
            java.lang.String r0 = r0.getTitle()
            r6.setTitle(r0)
            r0 = 2131232241(0x7f0805f1, float:1.8080586E38)
            r6.setMenuLeftButton(r0)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.KClassImpl$Data$declaredNonStaticMembers$2():void");
    }

    private final void PlaceComponentResult() {
        int i = A + 89;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        try {
            this.newProxyInstance = getIntent().getBooleanExtra(MyProfileBundleKey.HIGHLIGHT_AUTO_ROUTING_FEATURE, false);
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 85;
            A = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void lookAheadTest() {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 13;
            A = i % 128;
            if ((i % 2 != 0 ? (char) 25 : 'X') != 25) {
                getAuthRequestContext(getIntent().getBooleanExtra(MyProfileBundleKey.SHOW_ALWAYS_ASK_PIN_SUCCESS_DIALOG, false));
                return;
            }
            try {
                getAuthRequestContext(getIntent().getBooleanExtra(MyProfileBundleKey.SHOW_ALWAYS_ASK_PIN_SUCCESS_DIALOG, false));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0020, code lost:
    
        if (r7.length() >= 5) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x002b, code lost:
    
        if (r7.length() >= 3) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x002d, code lost:
    
        r0 = new java.lang.StringBuilder();
        r2 = r7.substring(0, 2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "");
        r0.append(r2);
        r0.append(id.dana.cashier.view.InputCardNumberView.DIVIDER);
        r0.append(getString(id.dana.R.string.hide_value_with_space));
        r0.append(id.dana.cashier.view.InputCardNumberView.DIVIDER);
        r7 = r7.substring(r7.length() - 4);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "");
        r0.append(r7);
        BuiltInFictitiousFunctionClassFactory(id.dana.data.profilemenu.MyProfileMenuAction.SETTING_CHANGE_MOBILE_NUMBER, r0.toString());
     */
    @Override // id.dana.myprofile.SettingMoreContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showPhoneNumber(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 78
            if (r0 != 0) goto L11
            r0 = 64
            goto L13
        L11:
            r0 = 78
        L13:
            r3 = 0
            java.lang.String r4 = ""
            if (r0 == r2) goto L23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r4)
            int r0 = r7.length()
            r2 = 5
            if (r0 < r2) goto L67
            goto L2d
        L23:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r4)
            int r0 = r7.length()
            r2 = 3
            if (r0 < r2) goto L67
        L2d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r7.substring(r3, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r0.append(r2)
            r2 = 32
            r0.append(r2)
            r5 = 2131954271(0x7f130a5f, float:1.9545037E38)
            java.lang.String r5 = r6.getString(r5)
            r0.append(r5)
            r0.append(r2)
            int r2 = r7.length()
            int r2 = r2 + (-4)
            java.lang.String r7 = r7.substring(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "setting_change_mobile_number"
            r6.BuiltInFictitiousFunctionClassFactory(r0, r7)
        L67:
            int r7 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r7 = r7 + 49
            int r0 = r7 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r0
            int r7 = r7 % r1
            if (r7 == 0) goto L73
            goto L74
        L73:
            r3 = 1
        L74:
            if (r3 == 0) goto L77
            return
        L77:
            r7 = 0
            int r7 = r7.length     // Catch: java.lang.Throwable -> L7a
            return
        L7a:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.showPhoneNumber(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x004c, code lost:
    
        if ((r3 == null) != true) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x005a, code lost:
    
        if ((r3 == null) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x005d, code lost:
    
        r4 = r3.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0064, code lost:
    
        if (r4 != 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0067, code lost:
    
        r4.setUsername(r7);
        r6.NetworkUserEntityData$$ExternalSyntheticLambda2.notifyItemChanged(r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [id.dana.domain.profilemenu.model.SettingModel] */
    /* JADX WARN: Type inference failed for: r4v6, types: [id.dana.domain.profilemenu.model.SettingModel] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showUsername(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r6.getPackageName()
            int r0 = r0.length()
            int r0 = r0 + (-7)
            r1 = 27
            char[] r1 = new char[r1]
            r1 = {x007a: FILL_ARRAY_DATA , data: [3416, 3371, -21681, -20740, -14435, -13243, 14264, 6761, -19524, 9806, -4314, 3787, 9117, -26103, -2436, 26126, 19262, -6845, -25188, 29089, 20583, -12887, -23263, 18637, 31118, -11243, 19524} // fill-array
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            a(r0, r1, r3)
            r0 = 0
            r1 = r3[r0]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r1.intern()
            int r1 = r6.getAuthRequestContext(r1)
            r3 = 89
            if (r1 < 0) goto L30
            r4 = 90
            goto L32
        L30:
            r4 = 89
        L32:
            if (r4 == r3) goto L6f
            int r3 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r3 = r3 + 3
            int r4 = r3 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r4
            int r3 = r3 % 2
            r4 = 0
            if (r3 != 0) goto L51
            id.dana.myprofile.adapter.MyProfileAdapter r3 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.util.List r3 = r3.getItems()
            int r5 = r4.length     // Catch: java.lang.Throwable -> L4f
            if (r3 == 0) goto L4b
            goto L4c
        L4b:
            r0 = 1
        L4c:
            if (r0 == r2) goto L64
            goto L5d
        L4f:
            r7 = move-exception
            throw r7
        L51:
            id.dana.myprofile.adapter.MyProfileAdapter r3 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.util.List r3 = r3.getItems()
            if (r3 == 0) goto L5a
            r2 = 0
        L5a:
            if (r2 == 0) goto L5d
            goto L64
        L5d:
            java.lang.Object r0 = r3.get(r1)
            r4 = r0
            id.dana.domain.profilemenu.model.SettingModel r4 = (id.dana.domain.profilemenu.model.SettingModel) r4
        L64:
            if (r4 != 0) goto L67
            return
        L67:
            r4.setUsername(r7)
            id.dana.myprofile.adapter.MyProfileAdapter r7 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2
            r7.notifyItemChanged(r1)
        L6f:
            int r7 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r7 = r7 + 43
            int r0 = r7 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r0
            int r7 = r7 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.showUsername(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0054, code lost:
    
        if ((r7.lookAheadTest) != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showNickname(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "setting_change_name"
            int r0 = r7.getAuthRequestContext(r0)
            r1 = 90
            if (r0 < 0) goto L12
            r2 = 43
            goto L14
        L12:
            r2 = 90
        L14:
            if (r2 == r1) goto L7b
            id.dana.myprofile.adapter.MyProfileAdapter r1 = r7.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.util.List r1 = r1.getItems()
            r2 = 2
            if (r1 == 0) goto L26
            java.lang.Object r1 = r1.get(r0)
            id.dana.domain.profilemenu.model.SettingModel r1 = (id.dana.domain.profilemenu.model.SettingModel) r1
            goto L30
        L26:
            r1 = 0
            int r3 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r3 = r3 + 67
            int r4 = r3 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r4
            int r3 = r3 % r2
        L30:
            if (r1 != 0) goto L33
            return
        L33:
            java.lang.String r3 = r7.DatabaseTableConfigUtil
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3b
            r6 = 1
            goto L3c
        L3b:
            r6 = 0
        L3c:
            if (r6 == 0) goto L65
            java.lang.String r6 = "KYC2"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r3)
            if (r3 == 0) goto L57
            int r3 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r3 = r3 + 91
            int r6 = r3 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r6
            int r3 = r3 % r2
            boolean r3 = r7.lookAheadTest
            if (r3 != 0) goto L54
            r4 = 0
        L54:
            if (r4 == 0) goto L57
            goto L65
        L57:
            r3 = 2131952792(0x7f130498, float:1.9542037E38)
            java.lang.String r3 = r7.getString(r3)
            r1.setTitle(r3)
            r1.setViewType(r2)
            goto L73
        L65:
            r2 = 2131952791(0x7f130497, float:1.9542035E38)
            java.lang.String r2 = r7.getString(r2)
            r1.setTitle(r2)
            r2 = 4
            r1.setViewType(r2)
        L73:
            r1.setSubtitle(r8)
            id.dana.myprofile.adapter.MyProfileAdapter r8 = r7.NetworkUserEntityData$$ExternalSyntheticLambda2
            r8.notifyItemChanged(r0)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.showNickname(java.lang.String):void");
    }

    public final void hideNickname() {
        int authRequestContext;
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 11;
            A = i % 128;
            if (!(i % 2 == 0)) {
                authRequestContext = getAuthRequestContext("setting_change_name");
                int i2 = 53 / 0;
                if (authRequestContext < 0) {
                    return;
                }
            } else {
                authRequestContext = getAuthRequestContext("setting_change_name");
                if ((authRequestContext >= 0 ? 'a' : '2') != 'a') {
                    return;
                }
            }
            MyProfileAdapter myProfileAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (myProfileAdapter.PlaceComponentResult(authRequestContext)) {
                return;
            }
            int i3 = A + 53;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
            myProfileAdapter.getItems().remove(authRequestContext);
            myProfileAdapter.notifyItemRemoved(authRequestContext);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void showAvatar(String r5) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 57;
            A = i % 128;
            int i2 = i % 2;
            int authRequestContext = getAuthRequestContext(MyProfileMenuAction.SETTING_CHANGE_PROFILE_PICTURE);
            if (!(authRequestContext >= 0)) {
                return;
            }
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 61;
            A = i3 % 128;
            if ((i3 % 2 != 0 ? 'c' : 'C') != 'C') {
                MyProfileAdapter myProfileAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                myProfileAdapter.getItems().get(authRequestContext).setAvatarUrl(r5);
                myProfileAdapter.notifyItemChanged(authRequestContext);
                int i4 = 76 / 0;
            } else {
                MyProfileAdapter myProfileAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                myProfileAdapter2.getItems().get(authRequestContext).setAvatarUrl(r5);
                myProfileAdapter2.notifyItemChanged(authRequestContext);
            }
            int i5 = A + 95;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
            int i6 = i5 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void showEmailAddress(String emailAddress) {
        try {
            int i = A + 19;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(emailAddress, "");
            if ((emailAddress.length() >= 3 ? '\t' : '0') != '\t') {
                return;
            }
            if (StringsKt.contains$default((CharSequence) emailAddress, (CharSequence) AUScreenAdaptTool.PREFIX_ID, false, 2, (Object) null) ? false : true) {
                return;
            }
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 65;
            A = i3 % 128;
            int i4 = i3 % 2;
            String PlaceComponentResult2 = TextUtil.PlaceComponentResult(this, emailAddress);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
            BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_CHANGE_EMAIL, PlaceComponentResult2);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void showEmailAddressUnset() {
        int i = A + 17;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 != 0)) {
            String string = getString(R.string.security_setting_email_unset);
            Intrinsics.checkNotNullExpressionValue(string, "");
            BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_CHANGE_EMAIL, string);
            Object obj = null;
            obj.hashCode();
            return;
        }
        String string2 = getString(R.string.security_setting_email_unset);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_CHANGE_EMAIL, string2);
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void showSecurityQuestionStateOn() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 81;
        A = i % 128;
        int i2 = i % 2;
        String string = getString(R.string.security_setting_question_state_on);
        Intrinsics.checkNotNullExpressionValue(string, "");
        BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_SECURITY_QUESTIONS, string);
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 87;
        A = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void showSecurityQuestionStateOff() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 75;
        A = i % 128;
        if (!(i % 2 == 0)) {
            String string = getString(R.string.security_setting_question_state_off);
            Intrinsics.checkNotNullExpressionValue(string, "");
            BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_SECURITY_QUESTIONS, string);
            Object obj = null;
            obj.hashCode();
            return;
        }
        String string2 = getString(R.string.security_setting_question_state_off);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_SECURITY_QUESTIONS, string2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x007b, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.next().getAction(), id.dana.data.profilemenu.MyProfileMenuAction.AUTO_ROUTING_SETTING_PARAM) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x007d, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x007f, code lost:
    
        r4 = r4 + 1;
        r5 = id.dana.myprofile.SettingMoreProfileActivity.A + 71;
        id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x008d, code lost:
    
        r0 = ((androidx.recyclerview.widget.RecyclerView) _$_findCachedViewById(id.dana.R.id.rv_sub_menu_profile_setting)).findViewHolderForLayoutPosition(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x009b, code lost:
    
        if ((r0 instanceof id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00a2, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
    
        return (id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0018, code lost:
    
        if (r0 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0029, code lost:
    
        if (r0 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x002d, code lost:
    
        r4 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 + 103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0031, code lost:
    
        id.dana.myprofile.SettingMoreProfileActivity.A = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0033, code lost:
    
        r4 = r4 % 2;
        r0 = r0.iterator();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x003a, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x003f, code lost:
    
        if (r0.hasNext() == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0041, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0043, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0044, code lost:
    
        if (r5 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0047, code lost:
    
        r5 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 + 7;
        id.dana.myprofile.SettingMoreProfileActivity.A = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0053, code lost:
    
        if ((r5 % 2) == 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0055, code lost:
    
        r5 = kotlin.jvm.internal.Intrinsics.areEqual(r0.next().getAction(), id.dana.data.profilemenu.MyProfileMenuAction.AUTO_ROUTING_SETTING_PARAM);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0063, code lost:
    
        r7 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0064, code lost:
    
        if (r5 == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0067, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0068, code lost:
    
        if (r6 == false) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder initRecordTimeStamp() {
        /*
            r8 = this;
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = -1
            r3 = 0
            if (r0 != 0) goto L23
            id.dana.myprofile.adapter.MyProfileAdapter r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L20
            java.util.List r0 = r0.getItems()     // Catch: java.lang.Exception -> L1d
            r4 = 37
            int r4 = r4 / r3
            if (r0 == 0) goto L8d
            goto L2b
        L1b:
            r0 = move-exception
            throw r0
        L1d:
            r0 = move-exception
            goto L8c
        L20:
            r0 = move-exception
            goto La1
        L23:
            id.dana.myprofile.adapter.MyProfileAdapter r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.util.List r0 = r0.getItems()
            if (r0 == 0) goto L8d
        L2b:
            int r4 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1     // Catch: java.lang.Exception -> L20
            int r4 = r4 + 103
            int r5 = r4 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r5     // Catch: java.lang.Exception -> L1d
            int r4 = r4 % 2
            java.util.Iterator r0 = r0.iterator()
            r4 = 0
        L3a:
            boolean r5 = r0.hasNext()
            r6 = 1
            if (r5 == 0) goto L43
            r5 = 0
            goto L44
        L43:
            r5 = 1
        L44:
            if (r5 == 0) goto L47
            goto L8d
        L47:
            int r5 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r5 = r5 + 7
            int r7 = r5 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r7
            int r5 = r5 % 2
            java.lang.String r7 = "setting_autoroute"
            if (r5 == 0) goto L6d
            java.lang.Object r5 = r0.next()
            id.dana.domain.profilemenu.model.SettingModel r5 = (id.dana.domain.profilemenu.model.SettingModel) r5
            java.lang.String r5 = r5.getAction()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r7)
            int r7 = r1.length     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L67
            goto L68
        L67:
            r6 = 0
        L68:
            if (r6 == 0) goto L7f
            goto L7d
        L6b:
            r0 = move-exception
            throw r0
        L6d:
            java.lang.Object r5 = r0.next()
            id.dana.domain.profilemenu.model.SettingModel r5 = (id.dana.domain.profilemenu.model.SettingModel) r5
            java.lang.String r5 = r5.getAction()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r7)
            if (r5 == 0) goto L7f
        L7d:
            r2 = r4
            goto L8d
        L7f:
            int r4 = r4 + 1
            int r5 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r5 = r5 + 71
            int r6 = r5 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r6
            int r5 = r5 % 2
            goto L3a
        L8c:
            throw r0
        L8d:
            int r0 = id.dana.R.id.rv_sub_menu_profile_setting
            android.view.View r0 = r8._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r0.findViewHolderForLayoutPosition(r2)
            boolean r2 = r0 instanceof id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder
            if (r2 == 0) goto La2
            r1 = r0
            id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder r1 = (id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder) r1     // Catch: java.lang.Exception -> L20
            goto La2
        La1:
            throw r0
        La2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.initRecordTimeStamp():id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder");
    }

    private final ProfileMenuFaceAuthViewHolder DatabaseTableConfigUtil() {
        int i = A + 17;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        List<SettingModel> items = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getItems();
        int i3 = -1;
        Object[] objArr = null;
        if (items != null) {
            try {
                int i4 = A + 25;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i4 % 128;
                if (i4 % 2 == 0) {
                }
                Iterator<SettingModel> it = items.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    int i6 = A + 33;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i6 % 128;
                    if (!(i6 % 2 != 0)) {
                        try {
                            boolean areEqual = Intrinsics.areEqual(it.next().getAction(), MyProfileMenuAction.SETTING_FACE_VERIFICATION);
                            int length = objArr.length;
                            if (areEqual) {
                                int i7 = BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
                                A = i7 % 128;
                                int i8 = i7 % 2;
                                i3 = i5;
                                break;
                            }
                            i5++;
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        if (!(!Intrinsics.areEqual(it.next().getAction(), MyProfileMenuAction.SETTING_FACE_VERIFICATION))) {
                            int i72 = BottomSheetCardBindingView$watcherCardNumberView$1 + 107;
                            A = i72 % 128;
                            int i82 = i72 % 2;
                            i3 = i5;
                            break;
                        }
                        i5++;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) _$_findCachedViewById(R.id.rv_sub_menu_profile_setting)).findViewHolderForLayoutPosition(i3);
        if (findViewHolderForLayoutPosition instanceof ProfileMenuFaceAuthViewHolder) {
            int i9 = BottomSheetCardBindingView$watcherCardNumberView$1 + 13;
            A = i9 % 128;
            if ((i9 % 2 != 0 ? '\f' : '\n') != '\f') {
                return (ProfileMenuFaceAuthViewHolder) findViewHolderForLayoutPosition;
            }
            ProfileMenuFaceAuthViewHolder profileMenuFaceAuthViewHolder = (ProfileMenuFaceAuthViewHolder) findViewHolderForLayoutPosition;
            objArr.hashCode();
            return profileMenuFaceAuthViewHolder;
        }
        return null;
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void setFaceLoginState(boolean isFaceLoginEnabled, boolean hasEnrolled, boolean isFaceLoginReady) {
        ProfileMenuFaceAuthViewHolder.EnrolmentState enrolmentState;
        getAuthRequestContext(isFaceLoginEnabled, hasEnrolled, isFaceLoginReady);
        ProfileMenuFaceAuthViewHolder DatabaseTableConfigUtil = DatabaseTableConfigUtil();
        if (DatabaseTableConfigUtil == null) {
            return;
        }
        try {
            this.getErrorConfigVersion = DatabaseTableConfigUtil;
            if ((hasEnrolled ? ':' : 'O') != 'O') {
                int i = A + 77;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                enrolmentState = ProfileMenuFaceAuthViewHolder.EnrolmentState.ENROLLED;
            } else {
                enrolmentState = ProfileMenuFaceAuthViewHolder.EnrolmentState.NOT_ENROLLED;
                try {
                    int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 7;
                    A = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            DatabaseTableConfigUtil.getAuthRequestContext(enrolmentState);
            DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2 = isFaceLoginEnabled;
            ((BlueSwitchView) DatabaseTableConfigUtil.itemView.findViewById(R.id.sv_enable_face_auth)).setChecked(isFaceLoginEnabled);
            ProfileMenuFaceAuthViewHolder.CheckedListener checkedListener = new ProfileMenuFaceAuthViewHolder.CheckedListener() { // from class: id.dana.myprofile.SettingMoreProfileActivity$setFaceLoginState$1
                @Override // id.dana.myprofile.viewholder.ProfileMenuFaceAuthViewHolder.CheckedListener
                public final void MyBillsEntityDataFactory() {
                    SettingMoreProfileActivity.this.getPresenter().getErrorConfigVersion();
                }
            };
            Intrinsics.checkNotNullParameter(checkedListener, "");
            DatabaseTableConfigUtil.MyBillsEntityDataFactory = checkedListener;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void getAuthRequestContext(boolean p0, boolean p1, boolean p2) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 61;
            try {
                A = i % 128;
                if (!(i % 2 != 0)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = Boolean.valueOf(p0);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Boolean.valueOf(p1);
                    this.MyBillsEntityDataFactory = Boolean.valueOf(p2);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = Boolean.valueOf(p0);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Boolean.valueOf(p1);
                this.MyBillsEntityDataFactory = Boolean.valueOf(p2);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 37;
        A = i % 128;
        int i2 = i % 2;
        try {
            SettingMoreProfileActivity settingMoreProfileActivity = this;
            Toast.makeText(settingMoreProfileActivity, ErrorUtil.BuiltInFictitiousFunctionClassFactory(settingMoreProfileActivity), 0).show();
            int i3 = A + 97;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void onGetUserInfoFailed() {
        int i = A + 83;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        ProfileMenuFaceAuthViewHolder DatabaseTableConfigUtil = DatabaseTableConfigUtil();
        if (DatabaseTableConfigUtil == null) {
            return;
        }
        DatabaseTableConfigUtil.getAuthRequestContext(ProfileMenuFaceAuthViewHolder.EnrolmentState.ERROR_FETCH);
        int i3 = A + 77;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        LoadingDialog PrepareContext = PrepareContext();
        if ((!PrepareContext.BuiltInFictitiousFunctionClassFactory.isShowing() ? 'N' : '0') != '0') {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 35;
            A = i % 128;
            try {
                if (i % 2 != 0) {
                    PrepareContext.BuiltInFictitiousFunctionClassFactory.show();
                    Object obj = null;
                    obj.hashCode();
                } else {
                    PrepareContext.BuiltInFictitiousFunctionClassFactory.show();
                }
            } catch (Exception unused) {
                return;
            }
        }
        int i2 = A + 31;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        try {
            int i = A + 111;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                if (i % 2 != 0) {
                    PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2();
                } else {
                    PrepareContext().KClassImpl$Data$declaredNonStaticMembers$2();
                    Object obj = null;
                    obj.hashCode();
                }
                int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
                A = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void onUserKycInfo(String r5, boolean kycCertified) {
        int i = A + 15;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? (char) 17 : Typography.less) != '<') {
            this.lookAheadTest = kycCertified;
            String string = getString(PlaceComponentResult(r5));
            Intrinsics.checkNotNullExpressionValue(string, "");
            BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_ACCOUNT_TYPE, string);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            this.lookAheadTest = kycCertified;
            String string2 = getString(PlaceComponentResult(r5));
            Intrinsics.checkNotNullExpressionValue(string2, "");
            BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_ACCOUNT_TYPE, string2);
        }
        try {
            int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 93;
            A = i2 % 128;
            if ((i2 % 2 != 0 ? '/' : 'L') != '/') {
                return;
            }
            int i3 = 5 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void onGetSettingCollectionSuccess(List<? extends SettingModel> settings) {
        int i = A + 83;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? 'F' : 'B') != 'F') {
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.setItems(settings);
                getPresenter().MyBillsEntityDataFactory();
                getPresenter().BuiltInFictitiousFunctionClassFactory();
                onUserKycInfo(this.DatabaseTableConfigUtil, this.lookAheadTest);
                whenAvailable();
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setItems(settings);
            getPresenter().MyBillsEntityDataFactory();
            getPresenter().BuiltInFictitiousFunctionClassFactory();
            onUserKycInfo(this.DatabaseTableConfigUtil, this.lookAheadTest);
            whenAvailable();
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 21;
        A = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void onGetAutoSwitchInitialState(boolean isVisible, boolean isSwitchActive, String authenticationType) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 117;
        A = i % 128;
        int i2 = i % 2;
        int authRequestContext = getAuthRequestContext(MyProfileMenuAction.AUTO_ROUTING_SETTING_PARAM);
        if (authRequestContext >= 0) {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 91;
            A = i3 % 128;
            int i4 = i3 % 2;
            try {
                MyProfileAdapter myProfileAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                try {
                    myProfileAdapter.getItems().get(authRequestContext).setAutoRouteSwitch(isSwitchActive);
                    myProfileAdapter.getItems().get(authRequestContext).setNeedToShow(isVisible);
                    myProfileAdapter.getItems().get(authRequestContext).setAutoRouteAuthenticationType(authenticationType);
                    myProfileAdapter.notifyItemChanged(authRequestContext);
                    if (!(!isVisible)) {
                        NetworkUserEntityData$$ExternalSyntheticLambda0();
                        int i5 = A + 75;
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
                        int i6 = i5 % 2;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x001b, code lost:
    
        if (r4.moveToNextValue != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0030, code lost:
    
        if ((r4.moveToNextValue ? 'H' : '4') != 'H') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0033, code lost:
    
        ((androidx.recyclerview.widget.RecyclerView) _$_findCachedViewById(id.dana.R.id.rv_sub_menu_profile_setting)).scrollToPosition(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r3 = "setting_autoroute"
            if (r0 == r1) goto L1e
            int r0 = r4.getAuthRequestContext(r3)
            boolean r1 = r4.moveToNextValue
            if (r1 == 0) goto L3e
            goto L33
        L1e:
            int r0 = r4.getAuthRequestContext(r3)
            boolean r1 = r4.moveToNextValue
            r3 = 22
            int r3 = r3 / r2
            r2 = 72
            if (r1 == 0) goto L2e
            r1 = 72
            goto L30
        L2e:
            r1 = 52
        L30:
            if (r1 == r2) goto L33
            goto L3e
        L33:
            int r1 = id.dana.R.id.rv_sub_menu_profile_setting
            android.view.View r1 = r4._$_findCachedViewById(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            r1.scrollToPosition(r0)
        L3e:
            boolean r1 = r4.newProxyInstance
            if (r1 == 0) goto L69
            android.view.View r1 = r4.getErrorConfigVersion()
            if (r1 != 0) goto L66
            int r1 = id.dana.R.id.rv_sub_menu_profile_setting
            android.view.View r1 = r4._$_findCachedViewById(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            id.dana.myprofile.SettingMoreProfileActivity$checkToShowAutoRoutingHighlight$1 r2 = new id.dana.myprofile.SettingMoreProfileActivity$checkToShowAutoRoutingHighlight$1
            r2.<init>()
            androidx.recyclerview.widget.RecyclerView$OnScrollListener r2 = (androidx.recyclerview.widget.RecyclerView.OnScrollListener) r2
            r1.addOnScrollListener(r2)
            int r1 = id.dana.R.id.rv_sub_menu_profile_setting
            android.view.View r1 = r4._$_findCachedViewById(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            r1.scrollToPosition(r0)
            return
        L66:
            r4.PlaceComponentResult(r0, r1)
        L69:
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 49
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L7a
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L78
            return
        L78:
            r0 = move-exception
            throw r0
        L7a:
            return
        L7b:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda0():void");
    }

    private final View getErrorConfigVersion() {
        View view;
        ProfileMenuAutoSwitchViewHolder initRecordTimeStamp = initRecordTimeStamp();
        if (!(initRecordTimeStamp == null) && (view = initRecordTimeStamp.itemView) != null) {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 57;
            A = i % 128;
            int i2 = i % 2;
            View findViewById = view.findViewById(R.id.f4574view_autoroute_switch);
            if ((findViewById != null ? 'A' : '?') != '?') {
                return findViewById;
            }
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 55;
        A = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 44 / 0;
            return null;
        }
        return null;
    }

    private final void PlaceComponentResult(final int p0, final View p1) {
        int i = A + 15;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 == 0) {
            int i2 = 46 / 0;
            if (p1 == null) {
                return;
            }
        } else {
            if (!(p1 != null)) {
                return;
            }
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 5;
        A = i3 % 128;
        boolean z = i3 % 2 == 0;
        Showcase showcase = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (!z) {
            int i4 = 98 / 0;
            if (showcase != null) {
                return;
            }
        } else if (showcase != null) {
            return;
        }
        try {
            this.newProxyInstance = false;
            p1.post(new Runnable() { // from class: id.dana.myprofile.SettingMoreProfileActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SettingMoreProfileActivity.$r8$lambda$Y0tXzMRrgG3pCYENyiRc8E82qFo(SettingMoreProfileActivity.this, p1, p0);
                }
            });
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void PlaceComponentResult(final SettingMoreProfileActivity settingMoreProfileActivity, View view, int i) {
        Intrinsics.checkNotNullParameter(settingMoreProfileActivity, "");
        SectionShowcaseBuilder sectionShowcaseBuilder = new SectionShowcaseBuilder(settingMoreProfileActivity, view);
        RecyclerView recyclerView = (RecyclerView) settingMoreProfileActivity._$_findCachedViewById(R.id.rv_sub_menu_profile_setting);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        Intrinsics.checkNotNullParameter(recyclerView, "");
        sectionShowcaseBuilder.PlaceComponentResult = recyclerView;
        sectionShowcaseBuilder.BuiltInFictitiousFunctionClassFactory = i;
        sectionShowcaseBuilder.MyBillsEntityDataFactory = true;
        settingMoreProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 = sectionShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.myprofile.SettingMoreProfileActivity$showAutoSwitchTooltip$1$1
            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
            public final void onFinished(int p0) {
                SettingMoreProfileActivity.access$setShowcase$p(SettingMoreProfileActivity.this, null);
                SettingMoreProfileActivity.access$setShowcaseShowing$p(SettingMoreProfileActivity.this, false);
            }
        }).BuiltInFictitiousFunctionClassFactory();
        settingMoreProfileActivity.moveToNextValue = true;
        int i2 = A + 45;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void toggleShareFeedConsentSuccess(SettingModel r4) {
        int i = A + 117;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? '\n' : 'G') != '\n') {
            try {
                Intrinsics.checkNotNullParameter(r4, "");
                getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(r4.isShareFeed());
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(r4, "");
        getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(r4.isShareFeed());
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void showErrorToast() {
        int i = A + 81;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        showToast(getString(R.string.SchedulerPoolFactory));
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 45;
        A = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void showTrustedDevice() {
        int i = A + 77;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 == 0) {
            BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_TWILLIO_ENROLLMENT, NetworkUserEntityData$$ExternalSyntheticLambda1());
            int i2 = 62 / 0;
        } else {
            BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_TWILLIO_ENROLLMENT, NetworkUserEntityData$$ExternalSyntheticLambda1());
        }
        int i3 = A + 81;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void showTrustedDeviceUnset() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 87;
        A = i % 128;
        int i2 = i % 2;
        String string = getString(R.string.security_setting_twilio_set);
        Intrinsics.checkNotNullExpressionValue(string, "");
        BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.SETTING_TWILLIO_ENROLLMENT, string);
        int i3 = A + 95;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void onAlreadyEnrolled() {
        int i = A + 95;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        SubSequence();
        try {
            int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 103;
            A = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void onUnenrolled() {
        int i = A + 71;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 != 0) {
            readMicros();
            return;
        }
        readMicros();
        Object obj = null;
        obj.hashCode();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.LOGOUT;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.Property.LOGOUT_TYPE, p0);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
        int i = A + 111;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.myprofile.SettingMoreContract.View
    public final void toggleShareFeedConsentFailed(SettingModel r4) {
        int authRequestContext;
        int i = A + 99;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(r4, "");
            getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(r4.isShareFeed());
            authRequestContext = getAuthRequestContext(MyProfileMenuAction.SHARE_FEED);
            if (authRequestContext < 0) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(r4, "");
            getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(r4.isShareFeed());
            authRequestContext = getAuthRequestContext(MyProfileMenuAction.SHARE_FEED);
            Object obj = null;
            obj.hashCode();
            if (authRequestContext < 0) {
                return;
            }
        }
        MyProfileAdapter myProfileAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        myProfileAdapter.getItems().get(authRequestContext).setShareFeed(r4.isShareFeed());
        myProfileAdapter.notifyItemChanged(authRequestContext);
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 21;
        A = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        int i = A + 5;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        boolean z = i % 2 != 0;
        int authRequestContext = getAuthRequestContext(p0);
        if (!z) {
            int i2 = 73 / 0;
            if ((authRequestContext >= 0 ? (char) 2 : Typography.less) == '<') {
                return;
            }
        } else {
            if (authRequestContext < 0) {
                return;
            }
        }
        int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 5;
        A = i3 % 128;
        if ((i3 % 2 != 0 ? Typography.less : (char) 23) != '<') {
            MyProfileAdapter myProfileAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            myProfileAdapter.getItems().get(authRequestContext).setSubtitle(p1);
            myProfileAdapter.notifyItemChanged(authRequestContext, RVParams.LONG_SUB_TITLE);
            return;
        }
        MyProfileAdapter myProfileAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        myProfileAdapter2.getItems().get(authRequestContext).setSubtitle(p1);
        myProfileAdapter2.notifyItemChanged(authRequestContext, RVParams.LONG_SUB_TITLE);
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final int PlaceComponentResult(String p0) {
        int i = A + 69;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
        this.DatabaseTableConfigUtil = p0;
        if (NetworkUserEntityData$$ExternalSyntheticLambda2()) {
            int i3 = A + 19;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            int i4 = i3 % 2;
            return R.string.dana_premium;
        }
        return R.string.dana_user;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda2")
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 57;
        A = i % 128;
        int i2 = i % 2;
        String str = this.DatabaseTableConfigUtil;
        if (str != null) {
            if ((!Intrinsics.areEqual("KYC0", str) ? '\b' : 'V') == '\b') {
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
                A = i3 % 128;
                int i4 = i3 % 2;
                return true;
            }
        }
        try {
            int i5 = BottomSheetCardBindingView$watcherCardNumberView$1 + 119;
            A = i5 % 128;
            int i6 = i5 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    private static String MyBillsEntityDataFactory(Intent p0) {
        String str = null;
        if (p0 != null) {
            int i = A + 103;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            Bundle extras = p0.getExtras();
            if ((extras != null ? '3' : ']') == '3') {
                int i3 = A + 77;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    str = extras.getString(ChallengeControl.Key.CANCEL_REASON);
                } else {
                    String string = extras.getString(ChallengeControl.Key.CANCEL_REASON);
                    str.hashCode();
                    str = string;
                }
            }
        }
        return (str == null ? (char) 23 : 'R') != 'R' ? "" : str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r5, int resultCode, Intent data) {
        String stringExtra;
        super.onActivityResult(r5, resultCode, data);
        try {
            if (r5 == 1001) {
                if (resultCode == -1) {
                    Listener listener = this.paymentAuthListener;
                    if ((listener != null ? 'K' : (char) 23) != 23) {
                        listener.KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    }
                    return;
                }
                Listener listener2 = this.paymentAuthListener;
                if (listener2 != null) {
                    listener2.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory(data));
                    return;
                }
                return;
            }
            boolean z = false;
            if (r5 == 1002) {
                int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 73;
                A = i % 128;
                int i2 = i % 2;
                if (resultCode == -1) {
                    Listener listener3 = this.faceAuthListener;
                    if (listener3 == null) {
                        z = true;
                    }
                    if (!z) {
                        listener3.KClassImpl$Data$declaredNonStaticMembers$2();
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    Listener listener4 = this.faceAuthListener;
                    if (listener4 != null) {
                        int i3 = A + 17;
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                        int i4 = i3 % 2;
                        listener4.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory(data));
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                getPresenter().PlaceComponentResult();
            } else if (r5 == 1006) {
                getAuthRequestContext(resultCode, data);
            } else if (r5 == 2001) {
                int i5 = BottomSheetCardBindingView$watcherCardNumberView$1 + 15;
                A = i5 % 128;
                if (i5 % 2 == 0) {
                    MyBillsEntityDataFactory(resultCode);
                    return;
                }
                MyBillsEntityDataFactory(resultCode);
                int i6 = 60 / 0;
            } else {
                if ((r5 == 1007 ? '\\' : 'D') != '\\') {
                    try {
                        if (r5 == getErrorConfigVersion) {
                            getAuthRequestContext(resultCode);
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } else if (resultCode == -1) {
                    if ((data != null ? Typography.greater : 'I') != '>') {
                        stringExtra = null;
                    } else {
                        int i7 = A + 99;
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i7 % 128;
                        int i8 = i7 % 2;
                        stringExtra = data.getStringExtra("accountDeactivationResult");
                    }
                    if (stringExtra == null) {
                        int i9 = A + 77;
                        BottomSheetCardBindingView$watcherCardNumberView$1 = i9 % 128;
                        int i10 = i9 % 2;
                        stringExtra = "";
                    }
                    BuiltInFictitiousFunctionClassFactory(stringExtra);
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 65;
        A = i % 128;
        if (i % 2 != 0) {
            try {
                GetContactSyncConfig().KClassImpl$Data$declaredNonStaticMembers$2(this);
                try {
                    AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[5];
                    abstractPresenterArr[0] = getPresenter();
                    abstractPresenterArr[0] = getChangePhoneNumberH5EventPresenter();
                    registerPresenter(abstractPresenterArr);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            GetContactSyncConfig().KClassImpl$Data$declaredNonStaticMembers$2(this);
            registerPresenter(getPresenter(), getChangePhoneNumberH5EventPresenter());
        }
        int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 67;
        A = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        int i3 = 95 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0029, code lost:
    
        if ((r3 == null) != true) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0031, code lost:
    
        if (r3 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0033, code lost:
    
        r4 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 + 47;
        id.dana.myprofile.SettingMoreProfileActivity.A = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x003d, code lost:
    
        if ((r4 % 2) == 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x003f, code lost:
    
        r4 = 'H';
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0042, code lost:
    
        r4 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0044, code lost:
    
        r3.KClassImpl$Data$declaredNonStaticMembers$2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0047, code lost:
    
        if (r4 == 'H') goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x004a, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x004b, code lost:
    
        r3 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x004c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(int r3, android.content.Intent r4) {
        /*
            r2 = this;
            r0 = -1
            r1 = 72
            if (r3 != r0) goto L8
            r3 = 30
            goto La
        L8:
            r3 = 72
        La:
            if (r3 == r1) goto L51
            int r3 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r3 = r3 + 5
            int r4 = r3 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r4
            int r3 = r3 % 2
            r4 = 24
            if (r3 == 0) goto L1d
            r3 = 24
            goto L1f
        L1d:
            r3 = 33
        L1f:
            r0 = 0
            if (r3 == r4) goto L2c
            id.dana.myprofile.SettingMoreProfileActivity$Listener r3 = r2.autoRouteListener
            r4 = 1
            if (r3 == 0) goto L28
            goto L29
        L28:
            r0 = 1
        L29:
            if (r0 == r4) goto L66
            goto L33
        L2c:
            id.dana.myprofile.SettingMoreProfileActivity$Listener r3 = r2.autoRouteListener
            r4 = 62
            int r4 = r4 / r0
            if (r3 == 0) goto L66
        L33:
            int r4 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r4 = r4 + 47
            int r0 = r4 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r0
            int r4 = r4 % 2
            if (r4 == 0) goto L42
            r4 = 72
            goto L44
        L42:
            r4 = 15
        L44:
            r3.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r4 == r1) goto L4a
            return
        L4a:
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L4d
            return
        L4d:
            r3 = move-exception
            throw r3
        L4f:
            r3 = move-exception
            throw r3
        L51:
            id.dana.myprofile.SettingMoreProfileActivity$Listener r3 = r2.autoRouteListener
            if (r3 == 0) goto L66
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r1
            int r0 = r0 % 2
            java.lang.String r4 = MyBillsEntityDataFactory(r4)
            r3.BuiltInFictitiousFunctionClassFactory(r4)
        L66:
            int r3 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r3 = r3 + 99
            int r4 = r3 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r4
            int r3 = r3 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.getAuthRequestContext(int, android.content.Intent):void");
    }

    private final void getAuthRequestContext(int p0) {
        int i = A + 125;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            if (p0 != -1) {
                return;
            }
        } else if (p0 != -1) {
            return;
        }
        Intent intent = new Intent(this, HomeTabActivity.class);
        intent.putExtra("target", "friends");
        intent.putExtra("Source", FeedsSourceType.FEED_SETTINGS);
        intent.setFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
        startActivity(intent);
        finish();
        int i2 = A + 99;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void newProxyInstance() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.myprofile.SettingMoreProfileActivity$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                SettingMoreProfileActivity.m2691$r8$lambda$2jjPnG_TmmCNSqGdQDqKyvmOFE(SettingMoreProfileActivity.this, i);
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_sub_menu_profile_setting);
        if (recyclerView != null) {
            Object[] objArr = null;
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            recyclerView.setNestedScrollingEnabled(false);
            ProfileDividerItemDecoration profileDividerItemDecoration = new ProfileDividerItemDecoration(recyclerView.getContext());
            Drawable PlaceComponentResult2 = ContextCompat.PlaceComponentResult(recyclerView.getContext(), (int) R.drawable.divider_drawable);
            if (PlaceComponentResult2 == null) {
                int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 51;
                A = i % 128;
                if (i % 2 == 0) {
                    return;
                }
                int length = objArr.length;
                return;
            }
            if (!(PlaceComponentResult2 != null)) {
                throw new IllegalArgumentException("Drawable cannot be null.");
            }
            int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 77;
            A = i2 % 128;
            int i3 = i2 % 2;
            profileDividerItemDecoration.MyBillsEntityDataFactory = PlaceComponentResult2;
            recyclerView.addItemDecoration(profileDividerItemDecoration);
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.myprofile.SettingMoreProfileActivity$$ExternalSyntheticLambda2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    SettingMoreProfileActivity.$r8$lambda$6focC4705Tiy7ajQfhERitZUqjc(SettingMoreProfileActivity.this);
                }
            });
        }
    }

    private static final void MyBillsEntityDataFactory(SettingMoreProfileActivity settingMoreProfileActivity, int i) {
        Intrinsics.checkNotNullParameter(settingMoreProfileActivity, "");
        SettingModel item = settingMoreProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda2.getItem(i);
        if (item != null) {
            String action = item.getAction();
            if (!(action == null)) {
                int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 65;
                A = i2 % 128;
                int i3 = i2 % 2;
                switch (action.hashCode()) {
                    case -1942416943:
                        if (action.equals(MyProfileMenuAction.PAYMENT_AUTHENTICATION)) {
                            return;
                        }
                        break;
                    case -1051859947:
                        if ((action.equals(MyProfileMenuAction.SETTING_ACCOUNT_DEACTIVATE) ? '5' : InputCardNumberView.DIVIDER) != ' ') {
                            settingMoreProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda6();
                            return;
                        }
                        break;
                    case -1019381144:
                        if (action.equals(MyProfileMenuAction.SETTING_TWILLIO_ENROLLMENT)) {
                            settingMoreProfileActivity.moveToNextValue();
                            return;
                        }
                        break;
                    case -719054499:
                        if (action.equals(MyProfileMenuAction.SETTING_SECURITY_QUESTIONS)) {
                            int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 93;
                            A = i4 % 128;
                            int i5 = i4 % 2;
                            settingMoreProfileActivity.getSupportButtonTintMode();
                            return;
                        }
                        break;
                    case -576998321:
                        if (action.equals(MyProfileMenuAction.SETTING_SECURITY)) {
                            int i6 = A + 111;
                            BottomSheetCardBindingView$watcherCardNumberView$1 = i6 % 128;
                            int i7 = i6 % 2;
                            settingMoreProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda5();
                            return;
                        }
                        break;
                    case -35919189:
                        if (action.equals("setting_merchant_management")) {
                            settingMoreProfileActivity.startActivity(new Intent(settingMoreProfileActivity, MerchantManagementActivity.class));
                            return;
                        }
                        break;
                    case 315215690:
                        Object[] objArr = new Object[1];
                        a((-1) - MotionEvent.axisFromString(""), new char[]{3416, 3371, 43855, 44796, 51101, 52293, 14264, 6761, 46012, 9806, 61222, 3787, 9117, 39433, 63100, 26126, 19262, 58691, 40348, 29089, 20583, 52649, 42273, 18637, 31118, 54293, 19524}, objArr);
                        if ((action.equals(((String) objArr[0]).intern()) ? 'a' : 'U') == 'a') {
                            settingMoreProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda3();
                            int i8 = BottomSheetCardBindingView$watcherCardNumberView$1 + 11;
                            A = i8 % 128;
                            if (i8 % 2 != 0) {
                                Object obj = null;
                                obj.hashCode();
                                return;
                            }
                            return;
                        }
                        break;
                    case 487954253:
                        if (action.equals(MyProfileMenuAction.SHARE_FEED)) {
                            return;
                        }
                        break;
                    case 948354699:
                        if (action.equals(MyProfileMenuAction.SETTING_RESTRICTED_CONTACT)) {
                            settingMoreProfileActivity.NetworkUserEntityData$$ExternalSyntheticLambda4();
                            return;
                        }
                        break;
                    case 1350426073:
                        if (action.equals(MyProfileMenuAction.CHANGE_PROFILE_PICTURE)) {
                            settingMoreProfileActivity.FragmentBottomSheetPaymentSettingBinding();
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
            String redirectUrl = item.getRedirectUrl();
            if (redirectUrl == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(redirectUrl, "");
            settingMoreProfileActivity.MyBillsEntityDataFactory(redirectUrl);
        }
    }

    private static final void PlaceComponentResult(SettingMoreProfileActivity settingMoreProfileActivity) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 77;
        A = i % 128;
        if ((i % 2 != 0 ? '\r' : 'X') != 'X') {
            Intrinsics.checkNotNullParameter(settingMoreProfileActivity, "");
            settingMoreProfileActivity.scheduleImpl();
            int i2 = 72 / 0;
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(settingMoreProfileActivity, "");
            settingMoreProfileActivity.scheduleImpl();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void scheduleImpl() {
        Boolean bool;
        boolean z;
        if (DatabaseTableConfigUtil() != null) {
            int i = A + 113;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            boolean z2 = false;
            if (i % 2 == 0) {
                bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Object[] objArr = null;
                int length = objArr.length;
                if (bool == null) {
                    return;
                }
            } else {
                bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (bool == null) {
                    return;
                }
            }
            try {
                if ((this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null ? '5' : '\'') == '5' && this.MyBillsEntityDataFactory != null) {
                    int i2 = BottomSheetCardBindingView$watcherCardNumberView$1 + 23;
                    A = i2 % 128;
                    int i3 = i2 % 2;
                    if (bool != null) {
                        int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 95;
                        A = i4 % 128;
                        int i5 = i4 % 2;
                        z = bool.booleanValue();
                    } else {
                        z = false;
                    }
                    Boolean bool2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    boolean booleanValue = !(bool2 == null) ? bool2.booleanValue() : false;
                    Boolean bool3 = this.MyBillsEntityDataFactory;
                    if (bool3 != null) {
                        z2 = bool3.booleanValue();
                        int i6 = BottomSheetCardBindingView$watcherCardNumberView$1 + 113;
                        A = i6 % 128;
                        int i7 = i6 % 2;
                    }
                    setFaceLoginState(z, booleanValue, z2);
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        startActivity(new Intent(this, RestrictedContactActivity.class));
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
        A = i % 128;
        if ((i % 2 != 0 ? 'V' : 'H') != 'H') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        int i = A + 51;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            if (!p0) {
                return;
            }
        } else {
            if (!(p0)) {
                return;
            }
        }
        getLogoutPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        int i2 = A + 1;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
        int i3 = i2 % 2;
    }

    private final void FragmentBottomSheetPaymentSettingBinding() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 103;
        A = i % 128;
        int i2 = i % 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.check();
        try {
            int i3 = A + 35;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
            if (i3 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void MyBillsEntityDataFactory(String p0) {
        String authRequestContext = UrlUtil.getAuthRequestContext(p0);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.myprofile.SettingMoreProfileActivity$openH5Container$$inlined$withDanaH5Callback$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p02) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p02) {
                SettingMoreProfileActivity.this.getPresenter().PlaceComponentResult();
            }
        });
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 117;
        A = i % 128;
        int i2 = i % 2;
    }

    private final int getAuthRequestContext(String p0) {
        List<SettingModel> items = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getItems();
        Object[] objArr = null;
        int i = -1;
        if ((items != null ? '\r' : (char) 20) != 20) {
            Iterator<SettingModel> it = items.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(it.next().getName(), p0)) {
                    int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 125;
                    A = i3 % 128;
                    if (i3 % 2 != 0) {
                        objArr.hashCode();
                    }
                    i = i2;
                } else {
                    i2++;
                    int i4 = A + 107;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i4 % 128;
                    int i5 = i4 % 2;
                }
            }
        }
        int i6 = A + 35;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i6 % 128;
        if ((i6 % 2 == 0 ? '5' : '\r') != '\r') {
            int length = objArr.length;
            return i;
        }
        return i;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        int i = A + 77;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if (i % 2 != 0) {
            String kycFromProfileUrl = getDynamicUrlWrapper().getKycFromProfileUrl();
            Intrinsics.checkNotNullExpressionValue(kycFromProfileUrl, "");
            ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(getProductPageManager(), this, kycFromProfileUrl);
        } else {
            String kycFromProfileUrl2 = getDynamicUrlWrapper().getKycFromProfileUrl();
            Intrinsics.checkNotNullExpressionValue(kycFromProfileUrl2, "");
            ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(getProductPageManager(), this, kycFromProfileUrl2);
            int i2 = 54 / 0;
        }
        int i3 = A + 13;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void getSupportButtonTintMode() {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 25;
            A = i % 128;
            if (!(i % 2 != 0)) {
                try {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
                    ProductPageManagerExtKt.BuiltInFictitiousFunctionClassFactory(getProductPageManager(), this);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
                ProductPageManagerExtKt.BuiltInFictitiousFunctionClassFactory(getProductPageManager(), this);
            }
            int i2 = A + 17;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            if ((i2 % 2 == 0 ? 'P' : 'b') != 'b') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void getAuthRequestContext(boolean p0) {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 111;
        A = i % 128;
        int i2 = i % 2;
        if (p0) {
            CustomDialog.Builder builder = new CustomDialog.Builder(this);
            builder.SubSequence = getString(R.string.payment_setting_always_ask_pin_dialog_title);
            builder.GetContactSyncConfig = getString(R.string.payment_setting_always_ask_pin_dialog_message);
            CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
            PlaceComponentResult2.moveToNextValue = 0L;
            MaterialDialog BuiltInFictitiousFunctionClassFactory = PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2), new Function1<View, Unit>() { // from class: id.dana.myprofile.SettingMoreProfileActivity$checkShowAlwaysAskPinSuccessDalog$1
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
                    MaterialDialog access$getAlwaysAskPinSuccessDialog$p = SettingMoreProfileActivity.access$getAlwaysAskPinSuccessDialog$p(SettingMoreProfileActivity.this);
                    if (access$getAlwaysAskPinSuccessDialog$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        access$getAlwaysAskPinSuccessDialog$p = null;
                    }
                    access$getAlwaysAskPinSuccessDialog$p.dismiss();
                }
            }).BuiltInFictitiousFunctionClassFactory();
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
            Object obj = null;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                int i3 = A + 63;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                if (i3 % 2 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    obj.hashCode();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                BuiltInFictitiousFunctionClassFactory = null;
            }
            BuiltInFictitiousFunctionClassFactory.show();
            int i4 = BottomSheetCardBindingView$watcherCardNumberView$1 + 105;
            A = i4 % 128;
            int i5 = i4 % 2;
        }
    }

    private static String NetworkUserEntityData$$ExternalSyntheticLambda1() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(Build.MANUFACTURER);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(Build.MODEL);
            String obj = sb.toString();
            int i = A + 97;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void moveToNextValue() {
        try {
            int i = A + 63;
            try {
                BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
                int i2 = i % 2;
                getPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                int i3 = BottomSheetCardBindingView$watcherCardNumberView$1 + 71;
                A = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void readMicros() {
        int i = A + 1;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        if ((i % 2 == 0 ? 'V' : 'R') != 'V') {
            TwilioIntroductionActivity.Companion companion = TwilioIntroductionActivity.INSTANCE;
            startActivity(TwilioIntroductionActivity.Companion.getAuthRequestContext(this, TwilioIntroductionActivity.SETTING_PAGE, ""));
        } else {
            TwilioIntroductionActivity.Companion companion2 = TwilioIntroductionActivity.INSTANCE;
            startActivity(TwilioIntroductionActivity.Companion.getAuthRequestContext(this, TwilioIntroductionActivity.SETTING_PAGE, ""));
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = A + 33;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void SubSequence() {
        try {
            startActivity(new Intent(this, TrustedDeviceActivity.class));
            int i = A + 47;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        try {
            startActivity(new Intent(this, ChangeUsernameActivity.class));
            int i = A + 41;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            if ((i % 2 == 0 ? 'J' : '=') != '=') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        try {
            startActivityForResult(new Intent(this, AccountDeactivationActivity.class), 1007);
            int i = A + 81;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            if ((i % 2 == 0 ? 'I' : 'U') != 'U') {
                int i2 = 7 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0019, code lost:
    
        if (r0 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0022, code lost:
    
        if (isTaskRoot() != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0024, code lost:
    
        r0 = new android.content.Intent(r4, id.dana.animation.HomeTabActivity.class).addFlags(335544320);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        startActivity(r0);
        finish();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x003f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0040, code lost:
    
        super.onBackPressed();
        r0 = id.dana.myprofile.SettingMoreProfileActivity.A + 63;
        id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x004d, code lost:
    
        if ((r0 % 2) != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0050, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0051, code lost:
    
        if (r1 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0055, code lost:
    
        r0 = 64 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0059, code lost:
    
        return;
     */
    @Override // androidx.view.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onBackPressed() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 23
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L1e
            boolean r0 = r4.isTaskRoot()
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L40
            goto L24
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            boolean r0 = r4.isTaskRoot()
            if (r0 == 0) goto L40
        L24:
            android.content.Intent r0 = new android.content.Intent
            r1 = r4
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<id.dana.home.HomeTabActivity> r2 = id.dana.animation.HomeTabActivity.class
            r0.<init>(r1, r2)
            r1 = 335544320(0x14000000, float:6.4623485E-27)
            android.content.Intent r0 = r0.addFlags(r1)
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r4.startActivity(r0)
            r4.finish()
            return
        L40:
            super.onBackPressed()
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r0 = r0 + 63
            int r3 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L50
            goto L51
        L50:
            r1 = 0
        L51:
            if (r1 == 0) goto L59
            r0 = 64
            int r0 = r0 / r2
            return
        L57:
            r0 = move-exception
            throw r0
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.onBackPressed():void");
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0) {
        SettingMoreProfileActivity settingMoreProfileActivity;
        int i;
        int i2;
        int i3;
        long j;
        int i4;
        int i5 = A + 43;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
        if ((i5 % 2 == 0 ? 'X' : 'c') != 'X') {
            BorderedToastUtil borderedToastUtil = BorderedToastUtil.MyBillsEntityDataFactory;
            settingMoreProfileActivity = this;
            i = R.drawable.success;
            i2 = R.color.f23922131099979;
            i3 = 48;
            j = TOAST_DURATION;
            i4 = 3;
        } else {
            BorderedToastUtil borderedToastUtil2 = BorderedToastUtil.MyBillsEntityDataFactory;
            settingMoreProfileActivity = this;
            i = R.drawable.success;
            i2 = R.color.f23922131099979;
            i3 = 102;
            j = TOAST_DURATION;
            i4 = 5;
        }
        BorderedToastUtil.MyBillsEntityDataFactory(settingMoreProfileActivity, i, i2, p0, i3, j, i4);
        int i6 = BottomSheetCardBindingView$watcherCardNumberView$1 + 65;
        A = i6 % 128;
        if (!(i6 % 2 != 0)) {
            return;
        }
        int i7 = 29 / 0;
    }

    private final boolean isLayoutRequested() {
        int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 57;
        A = i % 128;
        return !(i % 2 == 0) ? getIntent().getBooleanExtra(MyProfileBundleKey.FROM_FEEDS_SETTING_ICON, true) : getIntent().getBooleanExtra(MyProfileBundleKey.FROM_FEEDS_SETTING_ICON, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0029, code lost:
    
        if (r1 != null) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void whenAvailable() {
        /*
            r4 = this;
            java.lang.String r0 = "setting_feed_sharing"
            int r0 = r4.getAuthRequestContext(r0)     // Catch: java.lang.Exception -> L69
            r1 = 0
            if (r0 < 0) goto Lb
            r2 = 1
            goto Lc
        Lb:
            r2 = 0
        Lc:
            if (r2 == 0) goto L68
            int r2 = id.dana.myprofile.SettingMoreProfileActivity.A
            int r2 = r2 + 21
            int r3 = r2 % 128
            id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1 = r3
            int r2 = r2 % 2
            r3 = 90
            if (r2 != 0) goto L1f
            r2 = 90
            goto L21
        L1f:
            r2 = 49
        L21:
            if (r2 == r3) goto L2c
            id.dana.myprofile.adapter.MyProfileAdapter r1 = r4.NetworkUserEntityData$$ExternalSyntheticLambda2
            java.util.List r1 = r1.getItems()
            if (r1 == 0) goto L49
            goto L38
        L2c:
            id.dana.myprofile.adapter.MyProfileAdapter r2 = r4.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L66
            java.util.List r2 = r2.getItems()     // Catch: java.lang.Exception -> L66
            r3 = 40
            int r3 = r3 / r1
            if (r2 == 0) goto L49
            r1 = r2
        L38:
            int r2 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r2 = r2 + 67
            int r3 = r2 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r3
            int r2 = r2 % 2
            java.lang.Object r1 = r1.get(r0)
            id.dana.domain.profilemenu.model.SettingModel r1 = (id.dana.domain.profilemenu.model.SettingModel) r1
            goto L4a
        L49:
            r1 = 0
        L4a:
            if (r1 != 0) goto L4d
            return
        L4d:
            boolean r2 = r4.isLayoutRequested()
            r1.setFromFeeds(r2)
            id.dana.myprofile.adapter.MyProfileAdapter r1 = r4.NetworkUserEntityData$$ExternalSyntheticLambda2
            r1.notifyItemChanged(r0)
            int r0 = id.dana.myprofile.SettingMoreProfileActivity.BottomSheetCardBindingView$watcherCardNumberView$1
            int r0 = r0 + 51
            int r1 = r0 % 128
            id.dana.myprofile.SettingMoreProfileActivity.A = r1
            int r0 = r0 % 2
            goto L68
        L64:
            r0 = move-exception
            throw r0
        L66:
            r0 = move-exception
            throw r0
        L68:
            return
        L69:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.SettingMoreProfileActivity.whenAvailable():void");
    }

    private final ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda8() {
        String[] strArr;
        if ((OSUtil.MyBillsEntityDataFactory() ? 'L' : '[') != '[') {
            int i = A + 27;
            BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
            int i2 = i % 2;
            try {
                strArr = new String[]{"android.permission.CAMERA"};
                int i3 = A + 91;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                strArr = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
            } catch (Exception e2) {
                throw e2;
            }
        }
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr2);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.myprofile.SettingMoreProfileActivity$initPermission$1
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
                    SettingMoreProfileActivity.access$getHandPicked$p(SettingMoreProfileActivity.this).getAuthRequestContext();
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        return builder.PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004"}, d2 = {"Lid/dana/myprofile/SettingMoreProfileActivity$Companion;", "", "", "AUTO_ROUTE_BOTTOM_SHEET_REQUEST_CODE", "I", "", "PARAM_USERNAME_SUCCESS", "Ljava/lang/String;", "getErrorConfigVersion", "BuiltInFictitiousFunctionClassFactory", "()I", "MyBillsEntityDataFactory", "", "TOAST_DURATION", "J", "TOAST_MAX_TEXT_LINES", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public static int BuiltInFictitiousFunctionClassFactory() {
            return SettingMoreProfileActivity.access$getREQUEST_CODE_PRIVACY_SETTING$cp();
        }
    }

    static {
        BottomSheetCardBindingView$watcherCardNumberView$1 = 1;
        BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult = new byte[]{97, -108, 86, -98, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        getAuthRequestContext = 218;
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        getErrorConfigVersion = RandomInteger.BuiltInFictitiousFunctionClassFactory();
        int i = A + 73;
        BottomSheetCardBindingView$watcherCardNumberView$1 = i % 128;
        int i2 = i % 2;
    }

    private final void MyBillsEntityDataFactory(int p0) {
        try {
            int i = BottomSheetCardBindingView$watcherCardNumberView$1 + 57;
            A = i % 128;
            int i2 = i % 2;
            this.GetContactSyncConfig = false;
            if (!(p0 != -1)) {
                int i3 = A + 111;
                BottomSheetCardBindingView$watcherCardNumberView$1 = i3 % 128;
                int i4 = i3 % 2;
                ProfileMenuAutoSwitchViewHolder initRecordTimeStamp = initRecordTimeStamp();
                if ((initRecordTimeStamp != null ? (char) 31 : '.') != '.') {
                    int i5 = A + 51;
                    BottomSheetCardBindingView$watcherCardNumberView$1 = i5 % 128;
                    if ((i5 % 2 == 0 ? '^' : '#') != '^') {
                        initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.onProceedSwitchOn();
                        return;
                    }
                    initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2.onProceedSwitchOn();
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                }
                return;
            }
            ProfileMenuAutoSwitchViewHolder initRecordTimeStamp2 = initRecordTimeStamp();
            if (initRecordTimeStamp2 != null) {
                int i6 = BottomSheetCardBindingView$watcherCardNumberView$1 + 55;
                A = i6 % 128;
                int i7 = i6 % 2;
                initRecordTimeStamp2.KClassImpl$Data$declaredNonStaticMembers$2.revertChecked();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void b(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if (!(e.KClassImpl$Data$declaredNonStaticMembers$2 >= length3)) {
                int i2 = $10 + 79;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (readMicros ^ 4360990799332652212L)) ^ ((int) (C ^ 4360990799332652212L))) ^ ((char) (VerifyPinStateManager$executeRiskChallenge$2$1 ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                int i6 = $10 + 13;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        try {
            char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(B ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            while (true) {
                if (!(d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length)) {
                    break;
                }
                try {
                    int i2 = $11 + 25;
                    $10 = i2 % 128;
                    int i3 = i2 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (B ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            String str = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
            int i4 = $11 + 41;
            $10 = i4 % 128;
            if (!(i4 % 2 != 0)) {
                objArr[0] = str;
                return;
            }
            int i5 = 95 / 0;
            objArr[0] = str;
        } catch (Exception e2) {
            throw e2;
        }
    }
}
