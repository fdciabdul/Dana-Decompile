package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.landing.view.GroupCircleImageRichView;

/* loaded from: classes5.dex */
public final class ItemGroupSendBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final GroupCircleImageRichView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final ConstraintLayout lookAheadTest;
    public final TextView moveToNextValue;

    private ItemGroupSendBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, GroupCircleImageRichView groupCircleImageRichView, CircleImageView circleImageView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = groupCircleImageRichView;
        this.MyBillsEntityDataFactory = circleImageView;
        this.getAuthRequestContext = appCompatImageView;
        this.PlaceComponentResult = constraintLayout2;
        this.lookAheadTest = constraintLayout3;
        this.getErrorConfigVersion = textView;
        this.moveToNextValue = textView2;
    }

    public static ItemGroupSendBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.getValueOfTouchPositionAbsolute, viewGroup, false);
        int i = R.id.newProxyInstance_res_0x7f0a0192;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonSecondaryView != null) {
            i = R.id.groupCircleImageView;
            GroupCircleImageRichView groupCircleImageRichView = (GroupCircleImageRichView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (groupCircleImageRichView != null) {
                i = R.id.ivAvatarGroup;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (circleImageView != null) {
                    i = R.id.isInfoWindowShown;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.res_0x7f0a108a_setindex_kotlin_stdlib;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (constraintLayout != null) {
                            i = R.id.rlTopSectionGroupSend;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (constraintLayout2 != null) {
                                i = R.id.CreateCredentialCustomException;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView != null) {
                                    i = R.id.res_0x7f0a15cf_access_setgotomylocationvisibility;
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView2 != null) {
                                        return new ItemGroupSendBinding((ConstraintLayout) inflate, danaButtonSecondaryView, groupCircleImageRichView, circleImageView, appCompatImageView, constraintLayout, constraintLayout2, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
