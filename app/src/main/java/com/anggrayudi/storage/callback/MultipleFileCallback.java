package com.anggrayudi.storage.callback;

import androidx.documentfile.provider.DocumentFile;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.anggrayudi.storage.callback.FolderCallback;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0006\"#$%&'B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0012\u001a\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\t\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001d\u001a\u00020\u001c2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\t\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001e"}, d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback;", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$Report;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$Result;", "Landroidx/documentfile/provider/DocumentFile;", "p0", "", "Lcom/anggrayudi/storage/callback/FolderCallback$FileConflict;", "p1", "Lcom/anggrayudi/storage/callback/FolderCallback$FolderContentConflictAction;", "p2", "", "getAuthRequestContext", "(Landroidx/documentfile/provider/DocumentFile;Ljava/util/List;Lcom/anggrayudi/storage/callback/FolderCallback$FolderContentConflictAction;)V", "", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$InvalidSourceFilesAction;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Map;Lcom/anggrayudi/storage/callback/MultipleFileCallback$InvalidSourceFilesAction;)V", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentFolderConflictAction;", "p3", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/documentfile/provider/DocumentFile;Ljava/util/List;Ljava/util/List;Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentFolderConflictAction;)V", "", "", "Ljava/lang/Thread;", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Ljava/lang/Thread;)J", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", BehaviorLogger.Key.ERROR_CODE, "InvalidSourceFilesAction", "ParentConflict", "ParentFolderConflictAction", "Report", "Result"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public abstract class MultipleFileCallback extends BaseFileCallback<ErrorCode, Report, Result> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n"}, d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "STORAGE_PERMISSION_DENIED", "CANNOT_CREATE_FILE_IN_TARGET", "SOURCE_FILE_NOT_FOUND", "INVALID_TARGET_FOLDER", "UNKNOWN_IO_ERROR", "CANCELED", "NO_SPACE_LEFT_ON_TARGET_PATH"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public enum ErrorCode {
        STORAGE_PERMISSION_DENIED,
        CANNOT_CREATE_FILE_IN_TARGET,
        SOURCE_FILE_NOT_FOUND,
        INVALID_TARGET_FOLDER,
        UNKNOWN_IO_ERROR,
        CANCELED,
        NO_SPACE_LEFT_ON_TARGET_PATH
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0018\u00002\u00020\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", ""}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class ParentConflict {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MultipleFileCallback() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.callback.MultipleFileCallback.<init>():void");
    }

    public static long MyBillsEntityDataFactory(List<? extends DocumentFile> list, Thread thread) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(thread, "");
        return 0L;
    }

    public /* synthetic */ MultipleFileCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private MultipleFileCallback(CoroutineScope coroutineScope) {
        super(coroutineScope);
        Intrinsics.checkNotNullParameter(coroutineScope, "");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(DocumentFile p0, List<ParentConflict> p1, List<ParentConflict> p2, ParentFolderConflictAction p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p2, "");
        CancellableContinuation<List<ParentConflict>> cancellableContinuation = p3.MyBillsEntityDataFactory;
        Result.Companion companion = kotlin.Result.INSTANCE;
        cancellableContinuation.resumeWith(kotlin.Result.m3179constructorimpl(p2));
    }

    public static void getAuthRequestContext(DocumentFile p0, List<FolderCallback.FileConflict> p1, FolderCallback.FolderContentConflictAction p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p1, "");
        CancellableContinuation<List<FolderCallback.FileConflict>> cancellableContinuation = p2.KClassImpl$Data$declaredNonStaticMembers$2;
        Result.Companion companion = kotlin.Result.INSTANCE;
        cancellableContinuation.resumeWith(kotlin.Result.m3179constructorimpl(p1));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$InvalidSourceFilesAction;", "", "Lkotlinx/coroutines/CancellableContinuation;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/CancellableContinuation;", "getAuthRequestContext", "p0", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class InvalidSourceFilesAction {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final CancellableContinuation<Boolean> getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        public InvalidSourceFilesAction(CancellableContinuation<? super Boolean> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(cancellableContinuation, "");
            this.getAuthRequestContext = cancellableContinuation;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\t\u0010\nR \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentFolderConflictAction;", "", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", "PlaceComponentResult", "Lkotlinx/coroutines/CancellableContinuation;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class ParentFolderConflictAction {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final CancellableContinuation<List<ParentConflict>> MyBillsEntityDataFactory;

        /* JADX WARN: Multi-variable type inference failed */
        public ParentFolderConflictAction(CancellableContinuation<? super List<ParentConflict>> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(cancellableContinuation, "");
            this.MyBillsEntityDataFactory = cancellableContinuation;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\n\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0007"}, d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$Report;", "", "", "MyBillsEntityDataFactory", "J", "", "BuiltInFictitiousFunctionClassFactory", "I", "PlaceComponentResult", "", "KClassImpl$Data$declaredNonStaticMembers$2", LogConstants.RESULT_FALSE, "p0", "p1", "p2", "p3", "<init>", "(FJII)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Report {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final float BuiltInFictitiousFunctionClassFactory;
        public final long MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public Report(float f, long j, int i, int i2) {
            this.BuiltInFictitiousFunctionClassFactory = f;
            this.MyBillsEntityDataFactory = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = i2;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$Result;", "", "", "Landroidx/documentfile/provider/DocumentFile;", "MyBillsEntityDataFactory", "Ljava/util/List;", "", "getAuthRequestContext", "Z", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "<init>", "(Ljava/util/List;IIZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Result {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;
        public final List<DocumentFile> MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;
        public final boolean getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        public Result(List<? extends DocumentFile> list, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(list, "");
            this.MyBillsEntityDataFactory = list;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.getAuthRequestContext = z;
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Map<DocumentFile, ? extends FolderCallback.ErrorCode> p0, InvalidSourceFilesAction p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        CancellableContinuation<Boolean> cancellableContinuation = p1.getAuthRequestContext;
        Result.Companion companion = kotlin.Result.INSTANCE;
        cancellableContinuation.resumeWith(kotlin.Result.m3179constructorimpl(Boolean.FALSE));
    }
}
