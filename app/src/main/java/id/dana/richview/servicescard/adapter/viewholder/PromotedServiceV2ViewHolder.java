package id.dana.richview.servicescard.adapter.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieListener;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.databinding.ItemPromotedServiceV2Binding;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.model.ThirdPartyService;
import id.dana.richview.EllipseTextView;
import id.dana.richview.servicescard.helper.ServiceCardHelper;
import id.dana.utils.SizeUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017"}, d2 = {"Lid/dana/richview/servicescard/adapter/viewholder/PromotedServiceV2ViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/model/ThirdPartyService;", "Lid/dana/databinding/ItemPromotedServiceV2Binding;", "", "p0", "", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Ljava/lang/Runnable;", "PlaceComponentResult", "Ljava/lang/Runnable;", "MyBillsEntityDataFactory", "Landroid/view/View$OnClickListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/View$OnClickListener;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "lookAheadTest", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "p2", "p3", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/View$OnClickListener;Ljava/lang/Runnable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromotedServiceV2ViewHolder extends ViewBindingRecyclerViewHolder<ThirdPartyService, ItemPromotedServiceV2Binding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public SkeletonScreen lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public SkeletonScreen PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final View.OnClickListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Runnable MyBillsEntityDataFactory;
    public String getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        ThirdPartyService thirdPartyService = (ThirdPartyService) obj;
        super.bindData(thirdPartyService);
        if (thirdPartyService != null) {
            String str = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8;
            this.getAuthRequestContext = str;
            boolean z = true;
            boolean z2 = str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) LoanInfo.SERVICE_PAYLATER, false, 2, (Object) null);
            ServiceCardHelper serviceCardHelper = ServiceCardHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String BuiltInFictitiousFunctionClassFactory = ServiceCardHelper.BuiltInFictitiousFunctionClassFactory(context, thirdPartyService);
            if (!TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
                getBinding().lookAheadTest.setText(BuiltInFictitiousFunctionClassFactory);
            }
            if (z2) {
                ServiceCardHelper serviceCardHelper2 = ServiceCardHelper.INSTANCE;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                String PlaceComponentResult = ServiceCardHelper.PlaceComponentResult(context2, thirdPartyService.lookAheadTest);
                if (PlaceComponentResult != null) {
                    int i = thirdPartyService.readMicros;
                    String str2 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    if (str2 == null) {
                        str2 = "";
                    }
                    String str3 = PlaceComponentResult;
                    if (TextUtils.isEmpty(str3) || !StringsKt.contains((CharSequence) str2, (CharSequence) "due", true)) {
                        if (!TextUtils.isEmpty(str3) && !StringsKt.contains((CharSequence) str2, (CharSequence) "due", true)) {
                            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(str3);
                        }
                    } else if (i > 0) {
                        EllipseTextView ellipseTextView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(PlaceComponentResult, Arrays.copyOf(new Object[]{String.valueOf(i)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "");
                        ellipseTextView.setText(format);
                    } else if (i == 0) {
                        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(R.string.paylater_loan_personal_subtitle_due_today);
                    } else {
                        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(str3);
                    }
                }
            } else {
                ServiceCardHelper serviceCardHelper3 = ServiceCardHelper.INSTANCE;
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                String PlaceComponentResult2 = ServiceCardHelper.PlaceComponentResult(context3, thirdPartyService.lookAheadTest);
                if (PlaceComponentResult2 != null) {
                    String str4 = PlaceComponentResult2;
                    if (!TextUtils.isEmpty(str4)) {
                        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(str4);
                    }
                }
            }
            String str5 = thirdPartyService.getValueOfTouchPositionAbsolute;
            if (!TextUtils.isEmpty(str5)) {
                getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setTextColor(Color.parseColor(str5));
            } else {
                getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27152131100507));
            }
            String str6 = thirdPartyService.VerifyPinStateManager$executeRiskChallenge$2$2;
            if (!TextUtils.isEmpty(str6)) {
                getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeColor(Color.parseColor(str6));
                getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setCornerRadius(getContext().getResources().getDimension(R.dimen.f29202131165459));
                getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setPadding(SizeUtil.getAuthRequestContext(6), SizeUtil.getAuthRequestContext(4), SizeUtil.getAuthRequestContext(6), SizeUtil.getAuthRequestContext(5));
            } else {
                getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27072131100488));
                getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setPadding(SizeUtil.getAuthRequestContext(0), SizeUtil.getAuthRequestContext(0), SizeUtil.getAuthRequestContext(0), SizeUtil.getAuthRequestContext(0));
            }
            ServiceCardHelper serviceCardHelper4 = ServiceCardHelper.INSTANCE;
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "");
            String PlaceComponentResult3 = ServiceCardHelper.PlaceComponentResult(context4, thirdPartyService.getErrorConfigVersion);
            if (TextUtils.isEmpty(PlaceComponentResult3)) {
                String string = getContext().getResources().getString(R.string.view);
                Intrinsics.checkNotNullExpressionValue(string, "");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "");
                PlaceComponentResult3 = string.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
            }
            String str7 = PlaceComponentResult3;
            if (!TextUtils.isEmpty(str7)) {
                getBinding().BuiltInFictitiousFunctionClassFactory.setText(str7);
            }
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(this.BuiltInFictitiousFunctionClassFactory);
            }
            ServiceCardHelper serviceCardHelper5 = ServiceCardHelper.INSTANCE;
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "");
            final int BuiltInFictitiousFunctionClassFactory2 = ServiceCardHelper.BuiltInFictitiousFunctionClassFactory(context5, thirdPartyService.FragmentBottomSheetPaymentSettingBinding);
            String str8 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (str8 != null && str8.length() != 0) {
                z = false;
            }
            if (z) {
                getAuthRequestContext(thirdPartyService.GetContactSyncConfig, BuiltInFictitiousFunctionClassFactory2);
            } else {
                String str9 = thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda2;
                final String str10 = thirdPartyService.GetContactSyncConfig;
                if (!Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, str9)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = str9;
                    ItemPromotedServiceV2Binding binding = getBinding();
                    binding.getAuthRequestContext.setVisibility(0);
                    binding.MyBillsEntityDataFactory.setVisibility(8);
                    binding.getAuthRequestContext.setAnimationFromUrl(str9);
                    binding.getAuthRequestContext.setFailureListener(new LottieListener() { // from class: id.dana.richview.servicescard.adapter.viewholder.PromotedServiceV2ViewHolder$$ExternalSyntheticLambda0
                        @Override // com.airbnb.lottie.LottieListener
                        public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj2) {
                            Throwable th = (Throwable) obj2;
                            PromotedServiceV2ViewHolder.PlaceComponentResult(PromotedServiceV2ViewHolder.this, str10, BuiltInFictitiousFunctionClassFactory2);
                        }
                    });
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        getBinding().getAuthRequestContext.pauseAnimation();
                    }
                }
            }
            Runnable runnable = this.MyBillsEntityDataFactory;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemPromotedServiceV2Binding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemPromotedServiceV2Binding KClassImpl$Data$declaredNonStaticMembers$2 = ItemPromotedServiceV2Binding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotedServiceV2ViewHolder(Context context, ViewGroup viewGroup, View.OnClickListener onClickListener, Runnable runnable) {
        super(context, R.layout.item_promoted_service_v2, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.BuiltInFictitiousFunctionClassFactory = onClickListener;
        this.MyBillsEntityDataFactory = runnable;
    }

    private final void getAuthRequestContext(String p0, int p1) {
        getBinding().getAuthRequestContext.setVisibility(8);
        getBinding().MyBillsEntityDataFactory.setVisibility(0);
        if (SvgLoader.getAuthRequestContext(p0)) {
            getAuthRequestContext(p0);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        }
    }

    private final void getAuthRequestContext(String p0) {
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = p0;
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.service_skeleton_circle;
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = getBinding().MyBillsEntityDataFactory;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(p0).getErrorConfigVersion((int) R.drawable.service_skeleton_circle).PlaceComponentResult(p1).MyBillsEntityDataFactory(getBinding().MyBillsEntityDataFactory);
    }

    public static /* synthetic */ void PlaceComponentResult(PromotedServiceV2ViewHolder promotedServiceV2ViewHolder, String str, int i) {
        Intrinsics.checkNotNullParameter(promotedServiceV2ViewHolder, "");
        promotedServiceV2ViewHolder.getAuthRequestContext(str, i);
    }
}
