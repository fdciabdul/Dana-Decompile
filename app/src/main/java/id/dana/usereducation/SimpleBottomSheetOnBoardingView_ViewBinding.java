package id.dana.usereducation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SimpleBottomSheetOnBoardingView_ViewBinding implements Unbinder {
    private SimpleBottomSheetOnBoardingView KClassImpl$Data$declaredNonStaticMembers$2;

    public SimpleBottomSheetOnBoardingView_ViewBinding(SimpleBottomSheetOnBoardingView simpleBottomSheetOnBoardingView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = simpleBottomSheetOnBoardingView;
        simpleBottomSheetOnBoardingView.ivOnBoardingImage = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_on_boarding_image, "field 'ivOnBoardingImage'", ImageView.class);
        simpleBottomSheetOnBoardingView.tvSubtitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_on_boarding_subtitle, "field 'tvSubtitle'", TextView.class);
        simpleBottomSheetOnBoardingView.tvBodyText = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_on_boarding_body_text, "field 'tvBodyText'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SimpleBottomSheetOnBoardingView simpleBottomSheetOnBoardingView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (simpleBottomSheetOnBoardingView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        simpleBottomSheetOnBoardingView.ivOnBoardingImage = null;
        simpleBottomSheetOnBoardingView.tvSubtitle = null;
        simpleBottomSheetOnBoardingView.tvBodyText = null;
    }
}
