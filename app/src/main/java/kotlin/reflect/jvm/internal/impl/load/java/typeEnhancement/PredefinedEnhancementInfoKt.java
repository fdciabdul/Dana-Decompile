package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.notification.DanaFirebaseMessagingService;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes.dex */
public final class PredefinedEnhancementInfoKt {
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    private static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final JavaTypeQualifiers NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    private static final JavaTypeQualifiers NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);

    static {
        final SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        final String javaLang = signatureBuildingComponents.javaLang("Object");
        final String javaFunction = signatureBuildingComponents.javaFunction("Predicate");
        final String javaFunction2 = signatureBuildingComponents.javaFunction("Function");
        final String javaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        final String javaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        final String javaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        final String javaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        final String javaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        final String javaUtil2 = signatureBuildingComponents.javaUtil(TrackerKey.AppUpdateType.APP_UPDATE_OPTIONAL);
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator")).function("forEachRemaining", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaFunction3;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String javaUtil3 = SignatureBuildingComponents.this.javaUtil("Spliterator");
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(javaUtil3, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Collection"));
        classEnhancementBuilder.function("removeIf", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaFunction;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2);
                functionEnhancementBuilder.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        classEnhancementBuilder.function("stream", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaUtil;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        classEnhancementBuilder.function("parallelStream", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaUtil;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("List")).function("replaceAll", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaFunction6;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Map"));
        classEnhancementBuilder2.function("forEach", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaFunction5;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder2.function("putIfAbsent", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaLang;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder2.function("replace", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaLang;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder2.function("replace", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaLang;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str3, javaTypeQualifiers3);
                functionEnhancementBuilder.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        classEnhancementBuilder2.function("replaceAll", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaFunction4;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers3, javaTypeQualifiers4);
            }
        });
        classEnhancementBuilder2.function("compute", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                JavaTypeQualifiers javaTypeQualifiers5;
                JavaTypeQualifiers javaTypeQualifiers6;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaFunction4;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NULLABLE;
                javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2, javaTypeQualifiers3, javaTypeQualifiers4, javaTypeQualifiers5);
                String str3 = javaLang;
                javaTypeQualifiers6 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers6);
            }
        });
        classEnhancementBuilder2.function("computeIfAbsent", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                JavaTypeQualifiers javaTypeQualifiers5;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaFunction2;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2, javaTypeQualifiers3, javaTypeQualifiers4);
                String str3 = javaLang;
                javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers5);
            }
        });
        classEnhancementBuilder2.function("computeIfPresent", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$8
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                JavaTypeQualifiers javaTypeQualifiers5;
                JavaTypeQualifiers javaTypeQualifiers6;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaFunction4;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2, javaTypeQualifiers3, javaTypeQualifiers4, javaTypeQualifiers5);
                String str3 = javaLang;
                javaTypeQualifiers6 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers6);
            }
        });
        classEnhancementBuilder2.function("merge", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                JavaTypeQualifiers javaTypeQualifiers4;
                JavaTypeQualifiers javaTypeQualifiers5;
                JavaTypeQualifiers javaTypeQualifiers6;
                JavaTypeQualifiers javaTypeQualifiers7;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaFunction4;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers4 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                javaTypeQualifiers5 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                javaTypeQualifiers6 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.parameter(str3, javaTypeQualifiers3, javaTypeQualifiers4, javaTypeQualifiers5, javaTypeQualifiers6);
                String str4 = javaLang;
                javaTypeQualifiers7 = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str4, javaTypeQualifiers7);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaUtil2);
        classEnhancementBuilder3.function(DanaFirebaseMessagingService.EMPTY, new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaUtil2;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        classEnhancementBuilder3.function("of", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaUtil2;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.returns(str2, javaTypeQualifiers2, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder3.function("ofNullable", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaUtil2;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.returns(str2, javaTypeQualifiers2, javaTypeQualifiers3);
            }
        });
        classEnhancementBuilder3.function("get", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers);
            }
        });
        classEnhancementBuilder3.function("ifPresent", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaFunction3;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_NULLABLE;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("ref/Reference")).function("get", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$7$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NULLABLE;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction).function("test", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$8$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                functionEnhancementBuilder.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("BiPredicate")).function("test", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$9$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                functionEnhancementBuilder.returns(JvmPrimitiveType.BOOLEAN);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction3).function("accept", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$10$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction5).function("accept", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$11$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction2).function("apply", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$12$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str2, javaTypeQualifiers2);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction4).function("apply", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$13$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                JavaTypeQualifiers javaTypeQualifiers2;
                JavaTypeQualifiers javaTypeQualifiers3;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str, javaTypeQualifiers);
                String str2 = javaLang;
                javaTypeQualifiers2 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.parameter(str2, javaTypeQualifiers2);
                String str3 = javaLang;
                javaTypeQualifiers3 = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str3, javaTypeQualifiers3);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("Supplier")).function("get", new Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                invoke2(functionEnhancementBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
                JavaTypeQualifiers javaTypeQualifiers;
                Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "");
                String str = javaLang;
                javaTypeQualifiers = PredefinedEnhancementInfoKt.NOT_PLATFORM;
                functionEnhancementBuilder.returns(str, javaTypeQualifiers);
            }
        });
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}
