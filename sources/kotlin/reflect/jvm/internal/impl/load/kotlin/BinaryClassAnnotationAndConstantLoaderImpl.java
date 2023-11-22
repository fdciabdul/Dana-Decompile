package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer annotationDeserializer;
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses, StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        Intrinsics.checkNotNullParameter(moduleDescriptor, "");
        Intrinsics.checkNotNullParameter(notFoundClasses, "");
        Intrinsics.checkNotNullParameter(storageManager, "");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "");
        this.module = moduleDescriptor;
        this.notFoundClasses = notFoundClasses;
        this.annotationDeserializer = new AnnotationDeserializer(moduleDescriptor, notFoundClasses);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public final AnnotationDescriptor loadTypeAnnotation(ProtoBuf.Annotation annotation, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(annotation, "");
        Intrinsics.checkNotNullParameter(nameResolver, "");
        return this.annotationDeserializer.deserializeAnnotation(annotation, nameResolver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public final ConstantValue<?> loadConstant(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(obj, "");
        if (StringsKt.contains$default((CharSequence) "ZBCS", (CharSequence) str, false, 2, (Object) null)) {
            int intValue = ((Integer) obj).intValue();
            int hashCode = str.hashCode();
            if (hashCode == 66) {
                if (str.equals(DiskFormatter.B)) {
                    obj = Byte.valueOf((byte) intValue);
                }
                throw new AssertionError(str);
            } else if (hashCode == 67) {
                if (str.equals("C")) {
                    obj = Character.valueOf((char) intValue);
                }
                throw new AssertionError(str);
            } else if (hashCode == 83) {
                if (str.equals("S")) {
                    obj = Short.valueOf((short) intValue);
                }
                throw new AssertionError(str);
            } else {
                if (hashCode == 90 && str.equals("Z")) {
                    obj = Boolean.valueOf(intValue != 0);
                }
                throw new AssertionError(str);
            }
        }
        return ConstantValueFactory.INSTANCE.createConstantValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public final ConstantValue<?> transformToUnsignedConstant(ConstantValue<?> constantValue) {
        Intrinsics.checkNotNullParameter(constantValue, "");
        return constantValue instanceof ByteValue ? new UByteValue(((ByteValue) constantValue).getValue().byteValue()) : constantValue instanceof ShortValue ? new UShortValue(((ShortValue) constantValue).getValue().shortValue()) : constantValue instanceof IntValue ? new UIntValue(((IntValue) constantValue).getValue().intValue()) : constantValue instanceof LongValue ? new ULongValue(((LongValue) constantValue).getValue().longValue()) : constantValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(final ClassId classId, final SourceElement sourceElement, final List<AnnotationDescriptor> list) {
        Intrinsics.checkNotNullParameter(classId, "");
        Intrinsics.checkNotNullParameter(sourceElement, "");
        Intrinsics.checkNotNullParameter(list, "");
        final ClassDescriptor resolveClass = resolveClass(classId);
        return new AbstractAnnotationArgumentVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1
            private final HashMap<Name, ConstantValue<?>> arguments;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.arguments = new HashMap<>();
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor
            public final void visitConstantValue(Name name, ConstantValue<?> constantValue) {
                Intrinsics.checkNotNullParameter(constantValue, "");
                if (name != null) {
                    this.arguments.put(name, constantValue);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor
            public final void visitArrayValue(Name name, ArrayList<ConstantValue<?>> arrayList) {
                Intrinsics.checkNotNullParameter(arrayList, "");
                if (name == null) {
                    return;
                }
                ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, resolveClass);
                if (annotationParameterByName != null) {
                    HashMap<Name, ConstantValue<?>> hashMap = this.arguments;
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<? extends ConstantValue<?>> compact = CollectionsKt.compact(arrayList);
                    KotlinType type = annotationParameterByName.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "");
                    hashMap.put(name, constantValueFactory.createArrayValue(compact, type));
                } else if (BinaryClassAnnotationAndConstantLoaderImpl.this.isImplicitRepeatableContainer(classId) && Intrinsics.areEqual(name.asString(), "value")) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (obj instanceof AnnotationValue) {
                            arrayList2.add(obj);
                        }
                    }
                    List<AnnotationDescriptor> list2 = list;
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        list2.add(((AnnotationValue) it.next()).getValue());
                    }
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public final void visitEnd() {
                if (BinaryClassAnnotationAndConstantLoaderImpl.this.isRepeatableWithImplicitContainer(classId, this.arguments) || BinaryClassAnnotationAndConstantLoaderImpl.this.isImplicitRepeatableContainer(classId)) {
                    return;
                }
                list.add(new AnnotationDescriptorImpl(resolveClass.getDefaultType(), this.arguments, sourceElement));
            }
        };
    }

    /* loaded from: classes.dex */
    abstract class AbstractAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        public abstract void visitArrayValue(Name name, ArrayList<ConstantValue<?>> arrayList);

        public abstract void visitConstantValue(Name name, ConstantValue<?> constantValue);

        public AbstractAnnotationArgumentVisitor() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name name, Object obj) {
            visitConstantValue(name, BinaryClassAnnotationAndConstantLoaderImpl.this.createConstant(name, obj));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            Intrinsics.checkNotNullParameter(classLiteralValue, "");
            visitConstantValue(name, new KClassValue(classLiteralValue));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name name, ClassId classId, Name name2) {
            Intrinsics.checkNotNullParameter(classId, "");
            Intrinsics.checkNotNullParameter(name2, "");
            visitConstantValue(name, new EnumValue(classId, name2));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name) {
            return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(BinaryClassAnnotationAndConstantLoaderImpl.this, name, this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(final Name name, ClassId classId) {
            Intrinsics.checkNotNullParameter(classId, "");
            final ArrayList arrayList = new ArrayList();
            BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = BinaryClassAnnotationAndConstantLoaderImpl.this;
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "");
            final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation = binaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(classId, sourceElement, arrayList);
            Intrinsics.checkNotNull(loadAnnotation);
            return new KotlinJvmBinaryClass.AnnotationArgumentVisitor(this, name, arrayList) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitAnnotation$1
                private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
                final /* synthetic */ ArrayList<AnnotationDescriptor> $list;
                final /* synthetic */ Name $name;
                final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor this$0;

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public final void visit(Name name2, Object obj) {
                    this.$$delegate_0.visit(name2, obj);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name2, ClassId classId2) {
                    Intrinsics.checkNotNullParameter(classId2, "");
                    return this.$$delegate_0.visitAnnotation(name2, classId2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public final KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name2) {
                    return this.$$delegate_0.visitArray(name2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public final void visitClassLiteral(Name name2, ClassLiteralValue classLiteralValue) {
                    Intrinsics.checkNotNullParameter(classLiteralValue, "");
                    this.$$delegate_0.visitClassLiteral(name2, classLiteralValue);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public final void visitEnum(Name name2, ClassId classId2, Name name3) {
                    Intrinsics.checkNotNullParameter(classId2, "");
                    Intrinsics.checkNotNullParameter(name3, "");
                    this.$$delegate_0.visitEnum(name2, classId2, name3);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                    this.$name = name;
                    this.$list = arrayList;
                    this.$$delegate_0 = KotlinJvmBinaryClass.AnnotationArgumentVisitor.this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public final void visitEnd() {
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor.this.visitEnd();
                    this.this$0.visitConstantValue(this.$name, new AnnotationValue((AnnotationDescriptor) kotlin.collections.CollectionsKt.single((List) this.$list)));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstantValue<?> createConstant(Name name, Object obj) {
        ConstantValue<?> createConstantValue = ConstantValueFactory.INSTANCE.createConstantValue(obj);
        if (createConstantValue == null) {
            ErrorValue.Companion companion = ErrorValue.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported annotation argument: ");
            sb.append(name);
            return companion.create(sb.toString());
        }
        return createConstantValue;
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }
}
