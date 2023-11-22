package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.KeyEvent;
import com.mixpanel.android.BuildConfig;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.RemoteService;
import id.dana.data.here.HereOauthManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.C;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DecideChecker {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int DatabaseTableConfigUtil = 1;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static final JSONArray getAuthRequestContext;
    private static char lookAheadTest;
    private static char moveToNextValue;
    private static char scheduleImpl;
    private final ImageStore BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final MPConfig MyBillsEntityDataFactory;
    private final Map<String, DecideMessages> PlaceComponentResult = new HashMap();
    private final SystemInformation getErrorConfigVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Result {
        public JSONArray MyBillsEntityDataFactory;
        public final List<InAppNotification> BuiltInFictitiousFunctionClassFactory = new ArrayList();
        public final List<InAppNotification> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        public JSONArray getAuthRequestContext = DecideChecker.getAuthRequestContext();
        public JSONArray moveToNextValue = DecideChecker.getAuthRequestContext();
        public boolean PlaceComponentResult = false;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = (char) 40234;
        lookAheadTest = (char) 63147;
        scheduleImpl = (char) 55166;
        moveToNextValue = (char) 36640;
    }

    static /* synthetic */ JSONArray getAuthRequestContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 21;
        DatabaseTableConfigUtil = i % 128;
        if ((i % 2 == 0 ? 'X' : 'C') != 'C') {
            try {
                int i2 = 21 / 0;
                return getAuthRequestContext;
            } catch (Exception e) {
                throw e;
            }
        }
        return getAuthRequestContext;
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        getAuthRequestContext = new JSONArray();
        int i = DatabaseTableConfigUtil + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        int i2 = 32 / 0;
    }

    public DecideChecker(Context context, MPConfig mPConfig) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = mPConfig;
        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2(context);
        this.getErrorConfigVersion = SystemInformation.KClassImpl$Data$declaredNonStaticMembers$2(context);
    }

    private static ImageStore KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        ImageStore imageStore = new ImageStore(context, "DecideChecker");
        int i = DatabaseTableConfigUtil + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        if ((i % 2 != 0 ? (char) 1 : 'E') != 1) {
            return imageStore;
        }
        Object obj = null;
        obj.hashCode();
        return imageStore;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(DecideMessages decideMessages) {
        int i = DatabaseTableConfigUtil + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        int i2 = i % 2;
        this.PlaceComponentResult.put(decideMessages.KClassImpl$Data$declaredNonStaticMembers$2, decideMessages);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
        DatabaseTableConfigUtil = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        int i4 = 26 / 0;
    }

    public final void getAuthRequestContext(String str, RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        DecideMessages decideMessages = this.PlaceComponentResult.get(str);
        if ((decideMessages != null ? (char) 15 : '_') == 15) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 31;
            DatabaseTableConfigUtil = i % 128;
            int i2 = i % 2;
            try {
                Result authRequestContext = getAuthRequestContext(decideMessages.KClassImpl$Data$declaredNonStaticMembers$2, decideMessages.MyBillsEntityDataFactory(), remoteService);
                if (authRequestContext != null) {
                    int i3 = DatabaseTableConfigUtil + 1;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                    int i4 = i3 % 2;
                    decideMessages.BuiltInFictitiousFunctionClassFactory(authRequestContext.BuiltInFictitiousFunctionClassFactory, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.getAuthRequestContext, authRequestContext.moveToNextValue, authRequestContext.PlaceComponentResult, authRequestContext.MyBillsEntityDataFactory);
                    return;
                }
            } catch (UnintelligibleMessageException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DChecker", e.getMessage(), e);
            }
        }
        int i5 = DatabaseTableConfigUtil + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i5 % 128;
        if (!(i5 % 2 == 0)) {
            int i6 = 92 / 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UnintelligibleMessageException extends Exception {
        private static final long serialVersionUID = -6501269367559104957L;

        public UnintelligibleMessageException(String str, JSONException jSONException) {
            super(str, jSONException);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Iterator<InAppNotification> it) throws RemoteService.ServiceUnavailableException {
        InAppNotification next;
        Bitmap BuiltInFictitiousFunctionClassFactory;
        while (true) {
            if (!it.hasNext()) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 105;
                DatabaseTableConfigUtil = i % 128;
                int i2 = i % 2;
                return;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 7;
            DatabaseTableConfigUtil = i3 % 128;
            if (!(i3 % 2 != 0)) {
                next = it.next();
                BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(next, this.KClassImpl$Data$declaredNonStaticMembers$2);
                int i4 = 11 / 0;
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        sb.append("Could not retrieve image for notification ");
                        sb.append(next.PlaceComponentResult());
                        sb.append(", will not show the notification.");
                        MPLog.MyBillsEntityDataFactory("MixpanelAPI.DChecker", sb.toString());
                        it.remove();
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    next.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
                }
            } else {
                next = it.next();
                BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(next, this.KClassImpl$Data$declaredNonStaticMembers$2);
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not retrieve image for notification ");
                    sb2.append(next.PlaceComponentResult());
                    sb2.append(", will not show the notification.");
                    MPLog.MyBillsEntityDataFactory("MixpanelAPI.DChecker", sb2.toString());
                    it.remove();
                } else {
                    next.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
                }
            }
        }
    }

    private Result getAuthRequestContext(String str, String str2, RemoteService remoteService) throws RemoteService.ServiceUnavailableException, UnintelligibleMessageException {
        String PlaceComponentResult = PlaceComponentResult(str, str2, remoteService);
        StringBuilder sb = new StringBuilder();
        sb.append("Mixpanel decide server response was:\n");
        sb.append(PlaceComponentResult);
        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DChecker", sb.toString());
        Object obj = null;
        if (PlaceComponentResult == null) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 111;
            DatabaseTableConfigUtil = i % 128;
            int i2 = i % 2;
            return null;
        }
        int i3 = DatabaseTableConfigUtil + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
        if ((i3 % 2 != 0 ? '8' : 'H') != '8') {
            Result authRequestContext = getAuthRequestContext(PlaceComponentResult);
            KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.BuiltInFictitiousFunctionClassFactory.iterator());
            KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.iterator());
            return authRequestContext;
        }
        try {
            Result authRequestContext2 = getAuthRequestContext(PlaceComponentResult);
            KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext2.BuiltInFictitiousFunctionClassFactory.iterator());
            KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2.iterator());
            obj.hashCode();
            return authRequestContext2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.mixpanel.android.mpmetrics.InAppNotification> PlaceComponentResult(org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.DecideChecker.PlaceComponentResult(org.json.JSONObject):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0063 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.mixpanel.android.mpmetrics.DecideChecker.Result getAuthRequestContext(java.lang.String r8) throws com.mixpanel.android.mpmetrics.DecideChecker.UnintelligibleMessageException {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.DecideChecker.getAuthRequestContext(java.lang.String):com.mixpanel.android.mpmetrics.DecideChecker$Result");
    }

    private String PlaceComponentResult(String str, String str2, RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        try {
            String encode = URLEncoder.encode(str, HereOauthManager.ENC);
            String encode2 = str2 != null ? URLEncoder.encode(str2, HereOauthManager.ENC) : null;
            StringBuilder sb = new StringBuilder();
            sb.append("?version=1&lib=android&token=");
            sb.append(encode);
            if ((encode2 != null ? 'P' : 'a') == 'P') {
                int i = DatabaseTableConfigUtil + 7;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                char c = i % 2 != 0 ? '[' : '\\';
                sb.append("&distinct_id=");
                sb.append(encode2);
                if (c == '[') {
                    int i2 = 93 / 0;
                }
            }
            sb.append("&properties=");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("$android_lib_version", BuildConfig.MIXPANEL_VERSION);
                jSONObject.putOpt("$android_app_version", this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2);
                jSONObject.putOpt("$android_version", Build.VERSION.RELEASE);
                jSONObject.putOpt("$android_app_release", this.getErrorConfigVersion.getAuthRequestContext);
                jSONObject.putOpt("$android_device_model", Build.MODEL);
                sb.append(URLEncoder.encode(jSONObject.toString(), HereOauthManager.ENC));
            } catch (Exception e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DChecker", "Exception constructing properties JSON", e.getCause());
            }
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.MyBillsEntityDataFactory.getAuthRequestContext);
            sb2.append(obj);
            String obj2 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Querying decide server, url: ");
            sb3.append(obj2);
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DChecker", sb3.toString());
            byte[] KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(remoteService, this.KClassImpl$Data$declaredNonStaticMembers$2, obj2);
            if ((KClassImpl$Data$declaredNonStaticMembers$2 == null ? '[' : '\'') == '[') {
                int i3 = DatabaseTableConfigUtil + 53;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
                return null;
            }
            try {
                Object[] objArr = new Object[1];
                a(5 - KeyEvent.keyCodeFromString(""), new char[]{34955, 58373, 10597, 32044, 53501, 14047}, objArr);
                String str3 = new String(KClassImpl$Data$declaredNonStaticMembers$2, ((String) objArr[0]).intern());
                int i5 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 119;
                DatabaseTableConfigUtil = i5 % 128;
                if (i5 % 2 == 0) {
                    int i6 = 74 / 0;
                    return str3;
                }
                return str3;
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UTF not supported on this platform?", e2);
            }
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", e3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        if (r10 >= 720) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        if ((r10 < 21654) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        r0 = new java.lang.String[]{com.mixpanel.android.mpmetrics.InAppNotification.getAuthRequestContext(r9.NetworkUserEntityData$$ExternalSyntheticLambda0, "@4x"), com.mixpanel.android.mpmetrics.InAppNotification.getAuthRequestContext(r9.NetworkUserEntityData$$ExternalSyntheticLambda0, "@2x"), r9.NetworkUserEntityData$$ExternalSyntheticLambda0};
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap BuiltInFictitiousFunctionClassFactory(com.mixpanel.android.mpmetrics.InAppNotification r9, android.content.Context r10) throws com.mixpanel.android.util.RemoteService.ServiceUnavailableException {
        /*
            r8 = this;
            int r0 = com.mixpanel.android.mpmetrics.DecideChecker.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> L9b
            r1 = 3
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.mixpanel.android.mpmetrics.DecideChecker.DatabaseTableConfigUtil = r2     // Catch: java.lang.Exception -> L9b
            r2 = 2
            int r0 = r0 % r2
            java.lang.String[] r0 = new java.lang.String[r2]
            java.lang.String r3 = r9.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.String r4 = "@2x"
            java.lang.String r3 = com.mixpanel.android.mpmetrics.InAppNotification.getAuthRequestContext(r3, r4)
            r5 = 0
            r0[r5] = r3
            java.lang.String r3 = r9.NetworkUserEntityData$$ExternalSyntheticLambda0
            r6 = 1
            r0[r6] = r3
            java.lang.String r3 = "window"
            java.lang.Object r10 = r10.getSystemService(r3)
            android.view.WindowManager r10 = (android.view.WindowManager) r10
            android.view.Display r10 = r10.getDefaultDisplay()
            int r10 = getAuthRequestContext(r10)
            com.mixpanel.android.mpmetrics.InAppNotification$Type r3 = r9.getAuthRequestContext()
            com.mixpanel.android.mpmetrics.InAppNotification$Type r7 = com.mixpanel.android.mpmetrics.InAppNotification.Type.TAKEOVER
            if (r3 != r7) goto L6e
            int r3 = com.mixpanel.android.mpmetrics.DecideChecker.DatabaseTableConfigUtil     // Catch: java.lang.Exception -> L6c
            int r3 = r3 + 99
            int r7 = r3 % 128
            com.mixpanel.android.mpmetrics.DecideChecker.NetworkUserEntityData$$ExternalSyntheticLambda1 = r7     // Catch: java.lang.Exception -> L6c
            int r3 = r3 % r2
            if (r3 == 0) goto L41
            r3 = 1
            goto L42
        L41:
            r3 = 0
        L42:
            if (r3 == r6) goto L49
            r3 = 720(0x2d0, float:1.009E-42)
            if (r10 < r3) goto L6e
            goto L53
        L49:
            r3 = 21654(0x5496, float:3.0344E-41)
            if (r10 < r3) goto L4f
            r10 = 0
            goto L50
        L4f:
            r10 = 1
        L50:
            if (r10 == 0) goto L53
            goto L6e
        L53:
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.String r10 = r9.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.String r1 = "@4x"
            java.lang.String r10 = com.mixpanel.android.mpmetrics.InAppNotification.getAuthRequestContext(r10, r1)
            r0[r5] = r10
            java.lang.String r10 = r9.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.String r10 = com.mixpanel.android.mpmetrics.InAppNotification.getAuthRequestContext(r10, r4)
            r0[r6] = r10
            java.lang.String r9 = r9.NetworkUserEntityData$$ExternalSyntheticLambda0
            r0[r2] = r9
            goto L6e
        L6c:
            r9 = move-exception
            throw r9
        L6e:
            int r9 = r0.length
        L6f:
            if (r5 >= r9) goto L99
            r10 = r0[r5]
            com.mixpanel.android.util.ImageStore r1 = r8.BuiltInFictitiousFunctionClassFactory     // Catch: com.mixpanel.android.util.ImageStore.CantGetImageException -> L7a
            android.graphics.Bitmap r9 = r1.KClassImpl$Data$declaredNonStaticMembers$2(r10)     // Catch: com.mixpanel.android.util.ImageStore.CantGetImageException -> L7a
            return r9
        L7a:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Can't load image "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = " for a notification"
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            java.lang.String r2 = "MixpanelAPI.DChecker"
            com.mixpanel.android.util.MPLog.MyBillsEntityDataFactory(r2, r10, r1)
            int r5 = r5 + 1
            goto L6f
        L99:
            r9 = 0
            return r9
        L9b:
            r9 = move-exception
            goto L9e
        L9d:
            throw r9
        L9e:
            goto L9d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.DecideChecker.BuiltInFictitiousFunctionClassFactory(com.mixpanel.android.mpmetrics.InAppNotification, android.content.Context):android.graphics.Bitmap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 98) != true) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 13 ? '^' : 'K') != '^') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        r0 = new android.graphics.Point();
        r4.getSize(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        return r0.x;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r4 = r4.getWidth();
        r0 = com.mixpanel.android.mpmetrics.DecideChecker.NetworkUserEntityData$$ExternalSyntheticLambda1 + 87;
        com.mixpanel.android.mpmetrics.DecideChecker.DatabaseTableConfigUtil = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int getAuthRequestContext(android.view.Display r4) {
        /*
            int r0 = com.mixpanel.android.mpmetrics.DecideChecker.DatabaseTableConfigUtil
            int r0 = r0 + 55
            int r1 = r0 % 128
            com.mixpanel.android.mpmetrics.DecideChecker.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L1d
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 98
            if (r0 >= r3) goto L1a
            r1 = 1
        L1a:
            if (r1 == r2) goto L37
            goto L2c
        L1d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 13
            r2 = 94
            if (r0 >= r1) goto L28
            r0 = 94
            goto L2a
        L28:
            r0 = 75
        L2a:
            if (r0 == r2) goto L37
        L2c:
            android.graphics.Point r0 = new android.graphics.Point
            r0.<init>()
            r4.getSize(r0)
            int r4 = r0.x
            return r4
        L37:
            int r4 = r4.getWidth()
            int r0 = com.mixpanel.android.mpmetrics.DecideChecker.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.mixpanel.android.mpmetrics.DecideChecker.DatabaseTableConfigUtil = r1
            int r0 = r0 % 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.DecideChecker.getAuthRequestContext(android.view.Display):int");
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(RemoteService remoteService, Context context, String str) throws RemoteService.ServiceUnavailableException {
        try {
            MPConfig authRequestContext = MPConfig.getAuthRequestContext(context);
            byte[] bArr = null;
            if (!remoteService.KClassImpl$Data$declaredNonStaticMembers$2(context, authRequestContext.scheduleImpl())) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 41;
                DatabaseTableConfigUtil = i % 128;
                int i2 = i % 2;
                return null;
            }
            try {
                bArr = remoteService.BuiltInFictitiousFunctionClassFactory(str, null, authRequestContext.initRecordTimeStamp());
                int i3 = DatabaseTableConfigUtil + 99;
                NetworkUserEntityData$$ExternalSyntheticLambda1 = i3 % 128;
                int i4 = i3 % 2;
            } catch (FileNotFoundException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot get ");
                sb.append(str);
                sb.append(", file not found.");
                MPLog.MyBillsEntityDataFactory("MixpanelAPI.DChecker", sb.toString(), e);
            } catch (MalformedURLException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot interpret ");
                sb2.append(str);
                sb2.append(" as a URL.");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DChecker", sb2.toString(), e2);
            } catch (IOException e3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Cannot get ");
                sb3.append(str);
                sb3.append(".");
                MPLog.MyBillsEntityDataFactory("MixpanelAPI.DChecker", sb3.toString(), e3);
            } catch (OutOfMemoryError e4) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Out of memory when getting to ");
                sb4.append(str);
                sb4.append(".");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DChecker", sb4.toString(), e4);
            }
            return bArr;
        } catch (Exception e5) {
            throw e5;
        }
    }

    public final DecideMessages MyBillsEntityDataFactory(String str) {
        DecideMessages decideMessages;
        int i = DatabaseTableConfigUtil + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? (char) 11 : '\b') != '\b') {
            decideMessages = this.PlaceComponentResult.get(str);
            objArr.hashCode();
        } else {
            decideMessages = this.PlaceComponentResult.get(str);
        }
        int i2 = DatabaseTableConfigUtil + 123;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = i2 % 128;
        if (i2 % 2 == 0) {
            return decideMessages;
        }
        int length = objArr.length;
        return decideMessages;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $11 + 9;
        $10 = i2 % 128;
        while (true) {
            int i3 = i2 % 2;
            if (c.BuiltInFictitiousFunctionClassFactory >= cArr.length) {
                break;
            }
            int i4 = $11 + 79;
            $10 = i4 % 128;
            if ((i4 % 2 != 0 ? (char) 2 : 'F') != 'F') {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory / 0];
            } else {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            }
            int i5 = 58224;
            int i6 = $10 + 81;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            int i8 = 0;
            while (true) {
                if (i8 < 16) {
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i5) ^ ((cArr3[0] << 4) + ((char) (moveToNextValue ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (scheduleImpl ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i5) ^ ((cArr3[1] << 4) + ((char) (lookAheadTest ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 6353485791441662354L)))));
                    i5 -= 40503;
                    i8++;
                }
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
            i2 = $10 + 57;
            $11 = i2 % 128;
        }
        String str = new String(cArr2, 0, i);
        int i9 = $10 + 55;
        $11 = i9 % 128;
        if (i9 % 2 != 0) {
            objArr[0] = str;
            return;
        }
        int i10 = 71 / 0;
        objArr[0] = str;
    }
}
