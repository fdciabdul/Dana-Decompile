package id.dana.data.storage;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface SerializerFacade {
    <T> T deserialize(String str, Class<T> cls);

    List<String> deserializeList(String str);

    Map<String, String> deserializeMap(String str);

    String serialize(Object obj);

    String serialize(Object obj, Class cls);
}
