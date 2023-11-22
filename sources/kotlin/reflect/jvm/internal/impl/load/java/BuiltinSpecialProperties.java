package kotlin.reflect.jvm.internal.impl.load.java;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* loaded from: classes.dex */
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    static {
        FqName childSafe;
        FqName childSafe2;
        FqName child;
        FqName child2;
        FqName childSafe3;
        FqName child3;
        FqName child4;
        FqName child5;
        childSafe = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames._enum, "name");
        childSafe2 = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames._enum, "ordinal");
        child = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.collection, GriverMonitorConstants.KEY_SIZE);
        child2 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, GriverMonitorConstants.KEY_SIZE);
        childSafe3 = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames.charSequence, "length");
        child3 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, UserMetadata.KEYDATA_FILENAME);
        child4 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "values");
        child5 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, RemoteConfigConstants.ResponseFieldKey.ENTRIES);
        Map<FqName, Name> mapOf = MapsKt.mapOf(TuplesKt.to(childSafe, Name.identifier("name")), TuplesKt.to(childSafe2, Name.identifier("ordinal")), TuplesKt.to(child, Name.identifier(GriverMonitorConstants.KEY_SIZE)), TuplesKt.to(child2, Name.identifier(GriverMonitorConstants.KEY_SIZE)), TuplesKt.to(childSafe3, Name.identifier("length")), TuplesKt.to(child3, Name.identifier("keySet")), TuplesKt.to(child4, Name.identifier("values")), TuplesKt.to(child5, Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapOf;
        Set<Map.Entry<FqName, Name>> entrySet = mapOf.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), CollectionsKt.distinct((Iterable) entry2.getValue()));
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap2;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        Set<FqName> set = keySet;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((FqName) it2.next()).shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet(arrayList2);
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name) {
        Intrinsics.checkNotNullParameter(name, "");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
