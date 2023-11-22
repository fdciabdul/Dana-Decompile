package kotlin.reflect;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/KDeclarationContainer;", "", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "members"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface KDeclarationContainer {
    @JvmName(name = "getMembers")
    Collection<KCallable<?>> getMembers();
}
