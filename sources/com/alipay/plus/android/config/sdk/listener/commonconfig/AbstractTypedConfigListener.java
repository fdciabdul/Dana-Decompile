package com.alipay.plus.android.config.sdk.listener.commonconfig;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.listener.ConfigChangeType;

/* loaded from: classes7.dex */
public abstract class AbstractTypedConfigListener<T> implements ICommonConfigListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7371a = e.a("ConfigChangeListener");
    protected Class<T> mTypedClazz;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTypedConfigListener(Class<T> cls) {
        this.mTypedClazz = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alipay.plus.android.config.sdk.listener.commonconfig.ICommonConfigListener
    public void onCommonConfigChanged(String str, Object obj, ConfigChangeType configChangeType) {
        if (obj == 0 || this.mTypedClazz.isInstance(obj)) {
            onConfigChangedInternal(str, obj);
        } else {
            onConfigValueTypeNotConform(str, obj);
        }
    }

    protected abstract void onConfigChangedInternal(String str, T t);

    protected void onConfigValueTypeNotConform(String str, Object obj) {
        String str2 = f7371a;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = obj != null ? obj.getClass().getSimpleName() : "null";
        LoggerWrapper.e(str2, String.format("onConfigValueTypeNotConform: key = %s, valueClass = %s.", objArr));
    }
}
