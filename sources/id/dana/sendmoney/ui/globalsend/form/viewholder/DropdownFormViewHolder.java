package id.dana.sendmoney.ui.globalsend.form.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemDropdownFormBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.amount.TransactionPurposeFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.BankNameFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityFormModel;
import id.dana.sendmoney.ui.globalsend.form.view.FormOptionBottomSheetDialogFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B7\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0017\u0012\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JE\u0010\u000f\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b@GX\u0086\n¢\u0006\f\n\u0004\b\u0006\u0010\u0014\"\u0004\b\u000f\u0010\u0015R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u0016\u0010\u000f\u001a\u00020\u001b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u00118\u0005X\u0085\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0016\u0010 "}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/DropdownFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemDropdownFormBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;)V", "", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "Lkotlin/Function1;", "", "", "p1", "p2", "getAuthRequestContext", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;I)V", "Ljava/lang/String;", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "Landroidx/fragment/app/FragmentManager;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentManager;", "Lkotlin/jvm/functions/Function1;", "Lid/dana/sendmoney/ui/globalsend/form/view/FormOptionBottomSheetDialogFragment;", "Lid/dana/sendmoney/ui/globalsend/form/view/FormOptionBottomSheetDialogFragment;", "lookAheadTest", "scheduleImpl", "I", "()I", "p3", "<init>", "(Lid/dana/sendmoney/databinding/ItemDropdownFormBinding;ILandroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class DropdownFormViewHolder extends BaseGlobalSendFormViewHolder<ItemDropdownFormBinding, GlobalSendFormModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function1<GlobalSendFormOptionModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FragmentManager BuiltInFictitiousFunctionClassFactory;
    private FormOptionBottomSheetDialogFragment getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String PlaceComponentResult;
    private final int scheduleImpl;

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final int getScheduleImpl() {
        return this.scheduleImpl;
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder$1  reason: invalid class name */
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
    /* JADX WARN: Multi-variable type inference failed */
    public DropdownFormViewHolder(ItemDropdownFormBinding itemDropdownFormBinding, int i, FragmentManager fragmentManager, Function1<? super GlobalSendFormOptionModel, Unit> function1) {
        super(itemDropdownFormBinding);
        Intrinsics.checkNotNullParameter(itemDropdownFormBinding, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.scheduleImpl = i;
        this.BuiltInFictitiousFunctionClassFactory = fragmentManager;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        this.MyBillsEntityDataFactory = "";
        this.PlaceComponentResult = "";
    }

    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (Intrinsics.areEqual(str, this.MyBillsEntityDataFactory)) {
            return;
        }
        this.MyBillsEntityDataFactory = str;
        ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).moveToNextValue.setText(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public void getAuthRequestContext(GlobalSendFormModel p0) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(p0, "");
        int i = this.scheduleImpl;
        if (i == 1) {
            TransactionPurposeFormModel transactionPurposeFormModel = p0 instanceof TransactionPurposeFormModel ? (TransactionPurposeFormModel) p0 : null;
            if (transactionPurposeFormModel != null) {
                Iterator<T> it = transactionPurposeFormModel.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
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
                ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).scheduleImpl.setText(R.string.transaction_purpose_title);
                BuiltInFictitiousFunctionClassFactory(globalSendFormOptionModel != null ? globalSendFormOptionModel.BuiltInFictitiousFunctionClassFactory : null, R.string.transaction_purpose_hint_text);
                getAuthRequestContext(transactionPurposeFormModel.KClassImpl$Data$declaredNonStaticMembers$2, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder$setupBottomSheetOptionPicker$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                        return Boolean.TRUE;
                    }
                }, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder$setupBottomSheetOptionPicker$2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }
                });
            }
        } else if (i != 9) {
            if (i == 17) {
                CityFormModel cityFormModel = p0 instanceof CityFormModel ? (CityFormModel) p0 : null;
                if (cityFormModel != null) {
                    Iterator<T> it2 = cityFormModel.getAuthRequestContext.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it2.next();
                        if (((GlobalSendFormOptionModel) obj3).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                            break;
                        }
                    }
                    GlobalSendFormOptionModel globalSendFormOptionModel2 = (GlobalSendFormOptionModel) obj3;
                    CardView cardView = ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(cardView, "");
                    cardView.setVisibility(8);
                    getAuthRequestContext(cityFormModel.BuiltInFictitiousFunctionClassFactory);
                    ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).scheduleImpl.setText(cityFormModel.KClassImpl$Data$declaredNonStaticMembers$2);
                    BuiltInFictitiousFunctionClassFactory(globalSendFormOptionModel2 != null ? globalSendFormOptionModel2.BuiltInFictitiousFunctionClassFactory : null, cityFormModel.MyBillsEntityDataFactory);
                    if ((!cityFormModel.getAuthRequestContext.isEmpty()) == true) {
                        getAuthRequestContext(cityFormModel.getAuthRequestContext, cityFormModel.getErrorConfigVersion, cityFormModel.scheduleImpl);
                    }
                }
            }
        } else {
            BankNameFormModel bankNameFormModel = p0 instanceof BankNameFormModel ? (BankNameFormModel) p0 : null;
            if (bankNameFormModel != null) {
                Iterator<T> it3 = bankNameFormModel.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it3.next();
                    if (((GlobalSendFormOptionModel) obj2).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                        break;
                    }
                }
                GlobalSendFormOptionModel globalSendFormOptionModel3 = (GlobalSendFormOptionModel) obj2;
                CardView cardView2 = ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(cardView2, "");
                cardView2.setVisibility(0);
                ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).scheduleImpl.setText(R.string.header_form_bank_name);
                Integer num = globalSendFormOptionModel3 != null ? globalSendFormOptionModel3.MyBillsEntityDataFactory : null;
                if (num != null) {
                    int intValue = num.intValue();
                    CircleImageView circleImageView = ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullExpressionValue(circleImageView, "");
                    circleImageView.setVisibility(0);
                    if (circleImageView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(circleImageView, intValue);
                    } else {
                        circleImageView.setImageResource(intValue);
                    }
                }
                BuiltInFictitiousFunctionClassFactory(globalSendFormOptionModel3 != null ? globalSendFormOptionModel3.BuiltInFictitiousFunctionClassFactory : null, R.string.res_0x7f130a66_flowablecreate_bufferasyncemitter);
                getAuthRequestContext(bankNameFormModel.KClassImpl$Data$declaredNonStaticMembers$2, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder$setupBottomSheetOptionPicker$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                        return Boolean.TRUE;
                    }
                }, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder$setupBottomSheetOptionPicker$2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        Intrinsics.checkNotNullParameter(str, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(List<GlobalSendFormOptionModel> p0, final Function1<? super String, Boolean> p1, final Function1<? super String, Unit> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.getAuthRequestContext = new FormOptionBottomSheetDialogFragment(this.scheduleImpl, p0, new Function1<GlobalSendFormOptionModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder$setupBottomSheetOptionPicker$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GlobalSendFormOptionModel globalSendFormOptionModel) {
                invoke2(globalSendFormOptionModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GlobalSendFormOptionModel globalSendFormOptionModel) {
                String str;
                String str2;
                Function1 function1;
                Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
                DropdownFormViewHolder.this.PlaceComponentResult = globalSendFormOptionModel.BuiltInFictitiousFunctionClassFactory;
                Function1<String, Unit> function12 = p2;
                str = DropdownFormViewHolder.this.PlaceComponentResult;
                function12.invoke(str);
                Function1<String, Boolean> function13 = p1;
                str2 = DropdownFormViewHolder.this.PlaceComponentResult;
                function13.invoke(str2);
                function1 = DropdownFormViewHolder.this.KClassImpl$Data$declaredNonStaticMembers$2;
                function1.invoke(globalSendFormOptionModel);
            }
        }, new Function2<String, Boolean, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder$setupBottomSheetOptionPicker$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String str, boolean z) {
                String str2;
                Intrinsics.checkNotNullParameter(str, "");
                DropdownFormViewHolder.this.PlaceComponentResult = str;
                if (!z) {
                    str2 = DropdownFormViewHolder.this.PlaceComponentResult;
                    if (!(str2.length() > 0)) {
                        DropdownFormViewHolder.getAuthRequestContext(DropdownFormViewHolder.this);
                        return;
                    }
                }
                DropdownFormViewHolder.PlaceComponentResult(DropdownFormViewHolder.this);
            }
        });
        ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DropdownFormViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(DropdownFormViewHolder.this);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/DropdownFormViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemDropdownFormBinding;", "PlaceComponentResult", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemDropdownFormBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemDropdownFormBinding PlaceComponentResult(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemDropdownFormBinding MyBillsEntityDataFactory = ItemDropdownFormBinding.MyBillsEntityDataFactory(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            return MyBillsEntityDataFactory;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DropdownFormViewHolder dropdownFormViewHolder) {
        Intrinsics.checkNotNullParameter(dropdownFormViewHolder, "");
        FragmentManager fragmentManager = dropdownFormViewHolder.BuiltInFictitiousFunctionClassFactory;
        if (fragmentManager != null) {
            FormOptionBottomSheetDialogFragment formOptionBottomSheetDialogFragment = dropdownFormViewHolder.getAuthRequestContext;
            FormOptionBottomSheetDialogFragment formOptionBottomSheetDialogFragment2 = null;
            if (formOptionBottomSheetDialogFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                formOptionBottomSheetDialogFragment = null;
            }
            FormOptionBottomSheetDialogFragment formOptionBottomSheetDialogFragment3 = dropdownFormViewHolder.getAuthRequestContext;
            if (formOptionBottomSheetDialogFragment3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                formOptionBottomSheetDialogFragment2 = formOptionBottomSheetDialogFragment3;
            }
            formOptionBottomSheetDialogFragment.show(fragmentManager, formOptionBottomSheetDialogFragment2.getTag());
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(DropdownFormViewHolder dropdownFormViewHolder) {
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(((ItemDropdownFormBinding) dropdownFormViewHolder.MyBillsEntityDataFactory).scheduleImpl, R.style.BuiltInFictitiousFunctionClassFactory);
        ((ItemDropdownFormBinding) dropdownFormViewHolder.MyBillsEntityDataFactory).PlaceComponentResult.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(((ItemDropdownFormBinding) dropdownFormViewHolder.MyBillsEntityDataFactory).NetworkUserEntityData$$ExternalSyntheticLambda0.getResources(), R.drawable.DatabaseTableConfigUtil, null));
        TextView textView = ((ItemDropdownFormBinding) dropdownFormViewHolder.MyBillsEntityDataFactory).moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
    }

    public static final /* synthetic */ void PlaceComponentResult(DropdownFormViewHolder dropdownFormViewHolder) {
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(((ItemDropdownFormBinding) dropdownFormViewHolder.MyBillsEntityDataFactory).scheduleImpl, R.style.MyBillsEntityDataFactory);
        ((ItemDropdownFormBinding) dropdownFormViewHolder.MyBillsEntityDataFactory).PlaceComponentResult.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(((ItemDropdownFormBinding) dropdownFormViewHolder.MyBillsEntityDataFactory).NetworkUserEntityData$$ExternalSyntheticLambda0.getResources(), R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda0, null));
        TextView textView = ((ItemDropdownFormBinding) dropdownFormViewHolder.MyBillsEntityDataFactory).moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(String p0, int p1) {
        if (p0 != null) {
            TextView textView = ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).lookAheadTest;
            textView.setText(p0);
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView.getContext(), R.color.lookAheadTest));
            return;
        }
        TextView textView2 = ((ItemDropdownFormBinding) this.MyBillsEntityDataFactory).lookAheadTest;
        textView2.setText(p1);
        textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView2.getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157));
    }
}
