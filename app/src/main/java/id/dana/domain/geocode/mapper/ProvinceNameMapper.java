package id.dana.domain.geocode.mapper;

import id.dana.cashier.view.InputCardNumberView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0005R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b&\u0010\u0017R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b'\u0010\u0017R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b(\u0010\u0017R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0083T¢\u0006\u0006\n\u0004\b)\u0010\u0017"}, d2 = {"Lid/dana/domain/geocode/mapper/ProvinceNameMapper;", "", "", "provinceName", "getProvinceTypeEnglish", "(Ljava/lang/String;)Ljava/lang/String;", "getProvinceTypeIndonesia", "", "isLandmark", "(Ljava/lang/String;)Z", "oldName", "removeWhiteSpace", "translateJakartaProvince", "translateOtherProvince", "translateProvinceNameToIndonesian", "prefixName", "translateProvinceToIndonesian", "", "ALL_LANDMARK_NAME", "Ljava/util/List;", "getALL_LANDMARK_NAME", "()Ljava/util/List;", "BALI", "Ljava/lang/String;", "BARAT", "DAERAH_KHUSUS_IBUKOTA_JAKARTA", "EAST", "JAKARTA", "JAVA", "JAWA", "KALIMANTAN", "NORTH", "SELATAN", "SOUTH", "SULAWESI", "SUMATERA", "SUMATRA", "TENGAH", "TIMUR", "UTARA", "WEST", "WHITESPACE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ProvinceNameMapper {
    private static final String BARAT = "Barat";
    private static final String EAST = "East";
    private static final String JAVA = "Java";
    private static final String JAWA = "Jawa";
    private static final String KALIMANTAN = "Kalimantan";
    private static final String NORTH = "North";
    private static final String SELATAN = "Selatan";
    private static final String SOUTH = "South";
    private static final String SULAWESI = "Sulawesi";
    private static final String SUMATERA = "Sumatera";
    private static final String SUMATRA = "Sumatra";
    private static final String TENGAH = "Tengah";
    private static final String TIMUR = "Timur";
    private static final String UTARA = "Utara";
    private static final String WEST = "West";
    private static final String WHITESPACE = " ";
    public static final ProvinceNameMapper INSTANCE = new ProvinceNameMapper();
    private static final String JAKARTA = "Jakarta";
    private static final String DAERAH_KHUSUS_IBUKOTA_JAKARTA = "Daerah Khusus Ibukota Jakarta";
    private static final String BALI = "Bali";
    private static final List<String> ALL_LANDMARK_NAME = CollectionsKt.listOf((Object[]) new String[]{JAKARTA, DAERAH_KHUSUS_IBUKOTA_JAKARTA, "West Java", "Jawa Tengah", "Jawa Timur", "Jawa Barat", "North Sumatra", "South Sumatra", "Sumatera Utara", "Sumatera Selatan", "Kalimantan Selatan", "Sulawesi Selatan", "South Sulawesi", BALI});

    private ProvinceNameMapper() {
    }

    @JvmName(name = "getALL_LANDMARK_NAME")
    public final List<String> getALL_LANDMARK_NAME() {
        return ALL_LANDMARK_NAME;
    }

    public final String translateProvinceNameToIndonesian(String provinceName) {
        Intrinsics.checkNotNullParameter(provinceName, "");
        String str = provinceName;
        return StringsKt.contains((CharSequence) str, (CharSequence) JAKARTA, true) ? translateJakartaProvince(provinceName) : (StringsKt.contains((CharSequence) str, (CharSequence) EAST, true) || StringsKt.contains((CharSequence) str, (CharSequence) SOUTH, true) || StringsKt.contains((CharSequence) str, (CharSequence) WEST, true) || StringsKt.contains((CharSequence) str, (CharSequence) NORTH, true)) ? translateOtherProvince(provinceName) : provinceName;
    }

    public final boolean isLandmark(String provinceName) {
        Intrinsics.checkNotNullParameter(provinceName, "");
        Iterator<T> it = ALL_LANDMARK_NAME.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains((CharSequence) provinceName, (CharSequence) ((String) it.next()), true)) {
                return true;
            }
        }
        return false;
    }

    private final String translateJakartaProvince(String provinceName) {
        String replace = new Regex("[^a-zA-Z]").replace(removeWhiteSpace(provinceName), "");
        return StringsKt.replace$default(replace, replace, DAERAH_KHUSUS_IBUKOTA_JAKARTA, false, 4, (Object) null);
    }

    private final String translateOtherProvince(String provinceName) {
        String translateProvinceToIndonesian = translateProvinceToIndonesian(removeWhiteSpace(StringsKt.replace$default(provinceName, getProvinceTypeEnglish(provinceName), "", false, 4, (Object) null)));
        StringBuilder sb = new StringBuilder();
        sb.append(translateProvinceToIndonesian);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(getProvinceTypeIndonesia(provinceName));
        return sb.toString();
    }

    private final String translateProvinceToIndonesian(String prefixName) {
        String str = prefixName;
        return StringsKt.contains((CharSequence) str, (CharSequence) JAVA, true) ? StringsKt.replace$default(prefixName, JAVA, JAWA, false, 4, (Object) null) : StringsKt.contains((CharSequence) str, (CharSequence) SUMATRA, true) ? StringsKt.replace$default(prefixName, SUMATRA, SUMATERA, false, 4, (Object) null) : prefixName;
    }

    private final String getProvinceTypeEnglish(String provinceName) {
        String str = provinceName;
        return !StringsKt.contains((CharSequence) str, (CharSequence) EAST, true) ? StringsKt.contains((CharSequence) str, (CharSequence) SOUTH, true) ? SOUTH : StringsKt.contains((CharSequence) str, (CharSequence) WEST, true) ? WEST : NORTH : EAST;
    }

    private final String getProvinceTypeIndonesia(String provinceName) {
        String str = provinceName;
        return StringsKt.contains((CharSequence) str, (CharSequence) EAST, true) ? TIMUR : StringsKt.contains((CharSequence) str, (CharSequence) SOUTH, true) ? SELATAN : StringsKt.contains((CharSequence) str, (CharSequence) WEST, true) ? BARAT : UTARA;
    }

    private final String removeWhiteSpace(String oldName) {
        return new Regex("\\s").replace(oldName, "");
    }
}
