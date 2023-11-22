package com.zhuinden.simplestack.navigator;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.GlobalServices;
import com.zhuinden.simplestack.KeyFilter;
import com.zhuinden.simplestack.KeyParceler;
import com.zhuinden.simplestack.ScopedServices;
import com.zhuinden.simplestack.StateChanger;
import com.zhuinden.statebundle.StateBundle;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes2.dex */
public final class BackstackHost extends Fragment {
    Backstack backstack;
    ViewGroup container;
    GlobalServices.Factory globalServiceFactory;
    GlobalServices globalServices;
    List<?> initialKeys = Collections.emptyList();
    KeyFilter keyFilter;
    KeyParceler keyParceler;
    Bundle savedInstanceState;
    ScopedServices scopedServices;
    boolean shouldPersistContainerChild;
    List<Backstack.CompletionListener> stateChangeCompletionListeners;
    StateChanger stateChanger;
    Backstack.StateClearStrategy stateClearStrategy;
    public static final byte[] $$a = {104, -68, 0, 44, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 161;
    public static final byte[] getAuthRequestContext = {103, 121, -60, -41, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 157;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            byte[] r0 = com.zhuinden.simplestack.navigator.BackstackHost.getAuthRequestContext
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r7 = r7 + 105
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L18:
            r3 = 0
        L19:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhuinden.simplestack.navigator.BackstackHost.a(int, int, short, java.lang.Object[]):void");
    }

    private static void b(int i, byte b, short s, Object[] objArr) {
        byte[] bArr = $$a;
        int i2 = (s * 3) + 4;
        int i3 = (b * 4) + 75;
        int i4 = 42 - (i * 2);
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i2++;
            i3 = (i6 + (-i3)) - 7;
            i6 = i6;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i3;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = bArr[i2];
            i2++;
            i3 = (i3 + (-i7)) - 7;
            i6 = i6;
        }
    }

    public BackstackHost() {
        setRetainInstance(true);
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        try {
            Object[] objArr = new Object[1];
            a((byte) (getAuthRequestContext[5] - 1), getAuthRequestContext[5], (byte) (getAuthRequestContext[8] + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (getAuthRequestContext[5] - 1);
            Object[] objArr2 = new Object[1];
            a(b, b, (byte) (-getAuthRequestContext[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.lastIndexOf("", '0', 0, 0), 4 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16));
                    byte b2 = $$a[2];
                    byte b3 = b2;
                    Object[] objArr4 = new Object[1];
                    b(b2, b3, b3, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-2142250631, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                this.savedInstanceState = bundle;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Backstack initialize(boolean z) {
        if (this.backstack == null) {
            Backstack backstack = new Backstack();
            this.backstack = backstack;
            backstack.setKeyFilter(this.keyFilter);
            this.backstack.setKeyParceler(this.keyParceler);
            this.backstack.setStateClearStrategy(this.stateClearStrategy);
            ScopedServices scopedServices = this.scopedServices;
            if (scopedServices != null) {
                this.backstack.setScopedServices(scopedServices);
            }
            GlobalServices globalServices = this.globalServices;
            if (globalServices != null) {
                this.backstack.setGlobalServices(globalServices);
            }
            GlobalServices.Factory factory = this.globalServiceFactory;
            if (factory != null) {
                this.backstack.setGlobalServices(factory);
            }
            this.backstack.setup(this.initialKeys);
            Iterator<Backstack.CompletionListener> it = this.stateChangeCompletionListeners.iterator();
            while (it.hasNext()) {
                this.backstack.addStateChangeCompletionListener(it.next());
            }
            Bundle bundle = this.savedInstanceState;
            if (bundle != null) {
                this.backstack.fromBundle((StateBundle) bundle.getParcelable("NAVIGATOR_STATE_BUNDLE"));
            }
        }
        if (!z) {
            this.backstack.setStateChanger(this.stateChanger);
        }
        return this.backstack;
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.shouldPersistContainerChild) {
            Navigator.persistViewToState(this.container.getChildAt(0));
        }
        bundle.putParcelable("NAVIGATOR_STATE_BUNDLE", this.backstack.toBundle());
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.backstack.reattachStateChanger();
    }

    @Override // android.app.Fragment
    public final void onPause() {
        this.backstack.detachStateChanger();
        super.onPause();
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        this.backstack.executePendingStateChange();
        this.stateChanger = null;
        this.container = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.backstack.finalizeScopes();
    }

    public final Backstack getBackstack() {
        return this.backstack;
    }
}
