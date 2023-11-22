package id.dana.sendmoney.ui.globalsend.form.adapter;

import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.adapter.BaseViewPager2StateAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendFormVPAdapter;", "Lid/dana/core/ui/adapter/BaseViewPager2StateAdapter;", "Landroidx/fragment/app/FragmentManager;", "p0", "Landroidx/lifecycle/Lifecycle;", "p1", "", "Lid/dana/core/ui/BaseViewBindingFragment;", "p2", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendFormVPAdapter extends BaseViewPager2StateAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSendFormVPAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<? extends BaseViewBindingFragment<?>> list) {
        super(fragmentManager, lifecycle, list);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(lifecycle, "");
        Intrinsics.checkNotNullParameter(list, "");
    }
}
