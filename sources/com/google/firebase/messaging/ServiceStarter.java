package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
public class ServiceStarter {
    static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    static final int ERROR_ILLEGAL_STATE_EXCEPTION = 402;
    static final int ERROR_ILLEGAL_STATE_EXCEPTION_FALLBACK_TO_BIND = 403;
    static final int ERROR_NOT_FOUND = 404;
    static final int ERROR_SECURITY_EXCEPTION = 401;
    public static final int ERROR_UNKNOWN = 500;
    private static final String EXTRA_WRAPPED_INTENT = "wrapped_intent";
    private static final String PERMISSIONS_MISSING_HINT = "this should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    public static final int SUCCESS = -1;
    private static ServiceStarter instance;
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasWakeLockPermission = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private final Queue<Intent> messagingEvents = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (instance == null) {
                instance = new ServiceStarter();
            }
            serviceStarter = instance;
        }
        return serviceStarter;
    }

    private ServiceStarter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent getMessagingEvent() {
        return this.messagingEvents.poll();
    }

    public int startMessagingService(Context context, Intent intent) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            InstrumentInjector.log_d(Constants.TAG, "Starting service");
        }
        this.messagingEvents.offer(intent);
        Intent intent2 = new Intent(ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return doStartService(context, intent2);
    }

    private int doStartService(Context context, Intent intent) {
        ComponentName startService;
        String resolveServiceClassName = resolveServiceClassName(context, intent);
        if (resolveServiceClassName != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Restricting intent to a specific service: ");
                sb.append(resolveServiceClassName);
                InstrumentInjector.log_d(Constants.TAG, sb.toString());
            }
            intent.setClassName(context.getPackageName(), resolveServiceClassName);
        }
        try {
            if (hasWakeLockPermission(context)) {
                startService = WakeLockHolder.startWakefulService(context, intent);
            } else {
                startService = context.startService(intent);
                InstrumentInjector.log_d(Constants.TAG, "Missing wake lock permission, service start may be delayed");
            }
            if (startService == null) {
                InstrumentInjector.log_e(Constants.TAG, "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            return -1;
        } catch (IllegalStateException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to start service while in background: ");
            sb2.append(e);
            InstrumentInjector.log_e(Constants.TAG, sb2.toString());
            return 402;
        } catch (SecurityException e2) {
            InstrumentInjector.log_e(Constants.TAG, "Error while delivering the message to the serviceIntent", e2);
            return 401;
        }
    }

    private String resolveServiceClassName(Context context, Intent intent) {
        synchronized (this) {
            String str = this.firebaseMessagingServiceClassName;
            if (str != null) {
                return str;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null && resolveService.serviceInfo != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (context.getPackageName().equals(serviceInfo.packageName) && serviceInfo.name != null) {
                    if (serviceInfo.name.startsWith(".")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(context.getPackageName());
                        sb.append(serviceInfo.name);
                        this.firebaseMessagingServiceClassName = sb.toString();
                    } else {
                        this.firebaseMessagingServiceClassName = serviceInfo.name;
                    }
                    return this.firebaseMessagingServiceClassName;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                sb2.append(serviceInfo.packageName);
                sb2.append("/");
                sb2.append(serviceInfo.name);
                InstrumentInjector.log_e(Constants.TAG, sb2.toString());
                return null;
            }
            InstrumentInjector.log_e(Constants.TAG, "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasWakeLockPermission(Context context) {
        if (this.hasWakeLockPermission == null) {
            this.hasWakeLockPermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable(Constants.TAG, 3)) {
            InstrumentInjector.log_d(Constants.TAG, "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.hasWakeLockPermission.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasAccessNetworkStatePermission(Context context) {
        if (this.hasAccessNetworkStatePermission == null) {
            this.hasAccessNetworkStatePermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable(Constants.TAG, 3)) {
            InstrumentInjector.log_d(Constants.TAG, "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }
}
