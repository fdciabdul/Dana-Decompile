package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;

/* loaded from: classes.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final BuiltInsResourceLoader builtInsResourceLoader;
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "");
        this.classLoader = classLoader;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, byte[]] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    private final KotlinClassFinder.Result findKotlinClass(String str) {
        ReflectKotlinClass create;
        Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, str);
        ?? r0 = 0;
        r0 = 0;
        if (tryLoadClass != null && (create = ReflectKotlinClass.Factory.create(tryLoadClass)) != null) {
            r0 = new KotlinClassFinder.Result.KotlinClass(create, r0, 2, r0);
        }
        return (KotlinClassFinder.Result) r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public final KotlinClassFinder.Result findKotlinClassOrContent(ClassId classId) {
        String runtimeFqName;
        Intrinsics.checkNotNullParameter(classId, "");
        runtimeFqName = ReflectKotlinClassFinderKt.toRuntimeFqName(classId);
        return findKotlinClass(runtimeFqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public final KotlinClassFinder.Result findKotlinClassOrContent(JavaClass javaClass) {
        String asString;
        Intrinsics.checkNotNullParameter(javaClass, "");
        FqName fqName = javaClass.getFqName();
        if (fqName == null || (asString = fqName.asString()) == null) {
            return null;
        }
        return findKotlinClass(asString);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public final InputStream findBuiltInsData(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        if (fqName.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME)) {
            return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName));
        }
        return null;
    }
}
