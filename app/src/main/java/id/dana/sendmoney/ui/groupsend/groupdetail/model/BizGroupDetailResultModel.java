package id.dana.sendmoney.ui.groupsend.groupdetail.model;

import android.content.Context;
import id.dana.sendmoney.R;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupModel;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0012\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0002\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bR\u0011\u0010\u0014\u001a\u00020\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "", "hashCode", "()I", "Landroid/content/Context;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "PlaceComponentResult", "(Landroid/content/Context;)Ljava/util/List;", "toString", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupModel;", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupModel;", "MyBillsEntityDataFactory", "", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/ParticipantDetailModel;", "getAuthRequestContext", "Ljava/util/List;", "p1", "<init>", "(Lid/dana/sendmoney/ui/groupsend/landing/model/GroupModel;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupDetailResultModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final GroupModel MyBillsEntityDataFactory;
    public final List<ParticipantDetailModel> getAuthRequestContext;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BizGroupDetailResultModel) {
            BizGroupDetailResultModel bizGroupDetailResultModel = (BizGroupDetailResultModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, bizGroupDetailResultModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, bizGroupDetailResultModel.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        return (this.MyBillsEntityDataFactory.hashCode() * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupDetailResultModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    public BizGroupDetailResultModel(GroupModel groupModel, List<ParticipantDetailModel> list) {
        Intrinsics.checkNotNullParameter(groupModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.MyBillsEntityDataFactory = groupModel;
        this.getAuthRequestContext = list;
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        String str = this.getAuthRequestContext.get(0).KClassImpl$Data$declaredNonStaticMembers$2;
        return (Intrinsics.areEqual(str, "BALANCE") || !Intrinsics.areEqual(str, "BANK_TRANSFER")) ? GroupSendRecipientType.CONTACT : GroupSendRecipientType.BANK;
    }

    public final List<RecipientViewModel> PlaceComponentResult(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<ParticipantDetailModel> list = this.getAuthRequestContext;
        ArrayList arrayList = new ArrayList();
        for (ParticipantDetailModel participantDetailModel : list) {
            String str = participantDetailModel.getAuthRequestContext;
            String str2 = participantDetailModel.MyBillsEntityDataFactory;
            ParticipantInfoDetailModel participantInfoDetailModel = participantDetailModel.BuiltInFictitiousFunctionClassFactory;
            RecipientViewModel recipientViewModel = new RecipientViewModel(3);
            recipientViewModel.scheduleImpl = participantInfoDetailModel.BuiltInFictitiousFunctionClassFactory;
            String str3 = participantInfoDetailModel.MyBillsEntityDataFactory;
            if (str3.length() == 0) {
                str3 = p0.getString(R.string.res_0x7f1312c9_securitysettingsactivity_createpinlauncher_2_1);
                Intrinsics.checkNotNullExpressionValue(str3, "");
            }
            recipientViewModel.initRecordTimeStamp = str3;
            recipientViewModel.DatabaseTableConfigUtil = participantInfoDetailModel.initRecordTimeStamp;
            recipientViewModel.moveToNextValue = Intrinsics.areEqual(str, "USER_ID");
            recipientViewModel.getAuthRequestContext = str2;
            arrayList.add(recipientViewModel);
        }
        return arrayList;
    }
}
