package id.dana.mybills.ui.v2.addnewbills;

import com.google.gson.JsonObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import id.dana.utils.extension.JSONExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorGetInquiry;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorGetInquiry;Z)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class AddNewBillsUiStateKt {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsUiState.OnErrorGetInquiry onErrorGetInquiry, boolean z) {
        Object m3179constructorimpl;
        Intrinsics.checkNotNullParameter(onErrorGetInquiry, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            String asString = ((JsonObject) JSONExtKt.PlaceComponentResult().fromJson(onErrorGetInquiry.KClassImpl$Data$declaredNonStaticMembers$2, JsonObject.class)).get(z ? "id" : "en").getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "");
            m3179constructorimpl = Result.m3179constructorimpl(StringsKt.replace$default(asString, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, " ", false, 4, (Object) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3185isFailureimpl(m3179constructorimpl)) {
            m3179constructorimpl = null;
        }
        String str = (String) m3179constructorimpl;
        return str == null ? onErrorGetInquiry.KClassImpl$Data$declaredNonStaticMembers$2 : str;
    }
}
