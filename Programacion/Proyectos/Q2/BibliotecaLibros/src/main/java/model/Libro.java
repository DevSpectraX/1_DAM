
package model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.Arrays;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Libro implements Serializable {
    private long id;
    @SerializedName("Year")
    private long year;
    @SerializedName("Title")
    private String title;
    private String handle;
    @SerializedName("Publisher")
    private String publisher;
    @SerializedName("ISBN")
    private String isbn;
    @SerializedName("Pages")
    private long pages;
    @SerializedName("Notes")
    private String[] notes;
    private Villain[] villains;


    @Override
    public String toString() {
        return String.format("Id: %s\nTitle: %s\nYear: %s\nPublisher: %s\nISBN: %s\nPages: %s\nNotes: %s\nVillains: %s",
                getId(),
                getTitle(),
                getYear(),
                getPublisher(),
                getIsbn(),
                getPages(),
                Arrays.toString(getNotes()),
                Arrays.toString(getVillains()));
    }
}