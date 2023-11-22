package com.alibaba.griver.h5.jsapi;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.image.photo.PhotoContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import o.getOnBoardingScenario;

/* loaded from: classes6.dex */
public class ImageBridgeExtension extends SimpleBridgeExtension {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final int ERR_FILE_NOT_FOUND_OR_NOT_READABLE = 103;
    public static final int ERR_INVALID_FILE_PATH = 101;
    public static final int ERR_MISSING_FILE_PATH = 100;
    public static final int ERR_UNKNOWN_IMAGE_FORMAT = 104;
    public static final int ERR_UNSUPPORTED_FILE_PATH = 102;
    public static final int NO_ERROR = 0;
    private static int PlaceComponentResult = 0;
    private static final String TAG = "LoadLocalImagePlugin";
    private static long getAuthRequestContext = 6779585740085117533L;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if ((!r2 ? ':' : 'O') != 'O') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        loadLocalImageInternal(r3, r4);
        r2 = com.alibaba.griver.h5.jsapi.ImageBridgeExtension.PlaceComponentResult + 73;
        com.alibaba.griver.h5.jsapi.ImageBridgeExtension.BuiltInFictitiousFunctionClassFactory = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        r4.sendBridgeResponse(com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.INVALID_PARAM);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        return;
     */
    @com.alibaba.ariver.kernel.api.annotation.ActionFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadLocalImage(@com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext(required = true) com.alibaba.ariver.engine.api.bridge.model.ApiContext r2, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"filePath"}) java.lang.String r3, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r4) {
        /*
            r1 = this;
            int r2 = com.alibaba.griver.h5.jsapi.ImageBridgeExtension.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 103
            int r0 = r2 % 128
            com.alibaba.griver.h5.jsapi.ImageBridgeExtension.PlaceComponentResult = r0
            int r2 = r2 % 2
            r0 = 51
            if (r2 == 0) goto L11
            r2 = 57
            goto L13
        L11:
            r2 = 51
        L13:
            if (r2 == r0) goto L29
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L27
            r0 = 79
            if (r2 != 0) goto L22
            r2 = 58
            goto L24
        L22:
            r2 = 79
        L24:
            if (r2 == r0) goto L3d
            goto L2f
        L27:
            r2 = move-exception
            throw r2
        L29:
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L43
            if (r2 != 0) goto L3d
        L2f:
            r1.loadLocalImageInternal(r3, r4)
            int r2 = com.alibaba.griver.h5.jsapi.ImageBridgeExtension.PlaceComponentResult
            int r2 = r2 + 73
            int r3 = r2 % 128
            com.alibaba.griver.h5.jsapi.ImageBridgeExtension.BuiltInFictitiousFunctionClassFactory = r3
            int r2 = r2 % 2
            return
        L3d:
            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse r2 = com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse.INVALID_PARAM
            r4.sendBridgeResponse(r2)
            return
        L43:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.h5.jsapi.ImageBridgeExtension.loadLocalImage(com.alibaba.ariver.engine.api.bridge.model.ApiContext, java.lang.String, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback):void");
    }

    byte[] retrieveImageBytesFromFile(File file) {
        Object obj = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) file.length()];
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if ((read > 0 ? ',' : ']') != ']') {
                int i = PlaceComponentResult + 103;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (!(i % 2 == 0)) {
                    return bArr;
                }
                obj.hashCode();
                return bArr;
            }
        } catch (FileNotFoundException e) {
            GriverLogger.e(TAG, "", e);
        } catch (IOException e2) {
            GriverLogger.e(TAG, "", e2);
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 19;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        if (r2 > 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        if (r11.length > 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String encodeImageBytesToString(byte[] r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L6
            r2 = 1
            goto L7
        L6:
            r2 = 0
        L7:
            r3 = 0
            if (r2 == r0) goto Lb
            goto L7a
        Lb:
            int r2 = com.alibaba.griver.h5.jsapi.ImageBridgeExtension.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 15
            int r4 = r2 % 128
            com.alibaba.griver.h5.jsapi.ImageBridgeExtension.PlaceComponentResult = r4
            r4 = 2
            int r2 = r2 % r4
            if (r2 == 0) goto L20
            int r2 = r11.length
            r3.hashCode()     // Catch: java.lang.Throwable -> L1e
            if (r2 <= 0) goto L7a
            goto L23
        L1e:
            r11 = move-exception
            throw r11
        L20:
            int r2 = r11.length
            if (r2 <= 0) goto L7a
        L23:
            byte[] r11 = android.util.Base64.encode(r11, r1)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r2 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L72
            long r5 = android.os.SystemClock.uptimeMillis()     // Catch: java.io.UnsupportedEncodingException -> L72
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            int r9 = r9 + 21646
            r5 = 5
            char[] r5 = new char[r5]     // Catch: java.io.UnsupportedEncodingException -> L72
            r6 = 4939(0x134b, float:6.921E-42)
            r5[r1] = r6     // Catch: java.io.UnsupportedEncodingException -> L72
            r6 = 18373(0x47c5, float:2.5746E-41)
            r5[r0] = r6     // Catch: java.io.UnsupportedEncodingException -> L72
            r6 = 47686(0xba46, float:6.6822E-41)
            r5[r4] = r6     // Catch: java.io.UnsupportedEncodingException -> L72
            r6 = 3
            r7 = 61086(0xee9e, float:8.56E-41)
            r5[r6] = r7     // Catch: java.io.UnsupportedEncodingException -> L72
            r6 = 4
            r7 = 16666(0x411a, float:2.3354E-41)
            r5[r6] = r7     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.io.UnsupportedEncodingException -> L72
            a(r9, r5, r6)     // Catch: java.io.UnsupportedEncodingException -> L72
            r5 = r6[r1]     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r5 = r5.intern()     // Catch: java.io.UnsupportedEncodingException -> L72
            r2.<init>(r11, r5)     // Catch: java.io.UnsupportedEncodingException -> L72
            int r11 = com.alibaba.griver.h5.jsapi.ImageBridgeExtension.PlaceComponentResult
            int r11 = r11 + 95
            int r5 = r11 % 128
            com.alibaba.griver.h5.jsapi.ImageBridgeExtension.BuiltInFictitiousFunctionClassFactory = r5
            int r11 = r11 % r4
            if (r11 != 0) goto L6a
            goto L6b
        L6a:
            r0 = 0
        L6b:
            if (r0 == 0) goto L71
            int r11 = r3.length     // Catch: java.lang.Throwable -> L6f
            return r2
        L6f:
            r11 = move-exception
            throw r11
        L71:
            return r2
        L72:
            r11 = move-exception
            java.lang.String r0 = "LoadLocalImagePlugin"
            java.lang.String r1 = ""
            com.alibaba.griver.base.common.logger.GriverLogger.e(r0, r1, r11)
        L7a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.h5.jsapi.ImageBridgeExtension.encodeImageBytesToString(byte[]):java.lang.String");
    }

    CheckFilePathResult checkFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return new CheckFilePathResult(100, "Missing filePath");
        }
        try {
            if (str.contains("/../")) {
                return new CheckFilePathResult(101, "Invalid filePath");
            }
            if ((!str.startsWith("/") ? '4' : 'Y') != 'Y') {
                if (!str.startsWith(PhotoContext.FILE_SCHEME)) {
                    CheckFilePathResult checkFilePathResult = new CheckFilePathResult(102, "Unsupported filePath");
                    int i = PlaceComponentResult + 99;
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    return checkFilePathResult;
                }
            }
            if (!pathIsInAppScope(str)) {
                return new CheckFilePathResult(102, "Unsupported filePath");
            }
            try {
                File file = new File(URI.create(str).getPath());
                boolean z = false;
                if ((!file.exists()) || !file.canRead()) {
                    return new CheckFilePathResult(103, "File not found or not readable");
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(fileInputStream, null, options);
                    fileInputStream.close();
                    String str2 = options.outMimeType;
                    if (str2 == null) {
                        z = true;
                    }
                    if (z || !str2.contains("image")) {
                        return new CheckFilePathResult(104, "Unknown image format");
                    }
                } catch (FileNotFoundException unused) {
                    return new CheckFilePathResult(103, "File not found or not readable");
                } catch (IOException e) {
                    GriverLogger.e(TAG, "", e);
                }
                CheckFilePathResult checkFilePathResult2 = new CheckFilePathResult(file);
                int i3 = BuiltInFictitiousFunctionClassFactory + 95;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return checkFilePathResult2;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a5, code lost:
    
        if (r3.getCanonicalPath().startsWith(r9) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b2, code lost:
    
        if (r3.getCanonicalPath().startsWith(r9) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b4, code lost:
    
        r9 = com.alibaba.griver.h5.jsapi.ImageBridgeExtension.PlaceComponentResult + 41;
        com.alibaba.griver.h5.jsapi.ImageBridgeExtension.BuiltInFictitiousFunctionClassFactory = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00be, code lost:
    
        if ((r9 % 2) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean pathIsInAppScope(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.h5.jsapi.ImageBridgeExtension.pathIsInAppScope(java.lang.String):boolean");
    }

    private void loadLocalImageInternal(final String str, final BridgeCallback bridgeCallback) {
        GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.h5.jsapi.ImageBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                CheckFilePathResult checkFilePath = ImageBridgeExtension.this.checkFilePath(str);
                if (checkFilePath.isSuccessful()) {
                    String encodeImageBytesToString = ImageBridgeExtension.this.encodeImageBytesToString(ImageBridgeExtension.this.retrieveImageBytesFromFile(checkFilePath.file));
                    if (encodeImageBytesToString != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", (Object) encodeImageBytesToString);
                        bridgeCallback.sendJSONResponse(jSONObject);
                        return;
                    }
                    return;
                }
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(checkFilePath.errorCode, checkFilePath.errorMessage));
            }
        });
        int i = BuiltInFictitiousFunctionClassFactory + 77;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CheckFilePathResult {
        public final int errorCode;
        public final String errorMessage;
        public final File file;

        boolean isSuccessful() {
            return this.errorCode == 0;
        }

        CheckFilePathResult(File file) {
            this.errorCode = 0;
            this.errorMessage = "";
            this.file = file;
        }

        CheckFilePathResult(int i, String str) {
            this.file = null;
            this.errorCode = i;
            this.errorMessage = str;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            int i2 = $10 + 113;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 27 : 'G') != 27) {
                    break;
                }
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getAuthRequestContext ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            int i4 = $11 + 113;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            while (getonboardingscenario.getAuthRequestContext < cArr.length) {
                int i6 = $10 + 41;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            }
            objArr[0] = new String(cArr2);
        } catch (Exception e) {
            throw e;
        }
    }
}
