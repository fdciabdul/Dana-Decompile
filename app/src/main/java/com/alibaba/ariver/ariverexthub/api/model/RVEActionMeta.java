package com.alibaba.ariver.ariverexthub.api.model;

import com.alibaba.ariver.ariverexthub.api.RVEApiHandler;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class RVEActionMeta {
    public Method actionMethod;
    public String actionName;
    public Class<? extends RVEApiHandler> handlerClazz;
    public Annotation[][] paramAnnotationArray;
    public Class[] paramTypes;
}
