package com.anggrayudi.storage.callback;

import androidx.documentfile.provider.DocumentFile;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u001b\u001cB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0016R\u0012\u0010\u0013\u001a\u00020\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u0018"}, d2 = {"Lcom/anggrayudi/storage/callback/ZipDecompressionCallback;", "T", "", "p0", "Landroidx/documentfile/provider/DocumentFile;", "p1", "", "p2", "", "p3", "", "p4", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/documentfile/provider/DocumentFile;)V", "Lcom/anggrayudi/storage/callback/ZipDecompressionCallback$ErrorCode;", "PlaceComponentResult", "(Lcom/anggrayudi/storage/callback/ZipDecompressionCallback$ErrorCode;)V", "Lcom/anggrayudi/storage/callback/ZipDecompressionCallback$Report;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/anggrayudi/storage/callback/ZipDecompressionCallback$Report;)V", "Ljava/lang/Thread;", "(Ljava/lang/Thread;)J", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", BehaviorLogger.Key.ERROR_CODE, "Report"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public abstract class ZipDecompressionCallback<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public CoroutineScope KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n"}, d2 = {"Lcom/anggrayudi/storage/callback/ZipDecompressionCallback$ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "STORAGE_PERMISSION_DENIED", "CANNOT_CREATE_FILE_IN_TARGET", "MISSING_ZIP_FILE", "NOT_A_ZIP_FILE", "UNKNOWN_IO_ERROR", "CANCELED", "NO_SPACE_LEFT_ON_TARGET_PATH"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public enum ErrorCode {
        STORAGE_PERMISSION_DENIED,
        CANNOT_CREATE_FILE_IN_TARGET,
        MISSING_ZIP_FILE,
        NOT_A_ZIP_FILE,
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
    public ZipDecompressionCallback() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.callback.ZipDecompressionCallback.<init>():void");
    }

    public static void BuiltInFictitiousFunctionClassFactory(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "");
    }

    public static long KClassImpl$Data$declaredNonStaticMembers$2(Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "");
        return 0L;
    }

    public static void PlaceComponentResult(ErrorCode p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    private ZipDecompressionCallback(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coroutineScope;
    }

    public /* synthetic */ ZipDecompressionCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\b"}, d2 = {"Lcom/anggrayudi/storage/callback/ZipDecompressionCallback$Report;", "", "", "PlaceComponentResult", "J", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "I", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(JII)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Report {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final long getAuthRequestContext;

        public Report(long j, int i, int i2) {
            this.getAuthRequestContext = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
        }
    }
}
