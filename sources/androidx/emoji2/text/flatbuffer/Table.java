package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class Table {
    protected int BuiltInFictitiousFunctionClassFactory;
    protected ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    Utf8 PlaceComponentResult = Utf8.getAuthRequestContext();
    private int getAuthRequestContext;

    protected static int NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getAuthRequestContext(int i) {
        if (i < this.getAuthRequestContext) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(this.MyBillsEntityDataFactory + i);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int BuiltInFictitiousFunctionClassFactory(int i) {
        return i + this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int i2 = i + this.BuiltInFictitiousFunctionClassFactory;
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2 + this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int PlaceComponentResult(int i) {
        int i2 = i + this.BuiltInFictitiousFunctionClassFactory;
        return i2 + this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(i2) + 4;
    }

    /* renamed from: androidx.emoji2.text.flatbuffer.Table$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Comparator<Integer> {
        final /* synthetic */ Table BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Integer num, Integer num2) {
            return Table.NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(int i, ByteBuffer byteBuffer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = byteBuffer;
        if (byteBuffer != null) {
            this.BuiltInFictitiousFunctionClassFactory = i;
            int i2 = i - byteBuffer.getInt(i);
            this.MyBillsEntityDataFactory = i2;
            this.getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(i2);
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.MyBillsEntityDataFactory = 0;
        this.getAuthRequestContext = 0;
    }
}
