package id.dana.promocode.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/promocode/views/PromoCodeBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Lid/dana/promocode/views/PromoCodeBottomSheet$PromocodeBottomSheetListener;", "moveToNextValue", "Lid/dana/promocode/views/PromoCodeBottomSheet$PromocodeBottomSheetListener;", "getAuthRequestContext", "<init>", "Companion", "PromocodeBottomSheetListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoCodeBottomSheet extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    PromocodeBottomSheetListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/promocode/views/PromoCodeBottomSheet$PromocodeBottomSheetListener;", "", "", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface PromocodeBottomSheetListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();
    }

    private View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* bridge */ /* synthetic */ View getBottomSheet() {
        return null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.0f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_bottomsheet_promocode_info;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        Bundle arguments = getArguments();
        if (arguments != null) {
            ((TextView) BuiltInFictitiousFunctionClassFactory(R.id.GetPureRepPrice)).setText(arguments.getString("promo_code_title_key"));
            ((TextView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a149f_appmeasurement_conditionaluserproperty)).setText(arguments.getString("promo_code_desc_key"));
            ((DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.SummaryVoucherView$$ExternalSyntheticLambda2)).setActiveButton(arguments.getString("promo_code_positive_button_key"), null);
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) BuiltInFictitiousFunctionClassFactory(R.id.M);
            String string = arguments.getString("promo_code_negative_button_key");
            if (string == null) {
                string = getString(R.string.promocode_bottomsheet_back);
                Intrinsics.checkNotNullExpressionValue(string, "");
            }
            danaButtonSecondaryView.setActiveButton(string, null);
            InstrumentInjector.Resources_setImageResource((ImageView) BuiltInFictitiousFunctionClassFactory(R.id.JvmProtoBuf$JvmPropertySignature$Builder), arguments.getInt("promo_code_image_resource_key"));
            ((DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.SummaryVoucherView$$ExternalSyntheticLambda2)).setButtonContentDescription(getString(R.string.btn_continue_promo));
        }
        ((DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.SummaryVoucherView$$ExternalSyntheticLambda2)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocode.views.PromoCodeBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromoCodeBottomSheet.PlaceComponentResult(PromoCodeBottomSheet.this);
            }
        });
        ((DanaButtonSecondaryView) BuiltInFictitiousFunctionClassFactory(R.id.M)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocode.views.PromoCodeBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromoCodeBottomSheet.MyBillsEntityDataFactory(PromoCodeBottomSheet.this);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/promocode/views/PromoCodeBottomSheet$Companion;", "", "", "p0", "", "p1", "p2", "p3", "p4", "Lid/dana/promocode/views/PromoCodeBottomSheet;", "getAuthRequestContext", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/promocode/views/PromoCodeBottomSheet;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static PromoCodeBottomSheet getAuthRequestContext(int i, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            PromoCodeBottomSheet promoCodeBottomSheet = new PromoCodeBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString("promo_code_title_key", str);
            bundle.putString("promo_code_desc_key", str2);
            bundle.putString("promo_code_positive_button_key", str3);
            bundle.putString("promo_code_negative_button_key", null);
            bundle.putInt("promo_code_image_resource_key", i);
            promoCodeBottomSheet.setArguments(bundle);
            return promoCodeBottomSheet;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(PromoCodeBottomSheet promoCodeBottomSheet) {
        Intrinsics.checkNotNullParameter(promoCodeBottomSheet, "");
        PromocodeBottomSheetListener promocodeBottomSheetListener = promoCodeBottomSheet.getAuthRequestContext;
        if (promocodeBottomSheetListener != null) {
            promocodeBottomSheetListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PromoCodeBottomSheet promoCodeBottomSheet) {
        Intrinsics.checkNotNullParameter(promoCodeBottomSheet, "");
        promoCodeBottomSheet.dismiss();
        PromocodeBottomSheetListener promocodeBottomSheetListener = promoCodeBottomSheet.getAuthRequestContext;
        if (promocodeBottomSheetListener != null) {
            promocodeBottomSheetListener.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
