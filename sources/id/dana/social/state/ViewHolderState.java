package id.dana.social.state;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0001:\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0004\t\n\u000b\f"}, d2 = {"Lid/dana/social/state/ViewHolderState;", "", "T", "<init>", "()V", "Empty", "Item", "LoadingMore", "Shimmer", "Lid/dana/social/state/ViewHolderState$Item;", "Lid/dana/social/state/ViewHolderState$LoadingMore;", "Lid/dana/social/state/ViewHolderState$Shimmer;", "Lid/dana/social/state/ViewHolderState$Empty;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ViewHolderState<T> {
    public /* synthetic */ ViewHolderState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ViewHolderState() {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00028\u0001X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/social/state/ViewHolderState$Item;", "", "T", "Lid/dana/social/state/ViewHolderState;", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/Object;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Item<T> extends ViewHolderState<T> {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final T BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof Item) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((Item) p0).BuiltInFictitiousFunctionClassFactory);
        }

        public final int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Item(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(T t) {
            super(null);
            Intrinsics.checkNotNullParameter(t, "");
            this.BuiltInFictitiousFunctionClassFactory = t;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/social/state/ViewHolderState$LoadingMore;", "Lid/dana/social/state/ViewHolderState;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LoadingMore extends ViewHolderState {
        public static final LoadingMore INSTANCE = new LoadingMore();

        private LoadingMore() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/social/state/ViewHolderState$Shimmer;", "Lid/dana/social/state/ViewHolderState;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Shimmer extends ViewHolderState {
        public static final Shimmer INSTANCE = new Shimmer();

        private Shimmer() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/social/state/ViewHolderState$Empty;", "Lid/dana/social/state/ViewHolderState;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Empty extends ViewHolderState {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
            super(null);
        }
    }
}
