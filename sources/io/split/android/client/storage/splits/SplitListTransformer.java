package io.split.android.client.storage.splits;

import java.util.List;

/* loaded from: classes6.dex */
public interface SplitListTransformer<I, O> {
    List<O> transform(List<I> list);
}
