package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.iap.ac.android.rpc.RpcInvocationHandler;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Rpc {
    private static int zza;
    private static PendingIntent zzb;
    private static final Executor zzc = new Executor() { // from class: com.google.android.gms.cloudmessaging.zzz
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };
    private static final Pattern zzd = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    private final Context zzf;
    private final zzt zzg;
    private final ScheduledExecutorService zzh;
    private Messenger zzj;
    private zzd zzk;
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zze = new SimpleArrayMap<>();
    private Messenger zzi = new Messenger(new zzaa(this, Looper.getMainLooper()));

    public Rpc(Context context) {
        this.zzf = context;
        this.zzg = new zzt(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzh = scheduledThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Task zza(Bundle bundle) throws Exception {
        if (zzi(bundle)) {
            return Tasks.forResult(null);
        }
        return Tasks.forResult(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(Rpc rpc, Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            InstrumentInjector.log_w(RpcInvocationHandler.TAG, "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new zzc());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof zzd) {
                rpc.zzk = (zzd) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                rpc.zzj = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            if (Log.isLoggable(RpcInvocationHandler.TAG, 3)) {
                String valueOf = String.valueOf(action);
                InstrumentInjector.log_d(RpcInvocationHandler.TAG, valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                return;
            }
            return;
        }
        String stringExtra = intent2.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent2.getStringExtra("unregistered");
        }
        if (stringExtra == null) {
            String stringExtra2 = intent2.getStringExtra("error");
            if (stringExtra2 == null) {
                String valueOf2 = String.valueOf(intent2.getExtras());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 49);
                sb.append("Unexpected response, no error or registration id ");
                sb.append(valueOf2);
                InstrumentInjector.log_w(RpcInvocationHandler.TAG, sb.toString());
                return;
            }
            if (Log.isLoggable(RpcInvocationHandler.TAG, 3)) {
                InstrumentInjector.log_d(RpcInvocationHandler.TAG, stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
            }
            if (stringExtra2.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                String[] split = stringExtra2.split("\\|");
                if (split.length <= 2 || !"ID".equals(split[1])) {
                    InstrumentInjector.log_w(RpcInvocationHandler.TAG, stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                    return;
                }
                String str = split[2];
                String str2 = split[3];
                if (str2.startsWith(":")) {
                    str2 = str2.substring(1);
                }
                rpc.zzh(str, intent2.putExtra("error", str2).getExtras());
                return;
            }
            synchronized (rpc.zze) {
                for (int i = 0; i < rpc.zze.size(); i++) {
                    rpc.zzh((String) rpc.zze.moveToNextValue[i << 1], intent2.getExtras());
                }
            }
            return;
        }
        Matcher matcher = zzd.matcher(stringExtra);
        if (!matcher.matches()) {
            if (Log.isLoggable(RpcInvocationHandler.TAG, 3)) {
                InstrumentInjector.log_d(RpcInvocationHandler.TAG, stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                return;
            }
            return;
        }
        String group = matcher.group(1);
        String group2 = matcher.group(2);
        if (group != null) {
            Bundle extras = intent2.getExtras();
            extras.putString("registration_id", group2);
            rpc.zzh(group, extras);
        }
    }

    private final Task<Bundle> zze(Bundle bundle) {
        final String zzf = zzf();
        final TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.zze) {
            this.zze.put(zzf, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.zzg.zzb() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        zzg(this.zzf, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(zzf).length() + 5);
        sb.append("|ID|");
        sb.append(zzf);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable(RpcInvocationHandler.TAG, 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 8);
            sb2.append("Sending ");
            sb2.append(valueOf);
            InstrumentInjector.log_d(RpcInvocationHandler.TAG, sb2.toString());
        }
        intent.putExtra("google.messenger", this.zzi);
        if (this.zzj != null || this.zzk != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.zzj;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.zzk.zzb(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable(RpcInvocationHandler.TAG, 3)) {
                    InstrumentInjector.log_d(RpcInvocationHandler.TAG, "Messenger failed, fallback to startService");
                }
            }
            final ScheduledFuture<?> schedule = this.zzh.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzy
                @Override // java.lang.Runnable
                public final void run() {
                    if (TaskCompletionSource.this.trySetException(new IOException("TIMEOUT"))) {
                        InstrumentInjector.log_w(RpcInvocationHandler.TAG, "No response");
                    }
                }
            }, 30L, TimeUnit.SECONDS);
            taskCompletionSource.getTask().addOnCompleteListener(zzc, new OnCompleteListener() { // from class: com.google.android.gms.cloudmessaging.zzw
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Rpc.this.zzd(zzf, schedule, task);
                }
            });
            return taskCompletionSource.getTask();
        }
        if (this.zzg.zzb() == 2) {
            this.zzf.sendBroadcast(intent);
        } else {
            this.zzf.startService(intent);
        }
        final ScheduledFuture schedule2 = this.zzh.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzy
            @Override // java.lang.Runnable
            public final void run() {
                if (TaskCompletionSource.this.trySetException(new IOException("TIMEOUT"))) {
                    InstrumentInjector.log_w(RpcInvocationHandler.TAG, "No response");
                }
            }
        }, 30L, TimeUnit.SECONDS);
        taskCompletionSource.getTask().addOnCompleteListener(zzc, new OnCompleteListener() { // from class: com.google.android.gms.cloudmessaging.zzw
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                Rpc.this.zzd(zzf, schedule2, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    private static String zzf() {
        String num;
        synchronized (Rpc.class) {
            int i = zza;
            zza = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private static void zzg(Context context, Intent intent) {
        synchronized (Rpc.class) {
            if (zzb == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzb = com.google.android.gms.internal.cloudmessaging.zza.zza(context, 0, intent2, com.google.android.gms.internal.cloudmessaging.zza.zza);
            }
            intent.putExtra(GriverOnPreloadExtension.PARAMS_APP, zzb);
        }
    }

    private final void zzh(String str, Bundle bundle) {
        synchronized (this.zze) {
            TaskCompletionSource<Bundle> remove = this.zze.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                InstrumentInjector.log_w(RpcInvocationHandler.TAG, valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.setResult(bundle);
        }
    }

    private static boolean zzi(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    public Task<Bundle> send(final Bundle bundle) {
        if (this.zzg.zza() < 12000000) {
            if (this.zzg.zzb() == 0) {
                return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            return zze(bundle).continueWithTask(zzc, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzu
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Rpc.this.zzb(bundle, task);
                }
            });
        }
        return zzs.zzb(this.zzf).zzd(1, bundle).continueWith(zzc, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzv
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                if (task.isSuccessful()) {
                    return (Bundle) task.getResult();
                }
                if (Log.isLoggable(RpcInvocationHandler.TAG, 3)) {
                    String valueOf = String.valueOf(task.getException());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                    sb.append("Error making request: ");
                    sb.append(valueOf);
                    InstrumentInjector.log_d(RpcInvocationHandler.TAG, sb.toString());
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", task.getException());
            }
        });
    }

    public final /* synthetic */ Task zzb(Bundle bundle, Task task) throws Exception {
        return (task.isSuccessful() && zzi((Bundle) task.getResult())) ? zze(bundle).onSuccessTask(zzc, new SuccessContinuation() { // from class: com.google.android.gms.cloudmessaging.zzx
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Rpc.zza((Bundle) obj);
            }
        }) : task;
    }

    public final /* synthetic */ void zzd(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.zze) {
            this.zze.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
