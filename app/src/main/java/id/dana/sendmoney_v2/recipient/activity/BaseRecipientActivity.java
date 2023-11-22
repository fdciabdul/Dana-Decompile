package id.dana.sendmoney_v2.recipient.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.contract.sendmoney.RecipientContract;
import id.dana.databinding.ActivityRecipientV2Binding;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.domain.sendmoney.TransferScenario;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.sendmoney.model.QrTransferModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import id.dana.utils.RandomInteger;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001MB\u0007¢\u0006\u0004\bL\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H$¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H$¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b\u001b\u0010#J!\u0010\u001b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\tH\u0004¢\u0006\u0004\b\u001b\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u001cJ\u0017\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020\u0004*\u00020\u0007H\u0014¢\u0006\u0004\b+\u0010,R\"\u00103\u001a\u00020\t8\u0005@\u0005X\u0084\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010:\u001a\u00020!8\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8EX\u0085\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010B\u001a\u00020A8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010K\u001a\u00020\t8\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\bH\u0010.\u001a\u0004\bI\u00100\"\u0004\bJ\u00102"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/BaseRecipientActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityRecipientV2Binding;", "Lid/dana/sendmoney/view/BaseRecipientListener;", "", "configToolbar", "()V", "Lid/dana/sendmoney/model/QrTransferModel;", "qrTransferModel", "", "getTransferScenario", "(Lid/dana/sendmoney/model/QrTransferModel;)Ljava/lang/String;", "Lid/dana/sendmoney/model/RecipientModel;", "recipientModel", "(Lid/dana/sendmoney/model/RecipientModel;)Ljava/lang/String;", IAPSyncCommand.COMMAND_INIT, "initInjector", "initRecipientView", "initViewBinding", "()Lid/dana/databinding/ActivityRecipientV2Binding;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "openSummary", "(Lid/dana/sendmoney/model/RecipientModel;)V", "Lid/dana/domain/sendmoney/model/TransferInit;", "bizTransferInitResultModel", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "transferBalanceInitResultModel", "", "isNewNumber", "(Lid/dana/sendmoney/model/RecipientModel;Lid/dana/domain/sendmoney/model/TransferInit;Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;Z)V", "remarks", "(Lid/dana/sendmoney/model/RecipientModel;Ljava/lang/String;)V", "processRecipientListData", "Landroid/os/Bundle;", HummerConstants.BUNDLE, "setData", "(Landroid/os/Bundle;)V", "handleTransferData", "(Lid/dana/sendmoney/model/QrTransferModel;)V", "PlaceComponentResult", "Ljava/lang/String;", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "amount", "getAuthRequestContext", "Z", "getBelowKitkatDialog", "()Z", "setBelowKitkatDialog", "(Z)V", "belowKitkatDialog", "Lid/dana/dialog/DanaLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/Lazy;", "getDanaLoadingDialog", "()Lid/dana/dialog/DanaLoadingDialog;", "danaLoadingDialog", "Lid/dana/contract/sendmoney/RecipientContract$Presenter;", "recipientPresenter", "Lid/dana/contract/sendmoney/RecipientContract$Presenter;", "getRecipientPresenter", "()Lid/dana/contract/sendmoney/RecipientContract$Presenter;", "setRecipientPresenter", "(Lid/dana/contract/sendmoney/RecipientContract$Presenter;)V", "initRecordTimeStamp", "getTransactionType", "setTransactionType", "transactionType", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseRecipientActivity extends ViewBindingActivity<ActivityRecipientV2Binding> implements BaseRecipientListener {
    private static int DatabaseTableConfigUtil;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static char PrepareContext;
    public static final int lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean belowKitkatDialog;
    @Inject
    public RecipientContract.Presenter recipientPresenter;
    public static final byte[] $$j = {TarHeader.LF_DIR, 18, -76, 65, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$k = 207;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {120, 42, -65, -64, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int GetContactSyncConfig = 32;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String amount = "";

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String transactionType = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy danaLoadingDialog = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(BaseRecipientActivity.this);
        }
    });

    static void getAuthRequestContext() {
        PrepareContext = (char) 13492;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = -3620302632693249538L;
        DatabaseTableConfigUtil = -956812108;
    }

    private static void l(int i, byte b, short s, Object[] objArr) {
        int i2 = s + 4;
        byte[] bArr = NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i3 = 106 - i;
        int i4 = 23 - b;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i3 = (i3 + (-i6)) - 4;
            i6 = i6;
            i2 = i2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i2 + 1;
            i3 = (i3 + (-bArr[i8])) - 4;
            i6 = i6;
            i2 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m(short r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity.$$j
            int r7 = 46 - r7
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L18:
            r3 = 0
        L19:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
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
            r5 = r8
            r8 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity.m(short, int, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public View _$_findCachedViewById(int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:112:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0936  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x093b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x093f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0b02 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02a4  */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r35) {
        /*
            Method dump skipped, instructions count: 3226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    protected abstract void initInjector();

    protected abstract void initRecipientView();

    /* JADX WARN: Removed duplicated region for block: B:48:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0469 A[Catch: all -> 0x05ac, TryCatch #5 {all -> 0x05ac, blocks: (B:46:0x0450, B:50:0x04b1, B:49:0x0469), top: B:105:0x0450 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04c9  */
    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r30) {
        /*
            Method dump skipped, instructions count: 1972
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.BaseRecipientActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            k(new char[]{32074, 2064, 17385, 61767}, new char[]{59233, 10587, 36916, 22165, 56039, 2417, 17693, 31576, 60151, 35042, 30797, 50050, 1187, 49253, 60448, 389, 47563, 20592, 14702, 53177, 34747, 20978, 60919, 22061, 54218, 33233}, (char) (super.getResources().getString(R.string.twilio_intro_3_description).substring(74, 76).codePointAt(0) + 45789), new char[]{29388, 565, 64805, 33714}, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            k(new char[]{32074, 2064, 17385, 61767}, new char[]{23451, 61302, 48486, 56007, 16064, 40410, 12327, 49229, 44972, 50367, 43523, 4983, 33291, 12922, 31346, 27398, 7673, 27400}, (char) (super.getResources().getString(R.string.pocket_voucher_amount_transaction).substring(0, 11).length() + 59919), new char[]{22809, 18176, 6749, 39402}, KeyEvent.getMaxKeyCode() >> 16, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Gravity.getAbsoluteGravity(0, 0), TextUtils.indexOf("", "", 0, 0) + 18, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    public void onResume() {
        Class<?> cls;
        Object[] objArr;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr2 = new Object[1];
            k(new char[]{32074, 2064, 17385, 61767}, new char[]{59233, 10587, 36916, 22165, 56039, 2417, 17693, 31576, 60151, 35042, 30797, 50050, 1187, 49253, 60448, 389, 47563, 20592, 14702, 53177, 34747, 20978, 60919, 22061, 54218, 33233}, (char) (getPackageName().length() + 45814), new char[]{29388, 565, 64805, 33714}, super.getResources().getString(R.string.parking_description).substring(10, 11).length() - 1, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            char[] cArr = {32074, 2064, 17385, 61767};
            char[] cArr2 = {23451, 61302, 48486, 56007, 16064, 40410, 12327, 49229, 44972, 50367, 43523, 4983, 33291, 12922, 31346, 27398, 7673, 27400};
            try {
                Object[] objArr3 = new Object[1];
                l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[7], objArr3);
                cls = Class.forName((String) objArr3[0]);
                objArr = new Object[1];
                l(NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[41], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[59]), objArr);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr4 = new Object[1];
                k(cArr, cArr2, (char) (((ApplicationInfo) cls.getMethod((String) objArr[0], null).invoke(this, null)).targetSdkVersion + 59897), new char[]{22809, 18176, 6749, 39402}, super.getResources().getString(R.string.pocket_voucher_expired_in_date).substring(10, 15).codePointAt(1) - 37, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, ExpandableListView.getPackedPositionGroup(0L) + 18, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onResume();
    }

    @JvmName(name = "getRecipientPresenter")
    public final RecipientContract.Presenter getRecipientPresenter() {
        RecipientContract.Presenter presenter = this.recipientPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRecipientPresenter")
    public final void setRecipientPresenter(RecipientContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.recipientPresenter = presenter;
    }

    @JvmName(name = "getAmount")
    protected final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    protected final void setAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.amount = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getBelowKitkatDialog")
    public final boolean getBelowKitkatDialog() {
        return this.belowKitkatDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setBelowKitkatDialog")
    public final void setBelowKitkatDialog(boolean z) {
        this.belowKitkatDialog = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getTransactionType")
    public final String getTransactionType() {
        return this.transactionType;
    }

    @JvmName(name = "setTransactionType")
    protected final void setTransactionType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.transactionType = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getDanaLoadingDialog")
    public final DanaLoadingDialog getDanaLoadingDialog() {
        return (DanaLoadingDialog) this.danaLoadingDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public ActivityRecipientV2Binding initViewBinding() {
        ActivityRecipientV2Binding MyBillsEntityDataFactory = ActivityRecipientV2Binding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public void init() {
        initInjector();
        initRecipientView();
    }

    public void processRecipientListData(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        if ((!StringsKt.isBlank(this.amount)) == true) {
            recipientModel.PrepareContext = this.amount;
        }
    }

    public static /* synthetic */ void openSummary$default(BaseRecipientActivity baseRecipientActivity, RecipientModel recipientModel, TransferInit transferInit, TransferInitResultModel transferInitResultModel, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSummary");
        }
        if ((i & 2) != 0) {
            transferInit = null;
        }
        if ((i & 4) != 0) {
            transferInitResultModel = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        baseRecipientActivity.openSummary(recipientModel, transferInit, transferInitResultModel, z);
    }

    public static /* synthetic */ void openSummary$default(BaseRecipientActivity baseRecipientActivity, RecipientModel recipientModel, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSummary");
        }
        if ((i & 2) != 0) {
            str = "";
        }
        baseRecipientActivity.openSummary(recipientModel, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void openSummary(RecipientModel recipientModel, String remarks) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        Intrinsics.checkNotNullParameter(remarks, "");
        Intent intentClassWithTracking = getIntentClassWithTracking(SummaryActivity.class);
        if (intentClassWithTracking != null) {
            intentClassWithTracking.putExtra("data", recipientModel);
            intentClassWithTracking.putExtra("remarks", remarks);
            intentClassWithTracking.putExtra("transferScenario", getTransferScenario(recipientModel));
            if (Intrinsics.areEqual("split_bill", this.transactionType)) {
                intentClassWithTracking.putExtra(DecodedScanBizInfoKey.SPLIT_BILL_ID, getIntent().getStringExtra(DecodedScanBizInfoKey.SPLIT_BILL_ID));
            }
            if (Intrinsics.areEqual("Split Bill", getSource())) {
                intentClassWithTracking.putExtra("source", TrackerKey.SourceType.SPLITBILL_DEEPLINK);
            }
            startActivity(intentClassWithTracking);
            if (Intrinsics.areEqual("split_bill", recipientModel.B)) {
                finish();
            }
        }
    }

    public final void setData(Bundle bundle) {
        QrTransferModel qrTransferModel;
        if (bundle == null || (qrTransferModel = (QrTransferModel) bundle.getParcelable("scanner_data")) == null) {
            return;
        }
        String string = bundle.getString("transactionType", "");
        Intrinsics.checkNotNullExpressionValue(string, "");
        this.transactionType = string;
        handleTransferData(qrTransferModel);
    }

    protected void handleTransferData(QrTransferModel qrTransferModel) {
        String networkUserEntityData$$ExternalSyntheticLambda0;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(qrTransferModel, "");
        if (qrTransferModel.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            String placeComponentResult = qrTransferModel.getPlaceComponentResult();
            if (placeComponentResult == null) {
                placeComponentResult = "";
            }
            this.amount = placeComponentResult;
            networkUserEntityData$$ExternalSyntheticLambda0 = "";
            str = networkUserEntityData$$ExternalSyntheticLambda0;
        } else {
            String networkUserEntityData$$ExternalSyntheticLambda02 = qrTransferModel.getNetworkUserEntityData$$ExternalSyntheticLambda0();
            if (networkUserEntityData$$ExternalSyntheticLambda02 == null || StringsKt.isBlank(networkUserEntityData$$ExternalSyntheticLambda02)) {
                networkUserEntityData$$ExternalSyntheticLambda0 = qrTransferModel.getGetErrorConfigVersion();
                if (networkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    networkUserEntityData$$ExternalSyntheticLambda0 = "";
                }
                str = "phonenumber";
            } else {
                networkUserEntityData$$ExternalSyntheticLambda0 = qrTransferModel.getNetworkUserEntityData$$ExternalSyntheticLambda0();
                if (networkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    networkUserEntityData$$ExternalSyntheticLambda0 = "";
                }
                str = "userid";
            }
        }
        if ((!StringsKt.isBlank(networkUserEntityData$$ExternalSyntheticLambda0)) == true && (!StringsKt.isBlank(str)) == true) {
            RecipientModel.Builder builder = new RecipientModel.Builder("contact");
            builder.scheduleImpl = networkUserEntityData$$ExternalSyntheticLambda0;
            builder.PrepareContext = str;
            builder.initRecordTimeStamp = qrTransferModel.getLookAheadTest();
            builder.GetContactSyncConfig = qrTransferModel.getGetErrorConfigVersion();
            String kClassImpl$Data$declaredNonStaticMembers$2 = qrTransferModel.getKClassImpl$Data$declaredNonStaticMembers$2();
            if (kClassImpl$Data$declaredNonStaticMembers$2 == null) {
                kClassImpl$Data$declaredNonStaticMembers$2 = "";
            }
            builder.getErrorConfigVersion = kClassImpl$Data$declaredNonStaticMembers$2;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = qrTransferModel.getPlaceComponentResult();
            builder.BuiltInFictitiousFunctionClassFactory = true;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda5 = getTransferScenario(qrTransferModel);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = this.transactionType;
            String moveToNextValue = qrTransferModel.getMoveToNextValue();
            if (Intrinsics.areEqual(moveToNextValue, DecodeQrBizType.PROFILE_CODE)) {
                str2 = RecipientSource.REQ_MONEY_USER_WITHOUT_AMOUNT;
            } else {
                str2 = Intrinsics.areEqual(moveToNextValue, DecodeQrBizType.TRANSFER_CODE) ? RecipientSource.REQ_MONEY_USER_WITH_AMOUNT : "";
            }
            builder.newProxyInstance = str2;
            RecipientModel KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
            String scheduleImpl = qrTransferModel.getScheduleImpl();
            openSummary(KClassImpl$Data$declaredNonStaticMembers$2, scheduleImpl != null ? scheduleImpl : "");
        }
    }

    public final String getTransferScenario(QrTransferModel qrTransferModel) {
        Intrinsics.checkNotNullParameter(qrTransferModel, "");
        return qrTransferModel.lookAheadTest() ? TransferScenario.PROFILE_QR : qrTransferModel.GetContactSyncConfig() ? TransferScenario.REQUEST_MONEY : qrTransferModel.initRecordTimeStamp() ? TransferScenario.REQUEST_MONEY_BANK_QR : "";
    }

    public final String getTransferScenario(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        if (Intrinsics.areEqual("split_bill", this.transactionType)) {
            return TransferScenario.SPLIT_BILL;
        }
        String str = recipientModel.BottomSheetCardBindingView$watcherCardNumberView$1;
        Intrinsics.checkNotNullExpressionValue(str, "");
        return str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        if (requestCode == lookAheadTest) {
            RecipientModel recipientModel = (RecipientModel) data.getParcelableExtra("data");
            if (recipientModel != null) {
                Intrinsics.checkNotNullExpressionValue(recipientModel, "");
                openSummary(recipientModel);
            }
        } else if (requestCode == ScannerActionFactory.BuiltInFictitiousFunctionClassFactory) {
            setData(data.getExtras());
        }
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        lookAheadTest = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    public void openSummary(RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        recipientModel.B = "send_money";
        Intent intentClassWithTracking = getIntentClassWithTracking(SummaryActivity.class);
        intentClassWithTracking.putExtra("data", recipientModel);
        intentClassWithTracking.putExtra("transferScenario", getIntent().getStringExtra("transferScenario"));
        Bundle extras = getIntent().getExtras();
        intentClassWithTracking.putExtra("is_from_payroll", extras != null ? Boolean.valueOf(extras.getBoolean("is_from_payroll")) : null);
        startActivity(intentClassWithTracking);
    }

    public final void openSummary(RecipientModel recipientModel, TransferInit bizTransferInitResultModel, TransferInitResultModel transferBalanceInitResultModel, boolean isNewNumber) {
        Intrinsics.checkNotNullParameter(recipientModel, "");
        recipientModel.B = "send_money";
        Intent intentClassWithTracking = getIntentClassWithTracking(SummaryActivity.class);
        intentClassWithTracking.putExtra("data", recipientModel);
        intentClassWithTracking.putExtra("isNewNumber", isNewNumber);
        intentClassWithTracking.putExtra("transferScenario", getIntent().getStringExtra("transferScenario"));
        Bundle extras = getIntent().getExtras();
        Intent putExtra = intentClassWithTracking.putExtra("is_from_payroll", extras != null ? Boolean.valueOf(extras.getBoolean("is_from_payroll")) : null);
        Intrinsics.checkNotNullExpressionValue(putExtra, "");
        if (bizTransferInitResultModel != null) {
            putExtra.putExtra(SummaryActivity.BIZ_TRANSFER_INIT, bizTransferInitResultModel);
        } else if (transferBalanceInitResultModel != null) {
            putExtra.putExtra(SummaryActivity.TRANSFER_BALANCE_INIT, transferBalanceInitResultModel);
        }
        startActivity(putExtra);
    }

    private static void k(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr3.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr3, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr2.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4360990799332652212L)) ^ ((int) (DatabaseTableConfigUtil ^ 4360990799332652212L))) ^ ((char) (PrepareContext ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
