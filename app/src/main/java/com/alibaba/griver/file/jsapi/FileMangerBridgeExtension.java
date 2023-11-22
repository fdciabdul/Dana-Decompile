package com.alibaba.griver.file.jsapi;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.proxy.LocalIdTool;
import com.alibaba.griver.base.common.utils.AOMPFileTinyAppUtils;
import com.alibaba.griver.base.common.utils.FileCache;
import com.alibaba.griver.base.common.utils.H5FileUtil;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.base.common.utils.MD5Util;
import com.alibaba.griver.base.common.utils.OuterFileUtils;
import com.alibaba.griver.file.R;
import com.alibaba.griver.file.utils.FileManager;
import com.alibaba.griver.image.framework.api.APImageFormat;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.E;

/* loaded from: classes2.dex */
public class FileMangerBridgeExtension extends SimpleBridgeExtension {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String BOUNDARY = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final int ERROR_CODE_DOWNLOAD_FAILED = 12;
    public static final int ERROR_CODE_DOWNLOAD_NO_PERMISSION = 13;
    public static final int ERROR_CODE_UPLOAD_FILE_FAILED = 12;
    public static final int ERROR_CODE_UPLOAD_FILE_NOT_EXIT = 11;
    public static final int ERROR_CODE_UPLOAD_FILE_NO_PERMISSION = 13;
    public static final int ERROR_WRITE_FILE_FAIL = 13;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    public static final long MAX_FILE_SIZE = 31457280;
    private static long MyBillsEntityDataFactory = 4360990799332652212L;
    private static int PlaceComponentResult = 1405453124;
    private static final String TAG = "FileMangerBridgeExtension";
    private static char getAuthRequestContext = 13492;
    private FileCache cache;

