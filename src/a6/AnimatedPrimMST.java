package a6;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.introcs.*;

/**
 *  The <tt>PrimMST</tt> class represents a data type for computing a
 *  <em>minimum spanning tree</em> in an edge-weighted graph.
 *  The edge weights can be positive, zero, or negative and need not
 *  be distinct. If the graph is not connected, it computes a <em>minimum
 *  spanning forest</em>, which is the union of minimum spanning trees
 *  in each connected component. The <tt>weight()</tt> method returns the 
 *  weight of a minimum spanning tree and the <tt>edges()</tt> method
 *  returns its edges.
 *  <p>
 *  This implementation uses <em>Prim's algorithm</em> with an indexed
 *  binary heap.
 *  The constructor takes time proportional to <em>E</em> log <em>V</em>
 *  and extra space (not including the graph) proportional to <em>V</em>,
 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 *  Afterwards, the <tt>weight()</tt> method takes constant time
 *  and the <tt>edges()</tt> method takes time proportional to <em>V</em>.
 *  <p>
 *  For additional documentation, see <a href="/algs4/44sp">Section 4.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For alternate implementations, see {@link LazyPrimMST}, {@link KruskalMST},
 *  and {@link BoruvkaMST}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class AnimatedPrimMST {
    private Edge[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo;      // distTo[v] = weight of shortest such edge
    private boolean[] marked;     // marked[v] = true if v on tree, false otherwise
    private IndexMinPQ<Double> pq;
    private double[][] coords;

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public AnimatedPrimMST(EdgeWeightedGraph G, double[][] coords) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        this.coords = coords;
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;

        for (int v = 0; v < G.V(); v++)      // run from each vertex to find
            if (!marked[v]) prim(G, v);      // minimum spanning forest

        // check optimality conditions
        assert check(G);
    }

    // run Prim's algorithm in graph G, starting from vertex s
    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }
    //int previous_v = -1;
    // scan vertex v
    private void scan(EdgeWeightedGraph G, int v) {
    	StdDraw.setPenRadius();
    	
        marked[v] = true;
        int w = 0;
        for (Edge e : G.adj(v)) {
            w = e.other(v);
            if (marked[w]) continue;         // v-w is obsolete edge
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(x(w), y(w), x(v), y(v));
            StdDraw.setPenColor();
            StdDraw.filledCircle(x(w), y(w), .01);
            StdDraw.filledCircle(x(v), y(v), .01);
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
        Edge j = edgeTo[v];
        if (j != null) {
        	StdDraw.setPenColor(StdDraw.RED);
        	StdDraw.setPenRadius(.01);
        	w = j.other(v);
        	StdDraw.line(x(v), y(v), x(w), y(w));
        	StdDraw.setPenColor();
            StdDraw.filledCircle(x(w), y(w), .01);
            StdDraw.filledCircle(x(v), y(v), .01);
        }
        StdDraw.show(500);
        if (j != null) {
        	StdDraw.setPenColor(StdDraw.BLACK);
        	StdDraw.setPenRadius(.011);
        	StdDraw.line(x(v), y(v), x(j.other(v)), y(j.other(v)));
        }
        
        StdDraw.setPenRadius(.0025);
        for (Edge e : G.adj(v)) {
            w = e.other(v);
            if (marked[w]) continue;         // v-w is obsolete edge
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.line(x(w), y(w), x(v), y(v));
            StdDraw.setPenColor();
            StdDraw.filledCircle(x(w), y(w), .01);
            StdDraw.filledCircle(x(v), y(v), .01);
        }
        StdDraw.setPenColor();
        StdDraw.setPenRadius();
    	//if (previous_v >= 0) StdDraw.line(x(v), y(v), x(previous_v), y(previous_v));
        //previous_v = v;
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }


    // check optimality conditions (takes time proportional to E V lg* V)
    private boolean check(EdgeWeightedGraph G) {

        // check weight
        double totalWeight = 0.0;
        for (Edge e : edges()) {
            totalWeight += e.weight();
        }
        double EPSILON = 1E-12;
        if (Math.abs(totalWeight - weight()) > EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
            return false;
        }

        // check that it is acyclic
        UF uf = new UF(G.V());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new UF(G.V());
            for (Edge f : edges()) {
                int x = f.either(), y = f.other(x);
                if (f != e) uf.union(x, y);
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }

    //Convenience methods for coordinate access
    private double x(int i) {
    	return coords[i][0];
    }
    
    private double y(int i) {
    	return coords[i][1];
    }

}