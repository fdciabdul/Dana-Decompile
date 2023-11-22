package com.alibaba.ariver.resource.content;

import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import kotlin.text.Typography;
import o.B;

/* loaded from: classes2.dex */
public class ResourceUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static short[] MyBillsEntityDataFactory = null;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult = 1257195686;
    public static final String TAG = "AriverRes:ResourceUtils";
    private static int getAuthRequestContext = 1870608865;
    private static int scheduleImpl;
    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {-108, 120, 109, 96, -97};
    private static int BuiltInFictitiousFunctionClassFactory = 521117788;

    public static EntryInfo getEntryInfo(AppModel appModel) {
        if (!(appModel == null)) {
            try {
                if (appModel.getAppInfoModel() != null) {
                    EntryInfo entryInfo = new EntryInfo();
                    entryInfo.title = appModel.getAppInfoModel().getName();
                    entryInfo.iconUrl = appModel.getAppInfoModel().getLogo();
                    entryInfo.slogan = appModel.getAppInfoModel().getDesc();
                    entryInfo.isOffline = false;
                    try {
                        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 19;
                        scheduleImpl = i % 128;
                        int i2 = i % 2;
                        return entryInfo;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = scheduleImpl + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:61:0x0057
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String getPkgStatus(com.alibaba.ariver.resource.api.content.ResourcePackage r5) {
        /*
            r0 = 0
            r1 = 1
            if (r5 != 0) goto L6
            r2 = 0
            goto L7
        L6:
            r2 = 1
        L7:
            if (r2 == 0) goto L59
            java.lang.String r2 = r5.appId()
            int r3 = r5.count()
            r4 = 17
            if (r3 <= 0) goto L18
            r3 = 38
            goto L1a
        L18:
            r3 = 17
        L1a:
            if (r3 == r4) goto L36
            int r3 = com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl
            int r3 = r3 + 63
            int r4 = r3 % 128
            com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L2a
            r3 = 0
            goto L2b
        L2a:
            r3 = 1
        L2b:
            if (r3 == r1) goto L33
            r1 = 98
            int r1 = r1 / r0
            goto L33
        L31:
            r5 = move-exception
            throw r5
        L33:
            java.lang.String r0 = "Y"
            goto L38
        L36:
            java.lang.String r0 = "N"
        L38:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = "_"
            r1.append(r2)
            r1.append(r0)
            r1.append(r2)
            java.lang.String r5 = r5.version()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        L57:
            r5 = move-exception
            throw r5
        L59:
            java.lang.String r5 = ""
            int r0 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r1
            int r0 = r0 % 2
            return r5
        L66:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.content.ResourceUtils.getPkgStatus(com.alibaba.ariver.resource.api.content.ResourcePackage):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0076, code lost:
    
        downloadAndInstallApp(r9, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0079, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x007a, code lost:
    
        r8 = new com.alibaba.ariver.resource.api.appinfo.UpdateAppParam(r7, "*");
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x007f, code lost:
    
        if (r10 != null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0081, code lost:
    
        r10 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 + 107;
        com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r10 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x008b, code lost:
    
        if ((r10 % 2) == 0) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x008d, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x008f, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0090, code lost:
    
        if (r10 == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0092, code lost:
    
        r8.setForce(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0096, code lost:
    
        r8.setForce(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0099, code lost:
    
        r8.setUpdateMode(com.alibaba.ariver.resource.api.prepare.UpdateMode.SYNC_FORCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x009f, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00a4, code lost:
    
        if (r10.isSync() == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00a6, code lost:
    
        r0 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 + 109;
        com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
        r8.setForce(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00b3, code lost:
    
        r8.setUpdateMode(r10);
        r10 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 + 101;
        com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r10 % 128;
        r10 = r10 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00c0, code lost:
    
        r10 = com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory.createUpdater(r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00c4, code lost:
    
        if (r10 != null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x00c6, code lost:
    
        r8 = new java.lang.StringBuilder();
        r8.append("cannot find app updater for ");
        r8.append(r7);
        r8.append("!!!");
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.ariver.resource.content.ResourceUtils.TAG, r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00e3, code lost:
    
        if (r9 == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00e5, code lost:
    
        r8 = 23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00e8, code lost:
    
        r8 = 'L';
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00ea, code lost:
    
        if (r8 == 'L') goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00ec, code lost:
    
        r9.onResult(false, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00ef, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00f0, code lost:
    
        r10.updateApp(r8, new com.alibaba.ariver.resource.content.ResourceUtils.AnonymousClass1());
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00f8, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x001c, code lost:
    
        if (r3 == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0036, code lost:
    
        if ((!"*".equals(r8) ? '6' : 'I') != 'I') goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0038, code lost:
    
        r0 = r0.getAppModel(com.alibaba.ariver.resource.api.models.AppInfoQuery.make(r7).version(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0045, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0047, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x004a, code lost:
    
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x004c, code lost:
    
        r5 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 + 109;
        com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x005a, code lost:
    
        if ("*".equals(r8) != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x005c, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x005e, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x005f, code lost:
    
        if (r8 == true) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0061, code lost:
    
        r7 = com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl + 49;
        com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x006b, code lost:
    
        if ((r7 % 2) != 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x006d, code lost:
    
        downloadAndInstallApp(r9, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0070, code lost:
    
        r2.hashCode();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void prepare(final java.lang.String r7, java.lang.String r8, final com.alibaba.ariver.resource.api.PackageInstallCallback r9, com.alibaba.ariver.resource.api.prepare.UpdateMode r10) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.content.ResourceUtils.prepare(java.lang.String, java.lang.String, com.alibaba.ariver.resource.api.PackageInstallCallback, com.alibaba.ariver.resource.api.prepare.UpdateMode):void");
    }

    public static void prepare(String str, String str2, PackageInstallCallback packageInstallCallback) {
        try {
            int i = scheduleImpl + 49;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                prepare(str, str2, packageInstallCallback, null);
                int i3 = scheduleImpl + 7;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 30 : '8') != 30) {
                    return;
                }
                int i4 = 82 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0023, code lost:
    
        if (r1 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0038, code lost:
    
        if (r0.isDownloaded(r4) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003a, code lost:
    
        r0.downloadApp(r4, true, new com.alibaba.ariver.resource.api.DownloadInstallCallback(r4, true, true, r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0045, code lost:
    
        r3 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 + 21;
        com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x004f, code lost:
    
        com.alibaba.ariver.kernel.common.utils.ExecutorUtils.execute(com.alibaba.ariver.kernel.common.service.executor.ExecutorType.NORMAL, new com.alibaba.ariver.resource.content.ResourceUtils.AnonymousClass2());
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0059, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void downloadAndInstallApp(final com.alibaba.ariver.resource.api.PackageInstallCallback r3, final com.alibaba.ariver.resource.api.models.AppModel r4) {
        /*
            int r0 = com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl
            int r0 = r0 + 23
            int r1 = r0 % 128
            com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            r1 = 10
            if (r0 != 0) goto L11
            r0 = 54
            goto L13
        L11:
            r0 = 10
        L13:
            if (r0 == r1) goto L2c
            java.lang.Class<com.alibaba.ariver.resource.api.proxy.RVResourceManager> r0 = com.alibaba.ariver.resource.api.proxy.RVResourceManager.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)     // Catch: java.lang.Exception -> L28
            com.alibaba.ariver.resource.api.proxy.RVResourceManager r0 = (com.alibaba.ariver.resource.api.proxy.RVResourceManager) r0     // Catch: java.lang.Exception -> L2a
            boolean r1 = r0.isDownloaded(r4)     // Catch: java.lang.Exception -> L28
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L4f
            goto L3a
        L26:
            r3 = move-exception
            throw r3
        L28:
            r3 = move-exception
            throw r3
        L2a:
            r3 = move-exception
            goto L4e
        L2c:
            java.lang.Class<com.alibaba.ariver.resource.api.proxy.RVResourceManager> r0 = com.alibaba.ariver.resource.api.proxy.RVResourceManager.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.resource.api.proxy.RVResourceManager r0 = (com.alibaba.ariver.resource.api.proxy.RVResourceManager) r0
            boolean r1 = r0.isDownloaded(r4)
            if (r1 != 0) goto L4f
        L3a:
            com.alibaba.ariver.resource.api.DownloadInstallCallback r1 = new com.alibaba.ariver.resource.api.DownloadInstallCallback
            r2 = 1
            r1.<init>(r4, r2, r2, r3)
            r0.downloadApp(r4, r2, r1)
            int r3 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L2a
            int r3 = r3 + 21
            int r4 = r3 % 128
            com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r4
            int r3 = r3 % 2
            return
        L4e:
            throw r3
        L4f:
            com.alibaba.ariver.kernel.common.service.executor.ExecutorType r1 = com.alibaba.ariver.kernel.common.service.executor.ExecutorType.NORMAL
            com.alibaba.ariver.resource.content.ResourceUtils$2 r2 = new com.alibaba.ariver.resource.content.ResourceUtils$2
            r2.<init>()
            com.alibaba.ariver.kernel.common.utils.ExecutorUtils.execute(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.content.ResourceUtils.downloadAndInstallApp(com.alibaba.ariver.resource.api.PackageInstallCallback, com.alibaba.ariver.resource.api.models.AppModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0032, code lost:
    
        if (r1 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0048, code lost:
    
        if ((r0.containsKey(r4.getAppId()) ? '5' : 'Y') != 'Y') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004a, code lost:
    
        r0 = r0.getString(r4.getAppId());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0057, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0059, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x005b, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x005c, code lost:
    
        if (r1 == true) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0067, code lost:
    
        if (com.alibaba.ariver.resource.api.RVResourceUtils.compareVersion(r0, r4.getVersion()) <= 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0069, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("nbPluginVersion update from config: ");
        r1.append(r0);
        r1.append(", dev version = ");
        r1.append(r4.getVersion());
        com.alibaba.ariver.kernel.common.utils.RVLogger.d(com.alibaba.ariver.resource.content.ResourceUtils.TAG, r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x008b, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x008c, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x008d, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean needForceUpdate(com.alibaba.ariver.resource.api.models.PluginModel r4) {
        /*
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVConfigService> r0 = com.alibaba.ariver.kernel.common.service.RVConfigService.class
            java.lang.Object r0 = com.alibaba.ariver.kernel.common.RVProxy.get(r0)
            com.alibaba.ariver.kernel.common.service.RVConfigService r0 = (com.alibaba.ariver.kernel.common.service.RVConfigService) r0
            java.lang.String r1 = "h5_nbPluginVersionCfg"
            com.alibaba.fastjson.JSONObject r0 = r0.getConfigJSONObject(r1)
            r1 = 35
            if (r0 == 0) goto L15
            r2 = 61
            goto L17
        L15:
            r2 = 35
        L17:
            r3 = 0
            if (r2 == r1) goto L8e
            int r1 = com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl
            int r1 = r1 + 93
            int r2 = r1 % 128
            com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L37
            java.lang.String r1 = r4.getAppId()
            boolean r1 = r0.containsKey(r1)
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L35
            if (r1 == 0) goto L8e
            goto L4a
        L35:
            r4 = move-exception
            throw r4
        L37:
            java.lang.String r1 = r4.getAppId()
            boolean r1 = r0.containsKey(r1)
            r2 = 89
            if (r1 == 0) goto L46
            r1 = 53
            goto L48
        L46:
            r1 = 89
        L48:
            if (r1 == r2) goto L8e
        L4a:
            java.lang.String r1 = r4.getAppId()
            java.lang.String r0 = r0.getString(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r1 != 0) goto L5b
            r1 = 1
            goto L5c
        L5b:
            r1 = 0
        L5c:
            if (r1 == r2) goto L5f
            goto L8e
        L5f:
            java.lang.String r1 = r4.getVersion()     // Catch: java.lang.Exception -> L8c
            int r1 = com.alibaba.ariver.resource.api.RVResourceUtils.compareVersion(r0, r1)     // Catch: java.lang.Exception -> L99
            if (r1 <= 0) goto L8e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "nbPluginVersion update from config: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = ", dev version = "
            r1.append(r0)
            java.lang.String r4 = r4.getVersion()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            java.lang.String r0 = "AriverRes:ResourceUtils"
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r4)
            return r2
        L8c:
            r4 = move-exception
            throw r4
        L8e:
            int r4 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L99
            int r4 = r4 + 21
            int r0 = r4 % 128
            com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r0     // Catch: java.lang.Exception -> L99
            int r4 = r4 % 2
            return r3
        L99:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.content.ResourceUtils.needForceUpdate(com.alibaba.ariver.resource.api.models.PluginModel):boolean");
    }

    public static boolean movePluginRefreshTimeToSp() {
        int i = scheduleImpl + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        boolean equalsIgnoreCase = "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_movePluginRefreshTimeToSp", "yes"));
        int i3 = scheduleImpl + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return equalsIgnoreCase;
    }

    public static boolean enableTabBarByAppId(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            JSONArray parseArray = JSONUtils.parseArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_enableTabBar", ""));
            if ((parseArray != null ? 'R' : 'P') == 'R') {
                if (!(parseArray.isEmpty())) {
                    boolean contains = parseArray.contains(str);
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
                    scheduleImpl = i3 % 128;
                    if (!(i3 % 2 == 0)) {
                        Object[] objArr = null;
                        int length = objArr.length;
                        return contains;
                    }
                    return contains;
                }
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x007a, code lost:
    
        if (com.alibaba.ariver.resource.content.AppxNgResourcePackage.APPX_NG_RENDER_JS_URL.equals(r20.pureUrl) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x007c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x007e, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x007f, code lost:
    
        if (r6 == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0089, code lost:
    
        if (com.alibaba.ariver.resource.content.AppxNgResourcePackage.APPX_NG_WORKER_JS_URL.equals(r20.pureUrl) == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x008b, code lost:
    
        r6 = r3.getHeaders();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0095, code lost:
    
        if (com.alibaba.ariver.kernel.common.utils.CollectionUtils.isEmpty(r6) != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0097, code lost:
    
        r9 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 + 21;
        com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00a0, code lost:
    
        if ((r9 % 2) == 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00a2, code lost:
    
        r6 = r6.containsKey("appxVersion");
        r9 = r7.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00a7, code lost:
    
        if (r6 != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00ae, code lost:
    
        if (r6.containsKey("appxVersion") != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00b0, code lost:
    
        r9 = r3.getBytes();
        r5 = new java.lang.Object[1];
        a((-1440803011) - (android.os.Process.myPid() >> 22), (-52) - android.text.TextUtils.getCapsMode("", 0, 0), (short) (android.view.ViewConfiguration.getScrollBarSize() >> 8), (android.view.ViewConfiguration.getTapTimeout() >> 16) - 630223145, (byte) ((-1) - android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0, 0)), r5);
        r0 = new java.lang.String(r9, 0, 100, ((java.lang.String) r5[0]).intern()).split("\\r?\\n")[2].substring(3);
        r3.addHeader("appxVersion", r0);
        r5 = new java.lang.StringBuilder();
        r5.append("detect  appx   version is: ");
        r5.append(r0);
        r5.append("\t ");
        r5.append(r20.pureUrl);
        com.alibaba.ariver.kernel.common.utils.RVLogger.d(com.alibaba.ariver.resource.content.ResourceUtils.TAG, r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0128, code lost:
    
        r0 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
        com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0132, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0133, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append("detect appx  appx version exception: ");
        r5.append(r20.pureUrl);
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.ariver.resource.content.ResourceUtils.TAG, r5.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0026, code lost:
    
        if (r6 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x003a, code lost:
    
        if (com.alibaba.ariver.resource.content.AppxResourcePackage.APPX_RENDER_JS_URL.equals(r20.pureUrl) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0044, code lost:
    
        if ("https://appx/af-appx.worker.min.js".equals(r20.pureUrl) != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0046, code lost:
    
        r6 = com.alibaba.ariver.resource.content.ResourceUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 + 39;
        com.alibaba.ariver.resource.content.ResourceUtils.scheduleImpl = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0051, code lost:
    
        if ((r6 % 2) == 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0053, code lost:
    
        r6 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0056, code lost:
    
        r6 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x005a, code lost:
    
        if (r6 == '?') goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0064, code lost:
    
        r9 = 95 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0067, code lost:
    
        if (com.alibaba.ariver.resource.content.AppxNgResourcePackage.APPX_NG_RENDER_JS_URL.equals(r20.pureUrl) != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0069, code lost:
    
        r6 = ']';
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x006c, code lost:
    
        r6 = '3';
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x006e, code lost:
    
        if (r6 == '3') goto L132;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.ariver.engine.api.resources.Resource getResourceFromGlobalPackagePool(com.alibaba.ariver.resource.api.content.ResourceQuery r20) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.content.ResourceUtils.getResourceFromGlobalPackagePool(com.alibaba.ariver.resource.api.content.ResourceQuery):com.alibaba.ariver.engine.api.resources.Resource");
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        int i4;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i5 = i2 + ((int) (PlaceComponentResult ^ 3097486228508854431L));
        if (i5 == -1) {
            int i6 = $11 + 33;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            z = true;
        } else {
            z = false;
        }
        if (z) {
            try {
                byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    int i8 = 0;
                    while (true) {
                        if ((i8 < length ? '\r' : Typography.dollar) == '$') {
                            break;
                        }
                        int i9 = $10 + 47;
                        $11 = i9 % 128;
                        int i10 = i9 % 2;
                        bArr2[i8] = (byte) (bArr[i8] ^ 3097486228508854431L);
                        i8++;
                    }
                    bArr = bArr2;
                }
                i5 = bArr != null ? (byte) (((byte) (KClassImpl$Data$declaredNonStaticMembers$2[i + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L))) : (short) (((short) (MyBillsEntityDataFactory[i + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            } catch (Exception e) {
                throw e;
            }
        }
        if (i5 > 0) {
            int i11 = ((i + i5) - 2) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
            if (z) {
                int i12 = $10 + 87;
                $11 = i12 % 128;
                int i13 = i12 % 2;
                i4 = 1;
            } else {
                i4 = 0;
            }
            b2.getAuthRequestContext = i11 + i4;
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = $10 + 77;
                    $11 = i15 % 128;
                    if (i15 % 2 == 0) {
                        bArr4[i14] = (byte) (bArr3[i14] ^ 3097486228508854431L);
                        i14 /= 1;
                    } else {
                        bArr4[i14] = (byte) (bArr3[i14] ^ 3097486228508854431L);
                        i14++;
                    }
                }
                bArr3 = bArr4;
            }
            boolean z2 = bArr3 != null;
            try {
                b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i5) {
                    if (z2) {
                        int i16 = $10 + 11;
                        $11 = i16 % 128;
                        int i17 = i16 % 2;
                        byte[] bArr5 = KClassImpl$Data$declaredNonStaticMembers$2;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    } else {
                        short[] sArr = MyBillsEntityDataFactory;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    }
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        objArr[0] = sb.toString();
    }
}
