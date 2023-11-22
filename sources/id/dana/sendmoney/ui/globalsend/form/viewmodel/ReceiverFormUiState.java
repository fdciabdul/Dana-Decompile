package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import id.dana.sendmoney.ui.globalsend.form.model.GlobalTransferInitModel;
import id.dana.sendmoney.ui.globalsend.form.model.TransferValidateResultModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "<init>", "()V", "DanaLoading", "Error", "None", "OnErrorCodeInit", "OnErrorCodeValidate", "OnErrorFetchInit", "OnFormValid", "OnSuccessGetProvinceAndCityList", "OnSuccessInitGlobalTransfer", "OnSuccessValidate", "OnValidationIsFormNotFilled", "ShimmerLoading", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$None;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnValidationIsFormNotFilled;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnFormValid;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$DanaLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnErrorCodeInit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnErrorCodeValidate;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnSuccessValidate;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnErrorFetchInit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnSuccessInitGlobalTransfer;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnSuccessGetProvinceAndCityList;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ReceiverFormUiState {
    public /* synthetic */ ReceiverFormUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ReceiverFormUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$None;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends ReceiverFormUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnValidationIsFormNotFilled;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "MyBillsEntityDataFactory", "Z", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnValidationIsFormNotFilled extends ReceiverFormUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public OnValidationIsFormNotFilled(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnFormValid;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "MyBillsEntityDataFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnFormValid extends ReceiverFormUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean MyBillsEntityDataFactory;

        public OnFormValid(boolean z) {
            super(null);
            this.MyBillsEntityDataFactory = z;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$DanaLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "PlaceComponentResult", "()Z", "getAuthRequestContext", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DanaLoading extends ReceiverFormUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        public DanaLoading(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends ReceiverFormUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        public Error(String str) {
            super(null);
            this.PlaceComponentResult = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnErrorCodeInit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorCodeInit extends ReceiverFormUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorCodeInit(String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.getAuthRequestContext = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnErrorCodeValidate;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorCodeValidate extends ReceiverFormUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorCodeValidate(String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.MyBillsEntityDataFactory = str;
            this.getAuthRequestContext = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnSuccessValidate;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Lid/dana/sendmoney/ui/globalsend/form/model/TransferValidateResultModel;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/ui/globalsend/form/model/TransferValidateResultModel;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/sendmoney/ui/globalsend/form/model/TransferValidateResultModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessValidate extends ReceiverFormUiState {
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final TransferValidateResultModel BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessValidate(TransferValidateResultModel transferValidateResultModel, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(transferValidateResultModel, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = transferValidateResultModel;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "getAuthRequestContext", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShimmerLoading extends ReceiverFormUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnErrorFetchInit;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorFetchInit extends ReceiverFormUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        public OnErrorFetchInit(String str) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnSuccessInitGlobalTransfer;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "getAuthRequestContext", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessInitGlobalTransfer extends ReceiverFormUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final GlobalTransferInitModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessInitGlobalTransfer(GlobalTransferInitModel globalTransferInitModel) {
            super(null);
            Intrinsics.checkNotNullParameter(globalTransferInitModel, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = globalTransferInitModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState$OnSuccessGetProvinceAndCityList;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/ProvinceModel;", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetProvinceAndCityList extends ReceiverFormUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final List<ProvinceModel> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetProvinceAndCityList(List<ProvinceModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.BuiltInFictitiousFunctionClassFactory = list;
        }
    }
}
