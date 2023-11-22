package com.google.firebase.remoteconfig.internal;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import id.dana.cashier.view.InputCardNumberView;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import o.whenAvailable;
import org.json.JSONException;

/* loaded from: classes.dex */
public class ConfigGetParameterHandler {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    static final Pattern FALSE_REGEX;
    public static final Charset FRC_BYTE_ARRAY_ENCODING;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static int PlaceComponentResult;
    static final Pattern TRUE_REGEX;
    private static long getAuthRequestContext;
    private final ConfigCacheClient activatedConfigsCache;
    private final ConfigCacheClient defaultConfigsCache;
    private final Executor executor;
    private final Set<BiConsumer<String, ConfigContainer>> listeners;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{24681, 60175, 30388, 49700, 19864};
        getAuthRequestContext = 7399885711737976873L;
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1, 5 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0') + 37747), objArr);
        FRC_BYTE_ARRAY_ENCODING = Charset.forName(((String) objArr[0]).intern());
        TRUE_REGEX = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        FALSE_REGEX = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
        int i = BuiltInFictitiousFunctionClassFactory + 89;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    public ConfigGetParameterHandler(Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        try {
            this.listeners = new HashSet();
            this.executor = executor;
            this.activatedConfigsCache = configCacheClient;
            this.defaultConfigsCache = configCacheClient2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getString(String str) {
        String stringFromCache = getStringFromCache(this.activatedConfigsCache, str);
        if (stringFromCache != null) {
            int i = BuiltInFictitiousFunctionClassFactory + 69;
            PlaceComponentResult = i % 128;
            if (!(i % 2 != 0)) {
                callListeners(str, getConfigsFromCache(this.activatedConfigsCache));
                return stringFromCache;
            }
            callListeners(str, getConfigsFromCache(this.activatedConfigsCache));
            Object[] objArr = null;
            int length = objArr.length;
            return stringFromCache;
        }
        try {
            String stringFromCache2 = getStringFromCache(this.defaultConfigsCache, str);
            if ((stringFromCache2 != null ? (char) 2 : InputCardNumberView.DIVIDER) == ' ') {
                logParameterValueDoesNotExist(str, "String");
                return "";
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 71;
            PlaceComponentResult = i2 % 128;
            if (!(i2 % 2 == 0)) {
                int i3 = 6 / 0;
                return stringFromCache2;
            }
            return stringFromCache2;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean getBoolean(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 21;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        String stringFromCache = getStringFromCache(this.activatedConfigsCache, str);
        if (stringFromCache != null) {
            if (TRUE_REGEX.matcher(stringFromCache).matches()) {
                callListeners(str, getConfigsFromCache(this.activatedConfigsCache));
                return true;
            }
            try {
                if (FALSE_REGEX.matcher(stringFromCache).matches()) {
                    int i3 = PlaceComponentResult + 87;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                    callListeners(str, getConfigsFromCache(this.activatedConfigsCache));
                    return false;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        String stringFromCache2 = getStringFromCache(this.defaultConfigsCache, str);
        if ((stringFromCache2 != null ? 'W' : (char) 19) == 'W') {
            if (TRUE_REGEX.matcher(stringFromCache2).matches()) {
                return true;
            }
            if (FALSE_REGEX.matcher(stringFromCache2).matches()) {
                try {
                    int i5 = PlaceComponentResult + 83;
                    BuiltInFictitiousFunctionClassFactory = i5 % 128;
                    int i6 = i5 % 2;
                    return false;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        logParameterValueDoesNotExist(str, "Boolean");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if ((r0 != null) != true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if ((r0 != null) != true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r0 = getStringFromCache(r5.defaultConfigsCache, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r6 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult + 113;
        com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if ((r6 % 2) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        r1 = 2 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        return r0.getBytes(com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        logParameterValueDoesNotExist(r6, "ByteArray");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        return com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        callListeners(r6, getConfigsFromCache(r5.activatedConfigsCache));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        return r0.getBytes(com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return r0.getBytes(com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] getByteArray(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult     // Catch: java.lang.Exception -> L6c
            int r0 = r0 + 17
            int r1 = r0 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L6c
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L21
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r0 = r5.activatedConfigsCache
            java.lang.String r0 = getStringFromCache(r0, r6)
            r4 = 26
            int r4 = r4 / r3
            if (r0 == 0) goto L1b
            r4 = 1
            goto L1c
        L1b:
            r4 = 0
        L1c:
            if (r4 == r2) goto L5c
            goto L2e
        L1f:
            r6 = move-exception
            throw r6
        L21:
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r0 = r5.activatedConfigsCache
            java.lang.String r0 = getStringFromCache(r0, r6)
            if (r0 == 0) goto L2b
            r4 = 1
            goto L2c
        L2b:
            r4 = 0
        L2c:
            if (r4 == r2) goto L5c
        L2e:
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r0 = r5.defaultConfigsCache
            java.lang.String r0 = getStringFromCache(r0, r6)
            if (r0 == 0) goto L54
            int r6 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult     // Catch: java.lang.Exception -> L52
            int r6 = r6 + 113
            int r2 = r6 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r2     // Catch: java.lang.Exception -> L52
            int r6 = r6 % r1
            if (r6 != 0) goto L4b
            java.nio.charset.Charset r6 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING
            byte[] r6 = r0.getBytes(r6)
            int r1 = r1 / r3
            goto L51
        L49:
            r6 = move-exception
            throw r6
        L4b:
            java.nio.charset.Charset r6 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING
            byte[] r6 = r0.getBytes(r6)
        L51:
            return r6
        L52:
            r6 = move-exception
            throw r6
        L54:
            java.lang.String r0 = "ByteArray"
            logParameterValueDoesNotExist(r6, r0)
            byte[] r6 = com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY
            return r6
        L5c:
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r1 = r5.activatedConfigsCache
            com.google.firebase.remoteconfig.internal.ConfigContainer r1 = getConfigsFromCache(r1)
            r5.callListeners(r6, r1)
            java.nio.charset.Charset r6 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING
            byte[] r6 = r0.getBytes(r6)
            return r6
        L6c:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getByteArray(java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if ((r0 != null ? '\b' : 'O') != 'O') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r1 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory + 5;
        com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        callListeners(r4, getConfigsFromCache(r3.activatedConfigsCache));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        return r0.doubleValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        r0 = getDoubleFromCache(r3.defaultConfigsCache, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (r0 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        r4 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult + 59;
        com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        if ((r4 % 2) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        r4 = 21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        r4 = '-';
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        if (r4 == '-') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
    
        r0 = r0.doubleValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        r4 = 41 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        r0 = r0.doubleValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        r4 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult + 47;
        com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
    
        logParameterValueDoesNotExist(r4, "Double");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        return com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r0 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double getDouble(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 75
            if (r0 != 0) goto L11
            r0 = 35
            goto L13
        L11:
            r0 = 75
        L13:
            if (r0 == r1) goto L22
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r0 = r3.activatedConfigsCache
            java.lang.Double r0 = getDoubleFromCache(r0, r4)
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L4d
            goto L33
        L20:
            r4 = move-exception
            throw r4
        L22:
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r0 = r3.activatedConfigsCache
            java.lang.Double r0 = getDoubleFromCache(r0, r4)
            r1 = 79
            if (r0 == 0) goto L2f
            r2 = 8
            goto L31
        L2f:
            r2 = 79
        L31:
            if (r2 == r1) goto L4d
        L33:
            int r1 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 5
            int r2 = r1 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult = r2
            int r1 = r1 % 2
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r1 = r3.activatedConfigsCache     // Catch: java.lang.Exception -> L4b
            com.google.firebase.remoteconfig.internal.ConfigContainer r1 = getConfigsFromCache(r1)     // Catch: java.lang.Exception -> L4b
            r3.callListeners(r4, r1)     // Catch: java.lang.Exception -> L4b
            double r0 = r0.doubleValue()     // Catch: java.lang.Exception -> L4b
            return r0
        L4b:
            r4 = move-exception
            goto L84
        L4d:
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r0 = r3.defaultConfigsCache
            java.lang.Double r0 = getDoubleFromCache(r0, r4)
            if (r0 == 0) goto L85
            int r4 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult
            int r4 = r4 + 59
            int r1 = r4 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r1
            int r4 = r4 % 2
            r1 = 45
            if (r4 != 0) goto L66
            r4 = 21
            goto L68
        L66:
            r4 = 45
        L68:
            if (r4 == r1) goto L75
            double r0 = r0.doubleValue()
            r4 = 41
            int r4 = r4 / 0
            goto L79
        L73:
            r4 = move-exception
            throw r4
        L75:
            double r0 = r0.doubleValue()     // Catch: java.lang.Exception -> L4b
        L79:
            int r4 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult     // Catch: java.lang.Exception -> L4b
            int r4 = r4 + 47
            int r2 = r4 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r2     // Catch: java.lang.Exception -> L4b
            int r4 = r4 % 2
            return r0
        L84:
            throw r4
        L85:
            java.lang.String r0 = "Double"
            logParameterValueDoesNotExist(r4, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getDouble(java.lang.String):double");
    }

    public long getLong(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Long longFromCache = getLongFromCache(this.activatedConfigsCache, str);
        if ((longFromCache != null ? '4' : (char) 7) != 7) {
            callListeners(str, getConfigsFromCache(this.activatedConfigsCache));
            return longFromCache.longValue();
        }
        Long longFromCache2 = getLongFromCache(this.defaultConfigsCache, str);
        if ((longFromCache2 != null ? (char) 14 : 'G') != 'G') {
            try {
                int i3 = BuiltInFictitiousFunctionClassFactory + 53;
                try {
                    PlaceComponentResult = i3 % 128;
                    if (i3 % 2 != 0) {
                        int i4 = 74 / 0;
                        return longFromCache2.longValue();
                    }
                    return longFromCache2.longValue();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        logParameterValueDoesNotExist(str, "Long");
        return 0L;
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        try {
            try {
                String stringFromCache = getStringFromCache(this.activatedConfigsCache, str);
                if (stringFromCache != null) {
                    callListeners(str, getConfigsFromCache(this.activatedConfigsCache));
                    FirebaseRemoteConfigValueImpl firebaseRemoteConfigValueImpl = new FirebaseRemoteConfigValueImpl(stringFromCache, 2);
                    int i = BuiltInFictitiousFunctionClassFactory + 29;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    return firebaseRemoteConfigValueImpl;
                }
                String stringFromCache2 = getStringFromCache(this.defaultConfigsCache, str);
                if (stringFromCache2 != null) {
                    FirebaseRemoteConfigValueImpl firebaseRemoteConfigValueImpl2 = new FirebaseRemoteConfigValueImpl(stringFromCache2, 1);
                    int i3 = BuiltInFictitiousFunctionClassFactory + 67;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    return firebaseRemoteConfigValueImpl2;
                }
                logParameterValueDoesNotExist(str, "FirebaseRemoteConfigValue");
                return new FirebaseRemoteConfigValueImpl("", 0);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public Set<String> getKeysByPrefix(String str) {
        if ((str == null ? (char) 29 : 'O') == 29) {
            str = "";
        }
        TreeSet treeSet = new TreeSet();
        ConfigContainer configsFromCache = getConfigsFromCache(this.activatedConfigsCache);
        if (configsFromCache != null) {
            int i = BuiltInFictitiousFunctionClassFactory + 73;
            PlaceComponentResult = i % 128;
            if (i % 2 != 0) {
                treeSet.addAll(getKeysByPrefix(str, configsFromCache));
                int i2 = 63 / 0;
            } else {
                try {
                    treeSet.addAll(getKeysByPrefix(str, configsFromCache));
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        ConfigContainer configsFromCache2 = getConfigsFromCache(this.defaultConfigsCache);
        if ((configsFromCache2 != null ? (char) 3 : (char) 18) != 18) {
            try {
                treeSet.addAll(getKeysByPrefix(str, configsFromCache2));
                int i3 = PlaceComponentResult + 75;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        return treeSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.TreeSet<java.lang.String> getKeysByPrefix(java.lang.String r7, com.google.firebase.remoteconfig.internal.ConfigContainer r8) {
        /*
            java.util.TreeSet r0 = new java.util.TreeSet
            r0.<init>()
            org.json.JSONObject r8 = r8.getConfigs()
            java.util.Iterator r8 = r8.keys()
        Ld:
            boolean r1 = r8.hasNext()     // Catch: java.lang.Exception -> L88
            r2 = 89
            if (r1 == 0) goto L18
            r1 = 89
            goto L1a
        L18:
            r1 = 54
        L1a:
            if (r1 == r2) goto L29
            int r7 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L27
            int r7 = r7 + 65
            int r8 = r7 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult = r8     // Catch: java.lang.Exception -> L27
            int r7 = r7 % 2
            return r0
        L27:
            r7 = move-exception
            throw r7
        L29:
            int r1 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult
            int r1 = r1 + 85
            int r2 = r1 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r2
            int r1 = r1 % 2
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L39
            r1 = 1
            goto L3a
        L39:
            r1 = 0
        L3a:
            r4 = 0
            if (r1 == 0) goto L4f
            java.lang.Object r1 = r8.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r5 = r1.startsWith(r7)
            r4.hashCode()     // Catch: java.lang.Throwable -> L4d
            if (r5 == 0) goto Ld
            goto L64
        L4d:
            r7 = move-exception
            throw r7
        L4f:
            java.lang.Object r1 = r8.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r5 = r1.startsWith(r7)
            r6 = 87
            if (r5 == 0) goto L60
            r5 = 86
            goto L62
        L60:
            r5 = 87
        L62:
            if (r5 == r6) goto Ld
        L64:
            int r5 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 49
            int r6 = r5 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L71
            r2 = 0
        L71:
            if (r2 == 0) goto L77
            r0.add(r1)
            goto L7b
        L77:
            r0.add(r1)
            int r1 = r4.length     // Catch: java.lang.Throwable -> L86
        L7b:
            int r1 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L88
            int r1 = r1 + 97
            int r2 = r1 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult = r2     // Catch: java.lang.Exception -> L88
            int r1 = r1 % 2
            goto Ld
        L86:
            r7 = move-exception
            throw r7
        L88:
            r7 = move-exception
            goto L8b
        L8a:
            throw r7
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getKeysByPrefix(java.lang.String, com.google.firebase.remoteconfig.internal.ConfigContainer):java.util.TreeSet");
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(getKeySetFromCache(this.activatedConfigsCache));
        hashSet.addAll(getKeySetFromCache(this.defaultConfigsCache));
        HashMap hashMap = new HashMap();
        Iterator it = hashSet.iterator();
        int i = PlaceComponentResult + 5;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        while (true) {
            if ((it.hasNext() ? 'G' : 'U') == 'U') {
                return hashMap;
            }
            int i3 = BuiltInFictitiousFunctionClassFactory + 121;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 != 0)) {
                String str = (String) it.next();
                hashMap.put(str, getValue(str));
            } else {
                String str2 = (String) it.next();
                hashMap.put(str2, getValue(str2));
                Object[] objArr = null;
                int length = objArr.length;
            }
        }
    }

    public void addListener(BiConsumer<String, ConfigContainer> biConsumer) {
        synchronized (this.listeners) {
            this.listeners.add(biConsumer);
        }
    }

    private void callListeners(final String str, final ConfigContainer configContainer) {
        if (configContainer == null) {
            return;
        }
        synchronized (this.listeners) {
            for (final BiConsumer<String, ConfigContainer> biConsumer : this.listeners) {
                this.executor.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConfigGetParameterHandler.lambda$callListeners$0(BiConsumer.this, str, configContainer);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$callListeners$0(BiConsumer biConsumer, String str, ConfigContainer configContainer) {
        int i = PlaceComponentResult + 27;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 == 0)) {
            biConsumer.accept(str, configContainer);
            return;
        }
        try {
            biConsumer.accept(str, configContainer);
            int i2 = 32 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private static String getStringFromCache(ConfigCacheClient configCacheClient, String str) {
        try {
            int i = PlaceComponentResult + 7;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
            try {
                if (configsFromCache != null) {
                    try {
                        String string = configsFromCache.getConfigs().getString(str);
                        int i3 = BuiltInFictitiousFunctionClassFactory + 99;
                        PlaceComponentResult = i3 % 128;
                        int i4 = i3 % 2;
                        return string;
                    } catch (JSONException unused) {
                        return null;
                    }
                }
                int i5 = PlaceComponentResult + 113;
                BuiltInFictitiousFunctionClassFactory = i5 % 128;
                if ((i5 % 2 == 0 ? 'B' : '`') != '`') {
                    int i6 = 58 / 0;
                    return null;
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if ((r3 != null) != true) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        r3 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult + 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        if ((r3 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        r3 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r3 = '/';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r3 == '/') goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r3 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        r3 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult + 23;
        com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
    
        return java.lang.Double.valueOf(r3.getConfigs().getDouble(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0052, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r3 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Double getDoubleFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient r3, java.lang.String r4) {
        /*
            int r0 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            com.google.firebase.remoteconfig.internal.ConfigContainer r3 = getConfigsFromCache(r3)
            if (r0 != 0) goto L17
            int r0 = r1.length     // Catch: java.lang.Throwable -> L15
            if (r3 != 0) goto L45
            goto L1f
        L15:
            r3 = move-exception
            throw r3
        L17:
            r0 = 1
            if (r3 != 0) goto L1c
            r2 = 0
            goto L1d
        L1c:
            r2 = 1
        L1d:
            if (r2 == r0) goto L45
        L1f:
            int r3 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult     // Catch: java.lang.Exception -> L43
            int r3 = r3 + 7
            int r4 = r3 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r4     // Catch: java.lang.Exception -> L43
            int r3 = r3 % 2
            r4 = 47
            if (r3 != 0) goto L30
            r3 = 92
            goto L32
        L30:
            r3 = 47
        L32:
            if (r3 == r4) goto L38
            int r3 = r1.length     // Catch: java.lang.Throwable -> L36
            goto L38
        L36:
            r3 = move-exception
            throw r3
        L38:
            int r3 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.PlaceComponentResult
            int r3 = r3 + 23
            int r4 = r3 % 128
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.BuiltInFictitiousFunctionClassFactory = r4
            int r3 = r3 % 2
            return r1
        L43:
            r3 = move-exception
            throw r3
        L45:
            org.json.JSONObject r3 = r3.getConfigs()     // Catch: org.json.JSONException -> L52
            double r3 = r3.getDouble(r4)     // Catch: org.json.JSONException -> L52
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            return r3
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getDoubleFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient, java.lang.String):java.lang.Double");
    }

    private static Long getLongFromCache(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
        Object obj = null;
        if (!(configsFromCache != null)) {
            int i = PlaceComponentResult + 49;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if ((i % 2 != 0 ? (char) 17 : (char) 0) == 0) {
                obj.hashCode();
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 59;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return null;
        }
        try {
            return Long.valueOf(configsFromCache.getConfigs().getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static Set<String> getKeySetFromCache(ConfigCacheClient configCacheClient) {
        HashSet hashSet = new HashSet();
        ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
        Object obj = null;
        if ((configsFromCache == null ? 'a' : '8') == 'a') {
            try {
                int i = BuiltInFictitiousFunctionClassFactory + 59;
                PlaceComponentResult = i % 128;
                if ((i % 2 != 0 ? (char) 23 : 'a') != 23) {
                    return hashSet;
                }
                obj.hashCode();
                return hashSet;
            } catch (Exception e) {
                throw e;
            }
        }
        Iterator<String> keys = configsFromCache.getConfigs().keys();
        while (true) {
            if (!(keys.hasNext())) {
                return hashSet;
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 121;
            PlaceComponentResult = i2 % 128;
            if (i2 % 2 != 0) {
                hashSet.add(keys.next());
                obj.hashCode();
            } else {
                hashSet.add(keys.next());
            }
        }
    }

    private static ConfigContainer getConfigsFromCache(ConfigCacheClient configCacheClient) {
        int i = BuiltInFictitiousFunctionClassFactory + 15;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            try {
                return configCacheClient.getBlocking();
            } catch (Exception e) {
                throw e;
            }
        }
        ConfigContainer blocking = configCacheClient.getBlocking();
        Object obj = null;
        obj.hashCode();
        return blocking;
    }

    private static void logParameterValueDoesNotExist(String str, String str2) {
        int i = PlaceComponentResult + 63;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        InstrumentInjector.log_w(FirebaseRemoteConfig.TAG, String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
        int i3 = PlaceComponentResult + 23;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? '6' : (char) 7) != 7) {
            int i4 = 5 / 0;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '0' : 'R') == 'R') {
                break;
            }
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (KClassImpl$Data$declaredNonStaticMembers$2[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getAuthRequestContext))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
            try {
                int i3 = $11 + 81;
                try {
                    $10 = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
            throw e2;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            int i5 = $10 + 29;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
