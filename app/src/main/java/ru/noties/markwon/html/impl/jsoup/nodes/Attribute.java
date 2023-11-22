package ru.noties.markwon.html.impl.jsoup.nodes;

import java.util.Map;
import ru.noties.markwon.html.impl.jsoup.helper.Validate;

/* loaded from: classes6.dex */
public class Attribute implements Map.Entry<String, String>, Cloneable {
    public String BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;
    Attributes PlaceComponentResult;

    @Override // java.util.Map.Entry
    public /* synthetic */ String setValue(String str) {
        int BuiltInFictitiousFunctionClassFactory;
        String str2 = str;
        Attributes attributes = this.PlaceComponentResult;
        int BuiltInFictitiousFunctionClassFactory2 = attributes.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        String KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2 == -1 ? "" : Attributes.KClassImpl$Data$declaredNonStaticMembers$2(attributes.PlaceComponentResult[BuiltInFictitiousFunctionClassFactory2]);
        Attributes attributes2 = this.PlaceComponentResult;
        if (attributes2 != null && (BuiltInFictitiousFunctionClassFactory = attributes2.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory)) != -1) {
            this.PlaceComponentResult.PlaceComponentResult[BuiltInFictitiousFunctionClassFactory] = str2;
        }
        this.MyBillsEntityDataFactory = str2;
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public Attribute(String str, String str2, Attributes attributes) {
        Validate.MyBillsEntityDataFactory(str);
        this.BuiltInFictitiousFunctionClassFactory = str.trim();
        Validate.BuiltInFictitiousFunctionClassFactory(str);
        this.MyBillsEntityDataFactory = str2;
        this.PlaceComponentResult = attributes;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str == null ? attribute.BuiltInFictitiousFunctionClassFactory == null : str.equals(attribute.BuiltInFictitiousFunctionClassFactory)) {
            String str2 = this.MyBillsEntityDataFactory;
            String str3 = attribute.MyBillsEntityDataFactory;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.MyBillsEntityDataFactory;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public Attribute clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.util.Map.Entry
    public /* bridge */ /* synthetic */ String getKey() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // java.util.Map.Entry
    public /* bridge */ /* synthetic */ String getValue() {
        return this.MyBillsEntityDataFactory;
    }
}
