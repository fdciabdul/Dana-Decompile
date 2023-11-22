package com.alibaba.ariver.engine.common.extension.bind;

import java.lang.annotation.Annotation;

/* loaded from: classes3.dex */
public interface Binder<A extends Annotation, T> {
    T bind(Class<T> cls, A a2) throws BindException;
}
