package id.dana.miniprogram.tnc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.data.tracker.UserConsentTracker;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMiniProgramAgreementComponent;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkListener;
import id.dana.miniprogram.adapter.MiniProgramAgreementsAdapter;
import id.dana.miniprogram.provider.OauthServiceProvider;
import id.dana.miniprogram.tnc.TncDetailMiniProgramActivity;
import id.dana.miniprogram.tnc.TncMiniProgramDialogActivity;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0013\u0010\u000f\u001a\u00020\fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0014\u001a\f\u0012\b\u0012\u0006*\u00020\u00110\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&"}, d2 = {"Lid/dana/miniprogram/tnc/TncMiniProgramDialogActivity;", "Lid/dana/miniprogram/tnc/AbstractTncMiniProgramDialogActivity;", "", "onTncClicked", "()V", "setupBehavior", "setupContent", "showIcon", "Lid/dana/miniprogram/adapter/MiniProgramAgreementsAdapter;", "lookAheadTest", "Lid/dana/miniprogram/adapter/MiniProgramAgreementsAdapter;", "PlaceComponentResult", "Lid/dana/dialog/DanaLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroidx/activity/result/ActivityResultLauncher;", "getAuthRequestContext", "Lid/dana/miniprogram/tnc/TncMiniProgramDialogActivity$StartParams;", "GetContactSyncConfig", "Lid/dana/miniprogram/tnc/TncMiniProgramDialogActivity$StartParams;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "presenter", "Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "getPresenter", "()Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;", "setPresenter", "(Lid/dana/globalnetwork/currency/GlobalNetworkContract$Presenter;)V", "Lid/dana/data/tracker/UserConsentTracker;", "userConsentTracker", "Lid/dana/data/tracker/UserConsentTracker;", "getUserConsentTracker", "()Lid/dana/data/tracker/UserConsentTracker;", "setUserConsentTracker", "(Lid/dana/data/tracker/UserConsentTracker;)V", "<init>", "StartParams"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TncMiniProgramDialogActivity extends AbstractTncMiniProgramDialogActivity {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private StartParams KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private MiniProgramAgreementsAdapter PlaceComponentResult;
    @Inject
    public GlobalNetworkContract.Presenter presenter;
    @Inject
    public UserConsentTracker userConsentTracker;
    public static final byte[] $$g = {Ascii.ESC, -74, -29, -66, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$h = 51;
    public static final byte[] getErrorConfigVersion = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int scheduleImpl = 123;
    private static int DatabaseTableConfigUtil = 269894708;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.miniprogram.tnc.TncMiniProgramDialogActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(TncMiniProgramDialogActivity.this);
        }
    });

    private static void g(int i, short s, byte b, Object[] objArr) {
        int i2 = i + 97;
        int i3 = 23 - s;
        byte[] bArr = getErrorConfigVersion;
        int i4 = b + 4;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i2 = (i2 + i6) - 4;
            i6 = i6;
            i4 = i4;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i4 + 1;
            i2 = (i2 + bArr[i8]) - 4;
            i6 = i6;
            i4 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    private static void j(short s, int i, int i2, Object[] objArr) {
        int i3 = 103 - (i * 2);
        byte[] bArr = $$g;
        int i4 = (s * 3) + 21;
        int i5 = i2 + 4;
        byte[] bArr2 = new byte[i4];
        int i6 = -1;
        int i7 = i4 - 1;
        if (bArr == null) {
            i5++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i3 = (i3 + i7) - 7;
            i7 = i7;
        }
        while (true) {
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i5];
            int i9 = i3;
            i5++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
            i3 = (i9 + b) - 7;
            i7 = i7;
        }
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
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

    /* JADX WARN: Removed duplicated region for block: B:113:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x072a  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0ada A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0268  */
    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r27) {
        /*
            Method dump skipped, instructions count: 3074
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.tnc.TncMiniProgramDialogActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        h(false, new char[]{16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2, 16}, super.getResources().getString(R.string.voucher_description_default_value).substring(36, 43).length() + 11, super.getResources().getString(R.string.qr_expired_scanner_error_message).substring(4, 8).length() - 3, super.getResources().getString(R.string.cube_ptr_hours_ago).substring(0, 1).length() + 115, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        h(true, new char[]{65532, 1, 65517, 17, 5}, super.getResources().getString(R.string.res_0x7f1310bf_verifypinstatemanager_executeriskchallenge_2_1).substring(1, 5).codePointAt(0) - 106, 5 - KeyEvent.normalizeMetaState(0), Color.red(0) + 121, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                h(true, new char[]{17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6}, getPackageName().length() + 19, super.getResources().getString(R.string.category_trending).substring(6, 7).codePointAt(0) - 95, (ViewConfiguration.getLongPressTimeout() >> 16) + 116, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                char[] cArr = {'\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11};
                int codePointAt = getPackageName().codePointAt(0) - 87;
                try {
                    byte b = getErrorConfigVersion[25];
                    Object[] objArr5 = new Object[1];
                    g(b, b, getErrorConfigVersion[9], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], new Object[1]);
                    Object[] objArr6 = new Object[1];
                    h(false, cArr, codePointAt, ((ApplicationInfo) cls3.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 17, super.getResources().getString(R.string.tv_empty_state_desc).substring(17, 18).length() + 122, objArr6);
                    baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    h(true, new char[]{65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522}, super.getResources().getString(R.string.share_feed_consent_dialog_message).substring(28, 29).length() + 47, super.getResources().getString(R.string.min_send_amount_error_message_idr).substring(12, 13).length() + 34, getPackageName().codePointAt(6) - 9, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    h(true, new char[]{65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523}, 65 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), Color.alpha(0) + 40, super.getResources().getString(R.string.dana_viz_prompt_information_tooltip).substring(43, 45).codePointAt(0) - 27, objArr8);
                    String str2 = (String) objArr8[0];
                    char[] cArr2 = {65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote};
                    int codePointAt2 = super.getResources().getString(R.string.saved_cards).substring(1, 2).codePointAt(0) - 33;
                    try {
                        byte b2 = getErrorConfigVersion[25];
                        Object[] objArr9 = new Object[1];
                        g(b2, b2, getErrorConfigVersion[9], objArr9);
                        Class<?> cls4 = Class.forName((String) objArr9[0]);
                        g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], new Object[1]);
                        Object[] objArr10 = new Object[1];
                        h(true, cArr2, codePointAt2, ((ApplicationInfo) cls4.getMethod((String) r6[0], null).invoke(this, null)).targetSdkVersion - 8, getPackageName().length() + 78, objArr10);
                        String str3 = (String) objArr10[0];
                        char[] cArr3 = {19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19};
                        try {
                            byte b3 = getErrorConfigVersion[25];
                            Object[] objArr11 = new Object[1];
                            g(b3, b3, getErrorConfigVersion[9], objArr11);
                            Class<?> cls5 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], objArr12);
                            Object[] objArr13 = new Object[1];
                            h(false, cArr3, ((ApplicationInfo) cls5.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 27, getPackageName().codePointAt(5) - 52, super.getResources().getString(R.string.bottom_on_boarding_body_text_send_money_second).substring(4, 5).codePointAt(0) + 82, objArr13);
                            String str4 = (String) objArr13[0];
                            char[] cArr4 = {65532, 2, 65532, 7, 65535, 0};
                            try {
                                byte b4 = getErrorConfigVersion[25];
                                Object[] objArr14 = new Object[1];
                                g(b4, b4, getErrorConfigVersion[9], objArr14);
                                Class<?> cls6 = Class.forName((String) objArr14[0]);
                                Object[] objArr15 = new Object[1];
                                g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], objArr15);
                                int i = ((ApplicationInfo) cls6.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion - 27;
                                int length = super.getResources().getString(R.string.join_invitation_success_desc_content).substring(3, 4).length() + 3;
                                try {
                                    byte b5 = getErrorConfigVersion[25];
                                    Object[] objArr16 = new Object[1];
                                    g(b5, b5, getErrorConfigVersion[9], objArr16);
                                    Class<?> cls7 = Class.forName((String) objArr16[0]);
                                    Object[] objArr17 = new Object[1];
                                    g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], objArr17);
                                    int i2 = ((ApplicationInfo) cls7.getMethod((String) objArr17[0], null).invoke(this, null)).targetSdkVersion + 34;
                                    Object[] objArr18 = new Object[1];
                                    h(true, cArr4, i, length, i2, objArr18);
                                    try {
                                        Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) View.combineMeasuredStates(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr19);
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
            Object[] objArr20 = new Object[1];
            g(getErrorConfigVersion[32], (byte) (-getErrorConfigVersion[30]), (byte) 36, objArr20);
            Class<?> cls8 = Class.forName((String) objArr20[0]);
            Object[] objArr21 = new Object[1];
            g((byte) (scheduleImpl & 12), (byte) (-getErrorConfigVersion[30]), (byte) (getErrorConfigVersion[35] - 1), objArr21);
            try {
                Object[] objArr22 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 494, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 3, (char) View.MeasureSpec.getMode(0));
                    Object[] objArr23 = new Object[1];
                    j($$g[8], $$g[9], $$g[53], objArr23);
                    obj3 = cls9.getMethod((String) objArr23[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                int i3 = ((int[]) objArr24[1])[0];
                if (((int[]) objArr24[0])[0] != i3) {
                    long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), Gravity.getAbsoluteGravity(0, 0) + 35, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr25 = {-610246197, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr25);
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
                super.onCreate(bundle);
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

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6};
            try {
                byte b = getErrorConfigVersion[25];
                Object[] objArr = new Object[1];
                g(b, b, getErrorConfigVersion[9], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 7;
                try {
                    byte b2 = getErrorConfigVersion[25];
                    Object[] objArr3 = new Object[1];
                    g(b2, b2, getErrorConfigVersion[9], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    h(true, cArr, i, ((ApplicationInfo) cls2.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 18, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 117, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    char[] cArr2 = {'\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11};
                    int keyCodeFromString = KeyEvent.keyCodeFromString("") + 18;
                    int length = getPackageName().length() + 9;
                    try {
                        byte b3 = getErrorConfigVersion[25];
                        Object[] objArr5 = new Object[1];
                        g(b3, b3, getErrorConfigVersion[9], objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], objArr6);
                        int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 90;
                        Object[] objArr7 = new Object[1];
                        h(false, cArr2, keyCodeFromString, length, i2, objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myTid() >> 22) + 35, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr8 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr8);
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
        super.onPause();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6};
            try {
                byte b = getErrorConfigVersion[25];
                Object[] objArr = new Object[1];
                g(b, b, getErrorConfigVersion[9], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                g((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[27], getErrorConfigVersion[59], new Object[1]);
                Object[] objArr2 = new Object[1];
                h(true, cArr, ((ApplicationInfo) cls.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 7, TextUtils.getOffsetAfter("", 0) + 15, 116 - Color.argb(0, 0, 0, 0), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                h(false, new char[]{'\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11}, 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), super.getResources().getString(R.string.digitalvoucher_button_title).substring(0, 1).length() + 15, 123 - (ViewConfiguration.getTouchSlop() >> 8), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) (Process.getGidForName("") + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public TncMiniProgramDialogActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.miniprogram.tnc.TncMiniProgramDialogActivity$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                TncMiniProgramDialogActivity.$r8$lambda$cRL4foX2ucrdeZPsEKfDjqC9uLI(TncMiniProgramDialogActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.getAuthRequestContext = registerForActivityResult;
    }

    @JvmName(name = "getPresenter")
    public final GlobalNetworkContract.Presenter getPresenter() {
        GlobalNetworkContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(GlobalNetworkContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getUserConsentTracker")
    public final UserConsentTracker getUserConsentTracker() {
        UserConsentTracker userConsentTracker = this.userConsentTracker;
        if (userConsentTracker != null) {
            return userConsentTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUserConsentTracker")
    public final void setUserConsentTracker(UserConsentTracker userConsentTracker) {
        Intrinsics.checkNotNullParameter(userConsentTracker, "");
        this.userConsentTracker = userConsentTracker;
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void setupBehavior() {
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.res_0x7f0a0128_networkuserentitydata_externalsyntheticlambda4)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.miniprogram.tnc.TncMiniProgramDialogActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TncMiniProgramDialogActivity.m2672$r8$lambda$pu8mmnw9tOWyZQbvOUyTfaPA_8(TncMiniProgramDialogActivity.this, view);
            }
        });
        ((DanaButtonGhostView) _$_findCachedViewById(R.id.getOnBoardingScenario_res_0x7f0a0149)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.miniprogram.tnc.TncMiniProgramDialogActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TncMiniProgramDialogActivity.$r8$lambda$3fSV_yIgY3hRsnsRw6mtXYTrGAo(TncMiniProgramDialogActivity.this, view);
            }
        });
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void showIcon() {
        GlideRequests PlaceComponentResult = GlideApp.PlaceComponentResult(this);
        StartParams startParams = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        PlaceComponentResult.PlaceComponentResult(startParams.PlaceComponentResult).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a09c7_call_errorhandler)));
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void onTncClicked() {
        StartParams startParams = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        String str = startParams.moveToNextValue;
        StartParams startParams2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams2 = null;
        }
        String str2 = startParams2.PlaceComponentResult;
        MiniProgramAgreementsAdapter miniProgramAgreementsAdapter = this.PlaceComponentResult;
        if (miniProgramAgreementsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            miniProgramAgreementsAdapter = null;
        }
        Intent putExtra = new Intent(this, TncDetailMiniProgramActivity.class).putExtra("startParams", new TncDetailMiniProgramActivity.StartParams(str, str2, new ArrayList(miniProgramAgreementsAdapter.BuiltInFictitiousFunctionClassFactory), null, null, 24, null));
        Intrinsics.checkNotNullExpressionValue(putExtra, "");
        this.getAuthRequestContext.MyBillsEntityDataFactory(putExtra, null);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0018j\b\u0012\u0004\u0012\u00020\u000b`\u0019¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\"\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0018j\b\u0012\u0004\u0012\u00020\u000b`\u0019X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014"}, d2 = {"Lid/dana/miniprogram/tnc/TncMiniProgramDialogActivity$StartParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAuthRequestContext", "Ljava/util/ArrayList;", "Z", "moveToNextValue", "lookAheadTest", "scheduleImpl", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class StartParams implements Parcelable {
        public static final Parcelable.Creator<StartParams> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;
        public ArrayList<String> getAuthRequestContext;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        final String scheduleImpl;
        public final String moveToNextValue;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        final String lookAheadTest;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof StartParams) {
                StartParams startParams = (StartParams) p0;
                return Intrinsics.areEqual(this.MyBillsEntityDataFactory, startParams.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, startParams.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.scheduleImpl, startParams.scheduleImpl) && Intrinsics.areEqual(this.PlaceComponentResult, startParams.PlaceComponentResult) && Intrinsics.areEqual(this.moveToNextValue, startParams.moveToNextValue) && Intrinsics.areEqual(this.lookAheadTest, startParams.lookAheadTest) && this.KClassImpl$Data$declaredNonStaticMembers$2 == startParams.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.getAuthRequestContext, startParams.getAuthRequestContext);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.MyBillsEntityDataFactory.hashCode();
            int hashCode2 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            String str = this.scheduleImpl;
            int hashCode3 = str == null ? 0 : str.hashCode();
            int hashCode4 = this.PlaceComponentResult.hashCode();
            int hashCode5 = this.moveToNextValue.hashCode();
            String str2 = this.lookAheadTest;
            int hashCode6 = str2 != null ? str2.hashCode() : 0;
            boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StartParams(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeString(this.scheduleImpl);
            p0.writeString(this.PlaceComponentResult);
            p0.writeString(this.moveToNextValue);
            p0.writeString(this.lookAheadTest);
            p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
            p0.writeStringList(this.getAuthRequestContext);
        }

        public StartParams(String str, String str2, String str3, String str4, String str5, String str6, boolean z, ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(arrayList, "");
            this.MyBillsEntityDataFactory = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
            this.scheduleImpl = str3;
            this.PlaceComponentResult = str4;
            this.moveToNextValue = str5;
            this.lookAheadTest = str6;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.getAuthRequestContext = arrayList;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ StartParams(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, java.util.ArrayList r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r11 = this;
                r0 = r20
                r1 = r0 & 64
                if (r1 == 0) goto L16
                r1 = r16
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L13
                r1 = 1
                r9 = 1
                goto L18
            L13:
                r1 = 0
                r9 = 0
                goto L18
            L16:
                r9 = r18
            L18:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L23
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r10 = r0
                goto L25
            L23:
                r10 = r19
            L25:
                r2 = r11
                r3 = r12
                r4 = r13
                r5 = r14
                r6 = r15
                r7 = r16
                r8 = r17
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.tnc.TncMiniProgramDialogActivity.StartParams.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.util.ArrayList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<StartParams> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new StartParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartParams[] newArray(int i) {
                return new StartParams[i];
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$3fSV_yIgY3hRsnsRw6mtXYTrGAo(TncMiniProgramDialogActivity tncMiniProgramDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(tncMiniProgramDialogActivity, "");
        UserConsentTracker userConsentTracker = tncMiniProgramDialogActivity.getUserConsentTracker();
        StartParams startParams = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        UserConsentTracker.trackMPUserConsent$default(userConsentTracker, startParams.moveToNextValue, false, 2, null);
        EventBus eventBus = EventBus.getDefault();
        StartParams startParams2 = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams2 = null;
        }
        eventBus.post(new OauthServiceProvider.AgreementMessageEvent(false, startParams2.MyBillsEntityDataFactory, null));
        tncMiniProgramDialogActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$cRL4foX2ucrdeZPsEKfDjqC9uLI(TncMiniProgramDialogActivity tncMiniProgramDialogActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(tncMiniProgramDialogActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            Intent intent = activityResult.MyBillsEntityDataFactory;
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("AGREE", false) : false;
            EventBus eventBus = EventBus.getDefault();
            StartParams startParams = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (startParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                startParams = null;
            }
            eventBus.post(new OauthServiceProvider.AgreementMessageEvent(booleanExtra, startParams.MyBillsEntityDataFactory, null));
            tncMiniProgramDialogActivity.finish();
        }
    }

    /* renamed from: $r8$lambda$pu8mmnw9tOWyZQbv-OUyTfaPA_8  reason: not valid java name */
    public static /* synthetic */ void m2672$r8$lambda$pu8mmnw9tOWyZQbvOUyTfaPA_8(TncMiniProgramDialogActivity tncMiniProgramDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(tncMiniProgramDialogActivity, "");
        UserConsentTracker userConsentTracker = tncMiniProgramDialogActivity.getUserConsentTracker();
        StartParams startParams = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        StartParams startParams2 = null;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        userConsentTracker.trackMPUserConsent(startParams.moveToNextValue, true);
        GlobalNetworkContract.Presenter presenter = tncMiniProgramDialogActivity.getPresenter();
        StartParams startParams3 = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams3 = null;
        }
        String str = startParams3.moveToNextValue;
        StartParams startParams4 = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams4 = null;
        }
        String str2 = startParams4.PlaceComponentResult;
        StartParams startParams5 = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams5 = null;
        }
        String str3 = startParams5.BuiltInFictitiousFunctionClassFactory;
        StartParams startParams6 = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams6 = null;
        }
        String str4 = startParams6.scheduleImpl;
        StartParams startParams7 = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams7 = null;
        }
        String str5 = startParams7.lookAheadTest;
        StartParams startParams8 = tncMiniProgramDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            startParams2 = startParams8;
        }
        presenter.PlaceComponentResult(str, str2, str3, str4, str5, startParams2.MyBillsEntityDataFactory);
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(TncMiniProgramDialogActivity tncMiniProgramDialogActivity) {
        return (DanaLoadingDialog) tncMiniProgramDialogActivity.MyBillsEntityDataFactory.getValue();
    }

    @Override // id.dana.miniprogram.tnc.AbstractTncMiniProgramDialogActivity
    public final void setupContent() {
        DaggerMiniProgramAgreementComponent.Builder MyBillsEntityDataFactory = DaggerMiniProgramAgreementComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.PlaceComponentResult = (GlobalNetworkModule) Preconditions.getAuthRequestContext(new GlobalNetworkModule(new GlobalNetworkListener() { // from class: id.dana.miniprogram.tnc.TncMiniProgramDialogActivity$initComponent$1
            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void PlaceComponentResult(AuthCodeResult p0, boolean p1) {
                TncMiniProgramDialogActivity.StartParams startParams;
                Intrinsics.checkNotNullParameter(p0, "");
                EventBus eventBus = EventBus.getDefault();
                startParams = TncMiniProgramDialogActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (startParams == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    startParams = null;
                }
                eventBus.post(new OauthServiceProvider.AgreementMessageEvent(p1, startParams.MyBillsEntityDataFactory, p0.getAuthCode()));
                TncMiniProgramDialogActivity.this.finish();
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void lookAheadTest() {
                DanaLoadingDialog access$getDanaLoadingDialog = TncMiniProgramDialogActivity.access$getDanaLoadingDialog(TncMiniProgramDialogActivity.this);
                if (access$getDanaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                access$getDanaLoadingDialog.MyBillsEntityDataFactory.show();
                access$getDanaLoadingDialog.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                TncMiniProgramDialogActivity.access$getDanaLoadingDialog(TncMiniProgramDialogActivity.this).PlaceComponentResult();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, GlobalNetworkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerMiniProgramAgreementComponent.MiniProgramAgreementComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getPresenter());
        Parcelable parcelableExtra = getIntent().getParcelableExtra("startParams");
        Intrinsics.checkNotNull(parcelableExtra);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (StartParams) parcelableExtra;
        TextView textView = (TextView) _$_findCachedViewById(R.id.getRelativeLeft);
        Object[] objArr = new Object[1];
        StartParams startParams = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StartParams startParams2 = null;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        objArr[0] = startParams.moveToNextValue;
        textView.setText(getString(R.string.text_title_content_tnc_mp, objArr));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
        recyclerView.setVisibility(0);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StartParams startParams3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            startParams2 = startParams3;
        }
        MiniProgramAgreementsAdapter miniProgramAgreementsAdapter = new MiniProgramAgreementsAdapter(startParams2.getAuthRequestContext, 0, 0, 6, null);
        recyclerView.setAdapter(miniProgramAgreementsAdapter);
        this.PlaceComponentResult = miniProgramAgreementsAdapter;
        ((AppCompatTextView) _$_findCachedViewById(R.id.getHeaderBackgroundColor)).setVisibility(8);
    }

    private static void h(boolean z, char[] cArr, int i, int i2, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i3);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (DatabaseTableConfigUtil ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i];
            System.arraycopy(cArr2, 0, cArr3, 0, i);
            System.arraycopy(cArr3, 0, cArr2, i - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
