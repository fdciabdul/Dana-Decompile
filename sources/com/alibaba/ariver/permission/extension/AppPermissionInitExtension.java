package com.alibaba.ariver.permission.extension;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.PackageParsedPoint;
import com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes6.dex */
public class AppPermissionInitExtension implements AppDestroyPoint, PackageParsedPoint, PluginPackageParsedPoint {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int[] BuiltInFictitiousFunctionClassFactory = {-1592605580, -1403734981, 1300946360, -1015886678, -778967387, -1347839946, -1020793603, 1452510854, 1987826000, 564024133, 1264177651, 717276203, 720107004, 181904595, 2007507300, 761525590, -740189395, 807533042};
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    /* renamed from: a  reason: collision with root package name */
    private AuthenticationProxy f6177a;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        int i = PlaceComponentResult + 59;
        getAuthRequestContext = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        if (r9.getBytes() != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if (r9.getBytes() != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r2 = com.alibaba.ariver.permission.extension.AppPermissionInitExtension.PlaceComponentResult + 31;
        com.alibaba.ariver.permission.extension.AppPermissionInitExtension.getAuthRequestContext = r2 % 128;
        r2 = r2 % 2;
        com.alibaba.ariver.kernel.common.utils.RVLogger.d("AriverPermission:AppPermissionInitExtension", "onResourceParsed, loadFromPkgFile");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (r9.getBytes() == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r9 = com.alibaba.ariver.permission.AppPermissionUtils.parsePermissionJson(a(r8, r9.getBytes()));
        r3 = new java.lang.StringBuilder();
        r3.append("onResourceParsed: ");
        r3.append(r9);
        com.alibaba.ariver.kernel.common.utils.RVLogger.debug("AriverPermission:AppPermissionInitExtension", r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (r9 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        r7.f6177a.setPermissionModel(r8.getAppInfoModel().getAppId(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a6, code lost:
    
        if (r9 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00af, code lost:
    
        if (r9 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b1, code lost:
    
        r9 = id.dana.sendmoney.summary.SummaryActivity.CHECKED.equalsIgnoreCase(com.alibaba.ariver.kernel.common.utils.JSONUtils.getString(com.alibaba.ariver.kernel.common.utils.JSONUtils.getJSONObject(r9, com.alibaba.ariver.kernel.RVConstants.EXTRA_RES_PARAM_MAP, null), com.alibaba.ariver.app.api.PermissionUtil.KEY_FORCE_CHECK_PERMISSION, "false"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c7, code lost:
    
        if (r9 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c9, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00cb, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00cc, code lost:
    
        if (r3 == true) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cf, code lost:
    
        r5.put(com.alibaba.ariver.app.api.PermissionUtil.KEY_FORCE_CHECK_PERMISSION, java.lang.Boolean.valueOf(r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.alibaba.ariver.resource.api.models.AppModel r8, com.alibaba.ariver.resource.api.content.ResourcePackage r9) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.AppPermissionInitExtension.a(com.alibaba.ariver.resource.api.models.AppModel, com.alibaba.ariver.resource.api.content.ResourcePackage):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r2 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r2 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (r2.isTemplateValid() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        if (r4 != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] a(com.alibaba.ariver.resource.api.models.AppModel r9, byte[] r10) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L6
            r2 = 1
            goto L7
        L6:
            r2 = 0
        L7:
            if (r2 == 0) goto Lb4
            int r2 = com.alibaba.ariver.permission.extension.AppPermissionInitExtension.getAuthRequestContext
            int r2 = r2 + 13
            int r3 = r2 % 128
            com.alibaba.ariver.permission.extension.AppPermissionInitExtension.PlaceComponentResult = r3
            r3 = 2
            int r2 = r2 % r3
            if (r2 == 0) goto L25
            com.alibaba.ariver.resource.api.models.AppInfoModel r2 = r9.getAppInfoModel()
            com.alibaba.ariver.resource.api.models.TemplateConfigModel r2 = r2.getTemplateConfig()
            r4 = 66
            int r4 = r4 / r1
            if (r2 == 0) goto Lb4
            goto L2f
        L23:
            r9 = move-exception
            throw r9
        L25:
            com.alibaba.ariver.resource.api.models.AppInfoModel r2 = r9.getAppInfoModel()
            com.alibaba.ariver.resource.api.models.TemplateConfigModel r2 = r2.getTemplateConfig()
            if (r2 == 0) goto Lb4
        L2f:
            int r4 = com.alibaba.ariver.permission.extension.AppPermissionInitExtension.PlaceComponentResult
            int r4 = r4 + 115
            int r5 = r4 % 128
            com.alibaba.ariver.permission.extension.AppPermissionInitExtension.getAuthRequestContext = r5
            int r4 = r4 % r3
            if (r4 != 0) goto L3c
            r4 = 1
            goto L3d
        L3c:
            r4 = 0
        L3d:
            if (r4 == r0) goto L46
            boolean r4 = r2.isTemplateValid()
            if (r4 == 0) goto Lb4
            goto L50
        L46:
            boolean r4 = r2.isTemplateValid()
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> Lb2
            if (r4 == 0) goto Lb4
        L50:
            java.lang.String r4 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L91
            int r5 = android.view.View.MeasureSpec.getMode(r1)     // Catch: java.io.UnsupportedEncodingException -> L91
            int r5 = 5 - r5
            r6 = 4
            int[] r6 = new int[r6]     // Catch: java.io.UnsupportedEncodingException -> L91
            r7 = -977868626(0xffffffffc5b6e8ae, float:-5853.085)
            r6[r1] = r7     // Catch: java.io.UnsupportedEncodingException -> L91
            r7 = -1364025800(0xffffffffaeb29e38, float:-8.122608E-11)
            r6[r0] = r7     // Catch: java.io.UnsupportedEncodingException -> L91
            r7 = 1863693080(0x6f15b318, float:4.6329778E28)
            r6[r3] = r7     // Catch: java.io.UnsupportedEncodingException -> L91
            r3 = 3
            r7 = -1951156885(0xffffffff8bb3b56b, float:-6.922126E-32)
            r6[r3] = r7     // Catch: java.io.UnsupportedEncodingException -> L91
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.io.UnsupportedEncodingException -> L91
            b(r5, r6, r0)     // Catch: java.io.UnsupportedEncodingException -> L91
            r0 = r0[r1]     // Catch: java.io.UnsupportedEncodingException -> L91
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.UnsupportedEncodingException -> L91
            java.lang.String r0 = r0.intern()     // Catch: java.io.UnsupportedEncodingException -> L91
            r4.<init>(r10, r0)     // Catch: java.io.UnsupportedEncodingException -> L91
            java.lang.String r0 = r2.getTemplateId()     // Catch: java.io.UnsupportedEncodingException -> L91
            java.lang.String r9 = r9.getAppId()     // Catch: java.io.UnsupportedEncodingException -> L91
            java.lang.String r9 = r4.replace(r0, r9)     // Catch: java.io.UnsupportedEncodingException -> L91
            byte[] r9 = r9.getBytes()     // Catch: java.io.UnsupportedEncodingException -> L91
            return r9
        L91:
            r9 = move-exception
            java.lang.String r0 = "AriverPermission:AppPermissionInitExtension"
            java.lang.String r1 = "change api_permission error!"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r1, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "change api_permission to template: "
            r9.append(r1)
            java.lang.String r1 = r2.getTemplateId()
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r9)
            goto Lb4
        Lb2:
            r9 = move-exception
            throw r9
        Lb4:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.AppPermissionInitExtension.a(com.alibaba.ariver.resource.api.models.AppModel, byte[]):byte[]");
    }

    private boolean a(AppModel appModel) {
        if (!(appModel != null)) {
            int i = getAuthRequestContext + 79;
            PlaceComponentResult = i % 128;
            return i % 2 != 0;
        }
        PermissionModel permissionModel = appModel.getPermissionModel();
        if (permissionModel != null) {
            try {
                int i2 = getAuthRequestContext + 25;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                RVLogger.d("AriverPermission:AppPermissionInitExtension", "onResourceParsed, loadFromAppConfig");
                this.f6177a.setPermissionModel(appModel.getAppInfoModel().getAppId(), permissionModel);
                return true;
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }

    private Resource a(ResourcePackage resourcePackage) {
        int i = PlaceComponentResult + 125;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            Resource resource = resourcePackage.get(ResourceQuery.asUrl(RVConstants.FILE_API_PERMISSION).setNeedAutoCompleteHost());
            int i3 = PlaceComponentResult + 63;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return resource;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        int i = getAuthRequestContext + 91;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            this.f6177a = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
        } else {
            this.f6177a = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
            int i2 = 61 / 0;
        }
        int i3 = getAuthRequestContext + 111;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if (r1 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        if (android.text.TextUtils.isEmpty(r8.getAppInfoModel().getAppId()) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("onResourceParsed ");
        r1.append(r8.getAppInfoModel().getAppId());
        com.alibaba.ariver.kernel.common.utils.RVLogger.d("AriverPermission:AppPermissionInitExtension", r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        if ("yes".equalsIgnoreCase(((com.alibaba.ariver.kernel.common.service.RVConfigService) com.alibaba.ariver.kernel.common.RVProxy.get(com.alibaba.ariver.kernel.common.service.RVConfigService.class)).getConfigWithProcessCache("h5_skipParsePermissionFile", "yes")) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
    
        if (r8 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        r4 = kotlin.text.Typography.less;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        r4 = '.';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        if (r4 == '<') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        r1 = com.alibaba.ariver.permission.extension.AppPermissionInitExtension.PlaceComponentResult + 121;
        com.alibaba.ariver.permission.extension.AppPermissionInitExtension.getAuthRequestContext = r1 % 128;
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        if ((r1 % 2) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        if (r1 == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        r1 = r8.getExtendInfos();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
    
        r5 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0094, code lost:
    
        if (r1 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0096, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0098, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0099, code lost:
    
        if (r5 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009e, code lost:
    
        r1 = r8.getExtendInfos();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a2, code lost:
    
        if (r1 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a4, code lost:
    
        r5 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getJSONObject(r1, com.alibaba.ariver.kernel.RVConstants.EXTRA_RES_LAUNCH_PARAMS, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00aa, code lost:
    
        if (r5 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ad, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ae, code lost:
    
        if (r4 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b0, code lost:
    
        r4 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getString(r5, "checkPermission", "YES");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c2, code lost:
    
        if (com.alibaba.ariver.app.api.PermissionUtil.forceInnerPermissionCheck(com.alibaba.ariver.kernel.common.utils.JSONUtils.getJSONObject(r1, com.alibaba.ariver.kernel.RVConstants.EXTRA_RES_PARAM_MAP, null)) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ca, code lost:
    
        if ("NO".equalsIgnoreCase(r4) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cc, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.d("AriverPermission:AppPermissionInitExtension", "skip parse permission file because of checkPermission == no");
        r8 = com.alibaba.ariver.permission.extension.AppPermissionInitExtension.getAuthRequestContext + 39;
        com.alibaba.ariver.permission.extension.AppPermissionInitExtension.PlaceComponentResult = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dc, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e1, code lost:
    
        if (a(r8) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e7, code lost:
    
        if (a(r8, r9) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e9, code lost:
    
        r7.f6177a.clearPermissionModel(r8.getAppInfoModel().getAppId(), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
    
        return;
     */
    @Override // com.alibaba.ariver.resource.api.extension.PackageParsedPoint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResourceParsed(com.alibaba.ariver.resource.api.models.AppModel r8, com.alibaba.ariver.resource.api.content.ResourcePackage r9) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.permission.extension.AppPermissionInitExtension.onResourceParsed(com.alibaba.ariver.resource.api.models.AppModel, com.alibaba.ariver.resource.api.content.ResourcePackage):void");
    }

    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.alibaba.ariver.resource.api.models.PermissionModel] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.alibaba.ariver.resource.api.models.PermissionModel] */
    @Override // com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint
    public void onPluginParsed(AppModel appModel, PluginModel pluginModel, ResourcePackage resourcePackage) {
        PermissionModel generateFromJSON;
        PermissionModel permissionModel;
        if (appModel != null) {
            int i = PlaceComponentResult + 87;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if (!TextUtils.isEmpty(appModel.getAppInfoModel().getAppId())) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPluginParsed getPermission with pluginModel: ");
                sb.append(pluginModel);
                sb.append(", permissionModel: ");
                sb.append(pluginModel.getPermission());
                RVLogger.d("AriverPermission:AppPermissionInitExtension", sb.toString());
                boolean z = false;
                ?? r4 = 0;
                if (!(pluginModel.getPermission() != null)) {
                    Resource a2 = a(resourcePackage);
                    if (!(a2 == null)) {
                        int i3 = getAuthRequestContext + 11;
                        PlaceComponentResult = i3 % 128;
                        if (i3 % 2 == 0) {
                            r4 = PermissionModel.generateFromJSON(a2.getBytes());
                        } else {
                            r4 = PermissionModel.generateFromJSON(a2.getBytes());
                            int i4 = 50 / 0;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onPluginParsed getPermission from package (");
                    if (a2 != null) {
                        int i5 = PlaceComponentResult + 81;
                        getAuthRequestContext = i5 % 128;
                        int i6 = i5 % 2;
                        z = true;
                    }
                    sb2.append(z);
                    sb2.append(")");
                    RVLogger.d("AriverPermission:AppPermissionInitExtension", sb2.toString());
                    permissionModel = r4;
                } else {
                    int i7 = PlaceComponentResult + 75;
                    getAuthRequestContext = i7 % 128;
                    if (i7 % 2 == 0) {
                        generateFromJSON = PermissionModel.generateFromJSON(pluginModel.getPermission());
                        RVLogger.d("AriverPermission:AppPermissionInitExtension", "onPluginParsed getPermission from appModel");
                        int length = r4.length;
                    } else {
                        try {
                            try {
                                generateFromJSON = PermissionModel.generateFromJSON(pluginModel.getPermission());
                                RVLogger.d("AriverPermission:AppPermissionInitExtension", "onPluginParsed getPermission from appModel");
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    permissionModel = generateFromJSON;
                }
                if ((permissionModel != null ? (char) 15 : ':') != 15) {
                    return;
                }
                this.f6177a.setPluginPermissionModel(appModel.getAppId(), pluginModel, permissionModel);
                return;
            }
        }
        RVLogger.d("AriverPermission:AppPermissionInitExtension", "onPluginParsed appId is null, return");
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        int i = PlaceComponentResult + 1;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            this.f6177a.clearPermissionModel(app.getAppId(), true);
            int i3 = getAuthRequestContext + 97;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 93 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void b(int i, int[] iArr, Object[] objArr) {
        int length;
        int[] iArr2;
        int i2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = BuiltInFictitiousFunctionClassFactory;
        if (iArr3 != null) {
            int i4 = $11 + 67;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int i6 = 0;
            while (true) {
                if ((i6 < length2 ? '+' : 'O') == 'O') {
                    break;
                }
                try {
                    int i7 = $11 + 5;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                    iArr4[i6] = (int) (iArr3[i6] ^ (-3152031022165484798L));
                    i6++;
                } catch (Exception e) {
                    throw e;
                }
            }
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = BuiltInFictitiousFunctionClassFactory;
        if (!(iArr6 != null)) {
            i3 = length3;
        } else {
            int i9 = $10 + 49;
            $11 = i9 % 128;
            if ((i9 % 2 == 0 ? '#' : 'O') != '#') {
                length = iArr6.length;
                iArr2 = new int[length];
                i2 = 0;
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
                i2 = 1;
            }
            while (i2 < length) {
                iArr2[i2] = (int) (iArr6[i2] ^ (-3152031022165484798L));
                i2++;
                length3 = length3;
            }
            iArr6 = iArr2;
            i3 = length3;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, i3);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            try {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                int i10 = 0;
                while (true) {
                    if ((i10 < 16 ? (char) 2 : '\b') == '\b') {
                        break;
                    }
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i10];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i11;
                    i10++;
                }
                int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
                int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i14 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
