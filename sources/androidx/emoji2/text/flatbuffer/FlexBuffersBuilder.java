package androidx.emoji2.text.flatbuffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class FlexBuffersBuilder {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private Comparator<Value> MyBillsEntityDataFactory;
    private final HashMap<String, Integer> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final HashMap<String, Integer> PlaceComponentResult;
    private final ReadWriteBuf getAuthRequestContext;
    private final ArrayList<Value> moveToNextValue;

    /* loaded from: classes6.dex */
    static class Value {
        int PlaceComponentResult;
    }

    private FlexBuffersBuilder(byte b) {
        this(new ArrayReadWriteBuf(256));
    }

    public FlexBuffersBuilder() {
        this((byte) 0);
    }

    private FlexBuffersBuilder(ReadWriteBuf readWriteBuf) {
        this.moveToNextValue = new ArrayList<>();
        this.PlaceComponentResult = new HashMap<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashMap<>();
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.MyBillsEntityDataFactory = new Comparator<Value>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            @Override // java.util.Comparator
            public /* synthetic */ int compare(Value value, Value value2) {
                byte BuiltInFictitiousFunctionClassFactory;
                byte BuiltInFictitiousFunctionClassFactory2;
                int i = value.PlaceComponentResult;
                int i2 = value2.PlaceComponentResult;
                do {
                    BuiltInFictitiousFunctionClassFactory = FlexBuffersBuilder.this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i);
                    BuiltInFictitiousFunctionClassFactory2 = FlexBuffersBuilder.this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i2);
                    if (BuiltInFictitiousFunctionClassFactory == 0) {
                        return BuiltInFictitiousFunctionClassFactory - BuiltInFictitiousFunctionClassFactory2;
                    }
                    i++;
                    i2++;
                } while (BuiltInFictitiousFunctionClassFactory == BuiltInFictitiousFunctionClassFactory2);
                return BuiltInFictitiousFunctionClassFactory - BuiltInFictitiousFunctionClassFactory2;
            }
        };
        this.getAuthRequestContext = readWriteBuf;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    }
}
