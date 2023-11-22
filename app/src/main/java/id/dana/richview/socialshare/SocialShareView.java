package id.dana.richview.socialshare;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fullstory.instrumentation.InstrumentInjector;
import dagger.internal.Preconditions;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSocialShareComponent;
import id.dana.di.modules.SocialShareModule;
import id.dana.richview.socialshare.SocialShareContract;
import id.dana.richview.socialshare.model.SocialShareButton;
import id.dana.richview.socialshare.model.SocialShareModel;
import id.dana.utils.TagFormat;
import id.dana.utils.android.IntentUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SocialShareView extends BaseRichView implements SocialShareContract.View {
    private String BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    @BindView(R.id.civ_social_share_first)
    CircleImageView civSocialShareFirst;
    @BindView(R.id.civ_social_share_second)
    CircleImageView civSocialShareSecond;
    @BindView(R.id.civ_social_share_third)
    CircleImageView civSocialShareThird;
    protected boolean enableShareButton;
    private Listener getAuthRequestContext;
    @BindView(R.id.ll_share_first)
    LinearLayout llShareFirst;
    @BindView(R.id.ll_share_others)
    LinearLayout llShareOthers;
    @BindView(R.id.ll_share_qr)
    LinearLayout llShareQr;
    @BindView(R.id.ll_share_second)
    LinearLayout llShareSecond;
    @BindView(R.id.ll_share_third)
    LinearLayout llShareThird;
    @BindView(R.id.ll_csv_container)
    LinearLayout llViewContainer;
    @Inject
    SocialShareContract.Presenter presenter;
    protected List<SocialShareButton> socialShareButtonList;
    @BindView(R.id.tv_app_name_first)
    TextView tvAppNameFirst;
    @BindView(R.id.tv_app_name_second)
    TextView tvAppNameSecond;
    @BindView(R.id.tv_app_name_third)
    TextView tvAppNameThird;
    @BindView(R.id.tv_social_share_first)
    TextView tvSocialShareFirst;
    @BindView(R.id.tv_social_share_others)
    TextView tvSocialShareOthers;
    @BindView(R.id.tv_social_share_second)
    TextView tvSocialShareSecond;
    @BindView(R.id.tv_social_share_third)
    TextView tvSocialShareThird;
    @BindView(R.id.tv_social_share_title)
    TextView tvSocialShareTitle;

    /* loaded from: classes5.dex */
    public interface Listener {
        void MyBillsEntityDataFactory(SocialShareModel socialShareModel);
    }

    public static void __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(CircleImageView circleImageView, int i) {
        if (circleImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(circleImageView, i);
        } else {
            circleImageView.setImageResource(i);
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_social_share;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    public SocialShareView(Context context) {
        super(context);
        this.BuiltInFictitiousFunctionClassFactory = "";
    }

    public SocialShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BuiltInFictitiousFunctionClassFactory = "";
    }

    public SocialShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BuiltInFictitiousFunctionClassFactory = "";
    }

    public SocialShareView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.BuiltInFictitiousFunctionClassFactory = "";
    }

    public void setListener(Listener listener) {
        this.getAuthRequestContext = listener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateSocialShareButton$0$id-dana-richview-socialshare-SocialShareView  reason: not valid java name */
    public /* synthetic */ void m2857x38be5dd5(SocialShareModel socialShareModel, View view) {
        Listener listener = this.getAuthRequestContext;
        if (listener != null) {
            listener.MyBillsEntityDataFactory(socialShareModel);
        }
        shareToSocialApp(socialShareModel.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateSocialShareButton$1$id-dana-richview-socialshare-SocialShareView  reason: not valid java name */
    public /* synthetic */ void m2858xf235eb74(SocialShareModel socialShareModel, View view) {
        Listener listener = this.getAuthRequestContext;
        if (listener != null) {
            listener.MyBillsEntityDataFactory(socialShareModel);
        }
        shareToSocialApp(socialShareModel.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public void attachImageWithGlide(int i, CircleImageView circleImageView) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(Integer.valueOf(i)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).whenAvailable().MyBillsEntityDataFactory((ImageView) circleImageView);
    }

    public void shareToSocialApp(String str) {
        try {
            Intent KClassImpl$Data$declaredNonStaticMembers$2 = IntentUtil.KClassImpl$Data$declaredNonStaticMembers$2(TagFormat.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory("link", this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory());
            if (IntentUtil.PlaceComponentResult(getContext(), str)) {
                KClassImpl$Data$declaredNonStaticMembers$2.setPackage(str);
                getContext().startActivity(KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            showMessage(getResources().getString(R.string.social_share_pop_up_description));
        } catch (ActivityNotFoundException e) {
            showMessage(getResources().getString(R.string.share_failed));
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SOCIAL_SHARE_TAG, DanaLogConstants.Prefix.SOCIAL_SHARE_INTENT_PREFIX, e);
        }
    }

    public void showMessage(String str) {
        new MaterialDialog(getContext(), MaterialDialog.getDEFAULT_BEHAVIOR()).cancelable(false).message(null, str, null).positiveButton(Integer.valueOf((int) R.string.social_share_pop_up_button), null, null).show();
    }

    public void setEnableShareButton(boolean z) {
        this.enableShareButton = z;
    }

    public void setSocialShareViewTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.tvSocialShareTitle.setText(charSequence, TextView.BufferType.SPANNABLE);
        } else {
            this.tvSocialShareTitle.setVisibility(8);
        }
    }

    public void setSocialButtonText(String str) {
        for (SocialShareButton socialShareButton : this.socialShareButtonList) {
            if (str.isEmpty()) {
                socialShareButton.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
            }
            socialShareButton.BuiltInFictitiousFunctionClassFactory.setText(str);
        }
    }

    public void setSharingMessage(String str, String str2) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.f3578civ_share_others, R.id.tv_social_share_others})
    public void setOnClickOthers() {
        if (this.enableShareButton) {
            getContext().startActivity(Intent.createChooser(IntentUtil.KClassImpl$Data$declaredNonStaticMembers$2(TagFormat.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory("link", this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory()), getContext().getString(R.string.share_via)));
        }
    }

    public void setOthersButtonText(String str) {
        this.tvSocialShareOthers.setText(str);
    }

    public void setShareQrOnClickListener(View.OnClickListener onClickListener) {
        this.llShareQr.setOnClickListener(onClickListener);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        DaggerSocialShareComponent.Builder PlaceComponentResult = DaggerSocialShareComponent.PlaceComponentResult();
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (SocialShareModule) Preconditions.getAuthRequestContext(new SocialShareModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, SocialShareModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, ApplicationComponent.class);
        new DaggerSocialShareComponent.SocialShareComponentImpl(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult.PlaceComponentResult, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageCaptureViewModel$getTipUploadPhoto$2);
            try {
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getBoolean(0, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r1 == 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccessGetSocialMediaCategoryShare(java.util.List<java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L3c
            r0 = 0
        L7:
            int r1 = r5.size()
            r2 = 3
            if (r1 < r2) goto L18
            int r1 = r4.PlaceComponentResult
            r3 = 1
            if (r1 != r3) goto L15
            r2 = 2
            goto L1c
        L15:
            if (r1 != 0) goto L18
            goto L1c
        L18:
            int r2 = r5.size()
        L1c:
            if (r0 >= r2) goto L43
            android.content.Context r1 = r4.getContext()
            java.lang.Object r2 = r5.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            id.dana.richview.socialshare.model.SocialShareModel r1 = id.dana.richview.socialshare.model.SocialShareModelFactory.BuiltInFictitiousFunctionClassFactory(r1, r2)
            if (r1 == 0) goto L39
            java.util.List<id.dana.richview.socialshare.model.SocialShareButton> r2 = r4.socialShareButtonList
            java.lang.Object r2 = r2.get(r0)
            id.dana.richview.socialshare.model.SocialShareButton r2 = (id.dana.richview.socialshare.model.SocialShareButton) r2
            r4.updateSocialShareButton(r2, r1, r0)
        L39:
            int r0 = r0 + 1
            goto L7
        L3c:
            android.widget.LinearLayout r5 = r4.llViewContainer
            r0 = 8
            r5.setVisibility(r0)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.socialshare.SocialShareView.onSuccessGetSocialMediaCategoryShare(java.util.List):void");
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        ArrayList arrayList = new ArrayList();
        this.socialShareButtonList = arrayList;
        arrayList.add(new SocialShareButton(this.llShareFirst, this.tvSocialShareFirst, this.tvAppNameFirst, this.civSocialShareFirst));
        this.socialShareButtonList.add(new SocialShareButton(this.llShareSecond, this.tvSocialShareSecond, this.tvAppNameSecond, this.civSocialShareSecond));
        this.socialShareButtonList.add(new SocialShareButton(this.llShareThird, this.tvSocialShareThird, this.tvAppNameThird, this.civSocialShareThird));
        this.presenter.getAuthRequestContext();
        boolean z = this.MyBillsEntityDataFactory;
        this.PlaceComponentResult = z ? 1 : 0;
        this.llShareQr.setVisibility(z ? 0 : 8);
    }

    public void updateSocialShareButton(SocialShareButton socialShareButton, final SocialShareModel socialShareModel, int i) {
        attachImageWithGlide(socialShareModel.PlaceComponentResult, socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2);
        __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2, socialShareModel.PlaceComponentResult);
        socialShareButton.MyBillsEntityDataFactory.setText(socialShareModel.getAuthRequestContext);
        socialShareButton.PlaceComponentResult.setVisibility(0);
        socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(socialShareModel.BuiltInFictitiousFunctionClassFactory);
        socialShareButton.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.socialshare.SocialShareView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SocialShareView.this.m2857x38be5dd5(socialShareModel, view);
            }
        });
        socialShareButton.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.socialshare.SocialShareView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SocialShareView.this.m2858xf235eb74(socialShareModel, view);
            }
        });
    }
}
