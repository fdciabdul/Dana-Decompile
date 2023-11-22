package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;

/* loaded from: classes3.dex */
public class ParamBinder<T> implements Binder<BindingParam, T> {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f6044a;

    public ParamBinder(JSONObject jSONObject) {
        this.f6044a = jSONObject;
    }

    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public T bind(Class<T> cls, BindingParam bindingParam) throws BindException {
        String str;
        String[] value = bindingParam.value();
        if (value == null || value.length <= 0) {
            value = bindingParam.name();
        }
        if (value == null || value.length <= 0) {
            throw new BindException("bind key is null");
        }
        try {
            int length = value.length;
            str = null;
            T t = null;
            int i = 0;
            while (i < length) {
                try {
                    str = value[i];
                    JSONObject jSONObject = this.f6044a;
                    t = jSONObject == null ? null : jSONObject.getObject(str, cls);
                    if (t != null) {
                        break;
                    }
                    i++;
                    t = t;
                } catch (JSONException e) {
                    e = e;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Binding targetType: ");
                    sb.append(cls);
                    sb.append(" with: ");
                    sb.append(this.f6044a);
                    sb.append(" key: ");
                    sb.append(str);
                    sb.append(" exception!");
                    ExtHubLogger.e("AriverKernel", sb.toString(), e);
                    throw new BindException(e.getMessage());
                }
            }
            if (t == null) {
                if (bindingParam.required()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(value[0]);
                    sb2.append(" param is missing!");
                    throw new RequiredParamNotFoundException(sb2.toString());
                } else if (!cls.isPrimitive()) {
                    return cls == String.class ? (T) TypeUtils.castToJavaBean(bindingParam.stringDefault(), cls) : t;
                } else if (cls == Boolean.TYPE) {
                    return (T) TypeUtils.castToJavaBean(Boolean.valueOf(bindingParam.booleanDefault()), cls);
                } else {
                    if (cls == Integer.TYPE) {
                        return (T) TypeUtils.castToJavaBean(Integer.valueOf(bindingParam.intDefault()), cls);
                    }
                    if (cls == Float.TYPE) {
                        return (T) TypeUtils.castToJavaBean(Float.valueOf(bindingParam.floatDefault()), cls);
                    }
                    if (cls == Double.TYPE) {
                        return (T) TypeUtils.castToJavaBean(Double.valueOf(bindingParam.doubleDefault()), cls);
                    }
                    return cls == Long.TYPE ? (T) TypeUtils.castToJavaBean(Long.valueOf(bindingParam.longDefault()), cls) : t;
                }
            }
            return t;
        } catch (JSONException e2) {
            e = e2;
            str = null;
        }
    }
}
