package com.j256.ormlite.field;

import com.j256.ormlite.field.types.EnumStringType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class DataPersisterManager {
    private static final DataPersister DEFAULT_ENUM_PERSISTER = EnumStringType.getSingleton();
    private static List<DataPersister> registeredPersisters = null;
    private static final Map<String, DataPersister> builtInMap = new HashMap();

    static {
        for (DataType dataType : DataType.values()) {
            DataPersister dataPersister = dataType.getDataPersister();
            if (dataPersister != null) {
                for (Class<?> cls : dataPersister.getAssociatedClasses()) {
                    builtInMap.put(cls.getName(), dataPersister);
                }
                if (dataPersister.getAssociatedClassNames() != null) {
                    for (String str : dataPersister.getAssociatedClassNames()) {
                        builtInMap.put(str, dataPersister);
                    }
                }
            }
        }
    }

    private DataPersisterManager() {
    }

    public static void registerDataPersisters(DataPersister... dataPersisterArr) {
        ArrayList arrayList = new ArrayList();
        List<DataPersister> list = registeredPersisters;
        if (list != null) {
            arrayList.addAll(list);
        }
        for (DataPersister dataPersister : dataPersisterArr) {
            arrayList.add(dataPersister);
        }
        registeredPersisters = arrayList;
    }

    public static void clear() {
        registeredPersisters = null;
    }

    public static DataPersister lookupForField(Field field) {
        List<DataPersister> list = registeredPersisters;
        if (list != null) {
            for (DataPersister dataPersister : list) {
                if (dataPersister.isValidForField(field)) {
                    return dataPersister;
                }
                for (Class<?> cls : dataPersister.getAssociatedClasses()) {
                    if (field.getType() == cls) {
                        return dataPersister;
                    }
                }
            }
        }
        DataPersister dataPersister2 = builtInMap.get(field.getType().getName());
        if (dataPersister2 != null) {
            return dataPersister2;
        }
        if (field.getType().isEnum()) {
            return DEFAULT_ENUM_PERSISTER;
        }
        return null;
    }
}
