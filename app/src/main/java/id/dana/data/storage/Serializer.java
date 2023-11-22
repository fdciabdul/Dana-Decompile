package id.dana.data.storage;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import id.dana.utils.extension.JSONExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class Serializer implements SerializerFacade {
    @Inject
    public Serializer() {
    }

    private boolean isBlank(String str) {
        return str == null || str.length() <= 0;
    }

    @Override // id.dana.data.storage.SerializerFacade
    public String serialize(Object obj, Class cls) {
        try {
            return JSON.toJSONString(obj);
        } catch (JSONException e) {
            if (isWriteJavaBeanError(e)) {
                return JSONExtKt.PlaceComponentResult().toJson(obj);
            }
            throw e;
        }
    }

    @Override // id.dana.data.storage.SerializerFacade
    public String serialize(Object obj) {
        return serialize(obj, null);
    }

    @Override // id.dana.data.storage.SerializerFacade
    public <T> T deserialize(String str, Class<T> cls) {
        try {
            return (T) JSON.parseObject(str, cls);
        } catch (JSONException e) {
            if (isNoDefaultConstructorError(e)) {
                return (T) JSONExtKt.PlaceComponentResult().fromJson(str, (Class) cls);
            }
            throw e;
        }
    }

    @Override // id.dana.data.storage.SerializerFacade
    public Map<String, String> deserializeMap(String str) {
        return isBlank(str) ? new HashMap() : (Map) JSON.parseObject(str, new TypeReference<Map<String, String>>() { // from class: id.dana.data.storage.Serializer.1
        }, new Feature[0]);
    }

    @Override // id.dana.data.storage.SerializerFacade
    public List<String> deserializeList(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() != 0) {
            JSONArray parseArray = JSON.parseArray(str);
            for (int i = 0; i < parseArray.size(); i++) {
                arrayList.add(parseArray.getString(i));
            }
        }
        return arrayList;
    }

    private boolean isNoDefaultConstructorError(Exception exc) {
        return (exc instanceof JSONException) && exc.getMessage() != null && exc.getMessage().contains("default constructor not found");
    }

    private boolean isWriteJavaBeanError(Exception exc) {
        return (exc instanceof JSONException) && exc.getMessage() != null && exc.getMessage().contains("write javaBean error");
    }

    public Map<String, Integer> deserializeMaps(String str) {
        return isBlank(str) ? new HashMap() : (Map) JSON.parseObject(str, new TypeReference<Map<String, Integer>>() { // from class: id.dana.data.storage.Serializer.2
        }, new Feature[0]);
    }

    public <T> List<T> deserializeList(String str, Class<T> cls) {
        return TextUtils.isEmpty(str) ? new ArrayList() : JSON.parseArray(str, cls);
    }
}
