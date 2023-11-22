package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<ReflectionAccessFilter> list) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        this.reflectionFilters = list;
    }

    private boolean includeField(Field field, boolean z) {
        return (this.excluder.excludeClass(field.getType(), z) || this.excluder.excludeField(field, z)) ? false : true;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
            if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                StringBuilder sb = new StringBuilder();
                sb.append("ReflectionAccessFilter does not permit using reflection for ");
                sb.append(rawType);
                sb.append(". Register a TypeAdapter for this type or adjust the access filter.");
                throw new JsonIOException(sb.toString());
            }
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType, filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE));
        }
        return null;
    }

    public static void checkAccessible(Object obj, Field field) {
        if (Modifier.isStatic(field.getModifiers())) {
            obj = null;
        }
        if (ReflectionAccessFilterHelper.canAccess(field, obj)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Field '");
        sb.append(field.getDeclaringClass().getName());
        sb.append("#");
        sb.append(field.getName());
        sb.append("' is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type or adjust the access filter.");
        throw new JsonIOException(sb.toString());
    }

    private BoundField createBoundField(final Gson gson, final Field field, String str, final TypeToken<?> typeToken, boolean z, boolean z2, final boolean z3) {
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        final boolean z4 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        final TypeAdapter<?> typeAdapter2 = typeAdapter;
        return new BoundField(str, z, z2) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            {
                ReflectiveTypeAdapterFactory.this = this;
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                if (this.serialized) {
                    if (z3) {
                        ReflectiveTypeAdapterFactory.checkAccessible(obj, field);
                    }
                    Object obj2 = field.get(obj);
                    if (obj2 == obj) {
                        return;
                    }
                    jsonWriter.name(this.name);
                    (z4 ? typeAdapter2 : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, typeToken.getType())).write(jsonWriter, obj2);
                }
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read2 = typeAdapter2.read2(jsonReader);
                if (read2 == null && isPrimitive) {
                    return;
                }
                if (z3) {
                    ReflectiveTypeAdapterFactory.checkAccessible(obj, field);
                }
                field.set(obj, read2);
            }
        };
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls, boolean z) {
        boolean z2;
        int i;
        int i2;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Class<?> cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        boolean z3 = z;
        Class<?> cls3 = cls2;
        while (cls3 != Object.class) {
            Field[] declaredFields = cls3.getDeclaredFields();
            boolean z4 = true;
            boolean z5 = false;
            if (cls3 == cls2 || declaredFields.length <= 0) {
                z2 = z3;
            } else {
                ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(reflectiveTypeAdapterFactory.reflectionFilters, cls3);
                if (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ReflectionAccessFilter does not permit using reflection for ");
                    sb.append(cls3);
                    sb.append(" (supertype of ");
                    sb.append(cls2);
                    sb.append("). Register a TypeAdapter for this type or adjust the access filter.");
                    throw new JsonIOException(sb.toString());
                }
                z2 = filterResult == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE;
            }
            int length = declaredFields.length;
            int i3 = 0;
            while (i3 < length) {
                Field field = declaredFields[i3];
                boolean includeField = reflectiveTypeAdapterFactory.includeField(field, z4);
                boolean includeField2 = reflectiveTypeAdapterFactory.includeField(field, z5);
                if (includeField || includeField2) {
                    if (!z2) {
                        ReflectionHelper.makeAccessible(field);
                    }
                    Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls3, field.getGenericType());
                    List<String> fieldNames = reflectiveTypeAdapterFactory.getFieldNames(field);
                    BoundField boundField = null;
                    int size = fieldNames.size();
                    int i4 = 0;
                    while (i4 < size) {
                        String str = fieldNames.get(i4);
                        boolean z6 = i4 != 0 ? false : includeField;
                        BoundField boundField2 = boundField;
                        int i5 = size;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        int i6 = i3;
                        int i7 = length;
                        boundField = boundField2 == null ? (BoundField) linkedHashMap.put(str, createBoundField(gson, field, str, TypeToken.get(resolve), z6, includeField2, z2)) : boundField2;
                        i4++;
                        includeField = z6;
                        i3 = i6;
                        size = i5;
                        fieldNames = list;
                        field = field2;
                        length = i7;
                    }
                    BoundField boundField3 = boundField;
                    i = i3;
                    i2 = length;
                    if (boundField3 != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(type);
                        sb2.append(" declares multiple JSON fields named ");
                        sb2.append(boundField3.name);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                } else {
                    i = i3;
                    i2 = length;
                }
                i3 = i + 1;
                z5 = false;
                z4 = true;
                reflectiveTypeAdapterFactory = this;
                length = i2;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls3, cls3.getGenericSuperclass()));
            cls3 = typeToken2.getRawType();
            reflectiveTypeAdapterFactory = this;
            cls2 = cls;
            z3 = z2;
        }
        return linkedHashMap;
    }

    /* loaded from: classes3.dex */
    public static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public final T read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField != null && boundField.deserialized) {
                        boundField.read(jsonReader, construct);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                Iterator<BoundField> it = this.boundFields.values().iterator();
                while (it.hasNext()) {
                    it.next().write(jsonWriter, t);
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
            }
        }
    }
}
