package com.zoloz.wire;

import com.zoloz.wire.ExtendableMessage;
import com.zoloz.wire.Message;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class ExtendableMessage<T extends ExtendableMessage<?>> extends Message {
    transient ExtensionMap<T> extensionMap;

    protected ExtendableMessage(ExtendableMessage<T> extendableMessage) {
        super(extendableMessage);
        ExtensionMap<T> extensionMap;
        if (extendableMessage == null || (extensionMap = extendableMessage.extensionMap) == null) {
            return;
        }
        this.extensionMap = new ExtensionMap<>(extensionMap);
    }

    protected ExtendableMessage() {
    }

    protected void setBuilder(ExtendableBuilder<T> extendableBuilder) {
        super.setBuilder((Message.Builder) extendableBuilder);
        if (extendableBuilder.extensionMap != null) {
            this.extensionMap = new ExtensionMap<>(extendableBuilder.extensionMap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E> T setExtension(Extension<T, E> extension, E e) {
        ExtensionMap<T> extensionMap = this.extensionMap;
        if (extensionMap == null) {
            this.extensionMap = new ExtensionMap<>(extension, e);
        } else {
            extensionMap.put(extension, e);
        }
        return this;
    }

    public List<Extension<T, ?>> getExtensions() {
        ExtensionMap<T> extensionMap = this.extensionMap;
        return extensionMap == null ? Collections.emptyList() : extensionMap.getExtensions();
    }

    public <E> E getExtension(Extension<T, E> extension) {
        ExtensionMap<T> extensionMap = this.extensionMap;
        if (extensionMap == null) {
            return null;
        }
        return (E) extensionMap.get(extension);
    }

    protected boolean extensionsEqual(ExtendableMessage<T> extendableMessage) {
        ExtensionMap<T> extensionMap = this.extensionMap;
        if (extensionMap == null) {
            return extendableMessage.extensionMap == null;
        }
        return extensionMap.equals(extendableMessage.extensionMap);
    }

    protected int extensionsHashCode() {
        ExtensionMap<T> extensionMap = this.extensionMap;
        if (extensionMap == null) {
            return 0;
        }
        return extensionMap.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String extensionsToString() {
        ExtensionMap<T> extensionMap = this.extensionMap;
        return extensionMap == null ? "{}" : extensionMap.toString();
    }

    /* loaded from: classes8.dex */
    public static abstract class ExtendableBuilder<T extends ExtendableMessage<?>> extends Message.Builder<T> {
        ExtensionMap<T> extensionMap;

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(ExtendableMessage<T> extendableMessage) {
            super(extendableMessage);
            if (extendableMessage == null || extendableMessage.extensionMap == null) {
                return;
            }
            this.extensionMap = new ExtensionMap<>(extendableMessage.extensionMap);
        }

        public <E> E getExtension(Extension<T, E> extension) {
            ExtensionMap<T> extensionMap = this.extensionMap;
            if (extensionMap == null) {
                return null;
            }
            return (E) extensionMap.get(extension);
        }

        public <E> ExtendableBuilder<T> setExtension(Extension<T, E> extension, E e) {
            ExtensionMap<T> extensionMap = this.extensionMap;
            if (extensionMap == null) {
                this.extensionMap = new ExtensionMap<>(extension, e);
            } else {
                extensionMap.put(extension, e);
            }
            return this;
        }
    }
}
