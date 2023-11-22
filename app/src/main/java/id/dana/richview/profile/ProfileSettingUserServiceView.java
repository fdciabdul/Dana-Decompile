package id.dana.richview.profile;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ViewProfileSettingUserServiceBinding;
import id.dana.myprofile.ProfileUserServiceType;
import id.dana.myprofile.SubtitleType;

/* loaded from: classes5.dex */
public class ProfileSettingUserServiceView extends ViewBindingRichView<ViewProfileSettingUserServiceBinding> {
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;
    private SkeletonScreen getAuthRequestContext;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_profile_setting_user_service;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    public ProfileSettingUserServiceView(Context context) {
        super(context);
    }

    public ProfileSettingUserServiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public ViewProfileSettingUserServiceBinding initViewBinding(View view) {
        return ViewProfileSettingUserServiceBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setView(String str, String str2, String str3, String str4, Boolean bool, String str5) {
        char c;
        int i;
        str3.hashCode();
        switch (str3.hashCode()) {
            case -2006050296:
                if (str3.equals("setting_my_bills")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1751430567:
                if (str3.equals(ProfileUserServiceType.LOGOUT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1169499887:
                if (str3.equals(ProfileUserServiceType.SAVING)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1043979156:
                if (str3.equals(ProfileUserServiceType.PROMO_CODE)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -784346227:
                if (str3.equals("setting_new_smartpay")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -602817356:
                if (str3.equals("setting_new_security_settings")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -121893092:
                if (str3.equals("setting_aku")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -121883067:
                if (str3.equals("setting_kyb")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -121874758:
                if (str3.equals("setting_tnc")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -89626590:
                if (str3.equals("setting_investment")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -35919189:
                if (str3.equals("setting_merchant_management")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 101546777:
                if (str3.equals("setting_resolution_center")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 516484048:
                if (str3.equals("setting_help")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 516642788:
                if (str3.equals("setting_more")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 656665496:
                if (str3.equals(ProfileUserServiceType.PRIVACY_POLICY)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 858510317:
                if (str3.equals("setting_balance")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1215209638:
                if (str3.equals("setting_my_payment_cards")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1770598419:
                if (str3.equals("setting_verification_list")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 2009494083:
                if (str3.equals(ProfileUserServiceType.PROMO_QUEST)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 2046277804:
                if (str3.equals("setting_referral")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                i = R.drawable.ic_my_bills;
                break;
            case 1:
                getBinding().MyBillsEntityDataFactory.setVisibility(8);
                i = 0;
                break;
            case 2:
                i = R.drawable.ic_saving;
                break;
            case 3:
                i = R.drawable.ic_promo_code_filled;
                break;
            case 4:
                i = R.drawable.ic_smartpay;
                break;
            case 5:
                i = R.drawable.ic_security;
                break;
            case 6:
                i = R.drawable.ic_dana_paylater;
                break;
            case 7:
                i = R.drawable.ic_kyb;
                break;
            case '\b':
                i = R.drawable.ic_tnc;
                break;
            case '\t':
                i = R.drawable.ic_icon_dana_investment;
                break;
            case '\n':
                i = R.drawable.ic_linked_account;
                break;
            case 11:
                i = R.drawable.ic_reso;
                break;
            case '\f':
                i = R.drawable.ic_help_blue;
                break;
            case '\r':
                i = R.drawable.ic_profile;
                break;
            case 14:
                i = R.drawable.ic_privacy_policy;
                break;
            case 15:
                i = R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7;
                break;
            case 16:
                i = R.drawable.ic_payment_card;
                getBinding().BuiltInFictitiousFunctionClassFactory.setContentDescription(getContext().getString(R.string.btnSavedCard));
                getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getContext().getString(R.string.lblTotalCards));
                break;
            case 17:
                i = R.drawable.ic_verification;
                break;
            case 18:
                i = R.drawable.ic_quest;
                break;
            case 19:
                i = R.drawable.ic_referral;
                break;
            default:
                i = 0;
                break;
        }
        if (BuiltInFictitiousFunctionClassFactory(str2)) {
            showTextViewSkeleton();
        } else if (!KClassImpl$Data$declaredNonStaticMembers$2(getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getText().toString())) {
            hideTextViewSkeleton();
        }
        setTitle(str);
        setSubTitle(str2, bool, str5);
        setRedDotVisibility(isShowRedDot(str, str2));
        if (TextUtils.isEmpty(str4)) {
            if (i != 0) {
                GlideApp.getAuthRequestContext(this).PlaceComponentResult(Integer.valueOf(i)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion(i).PlaceComponentResult(i).MyBillsEntityDataFactory((ImageView) getBinding().getAuthRequestContext);
                getBinding().getAuthRequestContext.setVisibility(0);
                return;
            }
            return;
        }
        showIconSkeleton();
        GlideApp.getAuthRequestContext(this).PlaceComponentResult(str4).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) getBinding().getAuthRequestContext);
        hideIconSkeleton();
        getBinding().getAuthRequestContext.setVisibility(0);
    }

    public void setTitle(String str) {
        if (str != null) {
            getBinding().moveToNextValue.setText(str);
        }
    }

    public void setSubTitle(String str, Boolean bool, String str2) {
        if (bool == null || bool.equals(Boolean.FALSE)) {
            KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
        } else if (str == null || str.equals("")) {
            KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
        } else {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
            getBinding().lookAheadTest.setVisibility(8);
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(str);
            getAuthRequestContext(str2);
        }
    }

    public void setRedDotVisibility(boolean z) {
        getBinding().PlaceComponentResult.setVisibility(z ? 0 : 8);
    }

    public void showIconSkeleton() {
        getBinding().getAuthRequestContext.setVisibility(0);
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().getAuthRequestContext);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_icon_me_page_skeleton;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.getAuthRequestContext = viewSkeletonScreen;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return ("BALANCE".equalsIgnoreCase(str) || SubtitleType.PAYMENT_CARDS.equalsIgnoreCase(str) || SubtitleType.ACCOUNT_TYPE.equalsIgnoreCase(str) || SubtitleType.MOBILE_NUMBER.equalsIgnoreCase(str) || SubtitleType.REAL_NAME.equalsIgnoreCase(str) || SubtitleType.EMAIL.equalsIgnoreCase(str) || SubtitleType.SECURITY_QUESTIONS.equalsIgnoreCase(str) || SubtitleType.SAVING.equalsIgnoreCase(str)) && !TextUtils.isEmpty(str);
    }

    public void showTextViewSkeleton() {
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getRootView());
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_subtitle_me_page_skeleton;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory = viewSkeletonScreen;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return "-".equalsIgnoreCase(str);
    }

    public void hideTextViewSkeleton() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        getBinding().lookAheadTest.setVisibility(0);
        getBinding().lookAheadTest.setText(str);
        getAuthRequestContext(str2);
    }

    public void hideIconSkeleton() {
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
            this.getAuthRequestContext = null;
        }
    }

    private void getAuthRequestContext(String str) {
        if (str == null || str.equals("")) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().KClassImpl$Data$declaredNonStaticMembers$2, (int) R.style.f49862132017440);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().lookAheadTest, (int) R.style.f49862132017440);
            return;
        }
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setTextColor(Color.parseColor(str));
        getBinding().lookAheadTest.setTextColor(Color.parseColor(str));
    }

    public void setParentViewVisibility(int i) {
        getBinding().BuiltInFictitiousFunctionClassFactory.setVisibility(i);
    }

    private boolean BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        return str.contains(getResources().getString(R.string.security_setting_twilio_title)) && getResources().getString(R.string.security_setting_twilio_set).equals(str2);
    }

    public boolean isShowRedDot(String str, String str2) {
        return getResources().getString(R.string.security_setting_question_state_off).equals(str2) || BuiltInFictitiousFunctionClassFactory(str, str2) || (getResources().getString(R.string.change_name_non_kyc).equals(str) && str2.matches("\\d+"));
    }
}
