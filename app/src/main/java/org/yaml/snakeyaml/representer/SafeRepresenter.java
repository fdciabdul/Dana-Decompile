package org.yaml.snakeyaml.representer;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes6.dex */
class SafeRepresenter extends BaseRepresenter {
    private static final Pattern getErrorConfigVersion = Pattern.compile("\n|\u0085|\u2028|\u2029");
    protected TimeZone GetContactSyncConfig = null;
    protected Map<Class<? extends Object>, Tag> lookAheadTest;
    protected DumperOptions.NonPrintableStyle moveToNextValue;

    public SafeRepresenter(DumperOptions dumperOptions) {
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new RepresentNull();
        this.scheduleImpl.put(String.class, new RepresentString());
        this.scheduleImpl.put(Boolean.class, new RepresentBoolean());
        this.scheduleImpl.put(Character.class, new RepresentString());
        this.scheduleImpl.put(UUID.class, new RepresentUuid());
        this.scheduleImpl.put(byte[].class, new RepresentByteArray());
        RepresentPrimitiveArray representPrimitiveArray = new RepresentPrimitiveArray();
        this.scheduleImpl.put(short[].class, representPrimitiveArray);
        this.scheduleImpl.put(int[].class, representPrimitiveArray);
        this.scheduleImpl.put(long[].class, representPrimitiveArray);
        this.scheduleImpl.put(float[].class, representPrimitiveArray);
        this.scheduleImpl.put(double[].class, representPrimitiveArray);
        this.scheduleImpl.put(char[].class, representPrimitiveArray);
        this.scheduleImpl.put(boolean[].class, representPrimitiveArray);
        this.getAuthRequestContext.put(Number.class, new RepresentNumber());
        this.getAuthRequestContext.put(List.class, new RepresentList());
        this.getAuthRequestContext.put(Map.class, new RepresentMap());
        this.getAuthRequestContext.put(Set.class, new RepresentSet());
        this.getAuthRequestContext.put(Iterator.class, new RepresentIterator());
        this.getAuthRequestContext.put(new Object[0].getClass(), new RepresentArray());
        this.getAuthRequestContext.put(Date.class, new RepresentDate());
        this.getAuthRequestContext.put(Enum.class, new RepresentEnum());
        this.getAuthRequestContext.put(Calendar.class, new RepresentDate());
        this.lookAheadTest = new HashMap();
        this.moveToNextValue = dumperOptions.lookAheadTest;
    }

    /* loaded from: classes6.dex */
    protected class RepresentNull implements Represent {
        protected RepresentNull() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentString implements Represent {
        protected RepresentString() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentBoolean implements Represent {
        protected RepresentBoolean() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentNumber implements Represent {
        protected RepresentNumber() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentList implements Represent {
        protected RepresentList() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentIterator implements Represent {
        protected RepresentIterator() {
        }
    }

    /* loaded from: classes9.dex */
    static class IteratorWrapper implements Iterable<Object> {
        private final Iterator<Object> KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentArray implements Represent {
        protected RepresentArray() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentPrimitiveArray implements Represent {
        protected RepresentPrimitiveArray() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentMap implements Represent {
        protected RepresentMap() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentSet implements Represent {
        protected RepresentSet() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentDate implements Represent {
        protected RepresentDate() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentEnum implements Represent {
        protected RepresentEnum() {
        }
    }

    /* loaded from: classes6.dex */
    protected class RepresentByteArray implements Represent {
        protected RepresentByteArray() {
        }
    }

    public TimeZone MyBillsEntityDataFactory() {
        return this.GetContactSyncConfig;
    }

    public void PlaceComponentResult(TimeZone timeZone) {
        this.GetContactSyncConfig = timeZone;
    }

    /* loaded from: classes6.dex */
    protected class RepresentUuid implements Represent {
        protected RepresentUuid() {
        }
    }
}
