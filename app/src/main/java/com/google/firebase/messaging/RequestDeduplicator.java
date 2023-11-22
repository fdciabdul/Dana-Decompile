package com.google.firebase.messaging;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RequestDeduplicator {
    private final Executor executor;
    private final Map<String, Task<String>> getTokenRequests = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface GetTokenRequest {
        Task<String> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestDeduplicator(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public Task<String> getOrStartGetTokenRequest(final String str, GetTokenRequest getTokenRequest) {
        synchronized (this) {
            Task<String> task = this.getTokenRequests.get(str);
            if (task != null) {
                if (Log.isLoggable(Constants.TAG, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Joining ongoing request for: ");
                    sb.append(str);
                    InstrumentInjector.log_d(Constants.TAG, sb.toString());
                }
                return task;
            }
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Making new request for: ");
                sb2.append(str);
                InstrumentInjector.log_d(Constants.TAG, sb2.toString());
            }
            Task continueWithTask = getTokenRequest.start().continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.messaging.RequestDeduplicator$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    return RequestDeduplicator.this.m181x7161fc54(str, task2);
                }
            });
            this.getTokenRequests.put(str, continueWithTask);
            return continueWithTask;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getOrStartGetTokenRequest$0$com-google-firebase-messaging-RequestDeduplicator  reason: not valid java name */
    public /* synthetic */ Task m181x7161fc54(String str, Task task) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return task;
    }
}
