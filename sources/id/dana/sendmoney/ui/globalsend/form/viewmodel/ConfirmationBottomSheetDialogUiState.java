package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.globalsend.form.model.SenderDetailModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState;", "", "<init>", "()V", "Error", "None", "OnErrorGetUserInfo", "OnSuccessGetUserInfo", "OnSuccessSaveSenderDetail", "ShimmerLoading", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$None;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$OnSuccessSaveSenderDetail;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$OnSuccessGetUserInfo;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$OnErrorGetUserInfo;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$ShimmerLoading;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ConfirmationBottomSheetDialogUiState {
    public /* synthetic */ ConfirmationBottomSheetDialogUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConfirmationBottomSheetDialogUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$None;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends ConfirmationBottomSheetDialogUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState;", "", "MyBillsEntityDataFactory", "I", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Error extends ConfirmationBottomSheetDialogUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;

        public Error() {
            this(0, 1, null);
        }

        private Error(int i) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        public /* synthetic */ Error(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.SchedulerPoolFactory : i);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$OnSuccessSaveSenderDetail;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessSaveSenderDetail extends ConfirmationBottomSheetDialogUiState {
        public static final OnSuccessSaveSenderDetail INSTANCE = new OnSuccessSaveSenderDetail();

        private OnSuccessSaveSenderDetail() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$OnSuccessGetUserInfo;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState;", "Lid/dana/sendmoney/ui/globalsend/form/model/SenderDetailModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/globalsend/form/model/SenderDetailModel;", "p0", "<init>", "(Lid/dana/sendmoney/ui/globalsend/form/model/SenderDetailModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetUserInfo extends ConfirmationBottomSheetDialogUiState {
        public final SenderDetailModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetUserInfo(SenderDetailModel senderDetailModel) {
            super(null);
            Intrinsics.checkNotNullParameter(senderDetailModel, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = senderDetailModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$OnErrorGetUserInfo;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState;", "", "getAuthRequestContext", "I", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnErrorGetUserInfo extends ConfirmationBottomSheetDialogUiState {
        public final int getAuthRequestContext;

        public OnErrorGetUserInfo() {
            this(0, 1, null);
        }

        private OnErrorGetUserInfo(int i) {
            super(null);
            this.getAuthRequestContext = i;
        }

        public /* synthetic */ OnErrorGetUserInfo(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.error_message_get_user_info : i);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState;", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class ShimmerLoading extends ConfirmationBottomSheetDialogUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public ShimmerLoading(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }
}
