package ru.noties.markwon.html.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ru.noties.markwon.html.api.HtmlTag;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class HtmlTagImpl implements HtmlTag {
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory = -1;
    final String PlaceComponentResult;
    final Map<String, String> getAuthRequestContext;

    abstract void MyBillsEntityDataFactory(int i);

    protected HtmlTagImpl(String str, int i, Map<String, String> map) {
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = map;
    }

    @Override // ru.noties.markwon.html.api.HtmlTag
    public final String getErrorConfigVersion() {
        return this.PlaceComponentResult;
    }

    @Override // ru.noties.markwon.html.api.HtmlTag
    public final int moveToNextValue() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // ru.noties.markwon.html.api.HtmlTag
    public final int MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 == this.MyBillsEntityDataFactory;
    }

    @Override // ru.noties.markwon.html.api.HtmlTag
    public Map<String, String> BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }

    @Override // ru.noties.markwon.html.api.HtmlTag
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory >= 0;
    }

    /* loaded from: classes6.dex */
    static class InlineImpl extends HtmlTagImpl implements HtmlTag.Inline {
        @Override // ru.noties.markwon.html.api.HtmlTag
        public final boolean getAuthRequestContext() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public InlineImpl(String str, int i, Map<String, String> map) {
            super(str, i, map);
        }

        @Override // ru.noties.markwon.html.impl.HtmlTagImpl
        final void MyBillsEntityDataFactory(int i) {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                return;
            }
            this.MyBillsEntityDataFactory = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("InlineImpl{name='");
            sb.append(this.PlaceComponentResult);
            sb.append('\'');
            sb.append(", start=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", end=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", attributes=");
            sb.append(this.getAuthRequestContext);
            sb.append('}');
            return sb.toString();
        }

        @Override // ru.noties.markwon.html.api.HtmlTag
        public final HtmlTag.Block PlaceComponentResult() {
            throw new ClassCastException("Cannot cast Inline instance to Block");
        }
    }

    /* loaded from: classes6.dex */
    static class BlockImpl extends HtmlTagImpl implements HtmlTag.Block {
        List<BlockImpl> BuiltInFictitiousFunctionClassFactory;
        final BlockImpl lookAheadTest;

        @Override // ru.noties.markwon.html.api.HtmlTag
        public final HtmlTag.Block PlaceComponentResult() {
            return this;
        }

        @Override // ru.noties.markwon.html.api.HtmlTag
        public final boolean getAuthRequestContext() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static BlockImpl GetContactSyncConfig() {
            return new BlockImpl("", 0, Collections.emptyMap(), null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static BlockImpl PlaceComponentResult(String str, int i, Map<String, String> map, BlockImpl blockImpl) {
            return new BlockImpl(str, i, map, blockImpl);
        }

        private BlockImpl(String str, int i, Map<String, String> map, BlockImpl blockImpl) {
            super(str, i, map);
            this.lookAheadTest = blockImpl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.HtmlTagImpl
        public final void MyBillsEntityDataFactory(int i) {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                return;
            }
            this.MyBillsEntityDataFactory = i;
            List<BlockImpl> list = this.BuiltInFictitiousFunctionClassFactory;
            if (list != null) {
                Iterator<BlockImpl> it = list.iterator();
                while (it.hasNext()) {
                    it.next().MyBillsEntityDataFactory(i);
                }
            }
        }

        @Override // ru.noties.markwon.html.api.HtmlTag.Block
        public final HtmlTag.Block scheduleImpl() {
            return this.lookAheadTest;
        }

        @Override // ru.noties.markwon.html.api.HtmlTag.Block
        public final List<HtmlTag.Block> lookAheadTest() {
            List<BlockImpl> list = this.BuiltInFictitiousFunctionClassFactory;
            if (list == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(list);
        }

        @Override // ru.noties.markwon.html.impl.HtmlTagImpl, ru.noties.markwon.html.api.HtmlTag
        public final Map<String, String> BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BlockImpl{name='");
            sb.append(this.PlaceComponentResult);
            sb.append('\'');
            sb.append(", start=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", end=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", attributes=");
            sb.append(this.getAuthRequestContext);
            sb.append(", parent=");
            BlockImpl blockImpl = this.lookAheadTest;
            sb.append(blockImpl != null ? blockImpl.PlaceComponentResult : null);
            sb.append(", children=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append('}');
            return sb.toString();
        }
    }
}
