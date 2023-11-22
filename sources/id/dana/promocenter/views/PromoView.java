package id.dana.promocenter.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.textview.MaterialTextView;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.promocenter.model.PromoActionModel;
import id.dana.promocenter.model.PromoActionType;
import id.dana.promocenter.model.PromoModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageResize;
import id.dana.utils.LocaleUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class PromoView extends BaseRichView {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private Listener MyBillsEntityDataFactory;
    private MultiTransformation<Bitmap> PlaceComponentResult;
    @BindView(R.id.btn_first_promo_action)
    DanaButtonSecondaryView btnFirstPromoAction;
    @BindView(R.id.btn_second_promo_action)
    DanaButtonPrimaryView btnSecondPromoAction;
    private Disposable getAuthRequestContext;
    private boolean getErrorConfigVersion;
    AppCompatImageView ivExpiredIcon;
    @BindView(R.id.iv_hot_promo_ribbon)
    ImageView ivHotPromoRibbon;
    AppCompatImageView ivMerchantLogo;
    AppCompatImageView ivMerchantLogoBackground;
    @BindView(R.id.iv_promo_banner)
    ImageView ivPromoBanner;
    private boolean moveToNextValue;
    MaterialTextView tvCountdown;
    @BindView(R.id.tv_promo_expiry_date)
    TextView tvPromoExpiryDate;
    @BindView(R.id.f4482tv_promo_title)
    TextView tvPromoTitle;

    /* loaded from: classes5.dex */
    public interface Listener {
        void getAuthRequestContext(PromoModel promoModel, String str);
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_promo;
    }

    public PromoView(Context context) {
        super(context);
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    public PromoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    public PromoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.tvCountdown = (MaterialTextView) findViewById(R.id.tvCountdown);
        this.ivExpiredIcon = (AppCompatImageView) findViewById(R.id.iv_expired_icon);
        this.ivMerchantLogo = (AppCompatImageView) findViewById(R.id.SendMoneyHomePresenter);
        this.ivMerchantLogoBackground = (AppCompatImageView) findViewById(R.id.iv_logo_background);
        this.PlaceComponentResult = new MultiTransformation<>(new CenterCrop(), new RoundedCornersTransformation(ImageResize.PlaceComponentResult((Activity) getBaseActivity(), 7), 0, RoundedCornersTransformation.CornerType.TOP));
    }

    @Override // id.dana.base.BaseRichView
    public void dispose() {
        super.dispose();
        Disposable disposable = this.getAuthRequestContext;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.getAuthRequestContext.dispose();
    }

    public void setListener(Listener listener) {
        this.MyBillsEntityDataFactory = listener;
    }

    public void setPromo(final PromoModel promoModel) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (int) (displayMetrics.widthPixels * 0.91f);
        this.BuiltInFictitiousFunctionClassFactory = (int) (displayMetrics.heightPixels * 0.13f);
        if (promoModel != null) {
            if (!isViewBinded()) {
                ButterKnife.BuiltInFictitiousFunctionClassFactory(this, this);
            }
            if (this.getErrorConfigVersion) {
                this.tvCountdown.setVisibility(0);
                this.tvPromoExpiryDate.setVisibility(8);
                this.ivExpiredIcon.setVisibility(8);
                this.getAuthRequestContext = Observable.interval(1L, TimeUnit.SECONDS).takeUntil(new Predicate() { // from class: id.dana.promocenter.views.PromoView$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Object obj) {
                        return PromoView.lambda$generateCountdownTimer$1(PromoModel.this, (Long) obj);
                    }
                }).doOnNext(new Consumer() { // from class: id.dana.promocenter.views.PromoView$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        PromoView.lambda$generateCountdownTimer$2(PromoModel.this, (Long) obj);
                    }
                }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.promocenter.views.PromoView$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        PromoView.this.m2782xaad516d2(promoModel, (Long) obj);
                    }
                });
            }
            if (this.moveToNextValue) {
                this.ivMerchantLogo.setVisibility(0);
                this.ivMerchantLogoBackground.setVisibility(0);
                GlideApp.getAuthRequestContext(this).PlaceComponentResult("").getErrorConfigVersion((int) R.drawable.dana_coin).PlaceComponentResult((int) R.drawable.dana_coin).MyBillsEntityDataFactory((ImageView) this.ivMerchantLogo);
            }
            TextView textView = this.tvPromoTitle;
            String str = promoModel.scheduleImpl;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            TextView textView2 = this.tvPromoExpiryDate;
            long j = promoModel.BuiltInFictitiousFunctionClassFactory;
            textView2.setText(j > 0 ? String.format(getContext().getString(R.string.expired_voucher), DateTimeUtil.BuiltInFictitiousFunctionClassFactory(getContext().getString(R.string.complete_date), LocaleUtil.getAuthRequestContext(), j)) : "");
            int i = promoModel.moveToNextValue;
            if (i >= 0 && i <= 10) {
                this.ivHotPromoRibbon.setVisibility(0);
            } else {
                this.ivHotPromoRibbon.setVisibility(8);
            }
            GlideApp.getAuthRequestContext(this).PlaceComponentResult(promoModel.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.banner_placeholder).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) this.PlaceComponentResult).MyBillsEntityDataFactory(this.ivPromoBanner);
            this.btnSecondPromoAction.setVisibility(8);
            this.btnFirstPromoAction.setVisibility(4);
            List<PromoActionModel> list = promoModel.MyBillsEntityDataFactory;
            if (list == null) {
                list = new ArrayList();
            }
            for (PromoActionModel promoActionModel : list) {
                String str2 = promoActionModel.getAuthRequestContext;
                if (PromoActionType.PRIMARY.equalsIgnoreCase(str2)) {
                    this.btnSecondPromoAction.setActiveButton(promoActionModel.MyBillsEntityDataFactory, null);
                    this.btnSecondPromoAction.setVisibility(0);
                    DanaButtonPrimaryView danaButtonPrimaryView = this.btnSecondPromoAction;
                    final String str3 = promoActionModel.PlaceComponentResult;
                    danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.PromoView$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PromoView.this.m2783x1690659d(promoModel, str3, view);
                        }
                    });
                } else if (PromoActionType.SECONDARY.equalsIgnoreCase(str2)) {
                    this.btnFirstPromoAction.setActiveButton(promoActionModel.MyBillsEntityDataFactory, null);
                    this.btnFirstPromoAction.setVisibility(0);
                    DanaButtonSecondaryView danaButtonSecondaryView = this.btnFirstPromoAction;
                    final String str4 = promoActionModel.PlaceComponentResult;
                    danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.PromoView$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PromoView.this.m2783x1690659d(promoModel, str4, view);
                        }
                    });
                    final String str5 = promoActionModel.PlaceComponentResult;
                    setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.PromoView$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PromoView.this.m2783x1690659d(promoModel, str5, view);
                        }
                    });
                }
            }
        }
    }

    public void clearImage() {
        GlideApp.getAuthRequestContext(this).getAuthRequestContext((Target<?>) new RequestManager.ClearTarget(this.ivPromoBanner));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setPromoActionListener$0$id-dana-promocenter-views-PromoView  reason: not valid java name */
    public /* synthetic */ void m2783x1690659d(PromoModel promoModel, String str, View view) {
        if (this.MyBillsEntityDataFactory == null || !isRichViewClickable()) {
            return;
        }
        disableClick();
        this.MyBillsEntityDataFactory.getAuthRequestContext(promoModel, str);
    }

    public void setShowCountdown(boolean z) {
        this.getErrorConfigVersion = z;
    }

    public void setShowMerchantLogo(boolean z) {
        this.moveToNextValue = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$generateCountdownTimer$1(PromoModel promoModel, Long l) throws Exception {
        return l.longValue() >= promoModel.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$generateCountdownTimer$2(PromoModel promoModel, Long l) throws Exception {
        promoModel.BuiltInFictitiousFunctionClassFactory -= 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$generateCountdownTimer$3$id-dana-promocenter-views-PromoView  reason: not valid java name */
    public /* synthetic */ void m2782xaad516d2(PromoModel promoModel, Long l) throws Exception {
        Locale locale;
        if (DateTimeUtil.MyBillsEntityDataFactory(new Date(promoModel.BuiltInFictitiousFunctionClassFactory)) >= 24) {
            this.tvCountdown.setText(getResources().getString(R.string.expired_date_time_in_days, String.valueOf(DateTimeUtil.MyBillsEntityDataFactory(new Date(promoModel.BuiltInFictitiousFunctionClassFactory), new Date()))));
            return;
        }
        MaterialTextView materialTextView = this.tvCountdown;
        Date date = new Date(promoModel.BuiltInFictitiousFunctionClassFactory);
        locale = Locale.getDefault();
        materialTextView.setText(DateTimeUtil.MyBillsEntityDataFactory(date, "HH:mm:ss", locale));
    }
}
