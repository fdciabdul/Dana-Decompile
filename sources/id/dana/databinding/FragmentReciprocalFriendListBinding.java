package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.richview.SearchView;

/* loaded from: classes4.dex */
public final class FragmentReciprocalFriendListBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    private final FrameLayout GetContactSyncConfig;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    public final LinearLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final SearchView moveToNextValue;
    public final RecyclerView scheduleImpl;

    private FragmentReciprocalFriendListBinding(FrameLayout frameLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, SearchView searchView, TextView textView, TextView textView2) {
        this.GetContactSyncConfig = frameLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = frameLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout3;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.getErrorConfigVersion = linearLayout;
        this.scheduleImpl = recyclerView;
        this.moveToNextValue = searchView;
        this.lookAheadTest = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
    }

    public static FragmentReciprocalFriendListBinding PlaceComponentResult(View view) {
        int i = R.id.f3504res_0x7f0a01b0_flowviewutil_textchanges_1;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3504res_0x7f0a01b0_flowviewutil_textchanges_1);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3589onTooManyRedirects_res_0x7f0a0352);
            if (constraintLayout != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.fl_add_friend);
                if (frameLayout2 != null) {
                    ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_pull_up);
                    if (imageView != null) {
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_friendlist);
                        if (linearLayout != null) {
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_friends_list);
                            if (recyclerView != null) {
                                SearchView searchView = (SearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.sv_friend_list_search);
                                if (searchView != null) {
                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_friend_list_title);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_setting_title);
                                        if (textView2 != null) {
                                            return new FragmentReciprocalFriendListBinding(frameLayout, danaButtonPrimaryView, constraintLayout, frameLayout, frameLayout2, imageView, linearLayout, recyclerView, searchView, textView, textView2);
                                        }
                                        i = R.id.tv_setting_title;
                                    } else {
                                        i = R.id.tv_friend_list_title;
                                    }
                                } else {
                                    i = R.id.sv_friend_list_search;
                                }
                            } else {
                                i = R.id.rv_friends_list;
                            }
                        } else {
                            i = R.id.ll_friendlist;
                        }
                    } else {
                        i = R.id.iv_pull_up;
                    }
                } else {
                    i = R.id.fl_add_friend;
                }
            } else {
                i = R.id.f3589onTooManyRedirects_res_0x7f0a0352;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }
}
