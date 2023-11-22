package io.split.android.client.storage.common;

import java.util.List;

/* loaded from: classes6.dex */
public interface PersistentStorage<T> extends StoragePusher<T> {
    void delete(List<T> list);

    void deleteInvalid(long j);

    List<T> pop(int i);

    void pushMany(List<T> list);

    void setActive(List<T> list);
}
