package id.dana.social.utils;

import id.dana.social.base.FriendshipListBaseFragment;
import id.dana.social.view.fragment.FollowerListFragment;
import id.dana.social.view.fragment.FollowingListFragment;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/utils/FriendshipListFactory;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendshipListFactory {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/social/utils/FriendshipListFactory$Companion;", "", "", "p0", "Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;", "p1", "Lid/dana/social/base/FriendshipListBaseFragment;", "BuiltInFictitiousFunctionClassFactory", "(ILid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;)Lid/dana/social/base/FriendshipListBaseFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FriendshipListBaseFragment BuiltInFictitiousFunctionClassFactory(int p0, FriendshipListBaseFragment.ShowSnackbarInterface p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            if (p0 != 0) {
                if (p0 == 1) {
                    return new FollowerListFragment(p1);
                }
                return new FollowerListFragment(p1);
            }
            return new FollowingListFragment(p1);
        }
    }
}
