package com.alibaba.griver.file.jsapi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.ui.loadingview.GriverLoadingViewExtension;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.proxy.LocalIdTool;
import com.alibaba.griver.base.common.utils.AOMPFileTinyAppUtils;
import com.alibaba.griver.base.common.utils.H5FileUtil;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.file.R;
import com.alibaba.griver.file.utils.MimeTypeUtil;
import com.alibaba.griver.image.photo.PhotoContext;
import com.alipay.multimedia.adjuster.utils.PathUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ChooseFileBridgeExtension extends SimpleBridgeExtension {
    public static final String ACTION_CHOOSE_FILE = "choose_file";
    public static final String CHOOSE_FILE_RESULT_CANCELED = "cancel";
    public static final String CHOOSE_FILE_RESULT_DATA_KEY = "fileUri";
    public static final String CHOOSE_FILE_RESULT_KEY = "result";
    private static final int ERROR_CODE_COPY_FILE = 12;
    private static final int ERROR_CODE_LACK_PERMISSION = 17;
    private static final int ERROR_CODE_SIZE_LIMITATION = 18;
    private static final int ERROR_CODE_USER_CANCEL = 15;
    private static final int ERROR_CODE_USER_DENY_PERMISSION = 16;
    private static final String TAG = "ChooseFileBridgeExtension";
    private BroadcastReceiver receiver;

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void chooseFileFromDisk(@BindingNode(Page.class) Page page, @BindingCallback final BridgeCallback bridgeCallback) {
        String[] strArr;
        GriverLogger.d(TAG, "start choose file from disk");
        if (page.getPageContext() == null) {
            GriverLogger.w(TAG, "context is null, return unknown error");
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        final Activity activity = page.getPageContext().getActivity();
        if (activity == null) {
            GriverLogger.w(TAG, "activity is null, return unknown error");
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"};
        } else {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        }
        if (PermissionUtils.hasPermission(strArr)) {
            startChooseFile(activity, bridgeCallback);
        } else {
            PermissionUtils.requestPermissions(strArr, 2001, new IPermissionRequestCallback() { // from class: com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension.1
                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                public void onRequestPermissionResult(int i, String[] strArr2, int[] iArr) {
                    if (PermissionUtils.positivePermissionResult(iArr)) {
                        ChooseFileBridgeExtension.this.startChooseFile(activity, bridgeCallback);
                    } else if (ActivityCompat.MyBillsEntityDataFactory(activity, "android.permission.READ_MEDIA_AUDIO") || ActivityCompat.MyBillsEntityDataFactory(activity, "android.permission.READ_MEDIA_VIDEO") || ActivityCompat.MyBillsEntityDataFactory(activity, "android.permission.READ_MEDIA_IMAGES")) {
                        ChooseFileBridgeExtension.this.sendUserDenyCallback(GriverEnv.getResources(), bridgeCallback);
                    } else {
                        ChooseFileBridgeExtension.this.sendLackPermissionCallback(GriverEnv.getResources(), bridgeCallback);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserDenyCallback(Resources resources, BridgeCallback bridgeCallback) {
        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(16, resources == null ? "User denied read storage permission" : resources.getString(R.string.griver_file_user_deny_permission)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLackPermissionCallback(Resources resources, BridgeCallback bridgeCallback) {
        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(17, resources == null ? "Lack read storage permission" : resources.getString(R.string.griver_file_lack_permission)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserCancelCallback(Resources resources, BridgeCallback bridgeCallback) {
        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(15, resources == null ? "User cancels file selection" : resources.getString(R.string.griver_file_user_cancel_select)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCopyFileErrorCallback(Resources resources, BridgeCallback bridgeCallback) {
        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, resources == null ? "File copy error" : resources.getString(R.string.griver_file_copy_error)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSizeLimitationCallback(Resources resources, BridgeCallback bridgeCallback) {
        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(18, resources == null ? "Can not choose large file" : resources.getString(R.string.griver_file_file_size_error)));
    }

    private void startChooseFileIntent(Activity activity) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 19) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        } else {
            intent = new Intent("android.intent.action.GET_CONTENT");
        }
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        activity.startActivityForResult(intent, 200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startChooseFile(Activity activity, BridgeCallback bridgeCallback) {
        startChooseFileIntent(activity);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CHOOSE_FILE);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(GriverEnv.getApplicationContext());
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            localBroadcastManager.unregisterReceiver(broadcastReceiver);
            this.receiver = null;
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(localBroadcastManager, bridgeCallback, activity);
        this.receiver = anonymousClass2;
        localBroadcastManager.registerReceiver(anonymousClass2, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 extends BroadcastReceiver {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ BridgeCallback val$callback;
        final /* synthetic */ LocalBroadcastManager val$manager;

        AnonymousClass2(LocalBroadcastManager localBroadcastManager, BridgeCallback bridgeCallback, Activity activity) {
            this.val$manager = localBroadcastManager;
            this.val$callback = bridgeCallback;
            this.val$activity = activity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            GriverLogger.d(ChooseFileBridgeExtension.TAG, "choose file receive");
            if (intent == null || !TextUtils.equals(intent.getAction(), ChooseFileBridgeExtension.ACTION_CHOOSE_FILE)) {
                return;
            }
            this.val$manager.unregisterReceiver(this);
            ChooseFileBridgeExtension.this.receiver = null;
            if (TextUtils.equals("cancel", intent.getStringExtra("result"))) {
                ChooseFileBridgeExtension.this.sendUserCancelCallback(GriverEnv.getResources(), this.val$callback);
                return;
            }
            final Uri uri = (Uri) intent.getParcelableExtra(ChooseFileBridgeExtension.CHOOSE_FILE_RESULT_DATA_KEY);
            StringBuilder sb = new StringBuilder();
            sb.append("user choose: ");
            sb.append(uri);
            GriverLogger.d(ChooseFileBridgeExtension.TAG, sb.toString());
            if (uri != null) {
                ChooseFileBridgeExtension.this.showLoading(this.val$activity);
                GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final String obj = uri.toString();
                        if (TextUtils.isEmpty(obj)) {
                            ChooseFileBridgeExtension.this.hideLoading();
                            AnonymousClass2.this.val$callback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                        } else if (ChooseFileBridgeExtension.this.exceedSizeThreshold(obj)) {
                            ChooseFileBridgeExtension.this.hideLoading();
                            ChooseFileBridgeExtension.this.sendSizeLimitationCallback(GriverEnv.getResources(), AnonymousClass2.this.val$callback);
                        } else if (obj.startsWith(PathUtils.CONTENT_SCHEMA) && (obj = ChooseFileBridgeExtension.this.copyContentToTemp(uri)) == null) {
                            ChooseFileBridgeExtension.this.hideLoading();
                            ChooseFileBridgeExtension.this.sendCopyFileErrorCallback(GriverEnv.getResources(), AnonymousClass2.this.val$callback);
                        } else {
                            GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChooseFileBridgeExtension.this.hideLoading();
                                    String encodeToLocalId = LocalIdTool.get().encodeToLocalId(obj);
                                    String typeFromUri = ChooseFileBridgeExtension.this.getTypeFromUri(uri);
                                    if (typeFromUri == null) {
                                        typeFromUri = "other";
                                    }
                                    String localIdToUrl = H5ResourceHandlerUtil.localIdToUrl(encodeToLocalId, typeFromUri);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("apFilePath", (Object) localIdToUrl);
                                    jSONObject.put("success", (Object) Boolean.TRUE);
                                    AnonymousClass2.this.val$callback.sendJSONResponse(jSONObject);
                                }
                            });
                        }
                    }
                });
                return;
            }
            this.val$callback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }

    private static String getFileNameFromUri(Uri uri, Context context) {
        String str = null;
        if (uri == null) {
            return null;
        }
        String[] strArr = {"_display_name"};
        Cursor query = context.getContentResolver().query(uri, strArr, null, null, null);
        if (query != null) {
            query.moveToFirst();
            try {
                str = query.getString(query.getColumnIndex(strArr[0]));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("cursor.getString exception ");
                sb.append(e.getMessage());
                GriverLogger.e(TAG, sb.toString());
            }
            try {
                query.close();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cursor.close exception ");
                sb2.append(e2.getMessage());
                GriverLogger.e(TAG, sb2.toString());
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean exceedSizeThreshold(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(PhotoContext.FILE_SCHEME)) {
            File file = new File(str.replace(PhotoContext.FILE_SCHEME, ""));
            if (file.exists()) {
                try {
                    return ((double) new FileInputStream(file).available()) > getMaxSize();
                } catch (Exception e) {
                    GriverLogger.e(TAG, "compare file size exception", e);
                }
            }
            return false;
        }
        if (str.startsWith(PathUtils.CONTENT_SCHEMA)) {
            try {
                InputStream openInputStream = GriverEnv.getApplicationContext().getContentResolver().openInputStream(Uri.parse(str));
                if (openInputStream == null) {
                    return false;
                }
                return ((double) openInputStream.available()) > getMaxSize();
            } catch (Exception e2) {
                GriverLogger.e(TAG, "compare content file size exception", e2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension.3
            @Override // java.lang.Runnable
            public void run() {
                ((GriverLoadingViewExtension) RVProxy.get(GriverLoadingViewExtension.class)).dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading(final Activity activity) {
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension.4
            @Override // java.lang.Runnable
            public void run() {
                ((GriverLoadingViewExtension) RVProxy.get(GriverLoadingViewExtension.class)).show(activity, "", false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTypeFromUri(Uri uri) {
        if (uri == null) {
            return null;
        }
        String obj = uri.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("choose file getTypeFromUri for: ");
        sb.append(obj);
        GriverLogger.d(TAG, sb.toString());
        String mimeType = H5FileUtil.getMimeType(obj);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("choose file getTypeFromUri mimeType: ");
        sb2.append(mimeType);
        GriverLogger.d(TAG, sb2.toString());
        if (mimeType == null) {
            mimeType = MimeTypeUtil.getMimeType(getFileNameFromUri(uri, GriverEnv.getApplicationContext()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("choose file getTypeFromUri mimeType: ");
            sb3.append(mimeType);
            sb3.append(" by fileName");
            GriverLogger.d(TAG, sb3.toString());
        }
        if (TextUtils.isEmpty(mimeType)) {
            if (obj.startsWith(PathUtils.CONTENT_SCHEMA) && obj.contains("image")) {
                mimeType = "image";
            } else if (obj.startsWith(PathUtils.CONTENT_SCHEMA) && obj.contains("video")) {
                mimeType = "video";
            } else if (obj.startsWith(PathUtils.CONTENT_SCHEMA) && obj.contains(H5ResourceHandlerUtil.AUDIO)) {
                mimeType = H5ResourceHandlerUtil.AUDIO;
            }
        }
        String typeFromMimeType = AOMPFileTinyAppUtils.getTypeFromMimeType(mimeType);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("choose file getTypeFromUri result: ");
        sb4.append(typeFromMimeType);
        GriverLogger.d(TAG, sb4.toString());
        return typeFromMimeType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String copyContentToTemp(Uri uri) {
        String obj;
        try {
            InputStream openInputStream = GriverEnv.getApplicationContext().getContentResolver().openInputStream(uri);
            if (openInputStream == null || GriverEnv.getApplicationContext().getExternalCacheDir() == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(GriverEnv.getApplicationContext().getExternalCacheDir().getAbsolutePath());
            sb.append(File.separator);
            sb.append("griver");
            sb.append(File.separator);
            sb.append("tmp");
            sb.append(File.separator);
            String obj2 = sb.toString();
            File file = new File(obj2);
            if (file.exists() || file.mkdirs()) {
                String fileNameFromUri = getFileNameFromUri(uri, GriverEnv.getApplicationContext());
                if (TextUtils.isEmpty(fileNameFromUri)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    obj = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(System.currentTimeMillis());
                    sb3.append(".");
                    sb3.append(MimeTypeUtil.getExtension(fileNameFromUri));
                    obj = sb3.toString();
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(obj2);
                sb4.append(obj);
                String obj3 = sb4.toString();
                File file2 = new File(obj3);
                if (file2.createNewFile()) {
                    IOUtils.copy(openInputStream, new FileOutputStream(file2));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(PhotoContext.FILE_SCHEME);
                    sb5.append(obj3);
                    return sb5.toString();
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            GriverLogger.e(TAG, "copy file exception", e);
            return null;
        }
    }

    private double getMaxSize() {
        double parseDouble = Double.parseDouble(GriverConfigConstants.DEFAULT_CHOOSE_FILE_SIZE_THRESHOLD);
        String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_CHOOSE_FILE_SIZE_THRESHOLD, GriverConfigConstants.DEFAULT_CHOOSE_FILE_SIZE_THRESHOLD);
        try {
            if (!TextUtils.isEmpty(config)) {
                parseDouble = Double.parseDouble(config);
            }
        } catch (Exception e) {
            GriverLogger.e(TAG, "parse choose file threshold exception", e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("choose file size threshold in mb: ");
        sb.append(parseDouble);
        GriverLogger.d(TAG, sb.toString());
        return parseDouble * 1024.0d * 1024.0d;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        super.onFinalized();
        if (this.receiver == null || GriverEnv.getApplicationContext() == null) {
            return;
        }
        LocalBroadcastManager.getInstance(GriverEnv.getApplicationContext()).unregisterReceiver(this.receiver);
    }
}
