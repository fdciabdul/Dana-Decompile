package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.social.view.ReactionView;

/* loaded from: classes4.dex */
public final class ViewFeedReactionSectionBinding implements ViewBinding {
    public final ReactionView BuiltInFictitiousFunctionClassFactory;
    public final View GetContactSyncConfig;
    public final ReactionView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ReactionView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final TextView PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final View initRecordTimeStamp;
    public final View lookAheadTest;
    public final ConstraintLayout moveToNextValue;
    public final LinearLayout scheduleImpl;

    private ViewFeedReactionSectionBinding(ConstraintLayout constraintLayout, ReactionView reactionView, ReactionView reactionView2, ReactionView reactionView3, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, ConstraintLayout constraintLayout2, View view, View view2, View view3, View view4) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = reactionView;
        this.BuiltInFictitiousFunctionClassFactory = reactionView2;
        this.MyBillsEntityDataFactory = reactionView3;
        this.getAuthRequestContext = recyclerView;
        this.PlaceComponentResult = textView;
        this.getErrorConfigVersion = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView3;
        this.scheduleImpl = linearLayout;
        this.moveToNextValue = constraintLayout2;
        this.lookAheadTest = view;
        this.GetContactSyncConfig = view2;
        this.initRecordTimeStamp = view3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = view4;
    }

    public static ViewFeedReactionSectionBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.reaction_add_new;
        ReactionView reactionView = (ReactionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.reaction_add_new);
        if (reactionView != null) {
            ReactionView reactionView2 = (ReactionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.reaction_dummy);
            if (reactionView2 != null) {
                ReactionView reactionView3 = (ReactionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.reaction_more);
                if (reactionView3 != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_reactions);
                    if (recyclerView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_comment_section_info);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_reactions_empty_state_view);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_saymoji_section_info);
                                if (textView3 != null) {
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vg_reaction_section_info_wrapper);
                                    if (linearLayout != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_barrier_reaction_section_separator);
                                        if (BuiltInFictitiousFunctionClassFactory != null) {
                                            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_reaction_bottom_white_space);
                                            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_reaction_section_rv_ruler);
                                                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                    View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_reaction_section_separator);
                                                    if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                                        return new ViewFeedReactionSectionBinding(constraintLayout, reactionView, reactionView2, reactionView3, recyclerView, textView, textView2, textView3, linearLayout, constraintLayout, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4);
                                                    }
                                                    i = R.id.view_reaction_section_separator;
                                                } else {
                                                    i = R.id.view_reaction_section_rv_ruler;
                                                }
                                            } else {
                                                i = R.id.view_reaction_bottom_white_space;
                                            }
                                        } else {
                                            i = R.id.view_barrier_reaction_section_separator;
                                        }
                                    } else {
                                        i = R.id.vg_reaction_section_info_wrapper;
                                    }
                                } else {
                                    i = R.id.tv_saymoji_section_info;
                                }
                            } else {
                                i = R.id.tv_reactions_empty_state_view;
                            }
                        } else {
                            i = R.id.tv_comment_section_info;
                        }
                    } else {
                        i = R.id.rv_reactions;
                    }
                } else {
                    i = R.id.reaction_more;
                }
            } else {
                i = R.id.reaction_dummy;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }
}
