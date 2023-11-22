package id.dana.richview.socialshare;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes9.dex */
public class SocialShareView_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private SocialShareView getAuthRequestContext;

    public SocialShareView_ViewBinding(final SocialShareView socialShareView, View view) {
        this.getAuthRequestContext = socialShareView;
        socialShareView.llShareQr = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_share_qr, "field 'llShareQr'", LinearLayout.class);
        socialShareView.llShareFirst = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_share_first, "field 'llShareFirst'", LinearLayout.class);
        socialShareView.llShareSecond = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_share_second, "field 'llShareSecond'", LinearLayout.class);
        socialShareView.llShareThird = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_share_third, "field 'llShareThird'", LinearLayout.class);
        socialShareView.llShareOthers = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_share_others, "field 'llShareOthers'", LinearLayout.class);
        socialShareView.tvSocialShareTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_social_share_title, "field 'tvSocialShareTitle'", TextView.class);
        socialShareView.civSocialShareFirst = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.civ_social_share_first, "field 'civSocialShareFirst'", CircleImageView.class);
        socialShareView.civSocialShareSecond = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.civ_social_share_second, "field 'civSocialShareSecond'", CircleImageView.class);
        socialShareView.civSocialShareThird = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.civ_social_share_third, "field 'civSocialShareThird'", CircleImageView.class);
        socialShareView.tvSocialShareFirst = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_social_share_first, "field 'tvSocialShareFirst'", TextView.class);
        socialShareView.tvSocialShareSecond = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_social_share_second, "field 'tvSocialShareSecond'", TextView.class);
        socialShareView.tvSocialShareThird = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_social_share_third, "field 'tvSocialShareThird'", TextView.class);
        socialShareView.tvAppNameFirst = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_app_name_first, "field 'tvAppNameFirst'", TextView.class);
        socialShareView.tvAppNameSecond = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_app_name_second, "field 'tvAppNameSecond'", TextView.class);
        socialShareView.tvAppNameThird = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_app_name_third, "field 'tvAppNameThird'", TextView.class);
        socialShareView.llViewContainer = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_csv_container, "field 'llViewContainer'", LinearLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_social_share_others, "field 'tvSocialShareOthers' and method 'setOnClickOthers'");
        socialShareView.tvSocialShareOthers = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.tv_social_share_others, "field 'tvSocialShareOthers'", TextView.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.socialshare.SocialShareView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                socialShareView.setOnClickOthers();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3578civ_share_others, "method 'setOnClickOthers'");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.socialshare.SocialShareView_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                socialShareView.setOnClickOthers();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SocialShareView socialShareView = this.getAuthRequestContext;
        if (socialShareView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        socialShareView.llShareQr = null;
        socialShareView.llShareFirst = null;
        socialShareView.llShareSecond = null;
        socialShareView.llShareThird = null;
        socialShareView.llShareOthers = null;
        socialShareView.tvSocialShareTitle = null;
        socialShareView.civSocialShareFirst = null;
        socialShareView.civSocialShareSecond = null;
        socialShareView.civSocialShareThird = null;
        socialShareView.tvSocialShareFirst = null;
        socialShareView.tvSocialShareSecond = null;
        socialShareView.tvSocialShareThird = null;
        socialShareView.tvAppNameFirst = null;
        socialShareView.tvAppNameSecond = null;
        socialShareView.tvAppNameThird = null;
        socialShareView.llViewContainer = null;
        socialShareView.tvSocialShareOthers = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
