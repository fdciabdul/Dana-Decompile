package id.dana.sendmoney.ui.groupsend.summary.util;

import android.content.Context;
import id.dana.core.ui.util.MaskedTextUtil;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity;
import id.dana.sendmoney.ui.groupsend.summary.model.PayeeUserInfoModel;
import id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetInputAmountDialogFragment;
import id.dana.sendmoney.ui.groupsend.summary.view.InputAmountListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0004\b\t\u0010\n\u001a3\u0010\u0011\u001a\u00020\u0010*\u00020\u000b2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0005\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Landroid/content/Context;", "", "Lid/dana/sendmoney/ui/groupsend/summary/model/PayeeUserInfoModel;", "p0", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/util/List;Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;)Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "Lid/dana/sendmoney/ui/groupsend/summary/activity/GroupSendSummaryActivity;", "Lkotlin/Function2;", "", "", "", "Lid/dana/sendmoney/ui/groupsend/summary/view/InputAmountListener;", "PlaceComponentResult", "(Lid/dana/sendmoney/ui/groupsend/summary/activity/GroupSendSummaryActivity;Lkotlin/jvm/functions/Function2;I)Lid/dana/sendmoney/ui/groupsend/summary/view/InputAmountListener;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendSummaryExtKt {
    public static final InputAmountListener PlaceComponentResult(final GroupSendSummaryActivity groupSendSummaryActivity, final Function2<? super String, ? super Boolean, Unit> function2, final int i) {
        Intrinsics.checkNotNullParameter(groupSendSummaryActivity, "");
        Intrinsics.checkNotNullParameter(function2, "");
        return new InputAmountListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.util.GroupSendSummaryExtKt$getInputAmountListener$1
            @Override // id.dana.sendmoney.ui.groupsend.summary.view.InputAmountListener
            public final void MyBillsEntityDataFactory(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                GroupSendSummaryActivity.this.setSelectedMemberIndex(p1);
                String str = p0;
                StringBuilder sb = new StringBuilder();
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isDigit(charAt)) {
                        sb.append(charAt);
                    }
                }
                String obj = sb.toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                new BottomSheetInputAmountDialogFragment(Long.parseLong(obj), GroupSendSummaryActivity.this.getGroupSendInitResponse().BuiltInFictitiousFunctionClassFactory, GroupSendSummaryActivity.this.getGroupSendInitResponse().getAuthRequestContext, GroupSendSummaryActivity.this.getGroupSendInitResponse().PlaceComponentResult, GroupSendSummaryActivity.this.getRemainingLimit(), i, function2).show(GroupSendSummaryActivity.this.getSupportFragmentManager(), "BottomSheetInputAmountDialogFragment");
            }
        };
    }

    public static final String getAuthRequestContext(Context context, String str, List<? extends RecipientViewModel> list) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        String str2 = str;
        if (str2.length() == 0) {
            ArrayList arrayList = new ArrayList();
            for (RecipientViewModel recipientViewModel : list) {
                if (Intrinsics.areEqual(recipientViewModel.initRecordTimeStamp, context.getString(R.string.res_0x7f1312c9_securitysettingsactivity_createpinlauncher_2_1)) || Intrinsics.areEqual(recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda2, "-")) {
                    arrayList.addAll(CollectionsKt.listOf(recipientViewModel.DatabaseTableConfigUtil));
                } else {
                    MaskedTextUtil maskedTextUtil = MaskedTextUtil.INSTANCE;
                    String str3 = recipientViewModel.initRecordTimeStamp;
                    Intrinsics.checkNotNullExpressionValue(str3, "");
                    arrayList.addAll(CollectionsKt.listOf(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(str3)));
                }
            }
            str2 = CollectionsKt.joinToString$default(arrayList, ", ", "", "", 5, "...", null, 32, null);
        }
        return StringsKt.take(str2, 64);
    }

    public static final RecipientViewModel KClassImpl$Data$declaredNonStaticMembers$2(Context context, List<PayeeUserInfoModel> list, RecipientViewModel recipientViewModel) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(recipientViewModel, "");
        for (PayeeUserInfoModel payeeUserInfoModel : list) {
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            if (Intrinsics.areEqual(NumberUtil.PlaceComponentResult(recipientViewModel.DatabaseTableConfigUtil, "62-"), payeeUserInfoModel.MyBillsEntityDataFactory)) {
                recipientViewModel.PlaceComponentResult = payeeUserInfoModel.lookAheadTest;
                recipientViewModel.scheduleImpl = payeeUserInfoModel.BuiltInFictitiousFunctionClassFactory;
                recipientViewModel.GetContactSyncConfig = payeeUserInfoModel.moveToNextValue;
                recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = payeeUserInfoModel.scheduleImpl;
                if (Intrinsics.areEqual(recipientViewModel.initRecordTimeStamp, context.getString(R.string.res_0x7f1312c9_securitysettingsactivity_createpinlauncher_2_1))) {
                    recipientViewModel.initRecordTimeStamp = payeeUserInfoModel.scheduleImpl;
                }
                recipientViewModel.moveToNextValue = true;
                return recipientViewModel;
            }
        }
        recipientViewModel.PlaceComponentResult = "";
        return recipientViewModel;
    }
}
