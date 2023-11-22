package id.dana.animation.subscription;

import id.dana.model.CdpContentModel;
import id.dana.utils.DateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/model/CdpContentModel;", "", "MyBillsEntityDataFactory", "(Lid/dana/model/CdpContentModel;)I"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnnouncementExtKt {
    public static final int MyBillsEntityDataFactory(CdpContentModel cdpContentModel) {
        Locale locale;
        Date parse;
        Intrinsics.checkNotNullParameter(cdpContentModel, "");
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        String str = cdpContentModel.moveToNextValue;
        if (str == null) {
            return 9999;
        }
        locale = Locale.getDefault();
        parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).parse(str);
        return (int) DateTimeUtil.BuiltInFictitiousFunctionClassFactory(date, parse);
    }
}
