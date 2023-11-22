package id.dana.usereducation;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.core.ui.glide.ShimmerImageAttacherFactory;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.utils.ImageOss;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class SimpleBottomSheetOnBoardingView extends BaseSimpleView {
    ContentOnBoardingModel MyBillsEntityDataFactory;
    private int getAuthRequestContext;
    @BindView(R.id.iv_on_boarding_image)
    ImageView ivOnBoardingImage;
    @BindView(R.id.tv_on_boarding_body_text)
    TextView tvBodyText;
    @BindView(R.id.tv_on_boarding_subtitle)
    TextView tvSubtitle;

    @Override // id.dana.onboarding.view.BaseSimpleView
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return R.layout.view_simple_bottom_sheet_on_boarding;
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleBottomSheetOnBoardingView(int i, ContentOnBoardingModel contentOnBoardingModel) {
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = contentOnBoardingModel;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        ImageOss.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, this.ivOnBoardingImage, new ImageOss.EventListener() { // from class: id.dana.usereducation.SimpleBottomSheetOnBoardingView$$ExternalSyntheticLambda0
            @Override // id.dana.utils.ImageOss.EventListener
            public final void PlaceComponentResult(String str, ImageView imageView) {
                SimpleBottomSheetOnBoardingView simpleBottomSheetOnBoardingView = SimpleBottomSheetOnBoardingView.this;
                ShimmerImageAttacherFactory shimmerImageAttacherFactory = new ShimmerImageAttacherFactory();
                Context context = simpleBottomSheetOnBoardingView.KClassImpl$Data$declaredNonStaticMembers$2;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    context = null;
                }
                shimmerImageAttacherFactory.KClassImpl$Data$declaredNonStaticMembers$2(context, imageView, str, simpleBottomSheetOnBoardingView.MyBillsEntityDataFactory.getAuthRequestContext);
            }
        });
        this.tvSubtitle.setText(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        this.tvBodyText.setText(this.MyBillsEntityDataFactory.PlaceComponentResult);
        ImageView imageView = this.ivOnBoardingImage;
        Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        imageView.setContentDescription(String.format(context.getString(R.string.img_intro_), Integer.valueOf(this.getAuthRequestContext)));
        TextView textView = this.tvSubtitle;
        Context context3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context3 = null;
        }
        textView.setContentDescription(String.format(context3.getString(R.string.lbl_intro_title_), Integer.valueOf(this.getAuthRequestContext)));
        TextView textView2 = this.tvBodyText;
        Context context4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context4 != null) {
            context2 = context4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        textView2.setContentDescription(String.format(context2.getString(R.string.lbl_intro_text_), Integer.valueOf(this.getAuthRequestContext)));
    }
}
