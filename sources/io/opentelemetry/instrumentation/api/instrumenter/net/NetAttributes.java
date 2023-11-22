package io.opentelemetry.instrumentation.api.instrumenter.net;

import io.opentelemetry.api.common.AttributeKey;

/* loaded from: classes6.dex */
final class NetAttributes {
    static final String SOCK_FAMILY_INET = "inet";
    static final AttributeKey<String> NET_SOCK_FAMILY = AttributeKey.CC.stringKey("net.sock.family");
    static final AttributeKey<String> NET_SOCK_PEER_ADDR = AttributeKey.CC.stringKey("net.sock.peer.addr");
    static final AttributeKey<String> NET_SOCK_PEER_NAME = AttributeKey.CC.stringKey("net.sock.peer.name");
    static final AttributeKey<Long> NET_SOCK_PEER_PORT = AttributeKey.CC.longKey("net.sock.peer.port");
    static final AttributeKey<String> NET_SOCK_HOST_ADDR = AttributeKey.CC.stringKey("net.sock.host.addr");
    static final AttributeKey<Long> NET_SOCK_HOST_PORT = AttributeKey.CC.longKey("net.sock.host.port");

    private NetAttributes() {
    }
}
