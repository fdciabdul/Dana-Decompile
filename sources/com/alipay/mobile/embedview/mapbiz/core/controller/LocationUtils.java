package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.location.LocationManager;
import android.os.Build;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import id.dana.utils.permission.ManifestPermission;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class LocationUtils {
    public static final byte[] PlaceComponentResult = {8, -125, -40, -38, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int BuiltInFictitiousFunctionClassFactory = 61;
    protected static String[] sRequirePermissions = {ManifestPermission.ACCESS_COARSE_LOCATION, "android.permission.ACCESS_FINE_LOCATION"};

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7156a = false;

    /* loaded from: classes6.dex */
    public interface OnPermissionRequestCallback {
        void onPermissionGranted();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002f -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.LocationUtils.PlaceComponentResult
            int r8 = r8 * 5
            int r8 = 23 - r8
            int r7 = r7 * 22
            int r7 = 26 - r7
            int r6 = r6 * 6
            int r6 = r6 + 97
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1c:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L20:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2f:
            r3 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L37:
            int r7 = r7 + r8
            int r7 = r7 + (-8)
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.LocationUtils.b(byte, byte, int, java.lang.Object[]):void");
    }

    public static void checkPermission(H5MapContainer h5MapContainer, final OnPermissionRequestCallback onPermissionRequestCallback) {
        if (f7156a) {
            onPermissionRequestCallback.onPermissionGranted();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("start sPermissionChecked == ");
            sb.append(f7156a);
            InstrumentInjector.log_d("LocationUtils", sb.toString());
            if (Build.VERSION.SDK_INT >= 23) {
                Context context = h5MapContainer.getContext();
                try {
                    byte b = PlaceComponentResult[41];
                    Object[] objArr = new Object[1];
                    b(b, (byte) (b + 1), PlaceComponentResult[41], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory & 3);
                    byte b3 = PlaceComponentResult[41];
                    Object[] objArr2 = new Object[1];
                    b(b2, b3, (byte) (b3 + 1), objArr2);
                    if (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion >= 23) {
                        if (f7156a) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= 28) {
                            LocationManager locationManager = (LocationManager) h5MapContainer.getContext().getSystemService("location");
                            if (!((Boolean) locationManager.getClass().getDeclaredMethod("isLocationEnabled", new Class[0]).invoke(locationManager, new Object[0])).booleanValue()) {
                                return;
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        for (String str : sRequirePermissions) {
                            if (((Integer) h5MapContainer.getContext().getClass().getMethod("checkSelfPermission", String.class).invoke(h5MapContainer.getContext(), str)).intValue() != 0) {
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() > 0) {
                            GriverEnv.getTopActivity().get().requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1001);
                            RVNativePermissionRequestProxy rVNativePermissionRequestProxy = (RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class);
                            if (rVNativePermissionRequestProxy != null) {
                                rVNativePermissionRequestProxy.addPermRequstCallback(1001, new IPermissionRequestCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LocationUtils.1
                                    private void a() {
                                    }

                                    @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                                    public final void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
                                        if (i == 1001) {
                                            if (iArr.length > 0 && iArr[0] == 0) {
                                                boolean unused = LocationUtils.f7156a = true;
                                                OnPermissionRequestCallback.this.onPermissionGranted();
                                                return;
                                            }
                                            a();
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        f7156a = true;
                        onPermissionRequestCallback.onPermissionGranted();
                        return;
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            f7156a = true;
            onPermissionRequestCallback.onPermissionGranted();
        } catch (Exception e) {
            GriverLogger.e("LocationUtils", "checkPermission e:", e);
        }
    }
}
