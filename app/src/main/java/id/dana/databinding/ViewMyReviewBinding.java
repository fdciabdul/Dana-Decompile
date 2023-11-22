package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.drawable.view.RatingStarView;

/* loaded from: classes4.dex */
public final class ViewMyReviewBinding implements ViewBinding {
    public final Barrier BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout GetContactSyncConfig;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonGhostView MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Barrier PlaceComponentResult;
    public final ShapeableImageView getAuthRequestContext;
    public final RatingStarView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private ViewMyReviewBinding(ConstraintLayout constraintLayout, Barrier barrier, DanaButtonGhostView danaButtonGhostView, ShapeableImageView shapeableImageView, Barrier barrier2, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view, RatingStarView ratingStarView) {
        this.GetContactSyncConfig = constraintLayout;
        this.PlaceComponentResult = barrier;
        this.MyBillsEntityDataFactory = danaButtonGhostView;
        this.getAuthRequestContext = shapeableImageView;
        this.BuiltInFictitiousFunctionClassFactory = barrier2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.scheduleImpl = appCompatTextView;
        this.moveToNextValue = appCompatTextView2;
        this.lookAheadTest = appCompatTextView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.getErrorConfigVersion = ratingStarView;
    }

    public static ViewMyReviewBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.barrier;
        Barrier barrier = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.barrier);
        if (barrier != null) {
            DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnEdit);
            if (danaButtonGhostView != null) {
                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3854res_0x7f0a09f8_r8_lambda_npxyyf3zgc_tldyljuapq7cvou4);
                if (shapeableImageView != null) {
                    Barrier barrier2 = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.photosBarrier);
                    if (barrier2 != null) {
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.PathRelativizer);
                        if (recyclerView != null) {
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.onBluetoothCharacteristicValueChange);
                            if (appCompatTextView != null) {
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4315res_0x7f0a1549_newwalletpresenter_getinvestmentcardassets_2);
                                if (appCompatTextView2 != null) {
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.RecentRecipientEntityRepository);
                                    if (appCompatTextView3 != null) {
                                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vDivider);
                                        if (BuiltInFictitiousFunctionClassFactory != null) {
                                            RatingStarView ratingStarView = (RatingStarView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.DanapolyRewardsEntityRepository_Factory);
                                            if (ratingStarView != null) {
                                                return new ViewMyReviewBinding((ConstraintLayout) view, barrier, danaButtonGhostView, shapeableImageView, barrier2, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3, BuiltInFictitiousFunctionClassFactory, ratingStarView);
                                            }
                                            i = R.id.DanapolyRewardsEntityRepository_Factory;
                                        } else {
                                            i = R.id.vDivider;
                                        }
                                    } else {
                                        i = R.id.RecentRecipientEntityRepository;
                                    }
                                } else {
                                    i = R.id.f4315res_0x7f0a1549_newwalletpresenter_getinvestmentcardassets_2;
                                }
                            } else {
                                i = R.id.onBluetoothCharacteristicValueChange;
                            }
                        } else {
                            i = R.id.PathRelativizer;
                        }
                    } else {
                        i = R.id.photosBarrier;
                    }
                } else {
                    i = R.id.f3854res_0x7f0a09f8_r8_lambda_npxyyf3zgc_tldyljuapq7cvou4;
                }
            } else {
                i = R.id.btnEdit;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }
}
