package id.dana.social;

import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.social.fragment.FriendsFeedsFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/FeedsFragment;", "", BridgeDSL.INVOKE, "(Lid/dana/social/FeedsFragment;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeedsFragment$toFriendTab$1 extends Lambda implements Function1<FeedsFragment, Unit> {
    final /* synthetic */ String $$source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsFragment$toFriendTab$1(String str) {
        super(1);
        this.$$source = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(FeedsFragment feedsFragment) {
        invoke2(feedsFragment);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final FeedsFragment feedsFragment) {
        Intrinsics.checkNotNullParameter(feedsFragment, "");
        ViewPager2 viewPager2 = (ViewPager2) feedsFragment.PlaceComponentResult(R.id.LogFileLogAppender);
        if (viewPager2 != null) {
            final String str = this.$$source;
            viewPager2.post(new Runnable() { // from class: id.dana.social.FeedsFragment$toFriendTab$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FeedsFragment$toFriendTab$1.m2952invoke$lambda1(FeedsFragment.this, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m2952invoke$lambda1(FeedsFragment feedsFragment, String str) {
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter;
        Intrinsics.checkNotNullParameter(feedsFragment, "");
        baseTabFragmentAdapter = feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseTabFragmentAdapter = null;
        }
        if (baseTabFragmentAdapter.getPlaceComponentResult() > 1 && (baseTabFragmentAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0.get(1) instanceof FriendsFeedsFragment)) {
            ((ViewPager2) feedsFragment.PlaceComponentResult(R.id.LogFileLogAppender)).setCurrentItem(1);
            FeedsFragment.MyBillsEntityDataFactory(feedsFragment, str);
            FeedsFragment.lookAheadTest(feedsFragment);
        }
        feedsFragment.PlaceComponentResult();
    }
}
