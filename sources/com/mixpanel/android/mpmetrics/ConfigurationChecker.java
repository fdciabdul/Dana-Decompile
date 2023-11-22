package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import com.mixpanel.android.util.MPLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
class ConfigurationChecker {
    public static String BuiltInFictitiousFunctionClassFactory = "MixpanelAPI.ConfigurationChecker";
    private static Boolean MyBillsEntityDataFactory;

    ConfigurationChecker() {
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager == null || packageName == null) {
            MPLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "Can't check configuration when using a Context with null packageManager or packageName");
            return false;
        } else if (packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
            MPLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "Package does not have permission android.permission.INTERNET - Mixpanel will not work at all!");
            MPLog.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
            return false;
        } else {
            return true;
        }
    }

    public static boolean MyBillsEntityDataFactory(Context context) {
        if (MyBillsEntityDataFactory == null) {
            if (Build.VERSION.SDK_INT < 16) {
                Boolean bool = Boolean.FALSE;
                MyBillsEntityDataFactory = bool;
                return bool.booleanValue();
            }
            Intent intent = new Intent(context, TakeoverInAppActivity.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
                String str = BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb = new StringBuilder();
                sb.append(TakeoverInAppActivity.class.getName());
                sb.append(" is not registered as an activity in your application, so takeover in-apps can't be shown.");
                MPLog.BuiltInFictitiousFunctionClassFactory(str, sb.toString());
                MPLog.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, "Please add the child tag <activity android:name=\"com.mixpanel.android.takeoverinapp.TakeoverInAppActivity\" /> to your <application> tag.");
                Boolean bool2 = Boolean.FALSE;
                MyBillsEntityDataFactory = bool2;
                return bool2.booleanValue();
            }
            MyBillsEntityDataFactory = Boolean.TRUE;
        }
        return MyBillsEntityDataFactory.booleanValue();
    }

    public static boolean getAuthRequestContext(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager != null && packageName != null) {
            if (packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
                MPLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "Package does not have permission android.permission.INTERNET");
                MPLog.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
                return false;
            }
            try {
                ServiceInfo[] serviceInfoArr = packageManager.getPackageInfo(packageName, 4).services;
                if (serviceInfoArr != null && serviceInfoArr.length != 0) {
                    Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                    intent.setPackage(packageName);
                    List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
                    Iterator<ResolveInfo> it = queryIntentServices.iterator();
                    while (it.hasNext()) {
                        try {
                            if (!MixpanelFCMMessagingService.class.isAssignableFrom(Class.forName(it.next().serviceInfo.name))) {
                                it.remove();
                            }
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                    if (queryIntentServices != null && queryIntentServices.size() != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (ResolveInfo resolveInfo : queryIntentServices) {
                            for (ServiceInfo serviceInfo : serviceInfoArr) {
                                if (serviceInfo.name.equals(resolveInfo.serviceInfo.name) && serviceInfo.isEnabled()) {
                                    arrayList.add(resolveInfo.serviceInfo);
                                }
                            }
                        }
                        if (arrayList.size() > 1) {
                            MPLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "You can't have more than one service handling \"com.google.firebase.MESSAGING_EVENT\" intent filter. Android will only use the first one that is declared on your AndroidManifest.xml. If you have more than one push provider you need to crate your own FirebaseMessagingService class.");
                        }
                        try {
                            Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
                        } catch (ClassNotFoundException unused2) {
                            MPLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "Google Play Services aren't included in your build- push notifications won't work on Lollipop/API 21 or greater");
                            MPLog.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, "You can fix this by adding com.google.android.gms:play-services as a dependency of your gradle or maven project");
                        }
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused3) {
            }
        }
        return false;
    }

    public static boolean getAuthRequestContext(Future<SharedPreferences> future) {
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerStateListener");
            if (future != null) {
                return future.get().getAll().size() == 0;
            }
            return false;
        } catch (ClassNotFoundException unused) {
            MPLog.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "Missing com.android.installreferrer dependency. Google Play Store referrer information won't be available.");
            return false;
        } catch (InterruptedException unused2) {
            MPLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "Could not read referrer shared preferences.");
            return false;
        } catch (ExecutionException unused3) {
            MPLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, "Could not read referrer shared preferences.");
            return false;
        }
    }
}
