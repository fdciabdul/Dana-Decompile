package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes.dex */
final /* synthetic */ class JavaTypeEnhancementState$Companion$DEFAULT$1 extends FunctionReference implements Function1<FqName, ReportLevel> {
    public static final JavaTypeEnhancementState$Companion$DEFAULT$1 INSTANCE = new JavaTypeEnhancementState$Companion$DEFAULT$1();

    JavaTypeEnhancementState$Companion$DEFAULT$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "getDefaultReportLevelForAnnotation";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(JavaNullabilityAnnotationSettingsKt.class, "compiler.common.jvm");
    }

    @Override // kotlin.jvm.functions.Function1
    public final ReportLevel invoke(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return JavaNullabilityAnnotationSettingsKt.getDefaultReportLevelForAnnotation(fqName);
    }
}
