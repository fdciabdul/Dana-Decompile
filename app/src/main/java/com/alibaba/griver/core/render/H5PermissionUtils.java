package com.alibaba.griver.core.render;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.PermissionRequest;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.api.APWebChromeClient;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.core.ui.GriverPage;
import com.alibaba.griver.core.utils.GriverDialogUtils;
import com.alibaba.griver.lottie.utils.SharedPreferenceUtil;
import com.caverock.androidsvg.SVGParser;
import id.dana.util.permission.ManifestPermission;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class H5PermissionUtils {
    public static final int REQUEST_CODE = 50;
    public static final String TAG = "H5PermissionUtils";
    public static final Map<String, String> desc;
    public static final Map<String, List<String>> map;

    static {
        HashMap hashMap = new HashMap();
        map = hashMap;
        HashMap hashMap2 = new HashMap();
        desc = hashMap2;
        hashMap.put("android.webkit.resource.VIDEO_CAPTURE", Arrays.asList("android.permission.CAMERA"));
        hashMap.put("android.webkit.resource.AUDIO_CAPTURE", Arrays.asList(ManifestPermission.RECORD_AUDIO));
        if (Build.VERSION.SDK_INT >= 33) {
            hashMap.put("android.webkit.resource.PROTECTED_MEDIA_ID", Arrays.asList("android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"));
        } else if (Build.VERSION.SDK_INT >= 30) {
            hashMap.put("android.webkit.resource.PROTECTED_MEDIA_ID", Arrays.asList("android.permission.READ_EXTERNAL_STORAGE"));
        } else {
            hashMap.put("android.webkit.resource.PROTECTED_MEDIA_ID", Arrays.asList("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"));
        }
        hashMap.put("android.webkit.resource.MIDI_SYSEX", new ArrayList());
        hashMap2.put("android.webkit.resource.VIDEO_CAPTURE", "camera");
        hashMap2.put("android.webkit.resource.AUDIO_CAPTURE", H5ResourceHandlerUtil.AUDIO);
        hashMap2.put("android.webkit.resource.PROTECTED_MEDIA_ID", SVGParser.XML_STYLESHEET_ATTR_MEDIA);
        hashMap2.put("android.webkit.resource.MIDI_SYSEX", "midi");
    }

    public static final void processPermission(APWebChromeClient aPWebChromeClient, final PermissionRequest permissionRequest) {
        String str;
        Uri parse;
        if (Build.VERSION.SDK_INT < 21 || !(aPWebChromeClient instanceof NXWebChromeClient)) {
            return;
        }
        Page page = ((NXWebChromeClient) aPWebChromeClient).getPage();
        if (page instanceof GriverPage) {
            GriverPage griverPage = (GriverPage) page;
            if (griverPage.getWebView() != null) {
                String url = griverPage.getWebView().getUrl();
                if (TextUtils.isEmpty(url) || (parse = Uri.parse(url)) == null || TextUtils.isEmpty(parse.getHost())) {
                    str = "";
                } else {
                    str = parse.getHost();
                    GriverLogger.d(TAG, str);
                }
                if (!TextUtils.isEmpty(str)) {
                    String[] resources = permissionRequest.getResources();
                    final ArrayList arrayList = new ArrayList();
                    StringBuilder sb = new StringBuilder();
                    sb.append("H5PermissionUtils_");
                    sb.append(str);
                    final String obj = sb.toString();
                    final SharedPreferences defaultSharedPreference = SharedPreferenceUtil.getInstance().getDefaultSharedPreference(GriverEnv.getApplicationContext());
                    final JSONObject parseObject = JSONUtils.parseObject(defaultSharedPreference.getString(obj, "{}"));
                    final ArrayList arrayList2 = new ArrayList();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i = 0; i < resources.length; i++) {
                        String str2 = resources[i];
                        if (!parseObject.containsKey(str2) || parseObject.getBoolean(str2) == Boolean.FALSE) {
                            arrayList.add(str2);
                            stringBuffer.append(desc.get(str2));
                        }
                        arrayList2.addAll(map.get(str2));
                        if (i != resources.length - 1) {
                            stringBuffer.append(",");
                        }
                    }
                    if (arrayList.size() > 0) {
                        WeakReference<Activity> topActivity = GriverEnv.getTopActivity();
                        if (topActivity != null && topActivity.get() != null) {
                            Activity activity = topActivity.get();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Allow \"");
                            sb2.append(str);
                            sb2.append("\" to use your ");
                            sb2.append((Object) stringBuffer);
                            GriverDialogUtils.showMessageBox(activity, sb2.toString(), "Don't Allow", "Allow", new View.OnClickListener() { // from class: com.alibaba.griver.core.render.H5PermissionUtils.1
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        parseObject.put((String) it.next(), (Object) Boolean.FALSE);
                                    }
                                    defaultSharedPreference.edit().putString(obj, JSONObject.toJSONString(parseObject)).apply();
                                    permissionRequest.deny();
                                }
                            }, new View.OnClickListener() { // from class: com.alibaba.griver.core.render.H5PermissionUtils.2
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        parseObject.put((String) it.next(), (Object) Boolean.TRUE);
                                    }
                                    defaultSharedPreference.edit().putString(obj, JSONObject.toJSONString(parseObject)).apply();
                                    H5PermissionUtils.a(arrayList2, permissionRequest);
                                }
                            });
                            return;
                        }
                    } else {
                        a(arrayList2, permissionRequest);
                        return;
                    }
                }
            }
        }
        permissionRequest.deny();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(List<String> list, final PermissionRequest permissionRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (list != null && list.size() > 0) {
                PermissionUtils.requestPermissions((String[]) list.toArray(new String[list.size()]), 50, new IPermissionRequestCallback() { // from class: com.alibaba.griver.core.render.H5PermissionUtils.3
                    @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                    public final void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
                        if (PermissionUtils.positivePermissionsResult(iArr)) {
                            GriverLogger.d(H5PermissionUtils.TAG, "get  permission success!");
                            PermissionRequest permissionRequest2 = permissionRequest;
                            permissionRequest2.grant(permissionRequest2.getResources());
                            return;
                        }
                        permissionRequest.deny();
                    }
                });
            } else {
                permissionRequest.grant(permissionRequest.getResources());
            }
        }
    }

    public static boolean enableAllowH5Permission() {
        return GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_H5_PERMISSION_REQUEST_CONFIG, false);
    }
}
