package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.reflect.KDeclarationContainer;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "jClass"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ClassBasedDeclarationContainer extends KDeclarationContainer {
    @JvmName(name = "getJClass")
    Class<?> getJClass();
}
