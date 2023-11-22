package id.dana.sendmoney.ui.globalsend.form.viewholder.receiver;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.sendmoney.databinding.ItemDropdownFormBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceFormModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/SelectCountryViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/DropdownFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;)V", "Lid/dana/sendmoney/databinding/ItemDropdownFormBinding;", "", "p1", "Landroidx/fragment/app/FragmentManager;", "p2", "Lkotlin/Function1;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "p3", "<init>", "(Lid/dana/sendmoney/databinding/ItemDropdownFormBinding;ILandroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectCountryViewHolder extends DropdownFormViewHolder {
    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder, id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormModel globalSendFormModel) {
        getAuthRequestContext(globalSendFormModel);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.SelectCountryViewHolder$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends Lambda implements Function1<GlobalSendFormOptionModel, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(GlobalSendFormOptionModel globalSendFormOptionModel) {
            Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(GlobalSendFormOptionModel globalSendFormOptionModel) {
            invoke2(globalSendFormOptionModel);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectCountryViewHolder(ItemDropdownFormBinding itemDropdownFormBinding, int i, FragmentManager fragmentManager, Function1<? super GlobalSendFormOptionModel, Unit> function1) {
        super(itemDropdownFormBinding, i, fragmentManager, function1);
        Intrinsics.checkNotNullParameter(itemDropdownFormBinding, "");
        Intrinsics.checkNotNullParameter(function1, "");
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    public final void getAuthRequestContext(GlobalSendFormModel p0) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        if (super.getScheduleImpl() == 16) {
            ProvinceFormModel provinceFormModel = p0 instanceof ProvinceFormModel ? (ProvinceFormModel) p0 : null;
            if (provinceFormModel != null) {
                Iterator<T> it = provinceFormModel.lookAheadTest.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((GlobalSendFormOptionModel) obj).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                        break;
                    }
                }
                GlobalSendFormOptionModel globalSendFormOptionModel = (GlobalSendFormOptionModel) obj;
                CardView cardView = ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(cardView, "");
                cardView.setVisibility(8);
                super.getAuthRequestContext(provinceFormModel.MyBillsEntityDataFactory);
                ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).scheduleImpl.setText(provinceFormModel.getAuthRequestContext);
                BuiltInFictitiousFunctionClassFactory(globalSendFormOptionModel != null ? globalSendFormOptionModel.BuiltInFictitiousFunctionClassFactory : null, provinceFormModel.PlaceComponentResult);
                getAuthRequestContext(provinceFormModel.lookAheadTest, provinceFormModel.BuiltInFictitiousFunctionClassFactory, provinceFormModel.moveToNextValue);
            }
        }
    }
}