    static /* synthetic */ Map access$000(Map map) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 121;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            Map<String, List<String>> fixEmptyKeyHeader = fixEmptyKeyHeader(map);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
                return fixEmptyKeyHeader;
            }
            return fixEmptyKeyHeader;
        } catch (Exception e) {
            throw e;
        }
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void downloadFile(@BindingApiContext(required = true) ApiContext apiContext, @BindingNode(App.class) App app, @BindingParam(name = {"url"}) String str, @BindingCallback final BridgeCallback bridgeCallback) {
        final Activity activity = apiContext.getActivity();
        if (activity == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "Context empty"));
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, activity.getString(R.string.griver_url_is_null)));
                return;
            }
            if ((!str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP) ? 'V' : '8') == 'V') {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if ((i % 2 != 0 ? '%' : '0') != '0') {
                    downloadFileByBase64(activity, bridgeCallback, str, app);
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                }
                downloadFileByBase64(activity, bridgeCallback, str, app);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OuterFileUtils.getOuterRootFileDir(activity));
            sb.append(File.separator);
            sb.append(app.getAppId());
            FileManager.downloadFileByHttp(str, sb.toString(), MD5Util.getMD5String(str), new DownloadCallback() { // from class: com.alibaba.griver.file.jsapi.FileMangerBridgeExtension.1
                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onPrepare(String str2) {
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onProgress(String str2, int i2) {
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onCancel(String str2) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(12, activity.getString(R.string.griver_download_failed)));
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onFinish(String str2) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("apFilePath", (Object) H5ResourceHandlerUtil.localIdToUrl(LocalIdTool.get().encodeToLocalId(str2), "image"));
                    BridgeCallback bridgeCallback2 = bridgeCallback;
                    if (bridgeCallback2 == null || activity == null) {
                        return;
                    }
                    bridgeCallback2.sendJSONResponse(jSONObject);
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onFailed(String str2, int i2, String str3) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(12, activity.getString(R.string.griver_download_failed)));
                }
            });
            try {
                int i2 = BuiltInFictitiousFunctionClassFactory + 73;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private String getExtension(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            int i2 = 50 / 0;
            if (TextUtils.isEmpty(str)) {
                return APImageFormat.SUFFIX_PNG;
            }
        } else {
            if ((!TextUtils.isEmpty(str) ? 'Y' : 'a') == 'a') {
                return APImageFormat.SUFFIX_PNG;
            }
        }
        if (!(str.startsWith("image/gif") ? false : true)) {
            return APImageFormat.SUFFIX_GIF;
        }
        try {
            if (str.startsWith("image/png")) {
                return APImageFormat.SUFFIX_PNG;
            }
            if (str.startsWith("image/jpg")) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 119;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return APImageFormat.SUFFIX_JPG;
            } else if (str.startsWith("image/x-icon")) {
                int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                BuiltInFictitiousFunctionClassFactory = i5 % 128;
                int i6 = i5 % 2;
                return "x-icon";
            } else {
                return APImageFormat.SUFFIX_PNG;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void downloadFileByBase64(Activity activity, BridgeCallback bridgeCallback, String str, App app) {
        Bitmap bitmap;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            getExtension(ImageUtils.getMimeType(str));
            bitmap = ImageUtils.base64ToBitmap(str);
        } catch (Exception e) {
            GriverLogger.e(TAG, "base64 to bitmap failed", e);
            bitmap = null;
        }
        try {
            if (!(bitmap != null)) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 115;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(OuterFileUtils.getOuterRootFileDir(activity));
            sb.append(File.separator);
            sb.append(app.getAppId());
            File file = new File(sb.toString());
            if (!file.exists()) {
                try {
                    int i5 = BuiltInFictitiousFunctionClassFactory + 53;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    int i6 = i5 % 2;
                    file.mkdirs();
                } catch (Exception e2) {
                    throw e2;
                }
            }
            File file2 = new File(file, String.valueOf(System.currentTimeMillis()));
            if ((file2.exists() ? '*' : 'J') == '*') {
                file2.delete();
            }
            String absolutePath = file2.getAbsolutePath();
            try {
                if (H5FileUtil.create(absolutePath, true)) {
                    JSONObject jSONObject = new JSONObject();
                    ImageUtils.writeImage(bitmap, Bitmap.CompressFormat.PNG, absolutePath);
                    bitmap.getRowBytes();
                    bitmap.getHeight();
                    Object localIdToUrl = H5ResourceHandlerUtil.localIdToUrl(AOMPFileTinyAppUtils.encodeToLocalId(absolutePath), "image");
                    jSONObject.put("tempFilePath", (Object) absolutePath);
                    jSONObject.put("apFilePath", localIdToUrl);
                    bridgeCallback.sendJSONResponse(jSONObject);
                    return;
                }
            } catch (Throwable th) {
                GriverLogger.e(TAG, "download file failed", th);
            }
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, activity.getString(R.string.griver_write_file_fail)));
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x013b, code lost:
    
        if (r1 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x014d, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r21) ? 5 : 'D') != 'D') goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0153, code lost:
    
        if (android.text.TextUtils.isEmpty(r17) != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0155, code lost:
    
        uploadFileByHttp(r2, r24, r23, r5, r20, r21, r17, r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0165, code lost:
    
        return;
     */
    @com.alibaba.ariver.kernel.api.annotation.ThreadType(com.alibaba.ariver.kernel.common.service.executor.ExecutorType.NETWORK)
    @com.alibaba.ariver.kernel.api.annotation.ActionFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadFile(@com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext(required = true) com.alibaba.ariver.engine.api.bridge.model.ApiContext r15, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode(com.alibaba.ariver.app.api.App.class) com.alibaba.ariver.app.api.App r16, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"url"}) java.lang.String r17, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"filePath"}) java.lang.String r18, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"localId"}) java.lang.String r19, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"name"}) java.lang.String r20, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"type"}) java.lang.String r21, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"header"}) com.alibaba.fastjson.JSONObject r22, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(name = {"formData"}) com.alibaba.fastjson.JSONObject r23, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r24) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.file.jsapi.FileMangerBridgeExtension.uploadFile(com.alibaba.ariver.engine.api.bridge.model.ApiContext, com.alibaba.ariver.app.api.App, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.alibaba.fastjson.JSONObject, com.alibaba.fastjson.JSONObject, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        if ((r29.isEmpty()) != true) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
    
        if (r29.isEmpty() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        r6 = r29.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
    
        if (r6.hasNext() == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
    
        r9 = r6.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009c, code lost:
    
        if (r29.get(r9) == null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        r10 = r29.get(r9).toString();
        r12.append("------WebKitFormBoundaryT1HoybnYeFOGFlBR\r\n");
        r8 = new java.lang.StringBuilder();
        r8.append("Content-Disposition: form-data; name=\"");
        r8.append(r9);
        r8.append("\"\r\n");
        r12.append(r8.toString());
        r12.append("\r\n");
        r8 = new java.lang.StringBuilder();
        r8.append(r10);
        r8.append("\r\n");
        r12.append(r8.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:95:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0313 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0314  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void uploadFileByHttp(final android.content.Context r27, final com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r28, java.util.Map<java.lang.String, java.lang.Object> r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, com.alibaba.fastjson.JSONObject r34) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.file.jsapi.FileMangerBridgeExtension.uploadFileByHttp(android.content.Context, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.alibaba.fastjson.JSONObject):void");
    }

    private static Map<String, List<String>> fixEmptyKeyHeader(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
                try {
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    String next = it.next();
                    if ((!TextUtils.isEmpty(next) ? '.' : '-') != '-') {
                        hashMap.put(next, map.get(next));
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
            throw e;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 24 / 0;
            return hashMap;
        }
        return hashMap;
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $11 + 105;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? (char) 27 : '7') != '7') {
                int i4 = $11 + 5;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
                cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
                cArr4[i7] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (MyBillsEntityDataFactory ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
