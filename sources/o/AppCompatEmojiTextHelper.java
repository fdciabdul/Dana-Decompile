package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes3.dex */
public final class AppCompatEmojiTextHelper {
    public static TypeAdapter getAuthRequestContext(Gson gson, TypeToken typeToken, Object obj) {
        Type type = typeToken.getType();
        Class<?> cls = (obj == null || !(type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) ? type : obj.getClass();
        TypeAdapter adapter = gson.getAdapter(TypeToken.get(cls));
        if (type != cls && !MyBillsEntityDataFactory(adapter)) {
            TypeAdapter adapter2 = gson.getAdapter(typeToken);
            if (MyBillsEntityDataFactory(adapter2)) {
                return adapter2;
            }
        }
        return adapter;
    }

    private static boolean MyBillsEntityDataFactory(TypeAdapter typeAdapter) {
        return ((typeAdapter instanceof G) || (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter)) ? false : true;
    }

    public static TypeAdapter getAuthRequestContext(Gson gson, Class cls, Object obj) {
        Class<?> cls2 = (obj == null || !(cls == Object.class || (cls instanceof Class))) ? cls : obj.getClass();
        TypeAdapter adapter = gson.getAdapter(TypeToken.get((Type) cls2));
        if (cls != cls2 && !MyBillsEntityDataFactory(adapter)) {
            TypeAdapter adapter2 = gson.getAdapter(cls);
            if (MyBillsEntityDataFactory(adapter2)) {
                return adapter2;
            }
        }
        return adapter;
    }
}
