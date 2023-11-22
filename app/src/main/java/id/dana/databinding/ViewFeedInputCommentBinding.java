package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewFeedInputCommentBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatEditText KClassImpl$Data$declaredNonStaticMembers$2;
    public final Barrier MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final AppCompatImageView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatImageView scheduleImpl;

    private ViewFeedInputCommentBinding(ConstraintLayout constraintLayout, Barrier barrier, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.MyBillsEntityDataFactory = barrier;
        this.PlaceComponentResult = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatEditText;
        this.getAuthRequestContext = appCompatImageView;
        this.scheduleImpl = appCompatImageView2;
        this.lookAheadTest = appCompatImageView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView;
        this.moveToNextValue = appCompatTextView2;
    }

    public static ViewFeedInputCommentBinding getAuthRequestContext(View view) {
        int i = R.id.barrierReply;
        Barrier barrier = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.barrierReply);
        if (barrier != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_reply_comment);
            if (constraintLayout2 != null) {
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.et_input_comment);
                if (appCompatEditText != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivCloseReply);
                    if (appCompatImageView != null) {
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivReply);
                        if (appCompatImageView2 != null) {
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_submit_comment);
                            if (appCompatImageView3 != null) {
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvReplyComment);
                                if (appCompatTextView != null) {
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvReplyName);
                                    if (appCompatTextView2 != null) {
                                        return new ViewFeedInputCommentBinding(constraintLayout, barrier, constraintLayout, constraintLayout2, appCompatEditText, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatTextView, appCompatTextView2);
                                    }
                                    i = R.id.tvReplyName;
                                } else {
                                    i = R.id.tvReplyComment;
                                }
                            } else {
                                i = R.id.iv_submit_comment;
                            }
                        } else {
                            i = R.id.ivReply;
                        }
                    } else {
                        i = R.id.ivCloseReply;
                    }
                } else {
                    i = R.id.et_input_comment;
                }
            } else {
                i = R.id.cl_reply_comment;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
