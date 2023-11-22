package com.anggrayudi.storage.callback;

import androidx.documentfile.provider.DocumentFile;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.file.CreateMode;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0007\u001a\u001b\u001c\u001d\u001e\u001f B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\r\u0010\u0011J'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback;", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "Lcom/anggrayudi/storage/callback/FolderCallback$Report;", "Lcom/anggrayudi/storage/callback/FolderCallback$Result;", "Landroidx/documentfile/provider/DocumentFile;", "p0", "", "Lcom/anggrayudi/storage/callback/FolderCallback$FileConflict;", "p1", "Lcom/anggrayudi/storage/callback/FolderCallback$FolderContentConflictAction;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/documentfile/provider/DocumentFile;Ljava/util/List;Lcom/anggrayudi/storage/callback/FolderCallback$FolderContentConflictAction;)V", "Lcom/anggrayudi/storage/callback/FolderCallback$ParentFolderConflictAction;", "", "(Landroidx/documentfile/provider/DocumentFile;Lcom/anggrayudi/storage/callback/FolderCallback$ParentFolderConflictAction;)V", "", "Ljava/lang/Thread;", "", "PlaceComponentResult", "(Landroidx/documentfile/provider/DocumentFile;Ljava/lang/Thread;)J", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "ConflictResolution", BehaviorLogger.Key.ERROR_CODE, "FileConflict", "FolderContentConflictAction", "ParentFolderConflictAction", "Report", "Result"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public abstract class FolderCallback extends BaseFileCallback<ErrorCode, Report, Result> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "STORAGE_PERMISSION_DENIED", "CANNOT_CREATE_FILE_IN_TARGET", "SOURCE_FOLDER_NOT_FOUND", "SOURCE_FILE_NOT_FOUND", "INVALID_TARGET_FOLDER", "UNKNOWN_IO_ERROR", "CANCELED", "TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER", "NO_SPACE_LEFT_ON_TARGET_PATH"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public enum ErrorCode {
        STORAGE_PERMISSION_DENIED,
        CANNOT_CREATE_FILE_IN_TARGET,
        SOURCE_FOLDER_NOT_FOUND,
        SOURCE_FILE_NOT_FOUND,
        INVALID_TARGET_FOLDER,
        UNKNOWN_IO_ERROR,
        CANCELED,
        TARGET_FOLDER_CANNOT_HAVE_SAME_PATH_WITH_SOURCE_FOLDER,
        NO_SPACE_LEFT_ON_TARGET_PATH
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0018\u00002\u00020\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$FileConflict;", ""}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class FileConflict {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FolderCallback() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.callback.FolderCallback.<init>():void");
    }

    public static long PlaceComponentResult(DocumentFile documentFile, Thread thread) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(thread, "");
        return 0L;
    }

    public /* synthetic */ FolderCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private FolderCallback(CoroutineScope coroutineScope) {
        super(coroutineScope);
        Intrinsics.checkNotNullParameter(coroutineScope, "");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(DocumentFile documentFile, ParentFolderConflictAction parentFolderConflictAction) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(parentFolderConflictAction, "");
        ConflictResolution conflictResolution = ConflictResolution.CREATE_NEW;
        Intrinsics.checkNotNullParameter(conflictResolution, "");
        CancellableContinuation<ConflictResolution> cancellableContinuation = parentFolderConflictAction.BuiltInFictitiousFunctionClassFactory;
        Result.Companion companion = kotlin.Result.INSTANCE;
        cancellableContinuation.resumeWith(kotlin.Result.m3179constructorimpl(conflictResolution));
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(DocumentFile p0, List<FileConflict> p1, FolderContentConflictAction p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p1, "");
        CancellableContinuation<List<FileConflict>> cancellableContinuation = p2.KClassImpl$Data$declaredNonStaticMembers$2;
        Result.Companion companion = kotlin.Result.INSTANCE;
        cancellableContinuation.resumeWith(kotlin.Result.m3179constructorimpl(p1));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$ParentFolderConflictAction;", "", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "getAuthRequestContext", "Lkotlinx/coroutines/CancellableContinuation;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class ParentFolderConflictAction {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final CancellableContinuation<ConflictResolution> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Multi-variable type inference failed */
        public ParentFolderConflictAction(CancellableContinuation<? super ConflictResolution> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(cancellableContinuation, "");
            this.BuiltInFictitiousFunctionClassFactory = cancellableContinuation;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\t\u0010\nR \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$FolderContentConflictAction;", "", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lcom/anggrayudi/storage/callback/FolderCallback$FileConflict;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CancellableContinuation;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class FolderContentConflictAction {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final CancellableContinuation<List<FileConflict>> KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: Multi-variable type inference failed */
        public FolderContentConflictAction(CancellableContinuation<? super List<FileConflict>> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(cancellableContinuation, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cancellableContinuation;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "", "Lcom/anggrayudi/storage/file/CreateMode;", "toCreateMode", "()Lcom/anggrayudi/storage/file/CreateMode;", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "toFileConflictResolution", "()Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "<init>", "(Ljava/lang/String;I)V", "REPLACE", "MERGE", "CREATE_NEW", "SKIP"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public enum ConflictResolution {
        REPLACE,
        MERGE,
        CREATE_NEW,
        SKIP;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes7.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

            static {
                int[] iArr = new int[ConflictResolution.values().length];
                iArr[ConflictResolution.REPLACE.ordinal()] = 1;
                iArr[ConflictResolution.MERGE.ordinal()] = 2;
                iArr[ConflictResolution.CREATE_NEW.ordinal()] = 3;
                KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            }
        }

        public final CreateMode toCreateMode() {
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return CreateMode.REUSE;
                }
                return CreateMode.CREATE_NEW;
            }
            return CreateMode.REPLACE;
        }

        public final FileCallback.ConflictResolution toFileConflictResolution() {
            int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[ordinal()];
            if (i != 1) {
                if (i == 3) {
                    return FileCallback.ConflictResolution.CREATE_NEW;
                }
                return FileCallback.ConflictResolution.SKIP;
            }
            return FileCallback.ConflictResolution.REPLACE;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0007"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$Report;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "J", "PlaceComponentResult", "", "I", "getAuthRequestContext", "", LogConstants.RESULT_FALSE, "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "p0", "p1", "p2", "p3", "<init>", "(FJII)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Report {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final long PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final float BuiltInFictitiousFunctionClassFactory;

        public Report(float f, long j, int i, int i2) {
            this.BuiltInFictitiousFunctionClassFactory = f;
            this.PlaceComponentResult = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.getAuthRequestContext = i2;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\n\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$Result;", "", "Landroidx/documentfile/provider/DocumentFile;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/documentfile/provider/DocumentFile;", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "Z", "", "PlaceComponentResult", "I", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "<init>", "(Landroidx/documentfile/provider/DocumentFile;IIZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Result {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final DocumentFile getAuthRequestContext;
        public final boolean MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public Result(DocumentFile documentFile, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(documentFile, "");
            this.getAuthRequestContext = documentFile;
            this.PlaceComponentResult = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.MyBillsEntityDataFactory = z;
        }
    }
}
