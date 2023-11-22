package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.globalsend.form.model.GlobalTransferInitModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "", "<init>", "()V", "DanaLoading", "Error", "None", "OnErrorCode", "OnErrorFetchInit", "OnErrorTransferSubmit", "OnSuccessInitGlobalTransfer", "OnSuccessTransferSubmit", "ShimmerLoading", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$None;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$DanaLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnErrorCode;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnErrorFetchInit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnSuccessInitGlobalTransfer;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnSuccessTransferSubmit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnErrorTransferSubmit;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AmountFormUiState {
    public /* synthetic */ AmountFormUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AmountFormUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$None;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends AmountFormUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "()Z", "PlaceComponentResult", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShimmerLoading extends AmountFormUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        public ShimmerLoading(boolean z) {
            super(null);
            this.PlaceComponentResult = z;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$DanaLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "PlaceComponentResult", "()Z", "MyBillsEntityDataFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DanaLoading extends AmountFormUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean MyBillsEntityDataFactory;

        public DanaLoading(boolean z) {
            super(null);
            this.MyBillsEntityDataFactory = z;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "", "getAuthRequestContext", "I", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Error extends AmountFormUiState {
        public final int getAuthRequestContext;

        public Error() {
            this(0, 1, null);
        }

        private Error(int i) {
            super(null);
            this.getAuthRequestContext = i;
        }

        public /* synthetic */ Error(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.SchedulerPoolFactory : i);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnErrorCode;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorCode extends AmountFormUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorCode(String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnErrorFetchInit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorFetchInit extends AmountFormUiState {
        public static final OnErrorFetchInit INSTANCE = new OnErrorFetchInit();

        private OnErrorFetchInit() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnSuccessInitGlobalTransfer;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessInitGlobalTransfer extends AmountFormUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final GlobalTransferInitModel getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessInitGlobalTransfer(GlobalTransferInitModel globalTransferInitModel) {
            super(null);
            Intrinsics.checkNotNullParameter(globalTransferInitModel, "");
            this.getAuthRequestContext = globalTransferInitModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnSuccessTransferSubmit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessTransferSubmit extends AmountFormUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessTransferSubmit(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState$OnErrorTransferSubmit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorTransferSubmit extends AmountFormUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorTransferSubmit(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }
}
