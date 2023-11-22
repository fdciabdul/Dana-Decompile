package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
class WithinAppServiceConnection implements ServiceConnection {
    private static final int REQUEST_TIMEOUT_MS = 9000;
    private WithinAppServiceBinder binder;
    private boolean connectionInProgress;
    private final Intent connectionIntent;
    private final Context context;
    private final Queue<BindRequest> intentQueue;
    private final ScheduledExecutorService scheduledExecutorService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class BindRequest {
        final Intent intent;
        private final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();

        BindRequest(Intent intent) {
            this.intent = intent;
        }

        void arrangeTimeout(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.messaging.WithinAppServiceConnection$BindRequest$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WithinAppServiceConnection.BindRequest.this.m182x9cf97a38();
                }
            }, (this.intent.getFlags() & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? WakeLockHolder.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS : 9000L, TimeUnit.MILLISECONDS);
            getTask().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: com.google.firebase.messaging.WithinAppServiceConnection$BindRequest$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    schedule.cancel(false);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$arrangeTimeout$0$com-google-firebase-messaging-WithinAppServiceConnection$BindRequest  reason: not valid java name */
        public /* synthetic */ void m182x9cf97a38() {
            StringBuilder sb = new StringBuilder();
            sb.append("Service took too long to process intent: ");
            sb.append(this.intent.getAction());
            sb.append(" Releasing WakeLock.");
            InstrumentInjector.log_w(Constants.TAG, sb.toString());
            finish();
        }

        Task<Void> getTask() {
            return this.taskCompletionSource.getTask();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void finish() {
            this.taskCompletionSource.trySetResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WithinAppServiceConnection(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    WithinAppServiceConnection(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent(str).setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> sendIntent(Intent intent) {
        Task<Void> task;
        synchronized (this) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                InstrumentInjector.log_d(Constants.TAG, "new intent queued in the bind-strategy delivery");
            }
            BindRequest bindRequest = new BindRequest(intent);
            bindRequest.arrangeTimeout(this.scheduledExecutorService);
            this.intentQueue.add(bindRequest);
            flushQueue();
            task = bindRequest.getTask();
        }
        return task;
    }

    private void flushQueue() {
        synchronized (this) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                InstrumentInjector.log_d(Constants.TAG, "flush queue called");
            }
            while (!this.intentQueue.isEmpty()) {
                if (Log.isLoggable(Constants.TAG, 3)) {
                    InstrumentInjector.log_d(Constants.TAG, "found intent to be delivered");
                }
                WithinAppServiceBinder withinAppServiceBinder = this.binder;
                if (withinAppServiceBinder != null && withinAppServiceBinder.isBinderAlive()) {
                    if (Log.isLoggable(Constants.TAG, 3)) {
                        InstrumentInjector.log_d(Constants.TAG, "binder is alive, sending the intent.");
                    }
                    this.binder.send(this.intentQueue.poll());
                } else {
                    startConnectionIfNeeded();
                    return;
                }
            }
        }
    }

    private void startConnectionIfNeeded() {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.connectionInProgress);
            InstrumentInjector.log_d(Constants.TAG, sb.toString());
        }
        if (this.connectionInProgress) {
            return;
        }
        this.connectionInProgress = true;
        try {
        } catch (SecurityException e) {
            InstrumentInjector.log_e(Constants.TAG, "Exception while binding the service", e);
        }
        if (ConnectionTracker.getInstance().bindService(this.context, this.connectionIntent, this, 65)) {
            return;
        }
        InstrumentInjector.log_e(Constants.TAG, "binding to the service failed");
        this.connectionInProgress = false;
        finishAllInQueue();
    }

    private void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("onServiceConnected: ");
                sb.append(componentName);
                InstrumentInjector.log_d(Constants.TAG, sb.toString());
            }
            this.connectionInProgress = false;
            if (!(iBinder instanceof WithinAppServiceBinder)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid service connection: ");
                sb2.append(iBinder);
                InstrumentInjector.log_e(Constants.TAG, sb2.toString());
                finishAllInQueue();
                return;
            }
            this.binder = (WithinAppServiceBinder) iBinder;
            flushQueue();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onServiceDisconnected: ");
            sb.append(componentName);
            InstrumentInjector.log_d(Constants.TAG, sb.toString());
        }
        flushQueue();
    }
}
