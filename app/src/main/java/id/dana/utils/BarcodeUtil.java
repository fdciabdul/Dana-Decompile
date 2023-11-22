package id.dana.utils;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.UnsupportedEncodingException;
import java.util.EnumMap;
import java.util.concurrent.Callable;
import o.getCallingPid;

/* loaded from: classes5.dex */
public class BarcodeUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 42070;
    private static char[] MyBillsEntityDataFactory = {37274, 37252, 37255, 37257, 37367, 37346, 37254, 37275, 37253};
    private static int getAuthRequestContext;

    private BarcodeUtil() {
    }

    private static Bitmap PlaceComponentResult(String str, int i, int i2) {
        int i3;
        new BarcodeEncoder();
        try {
            BitMatrix MyBillsEntityDataFactory2 = BarcodeEncoder.MyBillsEntityDataFactory(str, BarcodeFormat.CODE_128, i, i2);
            int width = MyBillsEntityDataFactory2.getWidth();
            int height = MyBillsEntityDataFactory2.getHeight();
            int[] iArr = new int[width * height];
            int i4 = getAuthRequestContext + 53;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
            int i6 = 0;
            while (true) {
                if ((i6 < height ? (char) 21 : (char) 30) == 21) {
                    int i7 = BuiltInFictitiousFunctionClassFactory + 81;
                    getAuthRequestContext = i7 % 128;
                    int i8 = i7 % 2;
                    int i9 = getAuthRequestContext + 29;
                    BuiltInFictitiousFunctionClassFactory = i9 % 128;
                    int i10 = i9 % 2;
                    int i11 = 0;
                    while (true) {
                        if (i11 < width) {
                            int i12 = getAuthRequestContext + 77;
                            BuiltInFictitiousFunctionClassFactory = i12 % 128;
                            int i13 = i12 % 2;
                            if ((MyBillsEntityDataFactory2.get(i11, i6) ? '2' : '0') != '2') {
                                i3 = -1;
                            } else {
                                int i14 = BuiltInFictitiousFunctionClassFactory + 53;
                                getAuthRequestContext = i14 % 128;
                                int i15 = i14 % 2;
                                i3 = -16777216;
                            }
                            iArr[(i6 * width) + i11] = i3;
                            i11++;
                        }
                    }
                    i6++;
                } else {
                    Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                    int i16 = getAuthRequestContext + 87;
                    BuiltInFictitiousFunctionClassFactory = i16 % 128;
                    int i17 = i16 % 2;
                    return createBitmap;
                }
            }
        } catch (WriterException unused) {
            return null;
        }
    }

    private static BitMatrix getAuthRequestContext(String str) {
        BitMatrix bitMatrix;
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put((EnumMap) EncodeHintType.ERROR_CORRECTION, (EncodeHintType) ErrorCorrectionLevel.H);
        EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
        Object[] objArr = new Object[1];
        a(new char[]{1, 6, 4, 3, 13807}, (byte) (TextUtils.lastIndexOf("", '0', 0) + 78), 5 - (ViewConfiguration.getWindowTouchSlop() >> 8), objArr);
        enumMap.put((EnumMap) encodeHintType, (EncodeHintType) ((String) objArr[0]).intern());
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 0);
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Object[] objArr2 = new Object[1];
            a(new char[]{1, 6, 4, 3, 13807}, (byte) (77 - (ViewConfiguration.getTouchSlop() >> 8)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 6, objArr2);
            byte[] bytes = str.getBytes(((String) objArr2[0]).intern());
            Object[] objArr3 = new Object[1];
            a(new char[]{1, 6, 4, 3, 13807}, (byte) ((KeyEvent.getMaxKeyCode() >> 16) + 77), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 4, objArr3);
            bitMatrix = multiFormatWriter.encode(new String(bytes, ((String) objArr3[0]).intern()), BarcodeFormat.QR_CODE, 500, 500, enumMap);
        } catch (WriterException | UnsupportedEncodingException unused) {
            bitMatrix = null;
        }
        int i = BuiltInFictitiousFunctionClassFactory + 81;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return bitMatrix;
    }

    private static Bitmap PlaceComponentResult(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 79;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Bitmap bitmap = null;
        try {
            BitMatrix authRequestContext = getAuthRequestContext(str);
            if (authRequestContext != null) {
                int width = authRequestContext.getWidth();
                int height = authRequestContext.getHeight();
                int[] PlaceComponentResult = PlaceComponentResult(authRequestContext, width, height);
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                bitmap.setPixels(PlaceComponentResult, 0, width, 0, 0, width, height);
                return bitmap;
            }
            int i3 = getAuthRequestContext + 1;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            int i5 = BuiltInFictitiousFunctionClassFactory + 41;
            getAuthRequestContext = i5 % 128;
            if (i5 % 2 != 0) {
                int i6 = 1 / 0;
                return null;
            }
            return null;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    private static int[] PlaceComponentResult(BitMatrix bitMatrix, int i, int i2) {
        int i3 = BuiltInFictitiousFunctionClassFactory + 43;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        int[] iArr = new int[i * i2];
        int i5 = getAuthRequestContext + 35;
        BuiltInFictitiousFunctionClassFactory = i5 % 128;
        int i6 = i5 % 2;
        int i7 = 0;
        while (true) {
            if ((i7 < i2 ? '(' : (char) 17) != '(') {
                return iArr;
            }
            int i8 = getAuthRequestContext + 43;
            BuiltInFictitiousFunctionClassFactory = i8 % 128;
            int i9 = i8 % 2;
            for (int i10 = 0; i10 < i; i10++) {
                int i11 = -16777216;
                if (!(bitMatrix.get(i10, i7))) {
                    i11 = -1;
                } else {
                    int i12 = BuiltInFictitiousFunctionClassFactory + 33;
                    getAuthRequestContext = i12 % 128;
                    if (!(i12 % 2 == 0)) {
                        Object obj = null;
                        obj.hashCode();
                    } else {
                        continue;
                    }
                }
                iArr[(i7 * i) + i10] = i11;
            }
            i7++;
        }
    }

    public static Observable<Bitmap> BuiltInFictitiousFunctionClassFactory(final String str) {
        try {
            Observable<Bitmap> subscribeOn = Observable.fromCallable(new Callable() { // from class: id.dana.utils.BarcodeUtil$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BarcodeUtil.MyBillsEntityDataFactory(str);
                }
            }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory());
            int i = BuiltInFictitiousFunctionClassFactory + 103;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return subscribeOn;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Bitmap MyBillsEntityDataFactory(String str) throws Exception {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 49;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            Bitmap PlaceComponentResult = PlaceComponentResult(str);
            int i3 = BuiltInFictitiousFunctionClassFactory + 117;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return PlaceComponentResult;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Observable<Bitmap> BuiltInFictitiousFunctionClassFactory(final String str, final int i) {
        Observable<Bitmap> subscribeOn = Observable.fromCallable(new Callable() { // from class: id.dana.utils.BarcodeUtil$$ExternalSyntheticLambda1
            public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory = 100;

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BarcodeUtil.BuiltInFictitiousFunctionClassFactory(str, i, this.BuiltInFictitiousFunctionClassFactory);
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory());
        int i2 = getAuthRequestContext + 121;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        return subscribeOn;
    }

    public static /* synthetic */ Bitmap BuiltInFictitiousFunctionClassFactory(String str, int i, int i2) throws Exception {
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 119;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            Bitmap PlaceComponentResult = PlaceComponentResult(str, i, i2);
            int i5 = getAuthRequestContext + 25;
            BuiltInFictitiousFunctionClassFactory = i5 % 128;
            if ((i5 % 2 == 0 ? 'I' : 'c') != 'c') {
                int i6 = 36 / 0;
                return PlaceComponentResult;
            }
            return PlaceComponentResult;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        int length;
        char[] cArr2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr3 = MyBillsEntityDataFactory;
        if (cArr3 != null) {
            int i3 = $11 + 1;
            $10 = i3 % 128;
            if (i3 % 2 != 0) {
                length = cArr3.length;
                cArr2 = new char[length];
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
            }
            for (int i4 = 0; i4 < length; i4++) {
                try {
                    int i5 = $11 + 9;
                    try {
                        $10 = i5 % 128;
                        int i6 = i5 % 2;
                        cArr2[i4] = (char) (cArr3[i4] ^ (-1549216646985767851L));
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            cArr3 = cArr2;
        }
        char c = (char) ((-1549216646985767851L) ^ KClassImpl$Data$declaredNonStaticMembers$2);
        char[] cArr4 = new char[i];
        if (i % 2 == 0) {
            i2 = i;
        } else {
            int i7 = $11 + 55;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
            int i9 = $11 + 51;
            $10 = i9 % 128;
            int i10 = i9 % 2;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (true) {
                if ((getcallingpid.getAuthRequestContext < i2 ? (char) 30 : 'B') == 'B') {
                    break;
                }
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
                        int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr3[i11];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i12];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr3[i13];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i14];
                    } else {
                        int i15 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i16 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr3[i15];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i16];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i17 = 0;
        while (true) {
            if (i17 >= i) {
                objArr[0] = new String(cArr4);
                return;
            }
            int i18 = $11 + 89;
            $10 = i18 % 128;
            int i19 = i18 % 2;
            cArr4[i17] = (char) (cArr4[i17] ^ 13722);
            i17++;
        }
    }
}
