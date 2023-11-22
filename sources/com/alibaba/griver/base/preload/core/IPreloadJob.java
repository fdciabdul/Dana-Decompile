package com.alibaba.griver.base.preload.core;

import com.alibaba.griver.base.preload.core.PreloadScheduler;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IPreloadJob<T> {
    String getJobName();

    Class<T> getResultClazz();

    T preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType);
}
