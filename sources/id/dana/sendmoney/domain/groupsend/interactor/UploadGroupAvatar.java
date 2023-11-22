package id.dana.sendmoney.domain.groupsend.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.uploadfiles.UploadFilesEntity;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000b\f\rB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/interactor/UploadGroupAvatar;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/sendmoney/domain/groupsend/interactor/UploadGroupAvatar$Param;", "", "Lid/dana/domain/uploadfiles/UploadFilesRepository;", "MyBillsEntityDataFactory", "Lid/dana/domain/uploadfiles/UploadFilesRepository;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/domain/uploadfiles/UploadFilesRepository;)V", "Companion", "MaxFileSizeExceededException", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadGroupAvatar extends BaseFlowUseCase<Param, String> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final UploadFilesRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<String> buildUseCase(Param param) {
        Param param2 = param;
        Intrinsics.checkNotNullParameter(param2, "");
        if (param2.KClassImpl$Data$declaredNonStaticMembers$2 > 5242880) {
            return FlowKt.flow(new UploadGroupAvatar$buildUseCase$1(null));
        }
        return FlowKt.flow(new UploadGroupAvatar$buildUseCase$2(this, new UploadFilesEntity("", "image/jpeg", param2.PlaceComponentResult, "", "", param2.getGetAuthRequestContext(), false, 64, null), null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UploadGroupAvatar(id.dana.domain.uploadfiles.UploadFilesRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.PlaceComponentResult = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.domain.groupsend.interactor.UploadGroupAvatar.<init>(id.dana.domain.uploadfiles.UploadFilesRepository):void");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0011\u0010\f\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/interactor/UploadGroupAvatar$Param;", "", "", "BuiltInFictitiousFunctionClassFactory", "[B", "PlaceComponentResult", "()[B", "getAuthRequestContext", "", "Ljava/lang/String;", "", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "([BLjava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Param {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final byte[] getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String PlaceComponentResult;

        public Param(byte[] bArr, String str, int i) {
            Intrinsics.checkNotNullParameter(bArr, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = bArr;
            this.PlaceComponentResult = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final byte[] getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/interactor/UploadGroupAvatar$MaxFileSizeExceededException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MaxFileSizeExceededException extends Exception {
        public MaxFileSizeExceededException() {
            super("Max file size is 5 MB");
        }
    }
}
