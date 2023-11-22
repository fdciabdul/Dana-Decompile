package id.dana.sendmoney.ui.globalsend.form.viewholder;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemFormOptionGlobalSendBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/FormOptionViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemFormOptionGlobalSendBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "Lkotlin/Function1;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class FormOptionViewHolder extends BaseGlobalSendFormViewHolder<ItemFormOptionGlobalSendBinding, GlobalSendFormOptionModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<GlobalSendFormOptionModel, Unit> getAuthRequestContext;

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormOptionModel globalSendFormOptionModel) {
        final GlobalSendFormOptionModel globalSendFormOptionModel2 = globalSendFormOptionModel;
        Intrinsics.checkNotNullParameter(globalSendFormOptionModel2, "");
        ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory.setText(globalSendFormOptionModel2.BuiltInFictitiousFunctionClassFactory);
        if (globalSendFormOptionModel2.getKClassImpl$Data$declaredNonStaticMembers$2()) {
            AppCompatImageView appCompatImageView = ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(0);
            AppCompatImageView appCompatImageView2 = ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
            appCompatImageView2.setVisibility(8);
            ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.setBackgroundResource(R.color.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            AppCompatImageView appCompatImageView3 = ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
            appCompatImageView3.setVisibility(8);
            AppCompatImageView appCompatImageView4 = ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView4, "");
            appCompatImageView4.setVisibility(0);
            ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.setBackgroundResource(R.color.moveToNextValue);
        }
        ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.FormOptionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormOptionViewHolder.BuiltInFictitiousFunctionClassFactory(FormOptionViewHolder.this, globalSendFormOptionModel2);
            }
        });
        if (globalSendFormOptionModel2.MyBillsEntityDataFactory != null) {
            CircleImageView circleImageView = ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            circleImageView.setVisibility(0);
            CircleImageView circleImageView2 = ((ItemFormOptionGlobalSendBinding) this.MyBillsEntityDataFactory).getAuthRequestContext;
            int intValue = globalSendFormOptionModel2.MyBillsEntityDataFactory.intValue();
            if (circleImageView2 instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(circleImageView2, intValue);
            } else {
                circleImageView2.setImageResource(intValue);
            }
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FormOptionViewHolder formOptionViewHolder, GlobalSendFormOptionModel globalSendFormOptionModel) {
        Intrinsics.checkNotNullParameter(formOptionViewHolder, "");
        Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
        formOptionViewHolder.getAuthRequestContext.invoke(globalSendFormOptionModel);
    }
}
