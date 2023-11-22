package kotlin.properties;

import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J$\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H¦\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/properties/PropertyDelegateProvider;", "T", SummaryActivity.DAYS, "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "provideDelegate", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface PropertyDelegateProvider<T, D> {
    D provideDelegate(T thisRef, KProperty<?> property);
}
