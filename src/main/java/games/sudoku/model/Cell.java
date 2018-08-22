package games.sudoku.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;

@Data
public class Cell {
    private String value;
    private ArrayList<String> notes;

    Cell (String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cell cell = (Cell) o;
        return Objects.equals(getValue(), cell.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValue());
    }
}
