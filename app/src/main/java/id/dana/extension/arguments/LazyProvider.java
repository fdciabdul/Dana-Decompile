package id.dana.extension.arguments;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J*\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H¦\u0002¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/extension/arguments/LazyProvider;", "A", "T", "", "p0", "Lkotlin/reflect/KProperty;", "p1", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lkotlin/Lazy;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface LazyProvider<A, T> {
    Lazy<T> KClassImpl$Data$declaredNonStaticMembers$2(A p0, KProperty<?> p1);
}
