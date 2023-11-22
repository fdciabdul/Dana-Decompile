package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import id.dana.cashier.view.InputCardNumberView;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultUserAgentPublisher implements UserAgentPublisher {
    private final GlobalLibraryVersionRegistrar gamesSDKRegistrar;
    private final String javaSDKVersionUserAgent;

    DefaultUserAgentPublisher(Set<LibraryVersion> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.javaSDKVersionUserAgent = toUserAgent(set);
        this.gamesSDKRegistrar = globalLibraryVersionRegistrar;
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    public String getUserAgent() {
        if (this.gamesSDKRegistrar.getRegisteredVersions().isEmpty()) {
            return this.javaSDKVersionUserAgent;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.javaSDKVersionUserAgent);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(toUserAgent(this.gamesSDKRegistrar.getRegisteredVersions()));
        return sb.toString();
    }

    private static String toUserAgent(Set<LibraryVersion> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<LibraryVersion> it = set.iterator();
        while (it.hasNext()) {
            LibraryVersion next = it.next();
            sb.append(next.getLibraryName());
            sb.append('/');
            sb.append(next.getVersion());
            if (it.hasNext()) {
                sb.append(InputCardNumberView.DIVIDER);
            }
        }
        return sb.toString();
    }

    public static Component<UserAgentPublisher> component() {
        return Component.builder(UserAgentPublisher.class).add(Dependency.setOf(LibraryVersion.class)).factory(new ComponentFactory() { // from class: com.google.firebase.platforminfo.DefaultUserAgentPublisher$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ UserAgentPublisher lambda$component$0(ComponentContainer componentContainer) {
        return new DefaultUserAgentPublisher(componentContainer.setOf(LibraryVersion.class), GlobalLibraryVersionRegistrar.getInstance());
    }
}
