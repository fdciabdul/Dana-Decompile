package com.alibaba.griver.image.jsapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.utils.AOMPFileTinyAppUtils;
import com.alibaba.griver.base.common.utils.FileCache;
import com.alibaba.griver.base.common.utils.H5FileUtil;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.base.common.utils.TinyUtils;
import com.alibaba.griver.image.GriverImageService;
import com.alibaba.griver.image.framework.meta.APImageInfo;
import com.alibaba.griver.image.framework.meta.ImageFileType;
import com.alipay.mobile.zebra.data.ZebraData;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class ImageInfoBridgeExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6599a = "ImageInfoBridgeExtension";
    private GriverImageService b;
    private FileCache c;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public void getImageInfo(@BindingNode(Page.class) Page page, @BindingParam({"src"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put("error", (Object) 2);
            jSONObject2.put("errorMessage", "Invalid parameters");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        String str2 = f6599a;
        StringBuilder sb = new StringBuilder();
        sb.append("getImageInfo...path=");
        sb.append(str);
        RVLogger.d(str2, sb.toString());
        try {
            if (str.startsWith(H5ResourceHandlerUtil.RESOURCE) && str.endsWith(".image")) {
                String transferApPathToLocalPath = AOMPFileTinyAppUtils.transferApPathToLocalPath(str);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(transferApPathToLocalPath, options);
                if (options.outWidth > 0 && options.outHeight > 0) {
                    com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
                    jSONObject3.put(ZebraData.ATTR_WIDTH, (Object) Integer.valueOf(options.outWidth));
                    jSONObject3.put(ZebraData.ATTR_HEIGHT, (Object) Integer.valueOf(options.outHeight));
                    jSONObject3.put("path", (Object) str);
                    if (!TextUtils.isEmpty(transferApPathToLocalPath)) {
                        jSONObject3.put(GriverMonitorConstants.KEY_SIZE, (Object) Long.valueOf(new File(transferApPathToLocalPath).length()));
                    }
                    a(transferApPathToLocalPath, jSONObject3);
                    bridgeCallback.sendJSONResponse(jSONObject3);
                    return;
                }
                if (!FileUtils.exists(transferApPathToLocalPath)) {
                    com.alibaba.fastjson.JSONObject jSONObject4 = new com.alibaba.fastjson.JSONObject();
                    jSONObject4.put("errorMessage", "file does not exist");
                    jSONObject4.put("error", (Object) 12);
                    bridgeCallback.sendJSONResponse(jSONObject4);
                    return;
                }
                com.alibaba.fastjson.JSONObject jSONObject5 = new com.alibaba.fastjson.JSONObject();
                jSONObject5.put("errorMessage", "Failed to get image information");
                jSONObject5.put("error", (Object) 18);
                bridgeCallback.sendJSONResponse(jSONObject5);
            } else if (str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getImageInfoFromNet == ");
                sb2.append(str);
                RVLogger.d(str2, sb2.toString());
                a(page, str, bridgeCallback);
            } else {
                String a2 = a(str, page.getStartParams());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("getImageInfo realPath ");
                sb3.append(a2);
                RVLogger.d(str2, sb3.toString());
                Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(page).create()).load(ResourceLoadContext.newBuilder().originUrl(a2).build());
                if (load == null) {
                    com.alibaba.fastjson.JSONObject jSONObject6 = new com.alibaba.fastjson.JSONObject();
                    jSONObject6.put("error", (Object) 12);
                    jSONObject6.put("errorMessage", "file does not exist");
                    bridgeCallback.sendJSONResponse(jSONObject6);
                    return;
                }
                Bitmap decodeStream = BitmapFactory.decodeStream(load.getStream());
                com.alibaba.fastjson.JSONObject jSONObject7 = new com.alibaba.fastjson.JSONObject();
                jSONObject7.put(ZebraData.ATTR_WIDTH, (Object) Integer.valueOf(decodeStream.getWidth()));
                jSONObject7.put(ZebraData.ATTR_HEIGHT, (Object) Integer.valueOf(decodeStream.getHeight()));
                jSONObject7.put("type", (Object) H5FileUtil.getFileExtensionFromUrl(str));
                jSONObject7.put("path", (Object) a(str));
                jSONObject7.put("orientation", "up");
                bridgeCallback.sendJSONResponse(jSONObject7);
            }
        } catch (Throwable th) {
            String str3 = f6599a;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("getImageInfo...e=");
            sb4.append(th);
            RVLogger.e(str3, sb4.toString());
            com.alibaba.fastjson.JSONObject jSONObject8 = new com.alibaba.fastjson.JSONObject();
            jSONObject8.put("error", (Object) 18);
            jSONObject8.put("errorMessage", "Failed to get image information");
            bridgeCallback.sendJSONResponse(jSONObject8);
        }
    }

    private String a(String str, Bundle bundle) {
        String string = BundleUtils.getString(bundle, "url");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return TinyUtils.getAbsoluteUrlV2(string, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.alibaba.fastjson.JSONObject jSONObject) {
        Object obj;
        GriverImageService griverImageService = this.b;
        if (griverImageService != null) {
            try {
                APImageInfo parseImageInfo = griverImageService.parseImageInfo(str);
                String str2 = ImageFileType.sTypeSuffix.get(parseImageInfo.format);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "unknown";
                }
                jSONObject.put("type", (Object) str2);
                if (parseImageInfo != null) {
                    switch (parseImageInfo.orientation) {
                        case 2:
                            obj = "up-mirrored";
                            break;
                        case 3:
                            obj = "down";
                            break;
                        case 4:
                            obj = "down-mirrored";
                            break;
                        case 5:
                            obj = "left-mirrored";
                            break;
                        case 6:
                            obj = "right";
                            break;
                        case 7:
                            obj = "right-mirrored";
                            break;
                        case 8:
                            obj = "left";
                            break;
                    }
                    jSONObject.put("orientation", obj);
                }
                obj = "up";
                jSONObject.put("orientation", obj);
            } catch (Exception e) {
                String str3 = f6599a;
                StringBuilder sb = new StringBuilder();
                sb.append("parseTypeAndOrientation exception:");
                sb.append(e.getMessage());
                RVLogger.w(str3, sb.toString());
            }
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("./")) {
            return str.substring(2);
        }
        return str.startsWith("/") ? str.substring(1) : str;
    }

    private void a(final Page page, final String str, final BridgeCallback bridgeCallback) {
        String fileExtensionFromUrl = H5FileUtil.getFileExtensionFromUrl(str);
        String str2 = f6599a;
        StringBuilder sb = new StringBuilder();
        sb.append("ext == ");
        sb.append(fileExtensionFromUrl);
        RVLogger.d(str2, sb.toString());
        if (!TextUtils.isEmpty(fileExtensionFromUrl) && !ImageUtils.checkSuffixSupported(str)) {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("error", (Object) 22);
            jSONObject.put("errorMessage", "unsupported format");
            bridgeCallback.sendJSONResponse(jSONObject);
            return;
        }
        GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.image.jsapi.ImageInfoBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection()));
                    uRLConnection.setConnectTimeout(60000);
                    uRLConnection.setReadTimeout(60000);
                    uRLConnection.connect();
                    Map<String, List<String>> headerFields = uRLConnection.getHeaderFields();
                    String str3 = "";
                    String str4 = "";
                    for (String str5 : headerFields.keySet()) {
                        String str6 = ImageInfoBridgeExtension.f6599a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str5);
                        sb2.append("---->");
                        sb2.append(headerFields.get(str5));
                        RVLogger.d(str6, sb2.toString());
                        if ("Content-Type".equalsIgnoreCase(str5) && headerFields.get(str5) != null && headerFields.get(str5).size() > 0) {
                            String str7 = headerFields.get(str5).get(0);
                            if (!TextUtils.isEmpty(str7)) {
                                str4 = AOMPFileTinyAppUtils.getTypeFromMimeType(str7);
                                str3 = H5FileUtil.getExtensionFromMimeType(str7);
                            }
                        }
                    }
                    if (headerFields == null) {
                        RVLogger.e(ImageInfoBridgeExtension.f6599a, "getImageInfoFromNet response error");
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newValue("21", "Download image failed"));
                        return;
                    }
                    String tempPath = ImageInfoBridgeExtension.this.a(page).getTempPath(GriverEnv.getApplicationContext(), str, str3);
                    H5FileUtil.create(tempPath, true);
                    File file = new File(tempPath);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    InputStream inputStream = uRLConnection.getInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(tempPath, options);
                    if (options.outWidth > 0 && options.outHeight > 0) {
                        String localIdToUrl = H5ResourceHandlerUtil.localIdToUrl(AOMPFileTinyAppUtils.encodeToLocalId(tempPath), str4);
                        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
                        jSONObject2.put(ZebraData.ATTR_WIDTH, (Object) Integer.valueOf(options.outWidth));
                        jSONObject2.put(ZebraData.ATTR_HEIGHT, (Object) Integer.valueOf(options.outHeight));
                        jSONObject2.put("path", (Object) localIdToUrl);
                        jSONObject2.put(GriverMonitorConstants.KEY_SIZE, (Object) Long.valueOf(file.length()));
                        jSONObject2.put("type", (Object) str3);
                        ImageInfoBridgeExtension.this.a(tempPath, jSONObject2);
                        bridgeCallback.sendJSONResponse(jSONObject2);
                        return;
                    }
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newValue("18", "Failed to get image information"));
                } catch (Exception e) {
                    String str8 = ImageInfoBridgeExtension.f6599a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("getImageInfoFromNet...e=");
                    sb3.append(e);
                    RVLogger.e(str8, sb3.toString());
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newValue("18", "Failed to get image information"));
                }
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.b = (GriverImageService) RVProxy.get(GriverImageService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileCache a(Page page) {
        if (this.c == null) {
            String appId = page.getApp().getAppId();
            if (TextUtils.isEmpty(appId)) {
                appId = "20000067";
            }
            this.c = new FileCache(page.getPageContext().getActivity(), appId, GriverAccount.getUserId());
        }
        return this.c;
    }
}
