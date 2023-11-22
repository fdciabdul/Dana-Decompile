package androidx.work;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class InputMerger {
    private static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("InputMerger");

    public abstract Data PlaceComponentResult(List<Data> list);

    public static InputMerger MyBillsEntityDataFactory(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e) {
            Logger authRequestContext = Logger.getAuthRequestContext();
            String str2 = MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append("Trouble instantiating + ");
            sb.append(str);
            authRequestContext.BuiltInFictitiousFunctionClassFactory(str2, sb.toString(), e);
            return null;
        }
    }
}
