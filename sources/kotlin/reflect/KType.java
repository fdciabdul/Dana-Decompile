package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028'X¦\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8'X¦\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lkotlin/reflect/KType;", "Lkotlin/reflect/KAnnotatedElement;", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "getArguments$annotations", "()V", "arguments", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getClassifier$annotations", "classifier", "", "isMarkedNullable", "()Z"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface KType extends KAnnotatedElement {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getArguments$annotations() {
        }

        public static /* synthetic */ void getClassifier$annotations() {
        }
    }

    @JvmName(name = "getArguments")
    List<KTypeProjection> getArguments();

    @JvmName(name = "getClassifier")
    KClassifier getClassifier();

    @JvmName(name = "isMarkedNullable")
    boolean isMarkedNullable();
}
