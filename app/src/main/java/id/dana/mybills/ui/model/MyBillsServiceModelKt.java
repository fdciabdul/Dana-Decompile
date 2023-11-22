package id.dana.mybills.ui.model;

import android.content.Context;
import android.content.res.Resources;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.ResourceUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/model/MyBillsServiceModel;", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "getLocalizedName", "(Lid/dana/mybills/ui/model/MyBillsServiceModel;Landroid/content/Context;)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MyBillsServiceModelKt {
    public static final String getLocalizedName(MyBillsServiceModel myBillsServiceModel, Context context) {
        Object m3179constructorimpl;
        String str;
        Intrinsics.checkNotNullParameter(myBillsServiceModel, "");
        Intrinsics.checkNotNullParameter(context, "");
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        if (!LocaleUtil.PlaceComponentResult() || myBillsServiceModel.getNameInd() == null) {
            LocaleUtil localeUtil2 = LocaleUtil.INSTANCE;
            if (LocaleUtil.PlaceComponentResult() || myBillsServiceModel.getName() == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Resources resources = context.getResources();
                    ResourceUtil resourceUtil = ResourceUtil.INSTANCE;
                    StringBuilder sb = new StringBuilder();
                    sb.append("my_bills_label_");
                    sb.append(myBillsServiceModel.getKey());
                    m3179constructorimpl = Result.m3179constructorimpl(resources.getString(ResourceUtil.KClassImpl$Data$declaredNonStaticMembers$2(context, sb.toString())));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                    m3179constructorimpl = null;
                }
                String str2 = (String) m3179constructorimpl;
                if (str2 == null) {
                    str = myBillsServiceModel.getName();
                    if (str == null) {
                        str = "";
                    }
                } else {
                    str = str2;
                }
                Intrinsics.checkNotNullExpressionValue(str, "");
                return str;
            }
            return myBillsServiceModel.getName();
        }
        return myBillsServiceModel.getNameInd();
    }
}
