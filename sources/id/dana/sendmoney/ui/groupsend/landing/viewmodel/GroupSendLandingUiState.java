package id.dana.sendmoney.ui.groupsend.landing.viewmodel;

import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupModel;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupSendScenarioConfigModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "<init>", "()V", "DanaLoadingDialog", "Error", "ErrorToast", "None", "OnSuccessGetGroupSendMaxGroup", "OnSuccessGetGroupSendQuery", "OnSuccessGetGroupSendScenario", "OnSuccessGetIsNeedToShowBottomSheet", "ShimmerLoading", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$None;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$DanaLoadingDialog;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$Error;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$ErrorToast;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$OnSuccessGetGroupSendQuery;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$OnSuccessGetGroupSendScenario;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$OnSuccessGetIsNeedToShowBottomSheet;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$OnSuccessGetGroupSendMaxGroup;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GroupSendLandingUiState {
    public /* synthetic */ GroupSendLandingUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GroupSendLandingUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$None;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends GroupSendLandingUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "MyBillsEntityDataFactory", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShimmerLoading extends GroupSendLandingUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public ShimmerLoading(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$DanaLoadingDialog;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getAuthRequestContext", "()Z", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DanaLoadingDialog extends GroupSendLandingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$Error;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Ljava/lang/Throwable;", "p0", "p1", "p2", "<init>", "(ILjava/lang/Throwable;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends GroupSendLandingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final Throwable MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Error(int i, Throwable th, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.MyBillsEntityDataFactory = th;
            this.getAuthRequestContext = str;
        }

        public /* synthetic */ Error(int i, Throwable th, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.SchedulerPoolFactory : i, th, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$ErrorToast;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "getAuthRequestContext", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ErrorToast extends GroupSendLandingUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public ErrorToast() {
            this(0, 1, null);
        }

        public /* synthetic */ ErrorToast(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.SchedulerPoolFactory : i);
        }

        private ErrorToast(int i) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$OnSuccessGetGroupSendQuery;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupModel;", "getAuthRequestContext", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetGroupSendQuery extends GroupSendLandingUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final List<GroupModel> KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetGroupSendQuery(List<GroupModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$OnSuccessGetGroupSendScenario;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "Lid/dana/sendmoney/ui/groupsend/landing/model/GroupSendScenarioConfigModel;", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetGroupSendScenario extends GroupSendLandingUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final List<GroupSendScenarioConfigModel> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetGroupSendScenario(List<GroupSendScenarioConfigModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.BuiltInFictitiousFunctionClassFactory = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$OnSuccessGetIsNeedToShowBottomSheet;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetIsNeedToShowBottomSheet extends GroupSendLandingUiState {
        private final boolean PlaceComponentResult;

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        public OnSuccessGetIsNeedToShowBottomSheet(boolean z) {
            super(null);
            this.PlaceComponentResult = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState$OnSuccessGetGroupSendMaxGroup;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "", "MyBillsEntityDataFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetGroupSendMaxGroup extends GroupSendLandingUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public OnSuccessGetGroupSendMaxGroup(int i) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }
}
