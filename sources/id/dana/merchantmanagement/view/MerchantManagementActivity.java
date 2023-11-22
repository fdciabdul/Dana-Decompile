package id.dana.merchantmanagement.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.challenge.ChallengeControl;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.ActivityMerchantManagementBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantManagementComponent;
import id.dana.di.modules.MerchantManagementModule;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.merchantmanagement.MerchantManagementContract;
import id.dana.merchantmanagement.adapter.LinkedMerchantClickListener;
import id.dana.merchantmanagement.adapter.MerchantManagementAdapter;
import id.dana.merchantmanagement.model.LinkedMerchantModel;
import id.dana.merchantmanagement.model.UnbindMerchantModel;
import id.dana.merchantmanagement.view.richview.ErrorLinkedMerchantListView;
import id.dana.merchantmanagement.view.viewholder.BannerViewHolder;
import id.dana.model.CdpContentModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.danah5.DanaH5Listener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 g2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001gB\u0007¢\u0006\u0004\bf\u0010\fJ!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ/\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\fJ\u000f\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010\fJ\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\fJ\u000f\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010\fJ\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\fJ\u001f\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010.\u001a\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016¢\u0006\u0004\b.\u0010/J%\u00102\u001a\u00020\b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020&0+2\u0006\u00101\u001a\u00020\u0017H\u0016¢\u0006\u0004\b2\u00103J%\u00104\u001a\u00020\b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020&0+2\u0006\u00101\u001a\u00020\u0017H\u0016¢\u0006\u0004\b4\u00103J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0017H\u0002¢\u0006\u0004\b9\u0010:J\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0012\u0010;JG\u0010A\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0017H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\bH\u0016¢\u0006\u0004\bC\u0010\fJ\u000f\u0010D\u001a\u00020\bH\u0016¢\u0006\u0004\bD\u0010\fJ#\u0010E\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00172\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u00109\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u000fH\u0002¢\u0006\u0004\b9\u0010 R\u0016\u00109\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010\u0012\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010E\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bU\u0010RR\u0016\u0010A\u001a\u00020V8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010TR\u0018\u0010H\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010Q\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\be\u0010R"}, d2 = {"Lid/dana/merchantmanagement/view/MerchantManagementActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityMerchantManagementBinding;", "Lid/dana/merchantmanagement/MerchantManagementContract$View;", "Landroid/view/View;", "p0", "", "p1", "", "getAuthRequestContext", "(Landroid/view/View;Z)V", "configToolbar", "()V", "dismissProgress", "dismissShimmerItem", "", "p2", "Lid/dana/tracker/EventTrackerModel;", "MyBillsEntityDataFactory", "(ZLjava/lang/String;Ljava/lang/String;)Lid/dana/tracker/EventTrackerModel;", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityMerchantManagementBinding;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onErrorCheckUnbindEligibility", "onErrorGetMerchantList", "onErrorGetMoreMerchantList", "onErrorUnbindConsult", "onLinkedMerchantEmpty", "Lid/dana/merchantmanagement/model/LinkedMerchantModel;", "linkedMerchantModel", "unbindEligibilityCheckId", "onSuccessCheckUnbindEligibility", "(Lid/dana/merchantmanagement/model/LinkedMerchantModel;Ljava/lang/String;)V", "", "Lid/dana/model/CdpContentModel;", "list", "onSuccessGetBannerList", "(Ljava/util/List;)V", "linkedMerchants", "totalPageNumber", "onSuccessGetMerchantList", "(Ljava/util/List;I)V", "onSuccessGetMoreMerchantList", "Lid/dana/merchantmanagement/model/UnbindMerchantModel;", "unbindMerchantModel", "onSuccessUnbindConsult", "(Lid/dana/merchantmanagement/model/UnbindMerchantModel;)V", "PlaceComponentResult", "(I)V", "(II)Z", "p3", "Landroid/view/View$OnClickListener;", "p4", "p5", "p6", "BuiltInFictitiousFunctionClassFactory", "(IIIILandroid/view/View$OnClickListener;II)V", "showProgress", "showShimmerItem", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;)V", "Lid/dana/merchantmanagement/adapter/MerchantManagementAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/merchantmanagement/adapter/MerchantManagementAdapter;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "lookAheadTest", "I", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "DatabaseTableConfigUtil", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lid/dana/merchantmanagement/MerchantManagementContract$Presenter;", "presenter", "Lid/dana/merchantmanagement/MerchantManagementContract$Presenter;", "getPresenter", "()Lid/dana/merchantmanagement/MerchantManagementContract$Presenter;", "setPresenter", "(Lid/dana/merchantmanagement/MerchantManagementContract$Presenter;)V", "initRecordTimeStamp", "getErrorConfigVersion", "Lcom/ethanhua/skeleton/SkeletonScreen;", "GetContactSyncConfig", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PrepareContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantManagementActivity extends ViewBindingActivity<ActivityMerchantManagementBinding> implements MerchantManagementContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
    public static final int SHIMMER_DURATION = 1500;
    private static char isLayoutRequested;
    private static char newProxyInstance;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private ActivityPermissionRequest BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private SkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private MerchantManagementAdapter PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private int lookAheadTest;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;
    @Inject
    public MerchantManagementContract.Presenter presenter;
    public static final byte[] $$a = {15, -40, -114, -21, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 47;
    public static final byte[] PlaceComponentResult = {Ascii.ETB, -59, 18, 83, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = WheelView.DIVIDER_ALPHA;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 1;

    public static /* synthetic */ void $r8$lambda$HrQ0GBQSn8vzsoxivZIykmVQZxY(View view) {
    }

    public static /* synthetic */ void $r8$lambda$NM7rovIUEq30HOw2i2uLY5A1ZIs(View view) {
    }

    public static /* synthetic */ void $r8$lambda$ORap5VtYE1pZ6OA60RucKHcKwfQ(View view) {
    }

    public static /* synthetic */ void $r8$lambda$u1ERhwBskqja81PyhkeVMRCDBCM(View view) {
    }

    public static /* synthetic */ void $r8$lambda$yLoexdMZC6lIFrEnOKA6ZI2uvUM(View view) {
    }

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        newProxyInstance = (char) 18378;
        isLayoutRequested = (char) 33838;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = (char) 36204;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = (char) 20879;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0025 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = 106 - r9
            int r8 = r8 + 16
            int r7 = r7 + 4
            byte[] r0 = id.dana.merchantmanagement.view.MerchantManagementActivity.PlaceComponentResult
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r9 = r8
            r3 = r1
            r4 = 0
            r8 = r7
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2e
        L15:
            r3 = 0
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L25:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2e:
            int r9 = r9 + r7
            int r9 = r9 + (-4)
            int r7 = r8 + 1
            r8 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.merchantmanagement.view.MerchantManagementActivity.a(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r7 = r7 + 4
            byte[] r0 = id.dana.merchantmanagement.view.MerchantManagementActivity.$$a
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r7 = r7 + 1
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.merchantmanagement.view.MerchantManagementActivity.c(short, int, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void openMerchantManagementActivity(Context context) {
        Companion.getAuthRequestContext(context);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{30275, 3673, 6991, 43078, 53222, 21108, 11493, 4049, 2026, 24910, 52650, 40077, 19504, 379, 3232, 52965, 42725, 16015}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(5 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{33375, 24748, 38561, 51344, 51924, 43845}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(48 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{48923, 22645, 15185, 65488, 12110, 12156, 49864, 5282, 14824, 56252, 62290, 26276, 41319, 27423, 18733, 45781, 46800, 42992, 34329, 24549, 31922, 61186, 42512, 49809, 32861, 11334, 64161, 58842, 54561, 6847, 15168, 35907, 29784, 3421, 30119, 50941, 31712, 11172, 34457, 31819, 27981, 52349, 51393, 49678, 54589, 45272, 56863, 51332}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(TextUtils.lastIndexOf("", '0', 0) + 65, new char[]{8314, 14524, 51874, 60536, 31712, 11172, 23630, 54501, 31922, 61186, 7993, 16770, 1455, 9301, 58882, 24215, 1800, 11350, 20576, 27119, 1455, 9301, 29504, 29244, 23876, 27806, 39046, 42476, 64161, 58842, 1800, 11350, 34189, 26620, 35575, 12429, 50812, 34740, 27527, 3315, 60673, 56647, 46257, 6997, 195, 29216, 34892, 20219, 6886, 56885, 53734, 1524, 31743, 38724, 13988, 31699, 13988, 31699, 26404, 58629, 18105, 6164, 32861, 11334}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(64 - KeyEvent.getDeadChar(0, 0), new char[]{30009, 33353, 11549, 20980, 31743, 38724, 43407, 58295, 7578, 50385, 27401, 30163, 61004, 10560, 20505, 44719, 15168, 35907, 64102, 53087, 61574, 44904, 45680, 55141, 27981, 52349, 49864, 5282, 5658, 12200, 48923, 22645, 52984, 39186, 43297, 16532, 30583, 65017, 15185, 65488, 24193, 20284, 58882, 24215, 34457, 31819, 31300, 35475, 31712, 11172, 3232, 52965, 30009, 33353, 50928, 56917, 48415, 48569, 29784, 3421, 50928, 56917, 20353, 37572}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((Process.myPid() >> 22) + 60, new char[]{50871, 40056, 27114, 13842, 36411, 57162, 62681, 63480, 22014, 53369, 42265, 59880, 30708, 47441, 59853, 43794, 35841, 34510, 50441, 48644, 60079, 34867, 38787, 63675, 46658, 56576, 26281, 48952, 35781, 59708, 8007, 14253, 26281, 48952, 5434, 39443, 61383, 4341, 61480, 54055, 5155, 50924, 571, 58817, 34650, 37914, 18270, 32266, 62185, 62447, 24398, 33887, 39315, 14022, 50010, 5454, 10494, 48639, 54300, 39942}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(6 - KeyEvent.getDeadChar(0, 0), new char[]{43157, 61788, 56809, 3542, 30009, 33353}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                a((byte) 37, b, b, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[7], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.MeasureSpec.getSize(0), TextUtils.indexOf("", "", 0, 0) + 3, (char) Color.blue(0));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), (byte) ($$a[47] - 1), $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 14 - ExpandableListView.getPackedPositionChild(0L), (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 14, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.lastIndexOf("", '0'), View.resolveSize(0, 0) + 29, (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 800, 15 - Color.blue(0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), 35 - View.resolveSize(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {562737707, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = PlaceComponentResult[25];
                Object[] objArr19 = new Object[1];
                a((byte) 37, b2, b2, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[7], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 62, MotionEvent.axisFromString("") + 47, (char) (ViewConfiguration.getTapTimeout() >> 16));
                        byte b3 = (byte) ($$a[47] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b3, (byte) (b3 | Ascii.ETB), (byte) ($$a[47] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.getDeadChar(0, 0) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {562737707, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
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
                byte b4 = PlaceComponentResult[25];
                Object[] objArr25 = new Object[1];
                a((byte) 37, b4, b4, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[7], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 118, View.MeasureSpec.getMode(0) + 3, (char) (38967 - TextUtils.lastIndexOf("", '0', 0)));
                        byte b5 = (byte) ($$a[47] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b5, (byte) (b5 | Ascii.ETB), (byte) ($$a[47] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {562737707, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
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
                byte b6 = PlaceComponentResult[25];
                Object[] objArr31 = new Object[1];
                a((byte) 37, b6, b6, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[7], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 107, Drawable.resolveOpacity(0, 0) + 3, (char) (Process.getGidForName("") + 1));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[53]), (byte) (-$$a[8]), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myPid() >> 22) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {562737707, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), KeyEvent.getDeadChar(0, 0) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        b((-16777198) - Color.rgb(0, 0, 0), new char[]{30275, 3673, 6991, 43078, 53222, 21108, 11493, 4049, 2026, 24910, 52650, 40077, 19504, 379, 3232, 52965, 42725, 16015}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        b(5 - Color.alpha(0), new char[]{33375, 24748, 38561, 51344, 51924, 43845}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                b(super.getResources().getString(R.string.my_bills_hint_card_number).substring(3, 4).length() + 25, new char[]{30275, 3673, 6991, 43078, 53222, 21108, 11493, 4049, 5155, 50924, 10988, 3515, 30510, 10230, 25101, 40827, 28164, 58157, 50938, 26350, 37712, 4557, 42272, 1614, 63858, 46052}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(super.getResources().getString(R.string.paylater_checkout_additional_info_installment_selection).substring(4, 5).codePointAt(0) - 79, new char[]{48250, 2236, 40784, 43682, 10494, 48639, 44847, 8497, 14324, 38947, 14248, 33796, 13582, 62890, 25101, 40827, 58193, 52676}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    b(super.getResources().getString(R.string.tooltip_highlight_description_saving_goal).substring(13, 14).length() + 47, new char[]{48923, 22645, 15185, 65488, 12110, 12156, 49864, 5282, 14824, 56252, 62290, 26276, 41319, 27423, 18733, 45781, 46800, 42992, 34329, 24549, 31922, 61186, 42512, 49809, 32861, 11334, 64161, 58842, 54561, 6847, 15168, 35907, 29784, 3421, 30119, 50941, 31712, 11172, 34457, 31819, 27981, 52349, 51393, 49678, 54589, 45272, 56863, 51332}, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    b((ViewConfiguration.getLongPressTimeout() >> 16) + 64, new char[]{8314, 14524, 51874, 60536, 31712, 11172, 23630, 54501, 31922, 61186, 7993, 16770, 1455, 9301, 58882, 24215, 1800, 11350, 20576, 27119, 1455, 9301, 29504, 29244, 23876, 27806, 39046, 42476, 64161, 58842, 1800, 11350, 34189, 26620, 35575, 12429, 50812, 34740, 27527, 3315, 60673, 56647, 46257, 6997, 195, 29216, 34892, 20219, 6886, 56885, 53734, 1524, 31743, 38724, 13988, 31699, 13988, 31699, 26404, 58629, 18105, 6164, 32861, 11334}, objArr6);
                    String str2 = (String) objArr6[0];
                    try {
                        Object[] objArr7 = new Object[1];
                        a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[32], objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[56], PlaceComponentResult[13], objArr8);
                        Object[] objArr9 = new Object[1];
                        b(((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{30009, 33353, 11549, 20980, 31743, 38724, 43407, 58295, 7578, 50385, 27401, 30163, 61004, 10560, 20505, 44719, 15168, 35907, 64102, 53087, 61574, 44904, 45680, 55141, 27981, 52349, 49864, 5282, 5658, 12200, 48923, 22645, 52984, 39186, 43297, 16532, 30583, 65017, 15185, 65488, 24193, 20284, 58882, 24215, 34457, 31819, 31300, 35475, 31712, 11172, 3232, 52965, 30009, 33353, 50928, 56917, 48415, 48569, 29784, 3421, 50928, 56917, 20353, 37572}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(60 - KeyEvent.normalizeMetaState(0), new char[]{50871, 40056, 27114, 13842, 36411, 57162, 62681, 63480, 22014, 53369, 42265, 59880, 30708, 47441, 59853, 43794, 35841, 34510, 50441, 48644, 60079, 34867, 38787, 63675, 46658, 56576, 26281, 48952, 35781, 59708, 8007, 14253, 26281, 48952, 5434, 39443, 61383, 4341, 61480, 54055, 5155, 50924, 571, 58817, 34650, 37914, 18270, 32266, 62185, 62447, 24398, 33887, 39315, 14022, 50010, 5454, 10494, 48639, 54300, 39942}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(7 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{43157, 61788, 56809, 3542, 30009, 33353}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, ExpandableListView.getPackedPositionType(0L) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr13 = new Object[1];
            a((byte) 37, b, b, objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            Object[] objArr14 = new Object[1];
            a(PlaceComponentResult[35], PlaceComponentResult[25], PlaceComponentResult[7], objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 494, 5 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L));
                    Object[] objArr16 = new Object[1];
                    c((byte) (-$$a[9]), (byte) (-$$a[53]), (byte) (-$$a[8]), objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), TextUtils.getCapsMode("", 0, 0) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr18 = {1958638080, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - KeyEvent.keyCodeFromString(""), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                super.onCreate(bundle);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[32], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a((byte) (PlaceComponentResult[59] + 1), PlaceComponentResult[56], PlaceComponentResult[13], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{30275, 3673, 6991, 43078, 53222, 21108, 11493, 4049, 5155, 50924, 10988, 3515, 30510, 10230, 25101, 40827, 28164, 58157, 50938, 26350, 37712, 4557, 42272, 1614, 63858, 46052}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(super.getResources().getString(R.string.ep_confirmation_title).substring(2, 3).codePointAt(0) - 92, new char[]{48250, 2236, 40784, 43682, 10494, 48639, 44847, 8497, 14324, 38947, 14248, 33796, 13582, 62890, 25101, 40827, 58193, 52676}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getPressedStateDuration() >> 16) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.add_new_bills_second_onboarding_subtitle).substring(4, 5).length() + 25, new char[]{30275, 3673, 6991, 43078, 53222, 21108, 11493, 4049, 5155, 50924, 10988, 3515, 30510, 10230, 25101, 40827, 28164, 58157, 50938, 26350, 37712, 4557, 42272, 1614, 63858, 46052}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(getPackageName().codePointAt(4) - 79, new char[]{48250, 2236, 40784, 43682, 10494, 48639, 44847, 8497, 14324, 38947, 14248, 33796, 13582, 62890, 25101, 40827, 58193, 52676}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), 35 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    }

    @JvmName(name = "getPresenter")
    public final MerchantManagementContract.Presenter getPresenter() {
        MerchantManagementContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(MerchantManagementContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityMerchantManagementBinding initViewBinding() {
        ActivityMerchantManagementBinding authRequestContext = ActivityMerchantManagementBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.merchant_management_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onSuccessGetMerchantList(List<LinkedMerchantModel> linkedMerchants, int totalPageNumber) {
        Intrinsics.checkNotNullParameter(linkedMerchants, "");
        PlaceComponentResult(1);
        this.lookAheadTest = totalPageNumber;
        ArrayList arrayList = new ArrayList();
        MerchantManagementAdapter merchantManagementAdapter = this.PlaceComponentResult;
        MerchantManagementAdapter merchantManagementAdapter2 = null;
        if (merchantManagementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantManagementAdapter = null;
        }
        if (merchantManagementAdapter.getPlaceComponentResult() == 0) {
            arrayList.add(new LinkedMerchantModel(null, null, null, 0L, null, null, null, null, null, 3, 511, null));
        }
        arrayList.addAll(linkedMerchants);
        MerchantManagementAdapter merchantManagementAdapter3 = this.PlaceComponentResult;
        if (merchantManagementAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantManagementAdapter2 = merchantManagementAdapter3;
        }
        merchantManagementAdapter2.MyBillsEntityDataFactory(arrayList);
        getPresenter().PlaceComponentResult();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                MerchantManagementActivity.$r8$lambda$CRqwXmhNSjYuYCMVC8CKKbsHisk(MerchantManagementActivity.this);
            }
        }, 300L);
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onSuccessGetMoreMerchantList(List<LinkedMerchantModel> linkedMerchants, int totalPageNumber) {
        Intrinsics.checkNotNullParameter(linkedMerchants, "");
        this.lookAheadTest = totalPageNumber;
        MerchantManagementAdapter merchantManagementAdapter = this.PlaceComponentResult;
        if (merchantManagementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantManagementAdapter = null;
        }
        merchantManagementAdapter.MyBillsEntityDataFactory(linkedMerchants);
        CardView cardView = getBinding().getErrorConfigVersion.getAuthRequestContext.PlaceComponentResult;
        if (cardView != null) {
            cardView.setVisibility(0);
            cardView.animate().translationY(0.0f);
        }
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onErrorGetMerchantList() {
        PlaceComponentResult(2);
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onErrorGetMoreMerchantList() {
        this.KClassImpl$Data$declaredNonStaticMembers$2--;
        showWarningDialog(ErrorUtil.MyBillsEntityDataFactory(this));
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onLinkedMerchantEmpty() {
        PlaceComponentResult(3);
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onSuccessUnbindConsult(UnbindMerchantModel unbindMerchantModel) {
        Intrinsics.checkNotNullParameter(unbindMerchantModel, "");
        ChallengeControl.Builder builder = new ChallengeControl.Builder(this);
        builder.scheduleImpl = "unbind_merchant";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "unbind_merchant";
        Intrinsics.checkNotNullParameter(unbindMerchantModel, "");
        builder.moveToNextValue = unbindMerchantModel.BuiltInFictitiousFunctionClassFactory;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = unbindMerchantModel.MyBillsEntityDataFactory;
        builder.getErrorConfigVersion = unbindMerchantModel.PlaceComponentResult;
        builder.E = unbindMerchantModel.getAuthRequestContext;
        builder.BottomSheetCardBindingView$watcherCardNumberView$1 = unbindMerchantModel.KClassImpl$Data$declaredNonStaticMembers$2;
        builder.getOnBoardingScenario = unbindMerchantModel.scheduleImpl;
        builder.VerifyPinStateManager$executeRiskChallenge$2$2 = unbindMerchantModel.lookAheadTest;
        new ChallengeControl(builder, null).getAuthRequestContext();
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onErrorUnbindConsult() {
        showWarningDialog(ErrorUtil.MyBillsEntityDataFactory(this));
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onSuccessGetBannerList(final List<? extends CdpContentModel> list) {
        int i;
        Intrinsics.checkNotNullParameter(list, "");
        MerchantManagementAdapter merchantManagementAdapter = this.PlaceComponentResult;
        if (merchantManagementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantManagementAdapter = null;
        }
        if (merchantManagementAdapter.getAuthRequestContext()) {
            List<LinkedMerchantModel> items = merchantManagementAdapter.getItems();
            if (items != null) {
                i = 1;
                items.add(1, new LinkedMerchantModel(null, null, null, 0L, null, null, null, null, null, 4, 511, null));
            } else {
                i = 1;
            }
            merchantManagementAdapter.notifyItemInserted(i);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                MerchantManagementActivity.m2668$r8$lambda$ZMUpNWyNh1W9rUGzCi4UAMfpg(MerchantManagementActivity.this, list);
            }
        }, 250L);
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void showShimmerItem() {
        this.getAuthRequestContext = true;
        MerchantManagementAdapter merchantManagementAdapter = this.PlaceComponentResult;
        if (merchantManagementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantManagementAdapter = null;
        }
        merchantManagementAdapter.getItems().add(new LinkedMerchantModel(null, null, null, 0L, null, null, null, null, null, 0, 1023, null));
        merchantManagementAdapter.notifyDataSetChanged();
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void dismissShimmerItem() {
        MerchantManagementAdapter merchantManagementAdapter = this.PlaceComponentResult;
        if (merchantManagementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantManagementAdapter = null;
        }
        merchantManagementAdapter.removeItem(merchantManagementAdapter.getItems().size() - 1);
        merchantManagementAdapter.notifyDataSetChanged();
        this.getAuthRequestContext = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x007c, code lost:
    
        if (r12.equals(id.dana.constants.ErrorCode.SHOULD_CALL_CS_5) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0085, code lost:
    
        if (r12.equals(id.dana.constants.ErrorCode.SHOULD_CALL_CS_4) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x008e, code lost:
    
        if (r12.equals(id.dana.constants.ErrorCode.SHOULD_CALL_CS_3) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0097, code lost:
    
        if (r12.equals(id.dana.constants.ErrorCode.SHOULD_CALL_CS_2) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00a0, code lost:
    
        if (r12.equals(id.dana.constants.ErrorCode.SHOULD_CALL_CS_1) != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00a2, code lost:
    
        r12 = r11;
        BuiltInFictitiousFunctionClassFactory(id.dana.R.string.title_call_cs, id.dana.R.string.description_call_cs, id.dana.R.string.button_call_cs, id.dana.R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3, new id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda0(r11), id.dana.utils.ImageResize.PlaceComponentResult((android.app.Activity) r12, 128), id.dana.utils.ImageResize.PlaceComponentResult((android.app.Activity) r12, 128));
     */
    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityResult(int r12, int r13, android.content.Intent r14) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.merchantmanagement.view.MerchantManagementActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    private final void PlaceComponentResult(int p0) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(1 == p0 ? 0 : 8);
        getBinding().PlaceComponentResult.setVisibility(2 == p0 ? 0 : 8);
        getBinding().BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setVisibility(3 != p0 ? 8 : 0);
    }

    public final boolean MyBillsEntityDataFactory(int p0, int p1) {
        return !this.getAuthRequestContext && (p0 <= p1 + 3);
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(MerchantManagementActivity merchantManagementActivity, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        merchantManagementActivity.KClassImpl$Data$declaredNonStaticMembers$2(i, str);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1) {
        EventTrackerModel MyBillsEntityDataFactory;
        if (p0 == 1) {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory(true, "Date", DateTimeUtil.PlaceComponentResult("yyyy-MM-dd HH:mm:ss"));
        } else {
            MyBillsEntityDataFactory = p0 != 2 ? null : MyBillsEntityDataFactory(false, "Fail Reason", p1);
        }
        EventTracker.PlaceComponentResult(MyBillsEntityDataFactory);
    }

    static /* synthetic */ EventTrackerModel MyBillsEntityDataFactory$default(MerchantManagementActivity merchantManagementActivity, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return merchantManagementActivity.MyBillsEntityDataFactory(z, str, str2);
    }

    private final EventTrackerModel MyBillsEntityDataFactory(boolean p0, String p1, String p2) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.LINKED_ACCOUNTS_RESULT;
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory("Success", p0).MyBillsEntityDataFactory(p1, p2).BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTrackerModel eventTrackerModel = new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        Intrinsics.checkNotNullExpressionValue(eventTrackerModel, "");
        return eventTrackerModel;
    }

    private final void PlaceComponentResult(String p0) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.LINKED_ACCOUNTS_REQUEST;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Merchant Name", p0);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    private final void BuiltInFictitiousFunctionClassFactory(int p0, int p1, int p2, int p3, View.OnClickListener p4, int p5, int p6) {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(this);
        builder.FragmentBottomSheetPaymentSettingBinding = getString(p0);
        builder.getErrorConfigVersion = getString(p1);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = p3;
        builder.getSupportButtonTintMode = p5;
        builder.moveToNextValue = p6;
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = getString(p2);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = p4;
        String string = getString(R.string.option_cancel);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantManagementActivity.$r8$lambda$yLoexdMZC6lIFrEnOKA6ZI2uvUM(view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener;
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory();
    }

    public static void getAuthRequestContext(View p0, boolean p1) {
        if (p0 != null) {
            p0.animate().translationY(p0.getHeight() * 2.5f * (p1 ? 1 : -1));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/merchantmanagement/view/MerchantManagementActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;)V", "", "SHIMMER_DURATION", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void getAuthRequestContext(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.startActivity(new Intent(p0, MerchantManagementActivity.class));
        }
    }

    public static /* synthetic */ void $r8$lambda$2ZSCd1aU7c1vxWwI2i1JNldZVPE(MerchantManagementActivity merchantManagementActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantManagementActivity, "");
        ActivityPermissionRequest activityPermissionRequest = merchantManagementActivity.BuiltInFictitiousFunctionClassFactory;
        if (activityPermissionRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityPermissionRequest = null;
        }
        activityPermissionRequest.check();
    }

    public static /* synthetic */ void $r8$lambda$CRqwXmhNSjYuYCMVC8CKKbsHisk(MerchantManagementActivity merchantManagementActivity) {
        Intrinsics.checkNotNullParameter(merchantManagementActivity, "");
        getAuthRequestContext(merchantManagementActivity.getBinding().getAuthRequestContext.PlaceComponentResult, false);
        if (merchantManagementActivity.getErrorConfigVersion) {
            CardView cardView = merchantManagementActivity.getBinding().getErrorConfigVersion.getAuthRequestContext.PlaceComponentResult;
            if (cardView != null) {
                cardView.setVisibility(0);
                cardView.animate().translationY(0.0f);
                return;
            }
            return;
        }
        getAuthRequestContext(merchantManagementActivity.getBinding().getErrorConfigVersion.getAuthRequestContext.PlaceComponentResult, true);
    }

    /* renamed from: $r8$lambda$G2W5G0qSVBzLp-lAzFxXwp0mrsQ */
    public static /* synthetic */ void m2666$r8$lambda$G2W5G0qSVBzLplAzFxXwp0mrsQ(MerchantManagementActivity merchantManagementActivity, LinkedMerchantModel linkedMerchantModel, View view) {
        Intrinsics.checkNotNullParameter(merchantManagementActivity, "");
        Intrinsics.checkNotNullParameter(linkedMerchantModel, "");
        merchantManagementActivity.PlaceComponentResult(linkedMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
        merchantManagementActivity.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(linkedMerchantModel, null);
    }

    /* renamed from: $r8$lambda$Jc5BoQsRf2kHbf-jLmr73L4fMck */
    public static /* synthetic */ void m2667$r8$lambda$Jc5BoQsRf2kHbfjLmr73L4fMck(MerchantManagementActivity merchantManagementActivity, LinkedMerchantModel linkedMerchantModel, String str, View view) {
        Intrinsics.checkNotNullParameter(merchantManagementActivity, "");
        Intrinsics.checkNotNullParameter(linkedMerchantModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        merchantManagementActivity.PlaceComponentResult(linkedMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
        merchantManagementActivity.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(linkedMerchantModel, str);
    }

    /* renamed from: $r8$lambda$ZMUpNWyNh-1W9rUGzCi4UAM-fpg */
    public static /* synthetic */ void m2668$r8$lambda$ZMUpNWyNh1W9rUGzCi4UAMfpg(MerchantManagementActivity merchantManagementActivity, final List list) {
        Intrinsics.checkNotNullParameter(merchantManagementActivity, "");
        Intrinsics.checkNotNullParameter(list, "");
        MerchantManagementAdapter merchantManagementAdapter = merchantManagementActivity.PlaceComponentResult;
        if (merchantManagementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantManagementAdapter = null;
        }
        List<LinkedMerchantModel> items = merchantManagementAdapter.getItems();
        int i = -1;
        if (items != null) {
            Iterator<LinkedMerchantModel> it = items.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getErrorConfigVersion == 4) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = merchantManagementActivity.getBinding().getErrorConfigVersion.PlaceComponentResult.findViewHolderForLayoutPosition(i);
        final BannerViewHolder bannerViewHolder = findViewHolderForLayoutPosition instanceof BannerViewHolder ? (BannerViewHolder) findViewHolderForLayoutPosition : null;
        if (bannerViewHolder != null) {
            Intrinsics.checkNotNullParameter(list, "");
            if ((!list.isEmpty()) == true) {
                String str = ((CdpContentModel) CollectionsKt.first(list)).GetContactSyncConfig;
                Intrinsics.checkNotNullExpressionValue(str, "");
                Intrinsics.checkNotNullParameter(str, "");
                GlideRequest<Bitmap> MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(bannerViewHolder.getContext().getApplicationContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).MyBillsEntityDataFactory(DiskCacheStrategy.KClassImpl$Data$declaredNonStaticMembers$2);
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                float dimensionPixelSize = bannerViewHolder.getContext().getResources().getDimensionPixelSize(R.dimen.f28142131165293);
                RequestBuilder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory((Transformation<Bitmap>) new MultiTransformation(new GranularRoundedCorners(dimensionPixelSize, dimensionPixelSize, 0.0f)));
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
                MyBillsEntityDataFactory2.MyBillsEntityDataFactory(bannerViewHolder.getBinding().MyBillsEntityDataFactory);
                bannerViewHolder.getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.viewholder.BannerViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BannerViewHolder.PlaceComponentResult(BannerViewHolder.this, list);
                    }
                });
            }
        }
    }

    /* renamed from: $r8$lambda$sEbOUbtwC-2jENKDsIsVvULZ8NY */
    public static /* synthetic */ void m2669$r8$lambda$sEbOUbtwC2jENKDsIsVvULZ8NY(MerchantManagementActivity merchantManagementActivity) {
        Intrinsics.checkNotNullParameter(merchantManagementActivity, "");
        getAuthRequestContext(merchantManagementActivity.getBinding().getAuthRequestContext.PlaceComponentResult, false);
    }

    public static /* synthetic */ void $r8$lambda$zcd_smtPqw2r9j4jX9gpJH_D7Xo(final MerchantManagementActivity merchantManagementActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantManagementActivity, "");
        String transactionCompletedUrl = merchantManagementActivity.getDynamicUrlWrapper().getTransactionCompletedUrl();
        Intrinsics.checkNotNullExpressionValue(transactionCompletedUrl, "");
        DanaH5.startContainerFullUrl(transactionCompletedUrl, new DanaH5Listener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$openTransactionHistory$$inlined$withDanaH5Callback$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                MerchantManagementActivity.access$goToHome(MerchantManagementActivity.this);
            }
        });
    }

    public static final /* synthetic */ void access$doLogicShowHideButtonArrow(MerchantManagementActivity merchantManagementActivity) {
        if (merchantManagementActivity.getErrorConfigVersion) {
            CardView cardView = merchantManagementActivity.getBinding().getErrorConfigVersion.getAuthRequestContext.PlaceComponentResult;
            if (cardView != null) {
                cardView.setVisibility(0);
                cardView.animate().translationY(0.0f);
                return;
            }
            return;
        }
        getAuthRequestContext(merchantManagementActivity.getBinding().getErrorConfigVersion.getAuthRequestContext.PlaceComponentResult, true);
    }

    public static final /* synthetic */ void access$getLoadMoreLogic(MerchantManagementActivity merchantManagementActivity) {
        int i = merchantManagementActivity.lookAheadTest;
        int i2 = merchantManagementActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        boolean z = false;
        if (i2 > 0 && i2 < i) {
            z = true;
        }
        if (z) {
            MerchantManagementContract.Presenter presenter = merchantManagementActivity.getPresenter();
            int i3 = merchantManagementActivity.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            merchantManagementActivity.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
            presenter.PlaceComponentResult(i3);
        }
    }

    public static final /* synthetic */ void access$goToHome(MerchantManagementActivity merchantManagementActivity) {
        Intent intent = new Intent(merchantManagementActivity, HomeTabActivity.class);
        intent.setFlags(67108864);
        merchantManagementActivity.startActivity(intent);
        merchantManagementActivity.finish();
    }

    public static final /* synthetic */ void access$openH5Container(MerchantManagementActivity merchantManagementActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DanaH5.startContainerFullUrl(str);
    }

    public static final /* synthetic */ void access$showRemoveConfirmationDialog(final MerchantManagementActivity merchantManagementActivity, final LinkedMerchantModel linkedMerchantModel) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = merchantManagementActivity.getString(R.string.unbind_dialog_confirmation_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{linkedMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda0}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = merchantManagementActivity.getString(R.string.unbind_dialog_confirmation_message);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{linkedMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda0}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(merchantManagementActivity);
        builder.FragmentBottomSheetPaymentSettingBinding = format;
        builder.getErrorConfigVersion = format2;
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string3 = merchantManagementActivity.getString(R.string.remove_label);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantManagementActivity.m2666$r8$lambda$G2W5G0qSVBzLplAzFxXwp0mrsQ(MerchantManagementActivity.this, linkedMerchantModel, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string3;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string4 = merchantManagementActivity.getString(R.string.option_cancel);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantManagementActivity.$r8$lambda$HrQ0GBQSn8vzsoxivZIykmVQZxY(view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string4;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener2;
        MyBillsEntityDataFactory.initRecordTimeStamp = true;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.btnNegative.setContentDescription(merchantManagementActivity.getString(R.string.btnCancelPopup));
        KClassImpl$Data$declaredNonStaticMembers$2.btnPositive.setContentDescription(merchantManagementActivity.getString(R.string.btnRemovePopup));
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        SkeletonScreen skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        DaggerMerchantManagementComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerMerchantManagementComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (MerchantManagementModule) Preconditions.getAuthRequestContext(new MerchantManagementModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, MerchantManagementModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
        byte b = 0;
        new DaggerMerchantManagementComponent.MerchantManagementComponentImpl(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, b).MyBillsEntityDataFactory(this);
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((Activity) this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$initPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(MerchantManagementActivity.this, "1500445", true);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.BuiltInFictitiousFunctionClassFactory = builder.PlaceComponentResult();
        MerchantManagementAdapter merchantManagementAdapter = new MerchantManagementAdapter();
        this.PlaceComponentResult = merchantManagementAdapter;
        LinkedMerchantClickListener linkedMerchantClickListener = new LinkedMerchantClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$getAdapterListener$1
            @Override // id.dana.merchantmanagement.adapter.LinkedMerchantClickListener
            public final void getAuthRequestContext(CdpContentModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantManagementActivity merchantManagementActivity = MerchantManagementActivity.this;
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda4;
                Intrinsics.checkNotNullExpressionValue(str, "");
                MerchantManagementActivity.access$openH5Container(merchantManagementActivity, str);
            }

            @Override // id.dana.merchantmanagement.adapter.LinkedMerchantClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(LinkedMerchantModel p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantManagementActivity.this.MyBillsEntityDataFactory = p1;
                if (p0.getAuthRequestContext()) {
                    MerchantManagementActivity.this.getPresenter().MyBillsEntityDataFactory(p0);
                } else {
                    MerchantManagementActivity.access$showRemoveConfirmationDialog(MerchantManagementActivity.this, p0);
                }
            }
        };
        Intrinsics.checkNotNullParameter(linkedMerchantClickListener, "");
        merchantManagementAdapter.BuiltInFictitiousFunctionClassFactory = linkedMerchantClickListener;
        RecyclerView recyclerView = getBinding().getErrorConfigVersion.PlaceComponentResult;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(false);
        recyclerView.setFocusable(false);
        RecyclerView.LayoutManager layoutManager = getBinding().getErrorConfigVersion.PlaceComponentResult.getLayoutManager();
        if (layoutManager != null) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$getOnScrollListener$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p1 == 0) {
                        MerchantManagementActivity.access$doLogicShowHideButtonArrow(MerchantManagementActivity.this);
                    } else if (p1 == 1) {
                        MerchantManagementActivity.getAuthRequestContext(MerchantManagementActivity.this.getBinding().getErrorConfigVersion.getAuthRequestContext.PlaceComponentResult, true);
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    boolean MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrolled(p0, p1, p2);
                    int itemCount = linearLayoutManager.getItemCount();
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    MerchantManagementActivity.this.getErrorConfigVersion = findLastVisibleItemPosition < itemCount + (-1);
                    MyBillsEntityDataFactory = MerchantManagementActivity.this.MyBillsEntityDataFactory(itemCount, findLastVisibleItemPosition);
                    if (MyBillsEntityDataFactory) {
                        MerchantManagementActivity.access$getLoadMoreLogic(MerchantManagementActivity.this);
                    }
                }
            });
            recyclerView.setAdapter(recyclerView.getAdapter());
            getBinding().PlaceComponentResult.setOnTryAgainClickListener(new ErrorLinkedMerchantListView.OnTryAgainClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$getOnTryAgainClickListener$1
                @Override // id.dana.merchantmanagement.view.richview.ErrorLinkedMerchantListView.OnTryAgainClickListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    int i;
                    MerchantManagementActivity.this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                    MerchantManagementContract.Presenter presenter = MerchantManagementActivity.this.getPresenter();
                    i = MerchantManagementActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(i);
                }
            });
            EventTrackerModel.Builder builder2 = new EventTrackerModel.Builder(this);
            builder2.MyBillsEntityDataFactory = TrackerKey.Event.LINKED_ACCOUNTS_OPEN;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder2.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
            getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
            registerPresenter(getPresenter());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onErrorCheckUnbindEligibility() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(this);
        builder.FragmentBottomSheetPaymentSettingBinding = getString(R.string.unbind_lazada_dialog_confirmation_title);
        builder.getErrorConfigVersion = getString(R.string.unbind_lazada_dialog_confirmation_ineligible_message);
        TwoButtonWithImageDialog.Builder PlaceComponentResult2 = builder.MyBillsEntityDataFactory(false).PlaceComponentResult(false);
        String string = getString(R.string.remove_label);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantManagementActivity.$r8$lambda$u1ERhwBskqja81PyhkeVMRCDBCM(view);
            }
        };
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda5 = 2;
        PlaceComponentResult2.isLayoutRequested = false;
        String string2 = getString(R.string.option_cancel);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantManagementActivity.$r8$lambda$NM7rovIUEq30HOw2i2uLY5A1ZIs(view);
            }
        };
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        PlaceComponentResult2.DatabaseTableConfigUtil = onClickListener2;
        PlaceComponentResult2.initRecordTimeStamp = true;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.btnNegative.setContentDescription(getString(R.string.btnCancelPopup));
        KClassImpl$Data$declaredNonStaticMembers$2.btnPositive.setContentDescription(getString(R.string.btnRemovePopup));
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    @Override // id.dana.merchantmanagement.MerchantManagementContract.View
    public final void onSuccessCheckUnbindEligibility(final LinkedMerchantModel linkedMerchantModel, final String unbindEligibilityCheckId) {
        Intrinsics.checkNotNullParameter(linkedMerchantModel, "");
        Intrinsics.checkNotNullParameter(unbindEligibilityCheckId, "");
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(this);
        builder.FragmentBottomSheetPaymentSettingBinding = getString(R.string.unbind_lazada_dialog_confirmation_title);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.unbind_dialog_confirmation_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{linkedMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda0}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        builder.getErrorConfigVersion = format;
        TwoButtonWithImageDialog.Builder PlaceComponentResult2 = builder.MyBillsEntityDataFactory(false).PlaceComponentResult(false);
        String string2 = getString(R.string.remove_label);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantManagementActivity.m2667$r8$lambda$Jc5BoQsRf2kHbfjLmr73L4fMck(MerchantManagementActivity.this, linkedMerchantModel, unbindEligibilityCheckId, view);
            }
        };
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda8 = string2;
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string3 = getString(R.string.option_cancel);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.MerchantManagementActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantManagementActivity.$r8$lambda$ORap5VtYE1pZ6OA60RucKHcKwfQ(view);
            }
        };
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda2 = string3;
        PlaceComponentResult2.DatabaseTableConfigUtil = onClickListener2;
        PlaceComponentResult2.initRecordTimeStamp = true;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.btnNegative.setContentDescription(getString(R.string.btnCancelPopup));
        KClassImpl$Data$declaredNonStaticMembers$2.btnPositive.setContentDescription(getString(R.string.btnRemovePopup));
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        SkeletonScreen skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().getErrorConfigVersion.PlaceComponentResult);
        MerchantManagementAdapter merchantManagementAdapter = this.PlaceComponentResult;
        if (merchantManagementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantManagementAdapter = null;
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = merchantManagementAdapter;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_merchant_skeleton;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 10;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerViewSkeletonScreen;
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda8 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda7 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (isLayoutRequested ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (newProxyInstance ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
