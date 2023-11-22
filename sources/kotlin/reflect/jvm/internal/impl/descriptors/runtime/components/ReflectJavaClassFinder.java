package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class ReflectJavaClassFinder implements JavaClassFinder {
    private final ClassLoader classLoader;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public final Set<String> knownClassNamesInPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return null;
    }

    public ReflectJavaClassFinder(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "");
        this.classLoader = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public final JavaClass findClass(JavaClassFinder.Request request) {
        Intrinsics.checkNotNullParameter(request, "");
        ClassId classId = request.getClassId();
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "");
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        String replace$default = StringsKt.replace$default(asString, '.', (char) Typography.dollar, false, 4, (Object) null);
        if (!packageFqName.isRoot()) {
            StringBuilder sb = new StringBuilder();
            sb.append(packageFqName.asString());
            sb.append('.');
            sb.append(replace$default);
            replace$default = sb.toString();
        }
        Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, replace$default);
        if (tryLoadClass != null) {
            return new ReflectJavaClass(tryLoadClass);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public final JavaPackage findPackage(FqName fqName, boolean z) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return new ReflectJavaPackage(fqName);
    }
}
