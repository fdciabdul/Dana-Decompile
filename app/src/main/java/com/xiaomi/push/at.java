package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class at {

    /* loaded from: classes8.dex */
    public static final class a extends e {
        private boolean MyBillsEntityDataFactory;
        private boolean PlaceComponentResult;
        private boolean moveToNextValue;
        private boolean scheduleImpl;
        public int getAuthRequestContext = 0;
        private boolean getErrorConfigVersion = false;
        private int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        private boolean lookAheadTest = false;
        private List<String> BuiltInFictitiousFunctionClassFactory = Collections.emptyList();
        private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;

        private boolean BuiltInFictitiousFunctionClassFactory() {
            return this.MyBillsEntityDataFactory;
        }

        private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult;
        }

        public static a MyBillsEntityDataFactory(b bVar) {
            return new a().KClassImpl$Data$declaredNonStaticMembers$2(bVar);
        }

        private boolean MyBillsEntityDataFactory() {
            return this.getErrorConfigVersion;
        }

        private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return this.scheduleImpl;
        }

        private a getAuthRequestContext(String str) {
            if (this.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            }
            this.BuiltInFictitiousFunctionClassFactory.add(str);
            return this;
        }

        private boolean getErrorConfigVersion() {
            return this.lookAheadTest;
        }

        private boolean scheduleImpl() {
            return this.moveToNextValue;
        }

        @Override // com.xiaomi.push.e
        public final int getAuthRequestContext() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 < 0) {
                PlaceComponentResult();
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        public static a KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
            return (a) new a().BuiltInFictitiousFunctionClassFactory(bArr, 0, bArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.xiaomi.push.e
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public a KClassImpl$Data$declaredNonStaticMembers$2(b bVar) {
            while (true) {
                int BuiltInFictitiousFunctionClassFactory = bVar.BuiltInFictitiousFunctionClassFactory();
                if (BuiltInFictitiousFunctionClassFactory == 0) {
                    return this;
                }
                if (BuiltInFictitiousFunctionClassFactory == 8) {
                    int errorConfigVersion = bVar.getErrorConfigVersion();
                    this.PlaceComponentResult = true;
                    this.getAuthRequestContext = errorConfigVersion;
                } else if (BuiltInFictitiousFunctionClassFactory == 16) {
                    boolean MyBillsEntityDataFactory = bVar.MyBillsEntityDataFactory();
                    this.MyBillsEntityDataFactory = true;
                    this.getErrorConfigVersion = MyBillsEntityDataFactory;
                } else if (BuiltInFictitiousFunctionClassFactory == 24) {
                    int moveToNextValue = bVar.moveToNextValue();
                    this.moveToNextValue = true;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = moveToNextValue;
                } else if (BuiltInFictitiousFunctionClassFactory == 32) {
                    boolean MyBillsEntityDataFactory2 = bVar.MyBillsEntityDataFactory();
                    this.scheduleImpl = true;
                    this.lookAheadTest = MyBillsEntityDataFactory2;
                } else if (BuiltInFictitiousFunctionClassFactory == 42) {
                    getAuthRequestContext(bVar.getAuthRequestContext());
                } else if (!BuiltInFictitiousFunctionClassFactory(bVar, BuiltInFictitiousFunctionClassFactory)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public final void KClassImpl$Data$declaredNonStaticMembers$2(c cVar) {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                cVar.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            }
            if (BuiltInFictitiousFunctionClassFactory()) {
                cVar.BuiltInFictitiousFunctionClassFactory(2, MyBillsEntityDataFactory());
            }
            if (scheduleImpl()) {
                cVar.getAuthRequestContext(3, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                cVar.BuiltInFictitiousFunctionClassFactory(4, getErrorConfigVersion());
            }
            Iterator<String> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                cVar.PlaceComponentResult(5, it.next());
            }
        }

        @Override // com.xiaomi.push.e
        public final int PlaceComponentResult() {
            int i = 0;
            int authRequestContext = KClassImpl$Data$declaredNonStaticMembers$2() ? c.getAuthRequestContext(this.getAuthRequestContext) + 0 : 0;
            if (BuiltInFictitiousFunctionClassFactory()) {
                MyBillsEntityDataFactory();
                authRequestContext += c.PlaceComponentResult(2);
            }
            if (scheduleImpl()) {
                authRequestContext += c.BuiltInFictitiousFunctionClassFactory(3, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                getErrorConfigVersion();
                authRequestContext += c.PlaceComponentResult(4);
            }
            Iterator<String> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                i += c.MyBillsEntityDataFactory(it.next());
            }
            int size = authRequestContext + i + (this.BuiltInFictitiousFunctionClassFactory.size() * 1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = size;
            return size;
        }
    }
}
