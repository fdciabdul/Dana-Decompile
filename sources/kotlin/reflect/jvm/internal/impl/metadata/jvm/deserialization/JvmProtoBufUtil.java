package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes.dex */
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY;
    public static final JvmProtoBufUtil INSTANCE = new JvmProtoBufUtil();

    private JvmProtoBufUtil() {
    }

    static {
        ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(newInstance);
        Intrinsics.checkNotNullExpressionValue(newInstance, "");
        EXTENSION_REGISTRY = newInstance;
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "");
        Intrinsics.checkNotNullParameter(strArr2, "");
        byte[] decodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "");
        return readClassDataFrom(decodeBytes, strArr2);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(byte[] bArr, String[] strArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr), ProtoBuf.Class.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "");
        Intrinsics.checkNotNullParameter(strArr2, "");
        byte[] decodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "");
        return readPackageDataFrom(decodeBytes, strArr2);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(byte[] bArr, String[] strArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr), ProtoBuf.Package.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "");
        Intrinsics.checkNotNullParameter(strArr2, "");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(strArr));
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr2), ProtoBuf.Function.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(parseDelimitedFrom, "");
        return new JvmNameResolver(parseDelimitedFrom, strArr);
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf.Function function, NameResolver nameResolver, TypeTable typeTable) {
        String obj;
        Intrinsics.checkNotNullParameter(function, "");
        Intrinsics.checkNotNullParameter(nameResolver, "");
        Intrinsics.checkNotNullParameter(typeTable, "");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> generatedExtension = JvmProtoBuf.methodSignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(function, generatedExtension);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? function.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            obj = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            List listOfNotNull = CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(function, typeTable));
            List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "");
            List<ProtoBuf.ValueParameter> list = valueParameterList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProtoBuf.ValueParameter valueParameter : list) {
                Intrinsics.checkNotNullExpressionValue(valueParameter, "");
                arrayList.add(ProtoTypeTableUtilKt.type(valueParameter, typeTable));
            }
            List plus = CollectionsKt.plus((Collection) listOfNotNull, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
            Iterator it = plus.iterator();
            while (it.hasNext()) {
                String mapTypeDefault = INSTANCE.mapTypeDefault((ProtoBuf.Type) it.next(), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList2.add(mapTypeDefault);
            }
            ArrayList arrayList3 = arrayList2;
            String mapTypeDefault2 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(function, typeTable), nameResolver);
            if (mapTypeDefault2 == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CollectionsKt.joinToString$default(arrayList3, "", "(", ")", 0, null, null, 56, null));
            sb.append(mapTypeDefault2);
            obj = sb.toString();
        }
        return new JvmMemberSignature.Method(nameResolver.getString(name), obj);
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf.Constructor constructor, NameResolver nameResolver, TypeTable typeTable) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(constructor, "");
        Intrinsics.checkNotNullParameter(nameResolver, "");
        Intrinsics.checkNotNullParameter(typeTable, "");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> generatedExtension = JvmProtoBuf.constructorSignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(constructor, generatedExtension);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            joinToString$default = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "");
            List<ProtoBuf.ValueParameter> list = valueParameterList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProtoBuf.ValueParameter valueParameter : list) {
                JvmProtoBufUtil jvmProtoBufUtil = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(valueParameter, "");
                String mapTypeDefault = jvmProtoBufUtil.mapTypeDefault(ProtoTypeTableUtilKt.type(valueParameter, typeTable), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList.add(mapTypeDefault);
            }
            joinToString$default = CollectionsKt.joinToString$default(arrayList, "", "(", ")V", 0, null, null, 56, null);
        }
        return new JvmMemberSignature.Method(string, joinToString$default);
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(property, nameResolver, typeTable, z);
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z) {
        String mapTypeDefault;
        Intrinsics.checkNotNullParameter(property, "");
        Intrinsics.checkNotNullParameter(nameResolver, "");
        Intrinsics.checkNotNullParameter(typeTable, "");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(property, generatedExtension);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? property.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            mapTypeDefault = mapTypeDefault(ProtoTypeTableUtilKt.returnType(property, typeTable), nameResolver);
            if (mapTypeDefault == null) {
                return null;
            }
        } else {
            mapTypeDefault = nameResolver.getString(field.getDesc());
        }
        return new JvmMemberSignature.Field(nameResolver.getString(name), mapTypeDefault);
    }

    private final String mapTypeDefault(ProtoBuf.Type type, NameResolver nameResolver) {
        if (type.hasClassName()) {
            return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(type.getClassName()));
        }
        return null;
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(property, "");
        Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = property.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(extension, "");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }
}
