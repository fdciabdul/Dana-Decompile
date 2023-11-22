package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.cashier.view.InputCardNumberView;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

/* loaded from: classes7.dex */
public class FirebaseInitProvider extends ContentProvider {
    static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseinitprovider";
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {37294, 37344, 37289, 37368, 37309, 37457, 37282, 37365, 37279, 37468, 37280, 37310, 37274, 37311, 37291, 37460, 37286, 37345, 37459, 37456, 37306, 37290, 37367, 37469, 37371, 37288, 37283, 37305, 37463, 37372, 37366, 37374, 37308, 37292, 37370, 37293, 37373, 37302, 37375, 37462, 37262, 37275, 37471, 37307, 37281, 37461, 37369, 37287, 37458};
    private static char PlaceComponentResult = 42066;
    private static final String TAG = "FirebaseInitProvider";

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        checkContentProviderAuthority(providerInfo);
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Object[] objArr = new Object[1];
        a((byte) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 25), new char[]{2, '*', 18, 0, '\t', 17, 15, 18, 11, 31, 15, '\n', 3, 11, 28, JSONLexer.EOI, 13826, 13826}, 18 - (ViewConfiguration.getLongPressTimeout() >> 16), objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a((byte) (103 - TextUtils.indexOf("", "", 0, 0)), new char[]{2, ')', '\t', 19, 13925}, (ViewConfiguration.getLongPressTimeout() >> 16) + 5, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Object[] objArr3 = new Object[1];
            a((byte) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 67), new char[]{2, '*', 18, 0, '\t', 17, 15, 18, 6, 7, '\n', 20, '/', '(', ',', 15, 23, 20, ',', Typography.dollar, '(', '0', 0, 25, 7, 21}, 26 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a((byte) (22 - ((Process.getThreadPriority(0) + 20) >> 6)), new char[]{Typography.quote, 19, 13822, 13822, 23, '*', '/', Typography.dollar, 13824, 13824, 23, 19, 28, 5, ',', 15, '\t', '-'}, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr4);
            Context context = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 'S' - AndroidCharacter.getMirror('0'), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a((byte) (71 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), new char[]{5, 31, '+', 25, '#', 17, 29, 23, 0, 24, 30, 5, 22, '#', InputCardNumberView.DIVIDER, '-', 13810, 13810, '*', 4, 19, 28, InputCardNumberView.DIVIDER, '/', 15, 28, 21, 15, '#', 15, 7, 28, InputCardNumberView.DIVIDER, ',', '%', 29, '\t', '%', 24, Typography.dollar, 4, 3, 25, '-', Typography.dollar, 28, '*', 25}, 48 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a((byte) (19 - Color.argb(0, 0, 0, 0)), new char[]{6, 28, '*', 18, '\t', '%', Typography.dollar, 24, 19, 28, 31, 28, 17, 28, Typography.amp, 31, 13755, 13755, 3, 30, 17, 28, '+', InputCardNumberView.DIVIDER, '*', '\'', 28, 23, 21, 15, 13755, 13755, 28, 19, 25, 23, 13836, 13836, Typography.dollar, 31, 31, ')', 24, 28, 31, 5, Typography.amp, '\n', 13756, 13756, 2, 31, 31, 2, '-', Typography.amp, '-', Typography.amp, 28, '(', 29, 24, 15, 28}, View.resolveSize(0, 0) + 64, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a((byte) (114 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), new char[]{Typography.amp, 29, 28, '*', 31, 2, Typography.amp, 22, 13844, 13844, 24, 29, InputCardNumberView.DIVIDER, 30, '-', '\n', 7, 28, 21, 17, '%', Typography.dollar, 1, 28, 4, 3, 29, 23, 13934, 13934, 5, 31, 0, 17, '+', 29, Typography.amp, 0, '+', 25, 23, 1, Typography.amp, 31, 24, Typography.dollar, 7, '*', '\t', '%', 28, JSONLexer.EOI, Typography.amp, 29, 6, 30, 6, 31, InputCardNumberView.DIVIDER, ',', 6, 30, 28, 31}, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 63, objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) (39 - TextUtils.getOffsetAfter("", 0)), new char[]{'0', ',', '0', '\b', 28, 11, 13788, 13788, 21, 7, '*', 2, 15, '-', '.', 5, 28, 7, '/', 29, 4, 28, '-', 15, 27, 18, 1, 5, 18, 28, '\r', 18, 1, 5, 24, 14, 31, '\f', 0, 2, 6, 7, 15, 2, 23, 2, JSONLexer.EOI, 22, 29, '.', 6, 22, '+', '\b', 22, 21, 23, '*', '.', 29}, KeyEvent.normalizeMetaState(0) + 60, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) (95 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), new char[]{31, 16, 31, 24, Typography.amp, 29}, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6, objArr9);
                    try {
                        Object[] objArr10 = {context, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), Process.getGidForName("") + 19, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr10);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
        }
        if (FirebaseApp.initializeApp(getContext()) == null) {
            InstrumentInjector.log_i(TAG, "FirebaseApp initialization unsuccessful");
        } else {
            InstrumentInjector.log_i(TAG, "FirebaseApp initialization successful");
        }
        return false;
    }

    private static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if (EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ PlaceComponentResult);
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
