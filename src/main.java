import entitites.Airport;

public class main {

    public static void main(String[] args) {

        MyGraph mg = new MyGraph();
        Airport airport = mg.findAirport("MAG");


        //DFS testing
        /*
        DepthFirst testdfs = new DepthFirst();
        testdfs.dfs(airport, "CG");
        System.out.println(testdfs.checkMarked("CQQ"));
        testdfs.printAllMarked();
        */


        //BFS testing

        BreadthFirst testbfs = new BreadthFirst();
        testbfs.bfs(airport,"CG");
        testbfs.printAllMarked();

    }
}
