package org.yaml.snakeyaml.nodes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.UriEncoder;

/* loaded from: classes6.dex */
public final class Tag {
    public static final Tag BuiltInFictitiousFunctionClassFactory;
    public static final Tag DatabaseTableConfigUtil;
    public static final Tag GetContactSyncConfig;
    public static final Tag KClassImpl$Data$declaredNonStaticMembers$2;
    public static final Tag MyBillsEntityDataFactory;
    public static final Tag NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final Tag NetworkUserEntityData$$ExternalSyntheticLambda1;
    public static final Tag NetworkUserEntityData$$ExternalSyntheticLambda2;
    public static final Set<Tag> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private static final Map<Tag, Set<Class<?>>> NetworkUserEntityData$$ExternalSyntheticLambda8;
    public static final Tag PlaceComponentResult;
    public static final Tag getAuthRequestContext;
    public static final Tag getErrorConfigVersion;
    public static final Tag initRecordTimeStamp;
    public static final Tag lookAheadTest;
    public static final Tag moveToNextValue;
    public static final Tag scheduleImpl;
    private boolean PrepareContext;
    private final String newProxyInstance;

    static {
        Tag tag = new Tag("tag:yaml.org,2002:yaml");
        GetContactSyncConfig = tag;
        Tag tag2 = new Tag("tag:yaml.org,2002:merge");
        getErrorConfigVersion = tag2;
        Tag tag3 = new Tag("tag:yaml.org,2002:set");
        NetworkUserEntityData$$ExternalSyntheticLambda2 = tag3;
        Tag tag4 = new Tag("tag:yaml.org,2002:pairs");
        NetworkUserEntityData$$ExternalSyntheticLambda0 = tag4;
        Tag tag5 = new Tag("tag:yaml.org,2002:omap");
        lookAheadTest = tag5;
        Tag tag6 = new Tag("tag:yaml.org,2002:binary");
        MyBillsEntityDataFactory = tag6;
        Tag tag7 = new Tag("tag:yaml.org,2002:int");
        getAuthRequestContext = tag7;
        Tag tag8 = new Tag("tag:yaml.org,2002:float");
        BuiltInFictitiousFunctionClassFactory = tag8;
        Tag tag9 = new Tag("tag:yaml.org,2002:timestamp");
        initRecordTimeStamp = tag9;
        Tag tag10 = new Tag("tag:yaml.org,2002:bool");
        PlaceComponentResult = tag10;
        Tag tag11 = new Tag("tag:yaml.org,2002:null");
        moveToNextValue = tag11;
        Tag tag12 = new Tag("tag:yaml.org,2002:str");
        DatabaseTableConfigUtil = tag12;
        Tag tag13 = new Tag("tag:yaml.org,2002:seq");
        NetworkUserEntityData$$ExternalSyntheticLambda1 = tag13;
        Tag tag14 = new Tag("tag:yaml.org,2002:map");
        scheduleImpl = tag14;
        HashSet hashSet = new HashSet(15);
        NetworkUserEntityData$$ExternalSyntheticLambda7 = hashSet;
        hashSet.add(tag);
        hashSet.add(tag2);
        hashSet.add(tag3);
        hashSet.add(tag4);
        hashSet.add(tag5);
        hashSet.add(tag6);
        hashSet.add(tag7);
        hashSet.add(tag8);
        hashSet.add(tag9);
        hashSet.add(tag10);
        hashSet.add(tag11);
        hashSet.add(tag12);
        hashSet.add(tag13);
        hashSet.add(tag14);
        KClassImpl$Data$declaredNonStaticMembers$2 = new Tag("tag:yaml.org,2002:comment");
        HashMap hashMap = new HashMap();
        NetworkUserEntityData$$ExternalSyntheticLambda8 = hashMap;
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Double.class);
        hashSet2.add(Float.class);
        hashSet2.add(BigDecimal.class);
        hashMap.put(tag8, hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(Integer.class);
        hashSet3.add(Long.class);
        hashSet3.add(BigInteger.class);
        hashMap.put(tag7, hashSet3);
        HashSet hashSet4 = new HashSet();
        hashSet4.add(Date.class);
        try {
            hashSet4.add(Class.forName("java.sql.Date"));
            hashSet4.add(Class.forName("java.sql.Timestamp"));
        } catch (ClassNotFoundException unused) {
        }
        NetworkUserEntityData$$ExternalSyntheticLambda8.put(initRecordTimeStamp, hashSet4);
    }

    public Tag(String str) {
        this.PrepareContext = false;
        if (str == null) {
            throw new NullPointerException("Tag must be provided.");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Tag must not be empty.");
        }
        if (str.trim().length() != str.length()) {
            throw new IllegalArgumentException("Tag must not contain leading or trailing spaces.");
        }
        this.newProxyInstance = UriEncoder.KClassImpl$Data$declaredNonStaticMembers$2(str);
        this.PrepareContext = !str.startsWith("tag:yaml.org,2002:");
    }

    public Tag(Class<? extends Object> cls) {
        this.PrepareContext = false;
        if (cls == null) {
            throw new NullPointerException("Class for tag must be provided.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("tag:yaml.org,2002:");
        sb.append(UriEncoder.KClassImpl$Data$declaredNonStaticMembers$2(cls.getName()));
        this.newProxyInstance = sb.toString();
    }

    public final boolean PlaceComponentResult() {
        return this.PrepareContext;
    }

    public final boolean MyBillsEntityDataFactory(String str) {
        return this.newProxyInstance.startsWith(str);
    }

    public final String MyBillsEntityDataFactory() {
        if (this.PrepareContext) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid tag: ");
            sb.append(this.newProxyInstance);
            throw new YAMLException(sb.toString());
        }
        return UriEncoder.getAuthRequestContext(this.newProxyInstance.substring(18));
    }

    public final String toString() {
        return this.newProxyInstance;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Tag) {
            return this.newProxyInstance.equals(((Tag) obj).newProxyInstance);
        }
        return false;
    }

    public final int hashCode() {
        return this.newProxyInstance.hashCode();
    }

    public final boolean getAuthRequestContext(Class<?> cls) {
        Set<Class<?>> set = NetworkUserEntityData$$ExternalSyntheticLambda8.get(this);
        if (set != null) {
            return set.contains(cls);
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return (this.PrepareContext || NetworkUserEntityData$$ExternalSyntheticLambda7.contains(this)) ? false : true;
    }
}
