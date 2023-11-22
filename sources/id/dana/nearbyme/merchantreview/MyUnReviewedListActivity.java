package id.dana.nearbyme.merchantreview;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.nearbyme.MyReviewContract;
import id.dana.core.ui.richview.DanaDefaultPullToRefresh;
import id.dana.core.ui.richview.DanaPullToRefreshListener;
import id.dana.databinding.ActivityMyUnReviewedListBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.nearbyme.di.component.DaggerMyReviewComponent;
import id.dana.nearbyme.di.module.MyReviewModule;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment;
import id.dana.nearbyme.merchantreview.adapter.MerchantReviewAdapter;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewViewHolderModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewDialogDismissState;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.onboarding.splash.LauncherActivity;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0015\u001a\u00020\u0012X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/nearbyme/merchantreview/MyUnReviewedListActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityMyUnReviewedListBinding;", "", "configToolbar", "()V", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityMyUnReviewedListBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ldagger/Lazy;", "Lid/dana/contract/nearbyme/MyReviewContract$Presenter;", "presenter", "Ldagger/Lazy;", "getPresenter", "()Ldagger/Lazy;", "setPresenter", "(Ldagger/Lazy;)V", "Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyUnReviewedListActivity extends ViewBindingActivity<ActivityMyUnReviewedListBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int lookAheadTest;
    @Inject
    public Lazy<MyReviewContract.Presenter> presenter;
    public static final byte[] $$a = {93, 18, 67, -65, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 241;
    public static final byte[] getAuthRequestContext = {62, -79, -77, -78, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 72;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final kotlin.Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<MerchantReviewAdapter>() { // from class: id.dana.nearbyme.merchantreview.MyUnReviewedListActivity$unreviewedMerchantAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.nearbyme.merchantreview.MyUnReviewedListActivity$unreviewedMerchantAdapter$2$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<MerchantConsultReviewModel, Integer, Unit> {
            AnonymousClass1(Object obj) {
                super(2, obj, MyUnReviewedListActivity.class, "showMerchantReviewDialog", "showMerchantReviewDialog(Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;I)V", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(MerchantConsultReviewModel merchantConsultReviewModel, Integer num) {
                invoke(merchantConsultReviewModel, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MerchantConsultReviewModel merchantConsultReviewModel, int i) {
                Intrinsics.checkNotNullParameter(merchantConsultReviewModel, "");
                MyUnReviewedListActivity.access$showMerchantReviewDialog((MyUnReviewedListActivity) this.receiver, merchantConsultReviewModel, i);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
        @Override // kotlin.jvm.functions.Function0
        public final MerchantReviewAdapter invoke() {
            ?? r2 = 0;
            return new MerchantReviewAdapter(new AnonymousClass1(MyUnReviewedListActivity.this), r2, 2, r2);
        }
    });

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[MerchantReviewDialogDismissState.values().length];
            iArr[MerchantReviewDialogDismissState.DISMISSED_BY_CANCEL.ordinal()] = 1;
            iArr[MerchantReviewDialogDismissState.DISMISSED_BY_SUBMIT.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.nearbyme.merchantreview.MyUnReviewedListActivity.getAuthRequestContext
            int r7 = r7 + 4
            int r8 = 23 - r8
            int r9 = r9 + 97
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2d
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2d:
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            int r7 = r7 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.MyUnReviewedListActivity.b(byte, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r6 = r6 + 4
            byte[] r0 = id.dana.nearbyme.merchantreview.MyUnReviewedListActivity.$$a
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2e
        L17:
            r3 = 0
        L18:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.MyUnReviewedListActivity.c(short, short, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        lookAheadTest = 269894816;
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
        a(true, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 231, 18 - TextUtils.getTrimmedLength(""), View.resolveSizeAndState(0, 0, 0) + 18, new char[]{16, 16, 2, 0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(true, 236 - MotionEvent.axisFromString(""), 6 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 5 - (ViewConfiguration.getWindowTouchSlop() >> 8), new char[]{65532, 1, 65517, 17, 5}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, ExpandableListView.getPackedPositionChild(0L) + 36, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(false, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 204, 10 - TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 48, new char[]{65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(false, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, 60 - KeyEvent.keyCodeFromString(""), 64 - Color.blue(0), new char[]{Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(false, AndroidCharacter.getMirror('0') + 153, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 33, View.MeasureSpec.getSize(0) + 64, new char[]{65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(true, 230 - Color.green(0), ExpandableListView.getPackedPositionType(0L) + 2, TextUtils.getCapsMode("", 0, 0) + 60, new char[]{19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(true, 183 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), ImageFormat.getBitsPerPixel(0) + 4, (ViewConfiguration.getScrollBarSize() >> 8) + 6, new char[]{2, 65532, 7, 65535, 0, 65532}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = new Object[1];
                b((byte) 37, getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-getAuthRequestContext[35]);
                byte b2 = getAuthRequestContext[30];
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16777161) - Color.rgb(0, 0, 0), 3 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((Process.getThreadPriority(0) + 20) >> 6));
                        byte b3 = $$a[47];
                        byte b4 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b3, b4, b4, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) Color.alpha(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - Drawable.resolveOpacity(0, 0), (char) Color.blue(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 29 - KeyEvent.getDeadChar(0, 0), (char) (View.combineMeasuredStates(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getTrimmedLength(""), 15 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), TextUtils.getCapsMode("", 0, 0) + 35, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-240097419, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = new Object[1];
                b((byte) 37, getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = (byte) (-getAuthRequestContext[35]);
                byte b6 = getAuthRequestContext[30];
                Object[] objArr20 = new Object[1];
                b(b5, b6, (byte) (b6 + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 61, 45 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getEdgeSlop() >> 16));
                        Object[] objArr22 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), 35 - TextUtils.indexOf("", "", 0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-240097419, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr25 = new Object[1];
                b((byte) 37, getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = (byte) (-getAuthRequestContext[35]);
                byte b8 = getAuthRequestContext[30];
                Object[] objArr26 = new Object[1];
                b(b7, b8, (byte) (b8 + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 117, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 3, (char) (View.combineMeasuredStates(0, 0) + 38968));
                        Object[] objArr28 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-240097419, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr31 = new Object[1];
                b((byte) 37, getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b9 = (byte) (-getAuthRequestContext[35]);
                byte b10 = getAuthRequestContext[30];
                Object[] objArr32 = new Object[1];
                b(b9, b10, (byte) (b10 + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 107, 2 - ExpandableListView.getPackedPositionChild(0L), (char) View.getDefaultSize(0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 35 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-240097419, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 911, Color.blue(0) + 18, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(true, TextUtils.lastIndexOf("", '0', 0) + 233, getPackageName().codePointAt(2) - 28, 18 - Color.green(0), new char[]{16, 16, 2, 0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        int size = 237 - View.MeasureSpec.getSize(0);
        int codePointAt = super.getResources().getString(R.string.invalid_number_dialog_title).substring(3, 5).codePointAt(0) - 106;
        try {
            byte b = getAuthRequestContext[25];
            byte b2 = b;
            Object[] objArr3 = new Object[1];
            b(b, b2, b2, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
            Object[] objArr4 = new Object[1];
            a(true, size, codePointAt, ((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 28, new char[]{65532, 1, 65517, 17, 5}, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a(true, TextUtils.lastIndexOf("", '0', 0, 0) + 233, 10 - View.MeasureSpec.getSize(0), super.getResources().getString(R.string.identity_tooltip_title).substring(19, 20).length() + 25, new char[]{'\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r'}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(false, 239 - (ViewConfiguration.getScrollBarSize() >> 8), super.getResources().getString(R.string.passkey_faq_one_desc).substring(0, 8).length() + 5, getPackageName().length() + 11, new char[]{4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int codePointAt2 = super.getResources().getString(R.string.res_0x7f13015b_networkuserentitydata_externalsyntheticlambda0).substring(5, 6).codePointAt(0) + 172;
                        try {
                            byte b3 = getAuthRequestContext[25];
                            byte b4 = b3;
                            Object[] objArr7 = new Object[1];
                            b(b3, b4, b4, objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[5], objArr8);
                            int i = ((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion - 23;
                            try {
                                byte b5 = getAuthRequestContext[25];
                                byte b6 = b5;
                                Object[] objArr9 = new Object[1];
                                b(b5, b6, b6, objArr9);
                                Class<?> cls5 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[5], objArr10);
                                Object[] objArr11 = new Object[1];
                                a(false, codePointAt2, i, ((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 15, new char[]{65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522}, objArr11);
                                String str = (String) objArr11[0];
                                int codePointAt3 = super.getResources().getString(R.string.ektp_number).substring(5, 6).codePointAt(0) + 167;
                                try {
                                    byte b7 = getAuthRequestContext[25];
                                    byte b8 = b7;
                                    Object[] objArr12 = new Object[1];
                                    b(b7, b8, b8, objArr12);
                                    Class<?> cls6 = Class.forName((String) objArr12[0]);
                                    Object[] objArr13 = new Object[1];
                                    b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[5], objArr13);
                                    Object[] objArr14 = new Object[1];
                                    a(false, codePointAt3, ((ApplicationInfo) cls6.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 27, 64 - TextUtils.getOffsetBefore("", 0), new char[]{Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote}, objArr14);
                                    String str2 = (String) objArr14[0];
                                    Object[] objArr15 = new Object[1];
                                    a(false, getPackageName().length() + 194, TextUtils.lastIndexOf("", '0', 0) + 35, super.getResources().getString(R.string.yes_go_ahead).substring(0, 1).codePointAt(0) - 25, new char[]{65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote}, objArr15);
                                    String str3 = (String) objArr15[0];
                                    Object[] objArr16 = new Object[1];
                                    a(true, 230 - (Process.myPid() >> 22), super.getResources().getString(R.string.unstable_internet_network_title).substring(18, 21).length() - 1, super.getResources().getString(R.string.empty_state_bank_cards_title_v3).substring(0, 1).codePointAt(0) - 23, new char[]{19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19}, objArr16);
                                    String str4 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    a(true, super.getResources().getString(R.string.emas_subtitle).substring(5, 11).codePointAt(3) + 65, super.getResources().getString(R.string.bottom_on_boarding_body_text_top_up_second).substring(8, 9).codePointAt(0) - 62, super.getResources().getString(R.string.see_more).substring(0, 2).length() + 4, new char[]{2, 65532, 7, 65535, 0, 65532}, objArr17);
                                    try {
                                        Object[] objArr18 = {baseContext, str, str2, str3, str4, true, (String) objArr17[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, Color.argb(0, 0, 0, 0) + 18, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr18);
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
            try {
                Object[] objArr19 = new Object[1];
                b((byte) 37, getAuthRequestContext[30], (byte) (-getAuthRequestContext[32]), objArr19);
                Class<?> cls7 = Class.forName((String) objArr19[0]);
                byte b9 = (byte) (-getAuthRequestContext[35]);
                byte b10 = getAuthRequestContext[30];
                Object[] objArr20 = new Object[1];
                b(b9, b10, (byte) (b10 + 1), objArr20);
                try {
                    Object[] objArr21 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 495, 4 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr22);
                        obj3 = cls8.getMethod((String) objArr22[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj3).invoke(null, objArr21);
                    int i2 = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr24 = {352800674, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    super.onCreate(bundle);
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
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(true, getPackageName().codePointAt(2) + 186, (ViewConfiguration.getLongPressTimeout() >> 16) + 10, getPackageName().length() + 19, new char[]{'\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r'}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            int codePointAt = super.getResources().getString(R.string.send_money_text_toast_remove_quick_action).substring(22, 23).codePointAt(0) + 139;
            int i = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 13;
            try {
                byte b = getAuthRequestContext[25];
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                b(b, b2, b2, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[41], getAuthRequestContext[5], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(false, codePointAt, i, ((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.MeasureSpec.getSize(0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, 18 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(true, super.getResources().getString(R.string.error_message_get_user_info).substring(9, 10).length() + 231, getPackageName().codePointAt(3) - 90, 26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{'\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r'}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(false, getPackageName().length() + 232, (Process.myTid() >> 22) + 13, TextUtils.indexOf("", "", 0, 0) + 18, new char[]{4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, AndroidCharacter.getMirror('0') - 30, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    public final Lazy<MyReviewContract.Presenter> getPresenter() {
        Lazy<MyReviewContract.Presenter> lazy = this.presenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<MyReviewContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.presenter = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityMyUnReviewedListBinding initViewBinding() {
        ActivityMyUnReviewedListBinding MyBillsEntityDataFactory = ActivityMyUnReviewedListBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setMenuLeftButton(R.drawable.ic_close);
        setCenterTitle(getString(R.string.merchant_unreview_list_title));
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/merchantreview/MyUnReviewedListActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "PlaceComponentResult", "(Landroid/content/Context;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void PlaceComponentResult(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.startActivity(new Intent(p0, MyUnReviewedListActivity.class));
        }
    }

    public static final /* synthetic */ void access$fetchUnreviewedMerchants(MyUnReviewedListActivity myUnReviewedListActivity) {
        myUnReviewedListActivity.KClassImpl$Data$declaredNonStaticMembers$2();
        MyReviewContract.Presenter presenter = myUnReviewedListActivity.getPresenter().get();
        Intrinsics.checkNotNullExpressionValue(presenter, "");
        presenter.MyBillsEntityDataFactory(false);
    }

    public static final /* synthetic */ void access$handleOnDismissMerchantReviewDialog(MyUnReviewedListActivity myUnReviewedListActivity, MerchantReviewDialogDismissState merchantReviewDialogDismissState, int i) {
        int i2 = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[merchantReviewDialogDismissState.ordinal()];
        if (i2 == 1) {
            ((MerchantReviewAdapter) myUnReviewedListActivity.MyBillsEntityDataFactory.getValue()).PlaceComponentResult(i);
        } else if (i2 == 2) {
            ((MerchantReviewAdapter) myUnReviewedListActivity.MyBillsEntityDataFactory.getValue()).removeItem(i);
        }
    }

    public static final /* synthetic */ void access$onTouchBottom(MyUnReviewedListActivity myUnReviewedListActivity) {
        if (myUnReviewedListActivity.getPresenter().get().getGetAuthRequestContext() && ((MerchantReviewAdapter) myUnReviewedListActivity.MyBillsEntityDataFactory.getValue()).MyBillsEntityDataFactory()) {
            MerchantReviewAdapter merchantReviewAdapter = (MerchantReviewAdapter) myUnReviewedListActivity.MyBillsEntityDataFactory.getValue();
            MerchantConsultReviewViewHolderModel.Companion companion = MerchantConsultReviewViewHolderModel.INSTANCE;
            merchantReviewAdapter.appendItem(MerchantConsultReviewViewHolderModel.Companion.PlaceComponentResult());
            myUnReviewedListActivity.getPresenter().get().MyBillsEntityDataFactory(true);
        }
    }

    public static final /* synthetic */ void access$setUnreviewedMerchant(MyUnReviewedListActivity myUnReviewedListActivity, List list) {
        List list2 = list;
        boolean z = true;
        if ((!list2.isEmpty()) == true) {
            MerchantReviewAdapter merchantReviewAdapter = (MerchantReviewAdapter) myUnReviewedListActivity.MyBillsEntityDataFactory.getValue();
            Intrinsics.checkNotNullParameter(list, "");
            if (merchantReviewAdapter.PlaceComponentResult()) {
                ArrayList arrayList = new ArrayList();
                MerchantConsultReviewViewHolderModel.Companion companion = MerchantConsultReviewViewHolderModel.INSTANCE;
                arrayList.add(MerchantConsultReviewViewHolderModel.Companion.getAuthRequestContext());
                ((MerchantConsultReviewViewHolderModel) CollectionsKt.last(list)).MyBillsEntityDataFactory = 3;
                arrayList.addAll(list2);
                merchantReviewAdapter.setItems(arrayList);
                return;
            }
            List<MerchantConsultReviewViewHolderModel> items = merchantReviewAdapter.getItems();
            if (items != null && !items.isEmpty()) {
                z = false;
            }
            if (!z) {
                List<MerchantConsultReviewViewHolderModel> items2 = merchantReviewAdapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items2, "");
                if (((MerchantConsultReviewViewHolderModel) CollectionsKt.last((List) items2)).MyBillsEntityDataFactory == 6) {
                    List<MerchantConsultReviewViewHolderModel> items3 = merchantReviewAdapter.getItems();
                    Intrinsics.checkNotNullExpressionValue(items3, "");
                    merchantReviewAdapter.removeItem(CollectionsKt.getLastIndex(items3));
                }
            }
            List<MerchantConsultReviewViewHolderModel> items4 = merchantReviewAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items4, "");
            ((MerchantConsultReviewViewHolderModel) CollectionsKt.last((List) items4)).MyBillsEntityDataFactory = 2;
            ((MerchantConsultReviewViewHolderModel) CollectionsKt.last(list)).MyBillsEntityDataFactory = 3;
            merchantReviewAdapter.appendItems(list);
        }
    }

    public static final /* synthetic */ void access$showMerchantReviewDialog(final MyUnReviewedListActivity myUnReviewedListActivity, MerchantConsultReviewModel merchantConsultReviewModel, final int i) {
        MerchantReviewDialogFragment.Companion companion = MerchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        FragmentManager supportFragmentManager = myUnReviewedListActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        MerchantReviewDialogFragment.Companion.MyBillsEntityDataFactory(supportFragmentManager, merchantConsultReviewModel, true, null, new Function1<MerchantReviewDialogDismissState, Unit>() { // from class: id.dana.nearbyme.merchantreview.MyUnReviewedListActivity$showMerchantReviewDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
                invoke2(merchantReviewDialogDismissState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
                Intrinsics.checkNotNullParameter(merchantReviewDialogDismissState, "");
                MyUnReviewedListActivity.access$handleOnDismissMerchantReviewDialog(MyUnReviewedListActivity.this, merchantReviewDialogDismissState, i);
            }
        });
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MerchantReviewAdapter merchantReviewAdapter = (MerchantReviewAdapter) this.MyBillsEntityDataFactory.getValue();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            MerchantConsultReviewViewHolderModel.Companion companion = MerchantConsultReviewViewHolderModel.INSTANCE;
            arrayList.add(MerchantConsultReviewViewHolderModel.Companion.MyBillsEntityDataFactory());
        }
        merchantReviewAdapter.setItems(arrayList);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        DaggerMyReviewComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerMyReviewComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (MyReviewModule) Preconditions.getAuthRequestContext(new MyReviewModule(new MyReviewContract.View() { // from class: id.dana.nearbyme.merchantreview.MyUnReviewedListActivity$getMyReviewModule$1
            @Override // id.dana.contract.nearbyme.MyReviewContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th, String str) {
                MyReviewContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2(th, str);
            }

            @Override // id.dana.contract.nearbyme.MyReviewContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<MerchantReviewViewModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.nearbyme.MyReviewContract.View
            public final void MyBillsEntityDataFactory(Pair<? extends List<MerchantReviewTagModel>, ? extends List<MerchantReviewTagModel>> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
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

            @Override // id.dana.contract.nearbyme.MyReviewContract.View
            public final void MyBillsEntityDataFactory(List<MerchantConsultReviewViewHolderModel> p0) {
                ActivityMyUnReviewedListBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                MyUnReviewedListActivity.access$setUnreviewedMerchant(MyUnReviewedListActivity.this, p0);
                binding = MyUnReviewedListActivity.this.getBinding();
                binding.getAuthRequestContext.cancelRefreshProgress();
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().PlaceComponentResult(this);
        final RecyclerView recyclerView = getBinding().MyBillsEntityDataFactory;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter((MerchantReviewAdapter) this.MyBillsEntityDataFactory.getValue());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyme.merchantreview.MyUnReviewedListActivity$setupRecyclerView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                ActivityMyUnReviewedListBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                binding = MyUnReviewedListActivity.this.getBinding();
                DanaDefaultPullToRefresh danaDefaultPullToRefresh = binding.getAuthRequestContext;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
                danaDefaultPullToRefresh.setEnable(((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.canScrollVertically(130)) {
                    return;
                }
                MyUnReviewedListActivity.access$onTouchBottom(MyUnReviewedListActivity.this);
            }
        });
        KClassImpl$Data$declaredNonStaticMembers$2();
        MyReviewContract.Presenter presenter = getPresenter().get();
        Intrinsics.checkNotNullExpressionValue(presenter, "");
        presenter.MyBillsEntityDataFactory(false);
        getBinding().getAuthRequestContext.setDanaPullToRefreshListener(new DanaPullToRefreshListener() { // from class: id.dana.nearbyme.merchantreview.MyUnReviewedListActivity$initPullToRefresh$1
            @Override // id.dana.core.ui.richview.DanaPullToRefreshListener
            public final void PlaceComponentResult(PtrFrameLayout p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyUnReviewedListActivity.access$fetchUnreviewedMerchants(MyUnReviewedListActivity.this);
            }

            @Override // id.dana.core.ui.richview.DanaPullToRefreshListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                ActivityMyUnReviewedListBinding binding;
                binding = MyUnReviewedListActivity.this.getBinding();
                binding.getAuthRequestContext.cancelRefreshProgress();
            }
        });
    }

    private static void a(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (lookAheadTest ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
