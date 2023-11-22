package io.split.android.client.storage.common;

/* loaded from: classes6.dex */
public interface Storage<T> {
    void clearInMemory();

    void enablePersistence(boolean z);

    void push(T t);
}
