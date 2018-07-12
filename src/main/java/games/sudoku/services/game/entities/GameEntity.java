package games.sudoku.services.game.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class GameEntity implements Serializable {

    private static final long serialVersionUID = 1264566318791165530L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @Lob
    private String gameBoard;

    @Lob
    private String solvBoard;

}
