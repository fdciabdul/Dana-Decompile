package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ViewDropdownMyBillsBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final EditText KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaDividerView MyBillsEntityDataFactory;
    public final RelativeLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final ImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final ConstraintLayout getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final TextView lookAheadTest;
    public final ProgressBar moveToNextValue;
    public final RecyclerView scheduleImpl;

    private ViewDropdownMyBillsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, DanaDividerView danaDividerView, EditText editText, AppCompatImageView appCompatImageView, ImageView imageView, ProgressBar progressBar, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.getErrorConfigVersion = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.MyBillsEntityDataFactory = danaDividerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = editText;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = imageView;
        this.moveToNextValue = progressBar;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = relativeLayout;
        this.scheduleImpl = recyclerView;
        this.lookAheadTest = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView2;
        this.DatabaseTableConfigUtil = textView3;
        this.initRecordTimeStamp = textView4;
    }

    public static ViewDropdownMyBillsBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d0512_networkuserentitydata_externalsyntheticlambda5, (ViewGroup) null, false);
        int i = R.id.clDropdownContainer;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.res_0x7f0a05b7_summaryvoucherview_externalsyntheticlambda1;
            DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaDividerView != null) {
                i = R.id.etDropdownSelectedName;
                EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (editText != null) {
                    i = R.id.ivDropdownArrow;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.ivDropdownSelectedIcon;
                        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (imageView != null) {
                            i = R.id.res_0x7f0a0f9b_promocategorypresenter_1;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (progressBar != null) {
                                i = R.id.rlStatusIndicator;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (relativeLayout != null) {
                                    i = R.id.isRegionMiniProgram_res_0x7f0a10ef;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (recyclerView != null) {
                                        i = R.id.res_0x7f0a1446_unicastprocessor_unicastqueuesubscription;
                                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (textView != null) {
                                            i = R.id.tvDropdownSelectedValue;
                                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                            if (textView2 != null) {
                                                i = R.id.onTooManyRedirects_res_0x7f0a1448;
                                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                if (textView3 != null) {
                                                    i = R.id.tvLabelInformation;
                                                    TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                    if (textView4 != null) {
                                                        return new ViewDropdownMyBillsBinding((ConstraintLayout) inflate, constraintLayout, danaDividerView, editText, appCompatImageView, imageView, progressBar, relativeLayout, recyclerView, textView, textView2, textView3, textView4);
                                                    }
                                                }
                                            }
                                        }
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
        return this.getErrorConfigVersion;
    }
}
