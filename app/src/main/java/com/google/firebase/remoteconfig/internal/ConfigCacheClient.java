package com.google.firebase.remoteconfig.internal;

import androidx.credentials.CredentialManager$$ExternalSyntheticLambda0;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class ConfigCacheClient {
    static final long DISK_READ_TIMEOUT_IN_SECONDS = 5;
    private Task<ConfigContainer> cachedContainerTask = null;
    private final ExecutorService executorService;
    private final ConfigStorageClient storageClient;
    private static final Map<String, ConfigCacheClient> clientInstances = new HashMap();
    private static final Executor DIRECT_EXECUTOR = new CredentialManager$$ExternalSyntheticLambda0();

    private ConfigCacheClient(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        this.executorService = executorService;
        this.storageClient = configStorageClient;
    }

    public ConfigContainer getBlocking() {
        return getBlocking(5L);
    }

    ConfigContainer getBlocking(long j) {
        synchronized (this) {
            Task<ConfigContainer> task = this.cachedContainerTask;
            if (task != null && task.isSuccessful()) {
                return this.cachedContainerTask.getResult();
            }
            try {
                return (ConfigContainer) await(get(), j, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                InstrumentInjector.log_d(FirebaseRemoteConfig.TAG, "Reading from storage file failed.", e);
                return null;
            }
        }
    }

    public Task<ConfigContainer> put(ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$put$0$com-google-firebase-remoteconfig-internal-ConfigCacheClient  reason: not valid java name */
    public /* synthetic */ Void m204xddaae01c(ConfigContainer configContainer) throws Exception {
        return this.storageClient.write(configContainer);
    }

    public Task<ConfigContainer> put(final ConfigContainer configContainer, final boolean z) {
        return Tasks.call(this.executorService, new Callable() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConfigCacheClient.this.m204xddaae01c(configContainer);
            }
        }).onSuccessTask(this.executorService, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return ConfigCacheClient.this.m205x9820809d(z, configContainer, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$put$1$com-google-firebase-remoteconfig-internal-ConfigCacheClient  reason: not valid java name */
    public /* synthetic */ Task m205x9820809d(boolean z, ConfigContainer configContainer, Void r3) throws Exception {
        if (z) {
            updateInMemoryConfigContainer(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    public Task<ConfigContainer> get() {
        Task<ConfigContainer> task;
        synchronized (this) {
            Task<ConfigContainer> task2 = this.cachedContainerTask;
            if (task2 == null || (task2.isComplete() && !this.cachedContainerTask.isSuccessful())) {
                ExecutorService executorService = this.executorService;
                final ConfigStorageClient configStorageClient = this.storageClient;
                Objects.requireNonNull(configStorageClient);
                this.cachedContainerTask = Tasks.call(executorService, new Callable() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return ConfigStorageClient.this.read();
                    }
                });
            }
            task = this.cachedContainerTask;
        }
        return task;
    }

    public void clear() {
        synchronized (this) {
            this.cachedContainerTask = Tasks.forResult(null);
        }
        this.storageClient.clear();
    }

    private void updateInMemoryConfigContainer(ConfigContainer configContainer) {
        synchronized (this) {
            this.cachedContainerTask = Tasks.forResult(configContainer);
        }
    }

    Task<ConfigContainer> getCachedContainerTask() {
        Task<ConfigContainer> task;
        synchronized (this) {
            task = this.cachedContainerTask;
        }
        return task;
    }

    public static ConfigCacheClient getInstance(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            String fileName = configStorageClient.getFileName();
            Map<String, ConfigCacheClient> map = clientInstances;
            if (!map.containsKey(fileName)) {
                map.put(fileName, new ConfigCacheClient(executorService, configStorageClient));
            }
            configCacheClient = map.get(fileName);
        }
        return configCacheClient;
    }

    public static void clearInstancesForTest() {
        synchronized (ConfigCacheClient.class) {
            clientInstances.clear();
        }
    }

    private static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = DIRECT_EXECUTOR;
        task.addOnSuccessListener(executor, awaitListener);
        task.addOnFailureListener(executor, awaitListener);
        task.addOnCanceledListener(executor, awaitListener);
        if (!awaitListener.await(j, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AwaitListener<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {
        private final CountDownLatch latch;

        private AwaitListener() {
            this.latch = new CountDownLatch(1);
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(TResult tresult) {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            this.latch.countDown();
        }

        public void await() throws InterruptedException {
            this.latch.await();
        }

        public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.latch.await(j, timeUnit);
        }
    }
}
