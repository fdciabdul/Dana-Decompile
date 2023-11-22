package id.dana.expresspurchase.view;

import android.content.Context;
import android.view.View;
import com.afollestad.materialdialogs.MaterialDialog;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018JE\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseGoldViewExtender;", "", "", "p0", "", "p1", "Lkotlin/Function0;", "", "p2", "Lkotlin/Function2;", "p3", "PlaceComponentResult", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;)V", "Landroid/content/Context;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "getAuthRequestContext", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "MyBillsEntityDataFactory", "<init>", "(Landroid/content/Context;Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpressPurchaseGoldViewExtender {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ExpressPurchaseContract.Presenter MyBillsEntityDataFactory;

    public ExpressPurchaseGoldViewExtender(Context context, ExpressPurchaseContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(presenter, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = presenter;
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [T, com.afollestad.materialdialogs.MaterialDialog] */
    public final void PlaceComponentResult(final boolean p0, String p1, final Function0<Unit> p2, final Function2<? super Boolean, ? super Boolean, Unit> p3) {
        String string;
        String str;
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        CustomDialog.Builder builder = new CustomDialog.Builder(this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (p0) {
            string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.ep_price_change_dialog_title);
        } else {
            string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.ep_gold_price_not_changed_title);
        }
        builder.SubSequence = string;
        if (p0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.ep_price_change_dialog_desc);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            str = String.format(string2, Arrays.copyOf(new Object[]{p1}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else {
            str = null;
        }
        builder.GetContactSyncConfig = str;
        CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult.moveToNextValue = 0L;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.dialog_positive), new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseGoldViewExtender$onGoldPriceChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                EventBus.getDefault().unregister(Reflection.getOrCreateKotlinClass(OfferProductView.class));
                p3.invoke(Boolean.FALSE, Boolean.valueOf(p0));
                p2.invoke();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.dialog_negative), new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseGoldViewExtender$onGoldPriceChanged$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                p3.invoke(Boolean.TRUE, Boolean.valueOf(p0));
                MaterialDialog materialDialog = objectRef.element;
                if (materialDialog != null) {
                    materialDialog.dismiss();
                }
            }
        });
        String string3 = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.sdet_lbl_confirm_price_change);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.sdet_lbl_confirm_default);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        if (!p0) {
            string3 = string4;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.whenAvailable = string3;
        String string5 = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.sdet_txt_confirm_price_change);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested = p0 ? string5 : "";
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4 = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.sdet_btn_yes);
        KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.sdet_btn_no);
        objectRef.element = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        ((MaterialDialog) objectRef.element).show();
    }

    public final void BuiltInFictitiousFunctionClassFactory(ExpressPurchaseModel.Gold p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ExpressPurchaseContract.Presenter presenter = this.MyBillsEntityDataFactory;
        List<String> list = p0.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Map<String, ? extends Object> map = p0.DatabaseTableConfigUtil;
        String str = p0.initRecordTimeStamp;
        presenter.PlaceComponentResult(p0, list, map, str != null ? str : "");
    }
}
