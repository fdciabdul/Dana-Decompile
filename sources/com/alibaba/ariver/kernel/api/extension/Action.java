package com.alibaba.ariver.kernel.api.extension;

import java.util.List;

/* loaded from: classes3.dex */
public interface Action {

    /* loaded from: classes3.dex */
    public interface Complete<T> extends Action {
        void onComplete(T t);
    }

    /* loaded from: classes6.dex */
    public interface Exception extends Action {
        void onException(Extension extension, Throwable th);
    }

    /* loaded from: classes6.dex */
    public interface Interrupt extends Action {
        void onInterrupt(Extension extension);
    }

    /* loaded from: classes6.dex */
    public interface Progress<T> extends Action {
        void onProgress(Extension extension, T t);
    }

    /* loaded from: classes3.dex */
    public interface Start extends Action {
        void onStart(List<Extension> list);
    }
}
