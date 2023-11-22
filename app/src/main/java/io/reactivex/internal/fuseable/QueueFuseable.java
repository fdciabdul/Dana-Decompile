package io.reactivex.internal.fuseable;

/* loaded from: classes.dex */
public interface QueueFuseable<T> extends SimpleQueue<T> {
    int requestFusion(int i);
}
