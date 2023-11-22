package io.split.android.client.service.sseclient.reactor;

/* loaded from: classes6.dex */
public interface MySegmentsUpdateWorkerRegistry {
    void registerMySegmentsUpdateWorker(String str, MySegmentsUpdateWorker mySegmentsUpdateWorker);

    void start();

    void stop();

    void unregisterMySegmentsUpdateWorker(String str);
}
