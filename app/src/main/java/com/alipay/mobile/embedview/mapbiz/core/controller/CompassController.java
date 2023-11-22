package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterUiSettings;
import com.alipay.mobile.embedview.mapbiz.data.MapData;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class CompassController extends H5MapController {
    protected boolean mHasShowForDefault;
    public static final byte[] $$a = {TarHeader.LF_FIFO, -88, 36, -123, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 35;
    public static final byte[] getAuthRequestContext = {44, -51, -23, -10, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 113;

    /* JADX WARN: Removed duplicated region for block: B:32:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0024 -> B:35:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 15
            int r8 = 19 - r8
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.CompassController.getAuthRequestContext
            int r7 = r7 * 4
            int r7 = 16 - r7
            int r6 = r6 + 105
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r8
            r4 = 0
            goto L26
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r6
            r1[r3] = r5
            if (r4 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r3 = r0[r8]
        L26:
            int r8 = r8 + 1
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + 2
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.CompassController.a(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0028 -> B:35:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.CompassController.$$a
            int r7 = r7 * 3
            int r7 = 75 - r7
            int r6 = r6 * 4
            int r6 = r6 + 4
            int r5 = r5 * 2
            int r5 = 42 - r5
            byte[] r1 = new byte[r5]
            int r5 = r5 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r6
            r4 = 0
            goto L2a
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r5) goto L28
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L28:
            r3 = r0[r6]
        L2a:
            int r6 = r6 + 1
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.CompassController.b(short, int, int, java.lang.Object[]):void");
    }

    public CompassController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.mHasShowForDefault = false;
    }

    public void fixCompassOnLoad() {
        AdapterAMap map;
        if (this.mMapContainer.configController.isFixCompassOnLoad() && (map = this.mMapContainer.getMap()) != null) {
            MapData mapData = this.mMapContainer.renderController.getMapData();
            AdapterUiSettings uiSettings = map.getUiSettings();
            boolean z = true;
            if (mapData != null && mapData.setting != null && mapData.setting.showCompass != -1 && mapData.setting.showCompass != 1) {
                z = false;
            }
            uiSettings.setCompassEnabled(z);
        }
    }

    public void onCreate() {
        try {
            byte b = getAuthRequestContext[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (getAuthRequestContext[5] - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b3, getAuthRequestContext[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getTapTimeout() >> 16), 4 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (MotionEvent.axisFromString("") + 1));
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 35 - Color.green(0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1530043145, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                this.mHasShowForDefault = false;
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

    public void onRender(int i) {
        if (this.mHasShowForDefault) {
            return;
        }
        if (i != -1) {
            this.mHasShowForDefault = true;
            return;
        }
        AdapterAMap map = this.mMapContainer.getMap();
        if (map == null) {
            return;
        }
        map.getUiSettings().setCompassEnabled(true);
        this.mHasShowForDefault = true;
    }
}
