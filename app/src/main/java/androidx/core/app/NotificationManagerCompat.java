package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class NotificationManagerCompat {
    private static String BuiltInFictitiousFunctionClassFactory;
    private static SideChannelManager getErrorConfigVersion;
    private final NotificationManager NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Context lookAheadTest;
    public static final byte[] PlaceComponentResult = {62, -79, -77, -78, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int getAuthRequestContext = 58;
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    private static Set<String> MyBillsEntityDataFactory = new HashSet();
    private static final Object moveToNextValue = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Task {
        void getAuthRequestContext(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = androidx.core.app.NotificationManagerCompat.PlaceComponentResult
            int r9 = r9 * 6
            int r9 = 103 - r9
            int r7 = r7 * 5
            int r7 = r7 + 18
            int r8 = r8 * 22
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1b:
            r3 = 0
        L1c:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r10 = r10 + r7
            int r7 = r10 + (-8)
            int r9 = r9 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationManagerCompat.a(short, int, short, java.lang.Object[]):void");
    }

    public static NotificationManagerCompat MyBillsEntityDataFactory(Context context) {
        return new NotificationManagerCompat(context);
    }

    private NotificationManagerCompat(Context context) {
        this.lookAheadTest = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (NotificationManager) context.getSystemService("notification");
    }

    public final void MyBillsEntityDataFactory(int i) {
        PlaceComponentResult(null, i);
    }

    public final void PlaceComponentResult(String str, int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.cancel(str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            BuiltInFictitiousFunctionClassFactory(new CancelTask(this.lookAheadTest.getPackageName(), i, str));
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.lookAheadTest.getSystemService("appops");
            Context context = this.lookAheadTest;
            try {
                byte b = (byte) (PlaceComponentResult[8] - 1);
                byte b2 = PlaceComponentResult[41];
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 + 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = PlaceComponentResult[41];
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 + 1), PlaceComponentResult[41], objArr2);
                ApplicationInfo applicationInfo = (ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null);
                String packageName = this.lookAheadTest.getApplicationContext().getPackageName();
                int i = applicationInfo.uid;
                try {
                    Class<?> cls2 = Class.forName(AppOpsManager.class.getName());
                    if (((Integer) cls2.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls2.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() != 0) {
                        return false;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return true;
    }

    public final void BuiltInFictitiousFunctionClassFactory(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.createNotificationChannel(notificationChannel);
        }
    }

    public final NotificationChannelGroup KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getNotificationChannelGroup(str);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannelGroup notificationChannelGroup : KClassImpl$Data$declaredNonStaticMembers$2()) {
                if (notificationChannelGroup.getId().equals(str)) {
                    return notificationChannelGroup;
                }
            }
            return null;
        }
        return null;
    }

    public final List<NotificationChannel> MyBillsEntityDataFactory() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getNotificationChannels();
        }
        return Collections.emptyList();
    }

    public final List<NotificationChannelGroup> KClassImpl$Data$declaredNonStaticMembers$2() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getNotificationChannelGroups();
        }
        return Collections.emptyList();
    }

    public static Set<String> getAuthRequestContext(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            if (string != null) {
                if (!string.equals(BuiltInFictitiousFunctionClassFactory)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    MyBillsEntityDataFactory = hashSet;
                    BuiltInFictitiousFunctionClassFactory = string;
                }
            }
            set = MyBillsEntityDataFactory;
        }
        return set;
    }

    private void BuiltInFictitiousFunctionClassFactory(Task task) {
        synchronized (moveToNextValue) {
            if (getErrorConfigVersion == null) {
                getErrorConfigVersion = new SideChannelManager(this.lookAheadTest.getApplicationContext());
            }
            getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SideChannelManager implements Handler.Callback, ServiceConnection {
        private final Handler BuiltInFictitiousFunctionClassFactory;
        private final HandlerThread KClassImpl$Data$declaredNonStaticMembers$2;
        private final Context PlaceComponentResult;
        private final Map<ComponentName, ListenerRecord> getAuthRequestContext = new HashMap();
        private Set<String> MyBillsEntityDataFactory = new HashSet();

        SideChannelManager(Context context) {
            this.PlaceComponentResult = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = handlerThread;
            handlerThread.start();
            this.BuiltInFictitiousFunctionClassFactory = new Handler(handlerThread.getLooper(), this);
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(Task task) {
            this.BuiltInFictitiousFunctionClassFactory.obtainMessage(0, task).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                getAuthRequestContext((Task) message.obj);
                return true;
            } else if (i == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                MyBillsEntityDataFactory(serviceConnectedEvent.getAuthRequestContext, serviceConnectedEvent.BuiltInFictitiousFunctionClassFactory);
                return true;
            } else if (i == 2) {
                getAuthRequestContext((ComponentName) message.obj);
                return true;
            } else if (i != 3) {
                return false;
            } else {
                BuiltInFictitiousFunctionClassFactory((ComponentName) message.obj);
                return true;
            }
        }

        private void getAuthRequestContext(Task task) {
            PlaceComponentResult();
            for (ListenerRecord listenerRecord : this.getAuthRequestContext.values()) {
                listenerRecord.BuiltInFictitiousFunctionClassFactory.add(task);
                getAuthRequestContext(listenerRecord);
            }
        }

        private void MyBillsEntityDataFactory(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = this.getAuthRequestContext.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.PlaceComponentResult = INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.MyBillsEntityDataFactory = 0;
                getAuthRequestContext(listenerRecord);
            }
        }

        private void getAuthRequestContext(ComponentName componentName) {
            ListenerRecord listenerRecord = this.getAuthRequestContext.get(componentName);
            if (listenerRecord != null) {
                BuiltInFictitiousFunctionClassFactory(listenerRecord);
            }
        }

        private void BuiltInFictitiousFunctionClassFactory(ComponentName componentName) {
            ListenerRecord listenerRecord = this.getAuthRequestContext.get(componentName);
            if (listenerRecord != null) {
                getAuthRequestContext(listenerRecord);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Connected to service ");
                sb.append(componentName);
                InstrumentInjector.log_d("NotifManCompat", sb.toString());
            }
            this.BuiltInFictitiousFunctionClassFactory.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Disconnected from service ");
                sb.append(componentName);
                InstrumentInjector.log_d("NotifManCompat", sb.toString());
            }
            this.BuiltInFictitiousFunctionClassFactory.obtainMessage(2, componentName).sendToTarget();
        }

        private void PlaceComponentResult() {
            Set<String> authRequestContext = NotificationManagerCompat.getAuthRequestContext(this.PlaceComponentResult);
            if (authRequestContext.equals(this.MyBillsEntityDataFactory)) {
                return;
            }
            this.MyBillsEntityDataFactory = authRequestContext;
            List<ResolveInfo> queryIntentServices = this.PlaceComponentResult.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (authRequestContext.contains(resolveInfo.serviceInfo.packageName)) {
                    ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Permission present on component ");
                        sb.append(componentName);
                        sb.append(", not adding listener record.");
                        InstrumentInjector.log_w("NotifManCompat", sb.toString());
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.getAuthRequestContext.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Adding listener record for ");
                        sb2.append(componentName2);
                        InstrumentInjector.log_d("NotifManCompat", sb2.toString());
                    }
                    this.getAuthRequestContext.put(componentName2, new ListenerRecord(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, ListenerRecord>> it = this.getAuthRequestContext.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, ListenerRecord> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Removing listener record for ");
                        sb3.append(next.getKey());
                        InstrumentInjector.log_d("NotifManCompat", sb3.toString());
                    }
                    BuiltInFictitiousFunctionClassFactory(next.getValue());
                    it.remove();
                }
            }
        }

        private boolean PlaceComponentResult(ListenerRecord listenerRecord) {
            if (listenerRecord.KClassImpl$Data$declaredNonStaticMembers$2) {
                return true;
            }
            listenerRecord.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.getAuthRequestContext), this, 33);
            if (listenerRecord.KClassImpl$Data$declaredNonStaticMembers$2) {
                listenerRecord.MyBillsEntityDataFactory = 0;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to bind to listener ");
                sb.append(listenerRecord.getAuthRequestContext);
                InstrumentInjector.log_w("NotifManCompat", sb.toString());
                this.PlaceComponentResult.unbindService(this);
            }
            return listenerRecord.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        private void BuiltInFictitiousFunctionClassFactory(ListenerRecord listenerRecord) {
            if (listenerRecord.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.PlaceComponentResult.unbindService(this);
                listenerRecord.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
            listenerRecord.PlaceComponentResult = null;
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(ListenerRecord listenerRecord) {
            if (this.BuiltInFictitiousFunctionClassFactory.hasMessages(3, listenerRecord.getAuthRequestContext)) {
                return;
            }
            listenerRecord.MyBillsEntityDataFactory++;
            if (listenerRecord.MyBillsEntityDataFactory > 6) {
                StringBuilder sb = new StringBuilder();
                sb.append("Giving up on delivering ");
                sb.append(listenerRecord.BuiltInFictitiousFunctionClassFactory.size());
                sb.append(" tasks to ");
                sb.append(listenerRecord.getAuthRequestContext);
                sb.append(" after ");
                sb.append(listenerRecord.MyBillsEntityDataFactory);
                sb.append(" retries");
                InstrumentInjector.log_w("NotifManCompat", sb.toString());
                listenerRecord.BuiltInFictitiousFunctionClassFactory.clear();
                return;
            }
            int i = (1 << (listenerRecord.MyBillsEntityDataFactory - 1)) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scheduling retry for ");
                sb2.append(i);
                sb2.append(" ms");
                InstrumentInjector.log_d("NotifManCompat", sb2.toString());
            }
            this.BuiltInFictitiousFunctionClassFactory.sendMessageDelayed(this.BuiltInFictitiousFunctionClassFactory.obtainMessage(3, listenerRecord.getAuthRequestContext), i);
        }

        private void getAuthRequestContext(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Processing component ");
                sb.append(listenerRecord.getAuthRequestContext);
                sb.append(", ");
                sb.append(listenerRecord.BuiltInFictitiousFunctionClassFactory.size());
                sb.append(" queued tasks");
                InstrumentInjector.log_d("NotifManCompat", sb.toString());
            }
            if (listenerRecord.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                return;
            }
            if (!PlaceComponentResult(listenerRecord) || listenerRecord.PlaceComponentResult == null) {
                KClassImpl$Data$declaredNonStaticMembers$2(listenerRecord);
                return;
            }
            while (true) {
                Task peek = listenerRecord.BuiltInFictitiousFunctionClassFactory.peek();
                if (peek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Sending task ");
                        sb2.append(peek);
                        InstrumentInjector.log_d("NotifManCompat", sb2.toString());
                    }
                    peek.getAuthRequestContext(listenerRecord.PlaceComponentResult);
                    listenerRecord.BuiltInFictitiousFunctionClassFactory.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Remote service has died: ");
                        sb3.append(listenerRecord.getAuthRequestContext);
                        InstrumentInjector.log_d("NotifManCompat", sb3.toString());
                    }
                } catch (RemoteException e) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("RemoteException communicating with ");
                    sb4.append(listenerRecord.getAuthRequestContext);
                    InstrumentInjector.log_w("NotifManCompat", sb4.toString(), e);
                }
            }
            if (listenerRecord.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(listenerRecord);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class ListenerRecord {
            INotificationSideChannel PlaceComponentResult;
            final ComponentName getAuthRequestContext;
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
            ArrayDeque<Task> BuiltInFictitiousFunctionClassFactory = new ArrayDeque<>();
            int MyBillsEntityDataFactory = 0;

            ListenerRecord(ComponentName componentName) {
                this.getAuthRequestContext = componentName;
            }
        }
    }

    /* loaded from: classes3.dex */
    static class ServiceConnectedEvent {
        final IBinder BuiltInFictitiousFunctionClassFactory;
        final ComponentName getAuthRequestContext;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.getAuthRequestContext = componentName;
            this.BuiltInFictitiousFunctionClassFactory = iBinder;
        }
    }

    /* loaded from: classes6.dex */
    static class NotifyTask implements Task {
        final int BuiltInFictitiousFunctionClassFactory;
        final Notification KClassImpl$Data$declaredNonStaticMembers$2;
        final String MyBillsEntityDataFactory;
        final String getAuthRequestContext;

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void getAuthRequestContext(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", id:");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", tag:");
            sb.append(this.getAuthRequestContext);
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CancelTask implements Task {
        final String BuiltInFictitiousFunctionClassFactory;
        final boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
        final String PlaceComponentResult;
        final int getAuthRequestContext;

        CancelTask(String str, int i, String str2) {
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void getAuthRequestContext(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                iNotificationSideChannel.cancelAll(this.PlaceComponentResult);
            } else {
                iNotificationSideChannel.cancel(this.PlaceComponentResult, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CancelTask[");
            sb.append("packageName:");
            sb.append(this.PlaceComponentResult);
            sb.append(", id:");
            sb.append(this.getAuthRequestContext);
            sb.append(", tag:");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", all:");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("]");
            return sb.toString();
        }
    }
}
