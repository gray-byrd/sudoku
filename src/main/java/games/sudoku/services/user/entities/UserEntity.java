package games.sudoku.services.user.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class UserEntity implements Serializable{

    private static final long serialVersionUID = -4316029655615513180L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @Column(unique = true)
    private String email;

    private String password;

}