package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
    private final BaseGraph<N> graph;
    @CheckForNull
    N node;
    private final Iterator<N> nodeIterator;
    Iterator<N> successorIterator;

    public static <N> EndpointPairIterator<N> of(BaseGraph<N> baseGraph) {
        AnonymousClass1 anonymousClass1 = null;
        return baseGraph.isDirected() ? new Directed(baseGraph) : new Undirected(baseGraph);
    }

    private EndpointPairIterator(BaseGraph<N> baseGraph) {
        this.node = null;
        this.successorIterator = ImmutableSet.of().iterator();
        this.graph = baseGraph;
        this.nodeIterator = baseGraph.nodes().iterator();
    }

    final boolean advance() {
        Preconditions.checkState(!this.successorIterator.hasNext());
        if (this.nodeIterator.hasNext()) {
            N next = this.nodeIterator.next();
            this.node = next;
            this.successorIterator = this.graph.successors((BaseGraph<N>) next).iterator();
            return true;
        }
        return false;
    }

    /* loaded from: classes7.dex */
    public static final class Directed<N> extends EndpointPairIterator<N> {
        private Directed(BaseGraph<N> baseGraph) {
            super(baseGraph);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public final EndpointPair<N> computeNext() {
            while (!this.successorIterator.hasNext()) {
                if (!advance()) {
                    return endOfData();
                }
            }
            return EndpointPair.ordered(Objects.requireNonNull(this.node), this.successorIterator.next());
        }
    }

    /* loaded from: classes7.dex */
    public static final class Undirected<N> extends EndpointPairIterator<N> {
        @CheckForNull
        private Set<N> visitedNodes;

        private Undirected(BaseGraph<N> baseGraph) {
            super(baseGraph);
            this.visitedNodes = Sets.newHashSetWithExpectedSize(baseGraph.nodes().size() + 1);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public final EndpointPair<N> computeNext() {
            do {
                Objects.requireNonNull(this.visitedNodes);
                while (this.successorIterator.hasNext()) {
                    N next = this.successorIterator.next();
                    if (!this.visitedNodes.contains(next)) {
                        return EndpointPair.unordered(Objects.requireNonNull(this.node), next);
                    }
                }
                this.visitedNodes.add(this.node);
            } while (advance());
            this.visitedNodes = null;
            return endOfData();
        }
    }
}
