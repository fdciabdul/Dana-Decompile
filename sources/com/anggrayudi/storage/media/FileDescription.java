package com.anggrayudi.storage.media;

import com.alipay.mobile.zebra.ZebraLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fB\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lcom/anggrayudi/storage/media/FileDescription;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "PlaceComponentResult", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class FileDescription {
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    String PlaceComponentResult;

    private FileDescription(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = str2;
        this.BuiltInFictitiousFunctionClassFactory = ZebraLoader.MIME_TYPE_STREAM;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileDescription(String str, String str2, String str3) {
        this(str, str2);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = (str3 == null || !(StringsKt.contains$default((CharSequence) str3, (CharSequence) "*", false, 2, (Object) null) ^ true)) ? null : str3;
    }
}
