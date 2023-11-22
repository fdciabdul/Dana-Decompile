package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewGroupCircleImageBinding implements ViewBinding {
    public final CircleImageView BuiltInFictitiousFunctionClassFactory;
    public final CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final CircleImageView PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;
    public final TextView moveToNextValue;
    public final CircleImageView scheduleImpl;

    private ViewGroupCircleImageBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, CircleImageView circleImageView2, FrameLayout frameLayout, CircleImageView circleImageView3, CircleImageView circleImageView4, CircleImageView circleImageView5, TextView textView) {
        this.lookAheadTest = constraintLayout;
        this.MyBillsEntityDataFactory = circleImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = circleImageView2;
        this.getAuthRequestContext = frameLayout;
        this.PlaceComponentResult = circleImageView3;
        this.BuiltInFictitiousFunctionClassFactory = circleImageView4;
        this.scheduleImpl = circleImageView5;
        this.moveToNextValue = textView;
    }

    public static ViewGroupCircleImageBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_group_circle_image, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a06e3_flowviewutil_textchanges_1;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.firstAvatar;
            CircleImageView circleImageView2 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (circleImageView2 != null) {
                i = R.id.flSumAvatar;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (frameLayout != null) {
                    i = R.id.fourthAvatar;
                    CircleImageView circleImageView3 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (circleImageView3 != null) {
                        i = R.id.setAkuEntranceOpen_res_0x7f0a11e2;
                        CircleImageView circleImageView4 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (circleImageView4 != null) {
                            i = R.id.res_0x7f0a1310_imagewithdescriptionview_showimage_1;
                            CircleImageView circleImageView5 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (circleImageView5 != null) {
                                i = R.id.SwitchFaceAuthContract;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView != null) {
                                    return new ViewGroupCircleImageBinding((ConstraintLayout) inflate, circleImageView, circleImageView2, frameLayout, circleImageView3, circleImageView4, circleImageView5, textView);
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
        return this.lookAheadTest;
    }
}
