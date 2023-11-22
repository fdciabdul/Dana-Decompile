package com.google.firebase.crashlytics.internal.metadata;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import o.whenAvailable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MetaDataStore {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static final String KEY_USER_ID = "userId";
    private static long PlaceComponentResult = 0;
    private static final Charset UTF_8;
    private static int getAuthRequestContext = 1;
    private final FileStore fileStore;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        BuiltInFictitiousFunctionClassFactory = new char[]{53890, 57882, 45987, 17201, 4235};
        PlaceComponentResult = -5085253326542289961L;
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a(1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 5 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (8601 - Drawable.resolveOpacity(0, 0)), objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        try {
            int i = getAuthRequestContext + 21;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? 'U' : 'O') != 'U') {
                return;
            }
            Object[] objArr2 = null;
            int length = objArr2.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public MetaDataStore(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    public void writeUserData(String str, String str2) {
        BufferedWriter bufferedWriter;
        File userDataFileForSession = getUserDataFileForSession(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                String userIdToJson = userIdToJson(str2);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userDataFileForSession), UTF_8));
                try {
                    bufferedWriter.write(userIdToJson);
                    bufferedWriter.flush();
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                } catch (Exception e) {
                    e = e;
                    bufferedWriter2 = bufferedWriter;
                    Logger.getLogger().w("Error serializing user metadata.", e);
                    try {
                        CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
                        getAuthRequestContext = i3 % 128;
                        if (!(i3 % 2 != 0)) {
                            int i4 = 57 / 0;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r1.length() != 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r1.length() != 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r2 = new java.io.FileInputStream(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r4 = jsonToUserId(com.google.firebase.crashlytics.internal.common.CommonUtils.streamToString(r2));
        r6 = com.google.firebase.crashlytics.internal.Logger.getLogger();
        r7 = new java.lang.StringBuilder();
        r7.append("Loaded userId ");
        r7.append(r4);
        r7.append(" for session ");
        r7.append(r11);
        r6.d(r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r2, "Failed to close user metadata file.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        r11 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        com.google.firebase.crashlytics.internal.Logger.getLogger().w("Error deserializing user metadata.", r11);
        safeDeleteCorruptFile(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r2, "Failed to close user metadata file.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
    
        r11 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext + 11;
        com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2 = r11 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if ((r11 % 2) != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
    
        r11 = 31 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0090, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
    
        com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r5, "Failed to close user metadata file.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
    
        throw r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String readUserId(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "Failed to close user metadata file."
            java.io.File r1 = r10.getUserDataFileForSession(r11)
            boolean r2 = r1.exists()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L10
            r2 = 0
            goto L11
        L10:
            r2 = 1
        L11:
            r5 = 0
            if (r2 == r4) goto L96
            int r2 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext
            int r2 = r2 + 99
            int r6 = r2 % 128
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r2 = r2 % 2
            r6 = 0
            if (r2 == 0) goto L2d
            long r8 = r1.length()     // Catch: java.lang.Exception -> L2b
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L96
            goto L35
        L2b:
            r11 = move-exception
            goto L91
        L2d:
            long r8 = r1.length()
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L96
        L35:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6d
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6d
            java.lang.String r4 = com.google.firebase.crashlytics.internal.common.CommonUtils.streamToString(r2)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.lang.String r4 = r10.jsonToUserId(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r7.<init>()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.lang.String r8 = "Loaded userId "
            r7.append(r8)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r7.append(r4)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.lang.String r8 = " for session "
            r7.append(r8)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r7.append(r11)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.lang.String r11 = r7.toString()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r6.d(r11)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r2, r0)
            return r4
        L66:
            r11 = move-exception
            r5 = r2
            goto L92
        L69:
            r11 = move-exception
            goto L6f
        L6b:
            r11 = move-exception
            goto L92
        L6d:
            r11 = move-exception
            r2 = r5
        L6f:
            com.google.firebase.crashlytics.internal.Logger r4 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = "Error deserializing user metadata."
            r4.w(r6, r11)     // Catch: java.lang.Throwable -> L66
            safeDeleteCorruptFile(r1)     // Catch: java.lang.Throwable -> L66
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r2, r0)     // Catch: java.lang.Exception -> L2b
            int r11 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext
            int r11 = r11 + 11
            int r0 = r11 % 128
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r11 = r11 % 2
            if (r11 == 0) goto L90
            r11 = 31
            int r11 = r11 / r3
            return r5
        L8e:
            r11 = move-exception
            throw r11
        L90:
            return r5
        L91:
            throw r11
        L92:
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r5, r0)
            throw r11
        L96:
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Exception -> Lc6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc6
            r2.<init>()     // Catch: java.lang.Exception -> Lc6
            java.lang.String r6 = "No userId set for session "
            r2.append(r6)     // Catch: java.lang.Exception -> Lc6
            r2.append(r11)     // Catch: java.lang.Exception -> Lc6
            java.lang.String r11 = r2.toString()     // Catch: java.lang.Exception -> Lc6
            r0.d(r11)     // Catch: java.lang.Exception -> Lc6
            safeDeleteCorruptFile(r1)     // Catch: java.lang.Exception -> Lc6
            int r11 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext
            int r11 = r11 + 45
            int r0 = r11 % 128
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r11 = r11 % 2
            if (r11 == 0) goto Lbe
            goto Lbf
        Lbe:
            r3 = 1
        Lbf:
            if (r3 == r4) goto Lc5
            int r11 = r5.length     // Catch: java.lang.Throwable -> Lc3
            return r5
        Lc3:
            r11 = move-exception
            throw r11
        Lc5:
            return r5
        Lc6:
            r11 = move-exception
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.readUserId(java.lang.String):java.lang.String");
    }

    public void writeKeyData(String str, Map<String, String> map) {
        int i = getAuthRequestContext + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        writeKeyData(str, map, false);
        int i3 = getAuthRequestContext + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if ((!r8) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        if (r8 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r8 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext = r8 % 128;
        r8 = r8 % 2;
        r6 = getInternalKeysFileForSession(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        r6 = getKeysFileForSession(r6);
        r8 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext + 113;
        com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2 = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeKeyData(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r0 = "Failed to close key/value metadata file."
            int r1 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 119
            int r2 = r1 % 128
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext = r2
            int r1 = r1 % 2
            r2 = 12
            if (r1 != 0) goto L13
            r1 = 12
            goto L15
        L13:
            r1 = 58
        L15:
            r3 = 0
            if (r1 == r2) goto L20
            if (r8 == 0) goto L1c
            r8 = 0
            goto L1d
        L1c:
            r8 = 1
        L1d:
            if (r8 == 0) goto L23
            goto L32
        L20:
            int r1 = r3.length     // Catch: java.lang.Throwable -> L7e
            if (r8 == 0) goto L32
        L23:
            int r8 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 31
            int r1 = r8 % 128
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext = r1
            int r8 = r8 % 2
            java.io.File r6 = r5.getInternalKeysFileForSession(r6)
            goto L40
        L32:
            java.io.File r6 = r5.getKeysFileForSession(r6)
            int r8 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext
            int r8 = r8 + 113
            int r1 = r8 % 128
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r8 = r8 % 2
        L40:
            java.lang.String r7 = keysDataToJson(r7)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.io.BufferedWriter r8 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.nio.charset.Charset r4 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.UTF_8     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r1.<init>(r2, r4)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r8.write(r7)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r8.flush()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r8, r0)     // Catch: java.lang.Exception -> L5f
            return
        L5f:
            r6 = move-exception
            throw r6
        L61:
            r6 = move-exception
            goto L7a
        L63:
            r7 = move-exception
            r3 = r8
            goto L69
        L66:
            r6 = move-exception
            goto L79
        L68:
            r7 = move-exception
        L69:
            com.google.firebase.crashlytics.internal.Logger r8 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = "Error serializing key/value metadata."
            r8.w(r1, r7)     // Catch: java.lang.Throwable -> L66
            safeDeleteCorruptFile(r6)     // Catch: java.lang.Throwable -> L66
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r3, r0)
            return
        L79:
            r8 = r3
        L7a:
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r8, r0)
            throw r6
        L7e:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.writeKeyData(java.lang.String, java.util.Map, boolean):void");
    }

    public Map<String, String> readKeyData(String str) {
        int i = getAuthRequestContext + 31;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Map<String, String> readKeyData = !(i % 2 == 0) ? readKeyData(str, true) : readKeyData(str, false);
        int i2 = getAuthRequestContext + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        return readKeyData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if ((r9) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        if (r9 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
    
        r9 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        if ((r9 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r2 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r8 = getInternalKeysFileForSession(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        r8 = getInternalKeysFileForSession(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r9 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0043, code lost:
    
        r8 = getKeysFileForSession(r8);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> readKeyData(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to close user metadata file."
            int r1 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 17
            int r2 = r1 % 128
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext = r2
            int r1 = r1 % 2
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L12
            r1 = 1
            goto L13
        L12:
            r1 = 0
        L13:
            r4 = 0
            if (r1 == 0) goto L23
            r1 = 26
            int r1 = r1 / r3
            if (r9 == 0) goto L1d
            r9 = 1
            goto L1e
        L1d:
            r9 = 0
        L1e:
            if (r9 == 0) goto L43
            goto L25
        L21:
            r8 = move-exception
            throw r8
        L23:
            if (r9 == 0) goto L43
        L25:
            int r9 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 + 87
            int r1 = r9 % 128
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.getAuthRequestContext = r1
            int r9 = r9 % 2
            if (r9 != 0) goto L32
            r2 = 0
        L32:
            if (r2 == 0) goto L3b
            java.io.File r8 = r7.getInternalKeysFileForSession(r8)     // Catch: java.lang.Exception -> L39
            goto L47
        L39:
            r8 = move-exception
            throw r8
        L3b:
            java.io.File r8 = r7.getInternalKeysFileForSession(r8)
            int r9 = r4.length     // Catch: java.lang.Throwable -> L41
            goto L47
        L41:
            r8 = move-exception
            throw r8
        L43:
            java.io.File r8 = r7.getKeysFileForSession(r8)
        L47:
            boolean r9 = r8.exists()
            if (r9 == 0) goto L8c
            long r1 = r8.length()
            r5 = 0
            int r9 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r9 == 0) goto L8c
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            java.lang.String r1 = com.google.firebase.crashlytics.internal.common.CommonUtils.streamToString(r9)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            java.util.Map r8 = jsonToKeysData(r1)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r9, r0)
            return r8
        L68:
            r8 = move-exception
            r4 = r9
            goto L88
        L6b:
            r1 = move-exception
            r4 = r9
            goto L72
        L6e:
            r8 = move-exception
            goto L88
        L70:
            r9 = move-exception
            r1 = r9
        L72:
            com.google.firebase.crashlytics.internal.Logger r9 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = "Error deserializing user metadata."
            r9.w(r2, r1)     // Catch: java.lang.Throwable -> L6e
            safeDeleteCorruptFile(r8)     // Catch: java.lang.Throwable -> L6e
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r4, r0)     // Catch: java.lang.Exception -> L86
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: java.lang.Exception -> L86
            return r8
        L86:
            r8 = move-exception
            throw r8
        L88:
            com.google.firebase.crashlytics.internal.common.CommonUtils.closeOrLog(r4, r0)
            throw r8
        L8c:
            safeDeleteCorruptFile(r8)
            java.util.Map r8 = java.util.Collections.emptyMap()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.readKeyData(java.lang.String, boolean):java.util.Map");
    }

    public File getUserDataFileForSession(String str) {
        int i = getAuthRequestContext + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        File sessionFile = this.fileStore.getSessionFile(str, UserMetadata.USERDATA_FILENAME);
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 19 : (char) 1) != 1) {
                int i4 = 32 / 0;
                return sessionFile;
            }
            return sessionFile;
        } catch (Exception e) {
            throw e;
        }
    }

    public File getKeysFileForSession(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            try {
                File sessionFile = this.fileStore.getSessionFile(str, UserMetadata.KEYDATA_FILENAME);
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 20 : 'c') != 'c') {
                    int i4 = 90 / 0;
                    return sessionFile;
                }
                return sessionFile;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public File getInternalKeysFileForSession(String str) {
        File sessionFile;
        int i = getAuthRequestContext + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? ']' : (char) 11) != 11) {
            sessionFile = this.fileStore.getSessionFile(str, UserMetadata.INTERNAL_KEYDATA_FILENAME);
            int i2 = 47 / 0;
        } else {
            sessionFile = this.fileStore.getSessionFile(str, UserMetadata.INTERNAL_KEYDATA_FILENAME);
        }
        int i3 = getAuthRequestContext + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            return sessionFile;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return sessionFile;
    }

    private String jsonToUserId(String str) throws JSONException {
        String valueOrNull = valueOrNull(new JSONObject(str), "userId");
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            getAuthRequestContext = i % 128;
            if ((i % 2 == 0 ? '\'' : (char) 19) != 19) {
                Object obj = null;
                obj.hashCode();
                return valueOrNull;
            }
            return valueOrNull;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.crashlytics.internal.metadata.MetaDataStore$1] */
    private static String userIdToJson(String str) throws JSONException {
        try {
            String anonymousClass1 = new JSONObject(str) { // from class: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.1
                final /* synthetic */ String val$userId;

                {
                    this.val$userId = str;
                    put("userId", str);
                }
            }.toString();
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return anonymousClass1;
        } catch (Exception e) {
            throw e;
        }
    }

    private static Map<String, String> jsonToKeysData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        int i = getAuthRequestContext + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        while (true) {
            int i2 = i % 2;
            if (!keys.hasNext()) {
                return hashMap;
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            try {
                String next = keys.next();
                hashMap.put(next, valueOrNull(jSONObject, next));
                i = getAuthRequestContext + 35;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static String keysDataToJson(Map<String, String> map) {
        String jSONObject = new JSONObject(map).toString();
        try {
            int i = getAuthRequestContext + 19;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (!(i % 2 != 0)) {
                    return jSONObject;
                }
                Object obj = null;
                obj.hashCode();
                return jSONObject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String valueOrNull(JSONObject jSONObject, String str) {
        int i = getAuthRequestContext + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        String str2 = null;
        if ((!jSONObject.isNull(str) ? (char) 15 : (char) 1) == 15) {
            try {
                str2 = jSONObject.optString(str, null);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return str2;
    }

    private static void safeDeleteCorruptFile(File file) {
        try {
            int i = getAuthRequestContext + 5;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            if ((file.exists() ? (char) 6 : JSONLexer.EOI) != 26) {
                int i3 = getAuthRequestContext + 25;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                if (file.delete()) {
                    Logger logger = Logger.getLogger();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Deleted corrupt file: ");
                    sb.append(file.getAbsolutePath());
                    logger.i(sb.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        try {
            int i3 = $10 + 67;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            while (true) {
                if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                    break;
                }
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (BuiltInFictitiousFunctionClassFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ PlaceComponentResult))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            }
            char[] cArr = new char[i2];
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
                try {
                    int i5 = $10 + 33;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            objArr[0] = new String(cArr);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
