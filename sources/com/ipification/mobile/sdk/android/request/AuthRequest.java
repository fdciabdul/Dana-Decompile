package com.ipification.mobile.sdk.android.request;

import android.net.Uri;
import com.ipification.mobile.sdk.android.IPConfiguration;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0001.B«\u0001\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012&\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016\u0012&\u0010#\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016\u0012\u0006\u0010$\u001a\u00020\r\u0012\u0006\u0010%\u001a\u00020\r\u0012\u0006\u0010&\u001a\u00020\u0015\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010(\u001a\u00020\u0015\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b+\u0010,B\u0007¢\u0006\u0004\b+\u0010-J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0012\u0010\u000f\u001a\u00020\rX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u00108\u0001X\u0080\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R2\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016X\u0081\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0010X\u0081\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0081\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u0015X\u0081\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0015X\u0081\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR2\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016X\u0081\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0012\u0010\u0019\u001a\u00020\rX\u0081\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u000e"}, d2 = {"Lcom/ipification/mobile/sdk/android/request/AuthRequest;", "", "Landroid/content/Context;", "p0", "Landroid/net/Uri;", "PlaceComponentResult", "(Landroid/content/Context;)Landroid/net/Uri;", "Lcom/ipification/mobile/sdk/android/request/API_TYPE;", "getAuthRequestContext", "Lcom/ipification/mobile/sdk/android/request/API_TYPE;", "BuiltInFictitiousFunctionClassFactory", "DatabaseTableConfigUtil", "Landroid/net/Uri;", "", "J", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/String;", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "GetContactSyncConfig", "lookAheadTest", "moveToNextValue", "initRecordTimeStamp", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Lcom/ipification/mobile/sdk/android/request/API_TYPE;Landroid/net/Uri;Ljava/util/HashMap;Ljava/util/HashMap;JJLjava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "Builder"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthRequest {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public HashMap<String, String> PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private Uri getAuthRequestContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String lookAheadTest;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public HashMap<String, String> initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public long MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public API_TYPE BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public long NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;
    public String moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public Uri NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthRequest(API_TYPE api_type, Uri uri, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, long j, long j2, String str, Uri uri2, String str2, String str3, String str4) {
        this();
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = api_type;
        this.getAuthRequestContext = uri;
        this.initRecordTimeStamp = hashMap;
        this.PlaceComponentResult = hashMap2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = j;
        this.MyBillsEntityDataFactory = j2;
        this.scheduleImpl = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = uri2;
        this.lookAheadTest = str2;
        this.DatabaseTableConfigUtil = str3;
        this.moveToNextValue = str4;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0006\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\tR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R2\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0015X\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0002X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0002X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R2\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0015X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0012\u0010\u001e\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u000e"}, d2 = {"Lcom/ipification/mobile/sdk/android/request/AuthRequest$Builder;", "", "", "p0", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/ipification/mobile/sdk/android/request/AuthRequest;", "()Lcom/ipification/mobile/sdk/android/request/AuthRequest;", "Lcom/ipification/mobile/sdk/android/request/API_TYPE;", "Lcom/ipification/mobile/sdk/android/request/API_TYPE;", "", "PlaceComponentResult", "J", "BuiltInFictitiousFunctionClassFactory", "Landroid/net/Uri;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/net/Uri;", "MyBillsEntityDataFactory", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getAuthRequestContext", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "lookAheadTest", "initRecordTimeStamp", "<init>", "(Landroid/net/Uri;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public HashMap<String, String> PlaceComponentResult;
        public API_TYPE KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public Uri NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public HashMap<String, String> moveToNextValue;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        private final Uri MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public long BuiltInFictitiousFunctionClassFactory;
        public String getAuthRequestContext;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public String scheduleImpl;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public long initRecordTimeStamp;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String getErrorConfigVersion;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public String lookAheadTest;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, android.net.Uri] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Builder() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.request.AuthRequest.Builder.<init>():void");
        }

        public /* synthetic */ Builder(Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : uri);
        }

        public final AuthRequest KClassImpl$Data$declaredNonStaticMembers$2() {
            return new AuthRequest(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.moveToNextValue, this.PlaceComponentResult, this.initRecordTimeStamp, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl, this.lookAheadTest, this.getErrorConfigVersion);
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            if (this.moveToNextValue == null) {
                this.moveToNextValue = new HashMap<>();
            }
            HashMap<String, String> hashMap = this.moveToNextValue;
            if (hashMap == null) {
                Intrinsics.throwNpe();
            }
            hashMap.put(p0, p1);
        }

        public Builder(Uri uri) {
            this.MyBillsEntityDataFactory = uri;
            IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
            this.initRecordTimeStamp = IPConfiguration.Companion.MyBillsEntityDataFactory().PlaceComponentResult;
            this.BuiltInFictitiousFunctionClassFactory = IPConfiguration.Companion.MyBillsEntityDataFactory().getAuthRequestContext;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = API_TYPE.OTHER;
            this.getAuthRequestContext = "";
            this.scheduleImpl = "code";
        }
    }

    public AuthRequest() {
        this.getErrorConfigVersion = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = IPConfiguration.Companion.MyBillsEntityDataFactory().PlaceComponentResult;
        this.MyBillsEntityDataFactory = IPConfiguration.Companion.MyBillsEntityDataFactory().getAuthRequestContext;
        this.scheduleImpl = "";
        this.BuiltInFictitiousFunctionClassFactory = API_TYPE.OTHER;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        if (((r2 == null || r2.containsKey("consent_id")) ? false : true) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (((r2 == null || r2.containsKey("consent_timestamp")) ? false : true) != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.net.Uri PlaceComponentResult(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.request.AuthRequest.PlaceComponentResult(android.content.Context):android.net.Uri");
    }
}
