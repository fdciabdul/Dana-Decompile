package com.alibaba.griver.file.jsapi;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.a.b;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.proxy.RVFileAbilityProxy;
import com.alibaba.griver.base.common.utils.AOMPFileTinyAppUtils;
import com.alibaba.griver.base.common.utils.CommonUtils;
import com.alibaba.griver.base.common.utils.DiskUtil;
import com.alibaba.griver.base.common.utils.FileCache;
import com.alibaba.griver.base.common.utils.H5FileUtil;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.base.common.utils.TinyAppFileUtils;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.file.R;
import com.alibaba.griver.file.utils.DownloadFileHandle;
import com.alibaba.griver.image.photo.PhotoContext;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes2.dex */
public class FileBridgeExtension implements BridgeExtension, NodeAware<App> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6535a = "FileBridgeExtension";
    private static String f;
    private Map<String, DownloadFileHandle> b = new ConcurrentHashMap();
    private FileCache c;
    private String d;
    private String e;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    public static boolean deleteFile(File file, String str) {
        if (file != null && file.exists()) {
            try {
                String canonicalPath = file.getCanonicalPath();
                if (TextUtils.equals(canonicalPath, "/")) {
                    return false;
                }
                try {
                    String absolutePath = file.getAbsolutePath();
                    if (TextUtils.equals(absolutePath, "/")) {
                        return false;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (!absolutePath.startsWith(str)) {
                                if (!canonicalPath.startsWith(str)) {
                                    return false;
                                }
                            }
                        } catch (Exception e) {
                            RVLogger.e(f6535a, e);
                        }
                    }
                    return file.delete();
                } catch (Exception e2) {
                    RVLogger.e(f6535a, e2);
                    return false;
                }
            } catch (Exception e3) {
                RVLogger.e(f6535a, e3);
                return false;
            }
        }
        return false;
    }

    public static boolean isInAccessExternalPathWhiteList(Bundle bundle) {
        String config = GriverConfig.getConfig(GriverConfigConstants.KEY_ACCESS_EXTERNAL_PATH_WHITE_LIST, "");
        String string = BundleUtils.getString(bundle, "appId");
        if (!TextUtils.isEmpty(config) && !TextUtils.isEmpty(string)) {
            if (TextUtils.equals(config, "all")) {
                return true;
            }
            if (TextUtils.equals(config, "none")) {
                return false;
            }
            try {
                for (String str : config.split(",")) {
                    if (string.equals(str.trim())) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                GriverLogger.e(f6535a, "is in access external path white list exception", th);
            }
        }
        return false;
    }

    private static boolean a(JSONObject jSONObject, Context context) {
        try {
            String string = jSONObject.getString("tempFilePath");
            if (!TextUtils.isEmpty(string) && string.startsWith(PhotoContext.FILE_SCHEME)) {
                string = string.replaceAll(PhotoContext.FILE_SCHEME, "");
            }
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            File file = new File(string);
            if (file.exists()) {
                if (TextUtils.isEmpty(f)) {
                    f = context.getFilesDir().getParentFile().getCanonicalPath();
                }
                return !file.getCanonicalPath().startsWith(f);
            }
            return false;
        } catch (Throwable th) {
            GriverLogger.e(f6535a, "limitAccessExternalStorage", th);
            return true;
        }
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void saveFile(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        JSONObject jSONObject2 = new JSONObject();
        String a2 = a(jSONObject, "tempFilePath");
        if (TextUtils.isEmpty(a2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else if (TinyAppFileUtils.containsRelativeParentPath(a2)) {
            GriverLogger.w(f6535a, "tempFilePath has .. to traverse, forbidden");
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else if (a(jSONObject, apiContext.getActivity()) && !isInAccessExternalPathWhiteList(apiContext.getStartParams())) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(11, "not have permission to access external storage"));
        } else if (a(apiContext.getAppContext(), a2)) {
            jSONObject2.put("error", (Object) 19);
            jSONObject2.put("errorMessage", (Object) apiContext.getAppContext().getString(R.string.griver_exceed_file_size_limit));
            bridgeCallback.sendJSONResponse(jSONObject2);
        } else if (!a(a2)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "not have permission to save"));
        } else {
            String cachePath = a().getCachePath(apiContext.getAppContext(), a2);
            boolean copy = H5FileUtil.copy(a2, cachePath, true);
            String str = f6535a;
            StringBuilder sb = new StringBuilder();
            sb.append("saveFile..result:");
            sb.append(copy);
            RVLogger.d(str, sb.toString());
            if (copy) {
                String a3 = a(cachePath, b(CommonUtils.getString(jSONObject, "apFilePath")));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("apFilePath ");
                sb2.append(a3);
                sb2.append(" savedFilePath ");
                sb2.append(cachePath);
                RVLogger.d(str, sb2.toString());
                jSONObject2.put("apFilePath", (Object) a3);
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject2));
                return;
            }
            jSONObject2.put("error", (Object) 13);
            jSONObject2.put("errorMessage", (Object) apiContext.getAppContext().getString(R.string.griver_save_file_failed));
            bridgeCallback.sendJSONResponse(jSONObject2);
        }
    }

    private boolean a(String str) {
        File file = new File(str);
        RVFileAbilityProxy rVFileAbilityProxy = (RVFileAbilityProxy) RVProxy.get(RVFileAbilityProxy.class);
        if (rVFileAbilityProxy == null) {
            return false;
        }
        try {
            return rVFileAbilityProxy.hasFolderPermission(file.getCanonicalPath());
        } catch (IOException unused) {
            return false;
        }
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getFileInfo(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String str;
        String string = CommonUtils.getString(jSONObject, BridgeKey.FILE_PATH);
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
        }
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else if (TinyAppFileUtils.containsRelativeParentPath(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else {
            String string2 = CommonUtils.getString(jSONObject, "digestAlgorithm");
            if (TextUtils.isEmpty(string2)) {
                string2 = LottieParams.KEY_MD5;
            }
            if (!TextUtils.equals(LottieParams.KEY_MD5, string2) && !TextUtils.equals("sha1", string2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error", (Object) 16);
                jSONObject2.put("errorMessage", apiContext.getAppContext().getString(R.string.griver_digest_algorithm_only_support_md5_or_sha1));
                bridgeCallback.sendJSONResponse(jSONObject2);
                return;
            }
            try {
                String string3 = CommonUtils.getString(jSONObject, BridgeKey.FILE_PATH);
                if (!TextUtils.isEmpty(string3)) {
                    if (string3.startsWith(H5ResourceHandlerUtil.RESOURCE)) {
                        jSONObject.remove(BridgeKey.FILE_PATH);
                        jSONObject.put("apFilePath", (Object) string3);
                        str = a(jSONObject, BridgeKey.FILE_PATH);
                    } else {
                        str = a(apiContext, string3, jSONObject);
                    }
                } else {
                    String string4 = CommonUtils.getString(jSONObject, "apFilePath");
                    if (TextUtils.isEmpty(string4)) {
                        str = "";
                    } else if (string4.startsWith(H5ResourceHandlerUtil.RESOURCE)) {
                        str = a(jSONObject, BridgeKey.FILE_PATH);
                    } else {
                        str = a(apiContext, string4, jSONObject);
                    }
                }
                if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("error", (Object) 12);
                    jSONObject3.put("errorMessage", apiContext.getAppContext().getString(R.string.griver_file_not_exist));
                    bridgeCallback.sendJSONResponse(jSONObject3);
                    return;
                }
                String str2 = null;
                if (LottieParams.KEY_MD5.equals(string2)) {
                    str2 = H5FileUtil.getFileMD5(str);
                } else if ("sha1".equals(string2)) {
                    str2 = H5FileUtil.getFileSHA1(str);
                }
                JSONObject jSONObject4 = new JSONObject();
                if (TextUtils.isEmpty(str2)) {
                    jSONObject4.put("error", (Object) 17);
                    jSONObject4.put("errorMessage", apiContext.getAppContext().getString(R.string.griver_compute_digest_failed));
                } else {
                    jSONObject4.put(GriverMonitorConstants.KEY_SIZE, Long.valueOf(H5FileUtil.size(str)));
                    jSONObject4.put("digest", (Object) str2);
                }
                bridgeCallback.sendJSONResponse(jSONObject4);
                RVLogger.d(f6535a, "getFileInfo...");
            } catch (Exception e) {
                String str3 = f6535a;
                StringBuilder sb = new StringBuilder();
                sb.append("getFileInfo exception");
                sb.append(e.toString());
                RVLogger.d(str3, sb.toString());
            }
        }
    }

    private String a(ApiContext apiContext, String str, JSONObject jSONObject) {
        String userId = AOMPFileTinyAppUtils.getUserId();
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("usr/");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.d);
        sb2.append(userId);
        sb.append(b.a(sb2.toString()));
        String obj = sb.toString();
        CharSequence subPath = a().getSubPath();
        if (!str.startsWith("https://usr/")) {
            if (str.contains(obj) || (!TextUtils.isEmpty(subPath) && str.contains(subPath))) {
                return str;
            }
            return null;
        }
        String subDir = DiskUtil.getSubDir(apiContext.getAppContext(), obj);
        if (TextUtils.isEmpty(subDir)) {
            return null;
        }
        if (str.length() == 12) {
            return subDir;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(subDir);
        sb3.append("/");
        sb3.append(str.substring(12));
        return sb3.toString();
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getSavedFileInfo(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String string = CommonUtils.getString(jSONObject, BridgeKey.FILE_PATH);
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
        }
        Application applicationContext = GriverEnv.getApplicationContext();
        if (TextUtils.isEmpty(string) && applicationContext != null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, applicationContext.getString(R.string.griver_file_path_does_not_exit)));
        } else if (TinyAppFileUtils.containsRelativeParentPath(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            String a2 = a(jSONObject, BridgeKey.FILE_PATH);
            if (TextUtils.isEmpty(a2)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            } else if (!a2.contains(a().getSubPath())) {
                jSONObject2.put("error", (Object) 12);
                jSONObject2.put("errorMessage", (Object) GriverEnv.getApplicationContext().getString(R.string.griver_file_not_exist));
                bridgeCallback.sendJSONResponse(jSONObject2);
            } else {
                long size = H5FileUtil.size(a2);
                long createTime = H5FileUtil.getCreateTime(a2);
                String str = f6535a;
                StringBuilder sb = new StringBuilder();
                sb.append("filePath:");
                sb.append(a2);
                sb.append("size : ");
                sb.append(size);
                sb.append(", createTime: ");
                sb.append(createTime);
                RVLogger.d(str, sb.toString());
                if (size == 0 || createTime == 0) {
                    jSONObject2.put("error", (Object) 12);
                    bridgeCallback.sendJSONResponse(jSONObject2);
                    return;
                }
                jSONObject2.put("success", (Object) Boolean.TRUE);
                jSONObject2.put(GriverMonitorConstants.KEY_SIZE, (Object) Long.valueOf(size));
                jSONObject2.put("createTime", (Object) Long.valueOf(createTime));
                bridgeCallback.sendJSONResponse(jSONObject2);
            }
        }
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void removeSavedFile(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String string = CommonUtils.getString(jSONObject, BridgeKey.FILE_PATH);
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
        }
        if (TinyAppFileUtils.containsRelativeParentPath(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        String a2 = a(jSONObject, BridgeKey.FILE_PATH);
        if (TextUtils.isEmpty(a2)) {
            jSONObject2.put("error", (Object) 12);
            jSONObject2.put("errorMessage", (Object) GriverEnv.getApplicationContext().getString(R.string.griver_file_not_exist));
            bridgeCallback.sendJSONResponse(jSONObject2);
        } else if (!a2.contains(a().getSubPath())) {
            jSONObject2.put("error", (Object) 12);
            jSONObject2.put("errorMessage", (Object) GriverEnv.getApplicationContext().getString(R.string.griver_file_not_exist));
            bridgeCallback.sendJSONResponse(jSONObject2);
        } else {
            boolean delete = H5FileUtil.delete(a2);
            if (delete) {
                String str = f6535a;
                StringBuilder sb = new StringBuilder();
                sb.append("filePath is ");
                sb.append(a2);
                sb.append(", result is ");
                sb.append(delete);
                RVLogger.d(str, sb.toString());
                jSONObject2.put("success", (Object) Boolean.TRUE);
                bridgeCallback.sendJSONResponse(jSONObject2);
                return;
            }
            jSONObject2.put("error", (Object) 15);
            jSONObject2.put("errorMessage", (Object) GriverEnv.getApplicationContext().getString(R.string.griver_delete_file_failed));
            bridgeCallback.sendJSONResponse(jSONObject2);
        }
    }

    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getSavedFileList(@BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        String cacheDir = a().getCacheDir(apiContext.getAppContext());
        String str = f6535a;
        StringBuilder sb = new StringBuilder();
        sb.append("getSavedFileList...");
        sb.append(cacheDir);
        RVLogger.d(str, sb.toString());
        File file = new File(cacheDir);
        JSONArray jSONArray = new JSONArray();
        boolean isDirectory = file.isDirectory();
        Object obj = Boolean.TRUE;
        if (isDirectory) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    String path = file2.getPath();
                    String a2 = a(path, b(path));
                    JSONObject jSONObject2 = new JSONObject();
                    long size = H5FileUtil.size(file2);
                    long createTime = H5FileUtil.getCreateTime(path);
                    jSONObject2.put(GriverMonitorConstants.KEY_SIZE, (Object) Long.valueOf(size));
                    jSONObject2.put("apFilePath", (Object) a2);
                    jSONObject2.put("createTime", (Object) Long.valueOf(createTime));
                    jSONArray.add(jSONObject2);
                }
                jSONObject.put("success", obj);
                jSONObject.put("fileList", (Object) jSONArray);
                bridgeCallback.sendJSONResponse(jSONObject);
                return;
            }
            jSONObject.put("error", (Object) 12);
            jSONObject.put("errorMessage", GriverEnv.getApplicationContext().getString(R.string.griver_file_not_exist));
            bridgeCallback.sendJSONResponse(jSONObject);
            return;
        }
        jSONObject.put("success", obj);
        jSONObject.put("fileList", (Object) jSONArray);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private String a(String str, String str2) {
        String encodeToLocalId = AOMPFileTinyAppUtils.encodeToLocalId(str);
        String mimeType = H5FileUtil.getMimeType(str);
        if (!TextUtils.isEmpty(mimeType)) {
            str2 = mimeType;
        }
        if (str2 != null && str2.startsWith("image")) {
            return H5ResourceHandlerUtil.localIdToUrl(encodeToLocalId, "image");
        }
        if (str2 != null && str2.startsWith(H5ResourceHandlerUtil.AUDIO)) {
            return H5ResourceHandlerUtil.localIdToUrl(encodeToLocalId, H5ResourceHandlerUtil.AUDIO);
        }
        if (str2 != null && str2.startsWith("video")) {
            return H5ResourceHandlerUtil.localIdToUrl(encodeToLocalId, "video");
        }
        return H5ResourceHandlerUtil.localIdToUrl(encodeToLocalId, "other");
    }

    private String b(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(".")) == -1) {
            return null;
        }
        String substring = str.substring(lastIndexOf + 1);
        String str2 = f6535a;
        StringBuilder sb = new StringBuilder();
        sb.append("filePath suffix: ");
        sb.append(substring);
        RVLogger.d(str2, sb.toString());
        return substring;
    }

    private String a(JSONObject jSONObject, String str) {
        String string = CommonUtils.getString(jSONObject, str);
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
            if (!TextUtils.isEmpty(string)) {
                string = AOMPFileTinyAppUtils.getLocalPathFromId(string);
            }
        }
        if (!TextUtils.isEmpty(string) && string.startsWith(PhotoContext.FILE_SCHEME)) {
            string = string.replaceAll(PhotoContext.FILE_SCHEME, "");
        }
        if (TextUtils.isEmpty(string) || !H5FileUtil.exists(string)) {
            return null;
        }
        return string;
    }

    private boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long c = c(a().getCacheDir(context));
        long length = new File(str).length();
        String str2 = f6535a;
        StringBuilder sb = new StringBuilder();
        sb.append("checkFolderSizeLimited appendSize=");
        sb.append(length);
        sb.append(",folderSize=");
        sb.append(c);
        RVLogger.d(str2, sb.toString());
        if (c + length > 10485760) {
            RVLogger.d(str2, "checkFolderSizeLimited file exceed limited size");
            return true;
        }
        return false;
    }

    private long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return a(new File(str));
    }

    private long a(File file) {
        long length;
        long j = 0;
        if (file == null) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        try {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
        } catch (Throwable th) {
            String str = f6535a;
            StringBuilder sb = new StringBuilder();
            sb.append("getFolderSize...e = ");
            sb.append(th);
            RVLogger.e(str, sb.toString());
        }
        return j;
    }

    private FileCache a() {
        if (this.c == null) {
            this.c = new FileCache(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), this.d, this.e);
        }
        return this.c;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVFileAbilityProxy rVFileAbilityProxy = (RVFileAbilityProxy) RVProxy.get(RVFileAbilityProxy.class);
        if (rVFileAbilityProxy == null) {
            return;
        }
        this.e = rVFileAbilityProxy.getUserId();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        if (weakReference.get() == null) {
            return;
        }
        this.d = weakReference.get().getAppId();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }
}
