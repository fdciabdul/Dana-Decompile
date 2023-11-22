package com.alipay.mobile.security.bio.runtime;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.alipay.mobile.security.bio.config.BisRuntimeInfoEnum;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.runtime.FrameworkDesc;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.service.BioMetaInfo;
import com.alipay.mobile.security.bio.service.BioServiceDescription;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.local.LocalService;
import com.alipay.mobile.security.bio.service.local.dynamicrelease.DynamicReleaseService;
import com.alipay.mobile.security.bio.service.local.language.LanguageService;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.alipay.mobile.security.bio.workspace.Env;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class Runtime {
    private static final String LAUNCHER_APPLICATION = "com.alipay.mobile.quinox.LauncherApplication";
    public static final String TAG = "Runtime";
    private static Object bundleContext;
    private static Method findClassLoaderByBundleName;
    private static Method getResourcesByBundle;
    private static FrameworkDesc sFrameworkDesc;
    private static Boolean sIsRunningOnQuinox;
    private static HashMap<String, ModuleDesc> sModuleDescMap;

    static {
        try {
            Class<?> cls = Class.forName("com.alipay.mobile.framework.LauncherApplicationAgent");
            Method declaredMethod = cls.getDeclaredMethod("getmBundleContext", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, new Object[0]);
            bundleContext = invoke;
            Class<?> cls2 = invoke.getClass();
            Method method = cls2.getMethod("getResourcesByBundle", String.class);
            getResourcesByBundle = method;
            method.setAccessible(true);
            Method method2 = cls2.getMethod("findClassLoaderByBundleName", String.class);
            findClassLoaderByBundleName = method2;
            method2.setAccessible(true);
        } catch (Throwable th) {
            th.getMessage();
        }
        sIsRunningOnQuinox = null;
    }

    public static boolean isRunningOnQuinox(Context context) {
        if (sIsRunningOnQuinox == null) {
            synchronized (LAUNCHER_APPLICATION) {
                if (sIsRunningOnQuinox == null) {
                    sIsRunningOnQuinox = Boolean.valueOf(LAUNCHER_APPLICATION.equals(context.getApplicationContext().getClass().getName()));
                }
            }
        }
        return sIsRunningOnQuinox.booleanValue();
    }

    public static ClassLoader getClassLoaderByBundleName(String str) {
        try {
            return (ClassLoader) findClassLoaderByBundleName.invoke(bundleContext, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Resources getResourcesByBundleName(String str) {
        try {
            return (Resources) getResourcesByBundle.invoke(bundleContext, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<BioMetaInfo> getBioMetaInfoList() {
        ArrayList arrayList = new ArrayList();
        for (ModuleDesc moduleDesc : sModuleDescMap.values()) {
            if (moduleDesc.mBioMetaInfoList != null && !moduleDesc.mBioMetaInfoList.isEmpty()) {
                arrayList.addAll(moduleDesc.mBioMetaInfoList);
            }
        }
        return arrayList;
    }

    public static BioServiceDescription getBioServiceDescriptionByInterface(Context context, String str) {
        inflateModules(context, isRunningOnQuinox(context));
        return getBioServiceDescriptionByInterface(str);
    }

    private static BioServiceDescription getBioServiceDescriptionByInterface(String str) {
        BioServiceDescription bioServiceDescription = null;
        for (ModuleDesc moduleDesc : sModuleDescMap.values()) {
            if (moduleDesc.mBioServiceDescription != null && !moduleDesc.mBioServiceDescription.isEmpty()) {
                Iterator<BioServiceDescription> it = moduleDesc.mBioServiceDescription.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BioServiceDescription next = it.next();
                    if (TextUtils.equals(str, next.getInterfaceName())) {
                        bioServiceDescription = next;
                        break;
                    }
                }
            }
            if (bioServiceDescription != null) {
                break;
            }
        }
        return bioServiceDescription;
    }

    public static void getLocalService(Context context, HashMap<String, LocalService> hashMap, HashMap<String, BioServiceDescription> hashMap2) {
        inflateModules(context, isRunningOnQuinox(context));
        ArrayList<BioServiceDescription> arrayList = new ArrayList();
        for (ModuleDesc moduleDesc : sModuleDescMap.values()) {
            if (moduleDesc.mBioServiceDescription != null && !moduleDesc.mBioServiceDescription.isEmpty()) {
                arrayList.addAll(moduleDesc.mBioServiceDescription);
            }
        }
        for (BioServiceDescription bioServiceDescription : arrayList) {
            if (bioServiceDescription.isLazy()) {
                if (hashMap2 != null) {
                    hashMap2.put(bioServiceDescription.getInterfaceName(), bioServiceDescription);
                }
            } else if (hashMap != null) {
                try {
                    hashMap.put(bioServiceDescription.getInterfaceName(), (LocalService) bioServiceDescription.getClazz().newInstance());
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
    
        r3 = getClassLoaderByBundleName(r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Class<?> loadClass(android.content.Context r2, boolean r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            if (r3 == 0) goto L15
            java.lang.ClassLoader r3 = getClassLoaderByBundleName(r5)
            if (r3 == 0) goto L15
            java.lang.Class r3 = r3.loadClass(r4)     // Catch: java.lang.ClassNotFoundException -> L12
            goto L16
        L12:
            r0.add(r3)
        L15:
            r3 = 0
        L16:
            if (r3 != 0) goto L2c
            java.lang.Class<com.alipay.mobile.security.bio.runtime.Runtime> r5 = com.alipay.mobile.security.bio.runtime.Runtime.class
            java.lang.ClassLoader r5 = r5.getClassLoader()
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L2c
            java.lang.Class r3 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L29
            goto L2c
        L29:
            r0.add(r5)
        L2c:
            if (r3 != 0) goto L40
            if (r2 == 0) goto L40
            java.lang.ClassLoader r2 = r2.getClassLoader()
            if (r2 == 0) goto L40
            boolean r5 = r0.contains(r2)
            if (r5 != 0) goto L40
            java.lang.Class r3 = r2.loadClass(r4)     // Catch: java.lang.ClassNotFoundException -> L40
        L40:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.security.bio.runtime.Runtime.loadClass(android.content.Context, boolean, java.lang.String, java.lang.String):java.lang.Class");
    }

    public static String getFrameworkVersion(Context context) {
        return getSdkVersion(context, sFrameworkDesc.frameworkVersion, getBioMetaInfoList());
    }

    public static String getMetaInfos(Context context, Map<String, Object> map) {
        if (context == null) {
            throw new BioIllegalArgumentException("Context is null");
        }
        boolean isRunningOnQuinox = isRunningOnQuinox(context);
        inflateModules(context, isRunningOnQuinox);
        List<BioMetaInfo> bioMetaInfoList = getBioMetaInfoList();
        String sdkVersion = getSdkVersion(context, sFrameworkDesc.frameworkVersion, bioMetaInfoList);
        String sdkModule = getSdkModule(context, bioMetaInfoList);
        String runtimeInfo = getRuntimeInfo(context, bioMetaInfoList, isRunningOnQuinox, map);
        StringBuilder sb = new StringBuilder();
        sb.append(sdkVersion);
        sb.append(":");
        sb.append(sdkModule);
        sb.append(",");
        sb.append(runtimeInfo);
        return sb.toString();
    }

    private static void inflateModules(Context context, boolean z) {
        synchronized (Runtime.class) {
            if (sFrameworkDesc == null) {
                sFrameworkDesc = FrameworkDesc.create(context);
            }
            HashSet hashSet = new HashSet();
            if (sModuleDescMap == null) {
                sModuleDescMap = new HashMap<>(sFrameworkDesc.configs.size());
                for (FrameworkDesc.ConfigDesc configDesc : sFrameworkDesc.configs) {
                    ModuleDesc create = ModuleDesc.create(context, z, configDesc);
                    if (z) {
                        if (configDesc.dev) {
                            if (configDesc.dynamic) {
                                if (create != null) {
                                    sModuleDescMap.put(configDesc.configFileName, create);
                                }
                            } else if (create != null) {
                                sModuleDescMap.put(configDesc.configFileName, create);
                            }
                        } else if (configDesc.dynamic) {
                            if (create == null) {
                                hashSet.add(configDesc.bundleName);
                            } else {
                                sModuleDescMap.put(configDesc.configFileName, create);
                            }
                        } else if (create == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("There is a static bundle can't be found: ");
                            sb.append(configDesc);
                            throw new RuntimeException(sb.toString());
                        } else {
                            sModuleDescMap.put(configDesc.configFileName, create);
                        }
                    } else if (configDesc.dev) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("On no-quinox, there is a dev bundle: ");
                        sb2.append(configDesc);
                        throw new RuntimeException(sb2.toString());
                    } else if (configDesc.dynamic) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("On no-quinox, there is a dynamic bundle: ");
                        sb3.append(configDesc);
                        throw new RuntimeException(sb3.toString());
                    } else if (create == null) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("There is a static bundle can't be found: ");
                        sb4.append(configDesc);
                        throw new RuntimeException(sb4.toString());
                    } else {
                        sModuleDescMap.put(configDesc.configFileName, create);
                    }
                }
            } else if (z) {
                for (FrameworkDesc.ConfigDesc configDesc2 : sFrameworkDesc.configs) {
                    if (configDesc2.dynamic) {
                        ModuleDesc create2 = ModuleDesc.create(context, true, configDesc2);
                        if (create2 == null) {
                            hashSet.add(configDesc2.bundleName);
                        } else {
                            sModuleDescMap.put(configDesc2.configFileName, create2);
                        }
                    }
                }
            }
            if (z) {
                DynamicReleaseService dynamicReleaseService = (DynamicReleaseService) BioServiceManager.getLocalService(context, getBioServiceDescriptionByInterface(DynamicReleaseService.class.getName()));
                if (dynamicReleaseService != null) {
                    for (FrameworkDesc.ConfigDesc configDesc3 : sFrameworkDesc.configs) {
                        if (configDesc3.dynamic) {
                            dynamicReleaseService.monitorCoverage(configDesc3.bundleName, null);
                        }
                    }
                }
                if (!hashSet.isEmpty()) {
                    StringUtil.collection2String(hashSet);
                    if (dynamicReleaseService != null) {
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            dynamicReleaseService.trigDynamicRelease(context, (String) it.next());
                        }
                    }
                }
            }
        }
    }

    private static String getSdkVersion(Context context, String str, List<BioMetaInfo> list) {
        if (list == null || list.isEmpty()) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".") + 1;
        int parseInt = Integer.parseInt(str.substring(lastIndexOf));
        Iterator<BioMetaInfo> it = list.iterator();
        while (it.hasNext()) {
            String revision = it.next().getRevision(context);
            if (!TextUtils.isEmpty(revision)) {
                parseInt += Integer.parseInt(revision.replace(".", ""));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, lastIndexOf));
        sb.append(parseInt);
        return sb.toString();
    }

    private static String getSdkModule(Context context, List<BioMetaInfo> list) {
        int i = 0;
        for (BioMetaInfo bioMetaInfo : list) {
            List<Long> productIDs = bioMetaInfo.getProductIDs();
            if (productIDs != null && !productIDs.isEmpty()) {
                Iterator<Long> it = productIDs.iterator();
                while (it.hasNext()) {
                    double d = i;
                    double pow = Math.pow(2.0d, it.next().longValue());
                    Double.isNaN(d);
                    i = (int) (d + pow);
                }
            }
            List<Long> productIDs2 = bioMetaInfo.getProductIDs(context);
            if (productIDs2 != null && !productIDs2.isEmpty()) {
                Iterator<Long> it2 = productIDs2.iterator();
                while (it2.hasNext()) {
                    double d2 = i;
                    double pow2 = Math.pow(2.0d, it2.next().longValue());
                    Double.isNaN(d2);
                    i = (int) (d2 + pow2);
                }
            }
            List<BioAppDescription> applications = bioMetaInfo.getApplications();
            if (applications != null && !applications.isEmpty()) {
                Iterator<BioAppDescription> it3 = applications.iterator();
                while (it3.hasNext()) {
                    long productID = it3.next().getProductID();
                    if (-1 != productID) {
                        double d3 = i;
                        double pow3 = Math.pow(2.0d, productID);
                        Double.isNaN(d3);
                        i = (int) (d3 + pow3);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        return sb.toString();
    }

    private static String getRuntimeInfo(Context context, List<BioMetaInfo> list, boolean z, Map<String, Object> map) {
        int pow = (1 != Env.getProtocolFormat(context) ? (int) (Math.pow(2.0d, BisRuntimeInfoEnum.PROTOCOL_FORMAT.getProductID()) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : 0) + (new LanguageService().getCurrentLanguage() * 4);
        Iterator<BioMetaInfo> it = list.iterator();
        while (it.hasNext()) {
            List<Integer> runtimeInfoIDs = it.next().getRuntimeInfoIDs(context, map);
            if (runtimeInfoIDs != null && !runtimeInfoIDs.isEmpty()) {
                Iterator<Integer> it2 = runtimeInfoIDs.iterator();
                while (it2.hasNext()) {
                    double d = pow;
                    double pow2 = Math.pow(2.0d, it2.next().intValue());
                    Double.isNaN(d);
                    pow = (int) (d + pow2);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pow);
        return sb.toString();
    }

    public static boolean startActivity(Intent intent) {
        try {
            Class<?> cls = Class.forName("com.alipay.mobile.framework.LauncherApplicationAgent");
            Method method = cls.getMethod("getInstance", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(cls, new Object[0]);
            Method method2 = cls.getMethod("getMicroApplicationContext", new Class[0]);
            method2.setAccessible(true);
            Object invoke2 = method2.invoke(invoke, new Object[0]);
            Method method3 = invoke2.getClass().getMethod("getTopApplication", new Class[0]);
            method3.setAccessible(true);
            Object invoke3 = method3.invoke(invoke2, new Object[0]);
            Method method4 = invoke2.getClass().getMethod("startExtActivity", Class.forName("com.alipay.mobile.framework.app.MicroApplication"), Intent.class);
            method4.setAccessible(true);
            method4.invoke(invoke2, invoke3, intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
