package com.anggrayudi.storage.callback;

import androidx.documentfile.provider.DocumentFile;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.anggrayudi.storage.file.CreateMode;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0004\u0012\u0013\u0014\u0015B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b\n\u0010\u000e"}, d2 = {"Lcom/anggrayudi/storage/callback/FileCallback;", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "Lcom/anggrayudi/storage/callback/FileCallback$ErrorCode;", "Lcom/anggrayudi/storage/callback/FileCallback$Report;", "", "Landroidx/documentfile/provider/DocumentFile;", "p0", "Lcom/anggrayudi/storage/callback/FileCallback$FileConflictAction;", "p1", "", "MyBillsEntityDataFactory", "(Landroidx/documentfile/provider/DocumentFile;Lcom/anggrayudi/storage/callback/FileCallback$FileConflictAction;)V", "Ljava/lang/Thread;", "", "(Ljava/lang/Object;Ljava/lang/Thread;)J", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "ConflictResolution", BehaviorLogger.Key.ERROR_CODE, "FileConflictAction", "Report"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public abstract class FileCallback extends BaseFileCallback<ErrorCode, Report, Object> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lcom/anggrayudi/storage/callback/FileCallback$ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "STORAGE_PERMISSION_DENIED", "CANNOT_CREATE_FILE_IN_TARGET", "SOURCE_FILE_NOT_FOUND", "TARGET_FILE_NOT_FOUND", "TARGET_FOLDER_NOT_FOUND", "UNKNOWN_IO_ERROR", "CANCELED", "TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER", "NO_SPACE_LEFT_ON_TARGET_PATH"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public enum ErrorCode {
        STORAGE_PERMISSION_DENIED,
        CANNOT_CREATE_FILE_IN_TARGET,
        SOURCE_FILE_NOT_FOUND,
        TARGET_FILE_NOT_FOUND,
        TARGET_FOLDER_NOT_FOUND,
        UNKNOWN_IO_ERROR,
        CANCELED,
        TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER,
        NO_SPACE_LEFT_ON_TARGET_PATH
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FileCallback() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.callback.FileCallback.<init>():void");
    }

    public static long MyBillsEntityDataFactory(Object p0, Thread p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return 0L;
    }

    public /* synthetic */ FileCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private FileCallback(CoroutineScope coroutineScope) {
        super(coroutineScope);
        Intrinsics.checkNotNullParameter(coroutineScope, "");
    }

    public static void MyBillsEntityDataFactory(DocumentFile p0, FileConflictAction p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ConflictResolution conflictResolution = ConflictResolution.CREATE_NEW;
        Intrinsics.checkNotNullParameter(conflictResolution, "");
        CancellableContinuation<ConflictResolution> cancellableContinuation = p1.MyBillsEntityDataFactory;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3179constructorimpl(conflictResolution));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/anggrayudi/storage/callback/FileCallback$FileConflictAction;", "", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/CancellableContinuation;", "p0", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class FileConflictAction {
        final CancellableContinuation<ConflictResolution> MyBillsEntityDataFactory;

        /* JADX WARN: Multi-variable type inference failed */
        public FileConflictAction(CancellableContinuation<? super ConflictResolution> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(cancellableContinuation, "");
            this.MyBillsEntityDataFactory = cancellableContinuation;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t"}, d2 = {"Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "", "Lcom/anggrayudi/storage/file/CreateMode;", "toCreateMode", "()Lcom/anggrayudi/storage/file/CreateMode;", "<init>", "(Ljava/lang/String;I)V", "REPLACE", "CREATE_NEW", "SKIP"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public enum ConflictResolution {
        REPLACE,
        CREATE_NEW,
        SKIP;

        public final CreateMode toCreateMode() {
            return this == REPLACE ? CreateMode.REPLACE : CreateMode.CREATE_NEW;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/anggrayudi/storage/callback/FileCallback$Report;", "", "", "MyBillsEntityDataFactory", "J", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", LogConstants.RESULT_FALSE, "", "getAuthRequestContext", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(FJI)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Report {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final long BuiltInFictitiousFunctionClassFactory;
        public final float PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public Report(float f, long j, int i) {
            this.PlaceComponentResult = f;
            this.BuiltInFictitiousFunctionClassFactory = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }
}
