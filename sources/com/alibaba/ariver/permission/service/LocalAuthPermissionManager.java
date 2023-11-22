package com.alibaba.ariver.permission.service;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.ariver.permission.R;
import com.alibaba.ariver.permission.api.proxy.AuthDialogProxy;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.api.proxy.SettingExtendProxy;
import com.alibaba.ariver.permission.view.LocalPermissionDialog;
import com.alibaba.ariver.permission.view.PermissionPermitListener;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.sendmoney.summary.SummaryActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LocalAuthPermissionManager {
    public static final String PERMISSION_ALLOWED = "1";
    public static final String PERMISSION_FORBID = "0";
    public static final String PERMISSION_FORBID_NOT_RETRY = "-1";
    public static final List<String> SHOW_RENDER_PERMISSION_DIALOG_API;

    /* renamed from: a */
    private static boolean f6186a;
    private String b;
    private final Map<String, String> c = new HashMap() { // from class: com.alibaba.ariver.permission.service.LocalAuthPermissionManager.4
        {
            LocalAuthPermissionManager.this = this;
            put(SCOPE.CONST_SCOPE_CONTACT, "contact");
            put(SCOPE.CONST_SCOPE_CLIPBOARD, "clipboard");
            put(SCOPE.CONST_SCOPE_CAMERA, "camera");
            put(SCOPE.CONST_SCOPE_BLUETOOTH, TinyAppActionState.ACTION_BLUE_TOOTH);
            put(SCOPE.CONST_SCOPE_RECORD, "audioRecord");
            put(SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM, "writePhotosAlbum");
            put(SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM, "album");
            put(SCOPE.CONST_SCOPE_USERLOCATION, "location");
        }
    };
    private final Map<String, String> d = new HashMap() { // from class: com.alibaba.ariver.permission.service.LocalAuthPermissionManager.5
        {
            LocalAuthPermissionManager.this = this;
            put(SCOPE.CONST_SCOPE_CONTACT, "contact");
            put(SCOPE.CONST_SCOPE_CLIPBOARD, "clipboard");
            put(SCOPE.CONST_SCOPE_CAMERA, "camera");
            put(SCOPE.CONST_SCOPE_BLUETOOTH, TinyAppActionState.ACTION_BLUE_TOOTH);
            put(SCOPE.CONST_SCOPE_RECORD, "audioRecord");
            put(SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM, "writePhotosAlbum");
            put(SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM, "album");
            put(SCOPE.CONST_SCOPE_USERLOCATION, "location");
        }
    };
    public static final ConcurrentHashMap<String, String> SHOW_PERMISSION_DIALOG_API_MAP = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, String> sActionScopeMap = new ConcurrentHashMap<>();

    /* loaded from: classes6.dex */
    public interface SCOPE {
        public static final String CONST_SCOPE_ADDRESS = "scope.address";
        public static final String CONST_SCOPE_ALI_RUN = "scope.alirun";
        public static final String CONST_SCOPE_BLUETOOTH = "scope.bluetooth";
        public static final String CONST_SCOPE_CAMERA = "scope.camera";
        public static final String CONST_SCOPE_CHOOSE_PHOTOS_ALBUM = "scope.album";
        public static final String CONST_SCOPE_CLIPBOARD = "scope.clipBoard";
        public static final String CONST_SCOPE_CONTACT = "scope.contact";
        public static final String CONST_SCOPE_INVOICE_TITLE = "scope.invoiceTitle";
        public static final String CONST_SCOPE_MAINCITY = "scope.mainCity";
        public static final String CONST_SCOPE_RECORD = "scope.audioRecord";
        public static final String CONST_SCOPE_TB_AUTH = "scope.ta_tb_auth";
        public static final String CONST_SCOPE_USERINFO = "scope.userInfo";
        public static final String CONST_SCOPE_USERLOCATION = "scope.location";
        public static final String CONST_SCOPE_WRITE_PHOTOS_ALBUM = "scope.writePhotosAlbum";
    }

    static {
        ArrayList arrayList = new ArrayList();
        SHOW_RENDER_PERMISSION_DIALOG_API = arrayList;
        f6186a = false;
        arrayList.add("NBComponent.render");
        arrayList.add("NBComponent.sendMessage");
    }

    /* loaded from: classes6.dex */
    public static class PermissionDialogData {
        public Map<String, List<ResultObject>> data = new ConcurrentHashMap();

        public static List<ResultObject> getCurrentDialog(Node node, String str) {
            Map<String, List<ResultObject>> map;
            App app = (App) node.bubbleFindNode(App.class);
            if (app == null || (map = ((PermissionDialogData) app.getData(PermissionDialogData.class, true)).data) == null) {
                return null;
            }
            return map.get(str);
        }

        public static void add(Node node, String str, List<ResultObject> list) {
            App app = (App) node.bubbleFindNode(App.class);
            if (app == null) {
                return;
            }
            Map<String, List<ResultObject>> map = ((PermissionDialogData) app.getData(PermissionDialogData.class, true)).data;
            StringBuilder sb = new StringBuilder();
            sb.append("PermissionDialogData add scope ");
            sb.append(str);
            sb.append(" resultObjects ");
            sb.append(list);
            sb.append(" with node: ");
            sb.append(app);
            RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
            if (map != null) {
                map.put(str, list);
            }
        }

        public static List<ResultObject> remove(Node node, String str) {
            App app = (App) node.bubbleFindNode(App.class);
            if (app == null) {
                return null;
            }
            Map<String, List<ResultObject>> map = ((PermissionDialogData) app.getData(PermissionDialogData.class, true)).data;
            StringBuilder sb = new StringBuilder();
            sb.append("PermissionDialogData remove scope ");
            sb.append(str);
            sb.append(" with node: ");
            sb.append(app);
            RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
            if (map != null) {
                return map.remove(str);
            }
            return null;
        }
    }

    public LocalAuthPermissionManager() {
        b();
        a();
    }

    private void a() {
        a(ProcessUtils.getContext());
    }

    private void a(Context context) {
        try {
            SettingExtendProxy settingExtendProxy = (SettingExtendProxy) RVProxy.get(SettingExtendProxy.class);
            if (settingExtendProxy == null) {
                return;
            }
            String extendAction = settingExtendProxy.getExtendAction();
            String extendDescription = settingExtendProxy.getExtendDescription();
            this.b = settingExtendProxy.getExtendScope();
            if (TextUtils.isEmpty(extendAction) || TextUtils.isEmpty(extendDescription)) {
                return;
            }
            JSONArray parseArray = JSONUtils.parseArray(extendAction);
            JSONArray parseArray2 = JSONUtils.parseArray(extendDescription);
            JSONArray parseArray3 = JSONUtils.parseArray(this.b);
            if (parseArray == null || parseArray2 == null || parseArray.size() <= 0 || parseArray2.size() <= 0) {
                return;
            }
            for (int i = 0; i < parseArray.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("put ext action ");
                sb.append(extendAction);
                RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
                String str = (String) parseArray.get(i);
                String str2 = (String) parseArray2.get(i);
                String str3 = (String) parseArray3.get(i);
                SHOW_PERMISSION_DIALOG_API_MAP.put(str, str2);
                sActionScopeMap.put(str, str3);
            }
        } catch (Exception e) {
            RVLogger.e("AriverPermission:LocalAuthPermissionManager", "loadExtApiForInside exception", e);
        }
    }

    public static String getStringValueFromMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return null;
            }
            return applicationInfo.metaData.getString(str);
        } catch (Exception e) {
            RVLogger.e("AriverPermission:LocalAuthPermissionManager", "getStringValueFromMetaData ", e);
            return null;
        }
    }

    private void b() {
        String string;
        String string2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (f6186a) {
            return;
        }
        f6186a = true;
        Context context = ProcessUtils.getContext();
        if (context == null) {
            str = "Use your location";
            str2 = "Access your camera";
            str3 = "Save pictures to your album";
            string = "Use your microphone";
            str4 = "Use your bluetooth";
            str5 = "Visit your contact";
            string2 = "Get the contents of your clipboard";
        } else {
            Resources resources = context.getResources();
            String string3 = resources.getString(R.string.tiny_request_location_permission);
            String string4 = resources.getString(R.string.tiny_request_camera_permission);
            string = resources.getString(R.string.tiny_request_record_permission);
            String string5 = resources.getString(R.string.tiny_save_photo_permission);
            resources.getString(R.string.tiny_choose_photo_permission);
            String string6 = resources.getString(R.string.tiny_request_bluetooth_permission);
            String string7 = resources.getString(R.string.tiny_request_contact_permission);
            string2 = resources.getString(R.string.tiny_request_clipboard_permission);
            str = string3;
            str2 = string4;
            str3 = string5;
            str4 = string6;
            str5 = string7;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = SHOW_PERMISSION_DIALOG_API_MAP;
        concurrentHashMap.put("getLocation", str);
        concurrentHashMap.put("getCurrentLocation", str);
        concurrentHashMap.put("authMapLocation", str);
        concurrentHashMap.put("scan", str2);
        concurrentHashMap.put("chooseImage", "%s\n%s");
        concurrentHashMap.put("chooseVideo", "%s\n%s");
        concurrentHashMap.put("saveImage", str3);
        concurrentHashMap.put("startAudioRecord", string);
        concurrentHashMap.put("stopAudioRecord", string);
        concurrentHashMap.put("cancelAudioRecord", string);
        concurrentHashMap.put("saveVideoToPhotosAlbum", str3);
        concurrentHashMap.put("shareTokenImageSilent", str3);
        concurrentHashMap.put("enableBluetooth", str4);
        concurrentHashMap.put("connectBLEDevice", str4);
        concurrentHashMap.put("openBluetoothAdapter", str4);
        concurrentHashMap.put("getBeacons", str4);
        concurrentHashMap.put("NBComponent.render", "%s\n%s");
        concurrentHashMap.put("NBComponent.sendMessage", "%s\n%s");
        concurrentHashMap.put("contact", str5);
        concurrentHashMap.put("chooseContact", str5);
        concurrentHashMap.put("APSocialNebulaPlugin.selectContactJSAPI", str5);
        concurrentHashMap.put("getMainSelectedCity", str);
        concurrentHashMap.put("getClipboard", string2);
        concurrentHashMap.put("xNNGraphRequestCameraPermission", str2);
        concurrentHashMap.put("xNNGraphRequestMicrophonePermission", string);
    }

    private boolean a(Page page) {
        if (page == null) {
            return false;
        }
        return page.getEmbedType().isEmbedPage();
    }

    /* JADX WARN: Removed duplicated region for block: B:354:0x00e5 A[Catch: Exception -> 0x018f, TryCatch #0 {Exception -> 0x018f, blocks: (B:365:0x0127, B:369:0x0130, B:371:0x013a, B:373:0x0144, B:377:0x015f, B:379:0x0167, B:381:0x0171, B:342:0x00b7, B:344:0x00bd, B:349:0x00cd, B:351:0x00d3, B:352:0x00df, B:354:0x00e5, B:356:0x00f1, B:362:0x011c), top: B:572:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x01e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:587:0x011c A[EDGE_INSN: B:587:0x011c->B:362:0x011c BREAK  A[LOOP:2: B:352:0x00df->B:361:0x0119], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkShowPermissionDialog(final com.alibaba.ariver.kernel.api.security.Permission r22, final com.alibaba.ariver.engine.api.bridge.model.NativeCallContext r23, final com.alibaba.ariver.permission.api.proxy.AuthenticationProxy.LocalPermissionCallback r24, com.alibaba.ariver.app.api.Page r25) {
        /*
            Method dump skipped, instructions count: 1378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.service.LocalAuthPermissionManager.checkShowPermissionDialog(com.alibaba.ariver.kernel.api.security.Permission, com.alibaba.ariver.engine.api.bridge.model.NativeCallContext, com.alibaba.ariver.permission.api.proxy.AuthenticationProxy$LocalPermissionCallback, com.alibaba.ariver.app.api.Page):boolean");
    }

    private String a(AppModel appModel, String str, String str2, boolean z) {
        String aggregationMainAppId = AppPermissionUtils.getAggregationMainAppId(appModel);
        return TextUtils.isEmpty(aggregationMainAppId) ? !z ? AppPermissionUtils.getAggregationMainAppIdForH5Page(str, str2) : str : aggregationMainAppId;
    }

    private void a(Permission permission) {
        StringBuilder sb = new StringBuilder();
        sb.append("checkIfSendAuthedLogToRemoteDebug: ");
        sb.append(permission);
        RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
    }

    public void a(Page page, String str, String str2) {
        List<ResultObject> remove = PermissionDialogData.remove(page, str2);
        if (remove != null) {
            for (ResultObject resultObject : remove) {
                if (resultObject.permissionCallback != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("cancelAuth...action=");
                    sb.append(str);
                    sb.append(" on resultObject: ");
                    sb.append(resultObject);
                    RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
                    resultObject.permissionCallback.onNegative(true);
                }
            }
        }
    }

    public void a(Node node, String str, String str2) {
        List<ResultObject> remove = PermissionDialogData.remove(node, str2);
        if (remove != null) {
            for (ResultObject resultObject : remove) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendResult...action=");
                sb.append(str);
                sb.append(" on resultObject: ");
                sb.append(resultObject);
                RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
                try {
                    resultObject.permissionCallback.onPositive();
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("use local permission send result error:\t");
                    sb2.append(e.getMessage());
                    RVLogger.e("AriverPermission:LocalAuthPermissionManager", sb2.toString());
                }
            }
        }
    }

    private String a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        if (jSONObject2 != null) {
            String string = jSONObject2.getString("desc");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string;
        }
        return null;
    }

    private String a(String str, Map<String, String> map) {
        if ("chooseImage".equals(str) || "chooseVideo".equals(str) || "NBComponent.render".equalsIgnoreCase(str) || "NBComponent.sendMessage".equalsIgnoreCase(str)) {
            if (map == null || map.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                sb.append(it.next().getValue());
                sb.append("，");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        return SHOW_PERMISSION_DIALOG_API_MAP.get(str);
    }

    private String a(String str, String str2) {
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append("_");
        sb.append(str);
        sb.append("_");
        sb.append(str2.substring(str2.indexOf(".") + 1, str2.length()));
        return sb.toString();
    }

    private String a(String str, PermissionModel permissionModel) {
        String string = (permissionModel == null || permissionModel.getNativeApiUserAuth() == null || !permissionModel.getNativeApiUserAuth().containsKey(str)) ? "" : permissionModel.getNativeApiUserAuth().getString(str);
        if (TextUtils.isEmpty(string)) {
            if ("scan".equals(str) || "xNNGraphRequestCameraPermission".equals(str)) {
                string = SCOPE.CONST_SCOPE_CAMERA;
            } else if ("saveImage".equals(str) || "saveVideoToPhotosAlbum".equals(str) || "shareTokenImageSilent".equals(str)) {
                string = SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM;
            } else if (str.contains("Location") || "getMainSelectedCity".equals(str)) {
                string = SCOPE.CONST_SCOPE_USERLOCATION;
            } else if (str.contains("AudioRecord") || "xNNGraphRequestMicrophonePermission".equals(str)) {
                string = SCOPE.CONST_SCOPE_RECORD;
            } else if (str.equals("enableBluetooth") || str.equals("openBluetoothAdapter") || str.equals("connectBLEDevice") || str.equals("getBeacons")) {
                string = SCOPE.CONST_SCOPE_BLUETOOTH;
            } else if ("contact".equals(str) || "chooseContact".equals(str) || "APSocialNebulaPlugin.selectContactJSAPI".equals(str)) {
                string = SCOPE.CONST_SCOPE_CONTACT;
            } else if ("getClipboard".equals(str)) {
                string = SCOPE.CONST_SCOPE_CLIPBOARD;
            }
        }
        if (TextUtils.isEmpty(string)) {
            String str2 = sActionScopeMap.get(str);
            if (TextUtils.isEmpty(str2)) {
                return string;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("scope.");
            sb.append(str2);
            return sb.toString();
        }
        return string;
    }

    public Map<String, Boolean> getAllPermissions(String str, AppModel appModel, Page page, Map<String, Map<String, PermissionModel>> map) {
        RVAppInfoManager rVAppInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        if (appModel == null) {
            appModel = rVAppInfoManager.getAppModel(AppInfoQuery.make(str));
        }
        boolean z = false;
        if (page != null && page.getApp() != null) {
            z = page.getApp().isTinyApp();
        }
        return getAllPermissions(str, appModel, map, a(appModel, str, page != null ? page.getPageURI() : null, z));
    }

    public Map<String, Boolean> getAllPermissions(String str, AppModel appModel, Map<String, Map<String, PermissionModel>> map, String str2) {
        Map<String, PermissionModel> map2;
        JSONObject nativeApiScopeConfig;
        JSONArray parseArray;
        Map<String, PermissionModel> map3;
        JSONObject nativeApiScopeConfig2;
        RVAppInfoManager rVAppInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        if (appModel == null) {
            appModel = rVAppInfoManager.getAppModel(AppInfoQuery.make(str));
        }
        HashMap hashMap = new HashMap();
        if (appModel == null || appModel.getPermissionModel() == null || appModel.getPermissionModel().getNativeApiScopeConfig() == null) {
            HashSet<String> hashSet = new HashSet();
            boolean z = false;
            if (map != null && map.get(str) != null && !map.get(str).isEmpty() && map != null && (map2 = map.get(str)) != null && !map2.isEmpty()) {
                for (PermissionModel permissionModel : map2.values()) {
                    if (permissionModel != null && (nativeApiScopeConfig = permissionModel.getNativeApiScopeConfig()) != null) {
                        z = true;
                        hashSet.addAll(nativeApiScopeConfig.keySet());
                    }
                }
            }
            if (z) {
                for (String str3 : hashSet) {
                    String permissionByScope = getPermissionByScope(str, str2, str3);
                    if (!TextUtils.isEmpty(permissionByScope)) {
                        hashMap.put(str3, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope)));
                    }
                }
            } else {
                String permissionByScope2 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_USERLOCATION);
                if (!TextUtils.isEmpty(permissionByScope2)) {
                    hashMap.put(SCOPE.CONST_SCOPE_USERLOCATION, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope2)));
                }
                String permissionByScope3 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_RECORD);
                if (!TextUtils.isEmpty(permissionByScope3)) {
                    hashMap.put(SCOPE.CONST_SCOPE_RECORD, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope3)));
                }
                String permissionByScope4 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM);
                if (!TextUtils.isEmpty(permissionByScope4)) {
                    hashMap.put(SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope4)));
                }
                String permissionByScope5 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM);
                if (!TextUtils.isEmpty(permissionByScope5)) {
                    hashMap.put(SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope5)));
                }
                String permissionByScope6 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_CAMERA);
                if (!TextUtils.isEmpty(permissionByScope6)) {
                    hashMap.put(SCOPE.CONST_SCOPE_CAMERA, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope6)));
                }
                String permissionByScope7 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_BLUETOOTH);
                if (!TextUtils.isEmpty(permissionByScope7)) {
                    hashMap.put(SCOPE.CONST_SCOPE_BLUETOOTH, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope7)));
                }
                String permissionByScope8 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_TB_AUTH);
                if (!TextUtils.isEmpty(permissionByScope8)) {
                    hashMap.put(SCOPE.CONST_SCOPE_TB_AUTH, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope8)));
                }
                String permissionByScope9 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_CONTACT);
                if (!TextUtils.isEmpty(permissionByScope9)) {
                    hashMap.put(SCOPE.CONST_SCOPE_CONTACT, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope9)));
                }
                String permissionByScope10 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_MAINCITY);
                if (!TextUtils.isEmpty(permissionByScope10)) {
                    hashMap.put(SCOPE.CONST_SCOPE_MAINCITY, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope10)));
                }
                String permissionByScope11 = getPermissionByScope(str, str2, SCOPE.CONST_SCOPE_CLIPBOARD);
                if (!TextUtils.isEmpty(permissionByScope11)) {
                    hashMap.put(SCOPE.CONST_SCOPE_CLIPBOARD, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope11)));
                }
            }
        } else {
            HashSet<String> hashSet2 = new HashSet();
            hashSet2.addAll(appModel.getPermissionModel().getNativeApiScopeConfig().keySet());
            if (map != null && (map3 = map.get(str)) != null && !map3.isEmpty()) {
                for (PermissionModel permissionModel2 : map3.values()) {
                    if (permissionModel2 != null && (nativeApiScopeConfig2 = permissionModel2.getNativeApiScopeConfig()) != null && !nativeApiScopeConfig2.keySet().isEmpty()) {
                        hashSet2.addAll(nativeApiScopeConfig2.keySet());
                    }
                }
            }
            for (String str4 : hashSet2) {
                String permissionByScope12 = getPermissionByScope(str, str2, str4);
                if (!TextUtils.isEmpty(permissionByScope12)) {
                    hashMap.put(str4, Boolean.valueOf("1".equalsIgnoreCase(permissionByScope12)));
                }
            }
        }
        if (!TextUtils.isEmpty(this.b) && (parseArray = JSONUtils.parseArray(this.b)) != null && parseArray.size() > 0) {
            HashSet<String> hashSet3 = new HashSet();
            Iterator<Object> it = parseArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof String) {
                    hashSet3.add((String) next);
                }
            }
            for (String str5 : hashSet3) {
                StringBuilder sb = new StringBuilder();
                sb.append("scope.");
                sb.append(str5);
                String obj = sb.toString();
                if (!TextUtils.isEmpty(getPermissionByScope(str, str2, obj))) {
                    hashMap.put(obj, Boolean.valueOf(TextUtils.equals(getPermissionByScope(str, str2, obj), "1")));
                }
            }
        }
        return hashMap;
    }

    private boolean a(final Page page, final String str, final String str2, final String str3, final NativeCallContext nativeCallContext, final AuthenticationProxy.LocalPermissionCallback localPermissionCallback, final Map<String, String> map, PermissionModel permissionModel) {
        final String str4;
        final String str5;
        final String str6;
        String str7;
        String str8;
        String str9;
        String a2 = ("chooseImage".equals(str2) || "chooseVideo".equals(str2) || permissionModel == null || permissionModel.getNativeApiScopeConfig() == null) ? null : a(str3, permissionModel.getNativeApiScopeConfig());
        StringBuilder sb = new StringBuilder();
        sb.append("dialogContent dynamic is\t:");
        sb.append(a2);
        sb.append(", action = ");
        sb.append(str2);
        RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
        if (TextUtils.isEmpty(a2)) {
            a2 = a(str2, map);
        }
        final String str10 = a2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dialogContent native is\t:");
        sb2.append(str10);
        RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb2.toString());
        if (TextUtils.isEmpty(str10)) {
            RVLogger.d("AriverPermission:LocalAuthPermissionManager", "doShowPermissionDialog not show dialog content null");
            return false;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("doShowPermissionDialog...action:");
        sb3.append(str2);
        sb3.append(",appId:");
        sb3.append(str);
        RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb3.toString());
        String str11 = "";
        if (page == null || page.getApp() == null) {
            str4 = "";
            str5 = str4;
            str6 = str5;
            str7 = str6;
        } else {
            AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
            String a3 = a(appModel, str, page.getPageURI(), !b(page));
            StringBuilder sb4 = new StringBuilder();
            sb4.append("doShowPermissionDialog...aggregationMainAppId :");
            sb4.append(a3);
            RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb4.toString());
            if (appModel != null) {
                AppInfoModel appInfoModel = appModel.getAppInfoModel();
                EntryInfo entryInfo = (EntryInfo) page.getApp().getData(EntryInfo.class);
                if (entryInfo != null) {
                    str7 = entryInfo.title;
                    str9 = entryInfo.iconUrl;
                } else {
                    str9 = "";
                    str7 = str9;
                }
                if (appInfoModel != null) {
                    if (TextUtils.isEmpty(str7)) {
                        str7 = appInfoModel.getName();
                    }
                    if (TextUtils.isEmpty(str9)) {
                        str9 = appInfoModel.getLogo();
                    }
                }
                AppConfigModel appConfigModel = (AppConfigModel) page.getApp().getData(AppConfigModel.class);
                if (appConfigModel == null || appConfigModel.getPermission() == null || "no".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_supportCustomizeAuthUsageDesc", "yes"))) {
                    str8 = a3;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    if (map != null) {
                        Iterator<String> it = map.keySet().iterator();
                        while (it.hasNext()) {
                            String str12 = a3;
                            String string = JSONUtils.getString(JSONUtils.getJSONObject(appConfigModel.getPermission(), this.d.get(it.next()), null), "desc", "");
                            if (!TextUtils.isEmpty(string)) {
                                if (sb5.length() > 0) {
                                    sb5.append("\n");
                                }
                                sb5.append(string);
                            }
                            a3 = str12;
                        }
                        str8 = a3;
                    } else {
                        str8 = a3;
                        String string2 = JSONUtils.getString(JSONUtils.getJSONObject(appConfigModel.getPermission(), this.d.get(str3), null), "desc", "");
                        if (!TextUtils.isEmpty(string2)) {
                            sb5.append(string2);
                        }
                    }
                    str11 = sb5.toString();
                }
            } else {
                str8 = a3;
                str9 = "";
                str7 = str9;
            }
            if (b(page)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(" doShowPermissionDialog...action:");
                sb6.append(str2);
                sb6.append(" url :");
                sb6.append(page.getPageURI());
                RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb6.toString());
                str5 = str11;
                str7 = UrlUtils.getHost(page.getPageURI());
                str4 = "https://gw.alipayobjects.com/mdn/rms_ef981d/afts/img/A*qpA3TKXchKUAAAAAAAAAAABkARQnAQ";
            } else {
                str5 = str11;
                str4 = str9;
            }
            str6 = str8;
        }
        if (TextUtils.isEmpty(str7) || TextUtils.isEmpty(str4)) {
            RVLogger.d("AriverPermission:LocalAuthPermissionManager", "doShowPermissionDialog not show icon or title null");
            return false;
        } else if (a(page.getApp(), nativeCallContext.getPluginId())) {
            final String str13 = str6;
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.permission.service.LocalAuthPermissionManager.2
                {
                    LocalAuthPermissionManager.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Map map2 = map;
                    if (map2 != null && !map2.isEmpty()) {
                        Iterator it2 = map.entrySet().iterator();
                        while (it2.hasNext()) {
                            LocalAuthPermissionManager.this.changePermissionState(str, str13, (String) ((Map.Entry) it2.next()).getKey(), "1");
                        }
                    } else {
                        LocalAuthPermissionManager.this.changePermissionState(str, str13, str3, "1");
                    }
                    LocalAuthPermissionManager.this.a((Node) page, str2, str3);
                }
            });
            return true;
        } else {
            final String str14 = str7;
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.permission.service.LocalAuthPermissionManager.3
                {
                    LocalAuthPermissionManager.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Page page2 = page;
                    if (page2 == null || page2.getRender() == null || page.getRender().getActivity() == null) {
                        RVLogger.d("show localPermission but page is null");
                        return;
                    }
                    final Activity activity = page.getRender().getActivity();
                    LocalPermissionDialog localPermissionDialog = ((AuthDialogProxy) RVProxy.get(page, AuthDialogProxy.class)).getLocalPermissionDialog(activity);
                    localPermissionDialog.setDialogContent(str10, str14, str4);
                    HashMap hashMap = new HashMap();
                    if (page.getEmbedType().isEmbedPage() || "20000067".equalsIgnoreCase(str)) {
                        hashMap.put("showAlways", "yes");
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        hashMap.put("customDesc", str5);
                    }
                    ArrayList arrayList = new ArrayList();
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        Iterator it2 = map.entrySet().iterator();
                        while (it2.hasNext()) {
                            arrayList.add(((Map.Entry) it2.next()).getKey());
                        }
                    } else {
                        arrayList.add(str3);
                    }
                    hashMap.put("scopes", JSON.toJSONString(arrayList));
                    localPermissionDialog.setDialogExtraData(hashMap);
                    localPermissionDialog.setPermissionPermitListener(new PermissionPermitListener() { // from class: com.alibaba.ariver.permission.service.LocalAuthPermissionManager.3.1
                        {
                            AnonymousClass3.this = this;
                        }

                        @Override // com.alibaba.ariver.permission.view.PermissionPermitListener
                        public void onSuccess() {
                            if (map != null && !map.isEmpty()) {
                                Iterator it3 = map.entrySet().iterator();
                                while (it3.hasNext()) {
                                    LocalAuthPermissionManager.this.changePermissionState(str, str6, (String) ((Map.Entry) it3.next()).getKey(), "1");
                                }
                            } else {
                                LocalAuthPermissionManager.this.changePermissionState(str, str6, str3, "1");
                            }
                            LocalAuthPermissionManager.this.a(activity, LocalAuthPermissionManager.this.b(page) ? UrlUtils.getHost(page.getPageURI()) : str, true, true, map, str3, LocalAuthPermissionManager.this.c(page));
                            LocalAuthPermissionManager.this.a((Node) page, str2, str3);
                        }

                        @Override // com.alibaba.ariver.permission.view.PermissionPermitListener
                        public void onFailed(int i, String str15, boolean z) {
                            LocalAuthPermissionManager.this.a(page, str2, str3);
                            RVLogger.d("AriverPermission:LocalAuthPermissionManager", "checkShowPermissionDialog...cancel");
                            if (map != null && !map.isEmpty()) {
                                Iterator it3 = map.entrySet().iterator();
                                while (it3.hasNext()) {
                                    LocalAuthPermissionManager.this.changePermissionState(str, str6, (String) ((Map.Entry) it3.next()).getKey(), z ? "0" : "-1");
                                }
                            } else {
                                LocalAuthPermissionManager.this.changePermissionState(str, str6, str3, z ? "0" : "-1");
                            }
                            LocalAuthPermissionManager.this.a(activity, LocalAuthPermissionManager.this.b(page) ? UrlUtils.getHost(page.getPageURI()) : str, true, false, map, str3, LocalAuthPermissionManager.this.c(page));
                        }
                    });
                    LocalAuthPermissionManager localAuthPermissionManager = LocalAuthPermissionManager.this;
                    localAuthPermissionManager.a(activity, localAuthPermissionManager.b(page) ? UrlUtils.getHost(page.getPageURI()) : str, false, false, map, str3, LocalAuthPermissionManager.this.c(page));
                    localPermissionDialog.show();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new ResultObject(str2, nativeCallContext, localPermissionCallback));
                    PermissionDialogData.add(page, str3, arrayList2);
                }
            });
            return true;
        }
    }

    private boolean a(App app, String str) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null || !(appModel.getExtendInfos() == null || SummaryActivity.CHECKED.equals(appModel.getExtendInfos().getString("official")))) {
            return false;
        }
        if (!TextUtils.equals(appModel.getAppId(), str) && !TextUtils.isEmpty(str)) {
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            if (plugins != null) {
                for (PluginModel pluginModel : plugins) {
                    if (TextUtils.equals(pluginModel.getAppId(), str)) {
                        return pluginModel.getExtendInfo() != null && SummaryActivity.CHECKED.equals(pluginModel.getExtendInfo().getString("official"));
                    }
                }
            }
            DynamicPluginInfo dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
            if (dynamicPluginInfo != null && dynamicPluginInfo.getPluginModels() != null) {
                for (PluginModel pluginModel2 : dynamicPluginInfo.getPluginModels()) {
                    if (TextUtils.equals(pluginModel2.getAppId(), str)) {
                        return pluginModel2.getExtendInfo() != null && SummaryActivity.CHECKED.equals(pluginModel2.getExtendInfo().getString("official"));
                    }
                }
            }
        }
        return appModel.getExtendInfos() != null && SummaryActivity.CHECKED.equals(appModel.getExtendInfos().getString("official"));
    }

    public String getPermissionByScope(String str, String str2, String str3) {
        String a2 = a(str, str3);
        String b = b(str, a2);
        StringBuilder sb = new StringBuilder();
        sb.append("isThePermissionApplied,key: ");
        sb.append(a2);
        sb.append(",value: ");
        sb.append(b);
        RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
        return (!TextUtils.isEmpty(b) || TextUtils.isEmpty(str2)) ? b : b(str, a(str2, str3));
    }

    private String b(String str, String str2) {
        return ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(str, str2);
    }

    private void a(String str, String str2, String str3) {
        ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(str, str2, str3);
    }

    private void c(String str, String str2) {
        ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(str, str2);
    }

    public void removeAllPermissionInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str2);
    }

    private void a(String str) {
        c(str, a(str, SCOPE.CONST_SCOPE_USERINFO));
        c(str, a(str, SCOPE.CONST_SCOPE_USERLOCATION));
        c(str, a(str, SCOPE.CONST_SCOPE_ADDRESS));
        c(str, a(str, SCOPE.CONST_SCOPE_INVOICE_TITLE));
        c(str, a(str, SCOPE.CONST_SCOPE_ALI_RUN));
        c(str, a(str, SCOPE.CONST_SCOPE_RECORD));
        c(str, a(str, SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM));
        c(str, a(str, SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM));
        c(str, a(str, SCOPE.CONST_SCOPE_BLUETOOTH));
        c(str, a(str, SCOPE.CONST_SCOPE_TB_AUTH));
        c(str, a(str, SCOPE.CONST_SCOPE_CONTACT));
        c(str, a(str, SCOPE.CONST_SCOPE_MAINCITY));
        c(str, a(str, SCOPE.CONST_SCOPE_CLIPBOARD));
    }

    public void changePermissionState(String str, String str2, String str3, String str4) {
        String a2;
        if (TextUtils.isEmpty(str2)) {
            a2 = a(str, str3);
        } else {
            a2 = a(str2, str3);
        }
        a(str, a2, str4);
        StringBuilder sb = new StringBuilder();
        sb.append("changePermissionState,key: ");
        sb.append(a2);
        sb.append(",opened: ");
        sb.append(str4);
        RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
    }

    public void a(Context context, String str, boolean z, boolean z2, Map<String, String> map, String str2, boolean z3) {
        try {
            RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
            if (rVMonitor == null || TextUtils.isEmpty(str)) {
                return;
            }
            String str3 = null;
            if (map != null && map.keySet().contains(SCOPE.CONST_SCOPE_WRITE_PHOTOS_ALBUM) && map.keySet().contains(SCOPE.CONST_SCOPE_CAMERA)) {
                str3 = this.c.get(SCOPE.CONST_SCOPE_CAMERA);
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = this.c.get(str2);
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authAbility", str3);
            hashMap.put(HummerConstants.AUTH_TYPE, z3 ? "tinyapp" : "h5");
            hashMap.put("entity", str);
            if (!z) {
                rVMonitor.markSpmExpose(context, "a192.b10827.c72368.d148860", hashMap);
                rVMonitor.markSpmExpose(context, "a192.b10827.c72368.d148859", hashMap);
            } else if (z2) {
                rVMonitor.markSpmBehavor(context, "a192.b10827.c72368.d148859", hashMap);
            } else {
                rVMonitor.markSpmBehavor(context, "a192.b10827.c72368.d148860", hashMap);
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(" mark spm error : ");
            sb.append(th.getMessage());
            RVLogger.e("AriverPermission:LocalAuthPermissionManager", sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public class ResultObject {
        String action;
        NativeCallContext bridgeContext;
        AuthenticationProxy.LocalPermissionCallback permissionCallback;

        public ResultObject(String str, NativeCallContext nativeCallContext, AuthenticationProxy.LocalPermissionCallback localPermissionCallback) {
            LocalAuthPermissionManager.this = r1;
            this.action = str;
            this.bridgeContext = nativeCallContext;
            this.permissionCallback = localPermissionCallback;
        }
    }

    public boolean b(Page page) {
        if (page != null) {
            try {
                if (page.getApp().isTinyApp()) {
                    return page.getEmbedType().isEmbedPage();
                }
                return true;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(" isH5Type : ");
                sb.append(th.getMessage());
                RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
                return false;
            }
        }
        return false;
    }

    public boolean c(Page page) {
        if (page != null) {
            try {
                if (page.getApp() != null) {
                    return page.getApp().isTinyApp();
                }
                return false;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(" isTinyApp: ");
                sb.append(th.getMessage());
                RVLogger.d("AriverPermission:LocalAuthPermissionManager", sb.toString());
                return false;
            }
        }
        return false;
    }
}
