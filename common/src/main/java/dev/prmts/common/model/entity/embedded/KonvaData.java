package dev.prmts.common.model.entity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class KonvaData {
    @Column(name = "konva_x")
    private Double x;
    @Column(name = "konva_y")
    private Double y;
    @Column(name = "konva_width")
    private Double width;
    @Column(name = "konva_height")
    private Double height;

}
