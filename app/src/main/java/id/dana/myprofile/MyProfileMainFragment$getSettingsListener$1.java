package id.dana.myprofile;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import id.dana.databinding.FragmentMyprofileMainBinding;
import id.dana.myprofile.MyProfileMainFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/myprofile/MyProfileMainFragment$getSettingsListener$1;", "Lid/dana/myprofile/MyProfileMainFragment$SettingsListener;", "Lkotlin/Function0;", "", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyProfileMainFragment$getSettingsListener$1 implements MyProfileMainFragment.SettingsListener {
    final /* synthetic */ MyProfileMainFragment KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyProfileMainFragment$getSettingsListener$1(MyProfileMainFragment myProfileMainFragment) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myProfileMainFragment;
    }

    @Override // id.dana.myprofile.MyProfileMainFragment.SettingsListener
    public final void PlaceComponentResult(final Function0<Unit> p0) {
        FragmentMyprofileMainBinding binding;
        AppCompatImageView appCompatImageView;
        Intrinsics.checkNotNullParameter(p0, "");
        binding = this.KClassImpl$Data$declaredNonStaticMembers$2.getBinding();
        if (binding == null || (appCompatImageView = binding.PlaceComponentResult) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.MyProfileMainFragment$getSettingsListener$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyProfileMainFragment$getSettingsListener$1.getAuthRequestContext(Function0.this);
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
