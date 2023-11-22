package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> extends AbstractBinaryClassAnnotationLoader<A, AnnotationsContainerWithConstants<? extends A, ? extends C>> implements AnnotationAndConstantLoader<A, C> {
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<A, C>> storage;

    public abstract C loadConstant(String str, Object obj);

    protected abstract C transformToUnsignedConstant(C c);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        super(kotlinClassFinder);
        Intrinsics.checkNotNullParameter(storageManager, "");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "");
        this.storage = storageManager.createMemoizedFunction(new Function1<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<? extends A, ? extends C>>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$storage$1
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<A, C> invoke(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
                AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers;
                Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "");
                loadAnnotationsAndInitializers = this.this$0.loadAnnotationsAndInitializers(kotlinJvmBinaryClass);
                return loadAnnotationsAndInitializers;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "");
        return this.storage.invoke(kotlinJvmBinaryClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadAnnotationDefaultValue(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, "");
        Intrinsics.checkNotNullParameter(property, "");
        Intrinsics.checkNotNullParameter(kotlinType, "");
        return loadConstantFromProperty(protoContainer, property, AnnotatedCallableKind.PROPERTY_GETTER, kotlinType, new Function2<AnnotationsContainerWithConstants<? extends A, ? extends C>, MemberSignature, C>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationDefaultValue$1
            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Object invoke(Object obj, MemberSignature memberSignature) {
                return invoke((AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants) ((AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants) obj), memberSignature);
            }

            public final C invoke(AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<? extends A, ? extends C> annotationsContainerWithConstants, MemberSignature memberSignature) {
                Intrinsics.checkNotNullParameter(annotationsContainerWithConstants, "");
                Intrinsics.checkNotNullParameter(memberSignature, "");
                return annotationsContainerWithConstants.getAnnotationParametersDefaultValues().get(memberSignature);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, "");
        Intrinsics.checkNotNullParameter(property, "");
        Intrinsics.checkNotNullParameter(kotlinType, "");
        return loadConstantFromProperty(protoContainer, property, AnnotatedCallableKind.PROPERTY, kotlinType, new Function2<AnnotationsContainerWithConstants<? extends A, ? extends C>, MemberSignature, C>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadPropertyConstant$1
            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Object invoke(Object obj, MemberSignature memberSignature) {
                return invoke((AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants) ((AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants) obj), memberSignature);
            }

            public final C invoke(AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<? extends A, ? extends C> annotationsContainerWithConstants, MemberSignature memberSignature) {
                Intrinsics.checkNotNullParameter(annotationsContainerWithConstants, "");
                Intrinsics.checkNotNullParameter(memberSignature, "");
                return annotationsContainerWithConstants.getPropertyConstants().get(memberSignature);
            }
        });
    }

    private final C loadConstantFromProperty(ProtoContainer protoContainer, ProtoBuf.Property property, AnnotatedCallableKind annotatedCallableKind, KotlinType kotlinType, Function2<? super AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super MemberSignature, ? extends C> function2) {
        C invoke;
        KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, getSpecialCaseContainerClass(protoContainer, true, true, Flags.IS_CONST.get(property.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(property)));
        if (findClassWithAnnotationsAndInitializers == null) {
            return null;
        }
        MemberSignature callableSignature = getCallableSignature(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, findClassWithAnnotationsAndInitializers.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
        if (callableSignature == null || (invoke = function2.invoke(this.storage.invoke(findClassWithAnnotationsAndInitializers), callableSignature)) == null) {
            return null;
        }
        return UnsignedTypes.isUnsignedType(kotlinType) ? transformToUnsignedConstant(invoke) : invoke;
    }

    public final AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(final KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final HashMap hashMap3 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new KotlinJvmBinaryClass.MemberVisitor(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1
            final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            public final KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(Name name, String str) {
                Intrinsics.checkNotNullParameter(name, "");
                Intrinsics.checkNotNullParameter(str, "");
                MemberSignature.Companion companion = MemberSignature.Companion;
                String asString = name.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "");
                return new AnnotationVisitorForMethod(this, companion.fromMethodNameAndDesc(asString, str));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            public final KotlinJvmBinaryClass.AnnotationVisitor visitField(Name name, String str, Object obj) {
                Object loadConstant;
                Intrinsics.checkNotNullParameter(name, "");
                Intrinsics.checkNotNullParameter(str, "");
                MemberSignature.Companion companion = MemberSignature.Companion;
                String asString = name.asString();
                Intrinsics.checkNotNullExpressionValue(asString, "");
                MemberSignature fromFieldNameAndDesc = companion.fromFieldNameAndDesc(asString, str);
                if (obj != null && (loadConstant = this.this$0.loadConstant(str, obj)) != null) {
                    hashMap2.put(fromFieldNameAndDesc, loadConstant);
                }
                return new MemberAnnotationVisitor(this, fromFieldNameAndDesc);
            }

            /* loaded from: classes.dex */
            public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
                final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnnotationVisitorForMethod(AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
                    super(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, memberSignature);
                    Intrinsics.checkNotNullParameter(memberSignature, "");
                    this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
                public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement) {
                    Intrinsics.checkNotNullParameter(classId, "");
                    Intrinsics.checkNotNullParameter(sourceElement, "");
                    MemberSignature fromMethodSignatureAndParameterIndex = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), i);
                    ArrayList arrayList = (List) hashMap.get(fromMethodSignatureAndParameterIndex);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        hashMap.put(fromMethodSignatureAndParameterIndex, arrayList);
                    }
                    return this.this$0.this$0.loadAnnotationIfNotSpecial(classId, sourceElement, arrayList);
                }
            }

            /* loaded from: classes.dex */
            public class MemberAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
                private final ArrayList<A> result;
                private final MemberSignature signature;
                final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

                public MemberAnnotationVisitor(AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
                    Intrinsics.checkNotNullParameter(memberSignature, "");
                    this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
                    this.signature = memberSignature;
                    this.result = new ArrayList<>();
                }

                protected final MemberSignature getSignature() {
                    return this.signature;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
                    Intrinsics.checkNotNullParameter(classId, "");
                    Intrinsics.checkNotNullParameter(sourceElement, "");
                    return this.this$0.this$0.loadAnnotationIfNotSpecial(classId, sourceElement, this.result);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                    if ((!this.result.isEmpty()) == true) {
                        hashMap.put(this.signature, this.result);
                    }
                }
            }
        }, getCachedFileContent(kotlinJvmBinaryClass));
        return new AnnotationsContainerWithConstants<>(hashMap, hashMap2, hashMap3);
    }

    public final boolean isRepeatableWithImplicitContainer(ClassId classId, Map<Name, ? extends ConstantValue<?>> map) {
        Intrinsics.checkNotNullParameter(classId, "");
        Intrinsics.checkNotNullParameter(map, "");
        if (Intrinsics.areEqual(classId, SpecialJvmAnnotations.INSTANCE.getJAVA_LANG_ANNOTATION_REPEATABLE())) {
            ConstantValue<?> constantValue = map.get(Name.identifier("value"));
            KClassValue kClassValue = constantValue instanceof KClassValue ? (KClassValue) constantValue : null;
            if (kClassValue == null) {
                return false;
            }
            KClassValue.Value value = kClassValue.getValue();
            KClassValue.Value.NormalClass normalClass = value instanceof KClassValue.Value.NormalClass ? (KClassValue.Value.NormalClass) value : null;
            if (normalClass == null) {
                return false;
            }
            return isImplicitRepeatableContainer(normalClass.getClassId());
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static final class AnnotationsContainerWithConstants<A, C> extends AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {
        private final Map<MemberSignature, C> annotationParametersDefaultValues;
        private final Map<MemberSignature, List<A>> memberAnnotations;
        private final Map<MemberSignature, C> propertyConstants;

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer
        public final Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }

        public final Map<MemberSignature, C> getAnnotationParametersDefaultValues() {
            return this.annotationParametersDefaultValues;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnnotationsContainerWithConstants(Map<MemberSignature, ? extends List<? extends A>> map, Map<MemberSignature, ? extends C> map2, Map<MemberSignature, ? extends C> map3) {
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(map2, "");
            Intrinsics.checkNotNullParameter(map3, "");
            this.memberAnnotations = map;
            this.propertyConstants = map2;
            this.annotationParametersDefaultValues = map3;
        }
    }
}
