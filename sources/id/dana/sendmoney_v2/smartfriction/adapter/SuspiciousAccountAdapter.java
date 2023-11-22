package id.dana.sendmoney_v2.smartfriction.adapter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B%\u0012\u0006\u0010\u0004\u001a\u00020\u0013\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0006\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "", "p0", "Landroidx/fragment/app/Fragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)Landroidx/fragment/app/Fragment;", "getItemCount", "()I", "Landroid/view/View;", "", "p1", "", "(Landroid/view/View;F)V", "", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "Landroidx/fragment/app/FragmentManager;", "Landroidx/lifecycle/Lifecycle;", "p2", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;Landroidx/lifecycle/Lifecycle;)V", "OnStoryClickedListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SuspiciousAccountAdapter extends FragmentStateAdapter implements ViewPager2.PageTransformer {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<Fragment> MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "", "", "PlaceComponentResult", "()V", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnStoryClickedListener {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuspiciousAccountAdapter(FragmentManager fragmentManager, List<? extends Fragment> list, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(lifecycle, "");
        this.MyBillsEntityDataFactory = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.MyBillsEntityDataFactory.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        return this.MyBillsEntityDataFactory.get(p0);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(View p0, float p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.setTranslationX(0.0f);
        p0.setAlpha(1.0f);
        p0.setScaleX(1.0f);
        p0.setScaleY(1.0f);
    }
}
