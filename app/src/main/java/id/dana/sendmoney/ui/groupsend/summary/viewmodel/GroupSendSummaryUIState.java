package id.dana.sendmoney.ui.groupsend.summary.viewmodel;

import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.BizGroupDetailResultModel;
import id.dana.sendmoney.ui.groupsend.summary.model.SendMoneyGroupConfirmModel;
import id.dana.sendmoney.ui.groupsend.summary.model.SendMoneyGroupInitModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "", "<init>", "()V", "DanaLogoLoading", "Error", "None", "OnGetSendMoneyGroupInit", "OnSuccessConfirmSendMoneyGroup", "OnSuccessGetAvatars", "OnSuccessGetEditMemberSwitch", "OnSuccessGetGroupDetail", "OnSuccessGetGroupFavoriteValue", "ShimmerLoading", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$None;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$ShimmerLoading;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$DanaLogoLoading;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$Error;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessGetAvatars;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessConfirmSendMoneyGroup;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnGetSendMoneyGroupInit;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessGetEditMemberSwitch;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessGetGroupDetail;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessGetGroupFavoriteValue;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GroupSendSummaryUIState {
    public /* synthetic */ GroupSendSummaryUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GroupSendSummaryUIState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$None;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends GroupSendSummaryUIState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$ShimmerLoading;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "getAuthRequestContext", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShimmerLoading extends GroupSendSummaryUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        public ShimmerLoading(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$DanaLogoLoading;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DanaLogoLoading extends GroupSendSummaryUIState {
        private final boolean PlaceComponentResult;

        public DanaLogoLoading(boolean z) {
            super(null);
            this.PlaceComponentResult = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0007\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$Error;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "", "MyBillsEntityDataFactory", "I", "", "Ljava/lang/Throwable;", "p0", "p1", "p2", "<init>", "(ILjava/lang/Throwable;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends GroupSendSummaryUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final Throwable MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Error(int i, Throwable th, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.MyBillsEntityDataFactory = th;
            this.PlaceComponentResult = str;
        }

        public /* synthetic */ Error(int i, Throwable th, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.SchedulerPoolFactory : i, th, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessGetAvatars;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetAvatars extends GroupSendSummaryUIState {
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public OnSuccessGetAvatars(int i) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessConfirmSendMoneyGroup;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupConfirmModel;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupConfirmModel;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupConfirmModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessConfirmSendMoneyGroup extends GroupSendSummaryUIState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final SendMoneyGroupConfirmModel BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessConfirmSendMoneyGroup(SendMoneyGroupConfirmModel sendMoneyGroupConfirmModel) {
            super(null);
            Intrinsics.checkNotNullParameter(sendMoneyGroupConfirmModel, "");
            this.BuiltInFictitiousFunctionClassFactory = sendMoneyGroupConfirmModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnGetSendMoneyGroupInit;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "p0", "<init>", "(Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnGetSendMoneyGroupInit extends GroupSendSummaryUIState {
        public final SendMoneyGroupInitModel PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetSendMoneyGroupInit(SendMoneyGroupInitModel sendMoneyGroupInitModel) {
            super(null);
            Intrinsics.checkNotNullParameter(sendMoneyGroupInitModel, "");
            this.PlaceComponentResult = sendMoneyGroupInitModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessGetEditMemberSwitch;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "PlaceComponentResult", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetEditMemberSwitch extends GroupSendSummaryUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        public OnSuccessGetEditMemberSwitch(boolean z) {
            super(null);
            this.PlaceComponentResult = z;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessGetGroupDetail;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetGroupDetail extends GroupSendSummaryUIState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final BizGroupDetailResultModel PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetGroupDetail(BizGroupDetailResultModel bizGroupDetailResultModel) {
            super(null);
            Intrinsics.checkNotNullParameter(bizGroupDetailResultModel, "");
            this.PlaceComponentResult = bizGroupDetailResultModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState$OnSuccessGetGroupFavoriteValue;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "", "getAuthRequestContext", "Z", "MyBillsEntityDataFactory", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetGroupFavoriteValue extends GroupSendSummaryUIState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean MyBillsEntityDataFactory;

        public OnSuccessGetGroupFavoriteValue(boolean z) {
            super(null);
            this.MyBillsEntityDataFactory = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }
    }
}
