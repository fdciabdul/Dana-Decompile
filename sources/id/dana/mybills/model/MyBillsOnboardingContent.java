package id.dana.mybills.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0012\u0010\u0003\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0004"}, d2 = {"Lid/dana/mybills/model/MyBillsOnboardingContent;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsOnboardingContent {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    public MyBillsOnboardingContent() {
        this(0, null, null, 7, null);
    }

    public MyBillsOnboardingContent(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = str2;
    }

    public /* synthetic */ MyBillsOnboardingContent(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }
}
