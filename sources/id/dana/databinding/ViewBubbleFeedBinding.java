package id.dana.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.social.view.ReactionSectionView;

/* loaded from: classes4.dex */
public final class ViewBubbleFeedBinding implements ViewBinding {
    public final ImageButton BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final View GetContactSyncConfig;
    public final Barrier KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageButton MyBillsEntityDataFactory;
    public final ImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final ConstraintLayout PlaceComponentResult;
    public final View PrepareContext;
    public final ConstraintLayout getAuthRequestContext;
    public final View getErrorConfigVersion;
    public final Space initRecordTimeStamp;
    public final TextView isLayoutRequested;
    public final ReactionSectionView lookAheadTest;
    public final ImageButton moveToNextValue;
    public final ConstraintLayout scheduleImpl;

    private ViewBubbleFeedBinding(ConstraintLayout constraintLayout, Barrier barrier, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageView imageView, ReactionSectionView reactionSectionView, ConstraintLayout constraintLayout4, View view, Space space, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = barrier;
        this.PlaceComponentResult = constraintLayout2;
        this.getAuthRequestContext = constraintLayout3;
        this.MyBillsEntityDataFactory = imageButton;
        this.BuiltInFictitiousFunctionClassFactory = imageButton2;
        this.moveToNextValue = imageButton3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = imageView;
        this.lookAheadTest = reactionSectionView;
        this.scheduleImpl = constraintLayout4;
        this.getErrorConfigVersion = view;
        this.initRecordTimeStamp = space;
        this.GetContactSyncConfig = view2;
        this.DatabaseTableConfigUtil = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView3;
        this.isLayoutRequested = textView4;
        this.PrepareContext = view3;
    }

    public static ViewBubbleFeedBinding PlaceComponentResult(View view) {
        Barrier barrier = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.barrier_button);
        int i = R.id.cl_feed;
        if (barrier != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_caption);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_feed);
                if (constraintLayout2 != null) {
                    ImageButton imageButton = (ImageButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ib_bubble_feed_add_comment);
                    if (imageButton != null) {
                        ImageButton imageButton2 = (ImageButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ib_bubble_feed_add_saymoji);
                        if (imageButton2 != null) {
                            ImageButton imageButton3 = (ImageButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ib_bubble_feed_retry);
                            if (imageButton3 != null) {
                                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_top_left_bubble);
                                if (imageView != null) {
                                    ReactionSectionView reactionSectionView = (ReactionSectionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.reaction_section_view);
                                    if (reactionSectionView != null) {
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.separator);
                                        if (BuiltInFictitiousFunctionClassFactory != null) {
                                            Space space = (Space) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.space);
                                            if (space != null) {
                                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.triangle_spacer);
                                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_caption);
                                                    if (textView != null) {
                                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.saveMonthOfFetchFreeTransfer);
                                                        if (textView2 != null) {
                                                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_desc);
                                                            if (textView3 != null) {
                                                                TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_share_feed_description);
                                                                if (textView4 != null) {
                                                                    View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_bubble_feed_bg);
                                                                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                                        return new ViewBubbleFeedBinding(constraintLayout3, barrier, constraintLayout, constraintLayout2, imageButton, imageButton2, imageButton3, imageView, reactionSectionView, constraintLayout3, BuiltInFictitiousFunctionClassFactory, space, BuiltInFictitiousFunctionClassFactory2, textView, textView2, textView3, textView4, BuiltInFictitiousFunctionClassFactory3);
                                                                    }
                                                                    i = R.id.view_bubble_feed_bg;
                                                                } else {
                                                                    i = R.id.tv_share_feed_description;
                                                                }
                                                            } else {
                                                                i = R.id.tv_desc;
                                                            }
                                                        } else {
                                                            i = R.id.saveMonthOfFetchFreeTransfer;
                                                        }
                                                    } else {
                                                        i = R.id.tv_caption;
                                                    }
                                                } else {
                                                    i = R.id.triangle_spacer;
                                                }
                                            } else {
                                                i = R.id.space;
                                            }
                                        } else {
                                            i = R.id.separator;
                                        }
                                    } else {
                                        i = R.id.reaction_section_view;
                                    }
                                } else {
                                    i = R.id.iv_top_left_bubble;
                                }
                            } else {
                                i = R.id.ib_bubble_feed_retry;
                            }
                        } else {
                            i = R.id.ib_bubble_feed_add_saymoji;
                        }
                    } else {
                        i = R.id.ib_bubble_feed_add_comment;
                    }
                }
            } else {
                i = R.id.cl_caption;
            }
        } else {
            i = R.id.barrier_button;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }
}
