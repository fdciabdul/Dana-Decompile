package id.dana.lib.toggle.result;

import com.alibaba.fastjson.JSON;

/* loaded from: classes5.dex */
public class ConfigResult<T> implements FlagResult<T> {
    public static T MyBillsEntityDataFactory(String str, Class<T> cls) {
        return (T) JSON.parseObject(str, cls);
    }
}
