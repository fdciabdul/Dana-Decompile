package id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel;

import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.BizGroupDetailResultModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "<init>", "()V", "DanaLogoLoading", "Error", "None", "OnErrorUpdateGroupFavoriteState", "OnErrorWithShowToast", "OnSuccessDeleteGroup", "OnSuccessGetGroupDetail", "OnSuccessGetGroupFavoriteValue", "OnSuccessGetLeastTransactionFavoriteAccount", "OnSuccessGetMaxFavoriteAccount", "OnSuccessGetTotalFavoriteAccount", "OnSuccessModifyGroupImage", "OnSuccessModifyGroupName", "OnSuccessUpdateGroupFavoriteState", "ShimmerLoading", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$None;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$DanaLogoLoading;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$Error;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnErrorWithShowToast;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetGroupDetail;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessDeleteGroup;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessModifyGroupName;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessModifyGroupImage;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetGroupFavoriteValue;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetMaxFavoriteAccount;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetTotalFavoriteAccount;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessUpdateGroupFavoriteState;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnErrorUpdateGroupFavoriteState;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GroupDetailUiState {
    public /* synthetic */ GroupDetailUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GroupDetailUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$None;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends GroupDetailUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "MyBillsEntityDataFactory", "Z", "PlaceComponentResult", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShimmerLoading extends GroupDetailUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public ShimmerLoading(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$DanaLogoLoading;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DanaLogoLoading extends GroupDetailUiState {
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public DanaLogoLoading(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$Error;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "", "getAuthRequestContext", "Ljava/lang/Throwable;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends GroupDetailUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Throwable MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable th, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = th;
            this.PlaceComponentResult = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnErrorWithShowToast;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "", "MyBillsEntityDataFactory", "Ljava/lang/Throwable;", "p0", "p1", "p2", "p3", "<init>", "(ILjava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorWithShowToast extends GroupDetailUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int getAuthRequestContext;
        public final Throwable MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private OnErrorWithShowToast(int i, Throwable th, String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.getAuthRequestContext = i;
            this.MyBillsEntityDataFactory = th;
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }

        public /* synthetic */ OnErrorWithShowToast(int i, Throwable th, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.res_0x7f13171b_getwalletv3recommendationconfig_lambda_193 : i, th, str, str2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetGroupDetail;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "getAuthRequestContext", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetGroupDetail extends GroupDetailUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final BizGroupDetailResultModel MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetGroupDetail(BizGroupDetailResultModel bizGroupDetailResultModel) {
            super(null);
            Intrinsics.checkNotNullParameter(bizGroupDetailResultModel, "");
            this.MyBillsEntityDataFactory = bizGroupDetailResultModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessDeleteGroup;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "BuiltInFictitiousFunctionClassFactory", "I", "MyBillsEntityDataFactory", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessDeleteGroup extends GroupDetailUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int MyBillsEntityDataFactory;

        public OnSuccessDeleteGroup() {
            this(0, 1, null);
        }

        private OnSuccessDeleteGroup(int i) {
            super(null);
            this.MyBillsEntityDataFactory = i;
        }

        public /* synthetic */ OnSuccessDeleteGroup(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.delete_group_success_msg : i);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessModifyGroupName;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "", "getAuthRequestContext", "I", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessModifyGroupName extends GroupDetailUiState {
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final int MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private OnSuccessModifyGroupName(int i, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = i;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        public /* synthetic */ OnSuccessModifyGroupName(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.modify_group_name_success_message : i, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessModifyGroupImage;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "I", "p0", "p1", "<init>", "(ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessModifyGroupImage extends GroupDetailUiState {
        public final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private OnSuccessModifyGroupImage(int i, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.MyBillsEntityDataFactory = str;
        }

        public /* synthetic */ OnSuccessModifyGroupImage(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.modify_group_photo_success_message : i, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetGroupFavoriteValue;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "getAuthRequestContext", "()Z", "PlaceComponentResult", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetGroupFavoriteValue extends GroupDetailUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        public OnSuccessGetGroupFavoriteValue(boolean z) {
            super(null);
            this.PlaceComponentResult = z;
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetMaxFavoriteAccount;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "getAuthRequestContext", "I", "PlaceComponentResult", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetMaxFavoriteAccount extends GroupDetailUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        public OnSuccessGetMaxFavoriteAccount(int i) {
            super(null);
            this.PlaceComponentResult = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetTotalFavoriteAccount;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "MyBillsEntityDataFactory", "I", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetTotalFavoriteAccount extends GroupDetailUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;

        public OnSuccessGetTotalFavoriteAccount(int i) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetLeastTransactionFavoriteAccount;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetLeastTransactionFavoriteAccount extends GroupDetailUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final RecentRecipient MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetLeastTransactionFavoriteAccount(RecentRecipient recentRecipient) {
            super(null);
            Intrinsics.checkNotNullParameter(recentRecipient, "");
            this.MyBillsEntityDataFactory = recentRecipient;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0011\u0010\b\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessUpdateGroupFavoriteState;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/lang/String;", "p0", "p1", "p2", "<init>", "(ZZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessUpdateGroupFavoriteState extends GroupDetailUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessUpdateGroupFavoriteState(boolean z, boolean z2, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.getAuthRequestContext = z2;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnErrorUpdateGroupFavoriteState;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnErrorUpdateGroupFavoriteState extends GroupDetailUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public OnErrorUpdateGroupFavoriteState() {
            this(0, 1, null);
        }

        private OnErrorUpdateGroupFavoriteState(int i) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        public /* synthetic */ OnErrorUpdateGroupFavoriteState(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.error_add_group_to_favorite : i);
        }
    }
}
