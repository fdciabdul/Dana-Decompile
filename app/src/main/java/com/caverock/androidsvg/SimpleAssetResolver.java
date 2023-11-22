package com.caverock.androidsvg;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.cashier.view.InputCardNumberView;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import o.A;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes7.dex */
public class SimpleAssetResolver extends SVGExternalFileResolver {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static final String TAG = "SimpleAssetResolver";
    private static int getAuthRequestContext;
    private static final Set<String> supportedFormats;
    private AssetManager assetManager;

    static void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory = 269894756;
    }

    public SimpleAssetResolver(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    static {
        MyBillsEntityDataFactory();
        HashSet hashSet = new HashSet(8);
        supportedFormats = hashSet;
        hashSet.add("image/svg+xml");
        hashSet.add("image/jpeg");
        hashSet.add("image/png");
        hashSet.add("image/pjpeg");
        hashSet.add("image/gif");
        hashSet.add("image/bmp");
        hashSet.add("image/x-windows-bmp");
        if ((Build.VERSION.SDK_INT >= 14 ? (char) 25 : '\\') == 25) {
            hashSet.add("image/webp");
            try {
                int i = getAuthRequestContext + 11;
                try {
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = getAuthRequestContext + 67;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Typeface resolveFont(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("resolveFont(");
        sb.append(str);
        sb.append(",");
        sb.append(i);
        sb.append(",");
        sb.append(str2);
        sb.append(")");
        InstrumentInjector.log_i(TAG, sb.toString());
        try {
            try {
                AssetManager assetManager = this.assetManager;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(".ttf");
                Typeface typefaceCreateFromAsset = InstrumentInjector.typefaceCreateFromAsset(assetManager, sb2.toString());
                int i2 = MyBillsEntityDataFactory + 23;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                return typefaceCreateFromAsset;
            } catch (RuntimeException unused) {
                AssetManager assetManager2 = this.assetManager;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(".otf");
                return InstrumentInjector.typefaceCreateFromAsset(assetManager2, sb3.toString());
            }
        } catch (RuntimeException unused2) {
            return null;
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Bitmap resolveImage(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("resolveImage(");
            try {
                sb.append(str);
                sb.append(")");
                InstrumentInjector.log_i(TAG, sb.toString());
                try {
                    try {
                        Object[] objArr = {this.assetManager, str};
                        Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                        if (obj == null) {
                            obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 58133), ViewConfiguration.getScrollBarFadeDuration() >> 16, 49 - TextUtils.getOffsetAfter("", 0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                            NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                        }
                        Bitmap decodeStream = BitmapFactory.decodeStream((InputStream) ((Method) obj).invoke(null, objArr));
                        int i = getAuthRequestContext + 53;
                        MyBillsEntityDataFactory = i % 128;
                        int i2 = i % 2;
                        return decodeStream;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (IOException unused) {
                    return null;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public boolean isFormatSupported(String str) {
        try {
            int i = MyBillsEntityDataFactory + 121;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            try {
                boolean contains = supportedFormats.contains(str);
                int i3 = getAuthRequestContext + 33;
                MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 == 0 ? 'Q' : 'T') != 'T') {
                    Object obj = null;
                    obj.hashCode();
                    return contains;
                }
                return contains;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public String resolveCSSStyleSheet(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("resolveCSSStyleSheet(");
        sb.append(str);
        sb.append(")");
        InstrumentInjector.log_i(TAG, sb.toString());
        String assetAsString = getAssetAsString(str);
        int i = MyBillsEntityDataFactory + 109;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return assetAsString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    private String getAssetAsString(String str) {
        InputStream inputStream;
        ?? r0 = 0;
        try {
            try {
                Object[] objArr = {this.assetManager, str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 58132), Process.myPid() >> 22, (ViewConfiguration.getWindowTouchSlop() >> 8) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                try {
                    Object[] objArr2 = new Object[1];
                    a(new char[]{17, 16, 2, 65513, 65524}, (Process.myTid() >> 22) + 133, 6 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), false, ExpandableListView.getPackedPositionType(0L) + 5, objArr2);
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName(((String) objArr2[0]).intern()));
                    char[] cArr = new char[4096];
                    StringBuilder sb = new StringBuilder();
                    for (int read = inputStreamReader.read(cArr); read > 0; read = inputStreamReader.read(cArr)) {
                        int i = getAuthRequestContext + 13;
                        MyBillsEntityDataFactory = i % 128;
                        if (i % 2 == 0) {
                            sb.append(cArr, 0, read);
                        } else {
                            sb.append(cArr, 0, read);
                        }
                    }
                    String obj2 = sb.toString();
                    if (!(inputStream == null)) {
                        int i2 = MyBillsEntityDataFactory + 83;
                        getAuthRequestContext = i2 % 128;
                        try {
                            if (i2 % 2 != 0) {
                                inputStream.close();
                                int length = r0.length;
                            } else {
                                inputStream.close();
                            }
                        } catch (IOException unused) {
                        }
                    }
                    return obj2;
                } catch (IOException unused2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    r0 = inputStream;
                    if ((r0 != 0 ? ';' : '7') == ';') {
                        try {
                            r0.close();
                            int i3 = MyBillsEntityDataFactory + 63;
                            getAuthRequestContext = i3 % 128;
                            int i4 = i3 % 2;
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th2;
            }
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        char[] cArr2;
        A a2 = new A();
        char[] cArr3 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i2 ? 'U' : '\'') != 'U') {
                break;
            }
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr3[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr3[i4] = (char) (cArr3[i4] - ((int) (BuiltInFictitiousFunctionClassFactory ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i3 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr4 = new char[i2];
            System.arraycopy(cArr3, 0, cArr4, 0, i2);
            System.arraycopy(cArr4, 0, cArr3, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr4, a2.BuiltInFictitiousFunctionClassFactory, cArr3, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            int i5 = $10 + 55;
            $11 = i5 % 128;
            if ((i5 % 2 == 0 ? 'X' : InputCardNumberView.DIVIDER) != 'X') {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
            } else {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 1;
            }
            while (true) {
                try {
                    if (a2.MyBillsEntityDataFactory >= i2) {
                        break;
                    }
                    int i6 = $10 + 67;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                    int i8 = $11 + 3;
                    $10 = i8 % 128;
                    int i9 = i8 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr3 = cArr2;
        }
        objArr[0] = new String(cArr3);
    }
}
