package id.dana.cancelsurvey.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cancelsurvey.adapter.CancelReasonAdapter;
import id.dana.cancelsurvey.model.CancelReasonModel;
import id.dana.component.edittextcomponent.DanaEditTextView;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\f"}, d2 = {"Lid/dana/cancelsurvey/adapter/CancelReasonAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/cancelsurvey/adapter/CancelReasonAdapter$CancelReasonViewHolder;", "Lid/dana/cancelsurvey/model/CancelReasonModel;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cancelsurvey/adapter/CancelReasonAdapter$CancelReasonViewHolder;I)V", "Lkotlin/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "", "getAuthRequestContext", "MyBillsEntityDataFactory", "", "<init>", "(Ljava/util/List;)V", "CancelReasonViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CancelReasonAdapter extends BaseRecyclerViewAdapter<CancelReasonViewHolder, CancelReasonModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Function1<? super CancelReasonModel, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Function1<? super Boolean, Unit> MyBillsEntityDataFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new CancelReasonViewHolder(viewGroup, new Function1<Boolean, Unit>() { // from class: id.dana.cancelsurvey.adapter.CancelReasonAdapter$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Function1<? super Boolean, Unit> function1 = CancelReasonAdapter.this.MyBillsEntityDataFactory;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(z));
                }
            }
        }, new Function1<CancelReasonModel, Unit>() { // from class: id.dana.cancelsurvey.adapter.CancelReasonAdapter$onCreateViewHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CancelReasonModel cancelReasonModel) {
                invoke2(cancelReasonModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CancelReasonModel cancelReasonModel) {
                Intrinsics.checkNotNullParameter(cancelReasonModel, "");
                Function1<? super CancelReasonModel, Unit> function1 = CancelReasonAdapter.this.PlaceComponentResult;
                if (function1 != null) {
                    function1.invoke(cancelReasonModel);
                }
            }
        });
    }

    public CancelReasonAdapter(List<CancelReasonModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        setItems(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(CancelReasonViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<CancelReasonModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        if (p1 == CollectionsKt.getLastIndex(items)) {
            p0.setIsRecyclable(false);
        }
        super.onBindViewHolder((CancelReasonAdapter) p0, p1);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006"}, d2 = {"Lid/dana/cancelsurvey/adapter/CancelReasonAdapter$CancelReasonViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/cancelsurvey/model/CancelReasonModel;", "Lkotlin/Function1;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class CancelReasonViewHolder extends BaseRecyclerViewHolder<CancelReasonModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final Function1<Boolean, Unit> PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final Function1<CancelReasonModel, Unit> getAuthRequestContext;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(CancelReasonModel cancelReasonModel) {
            final CancelReasonModel cancelReasonModel2 = cancelReasonModel;
            if (cancelReasonModel2 != null) {
                final View view = this.itemView;
                TextView textView = (TextView) view.findViewById(R.id.res_0x7f0a188c_daggerserviceagreementcomponent_builder);
                if (textView != null) {
                    textView.setText(cancelReasonModel2.PlaceComponentResult);
                }
                RadioButton radioButton = (RadioButton) view.findViewById(R.id.rb_selected_reason);
                if (radioButton != null) {
                    Intrinsics.checkNotNullExpressionValue(radioButton, "");
                    radioButton.setChecked(cancelReasonModel2.getGetAuthRequestContext());
                    radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.cancelsurvey.adapter.CancelReasonAdapter$CancelReasonViewHolder$$ExternalSyntheticLambda2
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            CancelReasonAdapter.CancelReasonViewHolder.PlaceComponentResult(CancelReasonAdapter.CancelReasonViewHolder.this, cancelReasonModel2, z);
                        }
                    });
                }
                boolean z = cancelReasonModel2.getBuiltInFictitiousFunctionClassFactory() && cancelReasonModel2.getGetAuthRequestContext();
                Intrinsics.checkNotNullExpressionValue(view, "");
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.container_other_reason);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(z ? 0 : 8);
                }
                if (z) {
                    addDisposable(RxTextView.textChanges((DanaEditTextView) view.findViewById(R.id.res_0x7f0a069d_spansuppressionstrategy_1)).subscribe(new Consumer() { // from class: id.dana.cancelsurvey.adapter.CancelReasonAdapter$CancelReasonViewHolder$$ExternalSyntheticLambda1
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            CancelReasonAdapter.CancelReasonViewHolder.MyBillsEntityDataFactory(CancelReasonModel.this, view, this, (CharSequence) obj);
                        }
                    }));
                    DanaEditTextView danaEditTextView = (DanaEditTextView) view.findViewById(R.id.res_0x7f0a069d_spansuppressionstrategy_1);
                    if (danaEditTextView != null) {
                        danaEditTextView.setText("");
                        danaEditTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.cancelsurvey.adapter.CancelReasonAdapter$CancelReasonViewHolder$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnFocusChangeListener
                            public final void onFocusChange(View view2, boolean z2) {
                                CancelReasonAdapter.CancelReasonViewHolder.PlaceComponentResult(view, z2);
                            }
                        });
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CancelReasonViewHolder(ViewGroup viewGroup, Function1<? super Boolean, Unit> function1, Function1<? super CancelReasonModel, Unit> function12) {
            super(viewGroup.getContext(), R.layout.item_cancel_reason, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(function12, "");
            this.PlaceComponentResult = function1;
            this.getAuthRequestContext = function12;
        }

        public static /* synthetic */ void PlaceComponentResult(View view, boolean z) {
            Intrinsics.checkNotNullParameter(view, "");
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.res_0x7f0a0b5f_callcsordianaviewmodel_gethelpbuttonchatbotfeature_2);
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(z ? 0 : 8);
            }
        }

        public static /* synthetic */ void PlaceComponentResult(CancelReasonViewHolder cancelReasonViewHolder, CancelReasonModel cancelReasonModel, boolean z) {
            Intrinsics.checkNotNullParameter(cancelReasonViewHolder, "");
            Intrinsics.checkNotNullParameter(cancelReasonModel, "");
            if (z) {
                cancelReasonViewHolder.getAuthRequestContext.invoke(cancelReasonModel);
            }
        }

        public static /* synthetic */ void MyBillsEntityDataFactory(CancelReasonModel cancelReasonModel, View view, CancelReasonViewHolder cancelReasonViewHolder, CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(cancelReasonModel, "");
            Intrinsics.checkNotNullParameter(view, "");
            Intrinsics.checkNotNullParameter(cancelReasonViewHolder, "");
            String obj = charSequence.toString();
            Intrinsics.checkNotNullParameter(obj, "");
            cancelReasonModel.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
            TextView textView = (TextView) view.findViewById(R.id.tv_reason_helper);
            if (textView != null) {
                textView.setText(view.getContext().getString(R.string.cancel_survey_others_helper, String.valueOf(charSequence.length())));
            }
            Function1<Boolean, Unit> function1 = cancelReasonViewHolder.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(charSequence, "");
            function1.invoke(Boolean.valueOf(!StringsKt.isBlank(charSequence)));
        }
    }
}
