package id.dana.sendmoney.ui.groupsend.recipient.viewmodel;

import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.summary.model.SendMoneyGroupInitModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\r\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\r\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "<init>", "()V", "DanaLoadingDialog", "Error", "Loading", "None", "OnContactSyncFeatureEnabled", "OnErrorModifyGroup", "OnGetSendMoneyGroupInit", "OnSuccessGetDanaUserContact", "OnSuccessGetIsNeedToShowBottomSheet", "OnSuccessGetMaxGroupParticipant", "OnSuccessGetPhoneNumber", "OnSuccessGetRecipientSyncContacts", "OnSuccessModifyGroup", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$None;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$Loading;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$DanaLoadingDialog;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$Error;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetMaxGroupParticipant;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetRecipientSyncContacts;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetDanaUserContact;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnContactSyncFeatureEnabled;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetIsNeedToShowBottomSheet;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetPhoneNumber;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessModifyGroup;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnErrorModifyGroup;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnGetSendMoneyGroupInit;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GroupRecipientUiState {
    public /* synthetic */ GroupRecipientUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GroupRecipientUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$None;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends GroupRecipientUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$Loading;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "getAuthRequestContext", "Z", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Loading extends GroupRecipientUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        public Loading(boolean z) {
            super(null);
            this.PlaceComponentResult = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$DanaLoadingDialog;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DanaLoadingDialog extends GroupRecipientUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        public DanaLoadingDialog(boolean z) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0007\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$Error;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "Ljava/lang/Throwable;", "p0", "p1", "p2", "<init>", "(ILjava/lang/Throwable;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends GroupRecipientUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final Throwable KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Error(int i, Throwable th, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
            this.getAuthRequestContext = str;
        }

        public /* synthetic */ Error(int i, Throwable th, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.SchedulerPoolFactory : i, th, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetMaxGroupParticipant;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "MyBillsEntityDataFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetMaxGroupParticipant extends GroupRecipientUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public OnSuccessGetMaxGroupParticipant(int i) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetRecipientSyncContacts;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetRecipientSyncContacts extends GroupRecipientUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final List<RecipientViewModel> KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetRecipientSyncContacts(List<RecipientViewModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetDanaUserContact;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "MyBillsEntityDataFactory", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetDanaUserContact extends GroupRecipientUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final List<String> MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetDanaUserContact(List<String> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.MyBillsEntityDataFactory = list;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnContactSyncFeatureEnabled;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnContactSyncFeatureEnabled extends GroupRecipientUiState {
        public static final OnContactSyncFeatureEnabled INSTANCE = new OnContactSyncFeatureEnabled();

        private OnContactSyncFeatureEnabled() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetIsNeedToShowBottomSheet;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "getAuthRequestContext", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetIsNeedToShowBottomSheet extends GroupRecipientUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        public OnSuccessGetIsNeedToShowBottomSheet(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessGetPhoneNumber;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetPhoneNumber extends GroupRecipientUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetPhoneNumber(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnSuccessModifyGroup;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessModifyGroup extends GroupRecipientUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessModifyGroup(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnErrorModifyGroup;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "", "PlaceComponentResult", "Ljava/lang/String;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Throwable;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorModifyGroup extends GroupRecipientUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final Throwable MyBillsEntityDataFactory;
        public final String PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorModifyGroup(Throwable th, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = th;
            this.PlaceComponentResult = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState$OnGetSendMoneyGroupInit;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/sendmoney/ui/groupsend/summary/model/SendMoneyGroupInitModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnGetSendMoneyGroupInit extends GroupRecipientUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final SendMoneyGroupInitModel BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetSendMoneyGroupInit(SendMoneyGroupInitModel sendMoneyGroupInitModel) {
            super(null);
            Intrinsics.checkNotNullParameter(sendMoneyGroupInitModel, "");
            this.BuiltInFictitiousFunctionClassFactory = sendMoneyGroupInitModel;
        }
    }
}
