package id.dana.challenge;

import androidx.fragment.app.FragmentManager;
import id.dana.base.BaseFragment;
import id.dana.base.BaseFragmentPagerStateAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/challenge/ChallengeFragmentStateAdapter;", "Lid/dana/base/BaseFragmentPagerStateAdapter;", "Landroidx/fragment/app/FragmentManager;", "p0", "", "Lid/dana/base/BaseFragment;", "p1", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChallengeFragmentStateAdapter extends BaseFragmentPagerStateAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeFragmentStateAdapter(FragmentManager fragmentManager, List<? extends BaseFragment> list) {
        super(fragmentManager, list);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(list, "");
    }
}
