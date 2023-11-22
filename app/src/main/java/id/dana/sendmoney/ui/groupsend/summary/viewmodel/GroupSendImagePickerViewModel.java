package id.dana.sendmoney.ui.groupsend.summary.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.UploadGroupAvatar;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendImagePickerUIState;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerViewModel;", "Landroidx/lifecycle/ViewModel;", "", "p0", "", "p1", "", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "([BLjava/lang/String;I)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerUIState;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthRequestContext", "Lkotlinx/coroutines/flow/StateFlow;", "Lid/dana/sendmoney/domain/groupsend/interactor/UploadGroupAvatar;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/groupsend/interactor/UploadGroupAvatar;", "PlaceComponentResult", "<init>", "(Lid/dana/sendmoney/domain/groupsend/interactor/UploadGroupAvatar;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendImagePickerViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final UploadGroupAvatar PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MutableStateFlow<GroupSendImagePickerUIState> KClassImpl$Data$declaredNonStaticMembers$2;
    public final StateFlow<GroupSendImagePickerUIState> getAuthRequestContext;

    @Inject
    public GroupSendImagePickerViewModel(UploadGroupAvatar uploadGroupAvatar) {
        Intrinsics.checkNotNullParameter(uploadGroupAvatar, "");
        this.PlaceComponentResult = uploadGroupAvatar;
        MutableStateFlow<GroupSendImagePickerUIState> MutableStateFlow = StateFlowKt.MutableStateFlow(GroupSendImagePickerUIState.None.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MutableStateFlow;
        this.getAuthRequestContext = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(byte[] p0, String p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.PlaceComponentResult.execute(new UploadGroupAvatar.Param(p0, p1, p2), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendImagePickerViewModel$uploadAvatar$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupSendImagePickerViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendImagePickerUIState groupSendImagePickerUIState = (GroupSendImagePickerUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendImagePickerUIState.DanaLogoLoading(true)));
            }
        }, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendImagePickerViewModel$uploadAvatar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(str, "");
                mutableStateFlow = GroupSendImagePickerViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendImagePickerUIState groupSendImagePickerUIState = (GroupSendImagePickerUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendImagePickerUIState.OnUploadSuccess(str)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendImagePickerViewModel$uploadAvatar$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                GroupSendImagePickerUIState error;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GROUP_SEND_EXCEPTION, th.getMessage(), th);
                mutableStateFlow = GroupSendImagePickerViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendImagePickerUIState groupSendImagePickerUIState = (GroupSendImagePickerUIState) value;
                    if (th instanceof UploadGroupAvatar.MaxFileSizeExceededException) {
                        error = GroupSendImagePickerUIState.OnFileSizeLimitExceeded.INSTANCE;
                    } else {
                        error = new GroupSendImagePickerUIState.Error(th.getMessage(), th, GroupSendOperationType.GROUP_UPLOAD_GROUP_AVATAR);
                    }
                } while (!mutableStateFlow.compareAndSet(value, error));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendImagePickerViewModel$uploadAvatar$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupSendImagePickerViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendImagePickerUIState groupSendImagePickerUIState = (GroupSendImagePickerUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendImagePickerUIState.DanaLogoLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }
}
