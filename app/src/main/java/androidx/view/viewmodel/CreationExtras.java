package androidx.view.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0000¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006R#\u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0000¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras;", "", "T", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "p0", "PlaceComponentResult", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Map;", "MyBillsEntityDataFactory", "<init>", "()V", "Empty", "Key"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CreationExtras {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Map<Key<?>, Object> MyBillsEntityDataFactory = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "T", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Key<T> {
    }

    public abstract <T> T PlaceComponentResult(Key<T> p0);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras$Empty;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "T", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "p0", "PlaceComponentResult", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Empty extends CreationExtras {
        public static final Empty INSTANCE = new Empty();

        @Override // androidx.view.viewmodel.CreationExtras
        public final <T> T PlaceComponentResult(Key<T> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return null;
        }

        private Empty() {
        }
    }
}
