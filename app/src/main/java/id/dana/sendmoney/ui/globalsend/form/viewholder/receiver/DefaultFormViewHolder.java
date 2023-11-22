package id.dana.sendmoney.ui.globalsend.form.viewholder.receiver;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import id.dana.sendmoney.databinding.ItemDefaultFormBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.DefaultFormModel;
import id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B7\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0011\u0010\f\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0011\u0010\r\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/DefaultFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemDefaultFormBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;)V", "", "MyBillsEntityDataFactory", "I", "PlaceComponentResult", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getErrorConfigVersion", "Z", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/sendmoney/databinding/ItemDefaultFormBinding;IIZI)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class DefaultFormViewHolder extends BaseGlobalSendFormViewHolder<ItemDefaultFormBinding, GlobalSendFormModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ DefaultFormViewHolder(ItemDefaultFormBinding itemDefaultFormBinding, int i, int i2, boolean z, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemDefaultFormBinding, (i4 & 2) != 0 ? 1 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private DefaultFormViewHolder(ItemDefaultFormBinding itemDefaultFormBinding, int i, int i2, boolean z, int i3) {
        super(itemDefaultFormBinding);
        Intrinsics.checkNotNullParameter(itemDefaultFormBinding, "");
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.PlaceComponentResult = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.getAuthRequestContext = i3;
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public void getAuthRequestContext(GlobalSendFormModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DefaultFormModel defaultFormModel = (DefaultFormModel) p0;
        EditTextFormView editTextFormView = ((ItemDefaultFormBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2;
        editTextFormView.setEditTextAccessibilityId(defaultFormModel.BuiltInFictitiousFunctionClassFactory);
        editTextFormView.setHeaderText(defaultFormModel.PlaceComponentResult);
        editTextFormView.setHintText(defaultFormModel.KClassImpl$Data$declaredNonStaticMembers$2);
        editTextFormView.setFormInputType(this.BuiltInFictitiousFunctionClassFactory);
        editTextFormView.setAdditionalInfoTextRes(this.PlaceComponentResult);
        editTextFormView.setShowInfoIcon(this.KClassImpl$Data$declaredNonStaticMembers$2);
        editTextFormView.setSecondaryAdditionalInfoText(this.getAuthRequestContext);
        editTextFormView.setErrorMessageString(defaultFormModel.MyBillsEntityDataFactory);
        editTextFormView.setOnTextFormChanged(defaultFormModel.lookAheadTest);
        editTextFormView.setValidationRuleList(defaultFormModel.scheduleImpl);
        editTextFormView.setMaxLengthFormInput(defaultFormModel.moveToNextValue);
        editTextFormView.setHasCharCounter(defaultFormModel.getGetAuthRequestContext());
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/DefaultFormViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemDefaultFormBinding;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemDefaultFormBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemDefaultFormBinding getAuthRequestContext(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemDefaultFormBinding authRequestContext = ItemDefaultFormBinding.getAuthRequestContext(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            return authRequestContext;
        }
    }
}
