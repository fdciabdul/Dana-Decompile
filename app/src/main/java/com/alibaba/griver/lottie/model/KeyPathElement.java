package com.alibaba.griver.lottie.model;

import com.alibaba.griver.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes6.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback);

    void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2);
}
