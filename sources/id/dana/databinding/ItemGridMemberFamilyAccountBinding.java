package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.richview.CircleImageSelectionView;

/* loaded from: classes4.dex */
public final class ItemGridMemberFamilyAccountBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageSelectionView MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final MaterialCardView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView scheduleImpl;

    private ItemGridMemberFamilyAccountBinding(MaterialCardView materialCardView, TextView textView, CircleImageSelectionView circleImageSelectionView, CircleImageView circleImageView, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TextView textView2, TextView textView3) {
        this.PlaceComponentResult = materialCardView;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = circleImageSelectionView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = circleImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.scheduleImpl = textView2;
        this.getErrorConfigVersion = textView3;
    }

    public static ItemGridMemberFamilyAccountBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_grid_member_family_account, viewGroup, false);
        int i = R.id.btnResend;
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnResend);
        if (textView != null) {
            CircleImageSelectionView circleImageSelectionView = (CircleImageSelectionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivMemberImage);
            if (circleImageSelectionView != null) {
                CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivMemberStatusIndicator);
                if (circleImageView != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivThreeDots);
                    if (appCompatImageView != null) {
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvServices);
                        if (recyclerView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvMemberInfo);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvMemberName);
                                if (textView3 != null) {
                                    return new ItemGridMemberFamilyAccountBinding((MaterialCardView) inflate, textView, circleImageSelectionView, circleImageView, appCompatImageView, recyclerView, textView2, textView3);
                                }
                                i = R.id.tvMemberName;
                            } else {
                                i = R.id.tvMemberInfo;
                            }
                        } else {
                            i = R.id.rvServices;
                        }
                    } else {
                        i = R.id.ivThreeDots;
                    }
                } else {
                    i = R.id.ivMemberStatusIndicator;
                }
            } else {
                i = R.id.ivMemberImage;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
