package animals.model;

import java.util.Objects;

public class TreeStats {

    private final String root;
    private final int nodes;
    private int animals;
    private final int statements;
    private final int height;
    private final int minDepth;
    private final double avgDepth;

    public TreeStats(String root, int nodes, int animals, int statements, int height, int minDepth, double avgDepth) {
        this.root = root;
        this.nodes = nodes;
        this.animals = animals;
        this.statements = statements;
        this.height = height;
        this.minDepth = minDepth;
        this.avgDepth = avgDepth;
    }

    public String getRoot() {
        return root;
    }

    public int getNodes() {
        return nodes;
    }

    public int getAnimals() {
        return animals;
    }

    public void setAnimals(int animals) {
        this.animals = animals;
    }

    public int getStatements() {
        return statements;
    }

    public int getHeight() {
        return height;
    }

    public int getMinDepth() {
        return minDepth;
    }

    public double getAvgDepth() {
        return avgDepth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeStats)) return false;
        TreeStats treeStats = (TreeStats) o;
        return getNodes() == treeStats.getNodes() && getAnimals() == treeStats.getAnimals() &&
                getStatements() == treeStats.getStatements() && getHeight() == treeStats.getHeight() &&
                getMinDepth() == treeStats.getMinDepth() && getAvgDepth() == treeStats.getAvgDepth() &&
                Objects.equals(getRoot(), treeStats.getRoot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoot(), getNodes(), getAnimals(), getStatements(), getHeight(), getMinDepth(), getAvgDepth());
    }

    @Override
    public String toString() {
        return "TreeStats{" +
                "root='" + root + '\'' +
                ", nodes=" + nodes +
                ", animals=" + animals +
                ", statements=" + statements +
                ", height=" + height +
                ", minDepth=" + minDepth +
                ", avgDepth=" + avgDepth +
                '}';
    }

    public static class TreeStatsBuilder {
        private String root;
        private int nodes;
        private int animals;
        private int statements;
        private int height;
        private int minDepth;
        private double avgDepth;

        private TreeStatsBuilder() {
        }

        public TreeStatsBuilder withRoot(String root) {
            this.root = root;
            return this;
        }

        public TreeStatsBuilder withNodes(int nodes) {
            this.nodes = nodes;
            return this;
        }

        public TreeStatsBuilder withAnimals(int animals) {
            this.animals = animals;
            return this;
        }

        public TreeStatsBuilder withStatements(int statements) {
            this.statements = statements;
            return this;
        }

        public TreeStatsBuilder withHeight(int height) {
            this.height = height;
            return this;
        }

        public TreeStatsBuilder withMinDepth(int minDepth) {
            this.minDepth = minDepth;
            return this;
        }

        public TreeStatsBuilder withAvgDepth(double avgDepth) {
            this.avgDepth = avgDepth;
            return this;
        }

        public static TreeStatsBuilder init() {
            return new TreeStats.TreeStatsBuilder();
        }

        public TreeStats build() {
            return new TreeStats(root, nodes, animals, statements, height, minDepth, avgDepth);
        }
    }
}
