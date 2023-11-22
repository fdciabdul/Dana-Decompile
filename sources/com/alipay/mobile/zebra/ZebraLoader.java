package com.alipay.mobile.zebra;

import android.graphics.Bitmap;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import o.getCallingPid;

/* loaded from: classes7.dex */
public abstract class ZebraLoader {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final String MIME_TYPE_IMAGE = "image/*";
    public static final String MIME_TYPE_STREAM = "application/octet-stream";
    public static final String MIME_TYPE_TEXT = "text/*";
    private static char MyBillsEntityDataFactory = 42070;
    private static char[] getAuthRequestContext = {37257, 37275, 37301, 37367, 37346, 37258, 37256, 37274, 37259};

    /* loaded from: classes7.dex */
    public interface OnLoadImageCallback {
        void onComplete(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public interface OnLoadResourceCallback {
        void onComplete(WebResourceResponse webResourceResponse);
    }

    /* loaded from: classes7.dex */
    public interface OnLoadTextCallback {
        void onComplete(String str);
    }

    public abstract void load(String str, String str2, OnLoadResourceCallback onLoadResourceCallback);

    public abstract void loadImage(String str, OnLoadImageCallback onLoadImageCallback);

    public abstract void loadText(String str, String str2, OnLoadTextCallback onLoadTextCallback);

    public void load(String str, OnLoadResourceCallback onLoadResourceCallback) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '#' : ':') != ':') {
            load(str, MIME_TYPE_STREAM, onLoadResourceCallback);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                load(str, MIME_TYPE_STREAM, onLoadResourceCallback);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 111;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
    }

    public void loadText(String str, OnLoadResourceCallback onLoadResourceCallback) {
        int i = BuiltInFictitiousFunctionClassFactory + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 0 : 'a') != 0) {
            load(str, MIME_TYPE_TEXT, onLoadResourceCallback);
        } else {
            load(str, MIME_TYPE_TEXT, onLoadResourceCallback);
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public void loadImage(String str, OnLoadResourceCallback onLoadResourceCallback) {
        int i = BuiltInFictitiousFunctionClassFactory + 1;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        load(str, "image/*", onLoadResourceCallback);
        int i3 = BuiltInFictitiousFunctionClassFactory + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? '(' : 'Y') != '(') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public void loadText(String str, OnLoadTextCallback onLoadTextCallback) {
        int i = BuiltInFictitiousFunctionClassFactory + 21;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        e((byte) ((Process.myPid() >> 22) + 92), new char[]{1, 4, 1, 3, 13822}, TextUtils.getOffsetAfter("", 0) + 5, objArr);
        loadText(str, ((String) objArr[0]).intern(), onLoadTextCallback);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? ',' : 'B') != 'B') {
            int i4 = 20 / 0;
        }
    }

    private static void e(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = getAuthRequestContext;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (true) {
                if ((i3 < length ? '3' : '`') == '`') {
                    break;
                }
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                i3++;
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ MyBillsEntityDataFactory);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i4 = $10 + 19;
            $11 = i4 % 128;
            int i5 = i4 % 2;
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
                        int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                    } else {
                        try {
                            try {
                                if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                                    int i8 = $11 + 29;
                                    $10 = i8 % 128;
                                    int i9 = i8 % 2;
                                    getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                    getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                    int i10 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                    int i11 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                    cArr4[getcallingpid.getAuthRequestContext] = cArr2[i10];
                                    cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i11];
                                } else {
                                    int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                                    int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                                    cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                                    cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i14 = 0; i14 < i; i14++) {
            cArr4[i14] = (char) (cArr4[i14] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
