package id.dana.nearbyme.adapter.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.nearbyme.model.MerchantItemWrapper;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ResourceUtils;
import id.dana.utils.SizeUtil;
import id.dana.utils.TextUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cBK\u0012\u0006\u0010\u0007\u001a\u00020\u0016\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u0017\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u0017\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0004\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u001d\u0010\f\u001a\u00020\u00122\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0002¢\u0006\u0004\b\f\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014"}, d2 = {"Lid/dana/nearbyme/adapter/viewholder/OtherStoreItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/MerchantItemWrapper;", "", "MyBillsEntityDataFactory", "()Z", "Landroid/widget/ImageView;", "p0", "", "p1", "", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "(Z)V", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)I", "Z", "PlaceComponentResult", "Landroid/view/ViewGroup;", "Lkotlin/Function1;", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtherStoreItemViewHolder extends BaseRecyclerViewHolder<MerchantItemWrapper> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantItemWrapper merchantItemWrapper) {
        String PlaceComponentResult;
        TextView textView;
        String str;
        String string;
        MerchantItemWrapper merchantItemWrapper2 = merchantItemWrapper;
        Intrinsics.checkNotNullParameter(merchantItemWrapper2, "");
        final ShopModel shopModel = merchantItemWrapper2.MyBillsEntityDataFactory;
        TextView textView2 = (TextView) this.itemView.findViewById(R.id.tv_merchant_name);
        if (textView2 != null) {
            textView2.setText(shopModel.newProxyInstance);
        }
        TextView textView3 = (TextView) this.itemView.findViewById(R.id.tv_merchant_category);
        if (textView3 != null) {
            textView3.setText(shopModel.getAuthRequestContext(false, " | "));
        }
        TextView textView4 = (TextView) this.itemView.findViewById(R.id.tv_merchant_address);
        if (textView4 != null) {
            textView4.setText(shopModel.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult);
        }
        TextView textView5 = (TextView) this.itemView.findViewById(R.id.tv_merchant_store_distance);
        if (textView5 != null) {
            textView5.setText(TextUtil.BuiltInFictitiousFunctionClassFactory(getContext(), shopModel.getErrorConfigVersion));
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_merchant_logo);
        String str2 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        MyBillsEntityDataFactory(appCompatImageView, str2);
        View view = this.itemView;
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.tv_top_up_ready);
        if (appCompatTextView != null) {
            Context context = view.getContext();
            if (context == null || (string = context.getString(R.string.merchant_item_top_up)) == null) {
                str = null;
            } else {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "");
                str = string.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "");
            }
            if (str == null) {
                str = "";
            }
            appCompatTextView.setText(str);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.tv_top_up_ready);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Boolean>() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$showMerchantBadgeType$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(ShopModel.this.newProxyInstance());
                }
            }));
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.iv_qris_icon);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Boolean>() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$showMerchantBadgeType$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(ShopModel.this.PrepareContext());
                }
            }));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_business_icon);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Boolean>() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$showMerchantBadgeType$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(ShopModel.this.getErrorConfigVersion());
                }
            }));
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) view.findViewById(R.id.tv_home_shopping);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Boolean>() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$showMerchantBadgeType$1$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(ShopModel.this.initRecordTimeStamp());
                }
            }));
        }
        if (shopModel.readMicros == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            TextView textView6 = (TextView) this.itemView.findViewById(R.id.hasValidCountryCallingCode);
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        } else {
            TextView textView7 = (TextView) this.itemView.findViewById(R.id.hasValidCountryCallingCode);
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            TextView textView8 = (TextView) this.itemView.findViewById(R.id.hasValidCountryCallingCode);
            if (textView8 != null) {
                textView8.setText(String.valueOf(shopModel.readMicros));
            }
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) this.itemView.findViewById(R.id.iv_merchant_logo);
        String str3 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
        Intrinsics.checkNotNullExpressionValue(str3, "");
        MyBillsEntityDataFactory(appCompatImageView3, str3);
        if (shopModel.C.isEmpty() && !shopModel.moveToNextValue()) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            if (shopModel.moveToNextValue()) {
                PlaceComponentResult = getContext().getString(R.string.open);
            } else {
                PlaceComponentResult = shopModel.PlaceComponentResult(getContext());
                if (TextUtils.isEmpty(PlaceComponentResult)) {
                    KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            TextView textView9 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a180e_daggerlocalconfigsplashcomponent_localconfigsplashcomponentimpl_providefeedinitrepositoryprovider);
            if ((textView9 != null && textView9.getVisibility() == 8) && (textView = (TextView) this.itemView.findViewById(R.id.res_0x7f0a180e_daggerlocalconfigsplashcomponent_localconfigsplashcomponentimpl_providefeedinitrepositoryprovider)) != null) {
                textView.setVisibility(0);
            }
            if (Intrinsics.areEqual(PlaceComponentResult, getContext().getResources().getString(R.string.closing_soon)) || Intrinsics.areEqual(PlaceComponentResult, getContext().getResources().getString(R.string.closed))) {
                TextView textView10 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a180e_daggerlocalconfigsplashcomponent_localconfigsplashcomponentimpl_providefeedinitrepositoryprovider);
                getContext();
                textView10.setTextColor(-773316);
            } else {
                TextView textView11 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a180e_daggerlocalconfigsplashcomponent_localconfigsplashcomponentimpl_providefeedinitrepositoryprovider);
                if (textView11 != null) {
                    getContext();
                    textView11.setTextColor(-13553359);
                }
            }
            TextView textView12 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a180e_daggerlocalconfigsplashcomponent_localconfigsplashcomponentimpl_providefeedinitrepositoryprovider);
            if (textView12 != null) {
                textView12.setText(PlaceComponentResult);
            }
        }
        boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7();
        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.itemView.findViewById(R.id.cl_merchant_list_ribbon_container);
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(NetworkUserEntityData$$ExternalSyntheticLambda7 ? 0 : 8);
        }
        View findViewById = this.itemView.findViewById(R.id.divider_promo_ribbon);
        if (findViewById != null) {
            findViewById.setVisibility(NetworkUserEntityData$$ExternalSyntheticLambda7 ? 0 : 8);
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda7) {
            String scheduleImpl = shopModel.scheduleImpl();
            String NetworkUserEntityData$$ExternalSyntheticLambda0 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda0();
            TextView textView13 = (TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_top);
            if (textView13 != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                textView13.setText(ResourceUtils.PlaceComponentResult(context2, scheduleImpl, scheduleImpl));
            }
            TextView textView14 = (TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_bottom);
            if (textView14 != null) {
                textView14.setText(shopModel.GetContactSyncConfig() ? getContext().getString(R.string.max_value_with_val, NetworkUserEntityData$$ExternalSyntheticLambda0) : NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            if ((!this.PlaceComponentResult) != false) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.itemView.findViewById(R.id.lottie_merchant_list_nearby_ribbon);
                if (lottieAnimationView != null) {
                    lottieAnimationView.postDelayed(new Runnable() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            OtherStoreItemViewHolder.BuiltInFictitiousFunctionClassFactory(OtherStoreItemViewHolder.this);
                        }
                    }, 500L);
                    return;
                }
                return;
            }
            BuiltInFictitiousFunctionClassFactory(false);
            getAuthRequestContext(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtherStoreItemViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1, final Function1<? super Integer, Unit> function12, final Function1<? super Integer, Unit> function13) {
        super(viewGroup.getContext(), R.layout.item_merchant_list, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(function13, "");
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_item_merchant_list);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OtherStoreItemViewHolder.getAuthRequestContext(Function1.this, this);
                }
            });
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_merchant_list_ribbon_container);
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OtherStoreItemViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(Function1.this, this);
                }
            });
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.tv_home_shopping);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OtherStoreItemViewHolder.PlaceComponentResult(Function1.this, this);
                }
            });
        }
    }

    private final void MyBillsEntityDataFactory(ImageView p0, String p1) {
        if (p0 != null) {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(p1).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_merchant_logo_null).PlaceComponentResult((int) R.drawable.ic_merchant_logo_null).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new RoundedCorners(SizeUtil.getAuthRequestContext(3))).MyBillsEntityDataFactory(p0);
        }
    }

    private final int KClassImpl$Data$declaredNonStaticMembers$2(Function0<Boolean> p0) {
        return (p0.invoke().booleanValue() ? this : null) != null ? 0 : 8;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        TextView textView;
        TextView textView2 = (TextView) this.itemView.findViewById(R.id.res_0x7f0a180e_daggerlocalconfigsplashcomponent_localconfigsplashcomponentimpl_providefeedinitrepositoryprovider);
        boolean z = false;
        if (textView2 != null && textView2.getVisibility() == 0) {
            z = true;
        }
        if (z && (textView = (TextView) this.itemView.findViewById(R.id.res_0x7f0a180e_daggerlocalconfigsplashcomponent_localconfigsplashcomponentimpl_providefeedinitrepositoryprovider)) != null) {
            textView.setVisibility(8);
        }
        TextView textView3 = (TextView) this.itemView.findViewById(R.id.tv_merchant_store_distance);
        String replace$default = StringsKt.replace$default(String.valueOf(textView3 != null ? textView3.getText() : null), "• ", "", false, 4, (Object) null);
        TextView textView4 = (TextView) this.itemView.findViewById(R.id.tv_merchant_store_distance);
        if (textView4 != null) {
            textView4.setText(replace$default);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        if (((LottieAnimationView) this.itemView.findViewById(R.id.lottie_merchant_list_nearby_ribbon)) == null) {
            return;
        }
        if (p0) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.itemView.findViewById(R.id.lottie_merchant_list_nearby_ribbon);
            if (lottieAnimationView != null) {
                lottieAnimationView.playAnimation();
                return;
            }
            return;
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.itemView.findViewById(R.id.lottie_merchant_list_nearby_ribbon);
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setFrame(60);
        }
    }

    private final void getAuthRequestContext(boolean p0) {
        if (((TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_top)) == null) {
            return;
        }
        if (p0) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_top);
            if (textView != null) {
                textView.postDelayed(new Runnable() { // from class: id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        OtherStoreItemViewHolder.MyBillsEntityDataFactory(OtherStoreItemViewHolder.this);
                    }
                }, 150L);
                return;
            }
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(false);
    }

    private final boolean MyBillsEntityDataFactory() {
        return (((TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_top)) == null || ((TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_bottom)) == null || ((AppCompatImageView) this.itemView.findViewById(R.id.iv_merchant_list_info_icon)) == null) ? false : true;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator alpha2;
        ViewPropertyAnimator animate3;
        ViewPropertyAnimator alpha3;
        if (p0) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_top);
            if (textView != null && (animate3 = textView.animate()) != null && (alpha3 = animate3.alpha(1.0f)) != null) {
                alpha3.start();
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_bottom);
            if (textView2 != null && (animate2 = textView2.animate()) != null && (alpha2 = animate2.alpha(1.0f)) != null) {
                alpha2.start();
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_merchant_list_info_icon);
            if (appCompatImageView == null || (animate = appCompatImageView.animate()) == null || (alpha = animate.alpha(1.0f)) == null) {
                return;
            }
            alpha.start();
            return;
        }
        TextView textView3 = (TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_top);
        if (textView3 != null) {
            textView3.setAlpha(1.0f);
        }
        TextView textView4 = (TextView) this.itemView.findViewById(R.id.tv_merchant_list_ribbon_line_bottom);
        if (textView4 != null) {
            textView4.setAlpha(1.0f);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.itemView.findViewById(R.id.iv_merchant_list_info_icon);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setAlpha(1.0f);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(Function1 function1, OtherStoreItemViewHolder otherStoreItemViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(otherStoreItemViewHolder, "");
        function1.invoke(Integer.valueOf(otherStoreItemViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void getAuthRequestContext(Function1 function1, OtherStoreItemViewHolder otherStoreItemViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(otherStoreItemViewHolder, "");
        function1.invoke(Integer.valueOf(otherStoreItemViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(OtherStoreItemViewHolder otherStoreItemViewHolder) {
        Intrinsics.checkNotNullParameter(otherStoreItemViewHolder, "");
        if (otherStoreItemViewHolder.MyBillsEntityDataFactory()) {
            otherStoreItemViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
        otherStoreItemViewHolder.PlaceComponentResult = true;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(OtherStoreItemViewHolder otherStoreItemViewHolder) {
        Intrinsics.checkNotNullParameter(otherStoreItemViewHolder, "");
        otherStoreItemViewHolder.BuiltInFictitiousFunctionClassFactory(true);
        otherStoreItemViewHolder.getAuthRequestContext(true);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function1 function1, OtherStoreItemViewHolder otherStoreItemViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(otherStoreItemViewHolder, "");
        function1.invoke(Integer.valueOf(otherStoreItemViewHolder.getAbsoluteAdapterPosition()));
    }
}
