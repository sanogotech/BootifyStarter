package io.bootify.my_app.model;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


public class CartPartDTO {

    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime releaseDate;

    @NotNull
    @Size(max = 255)
    private String typeCode;

    @NotNull
    private Long supplier;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public OffsetDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final OffsetDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(final String typeCode) {
        this.typeCode = typeCode;
    }

    public Long getSupplier() {
        return supplier;
    }

    public void setSupplier(final Long supplier) {
        this.supplier = supplier;
    }

}
