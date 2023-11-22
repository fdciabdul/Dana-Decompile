package id.dana.electronicmoney.activity;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BulletSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.ThrottledOnClickListenerKt;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.extension.ViewExtKt;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.ElectronicMoneyAnalyticModule;
import id.dana.electronicmoney.BalanceResult;
import id.dana.electronicmoney.ElectronicMoneyCallback;
import id.dana.electronicmoney.ElectronicMoneyException;
import id.dana.electronicmoney.ElectronicMoneyManager;
import id.dana.electronicmoney.ElectronicMoneyManager$readCardType$1;
import id.dana.electronicmoney.bank.bri.BriBrizziManager;
import id.dana.electronicmoney.bank.bri.BriBrizziManager$readBalance$1;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager;
import id.dana.electronicmoney.constants.ElectronicMoneyErrorCode;
import id.dana.electronicmoney.constants.ElectronicMoneyName;
import id.dana.electronicmoney.di.DaggerElectronicMoneyComponent;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;
import id.dana.electronicmoney.util.ElectronicMoneyUtils;
import id.dana.electronicmoney.view.CardReadStatus;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.util.AndroidComponentUtilsKt;
import id.dana.util.MinApiUtils;
import id.dana.utils.DANAToast;
import id.dana.utils.OSUtil;
import id.dana.utils.SizeUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 G2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\bF\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0005\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010 J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u001cJ+\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0007\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0007\u0010#J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0007\u0010\u000bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010$R$\u0010\u001f\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020%8\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b&\u0010'\"\u0004\b\u0007\u0010(R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010\u0005\u001a\u00020;8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u00102\u001a\u00020>8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010?\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010*R\u0014\u0010<\u001a\u00020B8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u00103"}, d2 = {"Lid/dana/electronicmoney/activity/ElectronicMoneyActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lid/dana/electronicmoney/BalanceResult;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/electronicmoney/BalanceResult;)V", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "()Z", "(Z)V", "", "", "", "p1", "", "getAuthRequestContext", "([Ljava/lang/String;I)Ljava/lang/CharSequence;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onPause", "()V", "onResume", "onStart", "PlaceComponentResult", "(Ljava/lang/String;)V", "p2", "(ZLjava/lang/Integer;Ljava/lang/Integer;)V", "(Lid/dana/electronicmoney/BalanceResult;Z)V", "Lid/dana/electronicmoney/BalanceResult;", "Lid/dana/electronicmoney/view/CardReadStatus;", "lookAheadTest", "Lid/dana/electronicmoney/view/CardReadStatus;", "(Lid/dana/electronicmoney/view/CardReadStatus;)V", "getErrorConfigVersion", "Ljava/lang/String;", "Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;", "electronicMoneyMixpanelTracker", "Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;", "getElectronicMoneyMixpanelTracker", "()Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;", "setElectronicMoneyMixpanelTracker", "(Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;)V", "moveToNextValue", "Z", "Lid/dana/electronicmoney/ElectronicMoneyManager;", "manager", "Lid/dana/electronicmoney/ElectronicMoneyManager;", "getManager", "()Lid/dana/electronicmoney/ElectronicMoneyManager;", "setManager", "(Lid/dana/electronicmoney/ElectronicMoneyManager;)V", "Landroid/nfc/NfcAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/nfc/NfcAdapter;", "Landroid/app/PendingIntent;", "scheduleImpl", "Landroid/app/PendingIntent;", "DatabaseTableConfigUtil", "Lid/dana/electronicmoney/activity/ElectronicMoneyActivity$timer$1;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/electronicmoney/activity/ElectronicMoneyActivity$timer$1;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ElectronicMoneyActivity extends AppCompatActivity {
    public static final String EXTRA_ACTIVE_ELECTRONIC_MONEYS = "activeElectronicMoneys";
    public static final String EXTRA_CARD_NUMBER = "electronicMoney.CardNumber";
    public static final String EXTRA_REQUESTED_CARD_TYPE = "requestedCardType";
    public static final String EXTRA_SOURCE_CLICK = "sourceClick";
    public static final String EXTRA_TOPUP_ENABLE = "topUpEnable";
    private static int GetContactSyncConfig;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda7;
    private static long initRecordTimeStamp;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private BalanceResult MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private NfcAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public ElectronicMoneyAnalyticTracker electronicMoneyMixpanelTracker;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ElectronicMoneyManager manager;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private PendingIntent moveToNextValue;
    public static final byte[] $$a = {62, -79, -77, -78, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 215;
    public static final byte[] PlaceComponentResult = {Ascii.EM, 16, -94, Ascii.FS, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 45;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean lookAheadTest = true;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final ElectronicMoneyActivity$timer$1 NetworkUserEntityData$$ExternalSyntheticLambda0 = new CountDownTimer() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$timer$1
        @Override // android.os.CountDownTimer
        public final void onTick(long p0) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(10000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            CardReadStatus cardReadStatus;
            cardReadStatus = ElectronicMoneyActivity.this.PlaceComponentResult;
            if (cardReadStatus == CardReadStatus.TAP_ELECTRONIC_MONEY_CARD) {
                ElectronicMoneyActivity.this.BuiltInFictitiousFunctionClassFactory(CardReadStatus.SCAN_CARD_TIMEOUT);
            }
        }
    };

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private CardReadStatus PlaceComponentResult = CardReadStatus.TAP_ELECTRONIC_MONEY_CARD;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[CardReadStatus.values().length];
            iArr[CardReadStatus.TAP_ELECTRONIC_MONEY_CARD.ordinal()] = 1;
            iArr[CardReadStatus.READING_ELECTRONIC_MONEY_CARD.ordinal()] = 2;
            iArr[CardReadStatus.SHOWING_BRI_BRIZZI_BALANCE.ordinal()] = 3;
            iArr[CardReadStatus.SHOWING_MANDIRI_EMONEY_BALANCE.ordinal()] = 4;
            iArr[CardReadStatus.SCAN_CARD_TIMEOUT.ordinal()] = 5;
            iArr[CardReadStatus.CARD_READ_FAILED.ordinal()] = 6;
            iArr[CardReadStatus.SOMETHING_WRONG.ordinal()] = 7;
            iArr[CardReadStatus.CARD_UNSUPPORTED.ordinal()] = 8;
            iArr[CardReadStatus.SHOWING_CALL_CS.ordinal()] = 9;
            iArr[CardReadStatus.CARD_EXPIRED.ordinal()] = 10;
            iArr[CardReadStatus.UPDATE_BALANCE_FAILED.ordinal()] = 11;
            iArr[CardReadStatus.BALANCE_REACH_LIMIT.ordinal()] = 12;
            iArr[CardReadStatus.NO_NETWORK_CONNECTION.ordinal()] = 13;
            iArr[CardReadStatus.RETRY_UPDATE_CARD_LIMIT.ordinal()] = 14;
            iArr[CardReadStatus.INQUIRY_BALANCE_FAILED.ordinal()] = 15;
            PlaceComponentResult = iArr;
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        NetworkUserEntityData$$ExternalSyntheticLambda7 = (char) 13492;
        initRecordTimeStamp = -4233784197280170685L;
        GetContactSyncConfig = -956812108;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.electronicmoney.activity.ElectronicMoneyActivity.PlaceComponentResult
            int r6 = r6 + 97
            int r7 = r7 + 16
            int r8 = 55 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            int r8 = r8 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.activity.ElectronicMoneyActivity.b(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r6 = r6 * 3
            int r6 = 42 - r6
            byte[] r0 = id.dana.electronicmoney.activity.ElectronicMoneyActivity.$$a
            int r7 = 46 - r7
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
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
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
            int r6 = -r6
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.activity.ElectronicMoneyActivity.c(short, int, short, java.lang.Object[]):void");
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

    /* JADX WARN: Removed duplicated region for block: B:112:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0736  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0905  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0abe A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x056e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0909 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x073f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0281 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0274  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r26) {
        /*
            Method dump skipped, instructions count: 3158
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.activity.ElectronicMoneyActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @JvmName(name = "getManager")
    public final ElectronicMoneyManager getManager() {
        ElectronicMoneyManager electronicMoneyManager = this.manager;
        if (electronicMoneyManager != null) {
            return electronicMoneyManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setManager")
    public final void setManager(ElectronicMoneyManager electronicMoneyManager) {
        Intrinsics.checkNotNullParameter(electronicMoneyManager, "");
        this.manager = electronicMoneyManager;
    }

    @JvmName(name = "getElectronicMoneyMixpanelTracker")
    public final ElectronicMoneyAnalyticTracker getElectronicMoneyMixpanelTracker() {
        ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker = this.electronicMoneyMixpanelTracker;
        if (electronicMoneyAnalyticTracker != null) {
            return electronicMoneyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setElectronicMoneyMixpanelTracker")
    public final void setElectronicMoneyMixpanelTracker(ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(electronicMoneyAnalyticTracker, "");
        this.electronicMoneyMixpanelTracker = electronicMoneyAnalyticTracker;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Object[] objArr2;
        Parcelable parcelable;
        byte b = 0;
        Object[] objArr3 = new Object[1];
        a(new char[]{51703, 34699, 51634, 63931}, new char[]{12514, 6326, 35276, 61949}, super.getResources().getString(R.string.success_delete_group_from_favorite).substring(0, 2).codePointAt(0) - 71, (char) (getPackageName().codePointAt(1) + 64805), new char[]{22732, 30723, 2066, 14551, 9465, 37988, 26291, 13298, 34057, 20533, 34483, 49393, 35979, 691, 46851, 1264, 62005, 57770}, objArr3);
        Class<?> cls = Class.forName((String) objArr3[0]);
        char[] cArr = {51703, 34699, 51634, 63931};
        char[] cArr2 = {38835, 47927, 25569, 35454};
        int codePointAt = getPackageName().codePointAt(4) - 507824330;
        try {
            Object[] objArr4 = new Object[1];
            b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr5);
            Object[] objArr6 = new Object[1];
            a(cArr, cArr2, codePointAt, (char) (((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 32322), new char[]{761, 22611, 27908, 16437, 46102}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr7 = new Object[1];
                    a(new char[]{51703, 34699, 51634, 63931}, new char[]{18700, 64852, 43959, 39154}, super.getResources().getString(R.string.empty_state_investment_desc_v3).substring(6, 7).length() - 1, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 62123), new char[]{51538, 39412, 24632, 37142, 33039, 30766, 20027, 682, 6427, 8353, 18518, 47511, 39226, 1935, 29880, 25651, 5169, 55479, 38995, 18760, 19687, 21882, 60330, 44426, 41074, 61432}, objArr7);
                    Class<?> cls3 = Class.forName((String) objArr7[0]);
                    char[] cArr3 = {51703, 34699, 51634, 63931};
                    char[] cArr4 = {59949, 8033, 19854, 27249};
                    int length = getPackageName().length() - 7;
                    try {
                        Object[] objArr8 = new Object[1];
                        b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr9);
                        Object[] objArr10 = new Object[1];
                        a(cArr3, cArr4, length, (char) (((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 28972), new char[]{30480, 27230, 34571, 61818, 48668, 59136, 1527, 49306, 20562, 31390, 39076, 61147, 10895, 56984, 34824, 30517, 22521, 36205}, objArr10);
                        baseContext = (Context) cls3.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
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
                        if (obj != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), 35 - Drawable.resolveOpacity(0, 0), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(objArr, objArr);
                        char[] cArr5 = {51703, 34699, 51634, 63931};
                        char[] cArr6 = {59233, 9542, 36479, 34402};
                        try {
                            Object[] objArr11 = new Object[1];
                            b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr11);
                            Class<?> cls5 = Class.forName((String) objArr11[0]);
                            b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], new Object[1]);
                            Object[] objArr12 = new Object[1];
                            a(cArr5, cArr6, ((ApplicationInfo) cls5.getMethod((String) r5[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.image_capture_see_photo_tip_remark).substring(1, 2).codePointAt(0) - 97), new char[]{17796, 51091, 44059, 14997, 55552, 24031, 12580, 48532, 1391, 12130, 33742, 41430, 23312, 52350, 186, 6430, 20899, 39493, 54868, 42340, 3057, 31019, 53573, 45162, 16577, 56665, 39002, 46973, 2459, 14269, 46778, 16373, 53382, 302, 36873, 38338, 59702, 26197, 24099, 38211, 28825, 31132, 48592, 15679, 27167, 41729, 12630, 21302}, objArr12);
                            String str = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a(new char[]{51703, 34699, 51634, 63931}, new char[]{49946, 38430, 60268, 21093}, getPackageName().codePointAt(2) - 46, (char) (super.getResources().getString(R.string.my_bills_edit_bills_save_changes_dialog_confirmation_left_btn).substring(1, 2).codePointAt(0) - 97), new char[]{55696, 60411, 4630, 63573, 40685, 52237, 47237, 19193, 45616, 36032, 27163, 6572, 4134, 50732, 7400, 28899, 40328, 64999, 62863, 21695, 36444, 17403, 61122, 29354, 55929, 53544, 52948, 35568, 56525, 25564, 52508, 14950, 31407, 21269, 28945, 5008, 20751, 21800, 23131, 37867, 55119, 2222, 38789, 10401, 36487, 38011, 33599, 14718, 6409, 60812, 26655, 35948, 48627, 21056, 21243, 40744, 55458, 64534, 46872, 47584, 2661, 22859, 5556, 8902}, objArr13);
                            String str2 = (String) objArr13[0];
                            char[] cArr7 = {51703, 34699, 51634, 63931};
                            char[] cArr8 = {45382, 61827, 10501, 44927};
                            try {
                                Object[] objArr14 = new Object[1];
                                b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr14);
                                Class<?> cls6 = Class.forName((String) objArr14[0]);
                                b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], new Object[1]);
                                Object[] objArr15 = new Object[1];
                                a(cArr7, cArr8, ((ApplicationInfo) cls6.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(6) - 97), new char[]{19266, 60765, 9107, 29386, 18869, 18443, 40582, 54577, 3454, 10576, 28212, 27382, 54863, 44749, 11259, 29465, 11440, 39274, 23445, 59518, 31873, 61247, 53380, 62849, 24265, 18670, 8743, 37350, 23167, 58429, 32103, 4785, 40696, 4863, 65342, 46340, 13902, 49208, 1523, 60326, 39192, 51835, 5219, 36236, 34465, 1295, 34102, 56134, 16599, 40806, 35832, 21135, 36380, 42335, 25752, 30055, 1029, 59325, 62949, 50533, 10503, 36253, 27839, 30994}, objArr15);
                                String str3 = (String) objArr15[0];
                                char[] cArr9 = {51703, 34699, 51634, 63931};
                                char[] cArr10 = {55006, 24394, 48027, 2662};
                                try {
                                    Object[] objArr16 = new Object[1];
                                    b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr16);
                                    Class<?> cls7 = Class.forName((String) objArr16[0]);
                                    b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], new Object[1]);
                                    Object[] objArr17 = new Object[1];
                                    a(cArr9, cArr10, ((ApplicationInfo) cls7.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (super.getResources().getString(R.string.family_account_success_remove_family_member_message).substring(16, 17).codePointAt(0) - 32), new char[]{62467, 20940, 27947, 35931, 41921, 33259, '*', 35856, 59114, 57610, 27730, 32629, 33149, 16721, 65185, 36484, 12042, 48170, 49164, 19607, 38423, 53363, 51994, 50328, 29839, 59034, 13687, 9773, 8956, 12595, 2526, 45465, 10629, 36324, 2889, 17910, 19123, 35832, 20331, 19707, 47561, 24641, 11098, 49458, 42768, 38545, 21009, 55614, 28112, 27682, 16371, 20165, 18516, 61778, 58210, 9410, 40284, 15015, 29204, 26125}, objArr17);
                                    String str4 = (String) objArr17[0];
                                    Object[] objArr18 = new Object[1];
                                    a(new char[]{51703, 34699, 51634, 63931}, new char[]{4063, 54844, 4325, 28277}, super.getResources().getString(R.string.passkey_enrollment_tnc_description_tnc_link).substring(18, 19).length() - 1, (char) (super.getResources().getString(R.string.pop_up_description_saving_limit_about_info_non_kyc).substring(91, 93).length() + 29966), new char[]{17242, 952, 45255, 22242, 44867, 5911}, objArr18);
                                    try {
                                        Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), Process.getGidForName("") + 19, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                }
            }
            try {
                Object[] objArr20 = new Object[1];
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr20);
                Class<?> cls8 = Class.forName((String) objArr20[0]);
                byte b2 = (byte) (getAuthRequestContext & 26);
                byte b3 = PlaceComponentResult[25];
                Object[] objArr21 = new Object[1];
                b(b2, b3, (byte) (b3 | Ascii.RS), objArr21);
                try {
                    Object[] objArr22 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getDoubleTapTimeout() >> 16), TextUtils.getOffsetBefore("", 0) + 4, (char) ((-1) - MotionEvent.axisFromString("")));
                        byte b4 = (byte) ($$a[47] - 1);
                        byte b5 = b4;
                        Object[] objArr23 = new Object[1];
                        c(b4, b5, b5, objArr23);
                        obj3 = cls9.getMethod((String) objArr23[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {-69656806, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), TextUtils.getTrimmedLength("") + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr25);
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
                    } else {
                        objArr2 = null;
                    }
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_electronic_money);
                    setRequestedOrientation((OSUtil.DatabaseTableConfigUtil() || OSUtil.initRecordTimeStamp()) ? -1 : 1);
                    DaggerElectronicMoneyComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerElectronicMoneyComponent.KClassImpl$Data$declaredNonStaticMembers$2();
                    Application application = getApplication();
                    if (application == null) {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ElectronicMoneyAnalyticModule) Preconditions.getAuthRequestContext(new ElectronicMoneyAnalyticModule());
                    if (KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new ElectronicMoneyAnalyticModule();
                    }
                    Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, ApplicationComponent.class);
                    new DaggerElectronicMoneyComponent.ElectronicMoneyComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, b).PlaceComponentResult(this);
                    List<String> list = getManager().BuiltInFictitiousFunctionClassFactory;
                    String[] stringArrayExtra = getIntent().getStringArrayExtra(EXTRA_ACTIVE_ELECTRONIC_MONEYS);
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    CollectionsKt.addAll(list, stringArrayExtra);
                    getLifecycle().BuiltInFictitiousFunctionClassFactory(getManager());
                    AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.getDefaultAsyncJsApiList);
                    if (appCompatImageView != null) {
                        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda6
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ElectronicMoneyActivity.$r8$lambda$FjOeUFpSTxmjEBvmrokc7PLw3WE(ElectronicMoneyActivity.this, view);
                            }
                        });
                    }
                    DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                    if (danaButtonSecondaryView != null) {
                        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda7
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ElectronicMoneyActivity.$r8$lambda$FRiRG8N2uk2vHByos9WoriJOa9Y(ElectronicMoneyActivity.this, view);
                            }
                        });
                    }
                    DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                    if (danaButtonPrimaryView != null) {
                        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda8
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ElectronicMoneyActivity.$r8$lambda$1ztZR2bO5x8BzGjHEDZnRkPBVo8(ElectronicMoneyActivity.this, view);
                            }
                        });
                    }
                    DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getCallingPid_res_0x7f0a0134);
                    if (danaButtonSecondaryView2 != null) {
                        danaButtonSecondaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda9
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ElectronicMoneyActivity.m2577$r8$lambda$YHQHQ85d8YMLTSXcBCS2NV7g3M(ElectronicMoneyActivity.this, view);
                            }
                        });
                    }
                    DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnCallCsCall);
                    if (danaButtonPrimaryView2 != null) {
                        danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda10
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ElectronicMoneyActivity.$r8$lambda$nHffUJkiqvNpGdrArID7Cxbqeqo(ElectronicMoneyActivity.this, view);
                            }
                        });
                    }
                    DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.b);
                    if (danaButtonPrimaryView3 != null) {
                        danaButtonPrimaryView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda11
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ElectronicMoneyActivity.$r8$lambda$BW_V1l9LKvjbGDlWjCKIGHQNP1A(ElectronicMoneyActivity.this, view);
                            }
                        });
                    }
                    DanaButtonSecondaryView danaButtonSecondaryView3 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.btnBrizziTopUp);
                    if (danaButtonSecondaryView3 != null) {
                        danaButtonSecondaryView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda12
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ElectronicMoneyActivity.$r8$lambda$CYGJYzDLpQ_mtUPw2vEKRl3Af3A(ElectronicMoneyActivity.this, view);
                            }
                        });
                    }
                    BuiltInFictitiousFunctionClassFactory(CardReadStatus.TAP_ELECTRONIC_MONEY_CARD);
                    ElectronicMoneyActivity electronicMoneyActivity = this;
                    NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(electronicMoneyActivity);
                    Intrinsics.checkNotNullExpressionValue(defaultAdapter, "");
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = defaultAdapter;
                    PendingIntent activity = PendingIntent.getActivity(electronicMoneyActivity, 0, new Intent(electronicMoneyActivity, getClass()).addFlags(536870912), MinApiUtils.PlaceComponentResult() ? 33554432 : 0);
                    Intrinsics.checkNotNullExpressionValue(activity, "");
                    this.moveToNextValue = activity;
                    this.BuiltInFictitiousFunctionClassFactory = getIntent().getStringExtra(EXTRA_REQUESTED_CARD_TYPE);
                    this.scheduleImpl = getIntent().getStringExtra(EXTRA_SOURCE_CLICK);
                    this.lookAheadTest = getIntent().getBooleanExtra(EXTRA_TOPUP_ENABLE, true);
                    Intent intent = getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "");
                    if (Build.VERSION.SDK_INT >= 26) {
                        parcelable = intent.getParcelableExtra("android.nfc.extra.TAG");
                    } else {
                        Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
                        parcelable = (Intent) (!(parcelableExtra instanceof Intent) ? objArr2 : parcelableExtra);
                    }
                    Intent intent2 = (Intent) parcelable;
                    if (intent2 == null) {
                        return;
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2(intent2);
                    DanaApplication MyBillsEntityDataFactory = AndroidComponentUtilsKt.MyBillsEntityDataFactory(this);
                    if (MyBillsEntityDataFactory != null) {
                        MyBillsEntityDataFactory.chckTmprdApp();
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(new char[]{51703, 34699, 51634, 63931}, new char[]{18700, 64852, 43959, 39154}, super.getResources().getString(R.string.option_block_friend).substring(0, 3).length() - 3, (char) (getPackageName().length() + 62116), new char[]{51538, 39412, 24632, 37142, 33039, 30766, 20027, 682, 6427, 8353, 18518, 47511, 39226, 1935, 29880, 25651, 5169, 55479, 38995, 18760, 19687, 21882, 60330, 44426, 41074, 61432}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{51703, 34699, 51634, 63931}, new char[]{59949, 8033, 19854, 27249}, AndroidCharacter.getMirror('0') - '0', (char) (getPackageName().length() + 28998), new char[]{30480, 27230, 34571, 61818, 48668, 59136, 1527, 49306, 20562, 31390, 39076, 61147, 10895, 56984, 34824, 30517, 22521, 36205}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), 35 - KeyEvent.getDeadChar(0, 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), TextUtils.getOffsetBefore("", 0) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        NfcAdapter nfcAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (nfcAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nfcAdapter = null;
        }
        if (!nfcAdapter.isEnabled()) {
            startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        }
        NfcAdapter nfcAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (nfcAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nfcAdapter2 = null;
        }
        ElectronicMoneyActivity electronicMoneyActivity = this;
        PendingIntent pendingIntent = this.moveToNextValue;
        if (pendingIntent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            pendingIntent = null;
        }
        nfcAdapter2.enableForegroundDispatch(electronicMoneyActivity, pendingIntent, null, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        NfcAdapter nfcAdapter = null;
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(new char[]{51703, 34699, 51634, 63931}, new char[]{18700, 64852, 43959, 39154}, TextUtils.getOffsetBefore("", 0), (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 62123), new char[]{51538, 39412, 24632, 37142, 33039, 30766, 20027, 682, 6427, 8353, 18518, 47511, 39226, 1935, 29880, 25651, 5169, 55479, 38995, 18760, 19687, 21882, 60330, 44426, 41074, 61432}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{51703, 34699, 51634, 63931}, new char[]{59949, 8033, 19854, 27249}, super.getResources().getString(R.string.set_success).substring(1, 2).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN, (char) (getPackageName().codePointAt(4) + 28908), new char[]{30480, 27230, 34571, 61818, 48668, 59136, 1527, 49306, 20562, 31390, 39076, 61147, 10895, 56984, 34824, 30517, 22521, 36205}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - KeyEvent.normalizeMetaState(0), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, MotionEvent.axisFromString("") + 19, (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        NfcAdapter nfcAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (nfcAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            nfcAdapter = nfcAdapter2;
        }
        nfcAdapter.disableForegroundDispatch(this);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        super.onNewIntent(intent);
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1634370981) {
                if (hashCode != -1468892125) {
                    if (hashCode != 1865807226 || !action.equals("android.nfc.action.NDEF_DISCOVERED")) {
                        return;
                    }
                } else if (!action.equals("android.nfc.action.TAG_DISCOVERED")) {
                    return;
                }
            } else if (!action.equals("android.nfc.action.TECH_DISCOVERED")) {
                return;
            }
            intent.putExtra(EXTRA_SOURCE_CLICK, this.scheduleImpl);
            KClassImpl$Data$declaredNonStaticMembers$2(intent);
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(final Intent p0) {
        BuiltInFictitiousFunctionClassFactory(CardReadStatus.READING_ELECTRONIC_MONEY_CARD);
        ElectronicMoneyCallback electronicMoneyCallback = new ElectronicMoneyCallback() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$processTag$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Illegal instructions before constructor call */
            /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineScope] */
            {
                /*
                    r1 = this;
                    id.dana.electronicmoney.activity.ElectronicMoneyActivity.this = r2
                    r2 = 0
                    r0 = 1
                    r1.<init>(r2, r0, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.activity.ElectronicMoneyActivity$processTag$callback$1.<init>(id.dana.electronicmoney.activity.ElectronicMoneyActivity):void");
            }

            @Override // id.dana.electronicmoney.ElectronicMoneyCallback
            public final void MyBillsEntityDataFactory(BalanceResult p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                ElectronicMoneyActivity.this.MyBillsEntityDataFactory = p02;
                if (p02.getScheduleImpl() || ArraysKt.contains(new String[]{"009", "010"}, p02.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    ElectronicMoneyActivity.this.BuiltInFictitiousFunctionClassFactory(p02, Intrinsics.areEqual(p02.KClassImpl$Data$declaredNonStaticMembers$2, "009"));
                    return;
                }
                ElectronicMoneyActivity electronicMoneyActivity = ElectronicMoneyActivity.this;
                String str = p02.KClassImpl$Data$declaredNonStaticMembers$2;
                electronicMoneyActivity.getAuthRequestContext(str != null ? str : "");
            }

            @Override // id.dana.electronicmoney.ElectronicMoneyCallback
            public final void BuiltInFictitiousFunctionClassFactory(ElectronicMoneyException p02) {
                ElectronicMoneyActivity.this.getAuthRequestContext(p02 != null ? p02.getCode() : null);
            }
        };
        String str = this.BuiltInFictitiousFunctionClassFactory;
        BriBrizziManager briBrizziManager = null;
        if (str == null || str.length() == 0) {
            final ElectronicMoneyManager manager = getManager();
            final ElectronicMoneyCallback electronicMoneyCallback2 = electronicMoneyCallback;
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(electronicMoneyCallback2, "");
            BuildersKt__Builders_commonKt.launch$default((CoroutineScope) manager.getAuthRequestContext.getValue(), null, null, new ElectronicMoneyManager$readCardType$1(new Function1<String, Unit>() { // from class: id.dana.electronicmoney.ElectronicMoneyManager$updateAndReadBalance$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str2) {
                    BriBrizziManager briBrizziManager2;
                    MandiriEmoneyManager mandiriEmoneyManager;
                    if (CollectionsKt.contains(ElectronicMoneyManager.this.BuiltInFictitiousFunctionClassFactory, str2)) {
                        if (Intrinsics.areEqual(str2, ElectronicMoneyName.EMONEY)) {
                            mandiriEmoneyManager = ElectronicMoneyManager.this.PlaceComponentResult;
                            mandiriEmoneyManager.BuiltInFictitiousFunctionClassFactory(p0, electronicMoneyCallback2);
                        } else if (Intrinsics.areEqual(str2, ElectronicMoneyName.BRIZZI)) {
                            briBrizziManager2 = ElectronicMoneyManager.this.MyBillsEntityDataFactory;
                            Intent intent = p0;
                            ElectronicMoneyCallback electronicMoneyCallback3 = electronicMoneyCallback2;
                            Intrinsics.checkNotNullParameter(intent, "");
                            Intrinsics.checkNotNullParameter(electronicMoneyCallback3, "");
                            briBrizziManager2.KClassImpl$Data$declaredNonStaticMembers$2(intent, new BriBrizziManager$readBalance$1(briBrizziManager2, intent, electronicMoneyCallback3));
                        } else {
                            ?? r2 = 0;
                            electronicMoneyCallback2.BuiltInFictitiousFunctionClassFactory(new ElectronicMoneyException("004", r2, 2, r2));
                        }
                    }
                }
            }, manager, p0, null), 3, null);
            return;
        }
        ElectronicMoneyManager manager2 = getManager();
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        if (Intrinsics.areEqual(str2, ElectronicMoneyName.EMONEY)) {
            briBrizziManager = manager2.PlaceComponentResult;
        } else if (Intrinsics.areEqual(str2, ElectronicMoneyName.BRIZZI)) {
            briBrizziManager = manager2.MyBillsEntityDataFactory;
        }
        if (briBrizziManager != null) {
            ElectronicMoneyCallback electronicMoneyCallback3 = electronicMoneyCallback;
            if (Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ElectronicMoneyName.BRIZZI) && !this.getAuthRequestContext) {
                briBrizziManager.PlaceComponentResult(p0, electronicMoneyCallback3);
            } else {
                briBrizziManager.BuiltInFictitiousFunctionClassFactory(p0, electronicMoneyCallback3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(BalanceResult p0, boolean p1) {
        String string;
        String str;
        try {
            PlaceComponentResult(p0);
            TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
            if (textView != null) {
                if (p1) {
                    str = getString(R.string.desc_reversal_error);
                } else {
                    ElectronicMoneyUtils electronicMoneyUtils = ElectronicMoneyUtils.INSTANCE;
                    String PlaceComponentResult2 = ElectronicMoneyUtils.PlaceComponentResult("dd MMM YYYY hh:mm:ss");
                    if (Intrinsics.areEqual(p0.MyBillsEntityDataFactory, ElectronicMoneyName.BRIZZI)) {
                        string = getString(R.string.desc_update_saldo_fourth, PlaceComponentResult2, p0.lookAheadTest);
                    } else {
                        string = getString(R.string.desc_update_saldo_third, PlaceComponentResult2);
                    }
                    str = string;
                }
                textView.setText(str);
            }
            BuiltInFictitiousFunctionClassFactory(p1);
        } catch (NumberFormatException unused) {
            getAuthRequestContext("001");
        }
    }

    private final void PlaceComponentResult(BalanceResult p0) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a13f3_appupdatemanagerktxkt_requestappupdateinfo_1);
        if (textView != null) {
            ElectronicMoneyUtils electronicMoneyUtils = ElectronicMoneyUtils.INSTANCE;
            textView.setText(ElectronicMoneyUtils.MyBillsEntityDataFactory(p0.PlaceComponentResult));
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvCardNumber);
        if (textView2 != null) {
            ElectronicMoneyUtils electronicMoneyUtils2 = ElectronicMoneyUtils.INSTANCE;
            textView2.setText(ElectronicMoneyUtils.getAuthRequestContext(p0.BuiltInFictitiousFunctionClassFactory));
        }
        String str = p0.MyBillsEntityDataFactory;
        if (Intrinsics.areEqual(str, ElectronicMoneyName.BRIZZI)) {
            BuiltInFictitiousFunctionClassFactory(CardReadStatus.SHOWING_BRI_BRIZZI_BALANCE);
        } else if (Intrinsics.areEqual(str, ElectronicMoneyName.EMONEY)) {
            BuiltInFictitiousFunctionClassFactory(CardReadStatus.SHOWING_MANDIRI_EMONEY_BALANCE);
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(BalanceResult p0) {
        if (this.getAuthRequestContext) {
            if (p0.getAuthRequestContext.length() > 0) {
                DANAToast dANAToast = DANAToast.PlaceComponentResult;
                String string = getString(R.string.success_brizzi_activated_balance, p0.getAuthRequestContext);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.getAuthRequestContext(this, string);
                this.getAuthRequestContext = false;
            }
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(final BalanceResult p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnUpdateBalance);
        if (danaButtonPrimaryView != null) {
            ThrottledOnClickListenerKt.PlaceComponentResult(danaButtonPrimaryView, new Function1<View, Unit>() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$checkBrizziPendingBalance$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (view.isEnabled()) {
                        if (!(BalanceResult.this.lookAheadTest.length() == 0) && !Intrinsics.areEqual(BalanceResult.this.lookAheadTest, "0")) {
                            this.getAuthRequestContext = true;
                            this.getElectronicMoneyMixpanelTracker().MyBillsEntityDataFactory(BalanceResult.this.MyBillsEntityDataFactory);
                            this.BuiltInFictitiousFunctionClassFactory(CardReadStatus.TAP_ELECTRONIC_MONEY_CARD);
                            return;
                        }
                        ElectronicMoneyActivity electronicMoneyActivity = this;
                        String string = electronicMoneyActivity.getString(R.string.error_zero_pending_balance);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        CustomToast.BuiltInFictitiousFunctionClassFactory(electronicMoneyActivity, R.drawable.ic_info_orange, R.drawable.bg_rounded_border_yellow_50, string, 64, true, null);
                    }
                }
            });
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(final boolean p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(p0 ? 0 : 8);
            danaButtonPrimaryView.setActiveButton(getString(p0 ? R.string.title_close_button : 17039370), null);
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ElectronicMoneyActivity.$r8$lambda$yOiEf0QRJGMBUB30a9irG4zi9Ng(p0, this, view);
                }
            });
        }
        BuiltInFictitiousFunctionClassFactory(p0, null, Integer.valueOf((int) R.array.warning_reversal_error));
        getAuthRequestContext();
    }

    private final void getAuthRequestContext() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.MerchantReviewDetailActivity_MembersInjector);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvDescInfoBox);
        if (textView != null) {
            textView.setText(getAuthRequestContext(linearLayout.getResources().getStringArray(R.array.information_brizzi_top_up), SizeUtil.getAuthRequestContext(8)));
        }
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(this.PlaceComponentResult == CardReadStatus.SHOWING_BRI_BRIZZI_BALANCE ? 0 : 8);
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0, Integer p1, Integer p2) {
        String str;
        String str2;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.llContainerReversalError);
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a142d_jsapihandler_5_1);
        if (textView != null) {
            if (p2 != null) {
                str2 = getAuthRequestContext(linearLayout.getResources().getStringArray(p2.intValue()), SizeUtil.getAuthRequestContext(8));
            } else {
                if (p1 == null || (str = getString(p1.intValue())) == null) {
                    str = "";
                }
                str2 = str;
            }
            textView.setText(str2);
        }
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.setVisibility(p0 ? 0 : 8);
        if (linearLayout2.getVisibility() == 0) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.b);
            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
            danaButtonPrimaryView.setVisibility(8);
        }
    }

    private static CharSequence getAuthRequestContext(String[] p0, int p1) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (p0 != null) {
            int length = p0.length;
            int i = 0;
            while (i < length) {
                StringBuilder sb = new StringBuilder();
                sb.append(p0[i]);
                sb.append(i < p0.length + (-1) ? "\n" : "");
                SpannableString spannableString = new SpannableString(sb.toString());
                spannableString.setSpan(new BulletSpan(p1), 0, spannableString.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                i++;
            }
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void getAuthRequestContext(String p0) {
        CardReadStatus cardReadStatus;
        if (p0 != null) {
            int hashCode = p0.hashCode();
            if (hashCode != 47665) {
                switch (hashCode) {
                    case 47668:
                        if (p0.equals("004")) {
                            cardReadStatus = CardReadStatus.CARD_UNSUPPORTED;
                            break;
                        }
                        break;
                    case 47669:
                        if (p0.equals("005")) {
                            cardReadStatus = CardReadStatus.CARD_READ_FAILED;
                            break;
                        }
                        break;
                    default:
                        switch (hashCode) {
                            case 47671:
                                if (p0.equals("007")) {
                                    cardReadStatus = CardReadStatus.SCAN_CARD_TIMEOUT;
                                    break;
                                }
                                break;
                            case 47672:
                                if (p0.equals("008")) {
                                    cardReadStatus = CardReadStatus.SHOWING_CALL_CS;
                                    break;
                                }
                                break;
                            default:
                                switch (hashCode) {
                                    case 47696:
                                        if (p0.equals("011")) {
                                            cardReadStatus = CardReadStatus.CARD_EXPIRED;
                                            break;
                                        }
                                        break;
                                    case 47697:
                                        if (p0.equals("012")) {
                                            cardReadStatus = CardReadStatus.UPDATE_BALANCE_FAILED;
                                            break;
                                        }
                                        break;
                                    case 47698:
                                        if (p0.equals("013")) {
                                            cardReadStatus = CardReadStatus.BALANCE_REACH_LIMIT;
                                            break;
                                        }
                                        break;
                                    case 47699:
                                        if (p0.equals(ElectronicMoneyErrorCode.NO_NETWORK_AVAILABLE)) {
                                            cardReadStatus = CardReadStatus.NO_NETWORK_CONNECTION;
                                            break;
                                        }
                                        break;
                                    case 47700:
                                        if (p0.equals(ElectronicMoneyErrorCode.RETRY_UPDATE_CARD_LIMIT)) {
                                            cardReadStatus = CardReadStatus.RETRY_UPDATE_CARD_LIMIT;
                                            break;
                                        }
                                        break;
                                    case 47701:
                                        if (p0.equals(ElectronicMoneyErrorCode.INQUIRY_BALANCE_FAILED)) {
                                            cardReadStatus = CardReadStatus.INQUIRY_BALANCE_FAILED;
                                            break;
                                        }
                                        break;
                                }
                        }
                }
                BuiltInFictitiousFunctionClassFactory(cardReadStatus);
            }
            p0.equals("001");
        }
        cardReadStatus = CardReadStatus.SOMETHING_WRONG;
        BuiltInFictitiousFunctionClassFactory(cardReadStatus);
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(ElectronicMoneyActivity electronicMoneyActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        electronicMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2(z);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        CharSequence text;
        String obj;
        Intent intent = new Intent();
        if (p0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvCardNumber);
            intent.putExtra(EXTRA_CARD_NUMBER, (textView == null || (text = textView.getText()) == null || (obj = text.toString()) == null) ? null : StringsKt.replace$default(obj, " ", "", false, 4, (Object) null));
        }
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(CardReadStatus cardReadStatus) {
        Unit unit;
        this.PlaceComponentResult = cardReadStatus;
        BuiltInFictitiousFunctionClassFactory(false);
        switch (WhenMappings.PlaceComponentResult[cardReadStatus.ordinal()]) {
            case 1:
                start();
                TextView textView = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView != null) {
                    textView.setText(R.string.title_update_saldo_first);
                    Unit unit2 = Unit.INSTANCE;
                }
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView2 != null) {
                    textView2.setText(R.string.desc_tap_card_please);
                    Unit unit3 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView != null) {
                    appCompatImageView.setVisibility(0);
                    ViewExtKt.getAuthRequestContext(appCompatImageView, (int) R.drawable.ic_tap_e_money);
                    Unit unit4 = Unit.INSTANCE;
                }
                DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView != null) {
                    danaButtonSecondaryView.setVisibility(0);
                }
                DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView != null) {
                    danaButtonPrimaryView.setVisibility(8);
                }
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d26_splitmerchantconfigentity_getmerchantdetailpromoconfigentity_2);
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.res_0x7f0a108c_openmerchantformdialog_default);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                    return;
                }
                return;
            case 2:
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    textView3.setText(R.string.title_update_saldo_second);
                    Unit unit5 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView2 != null) {
                    appCompatImageView2.setVisibility(0);
                    ViewExtKt.getAuthRequestContext(appCompatImageView2, (int) R.drawable.ic_my_bill);
                    Unit unit6 = Unit.INSTANCE;
                }
                TextView textView4 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView4 != null) {
                    textView4.setText(R.string.desc_trying_read_card);
                    Unit unit7 = Unit.INSTANCE;
                }
                RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(R.id.res_0x7f0a108c_openmerchantformdialog_default);
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
                DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView2 != null) {
                    danaButtonSecondaryView2.setVisibility(8);
                }
                DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView2 != null) {
                    danaButtonPrimaryView2.setVisibility(8);
                }
                DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.b);
                if (danaButtonPrimaryView3 != null) {
                    danaButtonPrimaryView3.setVisibility(8);
                }
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d26_splitmerchantconfigentity_getmerchantdetailpromoconfigentity_2);
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                    return;
                }
                return;
            case 3:
                BalanceResult balanceResult = this.MyBillsEntityDataFactory;
                if (balanceResult != null) {
                    BuiltInFictitiousFunctionClassFactory(balanceResult);
                    KClassImpl$Data$declaredNonStaticMembers$2(balanceResult);
                    Unit unit8 = Unit.INSTANCE;
                    Unit unit9 = Unit.INSTANCE;
                }
                PlaceComponentResult();
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardBackground);
                if (appCompatImageView3 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView3, (int) R.drawable.ic_card_brizzi_bg);
                    Unit unit10 = Unit.INSTANCE;
                    return;
                }
                return;
            case 4:
                PlaceComponentResult();
                AppCompatImageView appCompatImageView4 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardBackground);
                if (appCompatImageView4 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView4, (int) R.drawable.ic_card_emoney_bg);
                    Unit unit11 = Unit.INSTANCE;
                    return;
                }
                return;
            case 5:
                TextView textView5 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView5 != null) {
                    textView5.setText(R.string.title_scan_card_time_out);
                    Unit unit12 = Unit.INSTANCE;
                }
                TextView textView6 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView6 != null) {
                    textView6.setText(R.string.desc_scan_card_time_out);
                    Unit unit13 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView5 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView5 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView5, (int) R.drawable.ic_timed_out);
                    Unit unit14 = Unit.INSTANCE;
                }
                DanaButtonSecondaryView danaButtonSecondaryView3 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView3 != null) {
                    danaButtonSecondaryView3.setVisibility(8);
                }
                DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView4 != null) {
                    danaButtonPrimaryView4.setActiveButton(getString(R.string.try_again), null);
                    danaButtonPrimaryView4.setVisibility(0);
                    danaButtonPrimaryView4.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda13
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ElectronicMoneyActivity.m2575$r8$lambda$M5K7Tivpua5x2sSIWiNxhSXahI(ElectronicMoneyActivity.this, view);
                        }
                    });
                    Unit unit15 = Unit.INSTANCE;
                    return;
                }
                return;
            case 6:
                TextView textView7 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView7 != null) {
                    textView7.setText(R.string.title_card_read_failed);
                    Unit unit16 = Unit.INSTANCE;
                }
                TextView textView8 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView8 != null) {
                    textView8.setText(R.string.desc_card_read_failed);
                    Unit unit17 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView6 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView6 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView6, (int) R.drawable.ic_read_failed);
                    Unit unit18 = Unit.INSTANCE;
                }
                DanaButtonSecondaryView danaButtonSecondaryView4 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView4 != null) {
                    danaButtonSecondaryView4.setVisibility(8);
                }
                DanaButtonPrimaryView danaButtonPrimaryView5 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView5 != null) {
                    danaButtonPrimaryView5.setActiveButton(getString(R.string.try_again), null);
                    danaButtonPrimaryView5.setVisibility(0);
                    danaButtonPrimaryView5.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda14
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ElectronicMoneyActivity.$r8$lambda$_QPL95MBBnf0mN_3gQFC_PlHxHs(ElectronicMoneyActivity.this, view);
                        }
                    });
                    Unit unit19 = Unit.INSTANCE;
                    return;
                }
                return;
            case 7:
                TextView textView9 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView9 != null) {
                    textView9.setText(R.string.title_something_wrong);
                    Unit unit20 = Unit.INSTANCE;
                }
                TextView textView10 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView10 != null) {
                    textView10.setText(R.string.desc_something_wrong);
                    Unit unit21 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView7 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView7 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView7, (int) R.drawable.ic_read_failed);
                    Unit unit22 = Unit.INSTANCE;
                }
                DanaButtonSecondaryView danaButtonSecondaryView5 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView5 != null) {
                    danaButtonSecondaryView5.setVisibility(8);
                }
                DanaButtonPrimaryView danaButtonPrimaryView6 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView6 != null) {
                    danaButtonPrimaryView6.setActiveButton(getString(R.string.try_again), null);
                    danaButtonPrimaryView6.setVisibility(0);
                    danaButtonPrimaryView6.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ElectronicMoneyActivity.$r8$lambda$cx9SUExM9PbvlbwZasbWR0lO3_g(ElectronicMoneyActivity.this, view);
                        }
                    });
                    Unit unit23 = Unit.INSTANCE;
                    return;
                }
                return;
            case 8:
                TextView textView11 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView11 != null) {
                    textView11.setText(R.string.title_card_unsupported);
                    Unit unit24 = Unit.INSTANCE;
                }
                TextView textView12 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView12 != null) {
                    textView12.setText(R.string.desc_card_unsupported);
                    Unit unit25 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView8 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView8 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView8, (int) R.drawable.ic_card_unsupported);
                    Unit unit26 = Unit.INSTANCE;
                }
                DanaButtonSecondaryView danaButtonSecondaryView6 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView6 != null) {
                    danaButtonSecondaryView6.setVisibility(0);
                }
                DanaButtonPrimaryView danaButtonPrimaryView7 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView7 != null) {
                    danaButtonPrimaryView7.setVisibility(8);
                    return;
                }
                return;
            case 9:
                TextView textView13 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView13 != null) {
                    textView13.setText(R.string.title_call_cs_emoney);
                    Unit unit27 = Unit.INSTANCE;
                }
                TextView textView14 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView14 != null) {
                    textView14.setText(R.string.desc_call_cs_emoney);
                    Unit unit28 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView9 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView9 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView9, (int) R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3);
                    Unit unit29 = Unit.INSTANCE;
                }
                LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(R.id.setEnableInQR);
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                DanaButtonSecondaryView danaButtonSecondaryView7 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView7 != null) {
                    danaButtonSecondaryView7.setVisibility(0);
                }
                DanaButtonPrimaryView danaButtonPrimaryView8 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView8 != null) {
                    danaButtonPrimaryView8.setVisibility(8);
                    return;
                }
                return;
            case 10:
                if (Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ElectronicMoneyName.EMONEY)) {
                    TextView textView15 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                    if (textView15 != null) {
                        textView15.setText(R.string.title_card_error_expired_emoney);
                        Unit unit30 = Unit.INSTANCE;
                    }
                    TextView textView16 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                    if (textView16 != null) {
                        textView16.setText(R.string.desc_card_error_expired_emoney);
                        Unit unit31 = Unit.INSTANCE;
                    }
                } else {
                    TextView textView17 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                    if (textView17 != null) {
                        textView17.setText(R.string.title_card_expired);
                        Unit unit32 = Unit.INSTANCE;
                    }
                    TextView textView18 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                    if (textView18 != null) {
                        textView18.setText(R.string.desc_card_expired);
                        Unit unit33 = Unit.INSTANCE;
                    }
                }
                AppCompatImageView appCompatImageView10 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView10 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView10, (int) R.drawable.ic_card_unsupported);
                    Unit unit34 = Unit.INSTANCE;
                }
                LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(R.id.setEnableInQR);
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                DanaButtonSecondaryView danaButtonSecondaryView8 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView8 != null) {
                    danaButtonSecondaryView8.setVisibility(0);
                }
                DanaButtonPrimaryView danaButtonPrimaryView9 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView9 != null) {
                    danaButtonPrimaryView9.setVisibility(8);
                    return;
                }
                return;
            case 11:
                TextView textView19 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView19 != null) {
                    textView19.setText(R.string.title_failed_update_balance);
                    Unit unit35 = Unit.INSTANCE;
                }
                TextView textView20 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView20 != null) {
                    textView20.setText(R.string.desc_failed_update_balance);
                    Unit unit36 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView11 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView11 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView11, (int) R.drawable.ic_update_balance_failed);
                    Unit unit37 = Unit.INSTANCE;
                }
                DanaButtonSecondaryView danaButtonSecondaryView9 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView9 != null) {
                    danaButtonSecondaryView9.setVisibility(0);
                }
                DanaButtonPrimaryView danaButtonPrimaryView10 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView10 != null) {
                    danaButtonPrimaryView10.setActiveButton(getString(R.string.try_again), null);
                    danaButtonPrimaryView10.setVisibility(0);
                    danaButtonPrimaryView10.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ElectronicMoneyActivity.$r8$lambda$ssbIahytzqyS79nm_9gOHf1p17g(ElectronicMoneyActivity.this, view);
                        }
                    });
                    Unit unit38 = Unit.INSTANCE;
                    return;
                }
                return;
            case 12:
                if (this.getAuthRequestContext) {
                    this.getAuthRequestContext = false;
                    DANAToast dANAToast = DANAToast.PlaceComponentResult;
                    String string = getString(R.string.error_brizzi_balance_reached_limit);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    DANAToast.PlaceComponentResult(this, string);
                    BalanceResult balanceResult2 = this.MyBillsEntityDataFactory;
                    if (balanceResult2 != null) {
                        BuiltInFictitiousFunctionClassFactory(balanceResult2, false);
                    } else {
                        KClassImpl$Data$declaredNonStaticMembers$2$default(this, false, 1, null);
                    }
                    Unit unit39 = Unit.INSTANCE;
                    return;
                }
                return;
            case 13:
                TextView textView21 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView21 != null) {
                    textView21.setText(R.string.unstable_internet_network_title);
                    Unit unit40 = Unit.INSTANCE;
                }
                TextView textView22 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView22 != null) {
                    textView22.setText(R.string.unstable_internet_network_description);
                    Unit unit41 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView12 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView12 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView12, (int) R.drawable.ic_no_network_emoney);
                    Unit unit42 = Unit.INSTANCE;
                }
                DanaButtonSecondaryView danaButtonSecondaryView10 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView10 != null) {
                    danaButtonSecondaryView10.setVisibility(8);
                }
                DanaButtonPrimaryView danaButtonPrimaryView11 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView11 != null) {
                    danaButtonPrimaryView11.setActiveButton(getString(R.string.unstable_internet_network_button_title), null);
                    danaButtonPrimaryView11.setVisibility(0);
                    danaButtonPrimaryView11.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ElectronicMoneyActivity.$r8$lambda$z5qzioMabH4DRZ9DSYUAHepwULU(ElectronicMoneyActivity.this, view);
                        }
                    });
                    Unit unit43 = Unit.INSTANCE;
                    return;
                }
                return;
            case 14:
                TextView textView23 = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
                if (textView23 != null) {
                    textView23.setText(R.string.retry_limit_read_card_title);
                    Unit unit44 = Unit.INSTANCE;
                }
                TextView textView24 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView24 != null) {
                    textView24.setText(R.string.retry_limit_read_card_description);
                    Unit unit45 = Unit.INSTANCE;
                }
                AppCompatImageView appCompatImageView13 = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
                if (appCompatImageView13 != null) {
                    ViewExtKt.getAuthRequestContext(appCompatImageView13, (int) R.drawable.ic_emoney_something_wrong);
                    Unit unit46 = Unit.INSTANCE;
                }
                DanaButtonSecondaryView danaButtonSecondaryView11 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView11 != null) {
                    danaButtonSecondaryView11.setVisibility(8);
                }
                DanaButtonPrimaryView danaButtonPrimaryView12 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView12 != null) {
                    danaButtonPrimaryView12.setActiveButton(getString(R.string.unstable_internet_network_button_title), null);
                    danaButtonPrimaryView12.setVisibility(0);
                    danaButtonPrimaryView12.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ElectronicMoneyActivity.m2576$r8$lambda$SiJoZpJQFepFrY7Q3UKjWAGeyY(ElectronicMoneyActivity.this, view);
                        }
                    });
                    Unit unit47 = Unit.INSTANCE;
                    return;
                }
                return;
            case 15:
                BalanceResult balanceResult3 = this.MyBillsEntityDataFactory;
                if (balanceResult3 != null) {
                    PlaceComponentResult(balanceResult3);
                    Unit unit48 = Unit.INSTANCE;
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2$default(this, false, 1, null);
                }
                TextView textView25 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1424_lambda_dootplogin_44_id_dana_data_login_loginentityrepository);
                if (textView25 != null) {
                    textView25.setText(getString(R.string.error_description_failed_inquiry_balance));
                }
                BuiltInFictitiousFunctionClassFactory(true, Integer.valueOf((int) R.string.information_failed_inquiry_balance), null);
                DanaButtonSecondaryView danaButtonSecondaryView12 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
                if (danaButtonSecondaryView12 != null) {
                    danaButtonSecondaryView12.setVisibility(8);
                }
                DanaButtonPrimaryView danaButtonPrimaryView13 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
                if (danaButtonPrimaryView13 != null) {
                    danaButtonPrimaryView13.setActiveButton(getString(R.string.try_again), null);
                    danaButtonPrimaryView13.setVisibility(0);
                    danaButtonPrimaryView13.setOnClickListener(new View.OnClickListener() { // from class: id.dana.electronicmoney.activity.ElectronicMoneyActivity$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ElectronicMoneyActivity.$r8$lambda$vU9Icq69I8nNNU61cEm4ajccCys(ElectronicMoneyActivity.this, view);
                        }
                    });
                    Unit unit49 = Unit.INSTANCE;
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void PlaceComponentResult() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.removeElapsedRealtimeUncertaintyNanos);
        if (textView != null) {
            textView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivCardReadState);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.res_0x7f0a108c_openmerchantformdialog_default);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.getSupportButtonTintMode);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setVisibility(8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(8);
        }
        if (!this.lookAheadTest) {
            DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.b);
            if (danaButtonPrimaryView2 != null) {
                danaButtonPrimaryView2.setDisabled(getString(R.string.top_up_card));
            }
            DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.b);
            if (danaButtonPrimaryView3 != null) {
                danaButtonPrimaryView3.setEnabled(false);
            }
        } else {
            DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.b);
            if (danaButtonPrimaryView4 != null) {
                danaButtonPrimaryView4.setActiveButton(getString(R.string.top_up_card), null);
            }
            DanaButtonPrimaryView danaButtonPrimaryView5 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.b);
            if (danaButtonPrimaryView5 != null) {
                danaButtonPrimaryView5.setEnabled(true);
            }
        }
        boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d26_splitmerchantconfigentity_getmerchantdetailpromoconfigentity_2);
        if (linearLayout != null) {
            Intrinsics.checkNotNullExpressionValue(linearLayout, "");
            linearLayout.setVisibility(MyBillsEntityDataFactory ? 0 : 8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView6 = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.b);
        if (danaButtonPrimaryView6 != null) {
            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView6, "");
            danaButtonPrimaryView6.setVisibility(MyBillsEntityDataFactory ^ true ? 0 : 8);
        }
    }

    private final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult == CardReadStatus.SHOWING_BRI_BRIZZI_BALANCE;
    }

    public static /* synthetic */ void $r8$lambda$1ztZR2bO5x8BzGjHEDZnRkPBVo8(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        electronicMoneyActivity.BuiltInFictitiousFunctionClassFactory(CardReadStatus.TAP_ELECTRONIC_MONEY_CARD);
    }

    public static /* synthetic */ void $r8$lambda$BW_V1l9LKvjbGDlWjCKIGHQNP1A(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        if (view.isEnabled()) {
            electronicMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
    }

    public static /* synthetic */ void $r8$lambda$CYGJYzDLpQ_mtUPw2vEKRl3Af3A(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        electronicMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2(true);
    }

    public static /* synthetic */ void $r8$lambda$FRiRG8N2uk2vHByos9WoriJOa9Y(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        KClassImpl$Data$declaredNonStaticMembers$2$default(electronicMoneyActivity, false, 1, null);
    }

    public static /* synthetic */ void $r8$lambda$FjOeUFpSTxmjEBvmrokc7PLw3WE(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        KClassImpl$Data$declaredNonStaticMembers$2$default(electronicMoneyActivity, false, 1, null);
    }

    /* renamed from: $r8$lambda$M5K7T-ivpua5x2sSIWiNxhSXahI  reason: not valid java name */
    public static /* synthetic */ void m2575$r8$lambda$M5K7Tivpua5x2sSIWiNxhSXahI(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        electronicMoneyActivity.BuiltInFictitiousFunctionClassFactory(CardReadStatus.TAP_ELECTRONIC_MONEY_CARD);
    }

    /* renamed from: $r8$lambda$SiJoZpJQFepFrY7Q3UKjWAGey-Y  reason: not valid java name */
    public static /* synthetic */ void m2576$r8$lambda$SiJoZpJQFepFrY7Q3UKjWAGeyY(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        KClassImpl$Data$declaredNonStaticMembers$2$default(electronicMoneyActivity, false, 1, null);
    }

    /* renamed from: $r8$lambda$YHQHQ8-5d8YMLTSXcBCS2NV7g3M  reason: not valid java name */
    public static /* synthetic */ void m2577$r8$lambda$YHQHQ85d8YMLTSXcBCS2NV7g3M(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        KClassImpl$Data$declaredNonStaticMembers$2$default(electronicMoneyActivity, false, 1, null);
    }

    public static /* synthetic */ void $r8$lambda$_QPL95MBBnf0mN_3gQFC_PlHxHs(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        electronicMoneyActivity.BuiltInFictitiousFunctionClassFactory(CardReadStatus.TAP_ELECTRONIC_MONEY_CARD);
    }

    public static /* synthetic */ void $r8$lambda$cx9SUExM9PbvlbwZasbWR0lO3_g(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        electronicMoneyActivity.BuiltInFictitiousFunctionClassFactory(CardReadStatus.TAP_ELECTRONIC_MONEY_CARD);
    }

    public static /* synthetic */ void $r8$lambda$nHffUJkiqvNpGdrArID7Cxbqeqo(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        electronicMoneyActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:1500445")));
    }

    public static /* synthetic */ void $r8$lambda$ssbIahytzqyS79nm_9gOHf1p17g(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        KClassImpl$Data$declaredNonStaticMembers$2$default(electronicMoneyActivity, false, 1, null);
    }

    public static /* synthetic */ void $r8$lambda$vU9Icq69I8nNNU61cEm4ajccCys(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        electronicMoneyActivity.BuiltInFictitiousFunctionClassFactory(CardReadStatus.TAP_ELECTRONIC_MONEY_CARD);
    }

    public static /* synthetic */ void $r8$lambda$yOiEf0QRJGMBUB30a9irG4zi9Ng(boolean z, ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2$default(electronicMoneyActivity, false, 1, null);
        }
    }

    public static /* synthetic */ void $r8$lambda$z5qzioMabH4DRZ9DSYUAHepwULU(ElectronicMoneyActivity electronicMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(electronicMoneyActivity, "");
        KClassImpl$Data$declaredNonStaticMembers$2$default(electronicMoneyActivity, false, 1, null);
    }

    private static void a(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
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
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (initRecordTimeStamp ^ 4360990799332652212L)) ^ ((int) (GetContactSyncConfig ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda7 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
