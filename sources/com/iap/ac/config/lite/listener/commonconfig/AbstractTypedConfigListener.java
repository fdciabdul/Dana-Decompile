package com.iap.ac.config.lite.listener.commonconfig;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.listener.ConfigChangeType;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class AbstractTypedConfigListener<T> implements ICommonConfigListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7648a = e.b("ConfigChangeListener");
    protected Class<T> mTypedClazz;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTypedConfigListener(Class<T> cls) {
        this.mTypedClazz = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.iap.ac.config.lite.listener.commonconfig.ICommonConfigListener
    public void onCommonConfigChanged(String str, Object obj, ConfigChangeType configChangeType) {
        if (this.mTypedClazz.isInstance(obj)) {
            onConfigChangedInternal(str, obj);
        } else if (obj != 0 && obj != JSONObject.NULL) {
            onConfigValueTypeNotConform(str, obj);
        } else {
            onConfigChangedInternal(str, null);
        }
    }

    protected abstract void onConfigChangedInternal(String str, T t);

    protected void onConfigValueTypeNotConform(String str, Object obj) {
        String str2 = f7648a;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = obj != null ? obj.getClass().getSimpleName() : "null";
        ACLog.e(str2, String.format("onConfigValueTypeNotConform: key = %s, valueClass = %s.", objArr));
    }
}
