package model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Villain implements Serializable {
    private String name;
    private String url;

    @Override
    public String toString(){
        return getName();
    }
}