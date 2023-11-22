package com.anggrayudi.storage.callback;

import androidx.documentfile.provider.DocumentFile;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002&'B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0017J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u000fH\u0017J\b\u0010\u0018\u001a\u00020\u000fH\u0017J\u001c\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0017J\u001e\u0010!\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010$\u001a\u00020%H\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006("}, d2 = {"Lcom/anggrayudi/storage/callback/ZipCompressionCallback;", "T", "", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "getUiScope", "()Lkotlinx/coroutines/CoroutineScope;", "setUiScope", "onCheckFreeSpace", "", "freeSpace", "", "fileSize", "onCompleted", "", "zipFile", "Landroidx/documentfile/provider/DocumentFile;", "bytesCompressed", "totalFilesCompressed", "", "compressionRate", "", "onCountingFiles", "onDeleteEntryFiles", "onFailed", "errorCode", "Lcom/anggrayudi/storage/callback/ZipCompressionCallback$ErrorCode;", "message", "", "onReport", "report", "Lcom/anggrayudi/storage/callback/ZipCompressionCallback$Report;", "onStart", "files", "", "workerThread", "Ljava/lang/Thread;", BehaviorLogger.Key.ERROR_CODE, "Report", "storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public abstract class ZipCompressionCallback<T> {
    public CoroutineScope getAuthRequestContext;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n"}, d2 = {"Lcom/anggrayudi/storage/callback/ZipCompressionCallback$ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "STORAGE_PERMISSION_DENIED", "CANNOT_CREATE_FILE_IN_TARGET", "MISSING_ENTRY_FILE", "DUPLICATE_ENTRY_FILE", "UNKNOWN_IO_ERROR", "CANCELED", "NO_SPACE_LEFT_ON_TARGET_PATH"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public enum ErrorCode {
        STORAGE_PERMISSION_DENIED,
        CANNOT_CREATE_FILE_IN_TARGET,
        MISSING_ENTRY_FILE,
        DUPLICATE_ENTRY_FILE,
        UNKNOWN_IO_ERROR,
        CANCELED,
        NO_SPACE_LEFT_ON_TARGET_PATH
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ZipCompressionCallback() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.callback.ZipCompressionCallback.<init>():void");
    }

    public static long BuiltInFictitiousFunctionClassFactory(List<? extends T> list, Thread thread) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(thread, "");
        return 0L;
    }

    public static void MyBillsEntityDataFactory(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "");
    }

    public static void MyBillsEntityDataFactory(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "");
    }

    private ZipCompressionCallback(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        this.getAuthRequestContext = coroutineScope;
    }

    public /* synthetic */ ZipCompressionCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Lcom/anggrayudi/storage/callback/ZipCompressionCallback$Report;", "", "", "PlaceComponentResult", "J", "KClassImpl$Data$declaredNonStaticMembers$2", "", "MyBillsEntityDataFactory", "I", "", "getAuthRequestContext", LogConstants.RESULT_FALSE, "p0", "p1", "p2", "p3", "<init>", "(FJII)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Report {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final long KClassImpl$Data$declaredNonStaticMembers$2;
        public final float getAuthRequestContext;

        public Report(float f, long j, int i, int i2) {
            this.getAuthRequestContext = f;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = i2;
        }
    }
}
