package id.dana.myprofile;

import android.view.View;
import android.widget.Button;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.base.BaseWithToolbarFragment_ViewBinding;
import id.dana.richview.SimpleProfileWithQrView;

/* loaded from: classes9.dex */
public class MyProfileFragment_ViewBinding extends BaseWithToolbarFragment_ViewBinding {
    private MyProfileFragment BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;

    public MyProfileFragment_ViewBinding(final MyProfileFragment myProfileFragment, View view) {
        super(myProfileFragment, view);
        this.BuiltInFictitiousFunctionClassFactory = myProfileFragment;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_verify, "field 'buttonVerify' and method 'onKycClick'");
        myProfileFragment.buttonVerify = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.btn_verify, "field 'buttonVerify'", Button.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.myprofile.MyProfileFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                myProfileFragment.onKycClick(view2);
            }
        });
        myProfileFragment.nsvProfile = (NestedScrollView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.nsv_profile, "field 'nsvProfile'", NestedScrollView.class);
        myProfileFragment.profileView = (SimpleProfileWithQrView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.profile, "field 'profileView'", SimpleProfileWithQrView.class);
        myProfileFragment.rvProfileSetting = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_profile_setting, "field 'rvProfileSetting'", RecyclerView.class);
    }

    @Override // id.dana.base.BaseWithToolbarFragment_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        MyProfileFragment myProfileFragment = this.BuiltInFictitiousFunctionClassFactory;
        if (myProfileFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        myProfileFragment.buttonVerify = null;
        myProfileFragment.nsvProfile = null;
        myProfileFragment.profileView = null;
        myProfileFragment.rvProfileSetting = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        super.getAuthRequestContext();
    }
}
