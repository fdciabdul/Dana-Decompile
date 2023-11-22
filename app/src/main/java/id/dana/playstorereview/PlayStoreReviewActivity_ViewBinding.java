package id.dana.playstorereview;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class PlayStoreReviewActivity_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private PlayStoreReviewActivity KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;

    public PlayStoreReviewActivity_ViewBinding(final PlayStoreReviewActivity playStoreReviewActivity, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = playStoreReviewActivity;
        playStoreReviewActivity.clDialog = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_dialog, "field 'clDialog'", ConstraintLayout.class);
        playStoreReviewActivity.clMainRoot = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.main_root, "field 'clMainRoot'", ConstraintLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_play_store_review_yes, "method 'btnPlayStoreReviewYesClicked'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.playstorereview.PlayStoreReviewActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                playStoreReviewActivity.btnPlayStoreReviewYesClicked();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_play_store_review_no, "method 'btnPlayStoreReviewNoClicked'");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.playstorereview.PlayStoreReviewActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                playStoreReviewActivity.btnPlayStoreReviewNoClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PlayStoreReviewActivity playStoreReviewActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (playStoreReviewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        playStoreReviewActivity.clDialog = null;
        playStoreReviewActivity.clMainRoot = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
