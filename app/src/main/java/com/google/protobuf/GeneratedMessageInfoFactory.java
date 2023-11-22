package com.google.protobuf;

/* loaded from: classes.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {
    private static final GeneratedMessageInfoFactory instance = new GeneratedMessageInfoFactory();

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory getInstance() {
        return instance;
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported message type: ");
            sb.append(cls.getName());
            throw new IllegalArgumentException(sb.toString());
        }
        try {
            return (MessageInfo) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to get message info for ");
            sb2.append(cls.getName());
            throw new RuntimeException(sb2.toString(), e);
        }
    }
}
