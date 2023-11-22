package id.dana.sendmoney.ui.groupsend.summary.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState;", "", "<init>", "()V", "DanaLogoLoading", "Error", "None", "OnFileSizeLimitExceeded", "OnUploadSuccess", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$None;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$OnUploadSuccess;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$OnFileSizeLimitExceeded;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$Error;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$DanaLogoLoading;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GroupSendImagePickerUIState {
    public /* synthetic */ GroupSendImagePickerUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GroupSendImagePickerUIState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$None;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends GroupSendImagePickerUIState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$OnUploadSuccess;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnUploadSuccess extends GroupSendImagePickerUIState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnUploadSuccess(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$OnFileSizeLimitExceeded;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnFileSizeLimitExceeded extends GroupSendImagePickerUIState {
        public static final OnFileSizeLimitExceeded INSTANCE = new OnFileSizeLimitExceeded();

        private OnFileSizeLimitExceeded() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$Error;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "Ljava/lang/Throwable;", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends GroupSendImagePickerUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final Throwable BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String str, Throwable th, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = th;
            this.getAuthRequestContext = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState$DanaLogoLoading;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState;", "", "getAuthRequestContext", "Z", "MyBillsEntityDataFactory", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DanaLogoLoading extends GroupSendImagePickerUIState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean MyBillsEntityDataFactory;

        public DanaLogoLoading(boolean z) {
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
