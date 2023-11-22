package com.alibaba.griver.image.jsapi;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.proxy.LocalIdTool;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.image.GriverImageService;
import com.alibaba.griver.image.framework.meta.APImageInfo;
import com.alibaba.griver.image.framework.utils.PathToLocalUtil;
import com.alibaba.griver.image.photo.PhotoContext;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CompressImageBridgeExtension implements BridgeExtension {
    public static final int COMPRESS_LEVEL_AUTO = 4;
    public static final int COMPRESS_LEVEL_HIGH = 2;
    public static final int COMPRESS_LEVEL_LOW = 0;
    public static final int COMPRESS_LEVEL_NONE = 3;
    public static final int COMPRESS_LEVEL_NORMAL = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f6598a;
    private int b;
    private GriverImageService c;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public void compressImage(@BindingParam({"apFilePaths"}) final String[] strArr, @BindingParam({"maxWidth"}) int i, @BindingParam({"maxHeight"}) int i2, @BindingParam({"compress"}) int i3, @BindingParam(intDefault = 4, value = {"compressLevel"}) final int i4, @BindingParam({"business"}) final String str, @BindingParam({"data"}) String str2, @BindingParam({"dataType"}) String str3, @BindingRequest JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("compressImage params: ");
        sb.append(JSON.toJSONString(jSONObject));
        RVLogger.d("H5CompressImage", sb.toString());
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    if (i4 < 0 || i4 > 4) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                        return;
                    } else {
                        GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.image.jsapi.CompressImageBridgeExtension.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    CompressImageBridgeExtension.this.a(strArr, Integer.MAX_VALUE, Integer.MAX_VALUE, i4, str, bridgeCallback);
                                } catch (Exception e) {
                                    RVLogger.e("H5CompressImage", "handleEvent error", e);
                                    CompressImageBridgeExtension.this.a(bridgeCallback, 2);
                                }
                            }
                        });
                        return;
                    }
                }
            } catch (Throwable th) {
                RVLogger.e("H5CompressImage", "handleEvent.file patch error:", th);
                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleEvent error, array: ");
        sb2.append(strArr);
        sb2.append(", data: ");
        sb2.append(str2);
        sb2.append(", dataType: ");
        sb2.append(str3);
        sb2.append(",business=");
        sb2.append(str);
        RVLogger.d("H5CompressImage", sb2.toString());
        bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
    }

    public static String trimFilePath(String str) {
        if (str != null) {
            String trim = str.trim();
            return trim.startsWith(PhotoContext.FILE_SCHEME) ? trim.substring(7) : trim;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i, int i2, int i3, String str, BridgeCallback bridgeCallback) {
        String[] a2 = a(strArr, i, i2, i3, str);
        if (a2 != null) {
            a(bridgeCallback, a2);
        } else {
            a(bridgeCallback, 2);
        }
    }

    private String[] a(String[] strArr, int i, int i2, int i3, String str) {
        String[] strArr2 = new String[strArr.length];
        int max = Math.max(i, i2);
        GriverImageService griverImageService = (GriverImageService) RVProxy.get(GriverImageService.class);
        for (int i4 = 0; i4 < strArr.length; i4++) {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = strArr[i4];
            strArr2[i4] = str2;
            if (i3 != 3) {
                String trimFilePath = trimFilePath(b(str2));
                String a2 = a(i3, max, griverImageService, TextUtils.isEmpty(trimFilePath) ? null : new File(trimFilePath));
                if (a2 == null) {
                    a2 = str2;
                }
                strArr2[i4] = a2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("compressFiles item: ");
            sb.append(str2);
            sb.append(", result: ");
            sb.append(strArr2[i4]);
            sb.append(", biz: ");
            sb.append(str);
            sb.append(", cost: ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            RVLogger.d("H5CompressImage", sb.toString());
        }
        return strArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:9:0x0025, B:12:0x0031, B:17:0x0060, B:21:0x0096, B:20:0x008d, B:14:0x003b, B:16:0x0055), top: B:26:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(int r11, int r12, com.alibaba.griver.image.GriverImageService r13, java.io.File r14) {
        /*
            r10 = this;
            java.lang.String r0 = "H5CompressImage"
            r1 = 0
            if (r14 == 0) goto Ld8
            boolean r2 = r14.exists()
            if (r2 == 0) goto Ld8
            long r2 = r14.length()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto Ld8
            int r12 = r10.a(r12, r14)
            int r11 = r10.a(r11)
            java.lang.String r2 = r14.getName()
            java.lang.String r2 = r10.a(r2, r12, r11)
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> Lae
            boolean r3 = com.alibaba.griver.image.framework.utils.FileUtils.checkFile(r2)     // Catch: java.lang.Exception -> Lae
            java.lang.String r8 = "image"
            if (r3 == 0) goto L3b
            java.lang.String r2 = r10.a(r2)     // Catch: java.lang.Exception -> Lae
            java.lang.String r12 = com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil.localIdToUrl(r2, r8)     // Catch: java.lang.Exception -> Lae
        L39:
            r1 = r12
            goto L60
        L3b:
            com.alibaba.griver.image.framework.encode.APEncodeOptions r3 = new com.alibaba.griver.image.framework.encode.APEncodeOptions     // Catch: java.lang.Exception -> Lae
            r3.<init>()     // Catch: java.lang.Exception -> Lae
            com.alibaba.griver.image.framework.mode.APMaxLenMode r9 = new com.alibaba.griver.image.framework.mode.APMaxLenMode     // Catch: java.lang.Exception -> Lae
            r9.<init>(r12)     // Catch: java.lang.Exception -> Lae
            r3.mode = r9     // Catch: java.lang.Exception -> Lae
            r3.quality = r11     // Catch: java.lang.Exception -> Lae
            r3.outputFile = r2     // Catch: java.lang.Exception -> Lae
            com.alibaba.griver.image.framework.encode.APEncodeResult r12 = r13.compress(r14, r3)     // Catch: java.lang.Exception -> Lae
            boolean r13 = r12.isSuccess()     // Catch: java.lang.Exception -> Lae
            if (r13 == 0) goto L60
            java.lang.String r12 = r12.encodeFilePath     // Catch: java.lang.Exception -> Lae
            java.lang.String r2 = r10.a(r12)     // Catch: java.lang.Exception -> Lae
            java.lang.String r12 = com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil.localIdToUrl(r2, r8)     // Catch: java.lang.Exception -> Lae
            goto L39
        L60:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lae
            r12.<init>()     // Catch: java.lang.Exception -> Lae
            java.lang.String r13 = "compressFile in: "
            r12.append(r13)     // Catch: java.lang.Exception -> Lae
            r12.append(r14)     // Catch: java.lang.Exception -> Lae
            java.lang.String r13 = ", len: "
            r12.append(r13)     // Catch: java.lang.Exception -> Lae
            long r8 = r14.length()     // Catch: java.lang.Exception -> Lae
            r12.append(r8)     // Catch: java.lang.Exception -> Lae
            java.lang.String r13 = ", outPath: "
            r12.append(r13)     // Catch: java.lang.Exception -> Lae
            r12.append(r2)     // Catch: java.lang.Exception -> Lae
            java.lang.String r13 = ", length: "
            r12.append(r13)     // Catch: java.lang.Exception -> Lae
            boolean r13 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> Lae
            if (r13 == 0) goto L8d
            goto L96
        L8d:
            java.io.File r13 = new java.io.File     // Catch: java.lang.Exception -> Lae
            r13.<init>(r2)     // Catch: java.lang.Exception -> Lae
            long r4 = r13.length()     // Catch: java.lang.Exception -> Lae
        L96:
            r12.append(r4)     // Catch: java.lang.Exception -> Lae
            java.lang.String r13 = ", cost: "
            r12.append(r13)     // Catch: java.lang.Exception -> Lae
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> Lae
            long r2 = r2 - r6
            r12.append(r2)     // Catch: java.lang.Exception -> Lae
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Exception -> Lae
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r12)     // Catch: java.lang.Exception -> Lae
            goto Ld8
        Lae:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r2 = "compressFiles file: "
            r13.append(r2)
            r13.append(r14)
            java.lang.String r14 = ", quality: "
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = ", out: "
            r13.append(r11)
            r13.append(r1)
            java.lang.String r11 = " error!!"
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r11, r12)
        Ld8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.jsapi.CompressImageBridgeExtension.a(int, int, com.alibaba.griver.image.GriverImageService, java.io.File):java.lang.String");
    }

    private int a(int i, File file) {
        int i2 = this.f6598a;
        int i3 = this.b;
        if (this.c == null) {
            this.c = (GriverImageService) RVProxy.get(GriverImageService.class);
        }
        GriverImageService griverImageService = this.c;
        if (griverImageService != null) {
            APImageInfo parseImageInfo = griverImageService.parseImageInfo(file.getAbsolutePath());
            if (parseImageInfo != null && parseImageInfo.width > 0 && parseImageInfo.height > 0) {
                if (i2 > parseImageInfo.width) {
                    i2 = parseImageInfo.width;
                }
                if (i3 > parseImageInfo.height) {
                    i3 = parseImageInfo.height;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Parsed width = ");
                sb.append(parseImageInfo.width);
                sb.append(",height = ");
                sb.append(parseImageInfo.height);
                sb.append("maxWidth =");
                sb.append(this.f6598a);
                sb.append(",maxHeight = ");
                sb.append(this.b);
                sb.append("After adjust w = ");
                sb.append(i2);
                sb.append(",h = ");
                sb.append(i3);
                RVLogger.d("H5CompressImage", sb.toString());
                float f = i2 / parseImageInfo.width;
                float f2 = i3 / parseImageInfo.height;
                if (f > f2) {
                    i2 = (int) (f2 * parseImageInfo.width);
                } else {
                    i3 = (int) (f * parseImageInfo.height);
                }
                return Math.max(i2, i3);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Parse image info failed @");
            sb2.append(file.getAbsolutePath());
            RVLogger.d("H5CompressImage", sb2.toString());
            return i;
        }
        RVLogger.d("H5CompressImage", "ImageProcessor null!");
        return i;
    }

    private int a(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 4;
        } else if (i == 2 || (i == 4 && NetworkUtil.getCurrentNetworkType(GriverEnv.getApplicationContext(), false) == NetworkUtil.Network.NETWORK_WIFI)) {
            i2 = 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("calcQuality compressLevel: ");
        sb.append(i);
        RVLogger.d("H5CompressImage", sb.toString());
        return i2;
    }

    private String a(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(GriverEnv.getApplicationContext().getCacheDir());
        sb.append(File.separator);
        sb.append("apm-h5");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append("_");
        sb2.append(i2);
        sb2.append("_");
        sb2.append(str);
        File file = new File(obj, sb2.toString());
        file.getParentFile().mkdirs();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("makeOutputPath: ");
        sb3.append(file);
        RVLogger.d("H5CompressImage", sb3.toString());
        return file.getAbsolutePath();
    }

    private void a(BridgeCallback bridgeCallback, String[] strArr) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(PathToLocalUtil.AL_MEDIA_FILES, (Object) strArr);
        a(bridgeCallback, jSONObject);
    }

    private void a(BridgeCallback bridgeCallback, com.alibaba.fastjson.JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("sendResult result: ");
        sb.append(jSONObject);
        RVLogger.d("H5CompressImage", sb.toString());
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BridgeCallback bridgeCallback, int i) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("error", (Object) Integer.valueOf(i));
        a(bridgeCallback, jSONObject);
    }

    private String a(String str) {
        return LocalIdTool.get().encodeToLocalId(str);
    }

    private String b(String str) {
        if (str != null && str.startsWith(H5ResourceHandlerUtil.RESOURCE)) {
            return H5ResourceHandlerUtil.apUrlToFilePath(str);
        }
        return LocalIdTool.get().decodeToPath(str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.c = (GriverImageService) RVProxy.get(GriverImageService.class);
    }
}
