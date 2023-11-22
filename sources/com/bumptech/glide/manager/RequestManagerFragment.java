package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Deprecated
/* loaded from: classes3.dex */
public class RequestManagerFragment extends Fragment {
    public static final byte[] $$a = {105, Ascii.NAK, -43, 101, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 54;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {11, Ascii.GS, 107, 8, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int scheduleImpl = 12;
    RequestManager BuiltInFictitiousFunctionClassFactory;
    Fragment MyBillsEntityDataFactory;
    final ActivityFragmentLifecycle PlaceComponentResult;
    final RequestManagerTreeNode getAuthRequestContext;
    private final Set<RequestManagerFragment> getErrorConfigVersion;
    private RequestManagerFragment moveToNextValue;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002c -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = 106 - r7
            int r9 = r9 * 15
            int r9 = 18 - r9
            byte[] r0 = com.bumptech.glide.manager.RequestManagerFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 4
            int r8 = 16 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            int r9 = r9 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L37:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.RequestManagerFragment.a(int, byte, int, java.lang.Object[]):void");
    }

    private static void b(byte b, int i, short s, Object[] objArr) {
        byte[] bArr = $$a;
        int i2 = (b * 4) + 42;
        int i3 = 75 - (i * 4);
        int i4 = 3 - (s * 2);
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            int i7 = (i4 + i6) - 7;
            i4 = i4;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i3 = i7;
            i6 = i6;
        }
        while (true) {
            int i8 = i4 + 1;
            int i9 = i5 + 1;
            bArr2[i9] = (byte) i3;
            if (i9 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i10 = i3;
            int i11 = i6;
            i4 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i9;
            i3 = (i10 + bArr[i8]) - 7;
            i6 = i11;
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), KClassImpl$Data$declaredNonStaticMembers$2[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 4 - View.resolveSize(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetBefore("", 0) + 35, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {610565146, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
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
                super.onCreate(bundle);
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

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.getAuthRequestContext = new FragmentRequestManagerTreeNode();
        this.getErrorConfigVersion = new HashSet();
        this.PlaceComponentResult = activityFragmentLifecycle;
    }

    final Set<RequestManagerFragment> PlaceComponentResult() {
        if (equals(this.moveToNextValue)) {
            return Collections.unmodifiableSet(this.getErrorConfigVersion);
        }
        if (this.moveToNextValue == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment requestManagerFragment : this.moveToNextValue.PlaceComponentResult()) {
            if (BuiltInFictitiousFunctionClassFactory(requestManagerFragment.getParentFragment())) {
                hashSet.add(requestManagerFragment);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private boolean BuiltInFictitiousFunctionClassFactory(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            MyBillsEntityDataFactory(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                InstrumentInjector.log_w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        RequestManagerFragment requestManagerFragment = this.moveToNextValue;
        if (requestManagerFragment != null) {
            requestManagerFragment.getErrorConfigVersion.remove(this);
            this.moveToNextValue = null;
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.PlaceComponentResult.getAuthRequestContext();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.PlaceComponentResult.PlaceComponentResult();
        RequestManagerFragment requestManagerFragment = this.moveToNextValue;
        if (requestManagerFragment != null) {
            requestManagerFragment.getErrorConfigVersion.remove(this);
            this.moveToNextValue = null;
        }
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        if (parentFragment == null) {
            parentFragment = this.MyBillsEntityDataFactory;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        FragmentRequestManagerTreeNode() {
            RequestManagerFragment.this = r1;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public final Set<RequestManager> MyBillsEntityDataFactory() {
            Set<RequestManagerFragment> PlaceComponentResult = RequestManagerFragment.this.PlaceComponentResult();
            HashSet hashSet = new HashSet(PlaceComponentResult.size());
            for (RequestManagerFragment requestManagerFragment : PlaceComponentResult) {
                if (requestManagerFragment.BuiltInFictitiousFunctionClassFactory != null) {
                    hashSet.add(requestManagerFragment.BuiltInFictitiousFunctionClassFactory);
                }
            }
            return hashSet;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(RequestManagerFragment.this);
            sb.append("}");
            return sb.toString();
        }
    }

    public final void MyBillsEntityDataFactory(Activity activity) {
        RequestManagerFragment requestManagerFragment = this.moveToNextValue;
        if (requestManagerFragment != null) {
            requestManagerFragment.getErrorConfigVersion.remove(this);
            this.moveToNextValue = null;
        }
        RequestManagerFragment authRequestContext = Glide.BuiltInFictitiousFunctionClassFactory(activity).scheduleImpl.getAuthRequestContext(activity.getFragmentManager(), (Fragment) null);
        this.moveToNextValue = authRequestContext;
        if (equals(authRequestContext)) {
            return;
        }
        this.moveToNextValue.getErrorConfigVersion.add(this);
    }
}
