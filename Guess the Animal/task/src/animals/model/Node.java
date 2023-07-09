package animals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Node {

    private String value;
    private Node left;
    private Node right;

    public Node(String value) {
        this.value = value;
        right = null;
        left = null;
    }

    @JsonIgnore
    public boolean isLeaf() {
        return left == null && right == null;
    }
}
