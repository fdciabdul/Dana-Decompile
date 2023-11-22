package id.dana.animation;

import android.content.res.ColorStateList;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import id.dana.R;
import id.dana.animation.model.EddAnswerInfoDTOModel;
import id.dana.animation.model.EddQuestionInfoDTOModel;
import id.dana.base.BaseRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\n\u0012&\u0010\u000e\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0005\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u000f\u0010\u0010R4\u0010\t\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0005\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u00060\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0007\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/home/KycAmlEddItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/home/model/EddQuestionInfoDTOModel;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function2;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KycAmlEddItemViewHolder extends BaseRecyclerViewHolder<EddQuestionInfoDTOModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function2<String, String, Unit> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(EddQuestionInfoDTOModel eddQuestionInfoDTOModel) {
        final EddQuestionInfoDTOModel eddQuestionInfoDTOModel2 = eddQuestionInfoDTOModel;
        Intrinsics.checkNotNullParameter(eddQuestionInfoDTOModel2, "");
        TextView textView = (TextView) this.itemView.findViewById(R.id.tv_kyc_aml_view_holder);
        if (textView != null) {
            String str = eddQuestionInfoDTOModel2.KClassImpl$Data$declaredNonStaticMembers$2;
            String str2 = eddQuestionInfoDTOModel2.MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(". ");
            sb.append(str2);
            textView.setText(sb.toString());
        }
        for (EddAnswerInfoDTOModel eddAnswerInfoDTOModel : eddQuestionInfoDTOModel2.BuiltInFictitiousFunctionClassFactory) {
            AppCompatRadioButton appCompatRadioButton = new AppCompatRadioButton(getContext());
            appCompatRadioButton.setText(eddAnswerInfoDTOModel.KClassImpl$Data$declaredNonStaticMembers$2);
            appCompatRadioButton.setTag(eddAnswerInfoDTOModel.getAuthRequestContext);
            appCompatRadioButton.setTypeface(ResourcesCompat.PlaceComponentResult(getContext(), (int) R.font.f34272131296265));
            appCompatRadioButton.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f24002131099997));
            appCompatRadioButton.setTextSize(2, 14.0f);
            appCompatRadioButton.setSupportButtonTintList(new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23972131099993), ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22912131099753)}));
            RadioGroup radioGroup = (RadioGroup) this.itemView.findViewById(R.id.rg_kyc_aml_view_holder);
            if (radioGroup != null) {
                radioGroup.addView(appCompatRadioButton);
            }
        }
        ((RadioGroup) this.itemView.findViewById(R.id.rg_kyc_aml_view_holder)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: id.dana.home.KycAmlEddItemViewHolder$$ExternalSyntheticLambda0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                KycAmlEddItemViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(KycAmlEddItemViewHolder.this, eddQuestionInfoDTOModel2, i);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KycAmlEddItemViewHolder(ViewGroup viewGroup, Function2<? super String, ? super String, Unit> function2) {
        super(viewGroup.getContext(), R.layout.kyc_aml_edd_item_view_holder, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
        this.MyBillsEntityDataFactory = function2;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(KycAmlEddItemViewHolder kycAmlEddItemViewHolder, EddQuestionInfoDTOModel eddQuestionInfoDTOModel, int i) {
        Intrinsics.checkNotNullParameter(kycAmlEddItemViewHolder, "");
        Intrinsics.checkNotNullParameter(eddQuestionInfoDTOModel, "");
        kycAmlEddItemViewHolder.MyBillsEntityDataFactory.invoke(eddQuestionInfoDTOModel.KClassImpl$Data$declaredNonStaticMembers$2, ((AppCompatRadioButton) kycAmlEddItemViewHolder.itemView.findViewById(i)).getTag().toString());
    }
}
