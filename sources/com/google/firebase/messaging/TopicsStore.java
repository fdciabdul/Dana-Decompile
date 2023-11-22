package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class TopicsStore {
    private static final String DIVIDER_QUEUE_OPERATIONS = ",";
    static final String KEY_TOPIC_OPERATIONS_QUEUE = "topic_operation_queue";
    static final String PREFERENCES = "com.google.android.gms.appid";
    private static WeakReference<TopicsStore> topicsStoreWeakReference;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    private SharedPreferencesQueue topicOperationsQueue;

    private TopicsStore(SharedPreferences sharedPreferences, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPreferences;
    }

    private void initStore() {
        synchronized (this) {
            this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, KEY_TOPIC_OPERATIONS_QUEUE, DIVIDER_QUEUE_OPERATIONS, this.syncExecutor);
        }
    }

    public static TopicsStore getInstance(Context context, Executor executor) {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            topicsStore = weakReference != null ? weakReference.get() : null;
            if (topicsStore == null) {
                topicsStore = new TopicsStore(context.getSharedPreferences(PREFERENCES, 0), executor);
                topicsStore.initStore();
                topicsStoreWeakReference = new WeakReference<>(topicsStore);
            }
        }
        return topicsStore;
    }

    static void clearCaches() {
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final TopicOperation getNextTopicOperation() {
        TopicOperation from;
        synchronized (this) {
            from = TopicOperation.from(this.topicOperationsQueue.peek());
        }
        return from;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean addTopicOperation(TopicOperation topicOperation) {
        boolean add;
        synchronized (this) {
            add = this.topicOperationsQueue.add(topicOperation.serialize());
        }
        return add;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean removeTopicOperation(TopicOperation topicOperation) {
        boolean remove;
        synchronized (this) {
            remove = this.topicOperationsQueue.remove(topicOperation.serialize());
        }
        return remove;
    }

    final TopicOperation pollTopicOperation() {
        TopicOperation from;
        synchronized (this) {
            try {
                from = TopicOperation.from(this.topicOperationsQueue.remove());
            } catch (NoSuchElementException unused) {
                InstrumentInjector.log_e(Constants.TAG, "Polling operation queue failed");
                return null;
            }
        }
        return from;
    }

    final List<TopicOperation> getOperations() {
        ArrayList arrayList;
        synchronized (this) {
            List<String> list = this.topicOperationsQueue.toList();
            arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(TopicOperation.from(it.next()));
            }
        }
        return arrayList;
    }

    final void clearTopicOperations() {
        synchronized (this) {
            this.topicOperationsQueue.clear();
        }
    }
}
