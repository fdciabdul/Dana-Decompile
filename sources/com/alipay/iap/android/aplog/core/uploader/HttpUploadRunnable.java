package com.alipay.iap.android.aplog.core.uploader;

import android.os.SystemClock;
import android.util.Log;
import com.alipay.iap.android.aplog.core.uploader.UserDiagnostician;
import com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback;
import java.util.Map;
import o.getCallingPid;

/* loaded from: classes3.dex */
public class HttpUploadRunnable implements Runnable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final int BUFFER_LENGTH = 8192;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char[] MyBillsEntityDataFactory = null;
    private static int PlaceComponentResult = 0;
    private static final String TAG = "HttpUploadRunnable";
    private static int getAuthRequestContext = 1;
    private long mAlreadySentLength;
    private long mAlreadySentSpend;
    private UploadTaskStatusCallback mCallback;
    private UserDiagnostician.DiagnoseTask mDiagnoseTask;
    private String mFilePath;
    private Map<String, String> mHeaderParameters;
    private String mUrl;

    static {
        getAuthRequestContext();
        try {
            int i = PlaceComponentResult + 123;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 42070;
        MyBillsEntityDataFactory = new char[]{42065, 42070, 37346, 37275, 37257, 37367, 42071, 37274, 42068};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpUploadRunnable(String str, String str2, UserDiagnostician.DiagnoseTask diagnoseTask, UploadTaskStatusCallback uploadTaskStatusCallback) {
        this.mFilePath = str;
        this.mUrl = str2;
        this.mDiagnoseTask = diagnoseTask;
        this.mCallback = uploadTaskStatusCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHeaderParameters(Map<String, String> map) {
        int i = PlaceComponentResult + 29;
        getAuthRequestContext = i % 128;
        char c = i % 2 == 0 ? '9' : '\t';
        this.mHeaderParameters = map;
        if (c == '9') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = getAuthRequestContext + 9;
        PlaceComponentResult = i2 % 128;
        if (i2 % 2 == 0) {
            return;
        }
        int i3 = 23 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x017b, code lost:
    
        if ((r3.size() <= 0) != true) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0189, code lost:
    
        if ((r3.size() > 0) != false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02a6, code lost:
    
        if ((r3 != null) != true) goto L90;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void upload() {
        /*
            Method dump skipped, instructions count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.HttpUploadRunnable.upload():void");
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = PlaceComponentResult + 69;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            upload();
            int i3 = getAuthRequestContext + 79;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th) {
            callbackOnError(Log.getStackTraceString(th));
        }
    }

    void callbackOnError(Object obj) {
        long j;
        if (this.mCallback == null) {
            return;
        }
        if ((this.mAlreadySentSpend == 0 ? (char) 5 : '!') != '!') {
            try {
                int i = getAuthRequestContext + 33;
                try {
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    j = -1;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            j = SystemClock.uptimeMillis() - this.mAlreadySentSpend;
            int i3 = getAuthRequestContext + 105;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sentLength: ");
        sb.append(this.mAlreadySentLength);
        sb.append(", alreadySentSpend: ");
        sb.append(j);
        sb.append(" [");
        sb.append(TAG);
        sb.append("] ");
        sb.append("fail: ");
        sb.append(obj);
        this.mCallback.onFail(UploadTaskStatusCallback.Code.RESULT_FAILURE, sb.toString());
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ KClassImpl$Data$declaredNonStaticMembers$2);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i4 = $11 + 41;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if ((i2 > 1 ? '*' : '^') == '*') {
            int i6 = $10 + 109;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            getcallingpid.getAuthRequestContext = 0;
            while (true) {
                if (getcallingpid.getAuthRequestContext >= i2) {
                    break;
                }
                try {
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
                            int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                        } else if ((getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 ? 'N' : (char) 29) != 29) {
                            int i10 = $11 + 105;
                            $10 = i10 % 128;
                            int i11 = i10 % 2;
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                        } else {
                            int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                        }
                    }
                    getcallingpid.getAuthRequestContext += 2;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        int i16 = 0;
        while (true) {
            if ((i16 < i ? (char) 0 : 'B') != 'B') {
                cArr4[i16] = (char) (cArr4[i16] ^ 13722);
                i16++;
            } else {
                objArr[0] = new String(cArr4);
                return;
            }
        }
    }
}
