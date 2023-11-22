package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;

/* loaded from: classes.dex */
public final class RuntimeModuleData {
    public static final Companion Companion = new Companion(null);
    private final DeserializationComponents deserialization;
    private final PackagePartScopeCache packagePartScopeCache;

    public /* synthetic */ RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationComponents, packagePartScopeCache);
    }

    private RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache) {
        this.deserialization = deserializationComponents;
        this.packagePartScopeCache = packagePartScopeCache;
    }

    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }

    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RuntimeModuleData create(ClassLoader classLoader) {
            Intrinsics.checkNotNullParameter(classLoader, "");
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader);
            ClassLoader classLoader2 = Unit.class.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader2, "");
            ReflectKotlinClassFinder reflectKotlinClassFinder2 = new ReflectKotlinClassFinder(classLoader2);
            ReflectJavaClassFinder reflectJavaClassFinder = new ReflectJavaClassFinder(classLoader);
            StringBuilder sb = new StringBuilder();
            sb.append("runtime module for ");
            sb.append(classLoader);
            DeserializationComponentsForJava.Companion.ModuleData createModuleData = DeserializationComponentsForJava.Companion.createModuleData(reflectKotlinClassFinder, reflectKotlinClassFinder2, reflectJavaClassFinder, sb.toString(), RuntimeErrorReporter.INSTANCE, RuntimeSourceElementFactory.INSTANCE);
            return new RuntimeModuleData(createModuleData.getDeserializationComponentsForJava().getComponents(), new PackagePartScopeCache(createModuleData.getDeserializedDescriptorResolver(), reflectKotlinClassFinder), null);
        }
    }
}
