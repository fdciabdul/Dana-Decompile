package id.dana.social.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.databinding.ViewActivityReactionsListBinding;
import id.dana.social.model.ReactionCountModel;
import id.dana.social.view.fragment.ActivityReactionsListFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u001a\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0010j\b\u0012\u0004\u0012\u00020\u0019`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014"}, d2 = {"Lid/dana/social/adapter/ActivityReactionsViewPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "getCount", "()I", "p0", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "(I)Landroidx/fragment/app/Fragment;", "Landroid/view/ViewGroup;", "p1", "", "p2", "", "setPrimaryItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Ljava/util/ArrayList;", "Lid/dana/social/view/fragment/ActivityReactionsListFragment;", "Lkotlin/collections/ArrayList;", "getAuthRequestContext", "Ljava/util/ArrayList;", "PlaceComponentResult", "Landroid/content/Context;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/model/ReactionCountModel;", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroid/content/Context;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityReactionsViewPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ArrayList<ReactionCountModel> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ArrayList<ActivityReactionsListFragment> PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityReactionsViewPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.PlaceComponentResult = new ArrayList<>();
        this.getAuthRequestContext = new ArrayList<>();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public final Fragment MyBillsEntityDataFactory(int p0) {
        ActivityReactionsListFragment activityReactionsListFragment = this.PlaceComponentResult.get(p0);
        Intrinsics.checkNotNullExpressionValue(activityReactionsListFragment, "");
        return activityReactionsListFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.PlaceComponentResult.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup p0, int p1, Object p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        super.setPrimaryItem(p0, p1, p2);
        int size = this.PlaceComponentResult.size();
        int i = 0;
        while (i < size) {
            ActivityReactionsListFragment activityReactionsListFragment = this.PlaceComponentResult.get(i);
            boolean z = p1 == i;
            if (activityReactionsListFragment.isViewBinded()) {
                ViewActivityReactionsListBinding binding = activityReactionsListFragment.getBinding();
                RecyclerView recyclerView = binding != null ? binding.getAuthRequestContext : null;
                if (recyclerView != null) {
                    recyclerView.setNestedScrollingEnabled(z);
                }
            }
            i++;
        }
        p0.requestLayout();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0012\u0010\u0012\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/social/adapter/ActivityReactionsViewPagerAdapter$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/social/model/ReactionCountModel;", "PlaceComponentResult", "Lid/dana/social/model/ReactionCountModel;", "MyBillsEntityDataFactory", "p1", "p2", "<init>", "(Ljava/lang/String;Lid/dana/social/model/ReactionCountModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {
        public String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public ReactionCountModel MyBillsEntityDataFactory;
        public String getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, params.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, params.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, params.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, ReactionCountModel reactionCountModel, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(reactionCountModel, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = reactionCountModel;
            this.getAuthRequestContext = str2;
        }
    }
}
