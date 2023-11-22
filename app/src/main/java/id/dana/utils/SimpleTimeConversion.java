package id.dana.utils;

import android.content.Context;
import id.dana.domain.featureconfig.model.UgcConfig;
import j$.util.DesugarTimeZone;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes5.dex */
public class SimpleTimeConversion {
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final long MyBillsEntityDataFactory;
    private final String getAuthRequestContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
        public static final String COMPLETE = "1";
        public static final String SIMPLE = "0";
    }

    public SimpleTimeConversion(Context context, long j, String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = j;
        this.getAuthRequestContext = str;
    }

    private static long getAuthRequestContext(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext());
        simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
        Date date = new Date(j);
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(date));
        } catch (ParseException unused) {
        }
        return date.getTime();
    }

    public final String PlaceComponentResult() {
        String str = this.getAuthRequestContext;
        str.hashCode();
        if (str.equals("0")) {
            return BuiltInFictitiousFunctionClassFactory();
        }
        return !str.equals("1") ? "" : MyBillsEntityDataFactory();
    }

    private String MyBillsEntityDataFactory() {
        Locale locale;
        if (Locale.getDefault().getLanguage().equals(new Locale("in").getLanguage())) {
            locale = new Locale("in");
        } else {
            locale = new Locale("en");
        }
        int round = Math.round(((float) (new Date().getTime() - getAuthRequestContext(this.MyBillsEntityDataFactory))) / 1000.0f);
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.complete_second);
        String str = "";
        if (round >= 60) {
            string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.complete_minute);
            float f = round;
            String valueOf = String.valueOf(Math.round(f / 60.0f));
            if (round > 3600) {
                string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.complete_hours);
                String valueOf2 = String.valueOf(Math.round(f / 3600.0f));
                if (round > 86400) {
                    Date date = new Date(this.MyBillsEntityDataFactory);
                    if (round / UgcConfig.DEFAULT_UGC_INTERVAL == 1) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.complete_yesterday));
                        sb.append(" ");
                        sb.append(simpleDateFormat.format(date));
                        string = sb.toString();
                    } else {
                        string = round > 31104000 ? new SimpleDateFormat("dd MMMM yyyy, hh:mm a", locale).format(date) : new SimpleDateFormat("dd MMMM, hh:mm a", locale).format(date);
                    }
                } else {
                    str = valueOf2;
                }
            } else {
                str = valueOf;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" ");
        sb2.append(string);
        return sb2.toString();
    }

    private String BuiltInFictitiousFunctionClassFactory() {
        int round = Math.round(((float) (new Date().getTime() - getAuthRequestContext(this.MyBillsEntityDataFactory))) / 1000.0f);
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.mini_second);
        if (round >= 60) {
            string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.mini_minute);
            float f = round;
            int round2 = Math.round(f / 60.0f);
            if (round > 3600) {
                string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.mini_hours);
                int round3 = Math.round(f / 3600.0f);
                if (round > 86400) {
                    string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.mini_day);
                    round3 = round / UgcConfig.DEFAULT_UGC_INTERVAL;
                    if (round > 2592000) {
                        string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.mini_month);
                        round3 = round / 2592000;
                        if (round > 31104000) {
                            string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(id.dana.R.string.mini_year);
                            round /= 31104000;
                        }
                    }
                }
                round = round3;
            } else {
                round = round2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(round);
        sb.append(string);
        return sb.toString();
    }
}
