package id.dana.sendmoney.ui.groupsend.recipient.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.sendmoney.databinding.ItemAddNewPhoneNumberBinding;
import id.dana.sendmoney.databinding.ItemGroupRecipientBinding;
import id.dana.sendmoney.databinding.ItemGroupRecipientContactNoPermissionBinding;
import id.dana.sendmoney.databinding.ItemGroupRecipientSectionBinding;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.viewholder.AddNewPhoneNumberViewHolder;
import id.dana.sendmoney.ui.groupsend.recipient.viewholder.BaseRecipientViewHolder;
import id.dana.sendmoney.ui.groupsend.recipient.viewholder.EmptyStateViewHolder;
import id.dana.sendmoney.ui.groupsend.recipient.viewholder.RecipientViewHolder;
import id.dana.sendmoney.ui.groupsend.recipient.viewholder.SectionViewHolder;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R.\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/adapter/RecipientAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/BaseRecipientViewHolder;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)Ljava/lang/String;", "Landroid/view/ViewGroup;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/EmptyStateViewHolder;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/EmptyStateViewHolder;", "", "(Ljava/lang/String;)C", "getItemViewType", "(I)I", "", "PlaceComponentResult", "(I)Z", "getAuthRequestContext", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function3;", "Lkotlin/jvm/functions/Function3;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecipientAdapter extends PagingDataAdapter<RecipientViewModel, BaseRecipientViewHolder<?>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Function3<? super RecipientViewModel, ? super Boolean, ? super Integer, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        BaseRecipientViewHolder baseRecipientViewHolder = (BaseRecipientViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(baseRecipientViewHolder, "");
        RecipientViewModel recipientViewModel = (RecipientViewModel) this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i);
        if (recipientViewModel != null) {
            baseRecipientViewHolder.MyBillsEntityDataFactory(recipientViewModel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SectionViewHolder sectionViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i != 1 && i != 10) {
            Function3<? super RecipientViewModel, ? super Boolean, ? super Integer, Unit> function3 = null;
            if (i == 3) {
                ItemGroupRecipientBinding MyBillsEntityDataFactory = ItemGroupRecipientBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                Function3<? super RecipientViewModel, ? super Boolean, ? super Integer, Unit> function32 = this.PlaceComponentResult;
                if (function32 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    function3 = function32;
                }
                sectionViewHolder = new RecipientViewHolder(MyBillsEntityDataFactory, function3);
            } else {
                if (i != 4 && i != 5) {
                    if (i != 7) {
                        if (i == 8) {
                            ItemAddNewPhoneNumberBinding authRequestContext = ItemAddNewPhoneNumberBinding.getAuthRequestContext(LayoutInflater.from(viewGroup.getContext()), viewGroup);
                            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                            Function3<? super RecipientViewModel, ? super Boolean, ? super Integer, Unit> function33 = this.PlaceComponentResult;
                            if (function33 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                function3 = function33;
                            }
                            sectionViewHolder = new AddNewPhoneNumberViewHolder(authRequestContext, function3);
                        } else {
                            switch (i) {
                                case 19:
                                    break;
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                    break;
                                default:
                                    sectionViewHolder = BuiltInFictitiousFunctionClassFactory(viewGroup);
                                    break;
                            }
                        }
                    }
                }
                sectionViewHolder = BuiltInFictitiousFunctionClassFactory(viewGroup);
            }
            return sectionViewHolder;
        }
        ItemGroupRecipientSectionBinding PlaceComponentResult = ItemGroupRecipientSectionBinding.PlaceComponentResult(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        sectionViewHolder = new SectionViewHolder(PlaceComponentResult);
        return sectionViewHolder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecipientAdapter(DiffUtil.ItemCallback<RecipientViewModel> itemCallback) {
        super(itemCallback, null, null, 6, null);
        Intrinsics.checkNotNullParameter(itemCallback, "");
        this.BuiltInFictitiousFunctionClassFactory = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.adapter.RecipientAdapter$onEmptyStateClickListener$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        if (getItemCount() == 0) {
            return 5;
        }
        List<RecipientViewModel> list = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2;
        if (p0 < 0) {
            p0 = 0;
        }
        RecipientViewModel recipientViewModel = list.get(p0);
        if (recipientViewModel != null) {
            return recipientViewModel.getSupportButtonTintMode;
        }
        return 5;
    }

    private final EmptyStateViewHolder BuiltInFictitiousFunctionClassFactory(ViewGroup p0) {
        ItemGroupRecipientContactNoPermissionBinding authRequestContext = ItemGroupRecipientContactNoPermissionBinding.getAuthRequestContext(LayoutInflater.from(p0.getContext()), p0);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return new EmptyStateViewHolder(authRequestContext, this.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getAuthRequestContext(int p0) {
        return getItemViewType(p0) == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean PlaceComponentResult(int p0) {
        return BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2(p0)) != BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2(p0 - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char BuiltInFictitiousFunctionClassFactory(String p0) {
        return p0.length() == 0 ? InputCardNumberView.DIVIDER : p0.charAt(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        String str;
        String str2;
        List<RecipientViewModel> list = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2;
        if (p0 < 0) {
            p0 = 0;
        }
        RecipientViewModel recipientViewModel = list.get(p0);
        if (recipientViewModel == null || (str2 = recipientViewModel.initRecordTimeStamp) == null) {
            str = null;
        } else {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "");
            str = str2.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        return str == null ? "" : str;
    }
}
