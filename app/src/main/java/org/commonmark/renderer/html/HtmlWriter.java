package org.commonmark.renderer.html;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.commonmark.internal.util.Escaping;

/* loaded from: classes9.dex */
public class HtmlWriter {
    public static final Map<String, String> BuiltInFictitiousFunctionClassFactory = Collections.emptyMap();
    private final Appendable MyBillsEntityDataFactory;
    public char getAuthRequestContext;

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, Map<String, String> map, boolean z) {
        PlaceComponentResult(SimpleComparison.LESS_THAN_OPERATION);
        PlaceComponentResult(str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                PlaceComponentResult(" ");
                PlaceComponentResult(Escaping.MyBillsEntityDataFactory(entry.getKey(), true));
                PlaceComponentResult("=\"");
                PlaceComponentResult(Escaping.MyBillsEntityDataFactory(entry.getValue(), true));
                PlaceComponentResult("\"");
            }
        }
        if (z) {
            PlaceComponentResult(" /");
        }
        PlaceComponentResult(SimpleComparison.GREATER_THAN_OPERATION);
    }

    public final void PlaceComponentResult(String str) {
        try {
            this.MyBillsEntityDataFactory.append(str);
            int length = str.length();
            if (length != 0) {
                this.getAuthRequestContext = str.charAt(length - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
