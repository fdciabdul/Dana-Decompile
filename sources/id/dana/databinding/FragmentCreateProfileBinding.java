package id.dana.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes8.dex */
public final class FragmentCreateProfileBinding implements ViewBinding {
    public final CircleImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    private final RelativeLayout PlaceComponentResult;
    public final EditText getAuthRequestContext;

    private FragmentCreateProfileBinding(RelativeLayout relativeLayout, TextView textView, CircleImageView circleImageView, EditText editText, TextView textView2) {
        this.PlaceComponentResult = relativeLayout;
        this.MyBillsEntityDataFactory = textView;
        this.BuiltInFictitiousFunctionClassFactory = circleImageView;
        this.getAuthRequestContext = editText;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView2;
    }

    public static FragmentCreateProfileBinding getAuthRequestContext(View view) {
        int i = R.id.header;
        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.header);
        if (textView != null) {
            CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4078x49e4d33e);
            if (circleImageView != null) {
                EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.profile_name);
                if (editText != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.steps);
                    if (textView2 != null) {
                        return new FragmentCreateProfileBinding((RelativeLayout) view, textView, circleImageView, editText, textView2);
                    }
                    i = R.id.steps;
                } else {
                    i = R.id.profile_name;
                }
            } else {
                i = R.id.f4078x49e4d33e;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
