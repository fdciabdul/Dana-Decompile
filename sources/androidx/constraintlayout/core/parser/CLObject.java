package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* loaded from: classes6.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {
    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    /* loaded from: classes6.dex */
    class CLObjectIterator implements Iterator {
        CLObject KClassImpl$Data$declaredNonStaticMembers$2;
        int getAuthRequestContext = 0;

        public CLObjectIterator(CLObject cLObject) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cLObject;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.getAuthRequestContext < ((CLContainer) this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            CLKey cLKey = (CLKey) this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.get(this.getAuthRequestContext);
            this.getAuthRequestContext++;
            return cLKey;
        }
    }
}
