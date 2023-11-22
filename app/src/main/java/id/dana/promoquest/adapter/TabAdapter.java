package id.dana.promoquest.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014"}, d2 = {"Lid/dana/promoquest/adapter/TabAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "Landroidx/fragment/app/Fragment;", "p0", "", "p1", "", "p2", "", "PlaceComponentResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/CharSequence;)V", "", "getCount", "()I", "getAuthRequestContext", "(I)Landroidx/fragment/app/Fragment;", "getPageTitle", "(I)Ljava/lang/CharSequence;", "Ljava/util/ArrayList;", "MyBillsEntityDataFactory", "Ljava/util/ArrayList;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TabAdapter extends FragmentStatePagerAdapter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ArrayList<Fragment> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ArrayList<CharSequence> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        this.PlaceComponentResult = new ArrayList<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
    }

    public final void PlaceComponentResult(Fragment p0, String p1, CharSequence p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Bundle arguments = p0.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        p0.setArguments(arguments);
        Bundle arguments2 = p0.getArguments();
        if (arguments2 != null) {
            arguments2.putString("TabAdapter.key", p1);
        }
        this.PlaceComponentResult.add(p0);
        this.KClassImpl$Data$declaredNonStaticMembers$2.add(p2);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public final Fragment getAuthRequestContext(int p0) {
        Fragment fragment = this.PlaceComponentResult.get(p0);
        Intrinsics.checkNotNullExpressionValue(fragment, "");
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.PlaceComponentResult.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int p0) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0);
    }
}
