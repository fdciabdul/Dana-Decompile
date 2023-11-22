package id.dana.wallet_v3.identity.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
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
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.KtpDetailActivityBinding;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.DANAToast;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.wallet_v3.di.component.DaggerKtpDetailComponent;
import id.dana.wallet_v3.di.module.KtpDetailModule;
import id.dana.wallet_v3.model.KtpInfoModel;
import id.dana.wallet_v3.presenter.KtpDetailContract;
import id.dana.wallet_v3.view.ConfirmationKtpDeletionDialog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJG\u0010%\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001bH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0010J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0010J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0010J\u000f\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010\u0010J\u000f\u0010+\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010\u0010R\u001b\u00101\u001a\u00020,8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R(\u00104\u001a\b\u0012\u0004\u0012\u000203028\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109"}, d2 = {"Lid/dana/wallet_v3/identity/view/KtpDetailActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/KtpDetailActivityBinding;", "Lid/dana/wallet_v3/model/KtpInfoModel;", "ktpDetail", "", "assignDataToView", "(Lid/dana/wallet_v3/model/KtpInfoModel;)V", "Lid/dana/wallet_v3/di/module/KtpDetailModule;", "getKtpDetailModule", "()Lid/dana/wallet_v3/di/module/KtpDetailModule;", "", "getPlaceAndDobFromKtpDetail", "(Lid/dana/wallet_v3/model/KtpInfoModel;)Ljava/lang/String;", "getRtRwFromKtpDetail", IAPSyncCommand.COMMAND_INIT, "()V", "initInjector", "initViewBinding", "()Lid/dana/databinding/KtpDetailActivityBinding;", CdpConstants.CONTENT_IMAGE_URL, "loadImage", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "onClickRightMenuButton", "(Landroid/view/View;)V", "Landroidx/appcompat/widget/AppCompatTextView;", "ktpCardField", "ktpDetailField", "text", "Landroidx/constraintlayout/widget/Group;", "groupCardView", "groupDetailView", "Landroidx/appcompat/widget/AppCompatImageView;", "copyCta", "ktpDetailTitle", "setKtpFieldUsingEmptyChecker", "(Landroidx/appcompat/widget/AppCompatTextView;Landroidx/appcompat/widget/AppCompatTextView;Ljava/lang/String;Landroidx/constraintlayout/widget/Group;Landroidx/constraintlayout/widget/Group;Landroidx/appcompat/widget/AppCompatImageView;Landroidx/appcompat/widget/AppCompatTextView;)V", "setupDeleteKtp", "setupToolbar", "setupTryAgainBtn", "showFailedFetchView", "showKtpDetailView", "Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog$delegate", "Lkotlin/Lazy;", "getDanaLoadingDialog", "()Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog", "Ldagger/Lazy;", "Lid/dana/wallet_v3/presenter/KtpDetailContract$Presenter;", "ktpDetailPresenter", "Ldagger/Lazy;", "getKtpDetailPresenter", "()Ldagger/Lazy;", "setKtpDetailPresenter", "(Ldagger/Lazy;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KtpDetailActivity extends ViewBindingActivity<KtpDetailActivityBinding> {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: danaLoadingDialog$delegate  reason: from kotlin metadata */
    private final Lazy danaLoadingDialog = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.wallet_v3.identity.view.KtpDetailActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(KtpDetailActivity.this);
        }
    });
    @Inject
    public dagger.Lazy<KtpDetailContract.Presenter> ktpDetailPresenter;
    public static final byte[] $$a = {45, -61, Ascii.ETB, 105, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = BlobStatic.MONITOR_IMAGE_WIDTH;
    public static final byte[] PlaceComponentResult = {110, -41, 63, 58, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 240;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda0 = 42066;
    private static char[] lookAheadTest = {37293, 37373, 37275, 37308, 37282, 37366, 37458, 37460, 37368, 37294, 37374, 37302, 37307, 37365, 37310, 37309, 37291, 37456, 37280, 37367, 37345, 37281, 37369, 37289, 37279, 37311, 37274, 37287, 37283, 37462, 37292, 37375, 37344, 37295, 37370, 37463, 37290, 37461, 37468, 37372, 37469, 37457, 37286, 37459, 37305, 37262, 37288, 37306, 37371};

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.wallet_v3.identity.view.KtpDetailActivity.PlaceComponentResult
            int r7 = 56 - r7
            int r8 = r8 + 16
            int r6 = 106 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2e
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2e:
            int r6 = r6 + r8
            int r6 = r6 + (-4)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.identity.view.KtpDetailActivity.b(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r5, byte r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = 47 - r5
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = id.dana.wallet_v3.identity.view.KtpDetailActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r4 = 0
            r3 = r5
            goto L28
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L26:
            r3 = r0[r5]
        L28:
            int r5 = r5 + 1
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.identity.view.KtpDetailActivity.c(int, byte, short, java.lang.Object[]):void");
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
        a((byte) (Drawable.resolveOpacity(0, 0) + 50), new char[]{7, 23, 17, 16, 14, '.', 17, 14, 17, 4, 17, 27, 16, 19, 29, '%', 13851, 13851}, 18 - Color.red(0), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((byte) (TextUtils.getOffsetAfter("", 0) + 89), new char[]{11, 18, 21, '/', 13911}, 5 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((byte) (TextUtils.lastIndexOf("", '0') + 73), new char[]{'\t', 29, JSONLexer.EOI, 15, 30, 17, '\f', JSONLexer.EOI, 15, '+', '%', 30, '+', '\b', '\b', 24, 13811, 13811, 23, '\b', 23, '%', 29, 23, 18, '%', 20, 17, 2, 15, '\b', '%', 1, JSONLexer.EOI, 2, 6, JSONLexer.EOI, 2, 17, '!', '\t', 22, '+', 27, 4, '#', 29, '+'}, 49 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) (AndroidCharacter.getMirror('0') + 'M'), new char[]{'\r', 30, 23, 15, JSONLexer.EOI, 2, '!', 17, 23, '%', 6, '!', 17, '\t', '\r', '-', 13861, 13861, 24, '\t', 17, '\t', 25, Typography.dollar, 21, 1, 1, '(', 20, 17, 13861, 13861, '%', 23, '/', 20, 13942, 13942, InputCardNumberView.DIVIDER, Typography.amp, 28, InputCardNumberView.DIVIDER, Typography.amp, '\b', 29, '\t', 11, '\t', 13862, 13862, '\f', 1, 1, '\f', Typography.amp, 17, Typography.amp, 17, 28, 2, '\f', 17, 18, '%'}, 63 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) ((KeyEvent.getMaxKeyCode() >> 16) + 87), new char[]{3, '\b', '#', 1, 1, '\f', 6, '+', 13817, 13817, 17, '\f', 11, Typography.amp, 29, '\n', '\b', '%', ',', 20, 2, 1, 11, '%', '\t', 22, '\f', JSONLexer.EOI, 13907, 13907, '\t', 29, '\t', 15, 5, 15, 1, 7, JSONLexer.EOI, 15, 16, JSONLexer.EOI, '\r', '-', 17, '!', 7, 2, JSONLexer.EOI, 2, 29, '%', 3, '\b', 27, 30, '\r', 29, 1, JSONLexer.EOI, 27, 30, '!', 6}, (-16777152) - Color.rgb(0, 0, 0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((byte) (53 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), new char[]{JSONLexer.EOI, '\r', 11, JSONLexer.EOI, 6, '\n', 13801, 13801, 23, 16, 23, 7, 19, '\r', 22, 20, '%', '\b', '\t', '!', '\n', 2, '\r', 19, '/', '0', '\b', 16, 17, 2, 19, '*', '\b', 16, ')', 15, InputCardNumberView.DIVIDER, 16, 11, '\'', 11, 23, '.', 28, 0, 28, '+', '\'', 5, '\n', 30, '.', 4, 29, '%', '+', '#', 22, '\n', 5}, 60 - Color.alpha(0), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((byte) (85 - (ViewConfiguration.getTapTimeout() >> 16)), new char[]{6, 19, 6, 27, 3, '\b'}, 6 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), TextUtils.indexOf((CharSequence) "", '0') + 19, (char) TextUtils.getOffsetAfter("", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(PlaceComponentResult[25], PlaceComponentResult[31], PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(PlaceComponentResult[7], (byte) (PlaceComponentResult[34] + 1), PlaceComponentResult[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - Process.getGidForName(""), 3 - (Process.myPid() >> 22), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))));
                        Object[] objArr16 = new Object[1];
                        c($$a[53], $$a[78], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Drawable.resolveOpacity(0, 0), 15 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 800, TextUtils.getOffsetBefore("", 0) + 15, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776401) - Color.rgb(0, 0, 0), View.resolveSize(0, 0) + 29, (char) (57994 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 800, 14 - MotionEvent.axisFromString(""), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {428850233, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.getDefaultSize(0, 0), 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[25], PlaceComponentResult[31], PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(PlaceComponentResult[7], (byte) (PlaceComponentResult[34] + 1), PlaceComponentResult[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 61, 46 - Drawable.resolveOpacity(0, 0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1));
                        byte b = $$a[84];
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b, b2, b2, objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {428850233, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[25], PlaceComponentResult[31], PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(PlaceComponentResult[7], (byte) (PlaceComponentResult[34] + 1), PlaceComponentResult[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getFadingEdgeLength() >> 16), TextUtils.getOffsetAfter("", 0) + 3, (char) (38968 - TextUtils.indexOf("", "", 0)));
                        byte b3 = $$a[84];
                        byte b4 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b3, b4, b4, objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {428850233, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), 18 - KeyEvent.getDeadChar(0, 0), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[25], PlaceComponentResult[31], PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(PlaceComponentResult[7], (byte) (PlaceComponentResult[34] + 1), PlaceComponentResult[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.combineMeasuredStates(0, 0), View.MeasureSpec.getSize(0) + 3, (char) View.resolveSizeAndState(0, 0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], $$a[9], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {428850233, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        a((byte) (50 - TextUtils.indexOf("", "")), new char[]{7, 23, 17, 16, 14, '.', 17, 14, 17, 4, 17, 27, 16, 19, 29, '%', 13851, 13851}, ExpandableListView.getPackedPositionGroup(0L) + 18, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            Object[] objArr3 = new Object[1];
            b(PlaceComponentResult[32], (byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(PlaceComponentResult[13], PlaceComponentResult[25], PlaceComponentResult[56], objArr4);
            byte b = (byte) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 56);
            char[] cArr = {11, 18, 21, '/', 13911};
            try {
                Object[] objArr5 = new Object[1];
                b(PlaceComponentResult[32], (byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                b(PlaceComponentResult[13], PlaceComponentResult[25], PlaceComponentResult[56], new Object[1]);
                Object[] objArr6 = new Object[1];
                a(b, cArr, ((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 28, objArr6);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr7 = new Object[1];
                        a((byte) (super.getResources().getString(R.string.most_wanted_ongoing_promos).substring(19, 20).codePointAt(0) + 23), new char[]{7, 23, 17, 16, 14, '.', 17, 14, 11, 23, 27, 18, ',', 31, 7, '/', '-', '+', '\r', '\f', 6, 23, 22, '+', 16, 23}, super.getResources().getString(R.string.citcall_introduction_title).substring(33, 34).length() + 25, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        a((byte) (super.getResources().getString(R.string.send_or_request_money_here).substring(15, 16).codePointAt(0) + 10), new char[]{'!', ',', 13842, 13842, '#', 22, '\n', '/', 13844, 13844, '#', 0, '%', 16, 7, '/', 14, 25}, super.getResources().getString(R.string.paylater_loan_personal_subtitle_due).substring(1, 3).length() + 16, objArr8);
                        baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            try {
                                Object[] objArr9 = new Object[1];
                                b(PlaceComponentResult[32], (byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[30]), objArr9);
                                Class<?> cls5 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                b(PlaceComponentResult[13], PlaceComponentResult[25], PlaceComponentResult[56], objArr10);
                                Object[] objArr11 = new Object[1];
                                a((byte) (((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 39), new char[]{'\t', 29, JSONLexer.EOI, 15, 30, 17, '\f', JSONLexer.EOI, 15, '+', '%', 30, '+', '\b', '\b', 24, 13811, 13811, 23, '\b', 23, '%', 29, 23, 18, '%', 20, 17, 2, 15, '\b', '%', 1, JSONLexer.EOI, 2, 6, JSONLexer.EOI, 2, 17, '!', '\t', 22, '+', 27, 4, '#', 29, '+'}, super.getResources().getString(R.string.pushverify_general_error_title).substring(11, 12).length() + 47, objArr11);
                                String str = (String) objArr11[0];
                                Object[] objArr12 = new Object[1];
                                a((byte) (getPackageName().length() + 118), new char[]{'\r', 30, 23, 15, JSONLexer.EOI, 2, '!', 17, 23, '%', 6, '!', 17, '\t', '\r', '-', 13861, 13861, 24, '\t', 17, '\t', 25, Typography.dollar, 21, 1, 1, '(', 20, 17, 13861, 13861, '%', 23, '/', 20, 13942, 13942, InputCardNumberView.DIVIDER, Typography.amp, 28, InputCardNumberView.DIVIDER, Typography.amp, '\b', 29, '\t', 11, '\t', 13862, 13862, '\f', 1, 1, '\f', Typography.amp, 17, Typography.amp, 17, 28, 2, '\f', 17, 18, '%'}, super.getResources().getString(R.string.deals_express_snackbar_fail_without_retry).substring(65, 67).length() + 62, objArr12);
                                String str2 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                a((byte) (super.getResources().getString(R.string.res_0x7f13048e_challenge_pin_dialog_button_negative).substring(4, 5).codePointAt(0) + 55), new char[]{3, '\b', '#', 1, 1, '\f', 6, '+', 13817, 13817, 17, '\f', 11, Typography.amp, 29, '\n', '\b', '%', ',', 20, 2, 1, 11, '%', '\t', 22, '\f', JSONLexer.EOI, 13907, 13907, '\t', 29, '\t', 15, 5, 15, 1, 7, JSONLexer.EOI, 15, 16, JSONLexer.EOI, '\r', '-', 17, '!', 7, 2, JSONLexer.EOI, 2, 29, '%', 3, '\b', 27, 30, '\r', 29, 1, JSONLexer.EOI, 27, 30, '!', 6}, getPackageName().length() + 57, objArr13);
                                String str3 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                a((byte) (super.getResources().getString(R.string.family_account_text_month_transaction_limit_desc_all_member_pending).substring(1, 2).length() + 51), new char[]{JSONLexer.EOI, '\r', 11, JSONLexer.EOI, 6, '\n', 13801, 13801, 23, 16, 23, 7, 19, '\r', 22, 20, '%', '\b', '\t', '!', '\n', 2, '\r', 19, '/', '0', '\b', 16, 17, 2, 19, '*', '\b', 16, ')', 15, InputCardNumberView.DIVIDER, 16, 11, '\'', 11, 23, '.', 28, 0, 28, '+', '\'', 5, '\n', 30, '.', 4, 29, '%', '+', '#', 22, '\n', 5}, getPackageName().length() + 53, objArr14);
                                String str4 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                a((byte) (super.getResources().getString(R.string.passkey_try_again).substring(6, 7).length() + 84), new char[]{6, 19, 6, 27, 3, '\b'}, 6 - Gravity.getAbsoluteGravity(0, 0), objArr15);
                                try {
                                    Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr16);
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
                    Object[] objArr17 = new Object[1];
                    b(PlaceComponentResult[25], PlaceComponentResult[31], PlaceComponentResult[25], objArr17);
                    Class<?> cls6 = Class.forName((String) objArr17[0]);
                    Object[] objArr18 = new Object[1];
                    b(PlaceComponentResult[7], (byte) (PlaceComponentResult[34] + 1), PlaceComponentResult[25], objArr18);
                    try {
                        Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.lastIndexOf("", '0', 0), (ViewConfiguration.getScrollBarSize() >> 8) + 4, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                            Object[] objArr20 = new Object[1];
                            c((byte) ($$a[78] - 1), $$a[8], $$a[9], objArr20);
                            obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                        int i = ((int[]) objArr21[1])[0];
                        if (((int[]) objArr21[0])[0] != i) {
                            long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr22 = {-1357905274, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr22);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) ((ViewConfiguration.getPressedStateDuration() >> 16) + 55), new char[]{7, 23, 17, 16, 14, '.', 17, 14, 11, 23, 27, 18, ',', 31, 7, '/', '-', '+', '\r', '\f', 6, 23, 22, '+', 16, 23}, getPackageName().length() + 19, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (getPackageName().length() + 35), new char[]{'!', ',', 13842, 13842, '#', 22, '\n', '/', 13844, 13844, '#', 0, '%', 16, 7, '/', 14, 25}, getPackageName().length() + 11, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, 35 - Color.blue(0), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), 17 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 54), new char[]{7, 23, 17, 16, 14, '.', 17, 14, 11, 23, 27, 18, ',', 31, 7, '/', '-', '+', '\r', '\f', 6, 23, 22, '+', 16, 23}, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 26, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (getPackageName().length() + 35), new char[]{'!', ',', 13842, 13842, '#', 22, '\n', '/', 13844, 13844, '#', 0, '%', 16, 7, '/', 14, 25}, super.getResources().getString(R.string.error_input_empty).substring(0, 6).length() + 12, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getKtpDetailPresenter")
    public final dagger.Lazy<KtpDetailContract.Presenter> getKtpDetailPresenter() {
        dagger.Lazy<KtpDetailContract.Presenter> lazy = this.ktpDetailPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setKtpDetailPresenter")
    public final void setKtpDetailPresenter(dagger.Lazy<KtpDetailContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.ktpDetailPresenter = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final KtpDetailActivityBinding initViewBinding() {
        KtpDetailActivityBinding PlaceComponentResult2 = KtpDetailActivityBinding.PlaceComponentResult(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getDanaLoadingDialog")
    public final DanaLoadingDialog getDanaLoadingDialog() {
        return (DanaLoadingDialog) this.danaLoadingDialog.getValue();
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickRightMenuButton(View view) {
        String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION_KTP);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        initInjector();
        setupToolbar();
        setupDeleteKtp();
        setupTryAgainBtn();
        getKtpDetailPresenter().get().getKtpDetailAsset();
    }

    private final void initInjector() {
        DaggerKtpDetailComponent.builder().applicationComponent(getApplicationComponent()).ktpDetailModule(getKtpDetailModule()).build().inject(this);
    }

    private final KtpDetailModule getKtpDetailModule() {
        return new KtpDetailModule(new KtpDetailContract.View() { // from class: id.dana.wallet_v3.identity.view.KtpDetailActivity$getKtpDetailModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.wallet_v3.presenter.KtpDetailContract.View
            public final void onGetKtpDetailSuccess(KtpInfoModel ktpDetail) {
                Intrinsics.checkNotNullParameter(ktpDetail, "");
                KtpDetailActivity.this.assignDataToView(ktpDetail);
            }

            @Override // id.dana.wallet_v3.presenter.KtpDetailContract.View
            public final void onGetKtpDetailFailed() {
                KtpDetailActivity.this.showFailedFetchView();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaLoadingDialog danaLoadingDialog;
                danaLoadingDialog = KtpDetailActivity.this.getDanaLoadingDialog();
                if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                danaLoadingDialog.MyBillsEntityDataFactory.show();
                danaLoadingDialog.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                DanaLoadingDialog danaLoadingDialog;
                danaLoadingDialog = KtpDetailActivity.this.getDanaLoadingDialog();
                danaLoadingDialog.PlaceComponentResult();
            }

            @Override // id.dana.wallet_v3.presenter.KtpDetailContract.View
            public final void onDeleteKtpSuccess() {
                KtpDetailActivity.this.setResult(-1, new Intent());
                KtpDetailActivity.this.finish();
            }

            @Override // id.dana.wallet_v3.presenter.KtpDetailContract.View
            public final void onDeleteKtpError() {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                KtpDetailActivity ktpDetailActivity = KtpDetailActivity.this;
                KtpDetailActivity ktpDetailActivity2 = ktpDetailActivity;
                String string = ktpDetailActivity.getResources().getString(R.string.failed_add_remove_favorite_card_msg);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.PlaceComponentResult(ktpDetailActivity2, string);
            }
        });
    }

    private final void setupToolbar() {
        setTitle(getString(R.string.toolbar_ktp_detail_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
        setMenuRightButton(R.drawable.ic_info_white);
    }

    private final void setupDeleteKtp() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.view.KtpDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KtpDetailActivity.m3011setupDeleteKtp$lambda0(KtpDetailActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupDeleteKtp$lambda-0  reason: not valid java name */
    public static final void m3011setupDeleteKtp$lambda0(final KtpDetailActivity ktpDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(ktpDetailActivity, "");
        new ConfirmationKtpDeletionDialog(ktpDetailActivity, new Function1<View, Unit>() { // from class: id.dana.wallet_v3.identity.view.KtpDetailActivity$setupDeleteKtp$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                Intrinsics.checkNotNullParameter(view2, "");
                KtpDetailActivity.this.getKtpDetailPresenter().get().deleteKtp();
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }
        }).showDialog();
    }

    private final void setupTryAgainBtn() {
        getBinding().isAuth.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.view.KtpDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KtpDetailActivity.m3012setupTryAgainBtn$lambda1(KtpDetailActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupTryAgainBtn$lambda-1  reason: not valid java name */
    public static final void m3012setupTryAgainBtn$lambda1(KtpDetailActivity ktpDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(ktpDetailActivity, "");
        ktpDetailActivity.getKtpDetailPresenter().get().getKtpDetailAsset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void assignDataToView(KtpInfoModel ktpDetail) {
        showKtpDetailView();
        loadImage(ktpDetail.getBackgroundUrl());
        KtpDetailActivityBinding binding = getBinding();
        AppCompatTextView appCompatTextView = binding.I;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        AppCompatTextView appCompatTextView2 = binding.R.H;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        String certNo = ktpDetail.getCertNo();
        Group group = binding.DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(group, "");
        Group group2 = binding.R.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(group2, "");
        AppCompatImageView appCompatImageView = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda6;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        AppCompatTextView appCompatTextView3 = binding.R.getValueOfTouchPositionAbsolute;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView, appCompatTextView2, certNo, group, group2, appCompatImageView, appCompatTextView3);
        AppCompatTextView appCompatTextView4 = binding.G;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "");
        AppCompatTextView appCompatTextView5 = binding.R.VerifyPinStateManager$executeRiskChallenge$2$2;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView5, "");
        String certName = ktpDetail.getCertName();
        Group group3 = binding.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(group3, "");
        Group group4 = binding.R.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(group4, "");
        AppCompatImageView appCompatImageView2 = binding.R.isLayoutRequested;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        AppCompatTextView appCompatTextView6 = binding.R.getOnBoardingScenario;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView6, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView4, appCompatTextView5, certName, group3, group4, appCompatImageView2, appCompatTextView6);
        AppCompatTextView appCompatTextView7 = binding.getCallingPid;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView7, "");
        AppCompatTextView appCompatTextView8 = binding.R.B;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView8, "");
        String placeAndDobFromKtpDetail = getPlaceAndDobFromKtpDetail(ktpDetail);
        Group group5 = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(group5, "");
        Group group6 = binding.R.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(group6, "");
        AppCompatImageView appCompatImageView3 = binding.R.newProxyInstance;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
        AppCompatTextView appCompatTextView9 = binding.R.SubSequence;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView9, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView7, appCompatTextView8, placeAndDobFromKtpDetail, group5, group6, appCompatImageView3, appCompatTextView9);
        AppCompatTextView appCompatTextView10 = binding.VerifyPinStateManager$executeRiskChallenge$2$1;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView10, "");
        AppCompatTextView appCompatTextView11 = binding.R.A;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView11, "");
        String gender = ktpDetail.getGender();
        Group group7 = binding.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(group7, "");
        Group group8 = binding.R.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(group8, "");
        AppCompatImageView appCompatImageView4 = binding.R.PrepareContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView4, "");
        AppCompatTextView appCompatTextView12 = binding.R.VerifyPinStateManager$executeRiskChallenge$2$1;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView12, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView10, appCompatTextView11, gender, group7, group8, appCompatImageView4, appCompatTextView12);
        AppCompatTextView appCompatTextView13 = binding.FragmentBottomSheetPaymentSettingBinding;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView13, "");
        AppCompatTextView appCompatTextView14 = binding.R.whenAvailable;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView14, "");
        String homeAddress = ktpDetail.getHomeAddress();
        Group group9 = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(group9, "");
        Group group10 = binding.R.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(group10, "");
        AppCompatImageView appCompatImageView5 = binding.R.DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView5, "");
        AppCompatTextView appCompatTextView15 = binding.R.readMicros;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView15, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView13, appCompatTextView14, homeAddress, group9, group10, appCompatImageView5, appCompatTextView15);
        AppCompatTextView appCompatTextView16 = binding.getNameOrBuilderList;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView16, "");
        AppCompatTextView appCompatTextView17 = binding.R.G;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView17, "");
        String rtRwFromKtpDetail = getRtRwFromKtpDetail(ktpDetail);
        Group group11 = binding.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(group11, "");
        Group group12 = binding.R.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(group12, "");
        AppCompatImageView appCompatImageView6 = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda4;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView6, "");
        AppCompatTextView appCompatTextView18 = binding.R.F;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView18, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView16, appCompatTextView17, rtRwFromKtpDetail, group11, group12, appCompatImageView6, appCompatTextView18);
        AppCompatTextView appCompatTextView19 = binding.C;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView19, "");
        AppCompatTextView appCompatTextView20 = binding.R.BottomSheetCardBindingView$watcherCardNumberView$1;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView20, "");
        String subdistrict = ktpDetail.getSubdistrict();
        Group group13 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(group13, "");
        Group group14 = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(group14, "");
        AppCompatImageView appCompatImageView7 = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda7;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView7, "");
        AppCompatTextView appCompatTextView21 = binding.R.C;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView21, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView19, appCompatTextView20, subdistrict, group13, group14, appCompatImageView7, appCompatTextView21);
        AppCompatTextView appCompatTextView22 = binding.SummaryVoucherView$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView22, "");
        AppCompatTextView appCompatTextView23 = binding.R.M;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView23, "");
        String district = ktpDetail.getDistrict();
        Group group15 = binding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(group15, "");
        Group group16 = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(group16, "");
        AppCompatImageView appCompatImageView8 = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda5;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView8, "");
        AppCompatTextView appCompatTextView24 = binding.R.L;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView24, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView22, appCompatTextView23, district, group15, group16, appCompatImageView8, appCompatTextView24);
        AppCompatTextView appCompatTextView25 = binding.L;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView25, "");
        AppCompatTextView appCompatTextView26 = binding.R.AppCompatEmojiTextHelper;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView26, "");
        String religion = ktpDetail.getReligion();
        Group group17 = binding.GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(group17, "");
        Group group18 = binding.R.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(group18, "");
        AppCompatImageView appCompatImageView9 = binding.R.FragmentBottomSheetPaymentSettingBinding;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView9, "");
        AppCompatTextView appCompatTextView27 = binding.R.I;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView27, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView25, appCompatTextView26, religion, group17, group18, appCompatImageView9, appCompatTextView27);
        AppCompatTextView appCompatTextView28 = binding.getValueOfTouchPositionAbsolute;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView28, "");
        AppCompatTextView appCompatTextView29 = binding.R.D;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView29, "");
        String marriage = ktpDetail.getMarriage();
        Group group19 = binding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(group19, "");
        Group group20 = binding.R.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(group20, "");
        AppCompatImageView appCompatImageView10 = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda8;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView10, "");
        AppCompatTextView appCompatTextView30 = binding.R.E;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView30, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView28, appCompatTextView29, marriage, group19, group20, appCompatImageView10, appCompatTextView30);
        AppCompatTextView appCompatTextView31 = binding.SummaryVoucherView$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView31, "");
        AppCompatTextView appCompatTextView32 = binding.R.K;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView32, "");
        String occupation = ktpDetail.getOccupation();
        Group group21 = binding.newProxyInstance;
        Intrinsics.checkNotNullExpressionValue(group21, "");
        Group group22 = binding.R.GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(group22, "");
        AppCompatImageView appCompatImageView11 = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView11, "");
        AppCompatTextView appCompatTextView33 = binding.R.J;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView33, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView31, appCompatTextView32, occupation, group21, group22, appCompatImageView11, appCompatTextView33);
        AppCompatTextView appCompatTextView34 = binding.readMicros;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView34, "");
        AppCompatTextView appCompatTextView35 = binding.R.getSupportButtonTintMode;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView35, "");
        String nationality = ktpDetail.getNationality();
        Group group23 = binding.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(group23, "");
        Group group24 = binding.R.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(group24, "");
        AppCompatImageView appCompatImageView12 = binding.R.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView12, "");
        AppCompatTextView appCompatTextView36 = binding.R.getCallingPid;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView36, "");
        setKtpFieldUsingEmptyChecker(appCompatTextView34, appCompatTextView35, nationality, group23, group24, appCompatImageView12, appCompatTextView36);
    }

    private final void loadImage(String imgUrl) {
        if (SvgLoader.getAuthRequestContext(imgUrl)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(this);
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = imgUrl;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ktp_detail_background;
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = getBinding().isLayoutRequested;
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
            return;
        }
        GlideApp.PlaceComponentResult(this).PlaceComponentResult(imgUrl).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ktp_detail_background).PlaceComponentResult((int) R.drawable.ktp_detail_background).MyBillsEntityDataFactory((ImageView) getBinding().isLayoutRequested);
    }

    private final void setKtpFieldUsingEmptyChecker(AppCompatTextView ktpCardField, AppCompatTextView ktpDetailField, final String text, Group groupCardView, Group groupDetailView, AppCompatImageView copyCta, final AppCompatTextView ktpDetailTitle) {
        String str = text;
        if (str.length() == 0) {
            groupCardView.setVisibility(8);
            groupDetailView.setVisibility(8);
            return;
        }
        groupCardView.setVisibility(0);
        groupDetailView.setVisibility(0);
        ktpCardField.setText(str);
        ktpDetailField.setText(str);
        copyCta.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.identity.view.KtpDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KtpDetailActivity.m3010setKtpFieldUsingEmptyChecker$lambda3(KtpDetailActivity.this, ktpDetailTitle, text, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setKtpFieldUsingEmptyChecker$lambda-3  reason: not valid java name */
    public static final void m3010setKtpFieldUsingEmptyChecker$lambda3(KtpDetailActivity ktpDetailActivity, AppCompatTextView appCompatTextView, String str, View view) {
        Intrinsics.checkNotNullParameter(ktpDetailActivity, "");
        Intrinsics.checkNotNullParameter(appCompatTextView, "");
        Intrinsics.checkNotNullParameter(str, "");
        TextUtil.getAuthRequestContext(ktpDetailActivity, appCompatTextView.getText().toString(), str);
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        KtpDetailActivity ktpDetailActivity2 = ktpDetailActivity;
        String string = ktpDetailActivity.getString(R.string.copy_ktp_data_msg, appCompatTextView.getText().toString());
        Intrinsics.checkNotNullExpressionValue(string, "");
        DANAToast.getAuthRequestContext(ktpDetailActivity2, string);
    }

    private final void showKtpDetailView() {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda7.setVisibility(0);
        getBinding().isAuth.PlaceComponentResult.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFailedFetchView() {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda7.setVisibility(8);
        getBinding().isAuth.PlaceComponentResult.setVisibility(0);
    }

    private final String getRtRwFromKtpDetail(KtpInfoModel ktpDetail) {
        if (ktpDetail.getRt().length() == 0) {
            if (ktpDetail.getRw().length() == 0) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ktpDetail.getRt());
        sb.append('/');
        sb.append(ktpDetail.getRw());
        return sb.toString();
    }

    private final String getPlaceAndDobFromKtpDetail(KtpInfoModel ktpDetail) {
        if (ktpDetail.getPlaceOfBirth().length() == 0) {
            if (ktpDetail.getDateOfBirth().length() == 0) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ktpDetail.getPlaceOfBirth());
        sb.append(", ");
        sb.append(ktpDetail.getDateOfBirth());
        return sb.toString();
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = lookAheadTest;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ NetworkUserEntityData$$ExternalSyntheticLambda0);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i4 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i5 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i4];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i5];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                    } else {
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i10 = 0; i10 < i; i10++) {
            cArr4[i10] = (char) (cArr4[i10] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
