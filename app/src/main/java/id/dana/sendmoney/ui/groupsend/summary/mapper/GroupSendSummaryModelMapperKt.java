package id.dana.sendmoney.ui.groupsend.summary.mapper;

import android.content.Context;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.util.NumberUtil;
import id.dana.domain.user.CurrencyAmount;
import id.dana.sendmoney.R;
import id.dana.sendmoney.domain.groupsend.model.init.PayeeUserInfo;
import id.dana.sendmoney.domain.groupsend.model.init.SendMoneyGroupInit;
import id.dana.sendmoney.domain.groupsend.model.submit.Milestone;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantInfoSubmit;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantSubmit;
import id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.summary.model.MilestoneModel;
import id.dana.sendmoney.ui.groupsend.summary.model.ParticipantInfoSubmitModel;
import id.dana.sendmoney.ui.groupsend.summary.model.ParticipantSubmitModel;
import id.dana.sendmoney.ui.groupsend.summary.model.PayeeUserInfoModel;
import id.dana.sendmoney.ui.groupsend.summary.model.SendMoneyGroupConfirmModel;
import id.dana.sendmoney.ui.groupsend.summary.model.SendMoneyGroupInitModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\u0002\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\u0002\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a;\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f*\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0004\b\u0002\u0010\u0017"}, d2 = {"Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/core/ui/model/CurrencyAmountModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/user/CurrencyAmount;)Lid/dana/core/ui/model/CurrencyAmountModel;", "Lid/dana/sendmoney/ui/groupsend/summary/model/ParticipantSubmitModel;", "Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantSubmit;", "getAuthRequestContext", "(Lid/dana/sendmoney/ui/groupsend/summary/model/ParticipantSubmitModel;)Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantSubmit;", "Lid/dana/sendmoney/domain/groupsend/model/submit/SendMoneyGroupConfirm;", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupConfirmModel;", "(Lid/dana/sendmoney/domain/groupsend/model/submit/SendMoneyGroupConfirm;)Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupConfirmModel;", "Lid/dana/sendmoney/domain/groupsend/model/init/SendMoneyGroupInit;", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/domain/groupsend/model/init/SendMoneyGroupInit;)Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "", "p0", "Landroid/content/Context;", "p1", "Lid/dana/sendmoney/ui/groupsend/summary/model/PayeeUserInfoModel;", "p2", "(Ljava/util/List;Ljava/lang/String;Landroid/content/Context;Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendSummaryModelMapperKt {
    public static final List<ParticipantSubmitModel> MyBillsEntityDataFactory(List<? extends RecipientViewModel> list, String str, Context context, List<PayeeUserInfoModel> list2) {
        Object obj;
        String str2 = str;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(list2, "");
        List<? extends RecipientViewModel> list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (RecipientViewModel recipientViewModel : list3) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str3 = ((PayeeUserInfoModel) obj).MyBillsEntityDataFactory;
                NumberUtil numberUtil = NumberUtil.INSTANCE;
                if (Intrinsics.areEqual(str3, NumberUtil.PlaceComponentResult(recipientViewModel.DatabaseTableConfigUtil, "62-"))) {
                    break;
                }
            }
            PayeeUserInfoModel payeeUserInfoModel = (PayeeUserInfoModel) obj;
            Boolean valueOf = payeeUserInfoModel != null ? Boolean.valueOf(payeeUserInfoModel.getPlaceComponentResult()) : null;
            String str4 = payeeUserInfoModel != null ? payeeUserInfoModel.getAuthRequestContext : null;
            String str5 = payeeUserInfoModel != null ? payeeUserInfoModel.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            Intrinsics.checkNotNullParameter(recipientViewModel, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(context, "");
            NumberUtil numberUtil2 = NumberUtil.INSTANCE;
            ParticipantInfoSubmitModel participantInfoSubmitModel = new ParticipantInfoSubmitModel(recipientViewModel.PlaceComponentResult, recipientViewModel.scheduleImpl, NumberUtil.PlaceComponentResult(recipientViewModel.DatabaseTableConfigUtil, "62-"), recipientViewModel.GetContactSyncConfig, recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda2, (Intrinsics.areEqual(recipientViewModel.initRecordTimeStamp, context.getString(R.string.res_0x7f1312c9_securitysettingsactivity_createpinlauncher_2_1)) || Intrinsics.areEqual(recipientViewModel.initRecordTimeStamp, "-")) ? "" : recipientViewModel.initRecordTimeStamp, null, null, null, null, null, null, null, null, null, null, null, null, null, valueOf, str4, str5, 524224, null);
            String str6 = recipientViewModel.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(str6, "");
            arrayList.add(new ParticipantSubmitModel(participantInfoSubmitModel, null, "", str, str6, null, null, 98, null));
            str2 = str;
        }
        return arrayList;
    }

    public static final CurrencyAmountModel MyBillsEntityDataFactory(CurrencyAmount currencyAmount) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        String amount = currencyAmount.getAmount();
        Intrinsics.checkNotNullExpressionValue(amount, "");
        String currency = currencyAmount.getCurrency();
        Intrinsics.checkNotNullExpressionValue(currency, "");
        return new CurrencyAmountModel(amount, currency, false, 4, null);
    }

    public static final ParticipantSubmit getAuthRequestContext(ParticipantSubmitModel participantSubmitModel) {
        ParticipantInfoSubmit participantInfoSubmit;
        String str;
        String str2;
        String str3;
        ArrayList arrayList;
        String str4 = "";
        Intrinsics.checkNotNullParameter(participantSubmitModel, "");
        ParticipantInfoSubmitModel participantInfoSubmitModel = participantSubmitModel.getAuthRequestContext;
        if (participantInfoSubmitModel != null) {
            Intrinsics.checkNotNullParameter(participantInfoSubmitModel, "");
            String str5 = participantInfoSubmitModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            String str6 = participantInfoSubmitModel.BuiltInFictitiousFunctionClassFactory;
            String str7 = participantInfoSubmitModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String str8 = participantInfoSubmitModel.PrepareContext;
            String str9 = participantInfoSubmitModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
            String str10 = participantInfoSubmitModel.KClassImpl$Data$declaredNonStaticMembers$2;
            String str11 = participantInfoSubmitModel.initRecordTimeStamp;
            String str12 = participantInfoSubmitModel.PlaceComponentResult;
            String str13 = participantInfoSubmitModel.getAuthRequestContext;
            String str14 = participantInfoSubmitModel.getErrorConfigVersion;
            String str15 = participantInfoSubmitModel.moveToNextValue;
            String str16 = participantInfoSubmitModel.scheduleImpl;
            List<MilestoneModel> list = participantInfoSubmitModel.isLayoutRequested;
            if (list != null) {
                List<MilestoneModel> list2 = list;
                str = str16;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    MilestoneModel milestoneModel = (MilestoneModel) it.next();
                    Intrinsics.checkNotNullParameter(milestoneModel, str4);
                    arrayList2.add(new Milestone(milestoneModel.BuiltInFictitiousFunctionClassFactory, milestoneModel.KClassImpl$Data$declaredNonStaticMembers$2, milestoneModel.getAuthRequestContext, milestoneModel.MyBillsEntityDataFactory));
                    it = it;
                    str4 = str4;
                    str15 = str15;
                    str14 = str14;
                }
                str2 = str14;
                str3 = str15;
                arrayList = arrayList2;
            } else {
                str = str16;
                str2 = str14;
                str3 = str15;
                arrayList = null;
            }
            String str17 = str2;
            String str18 = str3;
            participantInfoSubmit = new ParticipantInfoSubmit(str5, str6, str7, str8, str9, str10, str11, str12, str13, str17, str18, str, arrayList, participantInfoSubmitModel.newProxyInstance, participantInfoSubmitModel.NetworkUserEntityData$$ExternalSyntheticLambda7, participantInfoSubmitModel.NetworkUserEntityData$$ExternalSyntheticLambda1, participantInfoSubmitModel.lookAheadTest, participantInfoSubmitModel.NetworkUserEntityData$$ExternalSyntheticLambda0, participantInfoSubmitModel.NetworkUserEntityData$$ExternalSyntheticLambda4, participantInfoSubmitModel.MyBillsEntityDataFactory, participantInfoSubmitModel.GetContactSyncConfig, participantInfoSubmitModel.DatabaseTableConfigUtil);
        } else {
            participantInfoSubmit = null;
        }
        return new ParticipantSubmit(participantInfoSubmit, participantSubmitModel.PlaceComponentResult, participantSubmitModel.scheduleImpl, participantSubmitModel.NetworkUserEntityData$$ExternalSyntheticLambda0, participantSubmitModel.KClassImpl$Data$declaredNonStaticMembers$2, participantSubmitModel.BuiltInFictitiousFunctionClassFactory);
    }

    public static final SendMoneyGroupConfirmModel MyBillsEntityDataFactory(SendMoneyGroupConfirm sendMoneyGroupConfirm) {
        Intrinsics.checkNotNullParameter(sendMoneyGroupConfirm, "");
        return new SendMoneyGroupConfirmModel(sendMoneyGroupConfirm.scheduleImpl, sendMoneyGroupConfirm.PlaceComponentResult, sendMoneyGroupConfirm.NetworkUserEntityData$$ExternalSyntheticLambda0, sendMoneyGroupConfirm.KClassImpl$Data$declaredNonStaticMembers$2, sendMoneyGroupConfirm.moveToNextValue, sendMoneyGroupConfirm.getErrorConfigVersion, MyBillsEntityDataFactory(sendMoneyGroupConfirm.MyBillsEntityDataFactory), sendMoneyGroupConfirm.BuiltInFictitiousFunctionClassFactory, sendMoneyGroupConfirm.getAuthRequestContext);
    }

    public static final SendMoneyGroupInitModel BuiltInFictitiousFunctionClassFactory(SendMoneyGroupInit sendMoneyGroupInit) {
        Intrinsics.checkNotNullParameter(sendMoneyGroupInit, "");
        List<PayeeUserInfo> list = sendMoneyGroupInit.MyBillsEntityDataFactory;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PayeeUserInfo payeeUserInfo : list) {
            Intrinsics.checkNotNullParameter(payeeUserInfo, "");
            arrayList.add(new PayeeUserInfoModel(payeeUserInfo.scheduleImpl, payeeUserInfo.moveToNextValue, payeeUserInfo.PlaceComponentResult, payeeUserInfo.KClassImpl$Data$declaredNonStaticMembers$2, payeeUserInfo.BuiltInFictitiousFunctionClassFactory, payeeUserInfo.lookAheadTest, payeeUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda0, payeeUserInfo.getMyBillsEntityDataFactory(), payeeUserInfo.getAuthRequestContext));
        }
        return new SendMoneyGroupInitModel(arrayList, sendMoneyGroupInit.getKClassImpl$Data$declaredNonStaticMembers$2(), sendMoneyGroupInit.PlaceComponentResult, sendMoneyGroupInit.BuiltInFictitiousFunctionClassFactory, sendMoneyGroupInit.getAuthRequestContext);
    }
}
