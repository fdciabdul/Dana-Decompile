package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.richview.SearchView;

/* loaded from: classes4.dex */
public final class FragmentAddFriendBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final TextView GetContactSyncConfig;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final DanaButtonSecondaryView PlaceComponentResult;
    public final Group getAuthRequestContext;
    public final ImageView getErrorConfigVersion;
    private final FrameLayout initRecordTimeStamp;
    public final SearchView lookAheadTest;
    public final AppCompatImageView moveToNextValue;
    public final AppCompatImageView scheduleImpl;

    private FragmentAddFriendBinding(FrameLayout frameLayout, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout2, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, RecyclerView recyclerView, SearchView searchView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.initRecordTimeStamp = frameLayout;
        this.PlaceComponentResult = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout2;
        this.getAuthRequestContext = group;
        this.scheduleImpl = appCompatImageView;
        this.moveToNextValue = appCompatImageView2;
        this.getErrorConfigVersion = imageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.lookAheadTest = searchView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView;
        this.DatabaseTableConfigUtil = textView2;
        this.GetContactSyncConfig = textView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView4;
    }

    public static FragmentAddFriendBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.btnTryAgain;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnTryAgain);
        if (danaButtonSecondaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3589onTooManyRedirects_res_0x7f0a0352);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clErrorState);
                if (constraintLayout2 != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.groupErrorState);
                    if (group != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivBackButton);
                        if (appCompatImageView != null) {
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivErrorState);
                            if (appCompatImageView2 != null) {
                                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_pull_up);
                                if (imageView != null) {
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_friends_list);
                                    if (recyclerView != null) {
                                        SearchView searchView = (SearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.sv_friend_list_search);
                                        if (searchView != null) {
                                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvEmptyResultDesc);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.MerchantReviewFormAnalyticTracker);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvErrorTitle);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_friend_list_title);
                                                        if (textView4 != null) {
                                                            return new FragmentAddFriendBinding(frameLayout, danaButtonSecondaryView, constraintLayout, constraintLayout2, frameLayout, group, appCompatImageView, appCompatImageView2, imageView, recyclerView, searchView, textView, textView2, textView3, textView4);
                                                        }
                                                        i = R.id.tv_friend_list_title;
                                                    } else {
                                                        i = R.id.tvErrorTitle;
                                                    }
                                                } else {
                                                    i = R.id.MerchantReviewFormAnalyticTracker;
                                                }
                                            } else {
                                                i = R.id.tvEmptyResultDesc;
                                            }
                                        } else {
                                            i = R.id.sv_friend_list_search;
                                        }
                                    } else {
                                        i = R.id.rv_friends_list;
                                    }
                                } else {
                                    i = R.id.iv_pull_up;
                                }
                            } else {
                                i = R.id.ivErrorState;
                            }
                        } else {
                            i = R.id.ivBackButton;
                        }
                    } else {
                        i = R.id.groupErrorState;
                    }
                } else {
                    i = R.id.clErrorState;
                }
            } else {
                i = R.id.f3589onTooManyRedirects_res_0x7f0a0352;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.initRecordTimeStamp;
    }
}
