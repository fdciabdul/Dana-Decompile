package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* loaded from: classes.dex */
public final class JavaResolverComponents {
    private final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final ErrorReporter errorReporter;
    private final JavaClassFinder finder;
    private final JavaClassesTracker javaClassesTracker;
    private final JavaModuleAnnotationsProvider javaModuleResolver;
    private final JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator;
    private final JavaResolverCache javaResolverCache;
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    private final KotlinClassFinder kotlinClassFinder;
    private final NewKotlinTypeChecker kotlinTypeChecker;
    private final LookupTracker lookupTracker;
    private final ModuleDescriptor module;
    private final ModuleClassResolver moduleClassResolver;
    private final PackagePartProvider packagePartProvider;
    private final ReflectionTypes reflectionTypes;
    private final SamConversionResolver samConversionResolver;
    private final JavaResolverSettings settings;
    private final SignatureEnhancement signatureEnhancement;
    private final SignaturePropagator signaturePropagator;
    private final JavaSourceElementFactory sourceElementFactory;
    private final StorageManager storageManager;
    private final SupertypeLoopChecker supertypeLoopChecker;
    private final SyntheticJavaPartsProvider syntheticPartsProvider;

    public JavaResolverComponents(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, SignatureEnhancement signatureEnhancement, JavaClassesTracker javaClassesTracker, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState, JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, SyntheticJavaPartsProvider syntheticJavaPartsProvider) {
        Intrinsics.checkNotNullParameter(storageManager, "");
        Intrinsics.checkNotNullParameter(javaClassFinder, "");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "");
        Intrinsics.checkNotNullParameter(signaturePropagator, "");
        Intrinsics.checkNotNullParameter(errorReporter, "");
        Intrinsics.checkNotNullParameter(javaResolverCache, "");
        Intrinsics.checkNotNullParameter(javaPropertyInitializerEvaluator, "");
        Intrinsics.checkNotNullParameter(samConversionResolver, "");
        Intrinsics.checkNotNullParameter(javaSourceElementFactory, "");
        Intrinsics.checkNotNullParameter(moduleClassResolver, "");
        Intrinsics.checkNotNullParameter(packagePartProvider, "");
        Intrinsics.checkNotNullParameter(supertypeLoopChecker, "");
        Intrinsics.checkNotNullParameter(lookupTracker, "");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "");
        Intrinsics.checkNotNullParameter(reflectionTypes, "");
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver, "");
        Intrinsics.checkNotNullParameter(signatureEnhancement, "");
        Intrinsics.checkNotNullParameter(javaClassesTracker, "");
        Intrinsics.checkNotNullParameter(javaResolverSettings, "");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "");
        Intrinsics.checkNotNullParameter(javaModuleAnnotationsProvider, "");
        Intrinsics.checkNotNullParameter(syntheticJavaPartsProvider, "");
        this.storageManager = storageManager;
        this.finder = javaClassFinder;
        this.kotlinClassFinder = kotlinClassFinder;
        this.deserializedDescriptorResolver = deserializedDescriptorResolver;
        this.signaturePropagator = signaturePropagator;
        this.errorReporter = errorReporter;
        this.javaResolverCache = javaResolverCache;
        this.javaPropertyInitializerEvaluator = javaPropertyInitializerEvaluator;
        this.samConversionResolver = samConversionResolver;
        this.sourceElementFactory = javaSourceElementFactory;
        this.moduleClassResolver = moduleClassResolver;
        this.packagePartProvider = packagePartProvider;
        this.supertypeLoopChecker = supertypeLoopChecker;
        this.lookupTracker = lookupTracker;
        this.module = moduleDescriptor;
        this.reflectionTypes = reflectionTypes;
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver;
        this.signatureEnhancement = signatureEnhancement;
        this.javaClassesTracker = javaClassesTracker;
        this.settings = javaResolverSettings;
        this.kotlinTypeChecker = newKotlinTypeChecker;
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.javaModuleResolver = javaModuleAnnotationsProvider;
        this.syntheticPartsProvider = syntheticJavaPartsProvider;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final JavaClassFinder getFinder() {
        return this.finder;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.deserializedDescriptorResolver;
    }

    public final SignaturePropagator getSignaturePropagator() {
        return this.signaturePropagator;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final JavaResolverCache getJavaResolverCache() {
        return this.javaResolverCache;
    }

    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.javaPropertyInitializerEvaluator;
    }

    public final JavaSourceElementFactory getSourceElementFactory() {
        return this.sourceElementFactory;
    }

    public final ModuleClassResolver getModuleClassResolver() {
        return this.moduleClassResolver;
    }

    public final PackagePartProvider getPackagePartProvider() {
        return this.packagePartProvider;
    }

    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.supertypeLoopChecker;
    }

    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final ModuleDescriptor getModule() {
        return this.module;
    }

    public final ReflectionTypes getReflectionTypes() {
        return this.reflectionTypes;
    }

    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.annotationTypeQualifierResolver;
    }

    public final SignatureEnhancement getSignatureEnhancement() {
        return this.signatureEnhancement;
    }

    public final JavaClassesTracker getJavaClassesTracker() {
        return this.javaClassesTracker;
    }

    public final JavaResolverSettings getSettings() {
        return this.settings;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.javaTypeEnhancementState;
    }

    public final JavaModuleAnnotationsProvider getJavaModuleResolver() {
        return this.javaModuleResolver;
    }

    public /* synthetic */ JavaResolverComponents(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, SignatureEnhancement signatureEnhancement, JavaClassesTracker javaClassesTracker, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState, JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, SyntheticJavaPartsProvider syntheticJavaPartsProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, javaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, errorReporter, javaResolverCache, javaPropertyInitializerEvaluator, samConversionResolver, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, lookupTracker, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, javaClassesTracker, javaResolverSettings, newKotlinTypeChecker, javaTypeEnhancementState, javaModuleAnnotationsProvider, (i & 8388608) != 0 ? SyntheticJavaPartsProvider.Companion.getEMPTY() : syntheticJavaPartsProvider);
    }

    public final SyntheticJavaPartsProvider getSyntheticPartsProvider() {
        return this.syntheticPartsProvider;
    }

    public final JavaResolverComponents replace(JavaResolverCache javaResolverCache) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "");
        return new JavaResolverComponents(this.storageManager, this.finder, this.kotlinClassFinder, this.deserializedDescriptorResolver, this.signaturePropagator, this.errorReporter, javaResolverCache, this.javaPropertyInitializerEvaluator, this.samConversionResolver, this.sourceElementFactory, this.moduleClassResolver, this.packagePartProvider, this.supertypeLoopChecker, this.lookupTracker, this.module, this.reflectionTypes, this.annotationTypeQualifierResolver, this.signatureEnhancement, this.javaClassesTracker, this.settings, this.kotlinTypeChecker, this.javaTypeEnhancementState, this.javaModuleResolver, null, 8388608, null);
    }
}
