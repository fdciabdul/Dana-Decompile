package kotlin.reflect;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H¦\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u000e\u0010\tR \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0017\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0017\u001a\u0004\b\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0017\u001a\u0004\b$\u0010\u0015R\u001a\u0010&\u001a\u00020\u00078'X¦\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0017\u001a\u0004\b&\u0010\u0015R\u001e\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u000f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u001e\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000f8'X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0012R\u0016\u0010/\u001a\u0004\u0018\u00018\u00008'X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0004\u0018\u0001008'X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R(\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000048'X¦\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0017\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u0004\u0018\u0001008'X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u00102R \u0010>\u001a\b\u0012\u0004\u0012\u00020;048'X¦\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0017\u001a\u0004\b<\u00106R \u0010B\u001a\b\u0012\u0004\u0012\u00020?048'X¦\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0017\u001a\u0004\b@\u00106R\u001c\u0010G\u001a\u0004\u0018\u00010C8'X¦\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0017\u001a\u0004\bD\u0010E"}, d2 = {"Lkotlin/reflect/KClass;", "", "T", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "value", "isInstance", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "constructors", "isAbstract", "()Z", "isAbstract$annotations", "()V", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "Lkotlin/reflect/KCallable;", "getMembers", "members", "getNestedClasses", "nestedClasses", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName", "", "getSealedSubclasses", "()Ljava/util/List;", "getSealedSubclasses$annotations", "sealedSubclasses", "getSimpleName", "simpleName", "Lkotlin/reflect/KType;", "getSupertypes", "getSupertypes$annotations", "supertypes", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "getTypeParameters$annotations", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getSealedSubclasses$annotations() {
        }

        public static /* synthetic */ void getSupertypes$annotations() {
        }

        public static /* synthetic */ void getTypeParameters$annotations() {
        }

        public static /* synthetic */ void getVisibility$annotations() {
        }

        public static /* synthetic */ void isAbstract$annotations() {
        }

        public static /* synthetic */ void isCompanion$annotations() {
        }

        public static /* synthetic */ void isData$annotations() {
        }

        public static /* synthetic */ void isFinal$annotations() {
        }

        public static /* synthetic */ void isFun$annotations() {
        }

        public static /* synthetic */ void isInner$annotations() {
        }

        public static /* synthetic */ void isOpen$annotations() {
        }

        public static /* synthetic */ void isSealed$annotations() {
        }

        public static /* synthetic */ void isValue$annotations() {
        }
    }

    boolean equals(Object other);

    @JvmName(name = "getConstructors")
    Collection<KFunction<T>> getConstructors();

    @Override // kotlin.reflect.KDeclarationContainer
    @JvmName(name = "getMembers")
    Collection<KCallable<?>> getMembers();

    @JvmName(name = "getNestedClasses")
    Collection<KClass<?>> getNestedClasses();

    @JvmName(name = "getObjectInstance")
    T getObjectInstance();

    @JvmName(name = "getQualifiedName")
    String getQualifiedName();

    @JvmName(name = "getSealedSubclasses")
    List<KClass<? extends T>> getSealedSubclasses();

    @JvmName(name = "getSimpleName")
    String getSimpleName();

    @JvmName(name = "getSupertypes")
    List<KType> getSupertypes();

    @JvmName(name = "getTypeParameters")
    List<KTypeParameter> getTypeParameters();

    @JvmName(name = "getVisibility")
    KVisibility getVisibility();

    int hashCode();

    @JvmName(name = "isAbstract")
    boolean isAbstract();

    @JvmName(name = "isCompanion")
    boolean isCompanion();

    @JvmName(name = "isData")
    boolean isData();

    @JvmName(name = "isFinal")
    boolean isFinal();

    @JvmName(name = "isFun")
    boolean isFun();

    @JvmName(name = "isInner")
    boolean isInner();

    boolean isInstance(Object value);

    @JvmName(name = "isOpen")
    boolean isOpen();

    @JvmName(name = "isSealed")
    boolean isSealed();

    @JvmName(name = "isValue")
    boolean isValue();
}
