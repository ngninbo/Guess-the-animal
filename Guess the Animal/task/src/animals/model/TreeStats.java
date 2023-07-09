package animals.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TreeStats {

    private final String root;
    private final int nodes;
    private int animals;
    private final int statements;
    private final int height;
    private final int minDepth;
    private final double avgDepth;
}
